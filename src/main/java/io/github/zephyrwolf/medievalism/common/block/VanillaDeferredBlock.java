package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class VanillaDeferredBlock<T extends Block> extends DeferredBlock<T>
{
    public VanillaDeferredBlock(Block block)
    {
        super(block.builtInRegistryHolder().key());
    }
}

