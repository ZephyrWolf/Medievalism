package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
import io.github.zephyrwolf.medievalism.common.block.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BaseBlockTags extends BlockTagsProvider
{
    public BaseBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
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
        tag(ModBlockTags.REQUIRES_AXE_FOR_DROPS) // Add on Overhaul
                .addTag(BlockTags.LOGS);
    }

    protected void registerBlockMineables()
    {
        // TOOL
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                Registration.BRANCH_BLOCK.get()
        );
        tag(BlockTags.MINEABLE_WITH_HOE).add(
                Registration.THATCH_BLOCK.get()
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                Registration.LIMESTONE_BLOCK.get(),
                Registration.LARGE_ROCK_BLOCK.get(),
                Registration.ROCK_BLOCK.get(),
                Registration.LIMESTONE_ROCK_BLOCK.get(),
                Registration.COPPER_ROCK_BLOCK.get()
        );
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                Registration.RED_CLAY_BLOCK.get()
        );

        // Material
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add( // Vs NEEDS_STONE_TOOL
                Registration.LIMESTONE_BLOCK.get()
        );
        //tag(BlockTags.NEEDS_STONE_TOOL)
        //tag(BlockTags.NEEDS_IRON_TOOL)
        //tag(BlockTags.NEEDS_DIAMOND_TOOL)
    }

    protected void registerModTags()
    {
        tag(ModBlockTags.CAN_DROP_THATCH).add(
                Blocks.SHORT_GRASS,
                Blocks.TALL_GRASS,
                Blocks.FERN
        );
    }

    private void registerCommonModTags()
    {
    }

    private void registerCompatibilityTags()
    {
    }
}
