package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public record UpperGradientAwareConditionSource(
        ResourceLocation randomName,
        VerticalAnchor trueAtAndAbove,
        int depthBelow
) implements SurfaceRules.ConditionSource
{
    static final KeyDispatchDataCodec<UpperGradientAwareConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                                    ResourceLocation.CODEC.fieldOf("random_name").forGetter(UpperGradientAwareConditionSource::randomName),
                                    VerticalAnchor.CODEC.fieldOf("true_at_and_above").forGetter(UpperGradientAwareConditionSource::trueAtAndAbove),
                                    Codec.INT.fieldOf("depth_below").forGetter(UpperGradientAwareConditionSource::depthBelow)
                            )
                            .apply(instance, UpperGradientAwareConditionSource::new)
            ));

    @Override
    public KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() {
        return CODEC;
    }

    public SurfaceRules.Condition apply(final SurfaceRules.Context pContext)
    {
        // For some reason, we HAVE to query heightmap now and not at lazy
        final int heightMapY = AwareConditionSources.getSurfaceHeight(Heightmap.Types.WORLD_SURFACE_WG, pContext);
        final int j = AwareVerticalAnchor.resolveY(trueAtAndAbove, pContext.context, heightMapY);
        final int i = j - depthBelow;
        final PositionalRandomFactory positionalrandomfactory = pContext.randomState.getOrCreateRandomFactory(this.randomName());

        class LazyLowerGradientAwareConditionSource extends SurfaceRules.LazyYCondition
        {
            LazyLowerGradientAwareConditionSource()
            {
                super(pContext);
            }

            @Override
            protected boolean compute()
            {
                int k = this.context.blockY;
                if (k <= i)
                {
                    return false;
                }
                else if (k >= j)
                {
                    return true;
                }
                else
                {
                    double d0 = Mth.map((double)k, (double)i, (double)j, 1.0, 0.0);
                    RandomSource randomsource = positionalrandomfactory.at(this.context.blockX, k, this.context.blockZ);
                    return (double)randomsource.nextFloat() >= d0;
                }
            }
        }
        return new LazyLowerGradientAwareConditionSource();
    }
}
