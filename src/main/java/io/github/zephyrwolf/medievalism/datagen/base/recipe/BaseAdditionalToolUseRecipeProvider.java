package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.recipe.additionaldrops.AdditionalDropToolUseRecipeBuilder;
import io.github.zephyrwolf.medievalism.catalogs.tag.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.FarmingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WoodWorkingItemRegistration;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class BaseAdditionalToolUseRecipeProvider {
    public static void buildRecipes(RecipeOutput recipeOutput) {
        axeStrip(recipeOutput);
        knifeDig(recipeOutput);
    }

    private static void axeStrip(RecipeOutput recipeOutput)
    {
        // White Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(WoodWorkingItemRegistration.WHITE_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.WHITE_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_white_bark"));
        // Brown Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(WoodWorkingItemRegistration.BROWN_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.BROWN_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_brown_bark"));
        // Grey Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(WoodWorkingItemRegistration.GREY_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.GREY_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_grey_bark"));
        // Brown Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(WoodWorkingItemRegistration.DARK_BROWN_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.DARK_BROWN_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_dark_brown_bark"));
        // Black Bark
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(WoodWorkingItemRegistration.BLACK_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.BLACK_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_black_bark"));
    }

    private static void knifeDig(RecipeOutput recipeOutput)
    {
        // Thatch
        AdditionalDropToolUseRecipeBuilder
                .knifeDig(
                        new ItemStack(FarmingItemRegistration.THATCH.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.CAN_DROP_THATCH).build()
                )
                .chance(2)
                .unlockedBy("has_knife" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.KNIVES).build()))
                .save(recipeOutput, MedievalismConstants.resource("knife_dig_thatch"));
    }
}
