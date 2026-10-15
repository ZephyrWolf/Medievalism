package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.BiomeModifierTools;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BaseBiomeModifiersProviderEntry;
import io.github.zephyrwolf.medievalism.registration.world.level.BiomeTagCatalog;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;

public final class OverhaulBiomeModifiersProviderEntry
{
    // ==Vanilla==

    // ==Medievalism==
    // ROCKS
    public static final ResourceKey<BiomeModifier> SURFACE_SANDSTONE_ROCKS =            BaseBiomeModifiersProviderEntry.SURFACE_SANDSTONE_ROCKS;
    public static final ResourceKey<BiomeModifier> SURFACE_RED_SANDSTONE_ROCKS =        BaseBiomeModifiersProviderEntry.SURFACE_RED_SANDSTONE_ROCKS;
    public static final ResourceKey<BiomeModifier> SURFACE_ROCKS =             BaseBiomeModifiersProviderEntry.SURFACE_ROCKS;
    public static final ResourceKey<BiomeModifier> SURFACE_SEDIMENTARY_ROCKS =            BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_sedimentary_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_SAPROLITE_ROCKS =            BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_saprolite_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_LATERITE_ROCKS =             BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_laterite_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_SILT_CLUMPS =                BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_silt_clumps"));
    //public static final ResourceKey<BiomeModifier> SURFACE_GREYWACKE_ROCKS =            BaseBiomeModifiersProviderEntry.SURFACE_GREYWACKE_ROCKS;
    //public static final ResourceKey<BiomeModifier> SURFACE_SILTSTONE_ROCKS =            BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_siltstone_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_DOLOSTONE_ROCKS =            BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_dolostone_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_LIMESTONE_ROCKS =            BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_limestone_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_IRONSTONE_ROCKS =            BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_ironstone_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_SHALE_ROCKS =                BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_shale_rocks"));
    //public static final ResourceKey<BiomeModifier> SURFACE_ARKOSE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_arkose_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_GREYWACKE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_greywacke_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_SILTSTONE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_siltstone_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_DOLOSTONE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_dolostone_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_LIMESTONE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_limestone_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_IRONSTONE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_ironstone_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_SHALE_ROCKS =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_shale_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_ARKOSE_ROCKS =                  BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_arkose_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_MARBLE_ROCKS =                  BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_marble_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_QUARTZITE_ROCKS =               BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_quartzite_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_HORNFELS_ROCKS =                BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_hornfels_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_SLATE_ROCKS =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_slate_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_GABBRO_ROCKS =                  BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_gabbro_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_SMOOTH_DIORITE_ROCKS =          BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_smooth_diorite_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_SMOOTH_GRANITE_ROCKS =          BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_smooth_granite_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_NORITE_ROCKS =                  BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_norite_rocks"));
    //public static final ResourceKey<BiomeModifier> CAVE_PERIDOTITE_ROCKS =              BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_peridotite_rocks"));
    public static final ResourceKey<BiomeModifier> CAVE_ROCKS =                         BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_rocks"));


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
        // ROCKS
        BiomeModifierTools.addSimpleModifier(context, SURFACE_SANDSTONE_ROCKS,      BiomeTagCatalog.IS_SURFACE_WITH_SAND,       OverhaulPlacedFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SURFACE_RED_SANDSTONE_ROCKS,  BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND,   OverhaulPlacedFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS,    GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SURFACE_ROCKS,                BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SURFACE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);

        BiomeModifierTools.addSimpleModifier(context, SURFACE_SEDIMENTARY_ROCKS,    BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SURFACE_SEDIMENTARY_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, CAVE_ROCKS,                   BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_ROCKS,          GenerationStep.Decoration.UNDERGROUND_DECORATION);



        //BiomeModifierTools.addSimpleModifier(context, SURFACE_SAPROLITE_ROCKS,      BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SURFACE_SAPROLITE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_LATERITE_ROCKS,       BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SURFACE_LATERITE_ROCKS,         GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_SILT_CLUMPS,          BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    OverhaulPlacedFeaturesProviderEntry.SURFACE_SILT_CLUMPS,            GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_GREYWACKE_ROCKS,      BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_SILTSTONE_ROCKS,      BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_SILTSTONE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_DOLOSTONE_ROCKS,      BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_DOLOSTONE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_LIMESTONE_ROCKS,      BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_LIMESTONE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_IRONSTONE_ROCKS,      BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_IRONSTONE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_SHALE_ROCKS,          BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_SHALE_ROCKS,            GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, SURFACE_ARKOSE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.SURFACE_ARKOSE_ROCKS,           GenerationStep.Decoration.VEGETAL_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_GREYWACKE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_GREYWACKE_ROCKS,           GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_SILTSTONE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_SILTSTONE_ROCKS,           GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_DOLOSTONE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_DOLOSTONE_ROCKS,           GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_LIMESTONE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_LIMESTONE_ROCKS,           GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_IRONSTONE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_IRONSTONE_ROCKS,           GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_SHALE_ROCKS,             BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_SHALE_ROCKS,               GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_ARKOSE_ROCKS,            BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_ARKOSE_ROCKS,              GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_MARBLE_ROCKS,            BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_MARBLE_ROCKS,              GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_QUARTZITE_ROCKS,         BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_QUARTZITE_ROCKS,           GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_HORNFELS_ROCKS,          BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_HORNFELS_ROCKS,            GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_SLATE_ROCKS,             BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_SLATE_ROCKS,               GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_GABBRO_ROCKS,            BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_GABBRO_ROCKS,              GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_SMOOTH_DIORITE_ROCKS,    BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_SMOOTH_DIORITE_ROCKS,      GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_SMOOTH_GRANITE_ROCKS,    BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_SMOOTH_GRANITE_ROCKS,      GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_NORITE_ROCKS,            BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_NORITE_ROCKS,              GenerationStep.Decoration.UNDERGROUND_DECORATION);
        //BiomeModifierTools.addSimpleModifier(context, CAVE_PERIDOTITE_ROCKS,        BiomeTags.IS_OVERWORLD,                     OverhaulPlacedFeaturesProviderEntry.CAVE_PERIDOTITE_ROCKS,          GenerationStep.Decoration.UNDERGROUND_DECORATION);
    }
}
