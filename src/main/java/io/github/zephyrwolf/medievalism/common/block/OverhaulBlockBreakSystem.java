package io.github.zephyrwolf.medievalism.common.block;


import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

public class OverhaulBlockBreakSystem
{
    public static void registerEventHandlers()
    {
        NeoForge.EVENT_BUS.addListener(OverhaulBlockBreakSystem::blockDrops);
        NeoForge.EVENT_BUS.addListener(OverhaulBlockBreakSystem::breakSpeed);
    }

    public static void blockDrops(BlockDropsEvent event)
    {
        BlockState state = event.getState();
        Entity entity = event.getBreaker();
        if (entity instanceof Player player)
        {
            if (!player.isCreative() && state.is(BlockTagCatalog.REQUIRES_AXE_FOR_DROPS))
            {
                ItemStack mainHand = player.getMainHandItem();
                if (!mainHand.is(ItemTags.AXES))
                {
                    event.setCanceled(true);
                }
            }
        }
    }

    public static void breakSpeed(PlayerEvent.BreakSpeed event)
    {
        // Tool tool = pStack.get(DataComponents.TOOL);
        // return tool != null ? tool.getMiningSpeed(pState) : 1.0F;
        BlockState state = event.getState();
        Player player = event.getEntity();
        if (!player.isCreative() && state.is(BlockTagCatalog.REQUIRES_AXE_FOR_DROPS))
        {
            ItemStack mainHand = player.getMainHandItem();
            if (!mainHand.is(ItemTags.AXES))
            {
                event.setNewSpeed(0.5f); // instead of override, divide
            }
        }
    }
}
