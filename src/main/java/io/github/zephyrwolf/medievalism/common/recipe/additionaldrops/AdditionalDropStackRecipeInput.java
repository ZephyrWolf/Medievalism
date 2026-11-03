package io.github.zephyrwolf.medievalism.common.recipe.additionaldrops;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

public record AdditionalDropStackRecipeInput(BlockPos pos, ItemStack stack) implements IAdditionalDropRecipeInput
{
    public static AdditionalDropStackRecipeInput create(BlockPos pos, ItemStack stack)
    {
        return new AdditionalDropStackRecipeInput(pos, stack);
    }

    @Override
    public @NotNull ItemStack getItem(int pIndex) { return stack; }

    @Override
    public int size() { return 0; }

    @Override
    public boolean isEmpty() { return false; }

    @Override
    public boolean HasAction(ItemAbility ability) { return stack.canPerformAction(ability); }

    @Override
    public BlockPos Pos() { return pos; }
}
