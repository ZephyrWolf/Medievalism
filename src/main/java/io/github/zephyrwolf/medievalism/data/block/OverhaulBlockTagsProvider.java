package io.github.zephyrwolf.medievalism.data.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockTagCatalog;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class OverhaulBlockTagsProvider extends BlockTagsProvider
{
    public OverhaulBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.registerVanillaTags();
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

    protected void registerModTags()
    {
    }

    private void registerCommonModTags()
    {
    }

    private void registerCompatibilityTags()
    {
    }
}
