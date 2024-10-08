package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

// TODO Balance experience and cooking times
public final class BaseCampfireRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        survivalRecipes(recipeOutput);
        foodRecipes(recipeOutput);
        limeRecipes(recipeOutput);
        tempPotteryRecipes(recipeOutput); // TODO TEMP
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
        // Torches
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.STICK),
                        RecipeCategory.MISC, Items.TORCH,
                        0.0f, 100)
                .unlockedBy("has_stick", RecipeTools.itemPredicateOf(Items.STICK))
                .save(recipeOutput, MedievalismConstants.resource("stick_campfire"));
    }

    private static void foodRecipes(RecipeOutput recipeOutput) {
        // Baked Yam
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.YAM),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_YAM,
                        0.0f, 100)
                .unlockedBy("has_yam", RecipeTools.itemPredicateOf(ItemRegistration.YAM))
                .save(recipeOutput, MedievalismConstants.resource("baked_yam_campfire"));
        // Baked Beetroot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_BEETROOT,
                        0.0f, 100)
                .unlockedBy("has_beetroot", RecipeTools.itemPredicateOf(Items.BEETROOT))
                .save(recipeOutput, MedievalismConstants.resource("baked_beetroot_campfire"));
        // Baked Carrot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_CARROT,
                        0.0f, 100)
                .unlockedBy("has_carrot", RecipeTools.itemPredicateOf(Items.CARROT))
                .save(recipeOutput, MedievalismConstants.resource("baked_carrot_campfire"));
        // Bread
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.DOUGH),
                        RecipeCategory.FOOD, Items.BREAD,
                        0.0f, 100)
                .unlockedBy("has_dough", RecipeTools.itemPredicateOf(ItemRegistration.DOUGH))
                .save(recipeOutput, MedievalismConstants.resource("bread_campfire"));
    }

    private static void limeRecipes(RecipeOutput recipeOutput) {
        // Quicklime
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.LIMESTONE_ROCK),
                        RecipeCategory.MISC, ItemRegistration.QUICK_LIME,
                        0.0f, 1000)
                .unlockedBy("has_limestone_rock", RecipeTools.itemPredicateOf(ItemRegistration.LIMESTONE_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("quicklime_campfire"));
    }

    private static void tempPotteryRecipes(RecipeOutput recipeOutput) {
        // Jug
        /*
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_JUG),
                        RecipeCategory.MISC, ItemRegistration.JUG,
                        0.0f, 100)
                .unlockedBy("has_unfired_jug", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_JUG))
                .save(recipeOutput, MedievalismConstants.resource("jug_campfire"));
         */
        // Clay Crucible
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_CLAY_CRUCIBLE),
                        RecipeCategory.MISC, ItemRegistration.CLAY_CRUCIBLE,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("clay_crucible_campfire"));

        // --

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BlockRegistration.DRYING_GATHERERS_JAR),
                        RecipeCategory.MISC, BlockRegistration.GATHERERS_JAR,
                        1.0f, 100)
                .unlockedBy("has_unfired_gatherers_jar", RecipeTools.itemPredicateOf(BlockRegistration.DRYING_GATHERERS_JAR))
                .save(recipeOutput, MedievalismConstants.resource("gatherers_jar_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BlockRegistration.DRYING_KEEPERS_CROCK),
                        RecipeCategory.MISC, BlockRegistration.KEEPERS_CROCK,
                        1.0f, 100)
                .unlockedBy("has_unfired_keepers_crock", RecipeTools.itemPredicateOf(BlockRegistration.DRYING_KEEPERS_CROCK))
                .save(recipeOutput, MedievalismConstants.resource("keepers_crock_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BlockRegistration.DRYING_SETTLERS_POT),
                        RecipeCategory.MISC, BlockRegistration.SETTLERS_POT,
                        1.0f, 100)
                .unlockedBy("has_unfired_settlers_pot", RecipeTools.itemPredicateOf(BlockRegistration.DRYING_SETTLERS_POT))
                .save(recipeOutput, MedievalismConstants.resource("settlers_pot_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BlockRegistration.DRYING_CLAY_COOKING_POT),
                        RecipeCategory.MISC, BlockRegistration.CLAY_COOKING_POT,
                        1.0f, 100)
                .unlockedBy("has_unfired_clay_cooking_pot", RecipeTools.itemPredicateOf(BlockRegistration.DRYING_CLAY_COOKING_POT))
                .save(recipeOutput, MedievalismConstants.resource("clay_cooking_pot_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BlockRegistration.DRYING_CLAY_CAULDRON),
                        RecipeCategory.MISC, BlockRegistration.CLAY_CAULDRON,
                        1.0f, 100)
                .unlockedBy("has_unfired_clay_cauldron", RecipeTools.itemPredicateOf(BlockRegistration.DRYING_CLAY_CAULDRON))
                .save(recipeOutput, MedievalismConstants.resource("clay_cauldron_campfire"));

        // Pot
        /*
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_POT),
                        RecipeCategory.MISC, ItemRegistration.POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_POT))
                .save(recipeOutput, MedievalismConstants.resource("pot_campfire"));
        // Large Pot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_LARGE_POT),
                        RecipeCategory.MISC, ItemRegistration.LARGE_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_LARGE_POT))
                .save(recipeOutput, MedievalismConstants.resource("large_pot_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_LARGE_POT),
                        RecipeCategory.MISC, ItemRegistration.LARGE_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_LARGE_POT))
                .save(recipeOutput, MedievalismConstants.resource("large_pot_campfire"));

        // Flower Pot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_FLOWER_POT),
                        RecipeCategory.MISC, Items.FLOWER_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_FLOWER_POT))
                .save(recipeOutput, MedievalismConstants.resource("flower_pot_campfire"));
        // Decorated Pot // TODO This is only basic and not the decorated ones
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_DECORATED_POT),
                        RecipeCategory.MISC, Items.DECORATED_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_decorated_pot", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_DECORATED_POT))
                .save(recipeOutput, MedievalismConstants.resource("decorated_pot_campfire"));
        // Birch Pot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_BIRCH_POT),
                        RecipeCategory.MISC, BlockRegistration.BIRCH_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_BIRCH_POT))
                .save(recipeOutput, MedievalismConstants.resource("birch_pot_campfire"));
        */
        // Brick
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemRegistration.UNFIRED_BRICK),
                        RecipeCategory.MISC, Items.BRICK,
                        0.0f, 100)
                .unlockedBy("has_unfired_brick", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("brick_campfire"));
    }
}
