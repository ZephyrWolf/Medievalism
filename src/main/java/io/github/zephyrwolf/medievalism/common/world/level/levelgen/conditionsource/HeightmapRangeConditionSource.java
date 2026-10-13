package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import org.jetbrains.annotations.NotNull;

public record HeightmapRangeConditionSource(Heightmap.Types hmType, VerticalAnchor anchorLower, VerticalAnchor anchorHigher) implements SurfaceRules.ConditionSource {
    static final KeyDispatchDataCodec<HeightmapRangeConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                                    Heightmap.Types.CODEC.fieldOf("heightmap_type").forGetter(HeightmapRangeConditionSource::hmType),
                                    VerticalAnchor.CODEC.fieldOf("anchor_lower").forGetter(HeightmapRangeConditionSource::anchorLower),
                                    VerticalAnchor.CODEC.fieldOf("anchor_higher").forGetter(HeightmapRangeConditionSource::anchorHigher)
                            )
                            .apply(instance, HeightmapRangeConditionSource::new)
            )
    );

    @Override
    public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec()
    {
        return CODEC;
    }

    public SurfaceRules.Condition apply(final SurfaceRules.Context pContext)
    {
        // For some reason, we HAVE to query heightmap now and not at lazy
        final int heightMapY = AwareConditionSources.getSurfaceHeight(Heightmap.Types.OCEAN_FLOOR_WG, pContext);

        class LazyVerticalRangeAwareConditionSource extends SurfaceRules.LazyYCondition
        {
            LazyVerticalRangeAwareConditionSource()
            {
                super(pContext);
            }

            @Override
            protected boolean compute()
            {
                final int minY = HeightmapRangeConditionSource.this.anchorLower.resolveY(context.context);
                final int maxY = HeightmapRangeConditionSource.this.anchorHigher.resolveY(context.context);
                return heightMapY >= minY && heightMapY <= maxY;
            }
        }
        return new LazyVerticalRangeAwareConditionSource();
    }

    public static SurfaceRules.ConditionSource within(VerticalAnchor anchorLower, VerticalAnchor anchorHigher)
    {
        return within(Heightmap.Types.OCEAN_FLOOR_WG, anchorLower, anchorHigher);
    }

    public static SurfaceRules.ConditionSource within(Heightmap.Types hmType, VerticalAnchor anchorLower, VerticalAnchor anchorHigher)
    {
        return new HeightmapRangeConditionSource(hmType, anchorLower, anchorHigher);
    }
}
