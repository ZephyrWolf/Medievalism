package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class IncrementBlock extends Block implements SimpleWaterloggedBlock
{ // Waterlogged from SlabBlock
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected boolean canRemove;

    public IncrementBlock(Properties properties, boolean remove)
    {
        super(properties);
        canRemove = remove;
        assert getMinCount() < getMaxCount();
    }


    public abstract int getMinCount();
    public abstract int getMaxCount();
    public abstract IntegerProperty getCountProp();
    public abstract ItemStack pickUpItem(BlockState state, Level level, BlockPos pos);

    //region interaction
    protected abstract boolean canUseItemStack(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult);

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult)
    {
        int numCount = pState.getValue(getCountProp());

        if (canUseItemStack(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult))
        {
            if (numCount < getMaxCount())
            {
                BlockState newState = pState.setValue(getCountProp(), numCount + 1);
                pLevel.setBlockAndUpdate(pPos, newState);
                if (pPlayer instanceof ServerPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)pPlayer, pPos, pStack);
                }
                SoundType soundtype = newState.getSoundType(pLevel, pPos, pPlayer);
                pLevel.playSound(
                        pPlayer,
                        pPos,
                        newState.getSoundType(pLevel, pPos, pPlayer).getPlaceSound(),
                        SoundSource.BLOCKS,
                        (soundtype.getVolume() + 1.0F) / 2.0F,
                        soundtype.getPitch() * 0.8F
                );
                pLevel.gameEvent(GameEvent.BLOCK_PLACE, pPos, GameEvent.Context.of(pPlayer, newState));
                pStack.consume(1, pPlayer);
                return ItemInteractionResult.CONSUME_PARTIAL;
            }

        }
        else if (canRemove && pStack.isEmpty())
        {
            ItemStack pickupItem = pickUpItem(pState, pLevel, pPos); // This needs to run before the block set
            BlockState newState;
            if (numCount == 1)
                newState = pState.getValue(WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
            else newState = pState.setValue(getCountProp(), numCount - 1);
            pLevel.setBlockAndUpdate(pPos, newState);
            pLevel.playSound(
                    pPlayer,
                    pPlayer.blockPosition(), // or wherever you want
                    SoundEvents.ITEM_PICKUP,
                    SoundSource.PLAYERS,     // this is the category used for player-centric sounds
                    0.2F,                    // volume
                    (pLevel.getRandom().nextFloat() - pLevel.getRandom().nextFloat()) * 0.7F + 1.0F // pitch variation like vanilla
            );
            pLevel.gameEvent(GameEvent.BLOCK_PLACE, pPos, GameEvent.Context.of(pPlayer, newState));
            pPlayer.addItem(pickupItem);
            return ItemInteractionResult.CONSUME_PARTIAL;
        }
        return ItemInteractionResult.SUCCESS;
    }
    //endregion

    //region Block Behaviour
    @Override
    protected boolean isPathfindable(@NotNull BlockState pState, @NotNull PathComputationType pPathComputationType) {
        return hasCollision || pState.getFluidState().is(FluidTags.WATER); // SlabBlock
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }
    //endregion

    //region Tick
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
    //endregion
}
