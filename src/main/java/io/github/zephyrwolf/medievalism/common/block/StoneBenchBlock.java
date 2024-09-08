package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.common.block.blockentity.StoneBenchBlockEntity;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneBenchBlock extends BaseEntityBlock {
    public static final ResourceLocation CONTENTS = ResourceLocation.withDefaultNamespace("contents");

    public static final VoxelShape STONE_BENCH_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);

    public static final MapCodec<StoneBenchBlock> CODEC = simpleCodec(StoneBenchBlock::new);

    public StoneBenchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<StoneBenchBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return STONE_BENCH_SHAPE;
    }

    @SuppressWarnings("deprecation")
    @Override // Set to RenderShape.Invisible by BaseEntityBlock
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new StoneBenchBlockEntity(pPos, pState);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        BlockEntity be = pParams.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof StoneBenchBlockEntity sbbe) {
            pParams = pParams.withDynamicDrop(CONTENTS, consumer -> {
                for (int i = 0; i < sbbe.getInventory().getSlots(); i++) {
                    var stack = sbbe.getInventory().getStackInSlot(i);
                    consumer.accept(stack);
                }
            });
        }
        return super.getDrops(pState, pParams);
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof StoneBenchBlockEntity entity) {
                //entity.dropInventory();
                pLevel.updateNeighbourForOutputSignal(pPos, pState.getBlock());
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof StoneBenchBlockEntity entity) {
                pPlayer.openMenu(entity, pPos);
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
