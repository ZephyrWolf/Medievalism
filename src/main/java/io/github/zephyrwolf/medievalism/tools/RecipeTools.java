package io.github.zephyrwolf.medievalism.tools;

import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public final class RecipeTools
{

    public static Criterion<InventoryChangeTrigger.TriggerInstance> itemPredicateOf(TagKey<Item> pTag)
    {
        return InventoryChangeTrigger.TriggerInstance.hasItems(
                ItemPredicate.Builder.item().of(
                        ItemTagCatalog.BRANCH
                ).build()
        );
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> itemPredicateOf(ItemLike... pItems)
    {
        return InventoryChangeTrigger.TriggerInstance.hasItems(pItems);
    }
}
