package io.github.zephyrwolf.medievalism.common.recipe.inhand;

import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface IInhandRecipe extends Recipe<InhandRecipeInput>
{
    Ingredient getTool();
    Ingredient getIngredient();
    InhandRecipeIngredientMaterialType getMaterialType();

    @Override
    default boolean matches(InhandRecipeInput pInput, Level pLevel)
    {
        if (!getTool().test(pInput.tool())) return false;
        return getIngredient().test(pInput.ingredient());
    }

    @Override
    default ItemStack assemble(InhandRecipeInput pInput, HolderLookup.Provider pRegistries) { return getResultItem(pRegistries); }

    @Override
    default boolean canCraftInDimensions(int pWidth, int pHeight) { return false; }

    @Override
    default RecipeType<?> getType() {
        return RecipeRegistration.INHAND_RECIPE_TYPE.get();
    }
}
