package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerAnchor;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.List;

public final class WorldLayersRegistration
{
    public static final DeferredRegister<WorldLayerMap> LAYER_MAPS = DeferredRegister.create(
            RegistryRegistration.WORLD_LAYER_MAPS, MedievalismConstants.MOD_ID);
    public static final DeferredRegister<WorldLayer> LAYERS = DeferredRegister.create(
            RegistryRegistration.WORLD_LAYERS, MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus)
    {
        LAYER_MAPS.register(modEventBus);
        LAYERS.register(modEventBus);
    }

    private static ResourceKey<WorldLayer> getLayer_StoneGen_Overworld_Vanilla(
            @Nullable LevelReader level, @Nullable ChunkGenerator chunkGenerator,
            RandomState randomState, WorldLayerMap layerMap,
            List<ResourceKey<WorldLayer>> layerKeyList, BlockPos origin)
    {
        return origin.getY() > 0 ? VANILLA_OVERWORLD_STONE.getKey() : VANILLA_OVERWORLD_DEEPSLATE.getKey();
    }

    private static ResourceKey<WorldLayer> getLayer_StoneGen_Overworld_Overhaul(
            @Nullable LevelReader level, @Nullable ChunkGenerator chunkGenerator,
            RandomState randomState, WorldLayerMap layerMap,
            List<ResourceKey<WorldLayer>> layerKeyList, BlockPos origin)
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

    public static final String DEFAULT_LAYER_MAP_NAME = "none";
    public static final String DEFAULT_LAYER_NAME = "none";
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> NONE_LAYER_MAP =                           LAYER_MAPS.register(DEFAULT_LAYER_MAP_NAME,       WorldLayerMap.newLayerMap(Level.OVERWORLD, WorldLayerMap.DEFAULT_LAYER_GETTER));
    public static final DeferredHolder<WorldLayer, WorldLayer> NONE_LAYER =                                     LAYERS.register(DEFAULT_LAYER_NAME,               WorldLayer.newLayer(NONE_LAYER_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));

    // == Vanilla ==
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_OVERWORLD_MAP =                    LAYER_MAPS.register("vanilla_overworld",    WorldLayerMap.newLayerMap(Level.OVERWORLD, WorldLayersRegistration::getLayer_StoneGen_Overworld_Vanilla));
    public static final DeferredHolder<WorldLayer, WorldLayer> VANILLA_OVERWORLD_STONE =                        LAYERS.register("stone",                    WorldLayer.newLayer(VANILLA_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));
    public static final DeferredHolder<WorldLayer, WorldLayer> VANILLA_OVERWORLD_DEEPSLATE =                    LAYERS.register("deepslate",                WorldLayer.newLayer(VANILLA_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_NETHER_MAP =                       LAYER_MAPS.register("vanilla_nether",       WorldLayerMap.newLayerMap(Level.NETHER, WorldLayerMap.DEFAULT_LAYER_GETTER));
    // No layers defined
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_END_MAP =                          LAYER_MAPS.register("vanilla_end",          WorldLayerMap.newLayerMap(Level.END, WorldLayerMap.DEFAULT_LAYER_GETTER));
    // No layers defined

    // == Overhaul ==
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> OVERHAUL_OVERWORLD_MAP =                   LAYER_MAPS.register("overhaul_overworld",   WorldLayerMap.newLayerMap(Level.OVERWORLD, WorldLayersRegistration::getLayer_StoneGen_Overworld_Overhaul));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_ASHFALL =                     LAYERS.register("ashfall",                  WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_REGOLITH =                    LAYERS.register("regolith",                 WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_SEDIMENTARY =                 LAYERS.register("sedimentary",              WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_METAMORPHIC =                 LAYERS.register("metamorphic",              WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE =           LAYERS.register("igneous_intrusive",        WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.LOWER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE =      LAYERS.register("deep_igneous_intrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.LOWER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE =      LAYERS.register("soft_igneous_extrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE =      LAYERS.register("hard_igneous_extrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
}
