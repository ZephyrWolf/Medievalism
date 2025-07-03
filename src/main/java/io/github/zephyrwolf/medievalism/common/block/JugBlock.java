package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class JugBlock extends Block implements SimpleWaterloggedBlock
{
    //region Constants
    public static final MapCodec<GatherersJarBlock> CODEC = simpleCodec(GatherersJarBlock::new);

    public static final VoxelShape JUG_SHAPE = Block.box(6, 0.0, 6, 10, 6, 10);
    //endregion

    //region Boilerplate
    public JugBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any()
                .setValue(BlockStateProperties.WATERLOGGED, false)
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    //endregion

    //region Shape
    @SuppressWarnings("deprecation")
    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return JUG_SHAPE;
    }
    //endregion

    // region BlockStates
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(BlockStateProperties.WATERLOGGED)
                .add(BlockStateProperties.HORIZONTAL_FACING)
        ;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return defaultBlockState()
                .setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection());
    }

    @SuppressWarnings("deprecation")
    @Override
    protected BlockState rotate(BlockState pState, Rotation pRotation) {
        Direction facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        facing = switch (facing) {
            case Direction.NORTH -> Direction.EAST;
            case Direction.EAST -> Direction.SOUTH;
            case Direction.SOUTH -> Direction.WEST;
            case Direction.WEST -> Direction.NORTH;
            default -> facing;
        };
        return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, facing);
    }
    //endregion

    //region Block Properties
    @Override
    protected boolean isPathfindable(@NotNull BlockState pState, @NotNull PathComputationType pPathComputationType) {
        return hasCollision || pState.getFluidState().is(FluidTags.WATER); // SlabBlock
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return true;
    }
    //endregion

    //region Block Updates
    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    // Block Update
    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(BlockStateProperties.WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }
    //endregion

    public static class DryingJugBlock extends DryingBlockHorizontalFacing
    {
        public DryingJugBlock(Properties props) {
            super(props, JUG_SHAPE, SoundType.PACKED_MUD, 1.0f);
        }
    }
}
