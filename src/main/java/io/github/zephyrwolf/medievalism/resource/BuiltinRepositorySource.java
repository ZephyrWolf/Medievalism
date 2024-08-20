package io.github.zephyrwolf.medievalism.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import io.github.zephyrwolf.medievalism.service.ServiceManager;
import io.github.zephyrwolf.medievalism.tools.LangTools;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.*;
import net.minecraft.server.packs.repository.*;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public final class BuiltinRepositorySource implements RepositorySource
{ // https://github.com/CraftTweaker/ContentTweaker/blob/1.20.1/core/src/main/java/com/blamejared/contenttweaker/core/resource/UserRepositorySource.java
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().setLenient().create();
    //private static final Path TARGET = ServiceManager.platform().gameDirectory().resolve("resources"); // TODO("Maybe move somewhere else?")

    private final PackType type;
    private final Path target;

    /*
    public static BuiltinRepositorySource of(final PackType type)
    {
        return new BuiltinRepositorySource(
                Objects.requireNonNull(type),
                ServiceManager.platform().gameDirectory().resolve("resources"));
    }
    */

    public static BuiltinRepositorySource of(final PackType type, Path target)
    {
        return new BuiltinRepositorySource(
                Objects.requireNonNull(type),
                target);
    }

    private BuiltinRepositorySource(final PackType type, Path target)
    {
        this.type = type;
        this.target = target;
    }

    @Override
    public void loadPacks(final @NotNull Consumer<Pack> consumer)
    {
        if (!this.verify())
        {
            return; // Not a directory
        }
        try
        {
            //var hi = Thread.currentThread().getThreadGroup();
            //var s = SidedThreadGroups.SERVER;
            //var c = SidedThreadGroups.CLIENT;
            //var dangerous = Minecraft.getInstance().level; // still null, fuck me, how am i to optionally include them now?!


            consumer.accept(getPack());
        }
        catch (final IOException e)
        {
            MedievalismMod.LOGGER.warn("An error occurred while walking user resources", e);
        }
    }

    private boolean verify()
    {
        return Files.isDirectory(target);
    }

    private Pack _pack;

    private Pack getPack() throws IOException
    {   // MC Doesn't cache theirs, and yet I need to so that mine isn't culled from;
        // PackSelectionScreen > PackSelectionModel.findNewPacks() > this.selected.retainAll(this.repository.getAvailablePacks);
        // Despite my pack still being available, it fails since they aren't the same instance. I do not know where MC is caching theirs.
        if (_pack == null) _pack = createPack();
        return _pack;
        //return createPack();
    }
    /*
    @Override
    public boolean equals(Object obj) // Doesn't work to resolve issue with List.retainAll
    {
        if (obj instanceof BuiltinRepositorySource other)
        {
            return other.target == target && other.type == type;
        }
        return false; // super.equals(obj);
    }
    */

    private Pack createPack() throws IOException
    {
        final Path metadataPath = target.resolve("pack.mcmeta");
        final JsonObject metadata = this.readMetadata(metadataPath);
        final String packId = ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "overhaul/" + this.type.name().toLowerCase(Locale.ENGLISH)).toString();
        final Component packTitle = Component.translatable(LangTools.lang(MedievalismConstants.MOD_ID, "pack.title.overhaul." + this.type.name().toLowerCase(Locale.ENGLISH)));
        final PackSource source = PackSource.create(this::decorateSource, true);
        final KnownPack knownPackInfo = new KnownPack(MedievalismConstants.MOD_ID, "overhaul/" + this.type.name().toLowerCase(Locale.ENGLISH), SharedConstants.getCurrentVersion().getId());
        final PackLocationInfo locationInfo = new PackLocationInfo(packId, packTitle, source, Optional.of(knownPackInfo));
        final PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
        final Pack pack = Pack.readMetaAndCreate(locationInfo, BuiltInPackSource.fixedResources(resources(locationInfo, metadata)), type, selectionConfig);
        if (pack == null)
        {
            throw new IOException("Unable to create pack due to an unknown IO error", new NullPointerException());
        }
        return pack;
    }

    private JsonObject readMetadata(final Path path) throws IOException
    {
        if (Files.exists(path)) {
            try (final InputStreamReader reader = new InputStreamReader(Files.newInputStream(path, StandardOpenOption.READ))) {
                return GSON.fromJson(reader, JsonObject.class);
            }
        }
        throw new IOException("Unable to locate file '" + path+ "'.");
    }

    private PackResources resources(final PackLocationInfo locationInfo, final JsonObject metadata)
    {
        // final PackResources resources = new PathPackResources(locationInfo, target);
        //return new UserPack(GSON, name, resources, metadata);
        return new PathPackResources(locationInfo, target);
    }

    private Component decorateSource(final Component originalName) // , PackType type)
    { // Where does this come into play
        return Component.translatable(
                "pack.nameAndSource",
                originalName,
                Component.translatable(LangTools.lang(MedievalismConstants.MOD_ID, "pack.source.overhaul")) // + this.type.name().toLowerCase(Locale.ENGLISH)))
        ).withStyle(ChatFormatting.GRAY);
    }
}