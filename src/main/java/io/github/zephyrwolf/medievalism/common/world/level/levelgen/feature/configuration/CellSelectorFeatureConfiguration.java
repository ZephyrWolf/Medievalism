package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public class CellSelectorFeatureConfiguration implements FeatureConfiguration
{
    public static final MapCodec<CellSelectorFeatureConfiguration> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            CelledPlacedFeature.CODEC.listOf().fieldOf("features").forGetter(CellSelectorFeatureConfiguration::getCelledFeatures),
            CellNoiseSettings.CODEC.codec().fieldOf("settings").forGetter(selector -> selector.settings)
    ).apply(instance, CellSelectorFeatureConfiguration::new));

    public final Map<String, Holder<PlacedFeature>> features;
    public final CellNoiseSettings settings;

    public List<CelledPlacedFeature> getCelledFeatures()
    {
        List<CelledPlacedFeature> featuresList = new ArrayList<>();
        for (String cell : features.keySet())
        {
            Holder<PlacedFeature> feature = features.get(cell);
            if (feature != null) // I don't trust it
            {
                featuresList.add(new CelledPlacedFeature(cell, feature));
            }
        }
        return featuresList;
    }

    public CellSelectorFeatureConfiguration(List<CelledPlacedFeature> features, CellNoiseSettings settings)
    {
        Map<String, Holder<PlacedFeature>> featuresMap = new HashMap<>();
        for (CelledPlacedFeature feature : features)
        {
            featuresMap.put(feature.Cell, feature.Feature);
        }
        this.features = featuresMap;
        this.settings = settings;
    }

    public CellSelectorFeatureConfiguration(HashMap<String, Holder<PlacedFeature>> features, CellNoiseSettings settings)
    {
        this.features = features;
        this.settings = settings;
    }

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return features.values().stream().flatMap(placed -> placed.value().getFeatures());
    }
}
