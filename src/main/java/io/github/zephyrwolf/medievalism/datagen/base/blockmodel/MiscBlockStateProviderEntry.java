package io.github.zephyrwolf.medievalism.datagen.base.blockmodel;

import io.github.zephyrwolf.medievalism.common.block.firepit.BuildCampfireBlock;
import io.github.zephyrwolf.medievalism.common.block.firepit.FireLayBlock;
import io.github.zephyrwolf.medievalism.common.data.BlockStateEntryProviderHandle;
import io.github.zephyrwolf.medievalism.common.data.IBlockStateProviderEntry;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;

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
                BlockRegistration.THATCH_FIRE_LAY.get(),
                FireLayBlock.STAGE_PROP,
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_FIRE_LAY.get(), "_tinder")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_FIRE_LAY.get(), "_stick1")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_FIRE_LAY.get(), "_stick2")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_FIRE_LAY.get(), "_stick3")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_FIRE_LAY.get(), "_stick4"))
        );
        handle.randomRotationAndIntegerPropertyBlock(
                BlockRegistration.THATCH_BUILD_CAMPFIRE.get(),
                BuildCampfireBlock.STAGE_PROP,
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_BUILD_CAMPFIRE.get(), "_chopped_wood1")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_BUILD_CAMPFIRE.get(), "_chopped_wood2")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_BUILD_CAMPFIRE.get(), "_chopped_wood3")),
                handle.existingModel(handle.blockModelName(BlockRegistration.THATCH_BUILD_CAMPFIRE.get(), "_chopped_wood4"))
        );
        //endregion

        handle.simpleAxisBlock(BlockRegistration.THATCH_BLOCK.get());
        handle.simpleCrossBlock(BlockRegistration.DOGBANE.get());
    }
}
