package io.github.zephyrwolf.medievalism.common.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public final class ModFeatures
{
    // Cannot add without crashing, so i am doing something wrong.
    public static void bootstrap(BootstrapContext<Feature<?>> context)
    {
    }

    public static ResourceKey<Feature<?>> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(Registries.FEATURE, resource);
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void register(BootstrapContext<Feature<?>> context, ResourceKey<Feature<?>> key, F feature)
    {
        context.register(key, feature);
    }
}
