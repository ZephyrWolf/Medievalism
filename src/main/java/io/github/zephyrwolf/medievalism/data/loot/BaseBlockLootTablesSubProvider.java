package io.github.zephyrwolf.medievalism.data.loot;

import io.github.zephyrwolf.medievalism.common.block.DryingBlock;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BaseBlockLootTablesSubProvider extends BlockLootSubProvider {
    //private final Set<Block> generatedLootTables = new HashSet<>();

    public BaseBlockLootTablesSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate() {
        add(BlockRegistration.RED_CLAY.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                ItemRegistration.RED_CLAY_BALL.get(),
                ConstantValue.exactly(4)
        ));

        add(BlockRegistration.TIN_ORE.get(), (block) -> createOreDrop(
                BlockRegistration.TIN_ORE.get(),
                ItemRegistration.RAW_TIN.get()
        ));
        add(BlockRegistration.DEEPSLATE_TIN_ORE.get(), (block) -> createOreDrop(
                BlockRegistration.DEEPSLATE_TIN_ORE.get(),
                ItemRegistration.RAW_TIN.get()
        ));

        add(BlockRegistration.WET_PACKED_MUD_BRICK.get(), emptyItemTable());

        add(BlockRegistration.DRYING_GATHERERS_JAR.get(), block -> createSpecialDropOnStateTable(block, DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS, ItemRegistration.WET_GATHERERS_JAR, ItemRegistration.DRY_GATHERERS_JAR));
        add(BlockRegistration.GATHERERS_JAR.get(), this::createCeramicContainer);
        add(BlockRegistration.DRYING_KEEPERS_CROCK.get(), block -> createSpecialDropOnStateTable(block, DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS, ItemRegistration.WET_KEEPERS_CROCK, ItemRegistration.DRY_KEEPERS_CROCK));
        add(BlockRegistration.KEEPERS_CROCK.get(), this::createCeramicContainer);
        add(BlockRegistration.DRYING_SETTLERS_POT.get(), block -> createSpecialDropOnStateTable(block, DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS, ItemRegistration.WET_SETTLERS_POT, ItemRegistration.DRY_SETTLERS_POT));
        add(BlockRegistration.SETTLERS_POT.get(), this::createNameable);
        add(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), block -> createSpecialDropOnStateTable(block, DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS, ItemRegistration.WET_CLAY_COOKING_POT, ItemRegistration.DRY_CLAY_COOKING_POT));
        dropSelf(BlockRegistration.CLAY_COOKING_POT.get());
        add(BlockRegistration.DRYING_CLAY_CAULDRON.get(), block -> createSpecialDropOnStateTable(block, DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS, ItemRegistration.WET_CLAY_CAULDRON, ItemRegistration.DRY_CLAY_CAULDRON));
        dropSelf(BlockRegistration.CLAY_CAULDRON.get());

        dropSelf(BlockRegistration.OAK_BRANCH.get());
        dropSelf(BlockRegistration.BIRCH_BRANCH.get());
        dropSelf(BlockRegistration.SPRUCE_BRANCH.get());
        dropSelf(BlockRegistration.JUNGLE_BRANCH.get());
        dropSelf(BlockRegistration.DARK_OAK_BRANCH.get());
        dropSelf(BlockRegistration.ACACIA_BRANCH.get());
        dropSelf(BlockRegistration.CHERRY_BRANCH.get());
        dropSelf(BlockRegistration.MANGROVE_BRANCH.get());

        dropSelf(BlockRegistration.ROCK.get());
        dropSelf(BlockRegistration.SANDSTONE_ROCK.get());
        dropSelf(BlockRegistration.RED_SANDSTONE_ROCK.get());
        dropSelf(BlockRegistration.MOSSY_ROCK.get()); // TODO Make these drop regular without silk touch!?!?!?!?!?!
        dropSelf(BlockRegistration.LIGHTER_ROCK.get());
        dropSelf(BlockRegistration.SNOWY_ROCK.get());
        dropSelf(BlockRegistration.ICE_ROCK.get());

        dropSelf(BlockRegistration.LARGE_ROCK.get());
        dropSelf(BlockRegistration.SANDSTONE_LARGE_ROCK.get());
        dropSelf(BlockRegistration.RED_SANDSTONE_LARGE_ROCK.get());
        dropSelf(BlockRegistration.MOSSY_LARGE_ROCK.get()); // TODO Make these drop regular without silk touch!?!?!?!?!?!
        dropSelf(BlockRegistration.LIGHTER_LARGE_ROCK.get());
        dropSelf(BlockRegistration.SNOWY_LARGE_ROCK.get());
        dropSelf(BlockRegistration.ICE_LARGE_ROCK.get());

        add(
                BlockRegistration.YAMS.get(),
                createCropDrops(
                        BlockRegistration.YAMS.get(),
                        ItemRegistration.YAM.get(),
                        ItemRegistration.YAM.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistration.YAMS.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))
                )
        );
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        add(
                BlockRegistration.WILD_YAMS.get(),
                applyExplosionDecay(
                        BlockRegistration.WILD_YAMS.get(),
                        LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .add(
                                                        LootItem.lootTableItem(ItemRegistration.YAM.get())
                                                )
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .add(
                                                        LootItem.lootTableItem(ItemRegistration.YAM.get())
                                                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286f, 1))
                                                )
                                )
                )
        );

        dropSelf(BlockRegistration.LIMESTONE.get());
        dropSelf(BlockRegistration.LIMESTONE_ROCK.get());
        dropSelf(BlockRegistration.COPPER_ROCK.get());

        dropSelf(BlockRegistration.THATCH.get());
        dropSelf(BlockRegistration.DOGBANE.get());

        dropSelf(BlockRegistration.STONE_BENCH.get());
        dropSelf(BlockRegistration.CHOPPING_BLOCK.get());
    }

    @SuppressWarnings("unused")
    protected void dropNamedContainer(Block block) {
        add(block, this::createNameableBlockEntityTable);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BlockRegistration.BLOCKS.getEntries().stream().map(DeferredHolder::get).map(b -> (Block) b)::iterator;
    }

    @SuppressWarnings("unused")
    protected void dropOther(Block pBlock, ItemLike pItem, int count) {
        this.add(pBlock, this.createItemTable(pItem, count));
    }

    public LootTable.Builder createItemTable(ItemLike pItem, int count) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(pItem, LootPool
                        .lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem
                                .lootTableItem(pItem)
                                .setQuality(count)
                        )
                ));
    }

    public LootTable.Builder createCeramicContainer(Block block) {
        //LootItemFunctions
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(block)
                                .setQuality(1)
                                .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                .include(DataComponents.CUSTOM_NAME)
                                                .include(DataComponents.CONTAINER)
                                        //.include(DataComponents.LOCK)
                                        //.include(DataComponents.CONTAINER_LOOT)
                                )
                        )
                );
    }

    public LootTable.Builder createNameable(Block block) {
        //LootItemFunctions
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(block)
                                .setQuality(1)
                                .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                .include(DataComponents.CUSTOM_NAME)
                                        //.include(DataComponents.LOCK)
                                        //.include(DataComponents.CONTAINER_LOOT)
                                )
                        )
                );
    }

    public LootTable.Builder createSpecialDropOnStateTable(Block block, Property<Integer> property, int value, ItemLike wet, ItemLike dry) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(dry)
                                .setQuality(1)
                                .when(new LootItemBlockStatePropertyCondition.Builder(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(property, value)
                                        )
                                )
                        )
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(wet)
                                .setQuality(1)
                                .when(InvertedLootItemCondition.invert(
                                                new LootItemBlockStatePropertyCondition.Builder(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(property, value)
                                                        )
                                        )
                                )
                        )
                );
    }

    public LootTable.Builder emptyItemTable() {
        return LootTable.lootTable();
    }
}
