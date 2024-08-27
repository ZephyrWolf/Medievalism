package io.github.zephyrwolf.medievalism.data.provider;

import com.google.gson.JsonObject;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.SharedConstants;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class PackMetaProvider implements DataProvider
{
    private final PackOutput output;
    // resource 34, data 48
    private int packFormat = 0;
    private String description = "";

    public static PackMetaProvider of(PackOutput output, PackType packType)
    {
        return (new PackMetaProvider(output)).format(SharedConstants.getCurrentVersion().getPackVersion(packType));
    }

    public PackMetaProvider format(int format)
    {
        packFormat = format;
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

    @Override
    public CompletableFuture<?> run(CachedOutput cache)
    {
        return save(cache, this.output.getOutputFolder().resolve("pack.mcmeta"));
    }

    private CompletableFuture<?> save(CachedOutput cache, Path target)
    {
        JsonObject json = new JsonObject();
        JsonObject packObj = new JsonObject();
        packObj.addProperty("pack_format", packFormat);
        packObj.addProperty("description", description);
        json.add("pack", packObj);
        return DataProvider.saveStable(cache, json, target);
    }

    @Override
    public @NotNull String getName() { return "PackMeta"; }
}
