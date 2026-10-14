package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerCatalog;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class LayerHeightPlacement extends PlacementModifier
{
    public static LayerHeightPlacement withinLayer(WorldGenLayerCatalog.WorldLayer targetLayer)
    {
        return new LayerHeightPlacement(targetLayer);
    }

    public static final MapCodec<LayerHeightPlacement> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.fieldOf("layer").forGetter(filter -> filter.targetLayer.name())
    ).apply(instance, LayerHeightPlacement::new));

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.LAYER.get(); }

    WorldGenLayerCatalog.WorldLayer targetLayer;

    private LayerHeightPlacement(WorldGenLayerCatalog.WorldLayer layer)
    {
        this.targetLayer = layer;
    }

    private LayerHeightPlacement(String layerName)
    { // Error quietly and load as sedimentary (in case it is an old file, and the enum has been refactored)
        try {
            this.targetLayer = WorldGenLayerCatalog.WorldLayer.valueOf(layerName);
        } catch (IllegalArgumentException e) {
            this.targetLayer = WorldGenLayerCatalog.WorldLayer.SEDIMENTARY;
        }
    }

    @Override
    public @NotNull Stream<BlockPos> getPositions(PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        ChunkGenerator pGenerator = pContext.getLevel().getLevel().getChunkSource().getGenerator();
        LevelHeightAccessor pLevel = pContext.getLevel().getChunk(pPos);
        WorldGenerationContext context = new WorldGenerationContext(pGenerator, pLevel);
        int heightMapY_OCEAN = pContext.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pPos.getX(), pPos.getZ());
        int heightMapY_SURFACE = pContext.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pPos.getX(), pPos.getZ());
        WorldGenLayerCatalog.LayerInfoAtPos layer = WorldGenLayerCatalog.GetRange(context, targetLayer, pPos, heightMapY_OCEAN, heightMapY_SURFACE);
        if (!layer.Exists) return Stream.of();
        return Stream.of(pPos.atY(UniformInt.of(1, layer.MaxY - layer.MinY + 1).sample(pRandom) + layer.MinY - 1));
    }
}
