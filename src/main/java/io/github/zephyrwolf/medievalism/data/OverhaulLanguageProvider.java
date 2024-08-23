package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class OverhaulLanguageProvider extends LanguageProvider
{
    public OverhaulLanguageProvider(PackOutput output, String locale)
    {
        super(output, MedievalismConstants.MOD_ID, locale);
    }

    @Override
    protected void addTranslations()
    {
        add(Items.LEATHER, "Large Leather");
        // Limonite, etc.
    }
}
