package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class MudLangEntry implements ILanguageProviderEntry
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
        handle.addBlockItem(BlockItemRegistration.WET_PACKED_MUD.get(), "Wet Packed Mud");
        handle.addBlockItem(BlockItemRegistration.WET_DAUB_BLOCK.get(), "Wet Daub Block");
        handle.addBlockItem(BlockItemRegistration.DAUB_BLOCK.get(), "Daub Block");
        handle.addBlockItem(BlockItemRegistration.DAUB_BRICKS.get(), "Daub Brick Block");
        handle.addBlockItem(BlockItemRegistration.CRACKED_DAUB_BLOCK.get(), "Cracked Daub Block");
        handle.addBlockItem(BlockItemRegistration.CRACKED_DAUB_BRICKS.get(), "Cracked Daub Brick Block");
        handle.addBlockItem(BlockItemRegistration.WET_PACKED_MUD_BRICK.get(), "Wet Packed Mud Brick");
        handle.addBlockItem(BlockItemRegistration.WET_DAUB_BRICK.get(), "Wet Daub Brick");
    }

    private void addSoundTranslations(LanguageProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageProviderHandle handle)
    {
        handle.addItem(ItemRegistration.DIRT_CHUNK.get(), "Dirt Chunk");
        handle.addItem(ItemRegistration.MUD_BALL.get(), "Mud Ball");
        handle.addItem(ItemRegistration.WET_DAUB.get(), "Wet Daub Ball");
        handle.addItem(ItemRegistration.PACKED_MUD_BRICK.get(), "Packed Mud Brick");
        handle.addItem(ItemRegistration.DAUB_BRICK.get(), "Daub Brick");
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
