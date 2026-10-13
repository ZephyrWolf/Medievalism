package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BaseBiomeModifiersProviderEntry;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BasePlacedFeaturesProviderEntry;
import io.github.zephyrwolf.medievalism.registration.world.level.BiomeTagCatalog;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class OverhaulBiomeModifiersProviderEntry
{
    // ==Vanilla==

    // ==Medievalism==
    // ROCK
    public static final ResourceKey<BiomeModifier> SANDSTONE_ROCK =             BaseBiomeModifiersProviderEntry.SANDSTONE_ROCK;
    public static final ResourceKey<BiomeModifier> RED_SANDSTONE_ROCK =         BaseBiomeModifiersProviderEntry.RED_SANDSTONE_ROCK;
    public static final ResourceKey<BiomeModifier> SAPROLITE_ROCK =             registerKey(MedievalismConstants.resource("saprolite_rock"));
    public static final ResourceKey<BiomeModifier> LATERITE_ROCK =              registerKey(MedievalismConstants.resource("laterite_rock"));
    public static final ResourceKey<BiomeModifier> GREYWACKE_ROCK =             BaseBiomeModifiersProviderEntry.GREYWACKE_ROCK;
    public static final ResourceKey<BiomeModifier> SILTSTONE_ROCK =             registerKey(MedievalismConstants.resource("siltstone_rock"));
    public static final ResourceKey<BiomeModifier> DOLOSTONE_ROCK =             registerKey(MedievalismConstants.resource("dolostone_rock"));
    public static final ResourceKey<BiomeModifier> LIMESTONE_ROCK =             registerKey(MedievalismConstants.resource("limestone_rock"));
    public static final ResourceKey<BiomeModifier> IRONSTONE_ROCK =             registerKey(MedievalismConstants.resource("ironstone_rock"));
    public static final ResourceKey<BiomeModifier> SHALE_ROCK =                 registerKey(MedievalismConstants.resource("shale_rock"));
    public static final ResourceKey<BiomeModifier> ARKOSE_ROCK =                registerKey(MedievalismConstants.resource("arkose_rock"));
    // LARGE ROCK
    public static final ResourceKey<BiomeModifier> LARGE_SANDSTONE_ROCK =       BaseBiomeModifiersProviderEntry.LARGE_SANDSTONE_ROCK;
    public static final ResourceKey<BiomeModifier> LARGE_RED_SANDSTONE_ROCK =   BaseBiomeModifiersProviderEntry.LARGE_RED_SANDSTONE_ROCK;
    public static final ResourceKey<BiomeModifier> LARGE_SAPROLITE_ROCK =       registerKey(MedievalismConstants.resource("large_saprolite_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_LATERITE_ROCK =        registerKey(MedievalismConstants.resource("large_laterite_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_GREYWACKE_ROCK =       BaseBiomeModifiersProviderEntry.LARGE_GREYWACKE_ROCK;
    public static final ResourceKey<BiomeModifier> LARGE_SILTSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_siltstone_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_DOLOSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_dolostone_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_LIMESTONE_ROCK =       registerKey(MedievalismConstants.resource("large_limestone_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_IRONSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_ironstone_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_SHALE_ROCK =           registerKey(MedievalismConstants.resource("large_shale_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_ARKOSE_ROCK =          registerKey(MedievalismConstants.resource("large_arkose_rock"));
    // COPPER ROCK
    public static final ResourceKey<BiomeModifier> GREYWACKE_ROCK_COPPER_ORE =  BaseBiomeModifiersProviderEntry.GREYWACKE_ROCK_COPPER_ORE;
    public static final ResourceKey<BiomeModifier> SILTSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("siltstone_rock_copper_ore"));
    public static final ResourceKey<BiomeModifier> DOLOSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("dolostone_rock_copper_ore"));
    public static final ResourceKey<BiomeModifier> LIMESTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("limestone_rock_copper_ore"));
    public static final ResourceKey<BiomeModifier> IRONSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("ironstone_rock_copper_ore"));
    public static final ResourceKey<BiomeModifier> SHALE_ROCK_COPPER_ORE =      registerKey(MedievalismConstants.resource("shale_rock_copper_ore"));
    public static final ResourceKey<BiomeModifier> ARKOSE_ROCK_COPPER_ORE =     registerKey(MedievalismConstants.resource("arkose_rock_copper_ore"));

    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        bootstrap_vanilla(context);
        bootstrap_medievalism(context);
    }

    public static void bootstrap_vanilla(BootstrapContext<BiomeModifier> context)
    {
        // nothing yet
    }

    public static void bootstrap_medievalism(BootstrapContext<BiomeModifier> context)
    {
        // ROCK
        addSimpleModifier(context, SANDSTONE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITH_SAND,       OverhaulPlacedFeaturesProviderEntry.SANDSTONE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RED_SANDSTONE_ROCK,          BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND,   OverhaulPlacedFeaturesProviderEntry.RED_SANDSTONE_ROCK,         GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SAPROLITE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SAPROLITE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LATERITE_ROCK,               BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LATERITE_ROCK,              GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, GREYWACKE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.GREYWACKE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SILTSTONE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SILTSTONE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DOLOSTONE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.DOLOSTONE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LIMESTONE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LIMESTONE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, IRONSTONE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.IRONSTONE_ROCK,             GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SHALE_ROCK,                  BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SHALE_ROCK,                 GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, ARKOSE_ROCK,                 BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.ARKOSE_ROCK,                GenerationStep.Decoration.VEGETAL_DECORATION);
        // LARGE ROCK
        addSimpleModifier(context, LARGE_SANDSTONE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITH_SAND,       OverhaulPlacedFeaturesProviderEntry.LARGE_SANDSTONE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_RED_SANDSTONE_ROCK,    BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND,   OverhaulPlacedFeaturesProviderEntry.LARGE_RED_SANDSTONE_ROCK,   GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_SAPROLITE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_SAPROLITE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_LATERITE_ROCK,         BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_LATERITE_ROCK,        GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_GREYWACKE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_GREYWACKE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_SILTSTONE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_SILTSTONE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_DOLOSTONE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_DOLOSTONE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_LIMESTONE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_LIMESTONE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_IRONSTONE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_IRONSTONE_ROCK,       GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_SHALE_ROCK,            BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_SHALE_ROCK,           GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_ARKOSE_ROCK,           BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LARGE_ARKOSE_ROCK,          GenerationStep.Decoration.VEGETAL_DECORATION);
        // COPPER ROCK
        addSimpleModifier(context, GREYWACKE_ROCK_COPPER_ORE,   BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.GREYWACKE_ROCK_COPPER_ORE,  GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SILTSTONE_ROCK_COPPER_ORE,   BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SILTSTONE_ROCK_COPPER_ORE,  GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DOLOSTONE_ROCK_COPPER_ORE,   BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.DOLOSTONE_ROCK_COPPER_ORE,  GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LIMESTONE_ROCK_COPPER_ORE,   BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.LIMESTONE_ROCK_COPPER_ORE,  GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, IRONSTONE_ROCK_COPPER_ORE,   BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.IRONSTONE_ROCK_COPPER_ORE,  GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SHALE_ROCK_COPPER_ORE,       BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SHALE_ROCK_COPPER_ORE,      GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, ARKOSE_ROCK_COPPER_ORE,      BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.ARKOSE_ROCK_COPPER_ORE,     GenerationStep.Decoration.VEGETAL_DECORATION);
    }

    public static void addSimpleModifier(BootstrapContext<BiomeModifier> context, ResourceKey<BiomeModifier> biomeModifierKey,
                                      TagKey<Biome> biomeTagKey, ResourceKey<PlacedFeature> placedFeatureKey, GenerationStep.Decoration step)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        context.register(biomeModifierKey, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(biomeTagKey),
                HolderSet.direct(placedFeatures.getOrThrow(placedFeatureKey)),
                step
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, resource);
    }
}
