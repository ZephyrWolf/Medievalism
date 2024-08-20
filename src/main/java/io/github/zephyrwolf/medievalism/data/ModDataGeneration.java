package io.github.zephyrwolf.medievalism.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import io.github.zephyrwolf.medievalism.data.base.*;
import io.github.zephyrwolf.medievalism.data.overhaul.*;
import io.github.zephyrwolf.medievalism.data.provider.PackMetaProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class ModDataGeneration
{
    // TODO I can move the assets into sub folders with generator.getPackOutput(). If I can allow the system to handle more than one of a 'single provider' (maybe fake it), eg base and overhaul recipes then I wont have to use any reflection

    public static void gatherData(GatherDataEvent event)
    { // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/DataGenerators.java
        injectDataForBase(event);
        injectDataForAssetOverhaul(event);
        injectDataForDataOverhaul(event);

        // This would be soo easy, however, this cannot be done due to overlapping generator type. Only thing I can think to
        // do is to modify each class to take both packoutputs however this too will not work as the super classes use the
        // PathOutput to generate other files.
        //addProvidersForBase(event.getGenerator(), event.getGenerator().getPackOutput(MedievalismMod.MOD_ID), event.getLookupProvider(), event.getExistingFileHelper(), event.includeServer(), event.includeClient());
        //addProvidersForOverhaul(event.getGenerator(), event.getGenerator().getPackOutput(MedievalismMod.OVERHAUL_MOD_ID), event.getLookupProvider(), event.getExistingFileHelper(), event.includeServer(), event.includeClient());
    }

    //region Providers
    private static void addProvidersForBase(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper, boolean includeServer, boolean includeClient)
    {
        BaseBlockTags blockTags = new BaseBlockTags(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(includeServer, blockTags);
        generator.addProvider(includeServer, new BaseItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(includeServer, new BaseBiomeTags(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(event.includeServer(), new MedievalismEntityTags(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(includeServer, new BaseRecipes(packOutput, lookupProvider));
        generator.addProvider(includeServer, new AdvancementProvider(packOutput, lookupProvider, existingFileHelper, List.of(new BaseAdvancements())));
        generator.addProvider(includeClient, new BaseLanguageProvider(packOutput, "en_us"));
        generator.addProvider(includeServer, new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(BaseBlockLootTables::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
        //generator.addProvider(event.includeServer(), new StructureUpdater("structures/village/houses", FarmersDelight.MODID, existingFileHelper, packOutput));
        BaseBlockStates blockStates = new BaseBlockStates(packOutput, existingFileHelper);
        generator.addProvider(includeClient, blockStates);
        generator.addProvider(includeClient, new BaseItemModels(packOutput, blockStates.models().existingFileHelper));
        generator.addProvider(includeServer, new ModWorldGenProvider(packOutput, lookupProvider));
    }

    private static void addProvidersForAssetOverhaul(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper, boolean includeServer, boolean includeClient)
    {
        //generator.addProvider(includeClient, ...);
        generator.addProvider(includeClient, new OverhaulLanguageProvider(packOutput, "en_us"));
        generator.addProvider(
                includeClient,
                PackMetaProvider.of(packOutput, PackType.CLIENT_RESOURCES)
                        .description("Medievalism will overhaul the look and feel of Minecraft."));
    }

    private static void addProvidersForDataOverhaul(DataGenerator generator, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper, boolean includeServer, boolean includeClient)
    {
        generator.addProvider(includeServer, new OverhaulBlankRecipes(packOutput));
        generator.addProvider(includeServer, new OverhaulRecipes(packOutput, lookupProvider));
        generator.addProvider(includeServer, new OverhaulBlockTags(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(includeServer, new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(OverhaulMobLootTables::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(OverhaulBlockLootTables::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
        generator.addProvider(
                includeServer,
                PackMetaProvider.of(packOutput, PackType.SERVER_DATA)
                        .description("Medievalism will overhaul the progression of Minecraft."));
        // TODO I wonder if I can translate this ^^^^
    }
    //endregion

    //region Inject
    private static void injectDataForBase(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        try // Will move the cache
        {
            Field generatorRootOutputFolderField = generator.getClass().getDeclaredField("rootOutputFolder");
            generatorRootOutputFolderField.setAccessible(true);
            Path path = (Path) generatorRootOutputFolderField.get(generator);
            Path newPath = path.resolve(MedievalismConstants.MOD_ID);
            generatorRootOutputFolderField.set(generator, newPath);
        }
        catch (NoSuchFieldException | IllegalAccessException ignored)
        {
            MedievalismMod.LOGGER.error("Unable to access restricted field 'path'. Skipping base data gen.");
            return;
        }
        // The method which takes a string will recreate the packOutput where as the other without a param returns the pre-generated from the old path.
        // Defaults to generated/resources
        //PackOutput packOutput = generator.getPackOutput();
        // Since I moved the cache, sets to generated/resource/medievalism/medievalism
        //PackOutput packOutput = generator.getPackOutput(MedievalismMod.MOD_ID); // This doesn't move the cache but will move the assets generated.
        // Goes to generated/resources/medievalism
        PackOutput packOutput = generator.getPackOutput("");

        addProvidersForBase(generator, packOutput, event.getLookupProvider(), event.getExistingFileHelper(), event.includeServer(), event.includeClient());
    }

    private static void injectDataForAssetOverhaul(GatherDataEvent event)
    {
        Path path;
        try
        {
            Field configField = event.getClass().getDeclaredField("config");
            configField.setAccessible(true);
            GatherDataEvent.DataGeneratorConfig config = (GatherDataEvent.DataGeneratorConfig) configField.get(event);
            Field pathField = config.getClass().getDeclaredField("path");
            pathField.setAccessible(true);
            path = (Path) pathField.get(config);
        }
        catch (NoSuchFieldException | IllegalAccessException ignored)
        {
            MedievalismMod.LOGGER.error("Unable to access restricted field 'path'. Skipping overhaul data gen.");
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

    private static void injectDataForDataOverhaul(GatherDataEvent event)
    {
        Path path;
        try
        {
            Field configField = event.getClass().getDeclaredField("config");
            configField.setAccessible(true);
            GatherDataEvent.DataGeneratorConfig config = (GatherDataEvent.DataGeneratorConfig) configField.get(event);
            Field pathField = config.getClass().getDeclaredField("path");
            pathField.setAccessible(true);
            path = (Path) pathField.get(config);
        }
        catch (NoSuchFieldException | IllegalAccessException ignored)
        {
            MedievalismMod.LOGGER.error("Unable to access restricted field 'path'. Skipping overhaul data gen.");
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
