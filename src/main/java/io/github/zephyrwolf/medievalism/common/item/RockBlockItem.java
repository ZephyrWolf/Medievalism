package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.common.components.DummyDataComponent;
import io.github.zephyrwolf.medievalism.registration.components.DataComponentTypeRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.registration.particles.ParticleTypeRegistration;
import io.github.zephyrwolf.medievalism.registration.sounds.SoundsRegistration;
import io.github.zephyrwolf.medievalism.tools.ParticleTools;
import io.github.zephyrwolf.medievalism.tools.PlayerInventoryTools;
import net.minecraft.ChatFormatting;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RockBlockItem extends BlockItem
{
    //region Constants
    private static final int TICKS_PER_SECOND = 20;
    private static final int KNAP_DURATION_TICKS = 50;
    private static final int KNAP_PREPARE_DURATION_TICKS = 10;
    private static final int KNAP_FAIL_DURATION_TICKS = 10;
    public static final int HITS = 5;
    private static final float PERIOD = KNAP_DURATION_TICKS / (float) (HITS * TICKS_PER_SECOND); // Sec
    private static final int TIMING_TUNE = (int) (PERIOD * TICKS_PER_SECOND / 2f);
    //endregion

    public RockBlockItem(Block pBlock, Properties pProperties)
    {
        super(pBlock, pProperties);
    }

    //region Item
    //region - BlockItem
    @Override
    protected boolean canPlace(BlockPlaceContext pContext, @NotNull BlockState pState)
    {
        if (isHammerstone(pContext.getItemInHand())) return false;
        return super.canPlace(pContext, pState);
    }
    //endregion

    //region - Item
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
    public @NotNull String getDescriptionId(@NotNull ItemStack pStack)
    {
        return isHammerstone(pStack)
                ? super.getDescriptionId(pStack) + ".hammerstone"
                : super.getDescriptionId(pStack);
    }

    @Override
    public int getMaxStackSize(@NotNull ItemStack stack)
    {
        return isHammerstone(stack) ? 1 : 64;
    }
    //endregion

    //region - Animation
    @Override
    public int getUseDuration(
            @NotNull ItemStack pStack,
            @NotNull LivingEntity pEntity)
    { // pEntity.getUsedItemHand() and pEntity.swingingArm are not set yet
        InteractionHand hand = handFromStack(pEntity, pStack);
        return hand != null ? getKnapAction(pEntity, hand).duration : -1;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack)
    {
        return UseAnim.CUSTOM;
    }
    //endregion
    //endregion

    //region Interaction
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(
            @NotNull Level pLevel,
            Player pPlayer,
            @NotNull InteractionHand pHand)
    {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (pHand == InteractionHand.OFF_HAND) return InteractionResultHolder.pass(itemStack);

        KnapAction action = getKnapAction(pPlayer, pHand);
        if (action == KnapAction.NO_ACTION && pLevel.isClientSide())
        {
            pLevel.playSound( // Play error sound; client only
                    pPlayer,
                    pPlayer.getOnPos(),
                    SoundsRegistration.INHAND_KNAP_FAIL.value(),
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f);
        }
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void onUseTick(
            @NotNull Level pLevel,
            @NotNull LivingEntity pLivingEntity,
            @NotNull ItemStack pStack,
            int pRemainingUseDuration)
    {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
        KnapAction action = getKnapAction(pLivingEntity, pLivingEntity.getUsedItemHand());
        if (action != KnapAction.CAN_KNAP) return;
        if (pRemainingUseDuration % (KNAP_DURATION_TICKS / HITS) == TIMING_TUNE)
        {
            RandomSource rand = pLevel.getRandom();
            boolean finalHit = pRemainingUseDuration == TIMING_TUNE;
            SoundEvent sndEvent = finalHit
                    ? SoundsRegistration.INHAND_KNAP_FINAL_HIT.value()
                    : SoundsRegistration.INAHND_KNAP_HIT.value();
            int numParticles = finalHit ? (3 + rand.nextInt(4)) : (1 + rand.nextInt(2));
            pLevel.playSound( // Play hit sound
                    pLivingEntity,
                    pLivingEntity.getOnPos(),
                    sndEvent,
                    SoundSource.PLAYERS,
                    0.9f + 0.2f * rand.nextFloat(),
                    0.9f + 0.2f * rand.nextFloat());
            for (int n = 0; n < numParticles; n++) {
                if (FMLEnvironment.dist == Dist.CLIENT // Spawn particle for client
                        && pLevel.isClientSide()
                        && pLivingEntity instanceof Player player
                        && player == Minecraft.getInstance().player) {
                    ClientLevel clientLevel = (ClientLevel) pLevel;
                    float rot = Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON
                            ? pLivingEntity.yHeadRot
                            : pLivingEntity.yBodyRot;
                    float yaw = rot * ((float) Math.PI / 180f);
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
                } else if (FMLEnvironment.dist == Dist.DEDICATED_SERVER // Spawn particle for server
                        && !pLevel.isClientSide()
                        && pLivingEntity instanceof Player player) {
                    ServerLevel serverLevel = (ServerLevel) pLevel;
                    float yaw = pLivingEntity.yBodyRot * ((float) Math.PI / 180F);
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
    }

    @Override
    public @NotNull ItemStack finishUsingItem(
            @NotNull ItemStack pStack,
            @NotNull Level pLevel,
            @NotNull LivingEntity pLivingEntity)
    {
        InteractionHand hand = pLivingEntity.getUsedItemHand();
        InteractionHand oHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack itemStack = pLivingEntity.getItemInHand(hand);
        ItemStack oItemStack = pLivingEntity.getItemInHand(oHand);

        KnapAction action = getKnapAction(pLivingEntity, hand);
        if (action == KnapAction.UNSTACK_INTO_EMPTY_OFF_HAND)
        {
            oItemStack = itemStack.copy();
            oItemStack.shrink(1);
            pLivingEntity.setItemInHand(oHand, oItemStack);

            itemStack.setCount(1);
            return itemStack;
        }
        else if (action == KnapAction.UNSTACK_INTO_EMPTY_MAIN_HAND)
        {
            oItemStack = itemStack.copy();
            oItemStack.setCount(1);
            pLivingEntity.setItemInHand(oHand, oItemStack);

            //itemStack = itemStack.copy();
            itemStack.shrink(1);
            return itemStack;
        }
        else if (action == KnapAction.UNSTACK_MAIN_HAND_INTO_INV && pLivingEntity instanceof Player player)
        {
            ItemStack invStack = itemStack.copy();
            invStack.shrink(1);

            itemStack.set(DataComponentTypeRegistration.DUMMY, DummyDataComponent.INSTANCE);
            int rem = PlayerInventoryTools.addStackToPlayerInventory(player, invStack, true, false, true);
            itemStack.remove(DataComponentTypeRegistration.DUMMY);
            if (rem == 0)
            {
                PlayerInventoryTools.addStackToPlayerInventory(player, invStack, true, false, false);
                itemStack.setCount(1);
            }
        }
        else if (action == KnapAction.SWAP_HANDS)
        {
            ItemStack swap = itemStack.copy();
            pLivingEntity.setItemInHand(hand, oItemStack);
            pLivingEntity.setItemInHand(oHand, swap);
            return oItemStack;
        }
        else if (action == KnapAction.CAN_KNAP)
        {
            // Serverside
            if (!pLevel.isClientSide() && pLivingEntity instanceof Player player)
            {
                // We check so that if we are using an item, and we shouldn't, we aren't acting on items that we shouldn't
                // e.g. What if another mod modifies the players inventory?
                if (itemStack.getItem() instanceof RockBlockItem // TODO is hammerstone
                        && oItemStack.getItem() instanceof RockBlockItem) // TODO is recipe ingredient
                {
                    if (!player.isCreative()) {
                        pStack.setDamageValue(pStack.getDamageValue() + 1);
                        if (pStack.getDamageValue() >= pStack.getMaxDamage())
                        {
                            pStack = ItemStack.EMPTY;
                        }
                        oItemStack.shrink(1);
                    }
                }
            }
        }

        if (!pLevel.isClientSide && pLivingEntity instanceof Player player)
        {
            player.getCooldowns().addCooldown(this, 5);
        }

        return pStack;
    }
    //endregion

    //region Static In-hand Knapping
    /*
    Filter on item type to items that can hammer
     */
    private static boolean couldHammer(@NotNull ItemStack stack)
    {
        return stack.getItem() instanceof RockBlockItem;
    }

    /*
    Is this stack ready to hammer; i.e. is a hammer type and stack is only one
     */
    private static boolean canHammer(@NotNull ItemStack stack)
    {
        return stack.getCount() == 1 && stack.getItem() instanceof RockBlockItem;
    }

    /*
    If this stack is a hammer type and has been damaged (no longer a rock)
     */
    private static boolean isHammerstone(@NotNull ItemStack stack)
    {
        return stack.getCount() == 1 && stack.getItem() instanceof RockBlockItem && stack.isDamaged();
    }

    private static boolean isKnappableStone(ItemStack stack)
    {
        return !stack.isEmpty() && !stack.isDamaged() &&
                stack.getItem() instanceof RockBlockItem && stack.is(ItemTagCatalog.HARD_ROCK); // TODO tie this into the recipe system
    }

    /*
    Obtains the hand holding ItemStack.
    Some method pass an ItemStack before player.useItem is updated.
     */
    private static @Nullable InteractionHand handFromStack(@NotNull LivingEntity pEntity, @NotNull ItemStack pStack)
    {
        if (pStack == pEntity.getItemInHand(InteractionHand.OFF_HAND))
            return InteractionHand.OFF_HAND;
        else if (pStack == pEntity.getItemInHand(InteractionHand.MAIN_HAND))
            return InteractionHand.MAIN_HAND;
        else
            return null;
    }

    public enum KnapAction
    {
        NO_ACTION(KNAP_FAIL_DURATION_TICKS),
        UNSTACK_INTO_EMPTY_OFF_HAND(KNAP_PREPARE_DURATION_TICKS),
        UNSTACK_INTO_EMPTY_MAIN_HAND(KNAP_PREPARE_DURATION_TICKS),
        UNSTACK_MAIN_HAND_INTO_INV(KNAP_PREPARE_DURATION_TICKS),
        SWAP_HANDS(KNAP_PREPARE_DURATION_TICKS),
        CAN_KNAP(KNAP_DURATION_TICKS);

        public final int duration;

        KnapAction(int useDuration) { duration = useDuration; }
    }

    public static KnapAction getKnapAction(@NotNull LivingEntity pEntity, @NotNull InteractionHand hand)
    {
        ItemStack mItemStack = pEntity.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack oItemStack = pEntity.getItemInHand(InteractionHand.OFF_HAND);
        if (isKnappableStone(oItemStack) && couldHammer(mItemStack) && mItemStack.getCount() > 1 && pEntity instanceof Player player)
        {
            ItemStack insertStack = mItemStack.copy();
            mItemStack.set(DataComponentTypeRegistration.DUMMY, DummyDataComponent.INSTANCE);
            int rem = PlayerInventoryTools.addStackToPlayerInventory(player, insertStack, true, false, true);
            mItemStack.remove(DataComponentTypeRegistration.DUMMY);
            if (rem == 0)
            {
                return KnapAction.UNSTACK_MAIN_HAND_INTO_INV;
            }
        }
        else if (oItemStack.isEmpty() && isKnappableStone(mItemStack) && couldHammer(mItemStack) && mItemStack.getCount() > 1)
        {
            return KnapAction.UNSTACK_INTO_EMPTY_OFF_HAND;
        }
        else if (mItemStack.isEmpty() && isKnappableStone(oItemStack) && couldHammer(oItemStack) && oItemStack.getCount() > 1)
        {

            return KnapAction.UNSTACK_INTO_EMPTY_MAIN_HAND;
        }
        else if (isHammerstone(oItemStack) && isKnappableStone(mItemStack) && !isHammerstone(mItemStack))
        {
            return KnapAction.SWAP_HANDS;
        }
        else if (hand == InteractionHand.MAIN_HAND && canHammer(mItemStack) && isKnappableStone(oItemStack))
        {
            return KnapAction.CAN_KNAP;
        }
        return KnapAction.NO_ACTION;
    }
    //endregion
}
