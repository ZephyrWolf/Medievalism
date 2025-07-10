package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class OverhaulWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();
            //.add(Registries.NOISE_SETTINGS, OverhaulNoiseSettings::bootstrap);

    public OverhaulWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, BUILDER, Set.of(MedievalismConstants.MOD_ID));
    }

    // TODO move overhaul code here if you can
}
