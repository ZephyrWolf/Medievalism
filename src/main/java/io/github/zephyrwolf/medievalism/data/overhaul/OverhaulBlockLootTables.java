package io.github.zephyrwolf.medievalism.data.overhaul;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class OverhaulBlockLootTables extends BlockLootSubProvider
{
    private final Set<Block> generatedLootTables = new HashSet<>();

    public OverhaulBlockLootTables(HolderLookup.Provider lookupProvider)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate() {
        addLootTable(Blocks.CAMPFIRE, () ->
                add(
                        Blocks.CAMPFIRE,
                        block -> this.createSilkTouchDispatchTable(
                                block,
                                this.applyExplosionCondition(
                                        block,
                                        LootItem.lootTableItem(Items.CHARCOAL)
                                                .apply(
                                                        SetItemCountFunction.setCount(UniformGenerator.between(0, 1)
                                                        )
                                                )
                                )
                        )
                )
        );
    }

//    protected void dropNamedContainer(Block block)
//    {
//        add(block, this::createNameableBlockEntityTable);
//    }

    protected void addLootTable(Block block, Runnable run)
    {
        run.run();
        generatedLootTables.add(block);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return generatedLootTables; // .BLOCKS.getEntries().stream().map(DeferredHolder::get).map(b -> (Block) b)::iterator;
    }
}
