package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.tools.RecipeTools;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class OverhaulRecipeProvider extends RecipeProvider
{

    public OverhaulRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.PACKED_MUD)
                .requires(Blocks.MUD)
                .requires(ItemRegistration.THATCH)
                .unlockedBy("has_mud_thatch", RecipeTools.itemPredicateOf(Blocks.MUD, ItemRegistration.THATCH))
                .save(recipeOutput, MedievalismConstants.resource("temp_packed_mud_from_balls"));
    }
}
