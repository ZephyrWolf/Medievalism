package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.*;
import java.util.stream.Stream;

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

public record LayerSelectorFeatureConfiguration(ResourceKey<WorldLayerMap> layerMap, Map<ResourceKey<WorldLayer>, Holder<PlacedFeature>> features) implements FeatureConfiguration
{
    public static final MapCodec<LayerSelectorFeatureConfiguration> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ResourceKey.codec(RegistryRegistration.WORLD_LAYER_MAPS).fieldOf("layer_map").forGetter(LayerSelectorFeatureConfiguration::layerMap),
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

    public static LayerSelectorFeatureConfiguration layers(ResourceKey<WorldLayerMap> layerMap, LayeredPlacedFeature ... features)
    {
        return create(layerMap, Arrays.stream(features).toList());
    }

    public static LayerSelectorFeatureConfiguration create(ResourceKey<WorldLayerMap> layerMap, List<LayeredPlacedFeature> features)
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
        return new LayerSelectorFeatureConfiguration(layerMap, featuresMap);
    }

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return features.values().stream().flatMap(placed -> placed.value().getFeatures());
    }
}
