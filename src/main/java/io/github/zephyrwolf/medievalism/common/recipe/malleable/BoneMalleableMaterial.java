package io.github.zephyrwolf.medievalism.common.recipe.malleable;

import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import net.minecraft.world.item.ItemStack;

public class BoneMalleableMaterial extends MalleableMaterialType
{
    public BoneMalleableMaterial()
    {
        super(0xFFEFECDA, 0xFF7B7E6B);
    }
    public BoneMalleableMaterial(int positive, int negative)
    {
        super(positive, negative);
    }

    @Override
    public boolean requiresTool() {
        return true;
    }

    @Override
    public boolean validTool(ItemStack stack)
    {
        return !stack.isEmpty() && stack.is(ItemTagCatalog.CARVING_TOOL);
    }

    @Override
    public boolean canToggle() {
        return false;
    }
}
