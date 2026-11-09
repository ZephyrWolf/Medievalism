package io.github.zephyrwolf.medievalism.datagen.base.blockmodel;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import io.github.zephyrwolf.medievalism.common.block.firepit.BuildCampfireBlock;
import io.github.zephyrwolf.medievalism.common.block.plants.SoftRushBlock;
import io.github.zephyrwolf.medievalism.common.data.BlockStateEntryProviderHandle;
import io.github.zephyrwolf.medievalism.common.data.IBlockStateProviderEntry;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class WorldBlockStateProviderEntry implements IBlockStateProviderEntry
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    public WorldBlockStateProviderEntry()
    {
        super();
    }

    @Override
    public void registerModels(BlockStateEntryProviderHandle handle)
    {
        ResourceLocation textureClayInGrass0 = handle.blockTexture(BlockRegistration.CLAY_IN_GRASS.get(), "1");
        ResourceLocation textureClayInGrass1 = handle.blockTexture(BlockRegistration.CLAY_IN_GRASS.get(), "2");
        ResourceLocation textureClayInGrass2 = handle.blockTexture(BlockRegistration.CLAY_IN_GRASS.get(), "3");
        ResourceLocation textureClayInGrass3 = handle.blockTexture(BlockRegistration.CLAY_IN_GRASS.get(), "4");
        handle.randomModelBlock(BlockRegistration.CLAY_IN_GRASS.get(),
                handle.simpleGrassModel(handle.blockModelName(BlockRegistration.CLAY_IN_GRASS.get(), "0"), textureClayInGrass0),
                handle.simpleGrassModel(handle.blockModelName(BlockRegistration.CLAY_IN_GRASS.get(), "1"), textureClayInGrass1),
                handle.simpleGrassModel(handle.blockModelName(BlockRegistration.CLAY_IN_GRASS.get(), "2"), textureClayInGrass2),
                handle.simpleGrassModel(handle.blockModelName(BlockRegistration.CLAY_IN_GRASS.get(), "3"), textureClayInGrass3)
        );

        ResourceLocation textureDirt = handle.blockTexture(Blocks.DIRT);
        ResourceLocation textureClayInDirt0 = handle.blockTexture(BlockRegistration.CLAY_IN_DIRT.get(), "1");
        ResourceLocation textureClayInDirt1 = handle.blockTexture(BlockRegistration.CLAY_IN_DIRT.get(), "2");
        ResourceLocation textureClayInDirt2 = handle.blockTexture(BlockRegistration.CLAY_IN_DIRT.get(), "3");
        ResourceLocation textureClayInDirt3 = handle.blockTexture(BlockRegistration.CLAY_IN_DIRT.get(), "4");
        handle.randomModelBlock(BlockRegistration.CLAY_IN_DIRT.get(),
                handle.cubeColumnModel(handle.blockModelName(BlockRegistration.CLAY_IN_DIRT.get(), "0"), textureDirt, textureClayInDirt0),
                handle.cubeColumnModel(handle.blockModelName(BlockRegistration.CLAY_IN_DIRT.get(), "1"), textureDirt, textureClayInDirt1),
                handle.cubeColumnModel(handle.blockModelName(BlockRegistration.CLAY_IN_DIRT.get(), "2"), textureDirt, textureClayInDirt2),
                handle.cubeColumnModel(handle.blockModelName(BlockRegistration.CLAY_IN_DIRT.get(), "3"), textureDirt, textureClayInDirt3)
        );

        handle.simpleBlock(BlockRegistration.SILT.get());

        ResourceLocation sandstone_bottom =     handle.blockTexture(Blocks.SANDSTONE, "_bottom");
        ResourceLocation red_sandstone_bottom = handle.blockTexture(Blocks.RED_SANDSTONE, "_bottom");

        // STONE
        handle.simpleBlock(BlockRegistration.SOFT_TUFF.get());
        handle.simpleBlock(BlockRegistration.IGNIMBRITE.get());
        handle.simpleBlock(BlockRegistration.LAPILLISTONE.get());
        handle.simpleBlock(BlockRegistration.SAPROLITE.get());
        handle.simpleBlock(BlockRegistration.LATERITE.get());
        handle.simpleBlock(BlockRegistration.SILTSTONE.get());
        handle.simpleBlock(BlockRegistration.DOLOSTONE.get());
        handle.simpleBlock(BlockRegistration.LIMESTONE.get());
        handle.simpleBlock(BlockRegistration.CHALK.get());
        handle.simpleBlock(BlockRegistration.IRONSTONE.get());
        handle.simpleBlock(BlockRegistration.SHALE.get());
        handle.simpleBlock(BlockRegistration.DACITE.get());
        handle.simpleBlock(BlockRegistration.RHYOLITE.get());
        handle.simpleBlock(BlockRegistration.MARBLE.get());
        handle.simpleBlock(BlockRegistration.QUARTZITE.get());
        handle.simpleBlock(BlockRegistration.HORNFELS.get());
        handle.simpleBlock(BlockRegistration.SLATE.get());
        handle.simpleBlock(BlockRegistration.ARKOSE.get());
        handle.simpleBlock(BlockRegistration.NORITE.get());
        handle.simpleBlock(BlockRegistration.PERIDOTITE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_DIORITE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_GRANITE.get());
        // LOOSE STONE
        //simpleBlock(BlockRegistration.LOOSE_GREYWACKE.get());
        //simpleBlock(BlockRegistration.LOOSE_DOLOSTONE.get());
        //simpleBlock(BlockRegistration.LOOSE_SILTSTONE.get());
        //simpleBlock(BlockRegistration.LOOSE_LIMESTONE.get());
        //simpleBlock(BlockRegistration.LOOSE_CHALK.get());
        //simpleBlock(BlockRegistration.LOOSE_IRONSTONE.get());
        //simpleBlock(BlockRegistration.LOOSE_ARKOSE.get());
        //simpleBlock(BlockRegistration.LOOSE_SHALE.get());
        //simpleBlock(BlockRegistration.LOOSE_MARBLE.get());
        //simpleBlock(BlockRegistration.LOOSE_SLATE.get());
        //simpleBlock(BlockRegistration.LOOSE_QUARTZITE.get());
        //simpleBlock(BlockRegistration.LOOSE_HORNFELS.get());
        //simpleBlock(BlockRegistration.LOOSE_SMOOTH_DIORITE.get());
        //simpleBlock(BlockRegistration.LOOSE_SMOOTH_GRANITE.get());
        //simpleBlock(BlockRegistration.LOOSE_GABBRO.get());
        //simpleBlock(BlockRegistration.LOOSE_NORITE.get());
        //simpleBlock(BlockRegistration.LOOSE_PERIDOTITE.get());
        //simpleBlock(BlockRegistration.LOOSE_ANDESITE.get());
        //simpleBlock(BlockRegistration.LOOSE_BASALT.get());
        //// STONE GRAVEL
        //simpleBlock(BlockRegistration.GREYWACKE_GRAVEL.get());
        //simpleBlock(BlockRegistration.DOLOSTONE_GRAVEL.get());
        //simpleBlock(BlockRegistration.SILTSTONE_GRAVEL.get());
        //simpleBlock(BlockRegistration.LIMESTONE_GRAVEL.get());
        //simpleBlock(BlockRegistration.CHALK_GRAVEL.get());
        //simpleBlock(BlockRegistration.IRONSTONE_GRAVEL.get());
        //simpleBlock(BlockRegistration.ARKOSE_GRAVEL.get());
        //simpleBlock(BlockRegistration.SHALE_GRAVEL.get());
        //simpleBlock(BlockRegistration.MARBLE_GRAVEL.get());
        //simpleBlock(BlockRegistration.SLATE_GRAVEL.get());
        //simpleBlock(BlockRegistration.QUARTZITE_GRAVEL.get());
        //simpleBlock(BlockRegistration.HORNFELS_GRAVEL.get());
        //simpleBlock(BlockRegistration.SMOOTH_DIORITE_GRAVEL.get());
        //simpleBlock(BlockRegistration.SMOOTH_GRANITE_GRAVEL.get());
        //simpleBlock(BlockRegistration.GABBRO_GRAVEL.get());
        //simpleBlock(BlockRegistration.NORITE_GRAVEL.get());
        //simpleBlock(BlockRegistration.PERIDOTITE_GRAVEL.get());
        //simpleBlock(BlockRegistration.ANDESITE_GRAVEL.get());
        //simpleBlock(BlockRegistration.BASALT_GRAVEL.get());
        // INFESTED STONE
        handle.simpleBlock(BlockRegistration.INFESTED_SILTSTONE.get(),       handle.simpleCubeModel(BlockRegistration.SILTSTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_DOLOSTONE.get(),       handle.simpleCubeModel(BlockRegistration.DOLOSTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_LIMESTONE.get(),       handle.simpleCubeModel(BlockRegistration.LIMESTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_SHALE.get(),           handle.simpleCubeModel(BlockRegistration.SHALE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_ARKOSE.get(),          handle.simpleCubeModel(BlockRegistration.ARKOSE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_MARBLE.get(),          handle.simpleCubeModel(BlockRegistration.MARBLE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_QUARTZITE.get(),       handle.simpleCubeModel(BlockRegistration.QUARTZITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_HORNFELS.get(),        handle.simpleCubeModel(BlockRegistration.HORNFELS.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_SLATE.get(),           handle.simpleCubeModel(BlockRegistration.SLATE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_SMOOTH_DIORITE.get(),  handle.simpleCubeModel(BlockRegistration.SMOOTH_DIORITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_SMOOTH_GRANITE.get(),  handle.simpleCubeModel(BlockRegistration.SMOOTH_GRANITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_NORITE.get(),          handle.simpleCubeModel(BlockRegistration.NORITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_PERIDOTITE.get(),      handle.simpleCubeModel(BlockRegistration.PERIDOTITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_RHYOLITE.get(),        handle.simpleCubeModel(BlockRegistration.RHYOLITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_DACITE.get(),          handle.simpleCubeModel(BlockRegistration.DACITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_ANDESITE.get(),        handle.simpleCubeModel(BlockRegistration.ANDESITE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_BASALT.get(),          handle.simpleCubeModel(BlockRegistration.BASALT.get()));
        // COPPER ORE
        handle.simpleBlock(BlockRegistration.SAPROLITE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.GREYWACKE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.SILTSTONE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.DOLOSTONE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.LIMESTONE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.CHALK_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.IRONSTONE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.SHALE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.ARKOSE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.MARBLE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.QUARTZITE_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.HORNFELS_COPPER_ORE.get());
        handle.simpleBlock(BlockRegistration.SLATE_COPPER_ORE.get());
        // IRON ORE
        handle.simpleBlock(BlockRegistration.GABBRO_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.NORITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.PERIDOTITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.RHYOLITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.DACITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.ANDESITE_IRON_ORE.get());
        handle.simpleBlock(BlockRegistration.BASALT_IRON_ORE.get());
        // GOLD ORE
        handle.simpleBlock(BlockRegistration.GREYWACKE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.SILTSTONE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.DOLOSTONE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.LIMESTONE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.CHALK_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.IRONSTONE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.SHALE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.ARKOSE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.MARBLE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.QUARTZITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.HORNFELS_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.SLATE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.GABBRO_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.NORITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.PERIDOTITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.RHYOLITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.DACITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.ANDESITE_GOLD_ORE.get());
        handle.simpleBlock(BlockRegistration.BASALT_GOLD_ORE.get());
        // COAL ORE
        handle.simpleBlock(BlockRegistration.SAPROLITE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.LATERITE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.GREYWACKE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.SILTSTONE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.DOLOSTONE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.LIMESTONE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.CHALK_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.IRONSTONE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.SHALE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.ARKOSE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.MARBLE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.QUARTZITE_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.HORNFELS_COAL_ORE.get());
        handle.simpleBlock(BlockRegistration.SLATE_COAL_ORE.get());
        // DIAMOND ORE
        handle.simpleBlock(BlockRegistration.GABBRO_DIAMOND_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get());
        handle.simpleBlock(BlockRegistration.NORITE_DIAMOND_ORE.get());
        handle.simpleBlock(BlockRegistration.PERIDOTITE_DIAMOND_ORE.get());
        handle.simpleBlock(BlockRegistration.ANDESITE_DIAMOND_ORE.get());
        handle.simpleBlock(BlockRegistration.BASALT_DIAMOND_ORE.get());
        // EMERALD ORE
        handle.simpleBlock(BlockRegistration.GABBRO_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.NORITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.PERIDOTITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.RHYOLITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.DACITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.ANDESITE_EMERALD_ORE.get());
        handle.simpleBlock(BlockRegistration.BASALT_EMERALD_ORE.get());
        // LAPIS ORE
        handle.simpleBlock(BlockRegistration.MARBLE_LAPIS_ORE.get());
        handle.simpleBlock(BlockRegistration.QUARTZITE_LAPIS_ORE.get());
        handle.simpleBlock(BlockRegistration.HORNFELS_LAPIS_ORE.get());
        handle.simpleBlock(BlockRegistration.SLATE_LAPIS_ORE.get());
        // REDSTONE ORE
        handle.simpleBlock(BlockRegistration.GABBRO_REDSTONE_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get());
        handle.simpleBlock(BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get());
        handle.simpleBlock(BlockRegistration.NORITE_REDSTONE_ORE.get());
        handle.simpleBlock(BlockRegistration.PERIDOTITE_REDSTONE_ORE.get());

        // COBBLE
        handle.simpleBlock(BlockRegistration.COBBLED_SOFT_TUFF.get());
        handle.simpleBlock(BlockRegistration.COBBLED_IGNIMBRITE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_WELDED_TUFF.get());
        handle.simpleBlock(BlockRegistration.COBBLED_LAPILLISTONE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_SANDSTONE.get(), handle.cubeModel("cobbled_sandstone", sandstone_bottom));
        handle.simpleBlock(BlockRegistration.COBBLED_RED_SANDSTONE.get(), handle.cubeModel("cobbled_red_sandstone", red_sandstone_bottom));
        handle.simpleBlock(BlockRegistration.COBBLED_SAPROLITE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_LATERITE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_SILTSTONE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_DOLOSTONE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_LIMESTONE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_CHALK.get());
        handle.simpleBlock(BlockRegistration.COBBLED_IRONSTONE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_SHALE.get());
        handle.simpleBlock(BlockRegistration.COBBLED_ARKOSE.get());

        // INFESTED COBBLE
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_SILTSTONE.get(),   handle.simpleCubeModel(BlockRegistration.COBBLED_SILTSTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_DOLOSTONE.get(),   handle.simpleCubeModel(BlockRegistration.COBBLED_DOLOSTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_LIMESTONE.get(),   handle.simpleCubeModel(BlockRegistration.COBBLED_LIMESTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_CHALK.get(),       handle.simpleCubeModel(BlockRegistration.COBBLED_CHALK.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_IRONSTONE.get(),   handle.simpleCubeModel(BlockRegistration.COBBLED_IRONSTONE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_SHALE.get(),       handle.simpleCubeModel(BlockRegistration.COBBLED_SHALE.get()));
        handle.simpleBlock(BlockRegistration.INFESTED_COBBLED_ARKOSE.get(),      handle.simpleCubeModel(BlockRegistration.COBBLED_ARKOSE.get()));

        handle.simpleBlock(BlockRegistration.LIMESTONE_CHERT_ORE.get());
        handle.simpleBlock(BlockRegistration.CHALK_CHERT_ORE.get());
        handle.simpleBlock(BlockRegistration.BASALT_GEODE_ORE.get());
        handle.simpleBlock(BlockRegistration.ANDESITE_GEODE_ORE.get());
        handle.simpleBlock(BlockRegistration.RHYOLITE_GEODE_ORE.get());
        handle.simpleBlock(BlockRegistration.DACITE_GEODE_ORE.get());

        //region Branches
        handle.randomRotationAndIntegerPropertyBlock(
                BlockRegistration.TWIGS.get(),
                TwigsBlock.NUM_STICKS,
                handle.existingModel(handle.blockModelName(BlockRegistration.TWIGS.get(), "1")),
                handle.existingModel(handle.blockModelName(BlockRegistration.TWIGS.get(), "2")),
                handle.existingModel(handle.blockModelName(BlockRegistration.TWIGS.get(), "3"))
        );

        ResourceLocation modelBranch = MedievalismConstants.resource("block/branch");
        handle.randomModelAndRotationBlock(BlockRegistration.OAK_BRANCH.get(),        handle.existingParent(BlockRegistration.OAK_BRANCH.get(), modelBranch, BlockRegistration.OAK_BRANCH.get(), Blocks.OAK_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.BIRCH_BRANCH.get(),      handle.existingParent(BlockRegistration.BIRCH_BRANCH.get(), modelBranch, BlockRegistration.BIRCH_BRANCH.get(), Blocks.BIRCH_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.SPRUCE_BRANCH.get(),     handle.existingParent(BlockRegistration.SPRUCE_BRANCH.get(), modelBranch, BlockRegistration.SPRUCE_BRANCH.get(), Blocks.SPRUCE_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.JUNGLE_BRANCH.get(),     handle.existingParent(BlockRegistration.JUNGLE_BRANCH.get(), modelBranch, BlockRegistration.JUNGLE_BRANCH.get(), Blocks.JUNGLE_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.DARK_OAK_BRANCH.get(),   handle.existingParent(BlockRegistration.DARK_OAK_BRANCH.get(), modelBranch, BlockRegistration.DARK_OAK_BRANCH.get(), Blocks.DARK_OAK_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.ACACIA_BRANCH.get(),     handle.existingParent(BlockRegistration.ACACIA_BRANCH.get(), modelBranch, BlockRegistration.ACACIA_BRANCH.get(), Blocks.ACACIA_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.CHERRY_BRANCH.get(),     handle.existingParent(BlockRegistration.CHERRY_BRANCH.get(), modelBranch, BlockRegistration.CHERRY_BRANCH.get(), Blocks.CHERRY_LOG));
        handle.randomModelAndRotationBlock(BlockRegistration.MANGROVE_BRANCH.get(),   handle.existingParent(BlockRegistration.MANGROVE_BRANCH.get(), modelBranch, BlockRegistration.MANGROVE_BRANCH.get(), Blocks.MANGROVE_LOG));
        //endregion

        //region Rocks
        ResourceLocation sandstone_top =        handle.blockTexture(Blocks.SANDSTONE, "_top");
        ResourceLocation red_sandstone_top =    handle.blockTexture(Blocks.RED_SANDSTONE, "_top");

        ResourceLocation modelRock1 = MedievalismConstants.resource("block/base_rock1");
        ResourceLocation modelRock2 = MedievalismConstants.resource("block/base_rock2");
        ResourceLocation modelRock3 = MedievalismConstants.resource("block/base_rock3");
        ResourceLocation modelRock4 = MedievalismConstants.resource("block/base_rock4");
        ResourceLocation modelRock5 = MedievalismConstants.resource("block/base_rock5");
        handle.randomModelAndRotationBlock(
                BlockRegistration.SANDSTONE_ROCK.get(),
                handle.existingParent(handle.blockModelName(BlockRegistration.SANDSTONE_ROCK.get(), "1"), modelRock1, sandstone_top, sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.SANDSTONE_ROCK.get(), "2"), modelRock2, sandstone_top, sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.SANDSTONE_ROCK.get(), "3"), modelRock3, sandstone_top, sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.SANDSTONE_ROCK.get(), "4"), modelRock4, sandstone_top, sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.SANDSTONE_ROCK.get(), "5"), modelRock5, sandstone_top, sandstone_top)
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.RED_SANDSTONE_ROCK.get(),
                handle.existingParent(handle.blockModelName(BlockRegistration.RED_SANDSTONE_ROCK.get(), "1"), modelRock1, red_sandstone_top, red_sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.RED_SANDSTONE_ROCK.get(), "2"), modelRock2, red_sandstone_top, red_sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.RED_SANDSTONE_ROCK.get(), "3"), modelRock3, red_sandstone_top, red_sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.RED_SANDSTONE_ROCK.get(), "4"), modelRock4, red_sandstone_top, red_sandstone_top),
                handle.existingParent(handle.blockModelName(BlockRegistration.RED_SANDSTONE_ROCK.get(), "5"), modelRock5, red_sandstone_top, red_sandstone_top)
        );

        handle.randomModelAndRotationBlock(
                BlockRegistration.SAPROLITE_ROCK.get(),
                handle.existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "1", modelRock1, BlockRegistration.SAPROLITE.get()),
                handle.existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "2", modelRock2, BlockRegistration.SAPROLITE.get()),
                handle.existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "3", modelRock3, BlockRegistration.SAPROLITE.get()),
                handle.existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "4", modelRock4, BlockRegistration.SAPROLITE.get()),
                handle.existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "5", modelRock5, BlockRegistration.SAPROLITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LATERITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LATERITE_ROCK.get(), "1", modelRock1, BlockRegistration.LATERITE.get()),
                handle.existingParent(BlockRegistration.LATERITE_ROCK.get(), "2", modelRock2, BlockRegistration.LATERITE.get()),
                handle.existingParent(BlockRegistration.LATERITE_ROCK.get(), "3", modelRock3, BlockRegistration.LATERITE.get()),
                handle.existingParent(BlockRegistration.LATERITE_ROCK.get(), "4", modelRock4, BlockRegistration.LATERITE.get()),
                handle.existingParent(BlockRegistration.LATERITE_ROCK.get(), "5", modelRock5, BlockRegistration.LATERITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SILT_CLUMP.get(),
                handle.existingParent(BlockRegistration.SILT_CLUMP.get(), "1", modelRock1, BlockRegistration.SILT.get()),
                handle.existingParent(BlockRegistration.SILT_CLUMP.get(), "2", modelRock2, BlockRegistration.SILT.get()),
                handle.existingParent(BlockRegistration.SILT_CLUMP.get(), "3", modelRock3, BlockRegistration.SILT.get()),
                handle.existingParent(BlockRegistration.SILT_CLUMP.get(), "4", modelRock4, BlockRegistration.SILT.get()),
                handle.existingParent(BlockRegistration.SILT_CLUMP.get(), "5", modelRock5, BlockRegistration.SILT.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.GREYWACKE_ROCK.get(),
                handle.existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "1", modelRock1, BlockRegistration.GREYWACKE.get()),
                handle.existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "2", modelRock2, BlockRegistration.GREYWACKE.get()),
                handle.existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "3", modelRock3, BlockRegistration.GREYWACKE.get()),
                handle.existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "4", modelRock4, BlockRegistration.GREYWACKE.get()),
                handle.existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "5", modelRock5, BlockRegistration.GREYWACKE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SILTSTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "1", modelRock1, BlockRegistration.SILTSTONE.get()),
                handle.existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "2", modelRock2, BlockRegistration.SILTSTONE.get()),
                handle.existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "3", modelRock3, BlockRegistration.SILTSTONE.get()),
                handle.existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "4", modelRock4, BlockRegistration.SILTSTONE.get()),
                handle.existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "5", modelRock5, BlockRegistration.SILTSTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.DOLOSTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "1", modelRock1, BlockRegistration.DOLOSTONE.get()),
                handle.existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "2", modelRock2, BlockRegistration.DOLOSTONE.get()),
                handle.existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "3", modelRock3, BlockRegistration.DOLOSTONE.get()),
                handle.existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "4", modelRock4, BlockRegistration.DOLOSTONE.get()),
                handle.existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "5", modelRock5, BlockRegistration.DOLOSTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LIMESTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "1", modelRock1, BlockRegistration.LIMESTONE.get()),
                handle.existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "2", modelRock2, BlockRegistration.LIMESTONE.get()),
                handle.existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "3", modelRock3, BlockRegistration.LIMESTONE.get()),
                handle.existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "4", modelRock4, BlockRegistration.LIMESTONE.get()),
                handle.existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "5", modelRock5, BlockRegistration.LIMESTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.IRONSTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "1", modelRock1, BlockRegistration.IRONSTONE.get()),
                handle.existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "2", modelRock2, BlockRegistration.IRONSTONE.get()),
                handle.existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "3", modelRock3, BlockRegistration.IRONSTONE.get()),
                handle.existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "4", modelRock4, BlockRegistration.IRONSTONE.get()),
                handle.existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "5", modelRock5, BlockRegistration.IRONSTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SHALE_ROCK.get(),
                handle.existingParent(BlockRegistration.SHALE_ROCK.get(), "1", modelRock1, BlockRegistration.SHALE.get()),
                handle.existingParent(BlockRegistration.SHALE_ROCK.get(), "2", modelRock2, BlockRegistration.SHALE.get()),
                handle.existingParent(BlockRegistration.SHALE_ROCK.get(), "3", modelRock3, BlockRegistration.SHALE.get()),
                handle.existingParent(BlockRegistration.SHALE_ROCK.get(), "4", modelRock4, BlockRegistration.SHALE.get()),
                handle.existingParent(BlockRegistration.SHALE_ROCK.get(), "5", modelRock5, BlockRegistration.SHALE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.ARKOSE_ROCK.get(),
                handle.existingParent(BlockRegistration.ARKOSE_ROCK.get(), "1", modelRock1, BlockRegistration.ARKOSE.get()),
                handle.existingParent(BlockRegistration.ARKOSE_ROCK.get(), "2", modelRock2, BlockRegistration.ARKOSE.get()),
                handle.existingParent(BlockRegistration.ARKOSE_ROCK.get(), "3", modelRock3, BlockRegistration.ARKOSE.get()),
                handle.existingParent(BlockRegistration.ARKOSE_ROCK.get(), "4", modelRock4, BlockRegistration.ARKOSE.get()),
                handle.existingParent(BlockRegistration.ARKOSE_ROCK.get(), "5", modelRock5, BlockRegistration.ARKOSE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.MARBLE_ROCK.get(),
                handle.existingParent(BlockRegistration.MARBLE_ROCK.get(), "1", modelRock1, BlockRegistration.MARBLE.get()),
                handle.existingParent(BlockRegistration.MARBLE_ROCK.get(), "2", modelRock2, BlockRegistration.MARBLE.get()),
                handle.existingParent(BlockRegistration.MARBLE_ROCK.get(), "3", modelRock3, BlockRegistration.MARBLE.get()),
                handle.existingParent(BlockRegistration.MARBLE_ROCK.get(), "4", modelRock4, BlockRegistration.MARBLE.get()),
                handle.existingParent(BlockRegistration.MARBLE_ROCK.get(), "5", modelRock5, BlockRegistration.MARBLE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.QUARTZITE_ROCK.get(),
                handle.existingParent(BlockRegistration.QUARTZITE_ROCK.get(), "1", modelRock1, BlockRegistration.QUARTZITE.get()),
                handle.existingParent(BlockRegistration.QUARTZITE_ROCK.get(), "2", modelRock2, BlockRegistration.QUARTZITE.get()),
                handle.existingParent(BlockRegistration.QUARTZITE_ROCK.get(), "3", modelRock3, BlockRegistration.QUARTZITE.get()),
                handle.existingParent(BlockRegistration.QUARTZITE_ROCK.get(), "4", modelRock4, BlockRegistration.QUARTZITE.get()),
                handle.existingParent(BlockRegistration.QUARTZITE_ROCK.get(), "5", modelRock5, BlockRegistration.QUARTZITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.HORNFELS_ROCK.get(),
                handle.existingParent(BlockRegistration.HORNFELS_ROCK.get(), "1", modelRock1, BlockRegistration.HORNFELS.get()),
                handle.existingParent(BlockRegistration.HORNFELS_ROCK.get(), "2", modelRock2, BlockRegistration.HORNFELS.get()),
                handle.existingParent(BlockRegistration.HORNFELS_ROCK.get(), "3", modelRock3, BlockRegistration.HORNFELS.get()),
                handle.existingParent(BlockRegistration.HORNFELS_ROCK.get(), "4", modelRock4, BlockRegistration.HORNFELS.get()),
                handle.existingParent(BlockRegistration.HORNFELS_ROCK.get(), "5", modelRock5, BlockRegistration.HORNFELS.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SLATE_ROCK.get(),
                handle.existingParent(BlockRegistration.SLATE_ROCK.get(), "1", modelRock1, BlockRegistration.SLATE.get()),
                handle.existingParent(BlockRegistration.SLATE_ROCK.get(), "2", modelRock2, BlockRegistration.SLATE.get()),
                handle.existingParent(BlockRegistration.SLATE_ROCK.get(), "3", modelRock3, BlockRegistration.SLATE.get()),
                handle.existingParent(BlockRegistration.SLATE_ROCK.get(), "4", modelRock4, BlockRegistration.SLATE.get()),
                handle.existingParent(BlockRegistration.SLATE_ROCK.get(), "5", modelRock5, BlockRegistration.SLATE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.GABBRO_ROCK.get(),
                handle.existingParent(BlockRegistration.GABBRO_ROCK.get(), "1", modelRock1, BlockRegistration.GABBRO.get()),
                handle.existingParent(BlockRegistration.GABBRO_ROCK.get(), "2", modelRock2, BlockRegistration.GABBRO.get()),
                handle.existingParent(BlockRegistration.GABBRO_ROCK.get(), "3", modelRock3, BlockRegistration.GABBRO.get()),
                handle.existingParent(BlockRegistration.GABBRO_ROCK.get(), "4", modelRock4, BlockRegistration.GABBRO.get()),
                handle.existingParent(BlockRegistration.GABBRO_ROCK.get(), "5", modelRock5, BlockRegistration.GABBRO.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SMOOTH_DIORITE_ROCK.get(),
                handle.existingParent(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), "1", modelRock1, BlockRegistration.SMOOTH_DIORITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), "2", modelRock2, BlockRegistration.SMOOTH_DIORITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), "3", modelRock3, BlockRegistration.SMOOTH_DIORITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), "4", modelRock4, BlockRegistration.SMOOTH_DIORITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), "5", modelRock5, BlockRegistration.SMOOTH_DIORITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SMOOTH_GRANITE_ROCK.get(),
                handle.existingParent(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), "1", modelRock1, BlockRegistration.SMOOTH_GRANITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), "2", modelRock2, BlockRegistration.SMOOTH_GRANITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), "3", modelRock3, BlockRegistration.SMOOTH_GRANITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), "4", modelRock4, BlockRegistration.SMOOTH_GRANITE.get()),
                handle.existingParent(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), "5", modelRock5, BlockRegistration.SMOOTH_GRANITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.NORITE_ROCK.get(),
                handle.existingParent(BlockRegistration.NORITE_ROCK.get(), "1", modelRock1, BlockRegistration.NORITE.get()),
                handle.existingParent(BlockRegistration.NORITE_ROCK.get(), "2", modelRock2, BlockRegistration.NORITE.get()),
                handle.existingParent(BlockRegistration.NORITE_ROCK.get(), "3", modelRock3, BlockRegistration.NORITE.get()),
                handle.existingParent(BlockRegistration.NORITE_ROCK.get(), "4", modelRock4, BlockRegistration.NORITE.get()),
                handle.existingParent(BlockRegistration.NORITE_ROCK.get(), "5", modelRock5, BlockRegistration.NORITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.PERIDOTITE_ROCK.get(),
                handle.existingParent(BlockRegistration.PERIDOTITE_ROCK.get(), "1", modelRock1, BlockRegistration.PERIDOTITE.get()),
                handle.existingParent(BlockRegistration.PERIDOTITE_ROCK.get(), "2", modelRock2, BlockRegistration.PERIDOTITE.get()),
                handle.existingParent(BlockRegistration.PERIDOTITE_ROCK.get(), "3", modelRock3, BlockRegistration.PERIDOTITE.get()),
                handle.existingParent(BlockRegistration.PERIDOTITE_ROCK.get(), "4", modelRock4, BlockRegistration.PERIDOTITE.get()),
                handle.existingParent(BlockRegistration.PERIDOTITE_ROCK.get(), "5", modelRock5, BlockRegistration.PERIDOTITE.get())
        );

        // LARGE ROCK
        ResourceLocation modelLargeRock1 = MedievalismConstants.resource("block/base_large_rock1");
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SANDSTONE_ROCK.get(),
                handle.existingParent(handle.blockModelName(BlockRegistration.LARGE_SANDSTONE_ROCK.get(), "1"), modelLargeRock1, sandstone_top, sandstone_top)
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get(),
                handle.existingParent(handle.blockModelName(BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "1"), modelLargeRock1, red_sandstone_top, red_sandstone_top)
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SAPROLITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_SAPROLITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.SAPROLITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_LATERITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_LATERITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.LATERITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SILT_CLUMP.get(),
                handle.existingParent(BlockRegistration.LARGE_SILT_CLUMP.get(), "1", modelLargeRock1, BlockRegistration.SILT.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_GREYWACKE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_GREYWACKE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.GREYWACKE.get()) // 2 and 3
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SILTSTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_SILTSTONE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.SILTSTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_DOLOSTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_DOLOSTONE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.DOLOSTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_LIMESTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_LIMESTONE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.LIMESTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_IRONSTONE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_IRONSTONE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.IRONSTONE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SHALE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_SHALE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.SHALE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_ARKOSE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_ARKOSE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.ARKOSE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_MARBLE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_MARBLE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.MARBLE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_QUARTZITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_QUARTZITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.QUARTZITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_HORNFELS_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_HORNFELS_ROCK.get(), "1", modelLargeRock1, BlockRegistration.HORNFELS.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SLATE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_SLATE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.SLATE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_GABBRO_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_GABBRO_ROCK.get(), "1", modelLargeRock1, BlockRegistration.GABBRO.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.SMOOTH_DIORITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.SMOOTH_GRANITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_NORITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_NORITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.NORITE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LARGE_PERIDOTITE_ROCK.get(),
                handle.existingParent(BlockRegistration.LARGE_PERIDOTITE_ROCK.get(), "1", modelLargeRock1, BlockRegistration.PERIDOTITE.get())
        );

        // COPPER ROCK
        handle.randomModelAndRotationBlock(
                BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.CHALK_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.CHALK_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.CHALK_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.SHALE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.SHALE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.SHALE_ROCK_COPPER_ORE.get())
        );
        handle.randomModelAndRotationBlock(
                BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get(),
                handle.existingParent(BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get(), modelRock1, BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get())
        );

        handle.simpleTintedCrossBlock(BlockRegistration.SHRUB.get());
        softRushBlock(handle, BlockRegistration.SOFT_RUSH.get());
    }

    public void softRushBlock(BlockStateEntryProviderHandle handle, Block block)
    {
        ResourceLocation textureLower0 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_lower0");
        ResourceLocation textureLower1 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_lower1");
        ResourceLocation textureLower2 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_lower2");
        ResourceLocation textureLower3 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_lower3");
        ResourceLocation textureLower4 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_lower4");
        ResourceLocation textureUpper3 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_upper3");
        ResourceLocation textureUpper4 = handle.blockTexture(BlockRegistration.SOFT_RUSH.get(), "_upper4");

        ModelFile modelLower0 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_lower0"), textureLower0);
        ModelFile modelLower1 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_lower1"), textureLower1);
        ModelFile modelLower2 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_lower2"), textureLower2);
        ModelFile modelLower3 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_lower3"), textureLower3);
        ModelFile modelLower4 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_lower4"), textureLower4);
        ModelFile modelUpper3 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_upper3"), textureUpper3);
        ModelFile modelUpper4 = handle.tintedCrossModel(handle.blockModelName(BlockRegistration.SOFT_RUSH.get(), "_upper4"), textureUpper4);

        ConfiguredModel confModelLower0 = new ConfiguredModel(modelLower0, 0, 0, false);
        ConfiguredModel confModelLower1 = new ConfiguredModel(modelLower1, 0, 0, false);
        ConfiguredModel confModelLower2 = new ConfiguredModel(modelLower2, 0, 0, false);
        ConfiguredModel confModelLower3 = new ConfiguredModel(modelLower3, 0, 0, false);
        ConfiguredModel confModelLower4 = new ConfiguredModel(modelLower4, 0, 0, false);
        ConfiguredModel confModelUpper3 = new ConfiguredModel(modelUpper3, 0, 0, false);
        ConfiguredModel confModelUpper4 = new ConfiguredModel(modelUpper4, 0, 0, false);

        VariantBlockStateBuilder builder = handle.getVariantBuilder(block);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.LOWER).with(SoftRushBlock.AGE, 0).setModels(confModelLower0);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.LOWER).with(SoftRushBlock.AGE, 1).setModels(confModelLower1);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.LOWER).with(SoftRushBlock.AGE, 2).setModels(confModelLower2);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.LOWER).with(SoftRushBlock.AGE, 3).setModels(confModelLower3);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.LOWER).with(SoftRushBlock.AGE, 4).setModels(confModelLower4);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.UPPER).with(SoftRushBlock.AGE, 0).setModels(confModelUpper3);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.UPPER).with(SoftRushBlock.AGE, 1).setModels(confModelUpper3);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.UPPER).with(SoftRushBlock.AGE, 2).setModels(confModelUpper3);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.UPPER).with(SoftRushBlock.AGE, 3).setModels(confModelUpper3);
        builder.partialState().with(SoftRushBlock.HALF, DoubleBlockHalf.UPPER).with(SoftRushBlock.AGE, 4).setModels(confModelUpper4);
    }
}
