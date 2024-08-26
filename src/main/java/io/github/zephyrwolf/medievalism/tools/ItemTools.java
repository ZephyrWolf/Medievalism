package io.github.zephyrwolf.medievalism.tools;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public final class ItemTools
{
    public static int damageStack(ServerLevel level, ItemStack tool, int amt) {
        if (tool.isDamageableItem()) {
            amt = tool.getItem().damageItem(tool, amt, null, item -> {});
            if (amt > 0) {
                amt = EnchantmentHelper.processDurabilityChange(level, tool, amt);
            }
            if (amt <= 0) {
                return 0;
            }
            int damage = tool.getDamageValue() + amt;
            tool.setDamageValue(damage);
            if (damage >= tool.getMaxDamage()) {
                tool.shrink(1);
            }
            return amt;
        }
        else
        {
            return 0;
        }
    }

    public static int damageOrShrinkStack(ServerLevel level, ItemStack tool, int amt) {
        if (damageStack(level, tool, amt) == 0)
        {
            amt = Math.min(tool.getCount(), amt);
            tool.shrink(amt);
        }
        return amt;
    }
}
