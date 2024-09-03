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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
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
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
