package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

// TODO Balance experience and cooking times
public final class BaseSmeltingRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        foodRecipes(recipeOutput);
        limeRecipes(recipeOutput);
        potteryRecipes(recipeOutput);
    }

    private static void foodRecipes(RecipeOutput recipeOutput) {
        // Baked Yam
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.YAM),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_YAM,
                        0.0f, 100)
                .unlockedBy("has_yam", RecipeTools.itemPredicateOf(ItemRegistration.YAM))
                .save(recipeOutput, MedievalismConstants.resource("baked_yam_smelting"));
        // Baked Beetroot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_BEETROOT,
                        0.0f, 100)
                .unlockedBy("has_beetroot", RecipeTools.itemPredicateOf(Items.BEETROOT))
                .save(recipeOutput, MedievalismConstants.resource("baked_beetroot_smelting"));
        // Baked Carrot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_CARROT,
                        0.0f, 100)
                .unlockedBy("has_carrot", RecipeTools.itemPredicateOf(Items.CARROT))
                .save(recipeOutput, MedievalismConstants.resource("baked_carrot_smelting"));
        // Bread
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.DOUGH),
                        RecipeCategory.FOOD, Items.BREAD,
                        0.0f, 100)
                .unlockedBy("has_dough", RecipeTools.itemPredicateOf(ItemRegistration.DOUGH))
                .save(recipeOutput, MedievalismConstants.resource("bread_smelting"));
    }

    private static void limeRecipes(RecipeOutput recipeOutput) {
        // Quicklime
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistration.LIMESTONE_ROCK_ITEM),
                        RecipeCategory.MISC, ItemRegistration.QUICK_LIME,
                        0.0f, 1000)
                .unlockedBy("has_limestone_rock", RecipeTools.itemPredicateOf(BlockRegistration.LIMESTONE_ROCK_ITEM))
                .save(recipeOutput, MedievalismConstants.resource("quicklime_smelting"));
    }

    private static void tempPotteryRecipes(RecipeOutput recipeOutput) {
        // Jug
        /*
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_JUG),
                        RecipeCategory.MISC, ItemRegistration.JUG,
                        0.0f, 100)
                .unlockedBy("has_unfired_jug", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_JUG))
                .save(recipeOutput, MedievalismConstants.resource("jug_smelting"));
        // Clay Crucible
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_CLAY_CRUCIBLE),
                        RecipeCategory.MISC, ItemRegistration.CLAY_CRUCIBLE,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("clay_crucible_smelting"));
        // Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_POT),
                        RecipeCategory.MISC, ItemRegistration.POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("pot_smelting"));
        // Large Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_LARGE_POT),
                        RecipeCategory.MISC, ItemRegistration.LARGE_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("large_pot_smelting"));
        // Flower Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_FLOWER_POT),
                        RecipeCategory.MISC, Items.FLOWER_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("flower_pot_smelting"));
        // Decorated Pot // TODO This is only basic and not the decorated ones
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_DECORATED_POT),
                        RecipeCategory.MISC, Items.DECORATED_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_decorated_pot", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_DECORATED_POT))
                .save(recipeOutput, MedievalismConstants.resource("decorated_pot_smelting"));
        // Birch Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_BIRCH_POT),
                        RecipeCategory.MISC, BlockRegistration.BIRCH_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("birch_pot_smelting"));
        // Brick
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_BRICK),
                        RecipeCategory.MISC, Items.BRICK,
                        0.0f, 100)
                .unlockedBy("has_unfired_brick", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("brick_smelting"));

         */
    }

    private static void potteryRecipes(RecipeOutput recipeOutput)
    {
        // Brick // NOTE Remove in Overhaul
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemTagCatalog.CLAY_BALL),
                        RecipeCategory.MISC, Items.BRICK,
                        0.0f, 100)
                .group("brick")
                .unlockedBy("has_red_clay_ball", RecipeTools.itemPredicateOf(ItemRegistration.RED_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("brick_from_clay_ball_tag"));
    }
}
