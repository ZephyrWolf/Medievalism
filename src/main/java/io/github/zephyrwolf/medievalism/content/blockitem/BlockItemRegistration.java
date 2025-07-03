package io.github.zephyrwolf.medievalism.content.blockitem;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.blockitem.ContainerItemBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.DryingBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.DryingBrickBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.GatherersJarBlockItem;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class BlockItemRegistration {
    public static final DeferredRegister.Items BLOCKITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    //region World
    public static final DeferredItem<BlockItem> RED_CLAY_BLOCK = BLOCKITEMS.registerSimpleBlockItem("red_clay", BlockRegistration.RED_CLAY);
    public static final DeferredItem<BlockItem> LIMESTONE = BLOCKITEMS.registerSimpleBlockItem("limestone", BlockRegistration.LIMESTONE);
    public static final DeferredItem<BlockItem> TIN_ORE_BLOCK = BLOCKITEMS.registerSimpleBlockItem("tin_ore_block", BlockRegistration.TIN_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE_BLOCK = BLOCKITEMS.registerSimpleBlockItem("deepslate_tin_ore_block", BlockRegistration.DEEPSLATE_TIN_ORE);

    public static final DeferredItem<BlockItem> ROCK = BLOCKITEMS.registerSimpleBlockItem("rock", BlockRegistration.ROCK);
    public static final DeferredItem<BlockItem> SANDSTONE_ROCK = BLOCKITEMS.registerSimpleBlockItem("sandstone_rock", BlockRegistration.SANDSTONE_ROCK);
    public static final DeferredItem<BlockItem> RED_SANDSTONE_ROCK = BLOCKITEMS.registerSimpleBlockItem("red_sandstone_rock", BlockRegistration.RED_SANDSTONE_ROCK);
    public static final DeferredItem<BlockItem> MOSSY_ROCK = BLOCKITEMS.registerSimpleBlockItem("mossy_rock", BlockRegistration.MOSSY_ROCK);
    public static final DeferredItem<BlockItem> LIGHTER_ROCK = BLOCKITEMS.registerSimpleBlockItem("lighter_rock", BlockRegistration.LIGHTER_ROCK);
    public static final DeferredItem<BlockItem> SNOWY_ROCK = BLOCKITEMS.registerSimpleBlockItem("snowy_rock", BlockRegistration.SNOWY_ROCK);
    public static final DeferredItem<BlockItem> ICE_ROCK = BLOCKITEMS.registerSimpleBlockItem("ice_rock", BlockRegistration.ICE_ROCK);

    public static final DeferredItem<BlockItem> LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("large_rock", BlockRegistration.LARGE_ROCK);
    public static final DeferredItem<BlockItem> SANDSTONE_LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("sandstone_large_rock", BlockRegistration.SANDSTONE_LARGE_ROCK);
    public static final DeferredItem<BlockItem> RED_SANDSTONE_LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("red_sandstone_large_rock", BlockRegistration.RED_SANDSTONE_LARGE_ROCK);
    public static final DeferredItem<BlockItem> MOSSY_LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("mossy_large_rock", BlockRegistration.MOSSY_LARGE_ROCK);
    public static final DeferredItem<BlockItem> LIGHTER_LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("lighter_large_rock", BlockRegistration.LIGHTER_LARGE_ROCK);
    public static final DeferredItem<BlockItem> SNOWY_LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("snowy_large_rock", BlockRegistration.SNOWY_LARGE_ROCK);
    public static final DeferredItem<BlockItem> ICE_LARGE_ROCK = BLOCKITEMS.registerSimpleBlockItem("ice_large_rock", BlockRegistration.ICE_LARGE_ROCK);

    public static final DeferredItem<BlockItem> LIMESTONE_ROCK = BLOCKITEMS.registerSimpleBlockItem("limestone_rock", BlockRegistration.LIMESTONE_ROCK);
    public static final DeferredItem<BlockItem> COPPER_ROCK = BLOCKITEMS.registerSimpleBlockItem("copper_rock", BlockRegistration.COPPER_ROCK);

    public static final DeferredItem<BlockItem> BIRCH_BRANCH = BLOCKITEMS.registerSimpleBlockItem("birch_branch", BlockRegistration.BIRCH_BRANCH);
    public static final DeferredItem<BlockItem> OAK_BRANCH = BLOCKITEMS.registerSimpleBlockItem("oak_branch", BlockRegistration.OAK_BRANCH);
    public static final DeferredItem<BlockItem> SPRUCE_BRANCH = BLOCKITEMS.registerSimpleBlockItem("spruce_branch", BlockRegistration.SPRUCE_BRANCH);
    public static final DeferredItem<BlockItem> JUNGLE_BRANCH = BLOCKITEMS.registerSimpleBlockItem("jungle_branch", BlockRegistration.JUNGLE_BRANCH);
    public static final DeferredItem<BlockItem> DARK_OAK_BRANCH = BLOCKITEMS.registerSimpleBlockItem("dark_oak_branch", BlockRegistration.DARK_OAK_BRANCH);
    public static final DeferredItem<BlockItem> ACACIA_BRANCH = BLOCKITEMS.registerSimpleBlockItem("acacia_branch", BlockRegistration.ACACIA_BRANCH);
    public static final DeferredItem<BlockItem> CHERRY_BRANCH = BLOCKITEMS.registerSimpleBlockItem("cherry_branch", BlockRegistration.CHERRY_BRANCH);
    public static final DeferredItem<BlockItem> MANGROVE_BRANCH = BLOCKITEMS.registerSimpleBlockItem("mangrove_branch", BlockRegistration.MANGROVE_BRANCH);

    public static final DeferredItem<BlockItem> SHRUB = BLOCKITEMS.registerSimpleBlockItem("shrub", BlockRegistration.SHRUB);
    //endregion

    //region Farming
    public static final DeferredItem<BlockItem> DOGBANE_BLOCK_ITEM = BLOCKITEMS.registerSimpleBlockItem("dogbane", BlockRegistration.DOGBANE);
    //endregion

    //region Primitive
    public static final DeferredItem<BlockItem> THATCH_BLOCK = BLOCKITEMS.registerSimpleBlockItem("thatch_block", BlockRegistration.THATCH);
    public static final DeferredItem<BlockItem> STONE_BENCH = BLOCKITEMS.registerSimpleBlockItem("stone_bench", BlockRegistration.STONE_BENCH);
    public static final DeferredItem<BlockItem> CHOPPING_BLOCK = BLOCKITEMS.registerSimpleBlockItem("chopping_block", BlockRegistration.CHOPPING_BLOCK);
    public static final DeferredItem<BlockItem> WET_PACKED_MUD = BLOCKITEMS.registerSimpleBlockItem("wet_packed_mud", BlockRegistration.WET_PACKED_MUD);
    public static final DeferredItem<DryingBrickBlockItem> WET_PACKED_MUD_BRICK = registerBlockItem("wet_packed_mud_brick", DryingBrickBlockItem::new, BlockRegistration.WET_PACKED_MUD_BRICK);
    public static final DeferredItem<DryingBrickBlockItem> WET_DAUB_BRICK = registerBlockItem("wet_daub_brick", DryingBrickBlockItem::new, BlockRegistration.WET_DAUB_BRICK);
    public static final DeferredItem<DryingBrickBlockItem> DRYING_CLAY_BRICK = registerBlockItem("drying_clay_brick", DryingBrickBlockItem::new, BlockRegistration.DRYING_CLAY_BRICK);
    public static final DeferredItem<DryingBrickBlockItem> DRYING_RED_CLAY_BRICK = registerBlockItem("drying_red_clay_brick", DryingBrickBlockItem::new, BlockRegistration.DRYING_RED_CLAY_BRICK);
    public static final DeferredItem<BlockItem> WET_DAUB_BLOCK = BLOCKITEMS.registerSimpleBlockItem("wet_daub_block", BlockRegistration.WET_DAUB_BLOCK);
    public static final DeferredItem<BlockItem> DAUB_BLOCK = BLOCKITEMS.registerSimpleBlockItem("daub_block", BlockRegistration.DAUB_BLOCK);
    public static final DeferredItem<BlockItem> DAUB_BRICKS = BLOCKITEMS.registerSimpleBlockItem("daub_bricks", BlockRegistration.DAUB_BRICKS);
    public static final DeferredItem<BlockItem> CRACKED_DAUB_BLOCK = BLOCKITEMS.registerSimpleBlockItem("cracked_daub_block", BlockRegistration.CRACKED_DAUB_BLOCK);
    public static final DeferredItem<BlockItem> CRACKED_DAUB_BRICKS = BLOCKITEMS.registerSimpleBlockItem("cracked_daub_bricks", BlockRegistration.CRACKED_DAUB_BRICKS);

    //endregion

    //region Pottery
    public static final DeferredItem<BlockItem> WET_GATHERERS_JAR = BLOCKITEMS.registerItem("wet_gatherers_jar",
            props -> new DryingBlockItem(BlockRegistration.DRYING_GATHERERS_JAR, props, false));
    public static final DeferredItem<BlockItem> DRY_GATHERERS_JAR = BLOCKITEMS.registerItem("dry_gatherers_jar",
            props -> new DryingBlockItem(BlockRegistration.DRYING_GATHERERS_JAR, props, true));
    public static final DeferredItem<GatherersJarBlockItem> GATHERERS_JAR = BLOCKITEMS.registerItem("gatherers_jar",
            props -> new GatherersJarBlockItem(BlockRegistration.GATHERERS_JAR, props.stacksTo(1)));

    public static final DeferredItem<BlockItem> WET_KEEPERS_CROCK = BLOCKITEMS.registerItem("wet_keepers_crock",
            props -> new DryingBlockItem(BlockRegistration.DRYING_KEEPERS_CROCK, props, false));
    public static final DeferredItem<BlockItem> DRY_KEEPERS_CROCK = BLOCKITEMS.registerItem("dry_keepers_crock",
            props -> new DryingBlockItem(BlockRegistration.DRYING_KEEPERS_CROCK, props, true));
    public static final DeferredItem<ContainerItemBlockItem> KEEPERS_CROCK = BLOCKITEMS.registerItem("keepers_crock",
            props -> new ContainerItemBlockItem(BlockRegistration.KEEPERS_CROCK, props.stacksTo(1)));

    public static final DeferredItem<BlockItem> WET_SETTLERS_POT = BLOCKITEMS.registerItem("wet_settlers_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_SETTLERS_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_SETTLERS_POT = BLOCKITEMS.registerItem("dry_settlers_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_SETTLERS_POT, props, true));
    public static final DeferredItem<BlockItem> SETTLERS_POT = BLOCKITEMS.registerSimpleBlockItem("settlers_pot", BlockRegistration.SETTLERS_POT);

    public static final DeferredItem<BlockItem> WET_CLAY_COOKING_POT = BLOCKITEMS.registerItem("wet_clay_cooking_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_COOKING_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_CLAY_COOKING_POT = BLOCKITEMS.registerItem("dry_clay_cooking_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_COOKING_POT, props, true));
    public static final DeferredItem<BlockItem> CLAY_COOKING_POT = BLOCKITEMS.registerSimpleBlockItem("clay_cooking_pot", BlockRegistration.CLAY_COOKING_POT);

    public static final DeferredItem<BlockItem> WET_CLAY_CAULDRON = BLOCKITEMS.registerItem("wet_clay_cauldron",
            props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_CAULDRON, props.stacksTo(1), false));
    public static final DeferredItem<BlockItem> DRY_CLAY_CAULDRON = BLOCKITEMS.registerItem("dry_clay_cauldron",
            props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_CAULDRON, props.stacksTo(1), true));
    public static final DeferredItem<BlockItem> CLAY_CAULDRON = BLOCKITEMS.registerSimpleBlockItem("clay_cauldron", BlockRegistration.CLAY_CAULDRON);

    public static final DeferredItem<BlockItem> WET_JUG = BLOCKITEMS.registerItem("wet_jug",
            props -> new DryingBlockItem(BlockRegistration.DRYING_JUG, props, false));
    public static final DeferredItem<BlockItem> DRY_JUG = BLOCKITEMS.registerItem("dry_jug",
            props -> new DryingBlockItem(BlockRegistration.DRYING_JUG, props, true));
    public static final DeferredItem<BlockItem> JUG = BLOCKITEMS.registerSimpleBlockItem("jug", BlockRegistration.JUG);

    public static final DeferredItem<BlockItem> WET_FLOWER_POT = BLOCKITEMS.registerItem("wet_flower_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_FLOWER_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_FLOWER_POT = BLOCKITEMS.registerItem("dry_flower_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_FLOWER_POT, props, true));

    public static final DeferredItem<BlockItem> WET_DECORATED_POT = BLOCKITEMS.registerItem("wet_decorated_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_DECORATED_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_DECORATED_POT = BLOCKITEMS.registerItem("dry_decorated_pot",
            props -> new DryingBlockItem(BlockRegistration.DRYING_DECORATED_POT, props, true));

    //endregion

    public static void register(IEventBus modEventBus) {
        BLOCKITEMS.register(modEventBus);
    }

    // --

    public static <I extends Item> DeferredItem<I> registerBlockItem(String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    {
        return registerBlockItem(name, func, block, new Item.Properties());
    }

    public static <I extends Item> DeferredItem<I> registerBlockItem(String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    {
        return BLOCKITEMS.register(name, key -> func.apply(block.get(), props));
    }
}
