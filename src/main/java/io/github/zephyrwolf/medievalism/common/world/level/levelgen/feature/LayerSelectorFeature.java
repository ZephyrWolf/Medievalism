package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayerSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class LayerSelectorFeature extends Feature<LayerSelectorFeatureConfiguration>
{
    public LayerSelectorFeature(Codec<LayerSelectorFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<LayerSelectorFeatureConfiguration> context)
    {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        LevelHeightAccessor pLevel = level.getChunk(origin);
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        WorldGenerationContext worldGenContext = new WorldGenerationContext(chunkGenerator, pLevel);
        int heightMapY_OCEAN = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, origin.getX(), origin.getZ());
        int heightMapY_SURFACE = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, origin.getX(), origin.getZ());
        WorldGenLayerConstants.LayerInfoAtPos layerInfo = WorldGenLayerConstants.GetLayer(worldGenContext, origin, heightMapY_OCEAN, heightMapY_SURFACE);
        if (!layerInfo.Exists || layerInfo.Defaulted) return false;
        LayerSelectorFeatureConfiguration config = context.config();
        if (!config.features().containsKey(layerInfo.Layer) || config.features().get(layerInfo.Layer) == null) return false;
        Holder<PlacedFeature> holder = config.features().get(layerInfo.Layer);
        RandomSource randomSource = context.random();
        return holder.value().place(level, chunkGenerator, randomSource, origin);
    }
}
