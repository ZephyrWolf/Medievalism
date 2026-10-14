package io.github.zephyrwolf.medievalism.data.base.tag;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
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
        // Blocks
        // -Stone
        this.registerStoneBlockVariants();
        this.registerStoneBlockMining();
        this.registerOreVariants();

        // -Dirt
        this.registerDirtTags();
        // -Wood
        this.registerWoodBlocks();

        // -Plants
        this.registerPlantBlocks();

        // World Gen
        this.registerWorldGenStoneLayers();
        this.registerWorldGenFeatureReplaceables();
        this.registerSurfaceDecorationTags();

        this.registerNeoForgeCompatibilityTags();
        //this.registerSpecificModCompatibilityTags();
    }

    // Blocks
    // -Stone
    protected void registerStoneBlockVariants()
    {
        tag(BlockTags.SNAPS_GOAT_HORN).add(
                BlockRegistration.GREYWACKE.get(),
                BlockRegistration.SILTSTONE.get(),
                BlockRegistration.DOLOSTONE.get(),
                BlockRegistration.LIMESTONE.get(),
                BlockRegistration.IRONSTONE.get(),
                BlockRegistration.SHALE.get(),
                BlockRegistration.MARBLE.get(),
                BlockRegistration.QUARTZITE.get(),
                BlockRegistration.HORNFELS.get(),
                BlockRegistration.SLATE.get(),
                BlockRegistration.ARKOSE.get(),
                BlockRegistration.GABBRO.get(),
                BlockRegistration.SMOOTH_DIORITE.get(),
                BlockRegistration.ROUGH_DIORITE.get(),
                BlockRegistration.SMOOTH_GRANITE.get(),
                BlockRegistration.ROUGH_GRANITE.get(),
                BlockRegistration.NORITE.get(),
                BlockRegistration.PERIDOTITE.get(),
                BlockRegistration.TRAVERTINE.get(),
                BlockRegistration.RHYOLITE.get(),
                BlockRegistration.DACITE.get(),
                BlockRegistration.ANDESITE.get(),
                BlockRegistration.BASALT.get()
        );

        tag(BlockTagCatalog.OVERHAULED_VANILLA_ORE_REPLACEABLES).add(
                BlockRegistration.GREYWACKE.get(),
                BlockRegistration.TRAVERTINE.get(),
                BlockRegistration.GABBRO.get(),
                BlockRegistration.ROUGH_DIORITE.get(),
                BlockRegistration.ROUGH_GRANITE.get(),
                BlockRegistration.WELDED_TUFF.get(),
                BlockRegistration.ANDESITE.get(),
                BlockRegistration.BASALT.get()
        );

        tag(BlockTagCatalog.TRAVERTINE_BLOCKS).add(
                BlockRegistration.TRAVERTINE.get(),
                Blocks.POINTED_DRIPSTONE
        );

        tag(BlockTagCatalog.SOFT_TUFF_BLOCKS).add(
                BlockRegistration.SOFT_TUFF.get()
        );

        tag(BlockTagCatalog.IGNIMBRITE_BLOCKS).add(
                BlockRegistration.IGNIMBRITE.get()
        );

        tag(BlockTagCatalog.LAPILLISTONE_BLOCKS).add(
                BlockRegistration.LAPILLISTONE.get()
        );

        tag(BlockTagCatalog.WELDED_TUFF_BLOCKS).add(
                BlockRegistration.WELDED_TUFF.get()
        );

        tag(BlockTagCatalog.SANDSTONE_BLOCKS).add(
                Blocks.SANDSTONE,
                Blocks.SANDSTONE_SLAB,
                Blocks.SANDSTONE_STAIRS,
                Blocks.SANDSTONE_WALL,
                Blocks.CUT_SANDSTONE,
                Blocks.CUT_SANDSTONE_SLAB,
                Blocks.RED_SANDSTONE,
                Blocks.RED_SANDSTONE_SLAB,
                Blocks.RED_SANDSTONE_STAIRS,
                Blocks.RED_SANDSTONE_WALL,
                Blocks.CUT_RED_SANDSTONE,
                Blocks.CUT_RED_SANDSTONE_SLAB,
                BlockRegistration.COBBLED_SANDSTONE.get(),
                BlockRegistration.COBBLED_RED_SANDSTONE.get()
        );

        tag(BlockTagCatalog.SAPROLITE_BLOCKS).add(
                BlockRegistration.SAPROLITE.get(),
                BlockRegistration.COBBLED_SAPROLITE.get()
        );

        tag(BlockTagCatalog.LATERITE_BLOCKS).add(
                BlockRegistration.LATERITE.get(),
                BlockRegistration.COBBLED_LATERITE.get()
        );

        tag(BlockTagCatalog.GREYWACKE_BLOCKS).add(
                Blocks.STONE,
                Blocks.STONE_SLAB,
                Blocks.STONE_STAIRS,
                Blocks.INFESTED_STONE,
                Blocks.STONE_BRICKS,
                Blocks.STONE_BRICK_SLAB,
                Blocks.STONE_BRICK_STAIRS,
                Blocks.STONE_BRICK_WALL,
                Blocks.MOSSY_STONE_BRICKS,
                Blocks.MOSSY_STONE_BRICK_SLAB,
                Blocks.MOSSY_STONE_BRICK_STAIRS,
                Blocks.MOSSY_STONE_BRICK_WALL,
                Blocks.CHISELED_STONE_BRICKS,
                Blocks.CRACKED_STONE_BRICKS,
                Blocks.INFESTED_CHISELED_STONE_BRICKS,
                Blocks.INFESTED_CRACKED_STONE_BRICKS,
                Blocks.INFESTED_MOSSY_STONE_BRICKS,
                Blocks.SMOOTH_STONE,
                Blocks.SMOOTH_STONE_SLAB,
                Blocks.COBBLESTONE,
                Blocks.COBBLESTONE_SLAB,
                Blocks.COBBLESTONE_STAIRS,
                Blocks.COBBLESTONE_WALL,
                Blocks.INFESTED_COBBLESTONE,
                Blocks.MOSSY_COBBLESTONE,
                Blocks.MOSSY_COBBLESTONE_SLAB,
                Blocks.MOSSY_COBBLESTONE_STAIRS,
                Blocks.MOSSY_COBBLESTONE_WALL,
                BlockRegistration.GREYWACKE.get(),
                BlockRegistration.COBBLED_GREYWACKE.get()
        );

        tag(BlockTagCatalog.SILTSTONE_BLOCKS).add(
                BlockRegistration.SILTSTONE.get(),
                BlockRegistration.COBBLED_SILTSTONE.get()
        );

        tag(BlockTagCatalog.DOLOSTONE_BLOCKS).add(
                BlockRegistration.DOLOSTONE.get(),
                BlockRegistration.COBBLED_DOLOSTONE.get()
        );

        tag(BlockTagCatalog.LIMESTONE_BLOCKS).add(
                BlockRegistration.LIMESTONE.get(),
                BlockRegistration.LIMESTONE_CHERT_ORE.get()
        );

        tag(BlockTagCatalog.CHALK_BLOCKS).add(
                BlockRegistration.CHALK.get(),
                BlockRegistration.CHALK_CHERT_ORE.get()
        );

        tag(BlockTagCatalog.IRONSTONE_BLOCKS).add(
                BlockRegistration.IRONSTONE.get(),
                BlockRegistration.COBBLED_IRONSTONE.get()
        );

        tag(BlockTagCatalog.SHALE_BLOCKS).add(
                BlockRegistration.SHALE.get(),
                BlockRegistration.COBBLED_SHALE.get()
        );

        tag(BlockTagCatalog.ARKOSE_BLOCKS).add(
                BlockRegistration.ARKOSE.get(),
                BlockRegistration.COBBLED_ARKOSE.get()
        );

        tag(BlockTagCatalog.MARBLE_BLOCKS).add(
                BlockRegistration.MARBLE.get()
        );

        tag(BlockTagCatalog.QUARTZITE_BLOCKS).add(
                BlockRegistration.QUARTZITE.get()
        );

        tag(BlockTagCatalog.HORNFELS_BLOCKS).add(
                BlockRegistration.HORNFELS.get()
        );

        tag(BlockTagCatalog.SLATE_BLOCKS).add(
                BlockRegistration.SLATE.get()
        );

        tag(BlockTagCatalog.BASALT_BLOCKS).add(
                Blocks.SMOOTH_BASALT,
                Blocks.BASALT,
                Blocks.POLISHED_BASALT,
                BlockRegistration.BASALT.get(),
                BlockRegistration.BASALT_GEODE_ORE.get()
        );

        tag(BlockTagCatalog.ANDESITE_BLOCKS).add(
                Blocks.ANDESITE,
                Blocks.ANDESITE_SLAB,
                Blocks.ANDESITE_STAIRS,
                Blocks.ANDESITE_WALL,
                Blocks.POLISHED_ANDESITE,
                Blocks.POLISHED_ANDESITE_SLAB,
                Blocks.POLISHED_ANDESITE_STAIRS,
                BlockRegistration.ANDESITE.get(),
                BlockRegistration.ANDESITE_GEODE_ORE.get()
        );

        tag(BlockTagCatalog.RHYOLITE_BLOCKS).add(
                BlockRegistration.RHYOLITE.get(),
                BlockRegistration.RHYOLITE_GEODE_ORE.get()
        );
        tag(BlockTagCatalog.DACITE_ORE_REPLACEABLES).add(
                BlockRegistration.DACITE.get()
        );

        tag(BlockTagCatalog.DACITE_BLOCKS).add(
                BlockRegistration.DACITE.get(),
                BlockRegistration.DACITE_GEODE_ORE.get()
        );

        tag(BlockTagCatalog.GRANITE_BLOCKS).add(
                Blocks.GRANITE,
                Blocks.GRANITE_SLAB,
                Blocks.GRANITE_STAIRS,
                Blocks.GRANITE_WALL,
                Blocks.POLISHED_GRANITE,
                Blocks.POLISHED_GRANITE_SLAB,
                Blocks.POLISHED_GRANITE_STAIRS,
                BlockRegistration.SMOOTH_GRANITE.get(),
                BlockRegistration.ROUGH_GRANITE.get()
        );

        tag(BlockTagCatalog.DIORITE_BLOCKS).add(
                Blocks.DIORITE,
                Blocks.DIORITE_SLAB,
                Blocks.DIORITE_STAIRS,
                Blocks.DIORITE_WALL,
                Blocks.POLISHED_DIORITE,
                Blocks.POLISHED_DIORITE_SLAB,
                Blocks.POLISHED_DIORITE_STAIRS,
                BlockRegistration.SMOOTH_DIORITE.get(),
                BlockRegistration.ROUGH_DIORITE.get()
        );

        tag(BlockTagCatalog.GABBRO_BLOCKS).add(
                Blocks.DEEPSLATE,
                Blocks.COBBLED_DEEPSLATE,
                Blocks.COBBLED_DEEPSLATE_STAIRS,
                Blocks.COBBLED_DEEPSLATE_SLAB,
                Blocks.COBBLED_DEEPSLATE_WALL,
                Blocks.POLISHED_DEEPSLATE,
                Blocks.POLISHED_DEEPSLATE_SLAB,
                Blocks.POLISHED_DEEPSLATE_STAIRS,
                Blocks.POLISHED_DEEPSLATE_WALL,
                Blocks.DEEPSLATE_TILES,
                Blocks.DEEPSLATE_TILE_SLAB,
                Blocks.DEEPSLATE_TILE_STAIRS,
                Blocks.DEEPSLATE_TILE_WALL,
                Blocks.DEEPSLATE_BRICKS,
                Blocks.DEEPSLATE_BRICK_SLAB,
                Blocks.DEEPSLATE_BRICK_STAIRS,
                Blocks.DEEPSLATE_BRICK_WALL,
                Blocks.CHISELED_DEEPSLATE,
                Blocks.CRACKED_DEEPSLATE_TILES,
                Blocks.CRACKED_DEEPSLATE_BRICKS,
                Blocks.INFESTED_DEEPSLATE,
                BlockRegistration.GABBRO.get()
        );

        tag(BlockTagCatalog.NORITE_BLOCKS).add(
                BlockRegistration.NORITE.get()
        );

        tag(BlockTagCatalog.PERIDOTITE_BLOCKS).add(
                BlockRegistration.PERIDOTITE.get()
        );

        tag(BlockTagCatalog.CALCITE_BLOCKS).add(
                BlockRegistration.CALCITE.get()
        );

        tag(BlockTagCatalog.SOFT_TUFF_ORE_REPLACEABLES).add( BlockRegistration.SOFT_TUFF.get() );
        tag(BlockTagCatalog.IGNIMBRITE_ORE_REPLACEABLES).add( BlockRegistration.IGNIMBRITE.get() );
        tag(BlockTagCatalog.LAPILLISTONE_ORE_REPLACEABLES).add( BlockRegistration.LAPILLISTONE.get() );
        tag(BlockTagCatalog.WELDED_TUFF_ORE_REPLACEABLES).add( BlockRegistration.WELDED_TUFF.get() );
        tag(BlockTagCatalog.SANDSTONE_ORE_REPLACEABLES).add( BlockRegistration.SANDSTONE.get() );
        tag(BlockTagCatalog.RED_SANDSTONE_ORE_REPLACEABLES).add( BlockRegistration.RED_SANDSTONE.get() );
        tag(BlockTagCatalog.SAPROLITE_ORE_REPLACEABLES).add( BlockRegistration.SAPROLITE.get() );
        tag(BlockTagCatalog.LATERITE_ORE_REPLACEABLES).add( BlockRegistration.LATERITE.get() );
        tag(BlockTagCatalog.GREYWACKE_ORE_REPLACEABLES).add( BlockRegistration.GREYWACKE.get() );
        tag(BlockTagCatalog.SILTSTONE_ORE_REPLACEABLES).add( BlockRegistration.SILTSTONE.get() );
        tag(BlockTagCatalog.DOLOSTONE_ORE_REPLACEABLES).add( BlockRegistration.DOLOSTONE.get() );
        tag(BlockTagCatalog.LIMESTONE_ORE_REPLACEABLES).add( BlockRegistration.LIMESTONE.get() );
        tag(BlockTagCatalog.CHALK_ORE_REPLACEABLES).add( BlockRegistration.CHALK.get() );
        tag(BlockTagCatalog.IRONSTONE_ORE_REPLACEABLES).add( BlockRegistration.IRONSTONE.get() );
        tag(BlockTagCatalog.SHALE_ORE_REPLACEABLES).add( BlockRegistration.SHALE.get() );
        tag(BlockTagCatalog.ARKOSE_ORE_REPLACEABLES).add( BlockRegistration.ARKOSE.get() );
        tag(BlockTagCatalog.MARBLE_ORE_REPLACEABLES).add( BlockRegistration.MARBLE.get() );
        tag(BlockTagCatalog.QUARTZITE_ORE_REPLACEABLES).add( BlockRegistration.QUARTZITE.get() );
        tag(BlockTagCatalog.HORNFELS_ORE_REPLACEABLES).add( BlockRegistration.HORNFELS.get() );
        tag(BlockTagCatalog.SLATE_ORE_REPLACEABLES).add( BlockRegistration.SLATE.get() );
        tag(BlockTagCatalog.GABBRO_ORE_REPLACEABLES).add( BlockRegistration.GABBRO.get() );
        tag(BlockTagCatalog.SMOOTH_DIORITE_ORE_REPLACEABLES).add( BlockRegistration.SMOOTH_DIORITE.get() );
        tag(BlockTagCatalog.SMOOTH_GRANITE_ORE_REPLACEABLES).add( BlockRegistration.SMOOTH_GRANITE.get() );
        tag(BlockTagCatalog.NORITE_ORE_REPLACEABLES).add( BlockRegistration.NORITE.get() );
        tag(BlockTagCatalog.PERIDOTITE_ORE_REPLACEABLES).add( BlockRegistration.PERIDOTITE.get() );
        tag(BlockTagCatalog.TRAVERTINE_ORE_REPLACEABLES).add( BlockRegistration.TRAVERTINE.get() );
        tag(BlockTagCatalog.RHYOLITE_ORE_REPLACEABLES).add( BlockRegistration.RHYOLITE.get() );
        tag(BlockTagCatalog.DACITE_ORE_REPLACEABLES).add( BlockRegistration.DACITE.get() );
        tag(BlockTagCatalog.ANDESITE_ORE_REPLACEABLES).add( BlockRegistration.ANDESITE.get() );
        tag(BlockTagCatalog.BASALT_ORE_REPLACEABLES).add( BlockRegistration.BASALT.get() );
    }

    protected void registerStoneBlockMining()
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTagCatalog.SOFT_TUFF_BLOCKS)               // Ashfall
                .addTag(BlockTagCatalog.IGNIMBRITE_BLOCKS)
                .addTag(BlockTagCatalog.LAPILLISTONE_BLOCKS)
                .addTag(BlockTagCatalog.WELDED_TUFF_BLOCKS)
                .addTag(BlockTagCatalog.SANDSTONE_BLOCKS)               // Regolith
                .addTag(BlockTagCatalog.SAPROLITE_BLOCKS)
                .addTag(BlockTagCatalog.LATERITE_BLOCKS)
                .addTag(BlockTagCatalog.GREYWACKE_BLOCKS)               // Sedimentary
                .addTag(BlockTagCatalog.SILTSTONE_BLOCKS)
                .addTag(BlockTagCatalog.DOLOSTONE_BLOCKS)
                .addTag(BlockTagCatalog.LIMESTONE_BLOCKS)
                .addTag(BlockTagCatalog.CHALK_BLOCKS)
                .addTag(BlockTagCatalog.IRONSTONE_BLOCKS)
                .addTag(BlockTagCatalog.SHALE_BLOCKS)
                .addTag(BlockTagCatalog.ARKOSE_BLOCKS)
                .addTag(BlockTagCatalog.LIMESTONE_BLOCKS)               // Metamorphic
                .addTag(BlockTagCatalog.CHALK_BLOCKS)
                .addTag(BlockTagCatalog.IRONSTONE_BLOCKS)
                .addTag(BlockTagCatalog.SHALE_BLOCKS)
                .addTag(BlockTagCatalog.BASALT_BLOCKS)                  // Hard Igneous Extrusive
                .addTag(BlockTagCatalog.ANDESITE_BLOCKS)
                .addTag(BlockTagCatalog.RHYOLITE_BLOCKS)                // Soft Igneous Extrusive
                .addTag(BlockTagCatalog.DACITE_BLOCKS)
                .addTag(BlockTagCatalog.GABBRO_BLOCKS)                  // Igneous Extrusive
                .addTag(BlockTagCatalog.PERIDOTITE_BLOCKS)
                .addTag(BlockTagCatalog.GRANITE_BLOCKS)
                .addTag(BlockTagCatalog.DIORITE_BLOCKS)
                .addTag(BlockTagCatalog.NORITE_BLOCKS)                  // Deep Igneous Extrusive
                .addTag(BlockTagCatalog.TRAVERTINE_BLOCKS)              // other
                .addTag(BlockTagCatalog.CALCITE_BLOCKS);

        tag(BlockTagCatalog.NEEDS_PRIMITIVE_TOOL)
                .addTag(BlockTagCatalog.SOFT_TUFF_BLOCKS)               // Ashfall
                .addTag(BlockTagCatalog.IGNIMBRITE_BLOCKS)
                .addTag(BlockTagCatalog.LAPILLISTONE_BLOCKS)
                .addTag(BlockTagCatalog.WELDED_TUFF_BLOCKS)             // TODO This is harder in vanilla
                .addTag(BlockTagCatalog.SANDSTONE_BLOCKS)               // Regolith
                .addTag(BlockTagCatalog.SAPROLITE_BLOCKS)
                .addTag(BlockTagCatalog.LATERITE_BLOCKS)
                .addTag(BlockTagCatalog.CHALK_BLOCKS);                  // Sedimentary Exception

        tag(BlockTagCatalog.NEEDS_COPPER_TOOL)
                .addTag(BlockTagCatalog.GREYWACKE_BLOCKS)               // Sedimentary
                .addTag(BlockTagCatalog.SILTSTONE_BLOCKS)
                .addTag(BlockTagCatalog.DOLOSTONE_BLOCKS)
                .addTag(BlockTagCatalog.LIMESTONE_BLOCKS)
                .addTag(BlockTagCatalog.IRONSTONE_BLOCKS)
                .addTag(BlockTagCatalog.SHALE_BLOCKS)
                .addTag(BlockTagCatalog.ARKOSE_BLOCKS);

        tag(BlockTagCatalog.NEEDS_BRONZE_TOOL) // Stone // No override
                .addTag(BlockTagCatalog.MARBLE_BLOCKS)                  // Metamorphic
                .addTag(BlockTagCatalog.QUARTZITE_BLOCKS)
                .addTag(BlockTagCatalog.HORNFELS_BLOCKS)
                .addTag(BlockTagCatalog.SLATE_BLOCKS)
                .addTag(BlockTagCatalog.RHYOLITE_BLOCKS)                // Soft Igneous Extrusive
                .addTag(BlockTagCatalog.DACITE_BLOCKS);

        tag(BlockTagCatalog.NEEDS_WROUGHT_IRON_TOOL) // Iron
                //.addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_STONES) // andesite & basalt (stone) = overhaul
                //.addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_STONES); // gabbro, diorite & granite (stone) = overhaul
        .add(
                BlockRegistration.SMOOTH_DIORITE.get(),                 // Igneous Intrusive
                BlockRegistration.SMOOTH_GRANITE.get()
        );

        tag(BlockTagCatalog.NEEDS_STEEL_TOOL) // Diamond
                .addTag(BlockTagCatalog.NORITE_BLOCKS)
                .addTag(BlockTagCatalog.PERIDOTITE_BLOCKS);

        tag(BlockTagCatalog.NEEDS_NETHERITE_TOOL);
    }

    protected void registerOreVariants()
    {
        tag(Tags.Blocks.ORES_COPPER).add(
                BlockRegistration.GREYWACKE_COPPER_ORE.get(),
                BlockRegistration.SILTSTONE_COPPER_ORE.get(),
                BlockRegistration.DOLOSTONE_COPPER_ORE.get(),
                BlockRegistration.LIMESTONE_COPPER_ORE.get(),
                BlockRegistration.CHALK_COPPER_ORE.get(),
                BlockRegistration.IRONSTONE_COPPER_ORE.get(),
                BlockRegistration.SHALE_COPPER_ORE.get(),
                BlockRegistration.ARKOSE_COPPER_ORE.get(),
                BlockRegistration.MARBLE_COPPER_ORE.get(),
                BlockRegistration.QUARTZITE_COPPER_ORE.get(),
                BlockRegistration.HORNFELS_COPPER_ORE.get(),
                BlockRegistration.SLATE_COPPER_ORE.get()
        );
        tag(Tags.Blocks.ORES_IRON).add(
                BlockRegistration.GABBRO_IRON_ORE.get(),
                BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get(),
                BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get(),
                BlockRegistration.NORITE_IRON_ORE.get(),
                BlockRegistration.PERIDOTITE_IRON_ORE.get(),
                BlockRegistration.RHYOLITE_IRON_ORE.get(),
                BlockRegistration.DACITE_IRON_ORE.get(),
                BlockRegistration.ANDESITE_IRON_ORE.get(),
                BlockRegistration.BASALT_IRON_ORE.get()
        );
        tag(Tags.Blocks.ORES_GOLD).add(
                BlockRegistration.GREYWACKE_GOLD_ORE.get(),
                BlockRegistration.SILTSTONE_GOLD_ORE.get(),
                BlockRegistration.DOLOSTONE_GOLD_ORE.get(),
                BlockRegistration.LIMESTONE_GOLD_ORE.get(),
                BlockRegistration.CHALK_GOLD_ORE.get(),
                BlockRegistration.IRONSTONE_GOLD_ORE.get(),
                BlockRegistration.SHALE_GOLD_ORE.get(),
                BlockRegistration.ARKOSE_GOLD_ORE.get(),
                BlockRegistration.MARBLE_GOLD_ORE.get(),
                BlockRegistration.QUARTZITE_GOLD_ORE.get(),
                BlockRegistration.HORNFELS_GOLD_ORE.get(),
                BlockRegistration.SLATE_GOLD_ORE.get(),
                BlockRegistration.GABBRO_GOLD_ORE.get(),
                BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get(),
                BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get(),
                BlockRegistration.NORITE_GOLD_ORE.get(),
                BlockRegistration.PERIDOTITE_GOLD_ORE.get(),
                BlockRegistration.RHYOLITE_GOLD_ORE.get(),
                BlockRegistration.DACITE_GOLD_ORE.get(),
                BlockRegistration.ANDESITE_GOLD_ORE.get(),
                BlockRegistration.BASALT_GOLD_ORE.get()
        );
        tag(Tags.Blocks.ORES_COAL).add(
                BlockRegistration.SAPROLITE_COAL_ORE.get(),
                BlockRegistration.LATERITE_COAL_ORE.get(),
                BlockRegistration.GREYWACKE_COAL_ORE.get(),
                BlockRegistration.SILTSTONE_COAL_ORE.get(),
                BlockRegistration.DOLOSTONE_COAL_ORE.get(),
                BlockRegistration.LIMESTONE_COAL_ORE.get(),
                BlockRegistration.CHALK_COAL_ORE.get(),
                BlockRegistration.IRONSTONE_COAL_ORE.get(),
                BlockRegistration.SHALE_COAL_ORE.get(),
                BlockRegistration.ARKOSE_COAL_ORE.get(),
                BlockRegistration.MARBLE_COAL_ORE.get(),
                BlockRegistration.QUARTZITE_COAL_ORE.get(),
                BlockRegistration.HORNFELS_COAL_ORE.get(),
                BlockRegistration.SLATE_COAL_ORE.get()
        );
        tag(Tags.Blocks.ORES_DIAMOND).add(
                BlockRegistration.GABBRO_DIAMOND_ORE.get(),
                BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(),
                BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(),
                BlockRegistration.NORITE_DIAMOND_ORE.get(),
                BlockRegistration.PERIDOTITE_DIAMOND_ORE.get(),
                BlockRegistration.ANDESITE_DIAMOND_ORE.get(),
                BlockRegistration.BASALT_DIAMOND_ORE.get()
        );
        tag(Tags.Blocks.ORES_EMERALD).add(
                BlockRegistration.GABBRO_EMERALD_ORE.get(),
                BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(),
                BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(),
                BlockRegistration.NORITE_EMERALD_ORE.get(),
                BlockRegistration.PERIDOTITE_EMERALD_ORE.get(),
                BlockRegistration.RHYOLITE_EMERALD_ORE.get(),
                BlockRegistration.DACITE_EMERALD_ORE.get(),
                BlockRegistration.ANDESITE_EMERALD_ORE.get(),
                BlockRegistration.BASALT_EMERALD_ORE.get()
        );
        tag(Tags.Blocks.ORES_LAPIS).add(
                BlockRegistration.MARBLE_LAPIS_ORE.get(),
                BlockRegistration.QUARTZITE_LAPIS_ORE.get(),
                BlockRegistration.HORNFELS_LAPIS_ORE.get(),
                BlockRegistration.SLATE_LAPIS_ORE.get()
        );
        tag(Tags.Blocks.ORES_REDSTONE).add(
                BlockRegistration.GABBRO_REDSTONE_ORE.get(),
                BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(),
                BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(),
                BlockRegistration.NORITE_REDSTONE_ORE.get(),
                BlockRegistration.PERIDOTITE_REDSTONE_ORE.get()
        );
    }

    // -Dirt
    protected void registerDirtTags()
    {
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                BlockRegistration.RED_CLAY.get(),
                BlockRegistration.CLAY_IN_GRASS.get(),
                BlockRegistration.RED_CLAY_IN_GRASS.get(),
                BlockRegistration.CLAY_IN_DIRT.get(),
                BlockRegistration.RED_CLAY_IN_DIRT.get(),
                BlockRegistration.SILT.get()
        );

        tag(BlockTags.AZALEA_GROWS_ON).add(
                BlockRegistration.CLAY_IN_GRASS.get(),
                BlockRegistration.RED_CLAY_IN_GRASS.get(),
                BlockRegistration.CLAY_IN_DIRT.get(),
                BlockRegistration.RED_CLAY_IN_DIRT.get(),
                BlockRegistration.SILT.get()
        );

        tag(BlockTags.CONVERTABLE_TO_MUD).add(
                BlockRegistration.SILT.get()
        );

        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(
                BlockRegistration.CLAY_IN_GRASS.get(),
                BlockRegistration.RED_CLAY_IN_GRASS.get(),
                BlockRegistration.CLAY_IN_DIRT.get(),
                BlockRegistration.RED_CLAY_IN_DIRT.get(),
                BlockRegistration.SILT.get()
        );

        tag(BlockTags.DIRT).add(
                BlockRegistration.CLAY_IN_GRASS.get(),
                BlockRegistration.RED_CLAY_IN_GRASS.get(),
                BlockRegistration.CLAY_IN_DIRT.get(),
                BlockRegistration.RED_CLAY_IN_DIRT.get(),
                BlockRegistration.SILT.get()
        );
    }

    // -Wood
    protected void registerWoodBlocks()
    {
        // TOOL
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                BlockRegistration.OAK_BRANCH.get(),
                BlockRegistration.SPRUCE_BRANCH.get(),
                BlockRegistration.BIRCH_BRANCH.get(),
                BlockRegistration.JUNGLE_BRANCH.get(),
                BlockRegistration.DARK_OAK_BRANCH.get(),
                BlockRegistration.ACACIA_BRANCH.get(),
                BlockRegistration.CHERRY_BRANCH.get(),
                BlockRegistration.MANGROVE_BRANCH.get()
        );
    }

    // -Plant
    protected void registerPlantBlocks()
    {
        tag(BlockTags.CROPS).add( // Do not include wild variants as they are not crops that grow on fields
                BlockRegistration.YAMS.get()
        );

        tag(BlockTags.MINEABLE_WITH_HOE).add(
                BlockRegistration.THATCH.get()
        );
    }

    protected void registerWorldGenStoneLayers()
    {
        tag(BlockTagCatalog.REGOLITH_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.LATERITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SAPROLITE_ORE_REPLACEABLES);

        tag(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.GREYWACKE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SILTSTONE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.DOLOSTONE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.LIMESTONE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.CHALK_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.IRONSTONE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SHALE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.ARKOSE_ORE_REPLACEABLES);

        tag(BlockTagCatalog.METAMORPHIC_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.MARBLE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.QUARTZITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.HORNFELS_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SLATE_ORE_REPLACEABLES);

        tag(BlockTagCatalog.IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.GABBRO_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SMOOTH_DIORITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SMOOTH_GRANITE_ORE_REPLACEABLES);

        tag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.NORITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.PERIDOTITE_ORE_REPLACEABLES);

        tag(BlockTagCatalog.ASHFALL_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SOFT_TUFF_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.IGNIMBRITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.LAPILLISTONE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.WELDED_TUFF_ORE_REPLACEABLES);

        tag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.RHYOLITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.DACITE_ORE_REPLACEABLES);

        tag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.ANDESITE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.BASALT_ORE_REPLACEABLES);

        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
                .addTag(BlockTagCatalog.REGOLITH_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.METAMORPHIC_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.ASHFALL_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES);
    }

    protected void registerWorldGenFeatureReplaceables()
    {
        tag(BlockTags.MOSS_REPLACEABLE)
                .addTag(BlockTagCatalog.REGOLITH_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.METAMORPHIC_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.ASHFALL_ORE_REPLACEABLES)
                .add(
                        BlockRegistration.CLAY_IN_GRASS.get(),
                        BlockRegistration.RED_CLAY_IN_GRASS.get(),
                        BlockRegistration.CLAY_IN_DIRT.get(),
                        BlockRegistration.RED_CLAY_IN_DIRT.get(),
                        BlockRegistration.SILT.get()
                );
        tag(BlockTags.LUSH_GROUND_REPLACEABLE)
                .addTag(BlockTags.MOSS_REPLACEABLE)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .add(
                        BlockRegistration.RED_CLAY.get()
                );
        tag(BlockTags.AZALEA_ROOT_REPLACEABLE)
                .addTag(BlockTags.LUSH_GROUND_REPLACEABLE);

        tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE)
                .add(
                        BlockRegistration.RED_CLAY.get(),
                        BlockRegistration.CLAY_IN_GRASS.get(),
                        BlockRegistration.RED_CLAY_IN_GRASS.get(),
                        BlockRegistration.CLAY_IN_DIRT.get(),
                        BlockRegistration.RED_CLAY_IN_DIRT.get()
                );
        tag(BlockTags.BIG_DRIPLEAF_PLACEABLE)
                .addTag(BlockTags.SMALL_DRIPLEAF_PLACEABLE)
                .add(
                        BlockRegistration.SILT.get()
                );

        tag(BlockTags.DRIPSTONE_REPLACEABLE)
                .addTag(BlockTagCatalog.REGOLITH_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.METAMORPHIC_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.ASHFALL_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES);

        tag(BlockTags.SCULK_REPLACEABLE)
                .addTag(BlockTagCatalog.REGOLITH_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.METAMORPHIC_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.ASHFALL_ORE_REPLACEABLES)
                .add(
                        BlockRegistration.RED_CLAY.get(),
                        BlockRegistration.CLAY_IN_GRASS.get(),
                        BlockRegistration.RED_CLAY_IN_GRASS.get(),
                        BlockRegistration.CLAY_IN_DIRT.get(),
                        BlockRegistration.RED_CLAY_IN_DIRT.get(),
                        BlockRegistration.SILT.get()
                );

        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN)
                .addTag(BlockTags.SCULK_REPLACEABLE)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES);

        tag(BlockTags.ANCIENT_CITY_REPLACEABLE)
                .addTag(BlockTagCatalog.IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.DEEP_IGNEOUS_INTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.SOFT_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES)
                .addTag(BlockTagCatalog.HARD_IGNEOUS_EXTRUSIVE_ORE_REPLACEABLES);

        tag(BlockTags.TRAIL_RUINS_REPLACEABLE);
        tag(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH);
        tag(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH);

        tag(BlockTags.REPLACEABLE); // Autopopulated by BlockState::canBeReplaced()
    }

    protected void registerSurfaceDecorationTags()
    {
        tag(BlockTagCatalog.ROCK).add(
                BlockRegistration.SANDSTONE_ROCK.get(),
                BlockRegistration.RED_SANDSTONE_ROCK.get(),
                BlockRegistration.SAPROLITE_ROCK.get(),
                BlockRegistration.LATERITE_ROCK.get(),
                BlockRegistration.SILT_CLUMP.get(),
                BlockRegistration.GREYWACKE_ROCK.get(),
                BlockRegistration.SILTSTONE_ROCK.get(),
                BlockRegistration.DOLOSTONE_ROCK.get(),
                BlockRegistration.LIMESTONE_ROCK.get(),
                BlockRegistration.IRONSTONE_ROCK.get(),
                BlockRegistration.SHALE_ROCK.get(),
                BlockRegistration.ARKOSE_ROCK.get(),
                BlockRegistration.MARBLE_ROCK.get(),
                BlockRegistration.QUARTZITE_ROCK.get(),
                BlockRegistration.HORNFELS_ROCK.get(),
                BlockRegistration.SLATE_ROCK.get(),
                BlockRegistration.GABBRO_ROCK.get(),
                BlockRegistration.SMOOTH_DIORITE_ROCK.get(),
                BlockRegistration.SMOOTH_GRANITE_ROCK.get(),
                BlockRegistration.NORITE_ROCK.get(),
                BlockRegistration.PERIDOTITE_ROCK.get()
        );
        tag(BlockTagCatalog.LARGE_ROCK).add(
                BlockRegistration.LARGE_SANDSTONE_ROCK.get(),
                BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get(),
                BlockRegistration.LARGE_SAPROLITE_ROCK.get(),
                BlockRegistration.LARGE_LATERITE_ROCK.get(),
                BlockRegistration.LARGE_SILT_CLUMP.get(),
                BlockRegistration.LARGE_GREYWACKE_ROCK.get(),
                BlockRegistration.LARGE_SILTSTONE_ROCK.get(),
                BlockRegistration.LARGE_DOLOSTONE_ROCK.get(),
                BlockRegistration.LARGE_LIMESTONE_ROCK.get(),
                BlockRegistration.LARGE_IRONSTONE_ROCK.get(),
                BlockRegistration.LARGE_SHALE_ROCK.get(),
                BlockRegistration.LARGE_ARKOSE_ROCK.get(),
                BlockRegistration.LARGE_MARBLE_ROCK.get(),
                BlockRegistration.LARGE_QUARTZITE_ROCK.get(),
                BlockRegistration.LARGE_HORNFELS_ROCK.get(),
                BlockRegistration.LARGE_SLATE_ROCK.get(),
                BlockRegistration.LARGE_GABBRO_ROCK.get(),
                BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(),
                BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(),
                BlockRegistration.LARGE_NORITE_ROCK.get(),
                BlockRegistration.LARGE_PERIDOTITE_ROCK.get()
        );
        tag(BlockTagCatalog.COPPER_ROCK).add(
                BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get(),
                BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get(),
                BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get(),
                BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(),
                BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get(),
                BlockRegistration.CHALK_ROCK_COPPER_ORE.get(),
                BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get(),
                BlockRegistration.SHALE_ROCK_COPPER_ORE.get(),
                BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get()
        );
        tag(BlockTagCatalog.TWIGS).add(
                BlockRegistration.TWIGS.get()
        );
        tag(BlockTagCatalog.BRANCH).add(
                BlockRegistration.BIRCH_BRANCH.get(),
                BlockRegistration.OAK_BRANCH.get(),
                BlockRegistration.SPRUCE_BRANCH.get(),
                BlockRegistration.JUNGLE_BRANCH.get(),
                BlockRegistration.DARK_OAK_BRANCH.get(),
                BlockRegistration.ACACIA_BRANCH.get(),
                BlockRegistration.CHERRY_BRANCH.get(),
                BlockRegistration.MANGROVE_BRANCH.get()
        );
        tag(BlockTagCatalog.CAN_DROP_THATCH).add(
                Blocks.SHORT_GRASS,
                Blocks.TALL_GRASS,
                Blocks.FERN
        );
        tag(BlockTagCatalog.CLAY_CAN_REPLACE)
                .addTag(BlockTags.STONE_ORE_REPLACEABLES)
                .add(
                        Blocks.DIRT
                );
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

    protected void registerNeoForgeCompatibilityTags()
    {
        // Gravel
        tag(Tags.Blocks.GRAVELS).add(
                BlockRegistration.GRAVEL.get()
        );

        // Ashfall & Regolith // Do not add these to Tags.Blocks.COBBLESTONES, they are too soft
        // BlockRegistration.COBBLED_CHALK.get(),

        // Sedimentary
        tag(Tags.Blocks.STONES).add(
                BlockRegistration.GREYWACKE.get(),
                BlockRegistration.SILTSTONE.get(),
                BlockRegistration.DOLOSTONE.get(),
                BlockRegistration.LIMESTONE.get(), // not chalk
                BlockRegistration.IRONSTONE.get(),
                BlockRegistration.SHALE.get()
        );
        tag(Tags.Blocks.COBBLESTONES_NORMAL).add( // Only those of equal hardness as greywacke cobblestone
                BlockRegistration.COBBLED_GREYWACKE.get(),
                BlockRegistration.COBBLED_SILTSTONE.get(),
                BlockRegistration.COBBLED_DOLOSTONE.get(),
                BlockRegistration.COBBLED_LIMESTONE.get(), // not chalk
                BlockRegistration.COBBLED_IRONSTONE.get(),
                BlockRegistration.COBBLED_SHALE.get()
        );
        tag(Tags.Blocks.COBBLESTONES_MOSSY);
        tag(Tags.Blocks.COBBLESTONES_INFESTED);
        tag(Tags.Blocks.COBBLESTONES).add( // Everything from NORMAL, MOSSY and INFESTED
                BlockRegistration.COBBLED_GREYWACKE.get(),
                BlockRegistration.COBBLED_SILTSTONE.get(),
                BlockRegistration.COBBLED_DOLOSTONE.get(),
                BlockRegistration.LIMESTONE.get(),
                BlockRegistration.COBBLED_IRONSTONE.get(),
                BlockRegistration.COBBLED_SHALE.get()
        );
        tag(Tags.Blocks.ORE_BEARING_GROUND_STONE)
                .addTag(BlockTagCatalog.SEDIMENTARY_ORE_REPLACEABLES);

        // Metamorphic & Soft Igneous Extrusive // Harder than vanilla stone

        // Igneous Intrusive & Hard Igneous Extrusive
        tag(Tags.Blocks.COBBLESTONES_DEEPSLATE).add( // Only those of equal hardness as gabbro
                BlockRegistration.COBBLED_GABBRO.get()
        );

        // Deep Igneous Intrusive // Harder than vanilla deepslate
        tag(Tags.Blocks.ORE_BEARING_GROUND_DEEPSLATE).add( // TODO This may not be the best idea
                BlockRegistration.GABBRO.get(),
                BlockRegistration.SMOOTH_DIORITE.get(),
                BlockRegistration.ROUGH_DIORITE.get()
                //BlockRegistration.ANDESITE.get(),
                //BlockRegistration.BASALT.get()
        );

        tag(Tags.Blocks.ORE_RATES_DENSE);
        tag(Tags.Blocks.ORE_RATES_SINGULAR).add(
                BlockRegistration.LIMESTONE_CHERT_ORE.get(),
                BlockRegistration.CHALK_CHERT_ORE.get(),
                BlockRegistration.BASALT_GEODE_ORE.get(),
                BlockRegistration.ANDESITE_GEODE_ORE.get(),
                BlockRegistration.RHYOLITE_GEODE_ORE.get(),
                BlockRegistration.DACITE_GEODE_ORE.get(),
                BlockRegistration.TIN_ORE_IN_GREYWACKE.get(),
                BlockRegistration.TIN_ORE_IN_GABBRO.get()
        );
        tag(Tags.Blocks.ORE_RATES_SPARSE);

        tag(BlockTags.COAL_ORES);
        tag(Tags.Blocks.ORES_COAL);
        tag(BlockTags.COPPER_ORES);
        tag(Tags.Blocks.ORES_COPPER);
        tag(BlockTags.DIAMOND_ORES);
        tag(Tags.Blocks.ORES_DIAMOND);
        tag(BlockTags.EMERALD_ORES);
        tag(Tags.Blocks.ORES_EMERALD);
        tag(BlockTags.GOLD_ORES);
        tag(Tags.Blocks.ORES_GOLD);
        tag(BlockTags.IRON_ORES);
        tag(Tags.Blocks.ORES_IRON);
        tag(BlockTags.LAPIS_ORES);
        tag(Tags.Blocks.ORES_LAPIS);
        //tag(BlockTags.QUARTZ_ORE); // Doesn't exist
        tag(Tags.Blocks.ORES_QUARTZ);
        tag(BlockTags.REDSTONE_ORES);
        tag(Tags.Blocks.ORES_REDSTONE);

        tag(Tags.Blocks.SANDSTONE_BLOCKS).add(
                BlockRegistration.COBBLED_SANDSTONE.get(),
                BlockRegistration.COBBLED_RED_SANDSTONE.get()
        );
        tag(Tags.Blocks.SANDSTONE_UNCOLORED_BLOCKS).add(
                BlockRegistration.COBBLED_SANDSTONE.get()
        );
        tag(Tags.Blocks.SANDSTONE_RED_BLOCKS).add(
                BlockRegistration.COBBLED_RED_SANDSTONE.get()
        );
    }
}
