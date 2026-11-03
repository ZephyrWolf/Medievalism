package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;

public class RockItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        rock(handle);
        largeRock(handle);
        copperRock(handle);
        stone(handle);
        looseStone(handle);
        gravel(handle);
        infestedStone(handle);
        cobbled(handle);
        infestedCobbled(handle);
        copperOre(handle);
        ironOre(handle);
        goldOre(handle);
        coalOre(handle);
        diamondOre(handle);
        emeraldOre(handle);
        lapisOre(handle);
        redstoneOre(handle);
        chertOre(handle);
        geodeOre(handle);
        tinOre(handle);
        materials(handle);
        tools(handle);
        workstations(handle);
    }

    private void rock(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.RED_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SAPROLITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LATERITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SILT_CLUMP.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.GREYWACKE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SILTSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.DOLOSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.IRONSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SHALE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.ARKOSE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.MARBLE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.QUARTZITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.HORNFELS_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SLATE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.GABBRO_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.NORITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_ROCK.get(), "1");
    }

    private void largeRock(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.LARGE_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SAPROLITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_LATERITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SILT_CLUMP.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_GREYWACKE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SILTSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_DOLOSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_LIMESTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_IRONSTONE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SHALE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_ARKOSE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_MARBLE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_QUARTZITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_HORNFELS_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SLATE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_GABBRO_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_NORITE_ROCK.get(), "1");
        handle.blockBasedModel(BlockItemRegistration.LARGE_PERIDOTITE_ROCK.get(), "1");
    }

    private void copperRock(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHALK_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SHALE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "");
    }

    private void stone(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SOFT_TUFF.get(), "");                 // Ashfall
        handle.blockBasedModel(BlockItemRegistration.IGNIMBRITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LAPILLISTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SAPROLITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LATERITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SILTSTONE.get(), "");                 // Sedimentary
        handle.blockBasedModel(BlockItemRegistration.DOLOSTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHALK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.IRONSTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SHALE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ARKOSE.get(), "" );
        handle.blockBasedModel(BlockItemRegistration.MARBLE.get(), "");                    // Metamorphic
        handle.blockBasedModel(BlockItemRegistration.QUARTZITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.HORNFELS.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SLATE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE.get(), "");            // Igneous Intrusive
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.RHYOLITE.get(), "");                  // Soft Igneous Intrusive
        handle.blockBasedModel(BlockItemRegistration.DACITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.NORITE.get(), "");                    // Deep Igneous Intrusive
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE.get(), "" );
    }

    private void looseStone(ItemModelProviderHandle handle)
    {
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_GREYWACKE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_DOLOSTONE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_SILTSTONE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_LIMESTONE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_CHALK.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_IRONSTONE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_ARKOSE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_SHALE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_MARBLE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_SLATE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_QUARTZITE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_HORNFELS.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_SMOOTH_DIORITE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_SMOOTH_GRANITE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_GABBRO.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_NORITE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_PERIDOTITE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_ANDESITE.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LOOSE_BASALT.get(), "");
    }

    private void gravel(ItemModelProviderHandle handle)
    {
        //handle.blockBasedModel(BlockItemRegistration.GREYWACKE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.DOLOSTONE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.SILTSTONE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.LIMESTONE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.CHALK_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.IRONSTONE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.ARKOSE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.SHALE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.MARBLE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.SLATE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.QUARTZITE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.HORNFELS_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.GABBRO_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.NORITE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.ANDESITE_GRAVEL.get(), "");
        //handle.blockBasedModel(BlockItemRegistration.BASALT_GRAVEL.get(), "");
    }

    private void infestedStone(ItemModelProviderHandle handle)
    {
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SILTSTONE.get(), BlockItemRegistration.SILTSTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_DOLOSTONE.get(), BlockItemRegistration.DOLOSTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_LIMESTONE.get(), BlockItemRegistration.LIMESTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SHALE.get(), BlockItemRegistration.SHALE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_ARKOSE.get(), BlockItemRegistration.ARKOSE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_MARBLE.get(), BlockItemRegistration.MARBLE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_QUARTZITE.get(), BlockItemRegistration.QUARTZITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_HORNFELS.get(), BlockItemRegistration.HORNFELS.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SLATE.get(), BlockItemRegistration.SLATE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SMOOTH_DIORITE.get(), BlockItemRegistration.SMOOTH_DIORITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SMOOTH_GRANITE.get(), BlockItemRegistration.SMOOTH_GRANITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_NORITE.get(), BlockItemRegistration.NORITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_PERIDOTITE.get(), BlockItemRegistration.PERIDOTITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_RHYOLITE.get(), BlockItemRegistration.RHYOLITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_DACITE.get(), BlockItemRegistration.DACITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_ANDESITE.get(), BlockItemRegistration.ANDESITE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_BASALT.get(), "minecraft", BlockItemRegistration.BASALT.get(), "");
    }

    private void cobbled(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.COBBLED_SOFT_TUFF.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_IGNIMBRITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_LAPILLISTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_WELDED_TUFF.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_SANDSTONE.get(), "");         // Regolith
        handle.blockBasedModel(BlockItemRegistration.COBBLED_RED_SANDSTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_SAPROLITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_LATERITE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_SILTSTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_DOLOSTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_LIMESTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_CHALK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_IRONSTONE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_SHALE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.COBBLED_ARKOSE.get(), "");
    }

    private void infestedCobbled(ItemModelProviderHandle handle)
    {
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_SILTSTONE.get(), BlockItemRegistration.COBBLED_SILTSTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_DOLOSTONE.get(), BlockItemRegistration.COBBLED_DOLOSTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_LIMESTONE.get(), BlockItemRegistration.COBBLED_LIMESTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_CHALK.get(), BlockItemRegistration.COBBLED_CHALK.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_IRONSTONE.get(), BlockItemRegistration.COBBLED_IRONSTONE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_SHALE.get(), BlockItemRegistration.COBBLED_SHALE.get(), "");
        handle.mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_ARKOSE.get(), BlockItemRegistration.COBBLED_ARKOSE.get(), "");
    }

    private void copperOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SAPROLITE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SILTSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DOLOSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHALK_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.IRONSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SHALE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ARKOSE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.MARBLE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.QUARTZITE_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.HORNFELS_COPPER_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SLATE_COPPER_ORE.get(), "");
    }

    private void ironOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.NORITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.RHYOLITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DACITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ANDESITE_IRON_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.BASALT_IRON_ORE.get(), "");
    }

    private void goldOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SILTSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DOLOSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHALK_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.IRONSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SHALE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ARKOSE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.MARBLE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.QUARTZITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.HORNFELS_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SLATE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.NORITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.RHYOLITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DACITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ANDESITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.BASALT_GOLD_ORE.get(), "");
    }

    private void coalOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SAPROLITE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LATERITE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SILTSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DOLOSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHALK_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.IRONSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SHALE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ARKOSE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.MARBLE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.QUARTZITE_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.HORNFELS_COAL_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SLATE_COAL_ORE.get(), "");
    }

    private void diamondOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.NORITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ANDESITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.BASALT_DIAMOND_ORE.get(), "");
    }

    private void emeraldOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.NORITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.RHYOLITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DACITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ANDESITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.BASALT_EMERALD_ORE.get(), "");
    }

    private void lapisOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.MARBLE_LAPIS_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.QUARTZITE_LAPIS_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.HORNFELS_LAPIS_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SLATE_LAPIS_ORE.get(), "");
    }

    private void redstoneOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.NORITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.PERIDOTITE_REDSTONE_ORE.get(), "");
    }

    private void chertOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.LIMESTONE_CHERT_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHALK_CHERT_ORE.get(), "");
    }

    private void geodeOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.BASALT_GEODE_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ANDESITE_GEODE_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.RHYOLITE_GEODE_ORE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DACITE_GEODE_ORE.get(), "");
    }

    private void tinOre(ItemModelProviderHandle handle)
    {
        handle.blockBasedModel(BlockItemRegistration.TIN_ORE_IN_GREYWACKE.get(), "");
        handle.blockBasedModel(BlockItemRegistration.TIN_ORE_IN_GABBRO.get(), "");
    }

    private void materials(ItemModelProviderHandle handle)
    {
        handle.setFolder("rock");

        //handle.itemGeneratedModel(ItemRegistration.QUICK_LIME.get());
        //handle.itemGeneratedModel(ItemRegistration.SLACKED_LIME_BUCKET.get());
    }

    private void tools(ItemModelProviderHandle handle)
    {
        handle.setFolder("rock");

        //handle.itemGeneratedModel(ItemRegistration.LUNATE.get());
        //handle.itemGeneratedModel(ItemRegistration.BIFACE.get());

        //handle.itemGeneratedModel(ItemRegistration.ROCK_KNIFE_BLADE.get());
        //handle.itemGeneratedModel(ItemRegistration.ROCK_AXE_HEAD.get());

        //handle.itemGeneratedModel(ItemRegistration.ROCK_KNIFE.get());
        //handle.itemGeneratedModel(ItemRegistration.ROCK_AXE.get());
    }

    private void workstations(ItemModelProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(BlockItemRegistration.STONE_BENCH.get(), "");
    }
}
