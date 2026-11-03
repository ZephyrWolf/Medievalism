package io.github.zephyrwolf.medievalism.registrationclient.render;

import io.github.zephyrwolf.medievalism.client.item.KnappingItemAnimationClientExtension;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;
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
        // Wish I could read from a tag
        event.registerItem(new KnappingItemAnimationClientExtension(),
                BlockItemRegistration.GREYWACKE_ROCK.get(),
                BlockItemRegistration.SILTSTONE_ROCK.get(),
                BlockItemRegistration.DOLOSTONE_ROCK.get(),
                BlockItemRegistration.LIMESTONE_ROCK.get(),
                BlockItemRegistration.IRONSTONE_ROCK.get(),
                BlockItemRegistration.ARKOSE_ROCK.get(),
                BlockItemRegistration.MARBLE_ROCK.get(),
                BlockItemRegistration.QUARTZITE_ROCK.get(),
                BlockItemRegistration.HORNFELS_ROCK.get(),
                BlockItemRegistration.SLATE_ROCK.get(),
                BlockItemRegistration.GABBRO_ROCK.get(),
                BlockItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                BlockItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                BlockItemRegistration.NORITE_ROCK.get(),
                BlockItemRegistration.PERIDOTITE_ROCK.get()
        );
    }
}
