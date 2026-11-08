package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.KeepersCrockBlock;
import io.github.zephyrwolf.medievalism.common.block.SettlersPotBlock;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class ClayWorkingLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addBlockTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), "Drying Gatherer's Jar");
        handle.addBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(), "Drying Keeper's Crock");
        handle.addBlock(BlockRegistration.DRYING_SETTLERS_POT.get(), "Drying Settler's Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), "Drying Clay Cooking Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(), "Drying Clay Cauldron");
        //handle.addBlock(BlockRegistration.DRYING_JUG.get(), "Drying Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), "Drying Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), "Drying Decorated Pot");
        handle.addBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), ".wet", "Wet Gatherer's Jar");
        handle.addBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(), ".wet", "Wet Keeper's Crock");
        handle.addBlock(BlockRegistration.DRYING_SETTLERS_POT.get(), ".wet", "Wet Settler's Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), ".wet", "Wet Clay Cooking Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(), ".wet", "Wet Clay Cauldron");
        //handle.addBlock(BlockRegistration.DRYING_JUG.get(), ".wet", "Wet Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), ".wet", "Wet Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), ".wet", "Wet Decorated Pot");
        handle.addBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), ".dry",  "Unfired Gatherer's Jar");
        handle.addBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(), ".dry",  "Unfired Keeper's Crock");
        handle.addBlock(BlockRegistration.DRYING_SETTLERS_POT.get(), ".dry",  "Unfired Settler's Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), ".dry",  "Unfired Clay Cooking Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(), ".dry",  "Unfired Clay Cauldron");
        //handle.addBlock(BlockRegistration.DRYING_JUG.get(), ".dry",  "Unfired Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), ".dry",  "Unfired Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), ".dry",  "Unfired Decorated Pot");
        handle.addBlock(BlockRegistration.GATHERERS_JAR.get(), "Gatherer's Jar");
        handle.addBlock(BlockRegistration.KEEPERS_CROCK.get(), "Keeper's Crock");
        handle.addBlock(BlockRegistration.SETTLERS_POT.get(), "Settler's Pot");
        handle.addBlock(BlockRegistration.CLAY_COOKING_POT.get(), "Clay Cooking Pot");
        handle.addBlock(BlockRegistration.CLAY_CAULDRON.get(), "Clay Cauldron");
        //handle.addItem(ItemRegistration.JUG.get(), "Jug");

        handle.addBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), "Drying Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), "Drying Kaolin Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CHINA_CLAY_BRICK.get(), "Drying China Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), "Drying Potters Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), "Drying Refractory Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), ".wet", "Wet Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), ".wet", "Wet Kaolin Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CHINA_CLAY_BRICK.get(), ".wet", "Wet China Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), ".wet", "Wet Potters Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), ".wet", "Wet Refractory Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), ".dry", "Unfired Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CHINA_CLAY_BRICK.get(), ".dry", "Unfired China Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), ".dry", "Unfired Kaolin Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), ".dry", "Unfired Potters Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), ".dry", "Unfired Refractory Clay Brick");

        handle.addBlock(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), "Drying Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(),  "Drying China Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(),  "Drying Kaolin Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(),  "Drying Potters Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(),  "Drying Refractory Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet China Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Kaolin Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Potters Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Refractory Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired China Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Kaolin Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Potters Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Refractory Clay Double Brick");
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        // Clay Ball
        handle.addItem(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL.get(), "Kaolin Clay Ball");
        handle.addItem(ClayWorkingItemRegistration.CHINA_CLAY_BALL.get(), "China Clay Ball");
        // handle.addItem(ItemRegistration.CLAY_BALL.get(), "Clay Ball"); // Vanilla
        handle.addItem(ClayWorkingItemRegistration.POTTERS_CLAY_BALL.get(), "Potters Clay Ball");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL.get(), "Refractory Clay Ball");

        // Grog
        handle.addItem(ClayWorkingItemRegistration.GROG.get(), "Grog");
        handle.addItem(ClayWorkingItemRegistration.KAOLIN_GROG.get(), "Kaolin Grog");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_GROG.get(), "Refractory Grog");

        // Brick
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_BRICK.get(), "Unfired Clay Brick");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK.get(), "Unfired Kaolin Clay Brick");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BRICK.get(), "Unfired Potters Clay Brick");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK.get(), "Unfired Refractory Clay Brick");
        //handle.addItem(ItemRegistration.CLAY_BRICK.get(), "Clay Brick"); // Vanilla
        handle.addItem(ClayWorkingItemRegistration.CHINA_CLAY_BRICK.get(), "China Clay Brick");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_BRICK.get(), "Refractory Clay Brick");

        // Double Brick
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK.get(), "Unfired Clay Double Brick");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK.get(), "Unfired Kaolin Clay Double Brick");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK.get(), "Unfired Potters Clay Double Brick");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Unfired Refractory Clay Double Brick");
        handle.addItem(ClayWorkingItemRegistration.CLAY_DOUBLE_BRICK.get(), "Clay Double Brick");
        handle.addItem(ClayWorkingItemRegistration.CHINA_CLAY_DOUBLE_BRICK.get(), "China Clay Double Brick");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Refractory Clay Double Brick");

        // Bucket
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_BUCKET.get(), "Wet Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_BUCKET.get(), "Wet Potters Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_BUCKET.get(), "Wet Refractory Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_BUCKET.get(), "Unfired Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BUCKET.get(), "Unfired Potters Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BUCKET.get(), "Unfired Refractory Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.CLAY_BUCKET.get(), "Clay Bucket");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_BUCKET.get(), "Refractory Clay Bucket");

        // Crucible
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_CRUCIBLE.get(), "Wet Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_CRUCIBLE.get(), "Wet Potters Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_CRUCIBLE.get(), "Wet Refractory Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_CRUCIBLE.get(), "Unfired Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_CRUCIBLE.get(), "Unfired Potters Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_CRUCIBLE.get(), "Unfired Refractory Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.CLAY_CRUCIBLE.get(), "Clay Crucible");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_CRUCIBLE.get(), "Refractory Clay Crucible");

        // Ingot Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_INGOT_MOULD.get(), "Wet Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_INGOT_MOULD.get(), "Wet Potters Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_INGOT_MOULD.get(), "Wet Refractory Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_INGOT_MOULD.get(), "Unfired Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_INGOT_MOULD.get(), "Unfired Potters Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_INGOT_MOULD.get(), "Unfired Refractory Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_INGOT_MOULD.get(), "Clay Ingot Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_INGOT_MOULD.get(), "Refractory Clay Ingot Mould");

        // Axe Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_AXE_MOULD.get(), "Wet Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_AXE_MOULD.get(), "Wet Potters Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_AXE_MOULD.get(), "Wet Refractory Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_AXE_MOULD.get(), "Unfired Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_AXE_MOULD.get(), "Unfired Potters Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_AXE_MOULD.get(), "Unfired Refractory Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_AXE_MOULD.get(), "Clay Axe Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_AXE_MOULD.get(), "Refractory Clay Axe Mould");

        // Greataxe Mould
        //handle.addItem(ClayWorkingItemRegistration.WET_CLAY_GREATAXE_MOULD.get(), "Wet Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_GREATAXE_MOULD.get(), "Wet Potters Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_GREATAXE_MOULD.get(), "Wet Refractory Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_GREATAXE_MOULD.get(), "Unfired Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_GREATAXE_MOULD.get(), "Unfired Potters Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_GREATAXE_MOULD.get(), "Unfired Refractory Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.CLAY_GREATAXE_MOULD.get(), "Clay Greataxe Mould");
        //handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_GREATAXE_MOULD.get(), "Refractory Clay Greataxe Mould");

        // Hoe Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_HOE_MOULD.get(), "Wet Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_HOE_MOULD.get(), "Wet Potters Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_HOE_MOULD.get(), "Wet Refractory Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_HOE_MOULD.get(), "Unfired Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_HOE_MOULD.get(), "Unfired Potters Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_HOE_MOULD.get(), "Unfired Refractory Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_HOE_MOULD.get(), "Clay Hoe Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_HOE_MOULD.get(), "Refractory Clay Hoe Mould");

        // Knife Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_KNIFE_MOULD.get(), "Wet Clay Knife Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_MOULD.get(), "Wet Potters Clay knife Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_KNIFE_MOULD.get(), "Wet Refractory Clay Knife Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_KNIFE_MOULD.get(), "Unfired Clay Knife Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_KNIFE_MOULD.get(), "Unfired Potters Clay Knife Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_KNIFE_MOULD.get(), "Unfired Refractory Clay Knife Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_KNIFE_MOULD.get(), "Clay Knife Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_KNIFE_MOULD.get(), "Refractory Clay Knife Mould");

        // Longsword Mould
        //handle.addItem(ClayWorkingItemRegistration.WET_CLAY_LONGSWORD_MOULD.get(), "Wet Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_LONGSWORD_MOULD.get(), "Wet Potters Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_LONGSWORD_MOULD.get(), "Wet Refractory Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_LONGSWORD_MOULD.get(), "Unfired Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_LONGSWORD_MOULD.get(), "Unfired Potters Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_LONGSWORD_MOULD.get(), "Unfired Refractory Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.CLAY_LONGSWORD_MOULD.get(), "Clay Longsword Mould");
        //handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_LONGSWORD_MOULD.get(), "Refractory Clay Longsword Mould");

        // Pickaxe Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_PICKAXE_MOULD.get(), "Wet Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_PICKAXE_MOULD.get(), "Wet Potters Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_PICKAXE_MOULD.get(), "Wet Refractory Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_PICKAXE_MOULD.get(), "Unfired Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_PICKAXE_MOULD.get(), "Unfired Potters Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_PICKAXE_MOULD.get(), "Unfired Refractory Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_PICKAXE_MOULD.get(), "Clay Pickaxe Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_PICKAXE_MOULD.get(), "Refractory Clay Pickaxe Mould");

        // Shortsword Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_MOULD.get(), "Wet Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_MOULD.get(), "Wet Potters Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SHORTSWORD_MOULD.get(), "Wet Refractory Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_SHORTSWORD_MOULD.get(), "Unfired Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SHORTSWORD_MOULD.get(), "Unfired Potters Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SHORTSWORD_MOULD.get(), "Unfired Refractory Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_SHORTSWORD_MOULD.get(), "Clay Shortsword Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_SHORTSWORD_MOULD.get(), "Refractory Clay Shortsword Mould");

        // Shovel Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_SHOVEL_MOULD.get(), "Wet Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHOVEL_MOULD.get(), "Wet Potters Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SHOVEL_MOULD.get(), "Wet Refractory Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_SHOVEL_MOULD.get(), "Unfired Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SHOVEL_MOULD.get(), "Unfired Potters Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SHOVEL_MOULD.get(), "Unfired Refractory Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_SHOVEL_MOULD.get(), "Clay Shovel Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_SHOVEL_MOULD.get(), "Refractory Clay Shovel Mould");

        // Sickle Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_SICKLE_MOULD.get(), "Wet Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SICKLE_MOULD.get(), "Wet Potters Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SICKLE_MOULD.get(), "Wet Refractory Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_SICKLE_MOULD.get(), "Unfired Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SICKLE_MOULD.get(), "Unfired Potters Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SICKLE_MOULD.get(), "Unfired Refractory Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_SICKLE_MOULD.get(), "Clay Sickle Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_SICKLE_MOULD.get(), "Refractory Clay Sickle Mould");

        // Spear Mould
        handle.addItem(ClayWorkingItemRegistration.WET_CLAY_SPEAR_MOULD.get(), "Wet Clay Spear Mould");
        handle.addItem(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SPEAR_MOULD.get(), "Wet Potters Clay Spear");
        handle.addItem(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SPEAR_MOULD.get(), "Wet Refractory Clay Spear Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_CLAY_SPEAR_MOULD.get(), "Unfired Clay Spear Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SPEAR_MOULD.get(), "Unfired Potters Clay Spear Mould");
        handle.addItem(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SPEAR_MOULD.get(), "Unfired Refractory Clay Spear Mould");
        handle.addItem(ClayWorkingItemRegistration.CLAY_SPEAR_MOULD.get(), "Clay Spear Mould");
        handle.addItem(ClayWorkingItemRegistration.REFRACTORY_CLAY_SPEAR_MOULD.get(), "Refractory Clay Spear Mould");
    }

    private void addCreativeTabTranslations(LanguageEntryProviderHandle handle)
    {
        handle.add("creative_tab.medievalism.pottery.name", "Pottery");
    }

    private void addGUITranslations(LanguageEntryProviderHandle handle)
    {
        handle.add(GatherersJarBlock.LANG_DEFAULT_NAME, "Gatherer's Jar");
        handle.add(KeepersCrockBlock.LANG_DEFAULT_NAME, "Keeper's Crock");
        handle.add(SettlersPotBlock.LANG_DEFAULT_NAME, "Settler's Pot");
    }

    private void addTooltipTranslations(LanguageEntryProviderHandle handle)
    {
        handle.add(GatherersJarBlock.LANG_ITEM_COUNT, "%s x%s");
        handle.add(GatherersJarBlock.LANG_MORE, "and %s more...");
        handle.add(KeepersCrockBlock.LANG_ITEM_COUNT, "%s x%s");
        handle.add(KeepersCrockBlock.LANG_MORE, "and %s more...");
    }
}
