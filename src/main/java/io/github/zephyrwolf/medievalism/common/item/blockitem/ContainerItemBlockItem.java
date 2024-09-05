package io.github.zephyrwolf.medievalism.common.item.blockitem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ContainerItemBlockItem extends BlockItem {
    public ContainerItemBlockItem(Supplier<? extends Block> pBlock, Properties pProperties) {
        super(pBlock.get(), pProperties
                .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
        );
    }

    @Override
    public boolean canFitInsideContainerItems() { // Specifically items
        return false;
    }
}
