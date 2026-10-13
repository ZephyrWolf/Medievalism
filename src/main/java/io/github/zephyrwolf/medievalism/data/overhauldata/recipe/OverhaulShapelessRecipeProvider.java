package io.github.zephyrwolf.medievalism.data.overhauldata.recipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.RecipeOutput;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class OverhaulShapelessRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        survivalRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
    }
}
