package io.github.zephyrwolf.medievalism.datagen.base.item;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelProviderHandle;

public class BoneItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelProviderHandle handle)
    {
        mobDrops(handle);
        tools(handle);
    }

    private void mobDrops(ItemModelProviderHandle handle)
    {
        handle.setFolder("bone");
        //handle.itemGeneratedModel(BoneItemRegistration.BROKEN_GOAT_HORN.get());
    }

    private void tools(ItemModelProviderHandle handle)
    {
        handle.setFolder("bone");
        //handle.itemGeneratedModel(BoneItemRegistration.BONE_KNIFE_BLADE.get());
        //handle.itemGeneratedModel(BoneItemRegistration.BONE_KNIFE.get());
    }
}
