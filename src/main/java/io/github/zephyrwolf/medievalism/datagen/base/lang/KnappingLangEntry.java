package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.StoneBenchBlock;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageEntryProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;

public class KnappingLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageEntryProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addSoundTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageEntryProviderHandle handle)
    {

    }

    private void addBlockItemTranslations(LanguageEntryProviderHandle handle)
    {
        // ROCK
        handle.addBlock(BlockRegistration.SANDSTONE_ROCK.get(), "Sandstone Rock");
        handle.addBlock(BlockRegistration.RED_SANDSTONE_ROCK.get(), "Red Sandstone Rock");
        handle.addBlock(BlockRegistration.SAPROLITE_ROCK.get(), "Saprolite Rock");
        handle.addBlock(BlockRegistration.LATERITE_ROCK.get(), "Laterite Rock");
        handle.addBlock(BlockRegistration.SILT_CLUMP.get(), "Silt Clump");
        handle.addBlock(BlockRegistration.GREYWACKE_ROCK.get(), "Greywacke Rock");
        handle.addBlock(BlockRegistration.SILTSTONE_ROCK.get(), "Siltstone Rock");
        handle.addBlock(BlockRegistration.DOLOSTONE_ROCK.get(), "Dolostone Rock");
        handle.addBlock(BlockRegistration.LIMESTONE_ROCK.get(), "Limestone Rock");
        handle.addBlock(BlockRegistration.IRONSTONE_ROCK.get(), "Ironstone Rock");
        handle.addBlock(BlockRegistration.SHALE_ROCK.get(), "Shale Rock");
        handle.addBlock(BlockRegistration.ARKOSE_ROCK.get(), "Arkose Rock");
        handle.addBlock(BlockRegistration.MARBLE_ROCK.get(), "Marble Rock");
        handle.addBlock(BlockRegistration.QUARTZITE_ROCK.get(), "Quartzite Rock");
        handle.addBlock(BlockRegistration.HORNFELS_ROCK.get(), "Hornfels Rock");
        handle.addBlock(BlockRegistration.SLATE_ROCK.get(), "Slate Rock");
        handle.addBlock(BlockRegistration.GABBRO_ROCK.get(), "Gabbro Rock");
        handle.addBlock(BlockRegistration.SMOOTH_DIORITE_ROCK.get(), "Smooth Diorite Rock");
        handle.addBlock(BlockRegistration.SMOOTH_GRANITE_ROCK.get(), "Smooth Granite Rock");
        handle.addBlock(BlockRegistration.NORITE_ROCK.get(), "Norite Rock");
        handle.addBlock(BlockRegistration.PERIDOTITE_ROCK.get(), "Peridotite Rock");
        handle.add(ItemRegistration.GREYWACKE_ROCK.get().getDescriptionId() + ".hammerstone", "Greywacke Hammerstone");
        handle.add(ItemRegistration.SILTSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Siltstone Hammerstone");
        handle.add(ItemRegistration.DOLOSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Dolostone Hammerstone");
        handle.add(ItemRegistration.LIMESTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Limestone Hammerstone");
        handle.add(ItemRegistration.IRONSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Ironstone Hammerstone");
        handle.add(ItemRegistration.ARKOSE_ROCK.get().getDescriptionId() + ".hammerstone", "Arkose Hammerstone");
        handle.add(ItemRegistration.MARBLE_ROCK.get().getDescriptionId() + ".hammerstone", "Marble Hammerstone");
        handle.add(ItemRegistration.QUARTZITE_ROCK.get().getDescriptionId() + ".hammerstone", "Quartzite Hammerstone");
        handle.add(ItemRegistration.HORNFELS_ROCK.get().getDescriptionId() + ".hammerstone", "Hornfels Hammerstone");
        handle.add(ItemRegistration.SLATE_ROCK.get().getDescriptionId() + ".hammerstone", "Slate Hammerstone");
        handle.add(ItemRegistration.GABBRO_ROCK.get().getDescriptionId() + ".hammerstone", "Gabbro Hammerstone");
        handle.add(ItemRegistration.SMOOTH_DIORITE_ROCK.get().getDescriptionId() + ".hammerstone", "Smooth Diorite Hammerstone");
        handle.add(ItemRegistration.SMOOTH_GRANITE_ROCK.get().getDescriptionId() + ".hammerstone", "Smooth Granite Hammerstone");
        handle.add(ItemRegistration.NORITE_ROCK.get().getDescriptionId() + ".hammerstone", "Norite Hammerstone");
        handle.add(ItemRegistration.PERIDOTITE_ROCK.get().getDescriptionId() + ".hammerstone", "Peridotite Hammerstone");
        // LARGE ROCK
        handle.addBlock(BlockRegistration.LARGE_SANDSTONE_ROCK.get(), "Large Sandstone Rock");
        handle.addBlock(BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "Red Large Sandstone Rock");
        handle.addBlock(BlockRegistration.LARGE_SAPROLITE_ROCK.get(), "Large Saprolite Rock");
        handle.addBlock(BlockRegistration.LARGE_LATERITE_ROCK.get(), "Large Laterite Rock");
        handle.addBlock(BlockRegistration.LARGE_SILT_CLUMP.get(), "Large Silt Clump");
        handle.addBlock(BlockRegistration.LARGE_GREYWACKE_ROCK.get(), "Large Greywacke Rock");
        handle.addBlock(BlockRegistration.LARGE_SILTSTONE_ROCK.get(), "Large Siltstone Rock");
        handle.addBlock(BlockRegistration.LARGE_DOLOSTONE_ROCK.get(), "Large Dolostone Rock");
        handle.addBlock(BlockRegistration.LARGE_LIMESTONE_ROCK.get(), "Large Limestone Rock");
        handle.addBlock(BlockRegistration.LARGE_IRONSTONE_ROCK.get(), "Large Ironstone Rock");
        handle.addBlock(BlockRegistration.LARGE_SHALE_ROCK.get(), "Large Shale Rock");
        handle.addBlock(BlockRegistration.LARGE_ARKOSE_ROCK.get(), "Large Arkose Rock");
        handle.addBlock(BlockRegistration.LARGE_MARBLE_ROCK.get(), "Large Marble Rock");
        handle.addBlock(BlockRegistration.LARGE_QUARTZITE_ROCK.get(), "Large Quartzite Rock");
        handle.addBlock(BlockRegistration.LARGE_HORNFELS_ROCK.get(), "Large Hornfels Rock");
        handle.addBlock(BlockRegistration.LARGE_SLATE_ROCK.get(), "Large Slate Rock");
        handle.addBlock(BlockRegistration.LARGE_GABBRO_ROCK.get(), "Large Gabbro Rock");
        handle.addBlock(BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "Large Smooth Diorite Rock");
        handle.addBlock(BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "Large Smooth Granite Rock");
        handle.addBlock(BlockRegistration.LARGE_NORITE_ROCK.get(), "Large Norite Rock");
        handle.addBlock(BlockRegistration.LARGE_PERIDOTITE_ROCK.get(), "Large Peridotite Rock");
        // COPPER ROCK
        handle.addBlock(BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), "Saprolite Rock with Copper");
        handle.addBlock(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "Greywacke Rock with Copper");
        handle.addBlock(BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "Siltstone Rock with Copper");
        handle.addBlock(BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "Dolostone Rock with Copper");
        handle.addBlock(BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "Limestone Rock with Copper");
        handle.addBlock(BlockRegistration.CHALK_ROCK_COPPER_ORE.get(), "Chalk Rock with Copper");
        handle.addBlock(BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "Ironstone Rock with Copper");
        handle.addBlock(BlockRegistration.SHALE_ROCK_COPPER_ORE.get(), "Shale Rock with Copper");
        handle.addBlock(BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "Arkose Rock with Copper");

        handle.addBlock(BlockRegistration.STONE_BENCH.get(), "Stone Bench");
    }

    private void addSoundTranslations(LanguageEntryProviderHandle handle)
    {
        handle.add("medievalism.sound.entity.inhand_knap.hit", "In-hand Knap Hit");
        handle.add("medievalism.sound.entity.inhand_knap.final_hit", "In-hand Knap Final Hit");
        handle.add("medievalism.sound.entity.inhand_knap.fail", "In-hand Knap Fail");
    }

    private void addItemTranslations(LanguageEntryProviderHandle handle)
    {
        handle.addItem(ItemRegistration.LUNATE.get(), "Lunate");
        handle.addItem(ItemRegistration.BIFACE.get(), "Biface");
    }

    private void addCreativeTabTranslations(LanguageEntryProviderHandle handle)
    {
    }

    private void addGUITranslations(LanguageEntryProviderHandle handle)
    {
        handle.add(StoneBenchBlock.LANG_DEFAULT_NAME, "Stone bench");
    }

    private void addTooltipTranslations(LanguageEntryProviderHandle handle)
    {
        handle.add("medievalism.tooltip.hard_rock.can_knap", "This rock is hard enough to knap");
    }
}
