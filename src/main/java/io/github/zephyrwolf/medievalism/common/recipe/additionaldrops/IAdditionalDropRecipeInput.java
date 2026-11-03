package io.github.zephyrwolf.medievalism.common.recipe.additionaldrops;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.common.ItemAbility;

public interface IAdditionalDropRecipeInput extends RecipeInput
{
    boolean HasAction(ItemAbility ability);
    BlockPos Pos();
}
