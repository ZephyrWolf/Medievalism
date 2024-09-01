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
public final class BaseSmokingRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        foodRecipes(recipeOutput);
    }

    private static void foodRecipes(RecipeOutput recipeOutput) {
        // Baked Yam
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ItemRegistration.YAM),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_YAM,
                        0.0f, 50)
                .unlockedBy("has_yam", RecipeTools.itemPredicateOf(ItemRegistration.YAM))
                .save(recipeOutput, MedievalismConstants.resource("baked_yam_smoking"));
        // Baked Beetroot
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_BEETROOT,
                        0.0f, 50)
                .unlockedBy("has_beetroot", RecipeTools.itemPredicateOf(Items.BEETROOT))
                .save(recipeOutput, MedievalismConstants.resource("baked_beetroot_smoking"));
        // Baked Carrot
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD, ItemRegistration.BAKED_CARROT,
                        0.0f, 50)
                .unlockedBy("has_carrot", RecipeTools.itemPredicateOf(Items.CARROT))
                .save(recipeOutput, MedievalismConstants.resource("baked_carrot_smoking"));
        // Bread
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ItemRegistration.DOUGH),
                        RecipeCategory.FOOD, Items.BREAD,
                        0.0f, 50)
                .unlockedBy("has_dough", RecipeTools.itemPredicateOf(ItemRegistration.DOUGH))
                .save(recipeOutput, MedievalismConstants.resource("bread_smoking"));
    }
}
