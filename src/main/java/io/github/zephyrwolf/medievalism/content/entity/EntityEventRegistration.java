package io.github.zephyrwolf.medievalism.content.entity;

import io.github.zephyrwolf.medievalism.content.advancements.CriteriaTriggersRegistration;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.tools.ItemTools;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class EntityEventRegistration
{
    public static void register()
    {
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, EntityEventRegistration::onRightClickBlock);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, EntityEventRegistration::onStatCritereonCheck);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, EntityEventRegistration::onBlockBreakingTrigger);
    }

    public static void onBlockBreakingTrigger(PlayerInteractEvent.LeftClickBlock event)
    {
        if (event.getEntity() instanceof ServerPlayer)
        {
            CriteriaTriggersRegistration.BLOCK_BREAKING.get().trigger(
                    (ServerPlayer) event.getEntity(),
                    event.getLevel().getBlockState(event.getPos())
            );
        }
    }

    public static void onStatCritereonCheck(PlayerTickEvent.Post event)
    {
        final long period = 40;
        if (event.getEntity().level().isClientSide) return;

        ServerPlayer player = (ServerPlayer) event.getEntity();

        long worldTime = player.serverLevel().getGameTime();
        long cycle = worldTime % period;

        if (cycle == 0)
        {
            CriteriaTriggersRegistration.PLAYER_STATS.get().trigger(player);
        }
    }

    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        if (event.isCanceled()) return;
        // TODO This doesnt work properly; interacting with firelay causes issues
        if (false && !event.getItemStack().isEmpty() && event.getItemStack().getItem() == Items.STICK)
        {
            Level level = event.getLevel();
            BlockPos hitPos = event.getHitVec().getBlockPos();
            BlockState hitState = level.getBlockState(hitPos);
            if (hitState.getBlock() != BlockRegistration.TWIGS.get())
            {
                if (ItemTools.placeBlockAsIfBlockItem(event.getLevel(), event.getHitVec().getBlockPos(), event.getHitVec().getDirection(), event.getEntity(), event.getItemStack()))
                {
                    event.setCancellationResult(InteractionResult.CONSUME_PARTIAL);
                }
            }
        }
        event.setCancellationResult(InteractionResult.PASS); // Let another mod do something
    }
}
