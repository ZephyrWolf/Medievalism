package io.github.zephyrwolf.medievalism.data.base.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BaseAdvancementsProviderCopperAge implements AdvancementProvider.AdvancementGenerator
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/advancement/FDAdvancementGenerator.java

    @SuppressWarnings("unused")
    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
    {
    }

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
