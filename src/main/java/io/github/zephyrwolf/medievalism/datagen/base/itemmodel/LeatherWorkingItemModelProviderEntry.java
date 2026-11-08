package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.LeatherWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WoodWorkingItemRegistration;

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
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.QUICK_LIME.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SLACKED_LIME_BUCKET.get());
        handle.itemGeneratedModel(WoodWorkingItemRegistration.TANNIN_BUCKET.get());
    }

    private void hide(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("leather_working");
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.BAT_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.CAMEL_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.CAT_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.COW_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.DONKEY_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.FOX_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.GOAT_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.HOGLIN_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.HORSE_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.LLAMA_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.MOOSHROOM_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.MULE_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.OCELOT_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.PANDA_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.PIG_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.POLAR_BEAR_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.RAVAGER_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SHEEP_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SNIFFER_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SNOW_FOX_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.WOLF_HIDE.get());
        // rabbit hide is vanilla
    }

    private void leather(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("leather_working");
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.LARGE_LIMED_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.MEDIUM_LIMED_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SMALL_LIMED_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.LARGE_RAW_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.MEDIUM_RAW_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SMALL_RAW_HIDE.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.LARGE_WET_LEATHER.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.MEDIUM_WET_LEATHER.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SMALL_WET_LEATHER.get());
        // Large being vanilla
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.MEDIUM_LEATHER.get());
        handle.itemGeneratedModel(LeatherWorkingItemRegistration.SMALL_LEATHER.get());
    }
}
