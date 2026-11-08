package io.github.zephyrwolf.medievalism.datagen.base.itemmodel;

import io.github.zephyrwolf.medievalism.common.data.IItemModelProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.ItemModelEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.KnappingItemRegistration;

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

        handle.itemGeneratedModel(KnappingItemRegistration.BROKEN_GOAT_HORN.get());
    }

    private void tools(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("knapping");

        handle.itemGeneratedModel(KnappingItemRegistration.LUNATE.get());

        handle.itemGeneratedModel(KnappingItemRegistration.ANTLER.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_KNIFE_BLADE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.FLINT_KNIFE_BLADE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.BONE_KNIFE_BLADE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_KNIFE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.FLINT_KNIFE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.BONE_KNIFE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_AXE_HEAD.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_AXE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_PICKAXE_HEAD.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ANTLER_PICKAXE_HEAD.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_PICKAXE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ANTLER_PICKAXE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_HOE_HEAD.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ANTLER_HOE_HEAD.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_HOE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ANTLER_HOE.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_SPEAR_HEAD.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_SPEAR.get());
        handle.itemGeneratedModel(KnappingItemRegistration.ROCK_SICKLE.get());
    }

    private void workstations(ItemModelEntryProviderHandle handle)
    {
        handle.setFolder("");

        handle.blockBasedModel(ItemRegistration.STONE_BENCH.get(), "");
    }
}
