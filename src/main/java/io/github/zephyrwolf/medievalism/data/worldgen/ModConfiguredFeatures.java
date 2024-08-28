package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.worldgen.feature.configuration.CompositeFeatureConfiguration;
import io.github.zephyrwolf.medievalism.content.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.content.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.FeatureRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.UniformInt;
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

public final class ModConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TIN_ORE_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("tin_ore"));

    public static final ResourceKey<ConfiguredFeature<?,?>> BRANCH_FOREST_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("branch_forest_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> BRANCH_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("branch_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> LARGE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("large_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> LIMESTONE_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("limestone_rock_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> COPPER_ROCK_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("copper_rock_configured"));

    public static final ResourceKey<ConfiguredFeature<?,?>> RED_CLAY_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("red_clay_configured"));
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_CLAY_WITH_DOGBANE_CONFIGURED_KEY = registerKey(MedievalismConstants.resource("red_clay_with_dogbane_configured"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> overworldTinOres = List.of(
                OreConfiguration.target(stoneReplaceables, BlockRegistration.TIN_ORE_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get().defaultBlockState())
        );
        register(context, OVERWORLD_TIN_ORE_CONFIGURED_KEY, Feature.ORE, new OreConfiguration(overworldTinOres, 9));





        register(context, BRANCH_FOREST_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(3, 4, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.OAK_BRANCH_BLOCK.get())))));
        register(context, BRANCH_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(2, 3, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.OAK_BRANCH_BLOCK.get())))));






        register(context, ROCK_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(2, 3, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.ROCK_BLOCK.get())))));
        register(context, LARGE_ROCK_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(1, 0, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.LARGE_ROCK_BLOCK.get())))));
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
