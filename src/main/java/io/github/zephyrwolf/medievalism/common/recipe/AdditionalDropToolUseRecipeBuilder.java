package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdditionalDropToolUseRecipeBuilder implements RecipeBuilder
{
    BlockPredicate ingredient;
    ItemStack result;
    ItemAbility toolAbility;
    int chance = 1;

    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public static AdditionalDropToolUseRecipeBuilder axeStrip(ItemStack result, BlockPredicate ingredient)
    {
        return new AdditionalDropToolUseRecipeBuilder(ItemAbilities.AXE_STRIP, result, ingredient);
    }

    public static AdditionalDropToolUseRecipeBuilder of(ItemAbility ability, ItemStack result, BlockPredicate ingredient)
    {
        return new AdditionalDropToolUseRecipeBuilder(ability, result, ingredient);
    }

    protected AdditionalDropToolUseRecipeBuilder(ItemAbility ability, ItemStack result, BlockPredicate ingredient)
    {
        this.result = result;
        this.toolAbility = ability;
        this.ingredient = ingredient;
    }

    @Override
    public @NotNull AdditionalDropToolUseRecipeBuilder unlockedBy(@NotNull String pName, @NotNull Criterion<?> pCriterion)
    {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    public AdditionalDropToolUseRecipeBuilder chance(int chance)
    {
        this.chance = chance;
        return this;
    }

    @Deprecated
    @Override
    public @NotNull RecipeBuilder group(@Nullable String pGroupName)
    {
        return this;
    }

    @Deprecated
    @Override
    public @NotNull Item getResult() { return result.getItem(); }

    @Override
    public void save(@NotNull RecipeOutput pRecipeOutput, @NotNull ResourceLocation pId)
    {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        AdditionalDropToolUseRecipe recipe = new AdditionalDropToolUseRecipe(
                toolAbility,
                ingredient,
                result,
                chance
        );
        pRecipeOutput.accept(pId, recipe, advancement$builder.build(pId.withPrefix("recipes/" + "addition_drop_tool_use" + "/")));

    }

    private void ensureValid(ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
}
