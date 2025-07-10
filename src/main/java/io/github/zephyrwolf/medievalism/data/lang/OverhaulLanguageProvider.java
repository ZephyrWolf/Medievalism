package io.github.zephyrwolf.medievalism.data.lang;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
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
        //endregion

        //region Ore
        add(Items.COPPER_ORE, "Greywacke Native Copper Ore");
        add(Items.DEEPSLATE_COPPER_ORE, "Gabbro Native Copper Ore");
        add(Items.IRON_ORE, "Greywacke Limonite Ore");
        add(Items.DEEPSLATE_IRON_ORE, "Gabbro Limonite Ore");
        add(Items.GOLD_ORE, "Greywacke Native Gold Ore");
        add(Items.DEEPSLATE_GOLD_ORE, "Gabbro Native Gold Ore");
        add(Blocks.NETHER_GOLD_ORE, "Netherrack Native Gold Ore");
        add(Blocks.NETHER_QUARTZ_ORE, "Netherrack Nether Quartz Ore");
        add(Items.COAL_ORE, "Greywacke Anthracite Ore");
        add(Items.DEEPSLATE_COAL_ORE, "Gabbro Anthracite Ore");
        add(Items.LAPIS_ORE, "Greywacke Lapis Lazuli Ore");
        add(Items.DEEPSLATE_LAPIS_ORE, "Gabbro Lapis Lazuli Ore");
        add(Items.DIAMOND_ORE, "Greywacke Diamond Ore");
        add(Items.DEEPSLATE_DIAMOND_ORE, "Gabbro Diamond Ore");
        add(Items.REDSTONE_ORE, "Greywacke Cinnabar Ore");
        add(Items.DEEPSLATE_REDSTONE_ORE, "Gabbro Cinnabar Ore");
        add(Items.EMERALD_ORE, "Greywacke Emerald Ore");
        add(Items.DEEPSLATE_EMERALD_ORE, "Gabbro Emerald Ore");
        add(BlockRegistration.TIN_ORE.get(), "Greywacke Cassiterite Ore");
        add(BlockRegistration.DEEPSLATE_TIN_ORE.get(), "Gabbro Cassiterite Ore");
        //endregion
    }
}
