package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.*;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.feature.configuration.*;
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
    public static final Supplier<SpeckledOreFeature> SPECKLED_ORE_FEATURE = FEATURES.register("speckled_ore", () -> new SpeckledOreFeature(SpeckledOreConfiguration.CODEC));
    public static final Supplier<LayerSelectorFeature> LAYER_SELECTOR_FEATURE = FEATURES.register("layer_selector", () -> new LayerSelectorFeature(LayerSelectorFeatureConfiguration.CODEC.codec()));
    public static final Supplier<CellSelectorFeature> CELL_SELECTOR_FEATURE = FEATURES.register("cell_selector", () -> new CellSelectorFeature(CellSelectorFeatureConfiguration.CODEC.codec()));
    public static final Supplier<DisableFeature> DISABLE_FEATURE = FEATURES.register("disable", () -> new DisableFeature(DisableFeatureConfiguration.CODEC.codec()));
    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
