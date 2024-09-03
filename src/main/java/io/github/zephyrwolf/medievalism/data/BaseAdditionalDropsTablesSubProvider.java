package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public final class BaseAdditionalDropsTablesSubProvider implements LootTableSubProvider
{
    private final Map<ResourceLocation, LootTable.Builder> map = new HashMap<>();

    private final HolderLookup.Provider lookupProvider;

    public BaseAdditionalDropsTablesSubProvider(HolderLookup.Provider lookupProvider)
    {
        this.lookupProvider = lookupProvider;
    }

    // THIS IS WHERE YOU CAN ADD YOU ADDITIONAL DROPS FOR BLOCKS
    private void getLootTables(HolderLookup.Provider ignoredLookupProvider)
    {
        add(MedievalismConstants.resource("ruined_gatherers_pot"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.RED_CLAY_BALL)
                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                        )
                        )
        );
    }

    private void add(ResourceLocation location, LootTable.Builder builder)
    {
        if (map.containsKey(location))
        {
            throw new IllegalStateException(String.format("Encountered a duplicate loot table '%s'", location.toString()));
        }
        map.put(location, builder.setRandomSequence(location));
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer)
    {
        getLootTables(lookupProvider);
        Set<ResourceLocation> locations = map.keySet();
        for (ResourceLocation location : locations)
        {
            ResourceKey<LootTable> resourceKey = ResourceKey.create(Registries.LOOT_TABLE, location.withPrefix("additional_drops/"));
            LootTable.Builder builder = map.getOrDefault(location, null);
            if (builder == null)
            {
                throw new IllegalStateException(String.format("Missing loot table for '%s'", location));
            }
            consumer.accept(resourceKey, builder);
        }
    }
}
