package io.github.zephyrwolf.medievalism.common.item.blockitem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DryingBlockItem extends BlockItem
{
    public final boolean dry;

    public DryingBlockItem(Supplier<? extends Block> pBlock, Properties pProperties, boolean dry) {
        super(pBlock.get(), pProperties);
        this.dry = dry;
    }

    public boolean isDry() { return dry; }

    @Override
    public @NotNull String getDescriptionId()
    {
        return super.getDescriptionId() + (dry ? ".wet" : ".dry");
    }
}
