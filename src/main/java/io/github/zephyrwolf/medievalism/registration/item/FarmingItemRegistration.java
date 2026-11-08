package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.VanillaDeferredItem;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.catalogs.food.FoodCatalog;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class FarmingItemRegistration
{
    public static final DeferredRegister.Items FARMING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        FARMING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return FARMING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == FARMING ==
    public static final DeferredItem<BlockItem> THATCH_BLOCK = FARMING_ITEMS.registerSimpleBlockItem("thatch_block",                  BlockRegistration.THATCH_BLOCK);
    public static final DeferredItem<BlockItem> THATCH = FARMING_ITEMS.registerSimpleBlockItem("thatch",                        BlockRegistration.THATCH_FIRE_LAY);
    // Leaf Litter

    public static final DeferredItem<Item> BARLEY =                     FARMING_ITEMS.registerSimpleItem("barley",          new Item.Properties());
    public static final DeferredItem<Item> BARLEY_SEEDS =               FARMING_ITEMS.registerSimpleItem("barley_seeds",    new Item.Properties());
    public static final DeferredItem<Item> BEETROOT =                   new VanillaDeferredItem<>(Items.BEETROOT);
    public static final DeferredItem<Item> BLUEBERRIES =                FARMING_ITEMS.registerSimpleItem("blueberries",     new Item.Properties().food(FoodCatalog.BLUEBERRIES));
    public static final DeferredItem<Item> BROAD_BEAN =                 FARMING_ITEMS.registerSimpleItem("broad_bean",      new Item.Properties().food(FoodCatalog.BROAD_BEAN));
    public static final DeferredItem<Item> CABBAGE =                    FARMING_ITEMS.registerSimpleItem("cabbage",         new Item.Properties().food(FoodCatalog.CABBAGE));
    public static final DeferredItem<Item> CARROT =                     new VanillaDeferredItem<>(Items.CARROT);
    public static final DeferredItem<Item> CHARD =                      FARMING_ITEMS.registerSimpleItem("chard",           new Item.Properties().food(FoodCatalog.CHARD));
    public static final DeferredItem<BlockItem> DOGBANE =               FARMING_ITEMS.registerSimpleBlockItem("dogbane",    BlockRegistration.DOGBANE);
    public static final DeferredItem<Item> FLAX =                       FARMING_ITEMS.registerSimpleItem("flax",            new Item.Properties());
    public static final DeferredItem<Item> FLAX_SEEDS =                 FARMING_ITEMS.registerSimpleItem("flax_seeds",      new Item.Properties());
    public static final DeferredItem<Item> GARLIC =                     FARMING_ITEMS.registerSimpleItem("garlic",          new Item.Properties().food(FoodCatalog.GARLIC));
    public static final DeferredItem<Item> LEEK =                       FARMING_ITEMS.registerSimpleItem("leek",            new Item.Properties().food(FoodCatalog.LEEK));
    public static final DeferredItem<Item> MELON =                      new VanillaDeferredItem<>(Items.MELON);
    public static final DeferredItem<Item> MELON_SLICE =                new VanillaDeferredItem<>(Items.MELON_SLICE);
    public static final DeferredItem<Item> NAPA_CABBAGE =               FARMING_ITEMS.registerSimpleItem("napa_cabbage",    new Item.Properties().food(FoodCatalog.NAPA_CABBAGE));
    public static final DeferredItem<Item> NETTLE =                     FARMING_ITEMS.registerSimpleItem("nettle",          new Item.Properties().food(FoodCatalog.NETTLE));
    public static final DeferredItem<Item> OAT_SEEDS =                  FARMING_ITEMS.registerSimpleItem("oat_seeds",       new Item.Properties());
    public static final DeferredItem<Item> OATS =                       FARMING_ITEMS.registerSimpleItem("oats",            new Item.Properties());
    public static final DeferredItem<Item> PARSNIP =                    FARMING_ITEMS.registerSimpleItem("parsnip",         new Item.Properties().food(FoodCatalog.PARSNIP));
    public static final DeferredItem<Item> POTATO =                     new VanillaDeferredItem<>(Items.POTATO);
    public static final DeferredItem<Item> PUMPKIN =                    new VanillaDeferredItem<>(Items.PUMPKIN);
    public static final DeferredItem<BlockItem> GREEN_PUMPKIN =         FARMING_ITEMS.registerSimpleBlockItem(BlockRegistration.GREEN_PUMPKIN,  new Item.Properties());
    public static final DeferredItem<Item> PURPLE_CARROT =              FARMING_ITEMS.registerSimpleItem("purple_carrot",   new Item.Properties().food(FoodCatalog.PURPLE_CARROT));
    public static final DeferredItem<Item> PURPLE_ONION =               FARMING_ITEMS.registerSimpleItem("purple_onion",    new Item.Properties().food(FoodCatalog.PURPLE_ONION));
    public static final DeferredItem<Item> PURPLE_SKIRRET =             FARMING_ITEMS.registerSimpleItem("purple_skirret",  new Item.Properties().food(FoodCatalog.PURPLE_SKIRRET));
    public static final DeferredItem<Item> RADISH =                     FARMING_ITEMS.registerSimpleItem("radish",          new Item.Properties().food(FoodCatalog.RADISH));
    public static final DeferredItem<Item> RASPBERRIES =                FARMING_ITEMS.registerSimpleItem("raspberries",     new Item.Properties().food(FoodCatalog.RASPBERRIES));
    public static final DeferredItem<Item> SKIRRET =                    FARMING_ITEMS.registerSimpleItem("skirret",         new Item.Properties().food(FoodCatalog.SKIRRET));
    public static final DeferredItem<Item> SPINACH =                    FARMING_ITEMS.registerSimpleItem("spinach",         new Item.Properties().food(FoodCatalog.SPINACH));
    public static final DeferredItem<Item> STRAWBERRIES =               FARMING_ITEMS.registerSimpleItem("strawberries",    new Item.Properties().food(FoodCatalog.STRAWBERRIES));
    public static final DeferredItem<Item> TURNIP =                     FARMING_ITEMS.registerSimpleItem("turnip",          new Item.Properties().food(FoodCatalog.TURNIP));
    public static final DeferredItem<Item> WHITE_CARROT =               FARMING_ITEMS.registerSimpleItem("white_carrot",    new Item.Properties().food(FoodCatalog.WHITE_CARROT));
    public static final DeferredItem<Item> WHITE_ONION =                FARMING_ITEMS.registerSimpleItem("white_onion",     new Item.Properties().food(FoodCatalog.WHITE_ONION));
    public static final DeferredItem<BlockItem> YAM =                   FARMING_ITEMS.registerItem("yam", props -> new ItemNameBlockItem(BlockRegistration.YAMS.get(), new Item.Properties().food(FoodCatalog.YAM)));
    //endregion
}
