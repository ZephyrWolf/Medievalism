package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class CookingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        baked(handle);
        ingredients(handle);
    }

    private void baked(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("cooking");

        handle.itemGeneratedModel(ItemRegistration.BAKED_BEETROOT.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_CARROT.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_GARLIC.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_LEEK.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_PARSNIP.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_PUMPKIN_SLICE.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_PURPLE_CARROT.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_PURPLE_ONION.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_PURPLE_SKIRRET.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_RADISH.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_SKIRRET.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_TURNIP.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_WHITE_CARROT.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_WHITE_ONION.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_YAM.get());
    }

    private void ingredients(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("cooking");


        handle.itemGeneratedModel(ItemRegistration.CRACKED_BARLEY.get());
        handle.itemGeneratedModel(ItemRegistration.CRACKED_WHEAT.get());
        handle.itemGeneratedModel(ItemRegistration.ROLLED_OATS.get());
        handle.itemGeneratedModel(ItemRegistration.DOUGH.get());
        handle.itemGeneratedModel(ItemRegistration.FLOUR.get());
    }
}
