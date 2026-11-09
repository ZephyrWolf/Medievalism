package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.WeavingItemRegistration;

public class WeavingLangEntry implements ILanguageProviderEntry
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
        handle.addItem(WeavingItemRegistration.FLAX_FIBER.get(), "Flax Fiber");
        handle.addItem(WeavingItemRegistration.SPLIT_SOFT_RUSH.get(), "Split Soft Rush");
        handle.addItem(WeavingItemRegistration.PRIMITIVE_CORDAGE.get(), "Primitive Cordage");
        handle.addItem(WeavingItemRegistration.GREEN_BAST_FIBERS.get(), "Green Bast Fibers");
        handle.addItem(WeavingItemRegistration.DRY_BAST_FIBERS.get(), "Dry Bast Fibers");
        handle.addItem(WeavingItemRegistration.BAST_CORDAGE.get(), "Bast Cordage");
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
