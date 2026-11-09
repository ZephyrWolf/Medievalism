package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.item.DryingBlockItem;
import io.github.zephyrwolf.medievalism.common.item.DryingBrickBlockItem;
import io.github.zephyrwolf.medievalism.common.item.*;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class MudWorkingItemRegistration
{
    public static final DeferredRegister.Items MUD_WORKING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        MUD_WORKING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return MUD_WORKING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == MUD WORKING ==
    // PACKED MUD
    public static final DeferredItem<DirtChunkItem> DIRT_CHUNK = MUD_WORKING_ITEMS.registerItem("dirt_chunk", DirtChunkItem::new);
    public static final DeferredItem<Item> MUD_BALL = MUD_WORKING_ITEMS.registerSimpleItem("mud_ball", new Item.Properties());
    public static final DeferredItem<Item> PACKED_MUD_BRICK = MUD_WORKING_ITEMS.registerSimpleItem("packed_mud_brick", new Item.Properties());
    public static final DeferredItem<DryingBlockItem> DRYING_PACKED_MUD = MUD_WORKING_ITEMS.registerItem("drying_packed_mud", props -> new DryingBlockItem(BlockRegistration.DRYING_PACKED_MUD, props, false));
    public static final DeferredItem<DryingBrickBlockItem> DRYING_PACKED_MUD_BRICK =   MUD_WORKING_ITEMS.registerItem("drying_packed_mud_brick", props -> new DryingBrickBlockItem(BlockRegistration.DRYING_PACKED_MUD_BRICK, props,false));
    // DAUB
    public static final DeferredItem<Item> WET_DAUB = MUD_WORKING_ITEMS.registerSimpleItem("wet_daub", new Item.Properties());
    public static final DeferredItem<Item> DAUB_BRICK = MUD_WORKING_ITEMS.registerSimpleItem("daub_brick", new Item.Properties());
    public static final DeferredItem<DryingBrickBlockItem> DRYING_DAUB_BRICK = MUD_WORKING_ITEMS.registerItem("drying_daub_brick", props -> new DryingBrickBlockItem(BlockRegistration.DRYING_DAUB_BRICK, props, false));
    public static final DeferredItem<DryingBlockItem> DRYING_DAUB_BLOCK = MUD_WORKING_ITEMS.registerItem("drying_daub_block", props -> new DryingBlockItem(BlockRegistration.DRYING_DAUB_BLOCK, props, false));
    public static final DeferredItem<BlockItem> DAUB_BLOCK = MUD_WORKING_ITEMS.registerSimpleBlockItem("daub_block",                    BlockRegistration.DAUB_BLOCK);
    public static final DeferredItem<BlockItem> DAUB_BRICKS = MUD_WORKING_ITEMS.registerSimpleBlockItem("daub_bricks",                   BlockRegistration.DAUB_BRICKS);
    public static final DeferredItem<BlockItem> CRACKED_DAUB_BLOCK = MUD_WORKING_ITEMS.registerSimpleBlockItem("cracked_daub_block",            BlockRegistration.CRACKED_DAUB_BLOCK);
    public static final DeferredItem<BlockItem> CRACKED_DAUB_BRICKS = MUD_WORKING_ITEMS.registerSimpleBlockItem("cracked_daub_bricks",           BlockRegistration.CRACKED_DAUB_BRICKS);
    //endregion == MUD WORKING ==
}
