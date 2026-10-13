package io.github.zephyrwolf.medievalism.data.base.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.PlayerStatsTrigger;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
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

import io.github.zephyrwolf.medievalism.data.base.lang.BaseAdvancementTranslations;

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

        AdvancementHolder hint_journal_tutorial = Advancement.Builder.advancement()
                .parent(medievalism_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_JOURNAL_TUTORIAL_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_JOURNAL_TUTORIAL_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("play_time", PlayerStatsTrigger.TriggerInstance.timePlayerInWorld(100))
                .save(saver, getNameId("main/hint_journal_tutorial"));

        AdvancementHolder hint_gather = Advancement.Builder.advancement()
                .parent(medievalism_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_GATHER_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_GATHER_DESC),
                        null,
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(saver, getNameId("main/hint_gather"));

        AdvancementHolder hint_survive = Advancement.Builder.advancement()
                .parent(medievalism_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_SURVIVE_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_SURVIVE_DESC),
                        null,
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(saver, getNameId("main/hint_survive"));

        AdvancementHolder found_rock = Advancement.Builder.advancement()
                .parent(hint_gather)
                .display(BlockRegistration.GREYWACKE_ROCK,
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_ROCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_rocks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.ROCK).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/found_rock"));

        AdvancementHolder found_large_rock = Advancement.Builder.advancement()
                .parent(hint_gather)
                .display(BlockRegistration.LARGE_GREYWACKE_ROCK,
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_LARGE_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_LARGE_ROCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_large_rocks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.LARGE_ROCK).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/found_large_rock"));

        AdvancementHolder found_stick = Advancement.Builder.advancement()
                .parent(hint_gather)
                .display(Items.STICK,
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_STICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_STICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.STICK).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/found_stick"));

        AdvancementHolder found_branch = Advancement.Builder.advancement()
                .parent(hint_gather)
                .display(BlockItemRegistration.OAK_BRANCH.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_BRANCH_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_BRANCH_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_branch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.BRANCH).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/found_branch"));

        AdvancementHolder found_clay_ball = Advancement.Builder.advancement()
                .parent(hint_gather)
                .display(Items.CLAY_BALL,
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_CLAYBALL_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_CLAYBALL_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_clayball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/found_clayball"));

        AdvancementHolder craft_wet_brick = Advancement.Builder.advancement()
                .parent(found_clay_ball)
                .display(BlockItemRegistration.WET_CLAY_BRICK,
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_WET_BRICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_WET_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.WET_BRICK).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/craft_wet_brick"));

        AdvancementHolder found_copper_rock = Advancement.Builder.advancement()
                .parent(hint_gather)
                .display(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE,
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_COPPER_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.FOUND_COPPER_ROCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_copper_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.COPPER_ROCK).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/found_copper_rock"));

        AdvancementHolder hint_inhand_knapping = Advancement.Builder.advancement()
                .parent(hint_survive)
                .display(BlockRegistration.GREYWACKE_ROCK,
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_INHAND_KNAPPING_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_INHAND_KNAPPING_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("can_knap", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item()
                                .of(ItemTagCatalog.HARD_ROCK)
                                .withCount(MinMaxBounds.Ints.atLeast(2))
                                .build()
                ))
                .save(saver, getNameId("main/hint_inhand_knapping"));

        AdvancementHolder craft_biface = Advancement.Builder.advancement()
                .parent(hint_inhand_knapping)
                .display(ItemRegistration.BIFACE.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_BIFACE_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_BIFACE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("craft_biface", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemRegistration.BIFACE).build()
                ))
                .save(saver, getNameId("main/craft_biface"));

        AdvancementHolder craft_lunate = Advancement.Builder.advancement()
                .parent(hint_inhand_knapping)
                .display(ItemRegistration.LUNATE.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_LUNATE_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_LUNATE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("craft_lunate", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemRegistration.LUNATE).build()
                ))
                .save(saver, getNameId("main/craft_lunate"));

        AdvancementHolder craft_stonebench = Advancement.Builder.advancement()
                .parent(hint_inhand_knapping)
                .display(BlockItemRegistration.STONE_BENCH.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_STONEBENCH_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.CRAFT_STONEBENCH_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("craft_stonebench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH.get()).build()
                ))
                .save(saver, getNameId("main/craft_stonebench"));

        AdvancementHolder hint_better_knapping = Advancement.Builder.advancement()
                .parent(hint_survive)
                .display(BlockItemRegistration.STONE_BENCH.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_BETTER_KNAPPING_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_BETTER_KNAPPING_DESC),
                        null,
                        AdvancementType.TASK, false, false, true)
                .addCriterion("can_knap", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH.get()).build()
                ))
                .save(saver, getNameId("main/hint_better_knapping"));

        AdvancementHolder hint_clay_forming = Advancement.Builder.advancement()
                .parent(hint_survive)
                .display(ItemRegistration.RED_CLAY_BALL.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_CLAY_FORMING_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_CLAY_FORMING_DESC),
                        null,
                        AdvancementType.TASK, false, false, true)
                .addCriterion("can_form_clay", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH.get()).build()
                ))
                .save(saver, getNameId("main/hint_clay_forming"));

        AdvancementHolder hint_weaving = Advancement.Builder.advancement()
                .parent(hint_survive)
                .display(BlockItemRegistration.DOGBANE_BLOCK_ITEM.get(),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_WEAVING_TITLE),
                        TextTools.getTranslation(BaseAdvancementTranslations.HINT_WEAVING_DESC),
                        null,
                        AdvancementType.TASK, false, false, true)
                .addCriterion("can_weave", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH.get()).build()
                ))
                .save(saver, getNameId("main/hint_weaving"));
    }

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
