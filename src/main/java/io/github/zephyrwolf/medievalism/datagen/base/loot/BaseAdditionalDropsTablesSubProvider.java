package io.github.zephyrwolf.medievalism.datagen.base.loot;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.MudWorkingItemRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
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
        ruinedDrop(BlockRegistration.DRYING_PACKED_MUD_BRICK.get(), MudWorkingItemRegistration.MUD_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_DAUB_BRICK.get(), MudWorkingItemRegistration.WET_DAUB, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_CLAY_BRICK.get(), Items.CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_CHINA_CLAY_BRICK.get(), ClayWorkingItemRegistration.CHINA_CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), ClayWorkingItemRegistration.POTTERS_CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), ClayWorkingItemRegistration.KAOLIN_CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), Items.CLAY_BALL, 1, 2);
        ruinedDrop(BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.CHINA_CLAY_BALL, 1, 2);
        ruinedDrop(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.POTTERS_CLAY_BALL, 1, 2);
        ruinedDrop(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.KAOLIN_CLAY_BALL, 1, 2);
        ruinedDrop(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL, 1, 2);

        alternateDrop(BlockRegistration.DRYING_PACKED_MUD_BRICK.get(), MudWorkingItemRegistration.PACKED_MUD_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_DAUB_BRICK.get(), MudWorkingItemRegistration.DAUB_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_CLAY_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_CLAY_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_CHINA_CLAY_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_CHINA_CLAY_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_CHINA_CLAY_DOUBLE_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK, 1, 1);
        alternateDrop(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK, 1, 1);

        ruinedDrop(BlockRegistration.DRYING_GATHERERS_JAR.get(),        Items.CLAY_BALL, 1, 1);
        ruinedDrop(BlockRegistration.DRYING_KEEPERS_CROCK.get(),        Items.CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_SETTLERS_POT.get(),         Items.CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_CLAY_COOKING_POT.get(),     Items.CLAY_BALL, 2, 4);
        //ruinedDrop(BlockRegistration.DRYING_JUG.get(),                  Items.CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_FLOWER_POT.get(),           Items.CLAY_BALL, 2, 4);
        ruinedDrop(BlockRegistration.DRYING_DECORATED_POT.get(),        Items.CLAY_BALL, 2, 4);
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

    @SuppressWarnings("SameParameterValue")
    private void alternateDrop(Block block, ItemLike itemLike, float min, float max)
    {
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation rl = MedievalismConstants.resource("alternate_" + key.getPath());
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
