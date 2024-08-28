package io.github.zephyrwolf.medievalism.data.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class BaseWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder() // TODO Should I separate different categories?
            .add(Registries.CONFIGURED_FEATURE, BaseConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, BasePlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BaseBiomeModifers::bootstrap);

    public BaseWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, BUILDER, Set.of(MedievalismConstants.MOD_ID));
    }
}
