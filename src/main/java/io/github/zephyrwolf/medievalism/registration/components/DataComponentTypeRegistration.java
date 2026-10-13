package io.github.zephyrwolf.medievalism.registration.components;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.components.DummyDataComponent;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class DataComponentTypeRegistration
{
    public static final DeferredRegister.DataComponents DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(MedievalismConstants.MOD_ID);

    public static final Supplier<DataComponentType<DummyDataComponent>> DUMMY = DATA_COMPONENT_TYPES.registerComponentType(
            "dummy", builder -> builder.networkSynchronized(DummyDataComponent.STREAM_CODEC));

    public static void register(IEventBus bus)
    {
        DATA_COMPONENT_TYPES.register(bus);
    }
}
