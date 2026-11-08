package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.CookingItemRegistration;
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

        handle.itemGeneratedModel(CookingItemRegistration.BAKED_BEETROOT.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_CARROT.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_GARLIC.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_LEEK.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_PARSNIP.get());
        handle.itemGeneratedModel(CookingItemRegistration.PUMPKIN_SLICE.get());
        handle.itemGeneratedModel(CookingItemRegistration.GREEN_PUMPKIN_SLICE.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_PUMPKIN.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_GREEN_PUMPKIN.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_PUMPKIN_SLICE.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_GREEN_PUMPKIN_SLICE.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_PURPLE_CARROT.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_PURPLE_ONION.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_PURPLE_SKIRRET.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_RADISH.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_SKIRRET.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_TURNIP.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_WHITE_CARROT.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_WHITE_ONION.get());
        handle.itemGeneratedModel(CookingItemRegistration.BAKED_YAM.get());
    }

    private void ingredients(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("cooking");


        handle.itemGeneratedModel(CookingItemRegistration.CRACKED_BARLEY.get());
        handle.itemGeneratedModel(CookingItemRegistration.CRACKED_WHEAT.get());
        handle.itemGeneratedModel(CookingItemRegistration.ROLLED_OATS.get());
        handle.itemGeneratedModel(CookingItemRegistration.DOUGH.get());
        handle.itemGeneratedModel(CookingItemRegistration.FLOUR.get());
    }
}
