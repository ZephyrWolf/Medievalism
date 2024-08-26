package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterialType;
import io.github.zephyrwolf.medievalism.common.malleablematerial.StoneMalleableMaterial;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public final class MalleableMaterialRegistration
{
    public static final DeferredRegister<MalleableMaterialType> MATERIALS = DeferredRegister.create(
            RegistryRegistration.MATERIALS_REGISTRY, MedievalismConstants.MOD_ID);

    public static final Supplier<MalleableMaterialType> AIR = MATERIALS.register("air", MalleableMaterialType::new);
    public static final Supplier<MalleableMaterialType> CLAY = MATERIALS.register("clay", () -> new MalleableMaterialType(0xFFAFB9D6, 0xFF373944));
    public static final Supplier<MalleableMaterialType> STONE = MATERIALS.register("stone", StoneMalleableMaterial::new);

    public static void register(IEventBus modEventBus)
    {
        MATERIALS.register(modEventBus);
    }
}
