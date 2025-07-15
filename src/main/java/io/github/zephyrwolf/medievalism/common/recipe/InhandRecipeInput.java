package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record InhandRecipeInput(@Nonnull ItemStack tool, @Nonnull ItemStack ingredient) implements RecipeInput
{
    public static final int INDEX_TOOL = 0;
    public static final int INDEX_INGREDIENT = 1;

    @Override
    public ItemStack getItem(int pIndex) { return new ItemStack[] { tool, ingredient }[pIndex]; }

    @Override
    public int size() { return 2; }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
