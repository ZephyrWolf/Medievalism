package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.stream.Stream;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoise;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoiseSettings;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellVariant;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.jetbrains.annotations.NotNull;

public class CellPlacement extends PlacementFilter
{
    public static <E extends Enum<E>> CellPlacement cell(CellNoiseSettings noiseSettings, E e)
    {
        return cell(noiseSettings, MedievalismConstants.MOD_ID, e);
    }

    public static <E extends Enum<E>> CellPlacement cell(CellNoiseSettings noiseSettings, String modid, E e)
    {
        return cell(noiseSettings, CellVariant.getName(modid, e));
    }

    public static CellPlacement cell(CellNoiseSettings noiseSettings, ResourceLocation name)
    {
        return new CellPlacement(noiseSettings, noiseSettings.getOrdinal(name));
    }

    public static final MapCodec<CellPlacement> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                            CellNoiseSettings.CODEC.codec().fieldOf("cell").forGetter(placement -> placement.settings),
                            Codec.INT.fieldOf( "target_variant").forGetter(placement -> placement.targetVariant)
                    ).apply(instance, CellPlacement::new)
    );

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.CELL.get(); }

    // --

    private final CellNoiseSettings settings;
    private final int targetVariant;

    private CellPlacement(CellNoiseSettings cell, int targetVariant)
    {
        this.settings = cell;
        this.targetVariant = targetVariant;
    }

    @Override
    protected boolean shouldPlace(PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        RandomState randomState = pContext.getLevel().getLevel().getChunkSource().randomState();
        NormalNoise noise = randomState.getOrCreateNoise(settings.noiseKey());
        int stoneVariant = CellNoise.noise(settings, noise, pPos);
        return stoneVariant == targetVariant;
    }
}
