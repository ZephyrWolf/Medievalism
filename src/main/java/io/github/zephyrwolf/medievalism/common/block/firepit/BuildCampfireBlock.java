package io.github.zephyrwolf.medievalism.common.block.firepit;

import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.block.IncrementBlock;
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
public class BuildCampfireBlock extends IncrementBlock implements SimpleWaterloggedBlock
{ // Waterlogged from SlabBlock

    public enum BuildCampfireStage
    {
        CHOPPED_WOOD1,
        CHOPPED_WOOD2,
        CHOPPED_WOOD3,
        CHOPPED_WOOD4
    }
    public static final int MIN_STAGE = BuildCampfireStage.CHOPPED_WOOD1.ordinal();
    public static final int MAX_STAGE = BuildCampfireStage.CHOPPED_WOOD4.ordinal();
    public static final IntegerProperty STAGE_PROP = IntegerProperty.create("stage", MIN_STAGE, MAX_STAGE);

    protected final IBlockInteractWithStack completeWithStack;

    //TODO because the BlockItem obtains its name from the block; they are both thatch, i don't like that... need to separate things

    public BuildCampfireBlock(Properties properties, IBlockInteractWithStack completeWithStack)
    {
        super(properties, false);
        registerDefaultState(getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(STAGE_PROP, MIN_STAGE));
        this.completeWithStack = completeWithStack;
    }

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
    public static boolean canUseItemStack(ItemStack stack)
    {
        return stack.is(ItemTagCatalog.BUILD_CAMPFIRE_CHOPPED_WOOD);
    }

    @Override
    protected boolean canUseItemStack(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        return canUseItemStack(stack);
    }

    @Override
    public ItemStack pickUpItem(BlockState state, Level level, BlockPos pos) { return ItemStack.EMPTY; }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player)
    {
        return new ItemStack(Items.CAMPFIRE);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult)
    {
        if (pState.getValue(STAGE_PROP) == BuildCampfireStage.CHOPPED_WOOD4.ordinal())
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
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) { return SoundType.WOOD; }
    //endregion

    //region Shape
    public static final VoxelShape BUILD_CAMPFIRE_SHAPE1 = Block.box(3, 0, 3, 13, 4, 13);
    public static final VoxelShape BUILD_CAMPFIRE_SHAPE2 = Block.box(3, 0, 3, 13, 4, 13);
    public static final VoxelShape BUILD_CAMPFIRE_SHAPE3 = Block.box(3, 0, 3, 13, 4, 13);
    public static final VoxelShape BUILD_CAMPFIRE_SHAPE4 = Block.box(3, 0, 3, 13, 4, 13);
    public static final VoxelShape BUILD_CAMPFIRE_SHAPE5 = Block.box(3, 0, 3, 13, 4, 13);
    public static final VoxelShape[] BUILD_CAMPFIRE_SHAPES = {
            BUILD_CAMPFIRE_SHAPE1,
            BUILD_CAMPFIRE_SHAPE2,
            BUILD_CAMPFIRE_SHAPE3,
            BUILD_CAMPFIRE_SHAPE4,
            BUILD_CAMPFIRE_SHAPE5
    };

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return BUILD_CAMPFIRE_SHAPES[pState.getValue(STAGE_PROP)];
    }
    //endregion

    //region Block Behaviour
    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos)
    { return 1.0f; }

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
