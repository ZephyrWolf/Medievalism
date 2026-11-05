package io.github.zephyrwolf.medievalism.common.data;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LanguageEntryProviderHandle
{
    private final LanguageProvider provider;
    private String modId;

    public LanguageEntryProviderHandle(LanguageProvider provider, String modId)
    {
        this.provider = provider;
        this.modId = modId;
    }

    public void setModId(String modId)
    {
        this.modId = modId;
    }

    public void addAdvancement(String key, String value) { provider.add(modId + "." + key, value); }
    public void addBlock(Block block, String value) { provider.add(block, value); }
    public void addBlock(Block block, String suffix, String value) { provider.add(block.getDescriptionId() + suffix, value); }
    public void addItem(Item item, String value) { provider.add(item, value); }
    public void add(String key, String value) { provider.add(key, value); }
}
