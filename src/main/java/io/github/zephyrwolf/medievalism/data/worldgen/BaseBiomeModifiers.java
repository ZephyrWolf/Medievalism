package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.worldgen.BiomeTagCatalog;
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
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class BaseBiomeModifiers
{
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey(MedievalismConstants.resource("add_tin_ore"));
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE_UNIFORM = registerKey(MedievalismConstants.resource("add_tin_ore_uniform"));

    public static final ResourceKey<BiomeModifier> DENSE_OAK_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_oak_branch_modifier"));
    public static final ResourceKey<BiomeModifier> DENSE_BIRCH_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_birch_branch_modifier"));
    public static final ResourceKey<BiomeModifier> DENSE_SPRUCE_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_spruce_branch_modifier"));
    public static final ResourceKey<BiomeModifier> DENSE_JUNGLE_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_jungle_branch_modifier"));
    public static final ResourceKey<BiomeModifier> DENSE_DARK_OAK_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_dark_oak_branch_modifier"));
    public static final ResourceKey<BiomeModifier> DENSE_CHERRY_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_cherry_branch_modifier"));
    public static final ResourceKey<BiomeModifier> DENSE_MANGROVE_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("dense_mangrove_branch_modifier"));

    public static final ResourceKey<BiomeModifier> SPARSE_OAK_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("sparse_oak_branch_modifier"));
    public static final ResourceKey<BiomeModifier> SPARSE_BIRCH_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("sparse_birch_branch_modifier"));
    public static final ResourceKey<BiomeModifier> SPARSE_SPRUCE_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("sparse_spruce_branch_modifier"));
    public static final ResourceKey<BiomeModifier> SPARSE_JUNGLE_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("sparse_jungle_branch_modifier"));
    public static final ResourceKey<BiomeModifier> SPARSE_ACACIA_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("sparse_acacia_branch_modifier"));

    public static final ResourceKey<BiomeModifier> RARE_OAK_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("rare_oak_branch_modifier"));
    public static final ResourceKey<BiomeModifier> RARE_BIRCH_BRANCH_MODIFIER = registerKey(MedievalismConstants.resource("rare_birch_branch_modifier"));

    public static final ResourceKey<BiomeModifier> ROCK = registerKey(MedievalismConstants.resource("rock"));
    public static final ResourceKey<BiomeModifier> DENSE_ROCK = registerKey(MedievalismConstants.resource("dense_rock"));
    public static final ResourceKey<BiomeModifier> RIVER_ROCK = registerKey(MedievalismConstants.resource("river_rock"));
    public static final ResourceKey<BiomeModifier> SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("sandstone_rock"));
    public static final ResourceKey<BiomeModifier> RED_SANDSTONE_ROCK = registerKey(MedievalismConstants.resource("red_sandstone_rock"));
    public static final ResourceKey<BiomeModifier> MOSSY_ROCK = registerKey(MedievalismConstants.resource("mossy_rock"));
    public static final ResourceKey<BiomeModifier> LIGHTER_ROCK = registerKey(MedievalismConstants.resource("lighter_rock"));
    public static final ResourceKey<BiomeModifier> SNOWY_ROCK = registerKey(MedievalismConstants.resource("snowy_rock"));
    public static final ResourceKey<BiomeModifier> ICE_ROCK = registerKey(MedievalismConstants.resource("ice_rock"));

    public static final ResourceKey<BiomeModifier> LARGE_ROCK = registerKey(MedievalismConstants.resource("large_rock"));
    public static final ResourceKey<BiomeModifier> DENSE_LARGE_ROCK = registerKey(MedievalismConstants.resource("dense_large_rock"));
    public static final ResourceKey<BiomeModifier> SANDSTONE_LARGE_ROCK = registerKey(MedievalismConstants.resource("sandstone_large_rock"));
    public static final ResourceKey<BiomeModifier> RED_SANDSTONE_LARGE_ROCK = registerKey(MedievalismConstants.resource("red_sandstone_large_rock"));
    public static final ResourceKey<BiomeModifier> MOSSY_LARGE_ROCK = registerKey(MedievalismConstants.resource("mossy_large_rock"));
    public static final ResourceKey<BiomeModifier> LIGHTER_LARGE_ROCK = registerKey(MedievalismConstants.resource("lighter_large_rock"));
    public static final ResourceKey<BiomeModifier> SNOWY_LARGE_ROCK = registerKey(MedievalismConstants.resource("snowy_large_rock"));
    public static final ResourceKey<BiomeModifier> ICE_LARGE_ROCK = registerKey(MedievalismConstants.resource("ice_large_rock"));

    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE_ROCK = registerKey(MedievalismConstants.resource("add_limestone_rock"));
    public static final ResourceKey<BiomeModifier> ADD_COPPER_ROCK = registerKey(MedievalismConstants.resource("add_copper_rock"));

    public static final ResourceKey<BiomeModifier> ADD_RED_CLAY = registerKey(MedievalismConstants.resource("add_red_clay"));
    public static final ResourceKey<BiomeModifier> ADD_RED_CLAY_WITH_DOGBANE = registerKey(MedievalismConstants.resource("add_red_clay_with_dogbane"));

    public static final ResourceKey<BiomeModifier> ADD_WILD_YAMS = registerKey(MedievalismConstants.resource("add_wild_yams"));

    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_TIN_ORE_UNIFORM, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeatures.TIN_ORE_UNIFORM_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        addSimpleModifier(context, DENSE_OAK_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_OAK_TREES, BasePlacedFeatures.DENSE_OAK_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_BIRCH_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_BIRCH_TREES, BasePlacedFeatures.DENSE_BIRCH_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_SPRUCE_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_SPRUCE_TREES, BasePlacedFeatures.DENSE_SPRUCE_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_JUNGLE_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_JUNGLE_TREES, BasePlacedFeatures.DENSE_JUNGLE_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_CHERRY_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_CHERRY_TREES, BasePlacedFeatures.DENSE_CHERRY_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_DARK_OAK_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_DARK_OAK_TREES, BasePlacedFeatures.DENSE_DARK_OAK_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_MANGROVE_BRANCH_MODIFIER, BiomeTagCatalog.HAS_DENSE_MANGROVE_TREES, BasePlacedFeatures.DENSE_MANGROVE_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);

        addSimpleModifier(context, SPARSE_OAK_BRANCH_MODIFIER, BiomeTagCatalog.HAS_SPARSE_OAK_TREES, BasePlacedFeatures.SPARSE_OAK_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_BIRCH_BRANCH_MODIFIER, BiomeTagCatalog.HAS_SPARSE_BIRCH_TREES, BasePlacedFeatures.SPARSE_BIRCH_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_SPRUCE_BRANCH_MODIFIER, BiomeTagCatalog.HAS_SPARSE_SPRUCE_TREES, BasePlacedFeatures.SPARSE_SPRUCE_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_JUNGLE_BRANCH_MODIFIER, BiomeTagCatalog.HAS_SPARSE_JUNGLE_TREES, BasePlacedFeatures.SPARSE_JUNGLE_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SPARSE_ACACIA_BRANCH_MODIFIER, BiomeTagCatalog.HAS_SPARSE_ACACIA_TREES, BasePlacedFeatures.SPARSE_ACACIA_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);

        addSimpleModifier(context, RARE_OAK_BRANCH_MODIFIER, BiomeTagCatalog.HAS_RARE_OAK_TREES, BasePlacedFeatures.RARE_OAK_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RARE_BIRCH_BRANCH_MODIFIER, BiomeTagCatalog.HAS_RARE_BIRCH_TREES, BasePlacedFeatures.RARE_BIRCH_BRANCH_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);

        addSimpleModifier(context, ROCK, BiomeTagCatalog.GENERATE_STONE_ROCK, BasePlacedFeatures.ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_ROCK, BiomeTagCatalog.GENERATE_DENSE_STONE_ROCK, BasePlacedFeatures.DENSE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RIVER_ROCK, Tags.Biomes.IS_RIVER, BasePlacedFeatures.RIVER_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SANDSTONE_ROCK, BiomeTagCatalog.GENERATE_SANDSTONE_ROCK, BasePlacedFeatures.SANDSTONE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RED_SANDSTONE_ROCK, BiomeTagCatalog.GENERATE_RED_SANDSTONE_ROCK, BasePlacedFeatures.RED_SANDSTONE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, MOSSY_ROCK, BiomeTagCatalog.GENERATE_MOSSY_ROCK, BasePlacedFeatures.MOSSY_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LIGHTER_ROCK, BiomeTagCatalog.GENERATE_LIGHTER_ROCK, BasePlacedFeatures.LIGHTER_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SNOWY_ROCK, BiomeTagCatalog.GENERATE_SNOWY_ROCK, BasePlacedFeatures.SNOWY_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, ICE_ROCK, BiomeTagCatalog.GENERATE_ICE_ROCK, BasePlacedFeatures.ICE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);

        addSimpleModifier(context, LARGE_ROCK, BiomeTagCatalog.GENERATE_STONE_ROCK, BasePlacedFeatures.LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, DENSE_LARGE_ROCK, BiomeTagCatalog.GENERATE_DENSE_STONE_ROCK, BasePlacedFeatures.DENSE_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SANDSTONE_LARGE_ROCK, BiomeTagCatalog.GENERATE_SANDSTONE_ROCK, BasePlacedFeatures.SANDSTONE_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, RED_SANDSTONE_LARGE_ROCK, BiomeTagCatalog.GENERATE_RED_SANDSTONE_ROCK, BasePlacedFeatures.RED_SANDSTONE_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, MOSSY_LARGE_ROCK, BiomeTagCatalog.GENERATE_MOSSY_ROCK, BasePlacedFeatures.MOSSY_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, LIGHTER_LARGE_ROCK, BiomeTagCatalog.GENERATE_LIGHTER_ROCK, BasePlacedFeatures.LIGHTER_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, SNOWY_LARGE_ROCK, BiomeTagCatalog.GENERATE_SNOWY_ROCK, BasePlacedFeatures.SNOWY_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
        addSimpleModifier(context, ICE_LARGE_ROCK, BiomeTagCatalog.GENERATE_ICE_ROCK, BasePlacedFeatures.ICE_LARGE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);

        addSimpleModifier(context, ADD_LIMESTONE_ROCK, BiomeTagCatalog.GENERATE_LIMESTONE_ROCK, BasePlacedFeatures.LIMESTONE_ROCK_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);

        context.register(ADD_COPPER_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeatures.COPPER_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_RED_CLAY, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTagCatalog.GENERATE_RED_CLAY),
                HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeatures.RED_CLAY_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(ADD_RED_CLAY_WITH_DOGBANE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTagCatalog.GENERATE_RED_CLAY),
                HolderSet.direct(placedFeatures.getOrThrow(BasePlacedFeatures.RED_CLAY_WITH_DOGBANE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        addSimpleModifier(context, ADD_WILD_YAMS, BiomeTagCatalog.GENERATE_WILD_YAMS, BasePlacedFeatures.WILD_YAMS_PLACED_KEY, GenerationStep.Decoration.VEGETAL_DECORATION);
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
