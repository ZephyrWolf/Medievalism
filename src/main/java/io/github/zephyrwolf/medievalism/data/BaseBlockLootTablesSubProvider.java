package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.content.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.BlockRegistration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
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

        dropSelf(BlockRegistration.BRANCH_BLOCK.get());
        dropSelf(BlockRegistration.LIMESTONE_BLOCK.get());
        dropSelf(BlockRegistration.LARGE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.ROCK_BLOCK.get());
        dropSelf(BlockRegistration.LIMESTONE_ROCK_BLOCK.get());
        dropSelf(BlockRegistration.COPPER_ROCK_BLOCK.get());

        dropSelf(BlockRegistration.THATCH_BLOCK.get());
        dropSelf(BlockRegistration.DOGBANE_BLOCK.get());

        dropSelf(BlockRegistration.STONE_BENCH.get());
        dropSelf(BlockRegistration.CHOPPING_BLOCK.get());
        dropSelf(BlockRegistration.BIRCH_POT.get());
    }

    protected void dropNamedContainer(Block block)
    {
        add(block, this::createNameableBlockEntityTable);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return BlockRegistration.BLOCKS.getEntries().stream().map(DeferredHolder::get).map(b -> (Block) b)::iterator;
    }
}