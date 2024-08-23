package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagCatalog
{
    public static final TagKey<Block> REQUIRES_AXE_FOR_DROPS = tag( "requires_axe_for_drop");
    public static final TagKey<Block> CAN_DROP_THATCH = tag( "can_drop_thatch");
    public static final TagKey<Block> RED_CLAY_CAN_REPLACE = tag("red_clay_can_replace");

    public static final TagKey<Block> WHITE_BARK = tag("white_back");
    public static final TagKey<Block> BROWN_BARK = tag("brown_bark");
    public static final TagKey<Block> GREY_BARK = tag("grey_bark");
    public static final TagKey<Block> DARK_BROWN_BARK = tag("dark_brown_bark");
    public static final TagKey<Block> BLACK_BARK = tag("black_bark");

    private static TagKey<Block> tag(String name)
    {
        return tag(MedievalismConstants.MOD_ID, name);
    }

    private static TagKey<Block> tag(String namespace, String name)
    {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
    }
}
