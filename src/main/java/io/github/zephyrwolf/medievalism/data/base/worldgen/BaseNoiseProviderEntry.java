package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.registration.world.level.NoiseRegistration;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public final class BaseNoiseProviderEntry
{
    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context)
    {
        register(context, NoiseRegistration.NOISE_ASHFALL,                  1, 1.0f);
        register(context, NoiseRegistration.NOISE_REGOLITH,                 1, 1.0f);
        register(context, NoiseRegistration.NOISE_SEDIMENTARY,              1, 1.0f);
        register(context, NoiseRegistration.NOISE_METAMORPHIC,              1, 1.0f);
        register(context, NoiseRegistration.NOISE_IGNEOUS_INTRUSIVE,        1, 1.0f);
        register(context, NoiseRegistration.NOISE_DEEP_IGNEOUS_INTRUSIVE,   1, 1.0f);
        register(context, NoiseRegistration.NOISE_SOFT_IGNEOUS_EXTRUSIVE,   1, 1.0f);
        register(context, NoiseRegistration.NOISE_HARD_IGNEOUS_EXTRUSIVE,   1, 1.0f);
    }

    @SuppressWarnings("SameParameterValue")
    private static void register(BootstrapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int baseOctave, double ... amplitudes)
    {
        context.register(key, new NormalNoise.NoiseParameters(baseOctave, DoubleList.of(amplitudes) ));
    }
}
