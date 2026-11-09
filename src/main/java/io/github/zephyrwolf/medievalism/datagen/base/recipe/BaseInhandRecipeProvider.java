package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipeIngredientMaterialType;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.KnappingItemRegistration;
import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import io.github.zephyrwolf.medievalism.registration.item.WeavingItemRegistration;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;

public final class BaseInhandRecipeProvider
{
    public static void buildRecipes(RecipeOutput recipeOutput) {
        inhandKnapRecipes(recipeOutput);
    }

    private static void inhandKnapRecipes(RecipeOutput recipeOutput)
    {
        InhandRecipeBuilder.inhand(KnappingItemRegistration.LUNATE)
                .tool(Ingredient.of(ItemTagCatalog.ROCK_KNAP_TOOL))
                .materialType(InhandRecipeIngredientMaterialType.HIT_ROCK)
                .ingredient(Ingredient.of(ItemTagCatalog.HARD_ROCK))
                .unlockedBy("has_hard_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.HARD_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("lunate_inhand_hit_rock"));

        InhandRecipeBuilder.inhand(BlockRegistration.STONE_BENCH)
                .tool(Ingredient.of(ItemTagCatalog.ROCK_KNAP_TOOL))
                .materialType(InhandRecipeIngredientMaterialType.HIT_ROCK)
                .ingredient(Ingredient.of(ItemTagCatalog.LARGE_HARD_ROCK))
                .unlockedBy("has_large_hard_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_HARD_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("stone_bench_inhand_hit_rock"));

        InhandRecipeBuilder.inhand(WeavingItemRegistration.SPLIT_SOFT_RUSH)
                .tool(Ingredient.of(ItemTagCatalog.KNAP_TOOL))
                .materialType(InhandRecipeIngredientMaterialType.HIT_ROCK)
                .ingredient(Ingredient.of(BlockRegistration.SOFT_RUSH))
                .unlockedBy("has_soft_rush", RecipeTools.itemPredicateOf(BlockRegistration.SOFT_RUSH))
                .save(recipeOutput, MedievalismConstants.resource("split_soft_rush_inhand_hit_plant"));

        InhandRecipeBuilder.inhand(WeavingItemRegistration.GREEN_BAST_FIBERS)
                .tool(Ingredient.of(ItemTagCatalog.PLANT_CARVING_TOOL))
                .materialType(InhandRecipeIngredientMaterialType.HIT_PLANT)
                .ingredient(Ingredient.of(WeavingItemRegistration.SPLIT_SOFT_RUSH))
                .unlockedBy("has_soft_rush", RecipeTools.itemPredicateOf(BlockRegistration.SOFT_RUSH))
                .save(recipeOutput, MedievalismConstants.resource("green_bast_fibers_inhand_scrape_plant"));
    }
}
