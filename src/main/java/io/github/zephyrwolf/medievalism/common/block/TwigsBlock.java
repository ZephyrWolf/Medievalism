package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class TwigsBlock extends IncrementBlock implements SimpleWaterloggedBlock
{ // Waterlogged from SlabBlock

    public static final int MIN_STICKS = 1;
    public static final int MAX_STICKS = 3;
    public static final IntegerProperty NUM_STICKS = IntegerProperty.create("num_sticks", MIN_STICKS, MAX_STICKS);

    public TwigsBlock(Properties properties)
    {
        super(properties, false);
        registerDefaultState(getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(NUM_STICKS, MIN_STICKS));
    }

    //region State
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
                .setValue(NUM_STICKS, MIN_STICKS);
    }

    @Override
    public int getMinCount() { return MIN_STICKS; }
    @Override
    public int getMaxCount() { return MAX_STICKS; }
    @Override
    public IntegerProperty getCountProp() { return NUM_STICKS; }
    //endregion

    //region Interaction
    @Override
    protected boolean canUseItemStack(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        return stack.getItem() == Items.STICK;
    }

    @Override
    public ItemStack pickUpItem(BlockState state, Level level, BlockPos pos)
    {
        return new ItemStack(Items.STICK);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player)
    {
        return new ItemStack(Items.STICK);
    }

    //endregion

    //region Shape
    public static final VoxelShape TWIG_SHAPE = Block.box(3, 0, 3, 13, 3, 13);

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return TWIG_SHAPE;
    }
    //endregion

    //region Block Behaviour
    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return true;
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }
    //endregion

    //region Tick
    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }
    //endregion
}
