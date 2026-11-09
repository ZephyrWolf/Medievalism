package io.github.zephyrwolf.medievalism.common.block.plants;

import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SoftRushBlock extends BushBlock
{

    public static final MapCodec<SoftRushBlock> CODEC = BlockBehaviour.simpleCodec(SoftRushBlock::new);
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty DONE_GROWING = BooleanProperty.create("done_growing");


    protected static final VoxelShape SHAPE_LOWER0 = Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0);
    protected static final VoxelShape SHAPE_LOWER1 = Block.box(3.0, 0.0, 3.0, 13.0, 12.0, 13.0);
    protected static final VoxelShape SHAPE_LOWER2 = Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0);
    protected static final VoxelShape SHAPE_LOWER3 = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    protected static final VoxelShape SHAPE_LOWER4 = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    protected static final VoxelShape SHAPE_UPPER0 = Block.box(0, 0, 0, 16, 16, 16);
    protected static final VoxelShape SHAPE_UPPER1 = Block.box(0, 0, 0, 16, 16, 16);
    protected static final VoxelShape SHAPE_UPPER2 = Block.box(0, 0, 0, 16, 16, 16);
    protected static final VoxelShape SHAPE_UPPER3 = Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0);
    protected static final VoxelShape SHAPE_UPPER4 = Block.box(1.0, 0.0, 1.0, 15.0, 12.0, 15.0);

    protected static final VoxelShape[][] SHAPES = {{SHAPE_LOWER0, SHAPE_LOWER1, SHAPE_LOWER2, SHAPE_LOWER3, SHAPE_LOWER4}, {SHAPE_UPPER0, SHAPE_UPPER1, SHAPE_UPPER2, SHAPE_UPPER3, SHAPE_UPPER4}};

    @Override
    protected MapCodec<? extends BushBlock> codec() { return CODEC; }

    public SoftRushBlock(Properties props)
    {
        super(props.noCollission());
        registerDefaultState(getStateDefinition().any()
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(AGE, 0)
                .setValue(WATERLOGGED, false)
                .setValue(DONE_GROWING, false)
        );
    }

    public BlockState defaultWorldGenBlockState()
    {
        return defaultBlockState().setValue(DONE_GROWING, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HALF)
                .add(AGE)
                .add(WATERLOGGED)
                .add(DONE_GROWING);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        int half = pState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1;
        int age = pState.getValue(AGE);
        return SHAPES[half][age];
    }

    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (pState.getValue(HALF) == DoubleBlockHalf.LOWER && !pState.canSurvive(pLevel, pPos))
        {
            pLevel.destroyBlock(pPos, true);
        }
    }

    /**
     * Performs a random tick on a block.
     */
    @Override // Random Tick
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (pState.getValue(HALF) == DoubleBlockHalf.UPPER) return; // Only the lower state processes growth ticks
        if (pState.getValue(AGE) == MAX_AGE) return;
        if (pState.getValue(DONE_GROWING)) return;

        BlockPos abovePos = pPos.above();
        BlockState olderState = pState.setValue(AGE, pState.getValue(AGE) + 1);
        if (isDoubleBlock(olderState) && (pLevel.isEmptyBlock(abovePos) || pLevel.getBlockState(abovePos).getBlock() == this))
        { // If older is double && above is empty or this // doesn't matter if current is single or double
            if (olderState.getValue(AGE) == MAX_AGE && pRandom.nextInt(3) == 0)
            {
                pLevel.setBlock(pPos, pState.setValue(DONE_GROWING, true).setValue(HALF, DoubleBlockHalf.LOWER), 6); // No block update
                pLevel.setBlock(abovePos, pState.setValue(DONE_GROWING, true).setValue(HALF, DoubleBlockHalf.UPPER), 6); // No block update
            }
            else if (CommonHooks.canCropGrow(pLevel, pPos, pState, true))
            {
                pLevel.setBlockAndUpdate(pPos, olderState.setValue(HALF, DoubleBlockHalf.LOWER));
                pLevel.setBlockAndUpdate(abovePos, olderState.setValue(HALF, DoubleBlockHalf.UPPER));
                CommonHooks.fireCropGrowPost(pLevel, pPos, this.defaultBlockState());
                CommonHooks.fireCropGrowPost(pLevel, abovePos, this.defaultBlockState());
                //pLevel.setBlock(pPos, pState.setValue(AGE, 0), 4); // No block update
            }
        }
        else
        { // Single Block
            if (CommonHooks.canCropGrow(pLevel, pPos, pState, true))
            {
                pLevel.setBlockAndUpdate(pPos, olderState.setValue(HALF, DoubleBlockHalf.LOWER));
                CommonHooks.fireCropGrowPost(pLevel, pPos, this.defaultBlockState());
            }
        }
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        // Is our other half where it should be?
        if (pFacing.getAxis() == Direction.Axis.Y)
        { // If vertical
            if ((doubleblockhalf == DoubleBlockHalf.LOWER) == (pFacing == Direction.UP))
            { // If other half; lower & up || upper & down; xnor
                if (!pFacingState.is(this) || (pFacingState.getValue(HALF) == doubleblockhalf))
                { // Other half has been replaced || Other half state isn't other half
                    return Blocks.AIR.defaultBlockState();
                }
            }
        }
        // Has soil changed?
        if (doubleblockhalf == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos))
        {
            //pLevel.scheduleTick(pCurrentPos, this, 1);
            return Blocks.AIR.defaultBlockState();
        } // else
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public boolean isDoubleBlock(BlockState state)
    {
        int age = state.getValue(BlockStateProperties.AGE_4);
        return age >= 3;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockState state = super.getStateForPlacement(pContext);
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (    state == null || // forward null
                isDoubleBlock(state) && ( // placing double
                        blockpos.getY() >= level.getMaxBuildHeight() - 1 || // not enough room in build height
                        !level.getBlockState(blockpos.above()).canBeReplaced(pContext) // can't place upper half
                )
        )
        { // then null
            return null;
        } // else
        return state;
    }

    /**
     * Called by BlockItem after this block has been placed.
     */
    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack)
    {
        if (isDoubleBlock(pState))
        { // if double then place upper
            BlockPos abovePos = pPos.above();
            BlockState aboveState = copyWaterloggedFrom(pLevel, abovePos, pState.setValue(HALF, DoubleBlockHalf.UPPER));
            pLevel.setBlock(abovePos, aboveState, 3);
        }
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    { // I would check to ensure age are the same, but I am worried about canSurvive being called between block writes
        if (pState.getValue(HALF) == DoubleBlockHalf.UPPER)
        {
            BlockState belowState = pLevel.getBlockState(pPos.below());
            if (pState.getBlock() != this)
            { // Unsure about this comment, I would assume if below doesn't equal this then something is wrong
                return super.canSurvive(pState, pLevel, pPos); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            }
            return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER;
        } // else
        return super.canSurvive(pState, pLevel, pPos); // BushBlock handles lower
    }

    public static void placeAt(LevelAccessor pLevel, BlockState pState, BlockPos pPos, int pFlags)
    {
        BlockPos abovePos = pPos.above();
        pLevel.setBlock(pPos, copyWaterloggedFrom(pLevel, pPos, pState.setValue(HALF, DoubleBlockHalf.LOWER)), pFlags);
        pLevel.setBlock(abovePos, copyWaterloggedFrom(pLevel, abovePos, pState.setValue(HALF, DoubleBlockHalf.UPPER)), pFlags);
    }

    public static BlockState copyWaterloggedFrom(LevelReader pLevel, BlockPos pPos, BlockState pState)
    {
        return pState.hasProperty(BlockStateProperties.WATERLOGGED)
                ? pState.setValue(BlockStateProperties.WATERLOGGED, pLevel.isWaterAt(pPos))
                : pState;
    }

    @Override
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        if (!pLevel.isClientSide) // If Server
        {
            if (pPlayer.isCreative())
            {
                preventDropFromBottomPart(pLevel, pPos, pState, pPlayer);
            }
            else
            {
                dropResources(pState, pLevel, pPos, null, pPlayer, pPlayer.getMainHandItem());
            }
        }

        return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    /**
     * Called after a player has successfully harvested this block. This method will only be called if the player has used the correct tool and drops should be spawned.
     */
    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack)
    { // Ensure pState is set to AIR
        super.playerDestroy(pLevel, pPlayer, pPos, Blocks.AIR.defaultBlockState(), pTe, pStack);
    }

    protected static void preventDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) // If I am upper, then block lower drops
        {
            BlockPos belowPos = pPos.below();
            BlockState belowState = pLevel.getBlockState(belowPos);
            if (belowState.is(pState.getBlock()) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER) // If below is my lower
            {
                BlockState emptyBelowState = belowState.getFluidState().is(Fluids.WATER) ?
                        Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(belowPos, emptyBelowState, 35);
                pLevel.levelEvent(pPlayer, 2001, belowPos, Block.getId(belowState));
            }
        }
    }



    /**
     * Return a random long to be passed to {@link net.minecraft.client.resources.model.BakedModel#getQuads}, used for random model rotations
     */
    @Override
    protected long getSeed(BlockState pState, BlockPos pPos)
    { // Always seed with lower, not upper, regardless of half
        return Mth.getSeed(pPos.getX(), pPos.below(pState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pPos.getZ());
    }

}
