package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.CellSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayerSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoise;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellVariant;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;
import java.util.stream.Stream;

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
        CellNoiseSettings settings = config.settings;
        RandomState randomState = context.level().getLevel().getChunkSource().randomState();
        NormalNoise noise = randomState.getOrCreateNoise(settings.noiseKey());
        int stoneVariant = CellNoise.noise(settings, noise, origin);
        List<CellVariant> variants = settings.variants();
        if (!variants.isEmpty() && stoneVariant >= 0 && stoneVariant < variants.size())
        {
            String variantName = variants.get(stoneVariant).name().toString();
            if (config.features.containsKey(variantName))
            {
                PlacedFeature placedfeature = config.features.get(variantName).value();
                ChunkGenerator chunkGenerator = context.chunkGenerator();
                RandomSource randomSource = context.random();
                return placedfeature.place(level, chunkGenerator, randomSource, origin);
            }
        }
        return false;
    }
}
