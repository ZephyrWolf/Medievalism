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
import net.neoforged.neoforge.client.model.generators.*;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class MiscBlockStateProviderEntry implements IBlockStateProviderEntry
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    public MiscBlockStateProviderEntry()
    {
        super();
    }

    @Override
    public void registerModels(BlockStateEntryProviderHandle handle)
    {
        //region Primitive
        handle.randomRotationAndIntegerPropertyBlock(
                BlockRegistration.FIRE_LAY.get(),
                FireLayBlock.STAGE_PROP,
                handle.existingModel(BlockRegistration.FIRE_LAY.get(), "1"),
                handle.existingModel(BlockRegistration.FIRE_LAY.get(), "2"),
                handle.existingModel(BlockRegistration.FIRE_LAY.get(), "3"),
                handle.existingModel(BlockRegistration.FIRE_LAY.get(), "4"),
                handle.existingModel(BlockRegistration.FIRE_LAY.get(), "5")
        );
        //endregion

        handle.simpleAxisBlock(BlockRegistration.THATCH_BLOCK.get());
        handle.simpleCrossBlock(BlockRegistration.DOGBANE.get());
    }
}
