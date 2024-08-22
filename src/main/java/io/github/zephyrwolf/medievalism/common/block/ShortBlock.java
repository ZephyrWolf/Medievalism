package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShortBlock extends Block
{
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);

    public ShortBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) { return SHAPE; }
}