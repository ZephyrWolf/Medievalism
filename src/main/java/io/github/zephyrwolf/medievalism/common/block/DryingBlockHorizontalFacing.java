package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.common.blockitem.DryingBlockItem;
import io.github.zephyrwolf.medievalism.tools.WarmthTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class DryingBlockHorizontalFacing extends DryingBlock
{
    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;

    public DryingBlockHorizontalFacing(Properties props, VoxelShape shape, SoundType drySound, float baseDryingChance) {
        super(props, shape, drySound, baseDryingChance);
        registerDefaultState(getStateDefinition().any()
                .setValue(WarmthTools.IS_DRY, false)
                .setValue(DIRECTION, Direction.NORTH)
        );
    }

    //region State
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(WarmthTools.IS_DRY)
                .add(DIRECTION);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        ItemStack held = pContext.getItemInHand();
        if (held.getItem() instanceof DryingBlockItem dryingItem) {
            if (dryingItem.isDry()) {
                return defaultBlockState()
                        .setValue(WarmthTools.IS_DRY, true)
                        .setValue(DIRECTION, pContext.getHorizontalDirection());
            }
        }
        return defaultBlockState()
                .setValue(DIRECTION, pContext.getHorizontalDirection());
    }
    //endregion

    @SuppressWarnings("unused")
    public static class BasicDryingBlockHorizontalFacing extends DryingBlockHorizontalFacing
    {
        public BasicDryingBlockHorizontalFacing(Properties props) { super(props, Shapes.block(), SoundType.PACKED_MUD, 1.0f); }
    }
}
