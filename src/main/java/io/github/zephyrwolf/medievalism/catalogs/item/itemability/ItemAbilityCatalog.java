package io.github.zephyrwolf.medievalism.catalogs.item.itemability;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.Set;

public final class ItemAbilityCatalog
{
    public static final ItemAbility KNIFE_DIG = ItemAbility.get("KNIFE_DIG");
    public static final ItemAbility KNIFE_CARVE = ItemAbility.get("KNIFE_CARVE");
    public static final Set<ItemAbility> DEFAULT_KNIFE_ACTIONS = Set.of(KNIFE_DIG, KNIFE_CARVE);

    public static final ItemAbility SICKLE_DIG = ItemAbility.get("SICKLE_DIG");
    public static final Set<ItemAbility> DEFAULT_SICKLE_ACTIONS = Set.of(SICKLE_DIG);

    public static final ItemAbility SPEAR_THROW = ItemAbilities.TRIDENT_THROW;
    public static final Set<ItemAbility> DEFAULT_SPEAR_ACTIONS = Set.of(SPEAR_THROW);
}
