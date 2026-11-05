package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class MetalWorkingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        ore(handle);
        //tools(handle);
    }

    private void ore(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("metal_working");
        // From mining ore
        handle.itemGeneratedModel(ItemRegistration.RAW_TIN.get());
        // From crushing raw
        handle.itemGeneratedModel(ItemRegistration.COPPER_ORE_DUST.get());
        handle.itemGeneratedModel(ItemRegistration.TIN_ORE_DUST.get());
        handle.itemGeneratedModel(ItemRegistration.IRON_ORE_DUST.get());
    }
}
