package io.github.zephyrwolf.medievalism.common.recipe.crafting;

import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ShapelessToolRecipe implements CraftingRecipe
{
    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    final NonNullList<Ingredient> tools;

    public ShapelessToolRecipe(String pGroup, CraftingBookCategory pCategory, ItemStack pResult, NonNullList<Ingredient> pIngredients, NonNullList<Ingredient> pTools)
    {
        this.group = pGroup;
        this.category = pCategory;
        this.result = pResult;
        this.ingredients = pIngredients;
        this.tools = pTools;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeRegistration.SHAPELESS_TOOL_RECIPE.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() { return CraftingRecipe.super.getType(); }

    @Override
    public @NotNull String getGroup() {
        return this.group;
    }

    @Override
    public @NotNull CraftingBookCategory category() {
        return this.category;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider pRegistries) {
        return this.result;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients()
    {
        return NonNullList.copyOf(Stream.concat(ingredients.stream(), tools.stream()).toList());
    }

    public @NotNull ItemStack assemble(@NotNull CraftingInput pInput, HolderLookup.@NotNull Provider pRegistries)
    { return this.result.copy(); }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) { return pWidth * pHeight >= getIngredients().size(); }

    public boolean matches(CraftingInput pInput, @NotNull Level pLevel)
    {
        NonNullList<Ingredient> ingredientList = getIngredients();
        if (pInput.ingredientCount() != ingredientList.size()) { return false; }
        var inputList = new ArrayList<ItemStack>(pInput.ingredientCount());
        for (var item : pInput.items()) {
            if (!item.isEmpty()) {
                inputList.add(item);
            }
        }
        return RecipeMatcher.findMatches(inputList, ingredientList) != null;
    }

    protected boolean isTool(ItemStack stack)
    {
        for (Ingredient tool : tools)
        {
            if (tool.test(stack))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public @NotNull NonNullList<ItemStack> getRemainingItems(CraftingInput pInput)
    {
        NonNullList<ItemStack> nonnulllist = NonNullList.withSize(pInput.size(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); i++)
        {
            ItemStack item = pInput.getItem(i);
            if (item.hasCraftingRemainingItem())
            {
                nonnulllist.set(i, item.getCraftingRemainingItem());
            }
            else if (isTool(item))
            {
                if (!item.isDamageableItem() || item.getMaxDamage() == 0)
                {
                    nonnulllist.set(i, item.copyWithCount(1));
                }
                else {
                    ItemStack ret = item.copy();
                    int damage = ret.getDamageValue() + 1;
                    if (damage >= ret.getMaxDamage()) {
                        ret.setDamageValue(0);
                        ret.shrink(1);
                    } else {
                        ret.setDamageValue(damage);
                    }
                    nonnulllist.set(i, ret);
                }
            }
        }
        return nonnulllist;
    }
}
