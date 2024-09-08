package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.content.block.BlockTagCatalog;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WildYamBlock extends WorldLitterBlock {

    public WildYamBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return WildYamBlock.box(0, 0, 0, 16, 16, 16);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT) && super.canSurvive(pState, pLevel, pPos);
    }
}
