package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FoodItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        fresh(handle);
        baked(handle);
        ingredients(handle);
        cooked(handle);
    }

    private void fresh(ItemModelProviderHandle handle)
    {
        handle.setFolder("food");

        handle.itemGeneratedModel(ItemRegistration.BLUEBERRIES.get());
        //handle.itemGeneratedModel(ItemRegistration.BROAD_BEAN.get());
        //handle.itemGeneratedModel(ItemRegistration.CABBAGE.get());
        //handle.itemGeneratedModel(ItemRegistration.CHARD.get());
        //handle.itemGeneratedModel(ItemRegistration.GARLIC.get());
        //handle.itemGeneratedModel(ItemRegistration.LEEK.get());
        //handle.itemGeneratedModel(ItemRegistration.NAPA_CABBAGE.get());
        //handle.itemGeneratedModel(ItemRegistration.NETTLE.get());
        //handle.itemGeneratedModel(ItemRegistration.PARSNIP.get());
        //handle.itemGeneratedModel(ItemRegistration.PURPLE_CARROT.get());
        //handle.itemGeneratedModel(ItemRegistration.PURPLE_ONION.get());
        //handle.itemGeneratedModel(ItemRegistration.PURPLE_SKIRRET.get());
        //handle.itemGeneratedModel(ItemRegistration.RADISH.get());
        handle.itemGeneratedModel(ItemRegistration.RASPBERRIES.get());
        //handle.itemGeneratedModel(ItemRegistration.SKIRRET.get());
        //handle.itemGeneratedModel(ItemRegistration.SPINACH.get());
        handle.itemGeneratedModel(ItemRegistration.STRAWBERRIES.get());
        //handle.itemGeneratedModel(ItemRegistration.TURNIP.get());
        //handle.itemGeneratedModel(ItemRegistration.WHITE_CARROT.get());
        //handle.itemGeneratedModel(ItemRegistration.WHITE_ONION.get());
        handle.itemGeneratedModel(ItemRegistration.YAM.get());
    }

    private void baked(ItemModelProviderHandle handle)
    {
        handle.setFolder("food");

        handle.itemGeneratedModel(ItemRegistration.BAKED_BEETROOT.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_CARROT.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_GARLIC.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_LEEK.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_PARSNIP.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_PURPLE_CARROT.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_PURPLE_ONION.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_PURPLE_SKIRRET.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_RADISH.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_SKIRRET.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_TURNIP.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_WHITE_CARROT.get());
        //handle.itemGeneratedModel(ItemRegistration.BAKED_WHITE_ONION.get());
        handle.itemGeneratedModel(ItemRegistration.BAKED_YAM.get());
    }

    private void ingredients(ItemModelProviderHandle handle)
    {
        handle.setFolder("food");

        handle.itemGeneratedModel(ItemRegistration.OATS.get());
        handle.itemGeneratedModel(ItemRegistration.BARLEY.get());
        handle.itemGeneratedModel(ItemRegistration.CRACKED_BARLEY.get());
        handle.itemGeneratedModel(ItemRegistration.CRACKED_WHEAT.get());
        handle.itemGeneratedModel(ItemRegistration.ROLLED_OATS.get());
        //handle.itemGeneratedModel(ItemRegistration.WHEAT_DOUGH.get());
        //handle.itemGeneratedModel(ItemRegistration.BARLEY_DOUGH.get());
        //handle.itemGeneratedModel(ItemRegistration.OAT_DOUGH.get());
        //handle.itemGeneratedModel(ItemRegistration.BARLEY_FLOUR.get());
        //handle.itemGeneratedModel(ItemRegistration.WHEAT_FLOUR.get());
        //handle.itemGeneratedModel(ItemRegistration.OAT_FLOUR.get());
    }

    private void cooked(ItemModelProviderHandle handle)
    {
        handle.setFolder("food");

        //handle.itemGeneratedModel(ItemRegistration.BARLEY_BREAD.get());
        //handle.itemGeneratedModel(ItemRegistration.OAT_BREAD.get());
    }

}
