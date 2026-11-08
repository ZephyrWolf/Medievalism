package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.item.CookingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.FarmingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

// TODO Balance experience and cooking times
public final class BaseSmokingRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        foodRecipes(recipeOutput);
    }

    private static void foodRecipes(RecipeOutput recipeOutput) {
        // Baked Yam
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(FarmingItemRegistration.YAM),
                        RecipeCategory.FOOD, CookingItemRegistration.BAKED_YAM,
                        0.0f, 50)
                .unlockedBy("has_yam", RecipeTools.itemPredicateOf(FarmingItemRegistration.YAM))
                .save(recipeOutput, MedievalismConstants.resource("baked_yam_smoking"));
        // Baked Beetroot
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD, CookingItemRegistration.BAKED_BEETROOT,
                        0.0f, 50)
                .unlockedBy("has_beetroot", RecipeTools.itemPredicateOf(Items.BEETROOT))
                .save(recipeOutput, MedievalismConstants.resource("baked_beetroot_smoking"));
        // Baked Carrot
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD, CookingItemRegistration.BAKED_CARROT,
                        0.0f, 50)
                .unlockedBy("has_carrot", RecipeTools.itemPredicateOf(Items.CARROT))
                .save(recipeOutput, MedievalismConstants.resource("baked_carrot_smoking"));
        // Bread
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(CookingItemRegistration.DOUGH),
                        RecipeCategory.FOOD, Items.BREAD,
                        0.0f, 50)
                .unlockedBy("has_dough", RecipeTools.itemPredicateOf(CookingItemRegistration.DOUGH))
                .save(recipeOutput, MedievalismConstants.resource("bread_smoking"));
    }
}
