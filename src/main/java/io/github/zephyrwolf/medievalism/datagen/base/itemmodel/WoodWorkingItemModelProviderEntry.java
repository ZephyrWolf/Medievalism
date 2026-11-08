package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WoodWorkingItemRegistration;

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

        handle.itemGeneratedModel(WoodWorkingItemRegistration.CHARCOAL_POWDER.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.POTASH.get());
        handle.itemGeneratedModel(ItemRegistration.WOOD_ASH.get());
        handle.itemGeneratedModel(ItemRegistration.CHOPPED_WOOD.get());

        handle.itemGeneratedModel(WoodWorkingItemRegistration.WHITE_BARK.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.BROWN_BARK.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.GREY_BARK.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.DARK_BROWN_BARK.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.BLACK_BARK.get());
    }

    private void tools(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("wood_working");

        handle.itemGeneratedModel(WoodWorkingItemRegistration.DIGGING_STICK.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.FIRE_STARTER.get());

        handle.itemGeneratedModel(WoodWorkingItemRegistration.TOOL_HANDLE.get());
    }

    private void workstations(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.CHOPPING_BLOCK.get(), "");
    }
}
