package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.resource.BuiltinRepositorySource;
import net.minecraft.server.packs.PackType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforgespi.language.IModInfo;

import java.nio.file.Path;

public final class PackRegistration
{ // https://github.com/CraftTweaker/ContentTweaker/blob/1.18/forge/src/main/java/com/blamejared/contenttweaker/forge/resource/ForgeResourceManager.java
    public static void register(IEventBus bus)
    {
        bus.addListener(EventPriority.HIGH, false, AddPackFindersEvent.class, PackRegistration::addBuiltinPacks);
    }

    private static void addBuiltinPacks(final AddPackFindersEvent event)
    {
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
