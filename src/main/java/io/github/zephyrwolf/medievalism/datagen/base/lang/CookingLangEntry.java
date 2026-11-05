package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class CookingLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.CRACKED_BARLEY.get(), "Cracked Barley");
        handle.addItem(ItemRegistration.CRACKED_WHEAT.get(), "Cracked Wheat");
        handle.addItem(ItemRegistration.ROLLED_OATS.get(), "Rolled Oats");
        handle.addItem(ItemRegistration.FLOUR.get(), "Flour");
        handle.addItem(ItemRegistration.DOUGH.get(), "Dough");
        handle.addItem(ItemRegistration.BAKED_YAM.get(), "Baked Yam");
        handle.addItem(ItemRegistration.BAKED_BEETROOT.get(), "Baked Beetroot");
        handle.addItem(ItemRegistration.BAKED_CARROT.get(), "Baked Carrot");
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
