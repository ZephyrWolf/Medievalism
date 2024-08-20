package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class ModBiomeTags
{
    public static final TagKey<Biome> HAS_TREES = tag("has_trees");
    public static final TagKey<Biome> HAS_DENSE_TRESS = tag("has_dense_trees");

    private static TagKey<Biome> tag(String name)
    {
        return tag(MedievalismConstants.MOD_ID, name);
    }

    private static TagKey<Biome> tag(String namespace, String name)
    {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(namespace, name));
        //return BiomeTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
    }
}
