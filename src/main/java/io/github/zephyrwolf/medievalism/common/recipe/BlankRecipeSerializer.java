package io.github.zephyrwolf.medievalism.common.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class BlankRecipeSerializer implements RecipeSerializer<BlankRecipe> {
    public static final MapCodec<BlankRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    Codec.INT.fieldOf("dummy").forGetter(BlankRecipe::getDummyNumber)
            ).apply(inst, BlankRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, BlankRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.INT, BlankRecipe::getDummyNumber,
                    BlankRecipe::new);

    @Override
    public @NotNull MapCodec<BlankRecipe> codec() {
        return CODEC;
    }

    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, BlankRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
