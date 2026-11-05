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
public final class FarmingBlockStateProviderEntry implements IBlockStateProviderEntry
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java

    public FarmingBlockStateProviderEntry()
    {
        super();
    }

    @Override
    public void registerModels(BlockStateEntryProviderHandle handle)
    {
        handle.cropBlock_4_8(BlockRegistration.YAMS.get());
        handle.simpleCrossBlock(BlockRegistration.WILD_YAMS.get());
    }
}
