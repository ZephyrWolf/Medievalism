package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

public record AdditionalDropToolUseRecipeInput(BlockPos pos, ItemAbility toolAbility) implements RecipeInput
{
    @Override
    public @NotNull ItemStack getItem(int pIndex) { return new ItemStack(Items.AIR); }

    @Override
    public int size() { return 0; }

    @Override
    public boolean isEmpty() { return false; }
}
