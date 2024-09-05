package io.github.zephyrwolf.medievalism;

import com.mojang.logging.LogUtils;
import io.github.zephyrwolf.medievalism.content.*;
import io.github.zephyrwolf.medievalism.content.block.BlockEntityRegistration;
import io.github.zephyrwolf.medievalism.content.block.BlockEventRegistration;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.CreativeTabRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.menu.MenuRegistration;
import io.github.zephyrwolf.medievalism.content.recipe.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.content.recipe.RecipeRegistration;
import io.github.zephyrwolf.medievalism.content.worldgen.FeatureRegistration;
import io.github.zephyrwolf.medievalism.data.DataGenRegistration;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.slf4j.Logger;

@Mod(MedievalismConstants.MOD_ID)
public class MedievalismMod {
    public static final Logger LOGGER = LogUtils.getLogger();

    public MedievalismMod(IEventBus bus, ModContainer ignoredModContainer) {
        bus.addListener(this::commonSetup);

        PackRegistration.register(bus);
        ItemRegistration.register(bus);
        MenuRegistration.register(bus);
        BlockRegistration.register(bus);
        RecipeRegistration.register(bus);
        BlockEventRegistration.register();
        FeatureRegistration.register(bus);
        DataGenRegistration.register(bus);
        NetworkRegistration.register(bus);
        RegistryRegistration.register(bus);
        BlockEntityRegistration.register(bus);
        CreativeTabRegistration.register(bus);
        MalleableMaterialRegistration.register(bus);

        bus.addListener(this::registerCapabilities);
    }

    private void registerCapabilities(final RegisterCapabilitiesEvent event)
    {
        /*
        event.registerItem(
                Capabilities.ItemHandler.ITEM,
                (itemStack, context) -> {
                    ItemStackHandler items = new ItemStackHandler(4);
                    var dataMap = itemStack.getComponents();
                    var container = dataMap.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
                    for (int slot = 0; slot < container.getSlots(); slot++) {
                        items.setStackInSlot(slot, container.getStackInSlot(slot));
                    }
                    return items;
                    },
                BlockRegistration.GATHERERS_JAR_ITEM
        );
        */
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
