package io.github.zephyrwolf.medievalism.common.recipe.crafting;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class ShapelessToolRecipeBuilder implements RecipeBuilder
{
    private final RecipeCategory category;
    private final ItemStack resultStack;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final NonNullList<Ingredient> tools = NonNullList.create();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;
    private AdvancementRequirements.Strategy strategy = AdvancementRequirements.Strategy.OR;

    public ShapelessToolRecipeBuilder(RecipeCategory pCategory, ItemLike pResult, int pCount)
    {
        this(pCategory, new ItemStack(pResult, pCount));
    }

    public ShapelessToolRecipeBuilder(RecipeCategory category, ItemStack result)
    {
        this.category = category;
        this.resultStack = result;
    }

    public static ShapelessToolRecipeBuilder shapeless(RecipeCategory pCategory, ItemLike pResult)
    { return new ShapelessToolRecipeBuilder(pCategory, pResult, 1); }
    public static ShapelessToolRecipeBuilder shapeless(RecipeCategory pCategory, ItemLike pResult, int pCount)
    { return new ShapelessToolRecipeBuilder(pCategory, pResult, pCount); }
    public static ShapelessToolRecipeBuilder shapeless(RecipeCategory category, ItemStack result)
    { return new ShapelessToolRecipeBuilder(category, result); }

    public ShapelessToolRecipeBuilder requiresIngredient(TagKey<Item> pTag) { return this.requiresIngredient(Ingredient.of(pTag)); }
    public ShapelessToolRecipeBuilder requiresIngredient(ItemLike pItem) { return this.requiresIngredient(pItem, 1); }
    public ShapelessToolRecipeBuilder requiresIngredient(ItemLike pItem, int pQuantity)
    {
        for (int i = 0; i < pQuantity; i++) {
            this.requiresIngredient(Ingredient.of(pItem));
        }
        return this;
    }
    public ShapelessToolRecipeBuilder requiresIngredient(Ingredient pIngredient) { return this.requiresIngredient(pIngredient, 1); }
    public ShapelessToolRecipeBuilder requiresIngredient(Ingredient pIngredient, int pQuantity)
    {
        for (int i = 0; i < pQuantity; i++)
        {
            this.ingredients.add(pIngredient);
        }
        return this;
    }

    public ShapelessToolRecipeBuilder requiresTool(TagKey<Item> pTag) { return this.requiresTool(Ingredient.of(pTag)); }
    public ShapelessToolRecipeBuilder requiresTool(ItemLike pTool) { return this.requiresTool(pTool, 1); }
    public ShapelessToolRecipeBuilder requiresTool(ItemLike pTool, int pQuantity)
    {
        for (int i = 0; i < pQuantity; i++) {
            this.requiresTool(Ingredient.of(pTool));
        }
        return this;
    }
    public ShapelessToolRecipeBuilder requiresTool(Ingredient pTool) { return this.requiresTool(pTool, 1); }
    public ShapelessToolRecipeBuilder requiresTool(Ingredient pTool, int pQuantity)
    {
        for (int i = 0; i < pQuantity; i++)
        {
            this.tools.add(pTool);
        }
        return this;
    }

    public @NotNull ShapelessToolRecipeBuilder unlockedBy(@NotNull String pName, @NotNull Criterion<?> pCriterion)
    {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    public @NotNull ShapelessToolRecipeBuilder group(@Nullable String pGroupName)
    {
        this.group = pGroupName;
        return this;
    }

    public ShapelessToolRecipeBuilder strategy(AdvancementRequirements.Strategy strategy)
    {
        this.strategy = strategy;
        return this;
    }

    @Override
    public @NotNull Item getResult() { return this.resultStack.getItem(); }

    public ItemStack getResultStack() { return resultStack; }

    @Override
    public void save(RecipeOutput pRecipeOutput, @NotNull ResourceLocation pId)
    {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(strategy);
        this.criteria.forEach(advancement$builder::addCriterion);
        ShapelessToolRecipe shapelesstoolRecipe = new ShapelessToolRecipe(
                Objects.requireNonNullElse(this.group, ""),
                RecipeBuilder.determineBookCategory(this.category),
                this.resultStack,
                this.ingredients,
                this.tools
        );
        pRecipeOutput.accept(pId, shapelesstoolRecipe, advancement$builder.build(pId.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    /**
     * Makes sure that this recipe is valid and obtainable.
     */
    private void ensureValid(ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
        if (this.ingredients.isEmpty())
        {
            throw new IllegalStateException("ShapelessToolRecipe.ingredients cannot be empty " + pId);
        }
        if (this.tools.isEmpty())
        {
            throw new IllegalStateException("ShapelessToolRecipe.tools cannot be empty " + pId + ". Use Shapeless recipe instead.");
        }
    }
}
