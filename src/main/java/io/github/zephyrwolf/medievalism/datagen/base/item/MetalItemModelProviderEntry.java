package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class MetalItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        ore(handle);
        //tools(handle);
    }

    private void ore(ItemModelProviderHandle handle)
    {
        handle.setFolder("metal");
        // From mining ore
        handle.itemGeneratedModel(ItemRegistration.RAW_TIN.get());
        // From crushing raw
        handle.itemGeneratedModel(ItemRegistration.COPPER_ORE_DUST.get());
        handle.itemGeneratedModel(ItemRegistration.TIN_ORE_DUST.get());
        handle.itemGeneratedModel(ItemRegistration.IRON_ORE_DUST.get());
    }
}
