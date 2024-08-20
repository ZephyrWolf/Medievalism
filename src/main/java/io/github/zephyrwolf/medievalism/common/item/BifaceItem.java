package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.Registration;
import io.github.zephyrwolf.medievalism.common.block.ModBlockTags;
import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BifaceItem extends Item
{
    public BifaceItem(Properties pProperties)
    {
        super(pProperties);
    }

    public static Tool createToolProperties() {
        return new Tool(
                List.of(
                        //Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F),
                        //Tool.Rule.overrideSpeed(BlockTags.LEAVES, 15.0F),
                        //Tool.Rule.overrideSpeed(BlockTags.WOOL, 5.0F),
                        //Tool.Rule.overrideSpeed(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 2.0F)
                ),
                1.0F,
                1
        );
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pMiningEntity)
    {
        boolean val = super.mineBlock(pStack, pLevel, pState, pPos, pMiningEntity);
        if (val && !pLevel.isClientSide)
        {
            if (pState.is(ModBlockTags.CAN_DROP_THATCH))
            {
//                if (pMiningEntity instanceof Player player)
//                {
//                    PlayerEntity player = (PlayerEntity) entity;
//                //			player.addExhaustion( 0.005f);
//                //			player.addStat( Stats.ITEM_USED.get( held.getItem() ) );
//                //			if (success)
//                //			{
//                //				player.addStat( Stats.ITEM_CRAFTED.get( Registration.THATCH.get() ) );
//                //			}
//                }
                if (pLevel.getRandom().nextFloat() < 0.5f)
                {
                    pLevel.addFreshEntity(new ItemEntity(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), new ItemStack(Registration.THATCH.get())));
                }
            }
        }
        return val;
    }
}
