package io.github.zephyrwolf.medievalism;

import com.mojang.logging.LogUtils;
import io.github.zephyrwolf.medievalism.registration.*;
import io.github.zephyrwolf.medievalism.registration.advancements.CriteriaTriggersRegistration;
import io.github.zephyrwolf.medievalism.registration.blockentity.BlockEntityRegistration;
import io.github.zephyrwolf.medievalism.registration.block.BlockEventRegistration;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.CreativeTabRegistration;
import io.github.zephyrwolf.medievalism.registration.capabilities.CapabilitiesRegistration;
import io.github.zephyrwolf.medievalism.registration.client.ClientColoursRegistration;
import io.github.zephyrwolf.medievalism.registration.client.ClientExtensionsRegistration;
import io.github.zephyrwolf.medievalism.registration.client.ClientMenuScreenRegistration;
import io.github.zephyrwolf.medievalism.registration.entity.EntityEventRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.menu.MenuRegistration;
import io.github.zephyrwolf.medievalism.registration.recipe.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import io.github.zephyrwolf.medievalism.registration.worldgen.FeatureRegistration;
import io.github.zephyrwolf.medievalism.data.DataGenRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.slf4j.Logger;

@Mod(MedievalismConstants.MOD_ID)
public class MedievalismMod {
    public static final Logger LOGGER = LogUtils.getLogger();

    public MedievalismMod(IEventBus bus, ModContainer ignoredModContainer) {
        bus.addListener(this::commonSetup);

        RegistryRegistration.setup(bus);
        PackRegistration.register(bus);
        CriteriaTriggersRegistration.register(bus);
        ItemRegistration.register(bus);
        BlockItemRegistration.register(bus);
        BlockRegistration.register(bus);
        MenuRegistration.register(bus);
        RecipeRegistration.register(bus);
        BlockEventRegistration.register();
        EntityEventRegistration.register();
        FeatureRegistration.register(bus);
        DataGenRegistration.register(bus);
        NetworkRegistration.register(bus);
        BlockEntityRegistration.register(bus);
        CreativeTabRegistration.register(bus);
        MalleableMaterialRegistration.register(bus);
        ClientColoursRegistration.register(bus);

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
