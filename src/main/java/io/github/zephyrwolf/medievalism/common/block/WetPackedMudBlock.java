package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class WetPackedMudBlock extends Block
{
    public static final MapCodec<WetPackedMudBlock> CODEC = simpleCodec(WetPackedMudBlock::new);

    @Override
    public @NotNull MapCodec<WetPackedMudBlock> codec() {
        return CODEC;
    }

    public WetPackedMudBlock(BlockBehaviour.Properties props) {
        super(props);
    }
}
