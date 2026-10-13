package io.github.zephyrwolf.medievalism.data.overhauldata.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.BlankRecipeBuilder;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

public class OverhaulBlankRecipeProvider {
    protected static void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        // Vanilla
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("oak_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("birch_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("jungle_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("spruce_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("acacia_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("bamboo_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("dark_oak_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("mangrove_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("crimson_planks"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("warped_planks"));

        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("leather"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("bread"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("pumpkin_pie"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("mushroom_stew"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("rabbit_stew_from_red_mushroom"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("rabbit_stew_from_brown_mushrooms"));

        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("brick"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("packed_mud"));

        // Medievalism
        addBlank(recipeOutput, MedievalismConstants.resource("brick_from_clay_ball_tag"));

        // Vanilla Ore
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_blasting_deepslate_copper_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_blasting_copper_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_blasting_nether_copper_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_blasting_raw_copper"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_smelting_deepslate_copper_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_smelting_copper_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_smelting_nether_copper_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("copper_ingot_from_smelting_raw_copper"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_blasting_deepslate_iron_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_blasting_iron_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_blasting_nether_iron_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_blasting_raw_iron"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_smelting_deepslate_iron_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_smelting_iron_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_smelting_nether_iron_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("iron_ingot_from_smelting_raw_iron"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_blasting_deepslate_gold_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_blasting_gold_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_blasting_nether_gold_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_blasting_raw_gold"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_smelting_deepslate_gold_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_smelting_gold_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_smelting_nether_gold_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("gold_ingot_from_smelting_raw_gold"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("coal_from_blasting_deepslate_coal_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("coal_from_blasting_coal_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("coal_from_smelting_deepslate_coal_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("coal_from_smelting_coal_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("diamond_from_blasting_deepslate_diamond_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("diamond_from_blasting_diamond_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("diamond_from_smelting_deepslate_diamond_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("diamond_from_smelting_diamond_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("emerald_from_blasting_deepslate_emerald_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("emerald_from_blasting_emerald_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("emerald_from_smelting_deepslate_emerald_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("emerald_from_smelting_emerald_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("lapis_lazuli_from_blasting_deepslate_lapis_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("lapis_lazuli_from_blasting_lapis_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("lapis_lazuli_from_smelting_deepslate_lapis_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("lapis_lazuli_from_smelting_lapis_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("redstone_from_blasting_deepslate_redstone_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("redstone_from_blasting_redstone_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("redstone_from_smelting_deepslate_redstone_ore"));
        addBlank(recipeOutput, ResourceLocation.withDefaultNamespace("redstone_from_smelting_redstone_ore"));
        // Medievalism Ore
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_saprolite_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_laterite_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_siltstone_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_dolostone_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_limestone_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_chalk_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_ironstone_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_shale_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_arkose_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_marble_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_quartzite_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_hornfels_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_slate_copper_ore_to_raw_copper"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_diorite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_granite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_norite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_peridotite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_rhyolite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_dacite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_andesite_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_basalt_iron_ore_to_raw_iron"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_siltstone_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_dolostone_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_limestone_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_chalk_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_ironstone_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_shale_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_arkose_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_marble_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_quartzite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_hornfels_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_slate_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_diorite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_granite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_norite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_peridotite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_rhyolite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_dacite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_andesite_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_basalt_gold_ore_to_raw_gold"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_saprolite_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_laterite_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_siltstone_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_dolostone_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_limestone_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_chalk_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_ironstone_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_shale_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_arkose_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_marble_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_quartzite_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_hornfels_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_slate_coal_ore_to_coal"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_diorite_diamond_ore_to_diamond"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_granite_diamond_ore_to_diamond"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_norite_diamond_ore_to_diamond"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_peridotite_diamond_ore_to_diamond"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_andesite_diamond_ore_to_diamond"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_basalt_diamond_ore_to_diamond"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_diorite_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_granite_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_norite_emerald_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_peridotite_emerald_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_rhyolite_emerald_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_dacite_emerald_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_andesite_emerald_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_basalt_emerald_ore_to_emerald"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_marble_lapis_ore_to_lapis"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_quartzite_lapis_ore_to_lapis"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_hornfels_lapis_ore_to_lapis"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_slate_lapis_ore_to_lapis"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_diorite_redstone_ore_to_redstone"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_smooth_granite_redstone_ore_to_redstone"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_norite_redstone_ore_to_redstone"));
        addBlank(recipeOutput, MedievalismConstants.resource("smelt_peridotite_redstone_ore_to_redstone"));
    }

    private static void addBlank(@NonNull RecipeOutput recipeOutput, ResourceLocation location) {
        BlankRecipeBuilder.of()
                .unlockedBy("cant_unlock", never())
                .save(recipeOutput, location);
    }

    private static Criterion<ImpossibleTrigger.TriggerInstance> never() {
        return CriteriaTriggers.IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance());
    }
}
