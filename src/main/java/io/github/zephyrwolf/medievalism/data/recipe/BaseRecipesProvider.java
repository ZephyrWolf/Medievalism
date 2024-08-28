package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.AdditionalDropToolUseRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableMaterialRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableRecipeBuilder;
import io.github.zephyrwolf.medievalism.content.*;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeBuilder;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BaseRecipesProvider extends RecipeProvider
{

    public BaseRecipesProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    public void tempRecipes(@NotNull RecipeOutput recipeOutput)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.HAMMERSTONE.get())
                .requires(ItemTagCatalog.ROCK)
                .unlockedBy("has_rock",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.ROCK).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "hammerstone"));
        // The idea is you work with hammerstone in inv for a bit and then move to a stone anvil to knap some better things
        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.STONE_ANVIL.get())

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.DIGGING_STICK.get())
                .requires(ItemTagCatalog.BRANCH)
                .requires(ItemRegistration.LUNATE)
                .unlockedBy("has_branch_lunate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.BRANCH),
                                ItemPredicate.Builder.item().of(ItemRegistration.LUNATE.get())
                        )
                )
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "digging_stick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.FIRE_STARTER.get())
                .requires(Items.STICK)
                .requires(Items.STICK)
                .requires(ItemRegistration.LUNATE)
                .unlockedBy("has_sticks_lunate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                Items.STICK,
                                ItemRegistration.LUNATE.get()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "fire_starter"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_JUG),
                        RecipeCategory.MISC,
                        ItemRegistration.JUG,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_jug", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_JUG.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "jug_campfire"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get())
                .pattern("c c")
                .pattern(" c ")
                .define('c', ItemTagCatalog.CLAY_BALL)
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL)))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "unfired_crucible_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_CLAY_CRUCIBLE),
                        RecipeCategory.MISC,
                        ItemRegistration.CLAY_CRUCIBLE,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_crucible", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "clay_crucible_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_POT),
                        RecipeCategory.MISC,
                        ItemRegistration.POT,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_crucible", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "pot_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_LARGE_POT),
                        RecipeCategory.MISC,
                        ItemRegistration.LARGE_POT,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_crucible", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_pot_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_FLOWER_POT),
                        RecipeCategory.MISC,
                        Items.FLOWER_POT,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_crucible", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "flower_pot_campfire"));
        // TODO Decorated Pots
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_BIRCH_POT),
                        RecipeCategory.MISC,
                        BlockRegistration.BIRCH_POT,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_crucible", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "birch_pot_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.UNFIRED_BRICK),
                        RecipeCategory.MISC,
                        Items.BRICK,
                        0.0f,
                        100)
                .unlockedBy("has_unfired_brick", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_BRICK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "brick_campfire"));


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.UNFIRED_BIRCH_POT.get())
                .requires(ItemRegistration.UNFIRED_FLOWER_POT.get())
                .requires(Items.STICK)
                .unlockedBy("has_unfired_flower_pot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_FLOWER_POT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "unfired_birch_pot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.FLAX_FIBER.get())
                .requires(ItemRegistration.FLAX.get())
                .group("flax")
                .unlockedBy("has_flax", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.FLAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "flax_fiber"));

        // -- Leather

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LARGE_LIMED_HIDE.get())
                .requires(ItemTagCatalog.LARGE_HIDE)
                .group("large_hide")
                .unlockedBy("has_large_hide",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.LARGE_HIDE)
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_LIMED_HIDE.get())
                .requires(ItemTagCatalog.MEDIUM_HIDE)
                .group("medium_hide")
                .unlockedBy("has_medium_hide",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.MEDIUM_HIDE)
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_limed_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_LIMED_HIDE.get())
                .requires(ItemTagCatalog.SMALL_HIDE)
                .group("small_hide")
                .unlockedBy("has_small_hide",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.SMALL_HIDE)
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_limed_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LARGE_RAW_HIDE.get())
                .requires(ItemRegistration.LARGE_LIMED_HIDE.get())
                .group("large_limed_hide")
                .unlockedBy("has_large_limed_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.LARGE_LIMED_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_RAW_HIDE.get())
                .requires(ItemRegistration.MEDIUM_LIMED_HIDE.get())
                .group("medium_limed_hide")
                .unlockedBy("has_medium_limed_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.MEDIUM_LIMED_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_raw_hide"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_RAW_HIDE.get())
                .requires(ItemRegistration.SMALL_LIMED_HIDE.get())
                .group("small_limed_hide")
                .unlockedBy("has_small_limed_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.SMALL_LIMED_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_raw_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.LARGE_WET_LEATHER.get())
                .requires(ItemRegistration.LARGE_RAW_HIDE.get())
                .group("large_raw_hide")
                .unlockedBy("has_large_raw_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.LARGE_RAW_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_WET_LEATHER.get())
                .requires(ItemRegistration.MEDIUM_RAW_HIDE.get())
                .group("medium_raw_hide")
                .unlockedBy("has_medium_raw_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.MEDIUM_RAW_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_wet_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_WET_LEATHER.get())
                .requires(ItemRegistration.SMALL_RAW_HIDE.get())
                .group("small_raw_hide")
                .unlockedBy("has_small_raw_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.SMALL_RAW_HIDE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_wet_leather"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(ItemRegistration.LARGE_WET_LEATHER.get())
                .group("large_wet_leather")
                .unlockedBy("has_large_wet_leather", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.LARGE_WET_LEATHER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "large_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.MEDIUM_LEATHER.get())
                .requires(ItemRegistration.MEDIUM_WET_LEATHER.get())
                .group("medium_wet_leather")
                .unlockedBy("has_medium_wet_leather", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.MEDIUM_WET_LEATHER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "medium_leather"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.SMALL_LEATHER.get())
                .requires(ItemRegistration.SMALL_WET_LEATHER.get())
                .group("small_wet_leather")
                .unlockedBy("has_small_wet_leather", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.SMALL_WET_LEATHER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "small_leather"));
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        tempRecipes(recipeOutput);

        InWorldRecipeBuilder.fireStarter(Blocks.CAMPFIRE.defaultBlockState())
                .requires(ItemTagCatalog.BRANCH, 4)
                .requires(ItemTagCatalog.TINDER)
                .unlockedBy("has_branch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTagCatalog.BRANCH)))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "campfire"));

        // Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.RED_CLAY_BLOCK_ITEM.get())
                .pattern("cc")
                .pattern("cc")
                .define('c', ItemRegistration.RED_CLAY_BALL.get())
                .group("clay")
                .unlockedBy("has_red_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.RED_CLAY_BALL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "red_clay_block"));

        // Large Pot??? c c, c c, ccc

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.THATCH_BLOCK_ITEM.get())
                .pattern("tt")
                .pattern("tt")
                .define('t', ItemRegistration.THATCH)
                .unlockedBy("has_thatch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemRegistration.THATCH)))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "thatch_block"));

        // -- Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.UNFIRED_BRICK.get())
                .requires(ItemTagCatalog.CLAY_BALL)
                .group("unfired_brick")
                .unlockedBy("has_clay_ball",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.CLAY_BALL).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "unfired_brick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.CRACKED_WHEAT.get())
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(ItemRegistration.HAMMERSTONE)
                .unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "cracked_wheat"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.CRACKED_BARLEY.get())
                .requires(ItemRegistration.BARLEY.get())
                .requires(ItemRegistration.BARLEY.get())
                .requires(ItemRegistration.BARLEY.get())
                .requires(ItemRegistration.HAMMERSTONE)
                .unlockedBy("has_barley", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.BARLEY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "cracked_barley"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.ROLLED_OATS.get())
                .requires(ItemRegistration.OATS.get())
                .requires(ItemRegistration.OATS.get())
                .requires(ItemRegistration.OATS.get())
                .requires(ItemRegistration.HAMMERSTONE)
                .unlockedBy("has_oat", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.OATS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "rolled_oats"));
        // Hay Block from thatch/straw/hay
        // Add Wheat/Oat/Barley Block?

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 2)
                .requires(ItemTagCatalog.BRANCH)
                .unlockedBy("has_branch",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(
                                        ItemTagCatalog.BRANCH
                                ).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "stick_branch"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.THATCH, 9)
                .requires(BlockRegistration.THATCH_BLOCK_ITEM)
                .unlockedBy("has_thatch_block",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(BlockRegistration.THATCH_BLOCK_ITEM).build()
                        ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "thatch_from_block"));


        // -- Campfire
        // TODO Balance experience and cooking times
        SimpleCookingRecipeBuilder.campfireCooking(
                Ingredient.of(BlockRegistration.LIMESTONE_ROCK_ITEM.get()),
                RecipeCategory.MISC,
                ItemRegistration.QUICK_LIME.get(),
                0.0f,
                1000)
                .unlockedBy("has_limestone_rock", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistration.LIMESTONE_ROCK_ITEM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "quicklime_campfire"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(BlockRegistration.LIMESTONE_ROCK_ITEM.get()),
                        RecipeCategory.MISC,
                        ItemRegistration.QUICK_LIME.get(),
                        0.0f,
                        1000)
                .unlockedBy("has_limestone_rock", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, BlockRegistration.LIMESTONE_ROCK_ITEM.get()))
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
                        Ingredient.of(ItemRegistration.YAM),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_YAM,
                        0.0f,
                        100)
                .group("yam")
                .unlockedBy("has_yam", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.YAM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_yam_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_BEETROOT,
                        0.0f,
                        100)
                .group("beetroot")
                .unlockedBy("has_beetroot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_beetroot_campfire"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_CARROT,
                        0.0f,
                        100)
                .group("carrot")
                .unlockedBy("has_carrot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_carrot_campfire"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_CARROT,
                        0.0f,
                        100)
                .group("carrot")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_carrot_smelting"));
        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(Items.CARROT),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_CARROT,
                        0.0f,
                        100)
                .group("carrot")
                .unlockedBy("has_smoker", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SMOKER, Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_carrot_smoking"));


        // Bread
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.FLOUR.get())
                .requires(ItemTagCatalog.CAN_CRAFT_FLOUR)
                .requires(ItemRegistration.HAMMERSTONE.get())
                .group("flour")
                .unlockedBy(
                        "can_make_flour",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ItemTagCatalog.CAN_CRAFT_FLOUR).build()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "flour"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistration.DOUGH.get())
                .requires(ItemRegistration.FLOUR.get())
                .group("dough")
                .unlockedBy("has_flour", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.FLOUR.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "dough"));
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ItemRegistration.DOUGH.get()),
                        RecipeCategory.FOOD,
                        Items.BREAD,
                        0.0f,
                        100)
                .group("bread")
                .unlockedBy("has_dough", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.DOUGH.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "bread_campfire"));
        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ItemRegistration.DOUGH.get()),
                        RecipeCategory.FOOD,
                        Items.BREAD,
                        0.0f,
                        100)
                .group("bread")
                .unlockedBy("has_dough_smoker", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SMOKER, ItemRegistration.DOUGH.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "bread_smoking"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ItemRegistration.DOUGH.get()),
                        RecipeCategory.FOOD,
                        Items.BREAD,
                        0.0f,
                        100)
                .group("bread")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, ItemRegistration.DOUGH.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "bread_smelting"));




        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ItemRegistration.YAM),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_YAM,
                        0.0f,
                        100)
                .group("yam")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, ItemRegistration.YAM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_yam_smelting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.BEETROOT),
                        RecipeCategory.FOOD,
                        ItemRegistration.BAKED_BEETROOT,
                        0.0f,
                        100)
                .group("beetroot")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, Items.BEETROOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "baked_beetroot_smelting"));






        SimpleCookingRecipeBuilder.smelting( // remove in overhaul
                        Ingredient.of(ItemTagCatalog.CLAY_BALL),
                        RecipeCategory.MISC,
                        Items.BRICK,
                        0.0f,
                        100)
                .group("brick")
                .unlockedBy("has_red_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.RED_CLAY_BALL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "brick_from_clay_ball_tag"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ItemRegistration.UNFIRED_BRICK.get()),
                        RecipeCategory.MISC,
                        Items.BRICK,
                        0.0f,
                        100)
                .group("brick")
                .unlockedBy("has_unfired_brick", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistration.UNFIRED_BRICK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "brick_from_unfired_brick_smelting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ItemRegistration.UNFIRED_CLAY_CRUCIBLE),
                        RecipeCategory.MISC,
                        ItemRegistration.CLAY_CRUCIBLE,
                        0.0f,
                        100)
                .group("crucible")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "crucible_smelting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ItemRegistration.UNFIRED_JUG),
                        RecipeCategory.MISC,
                        ItemRegistration.JUG,
                        0.0f,
                        100)
                .group("jug")
                .unlockedBy("has_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE, ItemRegistration.UNFIRED_JUG.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "jug_smelting"));

        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.WHITE_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.WHITE_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_white_bark"));
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.BROWN_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.BROWN_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_brown_bark"));
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.GREY_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.GREY_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_grey_bark"));
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.DARK_BROWN_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.DARK_BROWN_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_dark_brown_bark"));
        AdditionalDropToolUseRecipeBuilder
                .axeStrip(
                        new ItemStack(ItemRegistration.BLACK_BARK.get()),
                        BlockPredicate.Builder.block().of(BlockTagCatalog.BLACK_BARK).build()
                )
                .chance(3)
                .unlockedBy("has_axe" , InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ItemTags.AXES).build()))
                .save(recipeOutput, MedievalismConstants.resource("strip_black_bark"));

        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.CLAY_BALL), MalleableMaterialRegistration.CLAY.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                            BlockRegistration.STONE_BENCH_ITEM
                        ))
                .save(recipeOutput, MedievalismConstants.resource("clay_ball_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.CLAY_BLOCK), MalleableMaterialRegistration.CLAY.get())
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("clay_block_material"));

        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.ROCK), MalleableMaterialRegistration.STONE.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.LARGE_ROCK), MalleableMaterialRegistration.STONE.get())
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("large_rock_material"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_FLOWER_POT.get()))
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_plant_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .pattern("x x")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_clay_crucible"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_POT.get()))
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_LARGE_POT.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_large_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_JUG.get()))
                .pattern(" x x ")
                .pattern(" x x ")
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_jug"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.STONE.get(), new ItemStack(ItemRegistration.BIFACE.get()))
                .allowMirror()
                .pattern("xx ")
                .pattern("xxx")
                .pattern("xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.STONE_BENCH_ITEM
                ))
                .save(recipeOutput, MedievalismConstants.resource("biface"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistration.LUNATE.get()))
                .requires(ItemTagCatalog.HAMMER)
                .requires(BlockRegistration.ROCK_ITEM)
                .unlockedBy("has_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.ROCK_ITEM.get(),
                        ItemRegistration.HAMMERSTONE
                ))
                .save(recipeOutput, MedievalismConstants.resource("lunate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(BlockRegistration.STONE_BENCH_ITEM.get()))
                .pattern("xx")
                .define('x', BlockRegistration.LARGE_ROCK_ITEM.get())
                .unlockedBy("has_large_rock", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BlockRegistration.LARGE_ROCK_ITEM.get()
                ))
                .save(recipeOutput, MedievalismConstants.resource("stone_bench"));
    }
}
