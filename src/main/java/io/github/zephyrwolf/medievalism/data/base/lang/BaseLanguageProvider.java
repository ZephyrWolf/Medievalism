package io.github.zephyrwolf.medievalism.data.base.lang;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.KeepersCrockBlock;
import io.github.zephyrwolf.medievalism.common.block.SettlersPotBlock;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class BaseLanguageProvider extends LanguageProvider
{
    public BaseLanguageProvider(PackOutput output, String locale)
    {
        super(output, MedievalismConstants.MOD_ID, locale);
    }

    @Override
    protected void addTranslations()
    {
        addPackTranslations();
        addNetworkingTranslations();
        addSoundTranslations();
        addBlockTranslations();
        addBlockItemTranslations();
        addItemTranslations();
        addCreativeTabTranslations();
        addGUITranslations();
        addTooltipTranslations();
        addAdvancementTranslations();
    }

    private void addPackTranslations()
    {
        add("medievalism.pack.title.overhaul.client_resources", "Medievalism Overhaul - Looks");
        add("medievalism.pack.title.overhaul.server_data", "Medievalism Overhaul - Progression");
        add("medievalism.pack.source.overhaul", "Medievalism Overhaul Source");
    }

    private void addNetworkingTranslations()
    {
        add("medievalism.networking.failed", "Medievalism crashed you :(");
    }

    private void addSoundTranslations()
    {
        add("medievalism.sound.entity.inhand_knap.hit", "In-hand Knap Hit");
        add("medievalism.sound.entity.inhand_knap.final_hit", "In-hand Knap Final Hit");
        add("medievalism.sound.entity.inhand_knap.fail", "In-hand Knap Fail");
    }

    private void addBlockTranslations()
    {
        add(BlockRegistration.FIRE_LAY.get(), "Thatch"); // TODO Seperate firelay and thatch names
        add(BlockRegistration.DRYING_GATHERERS_JAR.get(), "Drying Gatherer's Jar");
        add(BlockRegistration.DRYING_KEEPERS_CROCK.get(), "Drying Keeper's Crock");
        add(BlockRegistration.DRYING_SETTLERS_POT.get(), "Drying Settler's Pot");
        add(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), "Drying Clay Cooking Pot");
        add(BlockRegistration.DRYING_CLAY_CAULDRON.get(), "Drying Clay Cauldron");
        add(BlockRegistration.DRYING_JUG.get(), "Drying Jug");
        add(BlockRegistration.DRYING_FLOWER_POT.get(), "Drying Flower Pot");
        add(BlockRegistration.DRYING_DECORATED_POT.get(), "Drying Decorated Pot");
        add(BlockRegistration.TIN_ORE_IN_GREYWACKE.get(), "Tin Ore Block");
        add(BlockRegistration.TIN_ORE_IN_GABBRO.get(), "Deepslate Tin Ore Block");
        add(BlockRegistration.YAMS.get(), "Yams");
    }

    private void addBlockItemTranslations()
    {
        // GRAVEL
        // SAND
        // DIRT
        add(BlockItemRegistration.SILT.get(), "Silt");
        // STONE
        add(BlockItemRegistration.SOFT_TUFF.get(), "Soft Tuff");
        add(BlockItemRegistration.IGNIMBRITE.get(), "Ignimbrite");
        add(BlockItemRegistration.LAPILLISTONE.get(), "Lapillistone");
        add(BlockItemRegistration.SAPROLITE.get(), "Saprolite");
        add(BlockItemRegistration.LATERITE.get(), "Laterite");
        add(BlockItemRegistration.SILTSTONE.get (), "Siltstone");
        add(BlockItemRegistration.DOLOSTONE.get(), "Dolostone");
        add(BlockItemRegistration.LIMESTONE.get(), "Limestone");
        add(BlockItemRegistration.CHALK.get(), "Chalk");
        add(BlockItemRegistration.IRONSTONE.get(), "Ironstone");
        add(BlockItemRegistration.SHALE.get(), "Shale");
        add(BlockItemRegistration.ARKOSE.get(), "Arkose");
        add(BlockItemRegistration.MARBLE.get(), "Marble");
        add(BlockItemRegistration.QUARTZITE.get(), "Quartzite");
        add(BlockItemRegistration.HORNFELS.get(), "Hornfels");
        add(BlockItemRegistration.SLATE.get(), "Slate");
        add(BlockItemRegistration.SMOOTH_DIORITE.get(), "Smooth Diorite");
        add(BlockItemRegistration.SMOOTH_GRANITE.get(), "Smooth Granite");
        add(BlockItemRegistration.NORITE.get(), "Norite");
        add(BlockItemRegistration.PERIDOTITE.get(), "Peridotite");
        add(BlockItemRegistration.RHYOLITE.get(), "Rhyolite");
        add(BlockItemRegistration.DACITE.get(), "Dacite");
        // COPPER ORE
        add(BlockItemRegistration.SAPROLITE_COPPER_ORE.get(), "Copper Traces in Saprolite");
        add(BlockItemRegistration.SILTSTONE_COPPER_ORE.get(), "Copper Ore in Siltstone");
        add(BlockItemRegistration.DOLOSTONE_COPPER_ORE.get(), "Copper Ore in Dolostone");
        add(BlockItemRegistration.LIMESTONE_COPPER_ORE.get(), "Copper Ore in Limestone");
        add(BlockItemRegistration.CHALK_COPPER_ORE.get(), "Copper Ore in Chalk");
        add(BlockItemRegistration.IRONSTONE_COPPER_ORE.get(), "Copper Ore in Ironstone");
        add(BlockItemRegistration.SHALE_COPPER_ORE.get(), "Copper Ore in Shale");
        add(BlockItemRegistration.ARKOSE_COPPER_ORE.get(), "Copper Ore in Arkose");
        add(BlockItemRegistration.MARBLE_COPPER_ORE.get(), "Copper Ore in Marble");
        add(BlockItemRegistration.QUARTZITE_COPPER_ORE.get(), "Copper Ore in Quartzite");
        add(BlockItemRegistration.HORNFELS_COPPER_ORE.get(), "Copper Ore in Hornfels");
        add(BlockItemRegistration.SLATE_COPPER_ORE.get(), "Copper Ore in Slate");
        // IRON ORE
        add(BlockItemRegistration.GABBRO_IRON_ORE.get(), "Iron Ore in Gabbro");
        add(BlockItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "Iron Ore in Smooth Diorite");
        add(BlockItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "Iron Ore in Smooth Granite");
        add(BlockItemRegistration.NORITE_IRON_ORE.get(), "Iron Ore in Norite");
        add(BlockItemRegistration.PERIDOTITE_IRON_ORE.get(), "Iron Ore in Peridotite");
        add(BlockItemRegistration.RHYOLITE_IRON_ORE.get(), "Iron Ore in Rhyolite");
        add(BlockItemRegistration.DACITE_IRON_ORE.get(), "Iron Ore in Dacite");
        add(BlockItemRegistration.ANDESITE_IRON_ORE.get(), "Iron Ore in Andesite");
        add(BlockItemRegistration.BASALT_IRON_ORE.get(), "Iron Ore in Basalt");
        // GOLD ORE
        add(BlockItemRegistration.GREYWACKE_GOLD_ORE.get(), "Gold Ore in Greywacke");
        add(BlockItemRegistration.SILTSTONE_GOLD_ORE.get(), "Gold Ore in Siltstone");
        add(BlockItemRegistration.DOLOSTONE_GOLD_ORE.get(), "Gold Ore in Dolostone");
        add(BlockItemRegistration.LIMESTONE_GOLD_ORE.get(), "Gold Ore in Limestone");
        add(BlockItemRegistration.CHALK_GOLD_ORE.get(), "Gold Ore in Chalk");
        add(BlockItemRegistration.IRONSTONE_GOLD_ORE.get(), "Gold Ore in Ironstone");
        add(BlockItemRegistration.SHALE_GOLD_ORE.get(), "Gold Ore in Shale");
        add(BlockItemRegistration.ARKOSE_GOLD_ORE.get(), "Gold Ore in Arkose");
        add(BlockItemRegistration.MARBLE_GOLD_ORE.get(), "Gold Ore in Marble");
        add(BlockItemRegistration.QUARTZITE_GOLD_ORE.get(), "Gold Ore in Quartzite");
        add(BlockItemRegistration.HORNFELS_GOLD_ORE.get(), "Gold Ore in Hornfels");
        add(BlockItemRegistration.SLATE_GOLD_ORE.get(), "Gold Ore in Slate");
        add(BlockItemRegistration.GABBRO_GOLD_ORE.get(), "Gold Ore in Gabbro");
        add(BlockItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "Gold Ore in Smooth Diorite");
        add(BlockItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "Gold Ore in Smooth Granite");
        add(BlockItemRegistration.NORITE_GOLD_ORE.get(), "Gold Ore in Norite");
        add(BlockItemRegistration.PERIDOTITE_GOLD_ORE.get(), "Gold Ore in Peridotite");
        add(BlockItemRegistration.RHYOLITE_GOLD_ORE.get(), "Gold Ore in Rhyolite");
        add(BlockItemRegistration.DACITE_GOLD_ORE.get(), "Gold Ore in Dacite");
        add(BlockItemRegistration.ANDESITE_GOLD_ORE.get(), "Gold Ore in Andesite");
        add(BlockItemRegistration.BASALT_GOLD_ORE.get(), "Gold Ore in Basalt");
        // COAL ORE
        add(BlockItemRegistration.SAPROLITE_COAL_ORE.get(), "Coal Ore in Saprolite");
        add(BlockItemRegistration.LATERITE_COAL_ORE.get(), "Coal Ore in Laterite");
        add(BlockItemRegistration.GREYWACKE_COAL_ORE.get(), "Coal Ore in Greywacke");
        add(BlockItemRegistration.SILTSTONE_COAL_ORE.get(), "Coal Ore in Siltstone");
        add(BlockItemRegistration.DOLOSTONE_COAL_ORE.get(), "Coal Ore in Dolostone");
        add(BlockItemRegistration.LIMESTONE_COAL_ORE.get(), "Coal Ore in Limestone");
        add(BlockItemRegistration.CHALK_COAL_ORE.get(), "Coal Ore in Chalk");
        add(BlockItemRegistration.IRONSTONE_COAL_ORE.get(), "Coal Ore in Ironstone");
        add(BlockItemRegistration.SHALE_COAL_ORE.get(), "Coal Ore in Shale");
        add(BlockItemRegistration.ARKOSE_COAL_ORE.get(), "Coal Ore in Arkose");
        add(BlockItemRegistration.MARBLE_COAL_ORE.get(), "Coal Ore in Marble");
        add(BlockItemRegistration.QUARTZITE_COAL_ORE.get(), "Coal Ore in Quartzite");
        add(BlockItemRegistration.HORNFELS_COAL_ORE.get(), "Coal Ore in Hornfels");
        add(BlockItemRegistration.SLATE_COAL_ORE.get(), "Coal Ore in Slate");
        // DIAMOND ORE
        add(BlockItemRegistration.GABBRO_DIAMOND_ORE.get(), "Diamond Ore in Gabbro");
        add(BlockItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "Diamond Ore in Smooth Diorite");
        add(BlockItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "Diamond Ore in Smooth Granite");
        add(BlockItemRegistration.NORITE_DIAMOND_ORE.get(), "Diamond Ore in Norite");
        add(BlockItemRegistration.PERIDOTITE_DIAMOND_ORE.get(), "Diamond Ore in Peridotite");
        add(BlockItemRegistration.ANDESITE_DIAMOND_ORE.get(), "Diamond Ore in Andesite");
        add(BlockItemRegistration.BASALT_DIAMOND_ORE.get(), "Diamond Ore in Basalt");
        // EMERALD ORE
        add(BlockItemRegistration.GABBRO_EMERALD_ORE.get(), "Emerald Ore in Gabbro");
        add(BlockItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "Emerald Ore in Smooth Diorite");
        add(BlockItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "Emerald Ore in Smooth Granite");
        add(BlockItemRegistration.NORITE_EMERALD_ORE.get(), "Emerald Ore in Norite");
        add(BlockItemRegistration.PERIDOTITE_EMERALD_ORE.get(), "Emerald Ore in Peridotite");
        add(BlockItemRegistration.RHYOLITE_EMERALD_ORE.get(), "Emerald Ore in Rhyolite");
        add(BlockItemRegistration.DACITE_EMERALD_ORE.get(), "Emerald Ore in Dacite");
        add(BlockItemRegistration.ANDESITE_EMERALD_ORE.get(), "Emerald Ore in Andesite");
        add(BlockItemRegistration.BASALT_EMERALD_ORE.get(), "Emerald Ore in Basalt");
        // LAPIS ORE
        add(BlockItemRegistration.MARBLE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Marble");
        add(BlockItemRegistration.QUARTZITE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Quartzite");
        add(BlockItemRegistration.HORNFELS_LAPIS_ORE.get(), "Lapis Lazuli Ore in Hornfels");
        add(BlockItemRegistration.SLATE_LAPIS_ORE.get(), "Lapis Lazuli Ore in Slate");
        // REDSTONE ORE
        add(BlockItemRegistration.GABBRO_REDSTONE_ORE.get(), "Redstone Ore in Gabbro");
        add(BlockItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "Redstone Ore in Smooth Diorite");
        add(BlockItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "Redstone Ore in Smooth Granite");
        add(BlockItemRegistration.NORITE_REDSTONE_ORE.get(), "Redstone Ore in Norite");
        add(BlockItemRegistration.PERIDOTITE_REDSTONE_ORE.get(), "Redstone Ore in Peridotite");
        // COBBLE
        add(BlockItemRegistration.COBBLED_SOFT_TUFF.get(), "Cobbled Soft Tuff");
        add(BlockItemRegistration.COBBLED_IGNIMBRITE.get(), "Cobbled Ignimbrite");
        add(BlockItemRegistration.COBBLED_LAPILLISTONE.get(), "Cobbled Lapillistone");
        add(BlockItemRegistration.COBBLED_WELDED_TUFF.get(), "Cobbled Welded Tuff");
        add(BlockItemRegistration.COBBLED_SANDSTONE.get(), "Cobbled Sandstone");
        add(BlockItemRegistration.COBBLED_RED_SANDSTONE.get(), "Cobbled Red Sandstone");
        add(BlockItemRegistration.COBBLED_SAPROLITE.get(), "Cobbled Saprolite");
        add(BlockItemRegistration.COBBLED_LATERITE.get(), "Cobbled Laterite");
        add(BlockItemRegistration.COBBLED_SILTSTONE.get(), "Cobbled Siltstone");
        add(BlockItemRegistration.COBBLED_DOLOSTONE.get(), "Cobbled Dolostone");
        add(BlockItemRegistration.COBBLED_LIMESTONE.get(), "Cobbled Limestone");
        add(BlockItemRegistration.COBBLED_CHALK.get(), "Cobbled Chalk");
        add(BlockItemRegistration.COBBLED_IRONSTONE.get(), "Cobbled Ironstone");
        add(BlockItemRegistration.COBBLED_SHALE.get(), "Cobbled Shale");
        add(BlockItemRegistration.COBBLED_ARKOSE.get(), "Cobbled Arkose");
        // INFESTED STONE
        add(BlockItemRegistration.INFESTED_SILTSTONE.get(), "Infested Siltstone");
        add(BlockItemRegistration.INFESTED_DOLOSTONE.get(), "Infested Dolostone");
        add(BlockItemRegistration.INFESTED_LIMESTONE.get(), "Infested Limestone");
        add(BlockItemRegistration.INFESTED_SHALE.get(), "Infested Shale");
        add(BlockItemRegistration.INFESTED_ARKOSE.get(), "Infested Arkose");
        add(BlockItemRegistration.INFESTED_MARBLE.get(), "Infested Marble");
        add(BlockItemRegistration.INFESTED_QUARTZITE.get(), "Infested Quartzite");
        add(BlockItemRegistration.INFESTED_HORNFELS.get(), "Infested Hornfels");
        add(BlockItemRegistration.INFESTED_SLATE.get(), "Infested Slate");
        add(BlockItemRegistration.INFESTED_SMOOTH_DIORITE.get(), "Infested Smooth Diorite");
        add(BlockItemRegistration.INFESTED_SMOOTH_GRANITE.get(), "Infested Smooth Granite");
        add(BlockItemRegistration.INFESTED_NORITE.get(), "Infested Norite");
        add(BlockItemRegistration.INFESTED_PERIDOTITE.get(), "Infested Peridotite");
        add(BlockItemRegistration.INFESTED_RHYOLITE.get(), "Infested Rhyolite");
        add(BlockItemRegistration.INFESTED_DACITE.get(), "Infested Dacite");
        add(BlockItemRegistration.INFESTED_ANDESITE.get(), "Infested Andesite");
        add(BlockItemRegistration.INFESTED_BASALT.get(), "Infested Basalt");
        // INFESTED COBBLE
        add(BlockItemRegistration.INFESTED_COBBLED_SILTSTONE.get(), "Infested Cobbled Siltstone");
        add(BlockItemRegistration.INFESTED_COBBLED_DOLOSTONE.get(), "Infested Cobbled Dolostone");
        add(BlockItemRegistration.INFESTED_COBBLED_LIMESTONE.get(), "Infested Cobbled Limestone");
        add(BlockItemRegistration.INFESTED_COBBLED_CHALK.get(), "Infested Cobbled Chalk");
        add(BlockItemRegistration.INFESTED_COBBLED_IRONSTONE.get(), "Infested Cobbled Ironstone");
        add(BlockItemRegistration.INFESTED_COBBLED_SHALE.get(), "Infested Cobbled Shale");
        add(BlockItemRegistration.INFESTED_COBBLED_ARKOSE.get(), "Infested Cobbled Arkose");

        add(BlockItemRegistration.LIMESTONE_CHERT_ORE.get(), "Chert in Limestone");
        add(BlockItemRegistration.CHALK_CHERT_ORE.get(), "Chert in Chalk");
        add(BlockItemRegistration.BASALT_GEODE_ORE.get(), "Geode in Basalt");
        add(BlockItemRegistration.ANDESITE_GEODE_ORE.get(), "Geode in Andesite");
        add(BlockItemRegistration.RHYOLITE_GEODE_ORE.get(), "Geode in Rhyolite");
        add(BlockItemRegistration.DACITE_GEODE_ORE.get(), "Geode in Dacite");

        add(BlockItemRegistration.OAK_BRANCH.get(), "Oak Branch");
        add(BlockItemRegistration.BIRCH_BRANCH.get(), "Birch Branch");
        add(BlockItemRegistration.SPRUCE_BRANCH.get(), "Spruce Branch");
        add(BlockItemRegistration.JUNGLE_BRANCH.get(), "Jungle Branch");
        add(BlockItemRegistration.DARK_OAK_BRANCH.get(), "Dark Oak Branch");
        add(BlockItemRegistration.ACACIA_BRANCH.get(), "Acacia Branch");
        add(BlockItemRegistration.MANGROVE_BRANCH.get(), "Mangrove Branch");
        add(BlockItemRegistration.CHERRY_BRANCH.get(), "Cherry Branch");

        // ROCK
        add(BlockItemRegistration.SANDSTONE_ROCK.get(), "Sandstone Rock");
        add(BlockItemRegistration.RED_SANDSTONE_ROCK.get(), "Red Sandstone Rock");
        add(BlockItemRegistration.SAPROLITE_ROCK.get(), "Saprolite Rock");
        add(BlockItemRegistration.LATERITE_ROCK.get(), "Laterite Rock");
        add(BlockItemRegistration.SILT_CLUMP.get(), "Silt Clump");
        add(BlockItemRegistration.GREYWACKE_ROCK.get(), "Greywacke Rock");
        add(BlockItemRegistration.SILTSTONE_ROCK.get(), "Siltstone Rock");
        add(BlockItemRegistration.DOLOSTONE_ROCK.get(), "Dolostone Rock");
        add(BlockItemRegistration.LIMESTONE_ROCK.get(), "Limestone Rock");
        add(BlockItemRegistration.IRONSTONE_ROCK.get(), "Ironstone Rock");
        add(BlockItemRegistration.SHALE_ROCK.get(), "Shale Rock");
        add(BlockItemRegistration.ARKOSE_ROCK.get(), "Arkose Rock");
        add(BlockItemRegistration.MARBLE_ROCK.get(), "Marble Rock");
        add(BlockItemRegistration.QUARTZITE_ROCK.get(), "Quartzite Rock");
        add(BlockItemRegistration.HORNFELS_ROCK.get(), "Hornfels Rock");
        add(BlockItemRegistration.SLATE_ROCK.get(), "Slate Rock");
        add(BlockItemRegistration.GABBRO_ROCK.get(), "Gabbro Rock");
        add(BlockItemRegistration.SMOOTH_DIORITE_ROCK.get(), "Smooth Diorite Rock");
        add(BlockItemRegistration.SMOOTH_GRANITE_ROCK.get(), "Smooth Granite Rock");
        add(BlockItemRegistration.NORITE_ROCK.get(), "Norite Rock");
        add(BlockItemRegistration.PERIDOTITE_ROCK.get(), "Peridotite Rock");
        add(BlockItemRegistration.GREYWACKE_ROCK.get().getDescriptionId() + ".hammerstone", "Greywacke Hammerstone");
        add(BlockItemRegistration.SILTSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Siltstone Hammerstone");
        add(BlockItemRegistration.DOLOSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Dolostone Hammerstone");
        add(BlockItemRegistration.LIMESTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Limestone Hammerstone");
        add(BlockItemRegistration.IRONSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Ironstone Hammerstone");
        add(BlockItemRegistration.ARKOSE_ROCK.get().getDescriptionId() + ".hammerstone", "Arkose Hammerstone");
        add(BlockItemRegistration.MARBLE_ROCK.get().getDescriptionId() + ".hammerstone", "Marble Hammerstone");
        add(BlockItemRegistration.QUARTZITE_ROCK.get().getDescriptionId() + ".hammerstone", "Quartzite Hammerstone");
        add(BlockItemRegistration.HORNFELS_ROCK.get().getDescriptionId() + ".hammerstone", "Hornfels Hammerstone");
        add(BlockItemRegistration.SLATE_ROCK.get().getDescriptionId() + ".hammerstone", "Slate Hammerstone");
        add(BlockItemRegistration.GABBRO_ROCK.get().getDescriptionId() + ".hammerstone", "Gabbro Hammerstone");
        add(BlockItemRegistration.SMOOTH_DIORITE_ROCK.get().getDescriptionId() + ".hammerstone", "Smooth Diorite Hammerstone");
        add(BlockItemRegistration.SMOOTH_GRANITE_ROCK.get().getDescriptionId() + ".hammerstone", "Smooth Granite Hammerstone");
        add(BlockItemRegistration.NORITE_ROCK.get().getDescriptionId() + ".hammerstone", "Norite Hammerstone");
        add(BlockItemRegistration.PERIDOTITE_ROCK.get().getDescriptionId() + ".hammerstone", "Peridotite Hammerstone");
        // LARGE ROCK
        add(BlockItemRegistration.LARGE_SANDSTONE_ROCK.get(), "Large Sandstone Rock");
        add(BlockItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "Red Large Sandstone Rock");
        add(BlockItemRegistration.LARGE_SAPROLITE_ROCK.get(), "Large Saprolite Rock");
        add(BlockItemRegistration.LARGE_LATERITE_ROCK.get(), "Large Laterite Rock");
        add(BlockItemRegistration.LARGE_SILT_CLUMP.get(), "Large Silt Clump");
        add(BlockItemRegistration.LARGE_GREYWACKE_ROCK.get(), "Large Greywacke Rock");
        add(BlockItemRegistration.LARGE_SILTSTONE_ROCK.get(), "Large Siltstone Rock");
        add(BlockItemRegistration.LARGE_DOLOSTONE_ROCK.get(), "Large Dolostone Rock");
        add(BlockItemRegistration.LARGE_LIMESTONE_ROCK.get(), "Large Limestone Rock");
        add(BlockItemRegistration.LARGE_IRONSTONE_ROCK.get(), "Large Ironstone Rock");
        add(BlockItemRegistration.LARGE_SHALE_ROCK.get(), "Large Shale Rock");
        add(BlockItemRegistration.LARGE_ARKOSE_ROCK.get(), "Large Arkose Rock");
        add(BlockItemRegistration.LARGE_MARBLE_ROCK.get(), "Large Marble Rock");
        add(BlockItemRegistration.LARGE_QUARTZITE_ROCK.get(), "Large Quartzite Rock");
        add(BlockItemRegistration.LARGE_HORNFELS_ROCK.get(), "Large Hornfels Rock");
        add(BlockItemRegistration.LARGE_SLATE_ROCK.get(), "Large Slate Rock");
        add(BlockItemRegistration.LARGE_GABBRO_ROCK.get(), "Large Gabbro Rock");
        add(BlockItemRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "Large Smooth Diorite Rock");
        add(BlockItemRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "Large Smooth Granite Rock");
        add(BlockItemRegistration.LARGE_NORITE_ROCK.get(), "Large Norite Rock");
        add(BlockItemRegistration.LARGE_PERIDOTITE_ROCK.get(), "Large Peridotite Rock");
        // COPPER ROCK
        add(BlockItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), "Saprolite Rock with Copper");
        add(BlockItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "Greywacke Rock with Copper");
        add(BlockItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "Siltstone Rock with Copper");
        add(BlockItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "Dolostone Rock with Copper");
        add(BlockItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "Limestone Rock with Copper");
        add(BlockItemRegistration.CHALK_ROCK_COPPER_ORE.get(), "Chalk Rock with Copper");
        add(BlockItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "Ironstone Rock with Copper");
        add(BlockItemRegistration.SHALE_ROCK_COPPER_ORE.get(), "Shale Rock with Copper");
        add(BlockItemRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "Arkose Rock with Copper");

        add(BlockItemRegistration.CLAY_IN_GRASS.get(), "Clay in Grass");
        add(BlockItemRegistration.RED_CLAY_IN_GRASS.get(), "Red Clay in Grass");
        add(BlockItemRegistration.CLAY_IN_DIRT.get(), "Clay in Dirt");
        add(BlockItemRegistration.RED_CLAY_IN_DIRT.get(), "Red Clay in Dirt");
        add(BlockItemRegistration.THATCH_BLOCK.get(), "Thatch Block");
        add(BlockItemRegistration.WET_PACKED_MUD.get(), "Wet Packed Mud");
        add(BlockItemRegistration.WET_DAUB_BLOCK.get(), "Wet Daub Block");
        add(BlockItemRegistration.DAUB_BLOCK.get(), "Daub Block");
        add(BlockItemRegistration.DAUB_BRICKS.get(), "Daub Brick Block");
        add(BlockItemRegistration.CRACKED_DAUB_BLOCK.get(), "Cracked Daub Block");
        add(BlockItemRegistration.CRACKED_DAUB_BRICKS.get(), "Cracked Daub Brick Block");
        add(BlockItemRegistration.SHRUB.get(), "Shrub");
        add(BlockItemRegistration.DOGBANE_BLOCK_ITEM.get(), "Dogbane");
        add(BlockItemRegistration.WET_PACKED_MUD_BRICK.get(), "Wet Packed Mud Brick");
        add(BlockItemRegistration.WET_DAUB_BRICK.get(), "Wet Daub Brick");
        add(BlockItemRegistration.WET_CLAY_BRICK.get(), "Wet Clay Brick");
        add(BlockItemRegistration.WET_RED_CLAY_BRICK.get(), "Wet Red Clay Brick");
        add(BlockItemRegistration.WET_GATHERERS_JAR.get(), "Wet Gatherer's Jar");
        add(BlockItemRegistration.DRY_GATHERERS_JAR.get(), "Unfired Gatherer's Jar");
        add(BlockItemRegistration.GATHERERS_JAR.get(), "Gatherer's Jar");
        add(BlockItemRegistration.WET_KEEPERS_CROCK.get(), "Wet Keeper's Crock");
        add(BlockItemRegistration.DRY_KEEPERS_CROCK.get(), "Unfired Keeper's Crock");
        add(BlockItemRegistration.KEEPERS_CROCK.get(), "Keeper's Crock");
        add(BlockItemRegistration.WET_SETTLERS_POT.get(), "Wet Settler's Pot");
        add(BlockItemRegistration.DRY_SETTLERS_POT.get(), "Unfired Settler's Pot");
        add(BlockItemRegistration.SETTLERS_POT.get(), "Settler's Pot");
        add(BlockItemRegistration.WET_CLAY_COOKING_POT.get(), "Wet Clay Cooking Pot");
        add(BlockItemRegistration.DRY_CLAY_COOKING_POT.get(), "Unfired Clay Cooking Pot");
        add(BlockItemRegistration.CLAY_COOKING_POT.get(), "Clay Cooking Pot");
        add(BlockItemRegistration.WET_CLAY_CAULDRON.get(), "Wet Clay Cauldron");
        add(BlockItemRegistration.DRY_CLAY_CAULDRON.get(), "Unfired Clay Cauldron");
        add(BlockItemRegistration.CLAY_CAULDRON.get(), "Clay Cauldron");
        add(BlockItemRegistration.WET_JUG.get(), "Wet Jug");
        add(BlockItemRegistration.DRY_JUG.get(), "Unfired Jug");
        add(BlockItemRegistration.JUG.get(), "Jug");
        add(BlockItemRegistration.WET_FLOWER_POT.get(), "Wet Flower Pot");
        add(BlockItemRegistration.DRY_FLOWER_POT.get(), "Unfired Flower Pot");
        add(BlockItemRegistration.WET_DECORATED_POT.get(), "Wet Decorated Pot");
        add(BlockItemRegistration.DRY_DECORATED_POT.get(), "Unfired Decorated Pot");
        add(BlockItemRegistration.RED_CLAY_BLOCK.get(), "Red Clay");
        add(BlockItemRegistration.STONE_BENCH.get(), "Stone Bench");
        add(BlockItemRegistration.CHOPPING_BLOCK.get(), "Chopping Block");
    }

    private void addItemTranslations()
    {
        add(ItemRegistration.BROKEN_GOAT_HORN.get(), "Broken Goat Horn");
        add(ItemRegistration.MUD_BALL.get(), "Mud Ball");
        add(ItemRegistration.WET_DAUB.get(), "Daub");
        add(ItemRegistration.PACKED_MUD_BRICK.get(), "Packed Mud Brick");
        add(ItemRegistration.DAUB_BRICK.get(), "Daub Brick");
        add(ItemRegistration.DIRT_CHUNK.get(), "Dirt Chunk");
        add(ItemRegistration.RED_CLAY_BALL.get(), "Red Clay Ball");
        add(ItemRegistration.RAW_TIN.get(), "Tin Ore");
        add(ItemRegistration.FLAX.get(), "Flax");
        add(ItemRegistration.FLAX_SEEDS.get(), "Flax Seeds");
        add(ItemRegistration.FLAX_FIBER.get(), "Flax Fiber");
        add(ItemRegistration.BLUEBERRIES.get(), "Blueberries");
        add(ItemRegistration.RASPBERRIES.get(), "Raspberries");
        add(ItemRegistration.STRAWBERRIES.get(), "Strawberries");
        add(ItemRegistration.BARLEY_SEEDS.get(), "Barley Seeds");
        add(ItemRegistration.BARLEY.get(), "Barley");
        add(ItemRegistration.OAT_SEEDS.get(), "Oat Seeds");
        add(ItemRegistration.OATS.get(), "Oats");
        add(ItemRegistration.YAM.get(), "Yam");
        add(ItemRegistration.BAKED_YAM.get(), "Baked Yam");
        add(ItemRegistration.BAKED_BEETROOT.get(), "Baked Beetroot");
        add(ItemRegistration.BAKED_CARROT.get(), "Baked Carrot");
        add(ItemRegistration.CRACKED_BARLEY.get(), "Cracked Barley");
        add(ItemRegistration.CRACKED_WHEAT.get(), "Cracked Wheat");
        add(ItemRegistration.ROLLED_OATS.get(), "Rolled Oats");
        add(ItemRegistration.FLOUR.get(), "Flour");
        add(ItemRegistration.DOUGH.get(), "Dough");
        add(ItemRegistration.LUNATE.get(), "Lunate");
        add(ItemRegistration.BIFACE.get(), "Biface");
        add(ItemRegistration.HAMMERSTONE.get(), "hammerstone");
        add(ItemRegistration.UNFIRED_BRICK.get(), "Unfired Brick");
        add(ItemRegistration.WHITE_BARK.get(), "White Bark");
        add(ItemRegistration.BROWN_BARK.get(), "Brown Bark");
        add(ItemRegistration.GREY_BARK.get(), "Grey Bark");
        add(ItemRegistration.DARK_BROWN_BARK.get(), "Dark Brown Bark");
        add(ItemRegistration.BLACK_BARK.get(), "Black Bark");
        add(ItemRegistration.CAMEL_HIDE.get(), "Camel Hide");
        add(ItemRegistration.COW_HIDE.get(), "Cow Hide");
        add(ItemRegistration.DONKEY_HIDE.get(), "Donkey Hide");
        add(ItemRegistration.HOGLIN_HIDE.get(), "Hoglin Hide");
        add(ItemRegistration.HORSE_HIDE.get(), "Horse Hide");
        add(ItemRegistration.MOOSHROOM_HIDE.get(), "Mooshroom Hide");
        add(ItemRegistration.MULE_HIDE.get(), "Mule Hide");
        add(ItemRegistration.RAVAGER_HIDE.get(), "Raveger Hide"); // Should this be extra large?
        add(ItemRegistration.SHEEP_HIDE.get(), "Sheep Hide");
        add(ItemRegistration.FOX_HIDE.get(), "Fox Hide");
        add(ItemRegistration.SNOW_FOX_HIDE.get(), "Snow Fox Hide");
        add(ItemRegistration.WOLF_HIDE.get(), "Wolf Hide"); // Only one variable
        add(ItemRegistration.OCELOT_HIDE.get(), "Ocelot Hide");
        add(ItemRegistration.CAT_HIDE.get(), "Cat Hide"); // Only one variable
        add(ItemRegistration.BAT_HIDE.get(), "Bat Hide");
        add(ItemRegistration.GOAT_HIDE.get(), "Goat Hide");
        add(ItemRegistration.LLAMA_HIDE.get(), "Llama Hide");
        add(ItemRegistration.PANDA_HIDE.get(), "Panda Hide");
        add(ItemRegistration.PIG_HIDE.get(), "Pig Hide");
        add(ItemRegistration.POLAR_BEAR_HIDE.get(), "Polar Bear Hide");
        add(ItemRegistration.SNIFFER_HIDE.get(), "Sniffer Hide");
        add(ItemRegistration.LARGE_LIMED_HIDE.get(), "Large Limed Hide");
        add(ItemRegistration.MEDIUM_LIMED_HIDE.get(), "Medium Limed Hide");
        add(ItemRegistration.SMALL_LIMED_HIDE.get(), "Small Limed Hide");
        add(ItemRegistration.LARGE_RAW_HIDE.get(), "Large Raw Hide");
        add(ItemRegistration.MEDIUM_RAW_HIDE.get(), "Medium Raw Hide");
        add(ItemRegistration.SMALL_RAW_HIDE.get(), "Small Raw Hide");
        add(ItemRegistration.LARGE_WET_LEATHER.get(), "Large Wet Leather");
        add(ItemRegistration.MEDIUM_WET_LEATHER.get(), "Medium Wet Leather");
        add(ItemRegistration.SMALL_WET_LEATHER.get(), "Small Wet Leather");
        add(ItemRegistration.MEDIUM_LEATHER.get(), "Medium Leather");
        add(ItemRegistration.SMALL_LEATHER.get(), "Small Leather");
        add(ItemRegistration.CHARCOAL_POWDER.get(), "Charcoal Powder");
        add(ItemRegistration.FIRECLAY.get(), "Fireclay");
        add(ItemRegistration.POTASH.get(), "Potash");
        add(ItemRegistration.REFRACTORY_CLAY.get(), "Refractory Clay");
        add(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get(), "Unfired Clay Crucible");
        add(ItemRegistration.CLAY_CRUCIBLE.get(), "Clay Crucible");
        add(ItemRegistration.UNFIRED_FIRECLAY_CRUCIBLE.get(), "Unfired Fireclay Crucible");
        add(ItemRegistration.FIRECLAY_CRUCIBLE.get(), "Fireclay Crucible");
        add(ItemRegistration.UNFIRED_REFRACTORY_CRUCIBLE.get(), "Unfired Refractory Crucible");
        add(ItemRegistration.REFRACTORY_CRUCIBLE.get(), "Refractory Crucible");
        add(ItemRegistration.COPPER_ORE_DUST.get(), "Copper Ore Dust");
        add(ItemRegistration.TIN_ORE_DUST.get(), "Tin Ore Dust");
        add(ItemRegistration.IRON_ORE_DUST.get(), "Iron Ore Dust");
        add(ItemRegistration.QUICK_LIME.get(), "Quicklime");
        add(ItemRegistration.CHOPPED_WOOD.get(), "Chopped Wood");
        add(ItemRegistration.SLACKED_LIME_BUCKET.get(), "Slacked Lime Bucket");
        add(ItemRegistration.TANNIN_BUCKET.get(), "Tannin Bucket");
        add(ItemRegistration.DIGGING_STICK.get(), "Digging Stick");
        add(ItemRegistration.FIRE_STARTER.get(), "Fire Starter");
        add(ItemRegistration.WOOD_ASH.get(), "Wood Ash");
    }

    private void addCreativeTabTranslations()
    {
        add("creative_tab.medievalism.name", "Medievalism");
    }

    private void addGUITranslations()
    {
        add(GatherersJarBlock.LANG_DEFAULT_NAME, "Gatherer's Jar");
        add(KeepersCrockBlock.LANG_DEFAULT_NAME, "Keeper's Crock");
        add(SettlersPotBlock.LANG_DEFAULT_NAME, "Settler's Pot");
    }

    private void addTooltipTranslations()
    {
        add(GatherersJarBlock.LANG_ITEM_COUNT, "%s x%s");
        add(GatherersJarBlock.LANG_MORE, "and %s more...");
        add(KeepersCrockBlock.LANG_ITEM_COUNT, "%s x%s");
        add(KeepersCrockBlock.LANG_MORE, "and %s more...");
        add("medievalism.tooltip.hard_rock.can_knap", "This rock is hard enough to knap");
    }

    private void addAdvancementTranslations()
    {
        // Medievalism
        addAdvancement(BaseAdvancementTranslations.ROOT_TITLE, "Medievalism");
        addAdvancement(BaseAdvancementTranslations.ROOT_DESC, "The heart and story of history");
        addAdvancement(BaseAdvancementTranslations.HINT_JOURNAL_TUTORIAL_TITLE, "Press 'L' for hints to guide you!");
        addAdvancement(BaseAdvancementTranslations.HINT_JOURNAL_TUTORIAL_DESC, "All of your discoveries are recorded in this advancement menu");
        addAdvancement(BaseAdvancementTranslations.HINT_GATHER_TITLE, "Gather resources to get started!");
        addAdvancement(BaseAdvancementTranslations.HINT_GATHER_DESC, "Pick up anything you find, you never know what could be useful");
        addAdvancement(BaseAdvancementTranslations.HINT_SURVIVE_TITLE, "Gotta Survive");
        addAdvancement(BaseAdvancementTranslations.HINT_SURVIVE_DESC, "Be sure to craft useful tools and items to help you survive");

        addAdvancement(BaseAdvancementTranslations.FOUND_ROCK_TITLE, "Find Rocks");
        addAdvancement(BaseAdvancementTranslations.FOUND_ROCK_DESC, "If I had more I could begin knapping");
        addAdvancement(BaseAdvancementTranslations.FOUND_LARGE_ROCK_TITLE, "Find Large Rocks");
        addAdvancement(BaseAdvancementTranslations.FOUND_LARGE_ROCK_DESC, "I could get some work done with this");
        addAdvancement(BaseAdvancementTranslations.FOUND_STICK_TITLE, "Find Sticks");
        addAdvancement(BaseAdvancementTranslations.FOUND_STICK_DESC, "A dog's favourite toy");
        addAdvancement(BaseAdvancementTranslations.FOUND_BRANCH_TITLE, "Find Branches");
        addAdvancement(BaseAdvancementTranslations.FOUND_BRANCH_DESC, "Wood this be useful? I should look for more");
        addAdvancement(BaseAdvancementTranslations.FOUND_CLAYBALL_TITLE, "Find Clay");
        addAdvancement(BaseAdvancementTranslations.FOUND_CLAYBALL_DESC, "This has so many uses, I should gather a lot of it");
        addAdvancement(BaseAdvancementTranslations.CRAFT_WET_BRICK_TITLE, "Wet Bricks");
        addAdvancement(BaseAdvancementTranslations.CRAFT_WET_BRICK_DESC, "After I form a ball of clay into a brick, I can let it dry and then fire it");
        addAdvancement(BaseAdvancementTranslations.FOUND_COPPER_ROCK_TITLE, "What's this?");
        addAdvancement(BaseAdvancementTranslations.FOUND_COPPER_ROCK_DESC, "This rock looks different to the others...");

        addAdvancement(BaseAdvancementTranslations.HINT_INHAND_KNAPPING_TITLE, "In-hand Knapping");
        addAdvancement(BaseAdvancementTranslations.HINT_INHAND_KNAPPING_DESC, "Holding right-click with a hard rock in each hand will let me start knapping");
        addAdvancement(BaseAdvancementTranslations.CRAFT_BIFACE_TITLE, "Craft Biface");
        addAdvancement(BaseAdvancementTranslations.CRAFT_BIFACE_DESC, "Knap a rock to get a sharp rock I can start harvesting plants");
        addAdvancement(BaseAdvancementTranslations.CRAFT_LUNATE_TITLE, "Craft Lunate");
        addAdvancement(BaseAdvancementTranslations.CRAFT_LUNATE_DESC, "Knap a biface into a smaller, sharper rock");
        addAdvancement(BaseAdvancementTranslations.CRAFT_STONEBENCH_TITLE, "Craft Stonebench");
        addAdvancement(BaseAdvancementTranslations.CRAFT_STONEBENCH_DESC, "Knap a large rock into a good place to work");

        addAdvancement(BaseAdvancementTranslations.HINT_BETTER_KNAPPING_TITLE, "Better Knapping");
        addAdvancement(BaseAdvancementTranslations.HINT_BETTER_KNAPPING_DESC, "You can use the Stonebench to knapping more detailed items");
        addAdvancement(BaseAdvancementTranslations.HINT_CLAY_FORMING_TITLE, "The beginnings of Pottery");
        addAdvancement(BaseAdvancementTranslations.HINT_CLAY_FORMING_DESC, "You can use the Stonebench to shape clay into items ready to dry");
        addAdvancement(BaseAdvancementTranslations.HINT_WEAVING_TITLE, "Let's start Weaving");
        addAdvancement(BaseAdvancementTranslations.HINT_WEAVING_DESC, "You can use the Stonebench to weave coarse fibers together");

        // Stone Age
        // Copper Age


        // Overhaul
        addAdvancement(BaseAdvancementTranslations.OVERHAUL_TITLE, "Overhauled");
        addAdvancement(BaseAdvancementTranslations.OVERHAUL_DESC, "You can check here to see what has changed");
        addAdvancement(BaseAdvancementTranslations.CANT_PUNCH_LOGS_TITLE, "Bare hands won't work");
        addAdvancement(BaseAdvancementTranslations.CANT_PUNCH_LOGS_DESC, "The forest stands strong against my fists. Perhaps nature demands respect... or an axe");
    }

    // --

    private void addAdvancement(String key, String value)
    {
        add(MedievalismConstants.MOD_ID + "." + key, value);
    }
}
