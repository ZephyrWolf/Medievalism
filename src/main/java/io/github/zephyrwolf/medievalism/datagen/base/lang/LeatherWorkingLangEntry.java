package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class LeatherWorkingLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addSoundTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addBlockItemTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addSoundTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.BAT_HIDE.get(), "Bat Hide");
        handle.addItem(ItemRegistration.CAMEL_HIDE.get(), "Camel Hide");
        handle.addItem(ItemRegistration.CAT_HIDE.get(), "Cat Hide");
        handle.addItem(ItemRegistration.COW_HIDE.get(), "Cow Hide");
        handle.addItem(ItemRegistration.DONKEY_HIDE.get(), "Donkey Hide");
        handle.addItem(ItemRegistration.FOX_HIDE.get(), "Fox Hide");
        handle.addItem(ItemRegistration.GOAT_HIDE.get(), "Goat Hide");
        handle.addItem(ItemRegistration.HOGLIN_HIDE.get(), "Hoglin Hide");
        handle.addItem(ItemRegistration.HORSE_HIDE.get(), "Horse Hide");
        handle.addItem(ItemRegistration.LLAMA_HIDE.get(), "Llama Hide");
        handle.addItem(ItemRegistration.MOOSHROOM_HIDE.get(), "Mooshroom Hide");
        handle.addItem(ItemRegistration.MULE_HIDE.get(), "Mule Hide");
        handle.addItem(ItemRegistration.OCELOT_HIDE.get(), "Ocelot Hide");
        handle.addItem(ItemRegistration.PANDA_HIDE.get(), "Panda Hide");
        handle.addItem(ItemRegistration.PIG_HIDE.get(), "Pig Hide");
        handle.addItem(ItemRegistration.POLAR_BEAR_HIDE.get(), "Polar Bear Hide");
        handle.addItem(ItemRegistration.RAVAGER_HIDE.get(), "Ravager Hide");
        handle.addItem(ItemRegistration.SHEEP_HIDE.get(), "Sheep Hide");
        handle.addItem(ItemRegistration.SNIFFER_HIDE.get(), "Sniffer Hide");
        handle.addItem(ItemRegistration.SNOW_FOX_HIDE.get(), "Snow Fox Hide");
        handle.addItem(ItemRegistration.WOLF_HIDE.get(), "Wolf Hide");
        handle.addItem(ItemRegistration.LARGE_LIMED_HIDE.get(), "Large Limed Hide");
        handle.addItem(ItemRegistration.MEDIUM_LIMED_HIDE.get(), "Medium Limed Hide");
        handle.addItem(ItemRegistration.SMALL_LIMED_HIDE.get(), "Small Limed Hide");
        handle.addItem(ItemRegistration.LARGE_RAW_HIDE.get(), "Large Raw Hide");
        handle.addItem(ItemRegistration.MEDIUM_RAW_HIDE.get(), "Medium Raw Hide");
        handle.addItem(ItemRegistration.SMALL_RAW_HIDE.get(), "Small Raw Hide");
        handle.addItem(ItemRegistration.LARGE_WET_LEATHER.get(), "Large Wet Leather");
        handle.addItem(ItemRegistration.MEDIUM_WET_LEATHER.get(), "Medium Wet Leather");
        handle.addItem(ItemRegistration.SMALL_WET_LEATHER.get(), "Small Wet Leather");
        handle.addItem(ItemRegistration.LARGE_LEATHER.get(), "Large Leather");
        handle.addItem(ItemRegistration.MEDIUM_LEATHER.get(), "Medium Leather");
        handle.addItem(ItemRegistration.SMALL_LEATHER.get(), "Small Leather");
        handle.addItem(ItemRegistration.QUICK_LIME.get(), "Quick Lime");
        handle.addItem(ItemRegistration.SLACKED_LIME_BUCKET.get(), "Slacked Lime Bucket");
        handle.addItem(ItemRegistration.TANNIN_BUCKET.get(), "Tannin Bucket");
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
