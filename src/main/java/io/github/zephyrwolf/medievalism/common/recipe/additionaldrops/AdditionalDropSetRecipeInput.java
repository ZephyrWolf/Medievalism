package io.github.zephyrwolf.medievalism.common.recipe.additionaldrops;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public record AdditionalDropSetRecipeInput(BlockPos pos, Set<ItemAbility> toolAbility) implements IAdditionalDropRecipeInput
{
    public static AdditionalDropSetRecipeInput create(BlockPos pos, ItemAbility ... toolAbility)
    {
        return new AdditionalDropSetRecipeInput(pos, Set.of(toolAbility));
    }

    @Override
    public @NotNull ItemStack getItem(int pIndex) { return new ItemStack(Items.AIR); }

    @Override
    public int size() { return 0; }

    @Override
    public boolean isEmpty() { return false; }

    @Override
    public boolean HasAction(ItemAbility ability) { return toolAbility.contains(ability); }

    @Override
    public BlockPos Pos() { return pos; }
}

