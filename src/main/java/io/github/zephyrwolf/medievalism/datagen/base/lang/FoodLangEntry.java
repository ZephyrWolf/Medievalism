package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;

public class FoodLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageProviderHandle handle)
    {
        addFreshFoodTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addFreshFoodTranslations(LanguageProviderHandle handle)
    {
        handle.addBlock(BlockRegistration.YAMS.get(), "Yams");
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
