package io.github.zephyrwolf.medievalism.data.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.data.lang.BaseAdvancementTranslations;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.ItemLike;
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
        AdvancementHolder copper_age_root = Advancement.Builder.advancement()
                .display(BlockRegistration.COPPER_ROCK,
                        TextTools.getTranslation(BaseAdvancementTranslations.COPPER_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.COPPER_ROCK_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_copper_rock", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {
                        BlockRegistration.COPPER_ROCK.get()
                }))
                .save(saver, getNameId("copper_age/root"));
    }

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
