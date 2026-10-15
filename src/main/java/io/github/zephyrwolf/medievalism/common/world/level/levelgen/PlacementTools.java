package io.github.zephyrwolf.medievalism.common.world.level.levelgen;

import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement.BelowHeightmapFilter;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement.CellRarityFilter;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public final class PlacementTools
{
    public static ResourceKey<PlacedFeature> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, resource);
    }

    public static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                ResourceKey<ConfiguredFeature<?, ?>> configurationKey, List<PlacementModifier> modifiers)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(key, new PlacedFeature(configuredFeatures.getOrThrow(configurationKey), List.copyOf(modifiers)));
    }

    // --

    @Deprecated
    public static void placeUndergroundRock(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey,
                                            HeightRangePlacement heightRangePlacement, int minTry, int maxTry, int minCluster, int maxCluster)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(
                context,
                placedFeatureKey,
                configuredFeatures.getOrThrow(configuredFeatureKey),

                CountPlacement.of(UniformInt.of(minTry, maxTry)), // How many locations
                InSquarePlacement.spread(),

                heightRangePlacement,
                BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, 1),
                CountPlacement.of(UniformInt.of(minCluster, maxCluster)), // How many in a cluster
                RandomOffsetPlacement.of(
                        ClampedNormalInt.of(0.0F, 3.0F, -7, 7), // XZ spread
                        ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), // Y spread

                BiomeFilter.biome()
        );
    }

    public static void simpleChanceSurfacePlacedFeature(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, int count, int chance)
    {
        register(context, placedFeatureKey, configuredFeatureKey, surfacePlacement(count, count, chance));
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange)
    {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> rarityOrePlacement(int count, PlacementModifier heightRange)
    {
        return List.of(RarityFilter.onAverageOnceEvery(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange)
    {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> chanceOceanSurfacePlacement(int chance)
    {
        return chanceOceanSurfacePlacement(chance, 0, 0);
    }

    @SuppressWarnings("SameParameterValue")
    public static List<PlacementModifier> chanceOceanSurfacePlacement(int chance, int minYOffset,  int maxYOffset)
    {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                RandomOffsetPlacement.vertical(UniformInt.of(minYOffset, maxYOffset)),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BiomeFilter.biome()
        );
    }

    // --

    public static List<PlacementModifier> surfacePlacement(int minCount, int maxCount, int chance)
    {
        return List.of(
                CountPlacement.of(UniformInt.of(minCount, maxCount)),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(chance),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), // WORLD_SURFACE_WG -- WATER LEVEL
                BiomeFilter.biome());
    }

    public static List<PlacementModifier> cavePlacement(int minCount, int maxCount, int chance)
    {
        return cavePlacement(minCount, maxCount, chance, VerticalAnchor.BOTTOM, VerticalAnchor.TOP);
    }

    public static List<PlacementModifier> cavePlacement(int minCount, int maxCount, int chance, VerticalAnchor lowerAnchor, VerticalAnchor upperAnchor)
    {
        return List.of(
                CountPlacement.of(UniformInt.of(minCount, maxCount)), // How many locations
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(chance),
                HeightRangePlacement.uniform(lowerAnchor, upperAnchor),
                BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, 1),
                BiomeFilter.biome()
        );
    }

    @Deprecated
    public static <E extends Enum<E>> List<PlacementModifier> surfaceCellPlacement(int minCount, int maxCount, int chance, ResourceKey<WorldCellRegionMap> regionMap, ResourceKey<WorldCellRegion> cell)
    {
        return List.of(
                CountPlacement.of(UniformInt.of(minCount, maxCount)),
                InSquarePlacement.spread(),
                new CellRarityFilter(chance, regionMap, cell),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), // WORLD_SURFACE_WG -- WATER LEVEL
                BiomeFilter.biome());
    }

    public static List<PlacementModifier> cavePlacement(int minCount, int maxCount, int chance, PlacementModifier heightRangePlacement, int minSurfaceDepth)
    {
        return List.of(
                CountPlacement.of(UniformInt.of(minCount, maxCount)),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(chance),
                heightRangePlacement,
                BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, minSurfaceDepth),
                BiomeFilter.biome());
    }

    @Deprecated
    public static <E extends Enum<E>> List<PlacementModifier> caveCellPlacement(int minCount, int maxCount, int chance, ResourceKey<WorldLayer> layer, ResourceKey<WorldCellRegion> variant, PlacementModifier heightRangePlacement)
    {
        /*
        return List.of(

                //CellRarityFilter.onAverageOnceEvery(chance, cell, variant),
                RarityFilter.onAverageOnceEvery(1),
                //BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, 1),

        );
        */

        return List.of(
                // CellRarityFilter.onAverageOnceEvery(chance, cell, variant), // If we don't pass the filter of base pos, don't both with spamming checks
                CountPlacement.of(UniformInt.of(minCount, maxCount)), // How many locations
                InSquarePlacement.spread(),
                heightRangePlacement,

                BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, 1),
                //CountPlacement.of(UniformInt.of(1, 1)), // How many in a cluster
                //RandomOffsetPlacement.of(
                //        ClampedNormalInt.of(0.0F, 3.0F, -7, 7), // XZ spread
                //        ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), // Y spread

                BiomeFilter.biome()
        );
    }
}