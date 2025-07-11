package io.github.zephyrwolf.medievalism.data.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.data.lang.BaseAdvancementTranslations;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BaseAdvancementsProviderStoneAge implements AdvancementProvider.AdvancementGenerator
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/advancement/FDAdvancementGenerator.java

    @SuppressWarnings("unused")
    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
    {
        AdvancementHolder stone_age_root = Advancement.Builder.advancement()
                .display(BlockRegistration.LARGE_ROCK,
                        TextTools.getTranslation(BaseAdvancementTranslations.ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.ROCK_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_rocks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item()
                                .of(ItemTagCatalog.ROCK)
                                .of(ItemTagCatalog.LARGE_ROCK)
                                .build()
                ))
                .save(saver, getNameId("stone_age/rock"));

        AdvancementHolder two_hard_rocks = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(BlockRegistration.ROCK,
                        TextTools.getTranslation(BaseAdvancementTranslations.TWO_HARD_ROCKS_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.TWO_HARD_ROCKS_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_two_hard_rocks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item()
                                .of(ItemTagCatalog.HARD_ROCK)
                                .withCount(MinMaxBounds.Ints.atLeast(2))
                                .build()
                ))
                .save(saver, getNameId("stone_age/two_hard_rocks"));
    }

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
