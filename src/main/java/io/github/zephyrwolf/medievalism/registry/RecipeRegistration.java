package io.github.zephyrwolf.medievalism.registry;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.AdditionalDropToolUseRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.AdditionalDropToolUseRecipeSerializer;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeRegistration
{
    //public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPES, Tutorial2Block.MODID);
    //public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU_TYPES, Tutorial2Block.MODID);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
            Registries.RECIPE_TYPE, MedievalismConstants.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
            Registries.RECIPE_SERIALIZER, MedievalismConstants.MOD_ID);

    public static final Supplier<RecipeSerializer<InWorldRecipe>> IN_WORLD_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("in_world", InWorldRecipeSerializer::new);
    public static final Supplier<RecipeSerializer<AdditionalDropToolUseRecipe>> ADDITIONAL_DROP_TOOL_USE_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("additional_drop_tool_use", AdditionalDropToolUseRecipeSerializer::new);

    public static final Supplier<RecipeType<InWorldRecipe>> IN_WORLD_RECIPE_TYPE = RECIPE_TYPES.register("in_world", () ->
            RecipeType.simple(MedievalismConstants.resource("in_world")));
    public static final Supplier<RecipeType<AdditionalDropToolUseRecipe>> ADDITIONAL_DROP_TOOL_USE_RECIPE_TYPE = RECIPE_TYPES.register("additional_drop_tool_use", () ->
            RecipeType.simple(MedievalismConstants.resource("additional_drop_tool_use")));



    // Stone Anvil
    // Primitive Table

    // Claystone
    // Red Claystone
    // Limewash, Claystone
    // Chopping Block
    // Wattle Fence
    // Blueberry Bush
    // Raspberry Bush
    // Strawberry Bush !!!!!!!!!!!!!! that doesnt make sence, its a ground cover
    // yams
    // Oats
    // Barley
    // Bloomery
    // Charcoal Mound
    // Mud Kiln
    // Pit Kiln
    // Barrel


    // Wild Potato
    // Wild Carrot
    // Wild Beetroot
    // Wild Yam

    // -- Farming


    // -- Knapping


    // -- Pottery




    // -- Leather Working


    // -- Misc


    /*
    public static final DeferredItem<Item> ROCK_AXE = ITEMS.registerSimpleItem("rock_axe", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE = ITEMS.registerSimpleItem("rock_knife", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE = ITEMS.registerSimpleItem("rock_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SICKLE = ITEMS.registerSimpleItem("rock_sickle", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR = ITEMS.registerSimpleItem("rock_spear", new Item.Properties());
    */

    /*
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
    */

    /*
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
    */

    //public static final DeferredItem<Item> MOLTEN_COPPER_BUCKET = ITEMS.registerSimpleItem("molten_copper_bucket", new Item.Properties());
    //public static final DeferredItem<Item> MOLTEN_TIN_BUCKET = ITEMS.registerSimpleItem("molten_tin_bucket", new Item.Properties());
    //public static final DeferredItem<Item> MOLTEN_BRONZE_BUCKET = ITEMS.registerSimpleItem("molten_bronze_bucket", new Item.Properties()); // vs Brass?

    public static void register(IEventBus modEventBus)
    {
        //BLOCK_ENTITIES.register(modEventBus);
        //MENU_TYPES.register(modEventBus);
        RECIPE_TYPES.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
    }

    /*
    public static void addCreativeModeTabContents(BuildCreativeModeTabContentsEvent event)
    { // Existing Tabs
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(RED_CLAY_BALL);
        }
        else if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(RED_CLAY_BLOCK_ITEM);
        }
    }
    */
}
