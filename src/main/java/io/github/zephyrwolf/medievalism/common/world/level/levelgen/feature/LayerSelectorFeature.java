package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayerSelectorFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
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
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        RandomState randomState = level.getLevel().getChunkSource().randomState();
        ResourceKey<WorldLayer> layer = WorldLayerMap.getLayerAt(level, chunkGenerator, randomState, origin, context.config().layerMap());
        LayerSelectorFeatureConfiguration config = context.config();
        if (!config.features().containsKey(layer) || config.features().get(layer) == null) return false;
        Holder<PlacedFeature> holder = config.features().get(layer);
        RandomSource randomSource = context.random();
        return holder.value().place(level, chunkGenerator, randomSource, origin);
    }
}
