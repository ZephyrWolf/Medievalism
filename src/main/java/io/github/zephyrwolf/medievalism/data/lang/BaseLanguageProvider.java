package io.github.zephyrwolf.medievalism.data.lang;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.KeepersCrockBlock;
import io.github.zephyrwolf.medievalism.common.block.SettlersPotBlock;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class BaseLanguageProvider extends LanguageProvider {
    public BaseLanguageProvider(PackOutput output, String locale) {
        super(output, MedievalismConstants.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ItemRegistration.LIMESTONE_ITEM.get(), "Limestone");
        add(ItemRegistration.OAK_BRANCH_ITEM.get(), "Oak Branch");
        add(ItemRegistration.BIRCH_BRANCH_ITEM.get(), "Birch Branch");
        add(ItemRegistration.SPRUCE_BRANCH_ITEM.get(), "Spruce Branch");
        add(ItemRegistration.JUNGLE_BRANCH_ITEM.get(), "Jungle Branch");
        add(ItemRegistration.DARK_OAK_BRANCH_ITEM.get(), "Dark Oak Branch");
        add(ItemRegistration.ACACIA_BRANCH_ITEM.get(), "Acacia Branch");
        add(ItemRegistration.MANGROVE_BRANCH_ITEM.get(), "Mangrove Branch");
        add(ItemRegistration.CHERRY_BRANCH_ITEM.get(), "Cherry Branch");

        add(ItemRegistration.ROCK_ITEM.get(), "Rock");
        add(ItemRegistration.SANDSTONE_ROCK_ITEM.get(), "Sandstone Rock");
        add(ItemRegistration.RED_SANDSTONE_ROCK_ITEM.get(), "Red Sandstone Rock");
        add(ItemRegistration.MOSSY_ROCK_ITEM.get(), "Mossy Rock");
        add(ItemRegistration.LIGHTER_ROCK_ITEM.get(), "Lighter Rock");
        add(ItemRegistration.SNOWY_ROCK_ITEM.get(), "Snowy Rock");
        add(ItemRegistration.ICE_ROCK_ITEM.get(), "Ice Rock");

        add(ItemRegistration.LARGE_ROCK_ITEM.get(), "Large Rock");
        add(ItemRegistration.SANDSTONE_LARGE_ROCK_ITEM.get(), "Sandstone Large Rock");
        add(ItemRegistration.RED_SANDSTONE_LARGE_ROCK_ITEM.get(), "Red Sandstone Large Rock");
        add(ItemRegistration.MOSSY_LARGE_ROCK_ITEM.get(), "Mossy Large Rock");
        add(ItemRegistration.LIGHTER_LARGE_ROCK_ITEM.get(), "Lighter Large Rock");
        add(ItemRegistration.SNOWY_LARGE_ROCK_ITEM.get(), "Snowy Large Rock");
        add(ItemRegistration.ICE_LARGE_ROCK_ITEM.get(), "Ice Large Rock");

        add(ItemRegistration.LIMESTONE_ROCK_ITEM.get(), "Limestone Rock");
        add(ItemRegistration.COPPER_ROCK_ITEM.get(), "Copper Rock");
        add(ItemRegistration.THATCH_BLOCK_ITEM.get(), "Thatch Block");
        add(ItemRegistration.BROKEN_GOAT_HORN.get(), "Broken Goat Horn");
        add(ItemRegistration.DOGBANE_BLOCK_ITEM.get(), "Dogbane");

        add(ItemRegistration.MUD_BALL.get(), "Mud Ball");
        add(ItemRegistration.WET_PACKED_MUD_BRICK_ITEM.get(), "Wet Packed Mud Brick");
        add(ItemRegistration.PACKED_MUD_BRICK.get(), "Packed Mud Brick");

        add(ItemRegistration.WET_GATHERERS_JAR_ITEM.get(), "Wet Gatherer's Jar");
        add(ItemRegistration.DRY_GATHERERS_JAR_ITEM.get(), "Unfired Gatherer's Jar");
        add(BlockRegistration.DRYING_GATHERERS_JAR.get(), "Drying Gatherer's Jar");
        add(ItemRegistration.GATHERERS_JAR_ITEM.get(), "Gatherer's Jar");

        add(ItemRegistration.WET_KEEPERS_CROCK_ITEM.get(), "Wet Keeper's Crock");
        add(ItemRegistration.DRY_KEEPERS_CROCK_ITEM.get(), "Unfired Keeper's Crock");
        add(BlockRegistration.DRYING_KEEPERS_CROCK.get(), "Drying Keeper's Crock");
        add(ItemRegistration.KEEPERS_CROCK_ITEM.get(), "Keeper's Crock");

        add(ItemRegistration.WET_SETTLERS_POT_ITEM.get(), "Wet Settler's Pot");
        add(ItemRegistration.DRY_SETTLERS_POT_ITEM.get(), "Unfired Settler's Pot");
        add(BlockRegistration.DRYING_SETTLERS_POT.get(), "Drying Settler's Pot");
        add(ItemRegistration.SETTLERS_POT_ITEM.get(), "Settler's Pot");

        add(ItemRegistration.WET_CLAY_COOKING_POT_ITEM.get(), "Wet Clay Cooking Pot");
        add(ItemRegistration.DRY_CLAY_COOKING_POT_ITEM.get(), "Unfired Clay Cooking Pot");
        add(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), "Drying Clay Cooking Pot");
        add(ItemRegistration.CLAY_COOKING_POT_ITEM.get(), "Clay Cooking Pot");

        add(ItemRegistration.WET_CLAY_CAULDRON_ITEM.get(), "Wet Clay Cauldron");
        add(ItemRegistration.DRY_CLAY_CAULDRON_ITEM.get(), "Unfired Clay Cauldron");
        add(BlockRegistration.DRYING_CLAY_CAULDRON.get(), "Drying Clay Cauldron");
        add(ItemRegistration.CLAY_CAULDRON_ITEM.get(), "Clay Cauldron");


        { // World
            add(ItemRegistration.RED_CLAY_BALL.get(), "Red Clay Ball");
            add(ItemRegistration.RED_CLAY_BLOCK_ITEM.get(), "Red Clay");
            add(ItemRegistration.RAW_TIN.get(), "Tin Ore");
            add(BlockRegistration.TIN_ORE_BLOCK.get(), "Tin Ore Block");
            add(BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK.get(), "Deepslate Tin Ore Block");
            add(ItemRegistration.FLAX.get(), "Flax");
            add(ItemRegistration.FLAX_SEEDS.get(), "Flax Seeds");
            add(ItemRegistration.FLAX_FIBER.get(), "Flax Fiber");
            // Wild Potato
            // Wild Carrot
            // Wild Beetroot
            // Wild Yam
        }
        { // Farming
            add(ItemRegistration.BLUEBERRIES.get(), "Blueberries");
            add(ItemRegistration.RASPBERRIES.get(), "Raspberries");
            add(ItemRegistration.STRAWBERRIES.get(), "Strawberries");
            add(ItemRegistration.BARLEY_SEEDS.get(), "Barley Seeds");
            add(ItemRegistration.BARLEY.get(), "Barley");
            add(ItemRegistration.OAT_SEEDS.get(), "Oat Seeds");
            add(ItemRegistration.OATS.get(), "Oats");
            add(BlockRegistration.YAMS.get(), "Yams");
            add(ItemRegistration.YAM.get(), "Yam");
            add(ItemRegistration.BAKED_YAM.get(), "Baked Yam");
            add(ItemRegistration.BAKED_BEETROOT.get(), "Baked Beetroot");
            add(ItemRegistration.BAKED_CARROT.get(), "Baked Carrot");
            add(ItemRegistration.CRACKED_BARLEY.get(), "Cracked Barley");
            add(ItemRegistration.CRACKED_WHEAT.get(), "Cracked Wheat");
            add(ItemRegistration.ROLLED_OATS.get(), "Rolled Oats");
            add(ItemRegistration.FLOUR.get(), "Flour");
            add(ItemRegistration.DOUGH.get(), "Dough");
        }
        { // Knapping
            add(ItemRegistration.LUNATE.get(), "Lunate");
            add(ItemRegistration.BIFACE.get(), "Biface");
            add(ItemRegistration.HAMMERSTONE.get(), "hammerstone");
        }
        { // Pottery
            add(ItemRegistration.UNFIRED_BRICK.get(), "Unfired Brick");
            add(ItemRegistration.JUG.get(), "Jug");
        }
        { // Bark
            add(ItemRegistration.WHITE_BARK.get(), "White Bark");
            add(ItemRegistration.BROWN_BARK.get(), "Brown Bark");
            add(ItemRegistration.GREY_BARK.get(), "Grey Bark");
            add(ItemRegistration.DARK_BROWN_BARK.get(), "Dark Brown Bark");
            add(ItemRegistration.BLACK_BARK.get(), "Black Bark");
        }
        { // Primitive
            add(ItemRegistration.STONE_BENCH_ITEM.get(), "Stone Bench");
            add(ItemRegistration.CHOPPING_BLOCK_ITEM.get(), "Chopping Block");
        }
        { // Leather Working
            // Hide
            add(ItemRegistration.CAMEL_HIDE.get(), "Camel Hide");
            add(ItemRegistration.COW_HIDE.get(), "Cow Hide");
            add(ItemRegistration.DONKEY_HIDE.get(), "Donkey Hide");
            add(ItemRegistration.HOGLIN_HIDE.get(), "Hoglin Hide");
            add(ItemRegistration.HORSE_HIDE.get(), "Horse Hide");
            add(ItemRegistration.MOOSHROOM_HIDE.get(), "Mooshroom Hide");
            add(ItemRegistration.MULE_HIDE.get(), "Mule Hide");
            // Rabbit Hide -> minecraft:rabbit_hide
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

            // Leather
            add(ItemRegistration.LARGE_LIMED_HIDE.get(), "Large Limed Hide");
            add(ItemRegistration.MEDIUM_LIMED_HIDE.get(), "Medium Limed Hide");
            add(ItemRegistration.SMALL_LIMED_HIDE.get(), "Small Limed Hide");
            add(ItemRegistration.LARGE_RAW_HIDE.get(), "Large Raw Hide");
            add(ItemRegistration.MEDIUM_RAW_HIDE.get(), "Medium Raw Hide");
            add(ItemRegistration.SMALL_RAW_HIDE.get(), "Small Raw Hide");
            add(ItemRegistration.LARGE_WET_LEATHER.get(), "Large Wet Leather");
            add(ItemRegistration.MEDIUM_WET_LEATHER.get(), "Medium Wet Leather");
            add(ItemRegistration.SMALL_WET_LEATHER.get(), "Small Wet Leather");
            // Large Leather -> minecraft:leather
            add(ItemRegistration.MEDIUM_LEATHER.get(), "Medium Leather");
            add(ItemRegistration.SMALL_LEATHER.get(), "Small Leather");
        }
        { // Metallurgy
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
        }
        { // Misc
            add(ItemRegistration.QUICK_LIME.get(), "Quicklime");
            add(ItemRegistration.THATCH.get(), "Thatch");
            add(ItemRegistration.CHOPPED_WOOD.get(), "Chopped Wood");
            add(ItemRegistration.SLACKED_LIME_BUCKET.get(), "Slacked Lime Bucket");
            add(ItemRegistration.TANNIN_BUCKET.get(), "Tannin Bucket");
            add(ItemRegistration.DIGGING_STICK.get(), "Digging Stick");
            add(ItemRegistration.FIRE_STARTER.get(), "Fire Starter");
            add(ItemRegistration.WOOD_ASH.get(), "Wood Ash");
        }

        add("creative_tab.medievalism.name", "Medievalism");

        add(GatherersJarBlock.LANG_DEFAULT_NAME, "Gatherer's Jar");
        add(GatherersJarBlock.LANG_ITEM_COUNT, "%s x%s");
        add(GatherersJarBlock.LANG_MORE, "and %s more...");

        add(KeepersCrockBlock.LANG_DEFAULT_NAME, "Keeper's Crock");
        add(KeepersCrockBlock.LANG_ITEM_COUNT, "%s x%s");
        add(KeepersCrockBlock.LANG_MORE, "and %s more...");

        add(SettlersPotBlock.LANG_DEFAULT_NAME, "Settler's Pot");

        add("medievalism.advancement.root", "Medievalism");
        add("medievalism.advancement.root.desc", "The heart and story of history");
        add("medievalism.advancement.get_red_clay", "Get Red Clay");
        add("medievalism.advancement.get_red_clay.desc", "Obtain red clay");

        add("medievalism.pack.title.overhaul.client_resources", "Medievalism Overhaul - Looks");
        add("medievalism.pack.title.overhaul.server_data", "Medievalism Overhaul - Progression");
        add("medievalism.pack.source.overhaul", "Medievalism Overhaul Source");
        add("medievalism.networking.failed", "Medievalism crashed you :(");
    }
}
