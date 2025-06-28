package io.github.zephyrwolf.medievalism.content.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class BlockRegistration {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MedievalismConstants.MOD_ID);

    //region Stone&Ore
    public static final DeferredBlock<Block> RED_CLAY = BLOCKS.registerSimpleBlock(
            "red_clay", BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.FLUTE)
                    .strength(0.6f).sound(SoundType.GRAVEL));
    public static final DeferredBlock<Block> LIMESTONE = BLOCKS.registerSimpleBlock(
            "limestone", BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .requiresCorrectToolForDrops().strength(0.6f).sound(SoundType.STONE));
    public static final DeferredBlock<Block> TIN_ORE = BLOCKS.registerSimpleBlock(
            "tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(1.3f).sound(SoundType.STONE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = BLOCKS.registerSimpleBlock(
            "deepslate_tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE)
                    .strength(1.7f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());
    //endregion

    //region Rock
    public static BlockBehaviour.Properties rockProps = BlockBehaviour.Properties.of()
            .offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().isViewBlocking((pState, pLevel, pPos) -> false)
            .pushReaction(PushReaction.DESTROY).strength(0.05f)
            .sound(SoundType.STONE).mapColor(MapColor.STONE);

    public static final DeferredBlock<WorldLitterBlock> ROCK = BLOCKS.registerBlock(
            "rock", RockBlock::new, rockProps);
    public static final DeferredBlock<WorldLitterBlock> SANDSTONE_ROCK = BLOCKS.registerBlock(
            "sandstone_rock", RockBlock::new, rockProps);
    public static final DeferredBlock<WorldLitterBlock> RED_SANDSTONE_ROCK = BLOCKS.registerBlock(
            "red_sandstone_rock", RockBlock::new, rockProps);
    public static final DeferredBlock<WorldLitterBlock> MOSSY_ROCK = BLOCKS.registerBlock(
            "mossy_rock", RockBlock::new, rockProps);
    public static final DeferredBlock<WorldLitterBlock> LIGHTER_ROCK = BLOCKS.registerBlock(
            "lighter_rock", RockBlock::new, rockProps);
    public static final DeferredBlock<WorldLitterBlock> SNOWY_ROCK = BLOCKS.registerBlock(
            "snowy_rock", RockBlock::new, rockProps);
    public static final DeferredBlock<WorldLitterBlock> ICE_ROCK = BLOCKS.registerBlock(
            "ice_rock", RockBlock::new, rockProps);
    //endregion

    //region Large Rock
    public static BlockBehaviour.Properties largeRock = BlockBehaviour.Properties.of()
            .isViewBlocking((pState, pLevel, pPos) -> false)
            .pushReaction(PushReaction.DESTROY).strength(0.05f)
            .sound(SoundType.STONE).mapColor(MapColor.STONE);

    public static final DeferredBlock<WorldLitterBlock> LARGE_ROCK = BLOCKS.registerBlock(
            "large_rock", LargeRockBlock::new, largeRock);
    public static final DeferredBlock<WorldLitterBlock> SANDSTONE_LARGE_ROCK = BLOCKS.registerBlock(
            "sandstone_large_rock", LargeRockBlock::new, largeRock);
    public static final DeferredBlock<WorldLitterBlock> RED_SANDSTONE_LARGE_ROCK = BLOCKS.registerBlock(
            "red_sandstone_large_rock", LargeRockBlock::new, largeRock);
    public static final DeferredBlock<WorldLitterBlock> MOSSY_LARGE_ROCK = BLOCKS.registerBlock(
            "mossy_large_rock", LargeRockBlock::new, largeRock);
    public static final DeferredBlock<WorldLitterBlock> LIGHTER_LARGE_ROCK = BLOCKS.registerBlock(
            "lighter_large_rock", LargeRockBlock::new, largeRock);
    public static final DeferredBlock<WorldLitterBlock> SNOWY_LARGE_ROCK = BLOCKS.registerBlock(
            "snowy_large_rock", LargeRockBlock::new, largeRock);
    public static final DeferredBlock<WorldLitterBlock> ICE_LARGE_ROCK = BLOCKS.registerBlock(
            "ice_large_rock", LargeRockBlock::new, largeRock);
    //endregion

    //region Misc Rocks
    public static final DeferredBlock<WorldLitterBlock> LIMESTONE_ROCK = BLOCKS.registerBlock(
            "limestone_rock", TEMPFlatBlock::new, BlockBehaviour.Properties.of()
                    .noCollission().offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.05f).sound(SoundType.DRIPSTONE_BLOCK));
    public static final DeferredBlock<WorldLitterBlock> COPPER_ROCK = BLOCKS.registerBlock(
            "copper_rock", TEMPFlatBlock::new, BlockBehaviour.Properties.of().noCollission()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.STONE)
                    .strength(0.05f).sound(SoundType.DRIPSTONE_BLOCK));
    //endregion

    //region Branches
    public static BlockBehaviour.Properties branch = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN).dynamicShape()
            .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false)
            .pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD);

    public static final DeferredBlock<WorldLitterBlock> BIRCH_BRANCH = BLOCKS.registerBlock(
            "birch_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> OAK_BRANCH = BLOCKS.registerBlock(
            "oak_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> SPRUCE_BRANCH = BLOCKS.registerBlock(
            "spruce_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> JUNGLE_BRANCH = BLOCKS.registerBlock(
            "jungle_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> DARK_OAK_BRANCH = BLOCKS.registerBlock(
            "dark_oak_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> ACACIA_BRANCH = BLOCKS.registerBlock(
            "acacia_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> CHERRY_BRANCH = BLOCKS.registerBlock(
            "cherry_branch", BranchBlock::new, branch);
    public static final DeferredBlock<WorldLitterBlock> MANGROVE_BRANCH = BLOCKS.registerBlock(
            "mangrove_branch", BranchBlock::new, branch);
    //endregion

    //region Organic
    public static final DeferredBlock<Block> DOGBANE = BLOCKS.registerBlock(
            "dogbane", DogbaneBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                    .strength(0.3f).sound(SoundType.GRASS).randomTicks());
    //endregion

    //region Crops
    public static final DeferredBlock<WildYamBlock> WILD_YAMS = BLOCKS.registerBlock(
            "wild_yams", WildYamBlock::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    //.randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final DeferredBlock<YamBlock> YAMS = BLOCKS.registerBlock(
            "yams", YamBlock::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
    );
    //endregion

    //region Primitive
    public static final DeferredBlock<RotatedPillarBlock> THATCH = BLOCKS.registerBlock(
            "thatch_block", RotatedPillarBlock::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WARPED_STEM).strength(0.5f).sound(SoundType.GRASS));
    public static final DeferredBlock<Block> WET_PACKED_MUD = BLOCKS.registerBlock("wet_packed_mud", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.MUD));
    public static final DeferredBlock<Block> WET_DAUB_BLOCK = BLOCKS.registerBlock("wet_daub_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.MUD));
    public static final DeferredBlock<Block> DAUB_BLOCK = BLOCKS.registerBlock("daub_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DAUB_BRICKS = BLOCKS.registerBlock("daub_bricks", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> CRACKED_DAUB_BLOCK = BLOCKS.registerBlock("cracked_daub_block", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> CRACKED_DAUB_BRICKS = BLOCKS.registerBlock("cracked_daub_bricks", Block::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());

    public static final DeferredBlock<DryingBrick> WET_PACKED_MUD_BRICK = registerDryingBrick(BLOCKS,
            "wet_packed_mud_brick", DryingBrick::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.STONE).randomTicks(), 2);
    public static final DeferredBlock<DryingBrick> WET_DAUB_BRICK = registerDryingBrick(BLOCKS,
            "wet_daub_brick", DryingBrick::new, BlockBehaviour.Properties.of()
                .mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.STONE).randomTicks(), 3);

    public static final DeferredBlock<StoneBenchBlock> STONE_BENCH = BLOCKS.registerBlock("stone_bench", StoneBenchBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(1.0f).sound(SoundType.STONE));
    public static final DeferredBlock<ChoppingBlockBlock> CHOPPING_BLOCK = BLOCKS.registerBlock("chopping_block", ChoppingBlockBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD).strength(1.0f).sound(SoundType.WOOD));
    //endregion

    //region Pottery


    public static final BlockBehaviour.Properties WetClayProps = BlockBehaviour.Properties.of()
            .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY)
            .mapColor(MapColor.CLAY).strength(0.4f).sound(SoundType.MUD).randomTicks();
    public static final BlockBehaviour.Properties FiredClayProps = BlockBehaviour.Properties.of()
            .isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.BLOCK)
            .mapColor(MapColor.TERRACOTTA_BROWN).strength(0.4f).sound(SoundType.DECORATED_POT);

    // Gatherer's Jar
    public static final DeferredBlock<DryingBlock> DRYING_GATHERERS_JAR = BLOCKS.registerBlock("drying_gatherers_jar",
            GatherersJarBlock.DryingGatherersJarBlock::new, WetClayProps);
    public static final DeferredBlock<GatherersJarBlock> GATHERERS_JAR = BLOCKS.registerBlock("gatherers_jar",
            GatherersJarBlock::new, FiredClayProps);

    // Keeper's Crock
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_KEEPERS_CROCK = BLOCKS.registerBlock("drying_keepers_crock",
            KeepersCrockBlock.DryingKeepersCrockBlockHorizontalAxis::new, WetClayProps);
    public static final DeferredBlock<KeepersCrockBlock> KEEPERS_CROCK = BLOCKS.registerBlock("keepers_crock",
            KeepersCrockBlock::new, FiredClayProps);

    // Settler's Pot
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_SETTLERS_POT = BLOCKS.registerBlock("drying_settlers_pot",
            SettlersPotBlock.DryingSettlersPotBlockHorizontalAxis::new, WetClayProps);
    public static final DeferredBlock<SettlersPotBlock> SETTLERS_POT = BLOCKS.registerBlock("settlers_pot",
            SettlersPotBlock::new, FiredClayProps);

    // Cooking Pot
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_CLAY_COOKING_POT = BLOCKS.registerBlock("drying_clay_cooking_pot",
            ClayCookingPotBlock.DryingClayCookingPotBlock::new, WetClayProps);
    public static final DeferredBlock<ClayCookingPotBlock> CLAY_COOKING_POT = BLOCKS.registerBlock("clay_cooking_pot",
            ClayCookingPotBlock::new, FiredClayProps);

    // Clay Cauldron
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_CLAY_CAULDRON = BLOCKS.registerBlock("drying_clay_cauldron",
            ClayCauldronBlock.DryingClayCauldronBlock::new, WetClayProps);
    public static final DeferredBlock<ClayCauldronBlock> CLAY_CAULDRON = BLOCKS.registerBlock("clay_cauldron",
            ClayCauldronBlock::new, FiredClayProps);

    // Jug
    public static final DeferredBlock<DryingBlockHorizontalFacing> DRYING_JUG = BLOCKS.registerBlock("drying_jug",
            JugBlock.DryingJugBlock::new, WetClayProps);
    public static final DeferredBlock<JugBlock> JUG = BLOCKS.registerBlock("jug",
            JugBlock::new, FiredClayProps);

    // Birch Pot

    // Flower Pot
    public static final DeferredBlock<DryingBlock> DRYING_FLOWER_POT = BLOCKS.registerBlock("drying_flower_pot",
            DryingBlock.BasicDryingBlock::new, WetClayProps);

    // Decorated Pot
    public static final DeferredBlock<DryingBlock> DRYING_DECORATED_POT = BLOCKS.registerBlock("drying_decorated_pot",
            DryingBlock.BasicDryingBlock::new, WetClayProps); // TODO Support player right clicking face with SHERDS

    //endregion

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    private static <B extends Block> DeferredBlock<B> registerDryingBrick(DeferredRegister.Blocks blocks, String name, BiFunction<BlockBehaviour.Properties, Integer, ? extends B> func, BlockBehaviour.Properties props, int chance)
    {
        return blocks.register(name, () -> func.apply(props, chance));
    }
}
