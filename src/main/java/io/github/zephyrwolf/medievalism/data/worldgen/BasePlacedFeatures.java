package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public final class BasePlacedFeatures
{
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey(MedievalismConstants.resource("tin_ore_placed"));
    public static final ResourceKey<PlacedFeature> TIN_ORE_UNIFORM_PLACED_KEY = registerKey(MedievalismConstants.resource("tin_ore_uniform_placed"));

    public static final ResourceKey<PlacedFeature> DENSE_OAK_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_oak_branch_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_BIRCH_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_birch_branch_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_SPRUCE_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_spruce_branch_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_JUNGLE_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_jungle_branch_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_DARK_OAK_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_dark_oak_branch_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_CHERRY_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_cherry_branch_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_MANGROVE_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_mangrove_branch_placed"));

    public static final ResourceKey<PlacedFeature> SPARSE_OAK_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("sparse_oak_branch_placed"));
    public static final ResourceKey<PlacedFeature> SPARSE_BIRCH_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("sparse_birch_branch_placed"));
    public static final ResourceKey<PlacedFeature> SPARSE_SPRUCE_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("sparse_spruce_branch_placed"));
    public static final ResourceKey<PlacedFeature> SPARSE_JUNGLE_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("sparse_jungle_branch_placed"));
    public static final ResourceKey<PlacedFeature> SPARSE_ACACIA_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("sparse_acacia_branch_placed"));

    public static final ResourceKey<PlacedFeature> RARE_OAK_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("rare_oak_branch_placed"));
    public static final ResourceKey<PlacedFeature> RARE_BIRCH_BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("rare_birch_branch_placed"));

    public static final ResourceKey<PlacedFeature> ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("rock_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_rock_placed"));
    public static final ResourceKey<PlacedFeature> RIVER_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("river_rock_placed"));
    public static final ResourceKey<PlacedFeature> SANDSTONE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("sandstone_rock_placed"));
    public static final ResourceKey<PlacedFeature> RED_SANDSTONE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("red_sandstone_rock_placed"));
    public static final ResourceKey<PlacedFeature> MOSSY_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("mossy_rock_placed"));
    public static final ResourceKey<PlacedFeature> LIGHTER_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("lighter_rock_placed"));
    public static final ResourceKey<PlacedFeature> SNOWY_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("snowy_rock_placed"));
    public static final ResourceKey<PlacedFeature> ICE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("ice_rock_placed"));

    public static final ResourceKey<PlacedFeature> LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("large_rock_placed"));
    public static final ResourceKey<PlacedFeature> DENSE_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("dense_large_rock_placed"));
    public static final ResourceKey<PlacedFeature> SANDSTONE_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("sandstone_large_rock_placed"));
    public static final ResourceKey<PlacedFeature> RED_SANDSTONE_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("red_sandstone_large_rock_placed"));
    public static final ResourceKey<PlacedFeature> MOSSY_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("mossy_large_rock_placed"));
    public static final ResourceKey<PlacedFeature> LIGHTER_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("lighter_large_rock_placed"));
    public static final ResourceKey<PlacedFeature> SNOWY_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("snowy_large_rock_placed"));
    public static final ResourceKey<PlacedFeature> ICE_LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("ice_large_rock_placed"));

    public static final ResourceKey<PlacedFeature> LIMESTONE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("limestone_rock_placed"));
    public static final ResourceKey<PlacedFeature> COPPER_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("copper_rock_placed"));

    public static final ResourceKey<PlacedFeature> RED_CLAY_PLACED_KEY = registerKey(MedievalismConstants.resource("red_clay_placed"));
    public static final ResourceKey<PlacedFeature> RED_CLAY_WITH_DOGBANE_PLACED_KEY = registerKey(MedievalismConstants.resource("red_clay_with_dogbane_placed"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.OVERWORLD_TIN_ORE_CONFIGURED_KEY),
                commonOrePlacement(
                        1,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-32),
                                VerticalAnchor.absolute(48)

                        )
                )
        );
        register(context, TIN_ORE_UNIFORM_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.OVERWORLD_TIN_ORE_CONFIGURED_KEY),
                commonOrePlacement(
                        10,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(80)
                        )
                )
        );

        simpleChanceSurfacePlacedFeature(context, DENSE_OAK_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_OAK_BRANCH_CONFIGURED_KEY, 4,2);
        simpleChanceSurfacePlacedFeature(context, DENSE_BIRCH_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_BIRCH_BRANCH_CONFIGURED_KEY, 4,2);
        simpleChanceSurfacePlacedFeature(context, DENSE_SPRUCE_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_SPRUCE_BRANCH_CONFIGURED_KEY, 4,2);
        simpleChanceSurfacePlacedFeature(context, DENSE_JUNGLE_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_JUNGLE_BRANCH_CONFIGURED_KEY, 4,2);
        simpleChanceSurfacePlacedFeature(context, DENSE_CHERRY_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_CHERRY_BRANCH_CONFIGURED_KEY, 4,2);
        simpleChanceSurfacePlacedFeature(context, DENSE_DARK_OAK_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_DARK_OAK_BRANCH_CONFIGURED_KEY, 4,2);
        simpleChanceSurfacePlacedFeature(context, DENSE_MANGROVE_BRANCH_PLACED_KEY, BaseConfiguredFeatures.DENSE_MANGROVE_BRANCH_CONFIGURED_KEY, 4,2);

        simpleChanceSurfacePlacedFeature(context, SPARSE_OAK_BRANCH_PLACED_KEY, BaseConfiguredFeatures.SPARSE_OAK_BRANCH_CONFIGURED_KEY, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_BIRCH_BRANCH_PLACED_KEY, BaseConfiguredFeatures.SPARSE_BIRCH_BRANCH_CONFIGURED_KEY, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_SPRUCE_BRANCH_PLACED_KEY, BaseConfiguredFeatures.SPARSE_SPRUCE_BRANCH_CONFIGURED_KEY, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_JUNGLE_BRANCH_PLACED_KEY, BaseConfiguredFeatures.SPARSE_JUNGLE_BRANCH_CONFIGURED_KEY, 1, 2);
        simpleChanceSurfacePlacedFeature(context, SPARSE_ACACIA_BRANCH_PLACED_KEY, BaseConfiguredFeatures.SPARSE_ACACIA_BRANCH_CONFIGURED_KEY, 1, 2);

        simpleChanceSurfacePlacedFeature(context, RARE_OAK_BRANCH_PLACED_KEY, BaseConfiguredFeatures.RARE_OAK_BRANCH_CONFIGURED_KEY, 1, 3);
        simpleChanceSurfacePlacedFeature(context, RARE_BIRCH_BRANCH_PLACED_KEY, BaseConfiguredFeatures.RARE_BIRCH_BRANCH_CONFIGURED_KEY, 1, 3);

        register(context, ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );
        register(context, DENSE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.DENSE_ROCK_CONFIGURED_KEY), surfacePlacement(2, 2) );
        register(context, RIVER_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.RIVER_ROCK_CONFIGURED_KEY), surfacePlacement(2, 2) );
        register(context, SANDSTONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.SANDSTONE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );
        register(context, RED_SANDSTONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.RED_SANDSTONE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );
        register(context, MOSSY_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.MOSSY_ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );
        register(context, LIGHTER_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.LIGHTER_ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );
        register(context, SNOWY_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.SNOWY_ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );
        register(context, ICE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.ICE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 2) );

        register(context, LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        register(context, DENSE_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.DENSE_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(2, 4) );
        register(context, SANDSTONE_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.SANDSTONE_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        register(context, RED_SANDSTONE_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.RED_SANDSTONE_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        register(context, MOSSY_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.MOSSY_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        register(context, LIGHTER_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.LIGHTER_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        register(context, SNOWY_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.SNOWY_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        register(context, ICE_LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.ICE_LARGE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );

        // VV Doesn't generate everywhere, can I make rock place different types depending on biome?
        register(context, LIMESTONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.LIMESTONE_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );
        // Sandstone rock
        register(context, COPPER_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.COPPER_ROCK_CONFIGURED_KEY), surfacePlacement(1, 4) );

        register(context, RED_CLAY_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.RED_CLAY_CONFIGURED_KEY), chanceOceanSurfacePlacement(10, -5, 0));
        register(context, RED_CLAY_WITH_DOGBANE_PLACED_KEY, configuredFeatures.getOrThrow(BaseConfiguredFeatures.RED_CLAY_WITH_DOGBANE_CONFIGURED_KEY), chanceOceanSurfacePlacement(8, 0, 0));
    }

    // --

    public static void simpleChanceSurfacePlacedFeature(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, ResourceKey<ConfiguredFeature<?,?>> configuredFeatureKey, int count, int chance)
    {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, placedFeatureKey, configuredFeatures.getOrThrow(configuredFeatureKey), surfacePlacement(count, chance) );
    }

    public static ResourceKey<PlacedFeature> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, resource);
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?,?>> configuration, List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    // --

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange)
    {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    @SuppressWarnings("unused")
    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange)
    {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> surfacePlacement(int count, int chance)
    {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                CountPlacement.of(count),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), // WORLD_SURFACE_WG -- WATER LEVEL
                BiomeFilter.biome());
    }

    @SuppressWarnings("unused")
    private static List<PlacementModifier> chanceOceanSurfacePlacement(int chance)
    {
        return chanceOceanSurfacePlacement(chance, 0, 0);
    }

    private static List<PlacementModifier> chanceOceanSurfacePlacement(int chance, int minYOffset, @SuppressWarnings("SameParameterValue") int maxYOffset)
    {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                RandomOffsetPlacement.vertical(UniformInt.of(minYOffset, maxYOffset)),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BiomeFilter.biome());
    }
}
