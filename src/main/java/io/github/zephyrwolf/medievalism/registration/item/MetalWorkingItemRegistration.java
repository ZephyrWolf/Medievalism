package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class MetalWorkingItemRegistration
{
    public static final DeferredRegister.Items METAL_WORKING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        METAL_WORKING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return METAL_WORKING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == METAL WORKING ==
    public static final DeferredItem<Item> RAW_TIN = METAL_WORKING_ITEMS.registerSimpleItem("raw_tin");
    public static final DeferredItem<Item> COPPER_ORE_DUST = METAL_WORKING_ITEMS.registerSimpleItem("copper_ore_dust"); // malachite > azurite
    public static final DeferredItem<Item> TIN_ORE_DUST = METAL_WORKING_ITEMS.registerSimpleItem("tin_ore_dust"); // Cassiterite
    public static final DeferredItem<Item> IRON_ORE_DUST = METAL_WORKING_ITEMS.registerSimpleItem("iron_ore_dust"); // hematite > magnetite
    //endregion
}
