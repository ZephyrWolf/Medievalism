package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class VanillaDeferredItem<T extends Item> extends DeferredItem<T>
{
    public VanillaDeferredItem(Item item)
    {
        super(item.builtInRegistryHolder().key());
    }
}
