package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.*;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;

public class MiscLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageProviderHandle handle)
    {
        addPackTranslations(handle);
        addNetworkingTranslations(handle);
    }

    private void addPackTranslations(LanguageProviderHandle handle)
    {
        handle.add("medievalism.pack.title.overhaul.client_resources", "Medievalism Overhaul - Looks");
        handle.add("medievalism.pack.title.overhaul.server_data", "Medievalism Overhaul - Progression");
        handle.add("medievalism.pack.source.overhaul", "Medievalism Overhaul Source");
    }

    private void addNetworkingTranslations(LanguageProviderHandle handle)
    {
        handle.add("medievalism.networking.failed", "Medievalism crashed you :(");
    }
}
