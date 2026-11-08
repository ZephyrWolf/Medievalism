package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.FarmingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FarmingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        crops(handle);
        seeds(handle);

        handle.setFolder("farming");

        handle.itemGeneratedModel(FarmingItemRegistration.DOGBANE.get());
        //handle.itemGeneratedModel(ItemRegistration.LEAF_LITTER.get());
        handle.itemGeneratedModel(FarmingItemRegistration.THATCH.get());

        handle.setFolder("");
        handle.blockBasedModel(FarmingItemRegistration.THATCH_BLOCK.get(), "");
    }

    private void crops(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("farming");
        handle.itemGeneratedModel(FarmingItemRegistration.BARLEY.get());
        handle.itemGeneratedModel(FarmingItemRegistration.BLUEBERRIES.get());
        handle.itemGeneratedModel(FarmingItemRegistration.BROAD_BEAN.get());
        handle.itemGeneratedModel(FarmingItemRegistration.CABBAGE.get());
        handle.itemGeneratedModel(FarmingItemRegistration.CHARD.get());
        handle.itemGeneratedModel(FarmingItemRegistration.FLAX.get());
        handle.itemGeneratedModel(FarmingItemRegistration.GARLIC.get());
        handle.itemGeneratedModel(FarmingItemRegistration.LEEK.get());
        handle.itemGeneratedModel(FarmingItemRegistration.NAPA_CABBAGE.get());
        handle.itemGeneratedModel(FarmingItemRegistration.NETTLE.get());
        handle.itemGeneratedModel(FarmingItemRegistration.OATS.get());
        handle.itemGeneratedModel(FarmingItemRegistration.PARSNIP.get());
        handle.setFolder("");
        handle.blockBasedModel(FarmingItemRegistration.GREEN_PUMPKIN.get(), "");
        handle.setFolder("farming");
        handle.itemGeneratedModel(FarmingItemRegistration.PURPLE_CARROT.get());
        handle.itemGeneratedModel(FarmingItemRegistration.PURPLE_ONION.get());
        handle.itemGeneratedModel(FarmingItemRegistration.PURPLE_SKIRRET.get());
        handle.itemGeneratedModel(FarmingItemRegistration.RADISH.get());
        handle.itemGeneratedModel(FarmingItemRegistration.RASPBERRIES.get());
        handle.itemGeneratedModel(FarmingItemRegistration.SKIRRET.get());
        handle.itemGeneratedModel(FarmingItemRegistration.SPINACH.get());
        handle.itemGeneratedModel(FarmingItemRegistration.STRAWBERRIES.get());
        handle.itemGeneratedModel(FarmingItemRegistration.TURNIP.get());
        handle.itemGeneratedModel(FarmingItemRegistration.WHITE_CARROT.get());
        handle.itemGeneratedModel(FarmingItemRegistration.WHITE_ONION.get());
        handle.itemGeneratedModel(FarmingItemRegistration.YAM.get());
    }

    private void seeds(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("farming");
        handle.itemGeneratedModel(FarmingItemRegistration.FLAX_SEEDS.get());
        handle.itemGeneratedModel(FarmingItemRegistration.BARLEY_SEEDS.get());
        handle.itemGeneratedModel(FarmingItemRegistration.OAT_SEEDS.get());
    }
}
