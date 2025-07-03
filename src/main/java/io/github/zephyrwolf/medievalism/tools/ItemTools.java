package io.github.zephyrwolf.medievalism.tools;

import io.github.zephyrwolf.medievalism.common.block.TwigsBlock;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public final class ItemTools
{
    //region Damage
    public static int damageStack(ServerLevel level, ItemStack tool, int amt) {
        if (tool.isDamageableItem()) {
            amt = tool.getItem().damageItem(tool, amt, null, item -> {});
            if (amt > 0) {
                amt = EnchantmentHelper.processDurabilityChange(level, tool, amt);
            }
            if (amt <= 0) {
                return 0;
            }
            int damage = tool.getDamageValue() + amt;
            tool.setDamageValue(damage);
            if (damage >= tool.getMaxDamage()) {
                tool.shrink(1);
            }
            return amt;
        }
        else
        {
            return 0;
        }
    }

    public static int damageOrShrinkStack(ServerLevel level, ItemStack tool, int amt) {
        if (damageStack(level, tool, amt) == 0)
        {
            amt = Math.min(tool.getCount(), amt);
            tool.shrink(amt);
        }
        return amt;
    }
    //endregion

    //region BlockItem
    public static boolean placeBlockAsIfBlockItem(Level level, BlockPos hitPos, Direction hitSide, Player player, ItemStack heldStack)
    { // This is taken from BlockItem
        BlockPos placementPos = hitPos;
        if (!level.getBlockState(placementPos).canBeReplaced())
        {
            placementPos = placementPos.relative(hitSide);
        }

        BlockState placementState = BlockRegistration.TWIGS.get().defaultBlockState()
                .setValue(TwigsBlock.NUM_STICKS, 1);
        if (!level.setBlock(placementPos, placementState, 11))
        {
            return false;
        }
        else {
            BlockState placedState = level.getBlockState(placementPos);
            if (placedState.is(placementState.getBlock()))
            { // Was the placement successful?
                BlockItemStateProperties blockitemstateproperties = heldStack.getOrDefault(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY);
                if (!blockitemstateproperties.isEmpty())
                {
                    BlockState blockstate = blockitemstateproperties.apply(placedState);
                    if (blockstate != placedState) {
                        level.setBlock(placementPos, blockstate, 2);
                    }
                    placedState = blockstate;
                }
                BlockItem.updateCustomBlockEntityTag(level, player, placementPos, heldStack);
                BlockEntity blockentity = level.getBlockEntity(placementPos);
                if (blockentity != null) {
                    blockentity.applyComponentsFromItemStack(heldStack);
                    blockentity.setChanged();
                }
                placedState.getBlock().setPlacedBy(level, placementPos, placedState, player, heldStack);
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, placementPos, heldStack);
                }
            }

            SoundType soundtype = placedState.getSoundType(level, placementPos, player);
            level.playSound(
                    player,
                    placementPos,
                    placedState.getSoundType(level, placementPos, player).getPlaceSound(),
                    SoundSource.BLOCKS,
                    (soundtype.getVolume() + 1.0F) / 2.0F,
                    soundtype.getPitch() * 0.8F
            );
            level.gameEvent(GameEvent.BLOCK_PLACE, placementPos, GameEvent.Context.of(player, placedState));
            heldStack.consume(1, player);
            return true;
        }
    }
    //endregion
}
