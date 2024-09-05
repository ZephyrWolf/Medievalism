package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableMaterialRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableRecipeBuilder;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.content.recipe.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public final class BaseMalleableRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        malleableMaterialRecipes(recipeOutput);
        knappingRecipes(recipeOutput);
        potteryRecipes(recipeOutput);
    }

    private static void malleableMaterialRecipes(RecipeOutput recipeOutput) {
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.CLAY_BALL), MalleableMaterialRegistration.CLAY.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("clay_ball_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.CLAY_BLOCK), MalleableMaterialRegistration.CLAY.get())
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("clay_block_material"));

        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.ROCK), MalleableMaterialRegistration.STONE.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.LARGE_ROCK), MalleableMaterialRegistration.STONE.get())
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("large_rock_material"));
    }

    private static void knappingRecipes(RecipeOutput recipeOutput) {
        // Lunate
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.STONE.get(), new ItemStack(ItemRegistration.LUNATE.get()))
                .allowMirror()
                .pattern("x ")
                .pattern("xx")
                .pattern("xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(BlockRegistration.STONE_BENCH_ITEM))
                .save(recipeOutput, MedievalismConstants.resource("lunate_knapping1"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.STONE.get(), new ItemStack(ItemRegistration.LUNATE.get(), 2))
                .allowMirror()
                .pattern("x  x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(BlockRegistration.STONE_BENCH_ITEM))
                .save(recipeOutput, MedievalismConstants.resource("lunate_knapping2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.STONE.get(), new ItemStack(ItemRegistration.LUNATE.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(BlockRegistration.STONE_BENCH_ITEM))
                .save(recipeOutput, MedievalismConstants.resource("lunate_knapping3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.STONE.get(), new ItemStack(ItemRegistration.LUNATE.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(BlockRegistration.STONE_BENCH_ITEM))
                .save(recipeOutput, MedievalismConstants.resource("lunate_knapping4"));
        // Biface
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.STONE.get(), new ItemStack(ItemRegistration.BIFACE.get()))
                .allowMirror()
                .pattern("xx ")
                .pattern("xxx")
                .pattern("xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("biface"));
    }

    private static void potteryRecipes(RecipeOutput recipeOutput) {
        /*
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_FLOWER_POT.get()))
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_plant_pot"));
         */

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .pattern("x x")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_clay_crucible"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(BlockRegistration.WET_GATHERERS_JAR_ITEM.get()))
                .pattern("x x")
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_gatherers_jar"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(BlockRegistration.WET_KEEPERS_CROCK_ITEM.get()))
                .pattern("x  x")
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_keepers_crock"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(BlockRegistration.WET_SETTLERS_POT_ITEM.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_settlers_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(BlockRegistration.WET_CLAY_COOKING_POT_ITEM.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_cooking_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(BlockRegistration.WET_CLAY_CAULDRON_ITEM.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_cauldron"));

        /*
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_POT.get()))
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_LARGE_POT.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_large_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_JUG.get()))
                .pattern(" x x ")
                .pattern(" x x ")
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_jug"));
        */
    }
}
