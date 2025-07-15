package io.github.zephyrwolf.medievalism.common.recipe;

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
import java.util.Optional;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface InhandRecipe extends Recipe<InhandRecipeInput>
{
    Optional<Ingredient> getTool();
    TagKey<Item> getToolTag();
    Ingredient getIngredient();

    @Override
    default boolean matches(InhandRecipeInput pInput, Level pLevel)
    {
        if (!pInput.tool().is(getToolTag())) return false;
        if (getTool().isPresent() && !getTool().get().test(pInput.tool())) return false;
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
