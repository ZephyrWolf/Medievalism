package io.github.zephyrwolf.medievalism.common.world.level.cell;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldCellRegionRegistration;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;

import java.util.Objects;
import java.util.function.Supplier;

public record WorldCellRegion(ResourceKey<WorldCellRegionMap> cellRegionMap)
{
    public static final Codec<Holder<WorldCellRegion>> CODEC = RegistryRegistration.WORLD_CELL_REGION_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(WorldCellRegionRegistration.NONE_CELL_REGION.getKey())
                            ? DataResult.error(() -> "Layer Cell must not be " + WorldCellRegionRegistration.NONE_CELL_REGION.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldCellRegion>> STREAM_CODEC = ByteBufCodecs.holderRegistry(WorldCellRegionRegistration.CELL_REGIONS.getRegistryKey());

    public static Supplier<WorldCellRegion> newLayer(ResourceKey<WorldCellRegionMap> cellRegionMap)
    { return () -> new WorldCellRegion(cellRegionMap); }
}
