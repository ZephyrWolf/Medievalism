package io.github.zephyrwolf.medievalism.datagen.base.blockmodel;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import io.github.zephyrwolf.medievalism.common.data.BlockStateEntryProviderHandle;
import io.github.zephyrwolf.medievalism.common.data.IBlockStateProviderEntry;
import io.github.zephyrwolf.medievalism.common.warmth.WarmthTools;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
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
public final class MudWorkingBlockStateProviderEntry implements IBlockStateProviderEntry
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    public MudWorkingBlockStateProviderEntry()
    {
        super();
    }

    @Override
    public void registerModels(BlockStateEntryProviderHandle handle)
    {
        handle.simpleBlock(BlockRegistration.DRYING_PACKED_MUD.get(), handle.blockTexture("wet_packed_mud"));
        handle.simpleBlock(BlockRegistration.DRYING_DAUB_BLOCK.get(), handle.blockTexture("wet_daub_block"));
        handle.simpleBlock(BlockRegistration.DAUB_BLOCK.get());
        handle.simpleBlock(BlockRegistration.DAUB_BRICKS.get());
        handle.simpleBlock(BlockRegistration.CRACKED_DAUB_BLOCK.get());
        handle.simpleBlock(BlockRegistration.CRACKED_DAUB_BRICKS.get());

        dryingBrickBlock(handle, BlockRegistration.DRYING_PACKED_MUD_BRICK.get(), MedievalismConstants.resource("block/wet_packed_mud"), ResourceLocation.withDefaultNamespace("block/packed_mud"));
        dryingBrickBlock(handle, BlockRegistration.DRYING_DAUB_BRICK.get(), MedievalismConstants.resource("block/wet_daub_block"), MedievalismConstants.resource("block/daub_block"));
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
}
