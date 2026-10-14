package io.github.zephyrwolf.medievalism.data.base.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.common.recipe.RecipeTools;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

// TODO Balance experience and cooking times
public final class BaseSmeltingRecipeProvider
{
    public static void buildRecipes(RecipeOutput recipeOutput)
    {
        foodRecipes(recipeOutput);
        limeRecipes(recipeOutput);
        stoneRecipes(recipeOutput);
        oreRecipes(recipeOutput);
        tempRecipes(recipeOutput);
        potteryRecipes(recipeOutput);
    }

    private static void foodRecipes(RecipeOutput recipeOutput)
    {
        smelting(recipeOutput, RecipeCategory.FOOD, ItemRegistration.YAM, ItemRegistration.BAKED_YAM, "yam", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.FOOD, Items.BEETROOT, ItemRegistration.BAKED_BEETROOT, "beetroot", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.FOOD, Items.CARROT, ItemRegistration.BAKED_CARROT, "carrot", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.FOOD, ItemRegistration.DOUGH, Items.BREAD, "dough", 0.0f, 100);
    }

    private static void limeRecipes(RecipeOutput recipeOutput)
    {
        smelting(recipeOutput, RecipeCategory.FOOD, BlockItemRegistration.LIMESTONE_ROCK, ItemRegistration.QUICK_LIME, "limestone_rock", 0.0f, 500);
        smelting(recipeOutput, RecipeCategory.FOOD, BlockItemRegistration.LIMESTONE_ROCK, ItemRegistration.QUICK_LIME, "large_limestone_rock", 0.0f, 500);
    }

