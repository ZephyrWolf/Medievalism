package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CelledPlacedFeature
{
    public static final Codec<CelledPlacedFeature> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    Codec.STRING.fieldOf("cell").forGetter(layeredFeature -> layeredFeature.Cell),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(layeredFeature -> layeredFeature.Feature)
            )
            .apply(instance, CelledPlacedFeature::new));

    public final String Cell;
    public final Holder<PlacedFeature> Feature;

    public CelledPlacedFeature(String cell, Holder<PlacedFeature> feature)
    {
        Cell = cell;
        Feature = feature;
    }

    public boolean place(WorldGenLevel pLevel, ChunkGenerator pChunkGenerator, RandomSource pRandom, BlockPos pPos)
    {
        return this.Feature.value().place(pLevel, pChunkGenerator, pRandom, pPos);
    }
}
