package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.TwigsBlock;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.FeatureTools;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.CompositeFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayerSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayeredPlacedFeature;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.SpeckledOreConfiguration;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.registration.world.level.FeatureRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class BaseConfiguredFeaturesProviderEntry
{
    // DIRT
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLAY_IN_DIRT =                     FeatureTools.registerKey(MedievalismConstants.resource("clay_in_dirt"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CLAY_IN_DIRT =                 FeatureTools.registerKey(MedievalismConstants.resource("red_clay_in_dirt"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CLAY =                         FeatureTools.registerKey(MedievalismConstants.resource("red_clay"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CLAY_WITH_DOGBANE =            FeatureTools.registerKey(MedievalismConstants.resource("red_clay_with_dogbane"));
    // STONE
    // ORE
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TIN_ORE =                FeatureTools.registerKey(MedievalismConstants.resource("tin_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHALK_ORE =                        FeatureTools.registerKey(MedievalismConstants.resource("chalk_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERT_ORE =                        FeatureTools.registerKey(MedievalismConstants.resource("chert_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> GEODE_ORE =                        FeatureTools.registerKey(MedievalismConstants.resource("geode_ore"));
    // ROCK
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SANDSTONE_ROCKS =          FeatureTools.registerKey(MedievalismConstants.resource("surface_sandstone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_RED_SANDSTONE_ROCKS =      FeatureTools.registerKey(MedievalismConstants.resource("surface_red_sandstone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_ROCKS =          FeatureTools.registerKey(MedievalismConstants.resource("surface_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_ROCKS =             FeatureTools.registerKey(MedievalismConstants.resource("cave_rocks"));
    //TWIGS
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TWIGS =                      FeatureTools.registerKey(MedievalismConstants.resource("dense_twigs"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_TWIGS =                     FeatureTools.registerKey(MedievalismConstants.resource("sparse_twigs"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_TWIGS =                       FeatureTools.registerKey(MedievalismConstants.resource("rare_twigs"));
    // DENSE BRANCH
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_OAK_BRANCH =                 FeatureTools.registerKey(MedievalismConstants.resource("dense_oak_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_BIRCH_BRANCH =               FeatureTools.registerKey(MedievalismConstants.resource("dense_birch_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_SPRUCE_BRANCH =              FeatureTools.registerKey(MedievalismConstants.resource("dense_spruce_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_JUNGLE_BRANCH =              FeatureTools.registerKey(MedievalismConstants.resource("dense_jungle_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_CHERRY_BRANCH =              FeatureTools.registerKey(MedievalismConstants.resource("dense_cherry_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_DARK_OAK_BRANCH =            FeatureTools.registerKey(MedievalismConstants.resource("dense_dark_oak_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MANGROVE_BRANCH =            FeatureTools.registerKey(MedievalismConstants.resource("dense_mangrove_branch"));
    // SPARSE BRANCH
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_OAK_BRANCH =                FeatureTools.registerKey(MedievalismConstants.resource("sparse_oak_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_BIRCH_BRANCH =              FeatureTools.registerKey(MedievalismConstants.resource("sparse_birch_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_SPRUCE_BRANCH =             FeatureTools.registerKey(MedievalismConstants.resource("sparse_spruce_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_JUNGLE_BRANCH =             FeatureTools.registerKey(MedievalismConstants.resource("sparse_jungle_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_ACACIA_BRANCH =             FeatureTools.registerKey(MedievalismConstants.resource("spare_acacia_branch"));
    // RARE BRANCH
    public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_OAK_BRANCH =                  FeatureTools.registerKey(MedievalismConstants.resource("rare_oak_branch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_BIRCH_BRANCH =                FeatureTools.registerKey(MedievalismConstants.resource("rare_birch_branch"));
    // WILD CROPS
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_YAMS =                        FeatureTools.registerKey(MedievalismConstants.resource("wild_yams"));

    // --

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        //var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        // TODO Methodise this monstrosity

        RuleTest stoneAndDirtTest = new TagMatchTest(BlockTagCatalog.CLAY_CAN_REPLACE);
        RuleTest grassBlockTest = new BlockMatchTest(Blocks.GRASS_BLOCK);
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest limestoneReplaceables = new TagMatchTest(BlockTagCatalog.LIMESTONE_ORE_REPLACEABLES); // TODO Make me a tag
        RuleTest chalkReplaceables = new TagMatchTest(BlockTagCatalog.CHALK_ORE_REPLACEABLES); // TODO Make me a tag
        RuleTest basaltReplaceables = new TagMatchTest(BlockTagCatalog.BASALT_ORE_REPLACEABLES);
        RuleTest andesiteReplaceables = new TagMatchTest(BlockTagCatalog.ANDESITE_ORE_REPLACEABLES);
        RuleTest rhyoliteReplaceables = new TagMatchTest(BlockTagCatalog.RHYOLITE_ORE_REPLACEABLES);
        RuleTest daciteReplaceables = new TagMatchTest(BlockTagCatalog.DACITE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> clayInDirtTargetBlockStates = List.of(
                OreConfiguration.target(stoneAndDirtTest, BlockRegistration.CLAY_IN_DIRT.get().defaultBlockState()),
                OreConfiguration.target(grassBlockTest, BlockRegistration.CLAY_IN_GRASS.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> redClayInDirtTargetBlockStates = List.of(
                OreConfiguration.target(stoneAndDirtTest, BlockRegistration.RED_CLAY_IN_DIRT.get().defaultBlockState()),
                OreConfiguration.target(grassBlockTest, BlockRegistration.RED_CLAY_IN_GRASS.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> richClayTargetBlockStates = List.of(
                OreConfiguration.target(stoneAndDirtTest, BlockRegistration.RED_CLAY.get().defaultBlockState()),
                OreConfiguration.target(grassBlockTest, BlockRegistration.RED_CLAY_IN_GRASS.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> tinOres = List.of(
                OreConfiguration.target(stoneReplaceables, BlockRegistration.TIN_ORE_IN_GREYWACKE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistration.TIN_ORE_IN_GABBRO.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> chalkOres = List.of(
                OreConfiguration.target(limestoneReplaceables, BlockRegistration.CHALK.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> chertOres = List.of(
                OreConfiguration.target(limestoneReplaceables, BlockRegistration.LIMESTONE_CHERT_ORE.get().defaultBlockState()),
                OreConfiguration.target(chalkReplaceables, BlockRegistration.CHALK_CHERT_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> geodeOres = List.of(
                OreConfiguration.target(basaltReplaceables, BlockRegistration.BASALT_GEODE_ORE.get().defaultBlockState()),
                OreConfiguration.target(andesiteReplaceables, BlockRegistration.ANDESITE_GEODE_ORE.get().defaultBlockState()),
                OreConfiguration.target(rhyoliteReplaceables, BlockRegistration.RHYOLITE_GEODE_ORE.get().defaultBlockState()),
                OreConfiguration.target(daciteReplaceables, BlockRegistration.DACITE_GEODE_ORE.get().defaultBlockState())
        );

        // DIRT
        FeatureTools.register(context, CLAY_IN_DIRT, Feature.ORE, new OreConfiguration(clayInDirtTargetBlockStates, 64));
        FeatureTools.register(context, RED_CLAY_IN_DIRT, Feature.ORE, new OreConfiguration(redClayInDirtTargetBlockStates, 48));
        FeatureTools.register(context, RED_CLAY, Feature.ORE, new OreConfiguration(richClayTargetBlockStates, 32));
        FeatureTools.register(context, RED_CLAY_WITH_DOGBANE, FeatureRegistration.COMPOSITE_FEATURE.get(), new CompositeFeatureConfiguration(List.of(
                PlacementUtils.inlinePlaced(Feature.ORE, new OreConfiguration(
                        richClayTargetBlockStates, 48
                ), HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), RandomOffsetPlacement.vertical(UniformInt.of(-5, 0))),
                PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                        15,
                        4,
                        0,
                        PlacementUtils.inlinePlaced(
                                Feature.BLOCK_COLUMN,
                                BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 5), BlockStateProvider.simple(BlockRegistration.DOGBANE.get())),
                                BlockPredicateFilter.forPredicate(
                                        BlockPredicate.allOf(
                                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                                BlockPredicate.wouldSurvive(BlockRegistration.DOGBANE.get().defaultBlockState(), BlockPos.ZERO)
                                        )
                                ),
                                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG)
                        )
                ))
        )));
        // STONE
        // ORES
        FeatureTools.register(context, OVERWORLD_TIN_ORE, Feature.ORE, new OreConfiguration(tinOres, 9));
        FeatureTools.register(context, CHALK_ORE, FeatureRegistration.SPECKLED_ORE_FEATURE.get(), new SpeckledOreConfiguration(chalkOres, chertOres, 56, 0.15f));
        FeatureTools.register(context, CHERT_ORE, Feature.ORE, new OreConfiguration(chertOres, 2));
        FeatureTools.register(context, GEODE_ORE, Feature.ORE, new OreConfiguration(geodeOres, 1));
        // ROCK
        final int Y_SPREAD = 0;

        final int SURFACE_SANDSTONE_TRIES = 2;
        final int SURFACE_STONE_TRIES = 2;
        final int CAVE_TRIES = 2;

        final int SURFACE_SANDSTONE_XZ_SPREAD = 3;
        final int SURFACE_STONE_XZ_SPREAD = 3;
        final int CAVE_XZ_SPREAD = 3;

        final float LARGE_ROCK_CHANCE = 0.3f;
        final float ORE_ROCK_CHANCE = 0.25f;

        FeatureTools.registerRandomPatch(context, SURFACE_SANDSTONE_ROCKS, SURFACE_SANDSTONE_TRIES, SURFACE_SANDSTONE_XZ_SPREAD, 0, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SANDSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_SANDSTONE_ROCK.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_RED_SANDSTONE_ROCKS, SURFACE_SANDSTONE_TRIES, SURFACE_SANDSTONE_XZ_SPREAD, 0, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.RED_SANDSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_ROCKS, SURFACE_STONE_TRIES, SURFACE_STONE_XZ_SPREAD, 0, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.GREYWACKE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_GREYWACKE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));

        Holder<PlacedFeature> holderCaveStone = FeatureTools.inlineRandomPatch(CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.GREYWACKE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_GREYWACKE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        Holder<PlacedFeature> holderCaveDeepslate = FeatureTools.inlineRandomPatch(CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.GABBRO_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.GABBRO_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.register(context, CAVE_ROCKS, FeatureRegistration.LAYER_SELECTOR_FEATURE.get(), LayerSelectorFeatureConfiguration.layers(
                WorldLayersRegistration.VANILLA_OVERWORLD_MAP.getKey(),
                LayeredPlacedFeature.layer(WorldLayersRegistration.VANILLA_OVERWORLD_STONE.getKey(), holderCaveStone),
                LayeredPlacedFeature.layer(WorldLayersRegistration.VANILLA_OVERWORLD_DEEPSLATE.getKey(), holderCaveDeepslate)
        ));

        // TWIGS
        FeatureTools.register(context, DENSE_TWIGS, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        3, 4, 0,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new RandomizedIntStateProvider(
                                                BlockStateProvider.simple(BlockRegistration.TWIGS.get()),
                                                TwigsBlock.NUM_STICKS,
                                                UniformInt.of(1, 3))
                                )
                        )
                )
        );
        FeatureTools.register(context, SPARSE_TWIGS, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        2, 4, 0,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new RandomizedIntStateProvider(
                                                BlockStateProvider.simple(BlockRegistration.TWIGS.get()),
                                                TwigsBlock.NUM_STICKS,
                                                UniformInt.of(1, 2))
                                )
                        )
                )
        );
        FeatureTools.register(context, RARE_TWIGS, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        1, 0, 0,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new RandomizedIntStateProvider(
                                                BlockStateProvider.simple(BlockRegistration.TWIGS.get()),
                                                TwigsBlock.NUM_STICKS,
                                                UniformInt.of(1, 1))
                                )
                        )
                )
        );
        // DENSE BRANCH
        FeatureTools.registerRandomPatch(context, DENSE_OAK_BRANCH,         3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.OAK_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, DENSE_BIRCH_BRANCH,       3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.BIRCH_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, DENSE_SPRUCE_BRANCH,      3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SPRUCE_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, DENSE_JUNGLE_BRANCH,      3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.JUNGLE_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, DENSE_CHERRY_BRANCH,      3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.CHERRY_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, DENSE_DARK_OAK_BRANCH,    3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.DARK_OAK_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, DENSE_MANGROVE_BRANCH,    3, 4, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.MANGROVE_BRANCH.get()));
        // SPARSE BRANCH
        FeatureTools.registerRandomPatch(context, SPARSE_OAK_BRANCH,        2, 3, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.OAK_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, SPARSE_BIRCH_BRANCH,      2, 3, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.BIRCH_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, SPARSE_SPRUCE_BRANCH,     2, 3, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SPRUCE_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, SPARSE_JUNGLE_BRANCH,     2, 3, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.JUNGLE_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, SPARSE_ACACIA_BRANCH,     2, 3, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.ACACIA_BRANCH.get()));
        // RARE BRANCH
        FeatureTools.registerRandomPatch(context, RARE_OAK_BRANCH,          1, 0, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.OAK_BRANCH.get()));
        FeatureTools.registerRandomPatch(context, RARE_BIRCH_BRANCH,        1, 0, 0, FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.BIRCH_BRANCH.get()));
        // WILD CROPS
        FeatureTools.register(context, WILD_YAMS, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(7, 3, 0,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        SimpleStateProvider.simple(
                                                BlockRegistration.WILD_YAMS.get()
                                        )
                                )
                        )
                )
        );
    }
}
