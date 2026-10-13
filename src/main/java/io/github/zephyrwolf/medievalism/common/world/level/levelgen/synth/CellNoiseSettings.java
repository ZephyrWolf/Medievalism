package io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public record CellNoiseSettings(ResourceKey<NormalNoise.NoiseParameters> noiseKey, int cellSize, float warp, int boarderThickness, List<CellVariant> variants, int baseOctave, DoubleArrayList amplitudes)
{
    public static CellNoiseSettings create(ResourceKey<NormalNoise.NoiseParameters> noise, int cellSize, float warp, int boarderThickness, List<CellVariant> variants, int baseOctave, double ... amplitudes)
    {
        return new CellNoiseSettings(noise, cellSize, warp, boarderThickness, variants, baseOctave, DoubleArrayList.toList(Arrays.stream(amplitudes)) );
    }

    private static ResourceKey<NormalNoise.NoiseParameters> ToKey(ResourceLocation loc)
    {
        return ResourceKey.create(Registries.NOISE, loc);
    }

    CellNoiseSettings(ResourceLocation noise, int cellSize, float warp, int boarderThickness, List<CellVariant> variants, int baseOctave, List<Double> amplitudes)
    {
        this(ToKey(noise), cellSize, warp, boarderThickness, variants, baseOctave, new DoubleArrayList(amplitudes));
    }

    public static final KeyDispatchDataCodec<CellNoiseSettings> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                            ResourceLocation.CODEC.fieldOf("noise").forGetter(CellNoiseSettings::noiseLocation),
                            Codec.INT.fieldOf("cell_size").forGetter(CellNoiseSettings::cellSize),
                            Codec.FLOAT.fieldOf("warp").forGetter(CellNoiseSettings::warp),
                            Codec.INT.fieldOf("boarder_thickness").forGetter(CellNoiseSettings::boarderThickness),
                            CellVariant.CODEC.codec().codec().listOf().fieldOf("variants").forGetter(CellNoiseSettings::variants),
                            Codec.INT.fieldOf("baseOctave").forGetter(CellNoiseSettings::baseOctave),
                            Codec.DOUBLE.listOf().fieldOf("amplitudes").forGetter(CellNoiseSettings::amplitudes)
                    ).apply(instance, CellNoiseSettings::new)
            ));

    ResourceLocation noiseLocation()
    {
        return noiseKey.location();
    }

    public int getOrdinal(ResourceLocation location)
    {
        for (CellVariant variant : variants())
        {
            if (variant.name().equals(location))
            {
                return variant.ordinal();
            }
        }
        return -1;
    }

    public @NotNull KeyDispatchDataCodec<CellNoiseSettings> codec() { return CODEC; }
}
