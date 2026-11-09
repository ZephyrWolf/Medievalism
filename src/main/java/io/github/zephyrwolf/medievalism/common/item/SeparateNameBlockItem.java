package io.github.zephyrwolf.medievalism.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class SeparateNameBlockItem extends BlockItem
{
    public SeparateNameBlockItem(Block pBlock, Properties pProperties)
    {
        super(pBlock, pProperties);
    }

    @Override
    public @NotNull String getDescriptionId()
    {
        return super.getOrCreateDescriptionId();
    }
}
