package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellVariant;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public final class WorldGenNoiseCatalog
{
    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String pKey)
    {
        return ResourceKey.create(Registries.NOISE, MedievalismConstants.resource(pKey));
        // BaseNoiseProviderEntry for data generation
    }

    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_REGOLITH = createKey("regolith");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_SEDIMENTARY = createKey("sedimentary");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_METAMORPHIC = createKey("metamorphic");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_IGNEOUS_INTRUSIVE = createKey("igneous_intrusive");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_DEEP_IGNEOUS_INTRUSIVE = createKey("deep_igneous_intrusive");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_ASHFALL = createKey("ashfall");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_SOFT_IGNEOUS_EXTRUSIVE = createKey("soft_igneous_extrusive");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_HARD_IGNEOUS_EXTRUSIVE = createKey("hard_igneous_extrusive");

    public enum VARIANTS_REGOLITH
    {
        // Sandstone
        // Red Sandstone
        LATERITE,
        SAPROLITE,
        SILT
    }

    public enum VARIANTS_SEDIMENTARY
    {
        GREYWACKE,
        SILTSTONE,
        DOLOSTONE,
        LIMESTONE,
        IRONSTONE,
        SHALE,
        ARKOSE
    }

    public enum VARIANTS_METAMORPHIC
    {
        MARBLE,
        QUARTZITE,
        HORNFELS,
        SLATE
    }

    public enum VARIANTS_IGNEOUS_INTRUSIVE
    {
        GABBRO,
        DIORITE,
        GRANITE
    }

    public enum VARIANTS_DEEP_IGNEOUS_INTRUSIVE
    {
        NORITE,
        PERIDOTITE
    }

    public enum VARIANTS_ASHFALL
    {
        SOFT_TUFF,
        IGNIMBRITE,
        LAPILLISTONE,
        WELDED_TUFF
    }

    public enum VARIANTS_SOFT_IGNEOUS_EXTRUSIVE
    {
        RHYOLITE,
        DACITE
    }

    public enum VARIANTS_HARD_IGNEOUS_EXTRUSIVE
    {
        ANDESITE,
        BASALT
    }

    //TODO get the variants to work on the enums to be safer and clearer
    // new mobs that spawn lower as harder

    // BaseOctave and Amplitudes are used for data-generation; json values are used for runtime

    public static final CellNoiseSettings NOISE_SETTINGS_REGOLITH = CellNoiseSettings.create                ( NOISE_REGOLITH,                500, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_REGOLITH.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_SEDIMENTARY = CellNoiseSettings.create             ( NOISE_SEDIMENTARY,             500, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_SEDIMENTARY.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_METAMORPHIC = CellNoiseSettings.create             ( NOISE_METAMORPHIC,             600, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_METAMORPHIC.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_IGNEOUS_INTRUSIVE = CellNoiseSettings.create       ( NOISE_IGNEOUS_INTRUSIVE,       700, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_IGNEOUS_INTRUSIVE.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_DEEP_IGNEOUS_INTRUSIVE = CellNoiseSettings.create  ( NOISE_DEEP_IGNEOUS_INTRUSIVE,  800, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_DEEP_IGNEOUS_INTRUSIVE.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_ASHFALL = CellNoiseSettings.create                 ( NOISE_ASHFALL,                 350, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_ASHFALL.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_SOFT_IGNEOUS_EXTRUSIVE = CellNoiseSettings.create  ( NOISE_SOFT_IGNEOUS_EXTRUSIVE,  350, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_SOFT_IGNEOUS_EXTRUSIVE.class), 1, 1.0f );
    public static final CellNoiseSettings NOISE_SETTINGS_HARD_IGNEOUS_EXTRUSIVE = CellNoiseSettings.create  ( NOISE_HARD_IGNEOUS_EXTRUSIVE,  350, 1.0f, 15, CellVariant.listOf(MedievalismConstants.MOD_ID, VARIANTS_HARD_IGNEOUS_EXTRUSIVE.class), 1, 1.0f );
}
