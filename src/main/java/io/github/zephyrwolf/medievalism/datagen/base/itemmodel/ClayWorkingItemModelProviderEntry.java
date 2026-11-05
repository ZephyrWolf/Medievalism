package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class ClayWorkingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        worldGen(handle);
        materials(handle);
        brick(handle);
        double_brick(handle);
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

    private void worldGen(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");
        handle.blockBasedModel(ItemRegistration.CLAY_IN_GRASS.get(), "1");
        handle.blockBasedModel(ItemRegistration.CLAY_IN_DIRT.get(), "1");
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working");
        handle.itemGeneratedModel(ItemRegistration.POTTERS_CLAY_BALL.get());
        handle.itemGeneratedModel(ItemRegistration.KAOLIN_CLAY_BALL.get());
        handle.itemGeneratedModel(ItemRegistration.GROG.get());
        handle.itemGeneratedModel(ItemRegistration.KAOLIN_GROG.get());
        //handle.itemGeneratedModel(ItemRegistration.KAOLINITE.get()); // Not sure if I want to add this
        handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_BALL.get());
        handle.itemGeneratedModel(ItemRegistration.REFRACTORY_GROG.get());
    }

    private void brick(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/brick");
        handle.itemGeneratedModel(ItemRegistration.DRYING_CLAY_BRICK.get(), handle.resourceItem("wet_clay_brick"));
        handle.itemGeneratedModel(ItemRegistration.DRYING_POTTERS_CLAY_BRICK.get(), handle.resourceItem("wet_potters_clay_brick"));
        handle.itemGeneratedModel(ItemRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), handle.resourceItem("wet_kaolin_clay_brick"));
        handle.itemGeneratedModel(ItemRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), handle.resourceItem("wet_refractory_clay_brick"));
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_CLAY_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_POTTERS_CLAY_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.CLAY_BRICK.get()); // Vanilla
        handle.itemGeneratedModel(ItemRegistration.KAOLIN_CLAY_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_BRICK.get());
    }

    private void double_brick(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/brick");
        handle.itemGeneratedModel(ItemRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_clay_double_brick"));
        handle.itemGeneratedModel(ItemRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_potters_clay_double_brick"));
        handle.itemGeneratedModel(ItemRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_kaolin_clay_double_brick"));
        handle.itemGeneratedModel(ItemRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_refractory_clay_double_brick"));
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.KAOLIN_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY_DOUBLE_BRICK.get());
    }

    private void bucket(ItemModelEntryProviderHandle handle)
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

    private void crucible(ItemModelEntryProviderHandle handle)
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

    private void ingotMould(ItemModelEntryProviderHandle handle)
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

    private void axeMould(ItemModelEntryProviderHandle handle)
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

    private void hoeMould(ItemModelEntryProviderHandle handle)
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

    private void knifeMould(ItemModelEntryProviderHandle handle)
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

    private void pickaxeMould(ItemModelEntryProviderHandle handle)
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

    private void shortswordMould(ItemModelEntryProviderHandle handle)
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

    private void shovelMould(ItemModelEntryProviderHandle handle)
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

    private void sickleMould(ItemModelEntryProviderHandle handle)
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

    private void spearMould(ItemModelEntryProviderHandle handle)
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

    private void longswordMould(ItemModelEntryProviderHandle handle)
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

    private void greataxeMould(ItemModelEntryProviderHandle handle)
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

    private void containers(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");
        handle.blockBasedModel(ItemRegistration.WET_GATHERERS_JAR.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_GATHERERS_JAR.get(), "");
        handle.blockBasedModel(ItemRegistration.GATHERERS_JAR.get(), "");

        handle.blockBasedModel(ItemRegistration.WET_KEEPERS_CROCK.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_KEEPERS_CROCK.get(), "");
        handle.blockBasedModel(ItemRegistration.KEEPERS_CROCK.get(), "");

        handle.blockBasedModel(ItemRegistration.WET_SETTLERS_POT.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_SETTLERS_POT.get(), "");
        handle.blockBasedModel(ItemRegistration.SETTLERS_POT.get(), "");

        handle.blockBasedModel(ItemRegistration.WET_CLAY_COOKING_POT.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_CLAY_COOKING_POT.get(), "");
        handle.blockBasedModel(ItemRegistration.CLAY_COOKING_POT.get(), "");

        handle.blockBasedModel(ItemRegistration.WET_CLAY_CAULDRON.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_CLAY_CAULDRON.get(), "");
        handle.blockBasedModel(ItemRegistration.CLAY_CAULDRON.get(), "");

        handle.blockBasedModel(ItemRegistration.WET_JUG.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_JUG.get(), "");
        handle.blockBasedModel(ItemRegistration.JUG.get(), "");
    }

    private void decoration(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.WET_FLOWER_POT.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_FLOWER_POT.get(), "");

        handle.blockBasedModel(ItemRegistration.WET_DECORATED_POT.get(), "");
        handle.blockBasedModel(ItemRegistration.DRY_DECORATED_POT.get(), "");
    }
}
