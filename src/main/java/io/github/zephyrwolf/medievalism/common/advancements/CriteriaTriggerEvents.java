package io.github.zephyrwolf.medievalism.common.advancements;

import io.github.zephyrwolf.medievalism.registration.advancements.CriteriaTriggersRegistration;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class CriteriaTriggerEvents
{
    public static void registerEventHandlers()
    {
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, CriteriaTriggerEvents::onStatCritereonCheck);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, CriteriaTriggerEvents::onBlockBreak);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, CriteriaTriggerEvents::onBlockBreaking);
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

    public static void onBlockBreak(BlockEvent.BreakEvent event)
    {
        if (event.getPlayer() instanceof ServerPlayer)
        {
            CriteriaTriggersRegistration.BLOCK_BREAK.get().trigger(
                    (ServerPlayer) event.getPlayer(),
                    event.getState()
            );
        }
    }

    public static void onBlockBreaking(PlayerInteractEvent.LeftClickBlock event)
    {
        if (event.getEntity() instanceof ServerPlayer)
        {
            CriteriaTriggersRegistration.BLOCK_BREAKING.get().trigger(
                    (ServerPlayer) event.getEntity(),
                    event.getLevel().getBlockState(event.getPos())
            );
        }
    }
}
