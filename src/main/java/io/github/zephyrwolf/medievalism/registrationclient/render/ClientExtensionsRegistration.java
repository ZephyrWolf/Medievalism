package io.github.zephyrwolf.medievalism.registrationclient.render;

import io.github.zephyrwolf.medievalism.client.item.KnappingItemAnimationClientExtension;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
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
                ItemRegistration.GREYWACKE_ROCK.get(),
                ItemRegistration.SILTSTONE_ROCK.get(),
                ItemRegistration.DOLOSTONE_ROCK.get(),
                ItemRegistration.LIMESTONE_ROCK.get(),
                ItemRegistration.IRONSTONE_ROCK.get(),
                ItemRegistration.ARKOSE_ROCK.get(),
                ItemRegistration.MARBLE_ROCK.get(),
                ItemRegistration.QUARTZITE_ROCK.get(),
                ItemRegistration.HORNFELS_ROCK.get(),
                ItemRegistration.SLATE_ROCK.get(),
                ItemRegistration.GABBRO_ROCK.get(),
                ItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                ItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                ItemRegistration.NORITE_ROCK.get(),
                ItemRegistration.PERIDOTITE_ROCK.get()
        );
    }
}
