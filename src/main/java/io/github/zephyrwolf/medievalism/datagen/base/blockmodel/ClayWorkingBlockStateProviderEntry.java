package io.github.zephyrwolf.medievalism.datagen.base.blockmodel;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import io.github.zephyrwolf.medievalism.common.data.BlockStateEntryProviderHandle;
import io.github.zephyrwolf.medievalism.common.data.IBlockStateProviderEntry;
import io.github.zephyrwolf.medievalism.common.warmth.WarmthTools;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.neoforged.neoforge.client.model.generators.ModelFile;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class ClayWorkingBlockStateProviderEntry implements IBlockStateProviderEntry
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    public ClayWorkingBlockStateProviderEntry()
    {
        super();
    }

    @Override
    public void registerModels(BlockStateEntryProviderHandle handle)
    {
        //region Pottery
        // Gatherer's Jar
        ResourceLocation modelGatherersJar = handle.blockModelResource(BlockRegistration.GATHERERS_JAR.get());
        ResourceLocation textureWetGatherersJar = handle.blockTexture("wet_", BlockRegistration.GATHERERS_JAR.get());
        ResourceLocation textureDryGatherersJar = handle.blockTexture("dry_", BlockRegistration.GATHERERS_JAR.get());
        handle.booleanPropertyBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), WarmthTools.IS_DRY,
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.GATHERERS_JAR.get()), modelGatherersJar, textureWetGatherersJar),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.GATHERERS_JAR.get()), modelGatherersJar, textureDryGatherersJar)
        );
        handle.simpleBlock(BlockRegistration.GATHERERS_JAR.get(),
                handle.existingModel(BlockRegistration.GATHERERS_JAR.get())
        );

        // Keeper's Crock
        ResourceLocation modelKeepersCrock = handle.blockModelResource(BlockRegistration.KEEPERS_CROCK.get());
        ResourceLocation textureWetKeepersCrook = handle.blockTexture("wet_", BlockRegistration.KEEPERS_CROCK.get());
        ResourceLocation textureDryKeepersCrook = handle.blockTexture("dry_", BlockRegistration.KEEPERS_CROCK.get());
        dryingBlockHorizontalAxis(handle, BlockRegistration.DRYING_KEEPERS_CROCK.get(),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.KEEPERS_CROCK.get()),  modelKeepersCrock, textureWetKeepersCrook),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.KEEPERS_CROCK.get(), "_rotated"), modelKeepersCrock, textureWetKeepersCrook),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.KEEPERS_CROCK.get()), modelKeepersCrock, textureDryKeepersCrook),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.KEEPERS_CROCK.get(), "_rotated"), modelKeepersCrock, textureDryKeepersCrook)
        );
        handle.horizontalAxisBlock(
                BlockRegistration.KEEPERS_CROCK.get(),
                handle.existingModel(BlockRegistration.KEEPERS_CROCK.get(), ""),
                handle.existingModel(BlockRegistration.KEEPERS_CROCK.get(), "_rotated")
        );

        // Settler's Pot
        ResourceLocation modelSettlersPot = handle.blockModelResource(BlockRegistration.SETTLERS_POT.get());
        ResourceLocation modelSettlersPotRotated = handle.blockModelResource(BlockRegistration.SETTLERS_POT.get(), "_rotated");
        ResourceLocation textureWetSettlersPot = handle.blockTexture("wet_", BlockRegistration.SETTLERS_POT.get());
        ResourceLocation textureDrySettlersPot = handle.blockTexture("dry_", BlockRegistration.SETTLERS_POT.get());
        dryingBlockHorizontalAxis(handle, BlockRegistration.DRYING_SETTLERS_POT.get(),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.SETTLERS_POT.get()), modelSettlersPot, textureWetSettlersPot),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.SETTLERS_POT.get(), "_rotated"), modelSettlersPotRotated, textureWetSettlersPot),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.SETTLERS_POT.get()), modelSettlersPot, textureDrySettlersPot),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.SETTLERS_POT.get(), "_rotated"), modelSettlersPotRotated, textureDrySettlersPot)
        );
        handle.horizontalAxisBlock(
                BlockRegistration.SETTLERS_POT.get(),
                handle.existingModel(BlockRegistration.SETTLERS_POT.get(), ""),
                handle.existingModel(BlockRegistration.SETTLERS_POT.get(), "_rotated")
        );

        // Clay Cooking Pot
        ResourceLocation modelClayCookingPot = handle.blockModelResource(BlockRegistration.CLAY_COOKING_POT.get());
        ResourceLocation modelClayCookingPotRotated = handle.blockModelResource(BlockRegistration.CLAY_COOKING_POT.get(), "_rotated");
        ResourceLocation textureWetClayCookingPot = handle.blockTexture("wet_", BlockRegistration.CLAY_COOKING_POT.get());
        ResourceLocation textureDryClayCookingPot = handle.blockTexture("dry_", BlockRegistration.CLAY_COOKING_POT.get());
        dryingBlockHorizontalAxis(handle, BlockRegistration.DRYING_CLAY_COOKING_POT.get(),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.CLAY_COOKING_POT.get()), modelClayCookingPot, textureWetClayCookingPot),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.CLAY_COOKING_POT.get(), "_rotated"), modelClayCookingPotRotated, textureWetClayCookingPot),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.CLAY_COOKING_POT.get()), modelClayCookingPot, textureDryClayCookingPot),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.CLAY_COOKING_POT.get(), "_rotated"), modelClayCookingPotRotated, textureDryClayCookingPot)
        );
        handle.horizontalAxisBlock(
                BlockRegistration.CLAY_COOKING_POT.get(),
                handle.existingModel(BlockRegistration.CLAY_COOKING_POT.get(), ""),
                handle.existingModel(BlockRegistration.CLAY_COOKING_POT.get(), "_rotated")
        );

        // Clay Cauldron
        ResourceLocation modeClayCauldron = handle.blockModelResource(BlockRegistration.CLAY_CAULDRON.get());
        ResourceLocation modeClayCauldronRotated = handle.blockModelResource(BlockRegistration.CLAY_CAULDRON.get(), "_rotated");
        ResourceLocation textureWetClayCauldron = handle.blockTexture("wet_", BlockRegistration.CLAY_CAULDRON.get());
        ResourceLocation textureDryClayCauldron = handle.blockTexture("dry_", BlockRegistration.CLAY_CAULDRON.get());
        dryingBlockHorizontalAxis(handle, BlockRegistration.DRYING_CLAY_CAULDRON.get(),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.CLAY_CAULDRON.get()), modeClayCauldron, textureWetClayCauldron),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.CLAY_CAULDRON.get(), "_rotated"), modeClayCauldronRotated, textureWetClayCauldron),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.CLAY_CAULDRON.get()), modeClayCauldron, textureDryClayCauldron),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.CLAY_CAULDRON.get(), "_rotated"), modeClayCauldronRotated, textureDryClayCauldron)
        );
        handle.horizontalAxisBlock(
                BlockRegistration.CLAY_CAULDRON.get(),
                handle.existingModel(BlockRegistration.CLAY_CAULDRON.get(), ""),
                handle.existingModel(BlockRegistration.CLAY_CAULDRON.get(), "_rotated")
        );

        // Jug
        /*
        ResourceLocation modelJugNorth = handle.blockModelResource(BlockRegistration.JUG.get());
        ResourceLocation modelJugEast = handle.blockModelResource(BlockRegistration.JUG.get(), "_east");
        ResourceLocation modelJugSouth = handle.blockModelResource(BlockRegistration.JUG.get(), "_south");
        ResourceLocation modelJugWest = handle.blockModelResource(BlockRegistration.JUG.get(), "_west");
        ResourceLocation textureWetJug = handle.blockTexture("wet_", BlockRegistration.JUG.get());
        ResourceLocation textureDryJug = handle.blockTexture("dry_", BlockRegistration.JUG.get());
        dryingBlockHorizontalFacing(handle, BlockRegistration.DRYING_JUG.get(),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.JUG.get()), modelJugNorth, textureWetJug),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.JUG.get(), "_east"), modelJugEast, textureWetJug),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.JUG.get(), "_south"), modelJugSouth, textureWetJug),
                handle.existingParent(handle.blockModelName("wet_", BlockRegistration.JUG.get(), "_west"), modelJugWest, textureWetJug),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.JUG.get()), modelJugNorth, textureDryJug),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.JUG.get(), "_east"), modelJugEast, textureDryJug),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.JUG.get(), "_south"), modelJugSouth, textureDryJug),
                handle.existingParent(handle.blockModelName("dry_", BlockRegistration.JUG.get(), "_west"), modelJugWest, textureDryJug)
        );
        handle.horizontalFacingBlock(
                BlockRegistration.JUG.get(),
                handle.existingModel(BlockRegistration.JUG.get(), ""),
                handle.existingModel(BlockRegistration.JUG.get(), "_east"),
                handle.existingModel(BlockRegistration.JUG.get(), "_south"),
                handle.existingModel(BlockRegistration.JUG.get(), "_west"));
         */

        handle.simpleBlock(BlockRegistration.POTTERS_CLAY.get());
        handle.simpleBlock(BlockRegistration.KAOLIN_CLAY.get());
        handle.simpleBlock(BlockRegistration.CHINA_CLAY.get());
        handle.simpleBlock(BlockRegistration.REFRACTORY_CLAY.get());

        // Flower Pot
        handle.pushVanillaModId();
        ResourceLocation modelFlowerPot = handle.blockModelResource(BlockRegistration.FLOWER_POT.get());
        handle.popModId();
        ResourceLocation textureWetFlowerPot = MedievalismConstants.resource(handle.blockTexture("wet_", BlockRegistration.FLOWER_POT.get()).getPath());
        ResourceLocation textureDryFlowerPot = MedievalismConstants.resource(handle.blockTexture("dry_", BlockRegistration.FLOWER_POT.get()).getPath());
        handle.booleanPropertyBlock(BlockRegistration.DRYING_FLOWER_POT.get(), WarmthTools.IS_DRY,
                handle.existingParent(handle.blockModelName("wet_", Blocks.FLOWER_POT), modelFlowerPot, textureWetFlowerPot),
                handle.existingParent(handle.blockModelName("dry_", Blocks.FLOWER_POT), modelFlowerPot, textureDryFlowerPot)
        );

        // Decorated Pot
        handle.pushVanillaModId();
        ResourceLocation modelDecoratedPot = handle.blockModelResource(BlockRegistration.DECORATED_POT.get());
        handle.popModId();
        ResourceLocation textureWetDecoratedPot = MedievalismConstants.resource(handle.blockTexture("wet_", BlockRegistration.DECORATED_POT.get()).getPath());
        ResourceLocation textureDryDecoratedPot = MedievalismConstants.resource(handle.blockTexture("dry_", BlockRegistration.DECORATED_POT.get()).getPath());
        handle.booleanPropertyBlock(BlockRegistration.DRYING_DECORATED_POT.get(), WarmthTools.IS_DRY,
                handle.existingParent(handle.blockModelName("wet_", Blocks.DECORATED_POT), modelDecoratedPot, textureWetDecoratedPot),
                handle.existingParent(handle.blockModelName("dry_", Blocks.DECORATED_POT), modelDecoratedPot, textureDryDecoratedPot)
        );

        dryingBrickBlock(handle, BlockRegistration.DRYING_CLAY_BRICK.get(), ResourceLocation.withDefaultNamespace("block/clay"), MedievalismConstants.resource("block/unfired_clay"));
        dryingBrickBlock(handle, BlockRegistration.DRYING_CHINA_CLAY_BRICK.get(), MedievalismConstants.resource("block/wet_china_clay"), MedievalismConstants.resource("block/unfired_china_clay"));
        dryingBrickBlock(handle, BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), MedievalismConstants.resource("block/wet_potters_clay"), MedievalismConstants.resource("block/unfired_potters_clay"));
        dryingBrickBlock(handle, BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), MedievalismConstants.resource("block/wet_kaolin_clay"), MedievalismConstants.resource("block/unfired_kaolin_clay"));
        dryingBrickBlock(handle, BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), MedievalismConstants.resource("block/wet_refractory_clay"), MedievalismConstants.resource("block/unfired_refractory_clay"));
        dryingDoubleBrickBlock(handle, BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), ResourceLocation.withDefaultNamespace("block/clay"), MedievalismConstants.resource("block/unfired_clay"));
        dryingDoubleBrickBlock(handle, BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(), MedievalismConstants.resource("block/wet_china_clay"), MedievalismConstants.resource("block/unfired_china_clay"));
        dryingDoubleBrickBlock(handle, BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), MedievalismConstants.resource("block/wet_potters_clay"), MedievalismConstants.resource("block/unfired_potters_clay"));
        dryingDoubleBrickBlock(handle, BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), MedievalismConstants.resource("block/wet_kaolin_clay"), MedievalismConstants.resource("block/unfired_refractory_clay"));
        dryingDoubleBrickBlock(handle, BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), MedievalismConstants.resource("block/wet_refractory_clay"), MedievalismConstants.resource("block/unfired_refractory_clay"));

        //handle.flatItemBlock(BlockRegistration.)
    }

    private void dryingBlockHorizontalAxis(BlockStateEntryProviderHandle handle, DryingBlockRuinableHorizontalAxis block, ModelFile wetZModel, ModelFile wetXModel, ModelFile dryZModel, ModelFile dryXModel)
    {
        handle.getVariantBuilder(block)
                // Z
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockRuinableHorizontalAxis.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(wetZModel).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockRuinableHorizontalAxis.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(dryZModel).addModel()
                // X
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockRuinableHorizontalAxis.AXIS, Direction.Axis.X)
                .modelForState().modelFile(wetXModel).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockRuinableHorizontalAxis.AXIS, Direction.Axis.X)
                .modelForState().modelFile(dryXModel).addModel();
    }

    private void dryingBlockHorizontalFacing(BlockStateEntryProviderHandle handle, DryingBlockRuinableHorizontalFacing block, ModelFile wetModelNorth, ModelFile wetModelEast, ModelFile wetModelSouth, ModelFile wetModelWest, ModelFile dryModelNorth, ModelFile dryModelEast, ModelFile dryModelSouth, ModelFile dryModelWest)
    {
        handle.getVariantBuilder(block)
                // North
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.NORTH)
                .modelForState().modelFile(wetModelNorth).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.NORTH)
                .modelForState().modelFile(dryModelNorth).addModel()
                // East
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.EAST)
                .modelForState().modelFile(wetModelEast).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.EAST)
                .modelForState().modelFile(dryModelEast).addModel()
                // South
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.SOUTH)
                .modelForState().modelFile(wetModelSouth).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.SOUTH)
                .modelForState().modelFile(dryModelSouth).addModel()
                // West
                // -- Wet
                .partialState()
                .with(WarmthTools.IS_DRY, false)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.WEST)
                .modelForState().modelFile(wetModelWest).addModel()
                // -- Dry
                .partialState()
                .with(WarmthTools.IS_DRY, true)
                .with(DryingBlockRuinableHorizontalFacing.DIRECTION, Direction.WEST)
                .modelForState().modelFile(dryModelWest).addModel();
    }

    private void dryingBrickBlock(BlockStateEntryProviderHandle handle, Block block, ResourceLocation wetTexture, ResourceLocation dryTexture)
    {
        var builder = handle.getMultipartBuilder(block);

        for (EnumProperty<WarmthTools.DryingBrickState> aProp : DryingBrickRuinable.BRICK_PROPERTIES)
        {
            for (WarmthTools.DryingBrickState brick : WarmthTools.DryingBrickState.values()) {
                if (brick.isEmpty()) continue;
                ModelFile model = smallBrickModel(
                        handle,
                        (brick == WarmthTools.DryingBrickState.WET ? handle.blockModelName(block) : handle.blockModelName(block, "_dried")),
                        aProp,
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

    private void dryingDoubleBrickBlock(BlockStateEntryProviderHandle handle, Block block, ResourceLocation wetTexture, ResourceLocation dryTexture)
    {
        var builder = handle.getMultipartBuilder(block);

        for (WarmthTools.DryingBrickState brick : WarmthTools.DryingBrickState.values())
        {
            if (brick.isEmpty()) continue;
            ModelFile model = largeBrickModel(
                    handle,
                    (brick == WarmthTools.DryingBrickState.WET ? handle.blockModelName(block) : handle.blockModelName(block, "_dried")),
                    brick == WarmthTools.DryingBrickState.WET ? wetTexture : dryTexture);
            for (Direction dir : BlockStateProperties.HORIZONTAL_FACING.getPossibleValues())
            {
                builder.part()
                        .rotationY(((dir.get2DDataValue() + 2)%4) * 90) .modelFile(model).addModel()
                        .condition(BlockStateProperties.HORIZONTAL_FACING, dir)
                        .end();
            }
        }
    }

    private ModelFile smallBrickModel(
            BlockStateEntryProviderHandle handle,
            String name,
            EnumProperty<WarmthTools.DryingBrickState> property,
            ResourceLocation texture)
    {
        String suffix = "";
        if (property.equals(DryingBrickRuinable.BACK_LEFT)) suffix = "_back_left";
        if (property.equals(DryingBrickRuinable.BACK_RIGHT)) suffix = "_back_right";
        if (property.equals(DryingBrickRuinable.FRONT_LEFT)) suffix = "_front_left";
        if (property.equals(DryingBrickRuinable.FRONT_RIGHT)) suffix = "_front_right";
        if (suffix.isEmpty()) throw new IllegalStateException("Unrecognised BlockState Property.");
        return handle.existingParent(name + suffix, MedievalismConstants.resource("block/base_inworld_brick" + suffix), texture);
    }

    private ModelFile largeBrickModel(
            BlockStateEntryProviderHandle handle,
            String name,
            ResourceLocation texture)
    {
        return handle.existingParent(name, MedievalismConstants.resource("block/base_inworld_double_brick"), texture);
    }
}
