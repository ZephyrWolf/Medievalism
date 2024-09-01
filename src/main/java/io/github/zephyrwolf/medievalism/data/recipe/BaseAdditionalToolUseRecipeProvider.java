package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.AdditionalDropToolUseRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeBuilder;
import io.github.zephyrwolf.medievalism.content.block.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public final class BaseAdditionalToolUseRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        axeStrip(recipeOutput);
    }

    private static void axeStrip(RecipeOutput recipeOutput) {
        // White Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.WHITE_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.WHITE_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_white_bark"));
        // Brown Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.BROWN_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.BROWN_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_brown_bark"));
        // Grey Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.GREY_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.GREY_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_grey_bark"));
        // Brown Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.DARK_BROWN_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.DARK_BROWN_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_dark_brown_bark"));
        // Black Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.BLACK_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.BLACK_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_black_bark"));
    }
}
