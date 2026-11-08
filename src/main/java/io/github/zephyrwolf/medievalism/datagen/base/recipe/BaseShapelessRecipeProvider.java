package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.crafting.ShapelessToolRecipeBuilder;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class BaseShapelessRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        survivalRecipes(recipeOutput);
        potteryRecipes(recipeOutput);
        foodRecipes(recipeOutput);
        cordageRecipes(recipeOutput);
        leatherRecipes(recipeOutput);
        toolRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
        // Thatch
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.THATCH, 4)
                .requires(ItemRegistration.THATCH_BLOCK)
                .unlockedBy("has_thatch_block", RecipeTools.itemPredicateOf(ItemRegistration.THATCH_BLOCK))
                .save(recipeOutput, MedievalismConstants.resource("thatch_from_block"));
        // Mud Ball
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DIRT_CHUNK, 2)
                .requires(Blocks.DIRT)
                .group("dirt_chunk")
                .unlockedBy("has_dirt", RecipeTools.itemPredicateOf(Blocks.DIRT))
                .save(recipeOutput, MedievalismConstants.resource("dirt_chunk_from_dirt"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MUD_BALL, 4)
                .requires(Blocks.MUD)
                .group("mud_ball")
                .unlockedBy("has_mud", RecipeTools.itemPredicateOf(Blocks.MUD))
                .save(recipeOutput, MedievalismConstants.resource("mud_balls_from_mud"));
        // Fire Starter
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.FIRE_STARTER)
                .requires(Items.STICK)
                .requires(Items.STICK)
                .requires(ItemTagCatalog.CARVING_TOOL)
                .unlockedBy("has_knife", RecipeTools.itemPredicateOf(ItemTagCatalog.CARVING_TOOL))
                .save(recipeOutput, MedievalismConstants.resource("fire_starter"));
        // Digging Stick TODO Temp recipe, make handle and then sharpen handle?
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DIGGING_STICK)
                .requiresIngredient(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requiresTool(ItemTagCatalog.CARVING_TOOL)
                .unlockedBy("has_knife", RecipeTools.itemPredicateOf(ItemTagCatalog.CARVING_TOOL))
                .save(recipeOutput, MedievalismConstants.resource("digging_stick"));
    }

    private static void potteryRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.WET_DAUB, 2)
                .requires(ItemTagCatalog.CLAY_BALL)
                .requires(ItemRegistration.MUD_BALL)
                .requires(ItemRegistration.THATCH)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ItemTagCatalog.CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("wet_daub"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_PACKED_MUD_BRICK)
                .requires(ItemRegistration.MUD_BALL)
                .requires(ItemRegistration.THATCH)
                .unlockedBy("has_thatch", RecipeTools.itemPredicateOf(ItemRegistration.THATCH))
                .save(recipeOutput, MedievalismConstants.resource("drying_mud_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_DAUB_BRICK)
                .requires(ItemRegistration.WET_DAUB)
                .unlockedBy("has_wet_daub", RecipeTools.itemPredicateOf(ItemRegistration.WET_DAUB))
                .save(recipeOutput, MedievalismConstants.resource("drying_daub_brick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.POTTERS_CLAY_BALL, 2)
                .requires(ItemTagCatalog.GROG)
                .requires(Items.CLAY_BALL)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_grog", RecipeTools.itemPredicateOf(ItemTagCatalog.GROG))
                .save(recipeOutput, MedievalismConstants.resource("potters_clay_ball"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.REFRACTORY_CLAY_BALL, 2)
                .requires(ItemRegistration.KAOLIN_GROG)
                .requires(ItemRegistration.KAOLIN_CLAY_BALL)
                .requires(ItemRegistration.KAOLIN_CLAY_BALL)
                .requires(ItemTags.SAND)
                .unlockedBy("has_grog", RecipeTools.itemPredicateOf(ItemTagCatalog.GROG))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_ball"));

        // Unfired Brick
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_CLAY_BRICK)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ItemTagCatalog.CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requires(ItemRegistration.POTTERS_CLAY_BALL)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ItemRegistration.POTTERS_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_potters_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_KAOLIN_CLAY_BRICK)
                .requires(ItemRegistration.KAOLIN_CLAY_BALL)
                .unlockedBy("has_kaolin_clay_ball", RecipeTools.itemPredicateOf(ItemRegistration.KAOLIN_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_kaolin_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_REFRACTORY_CLAY_BRICK)
                .requires(ItemRegistration.REFRACTORY_CLAY_BALL)
                .unlockedBy("has_refractory_clay_ball", RecipeTools.itemPredicateOf(ItemRegistration.REFRACTORY_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_refractory_clay_brick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_CLAY_DOUBLE_BRICK)
                .requires(ItemRegistration.DRYING_CLAY_BRICK)
                .requires(ItemRegistration.DRYING_CLAY_BRICK)
                .unlockedBy("has_wet_clay_brick", RecipeTools.itemPredicateOf(ItemRegistration.DRYING_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_clay_double_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK)
                .requires(ItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requires(ItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .unlockedBy("has_wet_potters_clay_brick", RecipeTools.itemPredicateOf(ItemRegistration.DRYING_POTTERS_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_potters_clay_double_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK)
                .requires(ItemRegistration.DRYING_KAOLIN_CLAY_BRICK)
                .requires(ItemRegistration.DRYING_KAOLIN_CLAY_BRICK)
                .unlockedBy("has_wet_kaolin_clay_brick", RecipeTools.itemPredicateOf(ItemRegistration.DRYING_KAOLIN_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_kaolin_clay_double_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK)
                .requires(ItemRegistration.DRYING_REFRACTORY_CLAY_BRICK)
                .requires(ItemRegistration.DRYING_REFRACTORY_CLAY_BRICK)
                .unlockedBy("has_wet_refractory_clay_brick", RecipeTools.itemPredicateOf(ItemRegistration.DRYING_REFRACTORY_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_refractory_clay_double_brick"));

        // Birch Pot
        /*
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.UNFIRED_BIRCH_POT)
                .requires(ItemRegistration.UNFIRED_FLOWER_POT)
                .requires(Items.STICK)
                .group("unfired_birch_pot")
                .unlockedBy("has_unfired_flower_pot", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_FLOWER_POT))
                .save(recipeOutput, MedievalismConstants.resource("unfired_birch_pot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.UNFIRED_BIRCH_POT)
                .requires(ItemRegistration.UNFIRED_FLOWER_POT)
                .requires(ItemTagCatalog.AWL)
                .group("unfired_birch_pot")
                .unlockedBy("has_unfired_flower_pot", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_FLOWER_POT))
                .save(recipeOutput, MedievalismConstants.resource("unfired_birch_pot_awl"));
         */
    }

    private static void foodRecipes(RecipeOutput recipeOutput) {
        // Cracked Grain
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.CRACKED_WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                //.requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_wheat", RecipeTools.itemPredicateOf(Items.WHEAT))
                .save(recipeOutput, MedievalismConstants.resource("cracked_wheat_shapeless"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.CRACKED_BARLEY)
                .requires(ItemRegistration.BARLEY)
                .requires(ItemRegistration.BARLEY)
                .requires(ItemRegistration.BARLEY)
                //.requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_barley", RecipeTools.itemPredicateOf(ItemRegistration.BARLEY))
                .save(recipeOutput, MedievalismConstants.resource("cracked_barley_shapeless"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.ROLLED_OATS)
                .requires(ItemRegistration.OATS)
                .requires(ItemRegistration.OATS)
                .requires(ItemRegistration.OATS)
                //.requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_oat", RecipeTools.itemPredicateOf(ItemRegistration.OATS))
                .save(recipeOutput, MedievalismConstants.resource("rolled_oats_shapeless"));
        // TODO Should I have different types of flour and bread?
        // Flour
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.FLOUR)
                .requires(ItemTagCatalog.CAN_CRAFT_FLOUR)
                //.requires(ItemTagCatalog.HAMMER)
                .group("flour")
                .unlockedBy("can_make_flour", RecipeTools.itemPredicateOf(ItemTagCatalog.CAN_CRAFT_FLOUR))
                .save(recipeOutput, MedievalismConstants.resource("flour"));
        // Dough
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.DOUGH)
                .requires(ItemRegistration.FLOUR)
                .group("dough")
                .unlockedBy("has_flour", RecipeTools.itemPredicateOf(ItemRegistration.FLOUR))
                .save(recipeOutput, MedievalismConstants.resource("dough"));

        // TODO These should have a knife as a tool
        // TODO Replace melon recipe with this format
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.PUMPKIN_SLICE, 9)
                .requires(Items.PUMPKIN)
                .group("pumpkin_slice")
                .unlockedBy("hasPumpkin", RecipeTools.itemPredicateOf(Items.PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("pumpkin_slice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.GREEN_PUMPKIN_SLICE, 9)
                .requires(ItemRegistration.GREEN_PUMPKIN)
                .group("green_pumpkin_slice")
                .unlockedBy("hasGreenPumpkin", RecipeTools.itemPredicateOf(ItemRegistration.GREEN_PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("green_pumpkin_slice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.BAKED_PUMPKIN_SLICE, 9)
                .requires(ItemRegistration.BAKED_PUMPKIN)
                .group("baked_pumpkin_slice")
                .unlockedBy("hasBakedPumpkin", RecipeTools.itemPredicateOf(ItemRegistration.BAKED_PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("baked_pumpkin_slice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.BAKED_GREEN_PUMPKIN_SLICE, 9)
                .requires(ItemRegistration.BAKED_GREEN_PUMPKIN)
                .group("baked_green_pumpkin_slice")
                .unlockedBy("hasBakedGreenPumpkin", RecipeTools.itemPredicateOf(ItemRegistration.BAKED_GREEN_PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("baked_green_pumpkin_slice"));
    }

    private static void cordageRecipes(RecipeOutput recipeOutput) {
        // TODO This is a temp. Will need to soak flax to obtain their fibers
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.FLAX_FIBER)
                .requires(ItemRegistration.FLAX)
                .unlockedBy("has_flax", RecipeTools.itemPredicateOf(ItemRegistration.FLAX))
                .save(recipeOutput, MedievalismConstants.resource("flax_fiber"));
    }

    private static void leatherRecipes(RecipeOutput recipeOutput) {
        // Salted Hide
        // TODO
        // Dried Salted Hide
        // TODO
        // Cured Hide
        // TODO
        // Limed Hide
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LARGE_LIMED_HIDE)
                .requires(ItemTagCatalog.LARGE_HIDE)
                .unlockedBy("has_large_hide", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("large_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_LIMED_HIDE)
                .requires(ItemTagCatalog.MEDIUM_HIDE)
                .unlockedBy("has_medium_hide", RecipeTools.itemPredicateOf(ItemTagCatalog.MEDIUM_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("medium_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_LIMED_HIDE)
                .requires(ItemTagCatalog.SMALL_HIDE)
                .unlockedBy("has_small_hide", RecipeTools.itemPredicateOf(ItemTagCatalog.SMALL_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("small_limed_hide"));
        // Raw Hide / Scraped Hide
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LARGE_RAW_HIDE)
                .requires(ItemRegistration.LARGE_LIMED_HIDE)
                .unlockedBy("has_large_limed_hide", RecipeTools.itemPredicateOf(ItemRegistration.LARGE_LIMED_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("large_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_RAW_HIDE)
                .requires(ItemRegistration.MEDIUM_LIMED_HIDE)
                .unlockedBy("has_medium_limed_hide", RecipeTools.itemPredicateOf(ItemRegistration.MEDIUM_LIMED_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("medium_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_RAW_HIDE)
                .requires(ItemRegistration.SMALL_LIMED_HIDE)
                .unlockedBy("has_small_limed_hide", RecipeTools.itemPredicateOf(ItemRegistration.SMALL_LIMED_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("small_raw_hide"));
        // Soaked Hide
        // TODO
        // Wet Leather
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LARGE_WET_LEATHER)
                .requires(ItemRegistration.LARGE_RAW_HIDE)
                .unlockedBy("has_large_raw_hide", RecipeTools.itemPredicateOf(ItemRegistration.LARGE_RAW_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("large_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_WET_LEATHER)
                .requires(ItemRegistration.MEDIUM_RAW_HIDE)
                .unlockedBy("has_medium_raw_hide", RecipeTools.itemPredicateOf(ItemRegistration.MEDIUM_RAW_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("medium_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_WET_LEATHER)
                .requires(ItemRegistration.SMALL_RAW_HIDE)
                .unlockedBy("has_small_raw_hide", RecipeTools.itemPredicateOf(ItemRegistration.SMALL_RAW_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("small_wet_leather"));
        // Leather
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(ItemRegistration.LARGE_WET_LEATHER)
                .unlockedBy("has_large_wet_leather", RecipeTools.itemPredicateOf(ItemRegistration.LARGE_WET_LEATHER))
                .save(recipeOutput, MedievalismConstants.resource("large_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_LEATHER)
                .requires(ItemRegistration.MEDIUM_WET_LEATHER)
                .unlockedBy("has_medium_wet_leather", RecipeTools.itemPredicateOf(ItemRegistration.MEDIUM_WET_LEATHER))
                .save(recipeOutput, MedievalismConstants.resource("medium_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_LEATHER)
                .requires(ItemRegistration.SMALL_WET_LEATHER)
                .unlockedBy("has_small_wet_leather", RecipeTools.itemPredicateOf(ItemRegistration.SMALL_WET_LEATHER))
                .save(recipeOutput, MedievalismConstants.resource("small_leather"));
    }

    private static void toolRecipes(RecipeOutput recipeOutput)
    {
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.TOOL_HANDLE)
                .requiresIngredient(ItemTagCatalog.BRANCH)
                .requiresTool(ItemTagCatalog.CARVING_TOOL)
                .unlockedBy("has_branch", RecipeTools.itemPredicateOf(
                        ItemRegistration.OAK_BRANCH.get(),
                        ItemRegistration.SPRUCE_BRANCH.get(),
                        ItemRegistration.BIRCH_BRANCH.get(),
                        ItemRegistration.DARK_OAK_BRANCH.get(),
                        ItemRegistration.JUNGLE_BRANCH.get(),
                        ItemRegistration.ACACIA_BRANCH.get(),
                        ItemRegistration.CHERRY_BRANCH.get(),
                        ItemRegistration.MANGROVE_BRANCH.get()
                ))
                .save(recipeOutput, MedievalismConstants.resource("large_tool_handle"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ROCK_KNIFE)
                .requires(ItemRegistration.ROCK_KNIFE_BLADE)
                .requires(ItemTagCatalog.SMALL_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_knife_blade", RecipeTools.itemPredicateOf(ItemRegistration.ROCK_KNIFE_BLADE))
                .save(recipeOutput, MedievalismConstants.resource("rock_knife"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.FLINT_KNIFE)
                .requires(ItemRegistration.FLINT_KNIFE_BLADE)
                .requires(ItemTagCatalog.SMALL_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_flint_knife_blade", RecipeTools.itemPredicateOf(ItemRegistration.FLINT_KNIFE_BLADE))
                .save(recipeOutput, MedievalismConstants.resource("flint_knife"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.BONE_KNIFE)
                .requires(ItemRegistration.BONE_KNIFE_BLADE)
                .requires(ItemTagCatalog.SMALL_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_bone_knife_blade", RecipeTools.itemPredicateOf(ItemRegistration.BONE_KNIFE_BLADE))
                .save(recipeOutput, MedievalismConstants.resource("bone_knife"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ROCK_AXE)
                .requires(ItemRegistration.ROCK_AXE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_axe_head", RecipeTools.itemPredicateOf(ItemRegistration.ROCK_AXE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_axe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ROCK_PICKAXE)
                .requires(ItemRegistration.ROCK_PICKAXE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_pickaxe_head", RecipeTools.itemPredicateOf(ItemRegistration.ROCK_PICKAXE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_pickaxe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ANTLER_PICKAXE)
                .requires(ItemRegistration.ANTLER_PICKAXE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_antler_pickaxe_head", RecipeTools.itemPredicateOf(ItemRegistration.ANTLER_PICKAXE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("antler_pickaxe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ROCK_HOE)
                .requires(ItemRegistration.ROCK_HOE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_hoe_head", RecipeTools.itemPredicateOf(ItemRegistration.ROCK_HOE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_hoe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ANTLER_HOE)
                .requires(ItemRegistration.ANTLER_HOE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_antler_hoe_head", RecipeTools.itemPredicateOf(ItemRegistration.ANTLER_HOE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("antler_hoe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ROCK_SPEAR)
                .requires(ItemRegistration.ROCK_SPEAR_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_spear_head", RecipeTools.itemPredicateOf(ItemRegistration.ROCK_SPEAR_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_spear"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ItemRegistration.ROCK_SICKLE)
                .requires(ItemRegistration.LUNATE)
                .requires(ItemRegistration.LUNATE)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_large_tool_handle", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_TOOL_HANDLE))
                .save(recipeOutput, MedievalismConstants.resource("rock_sickle"));
    }
}
