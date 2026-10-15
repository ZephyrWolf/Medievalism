package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.CellSelectorFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CellSelectorFeature extends Feature<CellSelectorFeatureConfiguration>
{
    public CellSelectorFeature(Codec<CellSelectorFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CellSelectorFeatureConfiguration> context)
    {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        CellSelectorFeatureConfiguration config = context.config();
        ResourceKey<WorldCellRegion> cell = WorldCellRegionMap.getCellAt(
                level,
                level.getLevel().getChunkSource().getGenerator(),
                level.getLevel().getChunkSource().randomState(),
                origin,
                config.cellRegionMap());
        if (!config.features().containsKey(cell)) return false;
        PlacedFeature placedfeature = config.features().get(cell).value();
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        RandomSource randomSource = context.random();
        return placedfeature.place(level, chunkGenerator, randomSource, origin);
    }
}
