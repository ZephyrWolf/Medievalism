package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.item.CookingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.FarmingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import io.github.zephyrwolf.medievalism.registration.item.WorldItemRegistration;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

// TODO Balance experience and cooking times
public final class BaseCampfireRecipeProvider
{
    public static void buildRecipes(RecipeOutput recipeOutput)
    {
        survivalRecipes(recipeOutput);
        foodRecipes(recipeOutput);
        limeRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput)
    {
        // Torches
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.STICK),
                        RecipeCategory.MISC, Items.TORCH,
                        0.0f, 100)
                .unlockedBy("has_stick", RecipeTools.itemPredicateOf(Items.STICK))
                .save(recipeOutput, MedievalismConstants.resource("stick_campfire"));
    }

    private static void foodRecipes(RecipeOutput recipeOutput)
    {
        // Baked Yam
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(FarmingItemRegistration.YAM),
                        RecipeCategory.FOOD, CookingItemRegistration.BAKED_YAM,
                        0.0f, 100)
                .unlockedBy("has_yam", RecipeTools.itemPredicateOf(FarmingItemRegistration.YAM))
                .save(recipeOutput, MedievalismConstants.resource("baked_yam_campfire"));
        // Baked Beetroot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD, CookingItemRegistration.BAKED_BEETROOT,
                        0.0f, 100)
                .unlockedBy("has_beetroot", RecipeTools.itemPredicateOf(Items.BEETROOT))
                .save(recipeOutput, MedievalismConstants.resource("baked_beetroot_campfire"));
        // Baked Carrot
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD, CookingItemRegistration.BAKED_CARROT,
                        0.0f, 100)
                .unlockedBy("has_carrot", RecipeTools.itemPredicateOf(Items.CARROT))
                .save(recipeOutput, MedievalismConstants.resource("baked_carrot_campfire"));
        // Bread
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(CookingItemRegistration.DOUGH),
                        RecipeCategory.FOOD, Items.BREAD,
                        0.0f, 100)
                .unlockedBy("has_dough", RecipeTools.itemPredicateOf(CookingItemRegistration.DOUGH))
                .save(recipeOutput, MedievalismConstants.resource("bread_campfire"));
    }

    private static void limeRecipes(RecipeOutput recipeOutput) {
        // Quicklime
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(WorldItemRegistration.LIMESTONE_ROCK),
                        RecipeCategory.MISC, ItemRegistration.QUICK_LIME,
                        0.0f, 1000)
                .unlockedBy("has_limestone_rock", RecipeTools.itemPredicateOf(WorldItemRegistration.LIMESTONE_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("quicklime_campfire"));
    }
}
