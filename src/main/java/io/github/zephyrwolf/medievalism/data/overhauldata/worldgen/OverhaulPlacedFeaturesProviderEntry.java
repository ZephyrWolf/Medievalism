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
    public static final ResourceKey<PlacedFeature> SURFACE_ROCKS =                  BasePlacedFeaturesProviderEntry.SURFACE_ROCKS;
    public static final ResourceKey<PlacedFeature> SURFACE_SEDIMENTARY_ROCKS =      PlacementTools.registerKey(MedievalismConstants.resource("surface_sedimentary_rocks"));
    public static final ResourceKey<PlacedFeature> CAVE_ROCKS =                     PlacementTools.registerKey(MedievalismConstants.resource("cave_rocks"));
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
        List<PlacementModifier> SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES =       PlacementTools.surfacePlacement(1, 2, 2);
        List<PlacementModifier> SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES =   PlacementTools.surfacePlacement(1, 2, 2);
        List<PlacementModifier> SURFACE_REGOLITH_ROCKS_PLACEMENT_RULES =        PlacementTools.surfacePlacement(1, 2, 2);
        List<PlacementModifier> SURFACE_SEDIMENTARY_ROCKS_PLACEMENT_RULES =     PlacementTools.surfacePlacement(1, 1, 3);
        List<PlacementModifier> CAVE_DECORATION_PLACEMENT_RULES =               PlacementTools.cavePlacement(60, 100, 1);

        PlacementTools.register(context, SURFACE_SANDSTONE_ROCKS,        OverhaulConfiguredFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS,       SURFACE_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_RED_SANDSTONE_ROCKS,    OverhaulConfiguredFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS,   SURFACE_RED_SANDSTONE_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_ROCKS,                  OverhaulConfiguredFeaturesProviderEntry.SURFACE_ROCKS,                 SURFACE_REGOLITH_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, SURFACE_SEDIMENTARY_ROCKS,      OverhaulConfiguredFeaturesProviderEntry.SURFACE_SEDIMENTARY_ROCKS,     SURFACE_SEDIMENTARY_ROCKS_PLACEMENT_RULES);
        PlacementTools.register(context, CAVE_ROCKS, OverhaulConfiguredFeaturesProviderEntry.CAVE_ROCKS, CAVE_DECORATION_PLACEMENT_RULES);
    }
}
