package io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import org.jetbrains.annotations.NotNull;

public record InverseBellAwareVerticalAnchor(VerticalAnchor minHeight, float scale) implements IAwareVerticalAnchor
{
    public static final Codec<InverseBellAwareVerticalAnchor> CODE = RecordCodecBuilder.create(instance -> instance.group(
            VerticalAnchor.CODEC.fieldOf("min_height").forGetter(InverseBellAwareVerticalAnchor::minHeight),
            Codec.FLOAT.fieldOf("scale").forGetter(InverseBellAwareVerticalAnchor::scale)
    ).apply(instance, InverseBellAwareVerticalAnchor::new));

    @Override
    public int resolveY(WorldGenerationContext context, int surfaceHeight)
    {
        float div = Math.max((float) surfaceHeight - (float) minHeight.resolveY(context), 0);
        return (int) (surfaceHeight - div * div * scale);
    }

    @Override
    public @NotNull String toString() {
        return this.minHeight + " minHeight " + this.scale + " scale";
    }
}
