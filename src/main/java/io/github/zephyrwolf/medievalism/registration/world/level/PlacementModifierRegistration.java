package io.github.zephyrwolf.medievalism.registration.world.level;

import com.google.common.collect.Table;
import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.CompositeFeature;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.SpeckledOreFeature;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.CompositeFeatureConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.SpeckledOreConfiguration;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement.CellPlacement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class PlacementModifierRegistration
{
    public static final DeferredRegister<PlacementModifierType<?>> MODIFIERS = DeferredRegister.create(
            BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus) { MODIFIERS.register(modEventBus); }

    public static final Supplier<PlacementModifierType<?>> CELL = modifier("cell", CellPlacement.CODEC);

    private static Supplier<PlacementModifierType<?>> modifier(String name, MapCodec<CellPlacement> codec)
    {
        return MODIFIERS.register(name, () -> new PlacementModifierType<CellPlacement>()
        {
            @Override
            public @NotNull MapCodec<CellPlacement> codec() { return codec; }
        });
    }
}
