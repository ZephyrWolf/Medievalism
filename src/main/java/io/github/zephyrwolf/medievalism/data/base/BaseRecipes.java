package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
import io.github.zephyrwolf.medievalism.common.item.ModItemTags;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeBuilder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BaseRecipes extends RecipeProvider
{

    public BaseRecipes(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    public void tempRecipes(@NotNull RecipeOutput recipeOutput)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.HAMMERSTONE.get())
                .requires(ModItemTags.ROCK)
                .unlockedBy("has_rock",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.ROCK).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "hammerstone"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.LUNATE.get())
                .requires(ModItemTags.ROCK)
                .requires(Registration.HAMMERSTONE)
                .unlockedBy("has_rock",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.ROCK).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "lunate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.BIFACE.get())
                .requires(ModItemTags.LARGE_ROCK)
                .requires(Registration.HAMMERSTONE)
                .unlockedBy("has_large_rock",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.LARGE_ROCK).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "biface"));
        // The idea is you work with hammerstone in inv for a bit and then move to a stone anvil to knap some better things
        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.STONE_ANVIL.get())

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.DIGGING_STICK.get())
                .requires(Registration.BRANCH_ITEM)
                .requires(Registration.LUNATE)
                .unlockedBy("has_branch_lunate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                Registration.BRANCH_ITEM.get(),
                                Registration.LUNATE.get()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "digging_stick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.FIRE_STARTER.get())
                .requires(Items.STICK)
                .requires(Items.STICK)
                .requires(Registration.LUNATE)
                .unlockedBy("has_sticks_lunate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                Items.STICK,
                                Registration.LUNATE.get()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "fire_starter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.UNFIRED_JUG.get()) // TODO Cannot access
                .pattern("c c")
                .pattern("c c")
                .pattern(" c ")
                .define('c', ModItemTags.CLAY_BALL)
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModItemTags.CLAY_BALL)))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "unfired_jug"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Registration.UNFIRED_JUG),
                        RecipeCategory.MISC,
                        Registration.JUG,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_jug", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.UNFIRED_JUG.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "jug"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.UNFIRED_CRUCIBLE.get())
                .pattern("c c")
                .pattern(" c ")
                .define('c', ModItemTags.CLAY_BALL)
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModItemTags.CLAY_BALL)))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "unfired_crucible"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Registration.UNFIRED_CRUCIBLE),
                        RecipeCategory.MISC,
                        Registration.CRUCIBLE,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_crucible", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.UNFIRED_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "crucible"));

        // Pot
        // Large Pot

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.FLAX_FIBER.get())
                .requires(Registration.FLAX.get())
                .group("flax")
                .unlockedBy("has_flax", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.FLAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "flax_fiber"));

        // -- Leather

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.LARGE_LIMED_HIDE.get())
                .requires(ModItemTags.LARGE_HIDE)
                .group("large_hide")
                .unlockedBy("has_large_hide",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.LARGE_HIDE)
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.MEDIUM_LIMED_HIDE.get())
                .requires(ModItemTags.MEDIUM_HIDE)
                .group("medium_hide")
                .unlockedBy("has_medium_hide",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.MEDIUM_HIDE)
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.SMALL_LIMED_HIDE.get())
                .requires(ModItemTags.SMALL_HIDE)
                .group("small_hide")
                .unlockedBy("has_small_hide",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.SMALL_HIDE)
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_limed_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.LARGE_RAW_HIDE.get())
                .requires(Registration.LARGE_LIMED_HIDE.get())
                .group("large_limed_hide")
                .unlockedBy("has_large_limed_hide", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.LARGE_LIMED_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.MEDIUM_RAW_HIDE.get())
                .requires(Registration.MEDIUM_LIMED_HIDE.get())
                .group("medium_limed_hide")
                .unlockedBy("has_medium_limed_hide", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.MEDIUM_LIMED_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.SMALL_RAW_HIDE.get())
                .requires(Registration.SMALL_LIMED_HIDE.get())
                .group("small_limed_hide")
                .unlockedBy("has_small_limed_hide", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SMALL_LIMED_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_raw_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.LARGE_WET_LEATHER.get())
                .requires(Registration.LARGE_RAW_HIDE.get())
                .group("large_raw_hide")
                .unlockedBy("has_large_raw_hide", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.LARGE_RAW_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.MEDIUM_WET_LEATHER.get())
                .requires(Registration.MEDIUM_RAW_HIDE.get())
                .group("medium_raw_hide")
                .unlockedBy("has_medium_raw_hide", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.MEDIUM_RAW_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.SMALL_WET_LEATHER.get())
                .requires(Registration.SMALL_RAW_HIDE.get())
                .group("small_raw_hide")
                .unlockedBy("has_small_raw_hide", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SMALL_RAW_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_wet_leather"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(Registration.LARGE_WET_LEATHER.get())
                .group("large_wet_leather")
                .unlockedBy("has_large_wet_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.LARGE_WET_LEATHER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.MEDIUM_LEATHER.get())
                .requires(Registration.MEDIUM_WET_LEATHER.get())
                .group("medium_wet_leather")
                .unlockedBy("has_medium_wet_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.MEDIUM_WET_LEATHER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.SMALL_LEATHER.get())
                .requires(Registration.SMALL_WET_LEATHER.get())
                .group("small_wet_leather")
                .unlockedBy("has_small_wet_leather", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SMALL_WET_LEATHER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_leather"));
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        tempRecipes(recipeOutput);

        InWorldRecipeBuilder.fireStarter(Blocks.CAMPFIRE.defaultBlockState())
                .requires(Registration.BRANCH_ITEM, 4)
                .requires(ModItemTags.TINDER)
                .unlockedBy("has_branch", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BRANCH_ITEM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "campfire"));

        // Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.RED_CLAY_BLOCK_ITEM.get())
                .pattern("cc")
                .pattern("cc")
                .define('c', Registration.RED_CLAY_BALL.get())
                .group("clay")
                .unlockedBy("has_red_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RED_CLAY_BALL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "red_clay_block"));

        // Large Pot??? c c, c c, ccc

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.THATCH_BLOCK_ITEM.get())
                .pattern("tt")
                .pattern("tt")
                .define('t', Registration.THATCH)
                .unlockedBy("has_thatch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.THATCH)))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "thatch_block"));

        // -- Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Registration.UNFIRED_BRICK.get())
                .requires(ModItemTags.CLAY_BALL)
                .group("unfired_brick")
                .unlockedBy("has_clay_ball",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.CLAY_BALL).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "unfired_brick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Registration.CRACKED_WHEAT.get())
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Registration.HAMMERSTONE)
                .unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "cracked_wheat"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Registration.CRACKED_BARLEY.get())
                .requires(Registration.BARLEY.get())
                .requires(Registration.BARLEY.get())
                .requires(Registration.BARLEY.get())
                .requires(Registration.HAMMERSTONE)
                .unlockedBy("has_barley", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BARLEY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "cracked_barley"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Registration.ROLLED_OATS.get())
                .requires(Registration.OATS.get())
                .requires(Registration.OATS.get())
                .requires(Registration.OATS.get())
                .requires(Registration.HAMMERSTONE)
                .unlockedBy("has_oat", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.OATS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "rolled_oats"));
        // Hay Block from thatch/straw/hay
        // Add Wheat/Oat/Barley Block?

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 2)
                .requires(Registration.BRANCH_ITEM)
                .unlockedBy("has_branch",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(Registration.BRANCH_ITEM).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "stick_branch"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.THATCH, 9)
                .requires(Registration.THATCH_BLOCK_ITEM)
                .unlockedBy("has_thatch_block",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(Registration.THATCH_BLOCK_ITEM).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "thatch_from_block"));


        // -- Campfire
        // TODO Balance experience and cooking times
        SimpleCookingRecipeBuilder.campfireCooking(
                Ingredient.of(Registration.LIMESTONE_ROCK_ITEM.get()),
                RecipeCategory.MISC,
                Registration.QUICK_LIME.get(),
                0.0f,
                1000)
                .unlockedBy("has_limestone_rock", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.LIMESTONE_ROCK_ITEM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "quicklime_campfire"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Registration.LIMESTONE_ROCK_ITEM.get()),
                        RecipeCategory.MISC,
                        Registration.QUICK_LIME.get(),
                        0.0f,
                        1000)
                .unlockedBy("has_limestone_rock", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Registration.LIMESTONE_ROCK_ITEM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "quicklime_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(
                Ingredient.of(Items.STICK),
                RecipeCategory.MISC,
                Items.TORCH,
                0.0f,
                100)
                .group("stick")
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "stick_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Registration.YAM),
                        RecipeCategory.FOOD,
                        Registration.BAKED_YAM,
                        0.0f,
                        100)
                .group("yam")
                .unlockedBy("has_yam", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.YAM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_yam_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD,
                        Registration.BAKED_BEETROOT,
                        0.0f,
                        100)
                .group("beetroot")
                .unlockedBy("has_beetroot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_beetroot_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD,
                        Registration.BAKED_CARROT,
                        0.0f,
                        100)
                .group("carrot")
                .unlockedBy("has_carrot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_carrot_campfire"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD,
                        Registration.BAKED_CARROT,
                        0.0f,
                        100)
                .group("carrot")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_carrot_smelting"));
        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD,
                        Registration.BAKED_CARROT,
                        0.0f,
                        100)
                .group("carrot")
                .unlockedBy("has_smoker", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SMOKER, Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_carrot_smoking"));


        // Bread
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Registration.FLOUR.get())
                .requires(ModItemTags.CAN_CRAFT_FLOUR)
                .requires(Registration.HAMMERSTONE.get())
                .group("flour")
                .unlockedBy(
                        "can_make_flour",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModItemTags.CAN_CRAFT_FLOUR).build()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "flour"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Registration.DOUGH.get())
                .requires(Registration.FLOUR.get())
                .group("dough")
                .unlockedBy("has_flour", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.FLOUR.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "dough"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Registration.DOUGH.get()),
                        RecipeCategory.FOOD,
                        Items.BREAD,
                        0.0f,
                        100)
                .group("bread")
                .unlockedBy("has_dough", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.DOUGH.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "bread_campfire"));
        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(Registration.DOUGH.get()),
                        RecipeCategory.FOOD,
                        Items.BREAD,
                        0.0f,
                        100)
                .group("bread")
                .unlockedBy("has_dough_smoker", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SMOKER, Registration.DOUGH.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "bread_smoking"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Registration.DOUGH.get()),
                        RecipeCategory.FOOD,
                        Items.BREAD,
                        0.0f,
                        100)
                .group("bread")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Registration.DOUGH.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "bread_smelting"));




        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Registration.YAM),
                        RecipeCategory.FOOD,
                        Registration.BAKED_YAM,
                        0.0f,
                        100)
                .group("yam")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Registration.YAM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_yam_smelting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD,
                        Registration.BAKED_BEETROOT,
                        0.0f,
                        100)
                .group("beetroot")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Items.BEETROOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_beetroot_smelting"));






        SimpleCookingRecipeBuilder.smelting( // remove in overhaul
                        Ingredient.of(ModItemTags.CLAY_BALL),
                        RecipeCategory.MISC,
                        Items.BRICK,
                        0.0f,
                        100)
                .group("brick")
                .unlockedBy("has_red_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RED_CLAY_BALL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "brick_from_clay_ball_tag"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Registration.UNFIRED_BRICK.get()),
                        RecipeCategory.MISC,
                        Items.BRICK,
                        0.0f,
                        100)
                .group("brick")
                .unlockedBy("has_unfired_brick", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.UNFIRED_BRICK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "brick_from_unfired_brick_smelting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Registration.UNFIRED_CRUCIBLE),
                        RecipeCategory.MISC,
                        Registration.CRUCIBLE,
                        0.0f,
                        100)
                .group("crucible")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Registration.UNFIRED_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "crucible_smelting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Registration.UNFIRED_JUG),
                        RecipeCategory.MISC,
                        Registration.JUG,
                        0.0f,
                        100)
                .group("jug")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Registration.UNFIRED_JUG.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "jug_smelting"));
    }
}
