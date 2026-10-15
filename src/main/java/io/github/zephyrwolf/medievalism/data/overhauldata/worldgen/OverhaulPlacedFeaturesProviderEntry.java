package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.PlacementTools;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BasePlacedFeaturesProviderEntry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public final class OverhaulPlacedFeaturesProviderEntry
{
    // ===Vanilla===
    // ORE
    public static final ResourceKey<PlacedFeature> ORE_DIRT =               PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_dirt"));
    public static final ResourceKey<PlacedFeature> ORE_CLAY =               PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_clay"));
    public static final ResourceKey<PlacedFeature> ORE_GRAVEL =             PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gravel"));
    public static final ResourceKey<PlacedFeature> ORE_ANDESITE_LOWER =     PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_andesite_lower"));
    public static final ResourceKey<PlacedFeature> ORE_ANDESITE_UPPER =     PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_andesite_upper"));
    public static final ResourceKey<PlacedFeature> ORE_DIORITE_LOWER =      PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diorite_lower"));
    public static final ResourceKey<PlacedFeature> ORE_DIORITE_UPPER =      PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diorite_upper"));
    public static final ResourceKey<PlacedFeature> ORE_GRANITE_LOWER =      PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_granite_lower"));
    public static final ResourceKey<PlacedFeature> ORE_GRANITE_UPPER =      PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_granite_upper"));
    public static final ResourceKey<PlacedFeature> ORE_TUFF =               PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_tuff"));
    public static final ResourceKey<PlacedFeature> ORE_INFESTED =           PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_infested"));
    public static final ResourceKey<PlacedFeature> ORE_COPPER =             PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_copper"));
    public static final ResourceKey<PlacedFeature> ORE_COPPER_LARGE =       PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_copper_large"));
    public static final ResourceKey<PlacedFeature> ORE_IRON_MIDDLE =        PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_iron_middle"));
    public static final ResourceKey<PlacedFeature> ORE_IRON_SMALL =         PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_iron_small"));
    public static final ResourceKey<PlacedFeature> ORE_IRON_UPPER =         PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_iron_upper"));
    public static final ResourceKey<PlacedFeature> ORE_GOLD =               PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gold"));
    public static final ResourceKey<PlacedFeature> ORE_GOLD_EXTRA =         PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gold_extra"));
    public static final ResourceKey<PlacedFeature> ORE_GOLD_LOWER =         PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gold_lower"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND =            PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_BURIED =     PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_buried"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_LARGE =      PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_large"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_MEDIUM =     PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_medium"));
    public static final ResourceKey<PlacedFeature> ORE_EMERALD =            PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_emerald"));
    public static final ResourceKey<PlacedFeature> ORE_COAL_LOWER =         PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_coal_lower"));
    public static final ResourceKey<PlacedFeature> ORE_COAL_UPPER =         PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_coal_upper"));
    public static final ResourceKey<PlacedFeature> ORE_LAPIS =              PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_lapis"));
    public static final ResourceKey<PlacedFeature> ORE_LAPIS_BURIED =       PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_lapis_buried"));
    public static final ResourceKey<PlacedFeature> ORE_REDSTONE =           PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_redstone"));
    public static final ResourceKey<PlacedFeature> ORE_REDSTONE_LOWER =     PlacementTools.registerKey(ResourceLocation.withDefaultNamespace("ore_redstone_lower"));

    // === Medievalism===
    // ROCKS
    public static final ResourceKey<PlacedFeature> SURFACE_SANDSTONE_ROCKS =        BasePlacedFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS;
    public static final ResourceKey<PlacedFeature> SURFACE_RED_SANDSTONE_ROCKS =    BasePlacedFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS;
    //public static final ResourceKey<PlacedFeature> SURFACE_SAPROLITE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_saprolite_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_LATERITE_ROCKS =         PlacementTools.registerKey(MedievalismConstants.resource("surface_laterite_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_SILT_CLUMPS =            PlacementTools.registerKey(MedievalismConstants.resource("surface_silt_clumps"));
    //public static final ResourceKey<PlacedFeature> SURFACE_GREYWACKE_ROCKS =        BasePlacedFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS;
    //public static final ResourceKey<PlacedFeature> SURFACE_SILTSTONE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_siltstone_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_DOLOSTONE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_dolostone_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_LIMESTONE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_limestone_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_IRONSTONE_ROCKS =        PlacementTools.registerKey(MedievalismConstants.resource("surface_ironstone_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_SHALE_ROCKS =            PlacementTools.registerKey(MedievalismConstants.resource("surface_shale_rocks"));
    //public static final ResourceKey<PlacedFeature> SURFACE_ARKOSE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("surface_arkose_rocks"));
    public static final ResourceKey<PlacedFeature> SURFACE_ROCKS =                  BasePlacedFeaturesProviderEntry.SURFACE_ROCKS;
    public static final ResourceKey<PlacedFeature> SURFACE_SEDIMENTARY_ROCKS =      PlacementTools.registerKey(MedievalismConstants.resource("surface_sedimentary_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_GREYWACKE_ROCKS =           BasePlacedFeaturesProviderEntry.CAVE_GREYWACKE_ROCKS;
    //public static final ResourceKey<PlacedFeature> CAVE_SILTSTONE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("cave_siltstone_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_DOLOSTONE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("cave_dolostone_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_LIMESTONE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("cave_limestone_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_IRONSTONE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("cave_ironstone_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_SHALE_ROCKS =               PlacementTools.registerKey(MedievalismConstants.resource("cave_shale_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_ARKOSE_ROCKS =              PlacementTools.registerKey(MedievalismConstants.resource("cave_arkose_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_MARBLE_ROCKS =              PlacementTools.registerKey(MedievalismConstants.resource("cave_marble_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_QUARTZITE_ROCKS =           PlacementTools.registerKey(MedievalismConstants.resource("cave_quartzite_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_HORNFELS_ROCKS =            PlacementTools.registerKey(MedievalismConstants.resource("cave_hornfels_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_SLATE_ROCKS =               PlacementTools.registerKey(MedievalismConstants.resource("cave_slate_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_GABBRO_ROCKS =              BasePlacedFeaturesProviderEntry.CAVE_GABBRO_ROCKS;
    //public static final ResourceKey<PlacedFeature> CAVE_SMOOTH_DIORITE_ROCKS =      PlacementTools.registerKey(MedievalismConstants.resource("cave_smooth_diorite_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_SMOOTH_GRANITE_ROCKS =      PlacementTools.registerKey(MedievalismConstants.resource("cave_smooth_granite_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_NORITE_ROCKS =              PlacementTools.registerKey(MedievalismConstants.resource("cave_norite_rocks"));
    //public static final ResourceKey<PlacedFeature> CAVE_PERIDOTITE_ROCKS =          PlacementTools.registerKey(MedievalismConstants.resource("cave_peridotite_rocks"));
    public static final ResourceKey<PlacedFeature> CAVE_ROCKS =                     PlacementTools.registerKey(MedievalismConstants.resource("cave_rocks"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        bootstrap_vanilla(context);
        bootstrap_medievalism(context);
    }

    public static void bootstrap_vanilla(BootstrapContext<PlacedFeature> context)
    {
        PlacementTools.register(context, ORE_DIRT, OverhaulConfiguredFeaturesProviderEntry.ORE_DIRT,
                PlacementTools.commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        PlacementTools.register(context, ORE_CLAY, OverhaulConfiguredFeaturesProviderEntry.ORE_CLAY,
                PlacementTools.commonOrePlacement( 46, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256))));
        PlacementTools.register(context, ORE_GRAVEL, OverhaulConfiguredFeaturesProviderEntry.ORE_GRAVEL,
                PlacementTools.commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0))));
        PlacementTools.register(context, ORE_ANDESITE_LOWER, OverhaulConfiguredFeaturesProviderEntry.ORE_ANDESITE,
                PlacementTools.commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        PlacementTools.register(context, ORE_ANDESITE_UPPER, OverhaulConfiguredFeaturesProviderEntry.ORE_ANDESITE,
                PlacementTools.rarityOrePlacement( 6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        PlacementTools.register(context, ORE_DIORITE_LOWER, OverhaulConfiguredFeaturesProviderEntry.ORE_DIORITE,
                PlacementTools.commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        PlacementTools.register(context, ORE_DIORITE_UPPER, OverhaulConfiguredFeaturesProviderEntry.ORE_DIORITE,
                PlacementTools.rarityOrePlacement( 6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        PlacementTools.register(context, ORE_GRANITE_LOWER, OverhaulConfiguredFeaturesProviderEntry.ORE_GRANITE,
                PlacementTools.commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        PlacementTools.register(context, ORE_GRANITE_UPPER, OverhaulConfiguredFeaturesProviderEntry.ORE_GRANITE,
                PlacementTools.rarityOrePlacement( 6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        PlacementTools.register(context, ORE_TUFF, OverhaulConfiguredFeaturesProviderEntry.ORE_TUFF,
                PlacementTools.commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        PlacementTools.register(context, ORE_INFESTED, OverhaulConfiguredFeaturesProviderEntry.ORE_INFESTED,
                PlacementTools.commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        PlacementTools.register(context, ORE_COPPER, OverhaulConfiguredFeaturesProviderEntry.ORE_COPPER_SMALL,
                PlacementTools.commonOrePlacement( 16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        PlacementTools.register(context, ORE_COPPER_LARGE, OverhaulConfiguredFeaturesProviderEntry.ORE_COPPER_LARGE,
                PlacementTools.commonOrePlacement( 16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        PlacementTools.register(context, ORE_IRON_MIDDLE, OverhaulConfiguredFeaturesProviderEntry.ORE_IRON,
                PlacementTools.commonOrePlacement( 10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        PlacementTools.register(context, ORE_IRON_SMALL, OverhaulConfiguredFeaturesProviderEntry.ORE_IRON_SMALL,
                PlacementTools.commonOrePlacement( 10, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(72))));
        PlacementTools.register(context, ORE_IRON_UPPER, OverhaulConfiguredFeaturesProviderEntry.ORE_IRON,
                PlacementTools.commonOrePlacement( 90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
        PlacementTools.register(context, ORE_GOLD, OverhaulConfiguredFeaturesProviderEntry.ORE_GOLD_BURIED,
                PlacementTools.commonOrePlacement( 4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        PlacementTools.register(context, ORE_GOLD_EXTRA, OverhaulConfiguredFeaturesProviderEntry.ORE_GOLD,
                PlacementTools.commonOrePlacement( 50, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256))));
        PlacementTools.register(context, ORE_GOLD_LOWER, OverhaulConfiguredFeaturesProviderEntry.ORE_GOLD_BURIED,
                PlacementTools.rarityOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))));
        PlacementTools.register(context, ORE_DIAMOND, OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_SMALL,
                PlacementTools.commonOrePlacement( 7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        PlacementTools.register(context, ORE_DIAMOND_BURIED, OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_BURIED,
                PlacementTools.commonOrePlacement( 4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        PlacementTools.register(context, ORE_DIAMOND_LARGE, OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_LARGE,
                PlacementTools.rarityOrePlacement( 9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        PlacementTools.register(context, ORE_DIAMOND_MEDIUM, OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_MEDIUM,
                PlacementTools.commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4))));
        PlacementTools.register(context, ORE_EMERALD, OverhaulConfiguredFeaturesProviderEntry.ORE_EMERALD,
                PlacementTools.commonOrePlacement( 100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
        PlacementTools.register(context, ORE_COAL_LOWER, OverhaulConfiguredFeaturesProviderEntry.ORE_COAL_BURIED,
                PlacementTools.commonOrePlacement( 20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192))));
        PlacementTools.register(context, ORE_COAL_UPPER, OverhaulConfiguredFeaturesProviderEntry.ORE_COAL,
                PlacementTools.commonOrePlacement( 30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.belowTop(0))));
        PlacementTools.register(context, ORE_LAPIS, OverhaulConfiguredFeaturesProviderEntry.ORE_LAPIS,
                PlacementTools.commonOrePlacement( 2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));
        PlacementTools.register(context, ORE_LAPIS_BURIED, OverhaulConfiguredFeaturesProviderEntry.ORE_LAPIS_BURIED,
                PlacementTools.commonOrePlacement( 4, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(64))));
        PlacementTools.register(context, ORE_REDSTONE, OverhaulConfiguredFeaturesProviderEntry.ORE_REDSTONE,
                PlacementTools.commonOrePlacement( 4, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(15))));
        PlacementTools.register(context, ORE_REDSTONE_LOWER, OverhaulConfiguredFeaturesProviderEntry.ORE_REDSTONE,
                PlacementTools.commonOrePlacement( 8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))));
    }

    public static void bootstrap_medievalism(BootstrapContext<PlacedFeature> context)
    {
        // ROCKS
        //PlacementModifier ASHFALL_LAYER_FILTER =                  LayerHeightPlacement.withinLayer(WorldLayersRegistration.ASHFALL.getKey());
        //PlacementModifier REGOLITH_LAYER_FILTER =                 LayerHeightPlacement.withinLayer(WorldLayersRegistration.REGOLITH.getKey());
        //PlacementModifier SEDIMENTARY_LAYER_FILTER =              LayerHeightPlacement.withinLayer(WorldLayersRegistration.SEDIMENTARY.getKey());
        //PlacementModifier METAMORPHIC_LAYER_FILTER =              LayerHeightPlacement.withinLayer(WorldLayersRegistration.METAMORPHIC.getKey());
        //PlacementModifier SOFT_IGNEOUS_EXTRUSIVE_LAYER_FILTER =   LayerHeightPlacement.withinLayer(WorldLayersRegistration.SOFT_IGNEOUS_EXTRUSIVE.getKey());
        //PlacementModifier HARD_IGNEOUS_EXTRUSIVE_LAYER_FILTER =   LayerHeightPlacement.withinLayer(WorldLayersRegistration.HARD_IGNEOUS_EXTRUSIVE.getKey());
        //PlacementModifier IGNEOUS_INTRUSIVE_LAYER_FILTER =        LayerHeightPlacement.withinLayer(WorldLayersRegistration.IGNEOUS_INTRUSIVE.getKey());
        //PlacementModifier DEEP_IGNEOUS_INTRUSIVE_LAYER_FILTER =   LayerHeightPlacement.withinLayer(WorldLayersRegistration.DEEP_IGNEOUS_INTRUSIVE.getKey());

        List<PlacementModifier> SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfacePlacement(1, 2, 2);
        List<PlacementModifier> SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES =   PlacementTools.surfacePlacement(1, 2, 2);
        List<PlacementModifier> SURFACE_REGOLITH_ROCKS_PLACEMENT_RULES =       PlacementTools.surfacePlacement(1, 2, 2);
        List<PlacementModifier> SURFACE_SEDIMENTARY_ROCKS_PLACEMENT_RULES =       PlacementTools.surfacePlacement(1, 1, 3);
        List<PlacementModifier> CAVE_DECORATION_PLACEMENT_RULES =               PlacementTools.cavePlacement(60, 100, 1);

        //List<PlacementModifier> SURFACE_SAPROLITE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfaceCellPlacement(1, 2, 2,    WorldLayersRegistration.REGOLITH.getKey(),                   LayerCellRegistration.SAPROLITE.getKey());
        //List<PlacementModifier> SURFACE_LATERITE_ROCKS_PLACEMENT_RULES =        PlacementTools.surfaceCellPlacement(1, 2, 2,    WorldLayersRegistration.REGOLITH.getKey(),                   LayerCellRegistration.LATERITE.getKey());
        //List<PlacementModifier> SURFACE_SILT_CLUMPS_PLACEMENT_RULES =           PlacementTools.surfaceCellPlacement(1, 2, 2,    WorldLayersRegistration.REGOLITH.getKey(),                   LayerCellRegistration.SILT.getKey());
        //List<PlacementModifier> SURFACE_GREYWACKE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.GREYWACKE.getKey());
        //List<PlacementModifier> SURFACE_SILTSTONE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.SILTSTONE.getKey());
        //List<PlacementModifier> SURFACE_DOLOSTONE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.DOLOSTONE.getKey());
        //List<PlacementModifier> SURFACE_LIMESTONE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.LIMESTONE.getKey());
        //List<PlacementModifier> SURFACE_IRONSTONE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.IRONSTONE.getKey());
        //List<PlacementModifier> SURFACE_SHALE_ROCKS_PLACEMENT_RULES =           PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.SHALE.getKey());
        //List<PlacementModifier> SURFACE_ARKOSE_ROCKS_PLACEMENT_RULES =          PlacementTools.surfaceCellPlacement(1, 1, 3,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.ARKOSE.getKey());
        //List<PlacementModifier> CAVE_GREYWACKE_ROCKS_PLACEMENT_RULES =          PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.GREYWACKE.getKey(),                SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_SILTSTONE_ROCKS_PLACEMENT_RULES =          PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.SILTSTONE.getKey(),                SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_DOLOSTONE_ROCKS_PLACEMENT_RULES =          PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.DOLOSTONE.getKey(),                SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_LIMESTONE_ROCKS_PLACEMENT_RULES =          PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.LIMESTONE.getKey(),                SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_IRONSTONE_ROCKS_PLACEMENT_RULES =          PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.IRONSTONE.getKey(),                SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_SHALE_ROCKS_PLACEMENT_RULES =              PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.SHALE.getKey(),                    SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_ARKOSE_ROCKS_PLACEMENT_RULES =             PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.SEDIMENTARY.getKey(),                LayerCellRegistration.ARKOSE.getKey(),                   SEDIMENTARY_LAYER_FILTER);
        //List<PlacementModifier> CAVE_MARBLE_ROCKS_PLACEMENT_RULES =             PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.METAMORPHIC.getKey(),                LayerCellRegistration.MARBLE.getKey(),                   METAMORPHIC_LAYER_FILTER);
        //List<PlacementModifier> CAVE_QUARTZITE_ROCKS_PLACEMENT_RULES =          PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.METAMORPHIC.getKey(),                LayerCellRegistration.QUARTZITE.getKey(),                METAMORPHIC_LAYER_FILTER);
        //List<PlacementModifier> CAVE_HORNFELS_ROCKS_PLACEMENT_RULES =           PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.METAMORPHIC.getKey(),                LayerCellRegistration.HORNFELS.getKey(),                 METAMORPHIC_LAYER_FILTER);
        //List<PlacementModifier> CAVE_SLATE_ROCKS_PLACEMENT_RULES =              PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.METAMORPHIC.getKey(),                LayerCellRegistration.SLATE.getKey(),                    METAMORPHIC_LAYER_FILTER);
        //List<PlacementModifier> CAVE_GABBRO_ROCKS_PLACEMENT_RULES =             PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.IGNEOUS_INTRUSIVE.getKey(),          LayerCellRegistration.GABBRO.getKey(),             IGNEOUS_INTRUSIVE_LAYER_FILTER);
        //List<PlacementModifier> CAVE_SMOOTH_DIORITE_ROCKS_PLACEMENT_RULES =     PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.IGNEOUS_INTRUSIVE.getKey(),          LayerCellRegistration.SMOOTH_DIORITE.getKey(),     IGNEOUS_INTRUSIVE_LAYER_FILTER);
        //List<PlacementModifier> CAVE_SMOOTH_GRANITE_ROCKS_PLACEMENT_RULES =     PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.IGNEOUS_INTRUSIVE.getKey(),          LayerCellRegistration.SMOOTH_GRANITE.getKey(),     IGNEOUS_INTRUSIVE_LAYER_FILTER);
        //List<PlacementModifier> CAVE_NORITE_ROCKS_PLACEMENT_RULES =             PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.DEEP_IGNEOUS_INTRUSIVE.getKey(),     LayerCellRegistration.NORITE.getKey(),        DEEP_IGNEOUS_INTRUSIVE_LAYER_FILTER);
        //List<PlacementModifier> CAVE_PERIDOTITE_ROCKS_PLACEMENT_RULES =         PlacementTools.caveCellPlacement(30, 100, 1,    WorldLayersRegistration.DEEP_IGNEOUS_INTRUSIVE.getKey(),     LayerCellRegistration.PERIDOTITE.getKey(),    DEEP_IGNEOUS_INTRUSIVE_LAYER_FILTER);

        PlacementTools.register(context, SURFACE_SANDSTONE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS,       SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_RED_SANDSTONE_ROCKS,    OverhaulConfiguredFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS,   SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_SAPROLITE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_SAPROLITE_ROCKS,       SURFACE_SAPROLITE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_LATERITE_ROCKS,         OverhaulConfiguredFeaturesProviderEntry.SURFACE_LATERITE_ROCKS,        SURFACE_LATERITE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_SILT_CLUMPS,            OverhaulConfiguredFeaturesProviderEntry.SURFACE_SILT_CLUMPS,           SURFACE_SILT_CLUMPS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_GREYWACKE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS,       SURFACE_GREYWACKE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_SILTSTONE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_SILTSTONE_ROCKS,       SURFACE_SILTSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_DOLOSTONE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_DOLOSTONE_ROCKS,       SURFACE_DOLOSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_LIMESTONE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_LIMESTONE_ROCKS,       SURFACE_LIMESTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_IRONSTONE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_IRONSTONE_ROCKS,       SURFACE_IRONSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_SHALE_ROCKS,            OverhaulConfiguredFeaturesProviderEntry.SURFACE_SHALE_ROCKS,           SURFACE_SHALE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, SURFACE_ARKOSE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.SURFACE_ARKOSE_ROCKS,          SURFACE_ARKOSE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_ROCKS,         OverhaulConfiguredFeaturesProviderEntry.SURFACE_ROCKS,        SURFACE_REGOLITH_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_SEDIMENTARY_ROCKS,      OverhaulConfiguredFeaturesProviderEntry.SURFACE_SEDIMENTARY_ROCKS,     SURFACE_SEDIMENTARY_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_GREYWACKE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.CAVE_GREYWACKE_ROCKS,          CAVE_GREYWACKE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_SILTSTONE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.CAVE_SILTSTONE_ROCKS,          CAVE_SILTSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_DOLOSTONE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.CAVE_DOLOSTONE_ROCKS,          CAVE_DOLOSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_LIMESTONE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.CAVE_LIMESTONE_ROCKS,          CAVE_LIMESTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_IRONSTONE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.CAVE_IRONSTONE_ROCKS,          CAVE_IRONSTONE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_SHALE_ROCKS,               OverhaulConfiguredFeaturesProviderEntry.CAVE_SHALE_ROCKS,              CAVE_SHALE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_ARKOSE_ROCKS,              OverhaulConfiguredFeaturesProviderEntry.CAVE_ARKOSE_ROCKS,             CAVE_ARKOSE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_MARBLE_ROCKS,              OverhaulConfiguredFeaturesProviderEntry.CAVE_MARBLE_ROCKS,             CAVE_MARBLE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_QUARTZITE_ROCKS,           OverhaulConfiguredFeaturesProviderEntry.CAVE_QUARTZITE_ROCKS,          CAVE_QUARTZITE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_HORNFELS_ROCKS,            OverhaulConfiguredFeaturesProviderEntry.CAVE_HORNFELS_ROCKS,           CAVE_HORNFELS_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_SLATE_ROCKS,               OverhaulConfiguredFeaturesProviderEntry.CAVE_SLATE_ROCKS,              CAVE_SLATE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_GABBRO_ROCKS,              OverhaulConfiguredFeaturesProviderEntry.CAVE_GABBRO_ROCKS,             CAVE_GABBRO_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_SMOOTH_DIORITE_ROCKS,      OverhaulConfiguredFeaturesProviderEntry.CAVE_SMOOTH_DIORITE_ROCKS,     CAVE_SMOOTH_DIORITE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_SMOOTH_GRANITE_ROCKS,      OverhaulConfiguredFeaturesProviderEntry.CAVE_SMOOTH_GRANITE_ROCKS,     CAVE_SMOOTH_GRANITE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_NORITE_ROCKS,              OverhaulConfiguredFeaturesProviderEntry.CAVE_NORITE_ROCKS,             CAVE_NORITE_ROCKS_PLACEMENT_RULES);
        //PlacementTools.register(context, CAVE_PERIDOTITE_ROCKS,          OverhaulConfiguredFeaturesProviderEntry.CAVE_PERIDOTITE_ROCKS,         CAVE_PERIDOTITE_ROCKS_PLACEMENT_RULES);

        //PlacementTools.register(context, CAVE_PERIDOTITE_ROCKS, OverhaulConfiguredFeaturesProviderEntry.CAVE_PERIDOTITE_ROCKS, );

        // TO DO, This should be based on the HM
        //HeightRangePlacement placement = HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(200));
        // Set range to o to hm
        // then use layerSelector to div it up
        //PlacementTools.register(context, CAVE_PERIDOTITE_ROCKS, OverhaulConfiguredFeaturesProviderEntry.DEBUG_CELL,
        //        PlacementTools.caveCellPlacement(30, 100, 1,
        //                WorldLayersRegistration.DEEP_IGNEOUS_INTRUSIVE.getKey(),
        //                LayerCellRegistration.PERIDOTITE.getKey(),
        //                placement
        //        ));

        //List<PlacementModifier> placementList = List.of(
        //        // CellRarityFilter.onAverageOnceEvery(chance, cell, variant), // If we don't pass the filter of base pos, don't both with spamming checks
        //        CountPlacement.of(UniformInt.of(30, 100)), // How many locations
        //        InSquarePlacement.spread(),
        //        HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(200)),
//
        //        BelowHeightmapFilter.belowHeightmap(Heightmap.Types.OCEAN_FLOOR_WG, 1),
        //        //CountPlacement.of(UniformInt.of(1, 1)), // How many in a cluster
        //        //RandomOffsetPlacement.of(
        //        //        ClampedNormalInt.of(0.0F, 3.0F, -7, 7), // XZ spread
        //        //        ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), // Y spread
//
        //        BiomeFilter.biome()
        //);

        PlacementTools.register(context, CAVE_ROCKS, OverhaulConfiguredFeaturesProviderEntry.CAVE_ROCKS, CAVE_DECORATION_PLACEMENT_RULES);
    }
}
