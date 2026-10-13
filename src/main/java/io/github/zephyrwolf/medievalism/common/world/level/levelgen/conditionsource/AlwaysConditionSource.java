package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;

public record AlwaysConditionSource() implements SurfaceRules.ConditionSource
{
    static final KeyDispatchDataCodec<AlwaysConditionSource> CODEC =
            KeyDispatchDataCodec.of(MapCodec.unit(AlwaysConditionSource::new));

    @Override
    public KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() {
        return CODEC;
    }

    public SurfaceRules.Condition apply(final SurfaceRules.Context pContext)
    {
        class LazyAlwaysConditionSource extends SurfaceRules.LazyYCondition
        {
            LazyAlwaysConditionSource()
            {
                super(pContext);
            }

            @Override
            protected boolean compute()
            {
                return true;
            }
        }
        return new LazyAlwaysConditionSource();
    }

    public static SurfaceRules.ConditionSource always()
    {
        return new AlwaysConditionSource();
    }
}
