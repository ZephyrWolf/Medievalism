package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.catalogs.tag.BlockTagCatalog;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SickleItem extends SwordItem
{
    public SickleItem(Tier pTier, Properties pProperties)
    {
        super(pTier, pProperties.component(DataComponents.TOOL, createToolProperties()));
    }

    public static Tool createToolProperties()
    {
        return new Tool(List.of(
                Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F),
                Tool.Rule.overrideSpeed(BlockTagCatalog.SICKLE_EFFICIENT, 1.5F)
        ), 1.0F, 2);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility itemAbility)
    {
        return ItemAbilityCatalog.DEFAULT_SICKLE_ACTIONS.contains(itemAbility);
    }
}
