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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class DryingBlockHorizontalAxis extends DryingBlock
{
    public DryingBlockHorizontalAxis(Properties props, VoxelShape shape, SoundType drySound, float baseDryingChance) {
        super(props, shape, drySound, baseDryingChance);
        registerDefaultState(getStateDefinition().any()
                .setValue(WarmthTools.IS_DRY, false)
                .setValue(AXIS, Direction.Axis.Z)
        );
    }

    //region State
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(WarmthTools.IS_DRY)
                .add(AXIS);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        ItemStack held = pContext.getItemInHand();
        if (held.getItem() instanceof DryingBlockItem dryingItem) {
            if (dryingItem.isDry()) {
                return defaultBlockState()
                        .setValue(WarmthTools.IS_DRY, true)
                        .setValue(AXIS, pContext.getHorizontalDirection().getAxis());
            }
        }
        return defaultBlockState()
                .setValue(AXIS, pContext.getHorizontalDirection().getAxis());
    }
    //endregion

    @SuppressWarnings("unused")
    public static class BasicDryingBlockHorizontalAxis extends DryingBlockHorizontalAxis
    {
        public BasicDryingBlockHorizontalAxis(Properties props)
        {
            super(props, Shapes.block(), SoundType.PACKED_MUD, 1.0f);
        }
    }
}
