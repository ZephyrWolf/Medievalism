package io.github.zephyrwolf.medievalism.registration.item;

import net.neoforged.bus.api.IEventBus;

public final class ItemRegistration
{
    public static void register(IEventBus bus)
    {
        ClayWorkingItemRegistration.register(bus);
        CookingItemRegistration.register(bus);
        FarmingItemRegistration.register(bus);
        KnappingItemRegistration.register(bus);
        LeatherWorkingItemRegistration.register(bus);
        MetalWorkingItemRegistration.register(bus);
        MudWorkingItemRegistration.register(bus);
        WeavingItemRegistration.register(bus);
        WoodWorkingItemRegistration.register(bus);
        WorldItemRegistration.register(bus);
    }
}
