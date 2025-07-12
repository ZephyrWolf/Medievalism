package io.github.zephyrwolf.medievalism.registration.render;

import io.github.zephyrwolf.medievalism.client.item.RockBlockItemClientExtension;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

public final class ClientExtensionsRegistration
{
    public static void register(IEventBus bus)
    {
        bus.addListener(ClientExtensionsRegistration::registerClientItemExtensions);
    }

    private static void registerClientItemExtensions(RegisterClientExtensionsEvent event)
    {
        event.registerItem(new RockBlockItemClientExtension(),
                BlockItemRegistration.ROCK.get(),
                BlockItemRegistration.MOSSY_ROCK.get(),
                BlockItemRegistration.LIGHTER_ROCK.get(),
                BlockItemRegistration.SNOWY_ROCK.get(),
                BlockItemRegistration.ICE_ROCK.get()
        );
    }
}
