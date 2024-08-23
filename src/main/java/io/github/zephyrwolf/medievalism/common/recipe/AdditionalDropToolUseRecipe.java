package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.content.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.neoforged.neoforge.common.ItemAbility;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdditionalDropToolUseRecipe implements Recipe<AdditionalDropToolUseRecipeInput>
{
    final BlockPredicate block;
    final ItemStack result;
    final ItemAbility itemAbility;
    final int chance;

    public AdditionalDropToolUseRecipe(ItemAbility toolAbility, BlockPredicate ingredient, ItemStack result, int chance)
    {
        this.block = ingredient;
        this.result = result;
        this.itemAbility = toolAbility;
        this.chance = chance;
    }

    @Override
    public boolean matches(AdditionalDropToolUseRecipeInput pInput, Level pLevel)
    {
        BlockInWorld inWorldBlock = new BlockInWorld(pLevel, pInput.pos(), false);
        return itemAbility.equals(pInput.toolAbility()) && block.matches(inWorldBlock);
    }

    @Override
    public ItemStack assemble(AdditionalDropToolUseRecipeInput pInput, HolderLookup.Provider pRegistries) { return result; }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) { return pWidth * pHeight >= 1; }

    public ItemAbility getItemAbility() { return itemAbility; }
    public BlockPredicate getBlock() { return block; }
    public ItemStack getResult() { return result; }
    public int getChance() { return chance; }
    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) { return result; }

    @Override
    public RecipeSerializer<?> getSerializer() { return RecipeRegistration.ADDITIONAL_DROP_TOOL_USE_RECIPE_SERIALIZER.get(); }

    @Override
    public RecipeType<?> getType() { return RecipeRegistration.ADDITIONAL_DROP_TOOL_USE_RECIPE_TYPE.get(); }
}
