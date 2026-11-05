package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class WoodWorkingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        materials(handle);
        tools(handle);
        workstations(handle);
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("wood_working");

        handle.itemGeneratedModel(ItemRegistration.CHARCOAL_POWDER.get());
        handle.itemGeneratedModel(ItemRegistration.POTASH.get());
        handle.itemGeneratedModel(ItemRegistration.WOOD_ASH.get());
        handle.itemGeneratedModel(ItemRegistration.CHOPPED_WOOD.get());

        handle.itemGeneratedModel(ItemRegistration.WHITE_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.BROWN_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.GREY_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.DARK_BROWN_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.BLACK_BARK.get());
    }

    private void tools(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("wood_working");

        handle.itemGeneratedModel(ItemRegistration.DIGGING_STICK.get());
        handle.itemGeneratedModel(ItemRegistration.FIRE_STARTER.get());
    }

    private void workstations(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.CHOPPING_BLOCK.get(), "");
    }
}
