package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class MudItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        materials(handle);
        worldGen(handle);
        packedMud(handle);
        daub(handle);
    }

    private void materials(ItemModelProviderHandle handle)
    {
        handle.setFolder("mud");

        handle.itemGeneratedModel(ItemRegistration.DIRT_CHUNK.get());
        handle.itemGeneratedModel(ItemRegistration.MUD_BALL.get());
    }

    private void worldGen(ItemModelProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(BlockItemRegistration.SILT.get(), "");
    }

    private void packedMud(ItemModelProviderHandle handle)
    {
        handle.setFolder("mud");

        handle.itemGeneratedModel(ItemRegistration.PACKED_MUD_BRICK.get());
        handle.itemGeneratedModel(BlockItemRegistration.WET_PACKED_MUD_BRICK.get());

        handle.setFolder("");
        handle.blockBasedModel(BlockItemRegistration.WET_PACKED_MUD.get(), "");
    }

    private void daub(ItemModelProviderHandle handle)
    {
        handle.setFolder("mud");
        handle.itemGeneratedModel(BlockItemRegistration.WET_DAUB_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.DAUB_BRICK.get());
        handle.itemGeneratedModel(ItemRegistration.WET_DAUB.get());

        handle.setFolder("");
        handle.blockBasedModel(BlockItemRegistration.WET_DAUB_BLOCK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DAUB_BLOCK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DAUB_BRICKS.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CRACKED_DAUB_BLOCK.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CRACKED_DAUB_BRICKS.get(), "");
    }
}
