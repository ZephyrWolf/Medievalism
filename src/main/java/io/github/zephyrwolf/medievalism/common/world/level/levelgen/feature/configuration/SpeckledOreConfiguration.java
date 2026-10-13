package io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class SpeckledOreConfiguration implements FeatureConfiguration
{
    public static final Codec<SpeckledOreConfiguration> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Codec.list(OreConfiguration.TargetBlockState.CODEC).fieldOf("targets").forGetter(speckledOreConfiguration -> speckledOreConfiguration.targetStates),
                            Codec.list(OreConfiguration.TargetBlockState.CODEC).fieldOf("speckledTargets").forGetter(speckledOreConfiguration -> speckledOreConfiguration.speckledStates),
                            Codec.intRange(0, 64).fieldOf("size").forGetter(speckledOreConfig -> speckledOreConfig.size),
                            Codec.FLOAT.fieldOf("speckled_chance").forGetter(speckledOreConfig -> speckledOreConfig.speckledChance),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("discard_chance_on_air_exposure").forGetter(speckledOreConfig -> speckledOreConfig.discardChanceOnAirExposure)
                    )
                    .apply(instance, SpeckledOreConfiguration::new)
    );
    public final List<OreConfiguration.TargetBlockState> targetStates;
    public final List<OreConfiguration.TargetBlockState> speckledStates;
    public final int size;
    public final float speckledChance;
    public final float discardChanceOnAirExposure;

    public SpeckledOreConfiguration(List<OreConfiguration.TargetBlockState> pTargetStates, List<OreConfiguration.TargetBlockState> pSpeckledStates, int pSize, float pSpeckledChance, float pDiscardOnAirExposureChance) {
        this.targetStates = pTargetStates;
        this.speckledStates = pSpeckledStates;
        this.size = pSize;
        this.speckledChance = pSpeckledChance;
        this.discardChanceOnAirExposure = pDiscardOnAirExposureChance;
    }

    public SpeckledOreConfiguration(List<OreConfiguration.TargetBlockState> pTargetStates, List<OreConfiguration.TargetBlockState> pSpeckledStates, int pSize, float pSpeckledChance) {
        this(pTargetStates, pSpeckledStates, pSize, pSpeckledChance, 0.0F);
    }

    public SpeckledOreConfiguration(RuleTest pTarget, BlockState pState, BlockState pSpeckledState, int pSize, float pSpeckledChance, float pDiscardChanceOnAirExposure) {
        this(ImmutableList.of(OreConfiguration.target(pTarget, pState)), ImmutableList.of(OreConfiguration.target(pTarget, pSpeckledState)), pSize, pSpeckledChance, pDiscardChanceOnAirExposure);
    }

    public SpeckledOreConfiguration(RuleTest pTarget, BlockState pState, BlockState pSpeckledState, int pSize, float pSpeckledChance)
    {
        this(ImmutableList.of(OreConfiguration.target(pTarget, pState)), ImmutableList.of(OreConfiguration.target(pTarget, pSpeckledState)), pSize, pSpeckledChance, 0.0F);
    }
}
