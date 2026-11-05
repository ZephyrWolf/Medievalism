package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.KeepersCrockBlock;
import io.github.zephyrwolf.medievalism.common.block.SettlersPotBlock;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
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
        handle.addBlock(BlockRegistration.DRYING_JUG.get(), "Drying Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), "Drying Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), "Drying Decorated Pot");
        handle.addBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), ".wet", "Wet Gatherer's Jar");
        handle.addBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(), ".wet", "Wet Keeper's Crock");
        handle.addBlock(BlockRegistration.DRYING_SETTLERS_POT.get(), ".wet", "Wet Settler's Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), ".wet", "Wet Clay Cooking Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(), ".wet", "Wet Clay Cauldron");
        handle.addBlock(BlockRegistration.DRYING_JUG.get(), ".wet", "Wet Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), ".wet", "Wet Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), ".wet", "Wet Decorated Pot");
        handle.addBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), ".dry",  "Unfired Gatherer's Jar");
        handle.addBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(), ".dry",  "Unfired Keeper's Crock");
        handle.addBlock(BlockRegistration.DRYING_SETTLERS_POT.get(), ".dry",  "Unfired Settler's Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), ".dry",  "Unfired Clay Cooking Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(), ".dry",  "Unfired Clay Cauldron");
        handle.addBlock(BlockRegistration.DRYING_JUG.get(), ".dry",  "Unfired Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), ".dry",  "Unfired Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), ".dry",  "Unfired Decorated Pot");
        handle.addBlock(BlockRegistration.GATHERERS_JAR.get(), "Gatherer's Jar");
        handle.addBlock(BlockRegistration.KEEPERS_CROCK.get(), "Keeper's Crock");
        handle.addBlock(BlockRegistration.SETTLERS_POT.get(), "Settler's Pot");
        handle.addBlock(BlockRegistration.CLAY_COOKING_POT.get(), "Clay Cooking Pot");
        handle.addBlock(BlockRegistration.CLAY_CAULDRON.get(), "Clay Cauldron");
        handle.addItem(ItemRegistration.JUG.get(), "Jug");

        handle.addBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), "Drying Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), "Drying Kaolin Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), "Drying Potters Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), "Drying Refractory Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), ".wet", "Wet Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), ".wet", "Wet Kaolin Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), ".wet", "Wet Potters Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), ".wet", "Wet Refractory Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_BRICK.get(), ".dry", "Unfired Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), ".dry", "Unfired Kaolin Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_BRICK.get(), ".dry", "Unfired Potters Clay Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), ".dry", "Unfired Refractory Clay Brick");

        handle.addBlock(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), "Drying Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(),  "Drying Kaolin Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(),  "Drying Potters Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(),  "Drying Refractory Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Kaolin Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Potters Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), ".wet", "Wet Refractory Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Kaolin Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Potters Clay Double Brick");
        handle.addBlock(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), ".dry", "Unfired Refractory Clay Double Brick");
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.KAOLIN_CLAY_BALL.get(), "Kaolin Clay Ball");
        handle.addItem(ItemRegistration.POTTERS_CLAY_BALL.get(), "Potters Clay Ball");
        handle.addItem(ItemRegistration.REFRACTORY_CLAY_BALL.get(), "Refractory Clay Ball");
        handle.addItem(ItemRegistration.GROG.get(), "Grog");
        handle.addItem(ItemRegistration.KAOLIN_GROG.get(), "Kaolin Grog");
        handle.addItem(ItemRegistration.REFRACTORY_GROG.get(), "Refractory Grog");

        handle.addItem(ItemRegistration.UNFIRED_CLAY_BRICK.get(), "Unfired Clay Brick");
        handle.addItem(ItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK.get(), "Unfired Kaolin Clay Brick");
        handle.addItem(ItemRegistration.UNFIRED_POTTERS_CLAY_BRICK.get(), "Unfired Potters Clay Brick");
        handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK.get(), "Unfired Refractory Clay Brick");
        //handle.addItem(ItemRegistration.CLAY_BRICK.get(), "Clay Brick");
        handle.addItem(ItemRegistration.KAOLIN_CLAY_BRICK.get(), "Kaolin Clay Brick");
        handle.addItem(ItemRegistration.REFRACTORY_CLAY_BRICK.get(), "Refractory Clay Brick");

        handle.addItem(ItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK.get(), "Unfired Clay Double Brick");
        handle.addItem(ItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK.get(), "Unfired Kaolin Clay Double Brick");
        handle.addItem(ItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK.get(), "Unfired Potters Clay Double Brick");
        handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Unfired Refractory Clay Double Brick");
        handle.addItem(ItemRegistration.CLAY_DOUBLE_BRICK.get(), "Clay Double Brick");
        handle.addItem(ItemRegistration.KAOLIN_CLAY_DOUBLE_BRICK.get(), "Kaolin Clay Double Brick");
        handle.addItem(ItemRegistration.REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Refractory Clay Double Brick");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_BUCKET.get(), "Wet Blue Clay Bucket");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_BUCKET.get(), "Wet Red Clay Bucket");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_BUCKET.get(), "Wet Blue Potters Clay Bucket");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_BUCKET.get(), "Wet Red Potters Clay Bucket");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_BUCKET.get(), "Wet Refractory Clay Bucket");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_BUCKET.get(), "Unfired Blue Clay Bucket");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_BUCKET.get(), "Unfired Red Clay Bucket");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_BUCKET.get(), "Unfired Blue Potters Clay Bucket");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_BUCKET.get(), "Unfired Red Potters Clay Bucket");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_BUCKET.get(), "Unfired Refractory Clay Bucket");
        //handle.addItem(ItemRegistration.EMPTY_CLAY_BUCKET.get(), "Empty Clay Bucket");
        //handle.addItem(ItemRegistration.EMPTY_REFRACTORY_CLAY_BUCKET.get(), "Empty Refractory Clay Bucket");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_CRUCIBLE.get(), "Wet Blue Clay Crucible");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_CRUCIBLE.get(), "Wet Red Clay Crucible");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_CRUCIBLE.get(), "Wet Blue Potters Clay Crucible");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_CRUCIBLE.get(), "Wet Red Potters Clay Crucible");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_CRUCIBLE.get(), "Wet Refractory Clay Crucible");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_CRUCIBLE.get(), "Unfired Blue Clay Crucible");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_CRUCIBLE.get(), "Unfired Red Clay Crucible");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_CRUCIBLE.get(), "Unfired Blue Potters Clay Crucible");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_CRUCIBLE.get(), "Unfired Red Potters Clay Crucible");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_CRUCIBLE.get(), "Unfired Refractory Clay Crucible");
        //handle.addItem(ItemRegistration.EMPTY_CLAY_CRUCIBLE.get(), "Empty Clay Crucible");
        //handle.addItem(ItemRegistration.EMPTY_REFRACTORY_CLAY_CRUCIBLE.get(), "Empty Refractory Clay Crucible");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_INGOT_MOULD.get(), "Wet Blue Clay Ingot Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_INGOT_MOULD.get(), "Wet Red Clay Ingot Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_INGOT_MOULD.get(), "Wet Blue Potters Clay Ingot Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_INGOT_MOULD.get(), "Wet Red Potters Clay Ingot Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_INGOT_MOULD.get(), "Wet Refractory Clay Ingot Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_INGOT_MOULD.get(), "Unfired Blue Clay Ingot Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_INGOT_MOULD.get(), "Unfired Red Clay Ingot Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_INGOT_MOULD.get(), "Unfired Blue Potters Clay Ingot Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_INGOT_MOULD.get(), "Unfired Red Potters Clay Ingot Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_INGOT_MOULD.get(), "Unfired Refractory Clay Ingot Mould");
        //handle.addItem(ItemRegistration.CLAY_INGOT_MOULD.get(), "Clay Ingot Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_INGOT_MOULD.get(), "Refractory Clay Ingot Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_AXE_MOULD.get(), "Wet Blue Clay Axe Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_AXE_MOULD.get(), "Wet Red Clay Axe Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_AXE_MOULD.get(), "Wet Blue Potters Clay Axe Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_AXE_MOULD.get(), "Wet Red Potters Clay Axe Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_AXE_MOULD.get(), "Wet Refractory Clay Axe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_AXE_MOULD.get(), "Unfired Blue Clay Axe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_AXE_MOULD.get(), "Unfired Red Clay Axe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_AXE_MOULD.get(), "Unfired Blue Potters Clay Axe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_AXE_MOULD.get(), "Unfired Red Potters Clay Axe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_AXE_MOULD.get(), "Unfired Refractory Clay Axe Mould");
        //handle.addItem(ItemRegistration.CLAY_AXE_MOULD.get(), "Clay Axe Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_AXE_MOULD.get(), "Refractory Clay Axe Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_GREATAXE_MOULD.get(), "Wet Blue Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_GREATAXE_MOULD.get(), "Wet Red Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_GREATAXE_MOULD.get(), "Wet Blue Potters Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_GREATAXE_MOULD.get(), "Wet Red Potters Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_GREATAXE_MOULD.get(), "Wet Refractory Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_GREATAXE_MOULD.get(), "Unfired Blue Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_GREATAXE_MOULD.get(), "Unfired Red Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_GREATAXE_MOULD.get(), "Unfired Blue Potters Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_GREATAXE_MOULD.get(), "Unfired Red Potters Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_GREATAXE_MOULD.get(), "Unfired Refractory Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.CLAY_GREATAXE_MOULD.get(), "Clay Greataxe Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_GREATAXE_MOULD.get(), "Refractory Clay Greataxe Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_HOE_MOULD.get(), "Wet Blue Clay Hoe Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_HOE_MOULD.get(), "Wet Red Clay Hoe Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_HOE_MOULD.get(), "Wet Blue Potters Clay Hoe Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_HOE_MOULD.get(), "Wet Red Potters Clay Hoe Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_HOE_MOULD.get(), "Wet Refractory Clay Hoe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_HOE_MOULD.get(), "Unfired Blue Clay Hoe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_HOE_MOULD.get(), "Unfired Red Clay Hoe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_HOE_MOULD.get(), "Unfired Blue Potters Clay Hoe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_HOE_MOULD.get(), "Unfired Red Potters Clay Hoe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_HOE_MOULD.get(), "Unfired Refractory Clay Hoe Mould");
        //handle.addItem(ItemRegistration.CLAY_HOE_MOULD.get(), "Clay Hoe Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_HOE_MOULD.get(), "Refractory Clay Hoe Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_KNIFE_MOULD.get(), "Wet Blue Clay Knife Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_KNIFE_MOULD.get(), "Wet Red Clay Knife Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_KNIFE_MOULD.get(), "Wet Blue Potters Clay knife Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_KNIFE_MOULD.get(), "Wet Red Potters Clay Knife Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_KNIFE_MOULD.get(), "Wet Refractory Clay Knife Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_KNIFE_MOULD.get(), "Unfired Blue Clay Knife Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_KNIFE_MOULD.get(), "Unfired Red Clay Knife Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_KNIFE_MOULD.get(), "Unfired Blue Potters Clay Knife Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_KNIFE_MOULD.get(), "Unfired Red Potters Clay Knife Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_KNIFE_MOULD.get(), "Unfired Refractory Clay Knife Mould");
        //handle.addItem(ItemRegistration.CLAY_KNIFE_MOULD.get(), "Clay Knife Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_KNIFE_MOULD.get(), "Refractory Clay Knife Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_LONGSWORD_MOULD.get(), "Wet Blue Clay Longsword Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_LONGSWORD_MOULD.get(), "Wet Red Clay Longsword Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_LONGSWORD_MOULD.get(), "Wet Blue Potters Clay Longsword Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_LONGSWORD_MOULD.get(), "Wet Red Potters Clay Longsword Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_LONGSWORD_MOULD.get(), "Wet Refractory Clay Longsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_LONGSWORD_MOULD.get(), "Unfired Blue Clay Longsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_LONGSWORD_MOULD.get(), "Unfired Red Clay Longsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_LONGSWORD_MOULD.get(), "Unfired Blue Potters Clay Longsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_LONGSWORD_MOULD.get(), "Unfired Red Potters Clay Longsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_LONGSWORD_MOULD.get(), "Unfired Refractory Clay Longsword Mould");
        //handle.addItem(ItemRegistration.CLAY_LONGSWORD_MOULD.get(), "Clay Longsword Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_LONGSWORD_MOULD.get(), "Refractory Clay Longsword Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_PICKAXE_MOULD.get(), "Wet Blue Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_PICKAXE_MOULD.get(), "Wet Red Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_PICKAXE_MOULD.get(), "Wet Blue Potters Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_PICKAXE_MOULD.get(), "Wet Red Potters Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_PICKAXE_MOULD.get(), "Wet Refractory Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_PICKAXE_MOULD.get(), "Unfired Blue Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_PICKAXE_MOULD.get(), "Unfired Red Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_PICKAXE_MOULD.get(), "Unfired Blue Potters Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_PICKAXE_MOULD.get(), "Unfired Red Potters Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_PICKAXE_MOULD.get(), "Unfired Refractory Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.CLAY_PICKAXE_MOULD.get(), "Clay Pickaxe Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_PICKAXE_MOULD.get(), "Refractory Clay Pickaxe Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_SHORTSWORD_MOULD.get(), "Wet Blue Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_SHORTSWORD_MOULD.get(), "Wet Red Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_SHORTSWORD_MOULD.get(), "Wet Blue Potters Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_SHORTSWORD_MOULD.get(), "Wet Red Potters Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_SHORTSWORD_MOULD.get(), "Wet Refractory Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_SHORTSWORD_MOULD.get(), "Unfired Blue Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_SHORTSWORD_MOULD.get(), "Unfired Red Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SHORTSWORD_MOULD.get(), "Unfired Blue Potters Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SHORTSWORD_MOULD.get(), "Unfired Red Potters Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SHORTSWORD_MOULD.get(), "Unfired Refractory Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.CLAY_SHORTSWORD_MOULD.get(), "Clay Shortsword Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_SHORTSWORD_MOULD.get(), "Refractory Clay Shortsword Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_SHOVEL_MOULD.get(), "Wet Blue Clay Shovel Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_SHOVEL_MOULD.get(), "Wet Red Clay Shove Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_SHOVEL_MOULD.get(), "Wet Blue Potters Clay Shovel Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_SHOVEL_MOULD.get(), "Wet Red Potters Clay Shovel Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_SHOVEL_MOULD.get(), "Wet Refractory Clay Shovel Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_SHOVEL_MOULD.get(), "Unfired Blue Clay Shovel Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_SHOVEL_MOULD.get(), "Unfired Red Clay Shovel Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SHOVEL_MOULD.get(), "Unfired Blue Potters Clay Shovel Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SHOVEL_MOULD.get(), "Unfired Red Potters Clay Shovel Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SHOVEL_MOULD.get(), "Unfired Refractory Clay Shovel Mould");
        //handle.addItem(ItemRegistration.CLAY_SHOVEL_MOULD.get(), "Clay Shovel Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_SHOVEL_MOULD.get(), "Refractory Clay Shovel Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_SICKLE_MOULD.get(), "Wet Blue Clay Sickle Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_SICKLE_MOULD.get(), "Wet Red Clay Sickle Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_SICKLE_MOULD.get(), "Wet Blue Potters Clay Sickle Mould");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_SICKLE_MOULD.get(), "Wet Red Potters Clay Sickle Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_SICKLE_MOULD.get(), "Wet Refractory Clay Sickle Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_SICKLE_MOULD.get(), "Unfired Blue Clay Sickle Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_SICKLE_MOULD.get(), "Unfired Red Clay Sickle Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SICKLE_MOULD.get(), "Unfired Blue Potters Clay Sickle Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SICKLE_MOULD.get(), "Unfired Red Potters Clay Sickle Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SICKLE_MOULD.get(), "Unfired Refractory Clay Sickle Mould");
        //handle.addItem(ItemRegistration.CLAY_SICKLE_MOULD.get(), "Clay Sickle Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_SICKLE_MOULD.get(), "Refractory Clay Sickle Mould");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_SPEAR_MOULD.get(), "Wet Blue Clay Spear Mould");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_SPEAR_MOULD.get(), "Wet Red Clay Spear Mould");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_SPEAR_MOULD.get(), "Wet Blue Potters Clay Spear");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_SPEAR_MOULD.get(), "Wet Red Potters Clay Spear Mould");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_SPEAR_MOULD.get(), "Wet Refractory Clay Spear Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_SPEAR_MOULD.get(), "Unfired Blue Clay Spear Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_SPEAR_MOULD.get(), "Unfired Red Clay Spear Mould");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SPEAR_MOULD.get(), "Unfired Blue Potters Clay Spear Mould");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SPEAR_MOULD.get(), "Unfired Red Potters Clay Spear Mould");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SPEAR_MOULD.get(), "Unfired Refractory Clay Spear Mould");
        //handle.addItem(ItemRegistration.CLAY_SPEAR_MOULD.get(), "Clay Spear Mould");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_SPEAR_MOULD.get(), "Refractory Clay Spear Mould");
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
