package io.github.zephyrwolf.medievalism.registration.capabilities;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public final class CapabilitiesRegistration
{
    public static void register(IEventBus bus)
    {
        bus.addListener(CapabilitiesRegistration::registerCapabilities);
    }

    private static void registerCapabilities(final RegisterCapabilitiesEvent event)
    {
        /*
        event.registerItem(
                Capabilities.ItemHandler.ITEM,
                (itemStack, context) -> {
                    ItemStackHandler items = new ItemStackHandler(4);
                    var dataMap = itemStack.getComponents();
                    var container = dataMap.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
                    for (int slot = 0; slot < container.getSlots(); slot++) {
                        items.setStackInSlot(slot, container.getStackInSlot(slot));
                    }
                    return items;
                    },
                BlockRegistration.GATHERERS_JAR_ITEM
        );
        */
    }
}
