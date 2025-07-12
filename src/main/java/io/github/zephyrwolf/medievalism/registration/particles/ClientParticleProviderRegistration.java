package io.github.zephyrwolf.medievalism.registration.particles;

import io.github.zephyrwolf.medievalism.client.particles.KnapDebrisParticle;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

public final class ClientParticleProviderRegistration
{
    public static void register(IEventBus bus)
    {
        bus.addListener(ClientParticleProviderRegistration::registerParticleProviders);
    }

    private static void registerParticleProviders(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ParticleTypeRegistration.KNAP_DEBRIS.get(), KnapDebrisParticle.KnapDebrisParticleProvider::new);
    }
}
