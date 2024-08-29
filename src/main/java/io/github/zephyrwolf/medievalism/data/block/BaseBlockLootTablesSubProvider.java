package io.github.zephyrwolf.medievalism.data.block;

import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BaseBlockLootTablesSubProvider extends BlockLootSubProvider
{
    //private final Set<Block> generatedLootTables = new HashSet<>();

    public BaseBlockLootTablesSubProvider(HolderLookup.Provider lookupProvider)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate()
    {
        //dropSelf(ModBlocks.STOVE.get());
        //dropNamedContainer(ModBlocks.BASKET.get());
        //add(Registration.COOKING_POT.get(), (block) -> LootTable.lootTable().withPool(this.applyExplosionCondition(block,
        // LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block)
        //       .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY)).apply(CopyMealFunction.builder())))));
        /*
        add(Registration.RED_CLAY_BLOCK.get(), (block) -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .name("red_clay_ball")
                        .setRolls(ConstantValue.exactly(4))
                        .add(LootItem.lootTableItem(Registration.RED_CLAY_BALL.get()))
                )
        );
        */

        add(BlockRegistration.RED_CLAY_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                ItemRegistration.RED_CLAY_BALL.get(),
                ConstantValue.exactly(4)
        ));

        add(BlockRegistration.TIN_ORE_BLOCK.get(), (block) -> createOreDrop(
                BlockRegistration.TIN_ORE_BLOCK.get(),
                ItemRegistration.RAW_TIN.get()
        ));
        add(BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get(), (block) -> createOreDrop(
                BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get(),
                ItemRegistration.RAW_TIN.get()
        ));

        dropSelf(BlockRegistration.OAK_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.BIRCH_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.SPRUCE_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.JUNGLE_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.DARK_OAK_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.ACACIA_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.CHERRY_BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.MANGROVE_BRANCH_BLOCK.get());

        dropSelf(BlockRegistration.ROCK_BLOCK.get());
        dropSelf(BlockRegistration.SANDSTONE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.MOSSY_ROCK_BLOCK.get()); // TODO Make these drop regular without silk touch!?!?!?!?!?!
        dropSelf(BlockRegistration.LIGHTER_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.SNOWY_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.ICE_ROCK_BLOCK.get());

        dropSelf(BlockRegistration.LARGE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.SANDSTONE_LARGE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.RED_SANDSTONE_LARGE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.MOSSY_LARGE_ROCK_BLOCK.get()); // TODO Make these drop regular without silk touch!?!?!?!?!?!
        dropSelf(BlockRegistration.LIGHTER_LARGE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.SNOWY_LARGE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.ICE_LARGE_ROCK_BLOCK.get());

        dropSelf(BlockRegistration.LIMESTONE_BLOCK.get());
        dropSelf(BlockRegistration.LIMESTONE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.COPPER_ROCK_BLOCK.get());

        dropSelf(BlockRegistration.THATCH_BLOCK.get());
        dropSelf(BlockRegistration.DOGBANE_BLOCK.get());

        dropSelf(BlockRegistration.STONE_BENCH.get());
        dropSelf(BlockRegistration.CHOPPING_BLOCK.get());
        dropSelf(BlockRegistration.BIRCH_POT.get());
    }

    @SuppressWarnings("unused")
    protected void dropNamedContainer(Block block)
    {
        add(block, this::createNameableBlockEntityTable);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
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
}
