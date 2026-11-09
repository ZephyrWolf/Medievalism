package io.github.zephyrwolf.medievalism.common.recipe.inhand;

import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record InhandRecipe(@Nonnull String group, @Nonnull Ingredient tool, @Nonnull Ingredient ingredient, @Nonnull ItemStack result, @Nonnull InhandRecipeIngredientMaterialType materialType) implements IInhandRecipe
{
    @Override
    public Ingredient getTool() { return tool; }

    @Override
    public Ingredient getIngredient() { return ingredient; }

    @Override
    public InhandRecipeIngredientMaterialType getMaterialType() { return materialType; }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistration.INHAND_RECIPE_SERIALIZER.get();
    }
}
