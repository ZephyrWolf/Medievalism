package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.*;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public record DisableFeatureConfiguration(String dummy) implements FeatureConfiguration
{
    public static final MapCodec<DisableFeatureConfiguration> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                     Codec.STRING.fieldOf("dummy").forGetter(DisableFeatureConfiguration::dummy)
    ).apply(instance, DisableFeatureConfiguration::new));

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return Stream.of();
    }
}
