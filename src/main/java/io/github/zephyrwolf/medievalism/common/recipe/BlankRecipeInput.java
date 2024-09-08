package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
