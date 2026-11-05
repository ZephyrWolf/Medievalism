package io.github.zephyrwolf.medievalism.common.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Set;

public class BlockStateEntryProvider extends BlockStateProvider
{
    public static BlockStateEntryProvider create(PackOutput pack, ExistingFileHelper fileHelper, IBlockStateProviderEntry... entries)
    {
        return new BlockStateEntryProvider(pack, fileHelper, Set.of(entries));
    }

    protected Set<IBlockStateProviderEntry> entries;
    protected final String modId;

    public BlockStateEntryProvider(PackOutput output, ExistingFileHelper existingFileHelper, Set<IBlockStateProviderEntry> entries)
    {
        this(output, existingFileHelper, MedievalismConstants.MOD_ID, entries);
    }

    public BlockStateEntryProvider(PackOutput output, ExistingFileHelper existingFileHelper, String modId, Set<IBlockStateProviderEntry> entries)
    {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
        this.entries = entries;
        this.modId = modId;
    }

    @Override
    protected void registerStatesAndModels()
    {
        for (IBlockStateProviderEntry entry : entries)
        {
            BlockStateEntryProviderHandle handle = new BlockStateEntryProviderHandle(this, modId);
            entry.registerModels(handle);
        }
    }
}
