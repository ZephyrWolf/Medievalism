package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WorldItemRegistration;

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
        handle.blockBasedModel(WorldItemRegistration.SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.RED_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SAPROLITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LATERITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SILT_CLUMP.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.GREYWACKE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SILTSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.DOLOSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.IRONSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SHALE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.ARKOSE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.MARBLE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.QUARTZITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.HORNFELS_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SLATE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.GABBRO_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.NORITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE_ROCK.get(), "1");
    }

    private void largeRock(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.LARGE_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SAPROLITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_LATERITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SILT_CLUMP.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_GREYWACKE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SILTSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_DOLOSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_LIMESTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_IRONSTONE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SHALE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_ARKOSE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_MARBLE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_QUARTZITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_HORNFELS_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SLATE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_GABBRO_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_NORITE_ROCK.get(), "1");
        handle.blockBasedModel(WorldItemRegistration.LARGE_PERIDOTITE_ROCK.get(), "1");
    }

    private void copperRock(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHALK_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SHALE_ROCK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "");
    }

    private void stone(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SOFT_TUFF.get(), "");                 // Ashfall
        handle.blockBasedModel(WorldItemRegistration.IGNIMBRITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LAPILLISTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SAPROLITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LATERITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SILTSTONE.get(), "");                 // Sedimentary
        handle.blockBasedModel(WorldItemRegistration.DOLOSTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHALK.get(), "");
        handle.blockBasedModel(WorldItemRegistration.IRONSTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SHALE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ARKOSE.get(), "" );
        handle.blockBasedModel(WorldItemRegistration.MARBLE.get(), "");                    // Metamorphic
        handle.blockBasedModel(WorldItemRegistration.QUARTZITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.HORNFELS.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SLATE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE.get(), "");            // Igneous Intrusive
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.RHYOLITE.get(), "");                  // Soft Igneous Intrusive
        handle.blockBasedModel(WorldItemRegistration.DACITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.NORITE.get(), "");                    // Deep Igneous Intrusive
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE.get(), "" );
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
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_SILTSTONE.get(), WorldItemRegistration.SILTSTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_DOLOSTONE.get(), WorldItemRegistration.DOLOSTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_LIMESTONE.get(), WorldItemRegistration.LIMESTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_SHALE.get(), WorldItemRegistration.SHALE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_ARKOSE.get(), WorldItemRegistration.ARKOSE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_MARBLE.get(), WorldItemRegistration.MARBLE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_QUARTZITE.get(), WorldItemRegistration.QUARTZITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_HORNFELS.get(), WorldItemRegistration.HORNFELS.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_SLATE.get(), WorldItemRegistration.SLATE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_SMOOTH_DIORITE.get(), WorldItemRegistration.SMOOTH_DIORITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_SMOOTH_GRANITE.get(), WorldItemRegistration.SMOOTH_GRANITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_NORITE.get(), WorldItemRegistration.NORITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_PERIDOTITE.get(), WorldItemRegistration.PERIDOTITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_RHYOLITE.get(), WorldItemRegistration.RHYOLITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_DACITE.get(), WorldItemRegistration.DACITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_ANDESITE.get(), WorldItemRegistration.ANDESITE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_BASALT.get(), "minecraft", WorldItemRegistration.BASALT.get(), "");
    }

    private void cobbled(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.COBBLED_SOFT_TUFF.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_IGNIMBRITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_LAPILLISTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_WELDED_TUFF.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_SANDSTONE.get(), "");         // Regolith
        handle.blockBasedModel(WorldItemRegistration.COBBLED_RED_SANDSTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_SAPROLITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_LATERITE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_SILTSTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_DOLOSTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_LIMESTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_CHALK.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_IRONSTONE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_SHALE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.COBBLED_ARKOSE.get(), "");
    }

    private void infestedCobbled(ItemModelEntryProviderHandle handle)
    {
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_SILTSTONE.get(), WorldItemRegistration.COBBLED_SILTSTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_DOLOSTONE.get(), WorldItemRegistration.COBBLED_DOLOSTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_LIMESTONE.get(), WorldItemRegistration.COBBLED_LIMESTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_CHALK.get(), WorldItemRegistration.COBBLED_CHALK.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_IRONSTONE.get(), WorldItemRegistration.COBBLED_IRONSTONE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_SHALE.get(), WorldItemRegistration.COBBLED_SHALE.get(), "");
        handle.mirrorBlockBasedModel(WorldItemRegistration.INFESTED_COBBLED_ARKOSE.get(), WorldItemRegistration.COBBLED_ARKOSE.get(), "");
    }

    private void copperOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SAPROLITE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SILTSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DOLOSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHALK_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.IRONSTONE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SHALE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ARKOSE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.MARBLE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.QUARTZITE_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.HORNFELS_COPPER_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SLATE_COPPER_ORE.get(), "");
    }

    private void ironOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.NORITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.RHYOLITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DACITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ANDESITE_IRON_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.BASALT_IRON_ORE.get(), "");
    }

    private void goldOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SILTSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DOLOSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHALK_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.IRONSTONE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SHALE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ARKOSE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.MARBLE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.QUARTZITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.HORNFELS_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SLATE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.NORITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.RHYOLITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DACITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ANDESITE_GOLD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.BASALT_GOLD_ORE.get(), "");
    }

    private void coalOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SAPROLITE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LATERITE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SILTSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DOLOSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHALK_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.IRONSTONE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SHALE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ARKOSE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.MARBLE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.QUARTZITE_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.HORNFELS_COAL_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SLATE_COAL_ORE.get(), "");
    }

    private void diamondOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.NORITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ANDESITE_DIAMOND_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.BASALT_DIAMOND_ORE.get(), "");
    }

    private void emeraldOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.NORITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.RHYOLITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DACITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ANDESITE_EMERALD_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.BASALT_EMERALD_ORE.get(), "");
    }

    private void lapisOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.MARBLE_LAPIS_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.QUARTZITE_LAPIS_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.HORNFELS_LAPIS_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SLATE_LAPIS_ORE.get(), "");
    }

    private void redstoneOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.NORITE_REDSTONE_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.PERIDOTITE_REDSTONE_ORE.get(), "");
    }

    private void chertOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.LIMESTONE_CHERT_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHALK_CHERT_ORE.get(), "");
    }

    private void geodeOre(ItemModelEntryProviderHandle handle)
    {
        handle.blockBasedModel(WorldItemRegistration.BASALT_GEODE_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ANDESITE_GEODE_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.RHYOLITE_GEODE_ORE.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DACITE_GEODE_ORE.get(), "");
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(WorldItemRegistration.BIRCH_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.OAK_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.SPRUCE_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.JUNGLE_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.ACACIA_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.DARK_OAK_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.CHERRY_BRANCH.get(), "");
        handle.blockBasedModel(WorldItemRegistration.MANGROVE_BRANCH.get(), "");
        handle.blockIconGeneratedModel(WorldItemRegistration.SHRUB.get());
    }
}
