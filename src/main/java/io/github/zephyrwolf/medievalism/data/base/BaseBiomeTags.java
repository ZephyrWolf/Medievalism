package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public final class BaseBiomeTags extends BiomeTagsProvider
{
    public BaseBiomeTags(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> provider,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super (output, provider, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        tag(ModBiomeTags.HAS_TREES)
                .add(
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.FOREST,
                        Biomes.FLOWER_FOREST,
                        Biomes.BIRCH_FOREST,
                        Biomes.DARK_FOREST,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.TAIGA,
                        Biomes.SNOWY_TAIGA,
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.JUNGLE,
                        Biomes.SPARSE_JUNGLE,
                        Biomes.WOODED_BADLANDS,
                        Biomes.CHERRY_GROVE,
                        Biomes.GROVE
                );
        tag(ModBiomeTags.HAS_DENSE_TRESS)
                .addTag(BiomeTags.IS_FOREST)
                .add(
                        Biomes.MANGROVE_SWAMP,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.TAIGA,
                        Biomes.SNOWY_TAIGA,
                        Biomes.JUNGLE,
                        Biomes.CHERRY_GROVE
                );
    }
}
