package io.github.zephyrwolf.medievalism.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BaseRecipeProvider extends RecipeProvider
{

    public BaseRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        BaseShapelessRecipeProvider.buildRecipes(recipeOutput);
        BaseShapedRecipeProvider.buildRecipes(recipeOutput);
        BaseCampfireRecipeProvider.buildRecipes(recipeOutput);
        BaseSmokingRecipeProvider.buildRecipes(recipeOutput);
        BaseSmeltingRecipeProvider.buildRecipes(recipeOutput); // TODO Review once mod is futher developed
        BaseInWorldRecipeProvider.buildRecipes(recipeOutput);
        BaseAdditionalToolUseRecipeProvider.buildRecipes(recipeOutput);
        BaseMalleableRecipeProvider.buildRecipes(recipeOutput);
    }
}
