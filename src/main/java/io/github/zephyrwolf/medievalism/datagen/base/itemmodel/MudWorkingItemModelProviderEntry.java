package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

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

        handle.itemGeneratedModel(ItemRegistration.DIRT_CHUNK.get());
        handle.itemGeneratedModel(ItemRegistration.MUD_BALL.get());
    }

    private void worldGen(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.SILT.get(), "");
    }

    private void packedMud(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("mud_working");

        handle.itemGeneratedModel(ItemRegistration.PACKED_MUD_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.DRYING_PACKED_MUD_BRICK.get(), handle.resourceItem("wet_packed_mud_brick"));

        handle.setFolder("");
        handle.blockBasedModel(ItemRegistration.DRYING_PACKED_MUD.get(), "");
    }

    private void daub(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("mud_working");
        handle.itemGeneratedModel(ItemRegistration.DRYING_DAUB_BRICK.get(), handle.resourceItem("wet_daub_brick"));
        handle.itemGeneratedModel(ItemRegistration.DAUB_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.WET_DAUB.get());

        handle.setFolder("");
        handle.blockBasedModel(ItemRegistration.DRYING_DAUB_BLOCK.get(), "");
        handle.blockBasedModel(ItemRegistration.DAUB_BLOCK.get(), "");
        handle.blockBasedModel(ItemRegistration.DAUB_BRICKS.get(), "");
        handle.blockBasedModel(ItemRegistration.CRACKED_DAUB_BLOCK.get(), "");
        handle.blockBasedModel(ItemRegistration.CRACKED_DAUB_BRICKS.get(), "");
    }
}
