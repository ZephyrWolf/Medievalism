package io.github.zephyrwolf.medievalism.common.recipe.blank;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

public record BlankRecipeInput() implements RecipeInput
{
    @Override
    public @NotNull ItemStack getItem(int pIndex)
    {
        return ItemStack.EMPTY;
    }

    @Override
    public int size()
    {
        return 1;
    }
}
