package io.github.zephyrwolf.medievalism.data.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.DryingBlock;
import io.github.zephyrwolf.medievalism.common.block.WetPackedMudBrick;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
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
    protected void registerStatesAndModels() {
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
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock1", "1", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock2", "2", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock3", "3", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock4", "4", Blocks.STONE),
                existingParent(BlockRegistration.ROCK_BLOCK.get(), "block/base_rock5", "5", Blocks.STONE)
        );
        randomYRotationBlock(
                BlockRegistration.SANDSTONE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.SANDSTONE_ROCK_BLOCK.get(), "block/base_rock1", "1", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK_BLOCK.get(), "block/base_rock2", "2", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK_BLOCK.get(), "block/base_rock3", "3", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK_BLOCK.get(), "block/base_rock4", "4", sandstone_top, sandstone_top),
                existingParent(BlockRegistration.SANDSTONE_ROCK_BLOCK.get(), "block/base_rock5", "5", sandstone_top, sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(), "block/base_rock1", "1", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(), "block/base_rock2", "2", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(), "block/base_rock3", "3", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(), "block/base_rock4", "4", red_sandstone_top, red_sandstone_top),
                existingParent(BlockRegistration.RED_SANDSTONE_ROCK_BLOCK.get(), "block/base_rock5", "5", red_sandstone_top, red_sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.MOSSY_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.MOSSY_ROCK_BLOCK.get(), "block/base_rock1", "1", stone, mossy_rock.withSuffix("1")),
                existingParent(BlockRegistration.MOSSY_ROCK_BLOCK.get(), "block/base_rock2", "2", stone, mossy_rock.withSuffix("2")),
                existingParent(BlockRegistration.MOSSY_ROCK_BLOCK.get(), "block/base_rock3", "3", stone, mossy_rock.withSuffix("3")),
                existingParent(BlockRegistration.MOSSY_ROCK_BLOCK.get(), "block/base_rock4", "4", stone, mossy_rock.withSuffix("4")),
                existingParent(BlockRegistration.MOSSY_ROCK_BLOCK.get(), "block/base_rock5", "5", stone, mossy_rock.withSuffix("5"))
        );
        randomYRotationBlock(
                BlockRegistration.LIGHTER_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.LIGHTER_ROCK_BLOCK.get(), "block/base_rock1", "1", dirt_path_top),
                existingParent(BlockRegistration.LIGHTER_ROCK_BLOCK.get(), "block/base_rock2", "2", dirt_path_top),
                existingParent(BlockRegistration.LIGHTER_ROCK_BLOCK.get(), "block/base_rock3", "3", dirt_path_top),
                existingParent(BlockRegistration.LIGHTER_ROCK_BLOCK.get(), "block/base_rock4", "4", dirt_path_top),
                existingParent(BlockRegistration.LIGHTER_ROCK_BLOCK.get(), "block/base_rock5", "5", dirt_path_top)
        );
        randomYRotationBlock(
                BlockRegistration.SNOWY_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock1", "1", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock2", "2", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock3", "3", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock4", "4", Blocks.SNOW),
                existingParent(BlockRegistration.SNOWY_ROCK_BLOCK.get(), "block/base_rock5", "5", Blocks.SNOW)
        );
        randomYRotationBlock(
                BlockRegistration.ICE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock1", "1", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock2", "2", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock3", "3", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock4", "4", Blocks.PACKED_ICE),
                existingParent(BlockRegistration.ICE_ROCK_BLOCK.get(), "block/base_rock5", "5", Blocks.PACKED_ICE)
        );


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
        dryingBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(),
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
        dryingBlock(BlockRegistration.DRYING_SETTLERS_POT.get(),
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
        dryingBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(),
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
        dryingBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(),
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


        randomYRotationBlock(
                BlockRegistration.LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", Blocks.STONE) // 2 and 3
        );
        randomYRotationBlock(
                BlockRegistration.SANDSTONE_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.SANDSTONE_LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", sandstone_top, sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.RED_SANDSTONE_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.RED_SANDSTONE_LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", red_sandstone_top, red_sandstone_top)
        );
        randomYRotationBlock(
                BlockRegistration.MOSSY_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.MOSSY_LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", Blocks.MOSS_BLOCK)
        );
        randomYRotationBlock(
                BlockRegistration.LIGHTER_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.LIGHTER_LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", dirt_path_top, dirt_path_top)
        );
        randomYRotationBlock(
                BlockRegistration.SNOWY_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.SNOWY_LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", Blocks.SNOW)
        );
        randomYRotationBlock(
                BlockRegistration.ICE_LARGE_ROCK_BLOCK.get(),
                existingParent(BlockRegistration.ICE_LARGE_ROCK_BLOCK.get(), "block/base_large_rock1", "1", Blocks.PACKED_ICE)
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

        wetPackedMudBrickBlock(BlockRegistration.WET_PACKED_MUD_BRICK.get());
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    //region Blocks
    private void dryingBlock(DryingBlock block, ModelFile wetModel, ModelFile dryModel)
    {
        var builder = getVariantBuilder(block);
        for (int i = DryingBlock.MIN_DRYNESS; i < DryingBlock.MAX_DRYNESS; i++)
        {
            builder.partialState()
                    .with(DryingBlock.DRYNESS, i)
                    .modelForState().modelFile(wetModel).addModel();
        }
        builder.partialState()
                .with(DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS)
                .modelForState().modelFile(dryModel).addModel();
    }

    private void dryingBlock(DryingBlock block, ModelFile wetZModel, ModelFile wetXModel, ModelFile dryZModel, ModelFile dryXModel) {
        var builder = getVariantBuilder(block);
        for (int i = DryingBlock.MIN_DRYNESS; i < DryingBlock.MAX_DRYNESS; i++) {
            builder.partialState()
                    .with(DryingBlock.DRYNESS, i)
                    .with(DryingBlock.AXIS, Direction.Axis.Z)
                    .modelForState().modelFile(wetZModel).addModel();
        }
        builder.partialState()
                .with(DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS)
                .with(DryingBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(dryZModel).addModel();
        for (int i = DryingBlock.MIN_DRYNESS; i < DryingBlock.MAX_DRYNESS; i++) {
            builder.partialState()
                    .with(DryingBlock.DRYNESS, i)
                    .with(DryingBlock.AXIS, Direction.Axis.X)
                    .modelForState().modelFile(wetXModel).addModel();
        }
        builder.partialState()
                .with(DryingBlock.DRYNESS, DryingBlock.MAX_DRYNESS)
                .with(DryingBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(dryXModel).addModel();
    }

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

    private void wetPackedMudBrickBlock(Block block) {
        var builder = getMultipartBuilder(block);
        for (EnumProperty<?> aProp : WetPackedMudBrick.BRICK_PROPERTIES) {
            @SuppressWarnings("unchecked")
            EnumProperty<WetPackedMudBrick.PackedMudBrickState> prop = (EnumProperty<WetPackedMudBrick.PackedMudBrickState>) aProp;
            for (WetPackedMudBrick.PackedMudBrickState brick : WetPackedMudBrick.PackedMudBrickState.values()) {
                if (brick.isEmpty()) continue;
                ModelFile model = wetPackedMudBrickModel(brick == WetPackedMudBrick.PackedMudBrickState.WET ? "wet_packed_mud_brick" : "packed_mud_brick", prop, brick, brick == WetPackedMudBrick.PackedMudBrickState.WET ? "minecraft:block/mud" : "minecraft:block/packed_mud");
                builder.part().modelFile(model).addModel()
                        .condition(prop, brick)
                        .end();
            }
        }
    }
    //endregion

    //region Models
    private ModelFile wetPackedMudBrickModel(String name, EnumProperty<WetPackedMudBrick.PackedMudBrickState> property, WetPackedMudBrick.PackedMudBrickState brick, String texture) {
        if (brick.isEmpty()) throw new IllegalStateException("Cannot obtain model for an empty PackedMudBrickState.");
        String suffix = "";
        if (property.equals(WetPackedMudBrick.BACK_LEFT)) suffix = "_back_left";
        if (property.equals(WetPackedMudBrick.BACK_RIGHT)) suffix = "_back_right";
        if (property.equals(WetPackedMudBrick.FRONT_LEFT)) suffix = "_front_left";
        if (property.equals(WetPackedMudBrick.FRONT_RIGHT)) suffix = "_front_right";
        if (suffix.isEmpty()) throw new IllegalStateException("Unrecognised BlockState Property.");
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name + suffix, MedievalismConstants.resource("block/base_inworld_brick" + suffix))
                .texture("0", texture) // block/...
                .texture("particle", texture);
    }

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

    @SuppressWarnings("SameParameterValue")
    private ModelFile existingModel(Block block, String suffix) {
        return existingModel(blockName(block), suffix);
    }

    private ModelFile existingModel(String name, String suffix) {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .getExistingFile(MedievalismConstants.resource(name + suffix));
    }

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

    private ModelFile existingParent(String name, String parent, ResourceLocation... textures) {
        BlockModelBuilder model = models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, MedievalismConstants.resource(parent))
                .texture("particle", textures[0]);
        for (int i = 0; i < textures.length; i++) {
            model.texture(Integer.toString(i), textures[i]);
        }
        return model;
    }

    private ModelFile flatModel(Block block, boolean mirrored) {
        return flatModel(blockName(block), blockTexture(block), mirrored);
    }

    private ModelFile flatModel(String name, ResourceLocation top, boolean mirrored) {
        return models() // BlockModelProvider extends ModelProvider<BlockModelBuilder>
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, mirrored ? "block/flat_mirrored" : "block/flat"))
                .texture("top", top);
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
}
