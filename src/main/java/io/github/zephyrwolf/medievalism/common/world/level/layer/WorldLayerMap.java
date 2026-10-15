package io.github.zephyrwolf.medievalism.common.world.level.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.RandomState;

import java.util.*;
import java.util.function.Supplier;

public record WorldLayerMap(ResourceKey<Level> dimension)
{
    public static final Codec<Holder<WorldLayerMap>> CODEC = RegistryRegistration.WORLD_LAYER_MAPS_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(WorldLayersRegistration.NONE_LAYER_MAP.getKey())
                            ? DataResult.error(() -> "World Layer must not be " + WorldLayersRegistration.NONE_LAYER_MAP.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldLayerMap>> STREAM_CODEC = ByteBufCodecs.holderRegistry(WorldLayersRegistration.LAYER_MAPS.getRegistryKey());
    public static Supplier<WorldLayerMap> newLayerMap(ResourceKey<Level> dimension)
    {
        return () -> new WorldLayerMap(dimension);
    }
    @SuppressWarnings("FieldMayBeFinal") // No it can't
    private static Map<ResourceKey<WorldLayerMap>, List<ResourceKey<WorldLayer>>> _cacheLayers = new HashMap<>();

    private static List<ResourceKey<WorldLayer>> _getCells(ResourceKey<WorldLayerMap> layerMapKey)
    {
        if (_cacheLayers.containsKey(layerMapKey))
        {
            return _cacheLayers.get(layerMapKey);
        }
        List<ResourceKey<WorldLayer>> layerList = new ArrayList<>();
        for (Holder.Reference<WorldLayer> layer : RegistryRegistration.WORLD_LAYERS_REGISTRY.holders().toList())
        {
            if (layer.value().layerMap() == layerMapKey)
            {
                layerList.add(layer.key());
            }
        }
        _cacheLayers.put(layerMapKey, layerList);
        return _cacheLayers.get(layerMapKey);
    }

    public static ResourceKey<WorldLayerMap> getLayerAt(RandomState randomState, BlockPos origin, ResourceKey<WorldLayerMap> layerMapKey)
    {
        WorldLayerMap layerMap = RegistryRegistration.WORLD_LAYER_MAPS_REGISTRY.getOrThrow(layerMapKey);
        // return layerMap.getLayer(randomState, origin); // make it a getter function
        return null;
        //try {
        //    WorldLayer layer = RegistryRegistration.WORLD_LAYERS_REGISTRY.getOrThrow(layerKey);
        //    List<ResourceKey<WorldLayerCell>> cellList = _getCells(layerKey);
        //    long n = layer._noise(randomState, origin);
        //    int ordinal = Math.floorMod(n, cellList.size());
        //    return cellList.get(ordinal);
        //} catch (Exception e) {
        //    return LayerCellRegistration.NONE.getKey();
        //}
    }
}
