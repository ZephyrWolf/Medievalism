package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.catalogs.item.food.FoodCatalog;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class CookingItemRegistration
{
    public static final DeferredRegister.Items COOKING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        COOKING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return COOKING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == COOKING ==
    public static final DeferredItem<Item> BAKED_BEETROOT =             COOKING_ITEMS.registerSimpleItem("baked_beetroot", new Item.Properties().food(FoodCatalog.BAKED_BEETROOT));
    public static final DeferredItem<Item> BAKED_CARROT =               COOKING_ITEMS.registerSimpleItem("baked_carrot", new Item.Properties().food(FoodCatalog.BAKED_CARROT));
    public static final DeferredItem<Item> BAKED_GARLIC =               COOKING_ITEMS.registerSimpleItem("baked_garlic", new Item.Properties().food(FoodCatalog.BAKED_GARLIC));
    public static final DeferredItem<Item> BAKED_LEEK =                 COOKING_ITEMS.registerSimpleItem("baked_leek", new Item.Properties().food(FoodCatalog.BAKED_LEEK));
    public static final DeferredItem<Item> BAKED_PARSNIP =              COOKING_ITEMS.registerSimpleItem("baked_parsnip", new Item.Properties().food(FoodCatalog.BAKED_PARSNIP));
    public static final DeferredItem<Item> PUMPKIN_SLICE =              COOKING_ITEMS.registerSimpleItem("pumpkin_slice",   new Item.Properties().food(FoodCatalog.PUMPKIN_SLICE));
    public static final DeferredItem<Item> GREEN_PUMPKIN_SLICE =        COOKING_ITEMS.registerSimpleItem("green_pumpkin_slice",   new Item.Properties().food(FoodCatalog.PUMPKIN_SLICE));
    public static final DeferredItem<Item> BAKED_PUMPKIN =              COOKING_ITEMS.registerSimpleItem("baked_pumpkin", new Item.Properties());
    public static final DeferredItem<Item> BAKED_GREEN_PUMPKIN =        COOKING_ITEMS.registerSimpleItem("baked_green_pumpkin", new Item.Properties());
    public static final DeferredItem<Item> BAKED_PUMPKIN_SLICE =        COOKING_ITEMS.registerSimpleItem("baked_pumpkin_slice", new Item.Properties().food(FoodCatalog.BAKED_PUMPKIN_SLICE));
    public static final DeferredItem<Item> BAKED_GREEN_PUMPKIN_SLICE =  COOKING_ITEMS.registerSimpleItem("baked_green_pumpkin_slice", new Item.Properties().food(FoodCatalog.BAKED_PUMPKIN_SLICE));
    public static final DeferredItem<Item> BAKED_PURPLE_CARROT =        COOKING_ITEMS.registerSimpleItem("baked_purple_carrot", new Item.Properties().food(FoodCatalog.BAKED_PURPLE_CARROT));
    public static final DeferredItem<Item> BAKED_PURPLE_ONION =         COOKING_ITEMS.registerSimpleItem("baked_purple_onion", new Item.Properties().food(FoodCatalog.BAKED_PURPLE_ONION));
    public static final DeferredItem<Item> BAKED_PURPLE_SKIRRET =       COOKING_ITEMS.registerSimpleItem("baked_purple_skirret", new Item.Properties().food(FoodCatalog.BAKED_PURPLE_SKIRRET));
    public static final DeferredItem<Item> BAKED_RADISH =               COOKING_ITEMS.registerSimpleItem("baked_radish", new Item.Properties().food(FoodCatalog.BAKED_RADISH));
    public static final DeferredItem<Item> BAKED_SKIRRET =              COOKING_ITEMS.registerSimpleItem("baked_skirret", new Item.Properties().food(FoodCatalog.BAKED_SKIRRET));
    public static final DeferredItem<Item> BAKED_TURNIP =               COOKING_ITEMS.registerSimpleItem("baked_turnip", new Item.Properties().food(FoodCatalog.BAKED_TURNIP));
    public static final DeferredItem<Item> BAKED_WHITE_CARROT =         COOKING_ITEMS.registerSimpleItem("baked_white_carrot", new Item.Properties().food(FoodCatalog.BAKED_WHITE_CARROT));
    public static final DeferredItem<Item> BAKED_WHITE_ONION =          COOKING_ITEMS.registerSimpleItem("baked_white_onion", new Item.Properties().food(FoodCatalog.BAKED_WHITE_ONION));
    public static final DeferredItem<Item> BAKED_YAM =                  COOKING_ITEMS.registerSimpleItem("baked_yam", new Item.Properties().food(FoodCatalog.BAKED_YAM));
    public static final DeferredItem<Item> CRACKED_BARLEY =             COOKING_ITEMS.registerSimpleItem("cracked_barley", new Item.Properties());
    public static final DeferredItem<Item> CRACKED_WHEAT =              COOKING_ITEMS.registerSimpleItem("cracked_wheat", new Item.Properties());
    public static final DeferredItem<Item> ROLLED_OATS =                COOKING_ITEMS.registerSimpleItem("rolled_oats", new Item.Properties());
    public static final DeferredItem<Item> FLOUR =                      COOKING_ITEMS.registerSimpleItem("flour", new Item.Properties());
    public static final DeferredItem<Item> DOUGH =                      COOKING_ITEMS.registerSimpleItem("dough", new Item.Properties());
    //endregion
}
