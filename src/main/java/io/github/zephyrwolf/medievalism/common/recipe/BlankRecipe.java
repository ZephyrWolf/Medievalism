package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.content.recipe.RecipeRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BlankRecipe implements Recipe<InWorldRecipeInput> {

    public BlankRecipe(Integer dummyNumber) {
    }

    public int getDummyNumber() { return 0; }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    @Override
    public boolean matches(@NotNull InWorldRecipeInput pInput, @NotNull Level pLevel) {
        return false;
    }

    @Deprecated
    @Override
    public @NotNull ItemStack assemble(@NotNull InWorldRecipeInput pInput, HolderLookup.@NotNull Provider pRegistries) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Deprecated
    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider pRegistries) {
        return ItemStack.EMPTY;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeRegistration.BLANK_RECIPE_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeRegistration.BLANK_RECIPE_TYPE.get();
    }
}
