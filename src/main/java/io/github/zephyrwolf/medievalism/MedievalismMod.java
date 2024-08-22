package io.github.zephyrwolf.medievalism;

import io.github.zephyrwolf.medievalism.common.block.ModBlockEvents;
import io.github.zephyrwolf.medievalism.registry.FeatureRegistration;
import io.github.zephyrwolf.medievalism.data.base.ModCreativeModeTabs;
import io.github.zephyrwolf.medievalism.data.ModDataGeneration;
//import io.github.zephyrwolf.medievalism.resource.ClientModPackSource;
import io.github.zephyrwolf.medievalism.common.resource.BuiltinRepositorySource;
import io.github.zephyrwolf.medievalism.registry.BlockRegistration;
import io.github.zephyrwolf.medievalism.registry.ItemRegistration;
import io.github.zephyrwolf.medievalism.registry.RecipeRegistration;
import net.minecraft.server.packs.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforgespi.language.IModInfo;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.nio.file.Path;

@Mod(MedievalismConstants.MOD_ID)
public class MedievalismMod
{
    public static final Logger LOGGER = LogUtils.getLogger();

    public MedievalismMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(ModDataGeneration::gatherData);

        modEventBus.addListener(EventPriority.HIGH, false, AddPackFindersEvent.class, MedievalismMod::injectResources);

        ItemRegistration.register(modEventBus);
        BlockRegistration.register(modEventBus);
        FeatureRegistration.register(modEventBus);
        RecipeRegistration.register(modEventBus);

        //modEventBus.addListener(Registration::addCreativeModeTabContents);
        ModCreativeModeTabs.register(modEventBus);

        //NeoForge.EVENT_BUS.register(new NeoForgeEventHandlers());
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, ModBlockEvents::onToolUse);
        NeoForge.EVENT_BUS.addListener(ModBlockEvents::blockDrops);
        NeoForge.EVENT_BUS.addListener(ModBlockEvents::breakSpeed);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // https://github.com/CraftTweaker/ContentTweaker/blob/1.18/forge/src/main/java/com/blamejared/contenttweaker/forge/resource/ForgeResourceManager.java
    private static void injectResources(final AddPackFindersEvent event)
    { //     private static final Path TARGET = ServiceManager.platform().gameDirectory().resolve("resources"); // TODO("Maybe move somewhere else?")
        if (event.getPackType() == PackType.CLIENT_RESOURCES)
        {
            IModInfo modInfo = ModList.get().getModContainerById(MedievalismConstants.MOD_ID).orElseThrow(() -> new IllegalArgumentException("Mod not found: " + MedievalismConstants.MOD_ID)).getModInfo();
            Path root = modInfo.getOwningFile().getFile().getFilePath();
            Path overhaulClientPath = root.resolve("overhaul_client");
            event.addRepositorySource(BuiltinRepositorySource.of(event.getPackType(), overhaulClientPath));
        }
        else if (event.getPackType() == PackType.SERVER_DATA)  // TODO Datapacks written like this are forced!
        {
            //FMLLoader.getDist(); //  == FMLEnivornment.GetDist()
            //FMLLoader.isProduction(); // is worse than FMLEnvironment.Production. use environment
            if (FMLEnvironment.dist == Dist.CLIENT)
            { // Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER
                //var hi = Thread.currentThread().getThreadGroup();
                //var s = SidedThreadGroups.SERVER;
                //var c = SidedThreadGroups.CLIENT;
                //var dangerous = Minecraft.getInstance().level; // Wont work, what if i am a client, connecting to a server/lan
                // Haha very dangerous, its fucking null too hahaha, well fuck.
                IModInfo modInfo = ModList.get().getModContainerById(MedievalismConstants.MOD_ID).orElseThrow(() -> new IllegalArgumentException("Mod not found: " + MedievalismConstants.MOD_ID)).getModInfo();
                Path root = modInfo.getOwningFile().getFile().getFilePath();
                Path overhaulClientPath = root.resolve("overhaul_server");
                event.addRepositorySource(BuiltinRepositorySource.of(event.getPackType(), overhaulClientPath));
            }
        }
    }
}
