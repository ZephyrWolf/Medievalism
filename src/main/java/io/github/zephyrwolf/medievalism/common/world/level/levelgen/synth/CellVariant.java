package io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.KeyDispatchDataCodec;

import java.util.ArrayList;
import java.util.List;

public record CellVariant(ResourceLocation name, int ordinal)
{
    public static KeyDispatchDataCodec<CellVariant> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                            ResourceLocation.CODEC.fieldOf("name").forGetter(CellVariant::name),
                            Codec.INT.fieldOf("ordinal").forGetter(CellVariant::ordinal)
                    ).apply(instance, CellVariant::new)
            ));

    public static <E extends Enum<E>> ResourceLocation getName(String modId, E e)
    {
        return ResourceLocation.fromNamespaceAndPath(modId, e.name().toLowerCase());
    }

    public static <E extends Enum<E>> List<CellVariant> listOf(String modId, Class<E> classType)
    {
        List<CellVariant> variants = new ArrayList<>();
        for (E e : classType.getEnumConstants())
        {
            variants.add(new CellVariant(getName(modId, e), e.ordinal()));
        }
        return variants;
    }
}
