package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.VanillaDeferredItem;
import io.github.zephyrwolf.medievalism.common.blockitem.*;
import io.github.zephyrwolf.medievalism.common.item.*;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.food.FoodCatalog;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class ItemRegistration
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }

    public static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    public static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == WORLD ==
    // DIRT
    //public static final DeferredItem<BlockItem> CLAY_IN_GRASS =                     ITEMS.registerSimpleBlockItem("clay_in_grass",                 BlockRegistration.CLAY_IN_GRASS);
    //public static final DeferredItem<BlockItem> CLAY_IN_DIRT =                      ITEMS.registerSimpleBlockItem("clay_in_dirt",                  BlockRegistration.CLAY_IN_DIRT);
    //public static final DeferredItem<BlockItem> SILT =                              ITEMS.registerSimpleBlockItem("silt",                          BlockRegistration.SILT);
    //// STONE
    //public static final DeferredItem<BlockItem> SOFT_TUFF =                         ITEMS.registerSimpleBlockItem("soft_tuff",                     BlockRegistration.SOFT_TUFF);
    //public static final DeferredItem<BlockItem> IGNIMBRITE =                        ITEMS.registerSimpleBlockItem("ignimbrite",                    BlockRegistration.IGNIMBRITE);
    //public static final DeferredItem<BlockItem> LAPILLISTONE =                      ITEMS.registerSimpleBlockItem("lapillistone",                  BlockRegistration.LAPILLISTONE);
    //public static final DeferredItem<BlockItem> WELDED_TUFF =                       new VanillaDeferredItem<>((BlockItem) Items.TUFF);
    //public static final DeferredItem<BlockItem> COBBLED_SANDSTONE =                 ITEMS.registerSimpleBlockItem("cobbled_sandstone",             BlockRegistration.COBBLED_SANDSTONE);
    //public static final DeferredItem<BlockItem> SAPROLITE =                         ITEMS.registerSimpleBlockItem("saprolite",                     BlockRegistration.SAPROLITE);
    //public static final DeferredItem<BlockItem> LATERITE =                          ITEMS.registerSimpleBlockItem("laterite",                      BlockRegistration.LATERITE);
    //public static final DeferredItem<BlockItem> GREYWACKE =                         new VanillaDeferredItem<>(Items.STONE);
    //public static final DeferredItem<BlockItem> SILTSTONE =                         ITEMS.registerSimpleBlockItem("siltstone",                     BlockRegistration.SILTSTONE);
    //public static final DeferredItem<BlockItem> DOLOSTONE =                         ITEMS.registerSimpleBlockItem("dolostone",                     BlockRegistration.DOLOSTONE);
    //public static final DeferredItem<BlockItem> LIMESTONE =                         ITEMS.registerSimpleBlockItem("limestone",                     BlockRegistration.LIMESTONE);
    //public static final DeferredItem<BlockItem> CHALK =                             ITEMS.registerSimpleBlockItem("chalk",                         BlockRegistration.CHALK);
    //public static final DeferredItem<BlockItem> IRONSTONE =                         ITEMS.registerSimpleBlockItem("ironstone",                     BlockRegistration.IRONSTONE);
    //public static final DeferredItem<BlockItem> SHALE =                             ITEMS.registerSimpleBlockItem("shale",                         BlockRegistration.SHALE);
    //public static final DeferredItem<BlockItem> ARKOSE =                            ITEMS.registerSimpleBlockItem("arkose",                        BlockRegistration.ARKOSE);
    //public static final DeferredItem<BlockItem> RHYOLITE =                          ITEMS.registerSimpleBlockItem("rhyolite",                      BlockRegistration.RHYOLITE);
    //public static final DeferredItem<BlockItem> DACITE =                            ITEMS.registerSimpleBlockItem("dacite",                        BlockRegistration.DACITE);
    //public static final DeferredItem<BlockItem> MARBLE =                            ITEMS.registerSimpleBlockItem("marble",                        BlockRegistration.MARBLE);
    //public static final DeferredItem<BlockItem> QUARTZITE =                         ITEMS.registerSimpleBlockItem("quartzite",                     BlockRegistration.QUARTZITE);
    //public static final DeferredItem<BlockItem> HORNFELS =                          ITEMS.registerSimpleBlockItem("hornfels",                      BlockRegistration.HORNFELS);
    //public static final DeferredItem<BlockItem> SLATE =                             ITEMS.registerSimpleBlockItem("slate",                         BlockRegistration.SLATE);
    //public static final DeferredItem<BlockItem> NORITE =                            ITEMS.registerSimpleBlockItem("norite",                        BlockRegistration.NORITE);
    //public static final DeferredItem<BlockItem> PERIDOTITE =                        ITEMS.registerSimpleBlockItem("peridotite",                    BlockRegistration.PERIDOTITE);
    //public static final DeferredItem<BlockItem> GABBRO =                            new VanillaDeferredItem<>(Items.DEEPSLATE);
    //public static final DeferredItem<BlockItem> COBBLED_GABBRO =                    new VanillaDeferredItem<>(Items.COBBLED_DEEPSLATE);
    //public static final DeferredItem<BlockItem> ROUGH_DIORITE =                     new VanillaDeferredItem<>(Items.DIORITE);
    //public static final DeferredItem<BlockItem> ROUGH_GRANITE =                     new VanillaDeferredItem<>(Items.GRANITE);
    //public static final DeferredItem<BlockItem> SMOOTH_DIORITE =                    ITEMS.registerSimpleBlockItem("smooth_diorite",                BlockRegistration.SMOOTH_DIORITE);
    //public static final DeferredItem<BlockItem> SMOOTH_GRANITE =                    ITEMS.registerSimpleBlockItem("smooth_granite",                BlockRegistration.SMOOTH_GRANITE);
    //public static final DeferredItem<BlockItem> ANDESITE =                          new VanillaDeferredItem<>(Items.ANDESITE);
    //public static final DeferredItem<BlockItem> BASALT =                            new VanillaDeferredItem<>(Items.BASALT);
    //public static final DeferredItem<BlockItem> TRAVERTINE =                        new VanillaDeferredItem<>(Items.DRIPSTONE_BLOCK);
    //// INFESTED STONE
    //public static final DeferredItem<BlockItem> INFESTED_GREYWACKE =                new VanillaDeferredItem<>(Items.INFESTED_STONE);
    //public static final DeferredItem<BlockItem> INFESTED_SILTSTONE =                ITEMS.registerSimpleBlockItem("infested_siltstone",            BlockRegistration.INFESTED_SILTSTONE);
    //public static final DeferredItem<BlockItem> INFESTED_DOLOSTONE =                ITEMS.registerSimpleBlockItem("infested_dolostone",            BlockRegistration.INFESTED_DOLOSTONE);;
    //public static final DeferredItem<BlockItem> INFESTED_LIMESTONE =                ITEMS.registerSimpleBlockItem("infested_limestone",            BlockRegistration.INFESTED_LIMESTONE);
    //public static final DeferredItem<BlockItem> INFESTED_SHALE =                    ITEMS.registerSimpleBlockItem("infested_shale",                BlockRegistration.INFESTED_SHALE);
    //public static final DeferredItem<BlockItem> INFESTED_ARKOSE =                   ITEMS.registerSimpleBlockItem("infested_arkose",               BlockRegistration.INFESTED_ARKOSE);
    //public static final DeferredItem<BlockItem> INFESTED_MARBLE =                   ITEMS.registerSimpleBlockItem("infested_marble",               BlockRegistration.INFESTED_MARBLE);
    //public static final DeferredItem<BlockItem> INFESTED_QUARTZITE =                ITEMS.registerSimpleBlockItem("infested_quartzite",            BlockRegistration.INFESTED_QUARTZITE);
    //public static final DeferredItem<BlockItem> INFESTED_HORNFELS =                 ITEMS.registerSimpleBlockItem("infested_hornfels",             BlockRegistration.INFESTED_HORNFELS);
    //public static final DeferredItem<BlockItem> INFESTED_SLATE =                    ITEMS.registerSimpleBlockItem("infested_slate",                BlockRegistration.INFESTED_SLATE);
    //public static final DeferredItem<BlockItem> INFESTED_GABBRO =                   new VanillaDeferredItem<>(Items.INFESTED_DEEPSLATE);
    //public static final DeferredItem<BlockItem> INFESTED_SMOOTH_DIORITE =           ITEMS.registerSimpleBlockItem("infested_smooth_diorite",       BlockRegistration.INFESTED_SMOOTH_DIORITE);
    //public static final DeferredItem<BlockItem> INFESTED_SMOOTH_GRANITE =           ITEMS.registerSimpleBlockItem("infested_smooth_granite",       BlockRegistration.INFESTED_SMOOTH_GRANITE);
    //public static final DeferredItem<BlockItem> INFESTED_NORITE =                   ITEMS.registerSimpleBlockItem("infested_norite",               BlockRegistration.INFESTED_NORITE);
    //public static final DeferredItem<BlockItem> INFESTED_PERIDOTITE =               ITEMS.registerSimpleBlockItem("infested_peridotite",           BlockRegistration.INFESTED_PERIDOTITE);
    //public static final DeferredItem<BlockItem> INFESTED_RHYOLITE =                 ITEMS.registerSimpleBlockItem("infested_rhyolite",             BlockRegistration.INFESTED_RHYOLITE);
    //public static final DeferredItem<BlockItem> INFESTED_DACITE =                   ITEMS.registerSimpleBlockItem("infested_dacite",               BlockRegistration.INFESTED_DACITE);
    //public static final DeferredItem<BlockItem> INFESTED_ANDESITE =                 ITEMS.registerSimpleBlockItem("infested_andesite",             BlockRegistration.INFESTED_ANDESITE);
    //public static final DeferredItem<BlockItem> INFESTED_BASALT =                   ITEMS.registerSimpleBlockItem("infested_basalt",               BlockRegistration.INFESTED_BASALT);
    //// INFESTED COBBLE
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_GREYWACKE =        new VanillaDeferredItem<>(Items.INFESTED_COBBLESTONE);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_SILTSTONE =        ITEMS.registerSimpleBlockItem("infested_cobbled_siltstone",    BlockRegistration.INFESTED_COBBLED_SILTSTONE);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_DOLOSTONE =        ITEMS.registerSimpleBlockItem("infested_cobbled_dolostone",    BlockRegistration.INFESTED_COBBLED_DOLOSTONE);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_LIMESTONE =        ITEMS.registerSimpleBlockItem("infested_cobbled_limestone",    BlockRegistration.INFESTED_COBBLED_LIMESTONE);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_CHALK =            ITEMS.registerSimpleBlockItem("infested_cobbled_chalk",        BlockRegistration.INFESTED_COBBLED_CHALK);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_IRONSTONE =        ITEMS.registerSimpleBlockItem("infested_cobbled_ironstone",    BlockRegistration.INFESTED_COBBLED_IRONSTONE);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_SHALE =            ITEMS.registerSimpleBlockItem("infested_cobbled_shale",        BlockRegistration.INFESTED_COBBLED_SHALE);
    //public static final DeferredItem<BlockItem> INFESTED_COBBLED_ARKOSE =           ITEMS.registerSimpleBlockItem("infested_cobbled_arkose",       BlockRegistration.INFESTED_COBBLED_ARKOSE);
    //// COPPER ORE
    //public static final DeferredItem<BlockItem> SAPROLITE_COPPER_ORE =              ITEMS.registerSimpleBlockItem("saprolite_copper_ore",          BlockRegistration.SAPROLITE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> GREYWACKE_COPPER_ORE =              new VanillaDeferredItem<>(Items.COPPER_ORE);
    //public static final DeferredItem<BlockItem> SILTSTONE_COPPER_ORE =              ITEMS.registerSimpleBlockItem("siltstone_copper_ore",          BlockRegistration.SILTSTONE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> DOLOSTONE_COPPER_ORE =              ITEMS.registerSimpleBlockItem("dolostone_copper_ore",          BlockRegistration.DOLOSTONE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> LIMESTONE_COPPER_ORE =              ITEMS.registerSimpleBlockItem("limestone_copper_ore",          BlockRegistration.LIMESTONE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> CHALK_COPPER_ORE =                  ITEMS.registerSimpleBlockItem("chalk_copper_ore",              BlockRegistration.CHALK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> IRONSTONE_COPPER_ORE =              ITEMS.registerSimpleBlockItem("ironstone_copper_ore",          BlockRegistration.IRONSTONE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> SHALE_COPPER_ORE =                  ITEMS.registerSimpleBlockItem("shale_copper_ore",              BlockRegistration.SHALE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> ARKOSE_COPPER_ORE =                 ITEMS.registerSimpleBlockItem("arkose_copper_ore",             BlockRegistration.ARKOSE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> MARBLE_COPPER_ORE =                 ITEMS.registerSimpleBlockItem("marble_copper_ore",             BlockRegistration.MARBLE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> QUARTZITE_COPPER_ORE =              ITEMS.registerSimpleBlockItem("quartzite_copper_ore",          BlockRegistration.QUARTZITE_COPPER_ORE);
    //public static final DeferredItem<BlockItem> HORNFELS_COPPER_ORE =               ITEMS.registerSimpleBlockItem("hornfels_copper_ore",           BlockRegistration.HORNFELS_COPPER_ORE);
    //public static final DeferredItem<BlockItem> SLATE_COPPER_ORE =                  ITEMS.registerSimpleBlockItem("slate_copper_ore",              BlockRegistration.SLATE_COPPER_ORE);
    //// IRON ORE
    //public static final DeferredItem<BlockItem> GABBRO_IRON_ORE =                   new VanillaDeferredItem<>(Items.DEEPSLATE_IRON_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_DIORITE_IRON_ORE =           ITEMS.registerSimpleBlockItem("smooth_diorite_iron_ore",       BlockRegistration.SMOOTH_DIORITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_GRANITE_IRON_ORE =           ITEMS.registerSimpleBlockItem("smooth_granite_iron_ore",       BlockRegistration.SMOOTH_GRANITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> NORITE_IRON_ORE =                   ITEMS.registerSimpleBlockItem("norite_iron_ore",               BlockRegistration.NORITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> PERIDOTITE_IRON_ORE =               ITEMS.registerSimpleBlockItem("peridotite_iron_ore",           BlockRegistration.PERIDOTITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> RHYOLITE_IRON_ORE =                 ITEMS.registerSimpleBlockItem("rhyolite_iron_ore",             BlockRegistration.RHYOLITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> DACITE_IRON_ORE =                   ITEMS.registerSimpleBlockItem("dacite_iron_ore",               BlockRegistration.DACITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> ANDESITE_IRON_ORE =                 ITEMS.registerSimpleBlockItem("andesite_iron_ore",             BlockRegistration.ANDESITE_IRON_ORE);
    //public static final DeferredItem<BlockItem> BASALT_IRON_ORE =                   ITEMS.registerSimpleBlockItem("basalt_iron_ore",               BlockRegistration.BASALT_IRON_ORE);
    //// GOLD ORE
    //public static final DeferredItem<BlockItem> GREYWACKE_GOLD_ORE =                new VanillaDeferredItem<>(Items.GOLD_ORE);
    //public static final DeferredItem<BlockItem> SILTSTONE_GOLD_ORE =                ITEMS.registerSimpleBlockItem("siltstone_gold_ore",            BlockRegistration.SILTSTONE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> DOLOSTONE_GOLD_ORE =                ITEMS.registerSimpleBlockItem("dolostone_gold_ore",            BlockRegistration.DOLOSTONE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> LIMESTONE_GOLD_ORE =                ITEMS.registerSimpleBlockItem("limestone_gold_ore",            BlockRegistration.LIMESTONE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> CHALK_GOLD_ORE =                    ITEMS.registerSimpleBlockItem("chalk_gold_ore",                BlockRegistration.CHALK_GOLD_ORE);
    //public static final DeferredItem<BlockItem> IRONSTONE_GOLD_ORE =                ITEMS.registerSimpleBlockItem("ironstone_gold_ore",            BlockRegistration.IRONSTONE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> SHALE_GOLD_ORE =                    ITEMS.registerSimpleBlockItem("shale_gold_ore",                BlockRegistration.SHALE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> ARKOSE_GOLD_ORE =                   ITEMS.registerSimpleBlockItem("arkose_gold_ore",               BlockRegistration.ARKOSE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> MARBLE_GOLD_ORE =                   ITEMS.registerSimpleBlockItem("marble_gold_ore",               BlockRegistration.MARBLE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> QUARTZITE_GOLD_ORE =                ITEMS.registerSimpleBlockItem("quartzite_gold_ore",            BlockRegistration.QUARTZITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> HORNFELS_GOLD_ORE =                 ITEMS.registerSimpleBlockItem("hornfels_gold_ore",             BlockRegistration.HORNFELS_GOLD_ORE);
    //public static final DeferredItem<BlockItem> SLATE_GOLD_ORE =                    ITEMS.registerSimpleBlockItem("slate_gold_ore",                BlockRegistration.SLATE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> GABBRO_GOLD_ORE =                   new VanillaDeferredItem<>(Items.DEEPSLATE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_DIORITE_GOLD_ORE =           ITEMS.registerSimpleBlockItem("smooth_diorite_gold_ore",       BlockRegistration.SMOOTH_DIORITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_GRANITE_GOLD_ORE =           ITEMS.registerSimpleBlockItem("smooth_granite_gold_ore",       BlockRegistration.SMOOTH_GRANITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> NORITE_GOLD_ORE =                   ITEMS.registerSimpleBlockItem("norite_gold_ore",               BlockRegistration.NORITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> PERIDOTITE_GOLD_ORE =               ITEMS.registerSimpleBlockItem("peridotite_gold_ore",           BlockRegistration.PERIDOTITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> RHYOLITE_GOLD_ORE =                 ITEMS.registerSimpleBlockItem("rhyolite_gold_ore",             BlockRegistration.RHYOLITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> DACITE_GOLD_ORE =                   ITEMS.registerSimpleBlockItem("dacite_gold_ore",               BlockRegistration.DACITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> ANDESITE_GOLD_ORE =                 ITEMS.registerSimpleBlockItem("andesite_gold_ore",             BlockRegistration.ANDESITE_GOLD_ORE);
    //public static final DeferredItem<BlockItem> BASALT_GOLD_ORE =                   ITEMS.registerSimpleBlockItem("basalt_gold_ore",               BlockRegistration.BASALT_GOLD_ORE);
    //// COAL ORE
    //public static final DeferredItem<BlockItem> SAPROLITE_COAL_ORE =                ITEMS.registerSimpleBlockItem("saprolite_coal_ore",            BlockRegistration.SAPROLITE_COAL_ORE);
    //public static final DeferredItem<BlockItem> LATERITE_COAL_ORE =                 ITEMS.registerSimpleBlockItem("laterite_coal_ore",             BlockRegistration.LATERITE_COAL_ORE);
    //public static final DeferredItem<BlockItem> GREYWACKE_COAL_ORE =                new VanillaDeferredItem<>(Items.COAL_ORE);
    //public static final DeferredItem<BlockItem> SILTSTONE_COAL_ORE =                ITEMS.registerSimpleBlockItem("siltstone_coal_ore",            BlockRegistration.SILTSTONE_COAL_ORE);
    //public static final DeferredItem<BlockItem> DOLOSTONE_COAL_ORE =                ITEMS.registerSimpleBlockItem("dolostone_coal_ore",            BlockRegistration.DOLOSTONE_COAL_ORE);
    //public static final DeferredItem<BlockItem> LIMESTONE_COAL_ORE =                ITEMS.registerSimpleBlockItem("limestone_coal_ore",            BlockRegistration.LIMESTONE_COAL_ORE);
    //public static final DeferredItem<BlockItem> CHALK_COAL_ORE =                    ITEMS.registerSimpleBlockItem("chalk_coal_ore",                BlockRegistration.CHALK_COAL_ORE);
    //public static final DeferredItem<BlockItem> IRONSTONE_COAL_ORE =                ITEMS.registerSimpleBlockItem("ironstone_coal_ore",            BlockRegistration.IRONSTONE_COAL_ORE);
    //public static final DeferredItem<BlockItem> SHALE_COAL_ORE =                    ITEMS.registerSimpleBlockItem("shale_coal_ore",                BlockRegistration.SHALE_COAL_ORE);
    //public static final DeferredItem<BlockItem> ARKOSE_COAL_ORE =                   ITEMS.registerSimpleBlockItem("arkose_coal_ore",               BlockRegistration.ARKOSE_COAL_ORE);
    //public static final DeferredItem<BlockItem> MARBLE_COAL_ORE =                   ITEMS.registerSimpleBlockItem("marble_coal_ore",               BlockRegistration.MARBLE_COAL_ORE);
    //public static final DeferredItem<BlockItem> QUARTZITE_COAL_ORE =                ITEMS.registerSimpleBlockItem("quartzite_coal_ore",            BlockRegistration.QUARTZITE_COAL_ORE);
    //public static final DeferredItem<BlockItem> HORNFELS_COAL_ORE =                 ITEMS.registerSimpleBlockItem("hornfels_coal_ore",             BlockRegistration.HORNFELS_COAL_ORE);
    //public static final DeferredItem<BlockItem> SLATE_COAL_ORE =                    ITEMS.registerSimpleBlockItem("slate_coal_ore",                BlockRegistration.SLATE_COAL_ORE);
    //// DIAMOND ORE
    //public static final DeferredItem<BlockItem> GABBRO_DIAMOND_ORE =                new VanillaDeferredItem<>(Items.DEEPSLATE_DIAMOND_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_DIORITE_DIAMOND_ORE =        ITEMS.registerSimpleBlockItem("smooth_diorite_diamond_ore",    BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_GRANITE_DIAMOND_ORE =        ITEMS.registerSimpleBlockItem("smooth_granite_diamond_ore",    BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE);
    //public static final DeferredItem<BlockItem> NORITE_DIAMOND_ORE =                ITEMS.registerSimpleBlockItem("norite_diamond_ore",            BlockRegistration.NORITE_DIAMOND_ORE);
    //public static final DeferredItem<BlockItem> PERIDOTITE_DIAMOND_ORE =            ITEMS.registerSimpleBlockItem("peridotite_diamond_ore",        BlockRegistration.PERIDOTITE_DIAMOND_ORE);
    //public static final DeferredItem<BlockItem> ANDESITE_DIAMOND_ORE =              ITEMS.registerSimpleBlockItem("andesite_diamond_ore",          BlockRegistration.ANDESITE_DIAMOND_ORE);
    //public static final DeferredItem<BlockItem> BASALT_DIAMOND_ORE =                ITEMS.registerSimpleBlockItem("basalt_diamond_ore",            BlockRegistration.BASALT_DIAMOND_ORE);
    //// EMERALD ORE
    //public static final DeferredItem<BlockItem> GABBRO_EMERALD_ORE =                new VanillaDeferredItem<>(Items.DEEPSLATE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_DIORITE_EMERALD_ORE =        ITEMS.registerSimpleBlockItem("smooth_diorite_emerald_ore",    BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_GRANITE_EMERALD_ORE =        ITEMS.registerSimpleBlockItem("smooth_granite_emerald_ore",    BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> NORITE_EMERALD_ORE =                ITEMS.registerSimpleBlockItem("norite_emerald_ore",            BlockRegistration.NORITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> PERIDOTITE_EMERALD_ORE =            ITEMS.registerSimpleBlockItem("peridotite_emerald_ore",        BlockRegistration.PERIDOTITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> RHYOLITE_EMERALD_ORE =              ITEMS.registerSimpleBlockItem("rhyolite_emerald_ore",          BlockRegistration.RHYOLITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> DACITE_EMERALD_ORE =                ITEMS.registerSimpleBlockItem("dacite_emerald_ore",            BlockRegistration.DACITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> ANDESITE_EMERALD_ORE =              ITEMS.registerSimpleBlockItem("andesite_emerald_ore",          BlockRegistration.ANDESITE_EMERALD_ORE);
    //public static final DeferredItem<BlockItem> BASALT_EMERALD_ORE =                ITEMS.registerSimpleBlockItem("basalt_emerald_ore",            BlockRegistration.BASALT_EMERALD_ORE);
    //// LAPIS ORE
    //public static final DeferredItem<BlockItem> MARBLE_LAPIS_ORE =                  ITEMS.registerSimpleBlockItem("marble_lapis_ore",              BlockRegistration.MARBLE_LAPIS_ORE);
    //public static final DeferredItem<BlockItem> QUARTZITE_LAPIS_ORE =               ITEMS.registerSimpleBlockItem("quartzite_lapis_ore",           BlockRegistration.QUARTZITE_LAPIS_ORE);
    //public static final DeferredItem<BlockItem> HORNFELS_LAPIS_ORE =                ITEMS.registerSimpleBlockItem("hornfels_lapis_ore",            BlockRegistration.HORNFELS_LAPIS_ORE);
    //public static final DeferredItem<BlockItem> SLATE_LAPIS_ORE =                   ITEMS.registerSimpleBlockItem("slate_lapis_ore",               BlockRegistration.SLATE_LAPIS_ORE);
    //// REDSTONE ORE
    //public static final DeferredItem<BlockItem> GABBRO_REDSTONE_ORE =               new VanillaDeferredItem<>(Items.DEEPSLATE_REDSTONE_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_DIORITE_REDSTONE_ORE =       ITEMS.registerSimpleBlockItem("smooth_diorite_redstone_ore",   BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE);
    //public static final DeferredItem<BlockItem> SMOOTH_GRANITE_REDSTONE_ORE =       ITEMS.registerSimpleBlockItem("smooth_granite_redstone_ore",   BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE);
    //public static final DeferredItem<BlockItem> NORITE_REDSTONE_ORE =               ITEMS.registerSimpleBlockItem("norite_redstone_ore",           BlockRegistration.NORITE_REDSTONE_ORE);
    //public static final DeferredItem<BlockItem> PERIDOTITE_REDSTONE_ORE =           ITEMS.registerSimpleBlockItem("peridotite_redstone_ore",       BlockRegistration.PERIDOTITE_REDSTONE_ORE);
    //// CHERT ORE
    //public static final DeferredItem<BlockItem> LIMESTONE_CHERT_ORE =               ITEMS.registerSimpleBlockItem("limestone_chert_ore",           BlockRegistration.LIMESTONE_CHERT_ORE);
    //public static final DeferredItem<BlockItem> CHALK_CHERT_ORE =                   ITEMS.registerSimpleBlockItem("chalk_chert_ore",               BlockRegistration.CHALK_CHERT_ORE);
    //// GEODE ORE
    //public static final DeferredItem<BlockItem> BASALT_GEODE_ORE =                  ITEMS.registerSimpleBlockItem("basalt_geode_ore",              BlockRegistration.BASALT_GEODE_ORE);
    //public static final DeferredItem<BlockItem> ANDESITE_GEODE_ORE =                ITEMS.registerSimpleBlockItem("andesite_geode_ore",            BlockRegistration.ANDESITE_GEODE_ORE);
    //public static final DeferredItem<BlockItem> RHYOLITE_GEODE_ORE =                ITEMS.registerSimpleBlockItem("rhyolite_geode_ore",            BlockRegistration.RHYOLITE_GEODE_ORE);
    //public static final DeferredItem<BlockItem> DACITE_GEODE_ORE =                  ITEMS.registerSimpleBlockItem("dacite_geode_ore",              BlockRegistration.DACITE_GEODE_ORE);
    //// COBBLED
    //public static final DeferredItem<BlockItem> COBBLED_SOFT_TUFF =                 ITEMS.registerSimpleBlockItem("cobbled_soft_tuff",             BlockRegistration.COBBLED_SOFT_TUFF);
    //public static final DeferredItem<BlockItem> COBBLED_IGNIMBRITE =                ITEMS.registerSimpleBlockItem("cobbled_ignimbrite",            BlockRegistration.COBBLED_IGNIMBRITE);
    //public static final DeferredItem<BlockItem> COBBLED_LAPILLISTONE =              ITEMS.registerSimpleBlockItem("cobbled_lapillistone",          BlockRegistration.COBBLED_LAPILLISTONE);
    //public static final DeferredItem<BlockItem> COBBLED_WELDED_TUFF =               ITEMS.registerSimpleBlockItem("cobbled_welded_tuff",           BlockRegistration.COBBLED_WELDED_TUFF);
    //public static final DeferredItem<BlockItem> COBBLED_RED_SANDSTONE =             ITEMS.registerSimpleBlockItem("cobbled_red_sandstone",         BlockRegistration.COBBLED_RED_SANDSTONE);
    //public static final DeferredItem<BlockItem> COBBLED_SAPROLITE =                 ITEMS.registerSimpleBlockItem("cobbled_saprolite",             BlockRegistration.COBBLED_SAPROLITE);
    //public static final DeferredItem<BlockItem> COBBLED_LATERITE =                  ITEMS.registerSimpleBlockItem("cobbled_laterite",              BlockRegistration.COBBLED_LATERITE);
    //public static final DeferredItem<BlockItem> COBBLED_GREYWACKE =                 new VanillaDeferredItem<>(Items.COBBLESTONE);
    //public static final DeferredItem<BlockItem> COBBLED_SILTSTONE =                 ITEMS.registerSimpleBlockItem("cobbled_siltstone",             BlockRegistration.COBBLED_SILTSTONE);
    //public static final DeferredItem<BlockItem> COBBLED_DOLOSTONE =                 ITEMS.registerSimpleBlockItem("cobbled_dolostone",             BlockRegistration.COBBLED_DOLOSTONE);
    //public static final DeferredItem<BlockItem> COBBLED_LIMESTONE =                 ITEMS.registerSimpleBlockItem("cobbled_limestone",             BlockRegistration.COBBLED_LIMESTONE);
    //public static final DeferredItem<BlockItem> COBBLED_CHALK =                     ITEMS.registerSimpleBlockItem("cobbled_chalk",                 BlockRegistration.COBBLED_CHALK);
    //public static final DeferredItem<BlockItem> COBBLED_IRONSTONE =                 ITEMS.registerSimpleBlockItem("cobbled_ironstone",             BlockRegistration.COBBLED_IRONSTONE);
    //public static final DeferredItem<BlockItem> COBBLED_SHALE =                     ITEMS.registerSimpleBlockItem("cobbled_shale",                 BlockRegistration.COBBLED_SHALE);
    //public static final DeferredItem<BlockItem> COBBLED_ARKOSE =                    ITEMS.registerSimpleBlockItem("cobbled_arkose",                BlockRegistration.COBBLED_ARKOSE);
    //// ROCK PROPERTIES
    //private static final Item.Properties ROCK_PROPERTIES =                          new Item.Properties().durability(20);
    ////ROCK
    //public static final DeferredItem<RockBlockItem> SANDSTONE_ROCK =                registerBlockItem("sandstone_rock",         RockBlockItem::new,     BlockRegistration.SANDSTONE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> RED_SANDSTONE_ROCK =            registerBlockItem("red_sandstone_rock",     RockBlockItem::new,     BlockRegistration.RED_SANDSTONE_ROCK,   ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SAPROLITE_ROCK =                registerBlockItem("saprolite_rock",         RockBlockItem::new,     BlockRegistration.SAPROLITE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> LATERITE_ROCK =                 registerBlockItem("laterite_rock",          RockBlockItem::new,     BlockRegistration.LATERITE_ROCK,        ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SILT_CLUMP =                    registerBlockItem("silt_clump",             RockBlockItem::new,     BlockRegistration.SILT_CLUMP,           ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> GREYWACKE_ROCK =                registerBlockItem("greywacke_rock",         RockBlockItem::new,     BlockRegistration.GREYWACKE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SILTSTONE_ROCK =                registerBlockItem("siltstone_rock",         RockBlockItem::new,     BlockRegistration.SILTSTONE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> DOLOSTONE_ROCK =                registerBlockItem("dolostone_rock",         RockBlockItem::new,     BlockRegistration.DOLOSTONE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> LIMESTONE_ROCK =                registerBlockItem("limestone_rock",         RockBlockItem::new,     BlockRegistration.LIMESTONE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> IRONSTONE_ROCK =                registerBlockItem("ironstone_rock",         RockBlockItem::new,     BlockRegistration.IRONSTONE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SHALE_ROCK =                    registerBlockItem("shale_rock",             RockBlockItem::new,     BlockRegistration.SHALE_ROCK,           ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> ARKOSE_ROCK =                   registerBlockItem("arkose_rock",            RockBlockItem::new,     BlockRegistration.ARKOSE_ROCK,          ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> MARBLE_ROCK =                   registerBlockItem("marble_rock",            RockBlockItem::new,     BlockRegistration.MARBLE_ROCK,          ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> QUARTZITE_ROCK =                registerBlockItem("quartzite_rock",         RockBlockItem::new,     BlockRegistration.QUARTZITE_ROCK,       ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> HORNFELS_ROCK =                 registerBlockItem("hornfels_rock",          RockBlockItem::new,     BlockRegistration.HORNFELS_ROCK,        ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SLATE_ROCK =                    registerBlockItem("slate_rock",             RockBlockItem::new,     BlockRegistration.SLATE_ROCK,           ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> GABBRO_ROCK =                   registerBlockItem("gabbro_rock",            RockBlockItem::new,     BlockRegistration.GABBRO_ROCK,          ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SMOOTH_DIORITE_ROCK =           registerBlockItem("smooth_diorite_rock",    RockBlockItem::new,     BlockRegistration.SMOOTH_DIORITE_ROCK,  ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> SMOOTH_GRANITE_ROCK =           registerBlockItem("smooth_granite_rock",    RockBlockItem::new,     BlockRegistration.SMOOTH_GRANITE_ROCK,  ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> NORITE_ROCK =                   registerBlockItem("norite_rock",            RockBlockItem::new,     BlockRegistration.NORITE_ROCK,          ROCK_PROPERTIES);
    //public static final DeferredItem<RockBlockItem> PERIDOTITE_ROCK =               registerBlockItem("peridotite_rock",        RockBlockItem::new,     BlockRegistration.PERIDOTITE_ROCK,      ROCK_PROPERTIES);
    //// LARGE ROCK
    //public static final DeferredItem<BlockItem> LARGE_SANDSTONE_ROCK =              ITEMS.registerSimpleBlockItem("large_sandstone_rock",          BlockRegistration.LARGE_SANDSTONE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_RED_SANDSTONE_ROCK =          ITEMS.registerSimpleBlockItem("large_red_sandstone_rock",      BlockRegistration.LARGE_RED_SANDSTONE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SAPROLITE_ROCK =              ITEMS.registerSimpleBlockItem("large_saprolite_rock",          BlockRegistration.LARGE_SAPROLITE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_LATERITE_ROCK =               ITEMS.registerSimpleBlockItem("large_laterite_rock",           BlockRegistration.LARGE_LATERITE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SILT_CLUMP =                  ITEMS.registerSimpleBlockItem("large_silt_clump",              BlockRegistration.LARGE_SILT_CLUMP);
    //public static final DeferredItem<BlockItem> LARGE_GREYWACKE_ROCK =              ITEMS.registerSimpleBlockItem("large_greywacke_rock",          BlockRegistration.LARGE_GREYWACKE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SILTSTONE_ROCK =              ITEMS.registerSimpleBlockItem("large_siltstone_rock",          BlockRegistration.LARGE_SILTSTONE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_DOLOSTONE_ROCK =              ITEMS.registerSimpleBlockItem("large_dolostone_rock",          BlockRegistration.LARGE_DOLOSTONE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_LIMESTONE_ROCK =              ITEMS.registerSimpleBlockItem("large_limestone_rock",          BlockRegistration.LARGE_LIMESTONE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_IRONSTONE_ROCK =              ITEMS.registerSimpleBlockItem("large_ironstone_rock",          BlockRegistration.LARGE_IRONSTONE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SHALE_ROCK =                  ITEMS.registerSimpleBlockItem("large_shale_rock",              BlockRegistration.LARGE_SHALE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_ARKOSE_ROCK =                 ITEMS.registerSimpleBlockItem("large_arkose_rock",             BlockRegistration.LARGE_ARKOSE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_MARBLE_ROCK =                 ITEMS.registerSimpleBlockItem("large_marble_rock",             BlockRegistration.LARGE_MARBLE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_QUARTZITE_ROCK =              ITEMS.registerSimpleBlockItem("large_quartzite_rock",          BlockRegistration.LARGE_QUARTZITE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_HORNFELS_ROCK =               ITEMS.registerSimpleBlockItem("large_hornfels_rock",           BlockRegistration.LARGE_HORNFELS_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SLATE_ROCK =                  ITEMS.registerSimpleBlockItem("large_slate_rock",              BlockRegistration.LARGE_SLATE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_GABBRO_ROCK =                 ITEMS.registerSimpleBlockItem("large_gabbro_rock",             BlockRegistration.LARGE_GABBRO_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SMOOTH_DIORITE_ROCK =         ITEMS.registerSimpleBlockItem("large_smooth_diorite_rock",     BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_SMOOTH_GRANITE_ROCK =         ITEMS.registerSimpleBlockItem("large_smooth_granite_rock",     BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_NORITE_ROCK =                 ITEMS.registerSimpleBlockItem("large_norite_rock",             BlockRegistration.LARGE_NORITE_ROCK);
    //public static final DeferredItem<BlockItem> LARGE_PERIDOTITE_ROCK =             ITEMS.registerSimpleBlockItem("large_peridotite_rock",         BlockRegistration.LARGE_PERIDOTITE_ROCK);
    //// COPPER ROCK
    //public static final DeferredItem<BlockItem> SAPROLITE_ROCK_COPPER_ORE =         ITEMS.registerSimpleBlockItem("saprolite_rock_copper_ore",     BlockRegistration.SAPROLITE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> GREYWACKE_ROCK_COPPER_ORE =         ITEMS.registerSimpleBlockItem("greywacke_rock_copper_ore",     BlockRegistration.GREYWACKE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> SILTSTONE_ROCK_COPPER_ORE =         ITEMS.registerSimpleBlockItem("siltstone_rock_copper_ore",     BlockRegistration.SILTSTONE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> DOLOSTONE_ROCK_COPPER_ORE =         ITEMS.registerSimpleBlockItem("dolostone_rock_copper_ore",     BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> LIMESTONE_ROCK_COPPER_ORE =         ITEMS.registerSimpleBlockItem("limestone_rock_copper_ore",     BlockRegistration.LIMESTONE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> CHALK_ROCK_COPPER_ORE =             ITEMS.registerSimpleBlockItem("chalk_rock_copper_ore",         BlockRegistration.CHALK_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> IRONSTONE_ROCK_COPPER_ORE =         ITEMS.registerSimpleBlockItem("ironstone_rock_copper_ore",     BlockRegistration.IRONSTONE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> SHALE_ROCK_COPPER_ORE =             ITEMS.registerSimpleBlockItem("shale_rock_copper_ore",         BlockRegistration.SHALE_ROCK_COPPER_ORE);
    //public static final DeferredItem<BlockItem> ARKOSE_ROCK_COPPER_ORE =            ITEMS.registerSimpleBlockItem("arkose_rock_copper_ore",        BlockRegistration.ARKOSE_ROCK_COPPER_ORE);
    //// BRANCH
    //public static final DeferredItem<BlockItem> BIRCH_BRANCH =                      ITEMS.registerSimpleBlockItem("birch_branch",                  BlockRegistration.BIRCH_BRANCH);
    //public static final DeferredItem<BlockItem> OAK_BRANCH =                        ITEMS.registerSimpleBlockItem("oak_branch",                    BlockRegistration.OAK_BRANCH);
    //public static final DeferredItem<BlockItem> SPRUCE_BRANCH =                     ITEMS.registerSimpleBlockItem("spruce_branch",                 BlockRegistration.SPRUCE_BRANCH);
    //public static final DeferredItem<BlockItem> JUNGLE_BRANCH =                     ITEMS.registerSimpleBlockItem("jungle_branch",                 BlockRegistration.JUNGLE_BRANCH);
    //public static final DeferredItem<BlockItem> DARK_OAK_BRANCH =                   ITEMS.registerSimpleBlockItem("dark_oak_branch",               BlockRegistration.DARK_OAK_BRANCH);
    //public static final DeferredItem<BlockItem> ACACIA_BRANCH =                     ITEMS.registerSimpleBlockItem("acacia_branch",                 BlockRegistration.ACACIA_BRANCH);
    //public static final DeferredItem<BlockItem> CHERRY_BRANCH =                     ITEMS.registerSimpleBlockItem("cherry_branch",                 BlockRegistration.CHERRY_BRANCH);
    //public static final DeferredItem<BlockItem> MANGROVE_BRANCH =                   ITEMS.registerSimpleBlockItem("mangrove_branch",               BlockRegistration.MANGROVE_BRANCH);
    //// PLANT
    //public static final DeferredItem<BlockItem> SHRUB =                             ITEMS.registerSimpleBlockItem("shrub",                         BlockRegistration.SHRUB);
    //endregion == WORLD ==

    //region == METAL WORKING ==
    public static final DeferredItem<Item> RAW_TIN = ITEMS.registerSimpleItem("raw_tin");
    public static final DeferredItem<Item> COPPER_ORE_DUST = ITEMS.registerSimpleItem("copper_ore_dust"); // malachite > azurite
    public static final DeferredItem<Item> TIN_ORE_DUST = ITEMS.registerSimpleItem("tin_ore_dust"); // Cassiterite
    public static final DeferredItem<Item> IRON_ORE_DUST = ITEMS.registerSimpleItem("iron_ore_dust"); // hematite > magnetite
    //endregion

    //region == FARMING ==
    public static final DeferredItem<Item> BARLEY =                     ITEMS.registerSimpleItem("barley",          new Item.Properties());
    public static final DeferredItem<Item> BARLEY_SEEDS =               ITEMS.registerSimpleItem("barley_seeds",    new Item.Properties());
    public static final DeferredItem<Item> BEETROOT =                   new VanillaDeferredItem<>(Items.BEETROOT);
    public static final DeferredItem<Item> BLUEBERRIES =                ITEMS.registerSimpleItem("blueberries",     new Item.Properties().food(FoodCatalog.BLUEBERRIES));
    public static final DeferredItem<Item> BROAD_BEAN =                 ITEMS.registerSimpleItem("broad_bean",      new Item.Properties().food(FoodCatalog.BROAD_BEAN));
    public static final DeferredItem<Item> CABBAGE =                    ITEMS.registerSimpleItem("cabbage",         new Item.Properties().food(FoodCatalog.CABBAGE));
    public static final DeferredItem<Item> CARROT =                     new VanillaDeferredItem<>(Items.CARROT);
    public static final DeferredItem<Item> CHARD =                      ITEMS.registerSimpleItem("chard",           new Item.Properties().food(FoodCatalog.CHARD));
    public static final DeferredItem<BlockItem> DOGBANE =               ITEMS.registerSimpleBlockItem("dogbane",    BlockRegistration.DOGBANE);
    public static final DeferredItem<Item> FLAX =                       ITEMS.registerSimpleItem("flax",            new Item.Properties());
    public static final DeferredItem<Item> FLAX_SEEDS =                 ITEMS.registerSimpleItem("flax_seeds",      new Item.Properties());
    public static final DeferredItem<Item> GARLIC =                     ITEMS.registerSimpleItem("garlic",          new Item.Properties().food(FoodCatalog.GARLIC));
    public static final DeferredItem<Item> LEEK =                       ITEMS.registerSimpleItem("leek",            new Item.Properties().food(FoodCatalog.LEEK));
    public static final DeferredItem<Item> MELON =                      new VanillaDeferredItem<>(Items.MELON);
    public static final DeferredItem<Item> MELON_SLICE =                new VanillaDeferredItem<>(Items.MELON_SLICE);
    public static final DeferredItem<Item> NAPA_CABBAGE =               ITEMS.registerSimpleItem("napa_cabbage",    new Item.Properties().food(FoodCatalog.NAPA_CABBAGE));
    public static final DeferredItem<Item> NETTLE =                     ITEMS.registerSimpleItem("nettle",          new Item.Properties().food(FoodCatalog.NETTLE));
    public static final DeferredItem<Item> OAT_SEEDS =                  ITEMS.registerSimpleItem("oat_seeds",       new Item.Properties());
    public static final DeferredItem<Item> OATS =                       ITEMS.registerSimpleItem("oats",            new Item.Properties());
    public static final DeferredItem<Item> PARSNIP =                    ITEMS.registerSimpleItem("parsnip",         new Item.Properties().food(FoodCatalog.PARSNIP));
    public static final DeferredItem<Item> POTATO =                     new VanillaDeferredItem<>(Items.POTATO);
    public static final DeferredItem<Item> PUMPKIN =                    new VanillaDeferredItem<>(Items.PUMPKIN);
    public static final DeferredItem<BlockItem> GREEN_PUMPKIN =         ITEMS.registerSimpleBlockItem(BlockRegistration.GREEN_PUMPKIN,  new Item.Properties());
    public static final DeferredItem<Item> PURPLE_CARROT =              ITEMS.registerSimpleItem("purple_carrot",   new Item.Properties().food(FoodCatalog.PURPLE_CARROT));
    public static final DeferredItem<Item> PURPLE_ONION =               ITEMS.registerSimpleItem("purple_onion",    new Item.Properties().food(FoodCatalog.PURPLE_ONION));
    public static final DeferredItem<Item> PURPLE_SKIRRET =             ITEMS.registerSimpleItem("purple_skirret",  new Item.Properties().food(FoodCatalog.PURPLE_SKIRRET));
    public static final DeferredItem<Item> RADISH =                     ITEMS.registerSimpleItem("radish",          new Item.Properties().food(FoodCatalog.RADISH));
    public static final DeferredItem<Item> RASPBERRIES =                ITEMS.registerSimpleItem("raspberries",     new Item.Properties().food(FoodCatalog.RASPBERRIES));
    public static final DeferredItem<Item> SKIRRET =                    ITEMS.registerSimpleItem("skirret",         new Item.Properties().food(FoodCatalog.SKIRRET));
    public static final DeferredItem<Item> SPINACH =                    ITEMS.registerSimpleItem("spinach",         new Item.Properties().food(FoodCatalog.SPINACH));
    public static final DeferredItem<Item> STRAWBERRIES =               ITEMS.registerSimpleItem("strawberries",    new Item.Properties().food(FoodCatalog.STRAWBERRIES));
    public static final DeferredItem<Item> TURNIP =                     ITEMS.registerSimpleItem("turnip",          new Item.Properties().food(FoodCatalog.TURNIP));
    public static final DeferredItem<Item> WHITE_CARROT =               ITEMS.registerSimpleItem("white_carrot",    new Item.Properties().food(FoodCatalog.WHITE_CARROT));
    public static final DeferredItem<Item> WHITE_ONION =                ITEMS.registerSimpleItem("white_onion",     new Item.Properties().food(FoodCatalog.WHITE_ONION));
    public static final DeferredItem<BlockItem> YAM =                   ITEMS.registerItem("yam",                   props -> new ItemNameBlockItem(BlockRegistration.YAMS.get(), new Item.Properties().food(FoodCatalog.YAM)));
    //endregion

    // leaf litter
    // thatch

    //region == COOKING ==
    public static final DeferredItem<Item> BAKED_BEETROOT =             ITEMS.registerSimpleItem("baked_beetroot", new Item.Properties().food(FoodCatalog.BAKED_BEETROOT));
    public static final DeferredItem<Item> BAKED_CARROT =               ITEMS.registerSimpleItem("baked_carrot", new Item.Properties().food(FoodCatalog.BAKED_CARROT));
    public static final DeferredItem<Item> BAKED_GARLIC =               ITEMS.registerSimpleItem("baked_garlic", new Item.Properties().food(FoodCatalog.BAKED_GARLIC));
    public static final DeferredItem<Item> BAKED_LEEK =                 ITEMS.registerSimpleItem("baked_leek", new Item.Properties().food(FoodCatalog.BAKED_LEEK));
    public static final DeferredItem<Item> BAKED_PARSNIP =              ITEMS.registerSimpleItem("baked_parsnip", new Item.Properties().food(FoodCatalog.BAKED_PARSNIP));
    public static final DeferredItem<Item> PUMPKIN_SLICE =              ITEMS.registerSimpleItem("pumpkin_slice",   new Item.Properties().food(FoodCatalog.PUMPKIN_SLICE));
    public static final DeferredItem<Item> GREEN_PUMPKIN_SLICE =        ITEMS.registerSimpleItem("green_pumpkin_slice",   new Item.Properties().food(FoodCatalog.PUMPKIN_SLICE));
    public static final DeferredItem<Item> BAKED_PUMPKIN =              ITEMS.registerSimpleItem("baked_pumpkin", new Item.Properties());
    public static final DeferredItem<Item> BAKED_GREEN_PUMPKIN =        ITEMS.registerSimpleItem("baked_green_pumpkin", new Item.Properties());
    public static final DeferredItem<Item> BAKED_PUMPKIN_SLICE =        ITEMS.registerSimpleItem("baked_pumpkin_slice", new Item.Properties().food(FoodCatalog.BAKED_PUMPKIN_SLICE));
    public static final DeferredItem<Item> BAKED_GREEN_PUMPKIN_SLICE =  ITEMS.registerSimpleItem("baked_green_pumpkin_slice", new Item.Properties().food(FoodCatalog.BAKED_PUMPKIN_SLICE));
    public static final DeferredItem<Item> BAKED_PURPLE_CARROT =        ITEMS.registerSimpleItem("baked_purple_carrot", new Item.Properties().food(FoodCatalog.BAKED_PURPLE_CARROT));
    public static final DeferredItem<Item> BAKED_PURPLE_ONION =         ITEMS.registerSimpleItem("baked_purple_onion", new Item.Properties().food(FoodCatalog.BAKED_PURPLE_ONION));
    public static final DeferredItem<Item> BAKED_PURPLE_SKIRRET =       ITEMS.registerSimpleItem("baked_purple_skirret", new Item.Properties().food(FoodCatalog.BAKED_PURPLE_SKIRRET));
    public static final DeferredItem<Item> BAKED_RADISH =               ITEMS.registerSimpleItem("baked_radish", new Item.Properties().food(FoodCatalog.BAKED_RADISH));
    public static final DeferredItem<Item> BAKED_SKIRRET =              ITEMS.registerSimpleItem("baked_skirret", new Item.Properties().food(FoodCatalog.BAKED_SKIRRET));
    public static final DeferredItem<Item> BAKED_TURNIP =               ITEMS.registerSimpleItem("baked_turnip", new Item.Properties().food(FoodCatalog.BAKED_TURNIP));
    public static final DeferredItem<Item> BAKED_WHITE_CARROT =         ITEMS.registerSimpleItem("baked_white_carrot", new Item.Properties().food(FoodCatalog.BAKED_WHITE_CARROT));
    public static final DeferredItem<Item> BAKED_WHITE_ONION =          ITEMS.registerSimpleItem("baked_white_onion", new Item.Properties().food(FoodCatalog.BAKED_WHITE_ONION));
    public static final DeferredItem<Item> BAKED_YAM =                  ITEMS.registerSimpleItem("baked_yam", new Item.Properties().food(FoodCatalog.BAKED_YAM));
    public static final DeferredItem<Item> CRACKED_BARLEY =             ITEMS.registerSimpleItem("cracked_barley", new Item.Properties());
    public static final DeferredItem<Item> CRACKED_WHEAT =              ITEMS.registerSimpleItem("cracked_wheat", new Item.Properties());
    public static final DeferredItem<Item> ROLLED_OATS =                ITEMS.registerSimpleItem("rolled_oats", new Item.Properties());
    public static final DeferredItem<Item> FLOUR =                      ITEMS.registerSimpleItem("flour", new Item.Properties());
    public static final DeferredItem<Item> DOUGH =                      ITEMS.registerSimpleItem("dough", new Item.Properties());
    //endregion

    //region == WEAVING ==
    public static final DeferredItem<Item> FLAX_FIBER = ITEMS.registerSimpleItem("flax_fiber", new Item.Properties());
    //endregion

    //region == WOOD WORKING ==
    public static final DeferredItem<Item> DIGGING_STICK = ITEMS.registerSimpleItem("digging_stick", new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> FIRE_STARTER = ITEMS.registerItem("fire_starter", FireStarterItem::new, new Item.Properties().durability(64).setNoRepair());
    public static final DeferredItem<Item> WHITE_BARK = ITEMS.registerSimpleItem("white_bark"); // Birch, mangrove
    public static final DeferredItem<Item> BROWN_BARK = ITEMS.registerSimpleItem("brown_bark"); //cherry, spruce, jungle
    public static final DeferredItem<Item> GREY_BARK = ITEMS.registerSimpleItem("grey_bark"); // Acacia
    public static final DeferredItem<Item> DARK_BROWN_BARK = ITEMS.registerSimpleItem("dark_brown_bark"); // Oak
    public static final DeferredItem<Item> BLACK_BARK = ITEMS.registerSimpleItem("black_bark"); // Dark Oak
    public static final DeferredItem<Item> CHARCOAL_POWDER = ITEMS.registerSimpleItem("charcoal_powder");
    public static final DeferredItem<Item> POTASH = ITEMS.registerSimpleItem("potash"); // (Leaching) soluable part of wood ash, evaporated/boiled + NaCO3 (Soda Ash), CaCO3, MgCO3, Potassium Sulfate, CaSO4
    public static final DeferredItem<Item> TOOL_HANDLE = ITEMS.registerSimpleItem("tool_handle", new Item.Properties());
    //endregion

    //region == KNAPPING ==
    public static final DeferredItem<Item> BROKEN_GOAT_HORN = ITEMS.registerSimpleItem("broken_goat_horn", new Item.Properties());
    @Deprecated
    public static final DeferredItem<Item> LUNATE = ITEMS.registerSimpleItem("lunate", new Item.Properties());

    public static final DeferredItem<Item> ANTLER =                 ITEMS.registerSimpleItem("antler", new Item.Properties());

    public static final DeferredItem<Item> ROCK_KNIFE_BLADE =       ITEMS.registerSimpleItem("rock_knife_blade", new Item.Properties());
    public static final DeferredItem<Item> FLINT_KNIFE_BLADE =      ITEMS.registerSimpleItem("flint_knife_blade", new Item.Properties());
    public static final DeferredItem<Item> BONE_KNIFE_BLADE =       ITEMS.registerSimpleItem("bone_knife_blade", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE =             ITEMS.registerItem("rock_knife", props -> new KnifeItem(MedievalismTiers.ROCK, props), new Item.Properties().component(DataComponents.TOOL, KnifeItem.createToolProperties()));
    public static final DeferredItem<Item> FLINT_KNIFE =            ITEMS.registerItem("flint_knife", props -> new KnifeItem(MedievalismTiers.FLINT, props), new Item.Properties().component(DataComponents.TOOL, KnifeItem.createToolProperties()));
    public static final DeferredItem<Item> BONE_KNIFE =             ITEMS.registerItem("bone_knife", props -> new KnifeItem(MedievalismTiers.BONE, props), new Item.Properties().component(DataComponents.TOOL, KnifeItem.createToolProperties()));

    public static final DeferredItem<Item> ROCK_AXE_HEAD =          ITEMS.registerSimpleItem("rock_axe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_AXE =               ITEMS.registerItem("rock_axe", props -> new AxeItem(MedievalismTiers.ROCK, props), new Item.Properties());

    public static final DeferredItem<Item> ROCK_PICKAXE_HEAD =      ITEMS.registerSimpleItem("rock_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> ANTLER_PICKAXE_HEAD =    ITEMS.registerSimpleItem("antler_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE =           ITEMS.registerItem("rock_pickaxe", props -> new PickaxeItem(MedievalismTiers.ROCK, props), new Item.Properties());
    public static final DeferredItem<Item> ANTLER_PICKAXE =         ITEMS.registerItem("antler_pickaxe", props -> new PickaxeItem(MedievalismTiers.BONE, props), new Item.Properties());

    public static final DeferredItem<Item> ROCK_HOE_HEAD =          ITEMS.registerSimpleItem("rock_hoe_head", new Item.Properties());
    public static final DeferredItem<Item> ANTLER_HOE_HEAD =        ITEMS.registerSimpleItem("antler_hoe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_HOE =               ITEMS.registerItem("rock_hoe", props -> new HoeItem(MedievalismTiers.ROCK, props), new Item.Properties());
    public static final DeferredItem<Item> ANTLER_HOE =             ITEMS.registerItem("antler_hoe", props -> new HoeItem(MedievalismTiers.BONE, props), new Item.Properties());

    public static final DeferredItem<Item> ROCK_SPEAR_HEAD =        ITEMS.registerSimpleItem("rock_spear_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR =             ITEMS.registerItem("rock_spear", props -> new SpearItem(MedievalismTiers.ROCK, props), new Item.Properties().attributes(SpearItem.createAttributes()).component(DataComponents.TOOL, SpearItem.createToolProperties()));
    // Flint and Bone Spear

    public static final DeferredItem<Item> ROCK_SICKLE =            ITEMS.registerItem("rock_sickle", props -> new SickleItem(MedievalismTiers.ROCK, props), new Item.Properties().component(DataComponents.TOOL, SickleItem.createToolProperties()));

    //endregion

    //region == LEATHER WORKING ==
    public static final DeferredItem<Item> BAT_HIDE = ITEMS.registerSimpleItem("bat_hide", new Item.Properties());
    public static final DeferredItem<Item> CAMEL_HIDE = ITEMS.registerSimpleItem("camel_hide", new Item.Properties());
    public static final DeferredItem<Item> CAT_HIDE = ITEMS.registerSimpleItem("cat_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> COW_HIDE = ITEMS.registerSimpleItem("cow_hide", new Item.Properties());
    public static final DeferredItem<Item> DONKEY_HIDE = ITEMS.registerSimpleItem("donkey_hide", new Item.Properties());
    public static final DeferredItem<Item> FOX_HIDE = ITEMS.registerSimpleItem("fox_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> GOAT_HIDE = ITEMS.registerSimpleItem("goat_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> HOGLIN_HIDE = ITEMS.registerSimpleItem("hoglin_hide", new Item.Properties());
    public static final DeferredItem<Item> HORSE_HIDE = ITEMS.registerSimpleItem("horse_hide", new Item.Properties());
    public static final DeferredItem<Item> LLAMA_HIDE = ITEMS.registerSimpleItem("llama_hide", new Item.Properties());
    public static final DeferredItem<Item> MOOSHROOM_HIDE = ITEMS.registerSimpleItem("mooshroom_hide", new Item.Properties());
    public static final DeferredItem<Item> MULE_HIDE = ITEMS.registerSimpleItem("mule_hide", new Item.Properties());
    public static final DeferredItem<Item> OCELOT_HIDE = ITEMS.registerSimpleItem("ocelot_hide", new Item.Properties());
    public static final DeferredItem<Item> PANDA_HIDE = ITEMS.registerSimpleItem("panda_hide", new Item.Properties());
    public static final DeferredItem<Item> PIG_HIDE = ITEMS.registerSimpleItem("pig_hide", new Item.Properties());
    public static final DeferredItem<Item> POLAR_BEAR_HIDE = ITEMS.registerSimpleItem("polar_bear_hide", new Item.Properties());
    public static final DeferredItem<Item> RABBIT_HIDE = new VanillaDeferredItem<>(Items.RABBIT_HIDE);
    public static final DeferredItem<Item> RAVAGER_HIDE = ITEMS.registerSimpleItem("ravager_hide", new Item.Properties());
    public static final DeferredItem<Item> SHEEP_HIDE = ITEMS.registerSimpleItem("sheep_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> SNIFFER_HIDE = ITEMS.registerSimpleItem("sniffer_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> SNOW_FOX_HIDE = ITEMS.registerSimpleItem("snow_fox_hide", new Item.Properties());
    public static final DeferredItem<Item> WOLF_HIDE = ITEMS.registerSimpleItem("wolf_hide", new Item.Properties()); // White
    public static final DeferredItem<Item> LARGE_LIMED_HIDE = ITEMS.registerSimpleItem("large_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_LIMED_HIDE = ITEMS.registerSimpleItem("medium_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> SMALL_LIMED_HIDE = ITEMS.registerSimpleItem("small_limed_hide", new Item.Properties());
    public static final DeferredItem<Item> LARGE_RAW_HIDE = ITEMS.registerSimpleItem("large_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_RAW_HIDE = ITEMS.registerSimpleItem("medium_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> SMALL_RAW_HIDE = ITEMS.registerSimpleItem("small_raw_hide", new Item.Properties());
    public static final DeferredItem<Item> LARGE_WET_LEATHER = ITEMS.registerSimpleItem("large_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> MEDIUM_WET_LEATHER = ITEMS.registerSimpleItem("medium_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> SMALL_WET_LEATHER = ITEMS.registerSimpleItem("small_wet_leather", new Item.Properties());
    public static final DeferredItem<Item> LARGE_LEATHER = new VanillaDeferredItem<>(Items.LEATHER);
    public static final DeferredItem<Item> MEDIUM_LEATHER = ITEMS.registerSimpleItem("medium_leather", new Item.Properties());
    public static final DeferredItem<Item> SMALL_LEATHER = ITEMS.registerSimpleItem("small_leather", new Item.Properties());
    //endregion

    // SORT ME
    public static final DeferredItem<Item> QUICK_LIME = ITEMS.registerSimpleItem("quicklime", new Item.Properties());
    public static final DeferredItem<Item> CHOPPED_WOOD = ITEMS.registerSimpleItem("chopped_wood", new Item.Properties());
    public static final DeferredItem<Item> SLACKED_LIME_BUCKET = ITEMS.registerSimpleItem("slacked_lime_bucket", new Item.Properties());
    public static final DeferredItem<Item> TANNIN_BUCKET = ITEMS.registerSimpleItem("tannin_bucket", new Item.Properties());
    public static final DeferredItem<Item> WOOD_ASH = ITEMS.registerSimpleItem("wood_ash"); // Order of concentraiton Potash(Potassiam Carbonate), CaCO3, CaO, MgCO3, Posphates and Silicates
    public static final DeferredItem<BlockItem> THATCH_BLOCK = ITEMS.registerSimpleBlockItem("thatch_block",                  BlockRegistration.THATCH_BLOCK);
    public static final DeferredItem<BlockItem> STONE_BENCH = ITEMS.registerSimpleBlockItem("stone_bench",                   BlockRegistration.STONE_BENCH);
    public static final DeferredItem<BlockItem> CHOPPING_BLOCK = ITEMS.registerSimpleBlockItem("chopping_block",                BlockRegistration.CHOPPING_BLOCK);
    public static final DeferredItem<BlockItem> THATCH = ITEMS.registerSimpleBlockItem("thatch",                        BlockRegistration.FIRE_LAY);


    //region Tools
    /*
    public static final DeferredItem<Item> ROCK_AXE = ITEMS.registerSimpleItem("rock_axe", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE = ITEMS.registerSimpleItem("rock_knife", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE = ITEMS.registerSimpleItem("rock_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SICKLE = ITEMS.registerSimpleItem("rock_sickle", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR = ITEMS.registerSimpleItem("rock_spear", new Item.Properties());

    public static final DeferredItem<Item> UNFIRED_AXE_MOULD = ITEMS.registerSimpleItem("unfired_axe_mould", new Item.Properties());
    public static final DeferredItem<Item> AXE_MOULD = ITEMS.registerSimpleItem("axe_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_INGOT_MOULD = ITEMS.registerSimpleItem("unfired_ingot_mould", new Item.Properties());
    public static final DeferredItem<Item> INGOT_MOULD = ITEMS.registerSimpleItem("ingot_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_KNIFE_MOULD = ITEMS.registerSimpleItem("unfired_knife_mould", new Item.Properties());
    public static final DeferredItem<Item> KNIFE_MOULD = ITEMS.registerSimpleItem("knife_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_SICKLE_MOULD = ITEMS.registerSimpleItem("unfired_sickle_mould", new Item.Properties());
    public static final DeferredItem<Item> SICKLE_MOULD = ITEMS.registerSimpleItem("sickle_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_SPEAR_MOULD = ITEMS.registerSimpleItem("unfired_spear_mould", new Item.Properties());
    public static final DeferredItem<Item> SPEAR_MOULD = ITEMS.registerSimpleItem("spear_mould", new Item.Properties());
    public static final DeferredItem<Item> UNFIRED_PICKAXE_MOULD = ITEMS.registerSimpleItem("unfired_pickaxe_mould", new Item.Properties());
    public static final DeferredItem<Item> PICKAXE_MOULD = ITEMS.registerSimpleItem("pickaxe_mould", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_HOE_MOULD = ITEMS.registerSimpleItem("unfired_hoe_mould", new Item.Properties());
    //public static final DeferredItem<Item> HOE_MOULD = ITEMS.registerSimpleItem("hoe_mould", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_SHOVEL_MOULD = ITEMS.registerSimpleItem("unfired_shovel_mould", new Item.Properties());
    //public static final DeferredItem<Item> SHOVEL_MOULD = ITEMS.registerSimpleItem("shovel_mould", new Item.Properties());
    //public static final DeferredItem<Item> UNFIRED_SWORD_MOULD = ITEMS.registerSimpleItem("unfired_sword_mould", new Item.Properties());
    //public static final DeferredItem<Item> SWORD_MOULD = ITEMS.registerSimpleItem("sword_mould", new Item.Properties());

    public static final DeferredItem<Item> COPPER_BLOOM = ITEMS.registerSimpleItem("copper_bloom", new Item.Properties());
    public static final DeferredItem<Item> IRON_BLOOM = ITEMS.registerSimpleItem("iron_bloom", new Item.Properties());
    public static final DeferredItem<Item> PIG_IRON = ITEMS.registerSimpleItem("pig_iron", new Item.Properties());
    public static final DeferredItem<Item> TIN_BLOOM = ITEMS.registerSimpleItem("tin_bloom", new Item.Properties());
    //public static final DeferredItem<Item> BRONZE_DUST = ITEMS.registerSimpleItem("bronze_dust", new Item.Properties());
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.registerSimpleItem("copper_dust", new Item.Properties());
    public static final DeferredItem<Item> TIN_DUST = ITEMS.registerSimpleItem("tin_dust", new Item.Properties());
    public static final DeferredItem<Item> COPPER_TIN_BLEND_DUST = ITEMS.registerSimpleItem("copper_tin_blend_dust", new Item.Properties());
    public static final DeferredItem<Item> COPPER_ORE_DUST = ITEMS.registerSimpleItem("copper_core_dust", new Item.Properties());
    public static final DeferredItem<Item> TIN_ORE_DUST = ITEMS.registerSimpleItem("tin_ore_dust", new Item.Properties());
    public static final DeferredItem<Item> IRON_ORE_DUST = ITEMS.registerSimpleItem("iron_ore_dust", new Item.Properties());

    public static final DeferredItem<Item> SLAG = ITEMS.registerSimpleItem("slag", new Item.Properties());
    public static final DeferredItem<Item> BLISTER_STEEL_INGOT = ITEMS.registerSimpleItem("blister_steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.registerSimpleItem("bronze_ingot", new Item.Properties());
    public static final DeferredItem<Item> CAST_IRON_INGOT = ITEMS.registerSimpleItem("cast_iron_ingot", new Item.Properties());
    //public static final DeferredItem<Item> CHROMIUM_INGOT = ITEMS.registerSimpleItem("chromium_ingot", new Item.Properties());
    //public static final DeferredItem<Item> COPPER_INGOT = ITEMS.registerSimpleItem("copper_ingot", new Item.Properties());
    //public static final DeferredItem<Item> GOLD_INGOT = ITEMS.registerSimpleItem("gold_ingot", new Item.Properties());
    //public static final DeferredItem<Item> LEAD_INGOT = ITEMS.registerSimpleItem("lead_ingot", new Item.Properties());
    //public static final DeferredItem<Item> NICKLE_INGOT = ITEMS.registerSimpleItem("nickle_ingot", new Item.Properties());
    public static final DeferredItem<Item> SHEAR_STEEL_INGOT = ITEMS.registerSimpleItem("shear_steel_ingot", new Item.Properties());
    //public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot", new Item.Properties());
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.registerSimpleItem("tin_ingot", new Item.Properties());
    //public static final DeferredItem<Item> TUNGSTEN_INGOT = ITEMS.registerSimpleItem("tungsten_ingot", new Item.Properties());
    //public static final DeferredItem<Item> WROUGHT_IRON_INGOT = ITEMS.registerSimpleItem("wrought_iron_ingot", new Item.Properties()); // == minecraft:iron_ingot

    public static final DeferredItem<Item> COPPER_AXE = ITEMS.registerSimpleItem("copper_axe", new Item.Properties());
    public static final DeferredItem<Item> COPPER_KNIFE = ITEMS.registerSimpleItem("copper_knife", new Item.Properties());
    public static final DeferredItem<Item> COPPER_PICKAXE = ITEMS.registerSimpleItem("copper_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SICKLE = ITEMS.registerSimpleItem("copper_sickle", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SPEAR = ITEMS.registerSimpleItem("copper_spear", new Item.Properties());
    public static final DeferredItem<Item> TIN_AXE = ITEMS.registerSimpleItem("tin_axe", new Item.Properties());
    public static final DeferredItem<Item> TIN_KNIFE = ITEMS.registerSimpleItem("tin_knife", new Item.Properties());
    public static final DeferredItem<Item> TIN_PICKAXE = ITEMS.registerSimpleItem("tin_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> TIN_SICKLE = ITEMS.registerSimpleItem("tin_sickle", new Item.Properties());
    public static final DeferredItem<Item> TIN_SPEAR = ITEMS.registerSimpleItem("tin_spear", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_AXE = ITEMS.registerSimpleItem("bronze_axe", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_KNIFE = ITEMS.registerSimpleItem("bronze_knife", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_PICKAXE = ITEMS.registerSimpleItem("bronze_pickaxe", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SICKLE = ITEMS.registerSimpleItem("bronze_sickle", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SPEAR = ITEMS.registerSimpleItem("bronze_spear", new Item.Properties());
    public static final DeferredItem<Item> ROCK_AXE_HEAD = ITEMS.registerSimpleItem("rock_axe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE_HEAD = ITEMS.registerSimpleItem("rock_knife_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE_HEAD = ITEMS.registerSimpleItem("rock_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SICKLE_HEAD = ITEMS.registerSimpleItem("rock_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR_HEAD = ITEMS.registerSimpleItem("rock_spear_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_AXE_HEAD = ITEMS.registerSimpleItem("copper_axe_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_KNIFE_HEAD = ITEMS.registerSimpleItem("copper_knife_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_PICKAXE_HEAD = ITEMS.registerSimpleItem("copper_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SICKLE_HEAD = ITEMS.registerSimpleItem("copper_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> COPPER_SPEAR_HEAD = ITEMS.registerSimpleItem("copper_spear_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_AXE_HEAD = ITEMS.registerSimpleItem("tin_axe_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_KNIFE_HEAD = ITEMS.registerSimpleItem("tin_knife_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_PICKAXE_HEAD = ITEMS.registerSimpleItem("tin_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_SICKLE_HEAD = ITEMS.registerSimpleItem("tin_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> TIN_SPEAR_HEAD = ITEMS.registerSimpleItem("tin_spear_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_AXE_HEAD = ITEMS.registerSimpleItem("bronze_axe_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_KNIFE_HEAD = ITEMS.registerSimpleItem("bronze_knife_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_PICKAXE_HEAD = ITEMS.registerSimpleItem("bronze_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SICKLE_HEAD = ITEMS.registerSimpleItem("bronze_sickle_head", new Item.Properties());
    public static final DeferredItem<Item> BRONZE_SPEAR_HEAD = ITEMS.registerSimpleItem("bronze_spear_head", new Item.Properties());

    //public static final DeferredItem<Item> MOLTEN_COPPER_BUCKET = ITEMS.registerSimpleItem("molten_copper_bucket", new Item.Properties());
    //public static final DeferredItem<Item> MOLTEN_TIN_BUCKET = ITEMS.registerSimpleItem("molten_tin_bucket", new Item.Properties());
    //public static final DeferredItem<Item> MOLTEN_BRONZE_BUCKET = ITEMS.registerSimpleItem("molten_bronze_bucket", new Item.Properties()); // vs Brass?
    */
    //endregion


}
