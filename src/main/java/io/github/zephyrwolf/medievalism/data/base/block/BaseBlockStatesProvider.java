package io.github.zephyrwolf.medievalism.data.base.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.tools.WarmthTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class BaseBlockStatesProvider extends BlockStateProvider { // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final ExistingFileHelper existingFileHelper;

    public BaseBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void registerStatesAndModels()
    {
        grassBlock4(BlockRegistration.CLAY_IN_GRASS.get());
        grassBlock4(BlockRegistration.RED_CLAY_IN_GRASS.get());
        pillarBlock4(BlockRegistration.CLAY_IN_DIRT.get());
        pillarBlock4(BlockRegistration.RED_CLAY_IN_DIRT.get());

        simpleBlock(BlockRegistration.RED_CLAY.get());
        simpleBlock(BlockRegistration.TIN_ORE_IN_GREYWACKE.get());
        simpleBlock(BlockRegistration.TIN_ORE_IN_GABBRO.get());

        simpleBlock(BlockRegistration.SILT.get());

        ResourceLocation sandstone_bottom = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "sandstone_bottom");
        ResourceLocation red_sandstone_bottom = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "red_sandstone_bottom");

        // STONE
        simpleBlock(BlockRegistration.SOFT_TUFF.get());
        simpleBlock(BlockRegistration.IGNIMBRITE.get());
        simpleBlock(BlockRegistration.LAPILLISTONE.get());
        simpleBlock(BlockRegistration.SAPROLITE.get());
        simpleBlock(BlockRegistration.LATERITE.get());
        simpleBlock(BlockRegistration.SILTSTONE.get());
        simpleBlock(BlockRegistration.DOLOSTONE.get());
        simpleBlock(BlockRegistration.LIMESTONE.get());
        simpleBlock(BlockRegistration.CHALK.get());
        simpleBlock(BlockRegistration.IRONSTONE.get());
        simpleBlock(BlockRegistration.SHALE.get());
        simpleBlock(BlockRegistration.DACITE.get());
        simpleBlock(BlockRegistration.RHYOLITE.get());
        simpleBlock(BlockRegistration.MARBLE.get());
        simpleBlock(BlockRegistration.QUARTZITE.get());
        simpleBlock(BlockRegistration.HORNFELS.get());
        simpleBlock(BlockRegistration.SLATE.get());
        simpleBlock(BlockRegistration.ARKOSE.get());
        simpleBlock(BlockRegistration.NORITE.get());
        simpleBlock(BlockRegistration.PERIDOTITE.get());
        simpleBlock(BlockRegistration.SMOOTH_DIORITE.get());
        simpleBlock(BlockRegistration.SMOOTH_GRANITE.get());
        // INFESTED STONE
        infestedBlock(BlockRegistration.INFESTED_SILTSTONE.get(),       BlockRegistration.SILTSTONE.get());
        infestedBlock(BlockRegistration.INFESTED_DOLOSTONE.get(),       BlockRegistration.DOLOSTONE.get());
        infestedBlock(BlockRegistration.INFESTED_LIMESTONE.get(),       BlockRegistration.LIMESTONE.get());
        infestedBlock(BlockRegistration.INFESTED_SHALE.get(),           BlockRegistration.SHALE.get());
        infestedBlock(BlockRegistration.INFESTED_ARKOSE.get(),          BlockRegistration.ARKOSE.get());
        infestedBlock(BlockRegistration.INFESTED_MARBLE.get(),          BlockRegistration.MARBLE.get());
        infestedBlock(BlockRegistration.INFESTED_QUARTZITE.get(),       BlockRegistration.QUARTZITE.get());
        infestedBlock(BlockRegistration.INFESTED_HORNFELS.get(),        BlockRegistration.HORNFELS.get());
        infestedBlock(BlockRegistration.INFESTED_SLATE.get(),           BlockRegistration.SLATE.get());
        infestedBlock(BlockRegistration.INFESTED_SMOOTH_DIORITE.get(),  BlockRegistration.SMOOTH_DIORITE.get());
        infestedBlock(BlockRegistration.INFESTED_SMOOTH_GRANITE.get(),  BlockRegistration.SMOOTH_GRANITE.get());
        infestedBlock(BlockRegistration.INFESTED_NORITE.get(),          BlockRegistration.NORITE.get());
        infestedBlock(BlockRegistration.INFESTED_PERIDOTITE.get(),      BlockRegistration.PERIDOTITE.get());
        infestedBlock(BlockRegistration.INFESTED_RHYOLITE.get(),        BlockRegistration.RHYOLITE.get());
        infestedBlock(BlockRegistration.INFESTED_DACITE.get(),          BlockRegistration.DACITE.get());
        infestedBlock(BlockRegistration.INFESTED_ANDESITE.get(),        BlockRegistration.ANDESITE.get());
        infestedBlock(BlockRegistration.INFESTED_BASALT.get(),          BlockRegistration.BASALT.get());
        // COPPER ORE
        simpleBlock(BlockRegistration.SAPROLITE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.LATERITE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.GREYWACKE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.SILTSTONE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.DOLOSTONE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.LIMESTONE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.CHALK_COPPER_ORE.get());
        simpleBlock(BlockRegistration.IRONSTONE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.SHALE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.ARKOSE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.MARBLE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.QUARTZITE_COPPER_ORE.get());
        simpleBlock(BlockRegistration.HORNFELS_COPPER_ORE.get());
        simpleBlock(BlockRegistration.SLATE_COPPER_ORE.get());
        // IRON ORE
        simpleBlock(BlockRegistration.GABBRO_IRON_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.NORITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.PERIDOTITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.RHYOLITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.DACITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.ANDESITE_IRON_ORE.get());
        simpleBlock(BlockRegistration.BASALT_IRON_ORE.get());
        // GOLD ORE
        simpleBlock(BlockRegistration.GREYWACKE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.SILTSTONE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.DOLOSTONE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.LIMESTONE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.CHALK_GOLD_ORE.get());
        simpleBlock(BlockRegistration.IRONSTONE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.SHALE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.ARKOSE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.MARBLE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.QUARTZITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.HORNFELS_GOLD_ORE.get());
        simpleBlock(BlockRegistration.SLATE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.GABBRO_GOLD_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.NORITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.PERIDOTITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.RHYOLITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.DACITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.ANDESITE_GOLD_ORE.get());
        simpleBlock(BlockRegistration.BASALT_GOLD_ORE.get());
        // COAL ORE
        simpleBlock(BlockRegistration.SAPROLITE_COAL_ORE.get());
        simpleBlock(BlockRegistration.LATERITE_COAL_ORE.get());
        simpleBlock(BlockRegistration.GREYWACKE_COAL_ORE.get());
        simpleBlock(BlockRegistration.SILTSTONE_COAL_ORE.get());
        simpleBlock(BlockRegistration.DOLOSTONE_COAL_ORE.get());
        simpleBlock(BlockRegistration.LIMESTONE_COAL_ORE.get());
        simpleBlock(BlockRegistration.CHALK_COAL_ORE.get());
        simpleBlock(BlockRegistration.IRONSTONE_COAL_ORE.get());
        simpleBlock(BlockRegistration.SHALE_COAL_ORE.get());
        simpleBlock(BlockRegistration.ARKOSE_COAL_ORE.get());
        simpleBlock(BlockRegistration.MARBLE_COAL_ORE.get());
        simpleBlock(BlockRegistration.QUARTZITE_COAL_ORE.get());
        simpleBlock(BlockRegistration.HORNFELS_COAL_ORE.get());
        simpleBlock(BlockRegistration.SLATE_COAL_ORE.get());
        // DIAMOND ORE
        simpleBlock(BlockRegistration.GABBRO_DIAMOND_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get());
        simpleBlock(BlockRegistration.NORITE_DIAMOND_ORE.get());
        simpleBlock(BlockRegistration.PERIDOTITE_DIAMOND_ORE.get());
        simpleBlock(BlockRegistration.ANDESITE_DIAMOND_ORE.get());
        simpleBlock(BlockRegistration.BASALT_DIAMOND_ORE.get());
        // EMERALD ORE
        simpleBlock(BlockRegistration.GABBRO_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.NORITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.PERIDOTITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.RHYOLITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.DACITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.ANDESITE_EMERALD_ORE.get());
        simpleBlock(BlockRegistration.BASALT_EMERALD_ORE.get());
        // LAPIS ORE
        simpleBlock(BlockRegistration.MARBLE_LAPIS_ORE.get());
        simpleBlock(BlockRegistration.QUARTZITE_LAPIS_ORE.get());
        simpleBlock(BlockRegistration.HORNFELS_LAPIS_ORE.get());
        simpleBlock(BlockRegistration.SLATE_LAPIS_ORE.get());
        // REDSTONE ORE
        simpleBlock(BlockRegistration.GABBRO_REDSTONE_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get());
        simpleBlock(BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get());
        simpleBlock(BlockRegistration.NORITE_REDSTONE_ORE.get());
        simpleBlock(BlockRegistration.PERIDOTITE_REDSTONE_ORE.get());

        // COBBLE
        simpleBlock(BlockRegistration.COBBLED_SOFT_TUFF.get());
        simpleBlock(BlockRegistration.COBBLED_IGNIMBRITE.get());
        simpleBlock(BlockRegistration.COBBLED_WELDED_TUFF.get());
        simpleBlock(BlockRegistration.COBBLED_LAPILLISTONE.get());
        simpleBlock(BlockRegistration.COBBLED_SANDSTONE.get(), cube("cobbled_sandstone", sandstone_bottom));
        simpleBlock(BlockRegistration.COBBLED_RED_SANDSTONE.get(), cube("cobbled_red_sandstone", red_sandstone_bottom));
        simpleBlock(BlockRegistration.COBBLED_SAPROLITE.get());
        simpleBlock(BlockRegistration.COBBLED_LATERITE.get());
        simpleBlock(BlockRegistration.COBBLED_SILTSTONE.get());
        simpleBlock(BlockRegistration.COBBLED_DOLOSTONE.get());
        simpleBlock(BlockRegistration.COBBLED_LIMESTONE.get());
        simpleBlock(BlockRegistration.COBBLED_CHALK.get());
        simpleBlock(BlockRegistration.COBBLED_IRONSTONE.get());
        simpleBlock(BlockRegistration.COBBLED_SHALE.get());
        simpleBlock(BlockRegistration.COBBLED_ARKOSE.get());

        // INFESTED COBBLE
        infestedBlock(BlockRegistration.INFESTED_COBBLED_SILTSTONE.get(),   BlockRegistration.COBBLED_SILTSTONE.get());
        infestedBlock(BlockRegistration.INFESTED_COBBLED_DOLOSTONE.get(),   BlockRegistration.COBBLED_DOLOSTONE.get());
        infestedBlock(BlockRegistration.INFESTED_COBBLED_LIMESTONE.get(),   BlockRegistration.COBBLED_LIMESTONE.get());
        infestedBlock(BlockRegistration.INFESTED_COBBLED_CHALK.get(),       BlockRegistration.COBBLED_CHALK.get());
        infestedBlock(BlockRegistration.INFESTED_COBBLED_IRONSTONE.get(),   BlockRegistration.COBBLED_IRONSTONE.get());
        infestedBlock(BlockRegistration.INFESTED_COBBLED_SHALE.get(),       BlockRegistration.COBBLED_SHALE.get());
        infestedBlock(BlockRegistration.INFESTED_COBBLED_ARKOSE.get(),      BlockRegistration.COBBLED_ARKOSE.get());

        simpleBlock(BlockRegistration.LIMESTONE_CHERT_ORE.get());
        simpleBlock(BlockRegistration.CHALK_CHERT_ORE.get());
        simpleBlock(BlockRegistration.BASALT_GEODE_ORE.get());
        simpleBlock(BlockRegistration.ANDESITE_GEODE_ORE.get());
        simpleBlock(BlockRegistration.RHYOLITE_GEODE_ORE.get());
        simpleBlock(BlockRegistration.DACITE_GEODE_ORE.get());

        simpleBlock(BlockRegistration.WET_PACKED_MUD.get());
        simpleBlock(BlockRegistration.WET_DAUB_BLOCK.get());
        simpleBlock(BlockRegistration.DAUB_BLOCK.get());
        simpleBlock(BlockRegistration.DAUB_BRICKS.get());
        simpleBlock(BlockRegistration.CRACKED_DAUB_BLOCK.get());
        simpleBlock(BlockRegistration.CRACKED_DAUB_BRICKS.get());

        //region Branches
        randomYRotationIntegerState(
                BlockRegistration.TWIGS.get(),
                TwigsBlock.NUM_STICKS,
                existingModel(BlockRegistration.TWIGS.get(), "1"),
                existingModel(BlockRegistration.TWIGS.get(), "2"),
                existingModel(BlockRegistration.TWIGS.get(), "3")
        );

        randomYRotationBlock(BlockRegistration.OAK_BRANCH.get(), existingParent(BlockRegistration.OAK_BRANCH.get(), "block/branch", "", BlockRegistration.OAK_BRANCH.get(), Blocks.OAK_LOG));
        randomYRotationBlock(BlockRegistration.BIRCH_BRANCH.get(), existingParent(BlockRegistration.BIRCH_BRANCH.get(), "block/branch", "", BlockRegistration.BIRCH_BRANCH.get(), Blocks.BIRCH_LOG));
        randomYRotationBlock(BlockRegistration.SPRUCE_BRANCH.get(), existingParent(BlockRegistration.SPRUCE_BRANCH.get(), "block/branch", "", BlockRegistration.SPRUCE_BRANCH.get(), Blocks.SPRUCE_LOG));
        randomYRotationBlock(BlockRegistration.JUNGLE_BRANCH.get(), existingParent(BlockRegistration.JUNGLE_BRANCH.get(), "block/branch", "", BlockRegistration.JUNGLE_BRANCH.get(), Blocks.JUNGLE_LOG));
        randomYRotationBlock(BlockRegistration.DARK_OAK_BRANCH.get(), existingParent(BlockRegistration.DARK_OAK_BRANCH.get(), "block/branch", "", BlockRegistration.DARK_OAK_BRANCH.get(), Blocks.DARK_OAK_LOG));
        randomYRotationBlock(BlockRegistration.ACACIA_BRANCH.get(), existingParent(BlockRegistration.ACACIA_BRANCH.get(), "block/branch", "", BlockRegistration.ACACIA_BRANCH.get(), Blocks.ACACIA_LOG));
        randomYRotationBlock(BlockRegistration.CHERRY_BRANCH.get(), existingParent(BlockRegistration.CHERRY_BRANCH.get(), "block/branch", "", BlockRegistration.CHERRY_BRANCH.get(), Blocks.CHERRY_LOG));
        randomYRotationBlock(BlockRegistration.MANGROVE_BRANCH.get(), existingParent(BlockRegistration.MANGROVE_BRANCH.get(), "block/branch", "", BlockRegistration.MANGROVE_BRANCH.get(), Blocks.MANGROVE_LOG));
        //endregion

        //region Rocks
        ResourceLocation sandstone_top = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "sandstone_top");
        ResourceLocation red_sandstone_top = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "red_sandstone_top");

        randomYRotationBlock(
                BlockRegistration.SANDSTONE_ROCK.get(),
                existingParent(BlockRegistration.SANDSTONE_ROCK.get(), "block/base_rock1", "1", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK.get(), "block/base_rock2", "2", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK.get(), "block/base_rock3", "3", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK.get(), "block/base_rock4", "4", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK.get(), "block/base_rock5", "5", sandstone_top, sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.RED_SANDSTONE_ROCK.get(),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK.get(), "block/base_rock1", "1", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK.get(), "block/base_rock2", "2", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK.get(), "block/base_rock3", "3", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK.get(), "block/base_rock4", "4", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK.get(), "block/base_rock5", "5", red_sandstone_top, red_sandstone_top)
        );

        randomYRotationBlock(
                BlockRegistration.SAPROLITE_ROCK.get(),
                existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.SAPROLITE.get()),
                existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.SAPROLITE.get()),
                existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.SAPROLITE.get()),
                existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.SAPROLITE.get()),
                existingParent(BlockRegistration.SAPROLITE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.SAPROLITE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LATERITE_ROCK.get(),
                existingParent(BlockRegistration.LATERITE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.LATERITE.get()),
                existingParent(BlockRegistration.LATERITE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.LATERITE.get()),
                existingParent(BlockRegistration.LATERITE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.LATERITE.get()),
                existingParent(BlockRegistration.LATERITE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.LATERITE.get()),
                existingParent(BlockRegistration.LATERITE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.LATERITE.get())
        );
        randomYRotationBlock(
                BlockRegistration.GREYWACKE_ROCK.get(),
                existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.GREYWACKE.get()),
                existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.GREYWACKE.get()),
                existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.GREYWACKE.get()),
                existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.GREYWACKE.get()),
                existingParent(BlockRegistration.GREYWACKE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.GREYWACKE.get())
        );
        randomYRotationBlock(
                BlockRegistration.SILTSTONE_ROCK.get(),
                existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.SILTSTONE.get()),
                existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.SILTSTONE.get()),
                existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.SILTSTONE.get()),
                existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.SILTSTONE.get()),
                existingParent(BlockRegistration.SILTSTONE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.SILTSTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.DOLOSTONE_ROCK.get(),
                existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.DOLOSTONE.get()),
                existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.DOLOSTONE.get()),
                existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.DOLOSTONE.get()),
                existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.DOLOSTONE.get()),
                existingParent(BlockRegistration.DOLOSTONE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.DOLOSTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LIMESTONE_ROCK.get(),
                existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.LIMESTONE.get()),
                existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.LIMESTONE.get()),
                existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.LIMESTONE.get()),
                existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.LIMESTONE.get()),
                existingParent(BlockRegistration.LIMESTONE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.LIMESTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.IRONSTONE_ROCK.get(),
                existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.IRONSTONE.get()),
                existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.IRONSTONE.get()),
                existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.IRONSTONE.get()),
                existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.IRONSTONE.get()),
                existingParent(BlockRegistration.IRONSTONE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.IRONSTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.SHALE_ROCK.get(),
                existingParent(BlockRegistration.SHALE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.SHALE.get()),
                existingParent(BlockRegistration.SHALE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.SHALE.get()),
                existingParent(BlockRegistration.SHALE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.SHALE.get()),
                existingParent(BlockRegistration.SHALE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.SHALE.get()),
                existingParent(BlockRegistration.SHALE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.SHALE.get())
        );

        randomYRotationBlock(
                BlockRegistration.ARKOSE_ROCK.get(),
                existingParent(BlockRegistration.ARKOSE_ROCK.get(), "block/base_rock1", "1", BlockRegistration.ARKOSE.get()),
                existingParent(BlockRegistration.ARKOSE_ROCK.get(), "block/base_rock2", "2", BlockRegistration.ARKOSE.get()),
                existingParent(BlockRegistration.ARKOSE_ROCK.get(), "block/base_rock3", "3", BlockRegistration.ARKOSE.get()),
                existingParent(BlockRegistration.ARKOSE_ROCK.get(), "block/base_rock4", "4", BlockRegistration.ARKOSE.get()),
                existingParent(BlockRegistration.ARKOSE_ROCK.get(), "block/base_rock5", "5", BlockRegistration.ARKOSE.get())
        );
        // LARGE ROCK
        randomYRotationBlock(
                BlockRegistration.LARGE_SANDSTONE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_SANDSTONE_ROCK.get(), "block/base_large_rock1", "1", sandstone_top, sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "block/base_large_rock1", "1", red_sandstone_top, red_sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_SAPROLITE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_SAPROLITE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.SAPROLITE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_LATERITE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_LATERITE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.LATERITE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_GREYWACKE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_GREYWACKE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.GREYWACKE.get()) // 2 and 3
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_SILTSTONE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_SILTSTONE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.SILTSTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_DOLOSTONE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_DOLOSTONE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.DOLOSTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_LIMESTONE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_LIMESTONE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.LIMESTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_IRONSTONE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_IRONSTONE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.IRONSTONE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_SHALE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_SHALE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.SHALE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LARGE_ARKOSE_ROCK.get(),
                existingParent(BlockRegistration.LARGE_ARKOSE_ROCK.get(), "block/base_large_rock1", "1", BlockRegistration.ARKOSE.get())
        );
        // COPPER ROCK
        randomYRotationBlock(
                BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.CHALK_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.CHALK_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.CHALK_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.SHALE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.SHALE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.SHALE_ROCK_COPPER_ORE.get())
        );
        randomYRotationBlock(
                BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get(),
                existingParent(BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "block/base_rock1", "", BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get())
        );

        simpleBlock(BlockRegistration.SHRUB.get(), tintedCross(BlockRegistration.SHRUB.get(), ""));
        //endregion

        //region Primitive
        randomYRotationIntegerState(
                BlockRegistration.FIRE_LAY.get(),
                FireLayBlock.STAGE_PROP,
                existingModel(BlockRegistration.FIRE_LAY.get(), "1"),
                existingModel(BlockRegistration.FIRE_LAY.get(), "2"),
                existingModel(BlockRegistration.FIRE_LAY.get(), "3"),
                existingModel(BlockRegistration.FIRE_LAY.get(), "4"),
                existingModel(BlockRegistration.FIRE_LAY.get(), "5")
        );
        //endregion

        //region Pottery
        // Gatherer's Jar
        dryingBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(),
                existingParent("wet_" + blockName(BlockRegistration.GATHERERS_JAR.get()), "block/gatherers_jar",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_gatherers_jar")),
                existingParent("dry_" + blockName(BlockRegistration.GATHERERS_JAR.get()), "block/gatherers_jar",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_gatherers_jar")));
        simpleBlock(
                BlockRegistration.GATHERERS_JAR.get(),
                existingModel(BlockRegistration.GATHERERS_JAR.get(), ""));

        // Keeper's Crock
        dryingBlockHorizontalAxis(BlockRegistration.DRYING_KEEPERS_CROCK.get(),
                existingParent("wet_" + blockName(BlockRegistration.KEEPERS_CROCK.get()), "block/keepers_crock",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_keepers_crock")),
                existingParent("wet_" + blockName(BlockRegistration.KEEPERS_CROCK.get()) + "_rotated", "block/keepers_crock_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_keepers_crock")),
                existingParent("dry_" + blockName(BlockRegistration.KEEPERS_CROCK.get()), "block/keepers_crock",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_keepers_crock")),
                existingParent("dry_" + blockName(BlockRegistration.KEEPERS_CROCK.get()) + "_rotated", "block/keepers_crock_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_keepers_crock")));
        horizontalAxisBlock(
                BlockRegistration.KEEPERS_CROCK.get(),
                existingModel(BlockRegistration.KEEPERS_CROCK.get(), ""),
                existingModel(BlockRegistration.KEEPERS_CROCK.get(), "_rotated"));

        // Settler's Pot
        dryingBlockHorizontalAxis(BlockRegistration.DRYING_SETTLERS_POT.get(),
                existingParent("wet_" + blockName(BlockRegistration.SETTLERS_POT.get()), "block/settlers_pot",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_settlers_pot")),
                existingParent("wet_" + blockName(BlockRegistration.SETTLERS_POT.get()) + "_rotated", "block/settlers_pot_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_settlers_pot")),
                existingParent("dry_" + blockName(BlockRegistration.SETTLERS_POT.get()), "block/settlers_pot",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_settlers_pot")),
                existingParent("dry_" + blockName(BlockRegistration.SETTLERS_POT.get()) + "_rotated", "block/settlers_pot_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_settlers_pot")));
        horizontalAxisBlock(
                BlockRegistration.SETTLERS_POT.get(),
                existingModel(BlockRegistration.SETTLERS_POT.get(), ""),
                existingModel(BlockRegistration.SETTLERS_POT.get(), "_rotated"));

        // Clay Cooking Pot
        dryingBlockHorizontalAxis(BlockRegistration.DRYING_CLAY_COOKING_POT.get(),
                existingParent("wet_" + blockName(BlockRegistration.CLAY_COOKING_POT.get()), "block/clay_cooking_pot",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_clay_cooking_pot")),
                existingParent("wet_" + blockName(BlockRegistration.CLAY_COOKING_POT.get()) + "_rotated", "block/clay_cooking_pot_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_clay_cooking_pot")),
                existingParent("dry_" + blockName(BlockRegistration.CLAY_COOKING_POT.get()), "block/clay_cooking_pot",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_clay_cooking_pot")),
                existingParent("dry_" + blockName(BlockRegistration.CLAY_COOKING_POT.get()) + "_rotated", "block/clay_cooking_pot_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_clay_cooking_pot")));
        horizontalAxisBlock(
                BlockRegistration.CLAY_COOKING_POT.get(),
                existingModel(BlockRegistration.CLAY_COOKING_POT.get(), ""),
                existingModel(BlockRegistration.CLAY_COOKING_POT.get(), "_rotated"));

        // Clay Cauldron
        dryingBlockHorizontalAxis(BlockRegistration.DRYING_CLAY_CAULDRON.get(),
                existingParent("wet_" + blockName(BlockRegistration.CLAY_CAULDRON.get()), "block/clay_cauldron",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_clay_cauldron")),
                existingParent("wet_" + blockName(BlockRegistration.CLAY_CAULDRON.get()) + "_rotated", "block/clay_cauldron_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_clay_cauldron")),
                existingParent("dry_" + blockName(BlockRegistration.CLAY_CAULDRON.get()), "block/clay_cauldron",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_clay_cauldron")),
                existingParent("dry_" + blockName(BlockRegistration.CLAY_CAULDRON.get()) + "_rotated", "block/clay_cauldron_rotated",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_clay_cauldron")));
        horizontalAxisBlock(
                BlockRegistration.CLAY_CAULDRON.get(),
                existingModel(BlockRegistration.CLAY_CAULDRON.get(), ""),
                existingModel(BlockRegistration.CLAY_CAULDRON.get(), "_rotated"));

        // Jug
        dryingBlockHorizontalFacing(BlockRegistration.DRYING_JUG.get(),
                existingParent("wet_" + blockName(BlockRegistration.JUG.get()), "block/jug",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_jug")),
                existingParent("wet_" + blockName(BlockRegistration.JUG.get()) + "_east", "block/jug_east",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_jug")),
                existingParent("wet_" + blockName(BlockRegistration.JUG.get()) + "_south", "block/jug_south",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_jug")),
                existingParent("wet_" + blockName(BlockRegistration.JUG.get()) + "_west", "block/jug_west",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_jug")),

                existingParent("dry_" + blockName(BlockRegistration.JUG.get()), "block/jug",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_jug")),
                existingParent("dry_" + blockName(BlockRegistration.JUG.get()) + "_east", "block/jug_east",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_jug")),
                existingParent("dry_" + blockName(BlockRegistration.JUG.get()) + "_south", "block/jug_south",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_jug")),
                existingParent("dry_" + blockName(BlockRegistration.JUG.get()) + "_west", "block/jug_west",
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_jug")));
        horizontalFacingBlock(
                BlockRegistration.JUG.get(),
                existingModel(BlockRegistration.JUG.get(), ""),
                existingModel(BlockRegistration.JUG.get(), "_east"),
                existingModel(BlockRegistration.JUG.get(), "_south"),
                existingModel(BlockRegistration.JUG.get(), "_west"));

        // Flower Pot
        dryingBlock(BlockRegistration.DRYING_FLOWER_POT.get(),
                existingParent("wet_" + blockName(Blocks.FLOWER_POT), ResourceLocation.withDefaultNamespace("block/flower_pot"), // Is this going to see namespace Minecraft?
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_flower_pot")),
                existingParent("dry_" + blockName(Blocks.FLOWER_POT), ResourceLocation.withDefaultNamespace("block/flower_pot"),
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_flower_pot")));

        // Decorated Pot
        dryingBlock(BlockRegistration.DRYING_DECORATED_POT.get(),
                existingParent("wet_" + blockName(Blocks.DECORATED_POT), ResourceLocation.withDefaultNamespace("block/decorated_pot"),
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "wet_decorated_pot")),
                existingParent("dry_" + blockName(Blocks.DECORATED_POT), ResourceLocation.withDefaultNamespace("block/decorated_pot"),
                        MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "dry_decorated_pot")));

        //endregion

        //region Crops
        cropBlock4(BlockRegistration.YAMS.get());
        crossBlock(BlockRegistration.WILD_YAMS.get());
        //endregion

        axisBlock(BlockRegistration.THATCH.get());
        crossBlock(BlockRegistration.DOGBANE.get());

        shortBlock(BlockRegistration.STONE_BENCH.get());
        shortBlock(BlockRegistration.CHOPPING_BLOCK.get());

        dryingBrickBlock(BlockRegistration.WET_PACKED_MUD_BRICK.get(), MedievalismConstants.resource("block/wet_packed_mud"), ResourceLocation.withDefaultNamespace("block/packed_mud"));
        dryingBrickBlock(BlockRegistration.WET_DAUB_BRICK.get(), MedievalismConstants.resource("block/wet_daub_block"), MedievalismConstants.resource("block/daub_block"));
        dryingBrickBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), ResourceLocation.withDefaultNamespace("block/clay"), MedievalismConstants.resource("block/unfired_clay"));
        dryingBrickBlock(BlockRegistration.DRYING_RED_CLAY_BRICK.get(), MedievalismConstants.resource("block/red_clay"), MedievalismConstants.resource("block/unfired_clay"));
    }

    //region Util
    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }
    //endregion

    //region Blocks
    //region - Drying Blocks
    private void dryingBlock(DryingBlock block, ModelFile wetModel, ModelFile dryModel)
    {
        getVariantBuilder(block)
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .modelForState().modelFile(wetModel).addModel()
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .modelForState().modelFile(dryModel).addModel();
    }

    private void infestedBlock(Block block, Block mirror)
    {
        simpleBlock(block, cubeAll(mirror));
    }

    private void dryingBlockHorizontalAxis(DryingBlockHorizontalAxis block, ModelFile wetZModel, ModelFile wetXModel, ModelFile dryZModel, ModelFile dryXModel)
    {
        getVariantBuilder(block)
                // Z
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockHorizontalAxis.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(wetZModel).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockHorizontalAxis.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(dryZModel).addModel()
                // X
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockHorizontalAxis.AXIS, Direction.Axis.X)
                .modelForState().modelFile(wetXModel).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockHorizontalAxis.AXIS, Direction.Axis.X)
                .modelForState().modelFile(dryXModel).addModel();
    }

    private void dryingBlockHorizontalFacing(DryingBlockHorizontalFacing block, ModelFile wetModelNorth, ModelFile wetModelEast, ModelFile wetModelSouth, ModelFile wetModelWest, ModelFile dryModelNorth, ModelFile dryModelEast, ModelFile dryModelSouth, ModelFile dryModelWest)
    {
        getVariantBuilder(block)
                // North
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.NORTH)
                .modelForState().modelFile(wetModelNorth).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.NORTH)
                .modelForState().modelFile(dryModelNorth).addModel()
                // East
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.EAST)
                .modelForState().modelFile(wetModelEast).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.EAST)
                .modelForState().modelFile(dryModelEast).addModel()
                // South
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.SOUTH)
                .modelForState().modelFile(wetModelSouth).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.SOUTH)
                .modelForState().modelFile(dryModelSouth).addModel()
                // West
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.WEST)
                .modelForState().modelFile(wetModelWest).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockHorizontalFacing.DIRECTION, Direction.WEST)
                .modelForState().modelFile(dryModelWest).addModel();
    }

    private void dryingBrickBlock(Block block, ResourceLocation wetTexture, ResourceLocation dryTexture)
    {
        var builder = getMultipartBuilder(block);

        for (EnumProperty<WarmthTools.DryingBrickState> aProp : DryingBrick.BRICK_PROPERTIES)
        {
            for (WarmthTools.DryingBrickState brick : WarmthTools.DryingBrickState.values()) {
                if (brick.isEmpty()) continue;
                ModelFile model = dryingBrickModel(
                        (brick == WarmthTools.DryingBrickState.WET ? blockName(block) : blockName(block) + "_dried"),
                        aProp, brick,
                        brick == WarmthTools.DryingBrickState.WET ? wetTexture : dryTexture);
                for (Direction dir : BlockStateProperties.HORIZONTAL_FACING.getPossibleValues()) {
                    builder.part()
                            .rotationY(((dir.get2DDataValue() + 2)%4) * 90) .modelFile(model).addModel()
                            .condition(aProp, brick)
                            .condition(BlockStateProperties.HORIZONTAL_FACING, dir)
                            .end();
                }
            }
        }
    }
    //endregion

    //region - Basic Rotating Blocks
    @SuppressWarnings("unused")
    private void horizontalAxisBlock(Block block, ModelFile model) {
        horizontalAxisBlock(block, model, model);
    }

    private void horizontalAxisBlock(Block block, ModelFile zAxisModel, ModelFile xAxisModel) {
        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.Z)
                .modelForState().modelFile(zAxisModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X)
                .modelForState().modelFile(xAxisModel).rotationY(180).addModel();
    }

    private void horizontalFacingBlock(Block block, ModelFile northModel, ModelFile eastModel, ModelFile southModel, ModelFile westModel)
    {
        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .modelForState().modelFile(northModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .modelForState().modelFile(eastModel).rotationY(90).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .modelForState().modelFile(southModel).rotationY(180).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .modelForState().modelFile(westModel).rotationY(270).addModel();
    }

    private void randomYRotationIntegerState(Block block, IntegerProperty prop, ModelFile... rawModels) {
        int numVariants = prop.getPossibleValues().size();
        if (numVariants != rawModels.length)
        {
            throw new RuntimeException("Number of models needs to equal the number of values within prop.");
        }
        ConfiguredModel[][] models = new ConfiguredModel[numVariants][4];
        for (int i = 0; i < numVariants; i++) {
            models[i][0] = new ConfiguredModel(rawModels[i], 0, 0, false);
            models[i][1] = new ConfiguredModel(rawModels[i], 0, 180, false);
            models[i][2] = new ConfiguredModel(rawModels[i], 0, 90, false);
            models[i][3] = new ConfiguredModel(rawModels[i], 0, 270, false);
        }
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        int i = 0;
        for (int value : prop.getPossibleValues())
        {
            builder.partialState().with(prop, value)
                .setModels(models[i++]);
        }
    }

    private void randomYRotationBlock(Block block, ModelFile... rawModels) {
        ConfiguredModel[] models = new ConfiguredModel[rawModels.length * 4];
        for (int i = 0; i < rawModels.length; i++) {
            models[i * 4] = new ConfiguredModel(rawModels[i], 0, 0, false);
            models[i * 4 + 1] = new ConfiguredModel(rawModels[i], 0, 90, false);
            models[i * 4 + 2] = new ConfiguredModel(rawModels[i], 0, 180, false);
            models[i * 4 + 3] = new ConfiguredModel(rawModels[i], 0, 270, false);
        }
        getVariantBuilder(block).partialState().setModels(models);
    }

    private void pillarBlock4(Block block)
    {
        ConfiguredModel[] models = new ConfiguredModel[4];
        for (int i = 0; i < 4; i++)
        {
            ModelFile rawModel = pillarModel(blockName(block) + (i + 1), blockTexture(Blocks.DIRT), blockTexture(block).withSuffix(Integer.toString(i+1)));
            models[i] = new ConfiguredModel(rawModel, 0, 0, false);
        }
        getVariantBuilder(block).partialState().setModels(models);
    }

    private void grassBlock4(Block block)
    {
        ConfiguredModel[] models = new ConfiguredModel[4];
        for (int i = 0; i < 4; i++)
        {
            ModelFile rawModel = grassModel(blockName(block) + (i + 1),
                    blockTexture(Blocks.DIRT),
                    blockTexture(block).withSuffix(Integer.toString(i + 1)),
                    blockTexture(Blocks.GRASS_BLOCK).withSuffix("_side_overlay"),
                    blockTexture(Blocks.GRASS_BLOCK).withSuffix("_top"));
            models[i] = new ConfiguredModel(rawModel, 0, 0, false);
        }
        getVariantBuilder(block).partialState().setModels(models);
    }
    //endregion

    //region - Common Non-Full Blocks
    private void crossBlock(Block block) {
        ModelFile rawModel = crossModel(block);
        ConfiguredModel model = new ConfiguredModel(rawModel, 0, 0, false);
        getVariantBuilder(block).partialState().setModels(model);
    }

    private void shortBlock(Block block) {
        ModelFile rawModel = shortModel(block);
        ConfiguredModel model = new ConfiguredModel(rawModel, 0, 0, false);
        getVariantBuilder(block).partialState().setModels(model);
    }
    //endregion

    //region - Plants
    private void cropBlock4(CropBlock block)
    {
        var model0 = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(blockName(block) + "_stage0", MedievalismConstants.resource("minecraft:block/crop"))
                .texture("particle", blockTexture(block).withSuffix("_stage0"))
                .texture("crop", blockTexture(block).withSuffix("_stage0"))
                .renderType("cutout");
        var model1 = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(blockName(block) + "_stage1", MedievalismConstants.resource("minecraft:block/crop"))
                .texture("particle", blockTexture(block).withSuffix("_stage1"))
                .texture("crop", blockTexture(block).withSuffix("_stage1"))
                .renderType("cutout");
        var model2 = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(blockName(block) + "_stage2", MedievalismConstants.resource("minecraft:block/crop"))
                .texture("particle", blockTexture(block).withSuffix("_stage2"))
                .texture("crop", blockTexture(block).withSuffix("_stage2"))
                .renderType("cutout");
        var model3 = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(blockName(block) + "_stage3", MedievalismConstants.resource("minecraft:block/crop"))
                .texture("particle", blockTexture(block).withSuffix("_stage3"))
                .texture("crop", blockTexture(block).withSuffix("_stage3"))
                .renderType("cutout");

        var builder = getVariantBuilder(block);
        builder
                .partialState().with(CropBlock.AGE, 0)
                .modelForState().modelFile(model0).addModel()
                .partialState().with(CropBlock.AGE, 1)
                .modelForState().modelFile(model0).addModel()
                .partialState().with(CropBlock.AGE, 2)
                .modelForState().modelFile(model1).addModel()
                .partialState().with(CropBlock.AGE, 3)
                .modelForState().modelFile(model1).addModel()
                .partialState().with(CropBlock.AGE, 4)
                .modelForState().modelFile(model2).addModel()
                .partialState().with(CropBlock.AGE, 5)
                .modelForState().modelFile(model2).addModel()
                .partialState().with(CropBlock.AGE, 6)
                .modelForState().modelFile(model2).addModel()
                .partialState().with(CropBlock.AGE, 7)
                .modelForState().modelFile(model3).addModel();
    }
    //endregion
    //endregion

    //region Models
    //region - Drying Blocks
    private ModelFile dryingBrickModel(
            String name,
            EnumProperty<WarmthTools.DryingBrickState> property,
            WarmthTools.DryingBrickState brick,
            ResourceLocation texture)
    {
        if (brick.isEmpty()) throw new IllegalStateException("Cannot obtain model for an empty DryingBrickState.");
        String suffix = "";
        if (property.equals(DryingBrick.BACK_LEFT)) suffix = "_back_left";
        if (property.equals(DryingBrick.BACK_RIGHT)) suffix = "_back_right";
        if (property.equals(DryingBrick.FRONT_LEFT)) suffix = "_front_left";
        if (property.equals(DryingBrick.FRONT_RIGHT)) suffix = "_front_right";
        if (suffix.isEmpty()) throw new IllegalStateException("Unrecognised BlockState Property.");
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name + suffix, MedievalismConstants.resource("block/base_inworld_brick" + suffix))
                .texture("0", texture) // block/...
                .texture("particle", texture);
    }
    //endregion

    //region - Common Non-Full Blocks
    private ModelFile shortModel(Block block) {
        return shortModel(
                blockName(block),
                blockTexture(block).withPath(prefix -> prefix + "_top"),
                blockTexture(block).withPath(prefix -> prefix + "_bottom"),
                blockTexture(block).withPath(prefix -> prefix + "_side")
        );
    }

    private ModelFile shortModel(String name, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "block/short"))
                .texture("top", top)
                .texture("bottom", bottom)
                .texture("side", side);
    }

    private ModelFile flatModel(Block block, boolean mirrored) {
        return flatModel(blockName(block), blockTexture(block), mirrored);
    }

    private ModelFile flatModel(String name, ResourceLocation top, boolean mirrored) {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, mirrored ? "block/flat_mirrored" : "block/flat"))
                .texture("top", top);
    }

    private ModelFile pillarModel(String modelName, ResourceLocation topTexture, ResourceLocation sideTexture)
    {
        return models()
                .withExistingParent(modelName, ResourceLocation.withDefaultNamespace("block/cube_column"))
                .texture("end", topTexture)
                .texture("side", sideTexture);
    }

    private ModelFile grassModel(String modelName, ResourceLocation bottomTexture, ResourceLocation sideTexture, ResourceLocation sideOverlayTexture, ResourceLocation topTexture)
    {
        return models()
                .withExistingParent(modelName, ResourceLocation.withDefaultNamespace("block/grass_block"))
                .texture("particle", bottomTexture)
                .texture("bottom", bottomTexture)
                .texture("top", topTexture)
                .texture("side", sideTexture)
                .texture("overlay", sideOverlayTexture)
                .renderType("cutout");
    }

    private ModelFile crossModel(Block block) {
        return crossModel(blockName(block), blockTexture(block));
    }

    private ModelFile crossModel(String name, ResourceLocation crossTexture) {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.withDefaultNamespace("block/cross"))
                .texture("cross", crossTexture)
                .renderType("cutout");
    }
    //endregion

    //region - Existing Models
    @SuppressWarnings("SameParameterValue")
    private ModelFile existingModel(Block block, String suffix) {
        return existingModel(blockName(block), suffix);
    }

    private ModelFile existingModel(String name, String suffix) {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .getExistingFile(MedievalismConstants.resource(name + suffix));
    }

    @SuppressWarnings("unused")
    private ModelFile existingParent(Block block, String parent, String suffix) {
        return existingParent(block, parent, suffix, block);
    }

    private ModelFile existingParent(Block block, String parent, String suffix, Block texture) {
        return existingParent(block, parent, suffix, texture, texture);
    }

    private ModelFile existingParent(Block block, String parent, String suffix, Block particle, Block texture) {
        return existingParent(blockName(block) + suffix, parent, blockTexture(particle), blockTexture(texture));
    }

    @SuppressWarnings("SameParameterValue")
    private ModelFile existingParent(Block block, String parent, String suffix, ResourceLocation... textures) {
        return existingParent(blockName(block) + suffix, parent, textures);
    }

    private ModelFile existingParent(String name, String parentModel, ResourceLocation... textures) {
        return existingParent(name, MedievalismConstants.resource(parentModel), textures);
    }

    private ModelFile existingParent(String name, ResourceLocation parentModel, ResourceLocation... textures) {
        BlockModelBuilder model = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, parentModel)
                .texture("particle", textures[0]);
        for (int i = 0; i < textures.length; i++) {
            model.texture(Integer.toString(i), textures[i]);
        }
        return model;
    }

    private ModelFile tintedCross(Block block, String suffix)
    {
        return tintedCross(blockName(block) + suffix, blockTexture(block));
    }

    private ModelFile tintedCross(String name, ResourceLocation texture) {
        // BlockModelProvider extends ModelProvider<BlockModelBuilder>
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, "minecraft:block/tinted_cross")
                .texture("cross", texture)
                .renderType("cutout");
    }

    private ModelFile cube(String name, ResourceLocation texture) {
        // BlockModelProvider extends ModelProvider<BlockModelBuilder>
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, "minecraft:block/cube_all")
                .texture("all", texture);
    }
    //endregion
    //endregion
}
