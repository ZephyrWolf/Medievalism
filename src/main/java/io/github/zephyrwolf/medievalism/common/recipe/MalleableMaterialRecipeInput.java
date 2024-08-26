package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record MalleableMaterialRecipeInput(@Nonnull ItemStack material) implements RecipeInput
{
    @Override
    public ItemStack getItem(int pIndex) { return material; }

    @Override
    public int size() { return 1; }
}
