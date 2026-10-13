package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.world.level.BiomeTagCatalog;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class BaseBiomeModifiersProviderEntry
{
    // DIRT
    public static final ResourceKey<BiomeModifier> CLAY_IN_DIRT = registerKey(MedievalismConstants.resource("clay_in_dirt"));
    public static final ResourceKey<BiomeModifier> RED_CLAY_IN_DIRT = registerKey(MedievalismConstants.resource("red_clay_in_dirt"));
    public static final ResourceKey<BiomeModifier> RED_CLAY = registerKey(MedievalismConstants.resource("red_clay"));
    public static final ResourceKey<BiomeModifier> RED_CLAY_WITH_DOGBANE = registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    //STONE
    // ORE
    public static final ResourceKey<BiomeModifier> TIN_ORE = registerKey(MedievalismConstants.resource("tin_ore"));
    public static final ResourceKey<BiomeModifier> TIN_ORE_UNIFORM = registerKey(MedievalismConstants.resource("tin_ore_uniform"));
    public static final ResourceKey<BiomeModifier> CHALK_ORE = registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<BiomeModifier> CHERT_ORE = registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<BiomeModifier> GEODE_ORE = registerKey(MedievalismConstants.resource("geode_ore"));
    public static final ResourceKey<BiomeModifier> HARD_IG_EX_GEODE_ORE = registerKey(MedievalismConstants.resource("hard_ig_ex_geode_ore"));
    // ROCK
    public static final ResourceKey<BiomeModifier> SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("sandstone_rock"));
    public static final ResourceKey<BiomeModifier> RED_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("red_sandstone_rock"));
    public static final ResourceKey<BiomeModifier> GREYWACKE_ROCK = registerKey(MedievalismConstants.resource("greywacke_rock"));
    // ROCK LARGE
    public static final ResourceKey<BiomeModifier> LARGE_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("large_sandstone_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_RED_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("large_red_sandstone_rock"));
    public static final ResourceKey<BiomeModifier> LARGE_GREYWACKE_ROCK = registerKey(MedievalismConstants.resource("large_greywacke_rock"));
    // ROCK COPPER
    public static final ResourceKey<BiomeModifier> GREYWACKE_ROCK_COPPER_ORE = registerKey(MedievalismConstants.resource("greywacke_rock_copper"));

    // TWIGS
    public static final ResourceKey<BiomeModifier> DENSE_TWIGS = registerKey(MedievalismConstants.resource("dense_twigs"));
    public static final ResourceKey<BiomeModifier> SPARSE_TWIGS = registerKey(MedievalismConstants.resource("sparse_twigs"));
    public static final ResourceKey<BiomeModifier> RARE_TWIGS = registerKey(MedievalismConstants.resource("rare_twigs"));
    // DENSE BRANCH
    public static final ResourceKey<BiomeModifier> DENSE_OAK_BRANCH = registerKey(MedievalismConstants.resource("dense_oak_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_BIRCH_BRANCH = registerKey(MedievalismConstants.resource("dense_birch_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_SPRUCE_BRANCH = registerKey(MedievalismConstants.resource("dense_spruce_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_JUNGLE_BRANCH = registerKey(MedievalismConstants.resource("dense_jungle_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_DARK_OAK_BRANCH = registerKey(MedievalismConstants.resource("dense_dark_oak_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_CHERRY_BRANCH = registerKey(MedievalismConstants.resource("dense_cherry_branch"));
    public static final ResourceKey<BiomeModifier> DENSE_MANGROVE_BRANCH = registerKey(MedievalismConstants.resource("dense_mangrove_branch"));
    // SPARE BRANCH
    public static final ResourceKey<BiomeModifier> SPARSE_OAK_BRANCH = registerKey(MedievalismConstants.resource("sparse_oak_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_BIRCH_BRANCH = registerKey(MedievalismConstants.resource("sparse_birch_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_SPRUCE_BRANCH = registerKey(MedievalismConstants.resource("sparse_spruce_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_JUNGLE_BRANCH = registerKey(MedievalismConstants.resource("sparse_jungle_branch"));
    public static final ResourceKey<BiomeModifier> SPARSE_ACACIA_BRANCH = registerKey(MedievalismConstants.resource("sparse_acacia_branch"));
    // RARE BRANCH
    public static final ResourceKey<BiomeModifier> RARE_OAK_BRANCH = registerKey(MedievalismConstants.resource("rare_oak_branch"));
    public static final ResourceKey<BiomeModifier> RARE_BIRCH_BRANCH = registerKey(MedievalismConstants.resource("rare_birch_branch"));
    // WILD CROPS
    public static final ResourceKey<BiomeModifier> WILD_YAMS = registerKey(MedievalismConstants.resource("wild_yams"));

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
        addSimpleModifier(context, TIN_ORE,                     BiomeTags.IS_OVERWORLD, BasePlacedFeaturesProviderEntry.TIN_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);
        addSimpleModifier(context, TIN_ORE_UNIFORM,             BiomeTags.IS_OVERWORLD, BasePlacedFeaturesProviderEntry.TIN_ORE_UNIFORM, GenerationStep.Decoration.UNDERGROUND_ORES);
        addSimpleModifier(context, CHALK_ORE,                   BiomeTags.IS_OVERWORLD, BasePlacedFeaturesProviderEntry.CHALK_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);
        addSimpleModifier(context, CHERT_ORE,                   BiomeTags.IS_OVERWORLD, BasePlacedFeaturesProviderEntry.CHERT_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);
        addSimpleModifier(context, GEODE_ORE,                   BiomeTags.IS_OVERWORLD, BasePlacedFeaturesProviderEntry.GEODE_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);
        addSimpleModifier(context, HARD_IG_EX_GEODE_ORE,        BiomeTags.IS_OVERWORLD, BasePlacedFeaturesProviderEntry.HARD_IG_ED_GEODE_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);
        // ROCK
        addSimpleModifier(context, SANDSTONE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITH_SAND,       BasePlacedFeaturesProviderEntry.SANDSTONE_ROCK, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RED_SANDSTONE_ROCK,          BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND,   BasePlacedFeaturesProviderEntry.RED_SANDSTONE_ROCK, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, GREYWACKE_ROCK,              BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    BasePlacedFeaturesProviderEntry.GREYWACKE_ROCK, GenerationStep.Decoration.VEGETAL_DECORATION);
        // LARGE ROCK
        addSimpleModifier(context, LARGE_SANDSTONE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITH_SAND,       BasePlacedFeaturesProviderEntry.LARGE_SANDSTONE_ROCK, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_RED_SANDSTONE_ROCK,    BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND,   BasePlacedFeaturesProviderEntry.LARGE_RED_SANDSTONE_ROCK, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LARGE_GREYWACKE_ROCK,        BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    BasePlacedFeaturesProviderEntry.LARGE_GREYWACKE_ROCK, GenerationStep.Decoration.VEGETAL_DECORATION);
        // COPPER ROCK
        addSimpleModifier(context, GREYWACKE_ROCK_COPPER_ORE,   BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND,    BasePlacedFeaturesProviderEntry.GREYWACKE_ROCK_COPPER_ORE, GenerationStep.Decoration.VEGETAL_DECORATION);
        // TWIGS
        addSimpleModifier(context, DENSE_TWIGS, BiomeTagCatalog.HAS_DENSE_TREES, BasePlacedFeaturesProviderEntry.DENSE_TWIGS, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_TWIGS, BiomeTagCatalog.HAS_SPARSE_TREES, BasePlacedFeaturesProviderEntry.SPARSE_TWIGS, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RARE_TWIGS, BiomeTagCatalog.HAS_RARE_TREES, BasePlacedFeaturesProviderEntry.RARE_TWIGS, GenerationStep.Decoration.VEGETAL_DECORATION);
        // BRANCHES
        addSimpleModifier(context, DENSE_OAK_BRANCH, BiomeTagCatalog.HAS_DENSE_OAK_TREES, BasePlacedFeaturesProviderEntry.DENSE_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_BIRCH_BRANCH, BiomeTagCatalog.HAS_DENSE_BIRCH_TREES, BasePlacedFeaturesProviderEntry.DENSE_BIRCH_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_SPRUCE_BRANCH, BiomeTagCatalog.HAS_DENSE_SPRUCE_TREES, BasePlacedFeaturesProviderEntry.DENSE_SPRUCE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_JUNGLE_BRANCH, BiomeTagCatalog.HAS_DENSE_JUNGLE_TREES, BasePlacedFeaturesProviderEntry.DENSE_JUNGLE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_CHERRY_BRANCH, BiomeTagCatalog.HAS_DENSE_CHERRY_TREES, BasePlacedFeaturesProviderEntry.DENSE_CHERRY_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_DARK_OAK_BRANCH, BiomeTagCatalog.HAS_DENSE_DARK_OAK_TREES, BasePlacedFeaturesProviderEntry.DENSE_DARK_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_MANGROVE_BRANCH, BiomeTagCatalog.HAS_DENSE_MANGROVE_TREES, BasePlacedFeaturesProviderEntry.DENSE_MANGROVE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_OAK_BRANCH, BiomeTagCatalog.HAS_SPARSE_OAK_TREES, BasePlacedFeaturesProviderEntry.SPARSE_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_BIRCH_BRANCH, BiomeTagCatalog.HAS_SPARSE_BIRCH_TREES, BasePlacedFeaturesProviderEntry.SPARSE_BIRCH_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_SPRUCE_BRANCH, BiomeTagCatalog.HAS_SPARSE_SPRUCE_TREES, BasePlacedFeaturesProviderEntry.SPARSE_SPRUCE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_JUNGLE_BRANCH, BiomeTagCatalog.HAS_SPARSE_JUNGLE_TREES, BasePlacedFeaturesProviderEntry.SPARSE_JUNGLE_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_ACACIA_BRANCH, BiomeTagCatalog.HAS_SPARSE_ACACIA_TREES, BasePlacedFeaturesProviderEntry.SPARSE_ACACIA_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RARE_OAK_BRANCH, BiomeTagCatalog.HAS_RARE_OAK_TREES, BasePlacedFeaturesProviderEntry.RARE_OAK_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RARE_BIRCH_BRANCH, BiomeTagCatalog.HAS_RARE_BIRCH_TREES, BasePlacedFeaturesProviderEntry.RARE_BIRCH_BRANCH, GenerationStep.Decoration.VEGETAL_DECORATION);
        // WILD CROPS
        addSimpleModifier(context, WILD_YAMS, BiomeTagCatalog.GENERATE_WILD_YAMS, BasePlacedFeaturesProviderEntry.WILD_YAMS, GenerationStep.Decoration.VEGETAL_DECORATION);
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
