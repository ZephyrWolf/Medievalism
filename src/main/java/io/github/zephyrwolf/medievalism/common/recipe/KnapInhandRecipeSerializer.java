package io.github.zephyrwolf.medievalism.common.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

import io.github.zephyrwolf.medievalism.tools.CodecTools;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class KnapInhandRecipeSerializer implements RecipeSerializer<KnapInhandRecipe> {

    public static final MapCodec<KnapInhandRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    Codec.STRING.fieldOf("group").forGetter(KnapInhandRecipe::group),
                    Ingredient.CODEC.optionalFieldOf("tool").forGetter(KnapInhandRecipe::tool),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(KnapInhandRecipe::ingredient),
                    ItemStack.CODEC.fieldOf("result").forGetter(KnapInhandRecipe::result)
            ).apply(inst, KnapInhandRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, KnapInhandRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, KnapInhandRecipe::group,
                    CodecTools.OPTIONAL_INGREDIENT_STREAM_CODEC, KnapInhandRecipe::tool,
                    Ingredient.CONTENTS_STREAM_CODEC, KnapInhandRecipe::ingredient,
                    ItemStack.STREAM_CODEC, KnapInhandRecipe::result,
                    KnapInhandRecipe::new
            );

    @Override
    public MapCodec<KnapInhandRecipe> codec() { return CODEC; }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, KnapInhandRecipe> streamCodec() { return STREAM_CODEC; }
}
