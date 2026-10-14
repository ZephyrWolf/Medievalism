package io.github.zephyrwolf.medievalism.registration.blockitem;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.VanillaDeferredItem;
import io.github.zephyrwolf.medievalism.common.blockitem.ContainerItemBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.DryingBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.DryingBrickBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.GatherersJarBlockItem;
import io.github.zephyrwolf.medievalism.common.blockitem.RockBlockItem;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class BlockItemRegistration
{
    public static final DeferredRegister.Items BLOCKITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus) {
        BLOCKITEMS.register(modEventBus);
    }
    public static <I extends Item> DeferredItem<I> registerBlockItem(String name,
                 BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    public static <I extends Item> DeferredItem<I> registerBlockItem(String name,
                 BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return BLOCKITEMS.register(name, key -> func.apply(block.get(), props)); }

    // --

    //region World
    public static final DeferredItem<BlockItem> CLAY_IN_GRASS =                     BLOCKITEMS.registerSimpleBlockItem("clay_in_grass",                 BlockRegistration.CLAY_IN_GRASS);
    public static final DeferredItem<BlockItem> RED_CLAY_IN_GRASS =                 BLOCKITEMS.registerSimpleBlockItem("red_clay_in_grass",             BlockRegistration.RED_CLAY_IN_GRASS);
    public static final DeferredItem<BlockItem> CLAY_IN_DIRT =                      BLOCKITEMS.registerSimpleBlockItem("clay_in_dirt",                  BlockRegistration.CLAY_IN_DIRT);
    public static final DeferredItem<BlockItem> RED_CLAY_IN_DIRT =                  BLOCKITEMS.registerSimpleBlockItem("red_clay_in_dirt",              BlockRegistration.RED_CLAY_IN_DIRT);
    public static final DeferredItem<BlockItem> RED_CLAY_BLOCK =                    BLOCKITEMS.registerSimpleBlockItem("red_clay",                      BlockRegistration.RED_CLAY);

    public static final DeferredItem<BlockItem> GRAVEL =                            new VanillaDeferredItem<>((BlockItem) Items.GRAVEL);
    public static final DeferredItem<BlockItem> SILT =                              BLOCKITEMS.registerSimpleBlockItem("silt",                          BlockRegistration.SILT);

    // STONE
    public static final DeferredItem<BlockItem> SOFT_TUFF =                         BLOCKITEMS.registerSimpleBlockItem("soft_tuff",                     BlockRegistration.SOFT_TUFF);
    public static final DeferredItem<BlockItem> IGNIMBRITE =                        BLOCKITEMS.registerSimpleBlockItem("ignimbrite",                    BlockRegistration.IGNIMBRITE);
    public static final DeferredItem<BlockItem> LAPILLISTONE =                      BLOCKITEMS.registerSimpleBlockItem("lapillistone",                  BlockRegistration.LAPILLISTONE);
    public static final DeferredItem<BlockItem> WELDED_TUFF =                       new VanillaDeferredItem<>((BlockItem) Items.TUFF);
    public static final DeferredItem<BlockItem> COBBLED_SANDSTONE =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_sandstone",             BlockRegistration.COBBLED_SANDSTONE);
    public static final DeferredItem<BlockItem> SAPROLITE =                         BLOCKITEMS.registerSimpleBlockItem("saprolite",                     BlockRegistration.SAPROLITE);
    public static final DeferredItem<BlockItem> LATERITE =                          BLOCKITEMS.registerSimpleBlockItem("laterite",                      BlockRegistration.LATERITE);
    public static final DeferredItem<BlockItem> GREYWACKE =                         new VanillaDeferredItem<>(Items.STONE);
    public static final DeferredItem<BlockItem> SILTSTONE =                         BLOCKITEMS.registerSimpleBlockItem("siltstone",                     BlockRegistration.SILTSTONE);
    public static final DeferredItem<BlockItem> DOLOSTONE =                         BLOCKITEMS.registerSimpleBlockItem("dolostone",                     BlockRegistration.DOLOSTONE);
    public static final DeferredItem<BlockItem> LIMESTONE =                         BLOCKITEMS.registerSimpleBlockItem("limestone",                     BlockRegistration.LIMESTONE);
    public static final DeferredItem<BlockItem> CHALK =                             BLOCKITEMS.registerSimpleBlockItem("chalk",                         BlockRegistration.CHALK);
    public static final DeferredItem<BlockItem> IRONSTONE =                         BLOCKITEMS.registerSimpleBlockItem("ironstone",                     BlockRegistration.IRONSTONE);
    public static final DeferredItem<BlockItem> SHALE =                             BLOCKITEMS.registerSimpleBlockItem("shale",                         BlockRegistration.SHALE);
    public static final DeferredItem<BlockItem> ARKOSE =                            BLOCKITEMS.registerSimpleBlockItem("arkose",                        BlockRegistration.ARKOSE);
    public static final DeferredItem<BlockItem> RHYOLITE =                          BLOCKITEMS.registerSimpleBlockItem("rhyolite",                      BlockRegistration.RHYOLITE);
    public static final DeferredItem<BlockItem> DACITE =                            BLOCKITEMS.registerSimpleBlockItem("dacite",                        BlockRegistration.DACITE);
    public static final DeferredItem<BlockItem> MARBLE =                            BLOCKITEMS.registerSimpleBlockItem("marble",                        BlockRegistration.MARBLE);
    public static final DeferredItem<BlockItem> QUARTZITE =                         BLOCKITEMS.registerSimpleBlockItem("quartzite",                     BlockRegistration.QUARTZITE);
    public static final DeferredItem<BlockItem> HORNFELS =                          BLOCKITEMS.registerSimpleBlockItem("hornfels",                      BlockRegistration.HORNFELS);
    public static final DeferredItem<BlockItem> SLATE =                             BLOCKITEMS.registerSimpleBlockItem("slate",                         BlockRegistration.SLATE);
    public static final DeferredItem<BlockItem> NORITE =                            BLOCKITEMS.registerSimpleBlockItem("norite",                        BlockRegistration.NORITE);
    public static final DeferredItem<BlockItem> PERIDOTITE =                        BLOCKITEMS.registerSimpleBlockItem("peridotite",                    BlockRegistration.PERIDOTITE);
    public static final DeferredItem<BlockItem> GABBRO =                            new VanillaDeferredItem<>(Items.DEEPSLATE);
    public static final DeferredItem<BlockItem> COBBLED_GABBRO =                    new VanillaDeferredItem<>(Items.COBBLED_DEEPSLATE);
    public static final DeferredItem<BlockItem> ROUGH_DIORITE =                     new VanillaDeferredItem<>(Items.DIORITE);
    public static final DeferredItem<BlockItem> ROUGH_GRANITE =                     new VanillaDeferredItem<>(Items.GRANITE);
    public static final DeferredItem<BlockItem> SMOOTH_DIORITE =                    BLOCKITEMS.registerSimpleBlockItem("smooth_diorite",                BlockRegistration.SMOOTH_DIORITE);
    public static final DeferredItem<BlockItem> SMOOTH_GRANITE =                    BLOCKITEMS.registerSimpleBlockItem("smooth_granite",                BlockRegistration.SMOOTH_GRANITE);
    public static final DeferredItem<BlockItem> ANDESITE =                          new VanillaDeferredItem<>(Items.ANDESITE);
    public static final DeferredItem<BlockItem> BASALT =                            new VanillaDeferredItem<>(Items.BASALT);
    public static final DeferredItem<BlockItem> TRAVERTINE =                        new VanillaDeferredItem<>(Items.DRIPSTONE_BLOCK);
    // COBBLED
    public static final DeferredItem<BlockItem> COBBLED_SOFT_TUFF =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_soft_tuff",             BlockRegistration.COBBLED_SOFT_TUFF);
    public static final DeferredItem<BlockItem> COBBLED_IGNIMBRITE =                BLOCKITEMS.registerSimpleBlockItem("cobbled_ignimbrite",            BlockRegistration.COBBLED_IGNIMBRITE);
    public static final DeferredItem<BlockItem> COBBLED_LAPILLISTONE =              BLOCKITEMS.registerSimpleBlockItem("cobbled_lapillistone",          BlockRegistration.COBBLED_LAPILLISTONE);
    public static final DeferredItem<BlockItem> COBBLED_WELDED_TUFF =               BLOCKITEMS.registerSimpleBlockItem("cobbled_welded_tuff",           BlockRegistration.COBBLED_WELDED_TUFF);
    public static final DeferredItem<BlockItem> COBBLED_RED_SANDSTONE =             BLOCKITEMS.registerSimpleBlockItem("cobbled_red_sandstone",         BlockRegistration.COBBLED_RED_SANDSTONE);
    public static final DeferredItem<BlockItem> COBBLED_SAPROLITE =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_saprolite",             BlockRegistration.COBBLED_SAPROLITE);
    public static final DeferredItem<BlockItem> COBBLED_LATERITE =                  BLOCKITEMS.registerSimpleBlockItem("cobbled_laterite",              BlockRegistration.COBBLED_LATERITE);
    public static final DeferredItem<BlockItem> COBBLED_GREYWACKE =                 new VanillaDeferredItem<>(Items.COBBLESTONE);
    public static final DeferredItem<BlockItem> COBBLED_SILTSTONE =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_siltstone",             BlockRegistration.COBBLED_SILTSTONE);
    public static final DeferredItem<BlockItem> COBBLED_DOLOSTONE =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_dolostone",             BlockRegistration.COBBLED_DOLOSTONE);
    public static final DeferredItem<BlockItem> COBBLED_LIMESTONE =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_limestone",             BlockRegistration.COBBLED_LIMESTONE);
    public static final DeferredItem<BlockItem> COBBLED_CHALK =                     BLOCKITEMS.registerSimpleBlockItem("cobbled_chalk",                 BlockRegistration.COBBLED_CHALK);
    public static final DeferredItem<BlockItem> COBBLED_IRONSTONE =                 BLOCKITEMS.registerSimpleBlockItem("cobbled_ironstone",             BlockRegistration.COBBLED_IRONSTONE);
    public static final DeferredItem<BlockItem> COBBLED_SHALE =                     BLOCKITEMS.registerSimpleBlockItem("cobbled_shale",                 BlockRegistration.COBBLED_SHALE);
    public static final DeferredItem<BlockItem> COBBLED_ARKOSE =                    BLOCKITEMS.registerSimpleBlockItem("cobbled_arkose",                BlockRegistration.COBBLED_ARKOSE);
    // INFESTED STONE
    public static final DeferredItem<BlockItem> INFESTED_GREYWACKE =                new VanillaDeferredItem<>(Items.INFESTED_STONE);
    public static final DeferredItem<BlockItem> INFESTED_SILTSTONE =                BLOCKITEMS.registerSimpleBlockItem("infested_siltstone",            BlockRegistration.INFESTED_SILTSTONE);
    public static final DeferredItem<BlockItem> INFESTED_DOLOSTONE =                BLOCKITEMS.registerSimpleBlockItem("infested_dolostone",            BlockRegistration.INFESTED_DOLOSTONE);;
    public static final DeferredItem<BlockItem> INFESTED_LIMESTONE =                BLOCKITEMS.registerSimpleBlockItem("infested_limestone",            BlockRegistration.INFESTED_LIMESTONE);
    public static final DeferredItem<BlockItem> INFESTED_SHALE =                    BLOCKITEMS.registerSimpleBlockItem("infested_shale",                BlockRegistration.INFESTED_SHALE);
    public static final DeferredItem<BlockItem> INFESTED_ARKOSE =                   BLOCKITEMS.registerSimpleBlockItem("infested_arkose",               BlockRegistration.INFESTED_ARKOSE);
    public static final DeferredItem<BlockItem> INFESTED_MARBLE =                   BLOCKITEMS.registerSimpleBlockItem("infested_marble",               BlockRegistration.INFESTED_MARBLE);
    public static final DeferredItem<BlockItem> INFESTED_QUARTZITE =                BLOCKITEMS.registerSimpleBlockItem("infested_quartzite",            BlockRegistration.INFESTED_QUARTZITE);
    public static final DeferredItem<BlockItem> INFESTED_HORNFELS =                 BLOCKITEMS.registerSimpleBlockItem("infested_hornfels",             BlockRegistration.INFESTED_HORNFELS);
    public static final DeferredItem<BlockItem> INFESTED_SLATE =                    BLOCKITEMS.registerSimpleBlockItem("infested_slate",                BlockRegistration.INFESTED_SLATE);
    public static final DeferredItem<BlockItem> INFESTED_GABBRO =                   new VanillaDeferredItem<>(Items.INFESTED_DEEPSLATE);
    public static final DeferredItem<BlockItem> INFESTED_SMOOTH_DIORITE =           BLOCKITEMS.registerSimpleBlockItem("infested_smooth_diorite",       BlockRegistration.INFESTED_SMOOTH_DIORITE);
    public static final DeferredItem<BlockItem> INFESTED_SMOOTH_GRANITE =           BLOCKITEMS.registerSimpleBlockItem("infested_smooth_granite",       BlockRegistration.INFESTED_SMOOTH_GRANITE);
    public static final DeferredItem<BlockItem> INFESTED_NORITE =                   BLOCKITEMS.registerSimpleBlockItem("infested_norite",               BlockRegistration.INFESTED_NORITE);
    public static final DeferredItem<BlockItem> INFESTED_PERIDOTITE =               BLOCKITEMS.registerSimpleBlockItem("infested_peridotite",           BlockRegistration.INFESTED_PERIDOTITE);
    public static final DeferredItem<BlockItem> INFESTED_RHYOLITE =                 BLOCKITEMS.registerSimpleBlockItem("infested_rhyolite",             BlockRegistration.INFESTED_RHYOLITE);
    public static final DeferredItem<BlockItem> INFESTED_DACITE =                   BLOCKITEMS.registerSimpleBlockItem("infested_dacite",               BlockRegistration.INFESTED_DACITE);
    public static final DeferredItem<BlockItem> INFESTED_ANDESITE =                 BLOCKITEMS.registerSimpleBlockItem("infested_andesite",             BlockRegistration.INFESTED_ANDESITE);
    public static final DeferredItem<BlockItem> INFESTED_BASALT =                   BLOCKITEMS.registerSimpleBlockItem("infested_basalt",               BlockRegistration.INFESTED_BASALT);
    // INFESTED COBBLE
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_GREYWACKE =        new VanillaDeferredItem<>(Items.INFESTED_COBBLESTONE);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_SILTSTONE =        BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_siltstone",    BlockRegistration.INFESTED_COBBLED_SILTSTONE);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_DOLOSTONE =        BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_dolostone",    BlockRegistration.INFESTED_COBBLED_DOLOSTONE);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_LIMESTONE =        BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_limestone",    BlockRegistration.INFESTED_COBBLED_LIMESTONE);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_CHALK =            BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_chalk",        BlockRegistration.INFESTED_COBBLED_CHALK);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_IRONSTONE =        BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_ironstone",    BlockRegistration.INFESTED_COBBLED_IRONSTONE);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_SHALE =            BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_shale",        BlockRegistration.INFESTED_COBBLED_SHALE);
    public static final DeferredItem<BlockItem> INFESTED_COBBLED_ARKOSE =           BLOCKITEMS.registerSimpleBlockItem("infested_cobbled_arkose",       BlockRegistration.INFESTED_COBBLED_ARKOSE);
    // COPPER ORE
    public static final DeferredItem<BlockItem> SAPROLITE_COPPER_ORE =              BLOCKITEMS.registerSimpleBlockItem("saprolite_copper_ore",          BlockRegistration.SAPROLITE_COPPER_ORE);
    public static final DeferredItem<BlockItem> GREYWACKE_COPPER_ORE =              new VanillaDeferredItem<>(Items.COPPER_ORE);
    public static final DeferredItem<BlockItem> SILTSTONE_COPPER_ORE =              BLOCKITEMS.registerSimpleBlockItem("siltstone_copper_ore",          BlockRegistration.SILTSTONE_COPPER_ORE);
    public static final DeferredItem<BlockItem> DOLOSTONE_COPPER_ORE =              BLOCKITEMS.registerSimpleBlockItem("dolostone_copper_ore",          BlockRegistration.DOLOSTONE_COPPER_ORE);
    public static final DeferredItem<BlockItem> LIMESTONE_COPPER_ORE =              BLOCKITEMS.registerSimpleBlockItem("limestone_copper_ore",          BlockRegistration.LIMESTONE_COPPER_ORE);
    public static final DeferredItem<BlockItem> CHALK_COPPER_ORE =                  BLOCKITEMS.registerSimpleBlockItem("chalk_copper_ore",              BlockRegistration.CHALK_COPPER_ORE);
    public static final DeferredItem<BlockItem> IRONSTONE_COPPER_ORE =              BLOCKITEMS.registerSimpleBlockItem("ironstone_copper_ore",          BlockRegistration.IRONSTONE_COPPER_ORE);
    public static final DeferredItem<BlockItem> SHALE_COPPER_ORE =                  BLOCKITEMS.registerSimpleBlockItem("shale_copper_ore",              BlockRegistration.SHALE_COPPER_ORE);
    public static final DeferredItem<BlockItem> ARKOSE_COPPER_ORE =                 BLOCKITEMS.registerSimpleBlockItem("arkose_copper_ore",             BlockRegistration.ARKOSE_COPPER_ORE);
    public static final DeferredItem<BlockItem> MARBLE_COPPER_ORE =                 BLOCKITEMS.registerSimpleBlockItem("marble_copper_ore",             BlockRegistration.MARBLE_COPPER_ORE);
    public static final DeferredItem<BlockItem> QUARTZITE_COPPER_ORE =              BLOCKITEMS.registerSimpleBlockItem("quartzite_copper_ore",          BlockRegistration.QUARTZITE_COPPER_ORE);
    public static final DeferredItem<BlockItem> HORNFELS_COPPER_ORE =               BLOCKITEMS.registerSimpleBlockItem("hornfels_copper_ore",           BlockRegistration.HORNFELS_COPPER_ORE);
    public static final DeferredItem<BlockItem> SLATE_COPPER_ORE =                  BLOCKITEMS.registerSimpleBlockItem("slate_copper_ore",              BlockRegistration.SLATE_COPPER_ORE);
    // IRON ORE
    public static final DeferredItem<BlockItem> GABBRO_IRON_ORE =                   new VanillaDeferredItem<>(Items.DEEPSLATE_IRON_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_DIORITE_IRON_ORE =           BLOCKITEMS.registerSimpleBlockItem("smooth_diorite_iron_ore",       BlockRegistration.SMOOTH_DIORITE_IRON_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_GRANITE_IRON_ORE =           BLOCKITEMS.registerSimpleBlockItem("smooth_granite_iron_ore",       BlockRegistration.SMOOTH_GRANITE_IRON_ORE);
    public static final DeferredItem<BlockItem> NORITE_IRON_ORE =                   BLOCKITEMS.registerSimpleBlockItem("norite_iron_ore",               BlockRegistration.NORITE_IRON_ORE);
    public static final DeferredItem<BlockItem> PERIDOTITE_IRON_ORE =               BLOCKITEMS.registerSimpleBlockItem("peridotite_iron_ore",           BlockRegistration.PERIDOTITE_IRON_ORE);
    public static final DeferredItem<BlockItem> RHYOLITE_IRON_ORE =                 BLOCKITEMS.registerSimpleBlockItem("rhyolite_iron_ore",             BlockRegistration.RHYOLITE_IRON_ORE);
    public static final DeferredItem<BlockItem> DACITE_IRON_ORE =                   BLOCKITEMS.registerSimpleBlockItem("dacite_iron_ore",               BlockRegistration.DACITE_IRON_ORE);
    public static final DeferredItem<BlockItem> ANDESITE_IRON_ORE =                 BLOCKITEMS.registerSimpleBlockItem("andesite_iron_ore",             BlockRegistration.ANDESITE_IRON_ORE);
    public static final DeferredItem<BlockItem> BASALT_IRON_ORE =                   BLOCKITEMS.registerSimpleBlockItem("basalt_iron_ore",               BlockRegistration.BASALT_IRON_ORE);
    // GOLD ORE
    public static final DeferredItem<BlockItem> GREYWACKE_GOLD_ORE =                new VanillaDeferredItem<>(Items.GOLD_ORE);
    public static final DeferredItem<BlockItem> SILTSTONE_GOLD_ORE =                BLOCKITEMS.registerSimpleBlockItem("siltstone_gold_ore",            BlockRegistration.SILTSTONE_GOLD_ORE);
    public static final DeferredItem<BlockItem> DOLOSTONE_GOLD_ORE =                BLOCKITEMS.registerSimpleBlockItem("dolostone_gold_ore",            BlockRegistration.DOLOSTONE_GOLD_ORE);
    public static final DeferredItem<BlockItem> LIMESTONE_GOLD_ORE =                BLOCKITEMS.registerSimpleBlockItem("limestone_gold_ore",            BlockRegistration.LIMESTONE_GOLD_ORE);
    public static final DeferredItem<BlockItem> CHALK_GOLD_ORE =                    BLOCKITEMS.registerSimpleBlockItem("chalk_gold_ore",                BlockRegistration.CHALK_GOLD_ORE);
    public static final DeferredItem<BlockItem> IRONSTONE_GOLD_ORE =                BLOCKITEMS.registerSimpleBlockItem("ironstone_gold_ore",            BlockRegistration.IRONSTONE_GOLD_ORE);
    public static final DeferredItem<BlockItem> SHALE_GOLD_ORE =                    BLOCKITEMS.registerSimpleBlockItem("shale_gold_ore",                BlockRegistration.SHALE_GOLD_ORE);
    public static final DeferredItem<BlockItem> ARKOSE_GOLD_ORE =                   BLOCKITEMS.registerSimpleBlockItem("arkose_gold_ore",               BlockRegistration.ARKOSE_GOLD_ORE);
    public static final DeferredItem<BlockItem> MARBLE_GOLD_ORE =                   BLOCKITEMS.registerSimpleBlockItem("marble_gold_ore",               BlockRegistration.MARBLE_GOLD_ORE);
    public static final DeferredItem<BlockItem> QUARTZITE_GOLD_ORE =                BLOCKITEMS.registerSimpleBlockItem("quartzite_gold_ore",            BlockRegistration.QUARTZITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> HORNFELS_GOLD_ORE =                 BLOCKITEMS.registerSimpleBlockItem("hornfels_gold_ore",             BlockRegistration.HORNFELS_GOLD_ORE);
    public static final DeferredItem<BlockItem> SLATE_GOLD_ORE =                    BLOCKITEMS.registerSimpleBlockItem("slate_gold_ore",                BlockRegistration.SLATE_GOLD_ORE);
    public static final DeferredItem<BlockItem> GABBRO_GOLD_ORE =                   new VanillaDeferredItem<>(Items.DEEPSLATE_GOLD_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_DIORITE_GOLD_ORE =           BLOCKITEMS.registerSimpleBlockItem("smooth_diorite_gold_ore",       BlockRegistration.SMOOTH_DIORITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_GRANITE_GOLD_ORE =           BLOCKITEMS.registerSimpleBlockItem("smooth_granite_gold_ore",       BlockRegistration.SMOOTH_GRANITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> NORITE_GOLD_ORE =                   BLOCKITEMS.registerSimpleBlockItem("norite_gold_ore",               BlockRegistration.NORITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> PERIDOTITE_GOLD_ORE =               BLOCKITEMS.registerSimpleBlockItem("peridotite_gold_ore",           BlockRegistration.PERIDOTITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> RHYOLITE_GOLD_ORE =                 BLOCKITEMS.registerSimpleBlockItem("rhyolite_gold_ore",             BlockRegistration.RHYOLITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> DACITE_GOLD_ORE =                   BLOCKITEMS.registerSimpleBlockItem("dacite_gold_ore",               BlockRegistration.DACITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> ANDESITE_GOLD_ORE =                 BLOCKITEMS.registerSimpleBlockItem("andesite_gold_ore",             BlockRegistration.ANDESITE_GOLD_ORE);
    public static final DeferredItem<BlockItem> BASALT_GOLD_ORE =                   BLOCKITEMS.registerSimpleBlockItem("basalt_gold_ore",               BlockRegistration.BASALT_GOLD_ORE);
    // COAL ORE
    public static final DeferredItem<BlockItem> SAPROLITE_COAL_ORE =                BLOCKITEMS.registerSimpleBlockItem("saprolite_coal_ore",            BlockRegistration.SAPROLITE_COAL_ORE);
    public static final DeferredItem<BlockItem> LATERITE_COAL_ORE =                 BLOCKITEMS.registerSimpleBlockItem("laterite_coal_ore",             BlockRegistration.LATERITE_COAL_ORE);
    public static final DeferredItem<BlockItem> GREYWACKE_COAL_ORE =                new VanillaDeferredItem<>(Items.COAL_ORE);
    public static final DeferredItem<BlockItem> SILTSTONE_COAL_ORE =                BLOCKITEMS.registerSimpleBlockItem("siltstone_coal_ore",            BlockRegistration.SILTSTONE_COAL_ORE);
    public static final DeferredItem<BlockItem> DOLOSTONE_COAL_ORE =                BLOCKITEMS.registerSimpleBlockItem("dolostone_coal_ore",            BlockRegistration.DOLOSTONE_COAL_ORE);
    public static final DeferredItem<BlockItem> LIMESTONE_COAL_ORE =                BLOCKITEMS.registerSimpleBlockItem("limestone_coal_ore",            BlockRegistration.LIMESTONE_COAL_ORE);
    public static final DeferredItem<BlockItem> CHALK_COAL_ORE =                    BLOCKITEMS.registerSimpleBlockItem("chalk_coal_ore",                BlockRegistration.CHALK_COAL_ORE);
    public static final DeferredItem<BlockItem> IRONSTONE_COAL_ORE =                BLOCKITEMS.registerSimpleBlockItem("ironstone_coal_ore",            BlockRegistration.IRONSTONE_COAL_ORE);
    public static final DeferredItem<BlockItem> SHALE_COAL_ORE =                    BLOCKITEMS.registerSimpleBlockItem("shale_coal_ore",                BlockRegistration.SHALE_COAL_ORE);
    public static final DeferredItem<BlockItem> ARKOSE_COAL_ORE =                   BLOCKITEMS.registerSimpleBlockItem("arkose_coal_ore",               BlockRegistration.ARKOSE_COAL_ORE);
    public static final DeferredItem<BlockItem> MARBLE_COAL_ORE =                   BLOCKITEMS.registerSimpleBlockItem("marble_coal_ore",               BlockRegistration.MARBLE_COAL_ORE);
    public static final DeferredItem<BlockItem> QUARTZITE_COAL_ORE =                BLOCKITEMS.registerSimpleBlockItem("quartzite_coal_ore",            BlockRegistration.QUARTZITE_COAL_ORE);
    public static final DeferredItem<BlockItem> HORNFELS_COAL_ORE =                 BLOCKITEMS.registerSimpleBlockItem("hornfels_coal_ore",             BlockRegistration.HORNFELS_COAL_ORE);
    public static final DeferredItem<BlockItem> SLATE_COAL_ORE =                    BLOCKITEMS.registerSimpleBlockItem("slate_coal_ore",                BlockRegistration.SLATE_COAL_ORE);
    // DIAMOND ORE
    public static final DeferredItem<BlockItem> GABBRO_DIAMOND_ORE =                new VanillaDeferredItem<>(Items.DEEPSLATE_DIAMOND_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_DIORITE_DIAMOND_ORE =        BLOCKITEMS.registerSimpleBlockItem("smooth_diorite_diamond_ore",    BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_GRANITE_DIAMOND_ORE =        BLOCKITEMS.registerSimpleBlockItem("smooth_granite_diamond_ore",    BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE);
    public static final DeferredItem<BlockItem> NORITE_DIAMOND_ORE =                BLOCKITEMS.registerSimpleBlockItem("norite_diamond_ore",            BlockRegistration.NORITE_DIAMOND_ORE);
    public static final DeferredItem<BlockItem> PERIDOTITE_DIAMOND_ORE =            BLOCKITEMS.registerSimpleBlockItem("peridotite_diamond_ore",        BlockRegistration.PERIDOTITE_DIAMOND_ORE);
    public static final DeferredItem<BlockItem> ANDESITE_DIAMOND_ORE =              BLOCKITEMS.registerSimpleBlockItem("andesite_diamond_ore",          BlockRegistration.ANDESITE_DIAMOND_ORE);
    public static final DeferredItem<BlockItem> BASALT_DIAMOND_ORE =                BLOCKITEMS.registerSimpleBlockItem("basalt_diamond_ore",            BlockRegistration.BASALT_DIAMOND_ORE);
    // EMERALD ORE
    public static final DeferredItem<BlockItem> GABBRO_EMERALD_ORE =                new VanillaDeferredItem<>(Items.DEEPSLATE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_DIORITE_EMERALD_ORE =        BLOCKITEMS.registerSimpleBlockItem("smooth_diorite_emerald_ore",    BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_GRANITE_EMERALD_ORE =        BLOCKITEMS.registerSimpleBlockItem("smooth_granite_emerald_ore",    BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> NORITE_EMERALD_ORE =                BLOCKITEMS.registerSimpleBlockItem("norite_emerald_ore",            BlockRegistration.NORITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> PERIDOTITE_EMERALD_ORE =            BLOCKITEMS.registerSimpleBlockItem("peridotite_emerald_ore",        BlockRegistration.PERIDOTITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> RHYOLITE_EMERALD_ORE =              BLOCKITEMS.registerSimpleBlockItem("rhyolite_emerald_ore",          BlockRegistration.RHYOLITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> DACITE_EMERALD_ORE =                BLOCKITEMS.registerSimpleBlockItem("dacite_emerald_ore",            BlockRegistration.DACITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> ANDESITE_EMERALD_ORE =              BLOCKITEMS.registerSimpleBlockItem("andesite_emerald_ore",          BlockRegistration.ANDESITE_EMERALD_ORE);
    public static final DeferredItem<BlockItem> BASALT_EMERALD_ORE =                BLOCKITEMS.registerSimpleBlockItem("basalt_emerald_ore",            BlockRegistration.BASALT_EMERALD_ORE);
    // LAPIS ORE
    public static final DeferredItem<BlockItem> MARBLE_LAPIS_ORE =                  BLOCKITEMS.registerSimpleBlockItem("marble_lapis_ore",              BlockRegistration.MARBLE_LAPIS_ORE);
    public static final DeferredItem<BlockItem> QUARTZITE_LAPIS_ORE =               BLOCKITEMS.registerSimpleBlockItem("quartzite_lapis_ore",           BlockRegistration.QUARTZITE_LAPIS_ORE);
    public static final DeferredItem<BlockItem> HORNFELS_LAPIS_ORE =                BLOCKITEMS.registerSimpleBlockItem("hornfels_lapis_ore",            BlockRegistration.HORNFELS_LAPIS_ORE);
    public static final DeferredItem<BlockItem> SLATE_LAPIS_ORE =                   BLOCKITEMS.registerSimpleBlockItem("slate_lapis_ore",               BlockRegistration.SLATE_LAPIS_ORE);
    // REDSTONE ORE
    public static final DeferredItem<BlockItem> GABBRO_REDSTONE_ORE =               new VanillaDeferredItem<>(Items.DEEPSLATE_REDSTONE_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_DIORITE_REDSTONE_ORE =       BLOCKITEMS.registerSimpleBlockItem("smooth_diorite_redstone_ore",   BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE);
    public static final DeferredItem<BlockItem> SMOOTH_GRANITE_REDSTONE_ORE =       BLOCKITEMS.registerSimpleBlockItem("smooth_granite_redstone_ore",   BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE);
    public static final DeferredItem<BlockItem> NORITE_REDSTONE_ORE =               BLOCKITEMS.registerSimpleBlockItem("norite_redstone_ore",           BlockRegistration.NORITE_REDSTONE_ORE);
    public static final DeferredItem<BlockItem> PERIDOTITE_REDSTONE_ORE =           BLOCKITEMS.registerSimpleBlockItem("peridotite_redstone_ore",       BlockRegistration.PERIDOTITE_REDSTONE_ORE);
    // TIN ORE
    public static final DeferredItem<BlockItem> TIN_ORE_IN_GREYWACKE =              BLOCKITEMS.registerSimpleBlockItem("tin_ore_block",                 BlockRegistration.TIN_ORE_IN_GREYWACKE);
    public static final DeferredItem<BlockItem> TIN_ORE_IN_GABBRO =                 BLOCKITEMS.registerSimpleBlockItem("deepslate_tin_ore_block",       BlockRegistration.TIN_ORE_IN_GABBRO);
    // CHERT ORE
    public static final DeferredItem<BlockItem> LIMESTONE_CHERT_ORE =               BLOCKITEMS.registerSimpleBlockItem("limestone_chert_ore",           BlockRegistration.LIMESTONE_CHERT_ORE);
    public static final DeferredItem<BlockItem> CHALK_CHERT_ORE =                   BLOCKITEMS.registerSimpleBlockItem("chalk_chert_ore",               BlockRegistration.CHALK_CHERT_ORE);
    // GEODE ORE
    public static final DeferredItem<BlockItem> BASALT_GEODE_ORE =                  BLOCKITEMS.registerSimpleBlockItem("basalt_geode_ore",              BlockRegistration.BASALT_GEODE_ORE);
    public static final DeferredItem<BlockItem> ANDESITE_GEODE_ORE =                BLOCKITEMS.registerSimpleBlockItem("andesite_geode_ore",            BlockRegistration.ANDESITE_GEODE_ORE);
    public static final DeferredItem<BlockItem> RHYOLITE_GEODE_ORE =                BLOCKITEMS.registerSimpleBlockItem("rhyolite_geode_ore",            BlockRegistration.RHYOLITE_GEODE_ORE);
    public static final DeferredItem<BlockItem> DACITE_GEODE_ORE =                  BLOCKITEMS.registerSimpleBlockItem("dacite_geode_ore",              BlockRegistration.DACITE_GEODE_ORE);

    // ROCK PROPERTIES
    private static final Item.Properties ROCK_PROPERTIES =                          new Item.Properties().durability(20);
    //ROCK
    public static final DeferredItem<RockBlockItem> SANDSTONE_ROCK =                registerBlockItem("sandstone_rock",         RockBlockItem::new,     BlockRegistration.SANDSTONE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> RED_SANDSTONE_ROCK =            registerBlockItem("red_sandstone_rock",     RockBlockItem::new,     BlockRegistration.RED_SANDSTONE_ROCK,   ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SAPROLITE_ROCK =                registerBlockItem("saprolite_rock",         RockBlockItem::new,     BlockRegistration.SAPROLITE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> LATERITE_ROCK =                 registerBlockItem("laterite_rock",          RockBlockItem::new,     BlockRegistration.LATERITE_ROCK,        ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SILT_CLUMP =                    registerBlockItem("silt_clump",             RockBlockItem::new,     BlockRegistration.SILT_CLUMP,           ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> GREYWACKE_ROCK =                registerBlockItem("greywacke_rock",         RockBlockItem::new,     BlockRegistration.GREYWACKE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SILTSTONE_ROCK =                registerBlockItem("siltstone_rock",         RockBlockItem::new,     BlockRegistration.SILTSTONE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> DOLOSTONE_ROCK =                registerBlockItem("dolostone_rock",         RockBlockItem::new,     BlockRegistration.DOLOSTONE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> LIMESTONE_ROCK =                registerBlockItem("limestone_rock",         RockBlockItem::new,     BlockRegistration.LIMESTONE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> IRONSTONE_ROCK =                registerBlockItem("ironstone_rock",         RockBlockItem::new,     BlockRegistration.IRONSTONE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SHALE_ROCK =                    registerBlockItem("shale_rock",             RockBlockItem::new,     BlockRegistration.SHALE_ROCK,           ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> ARKOSE_ROCK =                   registerBlockItem("arkose_rock",            RockBlockItem::new,     BlockRegistration.ARKOSE_ROCK,          ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> MARBLE_ROCK =                   registerBlockItem("marble_rock",            RockBlockItem::new,     BlockRegistration.MARBLE_ROCK,          ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> QUARTZITE_ROCK =                registerBlockItem("quartzite_rock",         RockBlockItem::new,     BlockRegistration.QUARTZITE_ROCK,       ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> HORNFELS_ROCK =                 registerBlockItem("hornfels_rock",          RockBlockItem::new,     BlockRegistration.HORNFELS_ROCK,        ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SLATE_ROCK =                    registerBlockItem("slate_rock",             RockBlockItem::new,     BlockRegistration.SLATE_ROCK,           ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> GABBRO_ROCK =                   registerBlockItem("gabbro_rock",            RockBlockItem::new,     BlockRegistration.GABBRO_ROCK,          ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SMOOTH_DIORITE_ROCK =           registerBlockItem("smooth_diorite_rock",    RockBlockItem::new,     BlockRegistration.SMOOTH_DIORITE_ROCK,  ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> SMOOTH_GRANITE_ROCK =           registerBlockItem("smooth_granite_rock",    RockBlockItem::new,     BlockRegistration.SMOOTH_GRANITE_ROCK,  ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> NORITE_ROCK =                   registerBlockItem("norite_rock",            RockBlockItem::new,     BlockRegistration.NORITE_ROCK,          ROCK_PROPERTIES);
    public static final DeferredItem<RockBlockItem> PERIDOTITE_ROCK =               registerBlockItem("peridotite_rock",        RockBlockItem::new,     BlockRegistration.PERIDOTITE_ROCK,      ROCK_PROPERTIES);
    // LARGE ROCK
    public static final DeferredItem<BlockItem> LARGE_SANDSTONE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_sandstone_rock",          BlockRegistration.LARGE_SANDSTONE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_RED_SANDSTONE_ROCK =          BLOCKITEMS.registerSimpleBlockItem("large_red_sandstone_rock",      BlockRegistration.LARGE_RED_SANDSTONE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SAPROLITE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_saprolite_rock",          BlockRegistration.LARGE_SAPROLITE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_LATERITE_ROCK =               BLOCKITEMS.registerSimpleBlockItem("large_laterite_rock",           BlockRegistration.LARGE_LATERITE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SILT_CLUMP =                  BLOCKITEMS.registerSimpleBlockItem("large_silt_clump",              BlockRegistration.LARGE_SILT_CLUMP);
    public static final DeferredItem<BlockItem> LARGE_GREYWACKE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_greywacke_rock",          BlockRegistration.LARGE_GREYWACKE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SILTSTONE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_siltstone_rock",          BlockRegistration.LARGE_SILTSTONE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_DOLOSTONE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_dolostone_rock",          BlockRegistration.LARGE_DOLOSTONE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_LIMESTONE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_limestone_rock",          BlockRegistration.LARGE_LIMESTONE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_IRONSTONE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_ironstone_rock",          BlockRegistration.LARGE_IRONSTONE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SHALE_ROCK =                  BLOCKITEMS.registerSimpleBlockItem("large_shale_rock",              BlockRegistration.LARGE_SHALE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_ARKOSE_ROCK =                 BLOCKITEMS.registerSimpleBlockItem("large_arkose_rock",             BlockRegistration.LARGE_ARKOSE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_MARBLE_ROCK =                 BLOCKITEMS.registerSimpleBlockItem("large_marble_rock",             BlockRegistration.LARGE_MARBLE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_QUARTZITE_ROCK =              BLOCKITEMS.registerSimpleBlockItem("large_quartzite_rock",          BlockRegistration.LARGE_QUARTZITE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_HORNFELS_ROCK =               BLOCKITEMS.registerSimpleBlockItem("large_hornfels_rock",           BlockRegistration.LARGE_HORNFELS_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SLATE_ROCK =                  BLOCKITEMS.registerSimpleBlockItem("large_slate_rock",              BlockRegistration.LARGE_SLATE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_GABBRO_ROCK =                 BLOCKITEMS.registerSimpleBlockItem("large_gabbro_rock",             BlockRegistration.LARGE_GABBRO_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SMOOTH_DIORITE_ROCK =         BLOCKITEMS.registerSimpleBlockItem("large_smooth_diorite_rock",     BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_SMOOTH_GRANITE_ROCK =         BLOCKITEMS.registerSimpleBlockItem("large_smooth_granite_rock",     BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_NORITE_ROCK =                 BLOCKITEMS.registerSimpleBlockItem("large_norite_rock",             BlockRegistration.LARGE_NORITE_ROCK);
    public static final DeferredItem<BlockItem> LARGE_PERIDOTITE_ROCK =             BLOCKITEMS.registerSimpleBlockItem("large_peridotite_rock",         BlockRegistration.LARGE_PERIDOTITE_ROCK);
    // COPPER ROCK
    public static final DeferredItem<BlockItem> SAPROLITE_ROCK_COPPER_ORE =         BLOCKITEMS.registerSimpleBlockItem("saprolite_rock_copper_ore",     BlockRegistration.SAPROLITE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> GREYWACKE_ROCK_COPPER_ORE =         BLOCKITEMS.registerSimpleBlockItem("greywacke_rock_copper_ore",     BlockRegistration.GREYWACKE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> SILTSTONE_ROCK_COPPER_ORE =         BLOCKITEMS.registerSimpleBlockItem("siltstone_rock_copper_ore",     BlockRegistration.SILTSTONE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> DOLOSTONE_ROCK_COPPER_ORE =         BLOCKITEMS.registerSimpleBlockItem("dolostone_rock_copper_ore",     BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> LIMESTONE_ROCK_COPPER_ORE =         BLOCKITEMS.registerSimpleBlockItem("limestone_rock_copper_ore",     BlockRegistration.LIMESTONE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> CHALK_ROCK_COPPER_ORE =             BLOCKITEMS.registerSimpleBlockItem("chalk_rock_copper_ore",         BlockRegistration.CHALK_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> IRONSTONE_ROCK_COPPER_ORE =         BLOCKITEMS.registerSimpleBlockItem("ironstone_rock_copper_ore",     BlockRegistration.IRONSTONE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> SHALE_ROCK_COPPER_ORE =             BLOCKITEMS.registerSimpleBlockItem("shale_rock_copper_ore",         BlockRegistration.SHALE_ROCK_COPPER_ORE);
    public static final DeferredItem<BlockItem> ARKOSE_ROCK_COPPER_ORE =            BLOCKITEMS.registerSimpleBlockItem("arkose_rock_copper_ore",        BlockRegistration.ARKOSE_ROCK_COPPER_ORE);

    // BRANCH
    public static final DeferredItem<BlockItem> BIRCH_BRANCH =                      BLOCKITEMS.registerSimpleBlockItem("birch_branch",                  BlockRegistration.BIRCH_BRANCH);
    public static final DeferredItem<BlockItem> OAK_BRANCH =                        BLOCKITEMS.registerSimpleBlockItem("oak_branch",                    BlockRegistration.OAK_BRANCH);
    public static final DeferredItem<BlockItem> SPRUCE_BRANCH =                     BLOCKITEMS.registerSimpleBlockItem("spruce_branch",                 BlockRegistration.SPRUCE_BRANCH);
    public static final DeferredItem<BlockItem> JUNGLE_BRANCH =                     BLOCKITEMS.registerSimpleBlockItem("jungle_branch",                 BlockRegistration.JUNGLE_BRANCH);
    public static final DeferredItem<BlockItem> DARK_OAK_BRANCH =                   BLOCKITEMS.registerSimpleBlockItem("dark_oak_branch",               BlockRegistration.DARK_OAK_BRANCH);
    public static final DeferredItem<BlockItem> ACACIA_BRANCH =                     BLOCKITEMS.registerSimpleBlockItem("acacia_branch",                 BlockRegistration.ACACIA_BRANCH);
    public static final DeferredItem<BlockItem> CHERRY_BRANCH =                     BLOCKITEMS.registerSimpleBlockItem("cherry_branch",                 BlockRegistration.CHERRY_BRANCH);
    public static final DeferredItem<BlockItem> MANGROVE_BRANCH =                   BLOCKITEMS.registerSimpleBlockItem("mangrove_branch",               BlockRegistration.MANGROVE_BRANCH);

    public static final DeferredItem<BlockItem> SHRUB =                             BLOCKITEMS.registerSimpleBlockItem("shrub",                         BlockRegistration.SHRUB);
    //endregion

    //region Farming
    public static final DeferredItem<BlockItem> DOGBANE_BLOCK_ITEM =                BLOCKITEMS.registerSimpleBlockItem("dogbane",                       BlockRegistration.DOGBANE);
    //endregion

    //region Primitive
    public static final DeferredItem<BlockItem> THATCH_BLOCK =                      BLOCKITEMS.registerSimpleBlockItem("thatch_block",                  BlockRegistration.THATCH);
    public static final DeferredItem<BlockItem> STONE_BENCH =                       BLOCKITEMS.registerSimpleBlockItem("stone_bench",                   BlockRegistration.STONE_BENCH);
    public static final DeferredItem<BlockItem> CHOPPING_BLOCK =                    BLOCKITEMS.registerSimpleBlockItem("chopping_block",                BlockRegistration.CHOPPING_BLOCK);
    public static final DeferredItem<BlockItem> WET_PACKED_MUD =                    BLOCKITEMS.registerSimpleBlockItem("wet_packed_mud",                BlockRegistration.WET_PACKED_MUD);
    public static final DeferredItem<DryingBrickBlockItem> WET_PACKED_MUD_BRICK =   registerBlockItem("wet_packed_mud_brick",                           DryingBrickBlockItem::new, BlockRegistration.WET_PACKED_MUD_BRICK);
    public static final DeferredItem<DryingBrickBlockItem> WET_DAUB_BRICK =         registerBlockItem("wet_daub_brick",                                 DryingBrickBlockItem::new, BlockRegistration.WET_DAUB_BRICK);
    public static final DeferredItem<DryingBrickBlockItem> WET_CLAY_BRICK =         registerBlockItem("wet_clay_brick",                                 DryingBrickBlockItem::new, BlockRegistration.DRYING_CLAY_BRICK);
    public static final DeferredItem<DryingBrickBlockItem> WET_RED_CLAY_BRICK =     registerBlockItem("wet_red_clay_brick",                             DryingBrickBlockItem::new, BlockRegistration.DRYING_RED_CLAY_BRICK);
    public static final DeferredItem<BlockItem> WET_DAUB_BLOCK =                    BLOCKITEMS.registerSimpleBlockItem("wet_daub_block",                BlockRegistration.WET_DAUB_BLOCK);
    public static final DeferredItem<BlockItem> DAUB_BLOCK =                        BLOCKITEMS.registerSimpleBlockItem("daub_block",                    BlockRegistration.DAUB_BLOCK);
    public static final DeferredItem<BlockItem> DAUB_BRICKS =                       BLOCKITEMS.registerSimpleBlockItem("daub_bricks",                   BlockRegistration.DAUB_BRICKS);
    public static final DeferredItem<BlockItem> CRACKED_DAUB_BLOCK =                BLOCKITEMS.registerSimpleBlockItem("cracked_daub_block",            BlockRegistration.CRACKED_DAUB_BLOCK);
    public static final DeferredItem<BlockItem> CRACKED_DAUB_BRICKS =               BLOCKITEMS.registerSimpleBlockItem("cracked_daub_bricks",           BlockRegistration.CRACKED_DAUB_BRICKS);
    public static final DeferredItem<BlockItem> THATCH =                            BLOCKITEMS.registerSimpleBlockItem("thatch",                        BlockRegistration.FIRE_LAY);
    //endregion

    //region Pottery
    public static final DeferredItem<BlockItem> WET_GATHERERS_JAR =                 BLOCKITEMS.registerItem("wet_gatherers_jar",                        props -> new DryingBlockItem(BlockRegistration.DRYING_GATHERERS_JAR, props, false));
    public static final DeferredItem<BlockItem> DRY_GATHERERS_JAR =                 BLOCKITEMS.registerItem("dry_gatherers_jar",                        props -> new DryingBlockItem(BlockRegistration.DRYING_GATHERERS_JAR, props, true));
    public static final DeferredItem<GatherersJarBlockItem> GATHERERS_JAR =         BLOCKITEMS.registerItem("gatherers_jar",                            props -> new GatherersJarBlockItem(BlockRegistration.GATHERERS_JAR, props.stacksTo(1)));
    public static final DeferredItem<BlockItem> WET_KEEPERS_CROCK =                 BLOCKITEMS.registerItem("wet_keepers_crock",                        props -> new DryingBlockItem(BlockRegistration.DRYING_KEEPERS_CROCK, props, false));
    public static final DeferredItem<BlockItem> DRY_KEEPERS_CROCK =                 BLOCKITEMS.registerItem("dry_keepers_crock",                        props -> new DryingBlockItem(BlockRegistration.DRYING_KEEPERS_CROCK, props, true));
    public static final DeferredItem<ContainerItemBlockItem> KEEPERS_CROCK =        BLOCKITEMS.registerItem("keepers_crock",                            props -> new ContainerItemBlockItem(BlockRegistration.KEEPERS_CROCK, props.stacksTo(1)));
    public static final DeferredItem<BlockItem> WET_SETTLERS_POT =                  BLOCKITEMS.registerItem("wet_settlers_pot",                         props -> new DryingBlockItem(BlockRegistration.DRYING_SETTLERS_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_SETTLERS_POT =                  BLOCKITEMS.registerItem("dry_settlers_pot",                         props -> new DryingBlockItem(BlockRegistration.DRYING_SETTLERS_POT, props, true));
    public static final DeferredItem<BlockItem> SETTLERS_POT =                      BLOCKITEMS.registerSimpleBlockItem("settlers_pot",                  BlockRegistration.SETTLERS_POT);
    public static final DeferredItem<BlockItem> WET_CLAY_COOKING_POT =              BLOCKITEMS.registerItem("wet_clay_cooking_pot",                     props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_COOKING_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_CLAY_COOKING_POT =              BLOCKITEMS.registerItem("dry_clay_cooking_pot",                     props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_COOKING_POT, props, true));
    public static final DeferredItem<BlockItem> CLAY_COOKING_POT =                  BLOCKITEMS.registerSimpleBlockItem("clay_cooking_pot",              BlockRegistration.CLAY_COOKING_POT);
    public static final DeferredItem<BlockItem> WET_CLAY_CAULDRON =                 BLOCKITEMS.registerItem("wet_clay_cauldron",                        props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_CAULDRON, props.stacksTo(1), false));
    public static final DeferredItem<BlockItem> DRY_CLAY_CAULDRON =                 BLOCKITEMS.registerItem("dry_clay_cauldron",                        props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_CAULDRON, props.stacksTo(1), true));
    public static final DeferredItem<BlockItem> CLAY_CAULDRON =                     BLOCKITEMS.registerSimpleBlockItem("clay_cauldron",                 BlockRegistration.CLAY_CAULDRON);
    public static final DeferredItem<BlockItem> WET_JUG =                           BLOCKITEMS.registerItem("wet_jug",                                  props -> new DryingBlockItem(BlockRegistration.DRYING_JUG, props, false));
    public static final DeferredItem<BlockItem> DRY_JUG =                           BLOCKITEMS.registerItem("dry_jug",                                  props -> new DryingBlockItem(BlockRegistration.DRYING_JUG, props, true));
    public static final DeferredItem<BlockItem> JUG =                               BLOCKITEMS.registerSimpleBlockItem("jug",                           BlockRegistration.JUG);
    public static final DeferredItem<BlockItem> WET_FLOWER_POT =                    BLOCKITEMS.registerItem("wet_flower_pot",                           props -> new DryingBlockItem(BlockRegistration.DRYING_FLOWER_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_FLOWER_POT =                    BLOCKITEMS.registerItem("dry_flower_pot",                           props -> new DryingBlockItem(BlockRegistration.DRYING_FLOWER_POT, props, true));
    public static final DeferredItem<BlockItem> WET_DECORATED_POT =                 BLOCKITEMS.registerItem("wet_decorated_pot",                        props -> new DryingBlockItem(BlockRegistration.DRYING_DECORATED_POT, props, false));
    public static final DeferredItem<BlockItem> DRY_DECORATED_POT =                 BLOCKITEMS.registerItem("dry_decorated_pot",                        props -> new DryingBlockItem(BlockRegistration.DRYING_DECORATED_POT, props, true));
    //endregion
}
