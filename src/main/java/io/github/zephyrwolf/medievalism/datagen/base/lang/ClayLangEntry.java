package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.KeepersCrockBlock;
import io.github.zephyrwolf.medievalism.common.block.SettlersPotBlock;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class ClayLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageProviderHandle handle)
    {
        handle.addBlock(BlockRegistration.DRYING_GATHERERS_JAR.get(), "Drying Gatherer's Jar");
        handle.addBlock(BlockRegistration.DRYING_KEEPERS_CROCK.get(), "Drying Keeper's Crock");
        handle.addBlock(BlockRegistration.DRYING_SETTLERS_POT.get(), "Drying Settler's Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), "Drying Clay Cooking Pot");
        handle.addBlock(BlockRegistration.DRYING_CLAY_CAULDRON.get(), "Drying Clay Cauldron");
        handle.addBlock(BlockRegistration.DRYING_JUG.get(), "Drying Jug");
        handle.addBlock(BlockRegistration.DRYING_FLOWER_POT.get(), "Drying Flower Pot");
        handle.addBlock(BlockRegistration.DRYING_DECORATED_POT.get(), "Drying Decorated Pot");
    }

    private void addBlockItemTranslations(LanguageProviderHandle handle)
    {
        handle.addBlockItem(BlockItemRegistration.WET_CLAY_BRICK.get(), "Wet Clay Brick");
        handle.addBlockItem(BlockItemRegistration.WET_GATHERERS_JAR.get(), "Wet Gatherer's Jar");
        handle.addBlockItem(BlockItemRegistration.DRY_GATHERERS_JAR.get(), "Unfired Gatherer's Jar");
        handle.addBlockItem(BlockItemRegistration.GATHERERS_JAR.get(), "Gatherer's Jar");
        handle.addBlockItem(BlockItemRegistration.WET_KEEPERS_CROCK.get(), "Wet Keeper's Crock");
        handle.addBlockItem(BlockItemRegistration.DRY_KEEPERS_CROCK.get(), "Unfired Keeper's Crock");
        handle.addBlockItem(BlockItemRegistration.KEEPERS_CROCK.get(), "Keeper's Crock");
        handle.addBlockItem(BlockItemRegistration.WET_SETTLERS_POT.get(), "Wet Settler's Pot");
        handle.addBlockItem(BlockItemRegistration.DRY_SETTLERS_POT.get(), "Unfired Settler's Pot");
        handle.addBlockItem(BlockItemRegistration.SETTLERS_POT.get(), "Settler's Pot");
        handle.addBlockItem(BlockItemRegistration.WET_CLAY_COOKING_POT.get(), "Wet Clay Cooking Pot");
        handle.addBlockItem(BlockItemRegistration.DRY_CLAY_COOKING_POT.get(), "Unfired Clay Cooking Pot");
        handle.addBlockItem(BlockItemRegistration.CLAY_COOKING_POT.get(), "Clay Cooking Pot");
        handle.addBlockItem(BlockItemRegistration.WET_CLAY_CAULDRON.get(), "Wet Clay Cauldron");
        handle.addBlockItem(BlockItemRegistration.DRY_CLAY_CAULDRON.get(), "Unfired Clay Cauldron");
        handle.addBlockItem(BlockItemRegistration.CLAY_CAULDRON.get(), "Clay Cauldron");
        handle.addBlockItem(BlockItemRegistration.WET_JUG.get(), "Wet Jug");
        handle.addBlockItem(BlockItemRegistration.DRY_JUG.get(), "Unfired Jug");
        handle.addBlockItem(BlockItemRegistration.JUG.get(), "Jug");
        handle.addBlockItem(BlockItemRegistration.WET_FLOWER_POT.get(), "Wet Flower Pot");
        handle.addBlockItem(BlockItemRegistration.DRY_FLOWER_POT.get(), "Unfired Flower Pot");
        handle.addBlockItem(BlockItemRegistration.WET_DECORATED_POT.get(), "Wet Decorated Pot");
        handle.addBlockItem(BlockItemRegistration.DRY_DECORATED_POT.get(), "Unfired Decorated Pot");

        //handle.addBlockItem(BlockItemRegistration.WET_CLAY_BRICK.get(), "Wet Clay Brick");
        //handle.addBlockItem(BlockItemRegistration.WET_RED_CLAY_BRICK.get(), "Wet Red Clay Brick");
        //handle.addBlockItem(BlockItemRegistration.WET_GATHERERS_JAR.get(), "Wet Gatherer's Jar");
        //handle.addBlockItem(BlockItemRegistration.DRY_GATHERERS_JAR.get(), "Unfired Gatherer's Jar");
        //handle.addBlockItem(BlockItemRegistration.GATHERERS_JAR.get(), "Gatherer's Jar");
        //handle.addBlockItem(BlockItemRegistration.WET_KEEPERS_CROCK.get(), "Wet Keeper's Crock");
        //handle.addBlockItem(BlockItemRegistration.DRY_KEEPERS_CROCK.get(), "Unfired Keeper's Crock");
        //handle.addBlockItem(BlockItemRegistration.KEEPERS_CROCK.get(), "Keeper's Crock");
        //handle.addBlockItem(BlockItemRegistration.WET_SETTLERS_POT.get(), "Wet Settler's Pot");
        //handle.addBlockItem(BlockItemRegistration.DRY_SETTLERS_POT.get(), "Unfired Settler's Pot");
        //handle.addBlockItem(BlockItemRegistration.SETTLERS_POT.get(), "Settler's Pot");
        //handle.addBlockItem(BlockItemRegistration.WET_CLAY_COOKING_POT.get(), "Wet Clay Cooking Pot");
        //handle.addBlockItem(BlockItemRegistration.DRY_CLAY_COOKING_POT.get(), "Unfired Clay Cooking Pot");
        //handle.addBlockItem(BlockItemRegistration.CLAY_COOKING_POT.get(), "Clay Cooking Pot");
        //handle.addBlockItem(BlockItemRegistration.WET_CLAY_CAULDRON.get(), "Wet Clay Cauldron");
        //handle.addBlockItem(BlockItemRegistration.DRY_CLAY_CAULDRON.get(), "Unfired Clay Cauldron");
        //handle.addBlockItem(BlockItemRegistration.CLAY_CAULDRON.get(), "Clay Cauldron");
        //handle.addBlockItem(BlockItemRegistration.WET_JUG.get(), "Wet Jug");
        //handle.addBlockItem(BlockItemRegistration.DRY_JUG.get(), "Unfired Jug");
        //handle.addBlockItem(BlockItemRegistration.JUG.get(), "Jug");
        //handle.addBlockItem(BlockItemRegistration.WET_FLOWER_POT.get(), "Wet Flower Pot");
        //handle.addBlockItem(BlockItemRegistration.DRY_FLOWER_POT.get(), "Unfired Flower Pot");
        //handle.addBlockItem(BlockItemRegistration.WET_DECORATED_POT.get(), "Wet Decorated Pot");
        //handle.addBlockItem(BlockItemRegistration.DRY_DECORATED_POT.get(), "Unfired Decorated Pot");
        //handle.addBlockItem(BlockItemRegistration.RED_CLAY_BLOCK.get(), "Red Clay");
    }

    private void addItemTranslations(LanguageProviderHandle handle)
    {
        //handle.addItem(ItemRegistration.KAOLIN_CLAY_BALL.get(), "Kaolin Clay Ball");
        //handle.addItem(ItemRegistration.BLUE_POTTERS_CLAY_BALL.get(), "Blue Potters Clay Ball");
        //handle.addItem(ItemRegistration.RED_POTTERS_CLAY_BALL.get(), "Red Potters Clay Ball");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_BALL.get(), "Refractory Clay Ball");
        //handle.addItem(ItemRegistration.GROG.get(), "Grog");
        //handle.addItem(ItemRegistration.KAOLIN_GROG.get(), "Kaolin Grog");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_BRICK.get(), "Wet Blue Clay Brick");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_BRICK.get(), "Wet Red Clay Brick");
        //handle.addItem(ItemRegistration.WET_KAOLIN_CLAY_BRICK.get(), "Wet Kaolin Clay Brick");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_BRICK.get(), "Wet Blue Potters Clay Brick");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_BRICK.get(), "Wet Red Potters Clay Brick");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_BRICK.get(), "Wet Refractory Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_BRICK.get(), "Unfired Blue Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_BRICK.get(), "Unfired Red Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK.get(), "Unfired Kaolin Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_BRICK.get(), "Unfired Blue Potters Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_BRICK.get(), "Unfired Red Potters Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK.get(), "Unfired Refractory Clay Brick");
        //handle.addItem(ItemRegistration.CLAY_BRICK.get(), "Clay Brick");
        //handle.addItem(ItemRegistration.KAOLIN_CLAY_BRICK.get(), "Kaolin Clay Brick");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_BRICK.get(), "Refractory Clay Brick");

        //handle.addItem(ItemRegistration.WET_BLUE_CLAY_DOUBLE_BRICK.get(), "Wet Blue Double Clay Brick");
        //handle.addItem(ItemRegistration.WET_RED_CLAY_DOUBLE_BRICK.get(), "Wet Red Double Clay Brick");
        //handle.addItem(ItemRegistration.WET_KAOLIN_CLAY_DOUBLE_BRICK.get(), "Wet Kaolin Double Clay Brick");
        //handle.addItem(ItemRegistration.WET_BLUE_POTTERS_CLAY_DOUBLE_BRICK.get(), "Wet Blue Potters Double Clay Brick");
        //handle.addItem(ItemRegistration.WET_RED_POTTERS_CLAY_DOUBLE_BRICK.get(), "Wet Red Potters Double Clay Brick");
        //handle.addItem(ItemRegistration.WET_REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Wet Refractory Double Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_CLAY_DOUBLE_BRICK.get(), "Unfired Blue Double Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_RED_CLAY_DOUBLE_BRICK.get(), "Unfired Red Double Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK.get(), "Unfired Kaolin Double Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_DOUBLE_BRICK.get(), "Unfired Blue Potters Double Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_DOUBLE_BRICK.get(), "Unfired Red Potters Double Clay Brick");
        //handle.addItem(ItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Unfired Refractory Double Clay Brick");
        //handle.addItem(ItemRegistration.CLAY_DOUBLE_BRICK.get(), "Double Clay Brick");
        //handle.addItem(ItemRegistration.KAOLIN_CLAY_DOUBLE_BRICK.get(), "Kaolin Double Clay Brick");
        //handle.addItem(ItemRegistration.REFRACTORY_CLAY_DOUBLE_BRICK.get(), "Refractory Double Clay Brick");

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

    private void addCreativeTabTranslations(LanguageProviderHandle handle)
    {
        handle.add("creative_tab.medievalism.pottery.name", "Pottery");
    }

    private void addGUITranslations(LanguageProviderHandle handle)
    {
        handle.add(GatherersJarBlock.LANG_DEFAULT_NAME, "Gatherer's Jar");
        handle.add(KeepersCrockBlock.LANG_DEFAULT_NAME, "Keeper's Crock");
        handle.add(SettlersPotBlock.LANG_DEFAULT_NAME, "Settler's Pot");
    }

    private void addTooltipTranslations(LanguageProviderHandle handle)
    {
        handle.add(GatherersJarBlock.LANG_ITEM_COUNT, "%s x%s");
        handle.add(GatherersJarBlock.LANG_MORE, "and %s more...");
        handle.add(KeepersCrockBlock.LANG_ITEM_COUNT, "%s x%s");
        handle.add(KeepersCrockBlock.LANG_MORE, "and %s more...");
    }
}
