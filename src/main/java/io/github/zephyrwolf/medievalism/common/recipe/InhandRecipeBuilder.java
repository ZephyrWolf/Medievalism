package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class InhandRecipeBuilder<T extends InhandRecipe> implements RecipeBuilder
{
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    protected final ItemStack result;
    protected Optional<Ingredient> tool = Optional.empty();
    protected Ingredient ingredient = Ingredient.EMPTY;
    protected String group = "";

    protected InhandRecipeBuilder(@Nonnull ItemStack result)
    {
        this.result = result;
    }

    public InhandRecipeBuilder<T> tool(@Nonnull Ingredient tool)
    {
        this.tool = Optional.of(tool);
        return this;
    }

    public InhandRecipeBuilder<T> ingredient(@Nonnull Ingredient ingredient)
    {
        this.ingredient = ingredient;
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(@Nonnull String pName, @Nonnull Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    protected abstract String category();

    @Override
    public void save(@Nonnull RecipeOutput pRecipeOutput, @Nonnull ResourceLocation pId) {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        T recipe = buildRecipe();
        pRecipeOutput.accept(pId, recipe, advancement$builder.build(pId.withPrefix("recipes/" + category() + "/")));
    }

    protected abstract @NotNull T buildRecipe();

    protected void ensureValid(@Nonnull ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
        if (tool.isPresent() && tool.get().isEmpty())
        {
            throw new IllegalStateException("Cannot have an In-hand recipe with an empty tool. Leave blank for ANY or define filter.");
        }
        if (ingredient.isEmpty())
        {
            throw new IllegalStateException("Cannot have an In-hand recipe with an empty ingredient");
        }
        if (result.isEmpty())
        {
            throw new IllegalStateException("Cannot have an In-hand recipe with an empty result");
        }
    }
}
