package io.github.zephyrwolf.medievalism.registration.client;

import io.github.zephyrwolf.medievalism.client.screen.GatherersJarScreen;
import io.github.zephyrwolf.medievalism.client.screen.KeepersCrockScreen;
import io.github.zephyrwolf.medievalism.client.screen.SettlersPotScreen;
import io.github.zephyrwolf.medievalism.client.screen.StoneBenchScreen;
import io.github.zephyrwolf.medievalism.registration.menu.MenuRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public final class ClientMenuScreenRegistration
{
    public static void register(IEventBus bus)
    {
        bus.addListener(ClientMenuScreenRegistration::registerMenuScreens);
    }

    private static void registerMenuScreens(RegisterMenuScreensEvent event)
    {
        event.register(MenuRegistration.STONE_BENCH_MENU.get(), StoneBenchScreen::new);

        event.register(MenuRegistration.GATHERERS_JAR_MENU.get(), GatherersJarScreen::new);
        event.register(MenuRegistration.KEEPERS_CROCK_MENU.get(), KeepersCrockScreen::new);
        event.register(MenuRegistration.SETTLERS_POT_MENU.get(), SettlersPotScreen::new);
    }
}
