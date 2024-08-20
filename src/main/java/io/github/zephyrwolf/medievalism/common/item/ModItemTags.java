package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> LARGE_HIDE = tag("large_hide");
    public static final TagKey<Item> MEDIUM_HIDE = tag("medium_hide");
    public static final TagKey<Item> SMALL_HIDE = tag("small_hide");

    public static final TagKey<Item> CAN_CRAFT_FLOUR = tag("can_craft_flour");
    public static final TagKey<Item> CLAY_BALL = tag( "clay_ball");

    public static final TagKey<Item> ROCK = tag("rock");
    public static final TagKey<Item> LARGE_ROCK = tag("large_rock");

    public static final TagKey<Item> TINDER = tag("tinder");

    private static TagKey<Item> tag(String name)
    {
        return tag(MedievalismConstants.MOD_ID, name);
    }

    private static TagKey<Item> tag(String namespace, String name)
    {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
    }
}
