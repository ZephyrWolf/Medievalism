package io.github.zephyrwolf.medievalism.common.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.item.ItemAbilityCODEC;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.common.ItemAbility;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdditionalDropToolUseRecipeSerializer implements RecipeSerializer<AdditionalDropToolUseRecipe>
{
    public static final MapCodec<AdditionalDropToolUseRecipe> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    ItemAbility.CODEC.fieldOf("itemAbility").forGetter(AdditionalDropToolUseRecipe::getItemAbility),
                    BlockPredicate.CODEC.fieldOf("block").forGetter(AdditionalDropToolUseRecipe::getBlock),
                    ItemStack.CODEC.fieldOf("result").forGetter(AdditionalDropToolUseRecipe::getResult),
                    Codec.INT.fieldOf("chance").forGetter(AdditionalDropToolUseRecipe::getChance)
            ).apply(inst, AdditionalDropToolUseRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, AdditionalDropToolUseRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ItemAbilityCODEC.STREAM_CODEC, AdditionalDropToolUseRecipe::getItemAbility,
                    BlockPredicate.STREAM_CODEC, AdditionalDropToolUseRecipe::getBlock,
                    ItemStack.STREAM_CODEC, AdditionalDropToolUseRecipe::getResult,
                    ByteBufCodecs.INT, AdditionalDropToolUseRecipe::getChance,
                    AdditionalDropToolUseRecipe::new
            );

    @Override
    public MapCodec<AdditionalDropToolUseRecipe> codec() { return CODEC; }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, AdditionalDropToolUseRecipe> streamCodec() { return STREAM_CODEC; }
}
