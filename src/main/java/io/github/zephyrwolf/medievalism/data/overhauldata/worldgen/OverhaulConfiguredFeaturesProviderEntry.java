package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.FeatureTools;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayerSelectorFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.LayeredPlacedFeature;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BaseConfiguredFeaturesProviderEntry;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.registration.world.level.FeatureRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class OverhaulConfiguredFeaturesProviderEntry
{
    // ==DEBUG==
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEBUG_SIMPLE =                         FeatureTools.registerKey(MedievalismConstants.resource("debug_simple"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEBUG_FIND_LOWER =                     FeatureTools.registerKey(MedievalismConstants.resource("debug_find_lower"));

    // ==Vanilla==
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CLAY =                             FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_clay"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIRT =                             FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_dirt"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GRAVEL =                           FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gravel"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ANDESITE =                         FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_andesite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIORITE =                          FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diorite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GRANITE =                          FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_granite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TUFF =                             FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_tuff"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_INFESTED =                         FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_infested"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COPPER_LARGE =                     FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_copper_large"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COPPER_SMALL =                     FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_copper_small"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON =                             FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_iron"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON_SMALL =                       FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_iron_small"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD =                             FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gold"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD_BURIED =                      FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_gold_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COAL =                             FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_coal"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COAL_BURIED =                      FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_coal_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_BURIED =                   FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_LARGE =                    FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_large"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_MEDIUM =                   FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_medium"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_SMALL =                    FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_small"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EMERALD =                          FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_emerald"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LAPIS =                            FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_lapis"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LAPIS_BURIED =                     FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_lapis_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_REDSTONE =                         FeatureTools.registerKey(ResourceLocation.withDefaultNamespace("ore_redstone"));

    // ==Medievalism==
    // ROCKS
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SANDSTONE_ROCKS =              BaseConfiguredFeaturesProviderEntry.SURFACE_SANDSTONE_ROCKS;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_RED_SANDSTONE_ROCKS =          BaseConfiguredFeaturesProviderEntry.SURFACE_RED_SANDSTONE_ROCKS;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SAPROLITE_ROCKS =              FeatureTools.registerKey(MedievalismConstants.resource("surface_saprolite_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_LATERITE_ROCKS =               FeatureTools.registerKey(MedievalismConstants.resource("surface_laterite_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SILT_CLUMPS =                  FeatureTools.registerKey(MedievalismConstants.resource("surface_silt_clumps"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_GREYWACKE_ROCKS =              BaseConfiguredFeaturesProviderEntry.SURFACE_GREYWACKE_ROCKS;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SILTSTONE_ROCKS =              FeatureTools.registerKey(MedievalismConstants.resource("surface_siltstone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_DOLOSTONE_ROCKS =              FeatureTools.registerKey(MedievalismConstants.resource("surface_dolostone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_LIMESTONE_ROCKS =              FeatureTools.registerKey(MedievalismConstants.resource("surface_limestone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_IRONSTONE_ROCKS =              FeatureTools.registerKey(MedievalismConstants.resource("surface_ironstone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SHALE_ROCKS =                  FeatureTools.registerKey(MedievalismConstants.resource("surface_shale_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_ARKOSE_ROCKS =                 FeatureTools.registerKey(MedievalismConstants.resource("surface_arkose_rocks"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_GREYWACKE_ROCKS =                 BaseConfiguredFeaturesProviderEntry.CAVE_GREYWACKE_ROCKS;
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_SILTSTONE_ROCKS =                 FeatureTools.registerKey(MedievalismConstants.resource("cave_siltstone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_DOLOSTONE_ROCKS =                 FeatureTools.registerKey(MedievalismConstants.resource("cave_dolostone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_LIMESTONE_ROCKS =                 FeatureTools.registerKey(MedievalismConstants.resource("cave_limestone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_IRONSTONE_ROCKS =                 FeatureTools.registerKey(MedievalismConstants.resource("cave_ironstone_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_SHALE_ROCKS =                     FeatureTools.registerKey(MedievalismConstants.resource("cave_shale_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_ARKOSE_ROCKS =                    FeatureTools.registerKey(MedievalismConstants.resource("cave_arkose_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_MARBLE_ROCKS =                    FeatureTools.registerKey(MedievalismConstants.resource("cave_marble_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_QUARTZITE_ROCKS =                 FeatureTools.registerKey(MedievalismConstants.resource("cave_quartzite_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_HORNFELS_ROCKS =                  FeatureTools.registerKey(MedievalismConstants.resource("cave_hornfels_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_SLATE_ROCKS =                     FeatureTools.registerKey(MedievalismConstants.resource("cave_slate_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_GABBRO_ROCKS =                    BaseConfiguredFeaturesProviderEntry.CAVE_GABBRO_ROCKS;
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_SMOOTH_DIORITE_ROCKS =            FeatureTools.registerKey(MedievalismConstants.resource("cave_smooth_diorite_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_SMOOTH_GRANITE_ROCKS =            FeatureTools.registerKey(MedievalismConstants.resource("cave_smooth_granite_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_NORITE_ROCKS =                    FeatureTools.registerKey(MedievalismConstants.resource("cave_norite_rocks"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_PERIDOTITE_ROCKS =                FeatureTools.registerKey(MedievalismConstants.resource("cave_peridotite_rocks"));

    // --

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        FeatureTools.register(context, DEBUG_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.DIAMOND_BLOCK)));
        //FeatureTools.registerSimpleRandomFeature(context, DEBUG_FIND_LOWER, FeatureTools.inlineSteppedPlacement(Blocks.DIAMOND_BLOCK, Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1));

        FeatureTools.register(context, DEBUG_FIND_LOWER, FeatureRegistration.LAYER_SELECTOR_FEATURE.get(), LayerSelectorFeatureConfiguration.layers(
                LayeredPlacedFeature.layer(
                        WorldGenLayerCatalog.WorldLayer.DEEP_IGNEOUS_INTRUSIVE,
                        FeatureTools.inlineSteppedPlacement(Blocks.DIAMOND_BLOCK, Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1)),
                LayeredPlacedFeature.layer(
                        WorldGenLayerCatalog.WorldLayer.IGNEOUS_INTRUSIVE,
                        FeatureTools.inlineSteppedPlacement(Blocks.GOLD_BLOCK, Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1))
                ));

        bootstrap_vanilla(context);
        bootstrap_medievalism(context);
    }

    public static void bootstrap_vanilla(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest sedimentaryOreReplaceables =       new TagMatchTest(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES);
        RuleTest saproliteOreReplaceables =         new TagMatchTest(BlockTagCatalog.SAPROLITE_ORE_REPLACEABLES);
        RuleTest lateriteOreReplaceables =          new TagMatchTest(BlockTagCatalog.LATERITE_ORE_REPLACEABLES);
        RuleTest greywackeOreReplaceables =         new TagMatchTest(BlockTagCatalog.GREYWACKE_ORE_REPLACEABLES);
        RuleTest siltstoneOreReplaceables =         new TagMatchTest(BlockTagCatalog.SILTSTONE_ORE_REPLACEABLES);
        RuleTest dolostoneOreReplaceables =         new TagMatchTest(BlockTagCatalog.DOLOSTONE_ORE_REPLACEABLES);
        RuleTest limestoneOreReplaceables =         new TagMatchTest(BlockTagCatalog.LIMESTONE_ORE_REPLACEABLES);
        RuleTest chalkOreReplaceables =             new TagMatchTest(BlockTagCatalog.CHALK_ORE_REPLACEABLES);
        RuleTest ironstoneOreReplaceables =         new TagMatchTest(BlockTagCatalog.IRONSTONE_ORE_REPLACEABLES);
        RuleTest shaleOreReplaceables =             new TagMatchTest(BlockTagCatalog.SHALE_ORE_REPLACEABLES);
        RuleTest arkoseOreReplaceables =            new TagMatchTest(BlockTagCatalog.ARKOSE_ORE_REPLACEABLES);
        RuleTest marbleOreReplaceables =            new TagMatchTest(BlockTagCatalog.MARBLE_ORE_REPLACEABLES);
        RuleTest quartziteOreReplaceables =         new TagMatchTest(BlockTagCatalog.QUARTZITE_ORE_REPLACEABLES);
        RuleTest hornfelsOreReplaceables =          new TagMatchTest(BlockTagCatalog.HORNFELS_ORE_REPLACEABLES);
        RuleTest slateOreReplaceables =             new TagMatchTest(BlockTagCatalog.SLATE_ORE_REPLACEABLES);
        RuleTest gabbroOreReplaceables =            new TagMatchTest(BlockTagCatalog.GABBRO_ORE_REPLACEABLES);
        RuleTest smoothDioriteOreReplaceables =     new TagMatchTest(BlockTagCatalog.SMOOTH_DIORITE_ORE_REPLACEABLES);
        RuleTest smoothGraniteOreReplaceables =     new TagMatchTest(BlockTagCatalog.SMOOTH_GRANITE_ORE_REPLACEABLES);
        RuleTest noriteOreReplaceables =            new TagMatchTest(BlockTagCatalog.NORITE_ORE_REPLACEABLES);
        RuleTest peridotiteOreReplaceables =        new TagMatchTest(BlockTagCatalog.PERIDOTITE_ORE_REPLACEABLES);
        RuleTest rhyoliteOreReplaceables =          new TagMatchTest(BlockTagCatalog.RHYOLITE_ORE_REPLACEABLES);
        RuleTest daciteOreReplaceables =            new TagMatchTest(BlockTagCatalog.DACITE_ORE_REPLACEABLES);
        RuleTest andesiteOreReplaceables =          new TagMatchTest(BlockTagCatalog.ANDESITE_ORE_REPLACEABLES);
        RuleTest basaltOreReplaceables =            new TagMatchTest(BlockTagCatalog.BASALT_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> clayOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.CLAY.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> dirtOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.DIRT.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> gravelOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.GRAVEL.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> andesiteOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.ANDESITE.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> dioriteOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.DIORITE.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> graniteOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.GRANITE.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> tuffOres = List.of( OreConfiguration.target(sedimentaryOreReplaceables, Blocks.TUFF.defaultBlockState()) );
        List<OreConfiguration.TargetBlockState> infestedOres = List.of(
                OreConfiguration.target( greywackeOreReplaceables,      BlockRegistration.INFESTED_GREYWACKE.get().defaultBlockState()),
                OreConfiguration.target( siltstoneOreReplaceables,      BlockRegistration.INFESTED_SILTSTONE.get().defaultBlockState()),
                OreConfiguration.target( dolostoneOreReplaceables,      BlockRegistration.INFESTED_DOLOSTONE.get().defaultBlockState()),
                OreConfiguration.target( limestoneOreReplaceables,      BlockRegistration.INFESTED_LIMESTONE.get().defaultBlockState()),
                OreConfiguration.target( ironstoneOreReplaceables,      BlockRegistration.INFESTED_SHALE.get().defaultBlockState()),
                OreConfiguration.target( shaleOreReplaceables,          BlockRegistration.INFESTED_ARKOSE.get().defaultBlockState()),
                OreConfiguration.target( arkoseOreReplaceables,         BlockRegistration.INFESTED_MARBLE.get().defaultBlockState()),
                OreConfiguration.target( marbleOreReplaceables,         BlockRegistration.INFESTED_QUARTZITE.get().defaultBlockState()),
                OreConfiguration.target( quartziteOreReplaceables,      BlockRegistration.INFESTED_HORNFELS.get().defaultBlockState()),
                OreConfiguration.target( hornfelsOreReplaceables,       BlockRegistration.INFESTED_SLATE.get().defaultBlockState()),
                OreConfiguration.target( slateOreReplaceables,          BlockRegistration.INFESTED_GABBRO.get().defaultBlockState()
                        .setValue(BlockStateProperties.AXIS, Direction.Axis.Y)),
                OreConfiguration.target( gabbroOreReplaceables,         BlockRegistration.INFESTED_SMOOTH_DIORITE.get().defaultBlockState()),
                OreConfiguration.target( smoothDioriteOreReplaceables,  BlockRegistration.INFESTED_SMOOTH_GRANITE.get().defaultBlockState()),
                OreConfiguration.target( smoothGraniteOreReplaceables,  BlockRegistration.INFESTED_NORITE.get().defaultBlockState()),
                OreConfiguration.target( noriteOreReplaceables,         BlockRegistration.INFESTED_PERIDOTITE.get().defaultBlockState()),
                OreConfiguration.target( peridotiteOreReplaceables,     BlockRegistration.INFESTED_RHYOLITE.get().defaultBlockState()),
                OreConfiguration.target( rhyoliteOreReplaceables,       BlockRegistration.INFESTED_DACITE.get().defaultBlockState()),
                OreConfiguration.target( daciteOreReplaceables,         BlockRegistration.INFESTED_ANDESITE.get().defaultBlockState()),
                OreConfiguration.target( andesiteOreReplaceables,       BlockRegistration.INFESTED_BASALT.get().defaultBlockState())
        );
        // TODO Create vanilla ores
        List<OreConfiguration.TargetBlockState> copperOres = List.of(
                //Meta->Regolith
                OreConfiguration.target(saproliteOreReplaceables, BlockRegistration.SAPROLITE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(greywackeOreReplaceables, BlockRegistration.GREYWACKE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(siltstoneOreReplaceables, BlockRegistration.SILTSTONE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(dolostoneOreReplaceables, BlockRegistration.DOLOSTONE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(limestoneOreReplaceables, BlockRegistration.LIMESTONE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(chalkOreReplaceables, BlockRegistration.CHALK_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(ironstoneOreReplaceables, BlockRegistration.IRONSTONE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(shaleOreReplaceables, BlockRegistration.SHALE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(arkoseOreReplaceables, BlockRegistration.ARKOSE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(marbleOreReplaceables, BlockRegistration.MARBLE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(quartziteOreReplaceables, BlockRegistration.QUARTZITE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(hornfelsOreReplaceables, BlockRegistration.HORNFELS_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(slateOreReplaceables, BlockRegistration.SLATE_COPPER_ORE.get().defaultBlockState())
                //OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> ironOres = List.of(
                //OreConfiguration.target(stoneOreReplaceables, Blocks.IRON_ORE.defaultBlockState()),
                // Igneous
                OreConfiguration.target(gabbroOreReplaceables, BlockRegistration.GABBRO_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothDioriteOreReplaceables, BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothGraniteOreReplaceables, BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(noriteOreReplaceables, BlockRegistration.NORITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(peridotiteOreReplaceables, BlockRegistration.PERIDOTITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(rhyoliteOreReplaceables, BlockRegistration.RHYOLITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(daciteOreReplaceables, BlockRegistration.DACITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(andesiteOreReplaceables, BlockRegistration.ANDESITE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(basaltOreReplaceables, BlockRegistration.BASALT_IRON_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> goldOres = List.of(
                // Igneous -> Sedimentary
                OreConfiguration.target(greywackeOreReplaceables, BlockRegistration.GREYWACKE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(siltstoneOreReplaceables, BlockRegistration.SILTSTONE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(dolostoneOreReplaceables, BlockRegistration.DOLOSTONE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(limestoneOreReplaceables, BlockRegistration.LIMESTONE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(chalkOreReplaceables, BlockRegistration.CHALK_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(ironstoneOreReplaceables, BlockRegistration.IRONSTONE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(shaleOreReplaceables, BlockRegistration.SHALE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(arkoseOreReplaceables, BlockRegistration.ARKOSE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(marbleOreReplaceables, BlockRegistration.MARBLE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(quartziteOreReplaceables, BlockRegistration.QUARTZITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(hornfelsOreReplaceables, BlockRegistration.HORNFELS_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(slateOreReplaceables, BlockRegistration.SLATE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(gabbroOreReplaceables, BlockRegistration.GABBRO_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothDioriteOreReplaceables, BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothGraniteOreReplaceables, BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(noriteOreReplaceables, BlockRegistration.NORITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(peridotiteOreReplaceables, BlockRegistration.PERIDOTITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(rhyoliteOreReplaceables, BlockRegistration.RHYOLITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(daciteOreReplaceables, BlockRegistration.DACITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(andesiteOreReplaceables, BlockRegistration.ANDESITE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(basaltOreReplaceables, BlockRegistration.BASALT_GOLD_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> coalOres = List.of(
                //OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_COAL_ORE.defaultBlockState()),
                // Metamorphic -> Regolith
                OreConfiguration.target(saproliteOreReplaceables, BlockRegistration.SAPROLITE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(lateriteOreReplaceables, BlockRegistration.LATERITE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(greywackeOreReplaceables, BlockRegistration.GREYWACKE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(siltstoneOreReplaceables, BlockRegistration.SILTSTONE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(dolostoneOreReplaceables, BlockRegistration.DOLOSTONE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(limestoneOreReplaceables, BlockRegistration.LIMESTONE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(chalkOreReplaceables, BlockRegistration.CHALK_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(ironstoneOreReplaceables, BlockRegistration.IRONSTONE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(shaleOreReplaceables, BlockRegistration.SHALE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(arkoseOreReplaceables, BlockRegistration.ARKOSE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(marbleOreReplaceables, BlockRegistration.MARBLE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(quartziteOreReplaceables, BlockRegistration.QUARTZITE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(hornfelsOreReplaceables, BlockRegistration.HORNFELS_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(slateOreReplaceables, BlockRegistration.SLATE_COAL_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> diamondOres = List.of(
                //OreConfiguration.target(stoneOreReplaceables, Blocks.DIAMOND_ORE.defaultBlockState()),
                // Igneous Intrusive -> Hard Igneous Extrusive
                OreConfiguration.target(gabbroOreReplaceables, BlockRegistration.GABBRO_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothDioriteOreReplaceables, BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothGraniteOreReplaceables, BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(noriteOreReplaceables, BlockRegistration.NORITE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(peridotiteOreReplaceables, BlockRegistration.PERIDOTITE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(andesiteOreReplaceables, BlockRegistration.ANDESITE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(basaltOreReplaceables, BlockRegistration.BASALT_DIAMOND_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> emeraldOres = List.of(
                //OreConfiguration.target(stoneOreReplaceables, Blocks.EMERALD_ORE.defaultBlockState()),
                // Igneous Intrusive -> Igneous Extrusive
                OreConfiguration.target(gabbroOreReplaceables, BlockRegistration.GABBRO_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothDioriteOreReplaceables, BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothGraniteOreReplaceables, BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(noriteOreReplaceables, BlockRegistration.NORITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(peridotiteOreReplaceables, BlockRegistration.PERIDOTITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(rhyoliteOreReplaceables, BlockRegistration.RHYOLITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(daciteOreReplaceables, BlockRegistration.DACITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(andesiteOreReplaceables, BlockRegistration.ANDESITE_EMERALD_ORE.get().defaultBlockState()),
                OreConfiguration.target(basaltOreReplaceables, BlockRegistration.BASALT_EMERALD_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> lapisOres = List.of(
                //OreConfiguration.target(stoneOreReplaceables, Blocks.LAPIS_ORE.defaultBlockState()),
                //OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState()),
                // Metamorphic
                OreConfiguration.target(marbleOreReplaceables, BlockRegistration.MARBLE_LAPIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(quartziteOreReplaceables, BlockRegistration.QUARTZITE_LAPIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(hornfelsOreReplaceables, BlockRegistration.HORNFELS_LAPIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(slateOreReplaceables, BlockRegistration.SLATE_LAPIS_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> redstoneOres = List.of(
                //OreConfiguration.target(stoneOreReplaceables, Blocks.REDSTONE_ORE.defaultBlockState()),
                // Igneous Intrusive
                OreConfiguration.target(gabbroOreReplaceables, BlockRegistration.GABBRO_REDSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothDioriteOreReplaceables, BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(smoothGraniteOreReplaceables, BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(noriteOreReplaceables, BlockRegistration.NORITE_REDSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(peridotiteOreReplaceables, BlockRegistration.PERIDOTITE_REDSTONE_ORE.get().defaultBlockState())
        );

        FeatureTools.register(context, ORE_CLAY, Feature.ORE, new OreConfiguration(clayOres, 33));
        FeatureTools.register(context, ORE_DIRT, Feature.ORE, new OreConfiguration(dirtOres, 33));
        FeatureTools.register(context, ORE_GRAVEL, Feature.ORE, new OreConfiguration(gravelOres, 33));
        FeatureTools.register(context, ORE_ANDESITE, Feature.ORE, new OreConfiguration(andesiteOres, 64));
        FeatureTools.register(context, ORE_DIORITE, Feature.ORE, new OreConfiguration(dioriteOres, 64));
        FeatureTools.register(context, ORE_GRANITE, Feature.ORE, new OreConfiguration(graniteOres, 64));
        FeatureTools.register(context, ORE_TUFF, Feature.ORE, new OreConfiguration(tuffOres, 64));
        FeatureTools.register(context, ORE_INFESTED, Feature.ORE, new OreConfiguration(infestedOres, 9));
        FeatureTools.register(context, ORE_COPPER_LARGE, Feature.ORE, new OreConfiguration(copperOres, 20));
        FeatureTools.register(context, ORE_COPPER_SMALL, Feature.ORE, new OreConfiguration(copperOres, 10));
        FeatureTools.register(context, ORE_IRON, Feature.ORE, new OreConfiguration(ironOres, 9));
        FeatureTools.register(context, ORE_IRON_SMALL, Feature.ORE, new OreConfiguration(ironOres, 4));
        FeatureTools.register(context, ORE_GOLD, Feature.ORE, new OreConfiguration(goldOres, 9));
        FeatureTools.register(context, ORE_GOLD_BURIED, Feature.ORE, new OreConfiguration(goldOres, 9, 0.5f));
        FeatureTools.register(context, ORE_COAL, Feature.ORE, new OreConfiguration(coalOres, 17));
        FeatureTools.register(context, ORE_COAL_BURIED, Feature.ORE, new OreConfiguration(coalOres, 17, 0.5f));
        FeatureTools.register(context, ORE_DIAMOND_BURIED, Feature.ORE, new OreConfiguration(diamondOres, 8, 1.0f));
        FeatureTools.register(context, ORE_DIAMOND_LARGE, Feature.ORE, new OreConfiguration(diamondOres, 12, 0.7f));
        FeatureTools.register(context, ORE_DIAMOND_MEDIUM, Feature.ORE, new OreConfiguration(diamondOres, 8, 0.5f));
        FeatureTools.register(context, ORE_DIAMOND_SMALL, Feature.ORE, new OreConfiguration(diamondOres, 4, 0.5f));
        FeatureTools.register(context, ORE_EMERALD, Feature.ORE, new OreConfiguration(emeraldOres, 3));
        FeatureTools.register(context, ORE_LAPIS, Feature.ORE, new OreConfiguration(lapisOres, 14)); // 7
        FeatureTools.register(context, ORE_LAPIS_BURIED, Feature.ORE, new OreConfiguration(lapisOres, 7, 1.0f));
        FeatureTools.register(context, ORE_REDSTONE, Feature.ORE, new OreConfiguration(redstoneOres, 8));
    }

    public static void bootstrap_medievalism(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        final int Y_SPREAD = 0;

        final int SURFACE_SANDSTONE_TRIES = 2;
        final int SURFACE_REGOLITH_TRIES = 3;
        final int SURFACE_SEDIMENTARY_TRIES = 2;
        final int CAVE_TRIES = 3;

        final int SURFACE_SANDSTONE_XZ_SPREAD = 3;
        final int SURFACE_REGOLITH_XZ_SPREAD = 3;
        final int SURFACE_SEDIMENTARY_XZ_SPREAD = 3;
        final int CAVE_XZ_SPREAD = 3;

        final float LARGE_ROCK_CHANCE = 0.3f;
        final float ORE_ROCK_CHANCE = 0.25f;

        // ROCKS
        FeatureTools.registerRandomPatch(context, SURFACE_SANDSTONE_ROCKS, SURFACE_SANDSTONE_TRIES, SURFACE_SANDSTONE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SANDSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_SANDSTONE_ROCK.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_RED_SANDSTONE_ROCKS, SURFACE_SANDSTONE_TRIES, SURFACE_SANDSTONE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.RED_SANDSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_SAPROLITE_ROCKS, SURFACE_REGOLITH_TRIES, SURFACE_REGOLITH_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SAPROLITE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_SAPROLITE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_LATERITE_ROCKS, SURFACE_REGOLITH_TRIES, SURFACE_REGOLITH_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LATERITE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_LATERITE_ROCK.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_SILT_CLUMPS, SURFACE_REGOLITH_TRIES, SURFACE_REGOLITH_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SILT_CLUMP.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_SILT_CLUMP.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_GREYWACKE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.GREYWACKE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_GREYWACKE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_SILTSTONE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SILTSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_SILTSTONE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_DOLOSTONE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.DOLOSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_DOLOSTONE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_LIMESTONE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LIMESTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_LIMESTONE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_IRONSTONE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.IRONSTONE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_IRONSTONE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_SHALE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SHALE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_SHALE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.SHALE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, SURFACE_ARKOSE_ROCKS, SURFACE_SEDIMENTARY_TRIES, SURFACE_SEDIMENTARY_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.ARKOSE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_ARKOSE_ROCK.get()), LARGE_ROCK_CHANCE),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get()), ORE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_GREYWACKE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.GREYWACKE_ROCK.get()),
                new WeightedPlacedFeature(FeatureTools.inlineSimpleBlockOnlyInAir(BlockRegistration.LARGE_GREYWACKE_ROCK.get()), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_SILTSTONE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.SILTSTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_SILTSTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_DOLOSTONE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.DOLOSTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_DOLOSTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_LIMESTONE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.LIMESTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_LIMESTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_IRONSTONE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.IRONSTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_IRONSTONE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_SHALE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.SHALE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_SHALE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_ARKOSE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.ARKOSE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_ARKOSE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_MARBLE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.MARBLE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_MARBLE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_QUARTZITE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.QUARTZITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_QUARTZITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_HORNFELS_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.HORNFELS_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_HORNFELS_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_SLATE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.SLATE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_SLATE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_GABBRO_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.GABBRO_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.GABBRO_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_SMOOTH_DIORITE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_SMOOTH_GRANITE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_NORITE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.NORITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.LARGE_NORITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
        FeatureTools.registerRandomPatch(context, CAVE_PERIDOTITE_ROCKS, CAVE_TRIES, CAVE_XZ_SPREAD, Y_SPREAD, FeatureTools.inlineRandomFeature(
                FeatureTools.inlineSteppedPlacement(BlockRegistration.PERIDOTITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1),
                new WeightedPlacedFeature(FeatureTools.inlineSteppedPlacement(BlockRegistration.PERIDOTITE_ROCK.get(), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, 10, 1), LARGE_ROCK_CHANCE)
        ));
    }
}
