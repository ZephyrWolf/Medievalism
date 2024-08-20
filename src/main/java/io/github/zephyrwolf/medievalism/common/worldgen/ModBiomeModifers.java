package io.github.zephyrwolf.medievalism.common.worldgen;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.data.base.ModBiomeTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModBiomeModifers
{
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey(MedievalismConstants.resource("add_tin_ore"));
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE_UNIFORM = registerKey(MedievalismConstants.resource("add_tin_ore_uniform"));

    public static final ResourceKey<BiomeModifier> ADD_BRANCH_FOREST = registerKey(MedievalismConstants.resource("add_branch_forest"));
    public static final ResourceKey<BiomeModifier> ADD_BRANCH = registerKey(MedievalismConstants.resource("add_branch"));
    public static final ResourceKey<BiomeModifier> ADD_ROCK = registerKey(MedievalismConstants.resource("add_rock"));
    public static final ResourceKey<BiomeModifier> ADD_LARGE_ROCK = registerKey(MedievalismConstants.resource("add_large_rock"));
    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE_ROCK = registerKey(MedievalismConstants.resource("add_limestone_rock"));
    public static final ResourceKey<BiomeModifier> ADD_COPPER_ROCK = registerKey(MedievalismConstants.resource("add_copper_rock"));

    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), // Biomes.BEACH
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_TIN_ORE_UNIFORM, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), // Biomes.BEACH
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_UNIFORM_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_BRANCH_FOREST, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.HAS_DENSE_TRESS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BRANCH_FOREST_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_BRANCH, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.HAS_TREES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BRANCH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_LARGE_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_LIMESTONE_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LIMESTONE_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_COPPER_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.COPPER_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(ResourceLocation resource)
    {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, resource);
    }
}
