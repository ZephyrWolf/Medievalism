package io.github.zephyrwolf.medievalism.catalogs.tag;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ItemTagCatalog
{
    public static final TagKey<Item> SEDIMENTARY_WG_STONES = tag("sedimentary_wg_stones");

    public static final TagKey<Item> LARGE_HIDE = tag("large_hide");
    public static final TagKey<Item> MEDIUM_HIDE = tag("medium_hide");
    public static final TagKey<Item> SMALL_HIDE = tag("small_hide");

    public static final TagKey<Item> CAN_CRAFT_FLOUR = tag("can_craft_flour");

    public static final TagKey<Item> CLAY_BALL = tag( "clay_ball");
    public static final TagKey<Item> GROG = tag( "grog");
    public static final TagKey<Item> CLAY_BLOCK = tag("clay_block");
    public static final TagKey<Item> ROCK = tag("rock");
    public static final TagKey<Item> HARD_ROCK = tag("hard_rock");
    public static final TagKey<Item> LARGE_ROCK = tag("large_rock");
    public static final TagKey<Item> LARGE_HARD_ROCK = tag("large_hard_rock");
    public static final TagKey<Item> COPPER_ROCK = tag("copper_rock");

    public static final TagKey<Item> ORES_TIN = tag("ores_tin"); // TODO What is the neoforge way
    public static final TagKey<Item> ORES_CHERT = tag("ores_chert");
    public static final TagKey<Item> ORES_GEODE = tag("ores_geode");

    public static final TagKey<Item> BRANCH = tag("branch");

    public static final TagKey<Item> TINDER = tag("tinder");

    public static final TagKey<Item> BARK = tag("bark");
    public static final TagKey<Item> CLAY_FLUX = tag("clay_flux"); // wood_ash & potash // TODO Is this the right name for forge?

    public static final TagKey<Item> KNIVES = tag("knives");
    public static final TagKey<Item> ROCK_KNAP_TOOL = tag("rock_knap_tool");
    public static final TagKey<Item> FLINT_KNAP_TOOL = tag("flint_knap_tool");
    public static final TagKey<Item> KNAP_TOOL = tag("knap_tool");
    public static final TagKey<Item> BONE_CARVING_TOOL = tag("bone_carving_tool");
    public static final TagKey<Item> WOOD_CARVING_TOOL = tag("bone_carving_tool");
    public static final TagKey<Item> PLANT_CARVING_TOOL = tag("plant_carving_tool");
    public static final TagKey<Item> CARVING_TOOL = tag("carving_tool");

    public static final TagKey<Item> WET_BRICK = tag("wet_brick");

    public static final TagKey<Item> GOAT_HORN_MATERIAL = tag("goat_horn_material");

    public static final TagKey<Item> SMALL_TOOL_HANDLE = tag("small_tool_handle");
    public static final TagKey<Item> LARGE_TOOL_HANDLE = tag("large_tool_handle");
    public static final TagKey<Item> TOOL_BINDING = tag("tool_binding");

    public static final TagKey<Item> FIRE_LAY_STICK = tag("fire_lay_stick");
    public static final TagKey<Item> BUILD_CAMPFIRE_CHOPPED_WOOD = tag("build_campfire_chopped_wood");
    public static final TagKey<Item> BUILD_CAMPFIRE_FIRE_STARTER = tag("build_campfire_fire_starter");

    private static TagKey<Item> tag(String name)
    {
        return ItemTags.create(MedievalismConstants.resource(name));
    }
}
