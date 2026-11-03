package io.github.zephyrwolf.medievalism.common.recipe.malleable;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record MalleableRecipeInput(MalleableMaterial material) implements RecipeInput
{
    @Override
    public ItemStack getItem(int pIndex) { return ItemStack.EMPTY; }

    @Override
    public int size() { return 1; }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
