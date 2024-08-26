package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import io.github.zephyrwolf.medievalism.content.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record MalleableMaterialRecipe(Ingredient ingredient, MalleableMaterial shape) implements Recipe<MalleableMaterialRecipeInput>
{
    @Override
    public boolean matches(MalleableMaterialRecipeInput pInput, Level pLevel)
    {
        return ingredient.test(pInput.material());
    }

    @Deprecated
    @Override
    public ItemStack assemble(MalleableMaterialRecipeInput pInput, HolderLookup.Provider pRegistries)
    {
        return ItemStack.EMPTY;
    }

    public MalleableMaterial assembleMaterial(MalleableMaterialRecipeInput pInput, HolderLookup.Provider pRegistries)
    {
        return shape.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight)
    {
        return pWidth * pHeight >= 0;
    }

    @Deprecated
    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries)
    {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() { return RecipeRegistration.MALLEABLE_MATERIAL_RECIPE_SERIALIZER.get(); }

    @Override
    public RecipeType<?> getType() { return RecipeRegistration.MALLEABLE_MATERIAL_RECIPE_TYPE.get(); }
}
