package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record InWorldRecipeInput(ItemStack trigger, List<ItemEntity> entityItems, BlockPos pos) implements RecipeInput
{
    public int getSize() { return entityItems.size(); }
    public int numItems() { return entityItems.stream().map((eItem) -> eItem.getItem().getCount()).reduce(0, Integer::sum); }

    @Override
    public @NotNull ItemStack getItem(int pIndex)
    {
        return entityItems.get(pIndex).getItem();
    }

    @Override
    public int size()
    {
        return entityItems.size();
    }
}
