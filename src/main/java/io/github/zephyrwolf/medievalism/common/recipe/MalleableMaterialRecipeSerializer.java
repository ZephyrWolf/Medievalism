package io.github.zephyrwolf.medievalism.common.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

@MethodsReturnNonnullByDefault
public class MalleableMaterialRecipeSerializer implements RecipeSerializer<MalleableMaterialRecipe>
{
    public static final MapCodec<MalleableMaterialRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(MalleableMaterialRecipe::ingredient),
                    MalleableMaterial.CODEC.fieldOf("shape").forGetter(MalleableMaterialRecipe::shape)
            ).apply(inst, MalleableMaterialRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, MalleableMaterialRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, MalleableMaterialRecipe::ingredient,
                    MalleableMaterial.STREAM_CODEC, MalleableMaterialRecipe::shape,
                    MalleableMaterialRecipe::new
            );

    @Override
    public MapCodec<MalleableMaterialRecipe> codec() { return CODEC; }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, MalleableMaterialRecipe> streamCodec() { return STREAM_CODEC; }
}
