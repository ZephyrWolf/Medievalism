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

}
