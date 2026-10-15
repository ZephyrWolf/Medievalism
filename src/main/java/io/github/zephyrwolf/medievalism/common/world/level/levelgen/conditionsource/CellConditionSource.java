package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.jetbrains.annotations.NotNull;

public record CellConditionSource(ResourceKey<WorldLayer> layer, ResourceKey<WorldLayerCell> variant) implements SurfaceRules.ConditionSource
{
    static final KeyDispatchDataCodec<CellConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec( instance -> instance.group(
                            ResourceKey.codec(RegistryRegistration.WORLD_LAYERS).fieldOf("layer").forGetter(CellConditionSource::layer),
                            ResourceKey.codec(RegistryRegistration.LAYER_CELLS).fieldOf("variant").forGetter(CellConditionSource::variant)
                    ).apply(instance, CellConditionSource::new)
            ));

    public static CellConditionSource cell(ResourceKey<WorldLayerCell> variant)
    {
        WorldLayerCell cell = RegistryRegistration.LAYER_CELLS_REGISTRY.getOrThrow(variant);
        return new CellConditionSource(cell.layer(), variant);
    }

    @Override
    public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() { return CODEC; }

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
                BlockPos pos = new BlockPos(pContext.blockX, pContext.blockY, pContext.blockZ);
                ResourceKey<WorldLayerCell> atVariant = WorldLayer.getCellAt(pContext.randomState, pos, layer());
                return variant == atVariant;
            }
        }
        return new LazyVerticalRangeAwareConditionSource();
    }
}
