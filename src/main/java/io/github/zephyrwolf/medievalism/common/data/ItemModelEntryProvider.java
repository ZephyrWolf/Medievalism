package io.github.zephyrwolf.medievalism.common.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Set;

public class ItemModelEntryProvider extends ItemModelProvider
{
    public static ItemModelEntryProvider create(PackOutput pack, ExistingFileHelper fileHelper, IItemModelProviderEntry... entries)
    {
        return new ItemModelEntryProvider(pack, fileHelper, Set.of(entries));
    }

    protected Set<IItemModelProviderEntry> entries;
    protected final String modId;

    public ItemModelEntryProvider(PackOutput output, ExistingFileHelper existingFileHelper, Set<IItemModelProviderEntry> entries)
    {
        this(output, existingFileHelper, MedievalismConstants.MOD_ID, entries);
    }

    public ItemModelEntryProvider(PackOutput output, ExistingFileHelper existingFileHelper, String modId, Set<IItemModelProviderEntry> entries)
    {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
        this.entries = entries;
        this.modId = modId;
    }

    @Override
    protected void registerModels()
    {
        for (IItemModelProviderEntry entry : entries)
        {
            ItemModelEntryProviderHandle handle = new ItemModelEntryProviderHandle(this, modId);
            entry.registerModels(handle);
        }
    }
}
