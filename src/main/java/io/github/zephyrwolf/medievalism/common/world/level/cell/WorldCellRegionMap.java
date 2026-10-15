package io.github.zephyrwolf.medievalism.common.world.level.cell;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldCellRegionRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Supplier;

public record WorldCellRegionMap(ResourceKey<Level> dimension, CellRegionGetter cellRegionGetter, @Nullable ResourceKey<NormalNoise.NoiseParameters> noise, @Nullable Object extra)
{
    public static final Codec<Holder<WorldCellRegionMap>> CODEC = RegistryRegistration.WORLD_CELL_REGION_MAP_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(WorldCellRegionRegistration.NONE_CELL_REGION_MAP.getKey())
                            ? DataResult.error(() -> "CellRegion Map must not be " + WorldCellRegionRegistration.NONE_CELL_REGION_MAP.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<WorldCellRegionMap>> STREAM_CODEC = ByteBufCodecs.holderRegistry(WorldCellRegionRegistration.CELL_REGION_MAPS.getRegistryKey());
    public static Supplier<WorldCellRegionMap> newCellMap(ResourceKey<Level> dimension, CellRegionGetter cellRegionGetter, @Nullable ResourceKey<NormalNoise.NoiseParameters> noise, @Nullable Object extra)
    {
        return () -> new WorldCellRegionMap(dimension, cellRegionGetter, noise, extra);
    }
    @SuppressWarnings("unused")
    public static Supplier<WorldCellRegionMap> newCellMap(ResourceKey<Level> dimension, CellRegionGetter cellRegionGetter, @Nullable ResourceKey<NormalNoise.NoiseParameters> noise)
    {
        return () -> new WorldCellRegionMap(dimension, cellRegionGetter, noise, null);
    }
    public static Supplier<WorldCellRegionMap> newCellMap(ResourceKey<Level> dimension, CellRegionGetter cellRegionGetter, @Nullable Object extra)
    {
        return () -> new WorldCellRegionMap(dimension, cellRegionGetter, null, extra);
    }
    @SuppressWarnings("unused")
    public static Supplier<WorldCellRegionMap> newCellMap(ResourceKey<Level> dimension, CellRegionGetter cellRegionGetter)
    {
        return () -> new WorldCellRegionMap(dimension, cellRegionGetter, null,null);
    }
    @SuppressWarnings("FieldMayBeFinal") // No it can't
    private static Map<ResourceKey<WorldCellRegionMap>, List<ResourceKey<WorldCellRegion>>> _cachedCellRegions = new HashMap<>();

    private static List<ResourceKey<WorldCellRegion>> _getCellRegions(ResourceKey<WorldCellRegionMap> celLRegionMapKey)
    {
        if (_cachedCellRegions.containsKey(celLRegionMapKey))
        {
            return _cachedCellRegions.get(celLRegionMapKey);
        }
        List<ResourceKey<WorldCellRegion>> regionList = new ArrayList<>();
        for (Holder.Reference<WorldCellRegion> region : RegistryRegistration.WORLD_CELL_REGION_REGISTRY.holders().toList())
        {
            if (region.value().cellRegionMap() == celLRegionMapKey)
            {
                regionList.add(region.key());
            }
        }
        _cachedCellRegions.put(celLRegionMapKey, regionList);
        return _cachedCellRegions.get(celLRegionMapKey);
    }

    @FunctionalInterface
    public interface CellRegionGetter
    {
        ResourceKey<WorldCellRegion> getCellRegion(
                @Nullable LevelReader level,
                @Nullable ChunkGenerator chunkGenerator,
                RandomState randomState,
                WorldCellRegionMap cellRegionMap,
                List<ResourceKey<WorldCellRegion>> cellRegionKeyList,
                BlockPos origin
        );
    }

    private static class DummyCellRegionGetter implements CellRegionGetter
    {
        @Override
        public ResourceKey<WorldCellRegion> getCellRegion(
                @org.jetbrains.annotations.Nullable LevelReader level,
                @org.jetbrains.annotations.Nullable ChunkGenerator chunkGenerator,
                RandomState randomState, WorldCellRegionMap cellRegionMap,
                List<ResourceKey<WorldCellRegion>> cellRegionKeyList, BlockPos origin)
        {
            return WorldCellRegionRegistration.NONE_CELL_REGION.getKey();
        }
    }
    public static CellRegionGetter DEFAULT_CELL_REGION_GETTER = new DummyCellRegionGetter();

    public static ResourceKey<WorldCellRegion> getCellAt(@Nullable LevelReader level, @Nullable ChunkGenerator chunkGenerator, RandomState randomState, BlockPos origin, ResourceKey<WorldCellRegionMap> regionMapKey)
    {
        try {
            WorldCellRegionMap regionMap = RegistryRegistration.WORLD_CELL_REGION_MAP_REGISTRY.getOrThrow(regionMapKey);
            List<ResourceKey<WorldCellRegion>> regionList = _getCellRegions(regionMapKey);
            return regionMap.cellRegionGetter.getCellRegion(level, chunkGenerator, randomState, regionMap, regionList, origin);
        } catch (Exception e) {
            return WorldCellRegionRegistration.NONE_CELL_REGION.getKey();
        }
    }
}
