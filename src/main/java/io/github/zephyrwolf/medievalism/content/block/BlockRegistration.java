package io.github.zephyrwolf.medievalism.content.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import io.github.zephyrwolf.medievalism.common.item.blockitem.DryingBlockItem;
import io.github.zephyrwolf.medievalism.common.item.blockitem.ContainerItemBlockItem;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.zephyrwolf.medievalism.content.item.ItemRegistration.ITEMS;

public final class BlockRegistration {
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
    //region World Litter
    //region Rock
    public static BlockBehaviour.Properties rockProps = BlockBehaviour.Properties.of()
            .offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().isViewBlocking((pState, pLevel, pPos) -> false)
            .pushReaction(PushReaction.DESTROY).strength(0.05f)
            .sound(SoundType.STONE).mapColor(MapColor.STONE);
    public static final DeferredBlock<WorldLitterBlock> ROCK_BLOCK = BLOCKS.registerBlock(
            "rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> ROCK_ITEM = ITEMS.registerSimpleBlockItem("rock", ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> SANDSTONE_ROCK_BLOCK = BLOCKS.registerBlock(
            "sandstone_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> SANDSTONE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("sandstone_rock", SANDSTONE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> RED_SANDSTONE_ROCK_BLOCK = BLOCKS.registerBlock(
            "red_sandstone_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> RED_SANDSTONE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("red_sandstone_rock", RED_SANDSTONE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> MOSSY_ROCK_BLOCK = BLOCKS.registerBlock(
            "mossy_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> MOSSY_ROCK_ITEM = ITEMS.registerSimpleBlockItem("mossy_rock", MOSSY_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> LIGHTER_ROCK_BLOCK = BLOCKS.registerBlock(
            "lighter_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> LIGHTER_ROCK_ITEM = ITEMS.registerSimpleBlockItem("lighter_rock", LIGHTER_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> SNOWY_ROCK_BLOCK = BLOCKS.registerBlock(
            "snowy_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> SNOWY_ROCK_ITEM = ITEMS.registerSimpleBlockItem("snowy_rock", SNOWY_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> ICE_ROCK_BLOCK = BLOCKS.registerBlock(
            "ice_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.ROCK_SHAPE), rockProps);
    public static final DeferredItem<BlockItem> ICE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("ice_rock", ICE_ROCK_BLOCK);

    //endregion
    //region Large Rock
    public static BlockBehaviour.Properties largeRock = BlockBehaviour.Properties.of()
            .isViewBlocking((pState, pLevel, pPos) -> false)
            .pushReaction(PushReaction.DESTROY).strength(0.05f)
            .sound(SoundType.STONE).mapColor(MapColor.STONE);

    public static final DeferredBlock<WorldLitterBlock> LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("large_rock", LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> SANDSTONE_LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "sandstone_large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> SANDSTONE_LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("sandstone_large_rock", SANDSTONE_LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> RED_SANDSTONE_LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "red_sandstone_large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> RED_SANDSTONE_LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("red_sandstone_large_rock", RED_SANDSTONE_LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> MOSSY_LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "mossy_large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> MOSSY_LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("mossy_large_rock", MOSSY_LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> LIGHTER_LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "lighter_large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> LIGHTER_LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("lighter_large_rock", LIGHTER_LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> SNOWY_LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "snowy_large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> SNOWY_LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("snowy_large_rock", SNOWY_LARGE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> ICE_LARGE_ROCK_BLOCK = BLOCKS.registerBlock(
            "ice_large_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.LARGE_ROCK_SHAPE), largeRock);
    public static final DeferredItem<BlockItem> ICE_LARGE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("ice_large_rock", ICE_LARGE_ROCK_BLOCK);
    //endregion

    public static final DeferredBlock<WorldLitterBlock> LIMESTONE_ROCK_BLOCK = BLOCKS.registerBlock(
            "limestone_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.FLAT_SHAPE), BlockBehaviour.Properties.of()
                    .noCollission().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.05f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredItem<BlockItem> LIMESTONE_ROCK_ITEM = ITEMS.registerSimpleBlockItem("limestone_rock", LIMESTONE_ROCK_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> COPPER_ROCK_BLOCK = BLOCKS.registerBlock(
            "copper_rock", props -> new WorldLitterBlock(props, WorldLitterBlock.FLAT_SHAPE), BlockBehaviour.Properties.of().noCollission()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.05f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredItem<BlockItem> COPPER_ROCK_ITEM = ITEMS.registerSimpleBlockItem("copper_rock", COPPER_ROCK_BLOCK);

    //region Branches
    public static final DeferredBlock<WorldLitterBlock> BIRCH_BRANCH_BLOCK = BLOCKS.registerBlock(
            "birch_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> BIRCH_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("birch_branch", BIRCH_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> OAK_BRANCH_BLOCK = BLOCKS.registerBlock(
            "oak_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> OAK_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("oak_branch", OAK_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> SPRUCE_BRANCH_BLOCK = BLOCKS.registerBlock(
            "spruce_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> SPRUCE_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("spruce_branch", SPRUCE_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> JUNGLE_BRANCH_BLOCK = BLOCKS.registerBlock(
            "jungle_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> JUNGLE_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("jungle_branch", JUNGLE_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> DARK_OAK_BRANCH_BLOCK = BLOCKS.registerBlock(
            "dark_oak_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> DARK_OAK_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("dark_oak_branch", DARK_OAK_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> ACACIA_BRANCH_BLOCK = BLOCKS.registerBlock(
            "acacia_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> ACACIA_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("acacia_branch", ACACIA_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> CHERRY_BRANCH_BLOCK = BLOCKS.registerBlock(
            "cherry_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> CHERRY_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("cherry_branch", CHERRY_BRANCH_BLOCK);

    public static final DeferredBlock<WorldLitterBlock> MANGROVE_BRANCH_BLOCK = BLOCKS.registerBlock(
            "mangrove_branch", props -> new WorldLitterBlock(props, WorldLitterBlock.BRANCH_SHAPE), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN).dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> MANGROVE_BRANCH_ITEM = ITEMS.registerSimpleBlockItem("mangrove_branch", MANGROVE_BRANCH_BLOCK);
    //endregion
    //region Twigs
    /*
    public static final DeferredBlock<WorldLitterBlock> TWIGS_BLOCK = BLOCKS.registerBlock(
            "twigs", props -> new WorldLitterBlock(props, WorldLitterBlock.TWIGS), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> TWIGS_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("twigs", TWIGS_BLOCK);
    */
    //endregion
    //endregion
    //region Organic
    public static final DeferredBlock<Block> DOGBANE_BLOCK = BLOCKS.registerBlock(
            "dogbane", DogbaneBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                    .strength(0.3f).sound(SoundType.GRASS).randomTicks());
    public static final DeferredItem<BlockItem> DOGBANE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("dogbane", DOGBANE_BLOCK);
    //endregion
    //endregion
    //region Primitive
    public static final DeferredBlock<RotatedPillarBlock> THATCH_BLOCK = BLOCKS.registerBlock(
            "thatch_block", RotatedPillarBlock::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WARPED_STEM).strength(0.5f).sound(SoundType.GRASS));
    public static final DeferredItem<BlockItem> THATCH_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("thatch_block", THATCH_BLOCK);

    public static final DeferredBlock<WetPackedMudBrick> WET_PACKED_MUD_BRICK = BLOCKS.registerBlock(
            "wet_packed_mud_brick", props -> new WetPackedMudBrick(props, () -> new ItemStack(ItemRegistration.MUD_BALL.get())), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.STONE).randomTicks());
    public static final DeferredItem<BlockItem> WET_PACKED_MUD_BRICK_ITEM = ITEMS.registerSimpleBlockItem("wet_packed_mud_brick", WET_PACKED_MUD_BRICK);

    public static final DeferredBlock<StoneBenchBlock> STONE_BENCH = BLOCKS.registerBlock("stone_bench", StoneBenchBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0f).sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> STONE_BENCH_ITEM = ITEMS.registerSimpleBlockItem("stone_bench", STONE_BENCH);
    public static final DeferredBlock<ShortBlock> CHOPPING_BLOCK = BLOCKS.registerBlock("chopping_block", ShortBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD).strength(1.0f).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> CHOPPING_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("chopping_block", CHOPPING_BLOCK);

    // --

    public static final BlockBehaviour.Properties WetClayProps = BlockBehaviour.Properties.of()
            .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY)
            .mapColor(MapColor.CLAY).strength(0.4f).sound(SoundType.MUD).randomTicks();
    public static final BlockBehaviour.Properties FiredClayProps = BlockBehaviour.Properties.of()
            .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.BLOCK)
            .mapColor(MapColor.TERRACOTTA_BROWN).strength(0.4f).sound(SoundType.DECORATED_POT);

    // Gatherer's Jar
    public static final DeferredBlock<DryingBlock> DRYING_GATHERERS_JAR = BLOCKS.registerBlock("drying_gatherers_jar",
            props -> new DryingBlock(props, ClayContainerBlock.GATHERERS_POT_SHAPE), WetClayProps);
    public static final DeferredItem<BlockItem> WET_GATHERERS_JAR_ITEM = ITEMS.registerItem("wet_gatherers_jar",
            props -> new DryingBlockItem(DRYING_GATHERERS_JAR, props.stacksTo(1), false));
    public static final DeferredItem<BlockItem> DRY_GATHERERS_JAR_ITEM = ITEMS.registerItem("dry_gatherers_jar",
            props -> new DryingBlockItem(DRYING_GATHERERS_JAR, props.stacksTo(1), true));
    public static final DeferredBlock<ClayContainerBlock> GATHERERS_JAR = BLOCKS.registerBlock("gatherers_jar",
            props -> new ClayContainerBlock(props, ClayContainerBlock.GATHERERS_POT_SHAPE), FiredClayProps);
    public static final DeferredItem<ContainerItemBlockItem> GATHERERS_JAR_ITEM = ITEMS.registerItem("gatherers_jar",
            props -> new ContainerItemBlockItem(GATHERERS_JAR, props
                    .stacksTo(1)
                    .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

    // Keeper's Crock
    public static final DeferredBlock<DryingBlock> DRYING_KEEPERS_CROCK = BLOCKS.registerBlock("drying_keepers_crock",
            props -> new DryingBlock(props, KeepersCrockBlock.KEEPERS_CROCK_SHAPE), WetClayProps);
    public static final DeferredItem<BlockItem> WET_KEEPERS_CROCK_ITEM = ITEMS.registerItem("wet_keepers_crock",
            props -> new DryingBlockItem(DRYING_KEEPERS_CROCK, props, false));
    public static final DeferredItem<BlockItem> DRY_KEEPERS_CROCK_ITEM = ITEMS.registerItem("dry_keepers_crock",
            props -> new DryingBlockItem(DRYING_KEEPERS_CROCK, props, true));
    public static final DeferredBlock<KeepersCrockBlock> KEEPERS_CROCK = BLOCKS.registerBlock("keepers_crock",
            KeepersCrockBlock::new, FiredClayProps);
    public static final DeferredItem<ContainerItemBlockItem> KEEPERS_CROCK_ITEM = ITEMS.registerItem("keepers_crock",
            props -> new ContainerItemBlockItem(KEEPERS_CROCK, props.stacksTo(1))
    );

    // Settler's Pot
    public static final DeferredBlock<DryingBlock> DRYING_SETTLERS_POT = BLOCKS.registerBlock("drying_settlers_pot",
            props -> new DryingBlock(props, ClayContainerBlock.SETTLERS_POT_SHAPE), WetClayProps);
    public static final DeferredItem<BlockItem> WET_SETTLERS_POT_ITEM = ITEMS.registerItem("wet_settlers_pot",
            props -> new DryingBlockItem(DRYING_SETTLERS_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_SETTLERS_POT_ITEM = ITEMS.registerItem("dry_settlers_pot",
            props -> new DryingBlockItem(DRYING_SETTLERS_POT, props, true));
    public static final DeferredBlock<ClayContainerBlock> SETTLERS_POT = BLOCKS.registerBlock("settlers_pot",
            props -> new ClayContainerBlock(props, ClayContainerBlock.SETTLERS_POT_SHAPE), FiredClayProps);
    public static final DeferredItem<BlockItem> SETTLERS_POT_ITEM = ITEMS.registerSimpleBlockItem("settlers_pot", SETTLERS_POT);

    // Cooking Pot
    public static final DeferredBlock<DryingBlock> DRYING_CLAY_COOKING_POT = BLOCKS.registerBlock("drying_clay_cooking_pot",
            props -> new DryingBlock(props, ClayCookingPotBlock.CLAY_COOKING_POT_SHAPE), WetClayProps);
    public static final DeferredItem<BlockItem> WET_CLAY_COOKING_POT_ITEM = ITEMS.registerItem("wet_clay_cooking_pot",
            props -> new DryingBlockItem(DRYING_CLAY_COOKING_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_CLAY_COOKING_POT_ITEM = ITEMS.registerItem("dry_clay_cooking_pot",
            props -> new DryingBlockItem(DRYING_CLAY_COOKING_POT, props, true));
    public static final DeferredBlock<ClayCookingPotBlock> CLAY_COOKING_POT = BLOCKS.registerBlock("clay_cooking_pot",
            ClayCookingPotBlock::new, FiredClayProps);
    public static final DeferredItem<BlockItem> CLAY_COOKING_POT_ITEM = ITEMS.registerSimpleBlockItem("clay_cooking_pot", CLAY_COOKING_POT);

    // Clay Cauldron
    public static final DeferredBlock<DryingBlock> DRYING_CLAY_CAULDRON = BLOCKS.registerBlock("drying_clay_cauldron",
            props -> new DryingBlock(props, ClayCauldronBlock.CLAY_CAULDRON_SHAPE), WetClayProps);
    public static final DeferredItem<BlockItem> WET_CLAY_CAULDRON_ITEM = ITEMS.registerItem("wet_clay_cauldron",
            props -> new DryingBlockItem(DRYING_CLAY_CAULDRON, props, false));
    public static final DeferredItem<BlockItem> DRY_CLAY_CAULDRON_ITEM = ITEMS.registerItem("dry_clay_cauldron",
            props -> new DryingBlockItem(DRYING_CLAY_CAULDRON, props, true));
    public static final DeferredBlock<ClayCauldronBlock> CLAY_CAULDRON = BLOCKS.registerBlock("clay_cauldron",
            ClayCauldronBlock::new, FiredClayProps);
    public static final DeferredItem<BlockItem> CLAY_CAULDRON_ITEM = ITEMS.registerSimpleBlockItem("clay_cauldron", CLAY_CAULDRON);

    // Jug

    // Birch Pot

    // Flower Pot

    // Decorated Pot


    //endregion

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
