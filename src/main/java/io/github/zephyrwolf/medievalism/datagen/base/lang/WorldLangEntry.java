package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;

public class WorldLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addSoundTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageProviderHandle handle)
    {
    }

    private void addBlockItemTranslations(LanguageProviderHandle handle)
    {
        // DIRT
        handle.addBlockItem(BlockItemRegistration.SILT.get(), "Silt");
        // STONE
        handle.addBlockItem(BlockItemRegistration.SOFT_TUFF.get(), "Soft Tuff");
        handle.addBlockItem(BlockItemRegistration.IGNIMBRITE.get(), "Ignimbrite");
        handle.addBlockItem(BlockItemRegistration.LAPILLISTONE.get(), "Lapillistone");
        handle.addBlockItem(BlockItemRegistration.SAPROLITE.get(), "Saprolite");
        handle.addBlockItem(BlockItemRegistration.LATERITE.get(), "Laterite");
        handle.addBlockItem(BlockItemRegistration.SILTSTONE.get (), "Siltstone");
        handle.addBlockItem(BlockItemRegistration.DOLOSTONE.get(), "Dolostone");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE.get(), "Limestone");
        handle.addBlockItem(BlockItemRegistration.CHALK.get(), "Chalk");
        handle.addBlockItem(BlockItemRegistration.IRONSTONE.get(), "Ironstone");
        handle.addBlockItem(BlockItemRegistration.SHALE.get(), "Shale");
        handle.addBlockItem(BlockItemRegistration.ARKOSE.get(), "Arkose");
        handle.addBlockItem(BlockItemRegistration.MARBLE.get(), "Marble");
        handle.addBlockItem(BlockItemRegistration.QUARTZITE.get(), "Quartzite");
        handle.addBlockItem(BlockItemRegistration.HORNFELS.get(), "Hornfels");
        handle.addBlockItem(BlockItemRegistration.SLATE.get(), "Slate");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE.get(), "Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE.get(), "Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.NORITE.get(), "Norite");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE.get(), "Peridotite");
        handle.addBlockItem(BlockItemRegistration.RHYOLITE.get(), "Rhyolite");
        handle.addBlockItem(BlockItemRegistration.DACITE.get(), "Dacite");
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
        handle.addBlockItem(BlockItemRegistration.SAPROLITE_COPPER_ORE.get(), "Copper Traces in Saprolite");
        handle.addBlockItem(BlockItemRegistration.SILTSTONE_COPPER_ORE.get(), "Copper Ore in Siltstone");
        handle.addBlockItem(BlockItemRegistration.DOLOSTONE_COPPER_ORE.get(), "Copper Ore in Dolostone");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE_COPPER_ORE.get(), "Copper Ore in Limestone");
        handle.addBlockItem(BlockItemRegistration.CHALK_COPPER_ORE.get(), "Copper Ore in Chalk");
        handle.addBlockItem(BlockItemRegistration.IRONSTONE_COPPER_ORE.get(), "Copper Ore in Ironstone");
        handle.addBlockItem(BlockItemRegistration.SHALE_COPPER_ORE.get(), "Copper Ore in Shale");
        handle.addBlockItem(BlockItemRegistration.ARKOSE_COPPER_ORE.get(), "Copper Ore in Arkose");
        handle.addBlockItem(BlockItemRegistration.MARBLE_COPPER_ORE.get(), "Copper Ore in Marble");
        handle.addBlockItem(BlockItemRegistration.QUARTZITE_COPPER_ORE.get(), "Copper Ore in Quartzite");
        handle.addBlockItem(BlockItemRegistration.HORNFELS_COPPER_ORE.get(), "Copper Ore in Hornfels");
        handle.addBlockItem(BlockItemRegistration.SLATE_COPPER_ORE.get(), "Copper Ore in Slate");
        // IRON ORE
        handle.addBlockItem(BlockItemRegistration.GABBRO_IRON_ORE.get(), "Iron Ore in Gabbro");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "Iron Ore in Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "Iron Ore in Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.NORITE_IRON_ORE.get(), "Iron Ore in Norite");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE_IRON_ORE.get(), "Iron Ore in Peridotite");
        handle.addBlockItem(BlockItemRegistration.RHYOLITE_IRON_ORE.get(), "Iron Ore in Rhyolite");
        handle.addBlockItem(BlockItemRegistration.DACITE_IRON_ORE.get(), "Iron Ore in Dacite");
        handle.addBlockItem(BlockItemRegistration.ANDESITE_IRON_ORE.get(), "Iron Ore in Andesite");
        handle.addBlockItem(BlockItemRegistration.BASALT_IRON_ORE.get(), "Iron Ore in Basalt");
        // GOLD ORE
        handle.addBlockItem(BlockItemRegistration.GREYWACKE_GOLD_ORE.get(), "Gold Ore in Greywacke");
        handle.addBlockItem(BlockItemRegistration.SILTSTONE_GOLD_ORE.get(), "Gold Ore in Siltstone");
        handle.addBlockItem(BlockItemRegistration.DOLOSTONE_GOLD_ORE.get(), "Gold Ore in Dolostone");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE_GOLD_ORE.get(), "Gold Ore in Limestone");
        handle.addBlockItem(BlockItemRegistration.CHALK_GOLD_ORE.get(), "Gold Ore in Chalk");
        handle.addBlockItem(BlockItemRegistration.IRONSTONE_GOLD_ORE.get(), "Gold Ore in Ironstone");
        handle.addBlockItem(BlockItemRegistration.SHALE_GOLD_ORE.get(), "Gold Ore in Shale");
        handle.addBlockItem(BlockItemRegistration.ARKOSE_GOLD_ORE.get(), "Gold Ore in Arkose");
        handle.addBlockItem(BlockItemRegistration.MARBLE_GOLD_ORE.get(), "Gold Ore in Marble");
        handle.addBlockItem(BlockItemRegistration.QUARTZITE_GOLD_ORE.get(), "Gold Ore in Quartzite");
        handle.addBlockItem(BlockItemRegistration.HORNFELS_GOLD_ORE.get(), "Gold Ore in Hornfels");
        handle.addBlockItem(BlockItemRegistration.SLATE_GOLD_ORE.get(), "Gold Ore in Slate");
        handle.addBlockItem(BlockItemRegistration.GABBRO_GOLD_ORE.get(), "Gold Ore in Gabbro");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "Gold Ore in Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "Gold Ore in Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.NORITE_GOLD_ORE.get(), "Gold Ore in Norite");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE_GOLD_ORE.get(), "Gold Ore in Peridotite");
        handle.addBlockItem(BlockItemRegistration.RHYOLITE_GOLD_ORE.get(), "Gold Ore in Rhyolite");
        handle.addBlockItem(BlockItemRegistration.DACITE_GOLD_ORE.get(), "Gold Ore in Dacite");
        handle.addBlockItem(BlockItemRegistration.ANDESITE_GOLD_ORE.get(), "Gold Ore in Andesite");
        handle.addBlockItem(BlockItemRegistration.BASALT_GOLD_ORE.get(), "Gold Ore in Basalt");
        // COAL ORE
        handle.addBlockItem(BlockItemRegistration.SAPROLITE_COAL_ORE.get(), "Coal Ore in Saprolite");
        handle.addBlockItem(BlockItemRegistration.LATERITE_COAL_ORE.get(), "Coal Ore in Laterite");
        handle.addBlockItem(BlockItemRegistration.GREYWACKE_COAL_ORE.get(), "Coal Ore in Greywacke");
        handle.addBlockItem(BlockItemRegistration.SILTSTONE_COAL_ORE.get(), "Coal Ore in Siltstone");
        handle.addBlockItem(BlockItemRegistration.DOLOSTONE_COAL_ORE.get(), "Coal Ore in Dolostone");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE_COAL_ORE.get(), "Coal Ore in Limestone");
        handle.addBlockItem(BlockItemRegistration.CHALK_COAL_ORE.get(), "Coal Ore in Chalk");
        handle.addBlockItem(BlockItemRegistration.IRONSTONE_COAL_ORE.get(), "Coal Ore in Ironstone");
        handle.addBlockItem(BlockItemRegistration.SHALE_COAL_ORE.get(), "Coal Ore in Shale");
        handle.addBlockItem(BlockItemRegistration.ARKOSE_COAL_ORE.get(), "Coal Ore in Arkose");
        handle.addBlockItem(BlockItemRegistration.MARBLE_COAL_ORE.get(), "Coal Ore in Marble");
        handle.addBlockItem(BlockItemRegistration.QUARTZITE_COAL_ORE.get(), "Coal Ore in Quartzite");
        handle.addBlockItem(BlockItemRegistration.HORNFELS_COAL_ORE.get(), "Coal Ore in Hornfels");
        handle.addBlockItem(BlockItemRegistration.SLATE_COAL_ORE.get(), "Coal Ore in Slate");
        // DIAMOND ORE
        handle.addBlockItem(BlockItemRegistration.GABBRO_DIAMOND_ORE.get(), "Diamond Ore in Gabbro");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "Diamond Ore in Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "Diamond Ore in Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.NORITE_DIAMOND_ORE.get(), "Diamond Ore in Norite");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE_DIAMOND_ORE.get(), "Diamond Ore in Peridotite");
        handle.addBlockItem(BlockItemRegistration.ANDESITE_DIAMOND_ORE.get(), "Diamond Ore in Andesite");
        handle.addBlockItem(BlockItemRegistration.BASALT_DIAMOND_ORE.get(), "Diamond Ore in Basalt");
        // EMERALD ORE
        handle.addBlockItem(BlockItemRegistration.GABBRO_EMERALD_ORE.get(), "Emerald Ore in Gabbro");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "Emerald Ore in Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "Emerald Ore in Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.NORITE_EMERALD_ORE.get(), "Emerald Ore in Norite");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE_EMERALD_ORE.get(), "Emerald Ore in Peridotite");
        handle.addBlockItem(BlockItemRegistration.RHYOLITE_EMERALD_ORE.get(), "Emerald Ore in Rhyolite");
        handle.addBlockItem(BlockItemRegistration.DACITE_EMERALD_ORE.get(), "Emerald Ore in Dacite");
        handle.addBlockItem(BlockItemRegistration.ANDESITE_EMERALD_ORE.get(), "Emerald Ore in Andesite");
        handle.addBlockItem(BlockItemRegistration.BASALT_EMERALD_ORE.get(), "Emerald Ore in Basalt");
        // LAPIS ORE
        handle.addBlockItem(BlockItemRegistration.MARBLE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Marble");
        handle.addBlockItem(BlockItemRegistration.QUARTZITE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Quartzite");
        handle.addBlockItem(BlockItemRegistration.HORNFELS_LAPIS_ORE.get(), "Lapis Lazuli Ore in Hornfels");
        handle.addBlockItem(BlockItemRegistration.SLATE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Slate");
        // REDSTONE ORE
        handle.addBlockItem(BlockItemRegistration.GABBRO_REDSTONE_ORE.get(), "Redstone Ore in Gabbro");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "Redstone Ore in Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "Redstone Ore in Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.NORITE_REDSTONE_ORE.get(), "Redstone Ore in Norite");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE_REDSTONE_ORE.get(), "Redstone Ore in Peridotite");
        // TIN ORE
        handle.addBlock(BlockRegistration.TIN_ORE_IN_GREYWACKE.get(), "Tin Ore Block"); // TODO
        handle.addBlock(BlockRegistration.TIN_ORE_IN_GABBRO.get(), "Deepslate Tin Ore Block");
        // CHERT ORE
        handle.addBlockItem(BlockItemRegistration.CHALK_CHERT_ORE.get(), "Chert in Chalk");
        // GEODE ORE
        handle.addBlockItem(BlockItemRegistration.BASALT_GEODE_ORE.get(), "Geode in Basalt");
        handle.addBlockItem(BlockItemRegistration.ANDESITE_GEODE_ORE.get(), "Geode in Andesite");
        handle.addBlockItem(BlockItemRegistration.RHYOLITE_GEODE_ORE.get(), "Geode in Rhyolite");
        handle.addBlockItem(BlockItemRegistration.DACITE_GEODE_ORE.get(), "Geode in Dacite");
        // INFESTED STONE
        handle.addBlockItem(BlockItemRegistration.INFESTED_SILTSTONE.get(), "Infested Siltstone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_DOLOSTONE.get(), "Infested Dolostone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_LIMESTONE.get(), "Infested Limestone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_SHALE.get(), "Infested Shale");
        handle.addBlockItem(BlockItemRegistration.INFESTED_ARKOSE.get(), "Infested Arkose");
        handle.addBlockItem(BlockItemRegistration.INFESTED_MARBLE.get(), "Infested Marble");
        handle.addBlockItem(BlockItemRegistration.INFESTED_QUARTZITE.get(), "Infested Quartzite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_HORNFELS.get(), "Infested Hornfels");
        handle.addBlockItem(BlockItemRegistration.INFESTED_SLATE.get(), "Infested Slate");
        handle.addBlockItem(BlockItemRegistration.INFESTED_SMOOTH_DIORITE.get(), "Infested Smooth Diorite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_SMOOTH_GRANITE.get(), "Infested Smooth Granite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_NORITE.get(), "Infested Norite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_PERIDOTITE.get(), "Infested Peridotite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_RHYOLITE.get(), "Infested Rhyolite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_DACITE.get(), "Infested Dacite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_ANDESITE.get(), "Infested Andesite");
        handle.addBlockItem(BlockItemRegistration.INFESTED_BASALT.get(), "Infested Basalt");
        // COBBLE
        handle.addBlockItem(BlockItemRegistration.COBBLED_SOFT_TUFF.get(), "Cobbled Soft Tuff");
        handle.addBlockItem(BlockItemRegistration.COBBLED_IGNIMBRITE.get(), "Cobbled Ignimbrite");
        handle.addBlockItem(BlockItemRegistration.COBBLED_LAPILLISTONE.get(), "Cobbled Lapillistone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_WELDED_TUFF.get(), "Cobbled Welded Tuff");
        handle.addBlockItem(BlockItemRegistration.COBBLED_SANDSTONE.get(), "Cobbled Sandstone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_RED_SANDSTONE.get(), "Cobbled Red Sandstone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_SAPROLITE.get(), "Cobbled Saprolite");
        handle.addBlockItem(BlockItemRegistration.COBBLED_LATERITE.get(), "Cobbled Laterite");
        handle.addBlockItem(BlockItemRegistration.COBBLED_SILTSTONE.get(), "Cobbled Siltstone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_DOLOSTONE.get(), "Cobbled Dolostone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_LIMESTONE.get(), "Cobbled Limestone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_CHALK.get(), "Cobbled Chalk");
        handle.addBlockItem(BlockItemRegistration.COBBLED_IRONSTONE.get(), "Cobbled Ironstone");
        handle.addBlockItem(BlockItemRegistration.COBBLED_SHALE.get(), "Cobbled Shale");
        handle.addBlockItem(BlockItemRegistration.COBBLED_ARKOSE.get(), "Cobbled Arkose");
        // INFESTED COBBLE
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_SILTSTONE.get(), "Infested Cobbled Siltstone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_DOLOSTONE.get(), "Infested Cobbled Dolostone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_LIMESTONE.get(), "Infested Cobbled Limestone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_CHALK.get(), "Infested Cobbled Chalk");
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_IRONSTONE.get(), "Infested Cobbled Ironstone");
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_SHALE.get(), "Infested Cobbled Shale");
        handle.addBlockItem(BlockItemRegistration.INFESTED_COBBLED_ARKOSE.get(), "Infested Cobbled Arkose");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE_CHERT_ORE.get(), "Chert in Limestone");
    }

    private void addSoundTranslations(LanguageProviderHandle handle)
    {
    }

    private void addItemTranslations(LanguageProviderHandle handle)
    {
    }

    private void addCreativeTabTranslations(LanguageProviderHandle handle)
    {
    }

    private void addGUITranslations(LanguageProviderHandle handle)
    {
    }

    private void addTooltipTranslations(LanguageProviderHandle handle)
    {
    }
}
