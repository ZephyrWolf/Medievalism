package io.github.zephyrwolf.medievalism.data.recipe;

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
