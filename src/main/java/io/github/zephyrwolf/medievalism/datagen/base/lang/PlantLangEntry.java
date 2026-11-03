package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;

public class PlantLangEntry implements ILanguageProviderEntry
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
        handle.addBlock(BlockRegistration.FIRE_LAY.get(), "Thatch"); // TODO Seperate firelay and thatch names
    }

    private void addBlockItemTranslations(LanguageProviderHandle handle)
    {
        handle.addBlockItem(BlockItemRegistration.SHRUB.get(), "Shrub");
        handle.addBlockItem(BlockItemRegistration.THATCH_BLOCK.get(), "Thatch Block");
    }

    private void addSoundTranslations(LanguageProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageProviderHandle handle)
    {
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
