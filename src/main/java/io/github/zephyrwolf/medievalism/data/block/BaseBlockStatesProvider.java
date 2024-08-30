package io.github.zephyrwolf.medievalism.data.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class BaseBlockStatesProvider extends BlockStateProvider
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final ExistingFileHelper existingFileHelper;

    public BaseBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(BlockRegistration.RED_CLAY_BLOCK.get());
        simpleBlock(BlockRegistration.TIN_ORE_BLOCK.get());
        simpleBlock(BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get());
        simpleBlock(BlockRegistration.LIMESTONE_BLOCK.get());

        //region Branches
        randomYRotationBlock(BlockRegistration.OAK_BRANCH_BLOCK.get(), existingParent(BlockRegistration.OAK_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.OAK_BRANCH_BLOCK.get(), Blocks.OAK_LOG));
        randomYRotationBlock(BlockRegistration.BIRCH_BRANCH_BLOCK.get(), existingParent(BlockRegistration.BIRCH_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.BIRCH_BRANCH_BLOCK.get(), Blocks.BIRCH_LOG));
        randomYRotationBlock(BlockRegistration.SPRUCE_BRANCH_BLOCK.get(), existingParent(BlockRegistration.SPRUCE_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.SPRUCE_BRANCH_BLOCK.get(), Blocks.SPRUCE_LOG));
        randomYRotationBlock(BlockRegistration.JUNGLE_BRANCH_BLOCK.get(), existingParent(BlockRegistration.JUNGLE_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.JUNGLE_BRANCH_BLOCK.get(), Blocks.JUNGLE_LOG));
        randomYRotationBlock(BlockRegistration.DARK_OAK_BRANCH_BLOCK.get(), existingParent(BlockRegistration.DARK_OAK_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.DARK_OAK_BRANCH_BLOCK.get(), Blocks.DARK_OAK_LOG));
        randomYRotationBlock(BlockRegistration.ACACIA_BRANCH_BLOCK.get(), existingParent(BlockRegistration.ACACIA_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.ACACIA_BRANCH_BLOCK.get(), Blocks.ACACIA_LOG));
        randomYRotationBlock(BlockRegistration.CHERRY_BRANCH_BLOCK.get(), existingParent(BlockRegistration.CHERRY_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.CHERRY_BRANCH_BLOCK.get(), Blocks.CHERRY_LOG));
        randomYRotationBlock(BlockRegistration.MANGROVE_BRANCH_BLOCK.get(), existingParent(BlockRegistration.MANGROVE_BRANCH_BLOCK.get(), "block/branch", "", BlockRegistration.MANGROVE_BRANCH_BLOCK.get(), Blocks.MANGROVE_LOG));
        //endregion
        //region Rocks
        ResourceLocation sandstone_top = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "sandstone_top");
        ResourceLocation red_sandstone_top = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "red_sandstone_top");
        ResourceLocation dirt_path_top = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "dirt_path_top");
        ResourceLocation stone = ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + "stone");
        ResourceLocation mossy_rock = MedievalismConstants.resource(ModelProvider.BLOCK_FOLDER + "/" + "mossy_rock");

        randomYRotationBlock(
                BlockRegistration.ROCK_BLOCK.get(),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock","1", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock","2", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock","3", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock","4", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock","5", Blocks.STONE)
        );
        randomYRotationBlock(
                BlockRegistration.SANDSTONE_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.SANDSTONE_ROCK_BLOCK.get()), "block/base_rock", "1", sandstone_top, sandstone_top),
                existingParent(blockName(BlockRegistration.SANDSTONE_ROCK_BLOCK.get()), "block/base_rock", "2", sandstone_top, sandstone_top),
                existingParent(blockName(BlockRegistration.SANDSTONE_ROCK_BLOCK.get()), "block/base_rock","3", sandstone_top, sandstone_top),
                existingParent(blockName(BlockRegistration.SANDSTONE_ROCK_BLOCK.get()), "block/base_rock","4", sandstone_top, sandstone_top),
                existingParent(blockName(BlockRegistration.SANDSTONE_ROCK_BLOCK.get()), "block/base_rock","5", sandstone_top, sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get()), "block/base_rock", "1", red_sandstone_top, red_sandstone_top),
                existingParent(blockName(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get()), "block/base_rock", "2", red_sandstone_top, red_sandstone_top),
                existingParent(blockName(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get()), "block/base_rock","3", red_sandstone_top, red_sandstone_top),
                existingParent(blockName(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get()), "block/base_rock","4", red_sandstone_top, red_sandstone_top),
                existingParent(blockName(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get()), "block/base_rock","5", red_sandstone_top, red_sandstone_top)
        );

        randomYRotationBlock(
                BlockRegistration.MOSSY_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.MOSSY_ROCK_BLOCK.get()), "block/base_rock", "1", stone, mossy_rock.withSuffix("1")),
                existingParent(blockName(BlockRegistration.MOSSY_ROCK_BLOCK.get()), "block/base_rock", "2", stone, mossy_rock.withSuffix("2")),
                existingParent(blockName(BlockRegistration.MOSSY_ROCK_BLOCK.get()), "block/base_rock","3", stone, mossy_rock.withSuffix("3")),
                existingParent(blockName(BlockRegistration.MOSSY_ROCK_BLOCK.get()), "block/base_rock","4", stone, mossy_rock.withSuffix("4")),
                existingParent(blockName(BlockRegistration.MOSSY_ROCK_BLOCK.get()), "block/base_rock","5", stone, mossy_rock.withSuffix("5"))
        );
        randomYRotationBlock(
                BlockRegistration.LIGHTER_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.LIGHTER_ROCK_BLOCK.get()), "block/base_rock", "1", dirt_path_top, dirt_path_top),
                existingParent(blockName(BlockRegistration.LIGHTER_ROCK_BLOCK.get()), "block/base_rock", "2", dirt_path_top, dirt_path_top),
                existingParent(blockName(BlockRegistration.LIGHTER_ROCK_BLOCK.get()), "block/base_rock","3", dirt_path_top, dirt_path_top),
                existingParent(blockName(BlockRegistration.LIGHTER_ROCK_BLOCK.get()), "block/base_rock","4", dirt_path_top, dirt_path_top),
                existingParent(blockName(BlockRegistration.LIGHTER_ROCK_BLOCK.get()), "block/base_rock","5", dirt_path_top, dirt_path_top)
        );
        randomYRotationBlock(
                BlockRegistration.SNOWY_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock", "1", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock", "2", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock","3", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock","4", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock","5", Blocks.SNOW)
        );
        randomYRotationBlock(
                BlockRegistration.ICE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock", "1", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock", "2", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock","3", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock","4", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock","5", Blocks.PACKED_ICE)
        );

