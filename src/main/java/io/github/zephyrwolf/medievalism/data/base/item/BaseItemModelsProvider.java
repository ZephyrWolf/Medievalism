package io.github.zephyrwolf.medievalism.data.base.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BaseItemModelsProvider extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public BaseItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        {
            blockBasedModel(BlockItemRegistration.BIRCH_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.OAK_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.SPRUCE_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.JUNGLE_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.ACACIA_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.DARK_OAK_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.CHERRY_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.MANGROVE_BRANCH.get(), "");

            // ROCK
            blockBasedModel(BlockItemRegistration.SANDSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.RED_SANDSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SAPROLITE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LATERITE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.GREYWACKE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SILTSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.DOLOSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LIMESTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.IRONSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SHALE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.ARKOSE_ROCK.get(), "1");
            // LARGE ROCK
            blockBasedModel(BlockItemRegistration.LARGE_SANDSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_SAPROLITE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_LATERITE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_GREYWACKE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_SILTSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_DOLOSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_LIMESTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_IRONSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_SHALE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LARGE_ARKOSE_ROCK.get(), "1");
            // COPPER ROCK
            blockBasedModel(BlockItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.CHALK_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SHALE_ROCK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "");

            blockBasedModel(BlockItemRegistration.CLAY_IN_GRASS.get(), "1");
            blockBasedModel(BlockItemRegistration.RED_CLAY_IN_GRASS.get(), "1");
            blockBasedModel(BlockItemRegistration.CLAY_IN_DIRT.get(), "1");
            blockBasedModel(BlockItemRegistration.RED_CLAY_IN_DIRT.get(), "1");
            blockBasedModel(BlockItemRegistration.RED_CLAY_BLOCK.get(), "");

            // Dirts
            blockBasedModel(BlockItemRegistration.SILT.get(), "");

            // STONE
            blockBasedModel(BlockItemRegistration.SOFT_TUFF.get(), "");                 // Ashfall
            blockBasedModel(BlockItemRegistration.IGNIMBRITE.get(), "");
            blockBasedModel(BlockItemRegistration.LAPILLISTONE.get(), "");
            blockBasedModel(BlockItemRegistration.SAPROLITE.get(), "");
            blockBasedModel(BlockItemRegistration.LATERITE.get(), "");
            blockBasedModel(BlockItemRegistration.SILTSTONE.get(), "");                 // Sedimentary
            blockBasedModel(BlockItemRegistration.DOLOSTONE.get(), "");
            blockBasedModel(BlockItemRegistration.LIMESTONE.get(), "");
            blockBasedModel(BlockItemRegistration.CHALK.get(), "");
            blockBasedModel(BlockItemRegistration.IRONSTONE.get(), "");
            blockBasedModel(BlockItemRegistration.SHALE.get(), "");
            blockBasedModel(BlockItemRegistration.ARKOSE.get(), "" );
            blockBasedModel(BlockItemRegistration.MARBLE.get(), "");                    // Metamorphic
            blockBasedModel(BlockItemRegistration.QUARTZITE.get(), "");
            blockBasedModel(BlockItemRegistration.HORNFELS.get(), "");
            blockBasedModel(BlockItemRegistration.SLATE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE.get(), "");            // Igneous Intrusive
            blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE.get(), "");
            blockBasedModel(BlockItemRegistration.RHYOLITE.get(), "");                  // Soft Igneous Intrusive
            blockBasedModel(BlockItemRegistration.DACITE.get(), "");
            blockBasedModel(BlockItemRegistration.NORITE.get(), "");                    // Deep Igneous Intrusive
            blockBasedModel(BlockItemRegistration.PERIDOTITE.get(), "" );
            // INFESTED STONE
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SILTSTONE.get(), BlockItemRegistration.SILTSTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_DOLOSTONE.get(), BlockItemRegistration.DOLOSTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_LIMESTONE.get(), BlockItemRegistration.LIMESTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SHALE.get(), BlockItemRegistration.SHALE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_ARKOSE.get(), BlockItemRegistration.ARKOSE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_MARBLE.get(), BlockItemRegistration.MARBLE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_QUARTZITE.get(), BlockItemRegistration.QUARTZITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_HORNFELS.get(), BlockItemRegistration.HORNFELS.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SLATE.get(), BlockItemRegistration.SLATE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SMOOTH_DIORITE.get(), BlockItemRegistration.SMOOTH_DIORITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_SMOOTH_GRANITE.get(), BlockItemRegistration.SMOOTH_GRANITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_NORITE.get(), BlockItemRegistration.NORITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_PERIDOTITE.get(), BlockItemRegistration.PERIDOTITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_RHYOLITE.get(), BlockItemRegistration.RHYOLITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_DACITE.get(), BlockItemRegistration.DACITE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_ANDESITE.get(), BlockItemRegistration.ANDESITE.get(), "");
            withExistingParent(itemName(BlockItemRegistration.INFESTED_BASALT.get()), ResourceLocation.withDefaultNamespace("block/" + itemName(BlockItemRegistration.BASALT.get())));
            // COPPER ORE
            blockBasedModel(BlockItemRegistration.SAPROLITE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.LATERITE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SILTSTONE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DOLOSTONE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.LIMESTONE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.CHALK_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.IRONSTONE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SHALE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ARKOSE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.MARBLE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.QUARTZITE_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.HORNFELS_COPPER_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SLATE_COPPER_ORE.get(), "");
            // IRON ORE
            blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.NORITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.PERIDOTITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.RHYOLITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DACITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ANDESITE_IRON_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.BASALT_IRON_ORE.get(), "");
            // GOLD ORE
            blockBasedModel(BlockItemRegistration.SILTSTONE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DOLOSTONE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.LIMESTONE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.CHALK_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.IRONSTONE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SHALE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ARKOSE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.MARBLE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.QUARTZITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.HORNFELS_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SLATE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.NORITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.PERIDOTITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.RHYOLITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DACITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ANDESITE_GOLD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.BASALT_GOLD_ORE.get(), "");
            // COAL ORE
            blockBasedModel(BlockItemRegistration.SAPROLITE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.LATERITE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SILTSTONE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DOLOSTONE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.LIMESTONE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.CHALK_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.IRONSTONE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SHALE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ARKOSE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.MARBLE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.QUARTZITE_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.HORNFELS_COAL_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SLATE_COAL_ORE.get(), "");
            // DIAMOND ORE
            blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.NORITE_DIAMOND_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.PERIDOTITE_DIAMOND_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ANDESITE_DIAMOND_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.BASALT_DIAMOND_ORE.get(), "");
            // EMERALD ORE
            blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.NORITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.PERIDOTITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.RHYOLITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DACITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ANDESITE_EMERALD_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.BASALT_EMERALD_ORE.get(), "");
            // LAPIS ORE
            blockBasedModel(BlockItemRegistration.MARBLE_LAPIS_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.QUARTZITE_LAPIS_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.HORNFELS_LAPIS_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SLATE_LAPIS_ORE.get(), "");
            // REDSTONE ORE
            blockBasedModel(BlockItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.NORITE_REDSTONE_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.PERIDOTITE_REDSTONE_ORE.get(), "");

            // COBBLE
            blockBasedModel(BlockItemRegistration.COBBLED_SOFT_TUFF.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_IGNIMBRITE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_LAPILLISTONE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_WELDED_TUFF.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_SANDSTONE.get(), "");         // Regolith
            blockBasedModel(BlockItemRegistration.COBBLED_RED_SANDSTONE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_SAPROLITE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_LATERITE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_SILTSTONE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_DOLOSTONE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_LIMESTONE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_CHALK.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_IRONSTONE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_SHALE.get(), "");
            blockBasedModel(BlockItemRegistration.COBBLED_ARKOSE.get(), "");
            // INFESTED COBBLE
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_SILTSTONE.get(), BlockItemRegistration.COBBLED_SILTSTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_DOLOSTONE.get(), BlockItemRegistration.COBBLED_DOLOSTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_LIMESTONE.get(), BlockItemRegistration.COBBLED_LIMESTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_CHALK.get(), BlockItemRegistration.COBBLED_CHALK.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_IRONSTONE.get(), BlockItemRegistration.COBBLED_IRONSTONE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_SHALE.get(), BlockItemRegistration.COBBLED_SHALE.get(), "");
            mirrorBlockBasedModel(BlockItemRegistration.INFESTED_COBBLED_ARKOSE.get(), BlockItemRegistration.COBBLED_ARKOSE.get(), "");

            blockBasedModel(BlockItemRegistration.LIMESTONE_CHERT_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.CHALK_CHERT_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.BASALT_GEODE_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.ANDESITE_GEODE_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.RHYOLITE_GEODE_ORE.get(), "");
            blockBasedModel(BlockItemRegistration.DACITE_GEODE_ORE.get(), "");

            blockBasedModel(BlockItemRegistration.WET_PACKED_MUD.get(), "");
            blockBasedModel(BlockItemRegistration.WET_DAUB_BLOCK.get(), "");
            blockBasedModel(BlockItemRegistration.DAUB_BLOCK.get(), "");
            blockBasedModel(BlockItemRegistration.DAUB_BRICKS.get(), "");
            blockBasedModel(BlockItemRegistration.CRACKED_DAUB_BLOCK.get(), "");
            blockBasedModel(BlockItemRegistration.CRACKED_DAUB_BRICKS.get(), "");

            blockIconGeneratedModel(BlockItemRegistration.SHRUB.get());
            blockBasedModel(BlockItemRegistration.THATCH_BLOCK.get(), "");
            itemGeneratedModel(BlockItemRegistration.DOGBANE_BLOCK_ITEM.get());
            blockBasedModel(BlockItemRegistration.STONE_BENCH.get(), "");
            blockBasedModel(BlockItemRegistration.CHOPPING_BLOCK.get(), "");

            itemGeneratedModel(ItemRegistration.MUD_BALL.get());
            itemGeneratedModel(ItemRegistration.WET_DAUB.get());
            itemGeneratedModel(BlockItemRegistration.WET_PACKED_MUD_BRICK.get());
            itemGeneratedModel(ItemRegistration.PACKED_MUD_BRICK.get());
            itemGeneratedModel(BlockItemRegistration.WET_DAUB_BRICK.get());
            itemGeneratedModel(ItemRegistration.DAUB_BRICK.get());
            itemGeneratedModel(BlockItemRegistration.WET_CLAY_BRICK.get());
            itemGeneratedModel(BlockItemRegistration.WET_RED_CLAY_BRICK.get());
        }

        blockBasedModel(BlockItemRegistration.WET_GATHERERS_JAR.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_GATHERERS_JAR.get(), "");
        blockBasedModel(BlockItemRegistration.GATHERERS_JAR.get(), "");

        blockBasedModel(BlockItemRegistration.WET_KEEPERS_CROCK.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_KEEPERS_CROCK.get(), "");
        blockBasedModel(BlockItemRegistration.KEEPERS_CROCK.get(), "");

        blockBasedModel(BlockItemRegistration.WET_SETTLERS_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_SETTLERS_POT.get(), "");
        blockBasedModel(BlockItemRegistration.SETTLERS_POT.get(), "");

        blockBasedModel(BlockItemRegistration.WET_CLAY_COOKING_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_CLAY_COOKING_POT.get(), "");
        blockBasedModel(BlockItemRegistration.CLAY_COOKING_POT.get(), "");

        blockBasedModel(BlockItemRegistration.WET_CLAY_CAULDRON.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_CLAY_CAULDRON.get(), "");
        blockBasedModel(BlockItemRegistration.CLAY_CAULDRON.get(), "");

        blockBasedModel(BlockItemRegistration.WET_JUG.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_JUG.get(), "");
        blockBasedModel(BlockItemRegistration.JUG.get(), "");

        blockBasedModel(BlockItemRegistration.WET_FLOWER_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_FLOWER_POT.get(), "");

        blockBasedModel(BlockItemRegistration.WET_DECORATED_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_DECORATED_POT.get(), "");

        //withExistingParent(itemName(BlockRegistration.WET_GATHERERS_JAR_ITEM.get()), resourceBlock(blockName(BlockRegistration.DRYING_GATHERERS_JAR) + "_wet"));

        { // World
            itemGeneratedModel(ItemRegistration.DIRT_CHUNK.get());
            itemGeneratedModel(ItemRegistration.RED_CLAY_BALL.get());
            itemGeneratedModel(ItemRegistration.RAW_TIN.get());
            blockBasedModel(BlockItemRegistration.TIN_ORE_IN_GREYWACKE.get(), "");
            blockBasedModel(BlockItemRegistration.TIN_ORE_IN_GABBRO.get(), "");
            itemGeneratedModel(ItemRegistration.FLAX.get());
            itemGeneratedModel(ItemRegistration.FLAX_SEEDS.get());
            itemGeneratedModel(ItemRegistration.FLAX_FIBER.get());

            // Wild Potato
            // Wild Carrot
            // Wild Beetroot
            // Wild Yam
            // Branch
            // Rocks
        }
        { // Primitive
            itemGeneratedModel(BlockItemRegistration.THATCH.get());
        }
        { // Farming

            itemGeneratedModel(ItemRegistration.BLUEBERRIES.get());
            itemGeneratedModel(ItemRegistration.RASPBERRIES.get());
            itemGeneratedModel(ItemRegistration.STRAWBERRIES.get());
            itemGeneratedModel(ItemRegistration.BARLEY_SEEDS.get());
            itemGeneratedModel(ItemRegistration.BARLEY.get());
            itemGeneratedModel(ItemRegistration.OAT_SEEDS.get());
            itemGeneratedModel(ItemRegistration.OATS.get());
            itemGeneratedModel(ItemRegistration.YAM.get());
            itemGeneratedModel(ItemRegistration.BAKED_YAM.get());
            itemGeneratedModel(ItemRegistration.BAKED_BEETROOT.get());
            itemGeneratedModel(ItemRegistration.BAKED_CARROT.get());
            itemGeneratedModel(ItemRegistration.CRACKED_BARLEY.get());
            itemGeneratedModel(ItemRegistration.CRACKED_WHEAT.get());
            itemGeneratedModel(ItemRegistration.ROLLED_OATS.get());
            itemGeneratedModel(ItemRegistration.FLOUR.get());
            itemGeneratedModel(ItemRegistration.DOUGH.get());
        }
        { // Knapping
            itemGeneratedModel(ItemRegistration.HAMMERSTONE.asItem());
            itemGeneratedModel(ItemRegistration.LUNATE.get());
            itemGeneratedModel(ItemRegistration.BIFACE.get());
        }
        { // Pottery
            itemGeneratedModel(ItemRegistration.UNFIRED_BRICK.get());
            //itemGeneratedModel(ItemRegistration.UNFIRED_BIRCH_POT.get());
        }
        itemGeneratedModel(ItemRegistration.BROKEN_GOAT_HORN.get());
        { // Bark
            itemGeneratedModel(ItemRegistration.WHITE_BARK.get());
            itemGeneratedModel(ItemRegistration.BROWN_BARK.get());
            itemGeneratedModel(ItemRegistration.GREY_BARK.get());
            itemGeneratedModel(ItemRegistration.DARK_BROWN_BARK.get());
            itemGeneratedModel(ItemRegistration.BLACK_BARK.get());
        }
        { // Leather Working
            // Hide
            itemGeneratedModel(ItemRegistration.COW_HIDE.get());
            itemGeneratedModel(ItemRegistration.CAMEL_HIDE.get());
            itemGeneratedModel(ItemRegistration.DONKEY_HIDE.get());
            itemGeneratedModel(ItemRegistration.HOGLIN_HIDE.get());
            itemGeneratedModel(ItemRegistration.HORSE_HIDE.get());
            itemGeneratedModel(ItemRegistration.MOOSHROOM_HIDE.get());
            itemGeneratedModel(ItemRegistration.MULE_HIDE.get());
            // Rabbit Hide -> minecraft:rabbit_hide
            itemGeneratedModel(ItemRegistration.RAVAGER_HIDE.get()); // Should this be extra large?
            itemGeneratedModel(ItemRegistration.SHEEP_HIDE.get());
            itemGeneratedModel(ItemRegistration.FOX_HIDE.get());
            itemGeneratedModel(ItemRegistration.SNOW_FOX_HIDE.get()); // Unobtainable
            itemGeneratedModel(ItemRegistration.WOLF_HIDE.get()); // Only one variable
            itemGeneratedModel(ItemRegistration.OCELOT_HIDE.get());
            itemGeneratedModel(ItemRegistration.CAT_HIDE.get()); // Only one variable
            itemGeneratedModel(ItemRegistration.BAT_HIDE.get());
            itemGeneratedModel(ItemRegistration.CAT_HIDE.get()); // Only one variable
            itemGeneratedModel(ItemRegistration.GOAT_HIDE.get());
            itemGeneratedModel(ItemRegistration.LLAMA_HIDE.get());
            itemGeneratedModel(ItemRegistration.PANDA_HIDE.get());
            itemGeneratedModel(ItemRegistration.PIG_HIDE.get());
            itemGeneratedModel(ItemRegistration.POLAR_BEAR_HIDE.get());
            itemGeneratedModel(ItemRegistration.SNIFFER_HIDE.get());

            // Leather
            itemGeneratedModel(ItemRegistration.LARGE_LIMED_HIDE.get());
            itemGeneratedModel(ItemRegistration.MEDIUM_LIMED_HIDE.get());
            itemGeneratedModel(ItemRegistration.SMALL_LIMED_HIDE.get());
            itemGeneratedModel(ItemRegistration.LARGE_RAW_HIDE.get());
            itemGeneratedModel(ItemRegistration.MEDIUM_RAW_HIDE.get());
            itemGeneratedModel(ItemRegistration.SMALL_RAW_HIDE.get());
            itemGeneratedModel(ItemRegistration.LARGE_WET_LEATHER.get());
            itemGeneratedModel(ItemRegistration.MEDIUM_WET_LEATHER.get());
            itemGeneratedModel(ItemRegistration.SMALL_WET_LEATHER.get());
            // Large Leather -> minecraft:leather
            itemGeneratedModel(ItemRegistration.MEDIUM_LEATHER.get());
            itemGeneratedModel(ItemRegistration.SMALL_LEATHER.get());
        }
        { // Metallurgy
            itemGeneratedModel(ItemRegistration.CHARCOAL_POWDER.get());
            itemGeneratedModel(ItemRegistration.FIRECLAY.get());
            itemGeneratedModel(ItemRegistration.POTASH.get());
            itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.CLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_FIRECLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.FIRECLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.REFRACTORY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.COPPER_ORE_DUST.get());
            itemGeneratedModel(ItemRegistration.TIN_ORE_DUST.get());
            itemGeneratedModel(ItemRegistration.IRON_ORE_DUST.get());
        }
        { // Misc
            itemGeneratedModel(ItemRegistration.QUICK_LIME.get());
            itemGeneratedModel(ItemRegistration.CHOPPED_WOOD.get());
            itemGeneratedModel(ItemRegistration.SLACKED_LIME_BUCKET.get());
            itemGeneratedModel(ItemRegistration.TANNIN_BUCKET.get());
            itemGeneratedModel(ItemRegistration.DIGGING_STICK.get());
            itemGeneratedModel(ItemRegistration.FIRE_STARTER.get());
            itemGeneratedModel(ItemRegistration.WOOD_ASH.get());
        }
    }

    private String itemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public void blockBasedModel(Item item, String suffix) {
        withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
    }

    public void mirrorBlockBasedModel(Item item, Item block, String suffix)
    {
        withExistingParent(itemName(item), resourceBlock(itemName(block) + suffix));
    }

    public void blockIconGeneratedModel(Item item) {
        blockIconGeneratedModel(item, resourceBlock(itemName(item)));
    }

    public void blockIconGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    @SuppressWarnings("unused")
    public void itemHandheldModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), HANDHELD).texture("layer0", texture);
    }

    public void itemGeneratedModel(Item item) {
        itemGeneratedModel(item, resourceItem(itemName(item)));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "item/" + path);
    }
}
