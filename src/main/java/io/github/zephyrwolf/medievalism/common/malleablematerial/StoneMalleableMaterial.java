package io.github.zephyrwolf.medievalism.common.malleablematerial;

import io.github.zephyrwolf.medievalism.content.ItemTagCatalog;
import net.minecraft.world.item.ItemStack;

public class StoneMalleableMaterial extends MalleableMaterialType
{
    public StoneMalleableMaterial()
    {
        super(0xFFB0B0B0, 0xFF303030);
    }

    @Override
    public boolean requiresTool() {
        return true;
    }

    @Override
    public boolean validTool(ItemStack stack)
    {
        return !stack.isEmpty() && stack.is(ItemTagCatalog.HAMMER);
    }

    @Override
    public boolean canToggle() {
        return false;
    }
}
