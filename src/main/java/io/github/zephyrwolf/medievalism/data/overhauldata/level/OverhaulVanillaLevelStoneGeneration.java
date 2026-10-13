package io.github.zephyrwolf.medievalism.data.overhauldata.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource.AwareConditionSources;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource.CellConditionSource;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource.HeightmapRangeConditionSource;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenNoiseCatalog;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.Optional;

public final class OverhaulVanillaLevelStoneGeneration
{
    @Unique
    public static <E> @NotNull Optional<E> modifyNoiseGeneratorSettings(NoiseGeneratorSettings e)
    {
        SurfaceRules.SequenceRuleSource parent = (SurfaceRules.SequenceRuleSource) e.surfaceRule();

        // Remove Deepslate layer
        ArrayList<SurfaceRules.RuleSource> parentRules = new ArrayList<SurfaceRules.RuleSource>();
        for (SurfaceRules.RuleSource rule : parent.sequence()) {
            if (rule instanceof SurfaceRules.TestRuleSource testRule) {
                if (testRule.thenRun() instanceof SurfaceRules.BlockRuleSource blockRule) {
                    if (blockRule.resultState().getBlock() == Blocks.DEEPSLATE) {
                        continue;
                    }
                }
            }
            parentRules.add(rule); // If we cannot identify as deepslate layer for whatever reason, add it on
        }
        SurfaceRules.RuleSource strippedParent = new SurfaceRules.SequenceRuleSource(parentRules);

        //SurfaceRules.VerticalGradientConditionSource

        // TODO Make Cell definition to unify properties instead of copy paste
        // TODO Noise has octaves and such... can I make better use of these?

        // Add layers
        SurfaceRules.RuleSource modifiedSurfaceRule = SurfaceRules.sequence(
                strippedParent,
                SurfaceRules.ifTrue( // Try Ashfall
                        AwareConditionSources.verticalRange(WorldGenLayerConstants.MIN_ASHFALL, WorldGenLayerConstants.MAX_ASHFALL),
                        SurfaceRules.ifTrue(
                                AwareConditionSources.upperVerticalGradient(
                                        "medievalism:ashfall",
                                        AwareVerticalAnchor.heightMap(-5),
                                        3
                                ),
                                SurfaceRules.sequence( // Ashfall
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_ASHFALL,
                                                        WorldGenNoiseCatalog.VARIANTS_ASHFALL.SOFT_TUFF),
                                                SurfaceRules.state(BlockRegistration.SOFT_TUFF.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_ASHFALL,
                                                        WorldGenNoiseCatalog.VARIANTS_ASHFALL.IGNIMBRITE),
                                                SurfaceRules.state(BlockRegistration.IGNIMBRITE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_ASHFALL,
                                                        WorldGenNoiseCatalog.VARIANTS_ASHFALL.LAPILLISTONE),
                                                SurfaceRules.state(BlockRegistration.LAPILLISTONE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_ASHFALL,
                                                        WorldGenNoiseCatalog.VARIANTS_ASHFALL.WELDED_TUFF),
                                                SurfaceRules.state(BlockRegistration.WELDED_TUFF.get().defaultBlockState())
                                        )
                                )
                        )
                ),
                SurfaceRules.ifTrue( // Try Regolith
                        AwareConditionSources.verticalRange(WorldGenLayerConstants.MIN_REGOLITH, WorldGenLayerConstants.MAX_REGOLITH),
                        SurfaceRules.ifTrue(
                                AwareConditionSources.upperVerticalGradient(
                                        "medievalism:regolith",
                                        AwareVerticalAnchor.heightMap(-7),
                                        5
                                ),
                                SurfaceRules.sequence( // Reolith
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,
                                                        WorldGenNoiseCatalog.VARIANTS_REGOLITH.LATERITE),
                                                SurfaceRules.state(BlockRegistration.LATERITE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,
                                                        WorldGenNoiseCatalog.VARIANTS_REGOLITH.SAPROLITE),
                                                SurfaceRules.state(BlockRegistration.SAPROLITE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH,
                                                        WorldGenNoiseCatalog.VARIANTS_REGOLITH.SILT),
                                                SurfaceRules.state(BlockRegistration.SILT.get().defaultBlockState())
                                        )
                                )
                        )
                ),
                SurfaceRules.ifTrue( // Try Deep Igneous Intrusive
                        AwareConditionSources.lowerVerticalGradient(
                                "medievalism:deep_igneous_intrusive",
                                AwareVerticalAnchor.worldLayer(
                                        WorldGenLayerConstants.MIN_DEEP_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.TYPICAL_DEEP_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.MAX_DEEP_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.DATUM,
                                        WorldGenLayerConstants.POS_SCALE_DEEP_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE),
                                8
                        ),
                        //SurfaceRules.state(BlockRegistration.NORITE.get().defaultBlockState())
                        SurfaceRules.sequence( // Deep Igneous Intrusive
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_DEEP_IGNEOUS_INTRUSIVE,
                                                WorldGenNoiseCatalog.VARIANTS_DEEP_IGNEOUS_INTRUSIVE.NORITE),
                                        SurfaceRules.state(BlockRegistration.NORITE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_DEEP_IGNEOUS_INTRUSIVE,
                                                WorldGenNoiseCatalog.VARIANTS_DEEP_IGNEOUS_INTRUSIVE.PERIDOTITE),
                                        SurfaceRules.state(BlockRegistration.PERIDOTITE.get().defaultBlockState())
                                )
                        )
                ),
                SurfaceRules.ifTrue( // Try Igneous Intrusive
                        AwareConditionSources.lowerVerticalGradient(
                                "medievalism:igneous_intrusive",
                                AwareVerticalAnchor.worldLayer(
                                        WorldGenLayerConstants.MIN_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.TYPICAL_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.MAX_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.DATUM,
                                        WorldGenLayerConstants.POS_SCALE_IGNEOUS_INTRUSIVE,
                                        WorldGenLayerConstants.NEG_SCALE_IGNEOUS_INTRUSIVE),
                                8
                        ),
                        SurfaceRules.sequence( // Igneous Intrusive
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_IGNEOUS_INTRUSIVE,
                                                WorldGenNoiseCatalog.VARIANTS_IGNEOUS_INTRUSIVE.GABBRO),
                                        SurfaceRules.state(BlockRegistration.GABBRO.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_IGNEOUS_INTRUSIVE,
                                                WorldGenNoiseCatalog.VARIANTS_IGNEOUS_INTRUSIVE.DIORITE),
                                        SurfaceRules.state(BlockRegistration.SMOOTH_DIORITE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_IGNEOUS_INTRUSIVE,
                                                WorldGenNoiseCatalog.VARIANTS_IGNEOUS_INTRUSIVE.GRANITE),
                                        SurfaceRules.state(BlockRegistration.SMOOTH_GRANITE.get().defaultBlockState())
                                )
                        )
                ),
                SurfaceRules.ifTrue( // Try Metamorphic & Hard Extrusive Igneous
                        AwareConditionSources.verticalRange(WorldGenLayerConstants.MIN_METAMORPHIC, WorldGenLayerConstants.MAX_METAMORPHIC),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        HeightmapRangeConditionSource.within(
                                                WorldGenLayerConstants.MIN_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE,
                                                WorldGenLayerConstants.MAX_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE
                                        ),
                                        SurfaceRules.ifTrue(
                                                //AwareConditionSources.verticalRange( // Gradient comes from medievalism:metamorphic parent
                                                //        AwareVerticalAnchor.inverseBell(
                                                //                WorldGenLayers.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                                                //                WorldGenLayers.SCALE_HARD_IGNEOUS_EXTRUSIVE),
                                                //        WorldGenLayers.MAX_HARD_IGNEOUS_EXTRUSIVE
                                                //),
                                                AwareConditionSources.upperVerticalGradient( // Gradient comes from medievalism:metamorphic parent
                                                        "medievalism:hard_igneous_extrusive",
                                                        AwareVerticalAnchor.inverseBell(
                                                                WorldGenLayerConstants.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                                                                WorldGenLayerConstants.SCALE_HARD_IGNEOUS_EXTRUSIVE),
                                                        8
                                                ),
                                                SurfaceRules.sequence( // Hard extrusive igneous
                                                        SurfaceRules.ifTrue(
                                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_HARD_IGNEOUS_EXTRUSIVE,
                                                                        WorldGenNoiseCatalog.VARIANTS_HARD_IGNEOUS_EXTRUSIVE.ANDESITE),
                                                                SurfaceRules.state(BlockRegistration.ANDESITE.get().defaultBlockState())
                                                        ),
                                                        SurfaceRules.ifTrue(
                                                                CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_HARD_IGNEOUS_EXTRUSIVE,
                                                                        WorldGenNoiseCatalog.VARIANTS_HARD_IGNEOUS_EXTRUSIVE.BASALT),
                                                                SurfaceRules.state(BlockRegistration.BASALT.get().defaultBlockState())
                                                        )
                                                )
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        AwareConditionSources.lowerVerticalGradient(
                                                "medievalism:metamorphic",
                                                AwareVerticalAnchor.worldLayer(
                                                        WorldGenLayerConstants.MIN_METAMORPHIC,
                                                        WorldGenLayerConstants.TYPICAL_METAMORPHIC,
                                                        WorldGenLayerConstants.MAX_METAMORPHIC,
                                                        WorldGenLayerConstants.DATUM,
                                                        WorldGenLayerConstants.POS_SCALE_METAMORPHIC,
                                                        WorldGenLayerConstants.NEG_SCALE_METAMORPHIC),
                                                8
                                        ),
                                        SurfaceRules.sequence( // Metamorphic
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_METAMORPHIC,
                                                                WorldGenNoiseCatalog.VARIANTS_METAMORPHIC.MARBLE),
                                                        SurfaceRules.state(BlockRegistration.MARBLE.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_METAMORPHIC,
                                                                WorldGenNoiseCatalog.VARIANTS_METAMORPHIC.QUARTZITE),
                                                        SurfaceRules.state(BlockRegistration.QUARTZITE.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_METAMORPHIC,
                                                                WorldGenNoiseCatalog.VARIANTS_METAMORPHIC.HORNFELS),
                                                        SurfaceRules.state(BlockRegistration.HORNFELS.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_METAMORPHIC,
                                                                WorldGenNoiseCatalog.VARIANTS_METAMORPHIC.SLATE),
                                                        SurfaceRules.state(BlockRegistration.SLATE.get().defaultBlockState())
                                                )
                                        )
                                )
                        )
                ),
                SurfaceRules.sequence( // Try Sedimentary & Soft extrusive igneous
                        SurfaceRules.ifTrue(
                                HeightmapRangeConditionSource.within(
                                        WorldGenLayerConstants.MIN_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE,
                                        WorldGenLayerConstants.MAX_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE
                                ),
                                SurfaceRules.ifTrue(
                                        //AwareConditionSources.verticalRange( // TODO Eliminate vertical range for gradient, lets use upper
                                        //        AwareVerticalAnchor.inverseBell(
                                        //                WorldGenLayers.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                                        //                WorldGenLayers.SCALE_SOFT_IGNEOUS_EXTRUSIVE),
                                        //        WorldGenLayers.MAX_SOFT_IGNEOUS_EXTRUSIVE
                                        //),
                                        AwareConditionSources.upperVerticalGradient( // TODO Eliminate vertical range for gradient, lets use upper
                                                "medievalism:soft_igenous_extrusive",
                                                AwareVerticalAnchor.inverseBell(
                                                        WorldGenLayerConstants.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                                                        WorldGenLayerConstants.SCALE_SOFT_IGNEOUS_EXTRUSIVE),
                                                8
                                        ),
                                        SurfaceRules.sequence( // Soft extrusive igneous
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SOFT_IGNEOUS_EXTRUSIVE,
                                                                WorldGenNoiseCatalog.VARIANTS_SOFT_IGNEOUS_EXTRUSIVE.RHYOLITE),
                                                        SurfaceRules.state(BlockRegistration.RHYOLITE.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SOFT_IGNEOUS_EXTRUSIVE,
                                                                WorldGenNoiseCatalog.VARIANTS_SOFT_IGNEOUS_EXTRUSIVE.DACITE),
                                                        SurfaceRules.state(BlockRegistration.DACITE.get().defaultBlockState())
                                                )
                                        )
                                )
                        ),
                        SurfaceRules.sequence( // Sedimentary // Fills in the gap
                                SurfaceRules.ifTrue(
                                        //CellConditionSource.cell(BaseNoiseProviderEntry.NOISE_SEDIMENTARY, 1000, 0.03f, 0.2f, 5, 0),
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.GREYWACKE),
                                        SurfaceRules.state(BlockRegistration.GREYWACKE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SILTSTONE),
                                        SurfaceRules.state(BlockRegistration.SILTSTONE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.DOLOSTONE),
                                        SurfaceRules.state(BlockRegistration.DOLOSTONE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.LIMESTONE),
                                        SurfaceRules.state(BlockRegistration.LIMESTONE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.IRONSTONE),
                                        SurfaceRules.state(BlockRegistration.IRONSTONE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.SHALE),
                                        SurfaceRules.state(BlockRegistration.SHALE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY,
                                                WorldGenNoiseCatalog.VARIANTS_SEDIMENTARY.ARKOSE),
                                        SurfaceRules.state(BlockRegistration.ARKOSE.get().defaultBlockState())
                                )
                        )
                )
        );

        // Whats the dif between yBlockCheck and yStartCheck

        @SuppressWarnings("deprecation")
        NoiseGeneratorSettings modified = new NoiseGeneratorSettings(
                e.noiseSettings(),
                e.defaultBlock(),
                e.defaultFluid(),
                e.noiseRouter(),
                modifiedSurfaceRule,
                e.spawnTarget(),
                e.seaLevel(),
                e.disableMobGeneration(),
                e.aquifersEnabled(),
                e.oreVeinsEnabled(),
                e.useLegacyRandomSource()
        );

        @SuppressWarnings("unchecked")
        Optional<E> newCandidate = Optional.of((E) modified);
        return newCandidate;
    }
}
