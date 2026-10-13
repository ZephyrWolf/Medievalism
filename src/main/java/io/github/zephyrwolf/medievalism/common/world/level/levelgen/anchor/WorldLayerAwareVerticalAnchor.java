package io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import org.jetbrains.annotations.NotNull;

// TODO This is a terrible name for this class
public record WorldLayerAwareVerticalAnchor(VerticalAnchor minHeight, VerticalAnchor typicalHeight, VerticalAnchor maxHeight, VerticalAnchor yDatum, float posScale, float negScale) implements IAwareVerticalAnchor
{
    public static final Codec<WorldLayerAwareVerticalAnchor> CODE = RecordCodecBuilder.create(instance -> instance.group(
            VerticalAnchor.CODEC.fieldOf("minHeight").forGetter(WorldLayerAwareVerticalAnchor::minHeight),
            VerticalAnchor.CODEC.fieldOf("typicalHeight").forGetter(WorldLayerAwareVerticalAnchor::typicalHeight),
            VerticalAnchor.CODEC.fieldOf("maxHeight").forGetter(WorldLayerAwareVerticalAnchor::maxHeight),
            VerticalAnchor.CODEC.fieldOf("yDatum").forGetter(WorldLayerAwareVerticalAnchor::yDatum),
            Codec.FLOAT.fieldOf("posScale").forGetter(WorldLayerAwareVerticalAnchor::posScale),
            Codec.FLOAT.fieldOf("negScale").forGetter(WorldLayerAwareVerticalAnchor::negScale)
    ).apply(instance, WorldLayerAwareVerticalAnchor::new));

    @Override
    public int resolveY(WorldGenerationContext context, int surfaceHeight)
    {
        float deviationFromDatum = (float) (surfaceHeight - yDatum.resolveY(context));

        float pDeviationFromDatum = Math.max(deviationFromDatum, 0);
        float nDeviationFromDatum = Math.min(deviationFromDatum, 0);

        float posModifier = pDeviationFromDatum * pDeviationFromDatum * 0.01f * posScale;
        float negativeModifier = nDeviationFromDatum * nDeviationFromDatum * 0.01f * negScale;

        return Math.min(maxHeight.resolveY(context), Math.max(minHeight.resolveY(context), (int) (typicalHeight.resolveY(context) + posModifier - negativeModifier)));
    }

    @Override
    public @NotNull String toString() {
        return this.minHeight + " wave " + this.yDatum + " datum " + this.posScale + " posScale " + this.negScale + " negScale";
    }
}
