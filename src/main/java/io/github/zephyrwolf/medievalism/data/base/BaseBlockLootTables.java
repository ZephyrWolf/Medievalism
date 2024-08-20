package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BaseBlockLootTables extends BlockLootSubProvider
{
    //private final Set<Block> generatedLootTables = new HashSet<>();

    public BaseBlockLootTables(HolderLookup.Provider lookupProvider)
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

        add(Registration.RED_CLAY_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                Registration.RED_CLAY_BALL.get(),
                ConstantValue.exactly(4)
        ));

        dropSelf(Registration.BRANCH_BLOCK.get());
        dropSelf(Registration.LIMESTONE_BLOCK.get());
        dropSelf(Registration.LARGE_ROCK_BLOCK.get());
        dropSelf(Registration.ROCK_BLOCK.get());
        dropSelf(Registration.LIMESTONE_ROCK_BLOCK.get());
        dropSelf(Registration.COPPER_ROCK_BLOCK.get());
        dropSelf(Registration.THATCH_BLOCK.get());
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
