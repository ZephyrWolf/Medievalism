package io.github.zephyrwolf.medievalism.common.recipe.inhand;

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
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class InhandRecipeBuilder implements RecipeBuilder
{
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    protected final ItemStack result;
    protected Ingredient tool = Ingredient.EMPTY;
    protected Ingredient ingredient = Ingredient.EMPTY;
    protected String group = "";
    protected String category = "inhand";
    protected InhandRecipeIngredientMaterialType materialType = InhandRecipeIngredientMaterialType.HIT_ROCK;

    public static InhandRecipeBuilder inhand(ItemStack result)
    {
        return new InhandRecipeBuilder(result);
    }

    public static InhandRecipeBuilder inhand(ItemLike result)
    {
        return new InhandRecipeBuilder(new ItemStack(result, 1));
    }

    protected InhandRecipeBuilder(@Nonnull ItemStack result)
    {
        this.result = result;
    }

    public InhandRecipeBuilder tool(@Nonnull Ingredient tool)
    {
        this.tool = tool;
        return this;
    }

    public InhandRecipeBuilder materialType(@Nonnull InhandRecipeIngredientMaterialType soundType)
    {
        this.materialType = soundType;
        return this;
    }

    public InhandRecipeBuilder ingredient(@Nonnull Ingredient ingredient)
    {
        this.ingredient = ingredient;
        return this;
    }

    public InhandRecipeBuilder category(@Nonnull String category)
    {
        this.category = category;
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

    @Override
    public void save(@Nonnull RecipeOutput pRecipeOutput, @Nonnull ResourceLocation pId) {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        InhandRecipe recipe = buildRecipe();
        pRecipeOutput.accept(pId, recipe, advancement$builder.build(pId.withPrefix("recipes/" + category + "/")));
    }

    @NotNull
    protected InhandRecipe buildRecipe()
    {
        return new InhandRecipe(
                Objects.requireNonNullElse(group, ""),
                tool,
                ingredient,
                result,
                materialType
        );
    }

    protected void ensureValid(@Nonnull ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
        if (tool.isEmpty())
        {
            throw new IllegalStateException("Cannot have an In-hand recipe with an empty tool");
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
