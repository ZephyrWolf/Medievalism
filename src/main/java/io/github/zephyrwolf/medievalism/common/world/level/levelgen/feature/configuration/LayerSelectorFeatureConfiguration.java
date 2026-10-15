package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.*;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public record LayerSelectorFeatureConfiguration(Map<ResourceKey<WorldLayer>, Holder<PlacedFeature>> features) implements FeatureConfiguration
{
    public static final MapCodec<LayerSelectorFeatureConfiguration> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            LayeredPlacedFeature.CODEC.listOf().fieldOf("features").forGetter(LayerSelectorFeatureConfiguration::getLayeredFeatures)
    ).apply(instance, LayerSelectorFeatureConfiguration::create));

    public List<LayeredPlacedFeature> getLayeredFeatures()
    {
        List<LayeredPlacedFeature> featuresList = new ArrayList<>();
        for (ResourceKey<WorldLayer> layer : features.keySet())
        {
            Holder<PlacedFeature> feature = features.get(layer);
            if (feature != null) // I don't trust it
            {
                featuresList.add(new LayeredPlacedFeature(layer, feature));
            }
        }
        return featuresList;
    }

    public static LayerSelectorFeatureConfiguration layers(LayeredPlacedFeature ... features)
    {
        return create(Arrays.stream(features).toList());
    }

    public static LayerSelectorFeatureConfiguration create(List<LayeredPlacedFeature> features)
    {
        Map<ResourceKey<WorldLayer>, Holder<PlacedFeature>> featuresMap = new HashMap<>();
        for (LayeredPlacedFeature feature : features)
        {
            if (featuresMap.containsKey(feature.layer()))
            {
                throw new IllegalArgumentException("Duplicate layer '" + feature.layer() + "'on LayerSelectorFeatureConfiguration.");
            }
            featuresMap.put(feature.layer(), feature.feature());
        }
        return new LayerSelectorFeatureConfiguration(featuresMap);
    }

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return features.values().stream().flatMap(placed -> placed.value().getFeatures());
    }
}
