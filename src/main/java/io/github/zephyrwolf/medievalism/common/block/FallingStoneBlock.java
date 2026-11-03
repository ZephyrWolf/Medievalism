package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class FallingStoneBlock extends ColoredFallingBlock
{
    protected Supplier<BlockState> fallingState;
    protected float gravelChance;
    protected int particleChance;

    public static Supplier<FallingStoneBlock> fallingStone(Properties properties, Supplier<BlockState> fallingState, float gravelChance, int particleChance)
    {
        return () -> new FallingStoneBlock(properties, fallingState, gravelChance, particleChance);
    }

    public FallingStoneBlock(Properties properties, Supplier<BlockState> fallingState, float gravelChance, int particleChance)
    {
        super(new ColorRGBA(-8356741), properties);
        this.fallingState = fallingState;
        this.gravelChance = gravelChance;
        this.particleChance = particleChance;
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        pLevel.scheduleTick(pCurrentPos, this, this.getDelayAfterPlace());
        if (pLevel.getRandom().nextInt(5) > 1) // 2, 3, 4  (3/5)
        {
            pLevel.scheduleTick(pCurrentPos.below(), pLevel.getBlockState(pCurrentPos.below()).getBlock(), this.getDelayAfterPlace() * 2);
        }
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    protected BlockState getFallingState(BlockState pState, BlockPos pPos, RandomSource pRandom)
    {
        return pRandom.nextFloat() < gravelChance ? fallingState.get() : pState;
    }

    @Override
    protected void tick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom)
    {
        if (isFree(pLevel.getBlockState(pPos.below())) && pPos.getY() >= pLevel.getMinBuildHeight())
        { // Can Fall
            BlockState fallingState = getFallingState(pState, pPos, pRandom);
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(pLevel, pPos, fallingState);
            pLevel.setBlock(pPos, pState.getFluidState().createLegacyBlock(), 3);
            this.falling(fallingblockentity);
        }
    }

    @Override
    public void animateTick(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom)
    {
        if (pRandom.nextInt(particleChance) == 0)
        {
            BlockPos blockpos = pPos.below();
            if (isFree(pLevel.getBlockState(blockpos)))
            {
                ParticleUtils.spawnParticleBelow(pLevel, pPos, pRandom, new BlockParticleOption(ParticleTypes.FALLING_DUST, pState));
            }
        }
    }
}
