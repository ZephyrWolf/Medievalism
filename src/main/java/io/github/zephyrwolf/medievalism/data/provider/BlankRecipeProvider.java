package io.github.zephyrwolf.medievalism.data.provider;

import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class BlankRecipeProvider implements DataProvider
{
    private final PackOutput output;
    // resource 34, data 48
    private final List<ResourceLocation> recipes = new ArrayList<>();

    public BlankRecipeProvider(PackOutput output)
    {
        this.output = output;
        addRecipes();
    }

    protected abstract void addRecipes();

    public void addBlank(String namespace, String path)
    {
        recipes.add(ResourceLocation.fromNamespaceAndPath(namespace, path));
    }

    public void addBlank(ResourceLocation location)
    {
        recipes.add(location);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache)
    {
        if (recipes.isEmpty()) return CompletableFuture.completedFuture(null);
        CompletableFuture<?> future = null;
        Path rootPath = this.output.getOutputFolder().resolve("data");
        for (ResourceLocation location : recipes)
        {
            Path target = rootPath.resolve(location.getNamespace()).resolve("recipe").resolve(location.getPath() + ".json");
            if (future == null)
            {
                future = save(cache, target);
            }
            future = future.thenCompose((val) -> save(cache, target));
        }
        return future;
    }

    // SharedConstants.getCurrentVersion().getPackVersion(this.type)

    private CompletableFuture<?> save(CachedOutput cache, Path target)
    {
        // MCTODO: DataProvider.saveStable handles the caching and hashing already, but creating the JSON Object this way seems unreliable. -C
        JsonObject json = new JsonObject();
        return DataProvider.saveStable(cache, json, target);
    }

    @Override
    public @NotNull String getName() { return "BlankRecipe"; }
}
