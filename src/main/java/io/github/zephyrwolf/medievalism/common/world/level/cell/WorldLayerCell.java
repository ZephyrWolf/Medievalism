package io.github.zephyrwolf.medievalism.common.world.level.cell;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.LayerCellRegistration;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;

import java.util.Objects;
import java.util.function.Supplier;

public record WorldLayerCell(ResourceKey<WorldLayer> layer)
{
    public static final Codec<Holder<WorldLayerCell>> CODEC = RegistryRegistration.LAYER_CELLS_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(LayerCellRegistration.NONE.getKey())
                            ? DataResult.error(() -> "Layer Cell must not be " + LayerCellRegistration.NONE.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldLayerCell>> STREAM_CODEC = ByteBufCodecs.holderRegistry(LayerCellRegistration.CELLS.getRegistryKey());

    public static Supplier<WorldLayerCell> newLayer(ResourceKey<WorldLayer> layer) { return () -> new WorldLayerCell(layer); }
}
