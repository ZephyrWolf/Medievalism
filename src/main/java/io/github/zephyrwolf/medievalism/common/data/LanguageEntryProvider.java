package io.github.zephyrwolf.medievalism.common.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Set;

public class LanguageEntryProvider extends LanguageProvider
{
    public static LanguageEntryProvider create(PackOutput pack, ILanguageProviderEntry ... entries)
    {
        return new LanguageEntryProvider(pack, Set.of(entries));
    }

    protected final Set<ILanguageProviderEntry> entries;
    protected final String modId;

    public LanguageEntryProvider(PackOutput output, Set<ILanguageProviderEntry> entries)
    {
        this(output, MedievalismConstants.MOD_ID, "en_US", entries);
    }

    public LanguageEntryProvider(PackOutput output, String modId, String locale, Set<ILanguageProviderEntry> entries)
    {
        super(output, modId, locale);
        this.entries = entries;
        this.modId = modId;
    }

    @Override
    protected void addTranslations()
    {
        for (ILanguageProviderEntry entry : entries)
        {
            LanguageProviderHandle handle = new LanguageProviderHandle(this, modId);
            entry.addTranslations(handle);
        }
    }
}
