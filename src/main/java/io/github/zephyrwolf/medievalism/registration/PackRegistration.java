package io.github.zephyrwolf.medievalism.registration;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.resource.BuiltinRepositorySource;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
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
        IModInfo modInfo = ModList.get().getModContainerById(MedievalismConstants.MOD_ID)
                .orElseThrow(() -> new IllegalArgumentException("Mod not found: " + MedievalismConstants.MOD_ID)).getModInfo();
        Path root = modInfo.getOwningFile().getFile().getFilePath();
        Path overhaulClientPath = event.getPackType() == PackType.CLIENT_RESOURCES
                ? root.resolve("overhaul_client")
                : root.resolve("overhaul_server");
        event.addRepositorySource(BuiltinRepositorySource.of(event.getPackType(), overhaulClientPath));
    }
}
