package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> REQUIRES_AXE_FOR_DROPS = tag( "requires_axe_for_drop");
    public static final TagKey<Block> CAN_DROP_THATCH = tag( "can_drop_thatch");


    private static TagKey<Block> tag(String name)
    {
        return tag(MedievalismConstants.MOD_ID, name);
    }

    private static TagKey<Block> tag(String namespace, String name)
    {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
    }
}
