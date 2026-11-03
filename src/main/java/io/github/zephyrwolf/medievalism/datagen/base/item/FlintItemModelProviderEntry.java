package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FlintItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        tools(handle);
    }

    private void tools(ItemModelProviderHandle handle)
    {
        handle.setFolder("flint");

        //handle.itemGeneratedModel(ItemRegistration.FLINT_KNIFE_BLADE.get());
        //handle.itemGeneratedModel(ItemRegistration.FLINT_KNIFE.get());
    }
}
