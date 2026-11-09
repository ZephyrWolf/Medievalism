package io.github.zephyrwolf.medievalism.registrationclient.render;

import io.github.zephyrwolf.medievalism.client.item.KnappingItemAnimationClientExtension;
import io.github.zephyrwolf.medievalism.client.item.ScrapingItemAnimationClientExtension;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.KnappingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WorldItemRegistration;
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
                WorldItemRegistration.GREYWACKE_ROCK.get(),
                WorldItemRegistration.SILTSTONE_ROCK.get(),
                WorldItemRegistration.DOLOSTONE_ROCK.get(),
                WorldItemRegistration.LIMESTONE_ROCK.get(),
                WorldItemRegistration.IRONSTONE_ROCK.get(),
                WorldItemRegistration.ARKOSE_ROCK.get(),
                WorldItemRegistration.MARBLE_ROCK.get(),
                WorldItemRegistration.QUARTZITE_ROCK.get(),
                WorldItemRegistration.HORNFELS_ROCK.get(),
                WorldItemRegistration.SLATE_ROCK.get(),
                WorldItemRegistration.GABBRO_ROCK.get(),
                WorldItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                WorldItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                WorldItemRegistration.NORITE_ROCK.get(),
                WorldItemRegistration.PERIDOTITE_ROCK.get()
        );

        event.registerItem(new ScrapingItemAnimationClientExtension(),
                KnappingItemRegistration.ROCK_KNIFE.get(),
                KnappingItemRegistration.BONE_KNIFE.get(),
                KnappingItemRegistration.FLINT_KNIFE.get()
        );
    }
}
