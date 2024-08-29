package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.worldgen.feature.configuration.CompositeFeatureConfiguration;
import io.github.zephyrwolf.medievalism.content.block.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.worldgen.FeatureRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class BaseConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_OAK_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_oak_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_BIRCH_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_birch_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_SPRUCE_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_spruce_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_JUNGLE_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_jungle_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_CHERRY_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_cherry_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_DARK_OAK_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_dark_oak_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_MANGROVE_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_mangrove_branch_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> SPARSE_OAK_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("sparse_oak_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SPARSE_BIRCH_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("sparse_birch_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SPARSE_SPRUCE_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("sparse_spruce_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SPARSE_JUNGLE_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("sparse_jungle_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SPARSE_ACACIA_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("spare_acacia_branch_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> RARE_OAK_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("rare_oak_branch_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> RARE_BIRCH_BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("rare_birch_branch_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TIN_ORE_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("tin_ore"));

    public static final ResourceKey<ConfiguredFeature<?,?>> ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> RIVER_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("river_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SANDSTONE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("sandstone_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_SANDSTONE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("red_sandstone_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> MOSSY_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("mossy_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> LIGHTER_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("lighter_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SNOWY_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("snowy_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("ice_rock_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("dense_large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SANDSTONE_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("sandstone_large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_SANDSTONE_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("red_sandstone_large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> MOSSY_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("mossy_large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> LIGHTER_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("lighter_large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> SNOWY_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("snowy_large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("ice_large_rock_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> LIMESTONE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("limestone_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> COPPER_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("copper_rock_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> RED_CLAY_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("red_clay_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_CLAY_WITH_DOGBANE_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("red_clay_with_dogbane_configured"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context)
    {
        //var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> overworldTinOres = List.of(
                OreConfiguration.target(stoneReplaceables, BlockRegistration.TIN_ORE_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get().defaultBlockState())
        );
        register(context, OVERWORLD_TIN_ORE_CONFIGURED_KEY, Feature.ORE, new OreConfiguration(overworldTinOres, 9));

        simpleRandomPatch(context, DENSE_OAK_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.OAK_BRANCH_BLOCK.get());
        simpleRandomPatch(context, DENSE_BIRCH_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.BIRCH_BRANCH_BLOCK.get());
        simpleRandomPatch(context, DENSE_SPRUCE_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.SPRUCE_BRANCH_BLOCK.get());
        simpleRandomPatch(context, DENSE_JUNGLE_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.JUNGLE_BRANCH_BLOCK.get());
        simpleRandomPatch(context, DENSE_CHERRY_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.CHERRY_BRANCH_BLOCK.get());
        simpleRandomPatch(context, DENSE_DARK_OAK_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.DARK_OAK_BRANCH_BLOCK.get());
        simpleRandomPatch(context, DENSE_MANGROVE_BRANCH_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.MANGROVE_BRANCH_BLOCK.get());

        simpleRandomPatch(context, SPARSE_OAK_BRANCH_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.OAK_BRANCH_BLOCK.get());
        simpleRandomPatch(context, SPARSE_BIRCH_BRANCH_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.BIRCH_BRANCH_BLOCK.get());
        simpleRandomPatch(context, SPARSE_SPRUCE_BRANCH_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.SPRUCE_BRANCH_BLOCK.get());
        simpleRandomPatch(context, SPARSE_JUNGLE_BRANCH_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.JUNGLE_BRANCH_BLOCK.get());
        simpleRandomPatch(context, SPARSE_ACACIA_BRANCH_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.ACACIA_BRANCH_BLOCK.get());

        simpleRandomPatch(context, RARE_OAK_BRANCH_CONFIGURED_KEY, 1, 0, 0, BlockRegistration.OAK_BRANCH_BLOCK.get());
        simpleRandomPatch(context, RARE_BIRCH_BRANCH_CONFIGURED_KEY, 1, 0, 0, BlockRegistration.BIRCH_BRANCH_BLOCK.get());

        simpleRandomPatch(context, ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.ROCK_BLOCK.get());
        simpleRandomPatch(context, DENSE_ROCK_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.ROCK_BLOCK.get());
        simpleRandomPatch(context, RIVER_ROCK_CONFIGURED_KEY, 2, 2, 0, BlockRegistration.ROCK_BLOCK.get());
        simpleRandomPatch(context, SANDSTONE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.SANDSTONE_ROCK_BLOCK.get());
        simpleRandomPatch(context, RED_SANDSTONE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get());
        simpleRandomPatch(context, MOSSY_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.MOSSY_ROCK_BLOCK.get());
        simpleRandomPatch(context, LIGHTER_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.LIGHTER_ROCK_BLOCK.get());
        simpleRandomPatch(context, SNOWY_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.SNOWY_ROCK_BLOCK.get());
        simpleRandomPatch(context, ICE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.ICE_ROCK_BLOCK.get());

        simpleRandomPatch(context, LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, DENSE_LARGE_ROCK_CONFIGURED_KEY, 3, 4, 0, BlockRegistration.LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, SANDSTONE_LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.SANDSTONE_LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, RED_SANDSTONE_LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.RED_SANDSTONE_LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, MOSSY_LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.MOSSY_LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, LIGHTER_LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.LIGHTER_LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, SNOWY_LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.SNOWY_LARGE_ROCK_BLOCK.get());
        simpleRandomPatch(context, ICE_LARGE_ROCK_CONFIGURED_KEY, 2, 3, 0, BlockRegistration.ICE_LARGE_ROCK_BLOCK.get());

        register(context, LIMESTONE_ROCK_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(1, 0, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.LIMESTONE_ROCK_BLOCK.get())))));
        register(context, COPPER_ROCK_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(1, 0, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.COPPER_ROCK_BLOCK.get())))));

        RuleTest redClayReplaceables = new TagMatchTest(BlockTagCatalog.RED_CLAY_CAN_REPLACE);
        List<OreConfiguration.TargetBlockState> redClayTargetBlockStates = List.of(
                OreConfiguration.target(redClayReplaceables, BlockRegistration.RED_CLAY_BLOCK.get().defaultBlockState())
        );

        register(context, RED_CLAY_CONFIGURED_KEY, Feature.ORE, new OreConfiguration(redClayTargetBlockStates,32));
        register(context, RED_CLAY_WITH_DOGBANE_CONFIGURED_KEY, FeatureRegistration.COMPOSITE_FEATURE.get(), new CompositeFeatureConfiguration(List.of(
                PlacementUtils.inlinePlaced(Feature.ORE, new OreConfiguration(
                        redClayTargetBlockStates, 48
                ), HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), RandomOffsetPlacement.vertical(UniformInt.of(-5, 0))),
                PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                        15,
                        4,
                        0,
                        PlacementUtils.inlinePlaced(
                                Feature.BLOCK_COLUMN,
                                BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 5), BlockStateProvider.simple(BlockRegistration.DOGBANE_BLOCK.get())),
                                BlockPredicateFilter.forPredicate(
                                        BlockPredicate.allOf(
                                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                                BlockPredicate.wouldSurvive(BlockRegistration.DOGBANE_BLOCK.get().defaultBlockState(), BlockPos.ZERO)
                                        )
                                ),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG)
                        )
                ))
        )));
    }

    public static void simpleRandomPatch(BootstrapContext<ConfiguredFeature<?,?>> context, ResourceKey<ConfiguredFeature<?,?>> featureKey,
                                         int tries, int xzSpread, int ySpread, Block block)
    {
        simpleRandomPatch( context, featureKey, tries, xzSpread, ySpread, BlockStateProvider.simple( block ));
    }

    public static void simpleRandomPatch(BootstrapContext<ConfiguredFeature<?,?>> context, ResourceKey<ConfiguredFeature<?,?>> featureKey,
                                         int tries, int xzSpread, int ySpread, BlockStateProvider blockStateProvider)
    {
        register(context, featureKey, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        tries, xzSpread, ySpread,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( blockStateProvider )
                        )
                )
        );
    }

    public static ResourceKey<ConfiguredFeature<?,?>> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, resource);
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void register(BootstrapContext<ConfiguredFeature<?,?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