//        randomYRotationBlock(
//                BlockRegistration.LARGE_ROCK_BLOCK.get(),
//                existingModel(BlockRegistration.LARGE_ROCK_BLOCK.get(), "1") // 2 and 3
//        );
        randomYRotationBlock(
                BlockRegistration.LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.LARGE_ROCK_BLOCK.get(), "block/base_large_rock", "1", Blocks.STONE) // 2 and 3
        );
        randomYRotationBlock(
                BlockRegistration.SANDSTONE_LARGE_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.SANDSTONE_LARGE_ROCK_BLOCK.get()), "block/base_large_rock", "1", sandstone_top, sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.RED_SANDSTONE_LARGE_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.RED_SANDSTONE_LARGE_ROCK_BLOCK.get()), "block/base_large_rock", "1", red_sandstone_top, red_sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.MOSSY_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.MOSSY_LARGE_ROCK_BLOCK.get(), "block/base_large_rock", "1", Blocks.MOSS_BLOCK)
        );
        randomYRotationBlock(
                BlockRegistration.LIGHTER_LARGE_ROCK_BLOCK.get(),
                existingParent(blockName(BlockRegistration.LIGHTER_LARGE_ROCK_BLOCK.get()), "block/base_large_rock", "1", dirt_path_top, dirt_path_top)
        );
        randomYRotationBlock(
                BlockRegistration.SNOWY_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.SNOWY_LARGE_ROCK_BLOCK.get(), "block/base_large_rock", "1", Blocks.SNOW)
        );
        randomYRotationBlock(
                BlockRegistration.ICE_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.ICE_LARGE_ROCK_BLOCK.get(), "block/base_large_rock", "1", Blocks.PACKED_ICE)
        );

        randomYRotationBlock(
                BlockRegistration.LIMESTONE_ROCK_BLOCK.get(),
                flatModel(BlockRegistration.LIMESTONE_ROCK_BLOCK.get(), false),
                flatModel(BlockRegistration.LIMESTONE_ROCK_BLOCK.get(), true)
        );
        randomYRotationBlock(
                BlockRegistration.COPPER_ROCK_BLOCK.get(),
                flatModel(BlockRegistration.COPPER_ROCK_BLOCK.get(), false),
                flatModel(BlockRegistration.COPPER_ROCK_BLOCK.get(), true)
        );
        //endregion

        axisBlock(BlockRegistration.THATCH_BLOCK.get());
        crossBlock(BlockRegistration.DOGBANE_BLOCK.get());

        shortBlock(BlockRegistration.STONE_BENCH.get());
        shortBlock(BlockRegistration.CHOPPING_BLOCK.get());
        simpleBlock(BlockRegistration.BIRCH_POT.get());
    }

    private String blockName(Block block) { return BuiltInRegistries.BLOCK.getKey(block).getPath(); }

    //region Blocks
    private void randomYRotationBlock(Block block, ModelFile ... rawModels)
    {
        ConfiguredModel[] models = new ConfiguredModel[rawModels.length * 4];
        for (int i = 0; i < rawModels.length; i++)
        {
            models[i*4] = new ConfiguredModel(rawModels[i], 0, 0, false);
            models[i*4 + 1] = new ConfiguredModel(rawModels[i], 0, 90, false);
            models[i*4 + 2] = new ConfiguredModel(rawModels[i], 0, 180, false);
            models[i*4 + 3] = new ConfiguredModel(rawModels[i], 0, 270, false);
        }
        getVariantBuilder(block).partialState().setModels(models);
    }

    private void crossBlock(Block block)
    {
        ModelFile rawModel = crossModel(block);
        ConfiguredModel model = new ConfiguredModel(rawModel, 0, 0, false);
        getVariantBuilder(block).partialState().setModels(model);
    }

    private void shortBlock(Block block)
    {
        ModelFile rawModel = shortModel(block);
        ConfiguredModel model = new ConfiguredModel(rawModel, 0, 0, false);
        getVariantBuilder(block).partialState().setModels(model);
    }
    //endregion

    //region Models
    private ModelFile shortModel(Block block)
    {
        return shortModel(
                blockName(block),
                blockTexture(block).withPath(prefix -> prefix + "_top"),
                blockTexture(block).withPath(prefix -> prefix + "_bottom"),
                blockTexture(block).withPath(prefix -> prefix + "_side")
        );
    }
    private ModelFile shortModel(String name, ResourceLocation top, ResourceLocation bottom, ResourceLocation side)
    {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID,"block/short"))
                .texture("top", top)
                .texture("bottom", bottom)
                .texture("side", side);
    }

    private ModelFile existingModel(Block block, String suffix) { return existingModel(blockName(block), suffix); }
    private ModelFile existingModel(String name, String suffix)
    {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .getExistingFile(MedievalismConstants.resource(name + suffix));
    }

    @SuppressWarnings("unused")
    private ModelFile existingParent(Block block, String parent, String suffix) { return existingParent(block, parent, suffix, block); }
    private ModelFile existingParent(Block block, String parent, String suffix, Block texture) { return existingParent(block, parent, suffix, texture, texture); }
    private ModelFile existingParent(Block block, String parent, String suffix, Block texture, Block particle) { return existingParent(blockName(block), parent, suffix, blockTexture(particle), blockTexture(texture)); }
    private ModelFile existingParent(String name, String parent, String suffix, ResourceLocation particle, ResourceLocation ... textures)
    {
        BlockModelBuilder model = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name + suffix, MedievalismConstants.resource(parent + suffix))
                .texture("particle", particle);
        for (int i = 0; i < textures.length; i++) {
            model.texture(Integer.toString(i), textures[i]);
        }
        return model;
    }

    private ModelFile flatModel(Block block, boolean mirrored) { return flatModel(blockName(block), blockTexture(block), mirrored);  }
    private ModelFile flatModel(String name, ResourceLocation top, boolean mirrored)
    {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, mirrored ? "block/flat_mirrored" : "block/flat"))
                .texture("top", top);
    }

    private ModelFile crossModel(Block block) { return crossModel(blockName(block), blockTexture(block)); }
    private ModelFile crossModel(String name, ResourceLocation crossTexture)
    {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.withDefaultNamespace("block/cross"))
                .texture("cross", crossTexture)
                .renderType("cutout");
    }
    //endregion
}
