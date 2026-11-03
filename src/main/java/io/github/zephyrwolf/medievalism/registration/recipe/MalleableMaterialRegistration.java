package io.github.zephyrwolf.medievalism.registration.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.malleable.BoneMalleableMaterial;
import io.github.zephyrwolf.medievalism.common.recipe.malleable.MalleableMaterialType;
import io.github.zephyrwolf.medievalism.common.recipe.malleable.RockMalleableMaterial;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MalleableMaterialRegistration
{
    public static final DeferredRegister<MalleableMaterialType> MATERIALS = DeferredRegister.create(
            RegistryRegistration.MALLEABLE_MATERIALS, MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus) { MATERIALS.register(modEventBus); }

    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> AIR = MATERIALS.register("air", MalleableMaterialType::new);
    // Mud Works
    // Clay Works
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> CLAY = MATERIALS.register("clay", () -> new MalleableMaterialType(0xFFAFB9D6, 0xFF373944));
    // Knapping
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> STONE = MATERIALS.register("stone", RockMalleableMaterial::new);
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> FLINT = MATERIALS.register("flint", () -> new RockMalleableMaterial(0xFF3D3C3C, 0xFF0E0E0E));
    // Carving
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> BONE = MATERIALS.register("bone", BoneMalleableMaterial::new);
    // Weaving

}
