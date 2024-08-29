package io.github.zephyrwolf.medievalism.content.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class BiomeTagCatalog
{
    public static final TagKey<Biome> HAS_DENSE_OAK_TREES = tag("has_dense_oak_trees");
    public static final TagKey<Biome> HAS_DENSE_JUNGLE_TREES = tag("has_dense_jungle_trees");
    public static final TagKey<Biome> HAS_DENSE_SPRUCE_TREES = tag("has_dense_spruce_trees");
    public static final TagKey<Biome> HAS_DENSE_BIRCH_TREES = tag("has_dense_birch_trees");
    public static final TagKey<Biome> HAS_DENSE_DARK_OAK_TREES = tag("has_dense_dark_oak_trees");
    public static final TagKey<Biome> HAS_DENSE_CHERRY_TREES = tag("has_dense_cherry_trees");
    public static final TagKey<Biome> HAS_DENSE_MANGROVE_TREES = tag("has_dense_mangrove_trees");

    public static final TagKey<Biome> HAS_SPARSE_OAK_TREES = tag("has_sparse_oak_trees");
    public static final TagKey<Biome> HAS_SPARSE_JUNGLE_TREES = tag("has_sparse_jungle_trees");
    public static final TagKey<Biome> HAS_SPARSE_SPRUCE_TREES = tag("has_sparse_spruce_trees");
    public static final TagKey<Biome> HAS_SPARSE_BIRCH_TREES = tag("has_sparse_birch_trees");
    public static final TagKey<Biome> HAS_SPARSE_ACACIA_TREES = tag("has_sparse_acacia_trees");

    public static final TagKey<Biome> HAS_RARE_OAK_TREES = tag("has_rare_oak_trees");
    public static final TagKey<Biome> HAS_RARE_BIRCH_TREES = tag("has_rare_birch_trees");

    public static final TagKey<Biome> GENERATE_STONE_ROCK = tag("generate_stone_rock");
    public static final TagKey<Biome> GENERATE_DENSE_STONE_ROCK = tag("generate_dense_rock");
    public static final TagKey<Biome> GENERATE_SANDSTONE_ROCK = tag("generate_sandstone_rock");
    public static final TagKey<Biome> GENERATE_RED_SANDSTONE_ROCK = tag("generate_red_sandstone_rock");
    public static final TagKey<Biome> GENERATE_MOSSY_ROCK = tag("generate_mossy_rock");
    public static final TagKey<Biome> GENERATE_LIGHTER_ROCK = tag("generate_lighter_rock");
    public static final TagKey<Biome> GENERATE_SNOWY_ROCK = tag("generate_snowy_rock");
    public static final TagKey<Biome> GENERATE_ICE_ROCK = tag("generate_ice_rock");
    public static final TagKey<Biome> GENERATE_LIMESTONE_ROCK = tag("generate_limestone_rock");

    public static final TagKey<Biome> GENERATE_RED_CLAY = tag("generate_red_clay");

    private static TagKey<Biome> tag(String name)
    {
        return TagKey.create(Registries.BIOME, MedievalismConstants.resource(name));
    }
}
