package io.github.zephyrwolf.medievalism.registration.block;

import com.mojang.datafixers.util.Function3;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class BlockRegistration
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
    private static <B extends Block> DeferredBlock<B> registerDryingBrick(DeferredRegister.Blocks blocks, String name,
               Function3<BlockBehaviour.Properties, SoundType, Integer, ? extends B> func, BlockBehaviour.Properties props, SoundType drySound, int chance)
    { return blocks.register(name, () -> func.apply(props, drySound, chance)); }

    // STONE PROPERTIES
    public static final BlockBehaviour.Properties ASHFALL_PROPERTIES =                          BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties SOFT_TUFF_PROPERTIES =                        ASHFALL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties IGNIMBRITE_PROPERTIES =                       ASHFALL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties LAPILLISTONE_PROPERTIES =                     ASHFALL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties WELDED_TUFF_PROPERTIES =                      Blocks.TUFF.properties();
    public static final BlockBehaviour.Properties SANDSTONE_PROPERTIES =                        Blocks.SANDSTONE.properties();
    public static final BlockBehaviour.Properties RED_SANDSTONE_PROPERTIES =                    Blocks.RED_SANDSTONE.properties();
    public static final BlockBehaviour.Properties REGOLITH_PROPERTIES =                         BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties SAPROLITE_PROPERTIES =                        REGOLITH_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties LATERITE_PROPERTIES =                         REGOLITH_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties SEDIMENTARY_PROPERTIES =                      Blocks.STONE.properties();
    public static final BlockBehaviour.Properties GREYWACKE_PROPERTIES =                        SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties SILTSTONE_PROPERTIES =                        SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties DOLOSTONE_PROPERTIES =                        SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties LIMESTONE_PROPERTIES =                        SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties CHALK_PROPERTIES =                            SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties IRONSTONE_PROPERTIES =                        SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties SHALE_PROPERTIES     =                        SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties ARKOSE_PROPERTIES =                           SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties METAMORPHIC_PROPERTIES =                      BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties MARBLE_PROPERTIES =                           METAMORPHIC_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties QUARTZITE_PROPERTIES =                        METAMORPHIC_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties HORNFELS_PROPERTIES =                         METAMORPHIC_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties SLATE_PROPERTIES =                            METAMORPHIC_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties IGNEOUS_INTRUSIVE_PROPERTIES =                Blocks.DEEPSLATE.properties();
    public static final BlockBehaviour.Properties GABBRO_PROPERTIES =                           IGNEOUS_INTRUSIVE_PROPERTIES;
    public static final BlockBehaviour.Properties SMOOTH_DIORITE_PROPERTIES =                   IGNEOUS_INTRUSIVE_PROPERTIES.mapColor(Blocks.DIORITE.defaultMapColor());
    public static final BlockBehaviour.Properties SMOOTH_GRANITE_PROPERTIES =                   IGNEOUS_INTRUSIVE_PROPERTIES.mapColor(Blocks.GRANITE.defaultMapColor());
    public static final BlockBehaviour.Properties DEEP_IGNEOUS_INTRUSIVE_PROPERTIES =           BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties NORITE_PROPERTIES =                           DEEP_IGNEOUS_INTRUSIVE_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties PERIDOTITE_PROPERTIES =                       DEEP_IGNEOUS_INTRUSIVE_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties SOFT_IGNEOUS_EXTRUSIVE_PROPERTIES =           BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties RHYOLITE_PROPERTIES =                         SOFT_IGNEOUS_EXTRUSIVE_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties DACITE_PROPERTIES =                           SOFT_IGNEOUS_EXTRUSIVE_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties HARD_IGNEOUS_EXTRUSIVE_PROPERTIES =           BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties ANDESITE_PROPERTIES =                         Blocks.ANDESITE.properties();
    public static final BlockBehaviour.Properties BASALT_PROPERTIES =                           Blocks.SMOOTH_BASALT.properties();
    public static final BlockBehaviour.Properties TRAVERTINE_PROPERTIES =                       Blocks.DRIPSTONE_BLOCK.properties();
    public static final BlockBehaviour.Properties CALCITE_PROPERTIES =                          Blocks.CALCITE.properties();
    // STONE
    // TODO Reconsider soft_tuff and welded_tuff
    public static final DeferredBlock<Block> SOFT_TUFF =                    BLOCKS.registerSimpleBlock("soft_tuff",         SOFT_TUFF_PROPERTIES);
    public static final DeferredBlock<Block> IGNIMBRITE =                   BLOCKS.registerSimpleBlock("ignimbrite",        IGNIMBRITE_PROPERTIES);
    public static final DeferredBlock<Block> LAPILLISTONE =                 BLOCKS.registerSimpleBlock("lapillistone",      LAPILLISTONE_PROPERTIES);
    public static final DeferredBlock<Block> WELDED_TUFF =                  new VanillaDeferredBlock<>(Blocks.TUFF);
    public static final DeferredBlock<Block> SANDSTONE =                    new VanillaDeferredBlock<>(Blocks.SANDSTONE);
    public static final DeferredBlock<Block> RED_SANDSTONE =                new VanillaDeferredBlock<>(Blocks.RED_SANDSTONE);
    public static final DeferredBlock<Block> SAPROLITE =                    BLOCKS.registerSimpleBlock("saprolite",         SAPROLITE_PROPERTIES);
    public static final DeferredBlock<Block> LATERITE =                     BLOCKS.registerSimpleBlock("laterite",          LATERITE_PROPERTIES);
    public static final DeferredBlock<Block> GREYWACKE =                    new VanillaDeferredBlock<>(Blocks.STONE);
    public static final DeferredBlock<Block> SILTSTONE =                    BLOCKS.registerSimpleBlock("siltstone",         SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> DOLOSTONE =                    BLOCKS.registerSimpleBlock("dolostone",         DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> LIMESTONE =                    BLOCKS.registerSimpleBlock("limestone",         LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> CHALK =                        BLOCKS.registerSimpleBlock("chalk",             CHALK_PROPERTIES);
    public static final DeferredBlock<Block> IRONSTONE =                    BLOCKS.registerSimpleBlock("ironstone",         IRONSTONE_PROPERTIES);
    public static final DeferredBlock<Block> SHALE     =                    BLOCKS.registerSimpleBlock("shale",             SHALE_PROPERTIES);
    public static final DeferredBlock<Block> ARKOSE =                       BLOCKS.registerSimpleBlock("arkose",            ARKOSE_PROPERTIES);
    public static final DeferredBlock<Block> MARBLE =                       BLOCKS.registerSimpleBlock("marble",            MARBLE_PROPERTIES);
    public static final DeferredBlock<Block> QUARTZITE =                    BLOCKS.registerSimpleBlock("quartzite",         QUARTZITE_PROPERTIES);
    public static final DeferredBlock<Block> HORNFELS =                     BLOCKS.registerSimpleBlock("hornfels",          HORNFELS_PROPERTIES);
    public static final DeferredBlock<Block> SLATE =                        BLOCKS.registerSimpleBlock("slate",             SLATE_PROPERTIES);
    public static final DeferredBlock<Block> GABBRO =                       new VanillaDeferredBlock<>(Blocks.DEEPSLATE);
    public static final DeferredBlock<Block> SMOOTH_DIORITE =               BLOCKS.registerSimpleBlock("smooth_diorite",    SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> SMOOTH_GRANITE =               BLOCKS.registerSimpleBlock("smooth_granite",    SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> NORITE =                       BLOCKS.registerSimpleBlock("norite",            NORITE_PROPERTIES);
    public static final DeferredBlock<Block> PERIDOTITE =                   BLOCKS.registerSimpleBlock("peridotite",        PERIDOTITE_PROPERTIES);
    public static final DeferredBlock<Block> RHYOLITE =                     BLOCKS.registerSimpleBlock("rhyolite",          RHYOLITE_PROPERTIES);
    public static final DeferredBlock<Block> DACITE =                       BLOCKS.registerSimpleBlock("dacite",            DACITE_PROPERTIES);
    public static final DeferredBlock<Block> ANDESITE =                     new VanillaDeferredBlock<>(Blocks.ANDESITE);
    public static final DeferredBlock<Block> BASALT =                       new VanillaDeferredBlock<>(Blocks.SMOOTH_BASALT);
    public static final DeferredBlock<Block> TRAVERTINE =                   new VanillaDeferredBlock<>(Blocks.DRIPSTONE_BLOCK);
    public static final DeferredBlock<Block> CALCITE =                      new VanillaDeferredBlock<>(Blocks.CALCITE);
    // INFESTED STONE
    public static final DeferredBlock<Block> INFESTED_GREYWACKE =           new VanillaDeferredBlock<>(Blocks.INFESTED_STONE);
    public static final DeferredBlock<Block> INFESTED_SILTSTONE =           BLOCKS.registerBlock("infested_siltstone",          (props) -> new InfestedBlock(SILTSTONE.get(), props),           SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_DOLOSTONE =           BLOCKS.registerBlock("infested_dolostone",          (props) -> new InfestedBlock(DOLOSTONE.get(), props),           DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_LIMESTONE =           BLOCKS.registerBlock("infested_limestone",          (props) -> new InfestedBlock(LIMESTONE.get(), props),           LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_SHALE =               BLOCKS.registerBlock("infested_shale",              (props) -> new InfestedBlock(SHALE.get(), props),               SHALE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_ARKOSE =              BLOCKS.registerBlock("infested_arkose",             (props) -> new InfestedBlock(ARKOSE.get(), props),              ARKOSE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_MARBLE =              BLOCKS.registerBlock("infested_marble",             (props) -> new InfestedBlock(MARBLE.get(), props),              MARBLE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_QUARTZITE =           BLOCKS.registerBlock("infested_quartzite",          (props) -> new InfestedBlock(QUARTZITE.get(), props),           QUARTZITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_HORNFELS =            BLOCKS.registerBlock("infested_hornfels",           (props) -> new InfestedBlock(HORNFELS.get(), props),            HORNFELS_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_SLATE =               BLOCKS.registerBlock("infested_slate",              (props) -> new InfestedBlock(SLATE.get(), props),               SLATE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_GABBRO =              new VanillaDeferredBlock<>(Blocks.INFESTED_DEEPSLATE);
    public static final DeferredBlock<Block> INFESTED_SMOOTH_DIORITE =      BLOCKS.registerBlock("infested_smooth_diorite",     (props) -> new InfestedBlock(SMOOTH_DIORITE.get(), props),      SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_SMOOTH_GRANITE =      BLOCKS.registerBlock("infested_smooth_granite",     (props) -> new InfestedBlock(SMOOTH_GRANITE.get(), props),      SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_NORITE =              BLOCKS.registerBlock("infested_norite",             (props) -> new InfestedBlock(NORITE.get(), props),              NORITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_PERIDOTITE =          BLOCKS.registerBlock("infested_peridotite",         (props) -> new InfestedBlock(PERIDOTITE.get(), props),          PERIDOTITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_RHYOLITE =            BLOCKS.registerBlock("infested_rhyolite",           (props) -> new InfestedBlock(RHYOLITE.get(), props),            RHYOLITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_DACITE =              BLOCKS.registerBlock("infested_dacite",             (props) -> new InfestedBlock(DACITE.get(), props),              DACITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_ANDESITE =            BLOCKS.registerBlock("infested_andesite",           (props) -> new InfestedBlock(ANDESITE.get(), props),            ANDESITE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_BASALT =              BLOCKS.registerBlock("infested_basalt",             (props) -> new InfestedBlock(BASALT.get(), props),              BASALT_PROPERTIES);
    // COPPER ORE
    public static final DeferredBlock<Block> SAPROLITE_COPPER_ORE =         BLOCKS.registerSimpleBlock("saprolite_copper_ore",          SAPROLITE_PROPERTIES);
    public static final DeferredBlock<Block> GREYWACKE_COPPER_ORE =         new VanillaDeferredBlock<>(Blocks.COPPER_ORE);
    public static final DeferredBlock<Block> SILTSTONE_COPPER_ORE =         BLOCKS.registerSimpleBlock("siltstone_copper_ore",          SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> DOLOSTONE_COPPER_ORE =         BLOCKS.registerSimpleBlock("dolostone_copper_ore",          DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> LIMESTONE_COPPER_ORE =         BLOCKS.registerSimpleBlock("limestone_copper_ore",          LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> CHALK_COPPER_ORE =             BLOCKS.registerSimpleBlock("chalk_copper_ore",              CHALK_PROPERTIES);
    public static final DeferredBlock<Block> IRONSTONE_COPPER_ORE =         BLOCKS.registerSimpleBlock("ironstone_copper_ore",          IRONSTONE_PROPERTIES);
    public static final DeferredBlock<Block> SHALE_COPPER_ORE =             BLOCKS.registerSimpleBlock("shale_copper_ore",              SHALE_PROPERTIES);
    public static final DeferredBlock<Block> ARKOSE_COPPER_ORE =            BLOCKS.registerSimpleBlock("arkose_copper_ore",             ARKOSE_PROPERTIES);
    public static final DeferredBlock<Block> MARBLE_COPPER_ORE =            BLOCKS.registerSimpleBlock("marble_copper_ore",             MARBLE_PROPERTIES);
    public static final DeferredBlock<Block> QUARTZITE_COPPER_ORE =         BLOCKS.registerSimpleBlock("quartzite_copper_ore",          QUARTZITE_PROPERTIES);
    public static final DeferredBlock<Block> HORNFELS_COPPER_ORE =          BLOCKS.registerSimpleBlock("hornfels_copper_ore",           HORNFELS_PROPERTIES);
    public static final DeferredBlock<Block> SLATE_COPPER_ORE =             BLOCKS.registerSimpleBlock("slate_copper_ore",              SLATE_PROPERTIES);
    // IRON ORE
    public static final DeferredBlock<Block> GABBRO_IRON_ORE =              new VanillaDeferredBlock<>(Blocks.DEEPSLATE_IRON_ORE);
    public static final DeferredBlock<Block> SMOOTH_DIORITE_IRON_ORE =      BLOCKS.registerSimpleBlock("smooth_diorite_iron_ore",       GABBRO_PROPERTIES);
    public static final DeferredBlock<Block> SMOOTH_GRANITE_IRON_ORE =      BLOCKS.registerSimpleBlock("smooth_granite_iron_ore",       SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> NORITE_IRON_ORE =              BLOCKS.registerSimpleBlock("norite_iron_ore",               SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> PERIDOTITE_IRON_ORE =          BLOCKS.registerSimpleBlock("peridotite_iron_ore",           NORITE_PROPERTIES);
    public static final DeferredBlock<Block> RHYOLITE_IRON_ORE =            BLOCKS.registerSimpleBlock("rhyolite_iron_ore",             PERIDOTITE_PROPERTIES);
    public static final DeferredBlock<Block> DACITE_IRON_ORE =              BLOCKS.registerSimpleBlock("dacite_iron_ore",               RHYOLITE_PROPERTIES);
    public static final DeferredBlock<Block> ANDESITE_IRON_ORE =            BLOCKS.registerSimpleBlock("andesite_iron_ore",             DACITE_PROPERTIES);
    public static final DeferredBlock<Block> BASALT_IRON_ORE =              BLOCKS.registerSimpleBlock("basalt_iron_ore",               ANDESITE_PROPERTIES);
    // GOLD ORE
    public static final DeferredBlock<Block> GREYWACKE_GOLD_ORE =           new VanillaDeferredBlock<>(Blocks.GOLD_ORE);
    public static final DeferredBlock<Block> SILTSTONE_GOLD_ORE =           BLOCKS.registerSimpleBlock("siltstone_gold_ore",            SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> DOLOSTONE_GOLD_ORE =           BLOCKS.registerSimpleBlock("dolostone_gold_ore",            DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> LIMESTONE_GOLD_ORE =           BLOCKS.registerSimpleBlock("limestone_gold_ore",            LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> CHALK_GOLD_ORE =               BLOCKS.registerSimpleBlock("chalk_gold_ore",                CHALK_PROPERTIES);
    public static final DeferredBlock<Block> IRONSTONE_GOLD_ORE =           BLOCKS.registerSimpleBlock("ironstone_gold_ore",            IRONSTONE_PROPERTIES);
    public static final DeferredBlock<Block> SHALE_GOLD_ORE =               BLOCKS.registerSimpleBlock("shale_gold_ore",                SHALE_PROPERTIES);
    public static final DeferredBlock<Block> ARKOSE_GOLD_ORE =              BLOCKS.registerSimpleBlock("arkose_gold_ore",               ARKOSE_PROPERTIES);
    public static final DeferredBlock<Block> MARBLE_GOLD_ORE =              BLOCKS.registerSimpleBlock("marble_gold_ore",               MARBLE_PROPERTIES);
    public static final DeferredBlock<Block> QUARTZITE_GOLD_ORE =           BLOCKS.registerSimpleBlock("quartzite_gold_ore",            QUARTZITE_PROPERTIES);
    public static final DeferredBlock<Block> HORNFELS_GOLD_ORE =            BLOCKS.registerSimpleBlock("hornfels_gold_ore",             HORNFELS_PROPERTIES);
    public static final DeferredBlock<Block> SLATE_GOLD_ORE =               BLOCKS.registerSimpleBlock("slate_gold_ore",                SLATE_PROPERTIES);
    public static final DeferredBlock<Block> GABBRO_GOLD_ORE =              new VanillaDeferredBlock<>(Blocks.DEEPSLATE_GOLD_ORE);
    public static final DeferredBlock<Block> SMOOTH_DIORITE_GOLD_ORE =      BLOCKS.registerSimpleBlock("smooth_diorite_gold_ore",       SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> SMOOTH_GRANITE_GOLD_ORE =      BLOCKS.registerSimpleBlock("smooth_granite_gold_ore",       SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> NORITE_GOLD_ORE =              BLOCKS.registerSimpleBlock("norite_gold_ore",               NORITE_PROPERTIES);
    public static final DeferredBlock<Block> PERIDOTITE_GOLD_ORE =          BLOCKS.registerSimpleBlock("peridotite_gold_ore",           PERIDOTITE_PROPERTIES);
    public static final DeferredBlock<Block> RHYOLITE_GOLD_ORE =            BLOCKS.registerSimpleBlock("rhyolite_gold_ore",             RHYOLITE_PROPERTIES);
    public static final DeferredBlock<Block> DACITE_GOLD_ORE =              BLOCKS.registerSimpleBlock("dacite_gold_ore",               DACITE_PROPERTIES);
    public static final DeferredBlock<Block> ANDESITE_GOLD_ORE =            BLOCKS.registerSimpleBlock("andesite_gold_ore",             ANDESITE_PROPERTIES);
    public static final DeferredBlock<Block> BASALT_GOLD_ORE =              BLOCKS.registerSimpleBlock("basalt_gold_ore",               BASALT_PROPERTIES);
    // COAL ORE
    public static final DeferredBlock<Block> SAPROLITE_COAL_ORE =           BLOCKS.registerSimpleBlock("saprolite_coal_ore",            SAPROLITE_PROPERTIES);
    public static final DeferredBlock<Block> LATERITE_COAL_ORE =            BLOCKS.registerSimpleBlock("laterite_coal_ore",             LATERITE_PROPERTIES);
    public static final DeferredBlock<Block> GREYWACKE_COAL_ORE =           new VanillaDeferredBlock<>(Blocks.COAL_ORE);
    public static final DeferredBlock<Block> SILTSTONE_COAL_ORE =           BLOCKS.registerSimpleBlock("siltstone_coal_ore",            SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> DOLOSTONE_COAL_ORE =           BLOCKS.registerSimpleBlock("dolostone_coal_ore",            DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> LIMESTONE_COAL_ORE =           BLOCKS.registerSimpleBlock("limestone_coal_ore",            LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> CHALK_COAL_ORE =               BLOCKS.registerSimpleBlock("chalk_coal_ore",                CHALK_PROPERTIES);
    public static final DeferredBlock<Block> IRONSTONE_COAL_ORE =           BLOCKS.registerSimpleBlock("ironstone_coal_ore",            IRONSTONE_PROPERTIES);
    public static final DeferredBlock<Block> SHALE_COAL_ORE =               BLOCKS.registerSimpleBlock("shale_coal_ore",                SHALE_PROPERTIES);
    public static final DeferredBlock<Block> ARKOSE_COAL_ORE =              BLOCKS.registerSimpleBlock("arkose_coal_ore",               ARKOSE_PROPERTIES);
    public static final DeferredBlock<Block> MARBLE_COAL_ORE =              BLOCKS.registerSimpleBlock("marble_coal_ore",               MARBLE_PROPERTIES);
    public static final DeferredBlock<Block> QUARTZITE_COAL_ORE =           BLOCKS.registerSimpleBlock("quartzite_coal_ore",            QUARTZITE_PROPERTIES);
    public static final DeferredBlock<Block> HORNFELS_COAL_ORE =            BLOCKS.registerSimpleBlock("hornfels_coal_ore",             HORNFELS_PROPERTIES);
    public static final DeferredBlock<Block> SLATE_COAL_ORE =               BLOCKS.registerSimpleBlock("slate_coal_ore",                SLATE_PROPERTIES);
    // DIAMOND ORE
    public static final DeferredBlock<Block> GABBRO_DIAMOND_ORE =           new VanillaDeferredBlock<>(Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final DeferredBlock<Block> SMOOTH_DIORITE_DIAMOND_ORE =   BLOCKS.registerSimpleBlock("smooth_diorite_diamond_ore",    SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> SMOOTH_GRANITE_DIAMOND_ORE =   BLOCKS.registerSimpleBlock("smooth_granite_diamond_ore",    SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> NORITE_DIAMOND_ORE =           BLOCKS.registerSimpleBlock("norite_diamond_ore",            NORITE_PROPERTIES);
    public static final DeferredBlock<Block> PERIDOTITE_DIAMOND_ORE =       BLOCKS.registerSimpleBlock("peridotite_diamond_ore",        PERIDOTITE_PROPERTIES);
    public static final DeferredBlock<Block> ANDESITE_DIAMOND_ORE =         BLOCKS.registerSimpleBlock("andesite_diamond_ore",          ANDESITE_PROPERTIES);
    public static final DeferredBlock<Block> BASALT_DIAMOND_ORE =           BLOCKS.registerSimpleBlock("basalt_diamond_ore",            BASALT_PROPERTIES);
    // EMERALD ORE
    public static final DeferredBlock<Block> GABBRO_EMERALD_ORE =           new VanillaDeferredBlock<>(Blocks.EMERALD_ORE);
    public static final DeferredBlock<Block> SMOOTH_DIORITE_EMERALD_ORE =   BLOCKS.registerSimpleBlock("smooth_diorite_emerald_ore",    SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> SMOOTH_GRANITE_EMERALD_ORE =   BLOCKS.registerSimpleBlock("smooth_granite_emerald_ore",    SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> NORITE_EMERALD_ORE =           BLOCKS.registerSimpleBlock("norite_emerald_ore",            NORITE_PROPERTIES);
    public static final DeferredBlock<Block> PERIDOTITE_EMERALD_ORE =       BLOCKS.registerSimpleBlock("peridotite_emerald_ore",        PERIDOTITE_PROPERTIES);
    public static final DeferredBlock<Block> RHYOLITE_EMERALD_ORE =         BLOCKS.registerSimpleBlock("rhyolite_emerald_ore",          RHYOLITE_PROPERTIES);
    public static final DeferredBlock<Block> DACITE_EMERALD_ORE =           BLOCKS.registerSimpleBlock("dacite_emerald_ore",            DACITE_PROPERTIES);
    public static final DeferredBlock<Block> ANDESITE_EMERALD_ORE =         BLOCKS.registerSimpleBlock("andesite_emerald_ore",          ANDESITE_PROPERTIES);
    public static final DeferredBlock<Block> BASALT_EMERALD_ORE =           BLOCKS.registerSimpleBlock("basalt_emerald_ore",            BASALT_PROPERTIES);
    // LAPIS ORE
    public static final DeferredBlock<Block> MARBLE_LAPIS_ORE =             BLOCKS.registerSimpleBlock("marble_lapis_ore",              MARBLE_PROPERTIES);
    public static final DeferredBlock<Block> QUARTZITE_LAPIS_ORE =          BLOCKS.registerSimpleBlock("quartzite_lapis_ore",           QUARTZITE_PROPERTIES);
    public static final DeferredBlock<Block> HORNFELS_LAPIS_ORE =           BLOCKS.registerSimpleBlock("hornfels_lapis_ore",            HORNFELS_PROPERTIES);
    public static final DeferredBlock<Block> SLATE_LAPIS_ORE =              BLOCKS.registerSimpleBlock("slate_lapis_ore",               SLATE_PROPERTIES);
    // REDSTONE ORE
    public static final DeferredBlock<Block> GABBRO_REDSTONE_ORE =          new VanillaDeferredBlock<>(Blocks.DEEPSLATE_REDSTONE_ORE);
    public static final DeferredBlock<Block> SMOOTH_DIORITE_REDSTONE_ORE =  BLOCKS.registerSimpleBlock("smooth_diorite_redstone_ore",   SMOOTH_DIORITE_PROPERTIES);
    public static final DeferredBlock<Block> SMOOTH_GRANITE_REDSTONE_ORE =  BLOCKS.registerSimpleBlock("smooth_granite_redstone_ore",   SMOOTH_GRANITE_PROPERTIES);
    public static final DeferredBlock<Block> NORITE_REDSTONE_ORE =          BLOCKS.registerSimpleBlock("norite_redstone_ore",           NORITE_PROPERTIES);
    public static final DeferredBlock<Block> PERIDOTITE_REDSTONE_ORE =      BLOCKS.registerSimpleBlock("peridotite_redstone_ore",       PERIDOTITE_PROPERTIES);
    // TODO Modded Medieval Ores
    // TIN ORE // TODO World Gen
    public static final DeferredBlock<Block> TIN_ORE_IN_GREYWACKE = BLOCKS.registerSimpleBlock(
            "tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(1.3f).sound(SoundType.STONE).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> TIN_ORE_IN_GABBRO = BLOCKS.registerSimpleBlock(
            "deepslate_tin_ore_block", BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE)
                    .strength(1.7f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());
    // CHERT ORE // TODO World Gen
    public static final DeferredBlock<Block> LIMESTONE_CHERT_ORE =                              BLOCKS.registerSimpleBlock("limestone_chert_ore",           LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> CHALK_CHERT_ORE =                                  BLOCKS.registerSimpleBlock("chalk_chert_ore",               CHALK_PROPERTIES);
    // GEODE ORE // TODO World Gen
    public static final DeferredBlock<Block> BASALT_GEODE_ORE =                                 BLOCKS.registerSimpleBlock("basalt_geode_ore",              BASALT_PROPERTIES);
    public static final DeferredBlock<Block> ANDESITE_GEODE_ORE =                               BLOCKS.registerSimpleBlock("andesite_geode_ore",            ANDESITE_PROPERTIES);
    public static final DeferredBlock<Block> RHYOLITE_GEODE_ORE =                               BLOCKS.registerSimpleBlock("rhyolite_geode_ore",            RHYOLITE_PROPERTIES);
    public static final DeferredBlock<Block> DACITE_GEODE_ORE =                                 BLOCKS.registerSimpleBlock("dacite_geode_ore",              DACITE_PROPERTIES);

    // COBBLED PROPERTIES
    public static final BlockBehaviour.Properties COBBLED_ASHFALL_PROPERTIES =                  BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties COBBLED_SOFT_TUFF_PROPERTIES =                COBBLED_ASHFALL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_IGNIMBRITE_PROPERTIES =               COBBLED_ASHFALL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_LAPILLISTONE_PROPERTIES =             COBBLED_ASHFALL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_WELDED_TUFF_PROPERTIES =              COBBLED_ASHFALL_PROPERTIES; // mapColor respect discrepancy with stone soft tuff and welded tuff
    public static final BlockBehaviour.Properties COBBLED_DEEP_IGNEOUS_INTRUSIVE_PROPERTIES =   Blocks.COBBLED_DEEPSLATE.properties();
    public static final BlockBehaviour.Properties COBBLED_GABBRO_PROPERTIES =                   COBBLED_DEEP_IGNEOUS_INTRUSIVE_PROPERTIES;
    public static final BlockBehaviour.Properties ROUGH_DIORITE_PROPERTIES =                    COBBLED_DEEP_IGNEOUS_INTRUSIVE_PROPERTIES.mapColor(Blocks.DIORITE.defaultMapColor());
    public static final BlockBehaviour.Properties ROUGH_GRANITE_PROPERTIES =                    COBBLED_DEEP_IGNEOUS_INTRUSIVE_PROPERTIES.mapColor(Blocks.GRANITE.defaultMapColor());
    public static final BlockBehaviour.Properties COBBLED_SANDSTONES_PROPERTIES =               BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties COBBLED_SANDSTONE_PROPERTIES =                COBBLED_SANDSTONES_PROPERTIES.mapColor(Blocks.SANDSTONE.defaultMapColor());
    public static final BlockBehaviour.Properties COBBLED_RED_SANDSTONE_PROPERTIES =            COBBLED_SANDSTONES_PROPERTIES.mapColor(Blocks.RED_SANDSTONE.defaultMapColor());
    public static final BlockBehaviour.Properties COBBLED_REGOLITH_PROPERTIES =                 BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties COBBLED_SAPROLITE_PROPERTIES =                COBBLED_REGOLITH_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_LATERITE_PROPERTIES =                 COBBLED_REGOLITH_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_SEDIMENTARY_PROPERTIES =              Blocks.COBBLESTONE.properties();
    public static final BlockBehaviour.Properties COBBLED_GREYWACKE_PROPERTIES =                COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_SILTSTONE_PROPERTIES =                COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_DOLOSTONE_PROPERTIES =                COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_LIMESTONE_PROPERTIES =                COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_CHALK_PROPERTIES =                    COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_IRONSTONE_PROPERTIES =                COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_SHALE_PROPERTIES =                    COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties COBBLED_ARKOSE_PROPERTIES =                   COBBLED_SEDIMENTARY_PROPERTIES; // mapColor
    // COBBLED
    public static final DeferredBlock<Block> COBBLED_SOFT_TUFF =                            BLOCKS.registerSimpleBlock("cobbled_soft_tuff",         COBBLED_SOFT_TUFF_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_IGNIMBRITE =                           BLOCKS.registerSimpleBlock("cobbled_ignimbrite",        COBBLED_IGNIMBRITE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_LAPILLISTONE =                         BLOCKS.registerSimpleBlock("cobbled_lapillistone",      COBBLED_LAPILLISTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_WELDED_TUFF =                          BLOCKS.registerSimpleBlock("cobbled_welded_tuff",       COBBLED_WELDED_TUFF_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_SANDSTONE =                            BLOCKS.registerSimpleBlock("cobbled_sandstone",         COBBLED_SANDSTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_RED_SANDSTONE =                        BLOCKS.registerSimpleBlock("cobbled_red_sandstone",     COBBLED_RED_SANDSTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_SAPROLITE =                            BLOCKS.registerSimpleBlock("cobbled_saprolite",         COBBLED_SAPROLITE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_LATERITE =                             BLOCKS.registerSimpleBlock("cobbled_laterite",          COBBLED_LATERITE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_GREYWACKE =                            new VanillaDeferredBlock<>(Blocks.COBBLESTONE);
    public static final DeferredBlock<Block> COBBLED_SILTSTONE =                            BLOCKS.registerSimpleBlock("cobbled_siltstone",         COBBLED_SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_DOLOSTONE =                            BLOCKS.registerSimpleBlock("cobbled_dolostone",         COBBLED_DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_LIMESTONE =                            BLOCKS.registerSimpleBlock("cobbled_limestone",         COBBLED_LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_CHALK =                                BLOCKS.registerSimpleBlock("cobbled_chalk",             COBBLED_CHALK_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_IRONSTONE =                            BLOCKS.registerSimpleBlock("cobbled_ironstone",         COBBLED_IRONSTONE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_SHALE =                                BLOCKS.registerSimpleBlock("cobbled_shale",             COBBLED_SHALE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_ARKOSE =                               BLOCKS.registerSimpleBlock("cobbled_arkose",            COBBLED_ARKOSE_PROPERTIES);
    public static final DeferredBlock<Block> COBBLED_GABBRO =                               new VanillaDeferredBlock<>(Blocks.COBBLED_DEEPSLATE);
    public static final DeferredBlock<Block> ROUGH_DIORITE =                                new VanillaDeferredBlock<>(Blocks.DIORITE);
    public static final DeferredBlock<Block> ROUGH_GRANITE =                                new VanillaDeferredBlock<>(Blocks.GRANITE);
    // INFESTED COBBLESTONE
    public static final DeferredBlock<Block> INFESTED_COBBLED_GREYWACKE =                   new VanillaDeferredBlock<>(Blocks.INFESTED_COBBLESTONE);
    public static final DeferredBlock<Block> INFESTED_COBBLED_SILTSTONE =                   BLOCKS.registerBlock("infested_cobbled_siltstone",  (props) -> new InfestedBlock(COBBLED_SILTSTONE.get(), props),   COBBLED_SILTSTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_COBBLED_DOLOSTONE =                   BLOCKS.registerBlock("infested_cobbled_dolostone",  (props) -> new InfestedBlock(COBBLED_DOLOSTONE.get(), props),   COBBLED_DOLOSTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_COBBLED_LIMESTONE =                   BLOCKS.registerBlock("infested_cobbled_limestone",  (props) -> new InfestedBlock(COBBLED_LIMESTONE.get(), props),   COBBLED_LIMESTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_COBBLED_CHALK =                       BLOCKS.registerBlock("infested_cobbled_chalk",      (props) -> new InfestedBlock(COBBLED_CHALK.get(), props),       COBBLED_CHALK_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_COBBLED_IRONSTONE =                   BLOCKS.registerBlock("infested_cobbled_ironstone",  (props) -> new InfestedBlock(COBBLED_IRONSTONE.get(), props),   COBBLED_IRONSTONE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_COBBLED_SHALE =                       BLOCKS.registerBlock("infested_cobbled_shale",      (props) -> new InfestedBlock(COBBLED_SHALE.get(), props),       COBBLED_SHALE_PROPERTIES);
    public static final DeferredBlock<Block> INFESTED_COBBLED_ARKOSE =                      BLOCKS.registerBlock("infested_cobbled_arkose",     (props) -> new InfestedBlock(COBBLED_ARKOSE.get(), props),      COBBLED_ARKOSE_PROPERTIES);

    // SOIL PROPERTIES
    public static final BlockBehaviour.Properties GRASS_BLOCK_PROPERTIES =                  Blocks.GRASS_BLOCK.properties();
    public static final BlockBehaviour.Properties CLAY_IN_GRASS_PROPERTIES =                GRASS_BLOCK_PROPERTIES;
    public static final BlockBehaviour.Properties RED_CLAY_IN_GRASS_PROPERTIES =            GRASS_BLOCK_PROPERTIES;
    public static final BlockBehaviour.Properties DIRT_BLOCK_PROPERTIES =                   Blocks.DIRT.properties();
    public static final BlockBehaviour.Properties CLAY_IN_DIRT_PROPERTIES =                 DIRT_BLOCK_PROPERTIES;
    public static final BlockBehaviour.Properties RED_CLAY_IN_DIRT_PROPERTIES =             DIRT_BLOCK_PROPERTIES;
    public static final BlockBehaviour.Properties CLAY_BLOCK_PROPERTIES =                   Blocks.CLAY.properties();
    public static final BlockBehaviour.Properties RED_CLAY_PROPERTIES =                     CLAY_BLOCK_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties GRAVEL_PROPERTIES =                       Blocks.GRAVEL.properties();
    public static final BlockBehaviour.Properties SILT_PROPERTIES =                         GRAVEL_PROPERTIES; // mapColor
    public static final BlockBehaviour.Properties DRYING_MUD_PROPERTIES =                   BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.MUD);
    public static final BlockBehaviour.Properties DRY_MUD_PROPERTIES =                      BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops();
    public static final BlockBehaviour.Properties DRYING_PACKED_MUD_PROPERTIES =            DRYING_MUD_PROPERTIES;
    public static final BlockBehaviour.Properties DRYING_DAUB_BLOCK_PROPERTIES =            DRYING_MUD_PROPERTIES;
    public static final BlockBehaviour.Properties DAUB_BLOCK_PROPERTIES =                   DRY_MUD_PROPERTIES;
    public static final BlockBehaviour.Properties DAUB_BRICKS_PROPERTIES =                  DRY_MUD_PROPERTIES;
    public static final BlockBehaviour.Properties CRACKED_DAUB_BLOCK_PROPERTIES =           DRY_MUD_PROPERTIES;
    public static final BlockBehaviour.Properties CRACKED_DAUB_BRICKS_PROPERTIES =          DRY_MUD_PROPERTIES;
    public static final BlockBehaviour.Properties DRYING_PACKED_MUD_BRICK_PROPERTIES =      DRYING_MUD_PROPERTIES.randomTicks().mapColor(MapColor.DIRT).mapColor(MapColor.TERRACOTTA_BROWN);
    public static final BlockBehaviour.Properties DRYING_DAUB_BRICK_PROPERTIES =            DRYING_MUD_PROPERTIES.randomTicks().mapColor(MapColor.DIRT).mapColor(MapColor.TERRACOTTA_BROWN);
    public static final BlockBehaviour.Properties DRYING_CLAY_BRICK_PROPERTIES =            DRYING_MUD_PROPERTIES.randomTicks().mapColor(MapColor.CLAY).mapColor(MapColor.CLAY);
    public static final BlockBehaviour.Properties DRYING_RED_CLAY_BRICK_PROPERTIES =        DRYING_MUD_PROPERTIES.randomTicks().mapColor(MapColor.CLAY).mapColor(MapColor.TERRACOTTA_ORANGE);
    // SOIL
    public static final DeferredBlock<GrassBlock> CLAY_IN_GRASS =                           BLOCKS.registerBlock("clay_in_grass",                   GrassBlock::new, CLAY_IN_GRASS_PROPERTIES);
    public static final DeferredBlock<GrassBlock> RED_CLAY_IN_GRASS =                       BLOCKS.registerBlock("red_clay_in_grass",               GrassBlock::new, RED_CLAY_IN_GRASS_PROPERTIES);
    public static final DeferredBlock<Block> CLAY_IN_DIRT =                                 BLOCKS.registerSimpleBlock("clay_in_dirt",              CLAY_IN_DIRT_PROPERTIES);
    public static final DeferredBlock<Block> RED_CLAY_IN_DIRT =                             BLOCKS.registerSimpleBlock("red_clay_in_dirt",          RED_CLAY_IN_DIRT_PROPERTIES);
    public static final DeferredBlock<Block> RED_CLAY =                                     BLOCKS.registerSimpleBlock("red_clay",                  CLAY_BLOCK_PROPERTIES);
    public static final DeferredBlock<Block> GRAVEL =                                       new VanillaDeferredBlock<>(Blocks.GRAVEL);
    public static final DeferredBlock<Block> SILT =                                         BLOCKS.registerSimpleBlock("silt",                      SILTSTONE_PROPERTIES);
    // WET MUD
    public static final DeferredBlock<Block> WET_PACKED_MUD =                               BLOCKS.registerBlock("wet_packed_mud",                  Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.MUD));
    public static final DeferredBlock<Block> WET_DAUB_BLOCK =                               BLOCKS.registerBlock("wet_daub_block",                  Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1.0f).sound(SoundType.MUD));
    // DRY MUD
    public static final DeferredBlock<Block> DAUB_BLOCK =                                   BLOCKS.registerBlock("daub_block",                      Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> DAUB_BRICKS =                                  BLOCKS.registerBlock("daub_bricks",                     Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> CRACKED_DAUB_BLOCK =                           BLOCKS.registerBlock("cracked_daub_block",              Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<Block> CRACKED_DAUB_BRICKS =                          BLOCKS.registerBlock("cracked_daub_bricks",             Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0f).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops());
    public static final DeferredBlock<DryingBrick> WET_PACKED_MUD_BRICK =                   registerDryingBrick(BLOCKS, "wet_packed_mud_brick",     DryingBrick::new, DRYING_PACKED_MUD_BRICK_PROPERTIES, SoundType.PACKED_MUD, 1);
    public static final DeferredBlock<DryingBrick> WET_DAUB_BRICK =                         registerDryingBrick(BLOCKS, "wet_daub_brick",           DryingBrick::new, DRYING_DAUB_BRICK_PROPERTIES, SoundType.PACKED_MUD, 2);
    public static final DeferredBlock<DryingBrick> DRYING_CLAY_BRICK =                      registerDryingBrick(BLOCKS, "drying_clay_brick",        DryingBrick::new, DRYING_CLAY_BRICK_PROPERTIES, SoundType.PACKED_MUD, 3);
    public static final DeferredBlock<DryingBrick> DRYING_RED_CLAY_BRICK =                  registerDryingBrick(BLOCKS, "drying_red_clay_brick",    DryingBrick::new, DRYING_RED_CLAY_BRICK_PROPERTIES, SoundType.PACKED_MUD, 3);

    // ROCK PROPERTIES
    public static BlockBehaviour.Properties CLUMP_PROPERTIES =                              BlockBehaviour.Properties.of().offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.GRAVEL).mapColor(MapColor.DIRT);
    public static BlockBehaviour.Properties ROCK_PROPERTIES =                               BlockBehaviour.Properties.of().offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.STONE).mapColor(MapColor.STONE);
    public static BlockBehaviour.Properties ROCK_COPPER_ORE_PROPERTIES =                    ROCK_PROPERTIES;
    public static BlockBehaviour.Properties LARGE_CLUMP_PROPERTIES =                        BlockBehaviour.Properties.of().offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.GRAVEL).mapColor(MapColor.DIRT);
    public static BlockBehaviour.Properties LARGE_ROCK_PROPERTIES =                         BlockBehaviour.Properties.of().offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.STONE).mapColor(MapColor.STONE);
    // ROCK
    public static final DeferredBlock<WorldLitterBlock> SANDSTONE_ROCK =                    BLOCKS.registerBlock("sandstone_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> RED_SANDSTONE_ROCK =                BLOCKS.registerBlock("red_sandstone_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SAPROLITE_ROCK =                    BLOCKS.registerBlock("saprolite_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LATERITE_ROCK =                     BLOCKS.registerBlock("laterite_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SILT_CLUMP =                        BLOCKS.registerBlock("silt_clump", RockBlock::new, CLUMP_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> GREYWACKE_ROCK =                    BLOCKS.registerBlock("greywacke_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SILTSTONE_ROCK =                    BLOCKS.registerBlock("siltstone_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> DOLOSTONE_ROCK =                    BLOCKS.registerBlock("dolostone_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LIMESTONE_ROCK =                    BLOCKS.registerBlock("limestone_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> IRONSTONE_ROCK =                    BLOCKS.registerBlock("ironstone_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SHALE_ROCK =                        BLOCKS.registerBlock("shale_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> ARKOSE_ROCK =                       BLOCKS.registerBlock("arkose_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> MARBLE_ROCK =                       BLOCKS.registerBlock("marble_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> QUARTZITE_ROCK =                    BLOCKS.registerBlock("quartzite_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> HORNFELS_ROCK =                     BLOCKS.registerBlock("hornfels_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SLATE_ROCK =                        BLOCKS.registerBlock("slate_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> GABBRO_ROCK =                       BLOCKS.registerBlock("gabbro_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SMOOTH_DIORITE_ROCK =               BLOCKS.registerBlock("smooth_diorite_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SMOOTH_GRANITE_ROCK =               BLOCKS.registerBlock("smooth_granite_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> NORITE_ROCK =                       BLOCKS.registerBlock("norite_rock", RockBlock::new, ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> PERIDOTITE_ROCK =                   BLOCKS.registerBlock("peridotite_rock", RockBlock::new, ROCK_PROPERTIES);
    // LARGE ROCK
    public static final DeferredBlock<WorldLitterBlock> LARGE_SANDSTONE_ROCK =              BLOCKS.registerBlock("large_sandstone_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_RED_SANDSTONE_ROCK =          BLOCKS.registerBlock("large_red_sandstone_rock",    RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SAPROLITE_ROCK =              BLOCKS.registerBlock("large_saprolite_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_LATERITE_ROCK =               BLOCKS.registerBlock("large_laterite_rock",         RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SILT_CLUMP =                  BLOCKS.registerBlock("large_silt_clump",            RockBlock::new, LARGE_CLUMP_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_GREYWACKE_ROCK =              BLOCKS.registerBlock("large_greywacke_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SILTSTONE_ROCK =              BLOCKS.registerBlock("large_siltstone_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_DOLOSTONE_ROCK =              BLOCKS.registerBlock("large_dolostone_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_LIMESTONE_ROCK =              BLOCKS.registerBlock("large_limestone_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_IRONSTONE_ROCK =              BLOCKS.registerBlock("large_ironstone_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SHALE_ROCK =                  BLOCKS.registerBlock("large_shale_rock",            RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_ARKOSE_ROCK =                 BLOCKS.registerBlock("large_arkose_rock",           RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_MARBLE_ROCK =                 BLOCKS.registerBlock("large_marble_rock",           RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_QUARTZITE_ROCK =              BLOCKS.registerBlock("large_quartzite_rock",        RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_HORNFELS_ROCK =               BLOCKS.registerBlock("large_hornfels_rock",         RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SLATE_ROCK =                  BLOCKS.registerBlock("large_slate_rock",            RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_GABBRO_ROCK =                 BLOCKS.registerBlock("large_gabbro_rock",           RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SMOOTH_DIORITE_ROCK =         BLOCKS.registerBlock("large_smooth_diorite_rock",   RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_SMOOTH_GRANITE_ROCK =         BLOCKS.registerBlock("large_smooth_granite_rock",   RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_NORITE_ROCK =                 BLOCKS.registerBlock("large_norite_rock",           RockBlock::new, LARGE_ROCK_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LARGE_PERIDOTITE_ROCK =             BLOCKS.registerBlock("large_peridotite_rock",       RockBlock::new, LARGE_ROCK_PROPERTIES);
    // COPPER ROCK
    public static final DeferredBlock<WorldLitterBlock> SAPROLITE_ROCK_COPPER_ORE =         BLOCKS.registerBlock("saprolite_rock_copper_ore",   RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> GREYWACKE_ROCK_COPPER_ORE =         BLOCKS.registerBlock("greywacke_rock_copper_ore",   RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SILTSTONE_ROCK_COPPER_ORE =         BLOCKS.registerBlock( "siltstone_rock_copper_ore",  RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> DOLOSTONE_ROCK_COPPER_ORE =         BLOCKS.registerBlock( "dolostone_rock_copper_ore",  RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> LIMESTONE_ROCK_COPPER_ORE =         BLOCKS.registerBlock( "limestone_rock_copper_ore",  RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> CHALK_ROCK_COPPER_ORE =             BLOCKS.registerBlock( "chalk_rock_copper_ore",      RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> IRONSTONE_ROCK_COPPER_ORE =         BLOCKS.registerBlock( "ironstone_rock_copper_ore",  RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SHALE_ROCK_COPPER_ORE =             BLOCKS.registerBlock( "shale_rock_copper_ore",      RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> ARKOSE_ROCK_COPPER_ORE =            BLOCKS.registerBlock( "arkose_rock_copper_ore",     RockBlock::new, ROCK_COPPER_ORE_PROPERTIES);

    // WOOD PROPERTIES
    public static BlockBehaviour.Properties BRANCH_PROPERTIES =                             BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).strength(0.05f).sound(SoundType.WOOD);
    // TWIG
    public static final DeferredBlock<TwigsBlock> TWIGS =                                   BLOCKS.registerBlock("twigs", TwigsBlock::new, BRANCH_PROPERTIES);
    // BRANCH
    public static final DeferredBlock<WorldLitterBlock> BIRCH_BRANCH =                      BLOCKS.registerBlock("birch_branch",        BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> OAK_BRANCH =                        BLOCKS.registerBlock("oak_branch",          BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> SPRUCE_BRANCH =                     BLOCKS.registerBlock("spruce_branch",       BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> JUNGLE_BRANCH =                     BLOCKS.registerBlock("jungle_branch",       BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> DARK_OAK_BRANCH =                   BLOCKS.registerBlock("dark_oak_branch",     BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> ACACIA_BRANCH =                     BLOCKS.registerBlock("acacia_branch",       BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> CHERRY_BRANCH =                     BLOCKS.registerBlock("cherry_branch",       BranchBlock::new, BRANCH_PROPERTIES);
    public static final DeferredBlock<WorldLitterBlock> MANGROVE_BRANCH =                   BLOCKS.registerBlock("mangrove_branch",     BranchBlock::new, BRANCH_PROPERTIES);
    // Poplar

    // PLANT Properties
    static BlockBehaviour.Properties PLANT_PROPERTIES =                                     BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).noCollission().replaceable().strength(0.05f).sound(SoundType.GRASS);
    static BlockBehaviour.Properties DOGBANE_PROPERTIES =                                   BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(0.3f).sound(SoundType.GRASS).randomTicks();
    static BlockBehaviour.Properties WILD_CROP_PROPERTIES =                                 BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).ignitedByLava().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).noCollission().strength(0.05f).sound(SoundType.CROP);
    static BlockBehaviour.Properties WILD_YAM_PROPERTIES =                                  WILD_CROP_PROPERTIES;
    static BlockBehaviour.Properties CROP_PROPERTIES =                                      BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY);
    static BlockBehaviour.Properties YAMS_PROPERTIES =                                      CROP_PROPERTIES;
    // PLANT LITTER
    public static final DeferredBlock<WorldPlantBlock.BasicWorldPlantBlock> SHRUB =         BLOCKS.registerBlock("shrub", WorldPlantBlock.BasicWorldPlantBlock::new, PLANT_PROPERTIES);
    public static final DeferredBlock<Block> DOGBANE =                                      BLOCKS.registerBlock("dogbane", DogbaneBlock::new, DOGBANE_PROPERTIES);
    // WILD CROPS
    public static final DeferredBlock<WorldPlantBlock.BasicWorldPlantBlock> WILD_YAMS =     BLOCKS.registerBlock("wild_yams", WorldPlantBlock.BasicWorldPlantBlock::new, WILD_YAM_PROPERTIES);
    // CROPS
    public static final DeferredBlock<YamBlock> YAMS =                                      BLOCKS.registerBlock("yams", YamBlock::new, YAMS_PROPERTIES);

    // PRIMITIVE TECHNOLOGY PROPERTIES
    public static final BlockBehaviour.Properties THATCH_PROPERTIES =                       BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).strength(0.5f).sound(SoundType.AZALEA_LEAVES);
    public static final BlockBehaviour.Properties FIRE_LAY_PROPERTIES =                     THATCH_PROPERTIES;
    public static final BlockBehaviour.Properties STONE_WORKBENCH_PROPERTIES =              BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0f).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties STONE_BENCH_PROPERTIES =                  STONE_WORKBENCH_PROPERTIES;
    public static final BlockBehaviour.Properties WOOD_WORKBENCH_PROPERTIES =               BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0f).sound(SoundType.WOOD);
    public static final BlockBehaviour.Properties CHOPPING_BLOCK_PROPERTIES =               WOOD_WORKBENCH_PROPERTIES;
    // THATCH
    public static final DeferredBlock<RotatedPillarBlock>                                   THATCH = BLOCKS.registerBlock("thatch_block", RotatedPillarBlock::new, THATCH_PROPERTIES);
    public static final DeferredBlock<FireLayBlock>                                         FIRE_LAY = BLOCKS.registerBlock("fire_lay", FireLayBlock::new, FIRE_LAY_PROPERTIES);
    // WORKBENCH
    public static final DeferredBlock<StoneBenchBlock>                                      STONE_BENCH = BLOCKS.registerBlock("stone_bench", StoneBenchBlock::new, STONE_BENCH_PROPERTIES);
    public static final DeferredBlock<ChoppingBlockBlock>                                   CHOPPING_BLOCK = BLOCKS.registerBlock("chopping_block", ChoppingBlockBlock::new, CHOPPING_BLOCK_PROPERTIES);

    // POTTERY PROPERTIES
    public static final BlockBehaviour.Properties POTTERY_DRYING_PROPERTIES =               BlockBehaviour.Properties.of().isViewBlocking((pState, pLevel, pPos) -> false).pushReaction(PushReaction.DESTROY).mapColor(MapColor.CLAY).strength(0.4f).sound(SoundType.MUD).randomTicks();
    public static final BlockBehaviour.Properties POTTERY_PROPERTIES =                      POTTERY_DRYING_PROPERTIES.pushReaction(PushReaction.BLOCK).mapColor(MapColor.TERRACOTTA_BROWN).sound(SoundType.DECORATED_POT);
    // DRYING POTTERY
    public static final DeferredBlock<DryingBlock> DRYING_GATHERERS_JAR =                   BLOCKS.registerBlock("drying_gatherers_jar",    GatherersJarBlock.DryingGatherersJarBlock::new,                 POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_KEEPERS_CROCK =     BLOCKS.registerBlock("drying_keepers_crock",    KeepersCrockBlock.DryingKeepersCrockBlockHorizontalAxis::new,   POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_SETTLERS_POT =      BLOCKS.registerBlock("drying_settlers_pot",     SettlersPotBlock.DryingSettlersPotBlockHorizontalAxis::new,     POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_CLAY_COOKING_POT =  BLOCKS.registerBlock("drying_clay_cooking_pot", ClayCookingPotBlock.DryingClayCookingPotBlock::new,             POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlockHorizontalAxis> DRYING_CLAY_CAULDRON =     BLOCKS.registerBlock("drying_clay_cauldron",    ClayCauldronBlock.DryingClayCauldronBlock::new,                 POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlockHorizontalFacing> DRYING_JUG =             BLOCKS.registerBlock("drying_jug",              JugBlock.DryingJugBlock::new,                                   POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlock> DRYING_FLOWER_POT =                      BLOCKS.registerBlock("drying_flower_pot", DryingBlock.BasicDryingBlock::new, POTTERY_DRYING_PROPERTIES);
    public static final DeferredBlock<DryingBlock> DRYING_DECORATED_POT =                   BLOCKS.registerBlock("drying_decorated_pot", DryingBlock.BasicDryingBlock::new, POTTERY_DRYING_PROPERTIES);
    // FIRED POTTERY
    public static final DeferredBlock<GatherersJarBlock> GATHERERS_JAR =                    BLOCKS.registerBlock("gatherers_jar",           GatherersJarBlock::new,                                         POTTERY_PROPERTIES);
    public static final DeferredBlock<KeepersCrockBlock> KEEPERS_CROCK =                    BLOCKS.registerBlock("keepers_crock",           KeepersCrockBlock::new,                                         POTTERY_PROPERTIES);
    public static final DeferredBlock<SettlersPotBlock> SETTLERS_POT =                      BLOCKS.registerBlock("settlers_pot",            SettlersPotBlock::new,                                          POTTERY_PROPERTIES);
    public static final DeferredBlock<ClayCookingPotBlock> CLAY_COOKING_POT =               BLOCKS.registerBlock("clay_cooking_pot",        ClayCookingPotBlock::new,                                       POTTERY_PROPERTIES);
    public static final DeferredBlock<ClayCauldronBlock> CLAY_CAULDRON =                    BLOCKS.registerBlock("clay_cauldron",           ClayCauldronBlock::new,                                         POTTERY_PROPERTIES);
    public static final DeferredBlock<JugBlock> JUG =                                       BLOCKS.registerBlock("jug",                     JugBlock::new,                                                  POTTERY_PROPERTIES);
    // TODO Birch Pot
    public static final DeferredBlock<Block> FLOWER_POT =                                   new VanillaDeferredBlock<>(Blocks.FLOWER_POT);
    // TODO Support player right clicking face with SHERDS
    public static final DeferredBlock<Block> DECORATED_POT =                                new VanillaDeferredBlock<>(Blocks.DECORATED_POT);
}
