package io.github.zephyrwolf.medievalism.content.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabRegistration
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MedievalismConstants.MOD_ID);

    @SuppressWarnings("unused")
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEDIEVALISM_TAB = CREATIVE_MODE_TABS.register("medievalism_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(BlockRegistration.RED_CLAY_BLOCK.asItem()))
                    .title(Component.translatable("creative_tab.medievalism.name"))
                    .displayItems(CreativeTabRegistration::itemsForMedievalismTab)
                    .build());

    private static void itemsForMedievalismTab(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput)
    {
        for (DeferredHolder<Item, ? extends Item> item : ItemRegistration.ITEMS.getEntries())
        { // Add all items added by Medievalism.
            pOutput.accept(item.get());
        }
    }
    
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
        eventBus.addListener(CreativeTabRegistration::InjectItemsIntoCreativeTabs);
    }

    public static void InjectItemsIntoCreativeTabs(BuildCreativeModeTabContentsEvent event)
    { // Existing Tabs
    }
}
