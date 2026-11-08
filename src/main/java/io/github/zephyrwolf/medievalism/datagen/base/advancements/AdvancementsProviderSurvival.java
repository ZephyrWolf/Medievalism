package io.github.zephyrwolf.medievalism.datagen.base.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.PlayerStatsTrigger;
import io.github.zephyrwolf.medievalism.registration.item.*;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import io.github.zephyrwolf.medievalism.datagen.base.lang.AdvancementLangKeys;

@SuppressWarnings("unused")
public class AdvancementsProviderSurvival implements AdvancementProvider.AdvancementGenerator
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
        AdvancementHolder stone_age_root = Advancement.Builder.advancement()
                .display(Blocks.CAMPFIRE,
                        TextTools.getTranslation(AdvancementLangKeys.ROOT_STONE_AGE_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.ROOT_STONE_AGE_DESC),
                        MedievalismConstants.resource("textures/gui/advancements/paper.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", PlayerStatsTrigger.TriggerInstance.timePlayerInWorld(0))
                .save(saver, getNameId("stone_age", "root"));

        AdvancementHolder hint_journal_tutorial = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_JOURNAL_TUTORIAL_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_JOURNAL_TUTORIAL_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("play_time", PlayerStatsTrigger.TriggerInstance.timePlayerInWorld(100))
                .save(saver, getNameId("stone_age", "hint_journal_tutorial"));
        //about(hint_journal_tutorial, saver);

        AdvancementHolder hint_survive = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_SURVIVE_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_SURVIVE_DESC),
                        null,
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(saver, getNameId("stone_age", "hint_survive"));
        //survive(hint_survive, saver);

        AdvancementHolder hint_gather = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(Items.BOOK,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_GATHER_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_GATHER_DESC),
                        null,
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(saver, getNameId("stone_age", "hint_gather"));
        //gather(hint_gather, saver);

        AdvancementHolder hint_inhand_knapping = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(WorldItemRegistration.GREYWACKE_ROCK,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_INHAND_KNAPPING_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_INHAND_KNAPPING_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_hard_rocks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.HARD_ROCK)
                ))
                .save(saver, getNameId("stone_age", "hint_inhand_knapping"));
        //knapping(hint_inhand_knapping, saver);

        AdvancementHolder hint_clay_works = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(Items.CLAY_BALL,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_CLAY_WORKS_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_CLAY_WORKS_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_clay", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("survival", "hint_clay_works"));
        //clayWorks(hint_clay_works, saver);

        AdvancementHolder hint_mud_works = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(MudWorkingItemRegistration.MUD_BALL,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_MUD_WORKS_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_MUD_WORKS_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_mud_block", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.MUD).build()
                ))
                .addCriterion("has_mud_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudWorkingItemRegistration.MUD_BALL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "hint_mud_works"));
        //mudWorks(hint_mud_works, saver);

        /*
        AdvancementHolder hint_carving = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(ItemRegistration.ROCK_KNIFE.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_CARVING_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_CARVING_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH.get()).build()
                ))
                .addCriterion("has_carving_tool", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CARVING_TOOL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "hint_carving"));
        //carving(hint_carving, saver);

        AdvancementHolder hint_weaving = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(BlockItemRegistration.DOGBANE.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_WEAVING_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_WEAVING_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH.get()).build()
                ))
                .addCriterion("has_dogbane", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CANE).build()
                ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "hint_weaving"));
        //weaving(hint_weaving, saver);


        AdvancementHolder plant_cutting = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(ItemRegistration.ROCK_KNIFE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_PLANT_CUTTING_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_PLANT_CUTTING_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_knife", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.PLANT_CUTTING_TOOL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "hint_plant_cutting"));
        //plantCutting(plant_cutting, saver);
         */

        AdvancementHolder hint_bark_stripping = Advancement.Builder.advancement()
                .parent(stone_age_root)
                .display(Items.STONE_AXE,
                        TextTools.getTranslation(AdvancementLangKeys.HINT_AXE_STRIPPING_TITLE),
                        TextTools.getTranslation(AdvancementLangKeys.HINT_AXE_STRIPPING_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_axe", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "hint_bark_stripping"));
        //barkStripping(hint_bark_stripping, saver);
    }

    /*
    public void about(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {

    }

    public void survive(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        AdvancementHolder hint_craft_fire_Starter = Advancement.Builder.advancement()
                .parent(parent)
                .display(WoodItemRegistration.FIRE_STARTER,
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_CRAFT_FIRE_STARTER_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_CRAFT_FIRE_STARTER_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_twig", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.TWIG).build()
                ))
                .addCriterion("has_carving", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CARVING_TOOL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "hint_craft_fire_starter"));
        AdvancementHolder hint_build_campfire = Advancement.Builder.advancement()
                .parent(hint_craft_fire_Starter)
                .display(Blocks.CAMPFIRE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_BUILD_CAMPFIRE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_BUILD_CAMPFIRE_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_thatch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.TINDER).build()
                ))
                .addCriterion("has_twigs", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.TWIG).withCount(MinMaxBounds.Ints.atLeast(4)).build()
                ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "build_campfire"));
        AdvancementHolder light_torches = Advancement.Builder.advancement()
                .parent(hint_build_campfire)
                .display(Items.TORCH,
                        TextTools.getTranslation(BaseAdvancementLangKeys.LIGHT_TORCHES_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.LIGHT_TORCHES_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_torch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.TORCH).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "light_torches"));
        AdvancementHolder cook_food_on_campfire = Advancement.Builder.advancement()
                .parent(hint_build_campfire)
                .display(FoodItemRegistration.BAKED_YAM,
                        TextTools.getTranslation(BaseAdvancementLangKeys.COOK_FOOD_ON_CAMPFIRE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.COOK_FOOD_ON_CAMPFIRE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("clicked_on_campfire", CriteriaTriggers.ITEM_USED_ON_BLOCK.createCriterion(
                            new ItemUsedOnLocationTrigger.TriggerInstance(
                                    Optional.of(ContextAwarePredicate.create(
                                            MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTagCatalog.FOOD_CAN_BE_COOKED_IN_CAMPFIRE)).build()
                                    )),
                                    Optional.of(ContextAwarePredicate.create(
                                            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CAMPFIRE).build()
                                    ))
                            )
                        ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "cook_food_on_campfire"));
        AdvancementHolder cook_lime_on_campfire = Advancement.Builder.advancement() // TODO This needs to move somewhere better
                .parent(hint_build_campfire)
                .display(RockItemRegistration.QUICK_LIME,
                        TextTools.getTranslation(BaseAdvancementLangKeys.COOK_LIME_ON_CAMPFIRE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.COOK_LIME_ON_CAMPFIRE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("clicked_on_campfire", CriteriaTriggers.ITEM_USED_ON_BLOCK.createCriterion(
                        new ItemUsedOnLocationTrigger.TriggerInstance(
                                Optional.of(ContextAwarePredicate.create(
                                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(BlockItemRegistration.LIMESTONE_ROCK)).build()
                                )),
                                Optional.of(ContextAwarePredicate.create(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CAMPFIRE).build()
                                ))
                        )
                ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "cook_lime_on_campfire"));
    }

    public void gather(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        AdvancementHolder found_stick = Advancement.Builder.advancement()
                .parent(parent)
                .display(Items.STICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_STICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_STICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.TWIG).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_stick"));

        AdvancementHolder found_branch = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockItemRegistration.OAK_BRANCH.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_BRANCH_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_BRANCH_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_branch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.BRANCH).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_branch"));

        AdvancementHolder found_clay_ball = Advancement.Builder.advancement()
                .parent(parent)
                .display(Items.CLAY_BALL,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_CLAY_BALL_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_CLAY_BALL_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_clay_ball"));

        AdvancementHolder found_rock = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockRegistration.GREYWACKE_ROCK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_ROCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.ROCK).build()
                ))
                .addCriterion("has_large_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.LARGE_ROCK).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_rock"));

        AdvancementHolder found_hard_rock = Advancement.Builder.advancement()
                .parent(found_rock)
                .display(BlockRegistration.SAPROLITE_ROCK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_HARD_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_HARD_ROCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_hard_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.HARD_ROCK).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_hard_rock"));

        AdvancementHolder found_copper_rock = Advancement.Builder.advancement()
                .parent(found_rock)
                .display(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_COPPER_ROCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_COPPER_ROCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_copper_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.COPPER_ROCK).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_copper_rock"));

        AdvancementHolder found_dogbane = Advancement.Builder.advancement()
                .parent(found_rock)
                .display(BlockItemRegistration.DOGBANE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_DOGBANE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_DOGBANE_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_dogbane", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.DOGBANE).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_dogbane"));
        // TODO Flax and fiber

        AdvancementHolder found_mud = Advancement.Builder.advancement()
                .parent(parent)
                .display(MudItemRegistration.MUD_BALL,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_MUD_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_MUD_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_mud_block", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.MUD).build()
                ))
                .addCriterion("has_mud_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudItemRegistration.MUD_BALL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_mud"));

        AdvancementHolder found_dirt = Advancement.Builder.advancement()
                .parent(parent)
                .display(Items.DIRT,
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_DIRT_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.FOUND_DIRT_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.DIRT).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "found_dirt"));

        AdvancementHolder craft_dirt_chunks = Advancement.Builder.advancement()
                .parent(found_dirt)
                .display(MudItemRegistration.DIRT_CHUNK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_DIRT_CHUNK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_DIRT_CHUNK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dirt_chunk", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudItemRegistration.DIRT_CHUNK).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "craft_dirt_chunks"));

        AdvancementHolder craft_mud_balls = Advancement.Builder.advancement()
                .parent(craft_dirt_chunks)
                .display(MudItemRegistration.MUD_BALL,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_MUD_BALL_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_MUD_BALL_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_mud_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudItemRegistration.MUD_BALL).build()
                ))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "craft_mud_balls"));
    }

    public void mudWorks(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        // Making Mud
        // TODO
        // Packed Mud
        AdvancementHolder craft_wet_packed_mud_block = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockRegistration.WET_PACKED_MUD,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_PACKED_MUD_BLOCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_PACKED_MUD_BLOCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_packed_mud_block", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockRegistration.WET_PACKED_MUD).build())
                )
                .save(saver, getNameId("stone_age", "craft_mud_block"));
        AdvancementHolder craft_packed_mud_block = Advancement.Builder.advancement()
                .parent(craft_wet_packed_mud_block)
                .display(Blocks.PACKED_MUD,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_PACKED_MUD_BLOCK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_PACKED_MUD_BLOCK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_packed_mud_block", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Blocks.PACKED_MUD).build())
                )
                .save(saver, getNameId("stone_age", "craft_packed_mud_block"));
        // Packed Mud Bricks
        AdvancementHolder craft_wet_packed_mud = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockItemRegistration.WET_PACKED_MUD,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_PACKED_MUD_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_PACKED_MUD_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_packed_mud", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.WET_PACKED_MUD).build())
                )
                .save(saver, getNameId("stone_age", "craft_wet_packed_mud"));
        AdvancementHolder craft_wet_mud_brick = Advancement.Builder.advancement()
                .parent(craft_wet_packed_mud)
                .display(MudItemRegistration.PACKED_MUD_BRICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_PACKED_MUD_BRICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_PACKED_MUD_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_packed_mud_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.WET_PACKED_MUD_BRICK).build())
                )
                .save(saver, getNameId("stone_age", "craft_wet_packed_mud_brick"));
        AdvancementHolder craft_packed_mud_brick = Advancement.Builder.advancement()
                .parent(craft_wet_mud_brick)
                .display(MudItemRegistration.PACKED_MUD_BRICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_PACKED_MUD_BRICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_PACKED_MUD_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_packed_mud_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudItemRegistration.PACKED_MUD_BRICK).build())
                )
                .save(saver, getNameId("stone_age", "craft_packed_mud_brick"));
        AdvancementHolder craft_packed_mud_bricks = Advancement.Builder.advancement()
                .parent(craft_packed_mud_brick)
                .display(Blocks.MUD_BRICKS,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_PACKED_MUD_BRICKS_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_PACKED_MUD_BRICKS_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_packed_mud_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Blocks.MUD_BRICKS).build())
                )
                .save(saver, getNameId("stone_age", "craft_packed_mud_bricks"));
        // Daub Bricks
        AdvancementHolder craft_daub = Advancement.Builder.advancement()
                .parent(parent)
                .display(MudItemRegistration.WET_DAUB,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_DAUB_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_DAUB_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_daub", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudItemRegistration.WET_DAUB).build())
                )
                .save(saver, getNameId("stone_age", "craft_wet_daub"));
        AdvancementHolder craft_wet_daub_brick = Advancement.Builder.advancement()
                .parent(craft_daub)
                .display(BlockItemRegistration.WET_DAUB_BRICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_DAUB_BRICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_DAUB_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_daub_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.WET_DAUB_BRICK).build())
                )
                .save(saver, getNameId("stone_age", "craft_wet_daub_bricks"));
        AdvancementHolder craft_daub_brick = Advancement.Builder.advancement()
                .parent(craft_wet_daub_brick)
                .display(MudItemRegistration.DAUB_BRICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_DAUB_BRICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_DAUB_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_daub_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(MudItemRegistration.DAUB_BRICK).build())
                )
                .save(saver, getNameId("stone_age", "craft_daub_brick"));
        AdvancementHolder craft_daub_bricks = Advancement.Builder.advancement()
                .parent(craft_daub_brick)
                .display(BlockItemRegistration.DAUB_BRICKS,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_DAUB_BRICKS_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_DAUB_BRICKS_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_daub_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.DAUB_BRICKS).build())
                )
                .save(saver, getNameId("stone_age", "craft_daub_bricks"));
    }

    public void clayWorks(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        // Inhand
        AdvancementHolder craft_wet_brick = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockItemRegistration.WET_CLAY_BRICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_BRICK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CRAFT_WET_BRICK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_wet_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.WET_CLAY_BRICK).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "craft_wet_brick"));

        AdvancementHolder hint_clay_drying = Advancement.Builder.advancement()
                .parent(craft_wet_brick)
                .display(ClayItemRegistration.UNFIRED_BLUE_CLAY_BRICK,
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_CLAY_DRYING_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_CLAY_DRYING_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_dry_brick", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.UNFIRED_POTTERY).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "hint_clay_drying"));

        // Stone Bench
        AdvancementHolder better_pottery = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockItemRegistration.STONE_BENCH,
                        TextTools.getTranslation(BaseAdvancementLangKeys.BETTER_POTTERY_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.BETTER_POTTERY_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_clay", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build())
                )
                .addCriterion("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH).build())
                )
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(saver, getNameId("stone_age", "better_pottery"));

        // Different clay craftables
        // TODO
    }

    public void knapping(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        // Inhand Knapping
        AdvancementHolder inhand_knap_biface = Advancement.Builder.advancement()
                .parent(parent)
                .display(RockItemRegistration.BIFACE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.INHAND_KNAP_BIFACE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.INHAND_KNAP_BIFACE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_biface", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(RockItemRegistration.BIFACE).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "inhand_knap_biface"));

        AdvancementHolder inhand_knap_lunate = Advancement.Builder.advancement()
                .parent(parent)
                .display(RockItemRegistration.LUNATE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.INHAND_KNAP_LUNATE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.INHAND_KNAP_LUNATE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_lunate", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(RockItemRegistration.LUNATE).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "inhand_knap_lunate"));

        AdvancementHolder inhand_knap_stone_bench = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockRegistration.STONE_BENCH,
                        TextTools.getTranslation(BaseAdvancementLangKeys.INHAND_KNAP_STONE_BENCH_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.INHAND_KNAP_STONE_BENCH_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.STONE_BENCH).build()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "inhand_knap_stone_bench"));
        betterKnapping(inhand_knap_stone_bench, saver);
    }

    public void betterKnapping(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        AdvancementHolder knap_rock_knife_blade = Advancement.Builder.advancement()
                .parent(parent)
                .display(RockItemRegistration.ROCK_KNIFE_BLADE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.KNAP_ROCK_KNIFE_BLADE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.KNAP_ROCK_KNIFE_BLADE_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_rock_knife_blade", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(RockItemRegistration.ROCK_KNIFE_BLADE).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "knap_rock_knife_blade"));
        AdvancementHolder knap_flint_knife_blade = Advancement.Builder.advancement()
                .parent(knap_rock_knife_blade)
                .display(FlintItemRegistration.FLINT_KNIFE_BLADE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.KNAP_FLINT_KNIFE_BLADE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.KNAP_FLINT_KNIFE_BLADE_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_flint_knife_blade", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(FlintItemRegistration.FLINT_KNIFE_BLADE).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "knap_flint_knife_blade"));
        AdvancementHolder knap_rock_axe_head = Advancement.Builder.advancement()
                .parent(parent)
                .display(RockItemRegistration.ROCK_AXE_HEAD,
                        TextTools.getTranslation(BaseAdvancementLangKeys.KNAP_ROCK_AXE_HEAD_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.KNAP_ROCK_AXE_HEAD_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_rock_axe_head", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(RockItemRegistration.ROCK_AXE_HEAD).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "knap_rock_axe_head"));
    }

    public void carving(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        AdvancementHolder knap_bone_knife_blade = Advancement.Builder.advancement()
                .parent(parent)
                .display(BoneItemRegistration.BONE_KNIFE_BLADE,
                        TextTools.getTranslation(BaseAdvancementLangKeys.CARVE_BONE_KNIFE_BLADE_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.CARVE_BONE_KNIFE_BLADE_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_bone_knife_blade", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BoneItemRegistration.BONE_KNIFE_BLADE).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "knap_bone_knife_blade"));
    }

    public void plantCutting(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        AdvancementHolder harvest_thatch = Advancement.Builder.advancement()
                .parent(parent)
                .display(BlockItemRegistration.THATCH,
                        TextTools.getTranslation(BaseAdvancementLangKeys.HARVEST_THATCH_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HARVEST_THATCH_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_thatch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(BlockItemRegistration.THATCH).build())
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("stone_age", "harvest_thatch"));
    }

    public void weaving(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {

    }

    public void barkStripping(@NotNull AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver)
    {
        AdvancementHolder hint_stripped_bark = Advancement.Builder.advancement()
                .parent(parent)
                .display(Items.OAK_LOG,
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_STRIPPED_BARK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HINT_STRIPPED_BARK_DESC),
                        null,
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_bark", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.BARK).build()
                ))
                .save(saver, getNameId("stone_age", "stripped_bark"));
        AdvancementHolder stripped_white_bark = Advancement.Builder.advancement()
                .parent(hint_stripped_bark)
                .display(WoodItemRegistration.WHITE_BARK.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_WHITE_BARK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_WHITE_BARK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_white_bark", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(WoodItemRegistration.WHITE_BARK.get()).build()
                ))
                .save(saver, getNameId("stone_age", "stripped_white_bark"));
        AdvancementHolder stripped_grey_bark = Advancement.Builder.advancement()
                .parent(hint_stripped_bark)
                .display(WoodItemRegistration.GREY_BARK.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_GREY_BARK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_GREY_BARK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_grey_bark", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(WoodItemRegistration.GREY_BARK.get()).build()
                ))
                .save(saver, getNameId("stone_age", "stripped_grey_bark"));
        AdvancementHolder stripped_brown_bark = Advancement.Builder.advancement()
                .parent(hint_stripped_bark)
                .display(WoodItemRegistration.BROWN_BARK.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_BROWN_BARK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_BROWN_BARK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_brown_bark", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(WoodItemRegistration.BROWN_BARK.get()).build()
                ))
                .save(saver, getNameId("stone_age", "stripped_brown_bark"));
        AdvancementHolder stripped_dark_brown_bark = Advancement.Builder.advancement()
                .parent(hint_stripped_bark)
                .display(WoodItemRegistration.DARK_BROWN_BARK.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_DARK_BROWN_BARK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_DARK_BROWN_BARK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_dark_brown_bark", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(WoodItemRegistration.DARK_BROWN_BARK.get()).build()
                ))
                .save(saver, getNameId("stone_age", "stripped_dark_brown_bark"));
        AdvancementHolder stripped_black_bark = Advancement.Builder.advancement()
                .parent(hint_stripped_bark)
                .display(WoodItemRegistration.BLACK_BARK.get(),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_BLACK_BARK_TITLE),
                        TextTools.getTranslation(BaseAdvancementLangKeys.HAS_BLACK_BARK_DESC),
                        null,
                        AdvancementType.TASK, true, false, true)
                .addCriterion("has_black_bark", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(WoodItemRegistration.BLACK_BARK.get()).build()
                ))
                .save(saver, getNameId("stone_age", "stripped_black_bark"));
    }

     */
}
