package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.ConditionTools;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public record LowerGradientAwareConditionSource(
        ResourceLocation randomName,
        VerticalAnchor trueAtAndBelow,
        int depthAbove
) implements SurfaceRules.ConditionSource
{
    static final KeyDispatchDataCodec<LowerGradientAwareConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                                    ResourceLocation.CODEC.fieldOf("random_name").forGetter(LowerGradientAwareConditionSource::randomName),
                                    VerticalAnchor.CODEC.fieldOf("true_at_and_below").forGetter(LowerGradientAwareConditionSource::trueAtAndBelow),
                                    Codec.INT.fieldOf("depth_above").forGetter(LowerGradientAwareConditionSource::depthAbove)
                            )
                            .apply(instance, LowerGradientAwareConditionSource::new)
            ));

    @Override
    public KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() {
        return CODEC;
    }

    public SurfaceRules.Condition apply(final SurfaceRules.Context pContext)
    {
        // For some reason, we HAVE to query heightmap now and not at lazy
        final int heightMapY = ConditionTools.getSurfaceHeight(Heightmap.Types.OCEAN_FLOOR_WG, pContext);
        final int i = AwareVerticalAnchor.resolveY( trueAtAndBelow, pContext.context, heightMapY);
        final int j = i + depthAbove;
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
                    return true;
                }
                else if (k >= j)
                {
                    return false;
                }
                else
                {
                    double d0 = Mth.map((double)k, (double)i, (double)j, 1.0, 0.0);
                    RandomSource randomsource = positionalrandomfactory.at(this.context.blockX, k, this.context.blockZ);
                    return (double)randomsource.nextFloat() < d0;
                }
            }
        }
        return new LazyLowerGradientAwareConditionSource();
    }
}
