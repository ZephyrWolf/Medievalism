package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.worldgen.feature.CompositeFeature;
import io.github.zephyrwolf.medievalism.common.worldgen.feature.configuration.CompositeFeatureConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class FeatureRegistration
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(
            Registries.FEATURE, MedievalismConstants.MOD_ID);

    public static final Supplier<CompositeFeature> COMPOSITE_FEATURE = FEATURES.register("composite", () -> new CompositeFeature(CompositeFeatureConfiguration.CODEC));

    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
