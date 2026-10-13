package io.github.zephyrwolf.medievalism.data.overhauldata.worldgen;

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

public final class OverhaulWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, OverhaulConfiguredFeaturesProviderEntry::bootstrap)
            .add(Registries.PLACED_FEATURE, OverhaulPlacedFeaturesProviderEntry::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, OverhaulBiomeModifiersProviderEntry::bootstrap);

    public OverhaulWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, BUILDER, Set.of("minecraft", MedievalismConstants.MOD_ID)); // Overhaul Vanilla and Medievalism
    }

    @Override
    public @NotNull String getName()
    {
        return "Registries/WorldGen";
    }
}
