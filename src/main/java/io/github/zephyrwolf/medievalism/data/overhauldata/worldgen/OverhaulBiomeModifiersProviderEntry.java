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
    public static final ResourceKey<BiomeModifier> SURFACE_ROCKS =                      BaseBiomeModifiersProviderEntry.SURFACE_ROCKS;
    public static final ResourceKey<BiomeModifier> SURFACE_SEDIMENTARY_ROCKS =          BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_sedimentary_rocks"));
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
    }
}
