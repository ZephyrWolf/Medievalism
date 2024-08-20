package io.github.zephyrwolf.medievalism.registry;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.FlatBlock;
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

import static io.github.zephyrwolf.medievalism.registry.ItemRegistration.ITEMS;

public final class BlockRegistration
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MedievalismConstants.MOD_ID);

    //region World
    public static final DeferredBlock<Block> RED_CLAY_BLOCK = BLOCKS.registerSimpleBlock(
            "red_clay", BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.FLUTE)
                    .strength(0.6f).sound(SoundType.GRAVEL));
    public static final DeferredItem<BlockItem> RED_CLAY_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("red_clay", RED_CLAY_BLOCK);

    public static final DeferredBlock<Block> LIMESTONE_BLOCK = BLOCKS.registerSimpleBlock(
            "limestone", BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .requiresCorrectToolForDrops().strength(0.6f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> LIMESTONE_ITEM = ITEMS.registerSimpleBlockItem("limestone", LIMESTONE_BLOCK);

    public static final DeferredBlock<FlatBlock> BRANCH_BLOCK = BLOCKS.registerBlock(
            "branch", FlatBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> BRANCH_ITEM = ITEMS.registerSimpleBlockItem("branch", BRANCH_BLOCK);

    public static final DeferredBlock<FlatBlock> LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "large_rock", FlatBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.STONE).strength(0.1f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("large_rock", LARGE_ROCK_BLOCK);

    public static final DeferredBlock<FlatBlock> ROCK_BLOCK = BLOCKS.registerBlock(
            "rock", FlatBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.1f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> ROCK_ITEM = ITEMS.registerSimpleBlockItem("rock", ROCK_BLOCK);

    public static final DeferredBlock<FlatBlock> LIMESTONE_ROCK_BLOCK = BLOCKS.registerBlock(
            "limestone_rock", FlatBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.1f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredItem<BlockItem> LIMESTONE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("limestone_rock", LIMESTONE_ROCK_BLOCK);

    public static final DeferredBlock<FlatBlock> COPPER_ROCK_BLOCK = BLOCKS.registerBlock(
            "copper_rock", FlatBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.1f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredItem<BlockItem> COPPER_ROCK_ITEM = ITEMS.registerSimpleBlockItem("copper_rock", COPPER_ROCK_BLOCK);

    public static final DeferredBlock<Block> TIN_ORE_BLOCK = BLOCKS.registerSimpleBlock(
            "tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(1.3f).sound(SoundType.STONE).requiresCorrectToolForDrops());
    public static final DeferredItem<BlockItem> TIN_ORE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("tin_ore_block", TIN_ORE_BLOCK);

    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE_BLOCK = BLOCKS.registerSimpleBlock(
            "deepslate_tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE)
                    .strength(1.7f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());
    public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("deepslate_tin_ore_block", DEEPSLATE_TIN_ORE_BLOCK);

    //endregion

    //region Primitive
        public static final DeferredBlock<RotatedPillarBlock> THATCH_BLOCK = BLOCKS.registerBlock(
                "thatch_block", RotatedPillarBlock::new, BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WARPED_STEM).strength(0.5f).sound(SoundType.GRASS));
        public static final DeferredItem<BlockItem> THATCH_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("thatch_block", THATCH_BLOCK);
    //endregion

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
