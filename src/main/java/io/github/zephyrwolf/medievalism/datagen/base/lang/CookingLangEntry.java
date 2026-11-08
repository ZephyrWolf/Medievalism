package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.CookingItemRegistration;
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
        handle.addItem(CookingItemRegistration.BAKED_BEETROOT.get(), "Baked Beetroot");
        handle.addItem(CookingItemRegistration.BAKED_CARROT.get(), "Baked Carrot");
        handle.addItem(CookingItemRegistration.BAKED_GARLIC.get(), "Baked Garlic");
        handle.addItem(CookingItemRegistration.BAKED_LEEK.get(), "Baked Leek");
        handle.addItem(CookingItemRegistration.BAKED_PARSNIP.get(), "Baked Parsnip");
        handle.addItem(CookingItemRegistration.PUMPKIN_SLICE.get(), "Pumpkin Slice");
        handle.addItem(CookingItemRegistration.GREEN_PUMPKIN_SLICE.get(), "Green Pumpkin Slice");
        handle.addItem(CookingItemRegistration.BAKED_PUMPKIN.get(), "Baked Pumpkin");
        handle.addItem(CookingItemRegistration.BAKED_GREEN_PUMPKIN.get(), "Baked Green Pumpkin");
        handle.addItem(CookingItemRegistration.BAKED_PUMPKIN_SLICE.get(), "Baked Pumpkin Slice");
        handle.addItem(CookingItemRegistration.BAKED_GREEN_PUMPKIN_SLICE.get(), "Baked Green Pumpkin Slice");
        handle.addItem(CookingItemRegistration.BAKED_PURPLE_CARROT.get(), "Baked Purple Carrot");
        handle.addItem(CookingItemRegistration.BAKED_PURPLE_ONION.get(), "Baked Purple Onion");
        handle.addItem(CookingItemRegistration.BAKED_PURPLE_SKIRRET.get(), "Baked Purple Skirret");
        handle.addItem(CookingItemRegistration.BAKED_RADISH.get(), "Baked Radish");
        handle.addItem(CookingItemRegistration.BAKED_SKIRRET.get(), "Baked Skirret");
        handle.addItem(CookingItemRegistration.BAKED_TURNIP.get(), "Baked Turnip");
        handle.addItem(CookingItemRegistration.BAKED_WHITE_CARROT.get(), "Baked White Carrot");
        handle.addItem(CookingItemRegistration.BAKED_WHITE_ONION.get(), "Baked White Onion");
        handle.addItem(CookingItemRegistration.BAKED_YAM.get(), "Baked Yam");

        handle.addItem(CookingItemRegistration.CRACKED_BARLEY.get(), "Cracked Barley");
        handle.addItem(CookingItemRegistration.CRACKED_WHEAT.get(), "Cracked Wheat");
        handle.addItem(CookingItemRegistration.ROLLED_OATS.get(), "Rolled Oats");
        handle.addItem(CookingItemRegistration.FLOUR.get(), "Flour");
        handle.addItem(CookingItemRegistration.DOUGH.get(), "Dough");
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
