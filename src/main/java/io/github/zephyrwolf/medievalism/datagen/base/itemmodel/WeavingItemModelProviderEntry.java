package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WeavingItemRegistration;

public class WeavingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        materials(handle);
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("weaving");

        //handle.itemGeneratedModel(ItemRegistration.BAST_FIBERS.get());
        handle.itemGeneratedModel(WeavingItemRegistration.FLAX_FIBER.get());
    }
}
