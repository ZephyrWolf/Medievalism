package io.github.zephyrwolf.medievalism.registration.client;

import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public final class ClientColoursRegistration
{
    public static void register(IEventBus eventBus)
    {
        eventBus.addListener(ClientColoursRegistration::registerBlockColours);
        eventBus.addListener(ClientColoursRegistration::registerItemColours);
    }

    public static void registerBlockColours(RegisterColorHandlersEvent.Block event)
    {
        registerAverageGrassColour(event, BlockRegistration.SHRUB.get());
        registerAverageGrassColour(event, BlockRegistration.CLAY_IN_GRASS.get());
        registerAverageGrassColour(event, BlockRegistration.RED_CLAY_IN_GRASS.get());
    }

    public static void registerItemColours(RegisterColorHandlersEvent.Item event)
    {
        registerDefaultGrassColour(event, BlockItemRegistration.SHRUB.get());
        registerDefaultGrassColour(event, BlockItemRegistration.CLAY_IN_GRASS.get());
        registerDefaultGrassColour(event, BlockItemRegistration.RED_CLAY_IN_GRASS.get());
    }

    public static void registerAverageGrassColour(RegisterColorHandlersEvent.Block event, Block block)
    {
        event.register(
                (state, world, pos, tintIndex)
                        -> world != null && pos != null
                        ? BiomeColors.getAverageGrassColor(world, pos)
                        : FoliageColor.getDefaultColor(),
                block);
    }

    public static void registerDefaultGrassColour(RegisterColorHandlersEvent.Item event, Item item)
    {
        event.register(
                (stack, tintIndex) -> GrassColor.getDefaultColor(),
                item
        );
    }
}
