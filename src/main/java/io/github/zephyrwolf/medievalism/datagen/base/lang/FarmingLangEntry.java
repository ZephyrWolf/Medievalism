package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.FarmingItemRegistration;
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
        handle.addItem(FarmingItemRegistration.BARLEY.get(), "Barley");
        handle.addItem(FarmingItemRegistration.BLUEBERRIES.get(), "Blueberries");
        handle.addItem(FarmingItemRegistration.BROAD_BEAN.get(), "Broad Bean");
        handle.addItem(FarmingItemRegistration.CABBAGE.get(), "Cabbage");
        handle.addItem(FarmingItemRegistration.CHARD.get(), "Chard");
        handle.addItem(FarmingItemRegistration.FLAX.get(), "Flax");
        handle.addItem(FarmingItemRegistration.GARLIC.get(), "Garlic");
        handle.addItem(FarmingItemRegistration.LEEK.get(), "Leek");
        handle.addItem(FarmingItemRegistration.NAPA_CABBAGE.get(), "Napa Cabbage");
        handle.addItem(FarmingItemRegistration.NETTLE.get(), "Nettle");
        handle.addItem(FarmingItemRegistration.OATS.get(), "Oats");
        handle.addItem(FarmingItemRegistration.GREEN_PUMPKIN.get(), "Green Pumpkin");
        handle.addItem(FarmingItemRegistration.PARSNIP.get(), "Parsnip");
        handle.addItem(FarmingItemRegistration.PURPLE_CARROT.get(), "Purple Carrot");
        handle.addItem(FarmingItemRegistration.PURPLE_ONION.get(), "Purple Onion");
        handle.addItem(FarmingItemRegistration.PURPLE_SKIRRET.get(), "Purple Skirret");
        handle.addItem(FarmingItemRegistration.RADISH.get(), "Radish");
        handle.addItem(FarmingItemRegistration.RASPBERRIES.get(), "Raspberries");
        handle.addItem(FarmingItemRegistration.SKIRRET.get(), "Skirret");
        handle.addItem(FarmingItemRegistration.SOFT_RUSH_SEEDS.get(), "Soft Rush Seeds");
        handle.addItem(FarmingItemRegistration.SPINACH.get(), "Spinach");
        handle.addItem(FarmingItemRegistration.STRAWBERRIES.get(), "Strawberries");
        handle.addItem(FarmingItemRegistration.TURNIP.get(), "Turnip");
        handle.addItem(FarmingItemRegistration.WHITE_CARROT.get(), "White Carrot");
        handle.addItem(FarmingItemRegistration.WHITE_ONION.get(), "White Onion");
        handle.addItem(FarmingItemRegistration.YAM.get(), "Yam");
    }

    private void seeds(LanguageEntryProviderHandle handle)
    {
        handle.addItem(FarmingItemRegistration.FLAX_SEEDS.get(), "Flax Seeds");
        handle.addItem(FarmingItemRegistration.BARLEY_SEEDS.get(), "Barley Seeds");
        handle.addItem(FarmingItemRegistration.OAT_SEEDS.get(), "Oat Seeds");
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
