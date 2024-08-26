package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.common.blockentity.StoneBenchBlockEntity;
import io.github.zephyrwolf.medievalism.content.BlockEntityRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneBenchBlock extends BaseEntityBlock
{
    public static final MapCodec<StoneBenchBlock> CODEC = simpleCodec(StoneBenchBlock::new);

    public StoneBenchBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public MapCodec<StoneBenchBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) { return ShortBlock.SHAPE; }

    @SuppressWarnings("deprecation")
    @Override // Set to RenderShape.Invisible by BaseEntityBlock
    protected RenderShape getRenderShape(BlockState pState) { return RenderShape.MODEL; }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return new StoneBenchBlockEntity(pPos, pState);
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston)
    {
        if (pState.getBlock() != pNewState.getBlock())
        {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof StoneBenchBlockEntity entity)
            {
                entity.dropInventory();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult)
    {
        if (!pLevel.isClientSide())
        {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof StoneBenchBlockEntity entity)
            {
                ((ServerPlayer) pPlayer).openMenu(entity, pPos);
            }
            else
            {
                throw new IllegalStateException("Menu provider is missing!");
            }
        }
        //return InteractionResult.SUCCESS_NO_ITEM_USED;
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    /*
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType)
    {
        if (pLevel.isClientSide()) { return null; }
        return createTickerHelper(pBlockEntityType, BlockEntityRegistration.STONE_BENCH_BLOCK_ENTITY_TYPE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
    */
}
