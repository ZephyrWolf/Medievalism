package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FarmingLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        crops(handle);
        seeds(handle);
        addBlockTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void crops(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.BARLEY.get(), "Barley");
        handle.addItem(ItemRegistration.BLUEBERRIES.get(), "Blueberries");
        handle.addItem(ItemRegistration.BROAD_BEAN.get(), "Broad Bean");
        handle.addItem(ItemRegistration.CABBAGE.get(), "Cabbage");
        handle.addItem(ItemRegistration.CHARD.get(), "Chard");
        handle.addItem(ItemRegistration.FLAX.get(), "Flax");
        handle.addItem(ItemRegistration.GARLIC.get(), "Garlic");
        handle.addItem(ItemRegistration.LEEK.get(), "Leek");
        handle.addItem(ItemRegistration.NAPA_CABBAGE.get(), "Napa Cabbage");
        handle.addItem(ItemRegistration.NETTLE.get(), "Nettle");
        handle.addItem(ItemRegistration.OATS.get(), "Oats");
        //handle.addItem(ItemRegistration.PUMPKIN_SLICE.get(), "Pumpkin Slice");
        handle.addItem(ItemRegistration.PARSNIP.get(), "Parsnip");
        handle.addItem(ItemRegistration.PURPLE_CARROT.get(), "Purple Carrot");
        handle.addItem(ItemRegistration.PURPLE_ONION.get(), "Purple Onion");
        handle.addItem(ItemRegistration.PURPLE_SKIRRET.get(), "Purple Skirret");
        handle.addItem(ItemRegistration.RADISH.get(), "Radish");
        handle.addItem(ItemRegistration.RASPBERRIES.get(), "Raspberries");
        handle.addItem(ItemRegistration.SKIRRET.get(), "Skirret");
        handle.addItem(ItemRegistration.SPINACH.get(), "Spinach");
        handle.addItem(ItemRegistration.STRAWBERRIES.get(), "Strawberries");
        handle.addItem(ItemRegistration.TURNIP.get(), "Turnip");
        handle.addItem(ItemRegistration.WHITE_CARROT.get(), "White Carrot");
        handle.addItem(ItemRegistration.WHITE_ONION.get(), "White Onion");
        handle.addItem(ItemRegistration.YAM.get(), "Yam");
    }

    private void seeds(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.FLAX_SEEDS.get(), "Flax Seeds");
        handle.addItem(ItemRegistration.BARLEY_SEEDS.get(), "Barley Seeds");
        handle.addItem(ItemRegistration.OAT_SEEDS.get(), "Oat Seeds");
    }

    private void addBlockTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addBlock(BlockRegistration.YAMS.get(), "Yams");
        handle.addBlock(BlockRegistration.THATCH_BLOCK.get(), "Thatch Block");
    }

    private void addCreativeTabTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addGUITranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addTooltipTranslations(LanguageEntryProviderHandle handle)
    {
    }
}
