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

    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> NONE_LAYER_MAP =                           LAYER_MAPS.register("none",                 WorldLayerMap.newLayerMap(Level.OVERWORLD));
    public static final DeferredHolder<WorldLayer, WorldLayer> NONE_LAYER =                                     LAYERS.register("none",                     WorldLayer.newLayer(NONE_LAYER_MAP.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE, null, 100, 1.0f, 15));

    // == Vanilla ==
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_OVERWORLD =                        LAYER_MAPS.register("vanilla_overworld",    WorldLayerMap.newLayerMap(Level.OVERWORLD));
    public static final DeferredHolder<WorldLayer, WorldLayer> VANILLA_OVERWORLD_STONE =                        LAYERS.register("stone",                    WorldLayer.newLayer(VANILLA_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE, null, 100, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> VANILLA_OVERWORLD_DEEPSLATE =                    LAYERS.register("deepslate",                WorldLayer.newLayer(VANILLA_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE, null, 100, 1.0f, 15));
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_NETHER =                           LAYER_MAPS.register("vanilla_nether",       WorldLayerMap.newLayerMap(Level.NETHER));
    // No layers defined
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> VANILLA_END =                              LAYER_MAPS.register("vanilla_end",          WorldLayerMap.newLayerMap(Level.END));
    // No layers defined

    // == Overhaul ==
    public static final DeferredHolder<WorldLayerMap, WorldLayerMap> OVERHAUL_OVERWORLD =                       LAYER_MAPS.register("overhaul_overworld",   WorldLayerMap.newLayerMap(Level.OVERWORLD));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_ASHFALL =                     LAYERS.register("ashfall",                  WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER,  NoiseRegistration.NOISE_ASHFALL,                  350, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_REGOLITH =                    LAYERS.register("regolith",                 WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER,  NoiseRegistration.NOISE_REGOLITH,                 500, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_SEDIMENTARY =                 LAYERS.register("sedimentary",              WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.NONE,   NoiseRegistration.NOISE_SEDIMENTARY,              500, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_METAMORPHIC =                 LAYERS.register("metamorphic",              WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER,  NoiseRegistration.NOISE_METAMORPHIC,              600, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE =           LAYERS.register("igneous_intrusive",        WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.LOWER,  NoiseRegistration.NOISE_IGNEOUS_INTRUSIVE,        700, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE =      LAYERS.register("deep_igneous_intrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.LOWER,  NoiseRegistration.NOISE_DEEP_IGNEOUS_INTRUSIVE,   800, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE =      LAYERS.register("soft_igneous_extrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER,  NoiseRegistration.NOISE_SOFT_IGNEOUS_EXTRUSIVE,   500, 1.0f, 15));
    public static final DeferredHolder<WorldLayer, WorldLayer> OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE =      LAYERS.register("hard_igneous_extrusive",   WorldLayer.newLayer( OVERHAUL_OVERWORLD.getKey(), Level.OVERWORLD, WorldLayerAnchor.UPPER,  NoiseRegistration.NOISE_HARD_IGNEOUS_EXTRUSIVE,   500, 1.0f, 15));
}
