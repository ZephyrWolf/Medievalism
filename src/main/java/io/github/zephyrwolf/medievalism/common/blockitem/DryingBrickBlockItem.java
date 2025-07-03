package io.github.zephyrwolf.medievalism.common.blockitem;

import io.github.zephyrwolf.medievalism.common.block.DryingBrick;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DryingBrickBlockItem extends BlockItem
{
    public DryingBrickBlockItem(Block pBlock, Properties pProperties)
    {
        super(pBlock, pProperties);
    }

    @Override
    public @NotNull InteractionResult place(BlockPlaceContext pContext) {
        if (!this.getBlock().isEnabled(pContext.getLevel().enabledFeatures()))
        {
            return InteractionResult.FAIL;
        }
        else
        {
            BlockState state = pContext.getLevel().getBlockState(pContext.getClickedPos());
            if (state.getBlock() == this.getBlock() && state.getBlock().asItem() == pContext.getItemInHand().getItem() && state.getBlock() instanceof DryingBrick) {
                ItemInteractionResult result = ((DryingBrick) state.getBlock())
                        .tryPlaceAdditionalBrick(pContext.getItemInHand(), state, pContext.getLevel(), pContext.getClickedPos(), pContext.getPlayer());
                if (result == ItemInteractionResult.SUCCESS) {
                    return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide);
                }
            }
        }
        return super.place(pContext);
    }
}
