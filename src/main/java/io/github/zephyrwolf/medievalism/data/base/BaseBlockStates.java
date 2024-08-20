package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class BaseBlockStates extends BlockStateProvider
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    public BaseBlockStates(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        //this.simpleBlock(ModBlocks.RICH_SOIL.get(), cubeRandomRotation(ModBlocks.RICH_SOIL.get(), ""));
        //this.simpleBlock(ModBlocks.SAFETY_NET.get(), existingModel(ModBlocks.SAFETY_NET.get()));
        //this.axisBlock((RotatedPillarBlock) ModBlocks.STRAW_BALE.get());
        //simpleBlock(Registration.RED_CLAY_BLOCK.get(), existingModel(Registration.RED_CLAY_BLOCK.get()));
        simpleBlock(Registration.RED_CLAY_BLOCK.get());
        simpleBlock(Registration.LIMESTONE_BLOCK.get());
        flatBlock(Registration.BRANCH_BLOCK.get());
        flatBlock(Registration.LARGE_ROCK_BLOCK.get());
        flatBlock(Registration.ROCK_BLOCK.get());
        flatBlock(Registration.LIMESTONE_ROCK_BLOCK.get());
        flatBlock(Registration.COPPER_ROCK_BLOCK.get());
        axisBlock(Registration.THATCH_BLOCK.get());
    }

    private String blockName(Block block) { return BuiltInRegistries.BLOCK.getKey(block).getPath(); }

    private void flatBlock(Block block)
    {
        ModelFile rawModel = flatModel(block, false);
        ModelFile rawModelMirrored = flatModel(block, true);
        ConfiguredModel model0 = new ConfiguredModel(rawModel, 0, 0, false);
        ConfiguredModel model1 = new ConfiguredModel(rawModel, 0, 90, false);
        ConfiguredModel model2 = new ConfiguredModel(rawModel, 0, 180, false);
        ConfiguredModel model3 = new ConfiguredModel(rawModel, 0, 270, false);
        ConfiguredModel model4 = new ConfiguredModel(rawModelMirrored, 0, 0, false);
        ConfiguredModel model5 = new ConfiguredModel(rawModelMirrored, 0, 90, false);
        ConfiguredModel model6 = new ConfiguredModel(rawModelMirrored, 0, 180, false);
        ConfiguredModel model7 = new ConfiguredModel(rawModelMirrored, 0, 270, false);
        getVariantBuilder(block)
                .partialState().setModels(model0, model1, model2, model3, model4, model5, model6, model7);
    }

    private ModelFile flatModel(Block block, boolean mirrored)
    {
        return flatModel(blockName(block), blockTexture(block), mirrored);
    }

    private ModelFile flatModel(String name, ResourceLocation top, boolean mirrored)
    {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, mirrored ? "block/flat_mirrored" : "block/flat"))
                .texture("top", top);
    }

}
