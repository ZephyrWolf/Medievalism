package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public final class NoiseRegistration
{
    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String pKey) { return ResourceKey.create(Registries.NOISE, MedievalismConstants.resource(pKey)); }

    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_ASHFALL =                    createKey("ashfall");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_REGOLITH =                   createKey("regolith");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_SEDIMENTARY =                createKey("sedimentary");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_METAMORPHIC =                createKey("metamorphic");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_IGNEOUS_INTRUSIVE =          createKey("igneous_intrusive");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_DEEP_IGNEOUS_INTRUSIVE =     createKey("deep_igneous_intrusive");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_SOFT_IGNEOUS_EXTRUSIVE =     createKey("soft_igneous_extrusive");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_HARD_IGNEOUS_EXTRUSIVE =     createKey("hard_igneous_extrusive");
}
