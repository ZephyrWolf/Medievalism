package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.content.ItemRegistration;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiConsumer;

public final class OverhaulMobLootTablesSubProvider implements LootTableSubProvider
{
    private final Map<ResourceLocation, LootTable.Builder> map = new HashMap<>();

    private final HolderLookup.Provider lookupProvider;

    public OverhaulMobLootTablesSubProvider(HolderLookup.Provider lookupProvider)
    {
        this.lookupProvider = lookupProvider;
    }

    private AnyOfCondition.Builder shouldSmeltLoot(HolderLookup.Provider lookupProvider)
    {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = lookupProvider.lookupOrThrow(Registries.ENCHANTMENT);
        return AnyOfCondition.anyOf(
                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true))
                ),
                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.DIRECT_ATTACKER,
                        EntityPredicate.Builder.entity()
                                .equipment(
                                        EntityEquipmentPredicate.Builder.equipment()
                                                .mainhand(
                                                        ItemPredicate.Builder.item()
                                                                .withSubPredicate(
                                                                        ItemSubPredicates.ENCHANTMENTS,
                                                                        ItemEnchantmentsPredicate.enchantments(
                                                                                List.of(new EnchantmentPredicate(registrylookup.getOrThrow(EnchantmentTags.SMELTS_LOOT), MinMaxBounds.Ints.ANY))
                                                                        )
                                                                )
                                                )
                                )
                )
        );
    }

    private void getLootTables(HolderLookup.Provider lookupProvider)
    {
        getVanillaLoot(lookupProvider);
    }

    private void getVanillaLoot(HolderLookup.Provider lookupProvider)
    {
        // Bat
        add(ResourceLocation.withDefaultNamespace("bat"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(0.75f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.BAT_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Camel
        add(ResourceLocation.withDefaultNamespace("camel"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.CAMEL_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.125f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.125f, 1.0f)))
                                        )
                        )
        );
        // Cat
        add(ResourceLocation.withDefaultNamespace("cat"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 2.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(0.75f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.CAT_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Cow
        add(ResourceLocation.withDefaultNamespace("cow"),
                LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(
                                        LootItem.lootTableItem(ItemRegistration.COW_HIDE)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
                                )
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(
                                       LootItem.lootTableItem(Items.BEEF)
                                               .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                               .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                               .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                )
                )
        );
        // Donkey
        add(ResourceLocation.withDefaultNamespace("donkey"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.DONKEY_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.125f, 1.0f)))
                                        )
                        )
        );
        // Fox
        add(ResourceLocation.withDefaultNamespace("fox"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.FOX_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.25f, 1.0f)))
                                        )
                        )
        );
        // Goat
        add(ResourceLocation.withDefaultNamespace("goat"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.GOAT_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.125f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.BROKEN_GOAT_HORN)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Hoglin
        add(ResourceLocation.withDefaultNamespace("hoglin"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.HOGLIN_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.125f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.PORKCHOP)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))
                                                        .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Horse
        add(ResourceLocation.withDefaultNamespace("horse"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.HORSE_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.25f, 1.0f)))
                                        )
                        )
        );
        // Llama
        add(ResourceLocation.withDefaultNamespace("llama"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.LLAMA_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.25f, 1.0f)))
                                        )
                        )
        );
        // Mooshroom
        add(ResourceLocation.withDefaultNamespace("mooshroom"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.MOOSHROOM_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.BEEF)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                                        .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Mule
        add(ResourceLocation.withDefaultNamespace("mule"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.MULE_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.25f, 1.0f)))
                                        )
                        )
        );
        // Ocelot
        add(ResourceLocation.withDefaultNamespace("ocelot"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(0.75f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.OCELOT_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Panda
        add(ResourceLocation.withDefaultNamespace("panda"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.PANDA_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.BAMBOO)
                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                        )
                        )
        );
        // Pig
        add(ResourceLocation.withDefaultNamespace("pig"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.PIG_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.125f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.PORKCHOP)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                                        .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Polar Bear
        add(ResourceLocation.withDefaultNamespace("polar_bear"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.POLAR_BEAR_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.COD)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 2.0f)))
                                                        .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f))))
                                        .add(
                                                LootItem.lootTableItem(Items.SALMON)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 2.0f)))
                                                        .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        // Rabbit // Vanilla is fine
        // Ravager
        add(ResourceLocation.withDefaultNamespace("ravager"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.RAVAGER_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                        )
                        )
        );
        // Sheep // TODO I can use this to create the coloured hides
        //final String[] colours = { "black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow" };
        add(ResourceLocation.withDefaultNamespace("sheep"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.SHEEP_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.25f, 1.0f)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(Items.MUTTON)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                                        .apply(SmeltItemFunction.smelted().when(shouldSmeltLoot(lookupProvider)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.0f, 1.0f)))
                                        )
                        )
        );
        /*
        for (String colour : colours) // TODO this didn't generate
        {
            add(ResourceLocation.withDefaultNamespace("sheep/" + colour),
                    LootTable.lootTable()
                            .withPool(
                                    LootPool.lootPool()
                                            .setRolls(ConstantValue.exactly(1.0F))
                                            .add(
                                                    NestedLootTable.lootTableReference(EntityType.SHEEP.getDefaultLootTable())
                                            )
                            )
            );
        }
        */
        // Sniffer
        add(ResourceLocation.withDefaultNamespace("sniffer"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.SNIFFER_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
                                        )
                        )
        );
        // Wolf
        add(ResourceLocation.withDefaultNamespace("wolf"),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0f))
                                        .add(
                                                LootItem.lootTableItem(ItemRegistration.WOLF_HIDE)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookupProvider, UniformGenerator.between(0.4f, 1.0f)))
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
            EntityType<?> rl = BuiltInRegistries.ENTITY_TYPE.get(location);
            ResourceKey<LootTable> resourceKey = rl.getDefaultLootTable();
            if (resourceKey != BuiltInLootTables.EMPTY)
            {
                LootTable.Builder builder = map.getOrDefault(location, null);
                if (builder == null)
                {
                    throw new IllegalStateException(String.format("Missing loot table for '%s'", location.toString()));
                }
                consumer.accept(resourceKey, builder);
            }
        }
    }
}
