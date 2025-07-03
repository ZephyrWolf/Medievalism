package io.github.zephyrwolf.medievalism.content.entity;

import io.github.zephyrwolf.medievalism.common.block.TwigsBlock;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.tools.ItemTools;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class EntityEventRegistration
{
    public static void register()
    {
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, EntityEventRegistration::onRightClickBlock);
    }

    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        if (event.isCanceled()) return;
        if (!event.getItemStack().isEmpty() && event.getItemStack().getItem() == Items.STICK)
        {
            Level level = event.getLevel();
            BlockPos hitPos = event.getHitVec().getBlockPos();
            BlockState hitState = level.getBlockState(hitPos);
            Player player = event.getEntity();
            if (hitState.getBlock() != BlockRegistration.TWIGS.get()) {
                if (ItemTools.placeBlockAsIfBlockItem(event.getLevel(), event.getHitVec().getBlockPos(), event.getHitVec().getDirection(), event.getEntity(), event.getItemStack())) {
                    event.setCancellationResult(InteractionResult.CONSUME_PARTIAL);
                }
            } else {
                int numSticks = hitState.getValue(TwigsBlock.NUM_STICKS);
                if (numSticks < TwigsBlock.MAX_STICKS)
                {
                    BlockState newState = hitState.setValue(TwigsBlock.NUM_STICKS, numSticks + 1);
                    level.setBlockAndUpdate(hitPos, newState);
                    // Below taken from ItemTools.placeBlockAsIfBlockItem
                    newState.getBlock().setPlacedBy(level, hitPos, newState, player, event.getItemStack());
                    if (player instanceof ServerPlayer) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, hitPos, event.getItemStack());
                    }
                    SoundType soundtype = hitState.getSoundType(level, hitPos, player);
                    level.playSound(
                            player,
                            hitPos,
                            newState.getSoundType(level, hitPos, player).getPlaceSound(),
                            SoundSource.BLOCKS,
                            (soundtype.getVolume() + 1.0F) / 2.0F,
                            soundtype.getPitch() * 0.8F
                    );
                    level.gameEvent(GameEvent.BLOCK_PLACE, hitPos, GameEvent.Context.of(player, hitState));
                    event.getItemStack().consume(1, event.getEntity());
                    event.setCancellationResult(InteractionResult.CONSUME_PARTIAL);
                }
            }
        }
        event.setCancellationResult(InteractionResult.PASS); // Let another mod do something
    }
}
