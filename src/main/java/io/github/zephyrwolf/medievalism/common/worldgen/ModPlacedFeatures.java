package io.github.zephyrwolf.medievalism.common.worldgen;

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

public final class ModPlacedFeatures
{
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey(MedievalismConstants.resource("tin_ore_placed"));
    public static final ResourceKey<PlacedFeature> TIN_ORE_UNIFORM_PLACED_KEY = registerKey(MedievalismConstants.resource("tin_ore_uniform_placed"));

    public static final ResourceKey<PlacedFeature> BRANCH_FOREST_PLACED_KEY = registerKey(MedievalismConstants.resource("branch_forest_placed"));
    public static final ResourceKey<PlacedFeature> BRANCH_PLACED_KEY = registerKey(MedievalismConstants.resource("branch_placed"));

    public static final ResourceKey<PlacedFeature> ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("rock_placed"));
    public static final ResourceKey<PlacedFeature> LARGE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("large_rock_placed"));
    public static final ResourceKey<PlacedFeature> LIMESTONE_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("limestone_rock_placed"));
    public static final ResourceKey<PlacedFeature> COPPER_ROCK_PLACED_KEY = registerKey(MedievalismConstants.resource("copper_rock_placed"));

    public static final ResourceKey<PlacedFeature> RED_CLAY_PLACED_KEY = registerKey(MedievalismConstants.resource("red_clay_placed"));
    public static final ResourceKey<PlacedFeature> RED_CLAY_WITH_DOGBANE_PLACED_KEY = registerKey(MedievalismConstants.resource("red_clay_with_dogbane_placed"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TIN_ORE_CONFIGURED_KEY),
                commonOrePlacement(
                        1,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-32),
                                VerticalAnchor.absolute(48)

                        )
                )
        );
        register(context, TIN_ORE_UNIFORM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TIN_ORE_CONFIGURED_KEY),
                commonOrePlacement(
                        10,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(80)
                        )
                )
        );

        register(context, BRANCH_FOREST_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BRANCH_FOREST_CONFIGURED_KEY), branchPlacement(2) );
        register(context, BRANCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BRANCH_CONFIGURED_KEY), branchPlacement(3) );

        register(context, ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ROCK_CONFIGURED_KEY), branchPlacement(2) );
        register(context, LARGE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_ROCK_CONFIGURED_KEY), branchPlacement(4) );
        // VV Doesnt generate everywhere, can I make rock place different types depending on biome?
        register(context, LIMESTONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMESTONE_ROCK_CONFIGURED_KEY), branchPlacement(4) );
        // Sandstone rock
        register(context, COPPER_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COPPER_ROCK_CONFIGURED_KEY), branchPlacement(4) );

        register(context, RED_CLAY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_CLAY_CONFIGURED_KEY), surfacePlacement(10, -5, 0));
        register(context, RED_CLAY_WITH_DOGBANE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_CLAY_WITH_DOGBANE_CONFIGURED_KEY), surfacePlacement(8, 0, 0));
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

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange)
    {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> branchPlacement(int chance)
    {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome());
    }

    private static List<PlacementModifier> surfacePlacement(int chance)
    {
        return surfacePlacement(chance, 0, 0);
    }

    private static List<PlacementModifier> surfacePlacement(int chance, int minYOffset, int maxYOffset)
    {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), RandomOffsetPlacement.vertical(UniformInt.of(minYOffset, maxYOffset)), HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome());
    }
}
