package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.MudWorkingItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.WorldItemRegistration;

public class MudWorkingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        materials(handle);
        worldGen(handle);
        packedMud(handle);
        daub(handle);
    }

    private void materials(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("mud_working");

        handle.itemGeneratedModel(MudWorkingItemRegistration.DIRT_CHUNK.get());
        handle.itemGeneratedModel(MudWorkingItemRegistration.MUD_BALL.get());
    }

    private void worldGen(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(WorldItemRegistration.SILT.get(), "");
    }

    private void packedMud(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("mud_working");

        handle.itemGeneratedModel(MudWorkingItemRegistration.PACKED_MUD_BRICK.get());
        handle.itemGeneratedModel(MudWorkingItemRegistration.DRYING_PACKED_MUD_BRICK.get(), handle.resourceItem("wet_packed_mud_brick"));

        handle.setFolder("");
        handle.blockBasedModel(MudWorkingItemRegistration.DRYING_PACKED_MUD.get(), "");
    }

    private void daub(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("mud_working");
        handle.itemGeneratedModel(MudWorkingItemRegistration.DRYING_DAUB_BRICK.get(), handle.resourceItem("wet_daub_brick"));
        handle.itemGeneratedModel(MudWorkingItemRegistration.DAUB_BRICK.get());
        handle.itemGeneratedModel(MudWorkingItemRegistration.WET_DAUB.get());

        handle.setFolder("");
        handle.blockBasedModel(MudWorkingItemRegistration.DRYING_DAUB_BLOCK.get(), "");
        handle.blockBasedModel(MudWorkingItemRegistration.DAUB_BLOCK.get(), "");
        handle.blockBasedModel(MudWorkingItemRegistration.DAUB_BRICKS.get(), "");
        handle.blockBasedModel(MudWorkingItemRegistration.CRACKED_DAUB_BLOCK.get(), "");
        handle.blockBasedModel(MudWorkingItemRegistration.CRACKED_DAUB_BRICKS.get(), "");
    }
}
