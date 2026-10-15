package io.github.zephyrwolf.medievalism.data.overhauldata.level;

import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource.AwareConditionSources;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource.CellConditionSource;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource.HeightmapRangeConditionSource;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.LayerCellRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.Optional;

public final class OverhaulVanillaLevelStoneGeneration
{ // TODO Try to eliminate this file with json
    @Unique
    public static <E> @NotNull Optional<E> modifyNoiseGeneratorSettings(NoiseGeneratorSettings e)
    {
        SurfaceRules.SequenceRuleSource parent = (SurfaceRules.SequenceRuleSource) e.surfaceRule();

        // Remove Deepslate layer
        ArrayList<SurfaceRules.RuleSource> parentRules = new ArrayList<>();
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
                                        AwareVerticalAnchor.heightMap(-WorldGenLayerConstants.DEPTH_SURFACE_ASHFALL),
                                        WorldGenLayerConstants.TRANSITION_THICKNESS_ASHFALL
                                ),
                                SurfaceRules.sequence( // Ashfall
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.SOFT_TUFF.getKey()),
                                                SurfaceRules.state(BlockRegistration.SOFT_TUFF.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.IGNIMBRITE.getKey()),
                                                SurfaceRules.state(BlockRegistration.IGNIMBRITE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.LAPILLISTONE.getKey()),
                                                SurfaceRules.state(BlockRegistration.LAPILLISTONE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.WELDED_TUFF.getKey()),
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
                                        AwareVerticalAnchor.heightMap(-WorldGenLayerConstants.DEPTH_SURFACE_REGOLITH),
                                        WorldGenLayerConstants.TRANSITION_THICKNESS_REGOLITH
                                ),
                                SurfaceRules.sequence( // Regolith
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.LATERITE.getKey()),
                                                SurfaceRules.state(BlockRegistration.LATERITE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.SAPROLITE.getKey()),
                                                SurfaceRules.state(BlockRegistration.SAPROLITE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.SILT.getKey()),
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
                                WorldGenLayerConstants.TRANSITION_THICKNESS_DEEP_IGNEOUS_INTRUSIVE
                        ),
                        //SurfaceRules.state(BlockRegistration.NORITE.get().defaultBlockState())
                        SurfaceRules.sequence( // Deep Igneous Intrusive
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(LayerCellRegistration.NORITE.getKey()),
                                        SurfaceRules.state(BlockRegistration.NORITE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(LayerCellRegistration.PERIDOTITE.getKey()),
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
                                WorldGenLayerConstants.TRANSITION_THICKNESS_IGNEOUS_INTRUSIVE
                        ),
                        SurfaceRules.sequence( // Igneous Intrusive
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(LayerCellRegistration.GABBRO.getKey()),
                                        SurfaceRules.state(BlockRegistration.GABBRO.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(LayerCellRegistration.SMOOTH_DIORITE.getKey()),
                                        SurfaceRules.state(BlockRegistration.SMOOTH_DIORITE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        CellConditionSource.cell(LayerCellRegistration.SMOOTH_GRANITE.getKey()),
                                        SurfaceRules.state(BlockRegistration.SMOOTH_GRANITE.get().defaultBlockState())
                                )
                        )
                ),
                SurfaceRules.ifTrue( // Try Metamorphic & Hard Extrusive Igneous
                        AwareConditionSources.verticalRange(WorldGenLayerConstants.MIN_METAMORPHIC, WorldGenLayerConstants.MAX_METAMORPHIC),
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
                                        WorldGenLayerConstants.TRANSITION_THICKNESS_METAMORPHIC
                                ),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                HeightmapRangeConditionSource.within(
                                                        WorldGenLayerConstants.MIN_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE,
                                                        WorldGenLayerConstants.MAX_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE
                                                ),
                                                SurfaceRules.ifTrue(
                                                        AwareConditionSources.upperVerticalGradient( // Gradient comes from medievalism:metamorphic parent
                                                                "medievalism:hard_igneous_extrusive",
                                                                AwareVerticalAnchor.inverseBell(
                                                                        WorldGenLayerConstants.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                                                                        WorldGenLayerConstants.SCALE_HARD_IGNEOUS_EXTRUSIVE),
                                                                WorldGenLayerConstants.TRANSITION_THICKNESS_HARD_IGNEOUS_EXTRUSIVE
                                                        ),
                                                        SurfaceRules.sequence( // Hard extrusive igneous
                                                                SurfaceRules.ifTrue(
                                                                        CellConditionSource.cell(LayerCellRegistration.ANDESITE.getKey()),
                                                                        SurfaceRules.state(BlockRegistration.ANDESITE.get().defaultBlockState())
                                                                ),
                                                                SurfaceRules.ifTrue(
                                                                        CellConditionSource.cell(LayerCellRegistration.BASALT.getKey()),
                                                                        SurfaceRules.state(BlockRegistration.BASALT.get().defaultBlockState())
                                                                )
                                                        )
                                                )
                                        ),
                                        SurfaceRules.sequence( // Metamorphic
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(LayerCellRegistration.MARBLE.getKey()),
                                                        SurfaceRules.state(BlockRegistration.MARBLE.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(LayerCellRegistration.QUARTZITE.getKey()),
                                                        SurfaceRules.state(BlockRegistration.QUARTZITE.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(LayerCellRegistration.HORNFELS.getKey()),
                                                        SurfaceRules.state(BlockRegistration.HORNFELS.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        CellConditionSource.cell(LayerCellRegistration.SLATE.getKey()),
                                                        SurfaceRules.state(BlockRegistration.SLATE.get().defaultBlockState())
                                                )
                                        )
                                )
                        )
                ),
                SurfaceRules.ifTrue( // Try Metamorphic & Hard Extrusive Igneous
                        AwareConditionSources.verticalRange(WorldGenLayerConstants.MIN_SEDIMENTARY, WorldGenLayerConstants.MAX_SEDIMENTARY),
                        SurfaceRules.sequence( // Try Sedimentary & Soft extrusive igneous
                                SurfaceRules.ifTrue(
                                        HeightmapRangeConditionSource.within(
                                                WorldGenLayerConstants.MIN_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE,
                                                WorldGenLayerConstants.MAX_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE
                                        ),
                                        SurfaceRules.ifTrue(
                                                AwareConditionSources.upperVerticalGradient(
                                                        "medievalism:soft_igneous_extrusive",
                                                        AwareVerticalAnchor.inverseBell(
                                                                WorldGenLayerConstants.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                                                                WorldGenLayerConstants.SCALE_SOFT_IGNEOUS_EXTRUSIVE),
                                                        WorldGenLayerConstants.TRANSITION_THICKNESS_SOFT_IGNEOUS_EXTRUSIVE
                                                ),
                                                SurfaceRules.sequence( // Soft extrusive igneous
                                                        SurfaceRules.ifTrue(
                                                                CellConditionSource.cell(LayerCellRegistration.RHYOLITE.getKey()),
                                                                SurfaceRules.state(BlockRegistration.RHYOLITE.get().defaultBlockState())
                                                        ),
                                                        SurfaceRules.ifTrue(
                                                                CellConditionSource.cell(LayerCellRegistration.DACITE.getKey()),
                                                                SurfaceRules.state(BlockRegistration.DACITE.get().defaultBlockState())
                                                        )
                                                )
                                        )
                                ),
                                SurfaceRules.sequence( // Sedimentary // Fills in the gap
                                        SurfaceRules.ifTrue(
                                                //CellConditionSource.cell(BaseNoiseProviderEntry.NOISE_SEDIMENTARY, 1000, 0.03f, 0.2f, 5, 0),
                                                CellConditionSource.cell(LayerCellRegistration.GREYWACKE.getKey()),
                                                SurfaceRules.state(BlockRegistration.GREYWACKE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.SILTSTONE.getKey()),
                                                SurfaceRules.state(BlockRegistration.SILTSTONE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.DOLOSTONE.getKey()),
                                                SurfaceRules.state(BlockRegistration.DOLOSTONE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.LIMESTONE.getKey()),
                                                SurfaceRules.state(BlockRegistration.LIMESTONE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.IRONSTONE.getKey()),
                                                SurfaceRules.state(BlockRegistration.IRONSTONE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.SHALE.getKey()),
                                                SurfaceRules.state(BlockRegistration.SHALE.get().defaultBlockState())
                                        ),
                                        SurfaceRules.ifTrue(
                                                CellConditionSource.cell(LayerCellRegistration.ARKOSE.getKey()),
                                                SurfaceRules.state(BlockRegistration.ARKOSE.get().defaultBlockState())
                                        )
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
