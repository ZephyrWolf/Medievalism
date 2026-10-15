package io.github.zephyrwolf.medievalism.common.world.level.levelgen;

import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.CellSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.CelledPlacedFeature;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayerSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayeredPlacedFeature;
import io.github.zephyrwolf.medievalism.registration.world.level.FeatureRegistration;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

import java.util.Arrays;

public final class FeatureTools
{
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, resource);
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key,
                                             Holder<PlacedFeature> defaultFeature, WeightedPlacedFeature ... features)
    {
        FeatureUtils.register(context, key, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        Arrays.stream(features).toList(), defaultFeature
                ));
    }

    // --

    public static Holder<PlacedFeature> inlineLayeredPlacement(ResourceKey<WorldLayerMap> layerMap, LayeredPlacedFeature ... features)
    {
        return PlacementUtils.inlinePlaced(
                FeatureRegistration.LAYER_SELECTOR_FEATURE.get(),
                LayerSelectorFeatureConfiguration.create(layerMap, Arrays.stream(features).toList())
        );
    }

    // inline SimplePlacement
    public static Holder<PlacedFeature> inlineSteppedPlacement(Block block, Direction direction, BlockPredicate predicate, int maxSteps, int offset)
    { return inlineSteppedPlacement(BlockStateProvider.simple(block), direction, predicate, maxSteps, offset); }
    public static Holder<PlacedFeature> inlineSteppedPlacement(BlockStateProvider state, Direction direction, BlockPredicate predicate, int maxSteps, int offset)
    {
        return PlacementUtils.inlinePlaced(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(state),
                EnvironmentScanPlacement.scanningFor(direction, BlockPredicate.solid(), predicate, maxSteps), // TODO Have waterlogged rocks BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE
                RandomOffsetPlacement.vertical(ConstantInt.of(offset)));
    }

    public static Holder<PlacedFeature> inlineSimpleBlockOnlyInAir(Block block)
    { return inlineSimpleState(BlockStateProvider.simple(block), BlockPredicate.ONLY_IN_AIR_PREDICATE); }
    public static Holder<PlacedFeature> inlineSimpleBlockOnlyInAir(BlockState state)
    { return inlineSimpleState(BlockStateProvider.simple(state), BlockPredicate.ONLY_IN_AIR_PREDICATE); }
    public static Holder<PlacedFeature> inlineSimpleState(BlockStateProvider state, BlockPredicate predicate)
    { return PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(state), predicate); }

    // Random Feature
    public static Holder<PlacedFeature> inlineRandomFeature(Holder<PlacedFeature> defaultFeature, WeightedPlacedFeature... features)
    {
        return PlacementUtils.inlinePlaced(
                Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        Arrays.stream(features).toList(), defaultFeature
                )
        );
    }
    public static void registerRandomFeature(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                             Holder<PlacedFeature> defaultFeature, WeightedPlacedFeature ... features)
    {
        FeatureUtils.register(context, featureKey, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        Arrays.stream(features).toList(), defaultFeature
                ));
    }
    @SafeVarargs
    public static void registerSimpleRandomFeature(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                                   Holder<PlacedFeature> ... features)
    {
        FeatureUtils.register(context, featureKey, Feature.SIMPLE_RANDOM_SELECTOR, // TODO Only way I can have inlinePlaced because I duh know how to otherwise
                new SimpleRandomFeatureConfiguration(
                        HolderSet.direct(features)
                ));
    }

    public static Holder<PlacedFeature> inlineLayerSelect(ResourceKey<WorldLayerMap> layerMap, LayeredPlacedFeature ... features)
    {
        return PlacementUtils.inlinePlaced(
                FeatureRegistration.LAYER_SELECTOR_FEATURE.get(),
                LayerSelectorFeatureConfiguration.layers(layerMap, features)
        );
    }

    public static Holder<PlacedFeature> inlineCellSelect(ResourceKey<WorldCellRegionMap> cellRegionMap, CelledPlacedFeature ... features)
    {
        return PlacementUtils.inlinePlaced(
                FeatureRegistration.CELL_SELECTOR_FEATURE.get(),
                CellSelectorFeatureConfiguration.cells(cellRegionMap, features)
        );
    }
    // Random Patch
    public static Holder<PlacedFeature> inlineRandomPatch(int tries, int xzSpread, int ySpread, Holder<PlacedFeature> feature)
    {
        return PlacementUtils.inlinePlaced(
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(tries, xzSpread, ySpread, feature)
        );
    }
    public static void registerRandomPatch(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                           int tries, int xzSpread, int ySpread, Holder<PlacedFeature> feature)
    {
        FeatureUtils.register(context, featureKey, Feature.RANDOM_PATCH, new RandomPatchConfiguration(tries, xzSpread, ySpread, feature));
    }
    @Deprecated
    public static void registerSimpleRandomPatch(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                         int tries, int xzSpread, int ySpread, Block block)
    {
        registerSimpleRandomPatch(context, featureKey, tries, xzSpread, ySpread, BlockStateProvider.simple(block));
    }
    @Deprecated
    public static void registerSimpleRandomPatch(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                         int tries, int xzSpread, int ySpread, BlockStateProvider blockStateProvider)
    {
        context.register(featureKey, new ConfiguredFeature<>(
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        tries, xzSpread, ySpread,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(blockStateProvider)
                        )
                )));
    }
}
