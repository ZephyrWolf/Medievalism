package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

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
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
        // Stick
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 2)
                .requires(ItemTagCatalog.BRANCH)
                .unlockedBy("has_branch", RecipeTools.itemPredicateOf(ItemTagCatalog.BRANCH))
                .save(recipeOutput, MedievalismConstants.resource("sticks_from_branch"));
        // Thatch
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.THATCH, 4)
                .requires(BlockRegistration.THATCH_BLOCK_ITEM)
                .unlockedBy("has_thatch_block", RecipeTools.itemPredicateOf(BlockRegistration.THATCH_BLOCK_ITEM))
                .save(recipeOutput, MedievalismConstants.resource("thatch_from_block"));
        // Hammerstone, does this belong here?
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.HAMMERSTONE)
                .requires(ItemTagCatalog.HARD_ROCK)
                .unlockedBy("has_hard_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.HARD_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("hammerstone"));
        // Lunate
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LUNATE)
                .requires(ItemTagCatalog.HAMMER)
                .requires(ItemTagCatalog.HARD_ROCK)
                .unlockedBy("has_hammer", RecipeTools.itemPredicateOf(ItemTagCatalog.HAMMER))
                .save(recipeOutput, MedievalismConstants.resource("lunate"));
        // Fire Starter
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.FIRE_STARTER)
                .requires(Items.STICK)
                .requires(Items.STICK)
                .requires(ItemTagCatalog.KNIFE)
                .unlockedBy("has_knife", RecipeTools.itemPredicateOf(ItemTagCatalog.KNIFE))
                .save(recipeOutput, MedievalismConstants.resource("fire_starter"));
        // Digging Stick TODO Temp recipe, make handle and then sharpen handle?
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DIGGING_STICK)
                .requires(ItemTagCatalog.BRANCH)
                .requires(ItemTagCatalog.KNIFE)
                .unlockedBy("has_knife", RecipeTools.itemPredicateOf(ItemTagCatalog.KNIFE))
                .save(recipeOutput, MedievalismConstants.resource("digging_stick"));
    }

    private static void potteryRecipes(RecipeOutput recipeOutput) {
        // Unfired Brick
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.UNFIRED_BRICK)
                .requires(ItemTagCatalog.CLAY_BALL)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ItemTagCatalog.CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("unfired_brick"));
        // Birch Pot
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
    }

    private static void foodRecipes(RecipeOutput recipeOutput) {
        // Cracked Grain
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.CRACKED_WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_wheat", RecipeTools.itemPredicateOf(Items.WHEAT))
                .save(recipeOutput, MedievalismConstants.resource("cracked_wheat_shapeless"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.CRACKED_BARLEY)
                .requires(ItemRegistration.BARLEY)
                .requires(ItemRegistration.BARLEY)
                .requires(ItemRegistration.BARLEY)
                .requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_barley", RecipeTools.itemPredicateOf(ItemRegistration.BARLEY))
                .save(recipeOutput, MedievalismConstants.resource("cracked_barley_shapeless"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.ROLLED_OATS)
                .requires(ItemRegistration.OATS)
                .requires(ItemRegistration.OATS)
                .requires(ItemRegistration.OATS)
                .requires(ItemTagCatalog.HAMMER)
                .unlockedBy("has_oat", RecipeTools.itemPredicateOf(ItemRegistration.OATS))
                .save(recipeOutput, MedievalismConstants.resource("rolled_oats_shapeless"));
        // TODO Should I have different types of flour and bread?
        // Flour
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.FLOUR)
                .requires(ItemTagCatalog.CAN_CRAFT_FLOUR)
                .requires(ItemTagCatalog.HAMMER)
                .group("flour")
                .unlockedBy("can_make_flour", RecipeTools.itemPredicateOf(ItemTagCatalog.CAN_CRAFT_FLOUR))
                .save(recipeOutput, MedievalismConstants.resource("flour"));
        // Dough
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.DOUGH)
                .requires(ItemRegistration.FLOUR)
                .group("dough")
                .unlockedBy("has_flour", RecipeTools.itemPredicateOf(ItemRegistration.FLOUR))
                .save(recipeOutput, MedievalismConstants.resource("dough"));
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
}
