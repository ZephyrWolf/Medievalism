package io.github.zephyrwolf.medievalism.common.worldgen.feature;

import com.mojang.serialization.Codec;
import io.github.zephyrwolf.medievalism.common.worldgen.feature.configuration.CompositeFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CompositeFeature extends Feature<CompositeFeatureConfiguration>
{
    public CompositeFeature(Codec<CompositeFeatureConfiguration> pCodec)
    {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CompositeFeatureConfiguration> context)
    {
        CompositeFeatureConfiguration config = context.config();
        int i = 0;
        for (Holder<PlacedFeature> feature : config.features())
        {
            if (feature.value().place(context.level(), context.chunkGenerator(), context.random(), context.origin()))
            {
                i++;
            }
            else break;
        }
        return i > 0; // No necessarily complete but something
    }
}
