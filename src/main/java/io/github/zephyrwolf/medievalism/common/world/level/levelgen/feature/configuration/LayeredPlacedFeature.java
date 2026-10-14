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

public class LayeredPlacedFeature
{
    public static final Codec<LayeredPlacedFeature> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                            Codec.STRING.fieldOf("layer").forGetter(layeredFeature -> layeredFeature.Layer.name()),
                            PlacedFeature.CODEC.fieldOf("feature").forGetter(layeredFeature -> layeredFeature.Feature)
                    )
                    .apply(instance, LayeredPlacedFeature::new));

    public final WorldGenLayerCatalog.WorldLayer Layer;
    public final Holder<PlacedFeature> Feature;

    public static LayeredPlacedFeature layer(WorldGenLayerCatalog.WorldLayer layer, Holder<PlacedFeature> feature)
    {
        return new LayeredPlacedFeature(layer, feature);
    }

    public LayeredPlacedFeature(String layer, Holder<PlacedFeature> feature)
    {
        Layer = WorldGenLayerCatalog.WorldLayer.valueOf(layer);
        Feature = feature;
    }

    public LayeredPlacedFeature(WorldGenLayerCatalog.WorldLayer layer, Holder<PlacedFeature> feature)
    {
        Layer = layer;
        Feature = feature;
    }

    public boolean place(WorldGenLevel pLevel, ChunkGenerator pChunkGenerator, RandomSource pRandom, BlockPos pPos)
    {
        return this.Feature.value().place(pLevel, pChunkGenerator, pRandom, pPos);
    }
}
