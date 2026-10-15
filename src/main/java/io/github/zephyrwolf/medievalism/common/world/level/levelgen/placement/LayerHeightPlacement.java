package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

@Deprecated
public class LayerHeightPlacement extends PlacementModifier
{
    public static LayerHeightPlacement withinLayer(ResourceKey<WorldLayer> targetLayer)
    {
        return new LayerHeightPlacement(targetLayer);
    }

    public static final MapCodec<LayerHeightPlacement> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ResourceKey.codec(RegistryRegistration.WORLD_LAYERS).fieldOf("layer").forGetter(placement -> placement.layer)
    ).apply(instance, LayerHeightPlacement::new));

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.LAYER.get(); }

    ResourceKey<WorldLayer> layer;

    public LayerHeightPlacement(ResourceKey<WorldLayer> layer)
    { // Error quietly and load as sedimentary (in case it is an old file, and the enum has been refactored)
        this.layer = layer;
    }

    @Override
    public @NotNull Stream<BlockPos> getPositions(PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        ChunkGenerator pGenerator = pContext.getLevel().getLevel().getChunkSource().getGenerator();
        LevelHeightAccessor pLevel = pContext.getLevel().getChunk(pPos);
        WorldGenerationContext context = new WorldGenerationContext(pGenerator, pLevel);
        int heightMapY_OCEAN = pContext.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pPos.getX(), pPos.getZ());
        int heightMapY_SURFACE = pContext.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pPos.getX(), pPos.getZ());
        WorldGenLayerConstants.LayerInfoAtPos layerInfo = WorldGenLayerConstants.GetRange(context, this.layer, heightMapY_OCEAN, heightMapY_SURFACE);
        if (!layerInfo.Exists) return Stream.of();
        return Stream.of(pPos.atY(UniformInt.of(1, layerInfo.MaxY - layerInfo.MinY + 1).sample(pRandom) + layerInfo.MinY - 1));
    }
}
