package io.github.zephyrwolf.medievalism.data.overhauldata.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
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
        this.registerWoodenTags();
        this.registerStoneTags();
        this.registerModTags();
        this.registerCommonModTags();
        this.registerCompatibilityTags();
    }

    protected void registerWoodenTags()
    {
        // TODO Change to REQUIRES_TOOL_FOR_DROPS
        tag(BlockTagCatalog.REQUIRES_AXE_FOR_DROPS) // Add on Overhaul
                .addTag(BlockTags.LOGS);

        //tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)  // for some reason this is running before BaseBlockTagsProvider :?
        //        .addTag(BlockTagCatalog.SEDIMENTARY_WG_STONES);
    }

    protected void registerStoneTags()
    {
        //tag(BlockTagCatalog.NEEDS_COPPER_TOOL) // Wood
        //        .addTag(BlockTagCatalog.TRAVERTINE_BLOCKS);
        //tag(BlockTagCatalog.NEEDS_WROUGHT_IRON_TOOL) // Iron // Running before Base???
        //        .addTag(BlockTagCatalog.ANDESITE_BLOCKS)    // (wood) = overhaul
        //        .addTag(BlockTagCatalog.BASALT_BLOCKS)      // (wood) = overhaul
        //        .addTag(BlockTagCatalog.GABBRO_BLOCKS)      // (wood) = overhaul
        //        .addTag(BlockTagCatalog.DIORITE_BLOCKS)     // (wood) = overhaul
        //        .addTag(BlockTagCatalog.GRANITE_BLOCKS);    // (wood) = overhaul

        /*
        tag(BlockTagCatalog.INCORRECT_FOR_PRIMITIVE_TOOL)
                .addTag(BlockTagCatalog.SEDIMENTARY_STONES)
                .addTag(BlockTagCatalog.METAMORPHIC_STONES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_STONES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_STONES)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_STONES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_STONES);

        tag(BlockTagCatalog.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTagCatalog.METAMORPHIC_STONES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_STONES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_STONES)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_STONES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_STONES);

        tag(BlockTagCatalog.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_STONES)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_STONES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_STONES);

        tag(BlockTagCatalog.INCORRECT_FOR_WROUGHT_IRON_TOOL)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_STONES);
         */
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
