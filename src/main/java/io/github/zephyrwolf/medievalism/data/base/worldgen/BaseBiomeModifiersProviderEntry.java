package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.BiomeModifierTools;
import io.github.zephyrwolf.medievalism.registration.world.level.BiomeTagCatalog;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;

public final class BaseBiomeModifiersProviderEntry
{
    // DIRT
    public static final ResourceKey<BiomeModifier> CLAY_IN_DIRT =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("clay_in_dirt"));
    public static final ResourceKey<BiomeModifier> RED_CLAY_IN_DIRT =               BiomeModifierTools.registerKey(MedievalismConstants.resource("red_clay_in_dirt"));
    public static final ResourceKey<BiomeModifier> RED_CLAY =                       BiomeModifierTools.registerKey(MedievalismConstants.resource("red_clay"));
    public static final ResourceKey<BiomeModifier> RED_CLAY_WITH_DOGBANE =          BiomeModifierTools.registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    //STONE
    // ORE
    public static final ResourceKey<BiomeModifier> TIN_ORE =                        BiomeModifierTools.registerKey(MedievalismConstants.resource("tin_ore"));
    public static final ResourceKey<BiomeModifier> TIN_ORE_UNIFORM =                BiomeModifierTools.registerKey(MedievalismConstants.resource("tin_ore_uniform"));
    public static final ResourceKey<BiomeModifier> CHALK_ORE =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<BiomeModifier> CHERT_ORE =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<BiomeModifier> GEODE_ORE =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("geode_ore"));
    public static final ResourceKey<BiomeModifier> HARD_IG_EX_GEODE_ORE =           BiomeModifierTools.registerKey(MedievalismConstants.resource("hard_ig_ex_geode_ore"));
    // ROCKS
    public static final ResourceKey<BiomeModifier> SURFACE_SANDSTONE_ROCKS =        BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_sandstone_rocks"));
    public static final ResourceKey<BiomeModifier> SURFACE_RED_SANDSTONE_ROCKS =    BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_red_sandstone_rocks"));
    public static final ResourceKey<BiomeModifier> SURFACE_ROCKS =        BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_rocks"));
    public static final ResourceKey<BiomeModifier> CAVE_ROCKS =           BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_rocks"));
    // TWIGS
    public static final ResourceKey<BiomeModifier> DENSE_TWIGS =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_twigs"));
    public static final ResourceKey<BiomeModifier> SPARSE_TWIGS =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("sparse_twigs"));
    public static final ResourceKey<BiomeModifier> RARE_TWIGS =                     BiomeModifierTools.registerKey(MedievalismConstants.resource("rare_twigs"));
    // DENSE BRANCH
    public static final ResourceKey<BiomeModifier> DENSE_OAK_BRANCH =               BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_oak_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_BIRCH_BRANCH =             BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_birch_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_SPRUCE_BRANCH =            BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_spruce_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_JUNGLE_BRANCH =            BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_jungle_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_DARK_OAK_BRANCH =          BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_dark_oak_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_CHERRY_BRANCH =            BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_cherry_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_MANGROVE_BRANCH =          BiomeModifierTools.registerKey(MedievalismConstants.resource("dense_mangrove_branch"));
    // SPARE BRANCH
    public static final ResourceKey<BiomeModifier> SPARSE_OAK_BRANCH =              BiomeModifierTools.registerKey(MedievalismConstants.resource("sparse_oak_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_BIRCH_BRANCH =            BiomeModifierTools.registerKey(MedievalismConstants.resource("sparse_birch_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_SPRUCE_BRANCH =           BiomeModifierTools.registerKey(MedievalismConstants.resource("sparse_spruce_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_JUNGLE_BRANCH =           BiomeModifierTools.registerKey(MedievalismConstants.resource("sparse_jungle_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_ACACIA_BRANCH =           BiomeModifierTools.registerKey(MedievalismConstants.resource("sparse_acacia_branch"));
    // RARE BRANCH
    public static final ResourceKey<BiomeModifier> RARE_OAK_BRANCH =                BiomeModifierTools.registerKey(MedievalismConstants.resource("rare_oak_branch"));
    public static final ResourceKey<BiomeModifier> RARE_BIRCH_BRANCH =              BiomeModifierTools.registerKey(MedievalismConstants.resource("rare_birch_branch"));
    // WILD CROPS
    public static final ResourceKey<BiomeModifier> WILD_YAMS =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_yams"));

    // --

    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // DIRT
        context.register(CLAY_IN_DIRT, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTagCatalog.GENERATE_INLAND_CLAY), HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeaturesProviderEntry.CLAY_IN_DIRT)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(RED_CLAY_IN_DIRT, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTagCatalog.GENERATE_INLAND_CLAY), HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeaturesProviderEntry.RED_CLAY_IN_DIRT)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(RED_CLAY, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTagCatalog.GENERATE_INLAND_CLAY), HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeaturesProviderEntry.RED_CLAY)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(RED_CLAY_WITH_DOGBANE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTagCatalog.GENERATE_INLAND_CLAY), HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeaturesProviderEntry.RED_CLAY_WITH_DOGBANE)), GenerationStep.Decoration.VEGETAL_DECORATION));
        // STONE
        // ORE
        BiomeModifierTools.addSimpleModifier(context, TIN_ORE,                      BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.TIN_ORE,                        GenerationStep.Decoration.UNDERGROUND_ORES);
        BiomeModifierTools.addSimpleModifier(context, TIN_ORE_UNIFORM,              BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.TIN_ORE_UNIFORM,                GenerationStep.Decoration.UNDERGROUND_ORES);
        BiomeModifierTools.addSimpleModifier(context, CHALK_ORE,                    BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.CHALK_ORE,                      GenerationStep.Decoration.UNDERGROUND_ORES);
        BiomeModifierTools.addSimpleModifier(context, CHERT_ORE,                    BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.CHERT_ORE,                      GenerationStep.Decoration.UNDERGROUND_ORES);
        BiomeModifierTools.addSimpleModifier(context, GEODE_ORE,                    BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.GEODE_ORE,                      GenerationStep.Decoration.UNDERGROUND_ORES);
        BiomeModifierTools.addSimpleModifier(context, HARD_IG_EX_GEODE_ORE,         BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.HARD_IG_ED_GEODE_ORE,           GenerationStep.Decoration.UNDERGROUND_ORES);
        // ROCKS
        BiomeModifierTools.addSimpleModifier(context, SURFACE_SANDSTONE_ROCKS,      BiomeTagCatalog.IS_SURFACE_WITH_SAND,       BasePlacedFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS,        GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SURFACE_RED_SANDSTONE_ROCKS,  BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND,   BasePlacedFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS,    GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SURFACE_ROCKS,                BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    BasePlacedFeaturesProviderEntry.SURFACE_ROCKS,                  GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, CAVE_ROCKS,                   BiomeTags.IS_OVERWORLD,                     BasePlacedFeaturesProviderEntry.CAVE_ROCKS,                     GenerationStep.Decoration.UNDERGROUND_DECORATION);
        // TWIGS
        BiomeModifierTools.addSimpleModifier(context, DENSE_TWIGS, BiomeTagCatalog.HAS_DENSE_TREES, BasePlacedFeaturesProviderEntry.DENSE_TWIGS, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SPARSE_TWIGS, BiomeTagCatalog.HAS_SPARSE_TREES, BasePlacedFeaturesProviderEntry.SPARSE_TWIGS, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, RARE_TWIGS, BiomeTagCatalog.HAS_RARE_TREES, BasePlacedFeaturesProviderEntry.RARE_TWIGS, GenerationStep.Decoration.VEGETAL_DECORATION);
        // BRANCHES
        BiomeModifierTools.addSimpleModifier(context, DENSE_OAK_BRANCH, BiomeTagCatalog.HAS_DENSE_OAK_TREES, BasePlacedFeaturesProviderEntry.DENSE_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, DENSE_BIRCH_BRANCH, BiomeTagCatalog.HAS_DENSE_BIRCH_TREES, BasePlacedFeaturesProviderEntry.DENSE_BIRCH_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, DENSE_SPRUCE_BRANCH, BiomeTagCatalog.HAS_DENSE_SPRUCE_TREES, BasePlacedFeaturesProviderEntry.DENSE_SPRUCE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, DENSE_JUNGLE_BRANCH, BiomeTagCatalog.HAS_DENSE_JUNGLE_TREES, BasePlacedFeaturesProviderEntry.DENSE_JUNGLE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, DENSE_CHERRY_BRANCH, BiomeTagCatalog.HAS_DENSE_CHERRY_TREES, BasePlacedFeaturesProviderEntry.DENSE_CHERRY_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, DENSE_DARK_OAK_BRANCH, BiomeTagCatalog.HAS_DENSE_DARK_OAK_TREES, BasePlacedFeaturesProviderEntry.DENSE_DARK_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, DENSE_MANGROVE_BRANCH, BiomeTagCatalog.HAS_DENSE_MANGROVE_TREES, BasePlacedFeaturesProviderEntry.DENSE_MANGROVE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SPARSE_OAK_BRANCH, BiomeTagCatalog.HAS_SPARSE_OAK_TREES, BasePlacedFeaturesProviderEntry.SPARSE_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SPARSE_BIRCH_BRANCH, BiomeTagCatalog.HAS_SPARSE_BIRCH_TREES, BasePlacedFeaturesProviderEntry.SPARSE_BIRCH_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SPARSE_SPRUCE_BRANCH, BiomeTagCatalog.HAS_SPARSE_SPRUCE_TREES, BasePlacedFeaturesProviderEntry.SPARSE_SPRUCE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SPARSE_JUNGLE_BRANCH, BiomeTagCatalog.HAS_SPARSE_JUNGLE_TREES, BasePlacedFeaturesProviderEntry.SPARSE_JUNGLE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, SPARSE_ACACIA_BRANCH, BiomeTagCatalog.HAS_SPARSE_ACACIA_TREES, BasePlacedFeaturesProviderEntry.SPARSE_ACACIA_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, RARE_OAK_BRANCH, BiomeTagCatalog.HAS_RARE_OAK_TREES, BasePlacedFeaturesProviderEntry.RARE_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, RARE_BIRCH_BRANCH, BiomeTagCatalog.HAS_RARE_BIRCH_TREES, BasePlacedFeaturesProviderEntry.RARE_BIRCH_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        // WILD CROPS
        BiomeModifierTools.addSimpleModifier(context, WILD_YAMS, BiomeTagCatalog.GENERATE_WILD_YAMS, BasePlacedFeaturesProviderEntry.WILD_YAMS, GenerationStep.Decoration.VEGETAL_DECORATION);
    }


}
