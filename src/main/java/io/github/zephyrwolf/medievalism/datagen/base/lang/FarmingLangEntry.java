package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class FarmingLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addItemTranslations(handle);
        addBlockTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.BLUEBERRIES.get(), "Blueberries");
        handle.addItem(ItemRegistration.RASPBERRIES.get(), "Raspberries");
        handle.addItem(ItemRegistration.STRAWBERRIES.get(), "Strawberries");
        handle.addItem(ItemRegistration.BARLEY.get(), "Barley");
        handle.addItem(ItemRegistration.OATS.get(), "Oats");
        handle.addItem(ItemRegistration.YAM.get(), "Yam");
        handle.addItem(ItemRegistration.FLAX.get(), "Flax");

        handle.addItem(ItemRegistration.FLAX_SEEDS.get(), "Flax Seeds");
        handle.addItem(ItemRegistration.OAT_SEEDS.get(), "Oat Seeds");
        handle.addItem(ItemRegistration.BARLEY_SEEDS.get(), "Barley Seeds");
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
