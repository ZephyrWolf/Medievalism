package io.github.zephyrwolf.medievalism.registration;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterialType;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayerMap;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldCellRegionRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.ModifyRegistriesEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public final class RegistryRegistration
{
    @SuppressWarnings("FieldMayBeFinal") // No it can't
    private static List<Registry<?>> _pendingRegistries = new ArrayList<>();

    public static final ResourceKey<Registry<MalleableMaterialType>>    MALLEABLE_MATERIALS =               ResourceKey.createRegistryKey(MedievalismConstants.resource("malleable_material"));
    public static final ResourceKey<Registry<WorldLayerMap>>            WORLD_LAYER_MAPS =                  ResourceKey.createRegistryKey(MedievalismConstants.resource("world_layer_map"));
    public static final ResourceKey<Registry<WorldLayer>>               WORLD_LAYERS =                      ResourceKey.createRegistryKey(MedievalismConstants.resource("world_layer"));
    public static final ResourceKey<Registry<WorldCellRegionMap>>       WORLD_CELL_REGION_MAPS =            ResourceKey.createRegistryKey(MedievalismConstants.resource("world_cell_region_map"));
    public static final ResourceKey<Registry<WorldCellRegion>>          WORLD_CELL_REGIONS =                ResourceKey.createRegistryKey(MedievalismConstants.resource("world_cell_region"));

    public static final Registry<MalleableMaterialType>                 MALLEABLE_MATERIALS_REGISTRY =      _registerNewRegistry(MALLEABLE_MATERIALS, MedievalismConstants.resource("air")); // Can't reference keys before registry is created
    public static final Registry<WorldLayerMap>                         WORLD_LAYER_MAPS_REGISTRY =         _registerNewRegistry(WORLD_LAYER_MAPS, MedievalismConstants.resource(WorldLayersRegistration.DEFAULT_LAYER_MAP_NAME));
    public static final Registry<WorldLayer>                            WORLD_LAYERS_REGISTRY =             _registerNewRegistry(WORLD_LAYERS, MedievalismConstants.resource(WorldLayersRegistration.DEFAULT_LAYER_NAME));
    public static final Registry<WorldCellRegionMap>                    WORLD_CELL_REGION_MAP_REGISTRY =    _registerNewRegistry(WORLD_CELL_REGION_MAPS, MedievalismConstants.resource(WorldCellRegionRegistration.DEFAULT_CELL_REGION_MAP_NAME));
    public static final Registry<WorldCellRegion>                       WORLD_CELL_REGION_REGISTRY =        _registerNewRegistry(WORLD_CELL_REGIONS, MedievalismConstants.resource(WorldCellRegionRegistration.DEFAULT_CELL_REGION_NAME));

    public static <T> Holder.Reference<T> lookupRegistryHolder(Registry<T> registry, T obj)
    {
        var key = registry.getId(obj);
        var holder = registry.getHolder(key);
        if (holder.isEmpty())
        {
            throw new IllegalStateException("Cannot locate holder for " + key);
        }
        return holder.get();
    }

    public static void setup(IEventBus bus)
    {
        bus.addListener(RegistryRegistration::registerRegistries);
        bus.addListener(RegistryRegistration::modifyRegistries);
    }

    private static <T> Registry<T> _registerNewRegistry(ResourceKey<Registry<T>> key, ResourceLocation def)
    {
        Registry<T> registry = new RegistryBuilder<>(key)
                .sync(true)
                .defaultKey(def)
                //.maxId(256)
                .create();
        _pendingRegistries.add(registry);
        return registry;
    }

    private static void registerRegistries(NewRegistryEvent event)
    {
        for (Registry<?> registry : _pendingRegistries)
        {
            event.register(registry);
        }
    }

    private static void modifyRegistries(ModifyRegistriesEvent event)
    {
    }
}
