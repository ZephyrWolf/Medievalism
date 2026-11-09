package io.github.zephyrwolf.medievalism.registrationclient.particle;

import io.github.zephyrwolf.medievalism.client.particles.InhandCraftParticle;
import io.github.zephyrwolf.medievalism.registration.particles.ParticleTypeRegistration;
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
        event.registerSpriteSet(ParticleTypeRegistration.HIT_ROCK.get(), InhandCraftParticle.InhandCraftParticleProvider::new);
        event.registerSpriteSet(ParticleTypeRegistration.HIT_PLANT.get(), InhandCraftParticle.InhandCraftParticleProvider::new);
        event.registerSpriteSet(ParticleTypeRegistration.SCRAPE_PLANT.get(), InhandCraftParticle.InhandCraftParticleProvider::new);
    }
}
