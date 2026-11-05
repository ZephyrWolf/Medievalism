package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class WorldItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
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
        materials(handle);
    }

    private void rock(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.RED_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SAPROLITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LATERITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SILT_CLUMP.get(), "1");
        handle.blockBasedModel(ItemRegistration.GREYWACKE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SILTSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.DOLOSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LIMESTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.IRONSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SHALE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.ARKOSE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.MARBLE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.QUARTZITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.HORNFELS_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SLATE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.GABBRO_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.NORITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.PERIDOTITE_ROCK.get(), "1");
    }

    private void largeRock(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.LARGE_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SAPROLITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_LATERITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SILT_CLUMP.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_GREYWACKE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SILTSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_DOLOSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_LIMESTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_IRONSTONE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SHALE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_ARKOSE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_MARBLE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_QUARTZITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_HORNFELS_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SLATE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_GABBRO_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_NORITE_ROCK.get(), "1");
        handle.blockBasedModel(ItemRegistration.LARGE_PERIDOTITE_ROCK.get(), "1");
    }

    private void copperRock(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.CHALK_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SHALE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "");
    }

    private void stone(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SOFT_TUFF.get(), "");                 // Ashfall
        handle.blockBasedModel(ItemRegistration.IGNIMBRITE.get(), "");
        handle.blockBasedModel(ItemRegistration.LAPILLISTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.SAPROLITE.get(), "");
        handle.blockBasedModel(ItemRegistration.LATERITE.get(), "");
        handle.blockBasedModel(ItemRegistration.SILTSTONE.get(), "");                 // Sedimentary
        handle.blockBasedModel(ItemRegistration.DOLOSTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.LIMESTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.CHALK.get(), "");
        handle.blockBasedModel(ItemRegistration.IRONSTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.SHALE.get(), "");
        handle.blockBasedModel(ItemRegistration.ARKOSE.get(), "" );
        handle.blockBasedModel(ItemRegistration.MARBLE.get(), "");                    // Metamorphic
        handle.blockBasedModel(ItemRegistration.QUARTZITE.get(), "");
        handle.blockBasedModel(ItemRegistration.HORNFELS.get(), "");
        handle.blockBasedModel(ItemRegistration.SLATE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE.get(), "");            // Igneous Intrusive
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE.get(), "");
        handle.blockBasedModel(ItemRegistration.RHYOLITE.get(), "");                  // Soft Igneous Intrusive
        handle.blockBasedModel(ItemRegistration.DACITE.get(), "");
        handle.blockBasedModel(ItemRegistration.NORITE.get(), "");                    // Deep Igneous Intrusive
        handle.blockBasedModel(ItemRegistration.PERIDOTITE.get(), "" );
    }

    private void looseStone(ItemModelEntryProviderHandle handle)
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

    private void gravel(ItemModelEntryProviderHandle handle)
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

    private void infestedStone(ItemModelEntryProviderHandle handle)
    {
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_SILTSTONE.get(), ItemRegistration.SILTSTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_DOLOSTONE.get(), ItemRegistration.DOLOSTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_LIMESTONE.get(), ItemRegistration.LIMESTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_SHALE.get(), ItemRegistration.SHALE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_ARKOSE.get(), ItemRegistration.ARKOSE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_MARBLE.get(), ItemRegistration.MARBLE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_QUARTZITE.get(), ItemRegistration.QUARTZITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_HORNFELS.get(), ItemRegistration.HORNFELS.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_SLATE.get(), ItemRegistration.SLATE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_SMOOTH_DIORITE.get(), ItemRegistration.SMOOTH_DIORITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_SMOOTH_GRANITE.get(), ItemRegistration.SMOOTH_GRANITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_NORITE.get(), ItemRegistration.NORITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_PERIDOTITE.get(), ItemRegistration.PERIDOTITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_RHYOLITE.get(), ItemRegistration.RHYOLITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_DACITE.get(), ItemRegistration.DACITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_ANDESITE.get(), ItemRegistration.ANDESITE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_BASALT.get(), "minecraft", ItemRegistration.BASALT.get(), "");
    }

    private void cobbled(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.COBBLED_SOFT_TUFF.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_IGNIMBRITE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_LAPILLISTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_WELDED_TUFF.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_SANDSTONE.get(), "");         // Regolith
        handle.blockBasedModel(ItemRegistration.COBBLED_RED_SANDSTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_SAPROLITE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_LATERITE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_SILTSTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_DOLOSTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_LIMESTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_CHALK.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_IRONSTONE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_SHALE.get(), "");
        handle.blockBasedModel(ItemRegistration.COBBLED_ARKOSE.get(), "");
    }

    private void infestedCobbled(ItemModelEntryProviderHandle handle)
    {
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_SILTSTONE.get(), ItemRegistration.COBBLED_SILTSTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_DOLOSTONE.get(), ItemRegistration.COBBLED_DOLOSTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_LIMESTONE.get(), ItemRegistration.COBBLED_LIMESTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_CHALK.get(), ItemRegistration.COBBLED_CHALK.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_IRONSTONE.get(), ItemRegistration.COBBLED_IRONSTONE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_SHALE.get(), ItemRegistration.COBBLED_SHALE.get(), "");
        handle.mirrorBlockBasedModel(ItemRegistration.INFESTED_COBBLED_ARKOSE.get(), ItemRegistration.COBBLED_ARKOSE.get(), "");
    }

    private void copperOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SAPROLITE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SILTSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DOLOSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.LIMESTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.CHALK_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.IRONSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SHALE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ARKOSE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.MARBLE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.QUARTZITE_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.HORNFELS_COPPER_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SLATE_COPPER_ORE.get(), "");
    }

    private void ironOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.NORITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.PERIDOTITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.RHYOLITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DACITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ANDESITE_IRON_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.BASALT_IRON_ORE.get(), "");
    }

    private void goldOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SILTSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DOLOSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.LIMESTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.CHALK_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.IRONSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SHALE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ARKOSE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.MARBLE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.QUARTZITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.HORNFELS_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SLATE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.NORITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.PERIDOTITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.RHYOLITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DACITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ANDESITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.BASALT_GOLD_ORE.get(), "");
    }

    private void coalOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SAPROLITE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.LATERITE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SILTSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DOLOSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.LIMESTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.CHALK_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.IRONSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SHALE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ARKOSE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.MARBLE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.QUARTZITE_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.HORNFELS_COAL_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SLATE_COAL_ORE.get(), "");
    }

    private void diamondOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.NORITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.PERIDOTITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ANDESITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.BASALT_DIAMOND_ORE.get(), "");
    }

    private void emeraldOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.NORITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.PERIDOTITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.RHYOLITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DACITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ANDESITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.BASALT_EMERALD_ORE.get(), "");
    }

    private void lapisOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.MARBLE_LAPIS_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.QUARTZITE_LAPIS_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.HORNFELS_LAPIS_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SLATE_LAPIS_ORE.get(), "");
    }

    private void redstoneOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.NORITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.PERIDOTITE_REDSTONE_ORE.get(), "");
    }

    private void chertOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.LIMESTONE_CHERT_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.CHALK_CHERT_ORE.get(), "");
    }

    private void geodeOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(ItemRegistration.BASALT_GEODE_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.ANDESITE_GEODE_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.RHYOLITE_GEODE_ORE.get(), "");
        handle.blockBasedModel(ItemRegistration.DACITE_GEODE_ORE.get(), "");
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.BIRCH_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.OAK_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.SPRUCE_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.JUNGLE_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.ACACIA_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.DARK_OAK_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.CHERRY_BRANCH.get(), "");
        handle.blockBasedModel(ItemRegistration.MANGROVE_BRANCH.get(), "");
        handle.blockIconGeneratedModel(ItemRegistration.SHRUB.get());
    }
}
