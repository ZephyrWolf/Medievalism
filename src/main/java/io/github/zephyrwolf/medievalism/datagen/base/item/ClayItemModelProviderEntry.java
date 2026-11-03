package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class ClayItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        worldGen(handle);
        materials(handle);
        brick(handle);
        bucket(handle);
        crucible(handle);
        ingotMould(handle);
        axeMould(handle);
        hoeMould(handle);
        knifeMould(handle);
        pickaxeMould(handle);
        shortswordMould(handle);
        shovelMould(handle);
        sickleMould(handle);
        spearMould(handle);
        longswordMould(handle);
        greataxeMould(handle);
        //scythMould(handle); // in textures/items/scyth
        //birchPot(handle); // in textures/items/birch_pot
        //jug(handle); // in textures/items/jug
        //pot(handle); // in textures/items/pot
        containers(handle);
        decoration(handle);
    }

    private void worldGen(ItemModelProviderHandle handle)
    {
        handle.setFolder("");
        handle.blockBasedModel(BlockItemRegistration.CLAY_IN_GRASS.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.CLAY_IN_DIRT.get(), "1");
    }

    private void materials(ItemModelProviderHandle handle)
    {
        handle.setFolder("");

        handle.setFolder("clay");
        //handle.itemGeneratedModel(ItemRegistration.BLUE_CLAY_BALL); // Vanilla
        //handle.itemGeneratedModel(ItemRegistration.BLUE_POTTERS_CLAY_BALL.get());
        //handle.itemGeneratedModel(ItemRegistration.RED_POTTERS_CLAY_BALL.get());
        //handle.itemGeneratedModel(ItemRegistration.KAOLIN_CLAY_BALL.get());
        //handle.itemGeneratedModel(ItemRegistration.GROG.get());
        //handle.itemGeneratedModel(ItemRegistration.KAOLIN_GROG.get());
        ////handle.itemGeneratedModel(ItemRegistration.KAOLINITE.get()); // Not sure if I want to add this
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_BALL.get());
    }

    private void brick(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/brick");

        handle.itemGeneratedModel(BlockItemRegistration.WET_CLAY_BRICK.get());

        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_KAOLIN_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK.get());
        ////handle.itemGeneratedModel(ItemRegistration.CLAY_BRICK.get()); // Vanilla
        //handle.itemGeneratedModel(ItemRegistration.KAOLIN_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_KAOLIN_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.KAOLIN_CLAY_DOUBLE_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_DOUBLE_BRICK.get());
    }

    private void bucket(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/bucket");
        //handle.itemGeneratedModel(ItemRegistration.EMPTY_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.EMPTY_REFRACTORY_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_BUCKET.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_BUCKET.get());
    }

    private void crucible(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/crucible");
        //handle.itemGeneratedModel(ItemRegistration.EMPTY_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.EMPTY_REFRACTORY_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_CRUCIBLE.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_CRUCIBLE.get());
    }

    private void ingotMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/ingot_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_INGOT_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_INGOT_MOULD.get());
    }

    private void axeMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/axe_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_AXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_AXE_MOULD.get());
    }

    private void hoeMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/hoe_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_HOE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_HOE_MOULD.get());
    }

    private void knifeMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/knife_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_KNIFE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_KNIFE_MOULD.get());
    }

    private void pickaxeMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/pickaxe_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_PICKAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_PICKAXE_MOULD.get());
    }

    private void shortswordMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/shortsword_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_SHORTSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_SHORTSWORD_MOULD.get());
    }

    private void shovelMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/shovel_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_SHOVEL_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_SHOVEL_MOULD.get());
    }

    private void sickleMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/sickle_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_SICKLE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_SICKLE_MOULD.get());
    }

    private void spearMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/spear_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_SPEAR_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_SPEAR_MOULD.get());
    }

    private void longswordMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/longsword_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_LONGSWORD_MOULD.get());
    }

    private void greataxeMould(ItemModelProviderHandle handle)
    {
        handle.setFolder("clay/greataxe_mould");
        //handle.itemGeneratedModel(ItemRegistration.CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_BLUE_POTTERS_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_RED_POTTERS_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_BLUE_POTTERS_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_RED_POTTERS_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ItemRegistration.WET_REFRACTORY_CLAY_GREATAXE_MOULD.get());
    }

    private void containers(ItemModelProviderHandle handle)
    {
        handle.setFolder("");
        handle.blockBasedModel(BlockItemRegistration.WET_GATHERERS_JAR.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_GATHERERS_JAR.get(), "");
        handle.blockBasedModel(BlockItemRegistration.GATHERERS_JAR.get(), "");

        handle.blockBasedModel(BlockItemRegistration.WET_KEEPERS_CROCK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_KEEPERS_CROCK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.KEEPERS_CROCK.get(), "");

        handle.blockBasedModel(BlockItemRegistration.WET_SETTLERS_POT.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_SETTLERS_POT.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SETTLERS_POT.get(), "");

        handle.blockBasedModel(BlockItemRegistration.WET_CLAY_COOKING_POT.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_CLAY_COOKING_POT.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CLAY_COOKING_POT.get(), "");

        handle.blockBasedModel(BlockItemRegistration.WET_CLAY_CAULDRON.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_CLAY_CAULDRON.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CLAY_CAULDRON.get(), "");

        handle.blockBasedModel(BlockItemRegistration.WET_JUG.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_JUG.get(), "");
        handle.blockBasedModel(BlockItemRegistration.JUG.get(), "");
    }

    private void decoration(ItemModelProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(BlockItemRegistration.WET_FLOWER_POT.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_FLOWER_POT.get(), "");

        handle.blockBasedModel(BlockItemRegistration.WET_DECORATED_POT.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DRY_DECORATED_POT.get(), "");
    }
}
