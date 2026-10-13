package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement.BelowHeightmapFilter;
import io.github.zephyrwolf.medievalism.data.overhauldata.level.OverhaulVanillaLevelStoneGeneration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
import net.minecraft.core.Holder;
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

public final class BasePlacedFeaturesProviderEntry
{
    // DIRT
    public static final ResourceKey<PlacedFeature> CLAY_IN_DIRT = registerKey(MedievalismConstants.resource("clay_in_dirt"));
    public static final ResourceKey<PlacedFeature> RED_CLAY_IN_DIRT = registerKey(MedievalismConstants.resource("red_clay_in_dirt"));
    public static final ResourceKey<PlacedFeature> RED_CLAY = registerKey(MedievalismConstants.resource("red_clay"));
    public static final ResourceKey<PlacedFeature> RED_CLAY_WITH_DOGBANE = registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    // STONE
    // ORE
    public static final ResourceKey<PlacedFeature> TIN_ORE = registerKey(MedievalismConstants.resource("tin_ore"));
    public static final ResourceKey<PlacedFeature> TIN_ORE_UNIFORM = registerKey(MedievalismConstants.resource("tin_ore_uniform"));
    public static final ResourceKey<PlacedFeature> CHALK_ORE = registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<PlacedFeature> CHERT_ORE = registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<PlacedFeature> GEODE_ORE = registerKey(MedievalismConstants.resource("geode_ore"));
    public static final ResourceKey<PlacedFeature> HARD_IG_ED_GEODE_ORE = registerKey(MedievalismConstants.resource("hard_ig_ex_geode_ore"));
    // ROCK
    public static final ResourceKey<PlacedFeature> SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("sandstone_rock"));
    public static final ResourceKey<PlacedFeature> RED_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("red_sandstone_rock"));
    public static final ResourceKey<PlacedFeature> GREYWACKE_ROCK = registerKey(MedievalismConstants.resource("greywacke_rock"));

    public static final ResourceKey<PlacedFeature> UNDERGROUND_ROCK = registerKey(MedievalismConstants.resource("underground_rock"));
    // LARGE ROCK
    public static final ResourceKey<PlacedFeature> LARGE_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("large_sandstone_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_RED_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("large_red_sandstone_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_GREYWACKE_ROCK = registerKey(MedievalismConstants.resource("large_greywacke_rock"));
    // COPPER ROCK
    public static final ResourceKey<PlacedFeature> GREYWACKE_ROCK_COPPER_ORE = registerKey(MedievalismConstants.resource("greywacke_rock_copper_ore"));
    // TWIGS
    public static final ResourceKey<PlacedFeature> DENSE_TWIGS = registerKey(MedievalismConstants.resource("dense_twigs"));
    public static final ResourceKey<PlacedFeature> SPARSE_TWIGS = registerKey(MedievalismConstants.resource("sparse_twigs"));
    public static final ResourceKey<PlacedFeature> RARE_TWIGS = registerKey(MedievalismConstants.resource("rare_twigs"));
    // DENSE BRANCH
    public static final ResourceKey<PlacedFeature> DENSE_OAK_BRANCH = registerKey(MedievalismConstants.resource("dense_oak_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_BIRCH_BRANCH = registerKey(MedievalismConstants.resource("dense_birch_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_SPRUCE_BRANCH = registerKey(MedievalismConstants.resource("dense_spruce_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_JUNGLE_BRANCH = registerKey(MedievalismConstants.resource("dense_jungle_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_DARK_OAK_BRANCH = registerKey(MedievalismConstants.resource("dense_dark_oak_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_CHERRY_BRANCH = registerKey(MedievalismConstants.resource("dense_cherry_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_MANGROVE_BRANCH = registerKey(MedievalismConstants.resource("dense_mangrove_branch"));
    // SPARSE BRANCH
    public static final ResourceKey<PlacedFeature> SPARSE_OAK_BRANCH = registerKey(MedievalismConstants.resource("sparse_oak_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_BIRCH_BRANCH = registerKey(MedievalismConstants.resource("sparse_birch_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_SPRUCE_BRANCH = registerKey(MedievalismConstants.resource("sparse_spruce_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_JUNGLE_BRANCH = registerKey(MedievalismConstants.resource("sparse_jungle_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_ACACIA_BRANCH = registerKey(MedievalismConstants.resource("sparse_acacia_branch"));
    // RAR BRANCH
    public static final ResourceKey<PlacedFeature> RARE_OAK_BRANCH = registerKey(MedievalismConstants.resource("rare_oak_branch"));
    public static final ResourceKey<PlacedFeature> RARE_BIRCH_BRANCH = registerKey(MedievalismConstants.resource("rare_birch_branch"));
    // WILD CROPS
    public static final ResourceKey<PlacedFeature> WILD_YAMS = registerKey(MedievalismConstants.resource("wild_yams"));

    // --

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // DIRT
        register(context, CLAY_IN_DIRT, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.CLAY_IN_DIRT), chanceOceanSurfacePlacement(10, 0, 0));
        register(context, RED_CLAY_IN_DIRT, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.RED_CLAY_IN_DIRT), chanceOceanSurfacePlacement(8, 0, 0));
        register(context, RED_CLAY, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.RED_CLAY), chanceOceanSurfacePlacement(10, -5, 0));
        register(context, RED_CLAY_WITH_DOGBANE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.RED_CLAY_WITH_DOGBANE), chanceOceanSurfacePlacement(8, 0, 0));
        // STONE
        // ORE
        register(context, TIN_ORE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.OVERWORLD_TIN_ORE),
                commonOrePlacement(5, HeightRangePlacement.triangle( VerticalAnchor.absolute(-32), VerticalAnchor.absolute(48))));
        register(context, TIN_ORE_UNIFORM, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.OVERWORLD_TIN_ORE),
                commonOrePlacement(10, HeightRangePlacement.uniform( VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
        register(context, CHALK_ORE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.CHALK_ORE),
                commonOrePlacement( 7, HeightRangePlacement.uniform(WorldGenLayerConstants.MIN_SEDIMENTARY, WorldGenLayerConstants.MAX_SEDIMENTARY)));
        register(context, CHERT_ORE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.CHERT_ORE),
                commonOrePlacement( 50, HeightRangePlacement.uniform(WorldGenLayerConstants.MIN_SEDIMENTARY, WorldGenLayerConstants.MAX_SEDIMENTARY)));
        register(context, GEODE_ORE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.GEODE_ORE),
                commonOrePlacement( 50, HeightRangePlacement.uniform( WorldGenLayerConstants.MIN_IGNEOUS_EXTRUSIVE_GROUP, WorldGenLayerConstants.MAX_IGNEOUS_EXTRUSIVE_GROUP)));
        register(context, HARD_IG_ED_GEODE_ORE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.GEODE_ORE),
                commonOrePlacement( 20, HeightRangePlacement.uniform( WorldGenLayerConstants.MIN_IGNEOUS_EXTRUSIVE_GROUP, WorldGenLayerConstants.MAX_IGNEOUS_EXTRUSIVE_GROUP)));
        // ROCK
        register(context, SANDSTONE_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.SANDSTONE_ROCK), surfacePlacement(1, 2));
        register(context, RED_SANDSTONE_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.RED_SANDSTONE_ROCK), surfacePlacement(1, 2));
        register(context, GREYWACKE_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.GREYWACKE_ROCK), surfacePlacement(1, 2));


        HeightRangePlacement HEIGHT_RANGE_SEDIMENTARY = HeightRangePlacement.uniform(
                WorldGenLayerConstants.MIN_SEDIMENTARY, WorldGenLayerConstants.MAX_SEDIMENTARY
        );

        PlacementUtils.register(
                context,
                UNDERGROUND_ROCK,
                configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.UNDERGROUND_ROCK),
                CountPlacement.of(UniformInt.of(5, 30)), // How many locations
                InSquarePlacement.spread(),
                HEIGHT_RANGE_SEDIMENTARY,
                BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, 1),
                CountPlacement.of(UniformInt.of(1, 3)), // How many in a cluster
                RandomOffsetPlacement.of(
                        ClampedNormalInt.of(0.0F, 3.0F, -7, 7), // XZ spread
                        ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), // Y spread
                BiomeFilter.biome()
        );

        //register(context, UNDERGROUND_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.UNDERGROUND_ROCK), hi);
        // LARGE ROCK
        register(context, LARGE_SANDSTONE_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.LARGE_SANDSTONE_ROCK), surfacePlacement(1, 4));
        register(context, LARGE_RED_SANDSTONE_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.LARGE_RED_SANDSTONE_ROCK), surfacePlacement(1, 4));
        register(context, LARGE_GREYWACKE_ROCK, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.LARGE_GREYWACKE_ROCK), surfacePlacement(1, 4));
        // COPPER ROCK
        register(context, GREYWACKE_ROCK_COPPER_ORE, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.GREYWACKE_ROCK_COPPER_ORE), surfacePlacement(1, 4));
        // TWIGS
        simpleChanceSurfacePlacedFeature(context, DENSE_TWIGS, BaseConfiguredFeaturesProviderEntry.DENSE_TWIGS, 4, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_TWIGS, BaseConfiguredFeaturesProviderEntry.SPARSE_TWIGS, 2, 2);
        simpleChanceSurfacePlacedFeature(context, RARE_TWIGS, BaseConfiguredFeaturesProviderEntry.RARE_TWIGS, 1, 3);
        // DENSE BRANCH
        simpleChanceSurfacePlacedFeature(context, DENSE_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_OAK_BRANCH, 4, 2);
        simpleChanceSurfacePlacedFeature(context, DENSE_BIRCH_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_BIRCH_BRANCH, 4, 2);
        simpleChanceSurfacePlacedFeature(context, DENSE_SPRUCE_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_SPRUCE_BRANCH, 4, 2);
        simpleChanceSurfacePlacedFeature(context, DENSE_JUNGLE_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_JUNGLE_BRANCH, 4, 2);
        simpleChanceSurfacePlacedFeature(context, DENSE_CHERRY_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_CHERRY_BRANCH, 4, 2);
        simpleChanceSurfacePlacedFeature(context, DENSE_DARK_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_DARK_OAK_BRANCH, 4, 2);
        simpleChanceSurfacePlacedFeature(context, DENSE_MANGROVE_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_MANGROVE_BRANCH, 4, 2);
        // SPARSE BRANCH
        simpleChanceSurfacePlacedFeature(context, SPARSE_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_OAK_BRANCH, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_BIRCH_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_BIRCH_BRANCH, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_SPRUCE_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_SPRUCE_BRANCH, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_JUNGLE_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_JUNGLE_BRANCH, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_ACACIA_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_ACACIA_BRANCH, 1, 2);
        // RARE BRANCH
        simpleChanceSurfacePlacedFeature(context, RARE_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.RARE_OAK_BRANCH, 1, 3);
        simpleChanceSurfacePlacedFeature(context, RARE_BIRCH_BRANCH, BaseConfiguredFeaturesProviderEntry.RARE_BIRCH_BRANCH, 1, 3);
        // WILD CROPS
        register(context, WILD_YAMS, configuredFeatures.getOrThrow(BaseConfiguredFeaturesProviderEntry.WILD_YAMS), surfacePlacement(1, 10));
    }

    // --

    public static void simpleChanceSurfacePlacedFeature(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, int count, int chance)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, placedFeatureKey, configuredFeatures.getOrThrow(configuredFeatureKey), surfacePlacement(count, chance));
    }

    public static ResourceKey<PlacedFeature> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, resource);
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    // --

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    @SuppressWarnings("unused")
    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> surfacePlacement(int count, int chance) {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                CountPlacement.of(count),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), // WORLD_SURFACE_WG -- WATER LEVEL
                BiomeFilter.biome());
    }

    @SuppressWarnings("unused")
    private static List<PlacementModifier> chanceOceanSurfacePlacement(int chance) {
        return chanceOceanSurfacePlacement(chance, 0, 0);
    }

    private static List<PlacementModifier> chanceOceanSurfacePlacement(int chance, int minYOffset, @SuppressWarnings("SameParameterValue") int maxYOffset) {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                RandomOffsetPlacement.vertical(UniformInt.of(minYOffset, maxYOffset)),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BiomeFilter.biome());
    }
}
