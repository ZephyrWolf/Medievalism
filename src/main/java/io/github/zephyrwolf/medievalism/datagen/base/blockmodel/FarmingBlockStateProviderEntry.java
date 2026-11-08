package io.github.zephyrwolf.medievalism.datagen.base.blockmodel;

import io.github.zephyrwolf.medievalism.common.data.BlockStateEntryProviderHandle;
import io.github.zephyrwolf.medievalism.common.data.IBlockStateProviderEntry;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
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
        ResourceLocation textureGreenPumpkinTop = handle.blockTexture(BlockRegistration.GREEN_PUMPKIN.get(), "_top");
        ResourceLocation textureGreenPumpkinSide = handle.blockTexture(BlockRegistration.GREEN_PUMPKIN.get(), "_side");
        ModelFile modelGreenPumpkin = handle.cubeColumnModel(handle.blockModelName(BlockRegistration.GREEN_PUMPKIN.get()),
                textureGreenPumpkinTop, textureGreenPumpkinSide);
        handle.simpleBlock(BlockRegistration.GREEN_PUMPKIN.get(), modelGreenPumpkin);

        handle.cropBlock_4_8(BlockRegistration.YAMS.get());
        handle.simpleCrossBlock(BlockRegistration.WILD_YAMS.get());
    }
}
