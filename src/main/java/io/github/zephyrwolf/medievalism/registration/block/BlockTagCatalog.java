package io.github.zephyrwolf.medievalism.registration.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagCatalog
{
    public static final TagKey<Block> EMPTY_TAG = tag("empty");

    // Use this to set mining props
    public static final TagKey<Block> SOFT_TUFF_BLOCKS = tag("soft_tuff_blocks");           // Ashfall
    public static final TagKey<Block> IGNIMBRITE_BLOCKS = tag("ignimbrite_blocks");
    public static final TagKey<Block> LAPILLISTONE_BLOCKS = tag("lapillistone_blocks");
    public static final TagKey<Block> WELDED_TUFF_BLOCKS = tag("welded_tuff_blocks");
    public static final TagKey<Block> SANDSTONE_BLOCKS = tag("sandstone_blocks");           // Regolith
    public static final TagKey<Block> SAPROLITE_BLOCKS = tag("saprolite_blocks");
    public static final TagKey<Block> LATERITE_BLOCKS = tag("laterite_blocks");
    public static final TagKey<Block> GREYWACKE_BLOCKS = tag("greywacke_blocks");           // Sedimentary
    public static final TagKey<Block> SILTSTONE_BLOCKS = tag("siltstone_blocks");
    public static final TagKey<Block> DOLOSTONE_BLOCKS = tag("dolostone_blocks");
    public static final TagKey<Block> IRONSTONE_BLOCKS = tag("ironstone_blocks");
    public static final TagKey<Block> SHALE_BLOCKS = tag("shale_blocks");
    public static final TagKey<Block> ARKOSE_BLOCKS = tag("arkose_blocks");
    public static final TagKey<Block> LIMESTONE_BLOCKS = tag("limestone_blocks");
    public static final TagKey<Block> CHALK_BLOCKS = tag("chalk_blocks");
    public static final TagKey<Block> MARBLE_BLOCKS = tag("marble_blocks");                 // Metamorphic
    public static final TagKey<Block> QUARTZITE_BLOCKS = tag("quartzite_blocks");
    public static final TagKey<Block> HORNFELS_BLOCKS = tag("hornfels_blocks");
    public static final TagKey<Block> SLATE_BLOCKS = tag("slate_blocks");
    public static final TagKey<Block> TRAVERTINE_BLOCKS = tag("travertine_blocks");         // Other
    public static final TagKey<Block> BASALT_BLOCKS = tag("basalt_blocks");                 // Hard Intrusive Extrusive
    public static final TagKey<Block> ANDESITE_BLOCKS = tag("andesite_blocks");
    public static final TagKey<Block> RHYOLITE_BLOCKS = tag("rhyolite_blocks");             // Soft Igneous Extrusive
    public static final TagKey<Block> DACITE_BLOCKS = tag("dacite_blocks");
    public static final TagKey<Block> GRANITE_BLOCKS = tag("granite_blocks");               // Igneous Intrusive
    public static final TagKey<Block> DIORITE_BLOCKS = tag("diorite_blocks");
    public static final TagKey<Block> GABBRO_BLOCKS = tag("gabbro_blocks");
    public static final TagKey<Block> NORITE_BLOCKS = tag("norite_blocks");                 // Deep Igneous Intrusive
    public static final TagKey<Block> PERIDOTITE_BLOCKS = tag("peridotite_blocks");
    public static final TagKey<Block> CALCITE_BLOCKS = tag("calcite_blocks");
    // Ore Replaceables
    public static final TagKey<Block> SOFT_TUFF_ORE_REPLACEABLES = tag("soft_tuff_ore_replaceables");
    public static final TagKey<Block> IGNIMBRITE_ORE_REPLACEABLES = tag("ignimbrite_ore_replaceables");
    public static final TagKey<Block> LAPILLISTONE_ORE_REPLACEABLES = tag("lapillistone_ore_replaceables");
    public static final TagKey<Block> WELDED_TUFF_ORE_REPLACEABLES = tag("welded_tuff_ore_replaceables");
    public static final TagKey<Block> SANDSTONE_ORE_REPLACEABLES = tag("sandstone_ore_replaceables");
    public static final TagKey<Block> RED_SANDSTONE_ORE_REPLACEABLES = tag("red_sandstone_ore_replaceables");
    public static final TagKey<Block> SAPROLITE_ORE_REPLACEABLES = tag("saprolite_ore_replaceables");
    public static final TagKey<Block> LATERITE_ORE_REPLACEABLES = tag("laterite_replaceables");
    public static final TagKey<Block> GREYWACKE_ORE_REPLACEABLES = tag("greywacke_ore_replaceables");
    public static final TagKey<Block> SILTSTONE_ORE_REPLACEABLES = tag("siltstone_ore_replaceables");
    public static final TagKey<Block> DOLOSTONE_ORE_REPLACEABLES = tag("dolostone_ore_replaceables");
    public static final TagKey<Block> LIMESTONE_ORE_REPLACEABLES = tag("limestone_ore_replaceables");
    public static final TagKey<Block> CHALK_ORE_REPLACEABLES = tag("chalk_ore_replaceables");
    public static final TagKey<Block> IRONSTONE_ORE_REPLACEABLES = tag("ironstone_ore_replaceables");
    public static final TagKey<Block> SHALE_ORE_REPLACEABLES = tag("shale_ore_replaceables");
    public static final TagKey<Block> ARKOSE_ORE_REPLACEABLES = tag("arkose_ore_replaceables");
    public static final TagKey<Block> MARBLE_ORE_REPLACEABLES = tag("marble_ore_replaceables");
    public static final TagKey<Block> QUARTZITE_ORE_REPLACEABLES = tag("quartzite_ore_replaceables");
    public static final TagKey<Block> HORNFELS_ORE_REPLACEABLES = tag("hornfels_ore_replaceables");
    public static final TagKey<Block> SLATE_ORE_REPLACEABLES = tag("slate_ore_replaceables");
    public static final TagKey<Block> GABBRO_ORE_REPLACEABLES = tag("gabbro_ore_replaceables");
    public static final TagKey<Block> SMOOTH_DIORITE_ORE_REPLACEABLES = tag("smooth_diorite_ore_replaceables");
    public static final TagKey<Block> SMOOTH_GRANITE_ORE_REPLACEABLES = tag("smooth_granite_ore_replaceables");
    public static final TagKey<Block> NORITE_ORE_REPLACEABLES = tag("norite_ore_replaceables");
    public static final TagKey<Block> PERIDOTITE_ORE_REPLACEABLES = tag("peridotite_ore_replaceables");
    public static final TagKey<Block> TRAVERTINE_ORE_REPLACEABLES = tag("travertine_ore_replaceables");
    public static final TagKey<Block> RHYOLITE_ORE_REPLACEABLES = tag("rhyolite_ore_replaceables");
    public static final TagKey<Block> DACITE_ORE_REPLACEABLES = tag("dacite_ore_replaceables");
    public static final TagKey<Block> ANDESITE_ORE_REPLACEABLES = tag("andesite_ore_replaceables");
    public static final TagKey<Block> BASALT_ORE_REPLACEABLES = tag("basalt_ore_replaceables");
    // Layer Ore Replaceables
    public static final TagKey<Block> REGOLITH_ORE_REPLACEABLES = tag("regolith_ore_replaceables");
    public static final TagKey<Block> SEDIMENTARY_ORE_REPLACEABLES = tag("sedimentary_ore_replaceables");
    public static final TagKey<Block> METAMORPHIC_ORE_REPLACEABLES = tag("metamorphic_ore_replaceables");
    public static final TagKey<Block> IGNEOUS_INTRUSIVE_ORE_REPLACEABLES = tag("igneous_intrusive_ore_replaceables");
    public static final TagKey<Block> DEEP_IGNEOUS_INTRUSIVE_ORE_REPLACEABLES = tag("deep_igneous_intrusive_ore_replaceables");
    public static final TagKey<Block> ASHFALL_ORE_REPLACEABLES = tag("ashfall_ore_replaceables");
    public static final TagKey<Block> SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES = tag("soft_igneous_extrusive_ore_replaceables");
    public static final TagKey<Block> HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES = tag("hard_igneous_extrusive_ore_replaceables");
    // Overhauled Vanilla Ore Replaceables
    public static final TagKey<Block> OVERHAULED_VANILLA_ORE_REPLACEABLES = tag("overhauled_vanilla_ore_replaceables");

    public static final TagKey<Block> INCORRECT_FOR_PRIMITIVE_TOOL = BlockTags.INCORRECT_FOR_GOLD_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = BlockTags.INCORRECT_FOR_WOODEN_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = BlockTags.INCORRECT_FOR_STONE_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_WROUGHT_IRON_TOOL = BlockTags.INCORRECT_FOR_IRON_TOOL;
    public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = BlockTags.INCORRECT_FOR_DIAMOND_TOOL;

    public static final TagKey<Block> NEEDS_PRIMITIVE_TOOL = tag("needs_primitive_tool");
    public static final TagKey<Block> NEEDS_WOODEN_TOOL = tag("needs_wooden_tool");
    public static final TagKey<Block> NEEDS_COPPER_TOOL = NEEDS_WOODEN_TOOL;
    public static final TagKey<Block> NEEDS_BRONZE_TOOL = BlockTags.NEEDS_STONE_TOOL;
    public static final TagKey<Block> NEEDS_WROUGHT_IRON_TOOL = BlockTags.NEEDS_IRON_TOOL;
    public static final TagKey<Block> NEEDS_STEEL_TOOL = BlockTags.NEEDS_DIAMOND_TOOL;
    public static final TagKey<Block> NEEDS_NETHERITE_TOOL = tag("needs_netherite_tool");

    public static final TagKey<Block> REQUIRES_AXE_FOR_DROPS = tag( "requires_axe_for_drop");
    public static final TagKey<Block> CAN_DROP_THATCH = tag( "can_drop_thatch");
    public static final TagKey<Block> CLAY_CAN_REPLACE = tag("clay_can_replace");

    public static final TagKey<Block> WHITE_BARK = tag("white_back");
    public static final TagKey<Block> BROWN_BARK = tag("brown_bark");
    public static final TagKey<Block> GREY_BARK = tag("grey_bark");
    public static final TagKey<Block> DARK_BROWN_BARK = tag("dark_brown_bark");
    public static final TagKey<Block> BLACK_BARK = tag("black_bark");

    public static final TagKey<Block> ROCK = tag("rock");
    public static final TagKey<Block> LARGE_ROCK = tag("large_rock");
    public static final TagKey<Block> COPPER_ROCK = tag( "copper_rock");
    public static final TagKey<Block> TWIGS = tag("twigs");
    public static final TagKey<Block> BRANCH = tag("branch");

    private static TagKey<Block> tag(String name)
    {
        return BlockTags.create(MedievalismConstants.resource(name));
    }
}
