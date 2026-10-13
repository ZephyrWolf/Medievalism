package io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import org.jetbrains.annotations.NotNull;

public record HeightmapAwareVerticalAnchor(int offset) implements IAwareVerticalAnchor
{
    public static final Codec<HeightmapAwareVerticalAnchor> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("offset").forGetter(HeightmapAwareVerticalAnchor::offset)
    ).apply(instance, HeightmapAwareVerticalAnchor::new));

    @Override
    public int resolveY(WorldGenerationContext context, int surfaceHeight)
    {
        return surfaceHeight + offset;
    }

    @Override
    public @NotNull String toString()
    {
        return "heightmap " + offset + " offset";
    }
}
