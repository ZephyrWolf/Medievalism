package io.github.zephyrwolf.medievalism;

import io.github.zephyrwolf.medievalism.common.block.ModBlockEvents;
import io.github.zephyrwolf.medievalism.content.*;
//import io.github.zephyrwolf.medievalism.resource.ClientModPackSource;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;
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

    public MedievalismMod(IEventBus bus, ModContainer modContainer)
    {
        bus.addListener(this::commonSetup);

        PackRegistration.register(bus);
        ItemRegistration.register(bus);
        BlockRegistration.register(bus);
        RecipeRegistration.register(bus);
        FeatureRegistration.register(bus);
        DataGenRegistration.register(bus);
        CreativeTabRegistration.register(bus);

        NeoForge.EVENT_BUS.addListener(ModBlockEvents::blockDrops);
        NeoForge.EVENT_BUS.addListener(ModBlockEvents::breakSpeed);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, ModBlockEvents::onToolUse);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
