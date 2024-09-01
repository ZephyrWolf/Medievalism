package io.github.zephyrwolf.medievalism.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class OverhaulRecipeProvider extends RecipeProvider
{

    public OverhaulRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {

    }
}
