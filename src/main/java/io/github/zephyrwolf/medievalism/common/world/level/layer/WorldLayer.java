package io.github.zephyrwolf.medievalism.common.world.level.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoise;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.LayerCellRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.*;
import java.util.function.Supplier;

public record WorldLayer(ResourceKey<WorldLayerMap> layerMap, ResourceKey<Level> dimension, WorldLayerAnchor anchor, ResourceKey<NormalNoise.NoiseParameters> noise, int cellSize, float warp, int boarderThickness)
{
    public static final Codec<Holder<WorldLayer>> CODEC = RegistryRegistration.WORLD_LAYERS_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(WorldLayersRegistration.NONE_LAYER.getKey())
                            ? DataResult.error(() -> "World Layer must not be " + WorldLayersRegistration.NONE_LAYER.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldLayer>> STREAM_CODEC = ByteBufCodecs.holderRegistry(WorldLayersRegistration.LAYERS.getRegistryKey());
    public static Supplier<WorldLayer> newLayer(ResourceKey<WorldLayerMap> layerMap, ResourceKey<Level> dimension, WorldLayerAnchor anchor, ResourceKey<NormalNoise.NoiseParameters> noise, int cellSize, float warp, int boarderThickness)
    {
        return () -> new WorldLayer(layerMap, dimension, anchor, noise, cellSize, warp, boarderThickness);
    }
    @SuppressWarnings("FieldMayBeFinal") // No it can't
    private static Map<ResourceKey<WorldLayer>, List<ResourceKey<WorldLayerCell>>> _cacheCells = new HashMap<>();

    private static List<ResourceKey<WorldLayerCell>> _getCells(ResourceKey<WorldLayer> layerKey)
    {
        if (_cacheCells.containsKey(layerKey))
        {
            return _cacheCells.get(layerKey);
        }
        List<ResourceKey<WorldLayerCell>> cellList = new ArrayList<>();
        for (Holder.Reference<WorldLayerCell> cell : RegistryRegistration.LAYER_CELLS_REGISTRY.holders().toList())
        {
            if (cell.value().layer() == layerKey)
            {
                cellList.add(cell.key());
            }
        }
        _cacheCells.put(layerKey, cellList);
        return _cacheCells.get(layerKey);
    }

    private long _noise(RandomState random, BlockPos origin)
    {
        NormalNoise noise = random.getOrCreateNoise(noise());
        return CellNoise.noise(noise, cellSize(), warp(), boarderThickness(), origin);
    }

    public static ResourceKey<WorldLayerCell> getCellAt(RandomState randomState, BlockPos origin, ResourceKey<WorldLayer> layerKey)
    {
        try {
            WorldLayer layer = RegistryRegistration.WORLD_LAYERS_REGISTRY.getOrThrow(layerKey);
            List<ResourceKey<WorldLayerCell>> cellList = _getCells(layerKey);
            long n = layer._noise(randomState, origin);
            int ordinal = Math.floorMod(n, cellList.size());
            return cellList.get(ordinal);
        } catch (Exception e) {
            return LayerCellRegistration.NONE.getKey();
        }
    }
}
