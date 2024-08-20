package io.github.zephyrwolf.medievalism.registry;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.item.BifaceItem;
import io.github.zephyrwolf.medievalism.common.item.FireStarterItem;
import io.github.zephyrwolf.medievalism.common.item.HammerstoneItem;
import io.github.zephyrwolf.medievalism.data.base.ModFoods;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ItemRegistration
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    //region World
    public static final DeferredItem<Item> RED_CLAY_BALL = ITEMS.registerSimpleItem("red_clay_ball", new Item.Properties());
    public static final DeferredItem<Item> RAW_TIN = ITEMS.registerSimpleItem("raw_tin", new Item.Properties());
    //endregion

    //region Farming
    public static final DeferredItem<Item> DOG_BANE = ITEMS.registerSimpleItem("dog_bane", new Item.Properties());
    public static final DeferredItem<Item> FLAX = ITEMS.registerSimpleItem("flax", new Item.Properties());
    public static final DeferredItem<Item> FLAX_FIBER = ITEMS.registerSimpleItem("flax_fiber", new Item.Properties());
    public static final DeferredItem<Item> FLAX_SEEDS = ITEMS.registerSimpleItem("flax_seeds", new Item.Properties());
    public static final DeferredItem<Item> BLUEBERRIES = ITEMS.registerSimpleItem("blueberries", new Item.Properties().food(ModFoods.BLUEBERRIES));
    public static final DeferredItem<Item> RASPBERRIES = ITEMS.registerSimpleItem("raspberries", new Item.Properties().food(ModFoods.RASPBERRIES));
    public static final DeferredItem<Item> STRAWBERRIES = ITEMS.registerSimpleItem("strawberries", new Item.Properties().food(ModFoods.STRAWBERRIES));
    public static final DeferredItem<Item> BARLEY_SEEDS = ITEMS.registerSimpleItem("barley_seeds", new Item.Properties());
    public static final DeferredItem<Item> BARLEY = ITEMS.registerSimpleItem("barley", new Item.Properties());
    public static final DeferredItem<Item> OAT_SEEDS = ITEMS.registerSimpleItem("oat_seeds", new Item.Properties());
    public static final DeferredItem<Item> OATS = ITEMS.registerSimpleItem("oats", new Item.Properties());
    public static final DeferredItem<Item> YAM = ITEMS.registerSimpleItem("yam", new Item.Properties().food(ModFoods.YAM));
    public static final DeferredItem<Item> BAKED_YAM = ITEMS.registerSimpleItem("baked_yam", new Item.Properties().food(ModFoods.BAKED_YAM));
    public static final DeferredItem<Item> BAKED_BEETROOT = ITEMS.registerSimpleItem("baked_beetroot", new Item.Properties().food(ModFoods.BAKED_BEETROOT));
    public static final DeferredItem<Item> BAKED_CARROT = ITEMS.registerSimpleItem("baked_carrot", new Item.Properties().food(ModFoods.BAKED_CARROT));
    // Cooking
    public static final DeferredItem<Item> CRACKED_BARLEY = ITEMS.registerSimpleItem("cracked_barley", new Item.Properties());
    public static final DeferredItem<Item> CRACKED_WHEAT = ITEMS.registerSimpleItem("cracked_wheat", new Item.Properties());
    public static final DeferredItem<Item> ROLLED_OATS = ITEMS.registerSimpleItem("rolled_oats", new Item.Properties());
    public static final DeferredItem<Item> FLOUR = ITEMS.registerSimpleItem("flour", new Item.Properties());
    public static final DeferredItem<Item> DOUGH = ITEMS.registerSimpleItem("dough", new Item.Properties());
    //endregion

    //region Primitive
    public static final DeferredItem<Item> HAMMERSTONE = ITEMS.registerItem("hammerstone", HammerstoneItem::new, new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> DIGGING_STICK = ITEMS.registerSimpleItem("digging_stick", new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> FIRE_STARTER = ITEMS.registerItem("fire_starter", FireStarterItem::new, new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> LUNATE = ITEMS.registerSimpleItem("lunate", new Item.Properties());
    public static final DeferredItem<Item> BIFACE = ITEMS.registerItem("biface", BifaceItem::new, new Item.Properties().component(DataComponents.TOOL, BifaceItem.createToolProperties()));
    //public static final DeferredItem<Item> MUD_BALL = ITEMS.registerSimpleItem("mud_ball", new Item.Properties());
    public static final DeferredItem<Item> QUICK_LIME = ITEMS.registerSimpleItem("quicklime", new Item.Properties());
    public static final DeferredItem<Item> THATCH = ITEMS.registerSimpleItem("thatch", new Item.Properties());
    public static final DeferredItem<Item> CHOPPED_WOOD = ITEMS.registerSimpleItem("chopped_wood", new Item.Properties());
    public static final DeferredItem<Item> SLACKED_LIME_BUCKET = ITEMS.registerSimpleItem("slacked_lime_bucket", new Item.Properties());
    public static final DeferredItem<Item> TANNIN_BUCKET = ITEMS.registerSimpleItem("tannin_bucket", new Item.Properties());
    //endregion

    //region Pottery
    public static final DeferredItem<Item> UNFIRED_BRICK = ITEMS.registerSimpleItem("unfired_brick", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_POTTERY_BRICK = ITEMS.registerSimpleItem("unfired_pottery_brick", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_JUG = ITEMS.registerSimpleItem("unfired_jug", new Item.Properties());
    public static final DeferredItem<Item> JUG = ITEMS.registerSimpleItem("jug", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_CRUCIBLE = ITEMS.registerSimpleItem("unfired_crucible", new Item.Properties());
    public static final DeferredItem<Item> CRUCIBLE = ITEMS.registerSimpleItem("crucible", new Item.Properties());
    //endregion

    //region MobDrops
    public static final DeferredItem<Item> BROKEN_GOAT_HORN = ITEMS.registerSimpleItem("broken_goat_horn", new Item.Properties());
    // Hide
    public static final DeferredItem<Item> BAT_HIDE = ITEMS.registerSimpleItem("bat_hide", new Item.Properties());
    public static final DeferredItem<Item> CAMEL_HIDE = ITEMS.registerSimpleItem("camel_hide", new Item.Properties());
    public static final DeferredItem<Item> CAT_HIDE = ITEMS.registerSimpleItem("cat_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> COW_HIDE = ITEMS.registerSimpleItem("cow_hide", new Item.Properties());
    public static final DeferredItem<Item> DONKEY_HIDE = ITEMS.registerSimpleItem("donkey_hide", new Item.Properties());
    public static final DeferredItem<Item> FOX_HIDE = ITEMS.registerSimpleItem("fox_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> GOAT_HIDE = ITEMS.registerSimpleItem("goat_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> HOGLIN_HIDE = ITEMS.registerSimpleItem("hoglin_hide", new Item.Properties());
    public static final DeferredItem<Item> HORSE_HIDE = ITEMS.registerSimpleItem("horse_hide", new Item.Properties());
    public static final DeferredItem<Item> LLAMA_HIDE = ITEMS.registerSimpleItem("llama_hide", new Item.Properties());
    public static final DeferredItem<Item> MOOSHROOM_HIDE = ITEMS.registerSimpleItem("mooshroom_hide", new Item.Properties());
    public static final DeferredItem<Item> MULE_HIDE = ITEMS.registerSimpleItem("mule_hide", new Item.Properties());
    public static final DeferredItem<Item> OCELOT_HIDE = ITEMS.registerSimpleItem("ocelot_hide", new Item.Properties());
    public static final DeferredItem<Item> PANDA_HIDE = ITEMS.registerSimpleItem("panda_hide", new Item.Properties());
    public static final DeferredItem<Item> PIG_HIDE = ITEMS.registerSimpleItem("pig_hide", new Item.Properties());
    public static final DeferredItem<Item> POLAR_BEAR_HIDE = ITEMS.registerSimpleItem("polar_bear_hide", new Item.Properties());
    //public static final DeferredItem<Item> RABBIT_HIDE = ITEMS.registerSimpleItem("rabbit_hide", new Item.Properties());
    public static final DeferredItem<Item> RAVAGER_HIDE = ITEMS.registerSimpleItem("ravager_hide", new Item.Properties());
    public static final DeferredItem<Item> SHEEP_HIDE = ITEMS.registerSimpleItem("sheep_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> SNIFFER_HIDE = ITEMS.registerSimpleItem("sniffer_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> SNOW_FOX_HIDE = ITEMS.registerSimpleItem("snow_fox_hide", new Item.Properties());
    public static final DeferredItem<Item> WOLF_HIDE = ITEMS.registerSimpleItem("wolf_hide", new Item.Properties()); // White
    //endregion

    //region LeatherWorking
    public static final DeferredItem<Item> LARGE_LIMED_HIDE = ITEMS.registerSimpleItem("large_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_LIMED_HIDE = ITEMS.registerSimpleItem("medium_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> SMALL_LIMED_HIDE = ITEMS.registerSimpleItem("small_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> LARGE_RAW_HIDE = ITEMS.registerSimpleItem("large_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_RAW_HIDE = ITEMS.registerSimpleItem("medium_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> SMALL_RAW_HIDE = ITEMS.registerSimpleItem("small_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> LARGE_WET_LEATHER = ITEMS.registerSimpleItem("large_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_WET_LEATHER = ITEMS.registerSimpleItem("medium_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> SMALL_WET_LEATHER = ITEMS.registerSimpleItem("small_wet_leather", new Item.Properties());
    //public static final DeferredItem<Item> LARGE_LEATHER = ITEMS.registerSimpleItem("large_leather", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_LEATHER = ITEMS.registerSimpleItem("medium_leather", new Item.Properties());
    public static final DeferredItem<Item> SMALL_LEATHER = ITEMS.registerSimpleItem("small_leather", new Item.Properties());
    //endregion

    // InWorldRecipeBuilder.fireStarter
    public static ItemStack getThatchedItem(BlockState state)
    {
        return new ItemStack(THATCH.get());
    }

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}
