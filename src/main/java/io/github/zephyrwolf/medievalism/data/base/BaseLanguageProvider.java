package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
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
        add(Registration.LIMESTONE_ITEM.get(), "Limestone");
        add(Registration.BRANCH_ITEM.get(), "Branch");
        add(Registration.LARGE_ROCK_ITEM.get(), "Large Rock");
        add(Registration.ROCK_ITEM.get(), "Rock");
        add(Registration.LIMESTONE_ROCK_ITEM.get(), "Limestone Rock");
        add(Registration.COPPER_ROCK_ITEM.get(), "Copper Rock"); // -----------
        add(Registration.THATCH_BLOCK_ITEM.get(), "Thatch Block");
        add(Registration.BROKEN_GOAT_HORN.get(), "Broken Goat Horn");

        { // World
            add(Registration.RED_CLAY_BALL.get(), "Red Clay Ball");
            add(Registration.RED_CLAY_BLOCK_ITEM.get(), "Red Clay");
            add(Registration.DOG_BANE.get(), "Dog Bane");
            add(Registration.FLAX.get(), "Flax");
            add(Registration.FLAX_SEEDS.get(), "Flax Seeds");
            add(Registration.FLAX_FIBER.get(), "Flax Fiber");
            // Wild Potato
            // Wild Carrot
            // Wild Beetroot
            // Wild Yam
        }
        { // Farming
            add(Registration.BLUEBERRIES.get(), "Blueberries");
            add(Registration.RASPBERRIES.get(), "Raspberries");
            add(Registration.STRAWBERRIES.get(), "Strawberries");
            add(Registration.BARLEY_SEEDS.get(), "Barley Seeds");
            add(Registration.BARLEY.get(), "Barley");
            add(Registration.OAT_SEEDS.get(), "Oat Seeds");
            add(Registration.OATS.get(), "Oats");
            add(Registration.YAM.get(), "Yam");
            add(Registration.BAKED_YAM.get(), "Baked Yam");
            add(Registration.BAKED_BEETROOT.get(), "Baked Beetroot");
            add(Registration.BAKED_CARROT.get(), "Baked Carrot");
            add(Registration.CRACKED_BARLEY.get(), "Cracked Barley");
            add(Registration.CRACKED_WHEAT.get(), "Cracked Wheat");
            add(Registration.ROLLED_OATS.get(), "Rolled Oats");
            add(Registration.FLOUR.get(), "Flour");
            add(Registration.DOUGH.get(), "Dough");
        }
        { // Knapping
            add(Registration.LUNATE.get(), "Lunate");
            add(Registration.BIFACE.get(), "Biface");
            add(Registration.HAMMERSTONE.get(), "hammerstone");
        }
        { // Pottery
            add(Registration.UNFIRED_BRICK.get(), "Unfired Brick");
            add(Registration.UNFIRED_JUG.get(), "Unfired Jug");
            add(Registration.JUG.get(), "Jug");
            add(Registration.UNFIRED_CRUCIBLE.get(), "Unfired Crucible");
            add(Registration.CRUCIBLE.get(), "Crucible");
        }
        { // Leather Working
            // Hide
            add(Registration.CAMEL_HIDE.get(), "Camel Hide");
            add(Registration.COW_HIDE.get(), "Cow Hide");
            add(Registration.DONKEY_HIDE.get(), "Donkey Hide");
            add(Registration.HOGLIN_HIDE.get(), "Hoglin Hide");
            add(Registration.HORSE_HIDE.get(), "Horse Hide");
            add(Registration.MOOSHROOM_HIDE.get(), "Mooshroom Hide");
            add(Registration.MULE_HIDE.get(), "Mule Hide");
            //add(Registration.RABBIT_HIDE.get(), "Rabbit Hide");
            add(Registration.RAVAGER_HIDE.get(), "Raveger Hide"); // Should this be extra large?
            add(Registration.SHEEP_HIDE.get(), "Sheep Hide");
            add(Registration.FOX_HIDE.get(), "Fox Hide");
            add(Registration.SNOW_FOX_HIDE.get(), "Snow Fox Hide");
            add(Registration.WOLF_HIDE.get(), "Wolf Hide"); // Only one variable
            add(Registration.OCELOT_HIDE.get(), "Ocelot Hide");
            add(Registration.CAT_HIDE.get(), "Cat Hide"); // Only one variable
            add(Registration.BAT_HIDE.get(), "Bat Hide");
            add(Registration.GOAT_HIDE.get(), "Goat Hide");
            add(Registration.LLAMA_HIDE.get(), "Llama Hide");
            add(Registration.PANDA_HIDE.get(), "Panda Hide");
            add(Registration.PIG_HIDE.get(), "Pig Hide");
            add(Registration.POLAR_BEAR_HIDE.get(), "Polar Bear Hide");
            add(Registration.SNIFFER_HIDE.get(), "Sniffer Hide");

            // Leather
            add(Registration.LARGE_LIMED_HIDE.get(), "Large Limed Hide");
            add(Registration.MEDIUM_LIMED_HIDE.get(), "Medium Limed Hide");
            add(Registration.SMALL_LIMED_HIDE.get(), "Small Limed Hide");
            add(Registration.LARGE_RAW_HIDE.get(), "Large Raw Hide");
            add(Registration.MEDIUM_RAW_HIDE.get(), "Medium Raw Hide");
            add(Registration.SMALL_RAW_HIDE.get(), "Small Raw Hide");
            add(Registration.LARGE_WET_LEATHER.get(), "Large Wet Leather");
            add(Registration.MEDIUM_WET_LEATHER.get(), "Medium Wet Leather");
            add(Registration.SMALL_WET_LEATHER.get(), "Small Wet Leather");
            // Large Leather -> minecraft:leather
            add(Registration.MEDIUM_LEATHER.get(), "Medium Leather");
            add(Registration.SMALL_LEATHER.get(), "Small Leather");
        }

        { // Misc
            add(Registration.QUICK_LIME.get(), "Quicklime");
            add(Registration.THATCH.get(), "Thatch");
            add(Registration.CHOPPED_WOOD.get(), "Chopped Wood");
            add(Registration.SLACKED_LIME_BUCKET.get(), "Slacked Lime Bucket");
            add(Registration.TANNIN_BUCKET.get(), "Tannin Bucket");
            add(Registration.DIGGING_STICK.get(), "Digging Stick");
            add(Registration.FIRE_STARTER.get(), "Fire Starter");
        }

        add("creative_tab.medievalism.name", "Medievalism");

        add("medievalism.advancement.root", "Medievalism");
        add("medievalism.advancement.root.desc", "The heart and story of history");
        add("medievalism.advancement.get_red_clay", "Get Red Clay");
        add("medievalism.advancement.get_red_clay.desc", "Obtain red clay");

        add("medievalism.pack.title.overhaul.client_resources", "Medievalism Overhaul - Looks");
        add("medievalism.pack.title.overhaul.server_data", "Medievalism Overhaul - Progression");
        add("medievalism.pack.source.overhaul", "Medievalism Overhaul Source");
    }
}
