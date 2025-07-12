package io.github.zephyrwolf.medievalism.data.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.PlayerStatsTrigger;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import io.github.zephyrwolf.medievalism.data.lang.BaseAdvancementTranslations;

public class BaseAdvancementsProvider implements AdvancementProvider.AdvancementGenerator
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/advancement/FDAdvancementGenerator.java

    @SuppressWarnings("unused")
    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
    {
        AdvancementHolder medievalism_root = Advancement.Builder.advancement()
                .display(Blocks.CAMPFIRE,
                        TextTools.getTranslation(BaseAdvancementTranslations.ROOT_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.ROOT_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", PlayerStatsTrigger.TriggerInstance.timePlayerInWorld(0))
                .save(saver, getNameId("main/root"));

        AdvancementHolder explore_gather = Advancement.Builder.advancement()
                .parent(medievalism_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(BaseAdvancementTranslations.EXPLORE_GATHER_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.EXPLORE_GATHER_DESC),
                        null,
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(saver, getNameId("main/explore_gather"));

        AdvancementHolder journal_tutorial = Advancement.Builder.advancement()
                .parent(medievalism_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(BaseAdvancementTranslations.JOURNAL_TUTORIAL_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.JOURNAL_TUTORIAL_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)

                .addCriterion("play_time", PlayerStatsTrigger.TriggerInstance.timePlayerInWorld(100))
                .save(saver, getNameId("main/journal_tutorial"));

        AdvancementHolder red_clay_pun = Advancement.Builder.advancement()
                .parent(medievalism_root)
                .display(ItemRegistration.RED_CLAY_BALL.get(),
                        TextTools.getTranslation("advancement.get_red_clay"),
                        TextTools.getTranslation("advancement.get_red_clay.desc"),
                        null,
                        AdvancementType.TASK, false, false, true)
                .addCriterion("red_clay_balls", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.RED_CLAY_BALL.get()))
                .addCriterion("red_clay_block", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistration.RED_CLAY.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/get_red_clay"));
    }

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
