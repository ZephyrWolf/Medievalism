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
        handle.addItem(ItemRegistration.BAKED_BEETROOT.get(), "Baked Beetroot");
        handle.addItem(ItemRegistration.BAKED_CARROT.get(), "Baked Carrot");
        handle.addItem(ItemRegistration.BAKED_GARLIC.get(), "Baked Garlic");
        handle.addItem(ItemRegistration.BAKED_LEEK.get(), "Baked Leek");
        handle.addItem(ItemRegistration.BAKED_PARSNIP.get(), "Baked Parsnip");
        handle.addItem(ItemRegistration.PUMPKIN_SLICE.get(), "Pumpkin Slice");
        handle.addItem(ItemRegistration.GREEN_PUMPKIN_SLICE.get(), "Green Pumpkin Slice");
        handle.addItem(ItemRegistration.BAKED_PUMPKIN.get(), "Baked Pumpkin");
        handle.addItem(ItemRegistration.BAKED_GREEN_PUMPKIN.get(), "Baked Green Pumpkin");
        handle.addItem(ItemRegistration.BAKED_PUMPKIN_SLICE.get(), "Baked Pumpkin Slice");
        handle.addItem(ItemRegistration.BAKED_GREEN_PUMPKIN_SLICE.get(), "Baked Green Pumpkin Slice");
        handle.addItem(ItemRegistration.BAKED_PURPLE_CARROT.get(), "Baked Purple Carrot");
        handle.addItem(ItemRegistration.BAKED_PURPLE_ONION.get(), "Baked Purple Onion");
        handle.addItem(ItemRegistration.BAKED_PURPLE_SKIRRET.get(), "Baked Purple Skirret");
        handle.addItem(ItemRegistration.BAKED_RADISH.get(), "Baked Radish");
        handle.addItem(ItemRegistration.BAKED_SKIRRET.get(), "Baked Skirret");
        handle.addItem(ItemRegistration.BAKED_TURNIP.get(), "Baked Turnip");
        handle.addItem(ItemRegistration.BAKED_WHITE_CARROT.get(), "Baked White Carrot");
        handle.addItem(ItemRegistration.BAKED_WHITE_ONION.get(), "Baked White Onion");
        handle.addItem(ItemRegistration.BAKED_YAM.get(), "Baked Yam");

        handle.addItem(ItemRegistration.CRACKED_BARLEY.get(), "Cracked Barley");
        handle.addItem(ItemRegistration.CRACKED_WHEAT.get(), "Cracked Wheat");
        handle.addItem(ItemRegistration.ROLLED_OATS.get(), "Rolled Oats");
        handle.addItem(ItemRegistration.FLOUR.get(), "Flour");
        handle.addItem(ItemRegistration.DOUGH.get(), "Dough");
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
