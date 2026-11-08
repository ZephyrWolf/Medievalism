package io.github.zephyrwolf.medievalism.datagen.base.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.PlayerStatsTrigger;
import io.github.zephyrwolf.medievalism.datagen.base.lang.AdvancementLangKeys;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WorldItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class AdvancementsProviderClayWorking implements AdvancementProvider.AdvancementGenerator
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/advancement/FDAdvancementGenerator.java

    @SuppressWarnings("SameParameterValue")
    private String getNameId(String tech, String id)
    {
        return MedievalismConstants.MOD_ID + ":" + tech + "/" + id;
    }

    @SuppressWarnings("unused")
    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
    {
        AdvancementHolder clay_root = Advancement.Builder.advancement()
                .display(WorldItemRegistration.CLAY_IN_GRASS,
                        TextTools.getTranslation(AdvancementLangKeys.ROOT_CLAY_WORKING_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.ROOT_CLAY_WORKING_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, false, false, true)
                .addCriterion("has_clay", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build()
                ))
                .save(saver, getNameId("clay_working", "root"));

        AdvancementHolder found_clay_ball = Advancement.Builder.advancement()
                .parent(clay_root)
                .display(Items.CLAY_BALL,
                        TextTools.getTranslation(AdvancementLangKeys.ROOT_CLAY_WORKING_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.ROOT_CLAY_WORKING_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_clay", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build()
                ))
                .save(saver, getNameId("clay_working", "found_clay_ball"));

        AdvancementHolder craft_wet_bricks = Advancement.Builder.advancement()
                .parent(found_clay_ball)
                .display(ClayWorkingItemRegistration.DRYING_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_clay_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockRegistration.DRYING_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_bricks"));

        AdvancementHolder dry_wet_bricks = Advancement.Builder.advancement()
                .parent(craft_wet_bricks)
                .display(ClayWorkingItemRegistration.UNFIRED_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dry_clay_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_bricks"));
        // Roast em!

        AdvancementHolder craft_wet_double_bricks = Advancement.Builder.advancement()
                .parent(craft_wet_bricks)
                .display(ClayWorkingItemRegistration.DRYING_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_clay_double_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_double_bricks"));

        AdvancementHolder dry_wet_double_bricks = Advancement.Builder.advancement()
                .parent(craft_wet_double_bricks)
                .display(ClayWorkingItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dry_clay_double_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_double_bricks"));
        // Roast em

        AdvancementHolder craft_wet_potters_clay = Advancement.Builder.advancement()
                .parent(clay_root)
                .display(ClayWorkingItemRegistration.POTTERS_CLAY_BALL,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BALL_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BALL_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.POTTERS_CLAY_BALL).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_potters_clay"));

        AdvancementHolder craft_wet_potters_clay_brick = Advancement.Builder.advancement()
                .parent(craft_wet_potters_clay)
                .display(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_potters_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_potters_clay_brick"));

        AdvancementHolder dry_wet_potters_clay_brick = Advancement.Builder.advancement()
                .parent(craft_wet_potters_clay_brick)
                .display(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dry_potters_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_potters_clay_brick"));
        // Roast em

        AdvancementHolder craft_wet_potters_clay_double_brick = Advancement.Builder.advancement()
                .parent(craft_wet_potters_clay_brick)
                .display(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_POTTERS_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_POTTERS_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_potters_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_potters_clay_double_brick"));

        AdvancementHolder dry_wet_potters_clay_double_brick = Advancement.Builder.advancement()
                .parent(craft_wet_potters_clay_double_brick)
                .display(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_potters_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_potters_clay_double_brick"));
        // Roast em

        AdvancementHolder obtain_wet_kaolin_clay = Advancement.Builder.advancement()
                .parent(clay_root)
                .display(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL,
                        TextTools.getTranslation(AdvancementLangKeys.OBTAIN_KAOLIN_CLAY_BALL_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.OBTAIN_KAOLIN_CLAY_BALL_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_kaolin_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL).build()
                ))
                .save(saver, getNameId("clay_working", "obtain_wet_kaolin_clay"));

        AdvancementHolder craft_wet_kaolin_clay_brick = Advancement.Builder.advancement()
                .parent(obtain_wet_kaolin_clay)
                .display(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_KAOLIN_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_KAOLIN_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_kaolin_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_kaolin_clay_brick"));

        AdvancementHolder dry_wet_kaolin_clay_brick = Advancement.Builder.advancement()
                .parent(craft_wet_kaolin_clay_brick)
                .display(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dry_kaolin_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_kaolin_clay_brick"));
        // Roast em

        AdvancementHolder craft_wet_kaolin_clay_double_brick = Advancement.Builder.advancement()
                .parent(craft_wet_kaolin_clay_brick)
                .display(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_KAOLIN_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_KAOLIN_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_kaolin_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_kaolin_clay_double_brick"));

        AdvancementHolder dry_wet_kaolin_clay_double_brick = Advancement.Builder.advancement()
                .parent(craft_wet_kaolin_clay_double_brick)
                .display(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_kaolin_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_kaolin_clay_double_brick"));
        // Roast em

        AdvancementHolder craft_wet_refractory_clay = Advancement.Builder.advancement()
                .parent(clay_root)
                .display(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BALL_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BALL_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_refractory_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_refractory_clay"));

        AdvancementHolder craft_wet_refractory_clay_brick = Advancement.Builder.advancement()
                .parent(craft_wet_refractory_clay)
                .display(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_refractory_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_refractory_clay_brick"));

        AdvancementHolder dry_wet_refractory_clay_brick = Advancement.Builder.advancement()
                .parent(craft_wet_refractory_clay_brick)
                .display(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dry_refractory_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_refractory_clay_brick"));
        // Roast em

        AdvancementHolder craft_wet_refractory_clay_double_brick = Advancement.Builder.advancement()
                .parent(craft_wet_refractory_clay_brick)
                .display(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_REFRACTORY_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.CRAFT_WET_REFRACTORY_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_refractory_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "craft_wet_refractory_clay_double_brick"));

        AdvancementHolder dry_wet_refractory_clay_double_brick = Advancement.Builder.advancement()
                .parent(craft_wet_refractory_clay_double_brick)
                .display(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK,
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_DOUBLE_BRICK_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_DOUBLE_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_refractory_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK).build()
                ))
                .save(saver, getNameId("clay_working", "dry_wet_refractory_clay_double_brick"));
        // Roast em



        AdvancementHolder hint_better_pottery = Advancement.Builder.advancement()
                .parent(clay_root)
                .display(ItemRegistration.STONE_BENCH,
                        TextTools.getTranslation(AdvancementLangKeys.BETTER_POTTERY_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.BETTER_POTTERY_DESC),
                        null,
                        AdvancementType.TASK, false, false, true)
                .addCriterion("has_dry_potters_clay_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemRegistration.STONE_BENCH).build()
                ))
                .save(saver, getNameId("clay_working", "hint_better_pottery"));
    }
}
