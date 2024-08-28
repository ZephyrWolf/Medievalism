package io.github.zephyrwolf.medievalism.content.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.zephyrwolf.medievalism.content.item.ItemRegistration.ITEMS;

public final class BlockRegistration
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MedievalismConstants.MOD_ID);

    //region World
    //region Stone&Ore
    public static final DeferredBlock<Block> RED_CLAY_BLOCK = BLOCKS.registerSimpleBlock(
            "red_clay", BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.FLUTE)
                    .strength(0.6f).sound(SoundType.GRAVEL));
    public static final DeferredItem<BlockItem> RED_CLAY_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("red_clay", RED_CLAY_BLOCK);
    public static final DeferredBlock<Block> LIMESTONE_BLOCK = BLOCKS.registerSimpleBlock(
            "limestone", BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .requiresCorrectToolForDrops().strength(0.6f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> LIMESTONE_ITEM = ITEMS.registerSimpleBlockItem("limestone", LIMESTONE_BLOCK);
    public static final DeferredBlock<Block> TIN_ORE_BLOCK = BLOCKS.registerSimpleBlock(
            "tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(1.3f).sound(SoundType.STONE).requiresCorrectToolForDrops());
    public static final DeferredItem<BlockItem> TIN_ORE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("tin_ore_block", TIN_ORE_BLOCK);
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE_BLOCK = BLOCKS.registerSimpleBlock(
            "deepslate_tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE)
                    .strength(1.7f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());
    public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("deepslate_tin_ore_block", DEEPSLATE_TIN_ORE_BLOCK);
    //endregion
    //region Rocks
    public static final DeferredBlock<WorldLitterBlock> LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.FLAT), BlockBehaviour.Properties.of().noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.STONE).strength(0.1f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("large_rock", LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> ROCK_BLOCK = BLOCKS.registerBlock(
            "rock", props -> new WorldLitterBlock(props, WorldLitterBlock.FLAT), BlockBehaviour.Properties.of().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.1f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> ROCK_ITEM = ITEMS.registerSimpleBlockItem("rock", ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> LIMESTONE_ROCK_BLOCK = BLOCKS.registerBlock(
            "limestone_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.FLAT), BlockBehaviour.Properties.of().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.1f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredItem<BlockItem> LIMESTONE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("limestone_rock", LIMESTONE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> COPPER_ROCK_BLOCK = BLOCKS.registerBlock(
            "copper_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.FLAT), BlockBehaviour.Properties.of().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.1f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredItem<BlockItem> COPPER_ROCK_ITEM = ITEMS.registerSimpleBlockItem("copper_rock", COPPER_ROCK_BLOCK);
    //endregion
    //region World Litter
    //region Branches
    public static final DeferredBlock<WorldLitterBlock> BIRCH_BRANCH_BLOCK = BLOCKS.registerBlock(
            "birch_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> BIRCH_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("birch_branch", BIRCH_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> OAK_BRANCH_BLOCK = BLOCKS.registerBlock(
            "oak_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> OAK_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("oak_branch", OAK_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> SPRUCE_BRANCH_BLOCK = BLOCKS.registerBlock(
            "spruce_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> SPRUCE_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("spruce_branch", SPRUCE_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> JUNGLE_BRANCH_BLOCK = BLOCKS.registerBlock(
            "jungle_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> JUNGLE_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("jungle_branch", JUNGLE_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> DARK_OAK_BRANCH_BLOCK = BLOCKS.registerBlock(
            "dark_oak_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> DARK_OAK_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("dark_oak_branch", DARK_OAK_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> ACACIA_BRANCH_BLOCK = BLOCKS.registerBlock(
            "acacia_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> ACACIA_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("acacia_branch", ACACIA_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> CHERRY_BRANCH_BLOCK = BLOCKS.registerBlock(
            "cherry_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> CHERRY_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("cherry_branch", CHERRY_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> MANGROVE_BRANCH_BLOCK = BLOCKS.registerBlock(
            "mangrove_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> MANGROVE_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("mangrove_branch", MANGROVE_BRANCH_BLOCK);
    //endregion
    /*
    public static final DeferredBlock<WorldLitterBlock> TWIGS_BLOCK = BLOCKS.registerBlock(
            "twigs", props -> new WorldLitterBlock(props, WorldLitterBlock.TWIGS), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> TWIGS_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("twigs", TWIGS_BLOCK);
    */
    //endregion
    //region Organic
    public static final DeferredBlock<Block> DOGBANE_BLOCK = BLOCKS.registerBlock(
            "dogbane", DogbaneBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                    .strength(0.3f).sound(SoundType.GRASS));
    public static final DeferredItem<BlockItem> DOGBANE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("dogbane", DOGBANE_BLOCK);
    //endregion
    //endregion
    //region Primitive
    public static final DeferredBlock<RotatedPillarBlock> THATCH_BLOCK = BLOCKS.registerBlock(
            "thatch_block", RotatedPillarBlock::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WARPED_STEM).strength(0.5f).sound(SoundType.GRASS));
    public static final DeferredItem<BlockItem> THATCH_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("thatch_block", THATCH_BLOCK);
    public static final DeferredBlock<StoneBenchBlock> STONE_BENCH = BLOCKS.registerBlock("stone_bench", StoneBenchBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> STONE_BENCH_ITEM = ITEMS.registerSimpleBlockItem("stone_bench", STONE_BENCH);
    public static final DeferredBlock<ShortBlock> CHOPPING_BLOCK = BLOCKS.registerBlock("chopping_block", ShortBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD).strength(1.0f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> CHOPPING_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("chopping_block", CHOPPING_BLOCK);
    public static final DeferredBlock<Block> BIRCH_POT = BLOCKS.registerBlock("birch_pot", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_RED).strength(1.0f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> BIRCH_POT_ITEM = ITEMS.registerSimpleBlockItem("birch_pot", BIRCH_POT);
    //endregion

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
