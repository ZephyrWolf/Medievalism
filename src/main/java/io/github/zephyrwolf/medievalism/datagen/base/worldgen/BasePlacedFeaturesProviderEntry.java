package io.github.zephyrwolf.medievalism.datagen.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.PlacementTools;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
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
    public static final ResourceKey<PlacedFeature> CLAY_IN_DIRT = PlacementTools.registerKey(MedievalismConstants.resource("clay_in_dirt"));
    public static final ResourceKey<PlacedFeature> CLAY_WITH_DOGBANE = PlacementTools.registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    // STONE
    // ORE
    public static final ResourceKey<PlacedFeature> CHALK_ORE = PlacementTools.registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<PlacedFeature> CHERT_ORE = PlacementTools.registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<PlacedFeature> GEODE_ORE = PlacementTools.registerKey(MedievalismConstants.resource("geode_ore"));
    public static final ResourceKey<PlacedFeature> HARD_IG_ED_GEODE_ORE = PlacementTools.registerKey(MedievalismConstants.resource("hard_ig_ex_geode_ore"));
    // ROCK
    public static final ResourceKey<PlacedFeature> SURFACE_SANDSTONE_ROCKS = PlacementTools.registerKey(MedievalismConstants.resource("surface_sandstone_rocks"));
    public static final ResourceKey<PlacedFeature> SURFACE_RED_SANDSTONE_ROCKS = PlacementTools.registerKey(MedievalismConstants.resource("surface_red_sandstone_rocks"));
    public static final ResourceKey<PlacedFeature> SURFACE_ROCKS = PlacementTools.registerKey(MedievalismConstants.resource("surface_rocks"));
    public static final ResourceKey<PlacedFeature> CAVE_ROCKS = PlacementTools.registerKey(MedievalismConstants.resource("cave_rocks"));
    // TWIGS
    public static final ResourceKey<PlacedFeature> DENSE_TWIGS = PlacementTools.registerKey(MedievalismConstants.resource("dense_twigs"));
    public static final ResourceKey<PlacedFeature> SPARSE_TWIGS = PlacementTools.registerKey(MedievalismConstants.resource("sparse_twigs"));
    public static final ResourceKey<PlacedFeature> RARE_TWIGS = PlacementTools.registerKey(MedievalismConstants.resource("rare_twigs"));
    // DENSE BRANCH
    public static final ResourceKey<PlacedFeature> DENSE_OAK_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_oak_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_BIRCH_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_birch_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_SPRUCE_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_spruce_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_JUNGLE_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_jungle_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_DARK_OAK_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_dark_oak_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_CHERRY_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_cherry_branch"));
    public static final ResourceKey<PlacedFeature> DENSE_MANGROVE_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("dense_mangrove_branch"));
    // SPARSE BRANCH
    public static final ResourceKey<PlacedFeature> SPARSE_OAK_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("sparse_oak_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_BIRCH_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("sparse_birch_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_SPRUCE_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("sparse_spruce_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_JUNGLE_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("sparse_jungle_branch"));
    public static final ResourceKey<PlacedFeature> SPARSE_ACACIA_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("sparse_acacia_branch"));
    // RAR BRANCH
    public static final ResourceKey<PlacedFeature> RARE_OAK_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("rare_oak_branch"));
    public static final ResourceKey<PlacedFeature> RARE_BIRCH_BRANCH = PlacementTools.registerKey(MedievalismConstants.resource("rare_birch_branch"));
    // WILD CROPS
    public static final ResourceKey<PlacedFeature> WILD_BARLEY = PlacementTools.registerKey(MedievalismConstants.resource("wild_barley"));
    public static final ResourceKey<PlacedFeature> WILD_BEETROOT = PlacementTools.registerKey(MedievalismConstants.resource("wild_beetroot"));
    public static final ResourceKey<PlacedFeature> WILD_BLUEBERRIES = PlacementTools.registerKey(MedievalismConstants.resource("wild_blueberries"));
    public static final ResourceKey<PlacedFeature> WILD_BROAD_BEAN = PlacementTools.registerKey(MedievalismConstants.resource("wild_broad_bean"));
    public static final ResourceKey<PlacedFeature> WILD_CABBAGE = PlacementTools.registerKey(MedievalismConstants.resource("wild_cabbage"));
    public static final ResourceKey<PlacedFeature> WILD_CARROT = PlacementTools.registerKey(MedievalismConstants.resource("wild_carrot"));
    public static final ResourceKey<PlacedFeature> WILD_CHARD = PlacementTools.registerKey(MedievalismConstants.resource("wild_chard"));
    public static final ResourceKey<PlacedFeature> WILD_DOGBANE = PlacementTools.registerKey(MedievalismConstants.resource("wild_dogbane"));
    public static final ResourceKey<PlacedFeature> WILD_FLAX = PlacementTools.registerKey(MedievalismConstants.resource("wild_flax"));
    public static final ResourceKey<PlacedFeature> WILD_GARLIC = PlacementTools.registerKey(MedievalismConstants.resource("wild_garlic"));
    public static final ResourceKey<PlacedFeature> WILD_GREEN_PUMPKIN = PlacementTools.registerKey(MedievalismConstants.resource("wild_green_pumpkin"));
    public static final ResourceKey<PlacedFeature> WILD_LEEK = PlacementTools.registerKey(MedievalismConstants.resource("wild_leek"));
    public static final ResourceKey<PlacedFeature> WILD_MELON = PlacementTools.registerKey(MedievalismConstants.resource("wild_melon"));
    public static final ResourceKey<PlacedFeature> WILD_NAPA_CABBAGE = PlacementTools.registerKey(MedievalismConstants.resource("wild_napa_cabbage"));
    public static final ResourceKey<PlacedFeature> WILD_NETTLE = PlacementTools.registerKey(MedievalismConstants.resource("wild_nettle"));
    public static final ResourceKey<PlacedFeature> WILD_OATS = PlacementTools.registerKey(MedievalismConstants.resource("wild_oats"));
    public static final ResourceKey<PlacedFeature> WILD_PARSNIP = PlacementTools.registerKey(MedievalismConstants.resource("wild_parsnip"));
    public static final ResourceKey<PlacedFeature> WILD_POTATO = PlacementTools.registerKey(MedievalismConstants.resource("wild_potato"));
    public static final ResourceKey<PlacedFeature> WILD_PUMPKIN = PlacementTools.registerKey(MedievalismConstants.resource("wild_pumpkin"));
    public static final ResourceKey<PlacedFeature> WILD_PURPLE_CARROT = PlacementTools.registerKey(MedievalismConstants.resource("wild_purple_carrot"));
    public static final ResourceKey<PlacedFeature> WILD_PURPLE_ONION = PlacementTools.registerKey(MedievalismConstants.resource("wild_purple_onion"));
    public static final ResourceKey<PlacedFeature> WILD_PURPLE_SKIRRET = PlacementTools.registerKey(MedievalismConstants.resource("wild_purple_skirret"));
    public static final ResourceKey<PlacedFeature> WILD_RADISH = PlacementTools.registerKey(MedievalismConstants.resource("wild_radish"));
    public static final ResourceKey<PlacedFeature> WILD_RASPBERRIES = PlacementTools.registerKey(MedievalismConstants.resource("wild_raspberries"));
    public static final ResourceKey<PlacedFeature> WILD_SKIRRET = PlacementTools.registerKey(MedievalismConstants.resource("wild_skirret"));
    public static final ResourceKey<PlacedFeature> WILD_SPINACH = PlacementTools.registerKey(MedievalismConstants.resource("wild_spinach"));
    public static final ResourceKey<PlacedFeature> WILD_STRAWBERRIES = PlacementTools.registerKey(MedievalismConstants.resource("wild_strawberries"));
    public static final ResourceKey<PlacedFeature> WILD_TURNIP = PlacementTools.registerKey(MedievalismConstants.resource("wild_turnip"));
    public static final ResourceKey<PlacedFeature> WILD_WHITE_CARROT = PlacementTools.registerKey(MedievalismConstants.resource("wild_white_carrot"));
    public static final ResourceKey<PlacedFeature> WILD_WHITE_ONION = PlacementTools.registerKey(MedievalismConstants.resource("wild_white_onion"));
    public static final ResourceKey<PlacedFeature> WILD_YAM = PlacementTools.registerKey(MedievalismConstants.resource("wild_yam"));
    public static final ResourceKey<PlacedFeature> WILD_WHEAT = PlacementTools.registerKey(MedievalismConstants.resource("wild_wheat"));

    // --

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // DIRT
        PlacementTools.register(context, CLAY_IN_DIRT, BaseConfiguredFeaturesProviderEntry.CLAY_IN_DIRT, PlacementTools.chanceOceanSurfacePlacement(10, 0, 0));
        PlacementTools.register(context, CLAY_WITH_DOGBANE, BaseConfiguredFeaturesProviderEntry.CLAY_WITH_DOGBANE, PlacementTools.chanceOceanSurfacePlacement(8, 0, 0));
        // STONE
        // ORE
        PlacementTools.register(context, CHALK_ORE, BaseConfiguredFeaturesProviderEntry.CHALK_ORE,
                PlacementTools.commonOrePlacement(7, HeightRangePlacement.uniform(WorldGenLayerConstants.MIN_SEDIMENTARY, WorldGenLayerConstants.MAX_SEDIMENTARY)));
        PlacementTools.register(context, CHERT_ORE, BaseConfiguredFeaturesProviderEntry.CHERT_ORE,
                PlacementTools.commonOrePlacement(50, HeightRangePlacement.uniform(WorldGenLayerConstants.MIN_SEDIMENTARY, WorldGenLayerConstants.MAX_SEDIMENTARY)));
        PlacementTools.register(context, GEODE_ORE, BaseConfiguredFeaturesProviderEntry.GEODE_ORE,
                PlacementTools.commonOrePlacement(50, HeightRangePlacement.uniform(WorldGenLayerConstants.MIN_IGNEOUS_EXTRUSIVE_GROUP, WorldGenLayerConstants.MAX_IGNEOUS_EXTRUSIVE_GROUP)));
        PlacementTools.register(context, HARD_IG_ED_GEODE_ORE, BaseConfiguredFeaturesProviderEntry.GEODE_ORE,
                PlacementTools.commonOrePlacement(20, HeightRangePlacement.uniform(WorldGenLayerConstants.MIN_IGNEOUS_EXTRUSIVE_GROUP, WorldGenLayerConstants.MAX_IGNEOUS_EXTRUSIVE_GROUP)));
        // ROCK
        HeightRangePlacement HEIGHT_RANGE_STONE = HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.TOP);
        HeightRangePlacement HEIGHT_RANGE_DEEPSLATE = HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(0));

        List<PlacementModifier> SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES = PlacementTools.surfacePlacement(1, 1, 2);
        List<PlacementModifier> SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES = PlacementTools.surfacePlacement(1, 1, 2);
        List<PlacementModifier> SURFACE_GREYWACKE_ROCKS_PLACEMENT_RULES = PlacementTools.surfacePlacement(1, 4, 2);
        List<PlacementModifier> CAVE_GREYWACKE_ROCKS_PLACEMENT_RULES = PlacementTools.cavePlacement(10, 30, 1, HEIGHT_RANGE_STONE, 1);
        List<PlacementModifier> CAVE_GABBRO_ROCKS_PLACEMENT_RULES = PlacementTools.cavePlacement(10, 30, 1, HEIGHT_RANGE_DEEPSLATE, 1);

        PlacementTools.register(context, SURFACE_SANDSTONE_ROCKS, BaseConfiguredFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS, SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_RED_SANDSTONE_ROCKS, BaseConfiguredFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS, SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_ROCKS, BaseConfiguredFeaturesProviderEntry.SURFACE_ROCKS, SURFACE_GREYWACKE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, CAVE_ROCKS, BaseConfiguredFeaturesProviderEntry.CAVE_ROCKS, CAVE_GREYWACKE_ROCKS_PLACEMENT_RULES);
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
        PlacementTools.register(context, WILD_BARLEY,           BaseConfiguredFeaturesProviderEntry.WILD_BARLEY,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_BEETROOT,         BaseConfiguredFeaturesProviderEntry.WILD_BEETROOT,          PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_BLUEBERRIES,      BaseConfiguredFeaturesProviderEntry.WILD_BLUEBERRIES,       PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_BROAD_BEAN,       BaseConfiguredFeaturesProviderEntry.WILD_BROAD_BEAN,        PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_CABBAGE,          BaseConfiguredFeaturesProviderEntry.WILD_CABBAGE,           PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_CARROT,           BaseConfiguredFeaturesProviderEntry.WILD_CARROT,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_CHARD,            BaseConfiguredFeaturesProviderEntry.WILD_CHARD,             PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_DOGBANE,          BaseConfiguredFeaturesProviderEntry.WILD_DOGBANE,           PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_FLAX,             BaseConfiguredFeaturesProviderEntry.WILD_FLAX,              PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_GARLIC,           BaseConfiguredFeaturesProviderEntry.WILD_GARLIC,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_GREEN_PUMPKIN,    BaseConfiguredFeaturesProviderEntry.WILD_GREEN_PUMPKIN,     PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_LEEK,             BaseConfiguredFeaturesProviderEntry.WILD_LEEK,              PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_MELON,            BaseConfiguredFeaturesProviderEntry.WILD_MELON,             PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_NAPA_CABBAGE,     BaseConfiguredFeaturesProviderEntry.WILD_NAPA_CABBAGE,      PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_NETTLE,           BaseConfiguredFeaturesProviderEntry.WILD_NETTLE,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_OATS,             BaseConfiguredFeaturesProviderEntry.WILD_OATS,              PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_PARSNIP,          BaseConfiguredFeaturesProviderEntry.WILD_PARSNIP,           PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_POTATO,           BaseConfiguredFeaturesProviderEntry.WILD_POTATO,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_PUMPKIN,          BaseConfiguredFeaturesProviderEntry.WILD_PUMPKIN,           PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_PURPLE_CARROT,    BaseConfiguredFeaturesProviderEntry.WILD_PURPLE_CARROT,     PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_PURPLE_ONION,     BaseConfiguredFeaturesProviderEntry.WILD_PURPLE_ONION,      PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_PURPLE_SKIRRET,   BaseConfiguredFeaturesProviderEntry.WILD_PURPLE_SKIRRET,    PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_RADISH,           BaseConfiguredFeaturesProviderEntry.WILD_RADISH,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_RASPBERRIES,      BaseConfiguredFeaturesProviderEntry.WILD_RASPBERRIES,       PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_SKIRRET,          BaseConfiguredFeaturesProviderEntry.WILD_SKIRRET,           PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_SPINACH,          BaseConfiguredFeaturesProviderEntry.WILD_SPINACH,           PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_STRAWBERRIES,     BaseConfiguredFeaturesProviderEntry.WILD_STRAWBERRIES,      PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_TURNIP,           BaseConfiguredFeaturesProviderEntry.WILD_TURNIP,            PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_WHITE_CARROT,     BaseConfiguredFeaturesProviderEntry.WILD_WHITE_CARROT,      PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_WHITE_ONION,      BaseConfiguredFeaturesProviderEntry.WILD_WHITE_ONION,       PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_YAM,              BaseConfiguredFeaturesProviderEntry.WILD_YAM,               PlacementTools.surfacePlacementChance(20));
        PlacementTools.register(context, WILD_WHEAT,            BaseConfiguredFeaturesProviderEntry.WILD_WHEAT,             PlacementTools.surfacePlacementChance(20));
    }
}
