package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenNoiseCatalog;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public final class BaseNoiseProviderEntry
{
    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context)
    {
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_REGOLITH);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_SEDIMENTARY);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_METAMORPHIC);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_IGNEOUS_INTRUSIVE);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_DEEP_IGNEOUS_INTRUSIVE);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_ASHFALL);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_SOFT_IGNEOUS_EXTRUSIVE);
        register(context, WorldGenNoiseCatalog.NOISE_SETTINGS_HARD_IGNEOUS_EXTRUSIVE);
    }

    private static void register(BootstrapContext<NormalNoise.NoiseParameters> context, CellNoiseSettings settings)
    {
        context.register(settings.noiseKey(), new NormalNoise.NoiseParameters(settings.baseOctave(), settings.amplitudes() ));
    }
}
