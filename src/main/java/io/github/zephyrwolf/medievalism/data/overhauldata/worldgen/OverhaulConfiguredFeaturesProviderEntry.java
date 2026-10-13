package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.data.base.worldgen.BaseConfiguredFeaturesProviderEntry;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class OverhaulConfiguredFeaturesProviderEntry
{
    // ==Vanilla==
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CLAY =             registerKey(ResourceLocation.withDefaultNamespace("ore_clay"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIRT =             registerKey(ResourceLocation.withDefaultNamespace("ore_dirt"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GRAVEL =           registerKey(ResourceLocation.withDefaultNamespace("ore_gravel"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ANDESITE =         registerKey(ResourceLocation.withDefaultNamespace("ore_andesite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIORITE =          registerKey(ResourceLocation.withDefaultNamespace("ore_diorite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GRANITE =          registerKey(ResourceLocation.withDefaultNamespace("ore_granite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TUFF =             registerKey(ResourceLocation.withDefaultNamespace("ore_tuff"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_INFESTED =         registerKey(ResourceLocation.withDefaultNamespace("ore_infested"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COPPER_LARGE =     registerKey(ResourceLocation.withDefaultNamespace("ore_copper_large"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COPPER_SMALL =     registerKey(ResourceLocation.withDefaultNamespace("ore_copper_small"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON =             registerKey(ResourceLocation.withDefaultNamespace("ore_iron"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON_SMALL =       registerKey(ResourceLocation.withDefaultNamespace("ore_iron_small"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD =             registerKey(ResourceLocation.withDefaultNamespace("ore_gold"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD_BURIED =      registerKey(ResourceLocation.withDefaultNamespace("ore_gold_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COAL =             registerKey(ResourceLocation.withDefaultNamespace("ore_coal"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COAL_BURIED =      registerKey(ResourceLocation.withDefaultNamespace("ore_coal_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_BURIED =   registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_LARGE =    registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_large"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_MEDIUM =   registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_medium"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_SMALL =    registerKey(ResourceLocation.withDefaultNamespace("ore_diamond_small"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EMERALD =          registerKey(ResourceLocation.withDefaultNamespace("ore_emerald"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LAPIS =            registerKey(ResourceLocation.withDefaultNamespace("ore_lapis"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LAPIS_BURIED =     registerKey(ResourceLocation.withDefaultNamespace("ore_lapis_buried"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_REDSTONE =         registerKey(ResourceLocation.withDefaultNamespace("ore_redstone"));

    // ==Medievalism==
    // ROCK
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_ROCK =             BaseConfiguredFeaturesProviderEntry.SANDSTONE_ROCK;
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SANDSTONE_ROCK =         BaseConfiguredFeaturesProviderEntry.RED_SANDSTONE_ROCK;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPROLITE_ROCK =             registerKey(MedievalismConstants.resource("saprolite_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LATERITE_ROCK =              registerKey(MedievalismConstants.resource("laterite_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREYWACKE_ROCK =             BaseConfiguredFeaturesProviderEntry.GREYWACKE_ROCK;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILTSTONE_ROCK =             registerKey(MedievalismConstants.resource("siltstone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DOLOSTONE_ROCK =             registerKey(MedievalismConstants.resource("dolostone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_ROCK =             registerKey(MedievalismConstants.resource("limestone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONSTONE_ROCK =             registerKey(MedievalismConstants.resource("ironstone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHALE_ROCK =                 registerKey(MedievalismConstants.resource("shale_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARKOSE_ROCK =                registerKey(MedievalismConstants.resource("arkose_rock"));
    // LARGE ROCK
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_SANDSTONE_ROCK =       BaseConfiguredFeaturesProviderEntry.LARGE_SANDSTONE_ROCK;
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_RED_SANDSTONE_ROCK =   BaseConfiguredFeaturesProviderEntry.LARGE_RED_SANDSTONE_ROCK;
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_SAPROLITE_ROCK =       registerKey(MedievalismConstants.resource("large_saprolite_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_LATERITE_ROCK =        registerKey(MedievalismConstants.resource("large_laterite_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GREYWACKE_ROCK =       BaseConfiguredFeaturesProviderEntry.LARGE_GREYWACKE_ROCK;
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_SILTSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_siltstone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_DOLOSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_dolostone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_LIMESTONE_ROCK =       registerKey(MedievalismConstants.resource("large_limestone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_IRONSTONE_ROCK =       registerKey(MedievalismConstants.resource("large_ironstone_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_SHALE_ROCK =           registerKey(MedievalismConstants.resource("large_shale_rock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ARKOSE_ROCK =          registerKey(MedievalismConstants.resource("large_arkose_rock"));
    // COPPER ROCK
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREYWACKE_ROCK_COPPER_ORE =  BaseConfiguredFeaturesProviderEntry.GREYWACKE_ROCK_COPPER_ORE;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILTSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("siltstone_rock_copper_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DOLOSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("dolostone_rock_copper_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("limestone_rock_copper_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONSTONE_ROCK_COPPER_ORE =  registerKey(MedievalismConstants.resource("ironstone_rock_copper_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHALE_ROCK_COPPER_ORE =      registerKey(MedievalismConstants.resource("shale_rock_copper_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARKOSE_ROCK_COPPER_ORE =     registerKey(MedievalismConstants.resource("arkose_rock_copper_ore"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
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
                OreConfiguration.target(lateriteOreReplaceables, BlockRegistration.LATERITE_COPPER_ORE.get().defaultBlockState()),
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

        register(context, ORE_CLAY, Feature.ORE, new OreConfiguration(clayOres, 33));
        register(context, ORE_DIRT, Feature.ORE, new OreConfiguration(dirtOres, 33));
        register(context, ORE_GRAVEL, Feature.ORE, new OreConfiguration(gravelOres, 33));
        register(context, ORE_ANDESITE, Feature.ORE, new OreConfiguration(andesiteOres, 64));
        register(context, ORE_DIORITE, Feature.ORE, new OreConfiguration(dioriteOres, 64));
        register(context, ORE_GRANITE, Feature.ORE, new OreConfiguration(graniteOres, 64));
        register(context, ORE_TUFF, Feature.ORE, new OreConfiguration(tuffOres, 64));
        register(context, ORE_INFESTED, Feature.ORE, new OreConfiguration(infestedOres, 9));
        register(context, ORE_COPPER_LARGE, Feature.ORE, new OreConfiguration(copperOres, 20));
        register(context, ORE_COPPER_SMALL, Feature.ORE, new OreConfiguration(copperOres, 10));
        register(context, ORE_IRON, Feature.ORE, new OreConfiguration(ironOres, 9));
        register(context, ORE_IRON_SMALL, Feature.ORE, new OreConfiguration(ironOres, 4));
        register(context, ORE_GOLD, Feature.ORE, new OreConfiguration(goldOres, 9));
        register(context, ORE_GOLD_BURIED, Feature.ORE, new OreConfiguration(goldOres, 9, 0.5f));
        register(context, ORE_COAL, Feature.ORE, new OreConfiguration(coalOres, 17));
        register(context, ORE_COAL_BURIED, Feature.ORE, new OreConfiguration(coalOres, 17, 0.5f));
        register(context, ORE_DIAMOND_BURIED, Feature.ORE, new OreConfiguration(diamondOres, 8, 1.0f));
        register(context, ORE_DIAMOND_LARGE, Feature.ORE, new OreConfiguration(diamondOres, 12, 0.7f));
        register(context, ORE_DIAMOND_MEDIUM, Feature.ORE, new OreConfiguration(diamondOres, 8, 0.5f));
        register(context, ORE_DIAMOND_SMALL, Feature.ORE, new OreConfiguration(diamondOres, 4, 0.5f));
        register(context, ORE_EMERALD, Feature.ORE, new OreConfiguration(emeraldOres, 3));
        register(context, ORE_LAPIS, Feature.ORE, new OreConfiguration(lapisOres, 14)); // 7
        register(context, ORE_LAPIS_BURIED, Feature.ORE, new OreConfiguration(lapisOres, 7, 1.0f));
        register(context, ORE_REDSTONE, Feature.ORE, new OreConfiguration(redstoneOres, 8));
    }

    public static void bootstrap_medievalism(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        // ROCK
        simpleRandomPatch(context, SANDSTONE_ROCK,              2, 3, 0, BlockRegistration.SANDSTONE_ROCK.get());
        simpleRandomPatch(context, RED_SANDSTONE_ROCK,          2, 3, 0, BlockRegistration.RED_SANDSTONE_ROCK.get());
        simpleRandomPatch(context, SAPROLITE_ROCK,              2, 3, 0, BlockRegistration.SAPROLITE_ROCK.get());
        simpleRandomPatch(context, LATERITE_ROCK,               2, 3, 0, BlockRegistration.LATERITE_ROCK.get());
        simpleRandomPatch(context, GREYWACKE_ROCK,              2, 3, 0, BlockRegistration.GREYWACKE_ROCK.get());
        simpleRandomPatch(context, SILTSTONE_ROCK,              2, 3, 0, BlockRegistration.SILTSTONE_ROCK.get());
        simpleRandomPatch(context, DOLOSTONE_ROCK,              2, 3, 0, BlockRegistration.DOLOSTONE_ROCK.get());
        simpleRandomPatch(context, LIMESTONE_ROCK,              2, 3, 0, BlockRegistration.LIMESTONE_ROCK.get());
        simpleRandomPatch(context, IRONSTONE_ROCK,              2, 3, 0, BlockRegistration.IRONSTONE_ROCK.get());
        simpleRandomPatch(context, SHALE_ROCK,                  2, 3, 0, BlockRegistration.SHALE_ROCK.get());
        simpleRandomPatch(context, ARKOSE_ROCK,                 2, 3, 0, BlockRegistration.ARKOSE_ROCK.get());
        // LARGE ROCK
        simpleRandomPatch(context, LARGE_SANDSTONE_ROCK,        2, 3, 0, BlockRegistration.LARGE_SANDSTONE_ROCK.get());
        simpleRandomPatch(context, LARGE_RED_SANDSTONE_ROCK,    2, 3, 0, BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get());
        simpleRandomPatch(context, LARGE_SAPROLITE_ROCK,        2, 3, 0, BlockRegistration.LARGE_SAPROLITE_ROCK.get());
        simpleRandomPatch(context, LARGE_LATERITE_ROCK,         2, 3, 0, BlockRegistration.LARGE_LATERITE_ROCK.get());
        simpleRandomPatch(context, LARGE_GREYWACKE_ROCK,        2, 3, 0, BlockRegistration.LARGE_GREYWACKE_ROCK.get());
        simpleRandomPatch(context, LARGE_SILTSTONE_ROCK,        2, 3, 0, BlockRegistration.LARGE_SILTSTONE_ROCK.get());
        simpleRandomPatch(context, LARGE_DOLOSTONE_ROCK,        2, 3, 0, BlockRegistration.LARGE_DOLOSTONE_ROCK.get());
        simpleRandomPatch(context, LARGE_LIMESTONE_ROCK,        2, 3, 0, BlockRegistration.LARGE_LIMESTONE_ROCK.get());
        simpleRandomPatch(context, LARGE_IRONSTONE_ROCK,        2, 3, 0, BlockRegistration.LARGE_IRONSTONE_ROCK.get());
        simpleRandomPatch(context, LARGE_SHALE_ROCK,            2, 3, 0, BlockRegistration.LARGE_SHALE_ROCK.get());
        simpleRandomPatch(context, LARGE_ARKOSE_ROCK,           2, 3, 0, BlockRegistration.LARGE_ARKOSE_ROCK.get());
        // COPPER ROCK
        simpleRandomPatch(context, GREYWACKE_ROCK_COPPER_ORE,   1, 0, 0, BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get());
        simpleRandomPatch(context, SILTSTONE_ROCK_COPPER_ORE,   1, 0, 0, BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get());
        simpleRandomPatch(context, DOLOSTONE_ROCK_COPPER_ORE,   1, 0, 0, BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get());
        simpleRandomPatch(context, LIMESTONE_ROCK_COPPER_ORE,   1, 0, 0, BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get());
        simpleRandomPatch(context, IRONSTONE_ROCK_COPPER_ORE,   1, 0, 0, BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get());
        simpleRandomPatch(context, SHALE_ROCK_COPPER_ORE,       1, 0, 0, BlockRegistration.SHALE_ROCK_COPPER_ORE.get());
        simpleRandomPatch(context, ARKOSE_ROCK_COPPER_ORE,      1, 0, 0, BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get());
    }

    // --

    public static void simpleRandomPatch(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                         int tries, int xzSpread, int ySpread, Block block) {
        simpleRandomPatch(context, featureKey, tries, xzSpread, ySpread, BlockStateProvider.simple(block));
    }

    public static void simpleRandomPatch(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey,
                                         int tries, int xzSpread, int ySpread, BlockStateProvider blockStateProvider) {
        register(context, featureKey, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        tries, xzSpread, ySpread,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(blockStateProvider)
                        )
                )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(ResourceLocation resource) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, resource);
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
