package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeBuilder;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public final class BaseInWorldRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        fireStarterRecipes(recipeOutput);
    }

    private static void fireStarterRecipes(RecipeOutput recipeOutput) {
        // Campfire
        InWorldRecipeBuilder.fireStarter(Blocks.CAMPFIRE.defaultBlockState())
                .requires(ItemTagCatalog.BRANCH, 4)
                .requires(ItemTagCatalog.TINDER)
                .unlockedBy("has_branch", RecipeTools.itemPredicateOf(ItemTagCatalog.BRANCH))
                .save(recipeOutput, MedievalismConstants.resource("campfire"));
    }
}
