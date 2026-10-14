package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.PlacementTools;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public final class BasePlacedFeaturesProviderEntry
{
    // DIRT
    public static final ResourceKey<PlacedFeature> CLAY_IN_DIRT =                   PlacementTools.registerKey(MedievalismConstants.resource("clay_in_dirt"));
    public static final ResourceKey<PlacedFeature> RED_CLAY_IN_DIRT =               PlacementTools.registerKey(MedievalismConstants.resource("red_clay_in_dirt"));
    public static final ResourceKey<PlacedFeature> RED_CLAY =                       PlacementTools.registerKey(MedievalismConstants.resource("red_clay"));
    public static final ResourceKey<PlacedFeature> RED_CLAY_WITH_DOGBANE =          PlacementTools.registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    // STONE
    // ORE
    public static final ResourceKey<PlacedFeature> TIN_ORE =                        PlacementTools.registerKey(MedievalismConstants.resource("tin_ore"));
    public static final ResourceKey<PlacedFeature> TIN_ORE_UNIFORM =                PlacementTools.registerKey(MedievalismConstants.resource("tin_ore_uniform"));
    public static final ResourceKey<PlacedFeature> CHALK_ORE =                      PlacementTools.registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<PlacedFeature> CHERT_ORE =                      PlacementTools.registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<PlacedFeature> GEODE_ORE =                      PlacementTools.registerKey(MedievalismConstants.resource("geode_ore"));
    public static final ResourceKey<PlacedFeature> HARD_IG_ED_GEODE_ORE =           PlacementTools.registerKey(MedievalismConstants.resource("hard_ig_ex_geode_ore"));
    // ROCK
    public static final ResourceKey<PlacedFeature> SURFACE_SANDSTONE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_sandstone_rocks"));
    public static final ResourceKey<PlacedFeature> SURFACE_RED_SANDSTONE_ROCKS =    PlacementTools.registerKey(MedievalismConstants.resource("surface_red_sandstone_rocks"));
    public static final ResourceKey<PlacedFeature> SURFACE_GREYWACKE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_greywacke_rocks"));
    public static final ResourceKey<PlacedFeature> CAVE_GREYWACKE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("cave_greywacke_rocks"));
    public static final ResourceKey<PlacedFeature> CAVE_GABBRO_ROCKS =              PlacementTools.registerKey(MedievalismConstants.resource("cave_gabbro_rocks"));
    // TWIGS
    public static final ResourceKey<PlacedFeature> DENSE_TWIGS =                    PlacementTools.registerKey(MedievalismConstants.resource("dense_twigs"));
    public static final ResourceKey<PlacedFeature> SPARSE_TWIGS =                   PlacementTools.registerKey(MedievalismConstants.resource("sparse_twigs"));
    public static final ResourceKey<PlacedFeature> RARE_TWIGS =                     PlacementTools.registerKey(MedievalismConstants.resource("rare_twigs"));
    // DENSE BRANCH
    public static final ResourceKey<PlacedFeature> DENSE_OAK_BRANCH =               PlacementTools.registerKey(MedievalismConstants.resource("dense_oak_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_BIRCH_BRANCH =             PlacementTools.registerKey(MedievalismConstants.resource("dense_birch_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_SPRUCE_BRANCH =            PlacementTools.registerKey(MedievalismConstants.resource("dense_spruce_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_JUNGLE_BRANCH =            PlacementTools.registerKey(MedievalismConstants.resource("dense_jungle_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_DARK_OAK_BRANCH =          PlacementTools.registerKey(MedievalismConstants.resource("dense_dark_oak_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_CHERRY_BRANCH =            PlacementTools.registerKey(MedievalismConstants.resource("dense_cherry_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_MANGROVE_BRANCH =          PlacementTools.registerKey(MedievalismConstants.resource("dense_mangrove_branch"));
    // SPARSE BRANCH
    public static final ResourceKey<PlacedFeature> SPARSE_OAK_BRANCH =              PlacementTools.registerKey(MedievalismConstants.resource("sparse_oak_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_BIRCH_BRANCH =            PlacementTools.registerKey(MedievalismConstants.resource("sparse_birch_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_SPRUCE_BRANCH =           PlacementTools.registerKey(MedievalismConstants.resource("sparse_spruce_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_JUNGLE_BRANCH =           PlacementTools.registerKey(MedievalismConstants.resource("sparse_jungle_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_ACACIA_BRANCH =           PlacementTools.registerKey(MedievalismConstants.resource("sparse_acacia_branch"));
    // RAR BRANCH
    public static final ResourceKey<PlacedFeature> RARE_OAK_BRANCH =                PlacementTools.registerKey(MedievalismConstants.resource("rare_oak_branch"));
    public static final ResourceKey<PlacedFeature> RARE_BIRCH_BRANCH =              PlacementTools.registerKey(MedievalismConstants.resource("rare_birch_branch"));
    // WILD CROPS
    public static final ResourceKey<PlacedFeature> WILD_YAMS =                      PlacementTools.registerKey(MedievalismConstants.resource("wild_yams"));

    // --

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // DIRT
        PlacementTools.register(context, CLAY_IN_DIRT,             BaseConfiguredFeaturesProviderEntry.CLAY_IN_DIRT,           PlacementTools.chanceOceanSurfacePlacement(10, 0, 0));
        PlacementTools.register(context, RED_CLAY_IN_DIRT,         BaseConfiguredFeaturesProviderEntry.RED_CLAY_IN_DIRT,       PlacementTools.chanceOceanSurfacePlacement(8, 0, 0));
        PlacementTools.register(context, RED_CLAY,                 BaseConfiguredFeaturesProviderEntry.RED_CLAY,               PlacementTools.chanceOceanSurfacePlacement(10, -5, 0));
        PlacementTools.register(context, RED_CLAY_WITH_DOGBANE,    BaseConfiguredFeaturesProviderEntry.RED_CLAY_WITH_DOGBANE,  PlacementTools.chanceOceanSurfacePlacement(8, 0, 0));
        // STONE
        // ORE
        PlacementTools.register(context, TIN_ORE, BaseConfiguredFeaturesProviderEntry.OVERWORLD_TIN_ORE,
                PlacementTools.commonOrePlacement(5, HeightRangePlacement.triangle( VerticalAnchor.absolute(-32), VerticalAnchor.absolute(48))));
        PlacementTools.register(context, TIN_ORE_UNIFORM, BaseConfiguredFeaturesProviderEntry.OVERWORLD_TIN_ORE,
                PlacementTools.commonOrePlacement(10, HeightRangePlacement.uniform( VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
        PlacementTools.register(context, CHALK_ORE, BaseConfiguredFeaturesProviderEntry.CHALK_ORE,
                PlacementTools.commonOrePlacement( 7, HeightRangePlacement.uniform(WorldGenLayerCatalog.MIN_SEDIMENTARY, WorldGenLayerCatalog.MAX_SEDIMENTARY)));
        PlacementTools.register(context, CHERT_ORE, BaseConfiguredFeaturesProviderEntry.CHERT_ORE,
                PlacementTools.commonOrePlacement( 50, HeightRangePlacement.uniform(WorldGenLayerCatalog.MIN_SEDIMENTARY, WorldGenLayerCatalog.MAX_SEDIMENTARY)));
        PlacementTools.register(context, GEODE_ORE, BaseConfiguredFeaturesProviderEntry.GEODE_ORE,
                PlacementTools.commonOrePlacement( 50, HeightRangePlacement.uniform( WorldGenLayerCatalog.MIN_IGNEOUS_EXTRUSIVE_GROUP, WorldGenLayerCatalog.MAX_IGNEOUS_EXTRUSIVE_GROUP)));
        PlacementTools.register(context, HARD_IG_ED_GEODE_ORE, BaseConfiguredFeaturesProviderEntry.GEODE_ORE,
                PlacementTools.commonOrePlacement( 20, HeightRangePlacement.uniform( WorldGenLayerCatalog.MIN_IGNEOUS_EXTRUSIVE_GROUP, WorldGenLayerCatalog.MAX_IGNEOUS_EXTRUSIVE_GROUP)));
        // ROCK
        HeightRangePlacement HEIGHT_RANGE_STONE = HeightRangePlacement.uniform( VerticalAnchor.absolute(0), VerticalAnchor.TOP );
        HeightRangePlacement HEIGHT_RANGE_DEEPSLATE = HeightRangePlacement.uniform( VerticalAnchor.BOTTOM, VerticalAnchor.absolute(0) );

        List<PlacementModifier> SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES = PlacementTools.surfacePlacement(1, 1, 2);
        List<PlacementModifier> SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES = PlacementTools.surfacePlacement(1, 1, 2);
        List<PlacementModifier> SURFACE_GREYWACKE_ROCKS_PLACEMENT_RULES = PlacementTools.surfacePlacement(1, 1, 2);
        List<PlacementModifier> CAVE_GREYWACKE_ROCKS_PLACEMENT_RULES = PlacementTools.cavePlacement(10, 30, 1, HEIGHT_RANGE_STONE, 1);
        List<PlacementModifier> CAVE_GABBRO_ROCKS_PLACEMENT_RULES = PlacementTools.cavePlacement(10, 30, 1, HEIGHT_RANGE_DEEPSLATE, 1);

        PlacementTools.register(context,    SURFACE_SANDSTONE_ROCKS,        BaseConfiguredFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS,        SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context,    SURFACE_RED_SANDSTONE_ROCKS,    BaseConfiguredFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS,    SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context,    SURFACE_GREYWACKE_ROCKS,        BaseConfiguredFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS,        SURFACE_GREYWACKE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context,    CAVE_GREYWACKE_ROCKS,           BaseConfiguredFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS,        CAVE_GREYWACKE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context,    CAVE_GABBRO_ROCKS,              BaseConfiguredFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS,        CAVE_GABBRO_ROCKS_PLACEMENT_RULES);
        // TWIGS
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_TWIGS, BaseConfiguredFeaturesProviderEntry.DENSE_TWIGS, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, SPARSE_TWIGS, BaseConfiguredFeaturesProviderEntry.SPARSE_TWIGS, 2, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, RARE_TWIGS, BaseConfiguredFeaturesProviderEntry.RARE_TWIGS, 1, 3);
        // DENSE BRANCH
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_OAK_BRANCH, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_BIRCH_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_BIRCH_BRANCH, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_SPRUCE_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_SPRUCE_BRANCH, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_JUNGLE_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_JUNGLE_BRANCH, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_CHERRY_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_CHERRY_BRANCH, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_DARK_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_DARK_OAK_BRANCH, 4, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, DENSE_MANGROVE_BRANCH, BaseConfiguredFeaturesProviderEntry.DENSE_MANGROVE_BRANCH, 4, 2);
        // SPARSE BRANCH
        PlacementTools.simpleChanceSurfacePlacedFeature(context, SPARSE_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_OAK_BRANCH, 1, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, SPARSE_BIRCH_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_BIRCH_BRANCH, 1, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, SPARSE_SPRUCE_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_SPRUCE_BRANCH, 1, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, SPARSE_JUNGLE_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_JUNGLE_BRANCH, 1, 2);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, SPARSE_ACACIA_BRANCH, BaseConfiguredFeaturesProviderEntry.SPARSE_ACACIA_BRANCH, 1, 2);
        // RARE BRANCH
        PlacementTools.simpleChanceSurfacePlacedFeature(context, RARE_OAK_BRANCH, BaseConfiguredFeaturesProviderEntry.RARE_OAK_BRANCH, 1, 3);
        PlacementTools.simpleChanceSurfacePlacedFeature(context, RARE_BIRCH_BRANCH, BaseConfiguredFeaturesProviderEntry.RARE_BIRCH_BRANCH, 1, 3);
        // WILD CROPS
        PlacementTools.register(context, WILD_YAMS, BaseConfiguredFeaturesProviderEntry.WILD_YAMS, PlacementTools.surfacePlacement(1, 1, 10));
    }
}
