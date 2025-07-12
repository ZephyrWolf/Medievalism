package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.client.item.RockBlockItemClientExtension;
import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class RockBlockItem extends BlockItem
{
    public static final int KNAP_DURATION = 40;

    public RockBlockItem(Block pBlock, Properties pProperties)
    {
        super(pBlock, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        if (pStack.is(ItemTagCatalog.HARD_ROCK))
        {
            pTooltipComponents.add(Component.translatable("medievalism.tooltip.hard_rock.can_knap").withStyle(ChatFormatting.GRAY));
        }
    }

}
