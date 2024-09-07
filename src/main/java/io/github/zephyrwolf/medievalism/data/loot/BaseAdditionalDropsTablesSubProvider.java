package io.github.zephyrwolf.medievalism.data.loot;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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

    private void getLootTables(HolderLookup.Provider ignoredLookupProvider)
    {
        ruinedDrop(BlockRegistration.WET_PACKED_MUD_BRICK.get(), ItemRegistration.MUD_BALL, 1, 1);

        ruinedDrop(BlockRegistration.DRYING_GATHERERS_JAR.get(), ItemRegistration.RED_CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_KEEPERS_CROCK.get(), ItemRegistration.RED_CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_SETTLERS_POT.get(), ItemRegistration.RED_CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), ItemRegistration.RED_CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_CLAY_CAULDRON.get(), ItemRegistration.RED_CLAY_BALL, 2, 4);
    }

    // --

    @SuppressWarnings("SameParameterValue")
    private void ruinedDrop(Block block, ItemLike itemLike, float min, float max)
    {
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation rl = MedievalismConstants.resource("ruined_" + key.getPath());
        add(rl,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(itemLike)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        )
                        )
        );
    }

    // --

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
