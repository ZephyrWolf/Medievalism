package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.LeatherWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WoodWorkingItemRegistration;

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
        handle.addItem(LeatherWorkingItemRegistration.BAT_HIDE.get(), "Bat Hide");
        handle.addItem(LeatherWorkingItemRegistration.CAMEL_HIDE.get(), "Camel Hide");
        handle.addItem(LeatherWorkingItemRegistration.CAT_HIDE.get(), "Cat Hide");
        handle.addItem(LeatherWorkingItemRegistration.COW_HIDE.get(), "Cow Hide");
        handle.addItem(LeatherWorkingItemRegistration.DONKEY_HIDE.get(), "Donkey Hide");
        handle.addItem(LeatherWorkingItemRegistration.FOX_HIDE.get(), "Fox Hide");
        handle.addItem(LeatherWorkingItemRegistration.GOAT_HIDE.get(), "Goat Hide");
        handle.addItem(LeatherWorkingItemRegistration.HOGLIN_HIDE.get(), "Hoglin Hide");
        handle.addItem(LeatherWorkingItemRegistration.HORSE_HIDE.get(), "Horse Hide");
        handle.addItem(LeatherWorkingItemRegistration.LLAMA_HIDE.get(), "Llama Hide");
        handle.addItem(LeatherWorkingItemRegistration.MOOSHROOM_HIDE.get(), "Mooshroom Hide");
        handle.addItem(LeatherWorkingItemRegistration.MULE_HIDE.get(), "Mule Hide");
        handle.addItem(LeatherWorkingItemRegistration.OCELOT_HIDE.get(), "Ocelot Hide");
        handle.addItem(LeatherWorkingItemRegistration.PANDA_HIDE.get(), "Panda Hide");
        handle.addItem(LeatherWorkingItemRegistration.PIG_HIDE.get(), "Pig Hide");
        handle.addItem(LeatherWorkingItemRegistration.POLAR_BEAR_HIDE.get(), "Polar Bear Hide");
        handle.addItem(LeatherWorkingItemRegistration.RAVAGER_HIDE.get(), "Ravager Hide");
        handle.addItem(LeatherWorkingItemRegistration.SHEEP_HIDE.get(), "Sheep Hide");
        handle.addItem(LeatherWorkingItemRegistration.SNIFFER_HIDE.get(), "Sniffer Hide");
        handle.addItem(LeatherWorkingItemRegistration.SNOW_FOX_HIDE.get(), "Snow Fox Hide");
        handle.addItem(LeatherWorkingItemRegistration.WOLF_HIDE.get(), "Wolf Hide");
        handle.addItem(LeatherWorkingItemRegistration.LARGE_LIMED_HIDE.get(), "Large Limed Hide");
        handle.addItem(LeatherWorkingItemRegistration.MEDIUM_LIMED_HIDE.get(), "Medium Limed Hide");
        handle.addItem(LeatherWorkingItemRegistration.SMALL_LIMED_HIDE.get(), "Small Limed Hide");
        handle.addItem(LeatherWorkingItemRegistration.LARGE_RAW_HIDE.get(), "Large Raw Hide");
        handle.addItem(LeatherWorkingItemRegistration.MEDIUM_RAW_HIDE.get(), "Medium Raw Hide");
        handle.addItem(LeatherWorkingItemRegistration.SMALL_RAW_HIDE.get(), "Small Raw Hide");
        handle.addItem(LeatherWorkingItemRegistration.LARGE_WET_LEATHER.get(), "Large Wet Leather");
        handle.addItem(LeatherWorkingItemRegistration.MEDIUM_WET_LEATHER.get(), "Medium Wet Leather");
        handle.addItem(LeatherWorkingItemRegistration.SMALL_WET_LEATHER.get(), "Small Wet Leather");
        handle.addItem(LeatherWorkingItemRegistration.LARGE_LEATHER.get(), "Large Leather");
        handle.addItem(LeatherWorkingItemRegistration.MEDIUM_LEATHER.get(), "Medium Leather");
        handle.addItem(LeatherWorkingItemRegistration.SMALL_LEATHER.get(), "Small Leather");
        handle.addItem(LeatherWorkingItemRegistration.QUICK_LIME.get(), "Quick Lime");
        handle.addItem(LeatherWorkingItemRegistration.SLACKED_LIME_BUCKET.get(), "Slacked Lime Bucket");
        handle.addItem(WoodWorkingItemRegistration.TANNIN_BUCKET.get(), "Tannin Bucket");
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
