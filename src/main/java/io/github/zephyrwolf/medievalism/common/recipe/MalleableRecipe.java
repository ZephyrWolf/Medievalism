package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import io.github.zephyrwolf.medievalism.content.recipe.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record MalleableRecipe(MalleableMaterial material, ItemStack result, boolean doMirror) implements Recipe<MalleableRecipeInput>
{
    @Override
    public boolean matches(MalleableRecipeInput pInput, Level pLevel)
    {
        MalleableMaterial other = pInput.material().trim();
        if (other.materialType() != material.materialType()) return false;
        if (other.cols() != material.cols()) return false;
        if (other.rows() != material.rows()) return false;
        if (checkPattern(other, false)) return true;
        return doMirror && checkPattern(other, true);
    }

    // Assumes material, rows and cols have already been checked
    private boolean checkPattern(MalleableMaterial other, boolean doMirror)
    {
        for (int row = 0; row < material.rows(); row++)
        {
            for (int recipeCol = 0; recipeCol < material().cols(); recipeCol++)
            {
                int otherCol = doMirror ? material().cols() - recipeCol - 1 : recipeCol;
                int otherIndex = row * material().cols() + otherCol;
                int recipeIndex = row * material().cols() + recipeCol;
                if (other.pattern().get(otherIndex) != material.pattern().get(recipeIndex)) return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(MalleableRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth >= material.cols() && pHeight >= material.rows();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistration.MALLEABLE_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeRegistration.MALLEABLE_RECIPE_TYPE.get();
    }
}
