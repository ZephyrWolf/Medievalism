package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class ItemTagCatalog
{
    public static final TagKey<Item> SEDIMENTARY_WG_STONES = tag("sedimentary_wg_stones");

    public static final TagKey<Item> LARGE_HIDE = tag("large_hide");
    public static final TagKey<Item> MEDIUM_HIDE = tag("medium_hide");
    public static final TagKey<Item> SMALL_HIDE = tag("small_hide");

    public static final TagKey<Item> CAN_CRAFT_FLOUR = tag("can_craft_flour");

    public static final TagKey<Item> CLAY_BALL = tag( "clay_ball");
    public static final TagKey<Item> CLAY_BLOCK = tag("clay_block");
    public static final TagKey<Item> ROCK = tag("rock");
    public static final TagKey<Item> HARD_ROCK = tag("hard_rock");
    public static final TagKey<Item> LARGE_ROCK = tag("large_rock");
    public static final TagKey<Item> LARGE_HARD_ROCK = tag("large_hard_rock");
    public static final TagKey<Item> COPPER_ROCK = tag("copper_rock");

    public static final TagKey<Item> ORES_TIN = tag("ores_tin"); // TODO What is the newforge way
    public static final TagKey<Item> ORES_CHERT = tag("ores_chert");
    public static final TagKey<Item> ORES_GEODE = tag("ores_geode");

    public static final TagKey<Item> BRANCH = tag("branch");

    public static final TagKey<Item> TINDER = tag("tinder");

    public static final TagKey<Item> BARK = tag("bark");
    public static final TagKey<Item> CLAY_FLUX = tag("clay_flux"); // wood_ash & potash // TODO Is this the right name for forge?

    public static final TagKey<Item> CARVING_TOOL = tag("carving_tool");
    public static final TagKey<Item> KNAP_TOOL = tag("knap_tool");

    public static final TagKey<Item> WET_BRICK = tag("wet_brick");

    private static TagKey<Item> tag(String name)
    {
        return ItemTags.create(MedievalismConstants.resource(name));
    }
}
