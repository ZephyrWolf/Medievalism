package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public final class BaseShapedRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        survivalRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput) {
        // Red Clay Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.RED_CLAY_BLOCK_ITEM)
                .pattern("cc")
                .pattern("cc")
                .define('c', ItemRegistration.RED_CLAY_BALL)
                .group("clay")
                .unlockedBy("has_red_clay_ball", RecipeTools.itemPredicateOf(ItemRegistration.RED_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("red_clay_block"));
        // Mud
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MUD)
                .pattern("cc")
                .pattern("cc")
                .define('c', ItemRegistration.MUD_BALL)
                .unlockedBy("has_mud_balls", RecipeTools.itemPredicateOf(ItemRegistration.MUD_BALL))
                .save(recipeOutput, MedievalismConstants.resource("mud_from_balls"));
        // Thatch Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.THATCH_BLOCK_ITEM)
                .pattern("tt")
                .pattern("tt")
                .define('t', ItemRegistration.THATCH)
                .group("thatch")
                .unlockedBy("has_thatch", RecipeTools.itemPredicateOf(ItemRegistration.THATCH))
                .save(recipeOutput, MedievalismConstants.resource("thatch_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MUD_BRICKS, 1)
                .pattern("mm")
                .pattern("mm")
                .define('m', ItemRegistration.PACKED_MUD_BRICK)
                .unlockedBy("has_mud_stone_brick", RecipeTools.itemPredicateOf(ItemRegistration.PACKED_MUD_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("mud_brick_from_bricks"));
        // TODO Different types based on stone type?
        // Stone Bench
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(BlockRegistration.STONE_BENCH_ITEM.get()))
                .pattern("xx")
                .define('x', ItemTagCatalog.LARGE_ROCK)
                .unlockedBy("has_large_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("stone_bench"));
    }
}
