package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.KnappingItemRegistration;

public class WorldLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addSoundTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addBlock(BlockRegistration.FIRE_LAY.get(), "Thatch"); // TODO Seperate firelay and thatch names
    }

    private void addBlockItemTranslations(LanguageEntryProviderHandle handle)
    {
        // DIRT
        handle.addBlock(BlockRegistration.SILT.get(), "Silt");
        handle.addBlock(BlockRegistration.CLAY_IN_GRASS.get(), "Clay Rich Grass");
        handle.addBlock(BlockRegistration.CLAY_IN_DIRT.get(), "Clay Rich Dirt");
        // STONE
        handle.addBlock(BlockRegistration.SOFT_TUFF.get(), "Soft Tuff");
        handle.addBlock(BlockRegistration.IGNIMBRITE.get(), "Ignimbrite");
        handle.addBlock(BlockRegistration.LAPILLISTONE.get(), "Lapillistone");
        handle.addBlock(BlockRegistration.SAPROLITE.get(), "Saprolite");
        handle.addBlock(BlockRegistration.LATERITE.get(), "Laterite");
        handle.addBlock(BlockRegistration.SILTSTONE.get (), "Siltstone");
        handle.addBlock(BlockRegistration.DOLOSTONE.get(), "Dolostone");
        handle.addBlock(BlockRegistration.LIMESTONE.get(), "Limestone");
        handle.addBlock(BlockRegistration.CHALK.get(), "Chalk");
        handle.addBlock(BlockRegistration.IRONSTONE.get(), "Ironstone");
        handle.addBlock(BlockRegistration.SHALE.get(), "Shale");
        handle.addBlock(BlockRegistration.ARKOSE.get(), "Arkose");
        handle.addBlock(BlockRegistration.MARBLE.get(), "Marble");
        handle.addBlock(BlockRegistration.QUARTZITE.get(), "Quartzite");
        handle.addBlock(BlockRegistration.HORNFELS.get(), "Hornfels");
        handle.addBlock(BlockRegistration.SLATE.get(), "Slate");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE.get(), "Smooth Diorite");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE.get(), "Smooth Granite");
        handle.addBlock(BlockRegistration.NORITE.get(), "Norite");
        handle.addBlock(BlockRegistration.PERIDOTITE.get(), "Peridotite");
        handle.addBlock(BlockRegistration.RHYOLITE.get(), "Rhyolite");
        handle.addBlock(BlockRegistration.DACITE.get(), "Dacite");
        // LOOSE STONE
        //handle.addBlockItem(BlockItemRegistration.LOOSE_GREYWACKE.get(), "Loose Greywacke");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_DOLOSTONE.get(), "Loose Dolostone");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_SILTSTONE.get(), "Loose Siltstone");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_LIMESTONE.get(), "Loose Limestone");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_CHALK.get(), "Loose Chalk");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_IRONSTONE.get(), "Loose Ironstone");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_ARKOSE.get(), "Loose Arkose");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_SHALE.get(), "Loose Shale");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_MARBLE.get(), "Loose Marble");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_SLATE.get(), "Loose Slate");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_QUARTZITE.get(), "Loose Quartzite");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_HORNFELS.get(), "Loose Hornfels");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_SMOOTH_DIORITE.get(), "Loose Smooth Diorite");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_SMOOTH_GRANITE.get(), "Loose Smooth Granite");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_GABBRO.get(), "Loose Gabbro");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_NORITE.get(), "Loose Norite");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_PERIDOTITE.get(), "Loose Peridotite");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_ANDESITE.get(), "Loose Andesite");
        //handle.addBlockItem(BlockItemRegistration.LOOSE_BASALT.get(), "Loose Basalt");
        // STONE GRAVEL
        //handle.addBlockItem(BlockItemRegistration.GREYWACKE_GRAVEL.get(), "Greywacke Gravel");
        //handle.addBlockItem(BlockItemRegistration.DOLOSTONE_GRAVEL.get(), "Dolostone Gravel");
        //handle.addBlockItem(BlockItemRegistration.SILTSTONE_GRAVEL.get(), "Siltstone Gravel");
        //handle.addBlockItem(BlockItemRegistration.LIMESTONE_GRAVEL.get(), "Limestone Gravel");
        //handle.addBlockItem(BlockItemRegistration.CHALK_GRAVEL.get(), "Chalk Gravel");
        //handle.addBlockItem(BlockItemRegistration.IRONSTONE_GRAVEL.get(), "Ironstone Gravel");
        //handle.addBlockItem(BlockItemRegistration.ARKOSE_GRAVEL.get(), "Arkose Gravel");
        //handle.addBlockItem(BlockItemRegistration.SHALE_GRAVEL.get(), "Shale Gravel");
        //handle.addBlockItem(BlockItemRegistration.MARBLE_GRAVEL.get(), "Marble Gravel");
        //handle.addBlockItem(BlockItemRegistration.SLATE_GRAVEL.get(), "Slate Gravel");
        //handle.addBlockItem(BlockItemRegistration.QUARTZITE_GRAVEL.get(), "Quartzite Gravel");
        //handle.addBlockItem(BlockItemRegistration.HORNFELS_GRAVEL.get(), "Hornfels Gravel");
        //handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_GRAVEL.get(), "Smooth Diorite Gravel");
        //handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_GRAVEL.get(), "Smooth Granite Gravel");
        //handle.addBlockItem(BlockItemRegistration.GABBRO_GRAVEL.get(), "Gabbro Gravel");
        //handle.addBlockItem(BlockItemRegistration.NORITE_GRAVEL.get(), "Norite Gravel");
        //handle.addBlockItem(BlockItemRegistration.PERIDOTITE_GRAVEL.get(), "Peridotite Gravel");
        //handle.addBlockItem(BlockItemRegistration.ANDESITE_GRAVEL.get(), "Andesite Gravel");
        //handle.addBlockItem(BlockItemRegistration.BASALT_GRAVEL.get(), "Basalt Gravel");
        // COPPER ORE
        handle.addBlock(BlockRegistration.SAPROLITE_COPPER_ORE.get(), "Copper Traces in Saprolite");
        handle.addBlock(BlockRegistration.SILTSTONE_COPPER_ORE.get(), "Copper Ore in Siltstone");
        handle.addBlock(BlockRegistration.DOLOSTONE_COPPER_ORE.get(), "Copper Ore in Dolostone");
        handle.addBlock(BlockRegistration.LIMESTONE_COPPER_ORE.get(), "Copper Ore in Limestone");
        handle.addBlock(BlockRegistration.CHALK_COPPER_ORE.get(), "Copper Ore in Chalk");
        handle.addBlock(BlockRegistration.IRONSTONE_COPPER_ORE.get(), "Copper Ore in Ironstone");
        handle.addBlock(BlockRegistration.SHALE_COPPER_ORE.get(), "Copper Ore in Shale");
        handle.addBlock(BlockRegistration.ARKOSE_COPPER_ORE.get(), "Copper Ore in Arkose");
        handle.addBlock(BlockRegistration.MARBLE_COPPER_ORE.get(), "Copper Ore in Marble");
        handle.addBlock(BlockRegistration.QUARTZITE_COPPER_ORE.get(), "Copper Ore in Quartzite");
        handle.addBlock(BlockRegistration.HORNFELS_COPPER_ORE.get(), "Copper Ore in Hornfels");
        handle.addBlock(BlockRegistration.SLATE_COPPER_ORE.get(), "Copper Ore in Slate");
        // IRON ORE
        handle.addBlock(BlockRegistration.GABBRO_IRON_ORE.get(), "Iron Ore in Gabbro");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "Iron Ore in Smooth Diorite");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "Iron Ore in Smooth Granite");
        handle.addBlock(BlockRegistration.NORITE_IRON_ORE.get(), "Iron Ore in Norite");
        handle.addBlock(BlockRegistration.PERIDOTITE_IRON_ORE.get(), "Iron Ore in Peridotite");
        handle.addBlock(BlockRegistration.RHYOLITE_IRON_ORE.get(), "Iron Ore in Rhyolite");
        handle.addBlock(BlockRegistration.DACITE_IRON_ORE.get(), "Iron Ore in Dacite");
        handle.addBlock(BlockRegistration.ANDESITE_IRON_ORE.get(), "Iron Ore in Andesite");
        handle.addBlock(BlockRegistration.BASALT_IRON_ORE.get(), "Iron Ore in Basalt");
        // GOLD ORE
        handle.addBlock(BlockRegistration.GREYWACKE_GOLD_ORE.get(), "Gold Ore in Greywacke");
        handle.addBlock(BlockRegistration.SILTSTONE_GOLD_ORE.get(), "Gold Ore in Siltstone");
        handle.addBlock(BlockRegistration.DOLOSTONE_GOLD_ORE.get(), "Gold Ore in Dolostone");
        handle.addBlock(BlockRegistration.LIMESTONE_GOLD_ORE.get(), "Gold Ore in Limestone");
        handle.addBlock(BlockRegistration.CHALK_GOLD_ORE.get(), "Gold Ore in Chalk");
        handle.addBlock(BlockRegistration.IRONSTONE_GOLD_ORE.get(), "Gold Ore in Ironstone");
        handle.addBlock(BlockRegistration.SHALE_GOLD_ORE.get(), "Gold Ore in Shale");
        handle.addBlock(BlockRegistration.ARKOSE_GOLD_ORE.get(), "Gold Ore in Arkose");
        handle.addBlock(BlockRegistration.MARBLE_GOLD_ORE.get(), "Gold Ore in Marble");
        handle.addBlock(BlockRegistration.QUARTZITE_GOLD_ORE.get(), "Gold Ore in Quartzite");
        handle.addBlock(BlockRegistration.HORNFELS_GOLD_ORE.get(), "Gold Ore in Hornfels");
        handle.addBlock(BlockRegistration.SLATE_GOLD_ORE.get(), "Gold Ore in Slate");
        handle.addBlock(BlockRegistration.GABBRO_GOLD_ORE.get(), "Gold Ore in Gabbro");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "Gold Ore in Smooth Diorite");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "Gold Ore in Smooth Granite");
        handle.addBlock(BlockRegistration.NORITE_GOLD_ORE.get(), "Gold Ore in Norite");
        handle.addBlock(BlockRegistration.PERIDOTITE_GOLD_ORE.get(), "Gold Ore in Peridotite");
        handle.addBlock(BlockRegistration.RHYOLITE_GOLD_ORE.get(), "Gold Ore in Rhyolite");
        handle.addBlock(BlockRegistration.DACITE_GOLD_ORE.get(), "Gold Ore in Dacite");
        handle.addBlock(BlockRegistration.ANDESITE_GOLD_ORE.get(), "Gold Ore in Andesite");
        handle.addBlock(BlockRegistration.BASALT_GOLD_ORE.get(), "Gold Ore in Basalt");
        // COAL ORE
        handle.addBlock(BlockRegistration.SAPROLITE_COAL_ORE.get(), "Coal Ore in Saprolite");
        handle.addBlock(BlockRegistration.LATERITE_COAL_ORE.get(), "Coal Ore in Laterite");
        handle.addBlock(BlockRegistration.GREYWACKE_COAL_ORE.get(), "Coal Ore in Greywacke");
        handle.addBlock(BlockRegistration.SILTSTONE_COAL_ORE.get(), "Coal Ore in Siltstone");
        handle.addBlock(BlockRegistration.DOLOSTONE_COAL_ORE.get(), "Coal Ore in Dolostone");
        handle.addBlock(BlockRegistration.LIMESTONE_COAL_ORE.get(), "Coal Ore in Limestone");
        handle.addBlock(BlockRegistration.CHALK_COAL_ORE.get(), "Coal Ore in Chalk");
        handle.addBlock(BlockRegistration.IRONSTONE_COAL_ORE.get(), "Coal Ore in Ironstone");
        handle.addBlock(BlockRegistration.SHALE_COAL_ORE.get(), "Coal Ore in Shale");
        handle.addBlock(BlockRegistration.ARKOSE_COAL_ORE.get(), "Coal Ore in Arkose");
        handle.addBlock(BlockRegistration.MARBLE_COAL_ORE.get(), "Coal Ore in Marble");
        handle.addBlock(BlockRegistration.QUARTZITE_COAL_ORE.get(), "Coal Ore in Quartzite");
        handle.addBlock(BlockRegistration.HORNFELS_COAL_ORE.get(), "Coal Ore in Hornfels");
        handle.addBlock(BlockRegistration.SLATE_COAL_ORE.get(), "Coal Ore in Slate");
        // DIAMOND ORE
        handle.addBlock(BlockRegistration.GABBRO_DIAMOND_ORE.get(), "Diamond Ore in Gabbro");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "Diamond Ore in Smooth Diorite");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "Diamond Ore in Smooth Granite");
        handle.addBlock(BlockRegistration.NORITE_DIAMOND_ORE.get(), "Diamond Ore in Norite");
        handle.addBlock(BlockRegistration.PERIDOTITE_DIAMOND_ORE.get(), "Diamond Ore in Peridotite");
        handle.addBlock(BlockRegistration.ANDESITE_DIAMOND_ORE.get(), "Diamond Ore in Andesite");
        handle.addBlock(BlockRegistration.BASALT_DIAMOND_ORE.get(), "Diamond Ore in Basalt");
        // EMERALD ORE
        handle.addBlock(BlockRegistration.GABBRO_EMERALD_ORE.get(), "Emerald Ore in Gabbro");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "Emerald Ore in Smooth Diorite");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "Emerald Ore in Smooth Granite");
        handle.addBlock(BlockRegistration.NORITE_EMERALD_ORE.get(), "Emerald Ore in Norite");
        handle.addBlock(BlockRegistration.PERIDOTITE_EMERALD_ORE.get(), "Emerald Ore in Peridotite");
        handle.addBlock(BlockRegistration.RHYOLITE_EMERALD_ORE.get(), "Emerald Ore in Rhyolite");
        handle.addBlock(BlockRegistration.DACITE_EMERALD_ORE.get(), "Emerald Ore in Dacite");
        handle.addBlock(BlockRegistration.ANDESITE_EMERALD_ORE.get(), "Emerald Ore in Andesite");
        handle.addBlock(BlockRegistration.BASALT_EMERALD_ORE.get(), "Emerald Ore in Basalt");
        // LAPIS ORE
        handle.addBlock(BlockRegistration.MARBLE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Marble");
        handle.addBlock(BlockRegistration.QUARTZITE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Quartzite");
        handle.addBlock(BlockRegistration.HORNFELS_LAPIS_ORE.get(), "Lapis Lazuli Ore in Hornfels");
        handle.addBlock(BlockRegistration.SLATE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Slate");
        // REDSTONE ORE
        handle.addBlock(BlockRegistration.GABBRO_REDSTONE_ORE.get(), "Redstone Ore in Gabbro");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "Redstone Ore in Smooth Diorite");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "Redstone Ore in Smooth Granite");
        handle.addBlock(BlockRegistration.NORITE_REDSTONE_ORE.get(), "Redstone Ore in Norite");
        handle.addBlock(BlockRegistration.PERIDOTITE_REDSTONE_ORE.get(), "Redstone Ore in Peridotite");
        // CHERT ORE
        handle.addBlock(BlockRegistration.CHALK_CHERT_ORE.get(), "Chert in Chalk");
        // GEODE ORE
        handle.addBlock(BlockRegistration.BASALT_GEODE_ORE.get(), "Geode in Basalt");
        handle.addBlock(BlockRegistration.ANDESITE_GEODE_ORE.get(), "Geode in Andesite");
        handle.addBlock(BlockRegistration.RHYOLITE_GEODE_ORE.get(), "Geode in Rhyolite");
        handle.addBlock(BlockRegistration.DACITE_GEODE_ORE.get(), "Geode in Dacite");
        // INFESTEDkEBlock     handle.addBlock(BlockRegistration.INFESTED_SILTSTONE.get(), "Infested Siltstone");
        handle.addBlock(BlockRegistration.INFESTED_DOLOSTONE.get(), "Infested Dolostone");
        handle.addBlock(BlockRegistration.INFESTED_LIMESTONE.get(), "Infested Limestone");
        handle.addBlock(BlockRegistration.INFESTED_SHALE.get(), "Infested Shale");
        handle.addBlock(BlockRegistration.INFESTED_ARKOSE.get(), "Infested Arkose");
        handle.addBlock(BlockRegistration.INFESTED_MARBLE.get(), "Infested Marble");
        handle.addBlock(BlockRegistration.INFESTED_QUARTZITE.get(), "Infested Quartzite");
        handle.addBlock(BlockRegistration.INFESTED_HORNFELS.get(), "Infested Hornfels");
        handle.addBlock(BlockRegistration.INFESTED_SLATE.get(), "Infested Slate");
        handle.addBlock(BlockRegistration.INFESTED_SMOOTH_DIORITE.get(), "Infested Smooth Diorite");
        handle.addBlock(BlockRegistration.INFESTED_SMOOTH_GRANITE.get(), "Infested Smooth Granite");
        handle.addBlock(BlockRegistration.INFESTED_NORITE.get(), "Infested Norite");
        handle.addBlock(BlockRegistration.INFESTED_PERIDOTITE.get(), "Infested Peridotite");
        handle.addBlock(BlockRegistration.INFESTED_RHYOLITE.get(), "Infested Rhyolite");
        handle.addBlock(BlockRegistration.INFESTED_DACITE.get(), "Infested Dacite");
        handle.addBlock(BlockRegistration.INFESTED_ANDESITE.get(), "Infested Andesite");
        handle.addBlock(BlockRegistration.INFESTED_BASALT.get(), "Infested Basalt");
        // COBBLE
        handle.addBlock(BlockRegistration.COBBLED_SOFT_TUFF.get(), "Cobbled Soft Tuff");
        handle.addBlock(BlockRegistration.COBBLED_IGNIMBRITE.get(), "Cobbled Ignimbrite");
        handle.addBlock(BlockRegistration.COBBLED_LAPILLISTONE.get(), "Cobbled Lapillistone");
        handle.addBlock(BlockRegistration.COBBLED_WELDED_TUFF.get(), "Cobbled Welded Tuff");
        handle.addBlock(BlockRegistration.COBBLED_SANDSTONE.get(), "Cobbled Sandstone");
        handle.addBlock(BlockRegistration.COBBLED_RED_SANDSTONE.get(), "Cobbled Red Sandstone");
        handle.addBlock(BlockRegistration.COBBLED_SAPROLITE.get(), "Cobbled Saprolite");
        handle.addBlock(BlockRegistration.COBBLED_LATERITE.get(), "Cobbled Laterite");
        handle.addBlock(BlockRegistration.COBBLED_SILTSTONE.get(), "Cobbled Siltstone");
        handle.addBlock(BlockRegistration.COBBLED_DOLOSTONE.get(), "Cobbled Dolostone");
        handle.addBlock(BlockRegistration.COBBLED_LIMESTONE.get(), "Cobbled Limestone");
        handle.addBlock(BlockRegistration.COBBLED_CHALK.get(), "Cobbled Chalk");
        handle.addBlock(BlockRegistration.COBBLED_IRONSTONE.get(), "Cobbled Ironstone");
        handle.addBlock(BlockRegistration.COBBLED_SHALE.get(), "Cobbled Shale");
        handle.addBlock(BlockRegistration.COBBLED_ARKOSE.get(), "Cobbled Arkose");
        // INFESTED kEBlock     handle.addBlock(BlockRegistration.INFESTED_COBBLED_SILTSTONE.get(), "Infested Cobbled Siltstone");
        handle.addBlock(BlockRegistration.INFESTED_COBBLED_DOLOSTONE.get(), "Infested Cobbled Dolostone");
        handle.addBlock(BlockRegistration.INFESTED_COBBLED_LIMESTONE.get(), "Infested Cobbled Limestone");
        handle.addBlock(BlockRegistration.INFESTED_COBBLED_CHALK.get(), "Infested Cobbled Chalk");
        handle.addBlock(BlockRegistration.INFESTED_COBBLED_IRONSTONE.get(), "Infested Cobbled Ironstone");
        handle.addBlock(BlockRegistration.INFESTED_COBBLED_SHALE.get(), "Infested Cobbled Shale");
        handle.addBlock(BlockRegistration.INFESTED_COBBLED_ARKOSE.get(), "Infested Cobbled Arkose");
        handle.addBlock(BlockRegistration.LIMESTONE_CHERT_ORE.get(), "Chert in Limestone");
        // PLANT
        handle.addBlock(BlockRegistration.SHRUB.get(), "Shrub");
        handle.addBlock(BlockRegistration.DOGBANE.get(), "Dogbane");
        // BRANCH
        handle.addBlock(BlockRegistration.OAK_BRANCH.get(), "Oak Branch");
        handle.addBlock(BlockRegistration.BIRCH_BRANCH.get(), "Birch Branch");
        handle.addBlock(BlockRegistration.SPRUCE_BRANCH.get(), "Spruce Branch");
        handle.addBlock(BlockRegistration.JUNGLE_BRANCH.get(), "Jungle Branch");
        handle.addBlock(BlockRegistration.DARK_OAK_BRANCH.get(), "Dark Oak Branch");
        handle.addBlock(BlockRegistration.ACACIA_BRANCH.get(), "Acacia Branch");
        handle.addBlock(BlockRegistration.MANGROVE_BRANCH.get(), "Mangrove Branch");
        handle.addBlock(BlockRegistration.CHERRY_BRANCH.get(), "Cherry Branch");
    }

    private void addSoundTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(KnappingItemRegistration.BROKEN_GOAT_HORN.get(), "Broken Goat Horn");
    }

    private void addCreativeTabTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addGUITranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addTooltipTranslations(LanguageEntryProviderHandle handle)
    {
    }
}
