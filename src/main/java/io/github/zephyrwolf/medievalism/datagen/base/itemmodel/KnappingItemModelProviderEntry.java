package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class KnappingItemModelProviderEntry implements IItemModelProviderEntry
{
    @Override
    public void registerModels(ItemModelEntryProviderHandle handle)
    {
        mobDrops(handle);
        tools(handle);
        workstations(handle);
    }

    private void mobDrops(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("knapping");

        handle.itemGeneratedModel(ItemRegistration.BROKEN_GOAT_HORN.get());
    }

    private void tools(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("knapping");

        handle.itemGeneratedModel(ItemRegistration.LUNATE.get());
        handle.itemGeneratedModel(ItemRegistration.BIFACE.get());

        //handle.itemGeneratedModel(ItemRegistration.ROCK_KNIFE_BLADE.get());
        //handle.itemGeneratedModel(ItemRegistration.ROCK_AXE_HEAD.get());

        //handle.itemGeneratedModel(ItemRegistration.ROCK_KNIFE.get());
        //handle.itemGeneratedModel(ItemRegistration.ROCK_AXE.get());

        //handle.itemGeneratedModel(ItemRegistration.FLINT_KNIFE_BLADE.get());
        //handle.itemGeneratedModel(ItemRegistration.FLINT_KNIFE.get());

        //handle.itemGeneratedModel(BoneItemRegistration.BONE_KNIFE_BLADE.get());
        //handle.itemGeneratedModel(BoneItemRegistration.BONE_KNIFE.get());
    }

    private void workstations(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.STONE_BENCH.get(), "");
    }
}
