package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.DisableFeatureConfiguration;
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
import org.jetbrains.annotations.NotNull;

public class DisableFeature extends Feature<DisableFeatureConfiguration>
{
    public DisableFeature(Codec<DisableFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<DisableFeatureConfiguration> context)
    {
       return false;
    }
}
