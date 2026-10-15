package io.github.zephyrwolf.medievalism.common.world.level.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.*;
import java.util.function.Supplier;

public record WorldLayer(ResourceKey<WorldLayerMap> layerMap, ResourceKey<Level> dimension, WorldLayerAnchor anchor)
{
    public static final Codec<Holder<WorldLayer>> CODEC = RegistryRegistration.WORLD_LAYERS_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(WorldLayersRegistration.NONE_LAYER.getKey())
                            ? DataResult.error(() -> "World Layer must not be " + WorldLayersRegistration.NONE_LAYER.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldLayer>> STREAM_CODEC = ByteBufCodecs.holderRegistry(WorldLayersRegistration.LAYERS.getRegistryKey());
    public static Supplier<WorldLayer> newLayer(ResourceKey<WorldLayerMap> layerMap, ResourceKey<Level> dimension, WorldLayerAnchor anchor)
    {
        return () -> new WorldLayer(layerMap, dimension, anchor);
    }
}
