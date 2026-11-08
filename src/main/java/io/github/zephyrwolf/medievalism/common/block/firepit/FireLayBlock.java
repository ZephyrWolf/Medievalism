package io.github.zephyrwolf.medievalism.common.block.firepit;

import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.block.IncrementBlock;
import io.github.zephyrwolf.medievalism.registration.item.FarmingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WoodWorkingItemRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
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

import static io.github.zephyrwolf.medievalism.common.block.TwigsBlock.MIN_STICKS;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FireLayBlock extends IncrementBlock implements SimpleWaterloggedBlock
{ // Waterlogged from SlabBlock

    public enum FireLayStage
    {
        TINDER,
        STICK1,
        STICK2,
        STICK3,
        STICK4
    }
    public static final int MIN_STAGE = FireLayStage.TINDER.ordinal();
    public static final int MAX_STAGE = FireLayStage.STICK4.ordinal();
    public static final IntegerProperty STAGE_PROP = IntegerProperty.create("stage", MIN_STAGE, MAX_STAGE);

    protected final IBlockInteractWithStack completeWithStack;

    public FireLayBlock(Properties properties, IBlockInteractWithStack completeWithStack)
    {
        super(properties, false);
        registerDefaultState(getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(STAGE_PROP, MIN_STAGE));
        this.completeWithStack = completeWithStack;
    }

    //TODO because the blockitem obtains its name from the block; they are both thatch, i dont like that... need to seperate things

    //region State
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(WATERLOGGED)
                .add(STAGE_PROP);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return defaultBlockState()
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(STAGE_PROP, MIN_STAGE);
    }

    @Override
    public int getMinCount() { return MIN_STICKS; }
    @Override
    public int getMaxCount() { return MAX_STAGE; }
    @Override
    public IntegerProperty getCountProp() { return STAGE_PROP; }
    //endregion

    //region Interaction
    @Override
    protected boolean canUseItemStack(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        return stack.is(ItemTagCatalog.FIRE_LAY_STICK);
    }

    @Override
    public ItemStack pickUpItem(BlockState state, Level level, BlockPos pos) { return ItemStack.EMPTY; }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult)
    {
        if (pState.getValue(STAGE_PROP) == FireLayStage.STICK4.ordinal())
        {
            ItemInteractionResult result = completeWithStack.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
            if (result != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION)
            {
                return result;
            }
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }
    //endregion

    //region Sound
    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity)
    {
        if (state.getValue(STAGE_PROP) == FireLayStage.TINDER.ordinal())
        {
            return super.getSoundType(state, level, pos, entity);
        }
        return SoundType.WOOD;
    }
    //endregion

    //region Shape
    public static final VoxelShape TWIG_SHAPE1 = Block.box(6, 0, 6, 10, 2, 10);
    public static final VoxelShape TWIG_SHAPE2 = Block.box(4, 0, 4, 12, 2, 12);
    public static final VoxelShape TWIG_SHAPE3 = Block.box(4, 0, 4, 12, 2, 12);
    public static final VoxelShape TWIG_SHAPE4 = Block.box(4, 0, 4, 12, 4, 12);
    public static final VoxelShape TWIG_SHAPE5 = Block.box(4, 0, 4, 12, 4, 12);
    public static final VoxelShape[] FIRE_LAY_SHAPES = {
            TWIG_SHAPE1,
            TWIG_SHAPE2,
            TWIG_SHAPE3,
            TWIG_SHAPE4,
            TWIG_SHAPE5
    };

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return FIRE_LAY_SHAPES[pState.getValue(STAGE_PROP)];
    }
    //endregion

    //region Block Behaviour
    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos)
    { return 1.0f;  }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos)
    { return true; }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }
    //endregion

    //region Tick
    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (!pState.canSurvive(pLevel, pPos)) { pLevel.destroyBlock(pPos, true); }
    }
    //endregion
}
