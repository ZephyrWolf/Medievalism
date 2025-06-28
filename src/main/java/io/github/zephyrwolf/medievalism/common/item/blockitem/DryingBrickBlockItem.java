package io.github.zephyrwolf.medievalism.common.item.blockitem;

import io.github.zephyrwolf.medievalism.common.block.DryingBrick;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
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
            Player player = pContext.getPlayer();
            Level level = pContext.getLevel();
            BlockPos pos = pContext.getClickedPos();
            ItemStack stack = pContext.getItemInHand();
            BlockState state = pContext.getLevel().getBlockState(pContext.getClickedPos());
            if (state.getBlock() == getBlock() && state.getBlock() instanceof DryingBrick)
            {
                ItemInteractionResult result = ((DryingBrick) state.getBlock())
                        .useItemOnNext(pContext.getItemInHand(), state, pContext.getLevel(), pContext.getClickedPos());
                if (result == ItemInteractionResult.SUCCESS)
                {
                    if (player != null)
                    {
                        if (player instanceof ServerPlayer)
                        {
                            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, pos, stack);
                        }
                        SoundType soundtype = state.getSoundType(level, pos, player);
                        level.playSound(
                                player,
                                pos,
                                this.getPlaceSound(state, level, pos, player),
                                SoundSource.BLOCKS,
                                (soundtype.getVolume() + 1.0F) / 2.0F,
                                soundtype.getPitch() * 0.8F
                        );
                        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, state));
                        stack.consume(1, player);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }
        return super.place(pContext);
    }
}
