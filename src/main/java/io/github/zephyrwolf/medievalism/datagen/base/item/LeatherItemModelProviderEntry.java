package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;

public class LeatherItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        hide(handle);
        leather(handle);
        // TODO how does one prepare a hide to use for decoration?
    }

    private void hide(ItemModelProviderHandle handle)
    {
        handle.setFolder("leather");

        //handle.itemGeneratedModel(ItemRegistration.BAT_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.CAMEL_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.CAT_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.COW_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.DONKEY_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.FOX_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.GOAT_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.HOGLIN_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.HORSE_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.LLAMA_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.MOOSHROOM_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.MULE_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.OCELOT_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.PANDA_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.PIG_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.POLAR_BEAR_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.RAVAGER_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.SHEEP_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.SNIFFER_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.SNOW_FOX_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.WOLF_HIDE.get());
    }

    private void leather(ItemModelProviderHandle handle)
    {
        handle.setFolder("leather");

        //handle.itemGeneratedModel(ItemRegistration.LARGE_LIMED_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.MEDIUM_LIMED_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.SMALL_LIMED_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.LARGE_RAW_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.MEDIUM_RAW_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.SMALL_RAW_HIDE.get());
        //handle.itemGeneratedModel(ItemRegistration.LARGE_WET_LEATHER.get());
        //handle.itemGeneratedModel(ItemRegistration.MEDIUM_WET_LEATHER.get());
        //handle.itemGeneratedModel(ItemRegistration.SMALL_WET_LEATHER.get());
        //// Large being vanilla
        //handle.itemGeneratedModel(ItemRegistration.MEDIUM_LEATHER.get());
        //handle.itemGeneratedModel(ItemRegistration.SMALL_LEATHER.get());
    }
}
