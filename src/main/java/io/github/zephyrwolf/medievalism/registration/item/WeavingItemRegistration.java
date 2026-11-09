package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class WeavingItemRegistration
{
    public static final DeferredRegister.Items WEAVING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        WEAVING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return WEAVING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == WEAVING ==
    public static final DeferredItem<Item> FLAX_FIBER = WEAVING_ITEMS.registerSimpleItem("flax_fiber", new Item.Properties());
    public static final DeferredItem<Item> SPLIT_SOFT_RUSH = WEAVING_ITEMS.registerSimpleItem("split_soft_rush", new Item.Properties());
    public static final DeferredItem<Item> PRIMITIVE_CORDAGE = WEAVING_ITEMS.registerSimpleItem("primitive_cordage", new Item.Properties());
    public static final DeferredItem<Item> GREEN_BAST_FIBERS = WEAVING_ITEMS.registerSimpleItem("green_bast_fibers", new Item.Properties());
    public static final DeferredItem<Item> DRY_BAST_FIBERS = WEAVING_ITEMS.registerSimpleItem("dry_bast_fibers", new Item.Properties());
    public static final DeferredItem<Item> BAST_CORDAGE = WEAVING_ITEMS.registerSimpleItem("bast_cordage", new Item.Properties());
    //endregion
}
