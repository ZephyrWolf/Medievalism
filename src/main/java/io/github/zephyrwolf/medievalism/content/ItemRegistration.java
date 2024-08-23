package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.item.BifaceItem;
import io.github.zephyrwolf.medievalism.common.item.FireStarterItem;
import io.github.zephyrwolf.medievalism.common.item.HammerstoneItem;
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
    public static final DeferredItem<Item> RED_CLAY_BALL = ITEMS.registerSimpleItem("red_clay_ball");
    public static final DeferredItem<Item> RAW_TIN = ITEMS.registerSimpleItem("raw_tin");
    //endregion

    //region Farming
    public static final DeferredItem<Item> FLAX = ITEMS.registerSimpleItem("flax", new Item.Properties());
    public static final DeferredItem<Item> FLAX_FIBER = ITEMS.registerSimpleItem("flax_fiber", new Item.Properties());
    public static final DeferredItem<Item> FLAX_SEEDS = ITEMS.registerSimpleItem("flax_seeds", new Item.Properties());
    public static final DeferredItem<Item> BLUEBERRIES = ITEMS.registerSimpleItem("blueberries", new Item.Properties().food(FoodCatalog.BLUEBERRIES));
    public static final DeferredItem<Item> RASPBERRIES = ITEMS.registerSimpleItem("raspberries", new Item.Properties().food(FoodCatalog.RASPBERRIES));
    public static final DeferredItem<Item> STRAWBERRIES = ITEMS.registerSimpleItem("strawberries", new Item.Properties().food(FoodCatalog.STRAWBERRIES));
    public static final DeferredItem<Item> BARLEY_SEEDS = ITEMS.registerSimpleItem("barley_seeds", new Item.Properties());
    public static final DeferredItem<Item> BARLEY = ITEMS.registerSimpleItem("barley", new Item.Properties());
    public static final DeferredItem<Item> OAT_SEEDS = ITEMS.registerSimpleItem("oat_seeds", new Item.Properties());
    public static final DeferredItem<Item> OATS = ITEMS.registerSimpleItem("oats", new Item.Properties());
    public static final DeferredItem<Item> YAM = ITEMS.registerSimpleItem("yam", new Item.Properties().food(FoodCatalog.YAM));
    public static final DeferredItem<Item> BAKED_YAM = ITEMS.registerSimpleItem("baked_yam", new Item.Properties().food(FoodCatalog.BAKED_YAM));
    public static final DeferredItem<Item> BAKED_BEETROOT = ITEMS.registerSimpleItem("baked_beetroot", new Item.Properties().food(FoodCatalog.BAKED_BEETROOT));
    public static final DeferredItem<Item> BAKED_CARROT = ITEMS.registerSimpleItem("baked_carrot", new Item.Properties().food(FoodCatalog.BAKED_CARROT));
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
    public static final DeferredItem<Item> WOOD_ASH = ITEMS.registerSimpleItem("wood_ash"); // Order of concentraiton Potash(Potassiam Carbonate), CaCO3, CaO, MgCO3, Posphates and Silicates
    //endregion

    //region Pottery
    //public static final DeferredItem<Item> GROG = ITEMS.registerSimpleItem("grog"); // Not sure about this
    //public static final DeferredItem<Item> POTTERS_CLAY = ITEMS.registerSimpleItem("potters_clay"); // Clay, grog, wood ash?
    public static final DeferredItem<Item> UNFIRED_BRICK = ITEMS.registerSimpleItem("unfired_brick");
    //public static final DeferredItem<Item> UNFIRED_POTTERY_BRICK = ITEMS.registerSimpleItem("unfired_pottery_brick");
    public static final DeferredItem<Item> UNFIRED_JUG = ITEMS.registerSimpleItem("unfired_jug");
    public static final DeferredItem<Item> JUG = ITEMS.registerSimpleItem("jug");
    public static final DeferredItem<Item> UNFIRED_PLANT_POT = ITEMS.registerSimpleItem("unfired_plant_pot");
    public static final DeferredItem<Item> UNFIRED_BIRCH_POT = ITEMS.registerSimpleItem("unfired_birch_pot");
    public static final DeferredItem<Item> UNFIRED_POT = ITEMS.registerSimpleItem("unfired_pot");
    public static final DeferredItem<Item> POT = ITEMS.registerSimpleItem("pot");
    public static final DeferredItem<Item> UNFIRED_LARGE_POT = ITEMS.registerSimpleItem("unfired_large_pot");
    public static final DeferredItem<Item> LARGE_POT = ITEMS.registerSimpleItem("large_pot");
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

    //region Bark
    public static final DeferredItem<Item> WHITE_BARK = ITEMS.registerSimpleItem("white_bark"); // Birch, mangrove
    public static final DeferredItem<Item> BROWN_BARK = ITEMS.registerSimpleItem("brown_bark"); //cherry, spruce, jungle
    public static final DeferredItem<Item> GREY_BARK = ITEMS.registerSimpleItem("grey_bark"); // Acacia
    public static final DeferredItem<Item> DARK_BROWN_BARK = ITEMS.registerSimpleItem("dark_brown_bark"); // Oak
    public static final DeferredItem<Item> BLACK_BARK = ITEMS.registerSimpleItem("black_bark"); // Dark Oak
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

    //region Metallurgy
    public static final DeferredItem<Item> CHARCOAL_POWDER = ITEMS.registerSimpleItem("charcoal_powder");
    public static final DeferredItem<Item> FIRECLAY = ITEMS.registerSimpleItem("fireclay"); // clay, wood ash, charcoal powder, sand
    public static final DeferredItem<Item> POTASH = ITEMS.registerSimpleItem("potash"); // (Leaching) soluable part of wood ash, evaporated/boiled + NaCO3 (Soda Ash), CaCO3, MgCO3, Potassium Sulfate, CaSO4
    public static final DeferredItem<Item> REFRACTORY_CLAY = ITEMS.registerSimpleItem("refractory_clay"); // benotite, potash, charcoal powder, sand, iron oxide (not alumina)
    public static final DeferredItem<Item> UNFIRED_CLAY_CRUCIBLE = ITEMS.registerSimpleItem("unfired_clay_crucible", new Item.Properties());
    public static final DeferredItem<Item> CLAY_CRUCIBLE = ITEMS.registerSimpleItem("clay_crucible", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_FIRECLAY_CRUCIBLE = ITEMS.registerSimpleItem("unfired_fireclay_crucible", new Item.Properties());
    public static final DeferredItem<Item> FIRECLAY_CRUCIBLE = ITEMS.registerSimpleItem("fireclay_crucible", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_REFRACTORY_CRUCIBLE = ITEMS.registerSimpleItem("unfired_refractory_crucible", new Item.Properties());
    public static final DeferredItem<Item> REFRACTORY_CRUCIBLE = ITEMS.registerSimpleItem("refractory_crucible", new Item.Properties());

    public static final DeferredItem<Item> COPPER_ORE_DUST = ITEMS.registerSimpleItem("copper_ore_dust"); // malachite > azurite
    public static final DeferredItem<Item> TIN_ORE_DUST = ITEMS.registerSimpleItem("tin_ore_dust"); // Cassiterite
    public static final DeferredItem<Item> IRON_ORE_DUST = ITEMS.registerSimpleItem("iron_ore_dust"); // hematite > magnetite
    // Sphalerite, zinc
    //endregion

    //region Tools
    /*
    public static final DeferredItem<Item> ROCK_AXE = ITEMS.registerSimpleItem("rock_axe", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE = ITEMS.registerSimpleItem("rock_knife", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE = ITEMS.registerSimpleItem("rock_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SICKLE = ITEMS.registerSimpleItem("rock_sickle", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR = ITEMS.registerSimpleItem("rock_spear", new Item.Properties());

    public static final DeferredItem<Item> UNFIRED_AXE_MOULD = ITEMS.registerSimpleItem("unfired_axe_mould", new Item.Properties());
    public static final DeferredItem<Item> AXE_MOULD = ITEMS.registerSimpleItem("axe_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_INGOT_MOULD = ITEMS.registerSimpleItem("unfired_ingot_mould", new Item.Properties());
    public static final DeferredItem<Item> INGOT_MOULD = ITEMS.registerSimpleItem("ingot_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_KNIFE_MOULD = ITEMS.registerSimpleItem("unfired_knife_mould", new Item.Properties());
    public static final DeferredItem<Item> KNIFE_MOULD = ITEMS.registerSimpleItem("knife_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_SICKLE_MOULD = ITEMS.registerSimpleItem("unfired_sickle_mould", new Item.Properties());
    public static final DeferredItem<Item> SICKLE_MOULD = ITEMS.registerSimpleItem("sickle_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_SPEAR_MOULD = ITEMS.registerSimpleItem("unfired_spear_mould", new Item.Properties());
    public static final DeferredItem<Item> SPEAR_MOULD = ITEMS.registerSimpleItem("spear_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_PICKAXE_MOULD = ITEMS.registerSimpleItem("unfired_pickaxe_mould", new Item.Properties());
    public static final DeferredItem<Item> PICKAXE_MOULD = ITEMS.registerSimpleItem("pickaxe_mould", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_HOE_MOULD = ITEMS.registerSimpleItem("unfired_hoe_mould", new Item.Properties());
    //public static final DeferredItem<Item> HOE_MOULD = ITEMS.registerSimpleItem("hoe_mould", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_SHOVEL_MOULD = ITEMS.registerSimpleItem("unfired_shovel_mould", new Item.Properties());
    //public static final DeferredItem<Item> SHOVEL_MOULD = ITEMS.registerSimpleItem("shovel_mould", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_SWORD_MOULD = ITEMS.registerSimpleItem("unfired_sword_mould", new Item.Properties());
    //public static final DeferredItem<Item> SWORD_MOULD = ITEMS.registerSimpleItem("sword_mould", new Item.Properties());

    public static final DeferredItem<Item> COPPER_BLOOM = ITEMS.registerSimpleItem("copper_bloom", new Item.Properties());
    public static final DeferredItem<Item> IRON_BLOOM = ITEMS.registerSimpleItem("iron_bloom", new Item.Properties());
    public static final DeferredItem<Item> PIG_IRON = ITEMS.registerSimpleItem("pig_iron", new Item.Properties());
    public static final DeferredItem<Item> TIN_BLOOM = ITEMS.registerSimpleItem("tin_bloom", new Item.Properties());
    //public static final DeferredItem<Item> BRONZE_DUST = ITEMS.registerSimpleItem("bronze_dust", new Item.Properties());
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.registerSimpleItem("copper_dust", new Item.Properties());
    public static final DeferredItem<Item> TIN_DUST = ITEMS.registerSimpleItem("tin_dust", new Item.Properties());
    public static final DeferredItem<Item> COPPER_TIN_BLEND_DUST = ITEMS.registerSimpleItem("copper_tin_blend_dust", new Item.Properties());
    public static final DeferredItem<Item> COPPER_ORE_DUST = ITEMS.registerSimpleItem("copper_core_dust", new Item.Properties());
    public static final DeferredItem<Item> TIN_ORE_DUST = ITEMS.registerSimpleItem("tin_ore_dust", new Item.Properties());
    public static final DeferredItem<Item> IRON_ORE_DUST = ITEMS.registerSimpleItem("iron_ore_dust", new Item.Properties());

    public static final DeferredItem<Item> SLAG = ITEMS.registerSimpleItem("slag", new Item.Properties());
    public static final DeferredItem<Item> BLISTER_STEEL_INGOT = ITEMS.registerSimpleItem("blister_steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.registerSimpleItem("bronze_ingot", new Item.Properties());
    public static final DeferredItem<Item> CAST_IRON_INGOT = ITEMS.registerSimpleItem("cast_iron_ingot", new Item.Properties());
    //public static final DeferredItem<Item> CHROMIUM_INGOT = ITEMS.registerSimpleItem("chromium_ingot", new Item.Properties());
    //public static final DeferredItem<Item> COPPER_INGOT = ITEMS.registerSimpleItem("copper_ingot", new Item.Properties());
    //public static final DeferredItem<Item> GOLD_INGOT = ITEMS.registerSimpleItem("gold_ingot", new Item.Properties());
    //public static final DeferredItem<Item> LEAD_INGOT = ITEMS.registerSimpleItem("lead_ingot", new Item.Properties());
    //public static final DeferredItem<Item> NICKLE_INGOT = ITEMS.registerSimpleItem("nickle_ingot", new Item.Properties());
    public static final DeferredItem<Item> SHEAR_STEEL_INGOT = ITEMS.registerSimpleItem("shear_steel_ingot", new Item.Properties());
    //public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot", new Item.Properties());
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.registerSimpleItem("tin_ingot", new Item.Properties());
    //public static final DeferredItem<Item> TUNGSTEN_INGOT = ITEMS.registerSimpleItem("tungsten_ingot", new Item.Properties());
    //public static final DeferredItem<Item> WROUGHT_IRON_INGOT = ITEMS.registerSimpleItem("wrought_iron_ingot", new Item.Properties()); // == minecraft:iron_ingot

    public static final DeferredItem<Item> COPPER_AXE = ITEMS.registerSimpleItem("copper_axe", new Item.Properties());
    public static final DeferredItem<Item> COPPER_KNIFE = ITEMS.registerSimpleItem("copper_knife", new Item.Properties());
    public static final DeferredItem<Item> COPPER_PICKAXE = ITEMS.registerSimpleItem("copper_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SICKLE = ITEMS.registerSimpleItem("copper_sickle", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SPEAR = ITEMS.registerSimpleItem("copper_spear", new Item.Properties());
    public static final DeferredItem<Item> TIN_AXE = ITEMS.registerSimpleItem("tin_axe", new Item.Properties());
    public static final DeferredItem<Item> TIN_KNIFE = ITEMS.registerSimpleItem("tin_knife", new Item.Properties());
    public static final DeferredItem<Item> TIN_PICKAXE = ITEMS.registerSimpleItem("tin_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> TIN_SICKLE = ITEMS.registerSimpleItem("tin_sickle", new Item.Properties());
    public static final DeferredItem<Item> TIN_SPEAR = ITEMS.registerSimpleItem("tin_spear", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_AXE = ITEMS.registerSimpleItem("bronze_axe", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_KNIFE = ITEMS.registerSimpleItem("bronze_knife", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_PICKAXE = ITEMS.registerSimpleItem("bronze_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SICKLE = ITEMS.registerSimpleItem("bronze_sickle", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SPEAR = ITEMS.registerSimpleItem("bronze_spear", new Item.Properties());
    public static final DeferredItem<Item> ROCK_AXE_HEAD = ITEMS.registerSimpleItem("rock_axe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE_HEAD = ITEMS.registerSimpleItem("rock_knife_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE_HEAD = ITEMS.registerSimpleItem("rock_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SICKLE_HEAD = ITEMS.registerSimpleItem("rock_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR_HEAD = ITEMS.registerSimpleItem("rock_spear_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_AXE_HEAD = ITEMS.registerSimpleItem("copper_axe_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_KNIFE_HEAD = ITEMS.registerSimpleItem("copper_knife_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_PICKAXE_HEAD = ITEMS.registerSimpleItem("copper_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SICKLE_HEAD = ITEMS.registerSimpleItem("copper_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SPEAR_HEAD = ITEMS.registerSimpleItem("copper_spear_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_AXE_HEAD = ITEMS.registerSimpleItem("tin_axe_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_KNIFE_HEAD = ITEMS.registerSimpleItem("tin_knife_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_PICKAXE_HEAD = ITEMS.registerSimpleItem("tin_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_SICKLE_HEAD = ITEMS.registerSimpleItem("tin_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_SPEAR_HEAD = ITEMS.registerSimpleItem("tin_spear_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_AXE_HEAD = ITEMS.registerSimpleItem("bronze_axe_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_KNIFE_HEAD = ITEMS.registerSimpleItem("bronze_knife_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_PICKAXE_HEAD = ITEMS.registerSimpleItem("bronze_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SICKLE_HEAD = ITEMS.registerSimpleItem("bronze_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SPEAR_HEAD = ITEMS.registerSimpleItem("bronze_spear_head", new Item.Properties());

    //public static final DeferredItem<Item> MOLTEN_COPPER_BUCKET = ITEMS.registerSimpleItem("molten_copper_bucket", new Item.Properties());
    //public static final DeferredItem<Item> MOLTEN_TIN_BUCKET = ITEMS.registerSimpleItem("molten_tin_bucket", new Item.Properties());
    //public static final DeferredItem<Item> MOLTEN_BRONZE_BUCKET = ITEMS.registerSimpleItem("molten_bronze_bucket", new Item.Properties()); // vs Brass?
    */
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
