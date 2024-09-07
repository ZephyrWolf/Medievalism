package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.common.block.blockentity.HasInventory;
import io.github.zephyrwolf.medievalism.common.block.blockentity.SettlersPotBlockEntity;
import io.github.zephyrwolf.medievalism.content.block.BlockEntityRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
// net.minecraft.world.level.block.ShulkerBoxBlock
public class SettlersPotBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    //region Constants
    public static final MapCodec<SettlersPotBlock> CODEC = simpleCodec(SettlersPotBlock::new);

    public static final VoxelShape SETTLERS_POT_SHAPE = Block.box(1, 0, 1, 15, 16, 15);

    public static final String LANG_DEFAULT_NAME = "medievalism.container.settlers_pot";

    public static final ResourceLocation CONTENTS = ResourceLocation.withDefaultNamespace("contents");
    //endregion

    //region Boilerplate
    public SettlersPotBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any()
                .setValue(BlockStateProperties.WATERLOGGED, false)
                .setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
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
        return SETTLERS_POT_SHAPE;
    }
    //endregion

    // region BlockStates
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(BlockStateProperties.WATERLOGGED)
                .add(BlockStateProperties.HORIZONTAL_AXIS)
        ;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return defaultBlockState()
                .setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(BlockStateProperties.HORIZONTAL_AXIS, pContext.getHorizontalDirection().getAxis());
    }

    @SuppressWarnings("deprecation")
    @Override
    protected BlockState rotate(BlockState pState, Rotation pRotation) {
        Direction.Axis axis = pState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        axis = switch (axis) {
            case Direction.Axis.X -> Direction.Axis.Z;
            case Direction.Axis.Z -> Direction.Axis.X;
            default -> axis;
        };
        return pState.setValue(BlockStateProperties.HORIZONTAL_AXIS, axis);
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

    //region Block Events
    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pState.getFluidState().is(Fluids.WATER)) {
            return InteractionResult.FAIL;
        } else if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else if (pPlayer.isSpectator()) {
            return InteractionResult.CONSUME;
        } else if (pLevel.getBlockEntity(pPos) instanceof SettlersPotBlockEntity blockEntity) {
            pPlayer.openMenu(blockEntity, pPos);
            //pPlayer.awardStat(Stats.OPEN_SHULKER_BOX);
            PiglinAi.angerNearbyPiglins(pPlayer, true);

            return InteractionResult.CONSUME;
        } else {
            return InteractionResult.PASS;
        }
        // return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Override
    protected List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        var items = super.getDrops(pState, pParams);
        BlockEntity be = pParams.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof HasInventory invProvider) {
            items.addAll(invProvider.getInventoryAsList());
        }
        return items;
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof SettlersPotBlockEntity) {
                //entity.dropInventory();
                pLevel.updateNeighbourForOutputSignal(pPos, pState.getBlock());
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
    //endregion

    //region Item Properties
    @SuppressWarnings("deprecation")
    @Override
    public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        ItemStack itemstack = super.getCloneItemStack(pLevel, pPos, pState);
        pLevel.getBlockEntity(pPos, BlockEntityRegistration.SETTLERS_POT_BLOCK_ENTITY_TYPE.get())
                .ifPresent(blockEntity -> blockEntity.saveToItem(itemstack, pLevel.registryAccess()));
        return itemstack;
    }
    //endregion

    //region Redstone
    @SuppressWarnings("deprecation")
    @Override
    protected boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        if (pLevel.getBlockEntity(pPos) instanceof HasInventory invProvider) {
            return invProvider.getAnalogueSignal(pLevel, pPos);
        }
        return 0;
    }
    //endregion

    //region Entity
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SettlersPotBlockEntity(pPos, pState);
    }
    //endregion

    public static class DryingSettlersPotBlock extends DryingBlock
    {
        public DryingSettlersPotBlock(Properties props) {
            super(props, SETTLERS_POT_SHAPE);
        }
    }
}
