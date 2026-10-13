package io.github.zephyrwolf.medievalism.registration.render;

import io.github.zephyrwolf.medievalism.client.item.KnappingItemAnimationClientExtension;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;

public final class ClientExtensionsRegistration
{
    public static void register(IEventBus bus)
    {
        bus.addListener(ClientExtensionsRegistration::registerClientItemExtensions);

        NeoForge.EVENT_BUS.addListener(KnappingItemAnimationClientExtension::onRenderHand);
    }

    private static void registerClientItemExtensions(RegisterClientExtensionsEvent event)
    {
        event.registerItem(new KnappingItemAnimationClientExtension(),
                BlockItemRegistration.GREYWACKE_ROCK.get(),
                BlockItemRegistration.SILTSTONE_ROCK.get(),
                BlockItemRegistration.DOLOSTONE_ROCK.get(),
                BlockItemRegistration.LIMESTONE_ROCK.get(),
                BlockItemRegistration.IRONSTONE_ROCK.get(),
                BlockItemRegistration.SHALE_ROCK.get()
        );
    }
}
