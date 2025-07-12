package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
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
import net.minecraft.world.item.Items;
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
    public static final int MIN_STAGE = 1;
    public static final int MAX_STAGE = FireLayStage.STICK4.ordinal() + 1;
    public static final IntegerProperty STAGE_PROP = IntegerProperty.create("stage", MIN_STAGE, MAX_STAGE);

    public FireLayBlock(Properties properties)
    {
        super(properties, true);
        registerDefaultState(getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(STAGE_PROP, MIN_STAGE));
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
        return stack.getItem() == Items.STICK;
    }

    @Override
    public ItemStack pickUpItem(BlockState state, Level level, BlockPos pos)
    {
        if (state.getValue(STAGE_PROP) == FireLayStage.TINDER.ordinal() + 1)
        {
            return new ItemStack(BlockItemRegistration.THATCH.get());
        }
        return new ItemStack(Items.STICK);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player)
    {
        return new ItemStack(BlockItemRegistration.THATCH.get()); // Let's return the starting item
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult)
    {
        if (pState.getValue(STAGE_PROP) == FireLayStage.STICK4.ordinal() + 1 && pStack.getItem() == ItemRegistration.FIRE_STARTER.get())
        {
            pLevel.setBlockAndUpdate(pPos, Blocks.CAMPFIRE.defaultBlockState());
            pStack.setDamageValue(pStack.getDamageValue() + 1);
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }
    //endregion

    //region Sound
    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity)
    {
        if (state.getValue(STAGE_PROP) == FireLayStage.TINDER.ordinal() + 1)
        {
            return super.getSoundType(state, level, pos, entity);
        }
        return SoundType.WOOD;
    }
    //endregion

    //region Shape
    public static final VoxelShape TWIG_SHAPE = Block.box(3, 0, 3, 13, 4, 13);

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
