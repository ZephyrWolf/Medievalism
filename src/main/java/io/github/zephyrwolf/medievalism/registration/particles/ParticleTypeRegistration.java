package io.github.zephyrwolf.medievalism.registration.particles;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ParticleTypeRegistration
{
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MedievalismConstants.MOD_ID);

    public static final Supplier<SimpleParticleType> KNAP_DEBRIS = PARTICLE_TYPES.register("knap_debris", () -> new SimpleParticleType(false));

    public static void register(IEventBus bus)
    {
        PARTICLE_TYPES.register(bus);
    }
}
