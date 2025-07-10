package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterialType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.ModifyRegistriesEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

public final class RegistryRegistration
{
    private static final ResourceKey<Registry<MalleableMaterialType>> MATERIALS_KEY = ResourceKey.createRegistryKey(MedievalismConstants.resource("malleable_material"));
    public static final Registry<MalleableMaterialType> MATERIALS_REGISTRY = new RegistryBuilder<>(MATERIALS_KEY)
            .sync(true)
            .defaultKey(MedievalismConstants.resource("air"))
            //.maxId(256)
            .create();

    public static void setup(IEventBus bus)
    {
        bus.addListener(RegistryRegistration::registerRegistries);
        bus.addListener(RegistryRegistration::modifyRegistries);
    }

    private static void registerRegistries(NewRegistryEvent event)
    {
        event.register(MATERIALS_REGISTRY);
    }

    private static void modifyRegistries(ModifyRegistriesEvent event)
    {
    }
}
