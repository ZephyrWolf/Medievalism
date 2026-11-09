package io.github.zephyrwolf.medievalism.registration.particles;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipeIngredientMaterialType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ParticleTypeRegistration
{
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MedievalismConstants.MOD_ID);

    public static final Supplier<SimpleParticleType> HIT_ROCK = PARTICLE_TYPES.register("hit_rock", () -> new SimpleParticleType(false));
    public static final Supplier<SimpleParticleType> HIT_PLANT = PARTICLE_TYPES.register("hit_plant", () -> new SimpleParticleType(false));
    public static final Supplier<SimpleParticleType> SCRAPE_PLANT = PARTICLE_TYPES.register("scrape_plant", () -> new SimpleParticleType(false));

    public static Supplier<SimpleParticleType> getInhandParticle(InhandRecipeIngredientMaterialType materialType)
    {
        return switch (materialType) {
            case HIT_ROCK -> ParticleTypeRegistration.HIT_ROCK;
            case HIT_PLANT -> ParticleTypeRegistration.HIT_PLANT;
            case SCRAPE_PLANT -> ParticleTypeRegistration.SCRAPE_PLANT;
        };
    }

    public static void register(IEventBus bus)
    {
        PARTICLE_TYPES.register(bus);
    }
}
