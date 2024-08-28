package io.github.zephyrwolf.medievalism.content.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class BiomeTagCatalog
{
    public static final TagKey<Biome> HAS_TREES = tag("has_trees");
    public static final TagKey<Biome> HAS_DENSE_TRESS = tag("has_dense_trees");
    public static final TagKey<Biome> GENERATE_RED_CLAY = tag("generate_red_clay");

    private static TagKey<Biome> tag(String name)
    {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, name));
        //return BiomeTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
    }
}
