package io.github.zephyrwolf.medievalism.data.lang;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import net.minecraft.data.PackOutput;
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
        add(BlockRegistration.LIMESTONE_ITEM.get(), "Limestone");
        add(BlockRegistration.OAK_BRANCH_ITEM.get(), "Oak Branch");
        add(BlockRegistration.BIRCH_BRANCH_ITEM.get(), "Birch Branch");
        add(BlockRegistration.SPRUCE_BRANCH_ITEM.get(), "Spruce Branch");
        add(BlockRegistration.JUNGLE_BRANCH_ITEM.get(), "Jungle Branch");
        add(BlockRegistration.DARK_OAK_BRANCH_ITEM.get(), "Dark Oak Branch");
        add(BlockRegistration.ACACIA_BRANCH_ITEM.get(), "Acacia Branch");
        add(BlockRegistration.MANGROVE_BRANCH_ITEM.get(), "Mangrove Branch");
        add(BlockRegistration.CHERRY_BRANCH_ITEM.get(), "Cherry Branch");
        add(BlockRegistration.LARGE_ROCK_ITEM.get(), "Large Rock");
        add(BlockRegistration.ROCK_ITEM.get(), "Rock");
        add(BlockRegistration.LIMESTONE_ROCK_ITEM.get(), "Limestone Rock");
        add(BlockRegistration.COPPER_ROCK_ITEM.get(), "Copper Rock");
        add(BlockRegistration.THATCH_BLOCK_ITEM.get(), "Thatch Block");
        add(ItemRegistration.BROKEN_GOAT_HORN.get(), "Broken Goat Horn");
        add(BlockRegistration.DOGBANE_BLOCK_ITEM.get(), "Dogbane");

        { // World
            add(ItemRegistration.RED_CLAY_BALL.get(), "Red Clay Ball");
            add(BlockRegistration.RED_CLAY_BLOCK_ITEM.get(), "Red Clay");
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
            add(ItemRegistration.UNFIRED_JUG.get(), "Unfired Jug");
            add(ItemRegistration.JUG.get(), "Jug");
            add(ItemRegistration.UNFIRED_FLOWER_POT.get(), "Unfired Flower Pot");
            add(ItemRegistration.UNFIRED_BIRCH_POT.get(), "Unfired Birch Pot");
            add(ItemRegistration.UNFIRED_POT.get(), "Unfired Pot");
            add(ItemRegistration.POT.get(), "Pot");
            add(ItemRegistration.UNFIRED_LARGE_POT.get(), "Unfired Large Pot");
            add(ItemRegistration.LARGE_POT.get(), "Large Pot");
        }
        { // Bark
            add(ItemRegistration.WHITE_BARK.get(), "White Bark");
            add(ItemRegistration.BROWN_BARK.get(), "Brown Bark");
            add(ItemRegistration.GREY_BARK.get(), "Grey Bark");
            add(ItemRegistration.DARK_BROWN_BARK.get(), "Dark Brown Bark");
            add(ItemRegistration.BLACK_BARK.get(), "Black Bark");
        }
        { // Primitive
            add(BlockRegistration.STONE_BENCH_ITEM.get(), "Stone Bench");
            add(BlockRegistration.CHOPPING_BLOCK_ITEM.get(), "Chopping Block");
            add(BlockRegistration.BIRCH_POT_ITEM.get(), "Birch Pot");
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
