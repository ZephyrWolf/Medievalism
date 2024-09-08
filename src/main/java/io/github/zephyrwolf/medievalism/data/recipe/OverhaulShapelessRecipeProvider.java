package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class OverhaulShapelessRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        survivalRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
        // Packed Mud
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.PACKED_MUD) // TODO make this wet packed mud block or something that will dry
                .requires(Blocks.MUD)
                .requires(ItemRegistration.THATCH)
                .unlockedBy("has_mud_thatch", RecipeTools.itemPredicateOf(Blocks.MUD, ItemRegistration.THATCH))
                .save(recipeOutput, MedievalismConstants.resource("temp_packed_mud_from_balls"));
    }
}
