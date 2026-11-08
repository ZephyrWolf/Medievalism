package io.github.zephyrwolf.medievalism.common.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.*;

import java.util.ArrayList;
import java.util.Arrays;

public class BlockStateEntryProviderHandle
{
    private final BlockStateEntryProvider provider;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<String> modIds;
    private final String defaultModId;
    private String folder;

    public BlockStateEntryProviderHandle(BlockStateEntryProvider provider, String modId)
    {
        this.provider = provider;
        modIds = new ArrayList<>();
        this.defaultModId = modId;
        this.folder = "";
    }

    private String getModId() { return modIds.isEmpty() ? defaultModId :  modIds.getLast(); }
    public void pushModId(String modId) { modIds.add(modId); }
    public void pushVanillaModId() { modIds.add("minecraft"); }
    public void popModId() { if (!modIds.isEmpty()) { modIds.removeLast(); }}
    public void setFolder(String folder) { this.folder = folder; }

    // --

    public VariantBlockStateBuilder getVariantBuilder(Block block) { return provider.getVariantBuilder(block); }
    public MultiPartBlockStateBuilder getMultipartBuilder(Block block) { return provider.getMultipartBuilder(block); }

    public String blockModelName(Block block) { return BuiltInRegistries.BLOCK.getKey(block).getPath(); }
    public String blockModelName(Block block, String suffix) { return BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix; }
    public String blockModelName(String prefix, Block block) { return prefix + BuiltInRegistries.BLOCK.getKey(block).getPath(); }
    public String blockModelName(String prefix, Block block, String suffix) { return prefix + BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix; }

    public ResourceLocation blockModelResource(Block block) { return ResourceLocation.fromNamespaceAndPath(getModId(), "block/" + blockModelName(block)); }
    public ResourceLocation blockModelResource(String prefix, Block block) { return ResourceLocation.fromNamespaceAndPath(getModId(), "block/" + prefix + blockModelName(block)); }
    public ResourceLocation blockModelResource(Block block, String suffix) { return ResourceLocation.fromNamespaceAndPath(getModId(), "block/" + blockModelName(block) + suffix); }

    /*
    public ResourceLocation resourceBlock(String path)
    {
        return resourceBlock(modId, path);
    }

    public ResourceLocation resourceBlock(String modId, String path)
    {
        String fullPath = folder.isEmpty() ?
                String.join("/", "block", path) :
                String.join("/", "block", folder, path);
        return ResourceLocation.fromNamespaceAndPath(modId, fullPath);
    }
     */
    private ResourceLocation key(Block block) { return BuiltInRegistries.BLOCK.getKey(block); }

