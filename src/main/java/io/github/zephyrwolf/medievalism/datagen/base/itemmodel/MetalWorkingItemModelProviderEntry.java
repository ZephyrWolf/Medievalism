package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.MetalWorkingItemRegistration;

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
        handle.itemGeneratedModel(MetalWorkingItemRegistration.RAW_TIN.get());
        // From crushing raw
        handle.itemGeneratedModel(MetalWorkingItemRegistration.COPPER_ORE_DUST.get());
        handle.itemGeneratedModel(MetalWorkingItemRegistration.TIN_ORE_DUST.get());
        handle.itemGeneratedModel(MetalWorkingItemRegistration.IRON_ORE_DUST.get());
    }
}
