package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class TwigsBlock extends Block implements SimpleWaterloggedBlock { // Waterlogged from SlabBlock
    public static final MapCodec<BranchBlock> CODEC = simpleCodec(BranchBlock::new);
    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final int MIN_STICKS = 1;
    public static final int MAX_STICKS = 3;
    public static final IntegerProperty NUM_STICKS = IntegerProperty.create("num_sticks", MIN_STICKS, MAX_STICKS);

    public static final VoxelShape TWIG_SHAPE = Block.box(3, 0, 3, 13, 3, 13);

    public TwigsBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(NUM_STICKS, 1));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult)
    {
        if (pStack.getItem() == Items.STICK)
        {
            int numSticks = pState.getValue(NUM_STICKS);
            if (numSticks < MAX_STICKS)
            {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(NUM_STICKS, numSticks + 1));
                return ItemInteractionResult.SUCCESS;
            }
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player)
    {
        return new ItemStack(Items.STICK);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return TWIG_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(WATERLOGGED)
                .add(NUM_STICKS);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return defaultBlockState()
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(NUM_STICKS, 1);
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState pState, @NotNull PathComputationType pPathComputationType) {
        return hasCollision || pState.getFluidState().is(FluidTags.WATER); // SlabBlock
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return true;
    }

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
        if (pState.getValue(WATERLOGGED)) {
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
}
