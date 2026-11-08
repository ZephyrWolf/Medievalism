package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public final class BaseShapedRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        survivalRecipes(recipeOutput);
    }

    private static void survivalRecipes(RecipeOutput recipeOutput)
    {
        // Mud
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MUD)
                .pattern("cc")
                .pattern("cc")
                .define('c', ItemRegistration.MUD_BALL)
                .unlockedBy("has_mud_balls", RecipeTools.itemPredicateOf(ItemRegistration.MUD_BALL))
                .save(recipeOutput, MedievalismConstants.resource("mud_from_balls"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistration.DRYING_PACKED_MUD, 2)
                .pattern("mt")
                .pattern("tm")
                .define('m', Blocks.MUD.asItem())
                .define('t', ItemRegistration.THATCH)
                .group("wet_packed_mud")
                .unlockedBy("has_mud", RecipeTools.itemPredicateOf(Blocks.MUD.asItem()))
                .save(recipeOutput, MedievalismConstants.resource("wet_packed_mud"));
        // Clay
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.POTTERS_CLAY)
                .pattern("cc")
                .pattern("cc")
                .define('c', ClayWorkingItemRegistration.POTTERS_CLAY_BALL)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("potters_clay_from_balls"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.KAOLIN_CLAY)
                .pattern("cc")
                .pattern("cc")
                .define('c', ClayWorkingItemRegistration.KAOLIN_CLAY_BALL)
                .unlockedBy("has_kaolin_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("kaolin_clay_from_balls"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.CHINA_CLAY)
                .pattern("cc")
                .pattern("cc")
                .define('c', ClayWorkingItemRegistration.CHINA_CLAY_BALL)
                .unlockedBy("has_china_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CHINA_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("china_clay_from_balls"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.REFRACTORY_CLAY)
                .pattern("cc")
                .pattern("cc")
                .define('c', ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL)
                .unlockedBy("has_refractory_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_from_balls"));
        // Thatch Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistration.THATCH_BLOCK)
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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistration.DAUB_BRICKS, 1)
                .pattern("mm")
                .pattern("mm")
                .define('m', ItemRegistration.DAUB_BRICK)
                .unlockedBy("has_daub_brick", RecipeTools.itemPredicateOf(ItemRegistration.DAUB_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("daub_brick_from_bricks"));
        // Stone Bench
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ItemRegistration.STONE_BENCH.get()))
                .pattern("xx")
                .define('x', ItemTagCatalog.LARGE_ROCK)
                .unlockedBy("has_large_rock", RecipeTools.itemPredicateOf(ItemTagCatalog.LARGE_ROCK))
                .save(recipeOutput, MedievalismConstants.resource("stone_bench"));
    }
}
