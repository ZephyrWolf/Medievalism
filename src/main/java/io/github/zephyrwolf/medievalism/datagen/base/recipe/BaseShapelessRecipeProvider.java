package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.crafting.ShapelessToolRecipeBuilder;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.*;
import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
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
        weavingRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
        // Thatch
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingItemRegistration.THATCH, 4)
                .requires(FarmingItemRegistration.THATCH_BLOCK)
                .unlockedBy("has_thatch_block", RecipeTools.itemPredicateOf(FarmingItemRegistration.THATCH_BLOCK))
                .save(recipeOutput, MedievalismConstants.resource("thatch_from_block"));
        // Mud Ball
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MudWorkingItemRegistration.DIRT_CHUNK, 2)
                .requires(Blocks.DIRT)
                .group("dirt_chunk")
                .unlockedBy("has_dirt", RecipeTools.itemPredicateOf(Blocks.DIRT))
                .save(recipeOutput, MedievalismConstants.resource("dirt_chunk_from_dirt"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MudWorkingItemRegistration.MUD_BALL, 4)
                .requires(Blocks.MUD)
                .group("mud_ball")
                .unlockedBy("has_mud", RecipeTools.itemPredicateOf(Blocks.MUD))
                .save(recipeOutput, MedievalismConstants.resource("mud_balls_from_mud"));
        // Fire Starter
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WoodWorkingItemRegistration.FIRE_STARTER)
                .requires(Items.STICK)
                .requires(Items.STICK)
                .requires(ItemTagCatalog.BONE_CARVING_TOOL)
                .unlockedBy("has_knife", RecipeTools.itemPredicateOf(ItemTagCatalog.BONE_CARVING_TOOL))
                .save(recipeOutput, MedievalismConstants.resource("fire_starter"));
        // Digging Stick TODO Temp recipe, make handle and then sharpen handle?
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.MISC, WoodWorkingItemRegistration.DIGGING_STICK)
                .requiresIngredient(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requiresTool(ItemTagCatalog.BONE_CARVING_TOOL)
                .unlockedBy("has_knife", RecipeTools.itemPredicateOf(ItemTagCatalog.BONE_CARVING_TOOL))
                .save(recipeOutput, MedievalismConstants.resource("digging_stick"));
    }

    private static void potteryRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MudWorkingItemRegistration.WET_DAUB, 2)
                .requires(ItemTagCatalog.CLAY_BALL)
                .requires(MudWorkingItemRegistration.MUD_BALL)
                .requires(FarmingItemRegistration.THATCH)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ItemTagCatalog.CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("wet_daub"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.CLAY_BALL, 4)
                .requires(BlockRegistration.CLAY)
                .unlockedBy("has_clay", RecipeTools.itemPredicateOf(BlockRegistration.CLAY))
                .save(recipeOutput, MedievalismConstants.resource("clay_balls_from_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.POTTERS_CLAY_BALL, 4)
                .requires(BlockRegistration.POTTERS_CLAY)
                .unlockedBy("has_potters_clay", RecipeTools.itemPredicateOf(BlockRegistration.POTTERS_CLAY))
                .save(recipeOutput, MedievalismConstants.resource("potters_clay_balls_from_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.KAOLIN_CLAY_BALL, 4)
                .requires(BlockRegistration.KAOLIN_CLAY)
                .unlockedBy("has_kaolin_clay", RecipeTools.itemPredicateOf(BlockRegistration.KAOLIN_CLAY))
                .save(recipeOutput, MedievalismConstants.resource("kaolin_clay_balls_from_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.CHINA_CLAY_BALL, 4)
                .requires(BlockRegistration.CHINA_CLAY)
                .unlockedBy("has_china_clay", RecipeTools.itemPredicateOf(BlockRegistration.CHINA_CLAY))
                .save(recipeOutput, MedievalismConstants.resource("china_clay_balls_from_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL, 4)
                .requires(BlockRegistration.REFRACTORY_CLAY)
                .unlockedBy("has_refractory_clay", RecipeTools.itemPredicateOf(BlockRegistration.REFRACTORY_CLAY))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_balls_from_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MudWorkingItemRegistration.DRYING_PACKED_MUD_BRICK)
                .requires(MudWorkingItemRegistration.MUD_BALL)
                .requires(FarmingItemRegistration.THATCH)
                .unlockedBy("has_thatch", RecipeTools.itemPredicateOf(FarmingItemRegistration.THATCH))
                .save(recipeOutput, MedievalismConstants.resource("drying_mud_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MudWorkingItemRegistration.DRYING_DAUB_BRICK)
                .requires(MudWorkingItemRegistration.WET_DAUB)
                .unlockedBy("has_wet_daub", RecipeTools.itemPredicateOf(MudWorkingItemRegistration.WET_DAUB))
                .save(recipeOutput, MedievalismConstants.resource("drying_daub_brick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.POTTERS_CLAY_BALL, 2)
                .requires(ClayWorkingItemRegistration.GROG)
                .requires(Items.CLAY_BALL)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_grog", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.GROG))
                .save(recipeOutput, MedievalismConstants.resource("potters_clay_ball"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.CHINA_CLAY_BALL, 2)
                .requires(ClayWorkingItemRegistration.KAOLIN_GROG)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .unlockedBy("has_kaolin_grog", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.KAOLIN_GROG))
                .save(recipeOutput, MedievalismConstants.resource("china_clay_ball"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL, 2)
                .requires(ItemTags.SAND)
                .requires(ClayWorkingItemRegistration.KAOLIN_GROG)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .unlockedBy("has_kaolin_grog", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.KAOLIN_GROG))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_ball"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL, 2)
                .requires(ClayWorkingItemRegistration.REFRACTORY_GROG)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .requires(ItemTags.SAND)
                .unlockedBy("has_kaolin_grog", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.KAOLIN_GROG))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_ball2"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL, 2)
                .requires(ClayWorkingItemRegistration.CHINA_CLAY_BALL)
                .requires(ClayWorkingItemRegistration.CHINA_CLAY_BALL)
                .requires(ItemTags.SAND)
                .unlockedBy("has_china_call_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CHINA_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_ball3"));

        // Unfired Brick
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ItemTagCatalog.CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.POTTERS_CLAY_BALL)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_potters_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .unlockedBy("has_kaolin_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_kaolin_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_CHINA_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.CHINA_CLAY_BALL)
                .unlockedBy("has_china_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CHINA_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_china_clay_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL)
                .unlockedBy("has_refractory_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("drying_refractory_clay_brick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_CLAY_DOUBLE_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .unlockedBy("has_wet_clay_brick", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.DRYING_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_clay_double_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .unlockedBy("has_wet_potters_clay_brick", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_potters_clay_double_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK)
                .unlockedBy("has_wet_kaolin_clay_brick", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("drying_kaolin_clay_double_brick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK)
                .requires(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK)
                .unlockedBy("has_wet_refractory_clay_brick", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK))
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.CRACKED_WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                //.requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_wheat", RecipeTools.itemPredicateOf(Items.WHEAT))
                .save(recipeOutput, MedievalismConstants.resource("cracked_wheat_shapeless"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.CRACKED_BARLEY)
                .requires(FarmingItemRegistration.BARLEY)
                .requires(FarmingItemRegistration.BARLEY)
                .requires(FarmingItemRegistration.BARLEY)
                //.requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_barley", RecipeTools.itemPredicateOf(FarmingItemRegistration.BARLEY))
                .save(recipeOutput, MedievalismConstants.resource("cracked_barley_shapeless"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.ROLLED_OATS)
                .requires(FarmingItemRegistration.OATS)
                .requires(FarmingItemRegistration.OATS)
                .requires(FarmingItemRegistration.OATS)
                //.requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_oat", RecipeTools.itemPredicateOf(FarmingItemRegistration.OATS))
                .save(recipeOutput, MedievalismConstants.resource("rolled_oats_shapeless"));
        // TODO Should I have different types of flour and bread?
        // Flour
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.FLOUR)
                .requires(ItemTagCatalog.CAN_CRAFT_FLOUR)
                //.requires(ItemTagCatalog.HAMMER)
                .group("flour")
                .unlockedBy("can_make_flour", RecipeTools.itemPredicateOf(ItemTagCatalog.CAN_CRAFT_FLOUR))
                .save(recipeOutput, MedievalismConstants.resource("flour"));
        // Dough
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.DOUGH)
                .requires(CookingItemRegistration.FLOUR)
                .group("dough")
                .unlockedBy("has_flour", RecipeTools.itemPredicateOf(CookingItemRegistration.FLOUR))
                .save(recipeOutput, MedievalismConstants.resource("dough"));

        // TODO These should have a knife as a tool
        // TODO Replace melon recipe with this format
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.PUMPKIN_SLICE, 9)
                .requires(Items.PUMPKIN)
                .group("pumpkin_slice")
                .unlockedBy("hasPumpkin", RecipeTools.itemPredicateOf(Items.PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("pumpkin_slice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.GREEN_PUMPKIN_SLICE, 9)
                .requires(FarmingItemRegistration.GREEN_PUMPKIN)
                .group("green_pumpkin_slice")
                .unlockedBy("hasGreenPumpkin", RecipeTools.itemPredicateOf(FarmingItemRegistration.GREEN_PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("green_pumpkin_slice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.BAKED_PUMPKIN_SLICE, 9)
                .requires(CookingItemRegistration.BAKED_PUMPKIN)
                .group("baked_pumpkin_slice")
                .unlockedBy("hasBakedPumpkin", RecipeTools.itemPredicateOf(CookingItemRegistration.BAKED_PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("baked_pumpkin_slice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CookingItemRegistration.BAKED_GREEN_PUMPKIN_SLICE, 9)
                .requires(CookingItemRegistration.BAKED_GREEN_PUMPKIN)
                .group("baked_green_pumpkin_slice")
                .unlockedBy("hasBakedGreenPumpkin", RecipeTools.itemPredicateOf(CookingItemRegistration.BAKED_GREEN_PUMPKIN))
                .save(recipeOutput, MedievalismConstants.resource("baked_green_pumpkin_slice"));
    }

    private static void cordageRecipes(RecipeOutput recipeOutput) {
        // TODO This is a temp. Will need to soak flax to obtain their fibers
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WeavingItemRegistration.FLAX_FIBER)
                .requires(FarmingItemRegistration.FLAX)
                .unlockedBy("has_flax", RecipeTools.itemPredicateOf(FarmingItemRegistration.FLAX))
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.LARGE_LIMED_HIDE)
                .requires(ItemTagCatalog.LARGE_HIDE)
                .unlockedBy("has_large_hide", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("large_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.MEDIUM_LIMED_HIDE)
                .requires(ItemTagCatalog.MEDIUM_HIDE)
                .unlockedBy("has_medium_hide", RecipeTools.itemPredicateOf(ItemTagCatalog.MEDIUM_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("medium_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.SMALL_LIMED_HIDE)
                .requires(ItemTagCatalog.SMALL_HIDE)
                .unlockedBy("has_small_hide", RecipeTools.itemPredicateOf(ItemTagCatalog.SMALL_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("small_limed_hide"));
        // Raw Hide / Scraped Hide
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.LARGE_RAW_HIDE)
                .requires(LeatherWorkingItemRegistration.LARGE_LIMED_HIDE)
                .unlockedBy("has_large_limed_hide", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.LARGE_LIMED_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("large_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.MEDIUM_RAW_HIDE)
                .requires(LeatherWorkingItemRegistration.MEDIUM_LIMED_HIDE)
                .unlockedBy("has_medium_limed_hide", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.MEDIUM_LIMED_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("medium_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.SMALL_RAW_HIDE)
                .requires(LeatherWorkingItemRegistration.SMALL_LIMED_HIDE)
                .unlockedBy("has_small_limed_hide", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.SMALL_LIMED_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("small_raw_hide"));
        // Soaked Hide
        // TODO
        // Wet Leather
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.LARGE_WET_LEATHER)
                .requires(LeatherWorkingItemRegistration.LARGE_RAW_HIDE)
                .unlockedBy("has_large_raw_hide", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.LARGE_RAW_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("large_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.MEDIUM_WET_LEATHER)
                .requires(LeatherWorkingItemRegistration.MEDIUM_RAW_HIDE)
                .unlockedBy("has_medium_raw_hide", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.MEDIUM_RAW_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("medium_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.SMALL_WET_LEATHER)
                .requires(LeatherWorkingItemRegistration.SMALL_RAW_HIDE)
                .unlockedBy("has_small_raw_hide", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.SMALL_RAW_HIDE))
                .save(recipeOutput, MedievalismConstants.resource("small_wet_leather"));
        // Leather
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(LeatherWorkingItemRegistration.LARGE_WET_LEATHER)
                .unlockedBy("has_large_wet_leather", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.LARGE_WET_LEATHER))
                .save(recipeOutput, MedievalismConstants.resource("large_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.MEDIUM_LEATHER)
                .requires(LeatherWorkingItemRegistration.MEDIUM_WET_LEATHER)
                .unlockedBy("has_medium_wet_leather", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.MEDIUM_WET_LEATHER))
                .save(recipeOutput, MedievalismConstants.resource("medium_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LeatherWorkingItemRegistration.SMALL_LEATHER)
                .requires(LeatherWorkingItemRegistration.SMALL_WET_LEATHER)
                .unlockedBy("has_small_wet_leather", RecipeTools.itemPredicateOf(LeatherWorkingItemRegistration.SMALL_WET_LEATHER))
                .save(recipeOutput, MedievalismConstants.resource("small_leather"));
    }

    private static void toolRecipes(RecipeOutput recipeOutput)
    {
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, WoodWorkingItemRegistration.TOOL_HANDLE)
                .requiresIngredient(ItemTagCatalog.BRANCH)
                .requiresTool(ItemTagCatalog.BONE_CARVING_TOOL)
                .unlockedBy("has_branch", RecipeTools.itemPredicateOf(
                        WorldItemRegistration.OAK_BRANCH.get(),
                        WorldItemRegistration.SPRUCE_BRANCH.get(),
                        WorldItemRegistration.BIRCH_BRANCH.get(),
                        WorldItemRegistration.DARK_OAK_BRANCH.get(),
                        WorldItemRegistration.JUNGLE_BRANCH.get(),
                        WorldItemRegistration.ACACIA_BRANCH.get(),
                        WorldItemRegistration.CHERRY_BRANCH.get(),
                        WorldItemRegistration.MANGROVE_BRANCH.get()
                ))
                .save(recipeOutput, MedievalismConstants.resource("large_tool_handle"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ROCK_KNIFE)
                .requires(KnappingItemRegistration.ROCK_KNIFE_BLADE)
                .requires(ItemTagCatalog.SMALL_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_knife_blade", RecipeTools.itemPredicateOf(KnappingItemRegistration.ROCK_KNIFE_BLADE))
                .save(recipeOutput, MedievalismConstants.resource("rock_knife"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.FLINT_KNIFE)
                .requires(KnappingItemRegistration.FLINT_KNIFE_BLADE)
                .requires(ItemTagCatalog.SMALL_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_flint_knife_blade", RecipeTools.itemPredicateOf(KnappingItemRegistration.FLINT_KNIFE_BLADE))
                .save(recipeOutput, MedievalismConstants.resource("flint_knife"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.BONE_KNIFE)
                .requires(KnappingItemRegistration.BONE_KNIFE_BLADE)
                .requires(ItemTagCatalog.SMALL_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_bone_knife_blade", RecipeTools.itemPredicateOf(KnappingItemRegistration.BONE_KNIFE_BLADE))
                .save(recipeOutput, MedievalismConstants.resource("bone_knife"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ROCK_AXE)
                .requires(KnappingItemRegistration.ROCK_AXE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_axe_head", RecipeTools.itemPredicateOf(KnappingItemRegistration.ROCK_AXE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_axe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ROCK_PICKAXE)
                .requires(KnappingItemRegistration.ROCK_PICKAXE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_pickaxe_head", RecipeTools.itemPredicateOf(KnappingItemRegistration.ROCK_PICKAXE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_pickaxe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ANTLER_PICKAXE)
                .requires(KnappingItemRegistration.ANTLER_PICKAXE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_antler_pickaxe_head", RecipeTools.itemPredicateOf(KnappingItemRegistration.ANTLER_PICKAXE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("antler_pickaxe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ROCK_HOE)
                .requires(KnappingItemRegistration.ROCK_HOE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_hoe_head", RecipeTools.itemPredicateOf(KnappingItemRegistration.ROCK_HOE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_hoe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ANTLER_HOE)
                .requires(KnappingItemRegistration.ANTLER_HOE_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_antler_hoe_head", RecipeTools.itemPredicateOf(KnappingItemRegistration.ANTLER_HOE_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("antler_hoe"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ROCK_SPEAR)
                .requires(KnappingItemRegistration.ROCK_SPEAR_HEAD)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_rock_spear_head", RecipeTools.itemPredicateOf(KnappingItemRegistration.ROCK_SPEAR_HEAD))
                .save(recipeOutput, MedievalismConstants.resource("rock_spear"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, KnappingItemRegistration.ROCK_SICKLE)
                .requires(KnappingItemRegistration.LUNATE)
                .requires(KnappingItemRegistration.LUNATE)
                .requires(ItemTagCatalog.LARGE_TOOL_HANDLE)
                .requires(ItemTagCatalog.TOOL_BINDING)
                .unlockedBy("has_large_tool_handle", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_TOOL_HANDLE))
                .save(recipeOutput, MedievalismConstants.resource("rock_sickle"));
    }

    private static void weavingRecipes(RecipeOutput recipeOutput)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WeavingItemRegistration.PRIMITIVE_CORDAGE)
                .requires(WeavingItemRegistration.SPLIT_SOFT_RUSH)
                .requires(WeavingItemRegistration.SPLIT_SOFT_RUSH)
                .unlockedBy("has_split_soft_rush", RecipeTools.itemPredicateOf(WeavingItemRegistration.SPLIT_SOFT_RUSH))
                .save(recipeOutput, MedievalismConstants.resource("primitive_cordage_from_split_soft_rush"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WeavingItemRegistration.DRY_BAST_FIBERS)
                .requires(WeavingItemRegistration.GREEN_BAST_FIBERS)
                .unlockedBy("has_green_bast_fibers", RecipeTools.itemPredicateOf(WeavingItemRegistration.GREEN_BAST_FIBERS))
                .save(recipeOutput, MedievalismConstants.resource("dry_bast_fibers"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WeavingItemRegistration.BAST_CORDAGE)
                .requires(WeavingItemRegistration.DRY_BAST_FIBERS)
                .requires(WeavingItemRegistration.DRY_BAST_FIBERS)
                .unlockedBy("has_dry_bast_fibers", RecipeTools.itemPredicateOf(WeavingItemRegistration.DRY_BAST_FIBERS))
                .save(recipeOutput, MedievalismConstants.resource("bast_cordage"));
    }
}
