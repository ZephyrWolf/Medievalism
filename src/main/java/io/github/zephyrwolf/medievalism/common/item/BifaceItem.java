package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.catalogs.item.itemability.ItemAbilityCatalog;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.neoforged.neoforge.common.ItemAbility;

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
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility)
    {
        return itemAbility == ItemAbilityCatalog.KNIFE_DIG;
    }
}
