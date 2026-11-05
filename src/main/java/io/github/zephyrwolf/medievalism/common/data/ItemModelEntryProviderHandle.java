package io.github.zephyrwolf.medievalism.common.data;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;

public class ItemModelEntryProviderHandle
{
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    private final ItemModelProvider provider;
    private String modId;
    private String folder;

    public ItemModelEntryProviderHandle(ItemModelProvider provider, String modId)
    {
        this.provider = provider;
        this.modId = modId;
        this.folder = "";
    }

    public void setModId(String modId) { this.modId = modId; }
    public void setFolder(String folder) { this.folder = folder; }

    // --

    private String itemName(Item item) // Also for BlockItem
    {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public ResourceLocation resourceBlock(String path)
    {
        return resourceBlock(modId, path);
    }

    public ResourceLocation resourceBlock(String modId, String path)
    {
        String fullPath = folder.isEmpty() ?
                String.join("/", "block", path) :
                String.join("/", "block", folder, path);
        return ResourceLocation.fromNamespaceAndPath(modId, fullPath);
    }

    public ResourceLocation resourceItem(String path)
    {
        return resourceItem(modId, path);
    }

    public ResourceLocation resourceItem(String modId, String path)
    {
        String fullPath = folder.isEmpty() ?
                String.join("/", "item", path) :
                String.join("/", "item", folder, path);
        return ResourceLocation.fromNamespaceAndPath(modId, fullPath);
    }

    public void blockBasedModel(Item item, String suffix) {
        provider.withExistingParent(itemName(item), resourceBlock(MedievalismConstants.MOD_ID, itemName(item) + suffix));
    }

    public void blockBasedModel(Item item, String modId, String suffix) {
        provider.withExistingParent(itemName(item), resourceBlock(modId, itemName(item) + suffix));
    }

    public void mirrorBlockBasedModel(Item item, Item block, String suffix)
    {
        provider.withExistingParent(itemName(item), resourceBlock(MedievalismConstants.MOD_ID, itemName(block) + suffix));
    }

    public void mirrorBlockBasedModel(Item item, String modid, Item block, String suffix)
    {
        provider.withExistingParent(itemName(item), resourceBlock(modid, itemName(block) + suffix));
    }

    public void blockIconGeneratedModel(Item item)
    {
        blockIconGeneratedModel(item, resourceBlock(MedievalismConstants.MOD_ID, itemName(item)));
    }

    public void blockIconGeneratedModel(Item item, String modId)
    {
        blockIconGeneratedModel(item, resourceBlock(modId, itemName(item)));
    }

    public void blockIconGeneratedModel(Item item, ResourceLocation texture)
    {
        provider.withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    @SuppressWarnings("unused")
    public void itemHandheldModel(Item item, ResourceLocation texture)
    {
        provider.withExistingParent(itemName(item), HANDHELD).texture("layer0", texture);
    }

    public void itemGeneratedModel(Item item) {
        itemGeneratedModel(item, resourceItem(MedievalismConstants.MOD_ID, itemName(item)));
    }

    public void itemGeneratedModel(Item item, String modId) {
        itemGeneratedModel(item, resourceItem(modId, itemName(item)));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture)
    {
        provider.withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }


}
