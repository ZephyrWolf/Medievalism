package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlankRecipeBuilder implements RecipeBuilder
{
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public static BlankRecipeBuilder of()
    {
        return new BlankRecipeBuilder();
    }

    protected BlankRecipeBuilder()
    {
    }

    @Override
    public @NotNull RecipeBuilder unlockedBy(@NotNull String pName, @NotNull Criterion<?> pCriterion)
    {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Deprecated
    @Override
    public @NotNull RecipeBuilder group(@Nullable String pGroupName)
    {
        //this.group = pGroupName;
        return this;
    }

    @Deprecated
    @Override
    public @NotNull Item getResult() { return Items.AIR; }

    @Override
    public void save(@NotNull RecipeOutput pRecipeOutput, @NotNull ResourceLocation pId)
    {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        BlankRecipe blankrecipe = new BlankRecipe(0);
        pRecipeOutput.accept(pId, blankrecipe, advancement$builder.build(pId.withPrefix("recipes/" + "blank" + "/")));
    }

    private void ensureValid(ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
}
