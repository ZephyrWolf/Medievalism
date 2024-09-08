package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import io.github.zephyrwolf.medievalism.content.loot.LootContextParamSetRegistration;
import io.github.zephyrwolf.medievalism.data.block.*;
import io.github.zephyrwolf.medievalism.data.item.BaseItemModelsProvider;
import io.github.zephyrwolf.medievalism.data.item.BaseItemTagsProvider;
import io.github.zephyrwolf.medievalism.data.lang.BaseLanguageProvider;
import io.github.zephyrwolf.medievalism.data.lang.OverhaulLanguageProvider;
import io.github.zephyrwolf.medievalism.data.loot.BaseAdditionalDropsTablesSubProvider;
import io.github.zephyrwolf.medievalism.data.loot.BaseBlockLootTablesSubProvider;
import io.github.zephyrwolf.medievalism.data.loot.OverhaulBlockLootTablesSubProvider;
import io.github.zephyrwolf.medievalism.data.loot.OverhaulMobLootTablesSubProvider;
import io.github.zephyrwolf.medievalism.data.provider.PackMetaProvider;
import io.github.zephyrwolf.medievalism.data.recipe.BaseRecipeProvider;
import io.github.zephyrwolf.medievalism.data.recipe.OverhaulBlankRecipeProvider;
import io.github.zephyrwolf.medievalism.data.recipe.OverhaulRecipeProvider;
import io.github.zephyrwolf.medievalism.data.worldgen.BaseBiomeTagsProvider;
import io.github.zephyrwolf.medievalism.data.worldgen.BaseWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class DataGenRegistration { // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/DataGenerators.java

    public static void register(IEventBus eventBus) {
        eventBus.addListener(DataGenRegistration::gatherData);
    }

    public static void gatherData(GatherDataEvent event) {
        injectDataForBase(event);
        injectDataForAssetOverhaul(event);
        injectDataForDataOverhaul(event);
    }

    //region Providers
    //region Base
    private static void addProvidersForBase(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper, boolean includeServer, boolean includeClient) {
        BaseBlockTagsProvider blockTags = new BaseBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(includeServer, blockTags);
        generator.addProvider(includeServer, new BaseItemTagsProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(includeServer, new BaseBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(includeServer, new BaseRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new AdvancementProvider(packOutput, lookupProvider, existingFileHelper, List.of(new BaseAdvancementsProvider())));
        generator.addProvider(includeClient, new BaseLanguageProvider(packOutput, "en_us"));
        generator.addProvider(includeServer, new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(BaseBlockLootTablesSubProvider::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(BaseAdditionalDropsTablesSubProvider::new, LootContextParamSetRegistration.ADDITIONAL_DROPS)
        ), lookupProvider));
        BaseBlockStatesProvider blockStates = new BaseBlockStatesProvider(packOutput, existingFileHelper);
        generator.addProvider(includeClient, blockStates);
        generator.addProvider(includeClient, new BaseItemModelsProvider(packOutput, blockStates.models().existingFileHelper));
        generator.addProvider(includeServer, new BaseWorldGenProvider(packOutput, lookupProvider));
    }

    //endregion
    //region Overhaul Assets
    @SuppressWarnings("unused")
    private static void addProvidersForAssetOverhaul(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper, boolean includeServer, boolean includeClient) {
        //generator.addProvider(includeClient, ...);
        generator.addProvider(includeClient, new OverhaulLanguageProvider(packOutput, "en_us"));
        generator.addProvider(
                includeClient,
                PackMetaProvider.of(packOutput, PackType.CLIENT_RESOURCES)
                        .description("Medievalism will overhaul the look and feel of Minecraft."));
    }

    //endregion
    //region Overhaul Data
    @SuppressWarnings("unused")
    private static void addProvidersForDataOverhaul(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper, boolean includeServer, boolean includeClient) {
        generator.addProvider(includeServer, new OverhaulRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new OverhaulBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(includeServer, new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(OverhaulMobLootTablesSubProvider::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(OverhaulBlockLootTablesSubProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
        generator.addProvider(
                includeServer,
                PackMetaProvider.of(packOutput, PackType.SERVER_DATA)
                        .description("Medievalism will overhaul the progression of Minecraft."));
        // TODO I wonder if I can translate this ^^^^
    }
    //endregion
    //endregion

    //region Inject
    private static void injectDataForBase(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        try // Will move the cache
        {
            Field generatorRootOutputFolderField = generator.getClass().getDeclaredField("rootOutputFolder");
            generatorRootOutputFolderField.setAccessible(true);
            Path path = (Path) generatorRootOutputFolderField.get(generator);
            Path newPath = path.resolve(MedievalismConstants.MOD_ID);
            generatorRootOutputFolderField.set(generator, newPath);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            MedievalismMod.LOGGER.error("Unable to access restricted field 'path'. Skipping base data gen.");
            return;
        }
        // The method which takes a string will recreate the packOutput whereas the other without a param returns the pre-generated from the old path.
        PackOutput packOutput = generator.getPackOutput("");

        addProvidersForBase(generator, packOutput, event.getLookupProvider(), event.getExistingFileHelper(), event.includeServer(), event.includeClient());
    }

    private static void injectDataForAssetOverhaul(GatherDataEvent event) {
        Path path;
        try {
            Field configField = event.getClass().getDeclaredField("config");
            configField.setAccessible(true);
            GatherDataEvent.DataGeneratorConfig config = (GatherDataEvent.DataGeneratorConfig) configField.get(event);
            Field pathField = config.getClass().getDeclaredField("path");
            pathField.setAccessible(true);
            path = (Path) pathField.get(config);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            MedievalismMod.LOGGER.error("Unable to access restricted field 'path'. Skipping overhaul data gen for asset overhaul.");
            return;
        }

        GatherDataEvent.DataGeneratorConfig dataGeneratorConfig = new GatherDataEvent.DataGeneratorConfig(
                Set.of(MedievalismConstants.OVERHAUL_PACK_ID_ASSET),
                path,
                List.of(),
                event.getLookupProvider(),
                event.includeServer(),
                event.includeClient(),
                event.includeDev(),
                event.includeReports(),
                event.validate(),
                false);
        DataGenerator generator = dataGeneratorConfig.makeGenerator(
                p -> p.resolve(MedievalismConstants.OVERHAUL_PACK_ID_ASSET),
                true);
        PackOutput packOutput = generator.getPackOutput();

        addProvidersForAssetOverhaul(generator, packOutput, event.getLookupProvider(), event.getExistingFileHelper(), event.includeServer(), event.includeClient());

        dataGeneratorConfig.runAll();
    }

    private static void injectDataForDataOverhaul(GatherDataEvent event) {
        Path path;
        try {
            Field configField = event.getClass().getDeclaredField("config");
            configField.setAccessible(true);
            GatherDataEvent.DataGeneratorConfig config = (GatherDataEvent.DataGeneratorConfig) configField.get(event);
            Field pathField = config.getClass().getDeclaredField("path");
            pathField.setAccessible(true);
            path = (Path) pathField.get(config);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            MedievalismMod.LOGGER.error("Unable to access restricted field 'path'. Skipping overhaul data gen for data overhaul.");
            return;
        }

        GatherDataEvent.DataGeneratorConfig dataGeneratorConfig = new GatherDataEvent.DataGeneratorConfig(
                Set.of(MedievalismConstants.OVERHAUL_PACK_ID_DATA),
                path,
                List.of(),
                event.getLookupProvider(),
                event.includeServer(),
                event.includeClient(),
                event.includeDev(),
                event.includeReports(),
                event.validate(),
                false);
        DataGenerator generator = dataGeneratorConfig.makeGenerator(
                p -> p.resolve(MedievalismConstants.OVERHAUL_PACK_ID_DATA),
                true);
        PackOutput packOutput = generator.getPackOutput();

        addProvidersForDataOverhaul(generator, packOutput, event.getLookupProvider(), event.getExistingFileHelper(), event.includeServer(), event.includeClient());

        dataGeneratorConfig.runAll();
    }
    //endregion
}
