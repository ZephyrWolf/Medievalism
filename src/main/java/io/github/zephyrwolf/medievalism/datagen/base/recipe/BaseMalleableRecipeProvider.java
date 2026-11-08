package io.github.zephyrwolf.medievalism.datagen.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.malleable.MalleableMaterialRecipeBuilder;
import io.github.zephyrwolf.medievalism.common.recipe.malleable.MalleableRecipeBuilder;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.registration.recipe.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public final class BaseMalleableRecipeProvider
{
    public static void buildRecipes(RecipeOutput recipeOutput)
    {
        malleableMaterialRecipes(recipeOutput);
        knappingRecipes(recipeOutput);
        potteryRecipes(recipeOutput);
    }

    private static void malleableMaterialRecipes(RecipeOutput recipeOutput) {
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.CLAY_BALL), MalleableMaterialRegistration.CLAY.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ClayWorkingItemRegistration.CLAY_BALL
                ))
                .save(recipeOutput, MedievalismConstants.resource("clay_ball_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ClayWorkingItemRegistration.POTTERS_CLAY_BALL), MalleableMaterialRegistration.POTTERS_CLAY.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ClayWorkingItemRegistration.POTTERS_CLAY_BALL
                ))
                .save(recipeOutput, MedievalismConstants.resource("potters_clay_ball_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL), MalleableMaterialRegistration.KAOLIN_CLAY.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ClayWorkingItemRegistration.KAOLIN_CLAY_BALL
                ))
                .save(recipeOutput, MedievalismConstants.resource("kaolin_clay_ball_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL), MalleableMaterialRegistration.REFRACTORY_CLAY.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL
                ))
                .save(recipeOutput, MedievalismConstants.resource("refractory_clay_ball_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.CLAY_BLOCK), MalleableMaterialRegistration.CLAY.get())
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("clay_block_material"));

        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.ROCK), MalleableMaterialRegistration.ROCK.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.LARGE_ROCK), MalleableMaterialRegistration.ROCK.get())
                .pattern(" xxx ")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern("xxxxx")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("large_rock_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(Items.FLINT), MalleableMaterialRegistration.FLINT.get())
                .pattern(" x ")
                .pattern("xxx")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        Items.FLINT
                ))
                .save(recipeOutput, MedievalismConstants.resource("flint_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemTagCatalog.GOAT_HORN_MATERIAL), MalleableMaterialRegistration.BONE.get())
                .pattern("xx  ")
                .pattern("xxx ")
                .pattern(" xxx")
                .unlockedBy("has_goat_horn", InventoryChangeTrigger.TriggerInstance.hasItems(
                        Items.GOAT_HORN,
                        ItemRegistration.BROKEN_GOAT_HORN.get()
                ))
                .save(recipeOutput, MedievalismConstants.resource("goat_horn_material"));
        MalleableMaterialRecipeBuilder.builder(Ingredient.of(ItemRegistration.ANTLER), MalleableMaterialRegistration.BONE.get())
                .pattern("xxx  ")
                .pattern("xxxx ")
                .pattern("  xxx")
                .pattern(" x xx")
                .pattern("   xx")
                .unlockedBy("has_antler", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.ANTLER
                ))
                .save(recipeOutput, MedievalismConstants.resource("antler_material"));
    }

    private static void knappingRecipes(RecipeOutput recipeOutput)
    {
        // Rock Knife Blade
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_KNIFE_BLADE.get()))
                .allowMirror()
                .pattern("x ")
                .pattern("xx")
                .pattern("xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("rock_knife_blade_knapping1"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_KNIFE_BLADE.get(), 2))
                .allowMirror()
                .pattern("x  x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("rock_knife_blade_knapping2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_KNIFE_BLADE.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("rock_knife_blade_knapping3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_KNIFE_BLADE.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("rock_knife_blade_knapping4"));
        // Bone Knife Blade
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.BONE_KNIFE_BLADE.get()))
                .allowMirror()
                .pattern("x ")
                .pattern("xx")
                .pattern("xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("bone_knife_blade_knapping1"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.BONE_KNIFE_BLADE.get(), 2))
                .allowMirror()
                .pattern("x  x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("bone_knife_blade_knapping2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.BONE_KNIFE_BLADE.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("bone_knife_blade_knapping3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.BONE_KNIFE_BLADE.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("flint_knife_blade_knapping4"));
        // Flint Knife Blade
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.FLINT.get(), new ItemStack(ItemRegistration.FLINT_KNIFE_BLADE.get()))
                .allowMirror()
                .pattern("x ")
                .pattern("xx")
                .pattern("xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("flint_knife_blade_knapping1"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.FLINT.get(), new ItemStack(ItemRegistration.FLINT_KNIFE_BLADE.get(), 2))
                .allowMirror()
                .pattern("x  x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("flint_knife_blade_knapping2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.FLINT.get(), new ItemStack(ItemRegistration.FLINT_KNIFE_BLADE.get(), 2))
                .pattern(" x x ")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("flint_knife_blade_knapping3"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.FLINT.get(), new ItemStack(ItemRegistration.FLINT_KNIFE_BLADE.get(), 2))
                .pattern("x   x")
                .pattern("xx xx")
                .pattern("xx xx")
                .unlockedBy("stone_bench", RecipeTools.itemPredicateOf(ItemRegistration.STONE_BENCH))
                .save(recipeOutput, MedievalismConstants.resource("bone_knife_blade_knapping4"));
        // Rock Axe Head
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_AXE_HEAD.get()))
                .allowMirror()
                .pattern("xx ")
                .pattern("xxx")
                .pattern("xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_axe_head"));
        // Rock Pickaxe Head
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_PICKAXE_HEAD.get()))
                .allowMirror()
                .pattern("xxx  ")
                .pattern("  xx ")
                .pattern("   xx")
                .pattern("    x")
                .pattern("    x")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_pickaxe_head"));
        // Antler Pickaxe Head
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.ANTLER_PICKAXE_HEAD.get()))
                .allowMirror()
                .pattern("xxx  ")
                .pattern("  xx ")
                .pattern("   xx")
                .pattern("    x")
                .pattern("    x")
                .unlockedBy("has_antler", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.ANTLER
                ))
                .save(recipeOutput, MedievalismConstants.resource("antler_pickaxe_head"));
        // Rock Hoe Head
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_HOE_HEAD.get()))
                .allowMirror()
                .pattern("xxx ")
                .pattern("xxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_hoe_head"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_HOE_HEAD.get(), 2))
                .allowMirror()
                .pattern("xxx ")
                .pattern("xxxx")
                .pattern("    ")
                .pattern("xxx ")
                .pattern("xxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_hoe_head_2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_HOE_HEAD.get(), 2))
                .allowMirror()
                .pattern("xxx ")
                .pattern("xxxx")
                .pattern("    ")
                .pattern(" xxx")
                .pattern("xxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("rock_hoe_head_3"));
        // Antler Hoe Head
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.ANTLER_HOE_HEAD.get()))
                .allowMirror()
                .pattern("xxx ")
                .pattern("xxxx")
                .unlockedBy("has_antler", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.ANTLER
                ))
                .save(recipeOutput, MedievalismConstants.resource("antler_hoe_head"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.ANTLER_HOE_HEAD.get(), 2))
                .allowMirror()
                .pattern("xxx ")
                .pattern("xxxx")
                .pattern("    ")
                .pattern("xxx ")
                .pattern("xxxx")
                .unlockedBy("has_antler", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.ANTLER
                ))
                .save(recipeOutput, MedievalismConstants.resource("antler_hoe_head_2"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.BONE.get(), new ItemStack(ItemRegistration.ANTLER_HOE_HEAD.get(), 2))
                .allowMirror()
                .pattern("xxx ")
                .pattern("xxxx")
                .pattern("    ")
                .pattern(" xxx")
                .pattern("xxxx")
                .unlockedBy("has_antler", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.ANTLER
                ))
                .save(recipeOutput, MedievalismConstants.resource("antler_hoe_head_3"));
        // Rock Spear Head
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.ROCK_SPEAR_HEAD.get()))
                .allowMirror()
                .pattern(" xxx")
                .pattern("xxxx")
                .pattern("xxxx")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("spear_head"));
        // Lunate
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.ROCK.get(), new ItemStack(ItemRegistration.LUNATE.get()))
                .allowMirror()
                .pattern(" xx")
                .pattern("xxx")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("lunate"));
    }

    private static void potteryRecipes(RecipeOutput recipeOutput)
    {
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_FLOWER_POT.get()))
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ClayWorkingItemRegistration.CLAY_BALL
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_plant_pot"));
        /*
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get()))
                .pattern("x x")
                .pattern("xxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("unfired_clay_crucible"));
         */
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_GATHERERS_JAR.get()))
                .pattern("x x")
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_gatherers_jar"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_KEEPERS_CROCK.get()))
                .pattern("x  x")
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_keepers_crock"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_SETTLERS_POT.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_settlers_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_COOKING_POT.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern(" xxx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_cooking_pot"));

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_CLAY_CAULDRON.get()))
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("x   x")
                .pattern("xxxxx")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_clay_cauldron"));

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

        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_FLOWER_POT.get()))
                .pattern("x x")
                .pattern(" x ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_flower_pot"));
        MalleableRecipeBuilder.builder(MalleableMaterialRegistration.CLAY.get(), new ItemStack(ClayWorkingItemRegistration.WET_DECORATED_POT.get()))
                .pattern(" xx ")
                .pattern("x  x")
                .pattern("x  x")
                .pattern(" xx ")
                .unlockedBy("stone_bench", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemRegistration.STONE_BENCH
                ))
                .save(recipeOutput, MedievalismConstants.resource("wet_decorated_pot"));
    }
}
