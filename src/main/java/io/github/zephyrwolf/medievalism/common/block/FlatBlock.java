package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.NotNull;

public class FlatBlock extends CarpetBlock
{

    public FlatBlock(Properties props)
    {
        super(props);
    }

    // Block Bush
    @Override
    protected boolean isPathfindable(@NotNull BlockState pState, @NotNull PathComputationType pPathComputationType) {
        return pPathComputationType == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(pState, pPathComputationType);
    }

    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) { return 1.0f; }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) { return true; }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, LevelReader pLevel, BlockPos pPos)
    {
        //return canSupportCenter(p_152923_, p_152924_.below(), Direction.UP);
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }
}
