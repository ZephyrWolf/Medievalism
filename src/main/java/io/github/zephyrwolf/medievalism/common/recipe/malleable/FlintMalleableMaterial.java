package io.github.zephyrwolf.medievalism.common.recipe.malleable;

import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import net.minecraft.world.item.ItemStack;

public class FlintMalleableMaterial extends MalleableMaterialType
{
    public FlintMalleableMaterial()
    {
        super(0xFF3D3C3C, 0xFF0E0E0E);
    }

    @Override
    public boolean requiresTool() {
        return true;
    }

    @Override
    public boolean validTool(ItemStack stack)
    {
        return !stack.isEmpty() && stack.is(ItemTagCatalog.FLINT_KNAP_TOOL);
    }

    @Override
    public boolean canToggle() {
        return false;
    }
}
