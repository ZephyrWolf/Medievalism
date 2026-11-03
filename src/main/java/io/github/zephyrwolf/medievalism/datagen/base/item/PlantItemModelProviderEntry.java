package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;

public class PlantItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        handle.setFolder("plant");

        //handle.itemGeneratedModel(ItemRegistration.FLAX.get());
        //handle.itemGeneratedModel(ItemRegistration.FLAX_SEEDS.get());
        //handle.itemGeneratedModel(ItemRegistration.BARLEY_SEEDS.get());
        //handle.itemGeneratedModel(ItemRegistration.OAT_SEEDS.get());

        //handle.itemGeneratedModel(ItemRegistration.LEAF_LITTER.get());
        handle.itemGeneratedModel(BlockItemRegistration.THATCH.get());

        //handle.itemGeneratedModel(BlockItemRegistration.DOGBANE.get());

        handle.setFolder("");

        handle.blockBasedModel(BlockItemRegistration.THATCH_BLOCK.get(), "");
        handle.blockIconGeneratedModel(BlockItemRegistration.SHRUB.get());
    }
}
