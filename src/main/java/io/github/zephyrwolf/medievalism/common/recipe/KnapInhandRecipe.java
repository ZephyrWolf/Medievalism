package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
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
import java.util.Optional;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record KnapInhandRecipe(@Nonnull String group, @Nonnull Optional<Ingredient> tool, @Nonnull Ingredient ingredient, @Nonnull ItemStack result) implements InhandRecipe
{
    @Override
    public Optional<Ingredient> getTool() { return tool; }

    @Override
    public TagKey<Item> getToolTag() { return ToolTag(); }

    public static TagKey<Item> ToolTag() { return ItemTagCatalog.KNAP_TOOL; }

    @Override
    public Ingredient getIngredient() { return ingredient; }

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
        return RecipeRegistration.KNAP_INHAND_RECIPE_SERIALIZER.get();
    }
}
