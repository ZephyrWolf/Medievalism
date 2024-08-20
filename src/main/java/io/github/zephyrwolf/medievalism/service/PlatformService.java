package io.github.zephyrwolf.medievalism.service;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import net.minecraft.core.Registry;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.Objects;

public class PlatformService
{ // https://github.com/CraftTweaker/ContentTweaker/blob/1.18/forge/src/main/java/com/blamejared/contenttweaker/forge/service/ForgePlatformService.java
    public Path gameDirectory()
    {
        return FMLPaths.GAMEDIR.get();
    }

    public Path locateResource(final String... components)
    {
        Objects.requireNonNull(components);
        if (components.length < 1)
        {
            throw new IllegalArgumentException("At least one component required.");
        }
        return ModList.get()
                .getModFileById(MedievalismConstants.MOD_ID)
                .getFile()
                .findResource(components);
    }
}
