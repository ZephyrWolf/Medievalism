package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.VanillaDeferredItem;
import io.github.zephyrwolf.medievalism.common.item.ContainerItemBlockItem;
import io.github.zephyrwolf.medievalism.common.item.DryingBlockItem;
import io.github.zephyrwolf.medievalism.common.item.DryingBrickBlockItem;
import io.github.zephyrwolf.medievalism.common.item.GatherersJarBlockItem;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class ClayWorkingItemRegistration
{
    public static final DeferredRegister.Items CLAY_WORKING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        CLAY_WORKING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return CLAY_WORKING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == CLAY WORKING ==
    public static final DeferredItem<Item> CLAY_BALL =              new VanillaDeferredItem<>(Items.CLAY_BALL);
    public static final DeferredItem<Item> CHINA_CLAY_BALL =        CLAY_WORKING_ITEMS.registerSimpleItem("china_clay_ball");
    public static final DeferredItem<Item> GROG =                   CLAY_WORKING_ITEMS.registerSimpleItem("grog");
    public static final DeferredItem<Item> KAOLIN_CLAY_BALL =       CLAY_WORKING_ITEMS.registerSimpleItem("kaolin_clay_ball");
    public static final DeferredItem<Item> KAOLIN_GROG =            CLAY_WORKING_ITEMS.registerSimpleItem("kaolin_grog");
    public static final DeferredItem<Item> POTTERS_CLAY_BALL =      CLAY_WORKING_ITEMS.registerSimpleItem("potters_clay_ball");
    public static final DeferredItem<Item> REFRACTORY_CLAY_BALL =   CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_ball");
    public static final DeferredItem<Item> REFRACTORY_GROG =        CLAY_WORKING_ITEMS.registerSimpleItem("refractory_grog");

    public static final DeferredItem<Item> CLAY = new VanillaDeferredItem<>(Items.CLAY);
    public static final DeferredItem<BlockItem> POTTERS_CLAY = CLAY_WORKING_ITEMS.registerSimpleBlockItem(BlockRegistration.POTTERS_CLAY);
    public static final DeferredItem<BlockItem> KAOLIN_CLAY = CLAY_WORKING_ITEMS.registerSimpleBlockItem(BlockRegistration.KAOLIN_CLAY);
    public static final DeferredItem<BlockItem> CHINA_CLAY = CLAY_WORKING_ITEMS.registerSimpleBlockItem(BlockRegistration.CHINA_CLAY);
    public static final DeferredItem<BlockItem> REFRACTORY_CLAY = CLAY_WORKING_ITEMS.registerSimpleBlockItem(BlockRegistration.REFRACTORY_CLAY);

    // - BRICK
    public static final DeferredItem<Item>                      CLAY_BRICK =                    new VanillaDeferredItem<>(Items.BRICK);
    public static final DeferredItem<Item>                      CHINA_CLAY_BRICK =              CLAY_WORKING_ITEMS.registerSimpleItem("china_clay_brick");
    public static final DeferredItem<Item>                      REFRACTORY_CLAY_BRICK =         CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_brick");
    public static final DeferredItem<Item>                      UNFIRED_CLAY_BRICK =            CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_brick");
    public static final DeferredItem<Item>                      UNFIRED_CHINA_CLAY_BRICK =      CLAY_WORKING_ITEMS.registerSimpleItem("unfired_china_clay_brick");
    public static final DeferredItem<Item>                      UNFIRED_KAOLIN_CLAY_BRICK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_kaolin_clay_brick");
    public static final DeferredItem<Item>                      UNFIRED_POTTERS_CLAY_BRICK =    CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_brick");
    public static final DeferredItem<Item>                      UNFIRED_REFRACTORY_CLAY_BRICK = CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_brick");
    public static final DeferredItem<DryingBrickBlockItem>      DRYING_CLAY_BRICK =             CLAY_WORKING_ITEMS.registerItem("drying_clay_brick",                             props -> new DryingBrickBlockItem(BlockRegistration.DRYING_CLAY_BRICK, props, false));
    public static final DeferredItem<DryingBrickBlockItem>      DRYING_CHINA_CLAY_BRICK =       CLAY_WORKING_ITEMS.registerItem("drying_china_clay_brick", props -> new DryingBrickBlockItem(BlockRegistration.DRYING_CHINA_CLAY_BRICK, props, false));
    public static final DeferredItem<DryingBrickBlockItem>      DRYING_KAOLIN_CLAY_BRICK =      CLAY_WORKING_ITEMS.registerItem("drying_kaolin_clay_brick",                      props -> new DryingBrickBlockItem(BlockRegistration.DRYING_KAOLIN_CLAY_BRICK, props, false));
    public static final DeferredItem<DryingBrickBlockItem>      DRYING_POTTERS_CLAY_BRICK =     CLAY_WORKING_ITEMS.registerItem("drying_potters_clay_brick",                     props -> new DryingBrickBlockItem(BlockRegistration.DRYING_POTTERS_CLAY_BRICK, props, false));
    public static final DeferredItem<DryingBrickBlockItem>      DRYING_REFRACTORY_CLAY_BRICK =  CLAY_WORKING_ITEMS.registerItem("drying_refractory_clay_brick",                  props -> new DryingBrickBlockItem(BlockRegistration.DRYING_REFRACTORY_CLAY_BRICK, props, false));

    // - DOUBLE BRICK
    public static final DeferredItem<Item>                      CLAY_DOUBLE_BRICK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_double_brick");
    public static final DeferredItem<Item>                      CHINA_CLAY_DOUBLE_BRICK =               CLAY_WORKING_ITEMS.registerSimpleItem("china_clay_double_brick");
    public static final DeferredItem<Item>                      REFRACTORY_CLAY_DOUBLE_BRICK =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_double_brick");
    public static final DeferredItem<Item>                      UNFIRED_CLAY_DOUBLE_BRICK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_double_brick");
    public static final DeferredItem<Item>                      UNFIRED_CHINA_CLAY_DOUBLE_BRICK =       CLAY_WORKING_ITEMS.registerSimpleItem("unfired_china_clay_double_brick");
    public static final DeferredItem<Item>                      UNFIRED_KAOLIN_CLAY_DOUBLE_BRICK =      CLAY_WORKING_ITEMS.registerSimpleItem("unfired_kaolin_clay_double_brick");
    public static final DeferredItem<Item>                      UNFIRED_POTTERS_CLAY_DOUBLE_BRICK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_double_brick");
    public static final DeferredItem<Item>                      UNFIRED_REFRACTORY_CLAY_DOUBLE_BRICK =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_double_brick");
    public static final DeferredItem<DryingBlockItem>           DRYING_CLAY_DOUBLE_BRICK =              CLAY_WORKING_ITEMS.registerItem("drying_clay_double_brick",              props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_DOUBLE_BRICK, props, false));
    public static final DeferredItem<DryingBlockItem>           DRYING_CHINA_CLAY_DOUBLE_BRICK =        CLAY_WORKING_ITEMS.registerItem("drying_china_clay_double_brick",        props -> new DryingBlockItem(BlockRegistration.DRYING_CHINA_CLAY_DOUBLE_BRICK, props, false));
    public static final DeferredItem<DryingBlockItem>           DRYING_KAOLIN_CLAY_DOUBLE_BRICK =       CLAY_WORKING_ITEMS.registerItem("drying_kaolin_clay_double_brick",       props -> new DryingBlockItem(BlockRegistration.DRYING_POTTERS_CLAY_DOUBLE_BRICK, props, false));
    public static final DeferredItem<DryingBlockItem>           DRYING_POTTERS_CLAY_DOUBLE_BRICK =      CLAY_WORKING_ITEMS.registerItem("drying_potters_clay_double_brick",      props -> new DryingBlockItem(BlockRegistration.DRYING_KAOLIN_CLAY_DOUBLE_BRICK, props, false));
    public static final DeferredItem<DryingBlockItem>           DRYING_REFRACTORY_CLAY_DOUBLE_BRICK =   CLAY_WORKING_ITEMS.registerItem("drying_refractory_clay_double_brick",   props -> new DryingBlockItem(BlockRegistration.DRYING_REFRACTORY_CLAY_DOUBLE_BRICK, props, false));

    // - INGOT_MOULD
    public static final DeferredItem<Item>                      CLAY_INGOT_MOULD =                      CLAY_WORKING_ITEMS.registerSimpleItem("clay_ingot_mould");
    public static final DeferredItem<Item>                      REFRACTORY_CLAY_INGOT_MOULD =           CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_ingot_mould");
    public static final DeferredItem<Item>                      UNFIRED_CLAY_INGOT_MOULD =              CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_ingot_mould");
    public static final DeferredItem<Item>                      UNFIRED_POTTERS_CLAY_INGOT_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_ingot_mould");
    public static final DeferredItem<Item>                      UNFIRED_REFRACTORY_CLAY_INGOT_MOULD =   CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_ingot_mould");
    public static final DeferredItem<Item>                      WET_REFRACTORY_CLAY_INGOT_MOULD =       CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_ingot_mould");
    public static final DeferredItem<Item>                      WET_CLAY_INGOT_MOULD =                  CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_ingot_mould");
    public static final DeferredItem<Item>                      WET_POTTERS_CLAY_INGOT_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_ingot_mould");

    // - BUCKET
    public static final DeferredItem<Item>                      CLAY_BUCKET =                           CLAY_WORKING_ITEMS.registerSimpleItem("clay_bucket");
    public static final DeferredItem<Item>                      REFRACTORY_CLAY_BUCKET =                CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_bucket");
    public static final DeferredItem<Item>                      UNFIRED_CLAY_BUCKET =                   CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_bucket");
    public static final DeferredItem<Item>                      UNFIRED_POTTERS_CLAY_BUCKET =           CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_bucket");
    public static final DeferredItem<Item>                      UNFIRED_REFRACTORY_CLAY_BUCKET =        CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_bucket");
    public static final DeferredItem<Item>                      WET_REFRACTORY_CLAY_BUCKET =            CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_bucket");
    public static final DeferredItem<Item>                      WET_CLAY_BUCKET =                       CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_bucket");
    public static final DeferredItem<Item>                      WET_POTTERS_CLAY_BUCKET =               CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_bucket");

    // - CRUCIBLE
    public static final DeferredItem<Item>                      CLAY_CRUCIBLE =                         CLAY_WORKING_ITEMS.registerSimpleItem("clay_crucible");
    public static final DeferredItem<Item>                      REFRACTORY_CLAY_CRUCIBLE =              CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_crucible");
    public static final DeferredItem<Item>                      UNFIRED_CLAY_CRUCIBLE =                 CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_crucible");
    public static final DeferredItem<Item>                      UNFIRED_POTTERS_CLAY_CRUCIBLE =         CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_crucible");
    public static final DeferredItem<Item>                      UNFIRED_REFRACTORY_CLAY_CRUCIBLE =      CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_crucible");
    public static final DeferredItem<Item>                      WET_REFRACTORY_CLAY_CRUCIBLE =          CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_crucible");
    public static final DeferredItem<Item>                      WET_CLAY_CRUCIBLE =                     CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_crucible");
    public static final DeferredItem<Item>                      WET_POTTERS_CLAY_CRUCIBLE =             CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_crucible");

    // - AXE_MOULD
    public static final DeferredItem<Item>  CLAY_AXE_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_axe_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_AXE_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_axe_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_AXE_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_axe_blank");
    public static final DeferredItem<Item>  WET_CLAY_AXE_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_axe_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_AXE_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_axe_blank");
    public static final DeferredItem<Item>  CLAY_AXE_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_axe_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_AXE_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_axe_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_AXE_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_axe_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_AXE_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_axe_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_AXE_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_axe_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_AXE_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_axe_mould");
    public static final DeferredItem<Item>  WET_CLAY_AXE_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_axe_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_AXE_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_axe_mould");

    // - GREATAXE_MOULD
    //public static final DeferredItem<Item>  CLAY_GREATAXE_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_greataxe_mould");
    //public static final DeferredItem<Item>  REFRACTORY_CLAY_GREATAXE_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_greataxe_mould");
    //public static final DeferredItem<Item>  UNFIRED_CLAY_GREATAXE_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_greataxe_mould");
    //public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_GREATAXE_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_greataxe_mould");
    //public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_GREATAXE_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_greataxe_mould");
    //public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_GREATAXE_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_greataxe_mould");
    //public static final DeferredItem<Item>  WET_CLAY_GREATAXE_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_greataxe_mould");
    //public static final DeferredItem<Item>  WET_POTTERS_CLAY_GREATAXE_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_greataxe_mould");

    // - HOE_MOULD
    public static final DeferredItem<Item>  CLAY_HOE_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_hoe_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_HOE_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_hoe_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_HOE_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_hoe_blank");
    public static final DeferredItem<Item>  WET_CLAY_HOE_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_hoe_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_HOE_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_hoe_blank");
    public static final DeferredItem<Item>  CLAY_HOE_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_hoe_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_HOE_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_hoe_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_HOE_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_hoe_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_HOE_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_hoe_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_HOE_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_hoe_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_HOE_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_hoe_mould");
    public static final DeferredItem<Item>  WET_CLAY_HOE_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_hoe_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_HOE_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_hoe_mould");

    // - KNIFE_MOULD
    public static final DeferredItem<Item>  CLAY_KNIFE_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_knife_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_KNIFE_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_knife_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_KNIFE_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_knife_blank");
    public static final DeferredItem<Item>  WET_CLAY_KNIFE_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_knife_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_KNIFE_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_knife_blank");
    public static final DeferredItem<Item>  CLAY_KNIFE_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_knife_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_KNIFE_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_knife_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_KNIFE_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_knife_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_KNIFE_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_knife_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_KNIFE_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_knife_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_KNIFE_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_knife_mould");
    public static final DeferredItem<Item>  WET_CLAY_KNIFE_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_knife_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_KNIFE_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_knife_mould");

    // - LONGSWORD_MOULD
    //public static final DeferredItem<Item>  CLAY_LONGSWORD_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_longsword_mould");
    //public static final DeferredItem<Item>  REFRACTORY_CLAY_LONGSWORD_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_longsword_mould");
    //public static final DeferredItem<Item>  UNFIRED_CLAY_LONGSWORD_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_longsword_mould");
    //public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_LONGSWORD_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_longsword_mould");
    //public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_LONGSWORD_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_longsword_mould");
    //public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_LONGSWORD_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_longsword_mould");
    //public static final DeferredItem<Item>  WET_CLAY_LONGSWORD_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_longsword_mould");
    //public static final DeferredItem<Item>  WET_POTTERS_CLAY_LONGSWORD_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_longsword_mould");

    // - PICKAXE_MOULD
    public static final DeferredItem<Item>  CLAY_PICKAXE_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_pickaxe_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_PICKAXE_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_pickaxe_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_PICKAXE_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_pickaxe_blank");
    public static final DeferredItem<Item>  WET_CLAY_PICKAXE_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_pickaxe_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_PICKAXE_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_pickaxe_blank");
    public static final DeferredItem<Item>  CLAY_PICKAXE_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_pickaxe_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_PICKAXE_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_pickaxe_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_PICKAXE_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_pickaxe_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_PICKAXE_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_pickaxe_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_PICKAXE_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_pickaxe_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_PICKAXE_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_pickaxe_mould");
    public static final DeferredItem<Item>  WET_CLAY_PICKAXE_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_pickaxe_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_PICKAXE_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_pickaxe_mould");

    // - SHORTSWORD_MOULD
    public static final DeferredItem<Item>  CLAY_SHORTSWORD_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_shortsword_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SHORTSWORD_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_shortsword_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SHORTSWORD_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_shortsword_blank");
    public static final DeferredItem<Item>  WET_CLAY_SHORTSWORD_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_shortsword_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SHORTSWORD_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_shortsword_blank");
    public static final DeferredItem<Item>  CLAY_SHORTSWORD_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_shortsword_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_SHORTSWORD_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_shortsword_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SHORTSWORD_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_shortsword_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SHORTSWORD_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_shortsword_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_SHORTSWORD_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_shortsword_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_SHORTSWORD_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_shortsword_mould");
    public static final DeferredItem<Item>  WET_CLAY_SHORTSWORD_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_shortsword_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SHORTSWORD_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_shortsword_mould");

    // - SCYTH_MOULD
    //public static final DeferredItem<Item>  CLAY_SCYTH_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_scyth_mould");
    //public static final DeferredItem<Item>  REFRACTORY_CLAY_SCYTH_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_scyth_mould");
    //public static final DeferredItem<Item>  UNFIRED_CLAY_SCYTH_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_scyth_mould");
    //public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SCYTH_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_scyth_mould");
    //public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_SCYTH_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_scyth_mould");
    //public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_SCYTH_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_scyth_mould");
    //public static final DeferredItem<Item>  WET_CLAY_SCYTH_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_scyth_mould");
    //public static final DeferredItem<Item>  WET_POTTERS_CLAY_SCYTH_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_scyth_mould");

    // - SHOVEL_MOULD
    public static final DeferredItem<Item>  CLAY_SHOVEL_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_shovel_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SHOVEL_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_shovel_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SHOVEL_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_shovel_blank");
    public static final DeferredItem<Item>  WET_CLAY_SHOVEL_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_shovel_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SHOVEL_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_shovel_blank");
    public static final DeferredItem<Item>  CLAY_SHOVEL_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_shovel_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_SHOVEL_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_shovel_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SHOVEL_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_shovel_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SHOVEL_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_shovel_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_SHOVEL_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_shovel_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_SHOVEL_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_shovel_mould");
    public static final DeferredItem<Item>  WET_CLAY_SHOVEL_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_shovel_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SHOVEL_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_shovel_mould");

    // - SICKLE_MOULD
    public static final DeferredItem<Item>  CLAY_SICKLE_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_sickle_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SICKLE_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_sickle_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SICKLE_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_sickle_blank");
    public static final DeferredItem<Item>  WET_CLAY_SICKLE_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_sickle_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SICKLE_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_sickle_blank");
    public static final DeferredItem<Item>  CLAY_SICKLE_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_sickle_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_SICKLE_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_sickle_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SICKLE_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_sickle_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SICKLE_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_sickle_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_SICKLE_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_sickle_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_SICKLE_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_sickle_mould");
    public static final DeferredItem<Item>  WET_CLAY_SICKLE_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_sickle_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SICKLE_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_sickle_mould");

    // - SPEAR_MOULD
    public static final DeferredItem<Item>  CLAY_SPEAR_BLANK =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_spear_blank");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SPEAR_BLANK =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_spear_blank");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SPEAR_BLANK =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_spear_blank");
    public static final DeferredItem<Item>  WET_CLAY_SPEAR_BLANK =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_spear_blank");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SPEAR_BLANK =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_spear_blank");
    public static final DeferredItem<Item>  CLAY_SPEAR_MOULD =                     CLAY_WORKING_ITEMS.registerSimpleItem("clay_spear_mould");
    public static final DeferredItem<Item>  REFRACTORY_CLAY_SPEAR_MOULD =          CLAY_WORKING_ITEMS.registerSimpleItem("refractory_clay_spear_mould");
    public static final DeferredItem<Item>  UNFIRED_CLAY_SPEAR_MOULD =             CLAY_WORKING_ITEMS.registerSimpleItem("unfired_clay_spear_mould");
    public static final DeferredItem<Item>  UNFIRED_POTTERS_CLAY_SPEAR_MOULD =     CLAY_WORKING_ITEMS.registerSimpleItem("unfired_potters_clay_spear_mould");
    public static final DeferredItem<Item>  UNFIRED_REFRACTORY_CLAY_SPEAR_MOULD =  CLAY_WORKING_ITEMS.registerSimpleItem("unfired_refractory_clay_spear_mould");
    public static final DeferredItem<Item>  WET_REFRACTORY_CLAY_SPEAR_MOULD =      CLAY_WORKING_ITEMS.registerSimpleItem("wet_refractory_clay_spear_mould");
    public static final DeferredItem<Item>  WET_CLAY_SPEAR_MOULD =                 CLAY_WORKING_ITEMS.registerSimpleItem("wet_clay_spear_mould");
    public static final DeferredItem<Item>  WET_POTTERS_CLAY_SPEAR_MOULD =         CLAY_WORKING_ITEMS.registerSimpleItem("wet_potters_clay_spear_mould");

    // - GATHERERS_JAR
    public static final DeferredItem<DryingBlockItem> WET_GATHERERS_JAR =          CLAY_WORKING_ITEMS.registerItem("wet_gatherers_jar",                        props -> new DryingBlockItem(BlockRegistration.DRYING_GATHERERS_JAR, props, false));
    public static final DeferredItem<DryingBlockItem> DRY_GATHERERS_JAR =          CLAY_WORKING_ITEMS.registerItem("dry_gatherers_jar",                        props -> new DryingBlockItem(BlockRegistration.DRYING_GATHERERS_JAR, props, true));
    public static final DeferredItem<GatherersJarBlockItem> GATHERERS_JAR =        CLAY_WORKING_ITEMS.registerItem("gatherers_jar", props -> new GatherersJarBlockItem(BlockRegistration.GATHERERS_JAR, props.stacksTo(1)));

    // - KEEPERS_CROCK
    public static final DeferredItem<DryingBlockItem> WET_KEEPERS_CROCK =          CLAY_WORKING_ITEMS.registerItem("wet_keepers_crock",                        props -> new DryingBlockItem(BlockRegistration.DRYING_KEEPERS_CROCK, props, false));
    public static final DeferredItem<DryingBlockItem> DRY_KEEPERS_CROCK =          CLAY_WORKING_ITEMS.registerItem("dry_keepers_crock",                        props -> new DryingBlockItem(BlockRegistration.DRYING_KEEPERS_CROCK, props, true));
    public static final DeferredItem<ContainerItemBlockItem> KEEPERS_CROCK =       CLAY_WORKING_ITEMS.registerItem("keepers_crock", props -> new ContainerItemBlockItem(BlockRegistration.KEEPERS_CROCK, props.stacksTo(1)));

    // - SETTLERS_POT
    public static final DeferredItem<DryingBlockItem> WET_SETTLERS_POT =           CLAY_WORKING_ITEMS.registerItem("wet_settlers_pot",                         props -> new DryingBlockItem(BlockRegistration.DRYING_SETTLERS_POT, props, false));
    public static final DeferredItem<DryingBlockItem> DRY_SETTLERS_POT =           CLAY_WORKING_ITEMS.registerItem("dry_settlers_pot",                         props -> new DryingBlockItem(BlockRegistration.DRYING_SETTLERS_POT, props, true));
    public static final DeferredItem<BlockItem> SETTLERS_POT =                     CLAY_WORKING_ITEMS.registerSimpleBlockItem("settlers_pot",                  BlockRegistration.SETTLERS_POT);

    // - COOKING_POT
    public static final DeferredItem<DryingBlockItem> WET_CLAY_COOKING_POT =       CLAY_WORKING_ITEMS.registerItem("wet_clay_cooking_pot",                     props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_COOKING_POT, props, false));
    public static final DeferredItem<DryingBlockItem> DRY_CLAY_COOKING_POT =       CLAY_WORKING_ITEMS.registerItem("dry_clay_cooking_pot",                     props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_COOKING_POT, props, true));
    public static final DeferredItem<BlockItem> CLAY_COOKING_POT =                 CLAY_WORKING_ITEMS.registerSimpleBlockItem("clay_cooking_pot",              BlockRegistration.CLAY_COOKING_POT);

    // - CLAY_CAULDRON
    public static final DeferredItem<DryingBlockItem> WET_CLAY_CAULDRON =          CLAY_WORKING_ITEMS.registerItem("wet_clay_cauldron", props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_CAULDRON, props.stacksTo(1), false));
    public static final DeferredItem<DryingBlockItem> DRY_CLAY_CAULDRON =          CLAY_WORKING_ITEMS.registerItem("dry_clay_cauldron",                        props -> new DryingBlockItem(BlockRegistration.DRYING_CLAY_CAULDRON, props.stacksTo(1), true));
    public static final DeferredItem<BlockItem> CLAY_CAULDRON =                    CLAY_WORKING_ITEMS.registerSimpleBlockItem("clay_cauldron",                 BlockRegistration.CLAY_CAULDRON);

    // - BIRCH_POT
    // TODO

    // - JUG
    //public static final DeferredItem<DryingBlockItem> WET_JUG =                  ITEMS.registerItem("wet_jug",                                  props -> new DryingBlockItem(BlockRegistration.DRYING_JUG, props, false));
    //public static final DeferredItem<DryingBlockItem> DRY_JUG =                  ITEMS.registerItem("dry_jug",                                  props -> new DryingBlockItem(BlockRegistration.DRYING_JUG, props, true));
    //public static final DeferredItem<BlockItem> JUG =                            ITEMS.registerSimpleBlockItem("jug",                           BlockRegistration.JUG);

    // - POT
    // TODO

    // - DECORATED_POT
    public static final DeferredItem<DryingBlockItem> WET_DECORATED_POT =          CLAY_WORKING_ITEMS.registerItem("wet_decorated_pot",                        props -> new DryingBlockItem(BlockRegistration.DRYING_DECORATED_POT, props, false));
    public static final DeferredItem<DryingBlockItem> DRY_DECORATED_POT =          CLAY_WORKING_ITEMS.registerItem("dry_decorated_pot",                        props -> new DryingBlockItem(BlockRegistration.DRYING_DECORATED_POT, props, true));

    // - FLOWER_POT
    public static final DeferredItem<DryingBlockItem> WET_FLOWER_POT =             CLAY_WORKING_ITEMS.registerItem("wet_flower_pot",                           props -> new DryingBlockItem(BlockRegistration.DRYING_FLOWER_POT, props, false));
    public static final DeferredItem<DryingBlockItem> DRY_FLOWER_POT =             CLAY_WORKING_ITEMS.registerItem("dry_flower_pot",                           props -> new DryingBlockItem(BlockRegistration.DRYING_FLOWER_POT, props, true));
}
