package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class BoneLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addSoundTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageProviderHandle handle)
    {
    }

    private void addBlockItemTranslations(LanguageProviderHandle handle)
    {
    }

    private void addSoundTranslations(LanguageProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageProviderHandle handle)
    {
        handle.addItem(ItemRegistration.BROKEN_GOAT_HORN.get(), "Broken Goat Horn");
    }

    private void addCreativeTabTranslations(LanguageProviderHandle handle)
    {
    }

    private void addGUITranslations(LanguageProviderHandle handle)
    {
    }

    private void addTooltipTranslations(LanguageProviderHandle handle)
    {
    }
}
