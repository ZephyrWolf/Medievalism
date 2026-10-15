package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerAnchor;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

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

    public static final String DEFAULT_LAYER_MAP_NAME = "none";
    public static final String DEFAULT_LAYER_NAME = "none";
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> NONE_LAYER_MAP =                           LAYER_MAPS.register(DEFAULT_LAYER_MAP_NAME,       WorldLayerMap.newLayerMap(Level.OVERWORLD, null));
    public static final DeferredHolder<WorldLayer, WorldLayer> NONE_LAYER =                                     LAYERS.register(DEFAULT_LAYER_NAME,               WorldLayer.newLayer(NONE_LAYER_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));

    // == Vanilla ==
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_OVERWORLD_MAP =                        LAYER_MAPS.register("vanilla_overworld",    WorldLayerMap.newLayerMap(Level.OVERWORLD, null));
    public static final DeferredHolder<WorldLayer, WorldLayer> VANILLA_OVERWORLD_STONE =                        LAYERS.register("stone",                    WorldLayer.newLayer(VANILLA_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));
    public static final DeferredHolder<WorldLayer, WorldLayer> VANILLA_OVERWORLD_DEEPSLATE =                    LAYERS.register("deepslate",                WorldLayer.newLayer(VANILLA_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_NETHER_MAP =                           LAYER_MAPS.register("vanilla_nether",       WorldLayerMap.newLayerMap(Level.NETHER, null));
    // No layers defined
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_END_MAP =                          LAYER_MAPS.register("vanilla_end",          WorldLayerMap.newLayerMap(Level.END, null));
    // No layers defined

    // == Overhaul ==
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> OVERHAUL_OVERWORLD_MAP =                   LAYER_MAPS.register("overhaul_overworld",   WorldLayerMap.newLayerMap(Level.OVERWORLD, null));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_ASHFALL =                     LAYERS.register("ashfall",                  WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_REGOLITH =                    LAYERS.register("regolith",                 WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_SEDIMENTARY =                 LAYERS.register("sedimentary",              WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_METAMORPHIC =                 LAYERS.register("metamorphic",              WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE =           LAYERS.register("igneous_intrusive",        WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.LOWER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE =      LAYERS.register("deep_igneous_intrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.LOWER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE =      LAYERS.register("soft_igneous_extrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE =      LAYERS.register("hard_igneous_extrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER));
}
