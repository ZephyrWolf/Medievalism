package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public record CelledPlacedFeature(ResourceKey<WorldLayerCell> cell, Holder<PlacedFeature> feature)
{
    public static final Codec<CelledPlacedFeature> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    ResourceKey.codec(RegistryRegistration.LAYER_CELLS).fieldOf("cell").forGetter(CelledPlacedFeature::cell),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(CelledPlacedFeature::feature)
            )
            .apply(instance, CelledPlacedFeature::new));

    public static CelledPlacedFeature cell(ResourceKey<WorldLayerCell> cell, Holder<PlacedFeature> feature)
    {
        return new CelledPlacedFeature(cell, feature);
    }

    public boolean place(WorldGenLevel pLevel, ChunkGenerator pChunkGenerator, RandomSource pRandom, BlockPos pPos)
    {
        return this.feature().value().place(pLevel, pChunkGenerator, pRandom, pPos);
    }
}
