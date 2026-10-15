package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.jetbrains.annotations.NotNull;

// Used by mixin stone gen overhaul code, injected in
public record CellConditionSource(ResourceKey<WorldCellRegionMap> regionMap, ResourceKey<WorldCellRegion> region) implements SurfaceRules.ConditionSource
{
    static final KeyDispatchDataCodec<CellConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec( instance -> instance.group(
                            ResourceKey.codec(RegistryRegistration.WORLD_CELL_REGION_MAPS).fieldOf("region_map").forGetter(CellConditionSource::regionMap),
                            ResourceKey.codec(RegistryRegistration.WORLD_CELL_REGIONS).fieldOf("region").forGetter(CellConditionSource::region)
                    ).apply(instance, CellConditionSource::new)
            ));

    public static CellConditionSource cell(ResourceKey<WorldCellRegion> region)
    {
        WorldCellRegion cell = RegistryRegistration.WORLD_CELL_REGION_REGISTRY.getOrThrow(region);
        return new CellConditionSource(cell.cellRegionMap(), region);
    }

    @Override
    public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() { return CODEC; }

    public SurfaceRules.Condition apply(final SurfaceRules.Context pContext)
    {
        // For some reason, we HAVE to query heightmap now and not at lazy
        class LazyVerticalRangeAwareConditionSource extends SurfaceRules.LazyYCondition
        {
            LazyVerticalRangeAwareConditionSource()
            {
                super(pContext);
            }

            @Override
            protected boolean compute()
            {
                ServerLevel level = (ServerLevel) this.context.chunk.getLevel();
                BlockPos pos = new BlockPos(this.context.blockX, this.context.blockY, this.context.blockZ);
                ResourceKey<WorldCellRegion> atVariant = WorldCellRegionMap.getCellAt(
                        level,
                        level == null ? null : level.getChunkSource().getGenerator(),
                        this.context.randomState,
                        pos,
                        regionMap);
                return region == atVariant;
            }
        }
        return new LazyVerticalRangeAwareConditionSource();
    }
}
