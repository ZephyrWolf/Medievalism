package io.github.zephyrwolf.medievalism.data.base.tag;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.world.level.BiomeTagCatalog;
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

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        // Branches
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

        //region Twigs
        tag(BiomeTagCatalog.HAS_DENSE_TREES)
                .addTags(
                        BiomeTagCatalog.HAS_DENSE_OAK_TREES,
                        BiomeTagCatalog.HAS_DENSE_JUNGLE_TREES,
                        BiomeTagCatalog.HAS_DENSE_SPRUCE_TREES,
                        BiomeTagCatalog.HAS_DENSE_BIRCH_TREES,
                        BiomeTagCatalog.HAS_DENSE_DARK_OAK_TREES,
                        BiomeTagCatalog.HAS_DENSE_CHERRY_TREES,
                        BiomeTagCatalog.HAS_DENSE_MANGROVE_TREES
                );
        tag(BiomeTagCatalog.HAS_SPARSE_TREES)
                .addTags(
                        BiomeTagCatalog.HAS_SPARSE_OAK_TREES,
                        BiomeTagCatalog.HAS_SPARSE_JUNGLE_TREES,
                        BiomeTagCatalog.HAS_SPARSE_SPRUCE_TREES,
                        BiomeTagCatalog.HAS_SPARSE_BIRCH_TREES,
                        BiomeTagCatalog.HAS_SPARSE_ACACIA_TREES
                );
        tag(BiomeTagCatalog.HAS_RARE_TREES)
                .addTags(
                        BiomeTagCatalog.HAS_RARE_OAK_TREES,
                        BiomeTagCatalog.HAS_RARE_BIRCH_TREES
                );
        //endregion

        // SURFACE SAND
        tag(BiomeTagCatalog.IS_SURFACE_WITH_SAND).add(
                Biomes.BEACH,
                Biomes.SNOWY_BEACH,
                Biomes.DESERT
        );
        tag(BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND).add(
                Biomes.BADLANDS,
                Biomes.ERODED_BADLANDS,
                Biomes.WOODED_BADLANDS
        );
        tag(BiomeTagCatalog.IS_SURFACE_WITHOUT_SAND)
                .addTags(BiomeTags.IS_OVERWORLD)
                .remove(BiomeTagCatalog.IS_SURFACE_WITH_SAND)
                .remove(BiomeTagCatalog.IS_SURFACE_WITH_RED_SAND);

        tag(BiomeTagCatalog.GENERATE_INLAND_CLAY)
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

        // Wild Crops
        tag(BiomeTagCatalog.GENERATE_WILD_YAMS)
                .add(
                        Biomes.SWAMP,
                        Biomes.JUNGLE,
                        Biomes.BAMBOO_JUNGLE,
                        Biomes.SPARSE_JUNGLE,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.SAVANNA,
                        Biomes.WINDSWEPT_SAVANNA
                );
    }
}
