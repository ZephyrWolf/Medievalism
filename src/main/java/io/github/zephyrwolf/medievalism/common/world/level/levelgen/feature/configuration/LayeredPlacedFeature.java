package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public record LayeredPlacedFeature(ResourceKey<WorldLayer> layer, Holder<PlacedFeature> feature)
{
    public static final Codec<LayeredPlacedFeature> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                            ResourceKey.codec(RegistryRegistration.WORLD_LAYERS).fieldOf("layer").forGetter(LayeredPlacedFeature::layer),
                            PlacedFeature.CODEC.fieldOf("feature").forGetter(LayeredPlacedFeature::feature)
                    )
                    .apply(instance, LayeredPlacedFeature::new));

    public static LayeredPlacedFeature layer(ResourceKey<WorldLayer> layer, Holder<PlacedFeature> feature)
    {
        return new LayeredPlacedFeature(layer, feature);
    }

    public boolean place(WorldGenLevel pLevel, ChunkGenerator pChunkGenerator, RandomSource pRandom, BlockPos pPos)
    {
        return this.feature.value().place(pLevel, pChunkGenerator, pRandom, pPos);
    }
}
