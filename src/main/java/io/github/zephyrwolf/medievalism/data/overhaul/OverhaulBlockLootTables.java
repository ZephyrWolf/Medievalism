package io.github.zephyrwolf.medievalism.data.overhaul;

import io.github.zephyrwolf.medievalism.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class OverhaulBlockLootTables extends BlockLootSubProvider
{
    //private final Set<Block> generatedLootTables = new HashSet<>();

    public OverhaulBlockLootTables(HolderLookup.Provider lookupProvider)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate()
    {
        add(
                Blocks.CAMPFIRE,
                block -> this.createSilkTouchDispatchTable(
                        block,
                        (LootPoolEntryContainer.Builder<?>)this.applyExplosionCondition(
                                block,
                                LootItem.lootTableItem(Items.CHARCOAL) // TODO This is a loop hole, but so is woodash
                                        .apply(
                                                SetItemCountFunction.setCount(UniformGenerator.between(0, 1)
                                                )
                                        )
                        )
                ));
    }

    protected void dropNamedContainer(Block block)
    {
        add(block, this::createNameableBlockEntityTable);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return Registration.BLOCKS.getEntries().stream().map(DeferredHolder::get).map(b -> (Block) b)::iterator;
    }
}
