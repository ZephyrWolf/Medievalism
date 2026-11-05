package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;

public class MiscLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addPackTranslations(handle);
        addNetworkingTranslations(handle);
    }

    private void addPackTranslations(LanguageEntryProviderHandle handle)
    {
        handle.add("medievalism.pack.title.overhaul.client_resources", "Medievalism Overhaul - Looks");
        handle.add("medievalism.pack.title.overhaul.server_data", "Medievalism Overhaul - Progression");
        handle.add("medievalism.pack.source.overhaul", "Medievalism Overhaul Source");
    }

    private void addNetworkingTranslations(LanguageEntryProviderHandle handle)
    {
        handle.add("medievalism.networking.failed", "Medievalism crashed you :(");
    }
}
