package io.github.zephyrwolf.medievalism;

import io.github.zephyrwolf.medievalism.content.BlockEventRegistration;
import io.github.zephyrwolf.medievalism.content.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(MedievalismConstants.MOD_ID)
public class MedievalismMod
{
    public static final Logger LOGGER = LogUtils.getLogger();

    public MedievalismMod(IEventBus bus, ModContainer ignoredModContainer)
    {
        bus.addListener(this::commonSetup);

        PackRegistration.register(bus);
        ItemRegistration.register(bus);
        BlockRegistration.register(bus);
        RecipeRegistration.register(bus);
        BlockEventRegistration.register();
        FeatureRegistration.register(bus);
        DataGenRegistration.register(bus);
        RegistryRegistration.register(bus);
        CreativeTabRegistration.register(bus);
        MalleableMaterialRegistration.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
