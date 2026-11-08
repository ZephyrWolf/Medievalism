package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import io.github.zephyrwolf.medievalism.common.recipe.crafting.ShapelessToolRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.malleable.MalleableRecipeBuilder;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.KnappingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.recipe.MalleableMaterialRegistration;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;

public final class ClayWorkingRecipeProvider
{
    public static void buildRecipes(RecipeOutput recipeOutput)
    {
        bucketRecipes(recipeOutput);
        crucibleRecipes(recipeOutput);
        gatherersJarRecipes(recipeOutput);
        keepersCrockRecipes(recipeOutput);
        settlersPotRecipes(recipeOutput);
        cookingPotRecipes(recipeOutput);
        clayCauldronRecipes(recipeOutput);
        jugRecipes(recipeOutput);
        flowerPotRecipes(recipeOutput);
        decoratedPotRecipes(recipeOutput);
        toolAxeRecipes(recipeOutput);
        toolGreataxeRecipes(recipeOutput);
        toolHoeRecipes(recipeOutput);
        toolKnifeRecipes(recipeOutput);
        toolLongswordRecipes(recipeOutput);
        toolPickaxeRecipes(recipeOutput);
        toolShortswordRecipes(recipeOutput);
        toolShovelRecipes(recipeOutput);
        toolSickleRecipes(recipeOutput);
        toolSpearRecipes(recipeOutput);
    }

