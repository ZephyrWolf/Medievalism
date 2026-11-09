package io.github.zephyrwolf.medievalism.registration.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.item.KnifeItem;
import io.github.zephyrwolf.medievalism.catalogs.item.tier.MedievalismTierCatalog;
import io.github.zephyrwolf.medievalism.common.item.SickleItem;
import io.github.zephyrwolf.medievalism.common.item.SpearItem;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class KnappingItemRegistration
{
    public static final DeferredRegister.Items KNAPPING_ITEMS = DeferredRegister.createItems(MedievalismConstants.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        KNAPPING_ITEMS.register(modEventBus);
    }

    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block)
    { return registerBlockItem(name, func, block, new Item.Properties()); }
    protected static <I extends Item> DeferredItem<I> registerBlockItem(
            String name, BiFunction<Block, Item.Properties, ? extends I> func, Supplier<? extends Block> block, Item.Properties props)
    { return KNAPPING_ITEMS.register(name, key -> func.apply(block.get(), props)); }

    //region == KNAPPING ==
    public static final DeferredItem<BlockItem> STONE_BENCH = KNAPPING_ITEMS.registerSimpleBlockItem("stone_bench",                   BlockRegistration.STONE_BENCH);


    public static final DeferredItem<Item> BROKEN_GOAT_HORN = KNAPPING_ITEMS.registerSimpleItem("broken_goat_horn", new Item.Properties());
    @Deprecated
    public static final DeferredItem<Item> LUNATE = KNAPPING_ITEMS.registerSimpleItem("lunate", new Item.Properties());

    public static final DeferredItem<Item> ANTLER =                 KNAPPING_ITEMS.registerSimpleItem("antler", new Item.Properties());

    public static final DeferredItem<Item> ROCK_KNIFE_BLADE =       KNAPPING_ITEMS.registerSimpleItem("rock_knife_blade", new Item.Properties());
    public static final DeferredItem<Item> FLINT_KNIFE_BLADE =      KNAPPING_ITEMS.registerSimpleItem("flint_knife_blade", new Item.Properties());
    public static final DeferredItem<Item> BONE_KNIFE_BLADE =       KNAPPING_ITEMS.registerSimpleItem("bone_knife_blade", new Item.Properties());
    public static final DeferredItem<Item> ROCK_KNIFE =             KNAPPING_ITEMS.registerItem("rock_knife", props -> new KnifeItem(MedievalismTierCatalog.ROCK, props), new Item.Properties().component(DataComponents.TOOL, KnifeItem.createToolProperties()));
    public static final DeferredItem<Item> FLINT_KNIFE =            KNAPPING_ITEMS.registerItem("flint_knife", props -> new KnifeItem(MedievalismTierCatalog.FLINT, props), new Item.Properties().component(DataComponents.TOOL, KnifeItem.createToolProperties()));
    public static final DeferredItem<Item> BONE_KNIFE =             KNAPPING_ITEMS.registerItem("bone_knife", props -> new KnifeItem(MedievalismTierCatalog.BONE, props), new Item.Properties().component(DataComponents.TOOL, KnifeItem.createToolProperties()));

    public static final DeferredItem<Item> ROCK_AXE_HEAD =          KNAPPING_ITEMS.registerSimpleItem("rock_axe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_AXE =               KNAPPING_ITEMS.registerItem("rock_axe", props -> new AxeItem(MedievalismTierCatalog.ROCK, props), new Item.Properties());

    public static final DeferredItem<Item> ROCK_PICKAXE_HEAD =      KNAPPING_ITEMS.registerSimpleItem("rock_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> ANTLER_PICKAXE_HEAD =    KNAPPING_ITEMS.registerSimpleItem("antler_pickaxe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_PICKAXE =           KNAPPING_ITEMS.registerItem("rock_pickaxe", props -> new PickaxeItem(MedievalismTierCatalog.ROCK, props), new Item.Properties());
    public static final DeferredItem<Item> ANTLER_PICKAXE =         KNAPPING_ITEMS.registerItem("antler_pickaxe", props -> new PickaxeItem(MedievalismTierCatalog.BONE, props), new Item.Properties());

    public static final DeferredItem<Item> ROCK_HOE_HEAD =          KNAPPING_ITEMS.registerSimpleItem("rock_hoe_head", new Item.Properties());
    public static final DeferredItem<Item> ANTLER_HOE_HEAD =        KNAPPING_ITEMS.registerSimpleItem("antler_hoe_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_HOE =               KNAPPING_ITEMS.registerItem("rock_hoe", props -> new HoeItem(MedievalismTierCatalog.ROCK, props), new Item.Properties());
    public static final DeferredItem<Item> ANTLER_HOE =             KNAPPING_ITEMS.registerItem("antler_hoe", props -> new HoeItem(MedievalismTierCatalog.BONE, props), new Item.Properties());

    public static final DeferredItem<Item> ROCK_SPEAR_HEAD =        KNAPPING_ITEMS.registerSimpleItem("rock_spear_head", new Item.Properties());
    public static final DeferredItem<Item> ROCK_SPEAR =             KNAPPING_ITEMS.registerItem("rock_spear", props -> new SpearItem(MedievalismTierCatalog.ROCK, props), new Item.Properties().attributes(SpearItem.createAttributes()).component(DataComponents.TOOL, SpearItem.createToolProperties()));
    // Flint and Bone Spear

    public static final DeferredItem<Item> ROCK_SICKLE =            KNAPPING_ITEMS.registerItem("rock_sickle", props -> new SickleItem(MedievalismTierCatalog.ROCK, props), new Item.Properties().component(DataComponents.TOOL, SickleItem.createToolProperties()));

    //endregion
}
