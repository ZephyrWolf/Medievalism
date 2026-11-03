package io.github.zephyrwolf.medievalism.datagen.base.lang;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.KeepersCrockBlock;
import io.github.zephyrwolf.medievalism.common.block.SettlersPotBlock;
import io.github.zephyrwolf.medievalism.common.block.StoneBenchBlock;
import io.github.zephyrwolf.medievalism.common.data.ILanguageProviderEntry;
import io.github.zephyrwolf.medievalism.common.data.LanguageProviderHandle;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.item.BlockItemRegistration;

public class RockLangEntry implements ILanguageProviderEntry
{
    public void addTranslations(LanguageProviderHandle handle)
    {
        addBlockTranslations(handle);
        addBlockItemTranslations(handle);
        addSoundTranslations(handle);
        addItemTranslations(handle);
        addCreativeTabTranslations(handle);
        addGUITranslations(handle);
        addTooltipTranslations(handle);
    }

    private void addBlockTranslations(LanguageProviderHandle handle)
    {

    }

    private void addBlockItemTranslations(LanguageProviderHandle handle)
    {
        // ROCK
        handle.addBlockItem(BlockItemRegistration.SANDSTONE_ROCK.get(), "Sandstone Rock");
        handle.addBlockItem(BlockItemRegistration.RED_SANDSTONE_ROCK.get(), "Red Sandstone Rock");
        handle.addBlockItem(BlockItemRegistration.SAPROLITE_ROCK.get(), "Saprolite Rock");
        handle.addBlockItem(BlockItemRegistration.LATERITE_ROCK.get(), "Laterite Rock");
        handle.addBlockItem(BlockItemRegistration.SILT_CLUMP.get(), "Silt Clump");
        handle.addBlockItem(BlockItemRegistration.GREYWACKE_ROCK.get(), "Greywacke Rock");
        handle.addBlockItem(BlockItemRegistration.SILTSTONE_ROCK.get(), "Siltstone Rock");
        handle.addBlockItem(BlockItemRegistration.DOLOSTONE_ROCK.get(), "Dolostone Rock");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE_ROCK.get(), "Limestone Rock");
        handle.addBlockItem(BlockItemRegistration.IRONSTONE_ROCK.get(), "Ironstone Rock");
        handle.addBlockItem(BlockItemRegistration.SHALE_ROCK.get(), "Shale Rock");
        handle.addBlockItem(BlockItemRegistration.ARKOSE_ROCK.get(), "Arkose Rock");
        handle.addBlockItem(BlockItemRegistration.MARBLE_ROCK.get(), "Marble Rock");
        handle.addBlockItem(BlockItemRegistration.QUARTZITE_ROCK.get(), "Quartzite Rock");
        handle.addBlockItem(BlockItemRegistration.HORNFELS_ROCK.get(), "Hornfels Rock");
        handle.addBlockItem(BlockItemRegistration.SLATE_ROCK.get(), "Slate Rock");
        handle.addBlockItem(BlockItemRegistration.GABBRO_ROCK.get(), "Gabbro Rock");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_DIORITE_ROCK.get(), "Smooth Diorite Rock");
        handle.addBlockItem(BlockItemRegistration.SMOOTH_GRANITE_ROCK.get(), "Smooth Granite Rock");
        handle.addBlockItem(BlockItemRegistration.NORITE_ROCK.get(), "Norite Rock");
        handle.addBlockItem(BlockItemRegistration.PERIDOTITE_ROCK.get(), "Peridotite Rock");
        handle.add(BlockItemRegistration.GREYWACKE_ROCK.get().getDescriptionId() + ".hammerstone", "Greywacke Hammerstone");
        handle.add(BlockItemRegistration.SILTSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Siltstone Hammerstone");
        handle.add(BlockItemRegistration.DOLOSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Dolostone Hammerstone");
        handle.add(BlockItemRegistration.LIMESTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Limestone Hammerstone");
        handle.add(BlockItemRegistration.IRONSTONE_ROCK.get().getDescriptionId() + ".hammerstone", "Ironstone Hammerstone");
        handle.add(BlockItemRegistration.ARKOSE_ROCK.get().getDescriptionId() + ".hammerstone", "Arkose Hammerstone");
        handle.add(BlockItemRegistration.MARBLE_ROCK.get().getDescriptionId() + ".hammerstone", "Marble Hammerstone");
        handle.add(BlockItemRegistration.QUARTZITE_ROCK.get().getDescriptionId() + ".hammerstone", "Quartzite Hammerstone");
        handle.add(BlockItemRegistration.HORNFELS_ROCK.get().getDescriptionId() + ".hammerstone", "Hornfels Hammerstone");
        handle.add(BlockItemRegistration.SLATE_ROCK.get().getDescriptionId() + ".hammerstone", "Slate Hammerstone");
        handle.add(BlockItemRegistration.GABBRO_ROCK.get().getDescriptionId() + ".hammerstone", "Gabbro Hammerstone");
        handle.add(BlockItemRegistration.SMOOTH_DIORITE_ROCK.get().getDescriptionId() + ".hammerstone", "Smooth Diorite Hammerstone");
        handle.add(BlockItemRegistration.SMOOTH_GRANITE_ROCK.get().getDescriptionId() + ".hammerstone", "Smooth Granite Hammerstone");
        handle.add(BlockItemRegistration.NORITE_ROCK.get().getDescriptionId() + ".hammerstone", "Norite Hammerstone");
        handle.add(BlockItemRegistration.PERIDOTITE_ROCK.get().getDescriptionId() + ".hammerstone", "Peridotite Hammerstone");
        // LARGE ROCK
        handle.addBlockItem(BlockItemRegistration.LARGE_SANDSTONE_ROCK.get(), "Large Sandstone Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(), "Red Large Sandstone Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SAPROLITE_ROCK.get(), "Large Saprolite Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_LATERITE_ROCK.get(), "Large Laterite Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SILT_CLUMP.get(), "Large Silt Clump");
        handle.addBlockItem(BlockItemRegistration.LARGE_GREYWACKE_ROCK.get(), "Large Greywacke Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SILTSTONE_ROCK.get(), "Large Siltstone Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_DOLOSTONE_ROCK.get(), "Large Dolostone Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_LIMESTONE_ROCK.get(), "Large Limestone Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_IRONSTONE_ROCK.get(), "Large Ironstone Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SHALE_ROCK.get(), "Large Shale Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_ARKOSE_ROCK.get(), "Large Arkose Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_MARBLE_ROCK.get(), "Large Marble Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_QUARTZITE_ROCK.get(), "Large Quartzite Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_HORNFELS_ROCK.get(), "Large Hornfels Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SLATE_ROCK.get(), "Large Slate Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_GABBRO_ROCK.get(), "Large Gabbro Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SMOOTH_DIORITE_ROCK.get(), "Large Smooth Diorite Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_SMOOTH_GRANITE_ROCK.get(), "Large Smooth Granite Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_NORITE_ROCK.get(), "Large Norite Rock");
        handle.addBlockItem(BlockItemRegistration.LARGE_PERIDOTITE_ROCK.get(), "Large Peridotite Rock");
        // COPPER ROCK
        handle.addBlockItem(BlockItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(), "Saprolite Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(), "Greywacke Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(), "Siltstone Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(), "Dolostone Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(), "Limestone Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.CHALK_ROCK_COPPER_ORE.get(), "Chalk Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(), "Ironstone Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.SHALE_ROCK_COPPER_ORE.get(), "Shale Rock with Copper");
        handle.addBlockItem(BlockItemRegistration.ARKOSE_ROCK_COPPER_ORE.get(), "Arkose Rock with Copper");

        handle.addBlockItem(BlockItemRegistration.STONE_BENCH.get(), "Stone Bench");
    }

    private void addSoundTranslations(LanguageProviderHandle handle)
    {
        handle.add("medievalism.sound.entity.inhand_knap.hit", "In-hand Knap Hit");
        handle.add("medievalism.sound.entity.inhand_knap.final_hit", "In-hand Knap Final Hit");
        handle.add("medievalism.sound.entity.inhand_knap.fail", "In-hand Knap Fail");
    }

    private void addItemTranslations(LanguageProviderHandle handle)
    {
    }

    private void addCreativeTabTranslations(LanguageProviderHandle handle)
    {
    }

    private void addGUITranslations(LanguageProviderHandle handle)
    {
        handle.add(StoneBenchBlock.LANG_DEFAULT_NAME, "Stone bench");
    }

    private void addTooltipTranslations(LanguageProviderHandle handle)
    {
        handle.add("medievalism.tooltip.hard_rock.can_knap", "This rock is hard enough to knap");
    }
}
