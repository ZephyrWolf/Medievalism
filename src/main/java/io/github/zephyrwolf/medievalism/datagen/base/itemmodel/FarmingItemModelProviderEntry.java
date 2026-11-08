package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FarmingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        crops(handle);
        seeds(handle);

        handle.setFolder("farming");

        handle.itemGeneratedModel(ItemRegistration.DOGBANE.get());
        //handle.itemGeneratedModel(ItemRegistration.LEAF_LITTER.get());
        handle.itemGeneratedModel(ItemRegistration.THATCH.get());

        handle.setFolder("");
        handle.blockBasedModel(ItemRegistration.THATCH_BLOCK.get(), "");
    }

    private void crops(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("farming");
        handle.itemGeneratedModel(ItemRegistration.BARLEY.get());
        handle.itemGeneratedModel(ItemRegistration.BLUEBERRIES.get());
        handle.itemGeneratedModel(ItemRegistration.BROAD_BEAN.get());
        handle.itemGeneratedModel(ItemRegistration.CABBAGE.get());
        handle.itemGeneratedModel(ItemRegistration.CHARD.get());
        handle.itemGeneratedModel(ItemRegistration.FLAX.get());
        handle.itemGeneratedModel(ItemRegistration.GARLIC.get());
        handle.itemGeneratedModel(ItemRegistration.LEEK.get());
        handle.itemGeneratedModel(ItemRegistration.NAPA_CABBAGE.get());
        handle.itemGeneratedModel(ItemRegistration.NETTLE.get());
        handle.itemGeneratedModel(ItemRegistration.OATS.get());
        handle.itemGeneratedModel(ItemRegistration.PARSNIP.get());
        handle.setFolder("");
        handle.blockBasedModel(ItemRegistration.GREEN_PUMPKIN.get(), "");
        handle.setFolder("farming");
        handle.itemGeneratedModel(ItemRegistration.PURPLE_CARROT.get());
        handle.itemGeneratedModel(ItemRegistration.PURPLE_ONION.get());
        handle.itemGeneratedModel(ItemRegistration.PURPLE_SKIRRET.get());
        handle.itemGeneratedModel(ItemRegistration.RADISH.get());
        handle.itemGeneratedModel(ItemRegistration.RASPBERRIES.get());
        handle.itemGeneratedModel(ItemRegistration.SKIRRET.get());
        handle.itemGeneratedModel(ItemRegistration.SPINACH.get());
        handle.itemGeneratedModel(ItemRegistration.STRAWBERRIES.get());
        handle.itemGeneratedModel(ItemRegistration.TURNIP.get());
        handle.itemGeneratedModel(ItemRegistration.WHITE_CARROT.get());
        handle.itemGeneratedModel(ItemRegistration.WHITE_ONION.get());
        handle.itemGeneratedModel(ItemRegistration.YAM.get());
    }

    private void seeds(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("farming");
        handle.itemGeneratedModel(ItemRegistration.FLAX_SEEDS.get());
        handle.itemGeneratedModel(ItemRegistration.BARLEY_SEEDS.get());
        handle.itemGeneratedModel(ItemRegistration.OAT_SEEDS.get());
    }
}
