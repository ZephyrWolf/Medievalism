package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import io.github.zephyrwolf.medievalism.Registration;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MedievalismConstants.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEDIEVALISM_TAB = CREATIVE_MODE_TABS.register("medievalism_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Registration.RED_CLAY_BLOCK.asItem()))
                    .title(Component.translatable("creative_tab.medievalism.name"))
                    .displayItems(ModCreativeModeTabs::itemsForMedievalismTab)
                    .build());

    private static void itemsForMedievalismTab(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput)
    {
        for (DeferredHolder<Item, ? extends Item> item : Registration.ITEMS.getEntries())
        {
            pOutput.accept(item.get());
        }

        /*
        pOutput.accept(Registration.LIMESTONE_ITEM.get());
        pOutput.accept(Registration.BRANCH_ITEM.get());
        pOutput.accept(Registration.LARGE_ROCK_ITEM.get());
        pOutput.accept(Registration.ROCK_ITEM.get());
        pOutput.accept(Registration.COPPER_ROCK_ITEM.get());
        pOutput.accept(Registration.LIMESTONE_ROCK_BLOCK);
        pOutput.accept(Registration.THATCH_BLOCK_ITEM.get());

        { // World
            pOutput.accept(Registration.RED_CLAY_BALL.get());
            pOutput.accept(Registration.RED_CLAY_BLOCK_ITEM.get());
            pOutput.accept(Registration.DOG_BANE.get());
            pOutput.accept(Registration.FLAX.get());
            pOutput.accept(Registration.FLAX_SEEDS.get());
            pOutput.accept(Registration.FLAX_FIBER.get());
            // Wild Potato
            // Wild Carrot
            // Wild Beetroot
            // Wild Yam
        }
        { // Farming

            pOutput.accept(Registration.BLUEBERRIES.get());
            pOutput.accept(Registration.RASPBERRIES.get());
            pOutput.accept(Registration.STRAWBERRIES.get());
            pOutput.accept(Registration.BARLEY_SEEDS.get());
            pOutput.accept(Registration.BARLEY.get());
            pOutput.accept(Registration.OAT_SEEDS.get());
            pOutput.accept(Registration.OATS.get());
            pOutput.accept(Registration.YAM.get());
            pOutput.accept(Registration.BAKED_YAM.get());
            pOutput.accept(Registration.BAKED_BEETROOT.get());
            pOutput.accept(Registration.BAKED_CARROT.get());
            pOutput.accept(Registration.CRACKED_BARLEY.get());
            pOutput.accept(Registration.CRACKED_WHEAT.get());
            pOutput.accept(Registration.ROLLED_OATS.get());
            pOutput.accept(Registration.FLOUR.get());
            pOutput.accept(Registration.DOUGH.get());
        }
        { // Knapping
            pOutput.accept(Registration.LUNATE.get());
            pOutput.accept(Registration.BIFACE.get());
        }
        { // Pottery
            pOutput.accept(Registration.UNFIRED_BRICK.get());
            pOutput.accept(Registration.UNFIRED_JUG.get());
            pOutput.accept(Registration.JUG.get());
            pOutput.accept(Registration.UNFIRED_CRUCIBLE.get());
            pOutput.accept(Registration.CRUCIBLE.get());
        }
        { // Leather Working
            // Hide
            pOutput.accept(Registration.COW_HIDE.get());
            pOutput.accept(Registration.DONKEY_HIDE.get());
            pOutput.accept(Registration.HOGLIN_HIDE.get());
            pOutput.accept(Registration.HORSE_HIDE.get());
            pOutput.accept(Registration.MOOSHROOM_HIDE.get());
            pOutput.accept(Registration.MULE_HIDE.get());
            //pOutput.accept(Registration.RABBIT_HIDE.get());
            pOutput.accept(Registration.RAVAGER_HIDE.get()); // Should this be extra large?
            pOutput.accept(Registration.SHEEP_HIDE.get());
            pOutput.accept(Registration.FOX_HIDE.get());
            pOutput.accept(Registration.SNOW_FOX_HIDE.get());
            pOutput.accept(Registration.WOLF_HIDE.get()); // Only one variable
            pOutput.accept(Registration.OCELOT_HIDE.get());
            pOutput.accept(Registration.CAT_HIDE.get()); // Only one variable

            // Leather
            pOutput.accept(Registration.LARGE_LIMED_HIDE.get());
            pOutput.accept(Registration.MEDIUM_LIMED_HIDE.get());
            pOutput.accept(Registration.SMALL_LIMED_HIDE.get());
            pOutput.accept(Registration.LARGE_RAW_HIDE.get());
            pOutput.accept(Registration.MEDIUM_RAW_HIDE.get());
            pOutput.accept(Registration.SMALL_RAW_HIDE.get());
            pOutput.accept(Registration.LARGE_WET_LEATHER.get());
            pOutput.accept(Registration.MEDIUM_WET_LEATHER.get());
            pOutput.accept(Registration.SMALL_WET_LEATHER.get());
            // Large Leather -> minecraft:leather
            pOutput.accept(Registration.MEDIUM_LEATHER.get());
            pOutput.accept(Registration.SMALL_LEATHER.get());
        }

        { // Misc
            pOutput.accept(Registration.QUICK_LIME.get());
            pOutput.accept(Registration.THATCH.get());
            pOutput.accept(Registration.CHOPPED_WOOD.get());
            pOutput.accept(Registration.SLACKED_LIME_BUCKET.get());
            pOutput.accept(Registration.TANNIN_BUCKET.get());
            pOutput.accept(Registration.DIGGING_STICK.get());
            pOutput.accept(Registration.FIRE_STARTER.get());
        }
        */
    }
    
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
