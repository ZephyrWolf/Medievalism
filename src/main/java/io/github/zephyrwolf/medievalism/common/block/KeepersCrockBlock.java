package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.common.block.blockentity.HasInventory;
import io.github.zephyrwolf.medievalism.common.block.blockentity.KeepersCrockBlockEntity;
import io.github.zephyrwolf.medievalism.content.block.BlockEntityRegistration;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
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
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
// net.minecraft.world.level.block.ShulkerBoxBlock
public class KeepersCrockBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    //region Constants
    public static final MapCodec<KeepersCrockBlock> CODEC = simpleCodec(KeepersCrockBlock::new);

    public static final VoxelShape KEEPERS_CROCK_SHAPE = Block.box(2, 0, 2, 14, 12, 14);

    public static final String LANG_DEFAULT_NAME = "medievalism.container.keepers_crock";
    public static final String LANG_ITEM_COUNT = "medievalism.container.keepers_crock.item_count";
    public static final String LANG_MORE = "medievalism.container.keepers_crock.more";

    public static final ResourceLocation CONTENTS = ResourceLocation.withDefaultNamespace("contents");
    //endregion

    //region Boilerplate
    public KeepersCrockBlock(Properties properties) {
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
        return KEEPERS_CROCK_SHAPE;
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
        } else if (pLevel.getBlockEntity(pPos) instanceof KeepersCrockBlockEntity blockEntity) {
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
        BlockEntity be = pParams.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof HasInventory invProvider) {
            pParams = pParams.withDynamicDrop(CONTENTS, consumer -> {
                for (int i = 0; i < invProvider.getInventory().getSlots(); i++) {
                    var stack = invProvider.getInventory().getStackInSlot(i);
                    consumer.accept(stack);
                }
            });
        }
        return super.getDrops(pState, pParams);
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof KeepersCrockBlockEntity) {
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
        pLevel.getBlockEntity(pPos, BlockEntityRegistration.KEEPERS_CROCK_BLOCK_ENTITY_TYPE.get())
                .ifPresent(blockEntity -> blockEntity.saveToItem(itemstack, pLevel.registryAccess()));
        return itemstack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        int i = 0;
        int j = 0;

        for (ItemStack itemstack : pStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems()) {
            j++;
            if (i <= 4) {
                i++;
                pTooltipComponents.add(Component.translatable(LANG_ITEM_COUNT, itemstack.getHoverName(), itemstack.getCount()));
            }
        }

        if (j - i > 0) {
            pTooltipComponents.add(Component.translatable(LANG_MORE, j - i).withStyle(ChatFormatting.ITALIC));
        }
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
        if (pLevel.getBlockEntity(pPos) instanceof KeepersCrockBlockEntity blockEntity) {
            float f = 0.0F;
            ItemStackHandler inventory = blockEntity.getInventory();
            int inventorySize = inventory.getSlots();
            for (int slot = 0; slot < inventorySize; slot++) {
                ItemStack itemstack = inventory.getStackInSlot(slot);
                if (!itemstack.isEmpty()) {
                    f += (float) itemstack.getCount() / Math.min(itemstack.getMaxStackSize(), inventory.getSlotLimit(slot));
                }
            }
            f /= (float) inventorySize;
            return Mth.lerpDiscrete(f, 0, 15);
        }
        return 0;
    }
    //endregion

    //region Entity
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new KeepersCrockBlockEntity(pPos, pState);
    }
    //endregion

    public static class DryingKeepersCrockBlock extends DryingBlock
    {
        public DryingKeepersCrockBlock(Properties props) {
            super(props, KEEPERS_CROCK_SHAPE);
        }
    }
}