    private static void bucketRecipes(RecipeOutput recipeOutput)
    {
        // Clay Bucket
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_BUCKET.get()))
                .pattern("x x")
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_bucket"));

        // Potters Clay Bucket
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_BUCKET.get()))
                .pattern("x x")
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_bucket"));

        // Refractory Clay Bucket
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.REFRACTORY_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_BUCKET.get()))
                .pattern("x x")
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_refractory_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_refractory_clay_bucket"));
    }

    private static void crucibleRecipes(RecipeOutput recipeOutput)
    {
        /*
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .pattern("x x")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_clay_crucible"));
         */
    }

    private static void gatherersJarRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_GATHERERS_JAR.get()))
                .pattern("x x")
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_gatherers_jar"));
    }

    private static void keepersCrockRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_KEEPERS_CROCK.get()))
                .pattern("x  x")
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_keepers_crock"));
    }

    private static void settlersPotRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_SETTLERS_POT.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_settlers_pot"));
    }

    private static void cookingPotRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_COOKING_POT.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_cooking_pot"));
    }

    private static void clayCauldronRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_CAULDRON.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_cauldron"));
    }

    private static void jugRecipes(RecipeOutput recipeOutput)
    {
        /*
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_JUG.get()))
                .pattern(" x x ")
                .pattern(" x x ")
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_jug"));
         */
    }

    private static void flowerPotRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_FLOWER_POT.get()))
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_flower_pot"));
    }

    private static void decoratedPotRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_DECORATED_POT.get()))
                .pattern(" xx ")
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KnappingItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_decorated_pot"));
    }

    private static void toolAxeRecipes(RecipeOutput recipeOutput)
    {
        // Axe Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_AXE_BLANK.get()))
                .pattern(" xx")
                .pattern("xxx")
                .pattern(" xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_axe_blank"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_AXE_BLANK.get()))
                .pattern(" xx")
                .pattern("xxx")
                .pattern(" xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_axe_blank"));

        // Axe Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_AXE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_AXE_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_axe_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_AXE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_axe_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_AXE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_AXE_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_axe_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_AXE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_axe_mould"));
    }

    private static void toolGreataxeRecipes(RecipeOutput recipeOutput)
    {
        // Greataxe Blank

    }

    private static void toolHoeRecipes(RecipeOutput recipeOutput)
    {
        // Hoe Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_HOE_BLANK.get()))
                .pattern(" xxx")
                .pattern("xxxx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_hoe_blank"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_HOE_BLANK.get(), 2))
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("    ")
                .pattern(" xxx")
                .pattern("xxxx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_hoe_blank2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_HOE_BLANK.get(), 2))
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("    ")
                .pattern("xxx ")
                .pattern("xxxx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_hoe_blank3"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_HOE_BLANK.get()))
                .pattern(" xxx")
                .pattern("xxxx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_hoe_blank"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_HOE_BLANK.get(), 2))
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("    ")
                .pattern(" xxx")
                .pattern("xxxx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_hoe_blank2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_HOE_BLANK.get(), 2))
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("    ")
                .pattern("xxx ")
                .pattern("xxxx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_hoe_blank3"));

        // Hoe Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_HOE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_HOE_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_hoe_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_HOE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_hoe_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_HOE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_HOE_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_hoe_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_HOE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_hoe_mould"));
    }

    private static void toolKnifeRecipes(RecipeOutput recipeOutput)
    {
        // Knife Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_KNIFE_BLANK.get()))
                .pattern("x ")
                .pattern("xx")
                .pattern("xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_knife_blank"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_KNIFE_BLANK.get(), 2))
                .pattern("x  x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_knife_blank2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_KNIFE_BLANK.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_knife_blank3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_KNIFE_BLANK.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_knife_blank4"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_BLANK.get()))
                .pattern(" x")
                .pattern("xx")
                .pattern("xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_knife_blank"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_BLANK.get(), 2))
                .pattern(" x  x")
                .pattern("xx xx")
                .pattern("xx xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_knife_blank2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_BLANK.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_knife_blank3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_BLANK.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_knife_blank4"));

        // Knife Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_KNIFE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_KNIFE_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_knife_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_KNIFE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_knife_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_KNIFE_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_knife_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_KNIFE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_knife_mould"));
    }

    private static void toolLongswordRecipes(RecipeOutput recipeOutput)
    {
        // Longsword Blank
    }

    private static void toolPickaxeRecipes(RecipeOutput recipeOutput)
    {
        // Pickaxe Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_PICKAXE_BLANK.get()))
                .pattern("xxx  ")
                .pattern("  xx ")
                .pattern("   xx")
                .pattern("    x")
                .pattern("    x")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_pickaxe_blank"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_PICKAXE_BLANK.get()))
                .pattern("xxx  ")
                .pattern("  xx ")
                .pattern("   xx")
                .pattern("    x")
                .pattern("    x")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_pickaxe_blank"));

        // Pickaxe Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_PICKAXE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_PICKAXE_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_pickaxe_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_PICKAXE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_pickaxe_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_PICKAXE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_PICKAXE_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_pickaxe_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_PICKAXE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_pickaxe_mould"));
    }

    private static void toolShortswordRecipes(RecipeOutput recipeOutput)
    {
        // Shortsword Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_BLANK.get()))
                .pattern(" x")
                .pattern("xx")
                .pattern("xx")
                .pattern("xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shortsword_blank"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_BLANK.get(), 2))
                .pattern(" x  x")
                .pattern("xx xx")
                .pattern("xx xx")
                .pattern("xx xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shortsword_blank2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_BLANK.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shortsword_blank3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_BLANK.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shortsword_blank4"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_BLANK.get()))
                .pattern(" x")
                .pattern("xx")
                .pattern("xx")
                .pattern("xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shortsword_blank"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_BLANK.get(), 2))
                .pattern(" x  x")
                .pattern("xx xx")
                .pattern("xx xx")
                .pattern("xx xx")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shortsword_blank2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_BLANK.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shortsword_blank3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_BLANK.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shortsword_blank4"));

        // Shortsword Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SHORTSWORD_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_shortsword_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SHORTSWORD_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shortsword_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SHORTSWORD_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_shortsword_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SHORTSWORD_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shortsword_mould"));
    }

    private static void toolShovelRecipes(RecipeOutput recipeOutput)
    {
        // Shovel Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SHOVEL_BLANK.get()))
                .pattern(" x ")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shovel_blank"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHOVEL_BLANK.get()))
                .pattern(" x ")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shovel_blank"));

        // Shovel Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_SHOVEL_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SHOVEL_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_shovel_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SHOVEL_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_shovel_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHOVEL_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SHOVEL_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_shovel_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SHOVEL_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_shovel_mould"));
    }

    private static void toolSickleRecipes(RecipeOutput recipeOutput)
    {
        // Sickle Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SICKLE_BLANK.get()))
                .pattern(" xxx ")
                .pattern("x   x")
                .pattern("x    ")
                .pattern(" x   ")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_sickle_blank"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SICKLE_BLANK.get()))
                .pattern(" xxx ")
                .pattern("x   x")
                .pattern("x    ")
                .pattern(" x   ")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_sickle_blank"));

        // Sickle Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_SICKLE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SICKLE_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_sickle_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SICKLE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_sickle_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_SICKLE_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SICKLE_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_sickle_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SICKLE_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_sickle_mould"));
    }

    private static void toolSpearRecipes(RecipeOutput recipeOutput)
    {
        // Spear Blank
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_SPEAR_BLANK.get()))
                .allowMirror()
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("xxxx")
                .pattern(" xx ")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_spear_blank"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.POTTERS_CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SPEAR_BLANK.get()))
                .allowMirror()
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("xxxx")
                .pattern(" xx ")
                .allowMirror()
                .unlockedBy("has_stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems( KnappingItemRegistration.STONE_BENCH ))
                .unlockedBy("has_potters_clay_ball", InventoryChangeTrigger.TriggerInstance.hasItems( ClayWorkingItemRegistration.POTTERS_CLAY_BALL ))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_spear_blank"));

        // Spear Mould
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_CLAY_SPEAR_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SPEAR_BLANK)
                .unlockedBy("has_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_BALL))
                .unlockedBy("has_clay_spear_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SPEAR_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_spear_mould"));
        ShapelessToolRecipeBuilder.shapeless(RecipeCategory.TOOLS, ClayWorkingItemRegistration.WET_POTTERS_CLAY_SPEAR_MOULD)
                .requiresIngredient(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK)
                .requiresTool(ClayWorkingItemRegistration.CLAY_SPEAR_BLANK)
                .unlockedBy("has_potters_clay_ball", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.POTTERS_CLAY_BALL))
                .unlockedBy("has_clay_spear_blank", RecipeTools.itemPredicateOf(ClayWorkingItemRegistration.CLAY_SPEAR_BLANK))
                .strategy(AdvancementRequirements.Strategy.AND)
                .save(recipeOutput, MedievalismConstants.resource("wet_potters_clay_spear_mould"));
    }
}
