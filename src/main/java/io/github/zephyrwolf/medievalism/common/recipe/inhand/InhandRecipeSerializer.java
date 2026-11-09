package io.github.zephyrwolf.medievalism.common.recipe.inhand;

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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class InhandRecipeSerializer implements RecipeSerializer<InhandRecipe>
{

    public static final MapCodec<InhandRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    Codec.STRING.fieldOf("group").forGetter(InhandRecipe::group),
                    Ingredient.CODEC.fieldOf("tool").forGetter(InhandRecipe::tool),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(InhandRecipe::ingredient),
                    ItemStack.CODEC.fieldOf("result").forGetter(InhandRecipe::result),
                    InhandRecipeIngredientMaterialType.CODEC.fieldOf("material_type").forGetter(InhandRecipe::materialType)
            ).apply(inst, InhandRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, InhandRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, InhandRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC, InhandRecipe::tool,
                    Ingredient.CONTENTS_STREAM_CODEC, InhandRecipe::ingredient,
                    ItemStack.STREAM_CODEC, InhandRecipe::result,
                    InhandRecipeIngredientMaterialType.STREAM_CODEC, InhandRecipe::materialType,
                    InhandRecipe::new
            );

    @Override
    public MapCodec<InhandRecipe> codec() { return CODEC; }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, InhandRecipe> streamCodec() { return STREAM_CODEC; }
}
