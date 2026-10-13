package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoise;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.jetbrains.annotations.NotNull;

public class BelowHeightmapFilter extends PlacementFilter
{
    public static <E extends Enum<E>> BelowHeightmapFilter belowHeightmap(Heightmap.Types type)
    {
        return new BelowHeightmapFilter(type, 0);
    }
    public static <E extends Enum<E>> BelowHeightmapFilter belowHeightmap(Heightmap.Types type, int depth)
    {
        return new BelowHeightmapFilter(type, depth);
    }

    public static final MapCodec<BelowHeightmapFilter> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Heightmap.Types.CODEC.fieldOf("heightmap").forGetter(filter -> filter.heightmap),
            Codec.INT.fieldOf("depth").forGetter(filter -> filter.depth)
    ).apply(instance, BelowHeightmapFilter::new));

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.BELOW_HEIGHTMAP.get(); }

    Heightmap.Types heightmap;
    int depth;

    private BelowHeightmapFilter(Heightmap.Types type, int depth)
    {
        this.heightmap = type;
        this.depth = depth;
    }

    @Override
    protected boolean shouldPlace(@NotNull PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        return pPos.getY() < pContext.getHeight(this.heightmap, pPos.getX(), pPos.getZ()) - depth;
    }
}
