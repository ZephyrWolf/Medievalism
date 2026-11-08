package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ClayWorkingItemRegistration;
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
        handle.itemGeneratedModel(ClayWorkingItemRegistration.POTTERS_CLAY_BALL.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CHINA_CLAY_BALL.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.KAOLIN_CLAY_BALL.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.GROG.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.KAOLIN_GROG.get());
        //handle.itemGeneratedModel(ItemRegistration.KAOLINITE.get()); // Not sure if I want to add this
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_GROG.get());

        handle.setFolder("");
        handle.blockBasedModel(ClayWorkingItemRegistration.POTTERS_CLAY.get());
        handle.blockBasedModel(ClayWorkingItemRegistration.KAOLIN_CLAY.get());
        handle.blockBasedModel(ClayWorkingItemRegistration.CHINA_CLAY.get());
        handle.blockBasedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY.get());
    }

    private void brick(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/brick");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_CLAY_BRICK.get(), handle.resourceItem("wet_clay_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_CHINA_CLAY_BRICK.get(), handle.resourceItem("wet_china_clay_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_BRICK.get(), handle.resourceItem("wet_potters_clay_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_BRICK.get(), handle.resourceItem("wet_kaolin_clay_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_BRICK.get(), handle.resourceItem("wet_refractory_clay_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CHINA_CLAY_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BRICK.get());
        //handle.itemGeneratedModel(ItemRegistration.CLAY_BRICK.get()); // Vanilla
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CHINA_CLAY_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_BRICK.get());
    }

    private void double_brick(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/brick");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_clay_double_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_china_clay_double_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_potters_clay_double_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_kaolin_clay_double_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK.get(), handle.resourceItem("wet_refractory_clay_double_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CHINA_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_DOUBLE_BRICK.get(), handle.resourceItem("double_brick"));
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CHINA_CLAY_DOUBLE_BRICK.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_DOUBLE_BRICK.get());
    }

    private void bucket(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/bucket");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_BUCKET.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_BUCKET.get());
    }

    private void crucible(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/crucible");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_CRUCIBLE.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_CRUCIBLE.get());
    }

    private void ingotMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/ingot_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_INGOT_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_INGOT_MOULD.get());
    }

    private void axeMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/axe_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_AXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_AXE_MOULD.get());
    }

    private void hoeMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/hoe_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_HOE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_HOE_MOULD.get());
    }

    private void knifeMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/knife_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_KNIFE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_KNIFE_MOULD.get());
    }

    private void pickaxeMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/pickaxe_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_PICKAXE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_PICKAXE_MOULD.get());
    }

    private void shortswordMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/shortsword_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHORTSWORD_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SHORTSWORD_MOULD.get());
    }

    private void shovelMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/shovel_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SHOVEL_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SHOVEL_MOULD.get());
    }

    private void sickleMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/sickle_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SICKLE_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SICKLE_MOULD.get());
    }

    private void spearMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/spear_mould");
        handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_SPEAR_MOULD.get());
        handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_SPEAR_MOULD.get());
    }

    private void longswordMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/longsword_mould");
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_LONGSWORD_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_LONGSWORD_MOULD.get());
    }

    private void greataxeMould(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("clay_working/greataxe_mould");
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.REFRACTORY_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_POTTERS_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.UNFIRED_REFRACTORY_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_POTTERS_CLAY_GREATAXE_MOULD.get());
        //handle.itemGeneratedModel(ClayWorkingItemRegistration.WET_REFRACTORY_CLAY_GREATAXE_MOULD.get());
    }

    private void containers(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");
        handle.blockBasedModel(ClayWorkingItemRegistration.WET_GATHERERS_JAR.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_GATHERERS_JAR.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.GATHERERS_JAR.get(), "");

        handle.blockBasedModel(ClayWorkingItemRegistration.WET_KEEPERS_CROCK.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_KEEPERS_CROCK.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.KEEPERS_CROCK.get(), "");

        handle.blockBasedModel(ClayWorkingItemRegistration.WET_SETTLERS_POT.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_SETTLERS_POT.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.SETTLERS_POT.get(), "");

        handle.blockBasedModel(ClayWorkingItemRegistration.WET_CLAY_COOKING_POT.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_CLAY_COOKING_POT.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.CLAY_COOKING_POT.get(), "");

        handle.blockBasedModel(ClayWorkingItemRegistration.WET_CLAY_CAULDRON.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_CLAY_CAULDRON.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.CLAY_CAULDRON.get(), "");

        //handle.blockBasedModel(ClayWorkingItemRegistration.WET_JUG.get(), "");
        //handle.blockBasedModel(ClayWorkingItemRegistration.DRY_JUG.get(), "");
        //handle.blockBasedModel(ClayWorkingItemRegistration.JUG.get(), "");
    }

    private void decoration(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ClayWorkingItemRegistration.WET_FLOWER_POT.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_FLOWER_POT.get(), "");

        handle.blockBasedModel(ClayWorkingItemRegistration.WET_DECORATED_POT.get(), "");
        handle.blockBasedModel(ClayWorkingItemRegistration.DRY_DECORATED_POT.get(), "");
    }
}
