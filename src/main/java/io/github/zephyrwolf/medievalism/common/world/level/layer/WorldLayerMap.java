package io.github.zephyrwolf.medievalism.common.world.level.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldGenLayerConstants;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Supplier;

public record WorldLayerMap(ResourceKey<Level> dimension,  ResourceKey<NormalNoise.NoiseParameters> noise)
{
    public static final Codec<Holder<WorldLayerMap>> CODEC = RegistryRegistration.WORLD_LAYER_MAPS_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(WorldLayersRegistration.NONE_LAYER_MAP.getKey())
                            ? DataResult.error(() -> "World Layer must not be " + WorldLayersRegistration.NONE_LAYER_MAP.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldLayerMap>> STREAM_CODEC = ByteBufCodecs.holderRegistry(WorldLayersRegistration.LAYER_MAPS.getRegistryKey());
    public static Supplier<WorldLayerMap> newLayerMap(ResourceKey<Level> dimension, ResourceKey<NormalNoise.NoiseParameters> noise)
    {
        return () -> new WorldLayerMap(dimension, noise);
    }
    @SuppressWarnings("FieldMayBeFinal") // No it can't
    private static Map<ResourceKey<WorldLayerMap>, List<ResourceKey<WorldLayer>>> _cachedLayers = new HashMap<>();

    private static List<ResourceKey<WorldLayer>> _getLayers(ResourceKey<WorldLayerMap> layerMapKey)
    {
        if (_cachedLayers.containsKey(layerMapKey))
        {
            return _cachedLayers.get(layerMapKey);
        }
        List<ResourceKey<WorldLayer>> layerList = new ArrayList<>();
        for (Holder.Reference<WorldLayer> layer : RegistryRegistration.WORLD_LAYERS_REGISTRY.holders().toList())
        {
            if (layer.value().layerMap() == layerMapKey)
            {
                layerList.add(layer.key());
            }
        }
        _cachedLayers.put(layerMapKey, layerList);
        return _cachedLayers.get(layerMapKey);
    }

    private static ResourceKey<WorldLayer> getLayer(@Nullable LevelReader level, @Nullable ChunkGenerator chunkGenerator,  RandomState randomState, WorldLayerMap layerMap, List<ResourceKey<WorldLayer>> layerKeyList, BlockPos origin)
    {
        assert chunkGenerator != null;
        assert level != null;
        WorldGenerationContext worldGenContext = new WorldGenerationContext(chunkGenerator, level);
        int heightMapY_OCEAN = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, origin.getX(), origin.getZ());
        int heightMapY_SURFACE = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, origin.getX(), origin.getZ());
        WorldGenLayerConstants.LayerInfoAtPos layerInfo = WorldGenLayerConstants.GetLayer(worldGenContext, origin, heightMapY_OCEAN, heightMapY_SURFACE);
        if (!layerInfo.Exists || layerInfo.Defaulted) return WorldLayersRegistration.NONE_LAYER.getKey();
        return layerInfo.Layer;
    }

    public static ResourceKey<WorldLayer> getLayerAt(@Nullable LevelReader level, @Nullable ChunkGenerator chunkGenerator, RandomState randomState, BlockPos origin, ResourceKey<WorldLayerMap> layerMapKey)
    {
        try {
            WorldLayerMap layerMap = RegistryRegistration.WORLD_LAYER_MAPS_REGISTRY.getOrThrow(layerMapKey);
            List<ResourceKey<WorldLayer>> layerList = _getLayers(layerMapKey);
            return getLayer(level, chunkGenerator, randomState, layerMap, layerList, origin);
        } catch (Exception e) {
            return WorldLayersRegistration.NONE_LAYER.getKey();
        }
    }
}
