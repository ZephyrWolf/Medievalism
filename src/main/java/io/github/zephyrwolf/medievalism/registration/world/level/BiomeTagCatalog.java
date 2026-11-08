package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class BiomeTagCatalog
{
    private static TagKey<Biome> tag(String name)
    { return TagKey.create(Registries.BIOME, MedievalismConstants.resource(name)); }

    public static final TagKey<Biome> HAS_DENSE_OAK_TREES = tag("has_dense_oak_trees");
    public static final TagKey<Biome> HAS_DENSE_JUNGLE_TREES = tag("has_dense_jungle_trees");
    public static final TagKey<Biome> HAS_DENSE_SPRUCE_TREES = tag("has_dense_spruce_trees");
    public static final TagKey<Biome> HAS_DENSE_BIRCH_TREES = tag("has_dense_birch_trees");
    public static final TagKey<Biome> HAS_DENSE_DARK_OAK_TREES = tag("has_dense_dark_oak_trees");
    public static final TagKey<Biome> HAS_DENSE_CHERRY_TREES = tag("has_dense_cherry_trees");
    public static final TagKey<Biome> HAS_DENSE_MANGROVE_TREES = tag("has_dense_mangrove_trees");

    public static final TagKey<Biome> HAS_DENSE_TREES = tag("has_dense_trees");

    public static final TagKey<Biome> HAS_SPARSE_OAK_TREES = tag("has_sparse_oak_trees");
    public static final TagKey<Biome> HAS_SPARSE_JUNGLE_TREES = tag("has_sparse_jungle_trees");
    public static final TagKey<Biome> HAS_SPARSE_SPRUCE_TREES = tag("has_sparse_spruce_trees");
    public static final TagKey<Biome> HAS_SPARSE_BIRCH_TREES = tag("has_sparse_birch_trees");
    public static final TagKey<Biome> HAS_SPARSE_ACACIA_TREES = tag("has_sparse_acacia_trees");

    public static final TagKey<Biome> HAS_SPARSE_TREES = tag("has_sparse_trees");

    public static final TagKey<Biome> HAS_RARE_OAK_TREES = tag("has_rare_oak_trees");
    public static final TagKey<Biome> HAS_RARE_BIRCH_TREES = tag("has_rare_birch_trees");

    public static final TagKey<Biome> HAS_RARE_TREES = tag("has_rare_trees");

    public static final TagKey<Biome> IS_SURFACE_WITH_SAND = tag("is_surface_with_sand");
    public static final TagKey<Biome> IS_SURFACE_WITH_RED_SAND = tag("is_surface_with_red_sand");
    public static final TagKey<Biome> IS_SURFACE_WITHOUT_SAND = tag("is_surface_without_sand");

    public static final TagKey<Biome> GENERATE_INLAND_CLAY = tag("generate_inland_clay");

    //public static final TagKey<Biome> GENERATE_WILD_YAMS = tag("generate_wild_yams");

    public static final TagKey<Biome> GENERATE_WILD_BARLEY =            tag("generate_wild_barley");
    public static final TagKey<Biome> GENERATE_WILD_BEETROOT =          tag("generate_wild_beetroot");
    public static final TagKey<Biome> GENERATE_WILD_BLUEBERRIES =       tag("generate_wild_blueberries");
    public static final TagKey<Biome> GENERATE_WILD_BROAD_BEAN =        tag("generate_wild_broad_bean");
    public static final TagKey<Biome> GENERATE_WILD_CABBAGE =           tag("generate_wild_cabbage");
    public static final TagKey<Biome> GENERATE_WILD_CARROT =            tag("generate_wild_carrot");
    public static final TagKey<Biome> GENERATE_WILD_CHARD =             tag("generate_wild_chard");
    public static final TagKey<Biome> GENERATE_WILD_DOGBANE =           tag("generate_wild_dogbane");
    public static final TagKey<Biome> GENERATE_WILD_FLAX =              tag("generate_wild_flax");
    public static final TagKey<Biome> GENERATE_WILD_GARLIC =            tag("generate_wild_garlic");
    public static final TagKey<Biome> GENERATE_WILD_GREEN_PUMPKIN =     tag("generate_wild_green_pumpkin");
    public static final TagKey<Biome> GENERATE_WILD_LEEK =              tag("generate_wild_leek");
    public static final TagKey<Biome> GENERATE_WILD_MELON =             tag("generate_wild_melon");
    public static final TagKey<Biome> GENERATE_WILD_NAPA_CABBAGE =      tag("generate_wild_napa_cabbage");
    public static final TagKey<Biome> GENERATE_WILD_NETTLE =            tag("generate_wild_nettle");
    public static final TagKey<Biome> GENERATE_WILD_OATS =              tag("generate_wild_oats");
    public static final TagKey<Biome> GENERATE_WILD_PARSNIP =           tag("generate_wild_parsnip");
    public static final TagKey<Biome> GENERATE_WILD_POTATO =            tag("generate_wild_potato");
    public static final TagKey<Biome> GENERATE_WILD_PUMPKIN =           tag("generate_wild_pumpkin");
    public static final TagKey<Biome> GENERATE_WILD_PURPLE_CARROT =     tag("generate_wild_purple_carrot");
    public static final TagKey<Biome> GENERATE_WILD_PURPLE_ONION =      tag("generate_wild_purple_onion");
    public static final TagKey<Biome> GENERATE_WILD_PURPLE_SKIRRET =    tag("generate_wild_skirret");
    public static final TagKey<Biome> GENERATE_WILD_RADISH =            tag("generate_wild_radish");
    public static final TagKey<Biome> GENERATE_WILD_RASPBERRIES =       tag("generate_wild_raspberries");
    public static final TagKey<Biome> GENERATE_WILD_SKIRRET =           tag("generate_wild_skirret");
    public static final TagKey<Biome> GENERATE_WILD_SPINACH =           tag("generate_wild_spinach");
    public static final TagKey<Biome> GENERATE_WILD_STRAWBERRIES =      tag("generate_wild_strawberries");
    public static final TagKey<Biome> GENERATE_WILD_TURNIP =            tag("generate_wild_turnip");
    public static final TagKey<Biome> GENERATE_WILD_WHITE_CARROT =      tag("generate_wild_white_carrot");
    public static final TagKey<Biome> GENERATE_WILD_WHITE_ONION =       tag("generate_wild_white_onion");
    public static final TagKey<Biome> GENERATE_WILD_YAM =               tag("generate_wild_yam");
    public static final TagKey<Biome> GENERATE_WILD_WHEAT =             tag("generate_wild_wheat");
}
