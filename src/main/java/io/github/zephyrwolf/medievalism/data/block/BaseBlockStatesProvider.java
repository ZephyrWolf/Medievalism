package io.github.zephyrwolf.medievalism.data.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.BlockRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        randomYRotationBlock(BlockRegistration.OAK_BRANCH_BLOCK.get(), branchModel(BlockRegistration.OAK_BRANCH_BLOCK.get(), Blocks.OAK_LOG));
        randomYRotationBlock(BlockRegistration.BIRCH_BRANCH_BLOCK.get(), branchModel(BlockRegistration.BIRCH_BRANCH_BLOCK.get(), Blocks.BIRCH_LOG));
        randomYRotationBlock(BlockRegistration.SPRUCE_BRANCH_BLOCK.get(), branchModel(BlockRegistration.SPRUCE_BRANCH_BLOCK.get(), Blocks.SPRUCE_LOG));
        randomYRotationBlock(BlockRegistration.JUNGLE_BRANCH_BLOCK.get(), branchModel(BlockRegistration.JUNGLE_BRANCH_BLOCK.get(), Blocks.JUNGLE_LOG));
        randomYRotationBlock(BlockRegistration.DARK_OAK_BRANCH_BLOCK.get(), branchModel(BlockRegistration.DARK_OAK_BRANCH_BLOCK.get(), Blocks.DARK_OAK_LOG));
        randomYRotationBlock(BlockRegistration.ACACIA_BRANCH_BLOCK.get(), branchModel(BlockRegistration.ACACIA_BRANCH_BLOCK.get(), Blocks.ACACIA_LOG));
        randomYRotationBlock(BlockRegistration.CHERRY_BRANCH_BLOCK.get(), branchModel(BlockRegistration.CHERRY_BRANCH_BLOCK.get(), Blocks.CHERRY_LOG));
        randomYRotationBlock(BlockRegistration.MANGROVE_BRANCH_BLOCK.get(), branchModel(BlockRegistration.MANGROVE_BRANCH_BLOCK.get(), Blocks.MANGROVE_LOG));

        randomYRotationBlock(
                BlockRegistration.LARGE_ROCK_BLOCK.get(),
                flatModel(BlockRegistration.LARGE_ROCK_BLOCK.get(), false),
                flatModel(BlockRegistration.LARGE_ROCK_BLOCK.get(), true)
        );
        randomYRotationBlock(
                BlockRegistration.ROCK_BLOCK.get(),
                flatModel(BlockRegistration.ROCK_BLOCK.get(), false),
                flatModel(BlockRegistration.ROCK_BLOCK.get(), true)
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

    private ModelFile branchModel(Block block, Block particle) { return branchModel(blockName(block), blockTexture(block), blockTexture(particle)); }
    private ModelFile branchModel(String name, ResourceLocation top, ResourceLocation particle)
    {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, MedievalismConstants.resource("block/branch"))
                .texture("0", top)
                .texture("particle", particle);
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
