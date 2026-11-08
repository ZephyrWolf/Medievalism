package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.VanillaDeferredItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class LeatherWorkingItemRegistration
{
    public static final DeferredRegister.Items LEATHER_WORKING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        LEATHER_WORKING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return LEATHER_WORKING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == LEATHER WORKING ==
    public static final DeferredItem<Item> QUICK_LIME = LEATHER_WORKING_ITEMS.registerSimpleItem("quicklime", new Item.Properties());
    public static final DeferredItem<Item> SLACKED_LIME_BUCKET = LEATHER_WORKING_ITEMS.registerSimpleItem("slacked_lime_bucket", new Item.Properties());

    public static final DeferredItem<Item> BAT_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("bat_hide", new Item.Properties());
    public static final DeferredItem<Item> CAMEL_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("camel_hide", new Item.Properties());
    public static final DeferredItem<Item> CAT_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("cat_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> COW_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("cow_hide", new Item.Properties());
    public static final DeferredItem<Item> DONKEY_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("donkey_hide", new Item.Properties());
    public static final DeferredItem<Item> FOX_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("fox_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> GOAT_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("goat_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> HOGLIN_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("hoglin_hide", new Item.Properties());
    public static final DeferredItem<Item> HORSE_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("horse_hide", new Item.Properties());
    public static final DeferredItem<Item> LLAMA_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("llama_hide", new Item.Properties());
    public static final DeferredItem<Item> MOOSHROOM_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("mooshroom_hide", new Item.Properties());
    public static final DeferredItem<Item> MULE_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("mule_hide", new Item.Properties());
    public static final DeferredItem<Item> OCELOT_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("ocelot_hide", new Item.Properties());
    public static final DeferredItem<Item> PANDA_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("panda_hide", new Item.Properties());
    public static final DeferredItem<Item> PIG_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("pig_hide", new Item.Properties());
    public static final DeferredItem<Item> POLAR_BEAR_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("polar_bear_hide", new Item.Properties());
    public static final DeferredItem<Item> RABBIT_HIDE = new VanillaDeferredItem<>(Items.RABBIT_HIDE);
    public static final DeferredItem<Item> RAVAGER_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("ravager_hide", new Item.Properties());
    public static final DeferredItem<Item> SHEEP_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("sheep_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> SNIFFER_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("sniffer_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> SNOW_FOX_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("snow_fox_hide", new Item.Properties());
    public static final DeferredItem<Item> WOLF_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("wolf_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> LARGE_LIMED_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("large_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_LIMED_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("medium_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> SMALL_LIMED_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("small_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> LARGE_RAW_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("large_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_RAW_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("medium_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> SMALL_RAW_HIDE = LEATHER_WORKING_ITEMS.registerSimpleItem("small_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> LARGE_WET_LEATHER = LEATHER_WORKING_ITEMS.registerSimpleItem("large_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_WET_LEATHER = LEATHER_WORKING_ITEMS.registerSimpleItem("medium_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> SMALL_WET_LEATHER = LEATHER_WORKING_ITEMS.registerSimpleItem("small_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> LARGE_LEATHER = new VanillaDeferredItem<>(Items.LEATHER);
    public static final DeferredItem<Item> MEDIUM_LEATHER = LEATHER_WORKING_ITEMS.registerSimpleItem("medium_leather", new Item.Properties());
    public static final DeferredItem<Item> SMALL_LEATHER = LEATHER_WORKING_ITEMS.registerSimpleItem("small_leather", new Item.Properties());
    //endregion
}
