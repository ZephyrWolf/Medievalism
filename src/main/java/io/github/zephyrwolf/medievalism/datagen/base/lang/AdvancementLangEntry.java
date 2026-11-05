package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;

public class AdvancementLangEntry implements ILanguageProviderEntry
{
    @Override
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        // Medievalism
        handle.addAdvancement(AdvancementLangKeys.ROOT_STONE_AGE_TITLE, "Stone Age");
        handle.addAdvancement(AdvancementLangKeys.ROOT_STONE_AGE_DESC, "Great things come from humble beginnings");

        // Stone Age
        addAbout(handle); // TODO Reimplement all of your advancements :(
        addSurvive(handle);
        addGather(handle);
        addMudWorks(handle);
        addClayWorks(handle);
        addKnapping(handle);
        addCarving(handle);
        addPlantCutting(handle);
        addWeaving(handle);
        addAxeStripping(handle);

        // Copper Age
    }

    private void addAbout(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_JOURNAL_TUTORIAL_TITLE, "Press 'L' for hints to guide you!");
        handle.addAdvancement(AdvancementLangKeys.HINT_JOURNAL_TUTORIAL_DESC, "All of your discoveries are recorded in this advancement menu");
    }

    private void addGather(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_GATHER_TITLE, "Gather resources to get started!");
        handle.addAdvancement(AdvancementLangKeys.HINT_GATHER_DESC, "Pick up anything you find, you never know what could be useful");
        handle.addAdvancement(AdvancementLangKeys.FOUND_STICK_TITLE, "Find Sticks");
        handle.addAdvancement(AdvancementLangKeys.FOUND_STICK_DESC, "A dog's favourite toy");
        handle.addAdvancement(AdvancementLangKeys.FOUND_BRANCH_TITLE, "Find Branches");
        handle.addAdvancement(AdvancementLangKeys.FOUND_BRANCH_DESC, "Wood this be useful? I should look for more");
        handle.addAdvancement(AdvancementLangKeys.FOUND_CLAY_BALL_TITLE, "Find Clay");
        handle.addAdvancement(AdvancementLangKeys.FOUND_CLAY_BALL_DESC, "This has so many uses, I should gather a lot of it");
        handle.addAdvancement(AdvancementLangKeys.FOUND_ROCK_TITLE, "Find Rocks");
        handle.addAdvancement(AdvancementLangKeys.FOUND_ROCK_DESC, "There are many different rocks with many uses, keeping collecting");
        handle.addAdvancement(AdvancementLangKeys.FOUND_HARD_ROCK_TITLE, "Find Hard Rocks");
        handle.addAdvancement(AdvancementLangKeys.FOUND_HARD_ROCK_DESC, "Some rocks are harder than others and can be used for knapping");
        handle.addAdvancement(AdvancementLangKeys.FOUND_COPPER_ROCK_TITLE, "Find Ore Bearing Rock");
        handle.addAdvancement(AdvancementLangKeys.FOUND_COPPER_ROCK_DESC, "There is special minerals in this rock, we can smelt them out");
        handle.addAdvancement(AdvancementLangKeys.FOUND_DOGBANE_TITLE, "Find Dogbane");
        handle.addAdvancement(AdvancementLangKeys.FOUND_DOGBANE_DESC, "A useful plant, grows on clay bound soil, and can be used for weaving");
        handle.addAdvancement(AdvancementLangKeys.FOUND_MUD_TITLE, "Find Mud");
        handle.addAdvancement(AdvancementLangKeys.FOUND_MUD_DESC, "Simple yet surprisingly useful");
        handle.addAdvancement(AdvancementLangKeys.FOUND_DIRT_TITLE, "Find Dirt");
        handle.addAdvancement(AdvancementLangKeys.FOUND_DIRT_DESC, "Yeah, that wasn't hard was it?");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_DIRT_CHUNK_TITLE, "Craft Dirt Chunks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_DIRT_CHUNK_DESC, "What would your Mother say?");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_MUD_BALL_TITLE, "Craft Mud Ball");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_MUD_BALL_DESC, "Dip the Dirt Chunk into water");
    }

    private void addSurvive(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_SURVIVE_TITLE, "Gotta Survive");
        handle.addAdvancement(AdvancementLangKeys.HINT_SURVIVE_DESC, "Be sure to craft useful tools and items to help you survive");
        handle.addAdvancement(AdvancementLangKeys.HINT_CRAFT_FIRE_STARTER_TITLE, "Fire will be paramount to survive");
        handle.addAdvancement(AdvancementLangKeys.HINT_CRAFT_FIRE_STARTER_DESC, "Craft a couple sticks with a sharp Blade");
        handle.addAdvancement(AdvancementLangKeys.HINT_BUILD_CAMPFIRE_TITLE, "Let there be Fire!");
        handle.addAdvancement(AdvancementLangKeys.HINT_BUILD_CAMPFIRE_DESC, "Place down some Tinder, cover with Twigs, then light it");
        handle.addAdvancement(AdvancementLangKeys.LIGHT_TORCHES_TITLE, "Let there be Light!");
        handle.addAdvancement(AdvancementLangKeys.LIGHT_TORCHES_DESC, "Place a stick in the fire to ignite it");
        handle.addAdvancement(AdvancementLangKeys.COOK_FOOD_ON_CAMPFIRE_TITLE, "Tastes better cooked");
        handle.addAdvancement(AdvancementLangKeys.COOK_FOOD_ON_CAMPFIRE_DESC, "Simple ingredients can be cooked on a campfire");
        handle.addAdvancement(AdvancementLangKeys.COOK_LIME_ON_CAMPFIRE_TITLE, "Not that kind of Lime");
        handle.addAdvancement(AdvancementLangKeys.COOK_LIME_ON_CAMPFIRE_DESC, "Cooking limestone rocks creates Quick Lime");
    }

    private void addMudWorks(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_MUD_WORKS_TITLE, "A Primitive Building Material ");
        handle.addAdvancement(AdvancementLangKeys.HINT_MUD_WORKS_DESC, "From mud, walls and technology began");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_PACKED_MUD_BLOCK_TITLE, "Craft Wet Packed Block");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_PACKED_MUD_BLOCK_DESC, "Adding some thatch helps bind it");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_PACKED_MUD_BLOCK_TITLE, "Dry that Mud");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_PACKED_MUD_BLOCK_DESC, "Let it dry in the sun or near somewhere warm");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_PACKED_MUD_TITLE, "Craft Wet Packed Mud");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_PACKED_MUD_DESC, "Combine thatch and mudball");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_PACKED_MUD_BRICK_TITLE, "Craft Wet Packed Mud Brick");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_PACKED_MUD_BRICK_DESC, "Shape the wet mud into a brick shape");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_PACKED_MUD_BRICK_TITLE, "Dry it out");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_PACKED_MUD_BRICK_DESC, "Direct sun or campfire will help dry it out quicker");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_PACKED_MUD_BRICKS_TITLE, "Craft Packed Mud Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_PACKED_MUD_BRICKS_DESC, "Finally getting some building blocks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_DAUB_TITLE, "Craft Wet Daub");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_DAUB_DESC, "Sticky and gross");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_DAUB_BRICK_TITLE, "Craft Wet Daub Brick");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_DAUB_BRICK_DESC, "Shape it into a log");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_DAUB_BRICK_TITLE, "Dry it outside");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_DAUB_BRICK_DESC, "Try not to get it wet whilst it dries");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_DAUB_BRICKS_TITLE, "Craft Daub Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_DAUB_BRICKS_DESC, "Combine into a sturdier building block than mud alone");
    }

    private void addClayWorks(LanguageEntryProviderHandle handle)
    {
        // Root
        handle.addAdvancement(AdvancementLangKeys.HINT_CLAY_WORKS_TITLE, "A Primitive Building Material ");
        handle.addAdvancement(AdvancementLangKeys.HINT_CLAY_WORKS_DESC, "From mud, walls and technology began");
        handle.addAdvancement(AdvancementLangKeys.ROOT_CLAY_WORKING_TITLE, "Pottery");
        handle.addAdvancement(AdvancementLangKeys.ROOT_CLAY_WORKING_DESC, "Its time to play with clay and make useful items");
        // Inhand
        handle.addAdvancement(AdvancementLangKeys.OBTAIN_WET_CLAY_BALL_TITLE, "Obtain Clay Balls");
        handle.addAdvancement(AdvancementLangKeys.OBTAIN_WET_CLAY_BALL_DESC, "You can find clay in the topsoil or from clay blocks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_CLAY_BRICK_TITLE, "Form Wet Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_CLAY_BRICK_DESC, "You can form a ball of clay into a brick shape");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_CLAY_BRICK_TITLE, "Dry the Bricks");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_CLAY_BRICK_DESC, "You can dry out the bricks next to a fire or under the sun");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_CLAY_DOUBLE_BRICK_TITLE, "Combine Two Clay Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_CLAY_DOUBLE_BRICK_DESC, "Combine two clay bricks into a large brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_CLAY_DOUBLE_BRICK_TITLE, "Dry the Large Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_CLAY_DOUBLE_BRICK_DESC, "You can dry out the large brick next to a fire or under the sun");

        handle.addAdvancement(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BALL_TITLE, "Craft Potters Clay Ball");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BALL_DESC, "Mixing grog with two clay balls will yield more reliable firing");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BRICK_TITLE, "Form Potters Clay Brick");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_POTTERS_CLAY_BRICK_DESC, "You can form a ball of potters clay into a brick shape");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_BRICK_TITLE, "Dry the Potters Clay Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_BRICK_DESC, "You can dry out the brick next to a fire or under the sun");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_POTTERS_CLAY_DOUBLE_BRICK_TITLE, "Combine Two Potters Clay Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_POTTERS_CLAY_DOUBLE_BRICK_DESC, "Combine two potters clay bricks into a large brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_DOUBLE_BRICK_TITLE, "Dry the Large Potters Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_POTTERS_CLAY_DOUBLE_BRICK_DESC, "You can dry out the large brick next to a fire or under the sun");

        handle.addAdvancement(AdvancementLangKeys.OBTAIN_KAOLIN_CLAY_BALL_TITLE, "Craft Kaolin Clay Ball");
        handle.addAdvancement(AdvancementLangKeys.OBTAIN_KAOLIN_CLAY_BALL_DESC, "Mixing grog with two clay balls will yield better resulting in the kiln");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_KAOLIN_CLAY_BRICK_TITLE, "Form Kaolin Clay Brick");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_KAOLIN_CLAY_BRICK_DESC, "You can form a ball of kaolin clay into a brick shape");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_BRICK_TITLE, "Dry the Kaolin Clay Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_BRICK_DESC, "You can dry out the brick next to a fire or under the sun");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_KAOLIN_CLAY_DOUBLE_BRICK_TITLE, "Combine Two Kaolin Clay Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_KAOLIN_CLAY_DOUBLE_BRICK_DESC, "Combine two kaolin clay bricks into a large brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_DOUBLE_BRICK_TITLE, "Dry the Large Kaolin Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_KAOLIN_CLAY_DOUBLE_BRICK_DESC, "You can dry out the large brick next to a fire or under the sun");

        handle.addAdvancement(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BALL_TITLE, "Craft Refractory Clay Ball");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BALL_DESC, "Mixing refractory grog with two kaolin clay balls and sand will yield better a very heat resistant clay");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BRICK_TITLE, "Form Refractory Clay Brick");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_REFRACTORY_CLAY_BRICK_DESC, "You can form a ball of refractory clay into a brick shape");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_BRICK_TITLE, "Dry the Refractory Clay Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_BRICK_DESC, "You can dry out the brick next to a fire or under the sun");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_REFRACTORY_CLAY_DOUBLE_BRICK_TITLE, "Combine Two Refractory Clay Bricks");
        handle.addAdvancement(AdvancementLangKeys.CRAFT_WET_REFRACTORY_CLAY_DOUBLE_BRICK_DESC, "Combine two refractory clay bricks into a large brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_DOUBLE_BRICK_TITLE, "Dry the Large Refractory Brick");
        handle.addAdvancement(AdvancementLangKeys.DRY_WET_REFRACTORY_CLAY_DOUBLE_BRICK_DESC, "You can dry out the large brick next to a fire or under the sun");

        // Stone Bench
        handle.addAdvancement(AdvancementLangKeys.BETTER_POTTERY_TITLE, "Better Pottery");
        handle.addAdvancement(AdvancementLangKeys.BETTER_POTTERY_DESC, "You can use the Stone Bench to shape clay into larger and more delicate items");
    }

    private void addKnapping(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_INHAND_KNAPPING_TITLE, "In-hand Knapping");
        handle.addAdvancement(AdvancementLangKeys.HINT_INHAND_KNAPPING_DESC, "Holding right-click with a hard rock in each hand will let me start knapping");
        // Inhand
        handle.addAdvancement(AdvancementLangKeys.INHAND_KNAP_BIFACE_TITLE, "Craft Biface");
        handle.addAdvancement(AdvancementLangKeys.INHAND_KNAP_BIFACE_DESC, "Knap a rock to get a sharp rock");
        handle.addAdvancement(AdvancementLangKeys.INHAND_KNAP_LUNATE_TITLE, "Craft Lunate");
        handle.addAdvancement(AdvancementLangKeys.INHAND_KNAP_LUNATE_DESC, "Knap a Biface into a smaller, sharper rock");
        handle.addAdvancement(AdvancementLangKeys.INHAND_KNAP_STONE_BENCH_TITLE, "Craft Stone Bench");
        handle.addAdvancement(AdvancementLangKeys.INHAND_KNAP_STONE_BENCH_DESC, "Knap a large rock into a better place to work");
        // Stone Bench
        handle.addAdvancement(AdvancementLangKeys.KNAP_ROCK_KNIFE_BLADE_TITLE, "Craft Rock Knife Blade");
        handle.addAdvancement(AdvancementLangKeys.KNAP_ROCK_KNIFE_BLADE_DESC, "Use the Stone Bench to knap a rock into a shabby knife blade");
        handle.addAdvancement(AdvancementLangKeys.KNAP_FLINT_KNIFE_BLADE_TITLE, "Much Sharper than Stone");
        handle.addAdvancement(AdvancementLangKeys.KNAP_FLINT_KNIFE_BLADE_DESC, "This flint blade will make a much better knife than stone");
        handle.addAdvancement(AdvancementLangKeys.KNAP_ROCK_AXE_HEAD_TITLE, "Craft Rock Axe Head");
        handle.addAdvancement(AdvancementLangKeys.KNAP_ROCK_AXE_HEAD_DESC, "Use the Stone Bench to knap a rock into an rudimentary axe head");
    }

    private void addCarving(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_CARVING_TITLE, "Carving");
        handle.addAdvancement(AdvancementLangKeys.HINT_CARVING_DESC, "Can use your blade to cut and shape materials"); // Stab not slash
        handle.addAdvancement(AdvancementLangKeys.CARVE_BONE_KNIFE_BLADE_TITLE, "This is getting Macabre");
        handle.addAdvancement(AdvancementLangKeys.CARVE_BONE_KNIFE_BLADE_DESC, "This could really hurt"); // Stab not slash
    }

    private void addPlantCutting(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_PLANT_CUTTING_TITLE, "Carving");
        handle.addAdvancement(AdvancementLangKeys.HINT_PLANT_CUTTING_DESC, "Can use your blade to cut and shape materials"); // Stab not slash
        handle.addAdvancement(AdvancementLangKeys.HARVEST_THATCH_TITLE, "Harvesting from Plants");
        handle.addAdvancement(AdvancementLangKeys.HARVEST_THATCH_DESC, "Can use your blade to cut and prepare plants"); // cut and scrap
    }

    private void addWeaving(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_WEAVING_TITLE, "Let's start Weaving");
        handle.addAdvancement(AdvancementLangKeys.HINT_WEAVING_DESC, "You can use the Stone Bench to weave canes together");
    }

    private void addAxeStripping(LanguageEntryProviderHandle handle)
    {
        handle.addAdvancement(AdvancementLangKeys.HINT_AXE_STRIPPING_TITLE, "Stripping Blocks");
        handle.addAdvancement(AdvancementLangKeys.HINT_AXE_STRIPPING_DESC, "You can use axes to strip useful materials off of blocks");
        handle.addAdvancement(AdvancementLangKeys.HINT_STRIPPED_BARK_TITLE, "Bark, Bark, Arf, Bark!");
        handle.addAdvancement(AdvancementLangKeys.HINT_STRIPPED_BARK_DESC, "Strip logs to get bark");
        handle.addAdvancement(AdvancementLangKeys.HAS_WHITE_BARK_TITLE, "Strip White Bark"); // for pitch
        handle.addAdvancement(AdvancementLangKeys.HAS_WHITE_BARK_DESC, "Contains nealy no tannins, but can be used to make pitch");
        handle.addAdvancement(AdvancementLangKeys.HAS_GREY_BARK_TITLE, "Strip Grey Bark"); // for fiber
        handle.addAdvancement(AdvancementLangKeys.HAS_GREY_BARK_DESC, "Contains a small amount of tannins, can harvest the bast fibers");
        handle.addAdvancement(AdvancementLangKeys.HAS_BROWN_BARK_TITLE, "Strip Brown Bark"); // for smoking and brewing and burning
        handle.addAdvancement(AdvancementLangKeys.HAS_BROWN_BARK_DESC, "Easily burns and holds its heat");
        handle.addAdvancement(AdvancementLangKeys.HAS_DARK_BROWN_BARK_TITLE, "Strip Dark Brown Bark"); // for tannins
        handle.addAdvancement(AdvancementLangKeys.HAS_DARK_BROWN_BARK_DESC, "Contains a lot of tannins");
        handle.addAdvancement(AdvancementLangKeys.HAS_BLACK_BARK_TITLE, "Strip Dark Black Bark"); // ??
        handle.addAdvancement(AdvancementLangKeys.HAS_BLACK_BARK_DESC, "...");
    }
}