    private static void stoneRecipes(RecipeOutput recipeOutput)
    {
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_SOFT_TUFF, BlockItemRegistration.SOFT_TUFF, "cobbled_soft_tuff", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_IGNIMBRITE, BlockItemRegistration.IGNIMBRITE, "cobbled_ignimbrite", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_LAPILLISTONE, BlockItemRegistration.LAPILLISTONE, "cobbled_lapillistone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_WELDED_TUFF, BlockItemRegistration.WELDED_TUFF, "cobbled_welded_tuff", 0.0f, 100);
        //smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_SANDSTONE, Items.SANDSTONE, "cobbled_sandstone", 0.0f, 100);
        //smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_RED_SANDSTONE, Items.RED_SANDSTONE, "cobbled_red_sandstone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_SAPROLITE, BlockItemRegistration.SAPROLITE, "cobbled_saprolite", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_LATERITE, BlockItemRegistration.LATERITE, "cobbled_laterite", 0.0f, 100);
        //smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_GREYWACKE, BlockItemRegistration.GREYWACKE, "cobbled_greywacke"); // vanil, 0.0f, 100la
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_SILTSTONE, BlockItemRegistration.SILTSTONE, "cobbled_siltstone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_DOLOSTONE, BlockItemRegistration.DOLOSTONE, "cobbled_dolostone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_LIMESTONE, BlockItemRegistration.LIMESTONE, "cobbled_limestone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_CHALK, BlockItemRegistration.CHALK, "cobbled_chalk", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_IRONSTONE, BlockItemRegistration.IRONSTONE, "cobbled_ironstone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.COBBLED_SHALE, BlockItemRegistration.SHALE, "cobbled_shale", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.ROUGH_DIORITE, BlockItemRegistration.SMOOTH_DIORITE, "rough_diorite", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockItemRegistration.ROUGH_GRANITE, BlockItemRegistration.SMOOTH_GRANITE, "rough_granite", 0.0f, 100);
    }

    private static void oreRecipes(RecipeOutput recipeOutput)
    { // TODO I hate these
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SAPROLITE_COPPER_ORE, BlockItemRegistration.SAPROLITE_COPPER_ORE, "smelt_saprolite_copper_ore_to_saprolite_copper_ore", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SILTSTONE_COPPER_ORE, Items.RAW_COPPER, "smelt_siltstone_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.DOLOSTONE_COPPER_ORE, Items.RAW_COPPER, "smelt_dolostone_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.LIMESTONE_COPPER_ORE, Items.RAW_COPPER, "smelt_limestone_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.CHALK_COPPER_ORE, Items.RAW_COPPER, "smelt_chalk_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.IRONSTONE_COPPER_ORE, Items.RAW_COPPER, "smelt_ironstone_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SHALE_COPPER_ORE, Items.RAW_COPPER, "smelt_shale_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ARKOSE_COPPER_ORE, Items.RAW_COPPER, "smelt_arkose_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.MARBLE_COPPER_ORE, Items.RAW_COPPER, "smelt_marble_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.QUARTZITE_COPPER_ORE, Items.RAW_COPPER, "smelt_quartzite_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.HORNFELS_COPPER_ORE, Items.RAW_COPPER, "smelt_hornfels_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SLATE_COPPER_ORE, Items.RAW_COPPER, "smelt_slate_copper_ore_to_raw_copper", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_DIORITE_IRON_ORE, Items.RAW_IRON, "smelt_smooth_diorite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_GRANITE_IRON_ORE, Items.RAW_IRON, "smelt_smooth_granite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.NORITE_IRON_ORE, Items.RAW_IRON, "smelt_norite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.PERIDOTITE_IRON_ORE, Items.RAW_IRON, "smelt_peridotite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.RHYOLITE_IRON_ORE, Items.RAW_IRON, "smelt_rhyolite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.DACITE_IRON_ORE, Items.RAW_IRON, "smelt_dacite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ANDESITE_IRON_ORE, Items.RAW_IRON, "smelt_andesite_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.BASALT_IRON_ORE, Items.RAW_IRON, "smelt_basalt_iron_ore_to_raw_iron", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SILTSTONE_GOLD_ORE, Items.RAW_GOLD, "smelt_siltstone_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.DOLOSTONE_GOLD_ORE, Items.RAW_GOLD, "smelt_dolostone_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.LIMESTONE_GOLD_ORE, Items.RAW_GOLD, "smelt_limestone_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.CHALK_GOLD_ORE, Items.RAW_GOLD, "smelt_chalk_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.IRONSTONE_GOLD_ORE, Items.RAW_GOLD, "smelt_ironstone_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SHALE_GOLD_ORE, Items.RAW_GOLD, "smelt_shale_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ARKOSE_GOLD_ORE, Items.RAW_GOLD, "smelt_arkose_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.MARBLE_GOLD_ORE, Items.RAW_GOLD, "smelt_marble_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.QUARTZITE_GOLD_ORE, Items.RAW_GOLD, "smelt_quartzite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.HORNFELS_GOLD_ORE, Items.RAW_GOLD, "smelt_hornfels_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SLATE_GOLD_ORE, Items.RAW_GOLD, "smelt_slate_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_DIORITE_GOLD_ORE, Items.RAW_GOLD, "smelt_smooth_diorite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_GRANITE_GOLD_ORE, Items.RAW_GOLD, "smelt_smooth_granite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.NORITE_GOLD_ORE, Items.RAW_GOLD, "smelt_norite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.PERIDOTITE_GOLD_ORE, Items.RAW_GOLD, "smelt_peridotite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.RHYOLITE_GOLD_ORE, Items.RAW_GOLD, "smelt_rhyolite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.DACITE_GOLD_ORE, Items.RAW_GOLD, "smelt_dacite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ANDESITE_GOLD_ORE, Items.RAW_GOLD, "smelt_andesite_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.BASALT_GOLD_ORE, Items.RAW_GOLD, "smelt_basalt_gold_ore_to_raw_gold", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SAPROLITE_COAL_ORE, Items.COAL, "smelt_saprolite_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.LATERITE_COAL_ORE, Items.COAL, "smelt_laterite_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SILTSTONE_COAL_ORE, Items.COAL, "smelt_siltstone_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.DOLOSTONE_COAL_ORE, Items.COAL, "smelt_dolostone_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.LIMESTONE_COAL_ORE, Items.COAL, "smelt_limestone_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.CHALK_COAL_ORE, Items.COAL, "smelt_chalk_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.IRONSTONE_COAL_ORE, Items.COAL, "smelt_ironstone_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SHALE_COAL_ORE, Items.COAL, "smelt_shale_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ARKOSE_COAL_ORE, Items.COAL, "smelt_arkose_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.MARBLE_COAL_ORE, Items.COAL, "smelt_marble_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.QUARTZITE_COAL_ORE, Items.COAL, "smelt_quartzite_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.HORNFELS_COAL_ORE, Items.COAL, "smelt_hornfels_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SLATE_COAL_ORE, Items.COAL, "smelt_slate_coal_ore_to_coal", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE, Items.DIAMOND, "smelt_smooth_diorite_diamond_ore_to_diamond", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE, Items.DIAMOND, "smelt_smooth_granite_diamond_ore_to_diamond", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.NORITE_DIAMOND_ORE, Items.DIAMOND, "smelt_norite_diamond_ore_to_diamond", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.PERIDOTITE_DIAMOND_ORE, Items.DIAMOND, "smelt_peridotite_diamond_ore_to_diamond", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ANDESITE_DIAMOND_ORE, Items.DIAMOND, "smelt_andesite_diamond_ore_to_diamond", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.BASALT_DIAMOND_ORE, Items.DIAMOND, "smelt_basalt_diamond_ore_to_diamond", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_DIORITE_EMERALD_ORE, Items.EMERALD, "smelt_smooth_diorite_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_GRANITE_EMERALD_ORE, Items.EMERALD, "smelt_smooth_granite_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.NORITE_EMERALD_ORE, Items.EMERALD, "smelt_norite_emerald_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.PERIDOTITE_EMERALD_ORE, Items.EMERALD, "smelt_peridotite_emerald_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.RHYOLITE_EMERALD_ORE, Items.EMERALD, "smelt_rhyolite_emerald_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.DACITE_EMERALD_ORE, Items.EMERALD, "smelt_dacite_emerald_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.ANDESITE_EMERALD_ORE, Items.EMERALD, "smelt_andesite_emerald_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.BASALT_EMERALD_ORE, Items.EMERALD, "smelt_basalt_emerald_ore_to_emerald", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.MARBLE_LAPIS_ORE, Items.LAPIS_LAZULI, "smelt_marble_lapis_ore_to_lapis", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.QUARTZITE_LAPIS_ORE, Items.LAPIS_LAZULI, "smelt_quartzite_lapis_ore_to_lapis", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.HORNFELS_LAPIS_ORE, Items.LAPIS_LAZULI, "smelt_hornfels_lapis_ore_to_lapis", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SLATE_LAPIS_ORE, Items.LAPIS_LAZULI, "smelt_slate_lapis_ore_to_lapis", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE, Items.REDSTONE, "smelt_smooth_diorite_redstone_ore_to_redstone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE, Items.REDSTONE, "smelt_smooth_granite_redstone_ore_to_redstone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.NORITE_REDSTONE_ORE, Items.REDSTONE, "smelt_norite_redstone_ore_to_redstone", 0.0f, 100);
        smelting(recipeOutput, RecipeCategory.MISC, BlockItemRegistration.PERIDOTITE_REDSTONE_ORE, Items.REDSTONE, "smelt_peridotite_redstone_ore_to_redstone", 0.0f, 100);

    }

    private static void tempRecipes(RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockItemRegistration.WET_PACKED_MUD),
                        RecipeCategory.FOOD, Blocks.PACKED_MUD.asItem(),
                        0.0f, 100)
                .unlockedBy("has_wet_packed_mud", RecipeTools.itemPredicateOf(BlockItemRegistration.WET_PACKED_MUD))
                .save(recipeOutput, MedievalismConstants.resource("packed_mud_smelting"));

        // Jug
        /*
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_JUG),
                        RecipeCategory.MISC, ItemRegistration.JUG,
                        0.0f, 100)
                .unlockedBy("has_unfired_jug", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_JUG))
                .save(recipeOutput, MedievalismConstants.resource("jug_smelting"));
        // Clay Crucible
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_CLAY_CRUCIBLE),
                        RecipeCategory.MISC, ItemRegistration.CLAY_CRUCIBLE,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("clay_crucible_smelting"));
        // Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_POT),
                        RecipeCategory.MISC, ItemRegistration.POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("pot_smelting"));
        // Large Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_LARGE_POT),
                        RecipeCategory.MISC, ItemRegistration.LARGE_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("large_pot_smelting"));
        // Flower Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_FLOWER_POT),
                        RecipeCategory.MISC, Items.FLOWER_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("flower_pot_smelting"));
        // Decorated Pot // TODO This is only basic and not the decorated ones
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_DECORATED_POT),
                        RecipeCategory.MISC, Items.DECORATED_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_decorated_pot", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_DECORATED_POT))
                .save(recipeOutput, MedievalismConstants.resource("decorated_pot_smelting"));
        // Birch Pot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_BIRCH_POT),
                        RecipeCategory.MISC, BlockRegistration.BIRCH_POT,
                        0.0f, 100)
                .unlockedBy("has_unfired_crucible", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_CLAY_CRUCIBLE))
                .save(recipeOutput, MedievalismConstants.resource("birch_pot_smelting"));
        // Brick
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistration.UNFIRED_BRICK),
                        RecipeCategory.MISC, Items.BRICK,
                        0.0f, 100)
                .unlockedBy("has_unfired_brick", RecipeTools.itemPredicateOf(ItemRegistration.UNFIRED_BRICK))
                .save(recipeOutput, MedievalismConstants.resource("brick_smelting"));

         */
    }

    private static void potteryRecipes(RecipeOutput recipeOutput) {
        // Brick // NOTE Remove in Overhaul
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemTagCatalog.CLAY_BALL),
                        RecipeCategory.MISC, Items.BRICK,
                        0.0f, 100)
                .group("brick")
                .unlockedBy("has_red_clay_ball", RecipeTools.itemPredicateOf(ItemRegistration.RED_CLAY_BALL))
                .save(recipeOutput, MedievalismConstants.resource("brick_from_clay_ball_tag"));
    }

    private static void smelting(RecipeOutput recipeOutput, RecipeCategory category, ItemLike itemHolder, ItemLike result, String name, float expereince, int cookingTime)
    {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemHolder),
                        category, result,
                        expereince, cookingTime)
                .unlockedBy("has_" + name, RecipeTools.itemPredicateOf(itemHolder))
                .save(recipeOutput, MedievalismConstants.resource(name + "_smelting"));
    }
}
