package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.registry.RecipeRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InWorldRecipe implements Recipe<InWorldRecipeInput>
{
    final ItemStack trigger;
    final NonNullList<Ingredient> ingredients;
    final BlockState result;

    public InWorldRecipe(ItemStack trigger, List<Ingredient> ingredients, BlockState result)
    {
        this.trigger = trigger;
        this.ingredients = NonNullList.copyOf(ingredients);
        this.result = result;
    }

    public ItemStack getTrigger() { return trigger; }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() { return ingredients; }

    @Override
    public boolean matches(@NotNull InWorldRecipeInput pInput, @NotNull Level pLevel)
    {
        if (pInput.numItems() != ingredients.size()) return false;
        if (!pInput.trigger().getItem().equals(trigger.getItem())) return false;

        List<ItemStack> splitItems = new ArrayList<>();
        pInput.entityItems().forEach((eItem) -> {
            for (int i = 0; i < eItem.getItem().getCount(); i++)
            {
                ItemStack s = eItem.getItem().copy();
                s.setCount(1);
                splitItems.add(s);
            }
        });


        // I can detect trivial by looking if a row or column is all zero.
        Integer[] tests = new Integer[ingredients.size()];
        for (int i = 0; i < splitItems.size(); i++)
        {
            ItemStack stack = splitItems.get(i);
            tests[i] = 0;
            for (int j = 0; j < ingredients.size(); j++)
            {
                Ingredient ingredient = ingredients.get(i);
                if (ingredient.test(stack))
                {
                    tests[i] |= 1 << j;
                }
            }
        }

        // Optional.of(Permutation)???


        return HeapsAlgorithm(ingredients.size(), (permutation) -> {
            for (int j = 0; j < ingredients.size(); j++)
            {
                int test = tests[permutation.at(j)];
                int mask = 1 << j;
                int result1 = test & mask;
                if (result1 == 0) return false;
            }
            return true;
        });
    }

    public static class Permutation
    {
        private final int[] indices;
        public static Permutation of(int size)
        {
            if (size <= 0) // ->
                throw new IllegalArgumentException("Size must be greater than 0.");
            return new Permutation(size);
        }
        private Permutation(int size)
        {
            indices = new int[size];
            for (int i = 0; i < size; i++)
                indices[i] = i;
        }
        public int size() { return indices.length; }
        public int at(int index) { return indices[index]; }
        public int[] copy()
        {
            int[] newAry = new int[size()];
            for (int i = 0; i < size(); i++)
            {
                newAry[i] = at(i);
            }
            return newAry;
        }
    }

    public boolean HeapsAlgorithm(Integer length, Function<Permutation, Boolean> consumer)
    {
        return HeapsAlgorithmImpl(Permutation.of(length), length, consumer);
    }
    public boolean HeapsAlgorithmImpl(Permutation toPermutate, Integer length, Function<Permutation, Boolean> consumer)
    {
        if (length <= 1)
        {
            return consumer.apply(toPermutate);
        }
        else
        {
            //if (HeapsAlgorithmImpl(toPermutate, length - 1, consumer)) return true;
            for (int i = 0; i < length; i++)
            {
                if (HeapsAlgorithmImpl(toPermutate, length - 1, consumer)) return true;
                int[] subIndices = toPermutate.copy();
                int middle;
                if (length % 2 == 0) // even
                {
                    middle = subIndices[i];
                    subIndices[i] = subIndices[length-1];
                }
                else
                {
                    middle = subIndices[0];
                    subIndices[0] = subIndices[length - 1];
                }
                subIndices[length - 1] = middle;
                //if (HeapsAlgorithmImpl(toPermutate, length, consumer)) return true;
            }
        }
        return false;
    }

    @Deprecated
    @Override
    public @NotNull ItemStack assemble(@NotNull InWorldRecipeInput pInput, HolderLookup.@NotNull Provider pRegistries) { return ItemStack.EMPTY; }

    public @NotNull BlockState assembleState(@NotNull InWorldRecipeInput pInput, HolderLookup.@NotNull Provider pRegistries)
    {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) { return pWidth * pHeight >= 1; }

    public @NotNull BlockState getResultState() { return result; }

    @Deprecated
    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider pRegistries) { return ItemStack.EMPTY; }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() { return RecipeRegistration.IN_WORLD_RECIPE_SERIALIZER.get(); }

    @Override
    public @NotNull RecipeType<?> getType()
    {
        return RecipeRegistration.IN_WORLD_RECIPE_TYPE.get();
    }
}
