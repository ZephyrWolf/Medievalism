package io.github.zephyrwolf.medievalism.common.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registry.BlockRegistration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
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

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context)
    {
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
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.BRANCH_BLOCK.get())))));
        register(context, BRANCH_CONFIGURED_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(2, 3, 0,
                        PlacementUtils.onlyWhenEmpty( Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration( BlockStateProvider.simple(BlockRegistration.BRANCH_BLOCK.get())))));

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
