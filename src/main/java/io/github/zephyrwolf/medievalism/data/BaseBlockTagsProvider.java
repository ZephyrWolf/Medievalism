package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.BlockTagCatalog;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BaseBlockTagsProvider extends BlockTagsProvider
{
    public BaseBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.registerVanillaTags();
        this.registerBlockMineables();
        this.registerModTags();
        this.registerCommonModTags();
        this.registerCompatibilityTags();
    }

    protected void registerVanillaTags()
    { // BlockTags
        // TODO Change to REQUIRES_TOOL_FOR_DROPS
        tag(BlockTagCatalog.REQUIRES_AXE_FOR_DROPS) // Add on Overhaul
                .addTag(BlockTags.LOGS);
    }

    protected void registerBlockMineables()
    {
        // TOOL
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                BlockRegistration.BRANCH_BLOCK.get()
        );
        tag(BlockTags.MINEABLE_WITH_HOE).add(
                BlockRegistration.THATCH_BLOCK.get()
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                BlockRegistration.LIMESTONE_BLOCK.get(),
                BlockRegistration.LARGE_ROCK_BLOCK.get(),
                BlockRegistration.ROCK_BLOCK.get(),
                BlockRegistration.LIMESTONE_ROCK_BLOCK.get(),
                BlockRegistration.COPPER_ROCK_BLOCK.get(),
                BlockRegistration.TIN_ORE_BLOCK.get(),
                BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get()
        );
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                BlockRegistration.RED_CLAY_BLOCK.get()
        );

        // Material
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add( // Vs NEEDS_STONE_TOOL
                BlockRegistration.LIMESTONE_BLOCK.get()
        );
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                BlockRegistration.TIN_ORE_BLOCK.get(),
                BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get()
        );
        //tag(BlockTags.NEEDS_IRON_TOOL)
        //tag(BlockTags.NEEDS_DIAMOND_TOOL)
    }

    protected void registerModTags()
    {
        tag(BlockTagCatalog.CAN_DROP_THATCH).add(
                Blocks.SHORT_GRASS,
                Blocks.TALL_GRASS,
                Blocks.FERN
        );
        tag(BlockTagCatalog.RED_CLAY_CAN_REPLACE)
                .addTag(BlockTags.STONE_ORE_REPLACEABLES)
                .add(Blocks.DIRT);

        tag(BlockTagCatalog.WHITE_BARK).add(
                Blocks.BIRCH_LOG,
                Blocks.BIRCH_WOOD,
                Blocks.MANGROVE_LOG,
                Blocks.MANGROVE_WOOD
        );
        tag(BlockTagCatalog.BROWN_BARK).add(
                Blocks.JUNGLE_LOG,
                Blocks.JUNGLE_WOOD,
                Blocks.CHERRY_LOG,
                Blocks.CHERRY_WOOD,
                Blocks.SPRUCE_LOG,
                Blocks.SPRUCE_WOOD
        );
        tag(BlockTagCatalog.GREY_BARK).add(
                Blocks.ACACIA_LOG,
                Blocks.ACACIA_WOOD
        );
        tag(BlockTagCatalog.DARK_BROWN_BARK).add(
                Blocks.OAK_LOG,
                Blocks.OAK_WOOD
        );
        tag(BlockTagCatalog.BLACK_BARK).add(
                Blocks.DARK_OAK_LOG,
                Blocks.DARK_OAK_WOOD
        );
    }

    private void registerCommonModTags()
    {
    }

    private void registerCompatibilityTags()
    {
    }
}
