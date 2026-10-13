package io.github.zephyrwolf.medievalism.data.base.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class BaseWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    // Take a defined feature type and configure it to a particular instance
    // Take a configured feature and define how it is placed
    // Take a placed feature and define where it is placed

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, BaseConfiguredFeaturesProviderEntry::bootstrap)
            .add(Registries.PLACED_FEATURE, BasePlacedFeaturesProviderEntry::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BaseBiomeModifiersProviderEntry::bootstrap)

            .add(Registries.NOISE, BaseNoiseProviderEntry::bootstrap); // Can't be overhaul because it effects the registry. Overhaul can only be for toggles, not registry

    public BaseWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, BUILDER, Set.of("minecraft", MedievalismConstants.MOD_ID)); // Medievalism Only
    }

    @Override
    public @NotNull String getName()
    {
        return "Registries/WorldGen";
    }
}
