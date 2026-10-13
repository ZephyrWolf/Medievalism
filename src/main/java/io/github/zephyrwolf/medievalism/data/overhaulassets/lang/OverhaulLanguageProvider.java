package io.github.zephyrwolf.medievalism.data.overhaulassets.lang;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.data.base.lang.BaseAdvancementTranslations;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class OverhaulLanguageProvider extends LanguageProvider
{
    public OverhaulLanguageProvider(PackOutput output, String locale)
    {
        super(output, MedievalismConstants.MOD_ID, locale);
    }

    @Override
    protected void addTranslations()
    {
        addAdvancementTranslations();
        //region Other
        add(Items.LEATHER, "Large Leather");
        //endregion

        //region Stone
        add(Items.STONE, "Greywacke ");
        add(Items.STONE_BRICKS, "Greywacke Bricks");
        add(Items.STONE_BRICK_SLAB, "Greywacke Brick Slab");
        add(Items.STONE_BRICK_STAIRS, "Greywacke Brick Stairs");
        add(Items.STONE_BRICK_WALL, "Greywacke Brick Wall");
        add(Items.CRACKED_STONE_BRICKS, "Cracked Greywacke Bricks");
        add(Items.CHISELED_STONE_BRICKS, "Chiseled Greywacke Bricks");
        add(Items.MOSSY_STONE_BRICKS, "Mossy Greywacke Bricks");
        add(Items.MOSSY_STONE_BRICK_SLAB, "Mossy Greywacke Slab");
        add(Items.MOSSY_STONE_BRICK_STAIRS, "Mossy Greywacke Stairs");
        add(Items.MOSSY_STONE_BRICK_WALL, "Mossy Greywacke Wall");
        add(Items.COBBLESTONE, "Cobbled Greywacke");
        add(Items.COBBLESTONE_SLAB, "Cobbled Greywacke Slab");
        add(Items.COBBLESTONE_STAIRS, "Cobbled Greywacke Stairs");
        add(Items.COBBLESTONE_WALL, "Cobbled Greywacke Wall");
        add(Items.MOSSY_COBBLESTONE, "Mossy Cobbled Greywacke");
        add(Items.MOSSY_COBBLESTONE_SLAB, "Mossy Cobbled Greywacke Slab");
        add(Items.MOSSY_COBBLESTONE_STAIRS, "Mossy Cobbled Greywacke Stairs");
        add(Items.MOSSY_COBBLESTONE_WALL, "Mossy Cobbled Greywacke Wall");
        add(Items.INFESTED_STONE, "Infested Greywacke");
        add(Items.INFESTED_STONE_BRICKS, "Infested Greywacke Bricks");
        add(Items.INFESTED_CHISELED_STONE_BRICKS, "Infested Chiseled Greywacke Bricks");
        add(Items.INFESTED_CRACKED_STONE_BRICKS, "Infested Cracked Greywacke Bricks");
        add(Items.INFESTED_MOSSY_STONE_BRICKS, "Infested Mossy Greywacke Bricks");
        add(Items.INFESTED_COBBLESTONE, "Infested Cobbled Greywacke");
        add(Items.SMOOTH_STONE, "Smooth Greywacke");
        add(Items.SMOOTH_STONE_SLAB, "Smooth Greywacke Slab");
        add(Items.STONE_STAIRS, "Greywacke Stairs");
        add(Items.STONE_SLAB, "Greywacke Slab");
        add(Items.STONE_PRESSURE_PLATE, "Greywacke Pressure Plate");
        add(Items.STONE_BUTTON, "Greywacke Button");

        // Deepslate
        add(Items.DEEPSLATE, "Gabbro");
        add(Items.COBBLED_DEEPSLATE, "Cobbled Gabbro");
        add(Items.COBBLED_DEEPSLATE_SLAB, "Cobbled Gabbro Slab");
        add(Items.COBBLED_DEEPSLATE_STAIRS, "Cobbled Gabbro Stairs");
        add(Items.COBBLED_DEEPSLATE_WALL, "Cobbled Gabbro Wall");
        add(Items.POLISHED_DEEPSLATE, "Polished Gabbro");
        add(Items.POLISHED_DEEPSLATE_SLAB, "Polished Gabbro Slab");
        add(Items.POLISHED_DEEPSLATE_STAIRS, "Polished Gabbro Stairs");
        add(Items.POLISHED_DEEPSLATE_WALL, "Polished Gabbro Wall");
        add(Items.CHISELED_DEEPSLATE, "Chiseled Gabbro");
        add(Items.DEEPSLATE_BRICKS, "Gabbro Bricks");
        add(Items.DEEPSLATE_BRICK_SLAB, "Gabbro Brick Slab");
        add(Items.DEEPSLATE_BRICK_STAIRS, "Gabbro Brick Stairs");
        add(Items.DEEPSLATE_BRICK_WALL, "Gabbro Brick Wall");
        add(Items.CRACKED_DEEPSLATE_BRICKS, "Cracked Gabbro Bricks");
        add(Items.DEEPSLATE_TILES, "Gabbro Tiles");
        add(Items.DEEPSLATE_TILE_SLAB, "Gabbro Tile Slab");
        add(Items.DEEPSLATE_TILE_STAIRS, "Gabbro Tile Stairs");
        add(Items.DEEPSLATE_TILE_WALL, "Gabbro Tile Wall");
        add(Items.CRACKED_DEEPSLATE_TILES, "Cracked Gabbro Tiles");
        add(Items.INFESTED_DEEPSLATE, "Infested Gabbro");
        add(Items.REINFORCED_DEEPSLATE, "Reinforced Gabbro");

        // Basalt
        add(Items.BASALT, "Columnar Basalt");
        add(Items.POLISHED_BASALT, "Polished Columnar Basalt");

        // Diorite
        add(Items.DIORITE, "Rough Diorite");

        // Granite
        add(Items.GRANITE, "Rough Granite");

        // Tuff
        add(Items.TUFF, "Welded Tuff");
        add(Items.TUFF_BRICK_SLAB, "Welded Tuff Brick Slab");
        add(Items.TUFF_BRICKS, "Welded Tuff Bricks");
        add(Items.TUFF_SLAB, "Welded Tuff Slab");
        add(Items.TUFF_STAIRS, "Welded Tuff Stairs");
        add(Items.TUFF_BRICK_STAIRS, "Welded Tuff Brick Stairs");
        add(Items.TUFF_BRICK_WALL, "Welded Tuff Brick Wall");
        add(Items.TUFF_WALL, "Welded Tuff Wall");
        add(Items.CHISELED_TUFF, "Chiseled Welded Tuff");
        add(Items.POLISHED_TUFF, "Polished Welded Tuff");
        add(Items.CHISELED_TUFF_BRICKS, "Chiseled Welded Tuff Bricks");
        add(Items.POLISHED_TUFF_SLAB, "Polished Welded Tuff Slab");
        add(Items.POLISHED_TUFF_STAIRS, "Polished Welded Tuff Stairs");
        add(Items.POLISHED_TUFF_WALL, "Polished Welded Tuff Wall");

        // Dripstone
        add(Items.DRIPSTONE_BLOCK, "Travertine Block");
        add(Items.POINTED_DRIPSTONE, "Pointed Travertine");
        //endregion

        //region Ore
        add(Items.COPPER_ORE, "Native Copper Ore in Greywacke");
        add(Items.DEEPSLATE_COPPER_ORE, "Native Copper Ore in Gabbro");
        add(Items.IRON_ORE, "Limonite Ore in Greywacke");
        add(Items.DEEPSLATE_IRON_ORE, "Limonite Ore in Gabbro");
        add(Items.GOLD_ORE, "Native Gold Ore in Greywacke");
        add(Items.DEEPSLATE_GOLD_ORE, "Native Gold Ore in Gabbro");
        add(Blocks.NETHER_GOLD_ORE, "Native Gold Ore in Netherrack");
        add(Blocks.NETHER_QUARTZ_ORE, "Nether Quartz Ore Netherrack");
        add(Items.COAL_ORE, "Anthracite Ore in Greywacke");
        add(Items.DEEPSLATE_COAL_ORE, "Anthracite Ore in Gabbro");
        add(Items.LAPIS_ORE, "Lapis Lazuli Ore in Greywacke");
        add(Items.DEEPSLATE_LAPIS_ORE, "Lapis Lazuli Ore in Gabbro");
        add(Items.DIAMOND_ORE, "Diamond Ore in Greywacke");
        add(Items.DEEPSLATE_DIAMOND_ORE, "Diamond Ore in Gabbro");
        add(Items.REDSTONE_ORE, "Redstone Ore in Greywacke");
        add(Items.DEEPSLATE_REDSTONE_ORE, "Redstone Ore in Gabbro");
        add(Items.EMERALD_ORE, "Emerald Ore in Greywacke");
        add(Items.DEEPSLATE_EMERALD_ORE, "Emerald Ore in Gabbro");
        add(BlockRegistration.TIN_ORE_IN_GREYWACKE.get(), "Cassiterite Ore in Greywacke");
        add(BlockRegistration.TIN_ORE_IN_GABBRO.get(), "Cassiterite Ore in Gabbro");
        //endregion
    }

    private void addAdvancementTranslations()
    {
        addAdvancement(BaseAdvancementTranslations.HINT_JOURNAL_TUTORIAL_DESC, "All of your discoveries are recorded in your journal.");
        add("advancements.toast.task", "New Journal Entry");
        add("argument.entity.options.advancements.description", "Players with journal entries");
        add("chat.type.advancement.challenge", "%s has added the challenge %s to their journal");
        add("chat.type.advancement.goal", "%s has added the goal %s to their journal");
        add("chat.type.advancement.task", "%s has added %s to their journal");
        add("demo.help.fullWrapped", "This demo will last 5 in-game days (about 1 hour and 40 minutes of real time). Check your journal for hints! Have fun!");
        add("gamerule.announceAdvancements", "Announce new journal entries");
        add("gui.advancements", "Journal");
        add("key.advancements", "Journal");
        add("telemetry.event.advancement_made.description", "Understanding the context behind receiving an journal entry can help us better understand and improve the progression of the game.");
        add("telemetry.event.advancement_made.title", "New Journal Entry");
    }

    private void addAdvancement(String key, String value)
    {
        add(MedievalismConstants.MOD_ID + "." + key, value);
    }
}
