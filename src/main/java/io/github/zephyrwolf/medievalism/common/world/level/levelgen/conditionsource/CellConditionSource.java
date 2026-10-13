package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoise;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellVariant;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.jetbrains.annotations.NotNull;

public record CellConditionSource(CellNoiseSettings settings, int targetVariant) implements SurfaceRules.ConditionSource
{
    public static <E extends Enum<E>> CellConditionSource cell(CellNoiseSettings noiseSettings, E e)
    {
        return cell(noiseSettings, MedievalismConstants.MOD_ID, e);
    }

    public static <E extends Enum<E>> CellConditionSource cell(CellNoiseSettings noiseSettings, String modid, E e)
    {
        return cell(noiseSettings, CellVariant.getName(modid, e));
    }

    public static CellConditionSource cell(CellNoiseSettings noiseSettings, ResourceLocation name)
    {
        return new CellConditionSource(noiseSettings, noiseSettings.getOrdinal(name));
    }

    // TODO Error checking targetVariant >= 0 && < numnVariants

    static final KeyDispatchDataCodec<CellConditionSource> CODEC = KeyDispatchDataCodec.of(
            RecordCodecBuilder.mapCodec( instance -> instance.group(
                            CellNoiseSettings.CODEC.codec().fieldOf("settings").forGetter(CellConditionSource::settings),
                            Codec.INT.fieldOf( "target_variant").forGetter(CellConditionSource::targetVariant)
                    ).apply(instance, CellConditionSource::new)
            ));

    @Override
    public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() { return CODEC; }

    public SurfaceRules.Condition apply(final SurfaceRules.Context pContext)
    {
        // For some reason, we HAVE to query heightmap now and not at lazy
        final int heightMapY = AwareConditionSources.getSurfaceHeight(Heightmap.Types.OCEAN_FLOOR_WG, pContext);

        class LazyVerticalRangeAwareConditionSource extends SurfaceRules.LazyYCondition
        {
            LazyVerticalRangeAwareConditionSource()
            {
                super(pContext);
            }

            @Override
            protected boolean compute()
            {
                NormalNoise noise = pContext.randomState.getOrCreateNoise(settings.noiseKey());
                BlockPos pos = new BlockPos(pContext.blockX, pContext.blockY, pContext.blockZ);
                int stoneVariant = CellNoise.noise(settings, noise, pos);
                return stoneVariant == targetVariant;
            }
        }
        return new LazyVerticalRangeAwareConditionSource();
    }
}
