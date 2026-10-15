package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class CellRarityFilter extends PlacementFilter
{
    public static final MapCodec<CellRarityFilter> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.fieldOf( "chance").forGetter(placement -> placement.chance),
            ResourceKey.codec(RegistryRegistration.WORLD_CELL_REGION_MAPS).fieldOf("region_map").forGetter(placement -> placement.regionMap),
            ResourceKey.codec(RegistryRegistration.WORLD_CELL_REGIONS).fieldOf("region").forGetter(placement -> placement.region)
    ).apply(instance, CellRarityFilter::new));

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.CELL.get(); }

    int chance;
    ResourceKey<WorldCellRegionMap> regionMap;
    ResourceKey<WorldCellRegion> region;

    public CellRarityFilter(int chance, ResourceKey<WorldCellRegionMap> regionMap, ResourceKey<WorldCellRegion> region)
    {
        this.chance = chance;
        this.region = region;
        this.regionMap = regionMap;
    }

    @Override
    protected boolean shouldPlace(@NotNull PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        if (pRandom.nextFloat() >= 1.0F / (float)this.chance)
        {
            return false;
        } // Process the above first to save the expensive check below
        RandomState randomState = pContext.getLevel().getLevel().getChunkSource().randomState();
        ResourceKey<WorldCellRegion> atVariant = WorldCellRegionMap.getCellAt(
                pContext.getLevel(),
                pContext.getLevel().getLevel().getChunkSource().getGenerator(),
                randomState,
                pPos,
                regionMap);
        return this.region == atVariant;
    }
}
