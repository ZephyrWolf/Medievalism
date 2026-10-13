package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

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
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.jetbrains.annotations.NotNull;

public class CellRarityFilter extends PlacementFilter
{
    public static <E extends Enum<E>> CellRarityFilter onAverageOnceEvery(int chance, CellNoiseSettings noiseSettings, E e)
    {
        return onAverageOnceEvery(chance, noiseSettings, MedievalismConstants.MOD_ID, e);
    }

    public static <E extends Enum<E>> CellRarityFilter onAverageOnceEvery(int chance, CellNoiseSettings noiseSettings, String modid, E e)
    {
        return onAverageOnceEvery(chance, noiseSettings, CellVariant.getName(modid, e));
    }

    public static CellRarityFilter onAverageOnceEvery(int chance, CellNoiseSettings noiseSettings, ResourceLocation name)
    {
        return new CellRarityFilter(chance, noiseSettings, noiseSettings.getOrdinal(name));
    }

    public static final MapCodec<CellRarityFilter> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.fieldOf( "chance").forGetter(placement -> placement.chance),
            CellNoiseSettings.CODEC.codec().fieldOf("cell").forGetter(placement -> placement.settings),
            Codec.INT.fieldOf( "target_variant").forGetter(placement -> placement.targetVariant)
    ).apply(instance, CellRarityFilter::new));

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.CELL.get(); }

    // --

    int chance;
    private final CellNoiseSettings settings;
    private final int targetVariant;

    private CellRarityFilter(int chance, CellNoiseSettings cell, int targetVariant)
    {
        this.chance = chance;
        this.settings = cell;
        this.targetVariant = targetVariant;
    }

    @Override
    protected boolean shouldPlace(@NotNull PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        if (pRandom.nextFloat() >= 1.0F / (float)this.chance)
        {
            return false;
        } // Process the above first to save the expensive check below
        RandomState randomState = pContext.getLevel().getLevel().getChunkSource().randomState();
        NormalNoise noise = randomState.getOrCreateNoise(settings.noiseKey());
        int stoneVariant = CellNoise.noise(settings, noise, pPos);
        return stoneVariant == targetVariant;
    }
}
