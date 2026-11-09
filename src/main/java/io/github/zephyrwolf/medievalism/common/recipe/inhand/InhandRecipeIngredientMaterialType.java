package io.github.zephyrwolf.medievalism.common.recipe.inhand;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum InhandRecipeIngredientMaterialType implements StringRepresentable
{
    HIT_ROCK("hit_rock"),
    HIT_PLANT("hit_plant"),
    SCRAPE_PLANT("scrape_plant");

    private final String name;

    InhandRecipeIngredientMaterialType(String name)
    {
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName()
    {
        return name;
    }

    public static final Codec<InhandRecipeIngredientMaterialType> CODEC = StringRepresentable.fromEnum(InhandRecipeIngredientMaterialType::values);
    public static final StreamCodec<ByteBuf, InhandRecipeIngredientMaterialType> STREAM_CODEC = ByteBufCodecs.idMapper(
            id -> InhandRecipeIngredientMaterialType.values()[id],
            InhandRecipeIngredientMaterialType::ordinal);
}
