package io.github.zephyrwolf.medievalism.common.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class InWorldRecipeSerializer implements RecipeSerializer<InWorldRecipe>
{
    public static final MapCodec<InWorldRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    ItemStack.CODEC.fieldOf("trigger").forGetter(InWorldRecipe::getTrigger),
                    Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(InWorldRecipe::getIngredients),
                    BlockState.CODEC.fieldOf("result").forGetter(InWorldRecipe::getResultState)
            ).apply(inst, InWorldRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, InWorldRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ItemStack.STREAM_CODEC, InWorldRecipe::getTrigger,
                    Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), InWorldRecipe::getIngredients,
                    ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), InWorldRecipe::getResultState,
                    InWorldRecipe::new
            );

    @Override
    public @NotNull MapCodec<InWorldRecipe> codec() { return CODEC; }

    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, InWorldRecipe> streamCodec() { return STREAM_CODEC; }
}
