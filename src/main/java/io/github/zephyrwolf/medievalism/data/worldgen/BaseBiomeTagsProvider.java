package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.worldgen.BiomeTagCatalog;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public final class BaseBiomeTagsProvider extends BiomeTagsProvider
{
    public BaseBiomeTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> provider,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super (output, provider, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        //region Biomes by Tree Type
        //region Oak
        tag(BiomeTagCatalog.HAS_DENSE_OAK_TREES)
                .add(
                        Biomes.FOREST,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.WOODED_BADLANDS,
                        Biomes.SWAMP
                );
        tag(BiomeTagCatalog.HAS_SPARSE_OAK_TREES)
                .add(Biomes.FLOWER_FOREST);
        tag(BiomeTagCatalog.HAS_RARE_OAK_TREES)
                .add(Biomes.PLAINS);
        //endregion
        //region Birch
        tag(BiomeTagCatalog.HAS_DENSE_BIRCH_TREES)
                .add(
                        Biomes.BIRCH_FOREST,
                        Biomes.OLD_GROWTH_BIRCH_FOREST
                );
        tag(BiomeTagCatalog.HAS_SPARSE_BIRCH_TREES)
                .add(Biomes.FLOWER_FOREST);
        tag(BiomeTagCatalog.HAS_RARE_BIRCH_TREES)
                .add(Biomes.FOREST);
        //endregion
        //region Spruce
        tag(BiomeTagCatalog.HAS_DENSE_SPRUCE_TREES)
                .add(
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.TAIGA,
                        Biomes.SNOWY_TAIGA,
                        Biomes.GROVE
                );
        tag(BiomeTagCatalog.HAS_SPARSE_SPRUCE_TREES)
                .add(
                        Biomes.GROVE
                );
        //endregion
        //region Jungle
        tag(BiomeTagCatalog.HAS_DENSE_JUNGLE_TREES)
                .add(
                        Biomes.JUNGLE
                );
        tag(BiomeTagCatalog.HAS_SPARSE_JUNGLE_TREES)
                .add(
                        Biomes.SPARSE_JUNGLE
                );
        //endregion
        //region Dark Oak
        tag(BiomeTagCatalog.HAS_DENSE_DARK_OAK_TREES)
                .add(
                        Biomes.DARK_FOREST
                );
        //endregion
        //region Acacia
        tag(BiomeTagCatalog.HAS_SPARSE_ACACIA_TREES)
                .add(
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU
                );
        //endregion
        //region Cherry
        tag(BiomeTagCatalog.HAS_DENSE_CHERRY_TREES)
                .add(
                        Biomes.CHERRY_GROVE
                );
        //endregion
        //region Mangrove
        tag(BiomeTagCatalog.HAS_DENSE_MANGROVE_TREES)
                .add(
                        Biomes.MANGROVE_SWAMP
                );
        //endregion
        //endregion

        //region Biomes by Rock type
        tag(BiomeTagCatalog.GENERATE_STONE_ROCK)
                .add(
                        Biomes.PLAINS,
                        Biomes.SUNFLOWER_PLAINS,
                        Biomes.FOREST,
                        Biomes.FLOWER_FOREST,
                        Biomes.BIRCH_FOREST,
                        Biomes.DARK_FOREST,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.MEADOW,
                        Biomes.CHERRY_GROVE
                );
        tag(BiomeTagCatalog.GENERATE_SANDSTONE_ROCK)
                .add(
                        Biomes.DESERT
                );
        tag(BiomeTagCatalog.GENERATE_RED_SANDSTONE_ROCK)
                .add(
                        Biomes.BADLANDS,
                        Biomes.ERODED_BADLANDS,
                        Biomes.WOODED_BADLANDS
                );
        tag(BiomeTagCatalog.GENERATE_MOSSY_ROCK)
                .add(
                        Biomes.TAIGA,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.JUNGLE,
                        Biomes.SPARSE_JUNGLE,
                        Biomes.BAMBOO_JUNGLE
                );
        tag(BiomeTagCatalog.GENERATE_LIGHTER_ROCK)
                .add(
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.WINDSWEPT_SAVANNA
                );
        tag(BiomeTagCatalog.GENERATE_DENSE_STONE_ROCK)
                .add(
                        Biomes.WINDSWEPT_HILLS,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.STONY_PEAKS,
                        Biomes.STONY_SHORE
                );
        tag(BiomeTagCatalog.GENERATE_SNOWY_ROCK)
                .add(
                        Biomes.GROVE,
                        Biomes.JAGGED_PEAKS,
                        Biomes.SNOWY_SLOPES,
                        Biomes.SNOWY_TAIGA,
                        Biomes.SNOWY_BEACH,
                        Biomes.SNOWY_PLAINS,
                        Biomes.FROZEN_RIVER
                );
        tag(BiomeTagCatalog.GENERATE_ICE_ROCK)
                .add(
                        Biomes.ICE_SPIKES,
                        Biomes.FROZEN_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.FROZEN_PEAKS
                );
        tag(BiomeTagCatalog.GENERATE_LIMESTONE_ROCK)
                .add(
                        Biomes.WINDSWEPT_HILLS,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.WINDSWEPT_SAVANNA,
                        Biomes.SNOWY_SLOPES,
                        Biomes.JAGGED_PEAKS,
                        Biomes.STONY_PEAKS
                );
        //endregion

        tag(BiomeTagCatalog.GENERATE_RED_CLAY)
                .addTag(BiomeTags.IS_FOREST)
                .add(
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.RIVER,
                        Biomes.FROZEN_RIVER,
                        Biomes.TAIGA,
                        Biomes.SNOWY_TAIGA,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.JUNGLE,
                        Biomes.SPARSE_JUNGLE,
                        Biomes.BAMBOO_JUNGLE,
                        Biomes.SNOWY_PLAINS
                );
    }
}
