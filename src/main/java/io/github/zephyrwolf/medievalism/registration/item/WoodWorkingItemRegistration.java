package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.item.*;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class WoodWorkingItemRegistration
{
    public static final DeferredRegister.Items WOOD_WORKING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        WOOD_WORKING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return WOOD_WORKING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == WOOD WORKING ==
    public static final DeferredItem<Item> CHOPPED_WOOD = WOOD_WORKING_ITEMS.registerSimpleItem("chopped_wood", new Item.Properties());
    public static final DeferredItem<Item> TANNIN_BUCKET = WOOD_WORKING_ITEMS.registerSimpleItem("tannin_bucket", new Item.Properties());
    public static final DeferredItem<Item> WOOD_ASH = WOOD_WORKING_ITEMS.registerSimpleItem("wood_ash"); // Order of concentraiton Potash(Potassiam Carbonate), CaCO3, CaO, MgCO3, Posphates and Silicates
    public static final DeferredItem<BlockItem> CHOPPING_BLOCK = WOOD_WORKING_ITEMS.registerSimpleBlockItem("chopping_block",                BlockRegistration.CHOPPING_BLOCK);

    public static final DeferredItem<Item> DIGGING_STICK = WOOD_WORKING_ITEMS.registerSimpleItem("digging_stick", new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> FIRE_STARTER = WOOD_WORKING_ITEMS.registerItem("fire_starter", FireStarterItem::new, new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> WHITE_BARK = WOOD_WORKING_ITEMS.registerSimpleItem("white_bark"); // Birch, mangrove
    public static final DeferredItem<Item> BROWN_BARK = WOOD_WORKING_ITEMS.registerSimpleItem("brown_bark"); //cherry, spruce, jungle
    public static final DeferredItem<Item> GREY_BARK = WOOD_WORKING_ITEMS.registerSimpleItem("grey_bark"); // Acacia
    public static final DeferredItem<Item> DARK_BROWN_BARK = WOOD_WORKING_ITEMS.registerSimpleItem("dark_brown_bark"); // Oak
    public static final DeferredItem<Item> BLACK_BARK = WOOD_WORKING_ITEMS.registerSimpleItem("black_bark"); // Dark Oak
    public static final DeferredItem<Item> CHARCOAL_POWDER = WOOD_WORKING_ITEMS.registerSimpleItem("charcoal_powder");
    public static final DeferredItem<Item> POTASH = WOOD_WORKING_ITEMS.registerSimpleItem("potash"); // (Leaching) soluable part of wood ash, evaporated/boiled + NaCO3 (Soda Ash), CaCO3, MgCO3, Potassium Sulfate, CaSO4
    public static final DeferredItem<Item> TOOL_HANDLE = WOOD_WORKING_ITEMS.registerSimpleItem("tool_handle", new Item.Properties());
    //endregion

}
