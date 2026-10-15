package io.github.zephyrwolf.medievalism.registration.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterialType;
import io.github.zephyrwolf.medievalism.common.malleablematerial.StoneMalleableMaterial;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class MalleableMaterialRegistration
{
    public static final DeferredRegister<MalleableMaterialType> MATERIALS = DeferredRegister.create(
            RegistryRegistration.MALLEABLE_MATERIALS, MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus) { MATERIALS.register(modEventBus); }

    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> AIR = MATERIALS.register("air", MalleableMaterialType::new);
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> CLAY = MATERIALS.register("clay", () -> new MalleableMaterialType(0xFFAFB9D6, 0xFF373944));
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> STONE = MATERIALS.register("stone", StoneMalleableMaterial::new);
}
