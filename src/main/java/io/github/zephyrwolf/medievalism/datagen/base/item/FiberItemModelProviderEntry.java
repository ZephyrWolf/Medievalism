package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FiberItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        materials(handle);
    }

    private void materials(ItemModelProviderHandle handle)
    {
        handle.setFolder("fiber");

        //handle.itemGeneratedModel(ItemRegistration.BAST_FIBERS.get());
        handle.itemGeneratedModel(ItemRegistration.FLAX_FIBER.get());
    }
}
