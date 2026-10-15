package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.ConditionTools;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import org.jetbrains.annotations.NotNull;

// Used by OverhaulVanillaLevelStoneGeneration
// aware functionality is not being used
// is there a vanilla alternative?

public record VerticalRangeAwareConditionSource(Heightmap.Types hmType, VerticalAnchor anchorLower, VerticalAnchor anchorHigher) implements SurfaceRules.ConditionSource {
    static final KeyDispatchDataCodec<VerticalRangeAwareConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                                    Heightmap.Types.CODEC.fieldOf("heightmap_type").forGetter(VerticalRangeAwareConditionSource::hmType),
                                    VerticalAnchor.CODEC.fieldOf("anchor_lower").forGetter(VerticalRangeAwareConditionSource::anchorLower),
                                    VerticalAnchor.CODEC.fieldOf("anchor_higher").forGetter(VerticalRangeAwareConditionSource::anchorHigher)
                            )
                            .apply(instance, VerticalRangeAwareConditionSource::new)
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
        final int heightMapY = ConditionTools.getSurfaceHeight(Heightmap.Types.OCEAN_FLOOR_WG, pContext);

        class LazyVerticalRangeAwareConditionSource extends SurfaceRules.LazyYCondition
        {
            LazyVerticalRangeAwareConditionSource()
            {
                super(pContext);
            }

            @Override
            protected boolean compute()
            {
                final int minY = AwareVerticalAnchor.resolveY(VerticalRangeAwareConditionSource.this.anchorLower, context.context, heightMapY);
                final int maxY = AwareVerticalAnchor.resolveY(VerticalRangeAwareConditionSource.this.anchorHigher, context.context, heightMapY);
                return this.context.blockY >= minY && this.context.blockY <= maxY;
            }
        }
        return new LazyVerticalRangeAwareConditionSource();
    }
}
