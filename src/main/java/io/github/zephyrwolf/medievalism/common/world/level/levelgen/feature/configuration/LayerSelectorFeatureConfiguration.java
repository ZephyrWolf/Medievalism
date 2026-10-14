package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.*;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public class LayerSelectorFeatureConfiguration implements FeatureConfiguration
{
    public static final MapCodec<LayerSelectorFeatureConfiguration> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            LayeredPlacedFeature.CODEC.listOf().fieldOf("features").forGetter(LayerSelectorFeatureConfiguration::getLayeredFeatures)
    ).apply(instance, LayerSelectorFeatureConfiguration::new));

    public final Map<WorldGenLayerCatalog.WorldLayer, Holder<PlacedFeature>> features;

    public List<LayeredPlacedFeature> getLayeredFeatures()
    {
        List<LayeredPlacedFeature> featuresList = new ArrayList<>();
        for (WorldGenLayerCatalog.WorldLayer layer : features.keySet())
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
        return new LayerSelectorFeatureConfiguration(Arrays.stream(features).toList());
    }

    public LayerSelectorFeatureConfiguration(List<LayeredPlacedFeature> features)
    {
        Map<WorldGenLayerCatalog.WorldLayer, Holder<PlacedFeature>> featuresMap = new HashMap<>();
        for (LayeredPlacedFeature feature : features)
        {
            if (featuresMap.containsKey(feature.Layer))
            {
                throw new IllegalArgumentException("Duplicate layer '"+feature.Layer.name()+"'on LayerSelectorFeatureConfiguration.");
            }
            featuresMap.put(feature.Layer, feature.Feature);
        }
        this.features = featuresMap;
    }

    public LayerSelectorFeatureConfiguration(HashMap<WorldGenLayerCatalog.WorldLayer, Holder<PlacedFeature>> features)
    {
        this.features = features;
    }

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return features.values().stream().flatMap(placed -> placed.value().getFeatures());
    }
}
