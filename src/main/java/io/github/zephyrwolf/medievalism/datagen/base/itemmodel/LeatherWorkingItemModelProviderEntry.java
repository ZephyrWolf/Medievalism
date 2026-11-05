package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class LeatherWorkingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        materials(handle);
        hide(handle);
        leather(handle);
        // TODO how does one prepare a hide to use for decoration?
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("leather_working");
        handle.itemGeneratedModel(ItemRegistration.QUICK_LIME.get());
        handle.itemGeneratedModel(ItemRegistration.SLACKED_LIME_BUCKET.get());
        handle.itemGeneratedModel(ItemRegistration.TANNIN_BUCKET.get());
    }

    private void hide(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("leather_working");
        handle.itemGeneratedModel(ItemRegistration.BAT_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.CAMEL_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.CAT_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.COW_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.DONKEY_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.FOX_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.GOAT_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.HOGLIN_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.HORSE_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.LLAMA_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.MOOSHROOM_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.MULE_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.OCELOT_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.PANDA_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.PIG_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.POLAR_BEAR_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.RAVAGER_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.SHEEP_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.SNIFFER_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.SNOW_FOX_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.WOLF_HIDE.get());
        // rabbit hide is vanilla
    }

    private void leather(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("leather_working");
        handle.itemGeneratedModel(ItemRegistration.LARGE_LIMED_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.MEDIUM_LIMED_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.SMALL_LIMED_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.LARGE_RAW_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.MEDIUM_RAW_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.SMALL_RAW_HIDE.get());
        handle.itemGeneratedModel(ItemRegistration.LARGE_WET_LEATHER.get());
        handle.itemGeneratedModel(ItemRegistration.MEDIUM_WET_LEATHER.get());
        handle.itemGeneratedModel(ItemRegistration.SMALL_WET_LEATHER.get());
        // Large being vanilla
        handle.itemGeneratedModel(ItemRegistration.MEDIUM_LEATHER.get());
        handle.itemGeneratedModel(ItemRegistration.SMALL_LEATHER.get());
    }
}
