package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class WoodWorkingLangEntry implements ILanguageProviderEntry
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
        handle.addBlock(BlockRegistration.CHOPPING_BLOCK.get(), "Chopping Block");
    }

    private void addSoundTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.DIGGING_STICK.get(), "Digging Stick");
        handle.addItem(ItemRegistration.FIRE_STARTER.get(), "Fire Starter");
        handle.addItem(ItemRegistration.WHITE_BARK.get(), "White Bark");
        handle.addItem(ItemRegistration.BROWN_BARK.get(), "Brown Bark");
        handle.addItem(ItemRegistration.GREY_BARK.get(), "Grey Bark");
        handle.addItem(ItemRegistration.DARK_BROWN_BARK.get(), "Dark Brown Bark");
        handle.addItem(ItemRegistration.BLACK_BARK.get(), "Black Bark");
        handle.addItem(ItemRegistration.CHARCOAL_POWDER.get(), "Charcoal Powder");
        handle.addItem(ItemRegistration.POTASH.get(), "Potash");
        handle.addItem(ItemRegistration.CHOPPED_WOOD.get(), "Chopped Wood");
        handle.addItem(ItemRegistration.WOOD_ASH.get(), "Wood Ash");

        handle.addItem(ItemRegistration.TOOL_HANDLE.get(), "Tool Handle");
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
