package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement.CellPlacement;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BaseConfiguredFeaturesProviderEntry;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BasePlacedFeaturesProviderEntry;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenNoiseCatalog;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.ArrayList;
import java.util.List;

public final class OverhaulPlacedFeaturesProviderEntry
{
    // ===Vanilla===
    // ORE
    public static final ResourceKey<PlacedFeature> ORE_DIRT =               registerKey(ResourceLocation.withDefaultNamespace("ore_dirt"));
    public static final ResourceKey<PlacedFeature> ORE_CLAY =               registerKey(ResourceLocation.withDefaultNamespace("ore_clay"));
    public static final ResourceKey<PlacedFeature> ORE_GRAVEL =             registerKey(ResourceLocation.withDefaultNamespace("ore_gravel"));
    public static final ResourceKey<PlacedFeature> ORE_ANDESITE_LOWER =     registerKey(ResourceLocation.withDefaultNamespace("ore_andesite_lower"));
    public static final ResourceKey<PlacedFeature> ORE_ANDESITE_UPPER =     registerKey(ResourceLocation.withDefaultNamespace("ore_andesite_upper"));
    public static final ResourceKey<PlacedFeature> ORE_DIORITE_LOWER =      registerKey(ResourceLocation.withDefaultNamespace("ore_diorite_lower"));
    public static final ResourceKey<PlacedFeature> ORE_DIORITE_UPPER =      registerKey(ResourceLocation.withDefaultNamespace("ore_diorite_upper"));
    public static final ResourceKey<PlacedFeature> ORE_GRANITE_LOWER =      registerKey(ResourceLocation.withDefaultNamespace("ore_granite_lower"));
    public static final ResourceKey<PlacedFeature> ORE_GRANITE_UPPER =      registerKey(ResourceLocation.withDefaultNamespace("ore_granite_upper"));
    public static final ResourceKey<PlacedFeature> ORE_TUFF =               registerKey(ResourceLocation.withDefaultNamespace("ore_tuff"));
    public static final ResourceKey<PlacedFeature> ORE_INFESTED =           registerKey(ResourceLocation.withDefaultNamespace("ore_infested"));
    public static final ResourceKey<PlacedFeature> ORE_COPPER =             registerKey(ResourceLocation.withDefaultNamespace("ore_copper"));
    public static final ResourceKey<PlacedFeature> ORE_COPPER_LARGE =       registerKey(ResourceLocation.withDefaultNamespace("ore_copper_large"));
    public static final ResourceKey<PlacedFeature> ORE_IRON_MIDDLE =        registerKey(ResourceLocation.withDefaultNamespace("ore_iron_middle"));
    public static final ResourceKey<PlacedFeature> ORE_IRON_SMALL =         registerKey(ResourceLocation.withDefaultNamespace("ore_iron_small"));
    public static final ResourceKey<PlacedFeature> ORE_IRON_UPPER =         registerKey(ResourceLocation.withDefaultNamespace("ore_iron_upper"));
    public static final ResourceKey<PlacedFeature> ORE_GOLD =               registerKey(ResourceLocation.withDefaultNamespace("ore_gold"));
    public static final ResourceKey<PlacedFeature> ORE_GOLD_EXTRA =         registerKey(ResourceLocation.withDefaultNamespace("ore_gold_extra"));
    public static final ResourceKey<PlacedFeature> ORE_GOLD_LOWER =         registerKey(ResourceLocation.withDefaultNamespace("ore_gold_lower"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND =            registerKey(ResourceLocation.withDefaultNamespace("ore_diamond"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_BURIED =     registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_buried"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_LARGE =      registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_large"));
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_MEDIUM =     registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_medium"));
    public static final ResourceKey<PlacedFeature> ORE_EMERALD =            registerKey(ResourceLocation.withDefaultNamespace("ore_emerald"));
    public static final ResourceKey<PlacedFeature> ORE_COAL_LOWER =         registerKey(ResourceLocation.withDefaultNamespace("ore_coal_lower"));
    public static final ResourceKey<PlacedFeature> ORE_COAL_UPPER =         registerKey(ResourceLocation.withDefaultNamespace("ore_coal_upper"));
    public static final ResourceKey<PlacedFeature> ORE_LAPIS =              registerKey(ResourceLocation.withDefaultNamespace("ore_lapis"));
    public static final ResourceKey<PlacedFeature> ORE_LAPIS_BURIED =       registerKey(ResourceLocation.withDefaultNamespace("ore_lapis_buried"));
    public static final ResourceKey<PlacedFeature> ORE_REDSTONE =           registerKey(ResourceLocation.withDefaultNamespace("ore_redstone"));
    public static final ResourceKey<PlacedFeature> ORE_REDSTONE_LOWER =     registerKey(ResourceLocation.withDefaultNamespace("ore_redstone_lower"));

    // === Medievalism===
    // ROCK
    public static final ResourceKey<PlacedFeature> SANDSTONE_ROCK =             BasePlacedFeaturesProviderEntry.SANDSTONE_ROCK;
    public static final ResourceKey<PlacedFeature> RED_SANDSTONE_ROCK =         BasePlacedFeaturesProviderEntry.RED_SANDSTONE_ROCK;
    public static final ResourceKey<PlacedFeature> SAPROLITE_ROCK =             registerKey(MedievalismConstants.resource("saprolite_rock"));
    public static final ResourceKey<PlacedFeature> LATERITE_ROCK =              registerKey(MedievalismConstants.resource("laterite_rock"));
    public static final ResourceKey<PlacedFeature> GREYWACKE_ROCK =             BasePlacedFeaturesProviderEntry.GREYWACKE_ROCK;
    public static final ResourceKey<PlacedFeature> SILTSTONE_ROCK =             registerKey(MedievalismConstants.resource("siltstone_rock"));
    public static final ResourceKey<PlacedFeature> DOLOSTONE_ROCK =             registerKey(MedievalismConstants.resource("dolostone_rock"));
    public static final ResourceKey<PlacedFeature> LIMESTONE_ROCK =             registerKey(MedievalismConstants.resource("limestone_rock"));
    public static final ResourceKey<PlacedFeature> IRONSTONE_ROCK =             registerKey(MedievalismConstants.resource("ironstone_rock"));
    public static final ResourceKey<PlacedFeature> SHALE_ROCK =                 registerKey(MedievalismConstants.resource("shale_rock"));
    public static final ResourceKey<PlacedFeature> ARKOSE_ROCK =                registerKey(MedievalismConstants.resource("arkose_rock"));
    // LARGE ROCK
    public static final ResourceKey<PlacedFeature> LARGE_SANDSTONE_ROCK =       BasePlacedFeaturesProviderEntry.LARGE_SANDSTONE_ROCK;
    public static final ResourceKey<PlacedFeature> LARGE_RED_SANDSTONE_ROCK =   BasePlacedFeaturesProviderEntry.LARGE_RED_SANDSTONE_ROCK;
    public static final ResourceKey<PlacedFeature> LARGE_SAPROLITE_ROCK =       registerKey(MedievalismConstants.resource("large_saprolite_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_LATERITE_ROCK =        registerKey(MedievalismConstants.resource("large_laterite_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_GREYWACKE_ROCK =       BasePlacedFeaturesProviderEntry.LARGE_GREYWACKE_ROCK;
    public static final ResourceKey<PlacedFeature> LARGE_SILTSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_siltstone_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_DOLOSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_dolostone_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_LIMESTONE_ROCK =       registerKey(MedievalismConstants.resource("large_limestone_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_IRONSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_ironstone_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_SHALE_ROCK =           registerKey(MedievalismConstants.resource("large_shale_rock"));
    public static final ResourceKey<PlacedFeature> LARGE_ARKOSE_ROCK =          registerKey(MedievalismConstants.resource("large_arkose_rock"));
    // COPPER ROCK
    public static final ResourceKey<PlacedFeature> GREYWACKE_ROCK_COPPER_ORE =  BasePlacedFeaturesProviderEntry.GREYWACKE_ROCK_COPPER_ORE;
    public static final ResourceKey<PlacedFeature> SILTSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("siltstone_rock_copper_ore"));
    public static final ResourceKey<PlacedFeature> DOLOSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("dolostone_rock_copper_ore"));
    public static final ResourceKey<PlacedFeature> LIMESTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("limestone_rock_copper_ore"));
    public static final ResourceKey<PlacedFeature> IRONSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("ironstone_rock_copper_ore"));
    public static final ResourceKey<PlacedFeature> SHALE_ROCK_COPPER_ORE =      registerKey(MedievalismConstants.resource("shale_rock_copper_ore"));
    public static final ResourceKey<PlacedFeature> ARKOSE_ROCK_COPPER_ORE =     registerKey(MedievalismConstants.resource("arkose_rock_copper_ore"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        bootstrap_vanilla(context);
        bootstrap_medievalism(context);
    }

    public static void bootstrap_vanilla(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ORE_DIRT, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIRT),
                commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context, ORE_CLAY, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_CLAY),
                commonOrePlacement( 46, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256))));
        register(context, ORE_GRAVEL, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_GRAVEL),
                commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0))));
        register(context, ORE_ANDESITE_LOWER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_ANDESITE),
                commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        register(context, ORE_ANDESITE_UPPER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_ANDESITE),
                rarityOrePlacement( 6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        register(context, ORE_DIORITE_LOWER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIORITE),
                commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        register(context, ORE_DIORITE_UPPER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIORITE),
                rarityOrePlacement( 6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        register(context, ORE_GRANITE_LOWER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_GRANITE),
                commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        register(context, ORE_GRANITE_UPPER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_GRANITE),
                rarityOrePlacement( 6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        register(context, ORE_TUFF, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_TUFF),
                commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context, ORE_INFESTED, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_INFESTED),
                commonOrePlacement( 7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context, ORE_COPPER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_COPPER_SMALL),
                commonOrePlacement( 16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        register(context, ORE_COPPER_LARGE, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_COPPER_LARGE),
                commonOrePlacement( 16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        register(context, ORE_IRON_MIDDLE, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_IRON),
                commonOrePlacement( 10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        register(context, ORE_IRON_SMALL, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_IRON_SMALL),
                commonOrePlacement( 10, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(72))));
        register(context, ORE_IRON_UPPER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_IRON),
                commonOrePlacement( 90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
        register(context, ORE_GOLD, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_GOLD_BURIED),
                commonOrePlacement( 4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        register(context, ORE_GOLD_EXTRA, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_GOLD),
                commonOrePlacement( 50, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256))));
        register(context, ORE_GOLD_LOWER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_GOLD_BURIED),
                rarityOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))));
        register(context, ORE_DIAMOND, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_SMALL),
                commonOrePlacement( 7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, ORE_DIAMOND_BURIED, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_BURIED),
                commonOrePlacement( 4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, ORE_DIAMOND_LARGE, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_LARGE),
                rarityOrePlacement( 9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, ORE_DIAMOND_MEDIUM, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_DIAMOND_MEDIUM),
                commonOrePlacement( 2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4))));
        register(context, ORE_EMERALD, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_EMERALD),
                commonOrePlacement( 100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
        register(context, ORE_COAL_LOWER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_COAL_BURIED),
                commonOrePlacement( 20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192))));
        register(context, ORE_COAL_UPPER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_COAL),
                commonOrePlacement( 30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.belowTop(0))));
        register(context, ORE_LAPIS, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_LAPIS),
                commonOrePlacement( 2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));
        register(context, ORE_LAPIS_BURIED, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_LAPIS_BURIED),
                commonOrePlacement( 4, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(64))));
        register(context, ORE_REDSTONE, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_REDSTONE),
                commonOrePlacement( 4, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(15), VerticalAnchor.absolute(15))));
        register(context, ORE_REDSTONE_LOWER, configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ORE_REDSTONE),
                commonOrePlacement( 8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))));
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static void bootstrap_medievalism(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> SURFACE_SANDSTONE_ROCK_PLACEMENT_RULES =            surfacePlacement(1, 2);
        List<PlacementModifier> SURFACE_RED_SANDSTONE_ROCK_PLACEMENT_RULES =        surfacePlacement(1, 2);
        List<PlacementModifier> SURFACE_SAPROLITE_ROCK_PLACEMENT_RULES =            surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,        WorldGenNoiseCatalog.VARIANTS_REGOLITH.SAPROLITE);
        List<PlacementModifier> SURFACE_LATERITE_ROCK_PLACEMENT_RULES =             surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,        WorldGenNoiseCatalog.VARIANTS_REGOLITH.LATERITE);
        List<PlacementModifier> SURFACE_GREYWACKE_ROCK_PLACEMENT_RULES =            surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.GREYWACKE);
        List<PlacementModifier> SURFACE_SILTSTONE_ROCK_PLACEMENT_RULES =            surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SILTSTONE);
        List<PlacementModifier> SURFACE_DOLOSTONE_ROCK_PLACEMENT_RULES =            surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.DOLOSTONE);
        List<PlacementModifier> SURFACE_LIMESTONE_ROCK_PLACEMENT_RULES =            surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.LIMESTONE);
        List<PlacementModifier> SURFACE_IRONSTONE_ROCK_PLACEMENT_RULES =            surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.IRONSTONE);
        List<PlacementModifier> SURFACE_SHALE_ROCK_PLACEMENT_RULES =                surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SHALE);
        List<PlacementModifier> SURFACE_ARKOSE_ROCK_PLACEMENT_RULES =               surfaceCellPlacement(1, 2, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.ARKOSE);

        List<PlacementModifier> SURFACE_LARGE_SANDSTONE_ROCK_PLACEMENT_RULES =      surfacePlacement(1, 4);
        List<PlacementModifier> SURFACE_LARGE_RED_SANDSTONE_ROCK_PLACEMENT_RULES =  surfacePlacement(1, 4);
        List<PlacementModifier> SURFACE_LARGE_SAPROLITE_ROCK_PLACEMENT_RULES =      surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,        WorldGenNoiseCatalog.VARIANTS_REGOLITH.SAPROLITE);
        List<PlacementModifier> SURFACE_LARGE_LATERITE_ROCK_PLACEMENT_RULES =       surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,        WorldGenNoiseCatalog.VARIANTS_REGOLITH.LATERITE);
        List<PlacementModifier> SURFACE_LARGE_GREYWACKE_ROCK_PLACEMENT_RULES =      surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.GREYWACKE);
        List<PlacementModifier> SURFACE_LARGE_SILTSTONE_ROCK_PLACEMENT_RULES =      surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SILTSTONE);
        List<PlacementModifier> SURFACE_LARGE_DOLOSTONE_ROCK_PLACEMENT_RULES =      surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.DOLOSTONE);
        List<PlacementModifier> SURFACE_LARGE_LIMESTONE_ROCK_PLACEMENT_RULES =      surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.LIMESTONE);
        List<PlacementModifier> SURFACE_LARGE_IRONSTONE_ROCK_PLACEMENT_RULES =      surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.IRONSTONE);
        List<PlacementModifier> SURFACE_LARGE_SHALE_ROCK_PLACEMENT_RULES =          surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SHALE);
        List<PlacementModifier> SURFACE_LARGE_ARKOSE_ROCK_PLACEMENT_RULES =         surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.ARKOSE);

        List<PlacementModifier> SURFACE_COPPER_GREYWACKE_ROCK_PLACEMENT_RULES =     surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.GREYWACKE);
        List<PlacementModifier> SURFACE_COPPER_SILTSTONE_ROCK_PLACEMENT_RULES =     surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SILTSTONE);
        List<PlacementModifier> SURFACE_COPPER_DOLOSTONE_ROCK_PLACEMENT_RULES =     surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.DOLOSTONE);
        List<PlacementModifier> SURFACE_COPPER_LIMESTONE_ROCK_PLACEMENT_RULES =     surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.LIMESTONE);
        List<PlacementModifier> SURFACE_COPPER_IRONSTONE_ROCK_PLACEMENT_RULES =     surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.IRONSTONE);
        List<PlacementModifier> SURFACE_COPPER_SHALE_ROCK_PLACEMENT_RULES =         surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SHALE);
        List<PlacementModifier> SURFACE_COPPER_ARKOSE_ROCK_PLACEMENT_RULES =        surfaceCellPlacement(1, 4, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,     WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.ARKOSE);

        // ROCK
        register(context, SANDSTONE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.SANDSTONE_ROCK),              SURFACE_SANDSTONE_ROCK_PLACEMENT_RULES);
        register(context, RED_SANDSTONE_ROCK,           configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.RED_SANDSTONE_ROCK),          SURFACE_RED_SANDSTONE_ROCK_PLACEMENT_RULES);
        register(context, SAPROLITE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.SAPROLITE_ROCK),              SURFACE_SAPROLITE_ROCK_PLACEMENT_RULES);
        register(context, LATERITE_ROCK,                configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LATERITE_ROCK),               SURFACE_LATERITE_ROCK_PLACEMENT_RULES);
        register(context, GREYWACKE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.GREYWACKE_ROCK),              SURFACE_GREYWACKE_ROCK_PLACEMENT_RULES);
        register(context, SILTSTONE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.SILTSTONE_ROCK),              SURFACE_SILTSTONE_ROCK_PLACEMENT_RULES);
        register(context, DOLOSTONE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.DOLOSTONE_ROCK),              SURFACE_DOLOSTONE_ROCK_PLACEMENT_RULES);
        register(context, LIMESTONE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LIMESTONE_ROCK),              SURFACE_LIMESTONE_ROCK_PLACEMENT_RULES);
        register(context, IRONSTONE_ROCK,               configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.IRONSTONE_ROCK),              SURFACE_IRONSTONE_ROCK_PLACEMENT_RULES);
        register(context, SHALE_ROCK,                   configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.SHALE_ROCK),                  SURFACE_SHALE_ROCK_PLACEMENT_RULES);
        register(context, ARKOSE_ROCK,                  configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ARKOSE_ROCK),                 SURFACE_ARKOSE_ROCK_PLACEMENT_RULES);
        // LARGE ROCK
        register(context, LARGE_SANDSTONE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_SANDSTONE_ROCK),        SURFACE_LARGE_SANDSTONE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_RED_SANDSTONE_ROCK,     configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_RED_SANDSTONE_ROCK),    SURFACE_LARGE_RED_SANDSTONE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_SAPROLITE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_SAPROLITE_ROCK),        SURFACE_LARGE_SAPROLITE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_LATERITE_ROCK,          configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_LATERITE_ROCK),         SURFACE_LARGE_LATERITE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_GREYWACKE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_GREYWACKE_ROCK),        SURFACE_LARGE_GREYWACKE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_SILTSTONE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_SILTSTONE_ROCK),        SURFACE_LARGE_SILTSTONE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_DOLOSTONE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_DOLOSTONE_ROCK),        SURFACE_LARGE_DOLOSTONE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_LIMESTONE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_LIMESTONE_ROCK),        SURFACE_LARGE_LIMESTONE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_IRONSTONE_ROCK,         configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_IRONSTONE_ROCK),        SURFACE_LARGE_IRONSTONE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_SHALE_ROCK,             configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_SHALE_ROCK),            SURFACE_LARGE_SHALE_ROCK_PLACEMENT_RULES);
        register(context, LARGE_ARKOSE_ROCK,            configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LARGE_ARKOSE_ROCK),           SURFACE_LARGE_ARKOSE_ROCK_PLACEMENT_RULES);
        // COPPER ROCK
        register(context, GREYWACKE_ROCK_COPPER_ORE,    configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.GREYWACKE_ROCK_COPPER_ORE),   SURFACE_COPPER_GREYWACKE_ROCK_PLACEMENT_RULES);
        register(context, SILTSTONE_ROCK_COPPER_ORE,    configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.SILTSTONE_ROCK_COPPER_ORE),   SURFACE_COPPER_SILTSTONE_ROCK_PLACEMENT_RULES);
        register(context, DOLOSTONE_ROCK_COPPER_ORE,    configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.DOLOSTONE_ROCK_COPPER_ORE),   SURFACE_COPPER_DOLOSTONE_ROCK_PLACEMENT_RULES);
        register(context, LIMESTONE_ROCK_COPPER_ORE,    configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.LIMESTONE_ROCK_COPPER_ORE),   SURFACE_COPPER_LIMESTONE_ROCK_PLACEMENT_RULES);
        register(context, IRONSTONE_ROCK_COPPER_ORE,    configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.IRONSTONE_ROCK_COPPER_ORE),   SURFACE_COPPER_IRONSTONE_ROCK_PLACEMENT_RULES);
        register(context, SHALE_ROCK_COPPER_ORE,        configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.SHALE_ROCK_COPPER_ORE),       SURFACE_COPPER_SHALE_ROCK_PLACEMENT_RULES);
        register(context, ARKOSE_ROCK_COPPER_ORE,       configuredFeatures.getOrThrow(OverhaulConfiguredFeaturesProviderEntry.ARKOSE_ROCK_COPPER_ORE),      SURFACE_COPPER_ARKOSE_ROCK_PLACEMENT_RULES);
    }

    // --

    public static void simpleChanceSurfacePlacedFeature(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, int count, int chance) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, placedFeatureKey, configuredFeatures.getOrThrow(configuredFeatureKey), surfacePlacement(count, chance));
    }

    public static ResourceKey<PlacedFeature> registerKey(ResourceLocation resource) {
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

    private static List<PlacementModifier> rarityOrePlacement(int count, PlacementModifier heightRange) {
        return List.of(RarityFilter.onAverageOnceEvery(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
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

    private static <E extends Enum<E>> List<PlacementModifier> surfaceCellPlacement(int count, int _chance, CellNoiseSettings cell, E variant)
    {
        return List.of(
                //RarityFilter.onAverageOnceEvery(chance),
                CellPlacement.cell(cell, variant),
                InSquarePlacement.spread(),
                CountPlacement.of(count),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), // WORLD_SURFACE_WG -- WATER LEVEL
                BiomeFilter.biome());
    }

    @SuppressWarnings("unused")
    private static List<PlacementModifier> chanceOceanSurfacePlacement(int chance) {
        return chanceOceanSurfacePlacement(chance, 0, 0);
    }

    @SuppressWarnings("SameParameterValue")
    private static List<PlacementModifier> chanceOceanSurfacePlacement(int chance, int minYOffset, @SuppressWarnings("SameParameterValue") int maxYOffset) {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                RandomOffsetPlacement.vertical(UniformInt.of(minYOffset, maxYOffset)),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BiomeFilter.biome());
    }
}
