package io.github.zephyrwolf.medievalism.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DryingBlockItem extends BlockItem
{
    public final boolean isDry;

    public DryingBlockItem(Supplier<? extends Block> pBlock, Properties pProperties, boolean isDry) {
        super(pBlock.get(), pProperties);
        this.isDry = isDry;
    }

    public boolean isDry() { return isDry; }

    @Override
    public @NotNull String getDescriptionId()
    {
        return super.getDescriptionId() + (!isDry ? ".wet" : ".dry");
    }
}
