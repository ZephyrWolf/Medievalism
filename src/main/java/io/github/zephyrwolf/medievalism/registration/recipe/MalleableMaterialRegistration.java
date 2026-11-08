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
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> POTTERS_CLAY = MATERIALS.register("potters_clay", () -> new MalleableMaterialType(0xFF9098AF, 0xFF373944));
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> KAOLIN_CLAY = MATERIALS.register("kaolin_clay", () -> new MalleableMaterialType(0xFFF1EEE5, 0xFF8F8A7D));
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> CHINA_CLAY = MATERIALS.register("china_clay", () -> new MalleableMaterialType(0xFFE2E2E2, 0xFF8E8E8E));
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> REFRACTORY_CLAY = MATERIALS.register("refractory_clay", () -> new MalleableMaterialType(0xFFEFD288, 0xFF54492F));
    // Knapping
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> ROCK = MATERIALS.register("rock", RockMalleableMaterial::new);
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> FLINT = MATERIALS.register("flint", () -> new RockMalleableMaterial(0xFF3D3C3C, 0xFF0E0E0E));
    // Carving
    public static final DeferredHolder<MalleableMaterialType, MalleableMaterialType> BONE = MATERIALS.register("bone", BoneMalleableMaterial::new);
    // Weaving

}