    public ResourceLocation blockTexture(Block block) { return provider.blockTexture(block); }
    public ResourceLocation blockTexture(Block block, String suffix)
    {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + suffix);
    }
    public ResourceLocation blockTexture(String prefix, Block block)
    {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + prefix + name.getPath());
    }
    public ResourceLocation blockTexture(String name)
    {
        int i = name.indexOf(':');
        if (i > 0) throw new IllegalArgumentException("name cannot be namespaced, used setModid function");
        return ResourceLocation.fromNamespaceAndPath(getModId(), ModelProvider.BLOCK_FOLDER + "/" + name);
    }

    public void simpleBlock(Block block) { provider.simpleBlock(block); }
    public void simpleBlock(Block block, ModelFile rawModel) { provider.simpleBlock(block, rawModel); }
    public void simpleBlock(Block block, ResourceLocation texture) { provider.simpleBlock(block, cubeModel(blockModelName(block), texture)); }
    public void simpleBlock(Block block, ConfiguredModel... models) { provider.simpleBlock(block, models); }

    public void simpleTintedCrossBlock(Block block) { simpleBlock(block, simpleTintedCrossModel(block)); }
    public void simpleCrossBlock(Block block)  { simpleBlock(block, simpleCrossModel(block)); }
    public void simpleShortBlock(Block block) { simpleBlock(block, simpleShortModel(block)); }

    public void cropBlock_4_8(CropBlock block)
    {
        ResourceLocation textureCropStage0 = provider.blockTexture(block).withSuffix("_stage0");
        ResourceLocation textureCropStage1 = provider.blockTexture(block).withSuffix("_stage1");
        ResourceLocation textureCropStage2 = provider.blockTexture(block).withSuffix("_stage2");
        ResourceLocation textureCropStage3 = provider.blockTexture(block).withSuffix("_stage3");

        ModelFile model0 = cropModel(blockModelName(block, "_stage0"), textureCropStage0);
        ModelFile model1 = cropModel(blockModelName(block, "_stage1"), textureCropStage1);
        ModelFile model2 = cropModel(blockModelName(block, "_stage2"), textureCropStage2);
        ModelFile model3 = cropModel(blockModelName(block, "_stage3"), textureCropStage3);

        provider.getVariantBuilder(block)
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

    public void integerPropertyBlock(Block block, IntegerProperty prop, ModelFile... rawModels)
    {
        int numVariants = prop.getPossibleValues().size();
        if (numVariants != rawModels.length)
        {
            throw new RuntimeException("Number of models needs to equal the number of values within prop.");
        }
        ConfiguredModel[] models = new ConfiguredModel[numVariants];
        for (int i = 0; i < numVariants; i++) {
            models[i] = new ConfiguredModel(rawModels[i], 0, 0, false);
        }
        VariantBlockStateBuilder builder = provider.getVariantBuilder(block);
        int i = 0;
        for (int value : prop.getPossibleValues())
        {
            builder.partialState().with(prop, value).setModels(models[i++]);
        }
    }

    public void booleanPropertyBlock(Block block, BooleanProperty prop, ModelFile... rawModels)
    {
        int numVariants = prop.getPossibleValues().size();
        if (numVariants != rawModels.length)
        {
            throw new RuntimeException("Number of models needs to equal the number of values within prop.");
        }
        ConfiguredModel[] models = new ConfiguredModel[numVariants];
        for (int i = 0; i < numVariants; i++) {
            models[i] = new ConfiguredModel(rawModels[i], 0, 0, false);
        }
        VariantBlockStateBuilder builder = provider.getVariantBuilder(block);
        int i = 0;
        for (boolean value : prop.getPossibleValues())
        {
            builder.partialState().with(prop, value).setModels(models[i++]);
        }
    }

    public void randomModelBlock(Block block, ModelFile... rawModels)
    {
        ConfiguredModel[] models = new ConfiguredModel[rawModels.length];
        for (int i = 0; i < rawModels.length; i++)
        {
            models[i] = new ConfiguredModel(rawModels[i], 0, 0, false);
        }
        provider.getVariantBuilder(block).partialState().setModels(models);
    }

    public void randomModelAndRotationBlock(Block block, ModelFile... rawModels)
    {
        ConfiguredModel[] models = new ConfiguredModel[rawModels.length * 4];
        for (int i = 0; i < rawModels.length; i++) {
            models[i * 4] = new ConfiguredModel(rawModels[i], 0, 0, false);
            models[i * 4 + 1] = new ConfiguredModel(rawModels[i], 0, 90, false);
            models[i * 4 + 2] = new ConfiguredModel(rawModels[i], 0, 180, false);
            models[i * 4 + 3] = new ConfiguredModel(rawModels[i], 0, 270, false);
        }
        provider.getVariantBuilder(block).partialState().setModels(models);
    }

    public void randomRotationAndIntegerPropertyBlock(Block block, IntegerProperty prop, ModelFile... rawModels)
    {
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
        VariantBlockStateBuilder builder = provider.getVariantBuilder(block);
        int i = 0;
        for (int value : prop.getPossibleValues())
        {
            builder.partialState().with(prop, value).setModels(models[i++]);
        }
    }

    public void horizontalAxisBlock(Block block, ModelFile zAxisModel, ModelFile xAxisModel)
    {
        provider.getVariantBuilder(block)
                .partialState().with(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.Z)
                .modelForState().modelFile(zAxisModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X)
                .modelForState().modelFile(xAxisModel).rotationY(0).addModel();
    }

    public void horizontalFacingBlock(Block block, ModelFile northModel, ModelFile eastModel, ModelFile southModel, ModelFile westModel)
    {
        provider.getVariantBuilder(block)
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .modelForState().modelFile(northModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .modelForState().modelFile(eastModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .modelForState().modelFile(southModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .modelForState().modelFile(westModel).rotationY(0).addModel();
    }

    public void axisBlock(Block block, ModelFile xAxisModel, ModelFile yAxisModel, ModelFile zAxisModel)
    {
        provider.getVariantBuilder(block)
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.X)
                .modelForState().modelFile(xAxisModel).rotationY(0).addModel()
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(yAxisModel).rotationX(0).addModel()
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(zAxisModel).rotationY(0).addModel();
    }

    public void simpleAxisBlock(RotatedPillarBlock block)
    {
        provider.axisBlock(block);
    }

    //region Raw Model

    @SuppressWarnings("SameParameterValue")
    public ModelFile existingModel(Block block) { return existingModel(blockModelName(block)); }
    public ModelFile existingModel(String name)
    {
        return provider.models().getExistingFile(ResourceLocation.fromNamespaceAndPath(getModId(), name));
    }

    // --

    public ModelFile existingParent(Block block, ResourceLocation parentModel, Block... blockTextures)
    {
        return existingParent(blockModelName(block), parentModel, Arrays.stream(blockTextures).map(provider::blockTexture).toArray(ResourceLocation[]::new));
    }

    public ModelFile existingParent(Block block, String suffix, ResourceLocation parentModel, Block... blockTextures)
    {
        return existingParent(blockModelName(block, suffix), parentModel, Arrays.stream(blockTextures).map(provider::blockTexture).toArray(ResourceLocation[]::new));
    }

    public ModelFile existingParent(String prefix, Block block, ResourceLocation parentModel, Block... blockTextures)
    {
        return existingParent(blockModelName(prefix, block), parentModel, Arrays.stream(blockTextures).map(provider::blockTexture).toArray(ResourceLocation[]::new));
    }

    public ModelFile existingParent(String name, ResourceLocation parentModel, ResourceLocation... textures)
    {
        if (textures.length == 0) throw new IllegalStateException("Must provide at least 1 texture.");
        BlockModelBuilder model = provider.models()
                .withExistingParent(name, parentModel)
                .texture("particle", textures[0]);
        for (int i = 0; i < textures.length; i++) {
            model.texture(Integer.toString(i), textures[i]);
        }
        return model;
    }

    // --

    public ModelFile simpleShortModel(Block block)
    {
        return shortModel(
                blockModelName(block),
                provider.blockTexture(block).withPath(prefix -> prefix + "_top"),
                provider.blockTexture(block).withPath(prefix -> prefix + "_bottom"),
                provider.blockTexture(block).withPath(prefix -> prefix + "_side")
        );
    }
    public ModelFile shortModel(String name, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {
        return provider.models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "block/short"))
                .texture("top", top)
                .texture("bottom", bottom)
                .texture("side", side);
    }

    /*
    private ModelFile flatModel(Block block, boolean mirrored)
    {
        return flatModel(blockName(block), provider.blockTexture(block), mirrored);
    }

    private ModelFile flatModel(String name, ResourceLocation top, boolean mirrored)
    {
        return provider.models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, mirrored ? "block/flat_mirrored" : "block/flat"))
                .texture("top", top);
    }
     */

    public ModelFile simpleCrossModel(Block block)
    { return simpleCrossModel(blockModelName(block), provider.blockTexture(block)); }
    public ModelFile simpleCrossModel(String name, ResourceLocation texture)
    {
        return provider.models()
                .withExistingParent(name, "minecraft:block/cross")
                .texture("cross", texture)
                .renderType("cutout");
    }

    public ModelFile simpleTintedCrossModel(Block block)
    { return tintedCrossModel(blockModelName(block), provider.blockTexture(block)); }
    public ModelFile tintedCrossModel(String name, ResourceLocation texture)
    {
        return provider.models()
                .withExistingParent(name, "minecraft:block/tinted_cross")
                .texture("cross", texture)
                .renderType("cutout");
    }

    public ModelFile simpleCubeModel(Block block)
    { return cubeModel(blockModelName(block), provider.blockTexture(block)); }
    public ModelFile cubeModel(String name, ResourceLocation texture)
    {
        return provider.models()
                .withExistingParent(name, "minecraft:block/cube_all")
                .texture("all", texture);
    }

    public ModelFile simpleCropModel(Block block)
    { return cropModel(blockModelName(block), provider.blockTexture(block)); }
    public ModelFile cropModel(String name, ResourceLocation texture)
    {
        return provider.models()
                .withExistingParent(name, ResourceLocation.withDefaultNamespace("block/crop"))
                .texture("particle", texture)
                .texture("crop", texture)
                .renderType("cutout");
    }

    public ModelFile simpleGrassModel(Block block)
    {
        return grassModel(blockModelName(block),
                provider.blockTexture(Blocks.DIRT),
                provider.blockTexture(block),
                provider.blockTexture(Blocks.GRASS_BLOCK).withSuffix("_side_overlay"),
                provider.blockTexture(Blocks.GRASS_BLOCK).withSuffix("_top"));
    }
    public ModelFile simpleGrassModel(String name, ResourceLocation sideTexture)
    {
        return grassModel(name,
                provider.blockTexture(Blocks.DIRT),
                sideTexture,
                provider.blockTexture(Blocks.GRASS_BLOCK).withSuffix("_side_overlay"),
                provider.blockTexture(Blocks.GRASS_BLOCK).withSuffix("_top")
        );
    }
    public ModelFile grassModel(String modelName, ResourceLocation bottomTexture, ResourceLocation sideTexture, ResourceLocation sideOverlayTexture, ResourceLocation topTexture)
    {
        return provider.models()
                .withExistingParent(modelName, ResourceLocation.withDefaultNamespace("block/grass_block"))
                .texture("particle", bottomTexture)
                .texture("bottom", bottomTexture)
                .texture("top", topTexture)
                .texture("side", sideTexture)
                .texture("overlay", sideOverlayTexture)
                .renderType("cutout");
    }

    public ModelFile cubeColumnModel(Block block, Block end, Block side)
    { return cubeColumnModel(blockModelName(block), provider.blockTexture(end), provider.blockTexture(side)); }
    public ModelFile cubeColumnModel(String modelName, ResourceLocation endTexture, ResourceLocation sideTexture)
    {
        return provider.models()
                .withExistingParent(modelName, ResourceLocation.withDefaultNamespace("block/cube_column"))
                .texture("end", endTexture)
                .texture("side", sideTexture);
    }
    //endregion
}
