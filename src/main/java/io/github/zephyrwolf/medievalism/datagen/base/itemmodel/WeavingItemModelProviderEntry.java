package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
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

        handle.itemGeneratedModel(WeavingItemRegistration.FLAX_FIBER.get());
        handle.itemGeneratedModel(WeavingItemRegistration.SPLIT_SOFT_RUSH.get());
        handle.itemGeneratedModel(WeavingItemRegistration.PRIMITIVE_CORDAGE.get());//
        handle.itemGeneratedModel(WeavingItemRegistration.GREEN_BAST_FIBERS.get());
        handle.itemGeneratedModel(WeavingItemRegistration.DRY_BAST_FIBERS.get());//
        handle.itemGeneratedModel(WeavingItemRegistration.BAST_CORDAGE.get());//
    }
}
