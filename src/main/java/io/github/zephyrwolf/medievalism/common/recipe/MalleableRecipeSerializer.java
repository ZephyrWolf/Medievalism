package io.github.zephyrwolf.medievalism.common.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class MalleableRecipeSerializer implements RecipeSerializer<MalleableRecipe> {

    public static final MapCodec<MalleableRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    MalleableMaterial.CODEC.fieldOf("material").forGetter(MalleableRecipe::material),
                    ItemStack.CODEC.fieldOf("result").forGetter(MalleableRecipe::result),
                    Codec.BOOL.fieldOf("doMirror").forGetter(MalleableRecipe::doMirror)
            ).apply(inst, MalleableRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, MalleableRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    MalleableMaterial.STREAM_CODEC, MalleableRecipe::material,
                    ItemStack.STREAM_CODEC, MalleableRecipe::result,
                    ByteBufCodecs.BOOL, MalleableRecipe::doMirror,
                    MalleableRecipe::new
            );

    @Override
    public MapCodec<MalleableRecipe> codec() { return CODEC; }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, MalleableRecipe> streamCodec() { return STREAM_CODEC; }
}
