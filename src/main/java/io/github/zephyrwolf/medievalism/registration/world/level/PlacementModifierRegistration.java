package io.github.zephyrwolf.medievalism.registration.world.level;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement.BelowHeightmapFilter;
import net.minecraft.core.registries.BuiltInRegistries;
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

    public static final Supplier<PlacementModifierType<?>> BELOW_HEIGHTMAP = modifier("below_heightmap", BelowHeightmapFilter.CODEC);

    private static <T extends PlacementModifier> Supplier<PlacementModifierType<?>> modifier(String name, MapCodec<T> codec)
    {
        return MODIFIERS.register(name, () -> new PlacementModifierType<T>()
        {
            @Override
            public @NotNull MapCodec<T> codec() { return codec; }
        });
    }
}
