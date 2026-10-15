package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.*;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public record CellSelectorFeatureConfiguration(ResourceKey<WorldLayer> layer, Map<ResourceKey<WorldLayerCell>, Holder<PlacedFeature>> features) implements FeatureConfiguration
{
    public static final MapCodec<CellSelectorFeatureConfiguration> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ResourceKey.codec(RegistryRegistration.WORLD_LAYERS).fieldOf("layer").forGetter(CellSelectorFeatureConfiguration::layer),
            CelledPlacedFeature.CODEC.listOf().fieldOf("features").forGetter(CellSelectorFeatureConfiguration::getCelledFeatures)
    ).apply(instance, CellSelectorFeatureConfiguration::create));

    public List<CelledPlacedFeature> getCelledFeatures()
    {
        List<CelledPlacedFeature> featuresList = new ArrayList<>();
        for (ResourceKey<WorldLayerCell> cell : features.keySet())
        {
            Holder<PlacedFeature> feature = features.get(cell);
            if (feature != null) // I don't trust it
            {
                featuresList.add(new CelledPlacedFeature(cell, feature));
            }
        }
        return featuresList;
    }

    public static CellSelectorFeatureConfiguration cells(ResourceKey<WorldLayer> layer, CelledPlacedFeature ... features)
    {
        return create(layer, Arrays.stream(features).toList());
    }

    public static CellSelectorFeatureConfiguration create(ResourceKey<WorldLayer> layer, List<CelledPlacedFeature> features)
    {
        Map<ResourceKey<WorldLayerCell>, Holder<PlacedFeature>> featuresMap = new HashMap<>();
        for (CelledPlacedFeature feature : features)
        {
            WorldLayerCell cell = RegistryRegistration.LAYER_CELLS_REGISTRY.getOrThrow(feature.cell());
            if (layer != cell.layer())
            {
                throw new IllegalArgumentException("Cell '" + feature.cell() + "' cannot be grouped with layer '" + layer + "'.");
            }
            featuresMap.put(feature.cell(), feature.feature());
        }
        return new CellSelectorFeatureConfiguration(layer, featuresMap);
    }

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return features.values().stream().flatMap(placed -> placed.value().getFeatures());
    }
}
