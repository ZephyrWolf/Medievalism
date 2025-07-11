package io.github.zephyrwolf.medievalism.data.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.BlockBreakTrigger;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.PlayerStatsTrigger;
import io.github.zephyrwolf.medievalism.data.lang.BaseAdvancementTranslations;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class OverhaulAdvancementsProvider implements AdvancementProvider.AdvancementGenerator
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/advancement/FDAdvancementGenerator.java

    @SuppressWarnings("unused")
    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
    {
        AdvancementHolder overhaul_root = Advancement.Builder.advancement()
                .display(Items.CRAFTING_TABLE,
                        TextTools.getTranslation(BaseAdvancementTranslations.OVERHAUL_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.OVERHAUL_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", PlayerStatsTrigger.TriggerInstance.timePlayerInWorld(0))
                .save(saver, getNameId("overhaul/root"));

        AdvancementHolder cant_punch_logs = Advancement.Builder.advancement()
                .parent(overhaul_root)
                .display(Items.IRON_AXE,
                        TextTools.getTranslation(BaseAdvancementTranslations.CANT_PUNCH_LOGS_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.CANT_PUNCH_LOGS_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("punch_log", BlockBreakTrigger.TriggerInstance.breakingWithEmptyHand(BlockPredicate.Builder.block().of(BlockTags.LOGS).build()))
                .save(saver, getNameId("overhaul/cant_punch_logs"));



    }

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
