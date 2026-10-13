package io.github.zephyrwolf.medievalism.data.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.KnapInhandRecipeBuilder;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;

public final class BaseKnapInhandRecipeProvider
{
    public static void buildRecipes(RecipeOutput recipeOutput) {
        inhandKnapRecipes(recipeOutput);
    }

    private static void inhandKnapRecipes(RecipeOutput recipeOutput)
    {
        KnapInhandRecipeBuilder.knapInhand(ItemRegistration.BIFACE)
                .ingredient(Ingredient.of(ItemTagCatalog.HARD_ROCK))
                .unlockedBy("has_hard_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.HARD_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("biface_inhand_knap"));

        KnapInhandRecipeBuilder.knapInhand(ItemRegistration.LUNATE, 2)
                .ingredient(Ingredient.of(ItemRegistration.BIFACE))
                .unlockedBy("has_biface", RecipeTools.itemPredicateOf(ItemRegistration.BIFACE))
                .save(recipeOutput, MedievalismConstants.resource("lunate_inhand_knap"));

        KnapInhandRecipeBuilder.knapInhand(BlockRegistration.STONE_BENCH)
                .ingredient(Ingredient.of(ItemTagCatalog.LARGE_HARD_ROCK))
                .unlockedBy("has_large_hard_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_HARD_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("stone_bench_inhand_knap"));
    }
}
