package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.StoneBenchBlock;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;

public class WoodLangEntry implements ILanguageProviderEntry
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
        // BRANCH
        handle.addBlockItem(BlockItemRegistration.OAK_BRANCH.get(), "Oak Branch");
        handle.addBlockItem(BlockItemRegistration.BIRCH_BRANCH.get(), "Birch Branch");
        handle.addBlockItem(BlockItemRegistration.SPRUCE_BRANCH.get(), "Spruce Branch");
        handle.addBlockItem(BlockItemRegistration.JUNGLE_BRANCH.get(), "Jungle Branch");
        handle.addBlockItem(BlockItemRegistration.DARK_OAK_BRANCH.get(), "Dark Oak Branch");
        handle.addBlockItem(BlockItemRegistration.ACACIA_BRANCH.get(), "Acacia Branch");
        handle.addBlockItem(BlockItemRegistration.MANGROVE_BRANCH.get(), "Mangrove Branch");
        handle.addBlockItem(BlockItemRegistration.CHERRY_BRANCH.get(), "Cherry Branch");

        handle.addBlockItem(BlockItemRegistration.CHOPPING_BLOCK.get(), "Chopping Block");
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
