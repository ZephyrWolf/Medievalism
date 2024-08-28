package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class InWorldRecipeBuilder implements RecipeBuilder
{
    ItemStack trigger;
    NonNullList<Ingredient> ingredients = NonNullList.create();
    BlockState result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public static InWorldRecipeBuilder fireStarter(BlockState result)
    {
        return new InWorldRecipeBuilder(new ItemStack(ItemRegistration.FIRE_STARTER.get()), result);
    }

    public static InWorldRecipeBuilder of(Item trigger, BlockState result)
    {
        return new InWorldRecipeBuilder(new ItemStack(trigger), result);
    }

    protected  InWorldRecipeBuilder(ItemStack trigger, BlockState result)
    {
        this.trigger = trigger;
        this.result = result;
    }

    public InWorldRecipeBuilder requires(TagKey<Item> tag) { return requires(Ingredient.of(tag), 1); }
    public InWorldRecipeBuilder requires(TagKey<Item> tag, int quantity) { return requires(Ingredient.of(tag), quantity); }
    public InWorldRecipeBuilder requires(ItemLike item) { return requires(item, 1); }
    public InWorldRecipeBuilder requires(ItemLike item, int quantity) { return requires(Ingredient.of(item), quantity); }
    public InWorldRecipeBuilder requires(Ingredient ingredient) { return requires(ingredient, 1); }
    public InWorldRecipeBuilder requires(Ingredient ingredient, int quantity)
    {
        for (int i = 0; i < quantity; i++)
        {
            ingredients.add(ingredient);
        }
        return this;
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
    public BlockState getResultState() { return result; }

    @Override
    public void save(@NotNull RecipeOutput pRecipeOutput, @NotNull ResourceLocation pId)
    {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        InWorldRecipe inworldrecipe = new InWorldRecipe(
                //Objects.requireNonNullElse(this.group, ""),
                trigger,
                ingredients,
                result
        );
        pRecipeOutput.accept(pId, inworldrecipe, advancement$builder.build(pId.withPrefix("recipes/" + "in_world" + "/")));

    }

    private void ensureValid(ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
}
