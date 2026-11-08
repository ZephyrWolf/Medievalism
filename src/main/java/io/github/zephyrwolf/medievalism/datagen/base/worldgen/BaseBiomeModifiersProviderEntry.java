package io.github.zephyrwolf.medievalism.datagen.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.BiomeModifierTools;
import io.github.zephyrwolf.medievalism.catalogs.tag.BiomeTagCatalog;
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
    public static final ResourceKey<BiomeModifier> CLAY_WITH_DOGBANE =              BiomeModifierTools.registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    //STONE
    // ORE
    public static final ResourceKey<BiomeModifier> CHALK_ORE =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<BiomeModifier> CHERT_ORE =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<BiomeModifier> GEODE_ORE =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("geode_ore"));
    public static final ResourceKey<BiomeModifier> HARD_IG_EX_GEODE_ORE =           BiomeModifierTools.registerKey(MedievalismConstants.resource("hard_ig_ex_geode_ore"));
    // ROCKS
    public static final ResourceKey<BiomeModifier> SURFACE_SANDSTONE_ROCKS =        BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_sandstone_rocks"));
    public static final ResourceKey<BiomeModifier> SURFACE_RED_SANDSTONE_ROCKS =    BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_red_sandstone_rocks"));
    public static final ResourceKey<BiomeModifier> SURFACE_ROCKS =                  BiomeModifierTools.registerKey(MedievalismConstants.resource("surface_rocks"));
    public static final ResourceKey<BiomeModifier> CAVE_ROCKS =                     BiomeModifierTools.registerKey(MedievalismConstants.resource("cave_rocks"));
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
    public static final ResourceKey<BiomeModifier> WILD_BARLEY =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_barley"));
    public static final ResourceKey<BiomeModifier> WILD_BEETROOT =                  BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_beetroot"));
    public static final ResourceKey<BiomeModifier> WILD_BLUEBERRIES =               BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_blueberries"));
    public static final ResourceKey<BiomeModifier> WILD_BROAD_BEAN =                BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_broad_bean"));
    public static final ResourceKey<BiomeModifier> WILD_CABBAGE =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_cabbage"));
    public static final ResourceKey<BiomeModifier> WILD_CARROT =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_carrot"));
    public static final ResourceKey<BiomeModifier> WILD_CHARD =                     BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_chard"));
    public static final ResourceKey<BiomeModifier> WILD_DOGBANE =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_dogbane"));
    public static final ResourceKey<BiomeModifier> WILD_FLAX =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_flax"));
    public static final ResourceKey<BiomeModifier> WILD_GARLIC =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_garlic"));
    public static final ResourceKey<BiomeModifier> WILD_GREEN_PUMPKIN =             BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_green_pumpkin"));
    public static final ResourceKey<BiomeModifier> WILD_LEEK =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_leek"));
    public static final ResourceKey<BiomeModifier> WILD_MELON =                     BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_melon"));
    public static final ResourceKey<BiomeModifier> WILD_NAPA_CABBAGE =              BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_nap_cabbage"));
    public static final ResourceKey<BiomeModifier> WILD_NETTLE =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_nettle"));
    public static final ResourceKey<BiomeModifier> WILD_OATS =                      BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_oats"));
    public static final ResourceKey<BiomeModifier> WILD_PARSNIP =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_parsnip"));
    public static final ResourceKey<BiomeModifier> WILD_POTATO =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_potato"));
    public static final ResourceKey<BiomeModifier> WILD_PUMPKIN =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_pumpkin"));
    public static final ResourceKey<BiomeModifier> WILD_PURPLE_CARROT =             BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_purple_carrot"));
    public static final ResourceKey<BiomeModifier> WILD_PURPLE_ONION =              BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_purple_onion"));
    public static final ResourceKey<BiomeModifier> WILD_PURPLE_SKIRRET =            BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_purple_skirret"));
    public static final ResourceKey<BiomeModifier> WILD_RADISH =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_radish"));
    public static final ResourceKey<BiomeModifier> WILD_RASPBERRIES =               BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_raspberries"));
    public static final ResourceKey<BiomeModifier> WILD_SKIRRET =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_skirret"));
    public static final ResourceKey<BiomeModifier> WILD_SPINACH =                   BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_spinach"));
    public static final ResourceKey<BiomeModifier> WILD_STRAWBERRIES =              BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_strawberries"));
    public static final ResourceKey<BiomeModifier> WILD_TURNIP =                    BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_turnip"));
    public static final ResourceKey<BiomeModifier> WILD_WHITE_CARROT =              BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_white_carrot"));
    public static final ResourceKey<BiomeModifier> WILD_WHITE_ONION =               BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_white_onion"));
    public static final ResourceKey<BiomeModifier> WILD_YAM =                       BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_yam"));
    public static final ResourceKey<BiomeModifier> WILD_WHEAT =                     BiomeModifierTools.registerKey(MedievalismConstants.resource("wild_wheat"));

    // --

    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // DIRT
        context.register(CLAY_IN_DIRT, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTagCatalog.GENERATE_INLAND_CLAY), HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeaturesProviderEntry.CLAY_IN_DIRT)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(CLAY_WITH_DOGBANE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTagCatalog.GENERATE_INLAND_CLAY), HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeaturesProviderEntry.CLAY_WITH_DOGBANE)), GenerationStep.Decoration.VEGETAL_DECORATION));
        // STONE
        // ORE
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
        BiomeModifierTools.addSimpleModifier(context, WILD_BARLEY,              BiomeTagCatalog.GENERATE_WILD_BARLEY,           BasePlacedFeaturesProviderEntry.WILD_BARLEY,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_BEETROOT,            BiomeTagCatalog.GENERATE_WILD_BEETROOT,         BasePlacedFeaturesProviderEntry.WILD_BEETROOT,          GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_BLUEBERRIES,         BiomeTagCatalog.GENERATE_WILD_BLUEBERRIES,      BasePlacedFeaturesProviderEntry.WILD_BLUEBERRIES,       GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_BROAD_BEAN,          BiomeTagCatalog.GENERATE_WILD_BROAD_BEAN,       BasePlacedFeaturesProviderEntry.WILD_BROAD_BEAN,        GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_CABBAGE,             BiomeTagCatalog.GENERATE_WILD_CABBAGE,          BasePlacedFeaturesProviderEntry.WILD_CABBAGE,           GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_CARROT,              BiomeTagCatalog.GENERATE_WILD_CARROT,           BasePlacedFeaturesProviderEntry.WILD_CARROT,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_CHARD,               BiomeTagCatalog.GENERATE_WILD_CHARD,            BasePlacedFeaturesProviderEntry.WILD_CHARD,             GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_DOGBANE,             BiomeTagCatalog.GENERATE_WILD_DOGBANE,          BasePlacedFeaturesProviderEntry.WILD_DOGBANE,           GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_FLAX,                BiomeTagCatalog.GENERATE_WILD_FLAX,             BasePlacedFeaturesProviderEntry.WILD_FLAX,              GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_GARLIC,              BiomeTagCatalog.GENERATE_WILD_GARLIC,           BasePlacedFeaturesProviderEntry.WILD_GARLIC,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_GREEN_PUMPKIN,       BiomeTagCatalog.GENERATE_WILD_GREEN_PUMPKIN,    BasePlacedFeaturesProviderEntry.WILD_GREEN_PUMPKIN,     GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_LEEK,                BiomeTagCatalog.GENERATE_WILD_LEEK,             BasePlacedFeaturesProviderEntry.WILD_LEEK,              GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_MELON,               BiomeTagCatalog.GENERATE_WILD_MELON,            BasePlacedFeaturesProviderEntry.WILD_MELON,             GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_NAPA_CABBAGE,        BiomeTagCatalog.GENERATE_WILD_NAPA_CABBAGE,     BasePlacedFeaturesProviderEntry.WILD_NAPA_CABBAGE,      GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_NETTLE,              BiomeTagCatalog.GENERATE_WILD_NETTLE,           BasePlacedFeaturesProviderEntry.WILD_NETTLE,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_OATS,                BiomeTagCatalog.GENERATE_WILD_OATS,             BasePlacedFeaturesProviderEntry.WILD_OATS,              GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_PARSNIP,             BiomeTagCatalog.GENERATE_WILD_PARSNIP,          BasePlacedFeaturesProviderEntry.WILD_PARSNIP,           GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_POTATO,              BiomeTagCatalog.GENERATE_WILD_POTATO,           BasePlacedFeaturesProviderEntry.WILD_POTATO,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_PUMPKIN,             BiomeTagCatalog.GENERATE_WILD_PUMPKIN,          BasePlacedFeaturesProviderEntry.WILD_PUMPKIN,           GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_PURPLE_CARROT,       BiomeTagCatalog.GENERATE_WILD_PURPLE_CARROT,    BasePlacedFeaturesProviderEntry.WILD_PURPLE_CARROT,     GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_PURPLE_ONION,        BiomeTagCatalog.GENERATE_WILD_PURPLE_ONION,     BasePlacedFeaturesProviderEntry.WILD_PURPLE_ONION,      GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_PURPLE_SKIRRET,      BiomeTagCatalog.GENERATE_WILD_PURPLE_SKIRRET,   BasePlacedFeaturesProviderEntry.WILD_PURPLE_SKIRRET,    GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_RADISH,              BiomeTagCatalog.GENERATE_WILD_RADISH,           BasePlacedFeaturesProviderEntry.WILD_RADISH,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_RASPBERRIES,         BiomeTagCatalog.GENERATE_WILD_RASPBERRIES,      BasePlacedFeaturesProviderEntry.WILD_RASPBERRIES,       GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_SKIRRET,             BiomeTagCatalog.GENERATE_WILD_SKIRRET,          BasePlacedFeaturesProviderEntry.WILD_SKIRRET,           GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_SPINACH,             BiomeTagCatalog.GENERATE_WILD_SPINACH,          BasePlacedFeaturesProviderEntry.WILD_SPINACH,           GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_STRAWBERRIES,        BiomeTagCatalog.GENERATE_WILD_STRAWBERRIES,     BasePlacedFeaturesProviderEntry.WILD_STRAWBERRIES,      GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_TURNIP,              BiomeTagCatalog.GENERATE_WILD_TURNIP,           BasePlacedFeaturesProviderEntry.WILD_TURNIP,            GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_WHITE_CARROT,        BiomeTagCatalog.GENERATE_WILD_WHITE_CARROT,     BasePlacedFeaturesProviderEntry.WILD_WHITE_CARROT,      GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_WHITE_ONION,         BiomeTagCatalog.GENERATE_WILD_WHITE_ONION,      BasePlacedFeaturesProviderEntry.WILD_WHITE_ONION,       GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_YAM,                 BiomeTagCatalog.GENERATE_WILD_YAM,              BasePlacedFeaturesProviderEntry.WILD_YAM,               GenerationStep.Decoration.VEGETAL_DECORATION);
        BiomeModifierTools.addSimpleModifier(context, WILD_WHEAT,               BiomeTagCatalog.GENERATE_WILD_WHEAT,            BasePlacedFeaturesProviderEntry.WILD_WHEAT,             GenerationStep.Decoration.VEGETAL_DECORATION);
    }
}
