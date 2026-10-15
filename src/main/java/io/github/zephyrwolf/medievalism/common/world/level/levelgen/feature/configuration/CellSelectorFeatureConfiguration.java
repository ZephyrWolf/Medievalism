package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import java.util.*;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public record CellSelectorFeatureConfiguration(ResourceKey<WorldCellRegionMap> cellRegionMap, Map<ResourceKey<WorldCellRegion>, Holder<PlacedFeature>> features) implements FeatureConfiguration
{
    public static final MapCodec<CellSelectorFeatureConfiguration> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ResourceKey.codec(RegistryRegistration.WORLD_CELL_REGION_MAPS).fieldOf("cell_region_map").forGetter(CellSelectorFeatureConfiguration::cellRegionMap),
            CelledPlacedFeature.CODEC.listOf().fieldOf("features").forGetter(CellSelectorFeatureConfiguration::getCelledFeatures)
    ).apply(instance, CellSelectorFeatureConfiguration::create));

    public List<CelledPlacedFeature> getCelledFeatures()
    {
        List<CelledPlacedFeature> featuresList = new ArrayList<>();
        for (ResourceKey<WorldCellRegion> cell : features.keySet())
        {
            Holder<PlacedFeature> feature = features.get(cell);
            if (feature != null) // I don't trust it
            {
                featuresList.add(new CelledPlacedFeature(cell, feature));
            }
        }
        return featuresList;
    }

    public static CellSelectorFeatureConfiguration cells(ResourceKey<WorldCellRegionMap> cellRegionMap, CelledPlacedFeature ... features)
    {
        return create(cellRegionMap, Arrays.stream(features).toList());
    }

    public static CellSelectorFeatureConfiguration create(ResourceKey<WorldCellRegionMap> cellRegionMap, List<CelledPlacedFeature> features)
    {
        Map<ResourceKey<WorldCellRegion>, Holder<PlacedFeature>> featuresMap = new HashMap<>();
        for (CelledPlacedFeature feature : features)
        {
            WorldCellRegion cell = RegistryRegistration.WORLD_CELL_REGION_REGISTRY.getOrThrow(feature.cell());
            if (cellRegionMap != cell.cellRegionMap())
            {
                throw new IllegalArgumentException("Cell '" + feature.cell() + "' not found within '" + cellRegionMap + "'.");
            }
            featuresMap.put(feature.cell(), feature.feature());
        }
        return new CellSelectorFeatureConfiguration(cellRegionMap, featuresMap);
    }

    @Override
    public @NotNull Stream<ConfiguredFeature<?, ?>> getFeatures()
    {
        return features.values().stream().flatMap(placed -> placed.value().getFeatures());
    }
}
