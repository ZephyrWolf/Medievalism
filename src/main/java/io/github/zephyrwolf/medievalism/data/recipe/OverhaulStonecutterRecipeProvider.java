package io.github.zephyrwolf.medievalism.data.recipe;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class OverhaulStonecutterRecipeProvider
{
    protected static void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        // Vanilla
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.DEEPSLATE), RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE);
        // This is temp until I can refix all the shitty recipes for deepslate that make no sense
    }
}
