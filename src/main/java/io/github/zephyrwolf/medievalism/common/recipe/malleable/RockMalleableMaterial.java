package io.github.zephyrwolf.medievalism.common.recipe.malleable;

import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import net.minecraft.world.item.ItemStack;

public class RockMalleableMaterial extends MalleableMaterialType
{
    public RockMalleableMaterial()
    {
        super(0xFFB0B0B0, 0xFF303030);
    }
    public RockMalleableMaterial(int positive, int negative)
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
        return !stack.isEmpty() && stack.is(ItemTagCatalog.KNAP_TOOL);
    }

    @Override
    public boolean canToggle() {
        return false;
    }
}
