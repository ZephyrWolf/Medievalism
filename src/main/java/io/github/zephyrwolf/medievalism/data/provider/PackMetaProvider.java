package io.github.zephyrwolf.medievalism.data.provider;

import com.google.gson.JsonObject;
import net.minecraft.SharedConstants;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class PackMetaProvider implements DataProvider
{
    private final PackOutput output;
    // resource 34, data 48
    private int packFormat = 0;
    private int minFormat = 0;
    private int maxFormat = 0;
    private String description = "";

    public static PackMetaProvider of(PackOutput output, PackType packType)
    {
        return (new PackMetaProvider(output)).format(SharedConstants.getCurrentVersion().getPackVersion(packType));
    }

    public PackMetaProvider format(int format)
    {
        packFormat = format;
        minFormat = format;
        maxFormat = format;
        return this;
    }

    public PackMetaProvider supportedFormats(int minInclusive, int maxInclusive)
    {
        minFormat = minInclusive;
        maxFormat = maxInclusive;
        return this;
    }

    public PackMetaProvider description(String desc)
    {
        description = desc;
        return this;
    }

    // --

    public PackMetaProvider(PackOutput output)
    {
        this.output = output;
    }

    // protected abstract void addTranslations();

    @Override
    public CompletableFuture<?> run(CachedOutput cache)
    {
        //addTranslations();

        //if (!data.isEmpty())
            return save(cache, this.output.getOutputFolder().resolve("pack.mcmeta"));

        //return CompletableFuture.allOf();
    }

    // SharedConstants.getCurrentVersion().getPackVersion(this.type)

    private CompletableFuture<?> save(CachedOutput cache, Path target)
    {
        // MCTODO: DataProvider.saveStable handles the caching and hashing already, but creating the JSON Object this way seems unreliable. -C
        JsonObject json = new JsonObject();
        JsonObject packObj = new JsonObject();
        packObj.addProperty("pack_format", packFormat); // resource 34, data 48
        //packObj.addProperty("supported_formats", "["+minFormat+","+maxFormat+"]");
        packObj.addProperty("description", description);
        json.add("pack", packObj);
        return DataProvider.saveStable(cache, json, target);
    }

    @Override
    public @NotNull String getName() { return "PackMeta"; }
}
