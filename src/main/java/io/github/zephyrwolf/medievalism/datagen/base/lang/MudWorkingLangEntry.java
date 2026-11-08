package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.MudWorkingItemRegistration;

public class MudWorkingLangEntry implements ILanguageProviderEntry
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
        handle.addBlock(BlockRegistration.DRYING_PACKED_MUD.get(), "Drying Packed Mud");
        handle.addBlock(BlockRegistration.DRYING_DAUB_BLOCK.get(), "Drying Daub Block");
        handle.addBlock(BlockRegistration.DRYING_PACKED_MUD.get(), ".wet", "Wet Packed Mud");
        handle.addBlock(BlockRegistration.DRYING_DAUB_BLOCK.get(), ".wet", "Wet Daub Block");
        handle.addBlock(BlockRegistration.DRYING_PACKED_MUD.get(), ".dry", "Dry Packed Mud");
        handle.addBlock(BlockRegistration.DRYING_DAUB_BLOCK.get(), ".dry", "Dry Daub Block");

        handle.addBlock(BlockRegistration.DRYING_PACKED_MUD_BRICK.get(), "Drying Packed Mud Brick");
        handle.addBlock(BlockRegistration.DRYING_DAUB_BRICK.get(), "Drying Daub Brick");
        handle.addBlock(BlockRegistration.DRYING_PACKED_MUD_BRICK.get(), ".wet", "Wet Packed Mud Brick");
        handle.addBlock(BlockRegistration.DRYING_DAUB_BRICK.get(), ".wet", "Wet Daub Brick");
        handle.addBlock(BlockRegistration.DRYING_PACKED_MUD_BRICK.get(), ".dry", "Dry Packed Mud Brick");
        handle.addBlock(BlockRegistration.DRYING_DAUB_BRICK.get(), ".dry", "Dry Daub Brick");

        handle.addBlock(BlockRegistration.DAUB_BLOCK.get(), "Daub Block");
        handle.addBlock(BlockRegistration.DAUB_BRICKS.get(), "Daub Brick Block");
        handle.addBlock(BlockRegistration.CRACKED_DAUB_BLOCK.get(), "Cracked Daub Block");
        handle.addBlock(BlockRegistration.CRACKED_DAUB_BRICKS.get(), "Cracked Daub Brick Block");
    }

    private void addSoundTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(MudWorkingItemRegistration.DIRT_CHUNK.get(), "Dirt Chunk");
        handle.addItem(MudWorkingItemRegistration.MUD_BALL.get(), "Mud Ball");
        handle.addItem(MudWorkingItemRegistration.WET_DAUB.get(), "Wet Daub Ball");
        handle.addItem(MudWorkingItemRegistration.PACKED_MUD_BRICK.get(), "Packed Mud Brick");
        handle.addItem(MudWorkingItemRegistration.DAUB_BRICK.get(), "Daub Brick");
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
