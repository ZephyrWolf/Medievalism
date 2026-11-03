package io.github.zephyrwolf.medievalism.common.item;

import net.neoforged.neoforge.common.ItemAbility;

import java.util.Set;

public final class ItemAbilityCatalog
{
    public static final ItemAbility KNIFE_DIG = ItemAbility.get("KNIFE_DIG");

    public static final Set<ItemAbility> DEFAULT_KNIFE_ACTIONS = Set.of(KNIFE_DIG);

}
