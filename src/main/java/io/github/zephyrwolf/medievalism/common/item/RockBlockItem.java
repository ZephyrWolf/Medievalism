package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.registration.particles.ParticleTypeRegistration;
import io.github.zephyrwolf.medievalism.registration.sounds.SoundsRegistration;
import io.github.zephyrwolf.medievalism.tools.ParticleTools;
import net.minecraft.ChatFormatting;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RockBlockItem extends BlockItem
{
    public static final int KNAP_DURATION = 40;

    public RockBlockItem(Block pBlock, Properties pProperties)
    {
        super(pBlock, pProperties);
    }

    @Override
    public void appendHoverText(
            @NotNull ItemStack pStack,
            @NotNull TooltipContext pContext,
            @NotNull List<Component> pTooltipComponents,
            @NotNull TooltipFlag pTooltipFlag)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        if (pStack.is(ItemTagCatalog.HARD_ROCK))
        {
            pTooltipComponents.add(Component.translatable("medievalism.tooltip.hard_rock.can_knap").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public int getUseDuration(
            @NotNull ItemStack pStack,
            @NotNull LivingEntity pEntity)
    {
        return KNAP_DURATION;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack)
    {
        return UseAnim.CUSTOM;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(
            @NotNull Level pLevel,
            Player pPlayer,
            @NotNull InteractionHand pHand)
    {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        InteractionHand oHand = pHand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack oItemStack = pPlayer.getItemInHand(oHand);

        if (!oItemStack.is(this) || oItemStack.isDamaged()) { return InteractionResultHolder.fail(itemStack); }

        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void onUseTick(
            @NotNull Level pLevel,
            @NotNull LivingEntity pLivingEntity,
            @NotNull ItemStack pStack,
            int pRemainingUseDuration)
    {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
        RandomSource rand = pLevel.getRandom();
        if (pRemainingUseDuration % 10 == 2)
        {
            pLevel.playSound(
                    pLivingEntity,
                    pLivingEntity.getOnPos(),
                    pRemainingUseDuration == 2
                            ? SoundsRegistration.KNAP_FINAL_HIT.value()
                            : SoundsRegistration.KNAP_HIT.value(),
                    SoundSource.PLAYERS,
                    0.9f + 0.2f * rand.nextFloat(),
                    0.9f + 0.2f * rand.nextFloat());
            if (FMLEnvironment.dist == Dist.CLIENT
                    && pLevel.isClientSide()
                    && pLivingEntity instanceof Player player
                    && player == Minecraft.getInstance().player)
            {
                ClientLevel clientLevel = (ClientLevel) pLevel;
                float yaw;
                if (Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON)
                {
                    // Spawns from head pos 1st person
                    yaw = pLivingEntity.yHeadRot * ((float)Math.PI / 180F);
                }
                else
                {
                    // Spawns from body pos 3rd person
                    yaw = pLivingEntity.yBodyRot * ((float)Math.PI / 180F);
                }
                ParticleTools.addParticleClient(
                        clientLevel,
                        player,
                        ParticleTypeRegistration.KNAP_DEBRIS.get(),
                        pLivingEntity.getX() - Mth.sin(yaw) * 0.6f,
                        pLivingEntity.getY() + 1.3,
                        pLivingEntity.getZ() + Mth.cos(yaw) * 0.6F,
                        rand.nextDouble() - 0.4 - Mth.sin(yaw) * 0.1f,
                        rand.nextDouble(),
                        rand.nextDouble() - 0.4 + Mth.cos(yaw) * 0.1F
                );
            }
            else if (FMLEnvironment.dist == Dist.DEDICATED_SERVER
                    && !pLevel.isClientSide()
                    && pLivingEntity instanceof Player player)
            {
                ServerLevel serverLevel = (ServerLevel) pLevel;
                float yaw = pLivingEntity.yBodyRot * ((float)Math.PI / 180F);
                ParticleTools.sendParticlesServer(
                        serverLevel,
                        player,
                        ParticleTypeRegistration.KNAP_DEBRIS.get(),
                        pLivingEntity.getX() - Mth.sin(yaw) * 0.6f,
                        pLivingEntity.getY() + 1.3,
                        pLivingEntity.getZ() + Mth.cos(yaw) * 0.6F,
                        0,
                        rand.nextDouble() - 0.4 - Mth.sin(yaw) * 0.1f,
                        rand.nextDouble(),
                        rand.nextDouble() - 0.4 + Mth.cos(yaw) * 0.1F,
                        0.0
                );
            }
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(
            @NotNull ItemStack pStack,
            @NotNull Level pLevel,
            @NotNull LivingEntity pLivingEntity)
    {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player)
        {
            player.getCooldowns().addCooldown(this, 10);
        }
        return pStack;
    }
}
