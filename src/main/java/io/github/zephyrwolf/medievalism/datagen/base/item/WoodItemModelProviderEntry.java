package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class WoodItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        materials(handle);
        tools(handle);
        workstations(handle);
    }

    private void materials(ItemModelProviderHandle handle)
    {
        handle.setFolder("wood");

        handle.itemGeneratedModel(ItemRegistration.CHARCOAL_POWDER.get());
        handle.itemGeneratedModel(ItemRegistration.POTASH.get());
        handle.itemGeneratedModel(ItemRegistration.WOOD_ASH.get());
        handle.itemGeneratedModel(ItemRegistration.CHOPPED_WOOD.get());
        handle.itemGeneratedModel(ItemRegistration.TANNIN_BUCKET.get());

        handle.itemGeneratedModel(ItemRegistration.WHITE_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.BROWN_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.GREY_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.DARK_BROWN_BARK.get());
        handle.itemGeneratedModel(ItemRegistration.BLACK_BARK.get());

        handle.setFolder("");

        handle.blockBasedModel(BlockItemRegistration.BIRCH_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.OAK_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.SPRUCE_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.JUNGLE_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.ACACIA_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.DARK_OAK_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.CHERRY_BRANCH.get(), "");
        handle.blockBasedModel(BlockItemRegistration.MANGROVE_BRANCH.get(), "");
    }

    private void tools(ItemModelProviderHandle handle)
    {
        handle.setFolder("wood");

        handle.itemGeneratedModel(ItemRegistration.DIGGING_STICK.get());
        handle.itemGeneratedModel(ItemRegistration.FIRE_STARTER.get());
    }

    private void workstations(ItemModelProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(BlockItemRegistration.CHOPPING_BLOCK.get(), "");
    }
}
