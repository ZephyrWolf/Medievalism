package io.github.zephyrwolf.medievalism.tools;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Optional;

public final class CodecTools
{
    public static final StreamCodec<RegistryFriendlyByteBuf, Optional<Ingredient>> OPTIONAL_INGREDIENT_STREAM_CODEC
            = ByteBufCodecs.optional(Ingredient.CONTENTS_STREAM_CODEC);
}
