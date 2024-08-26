package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.menu.StoneBenchMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class MenuRegistration
{
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, MedievalismConstants.MOD_ID);

    public static final Supplier<MenuType<StoneBenchMenu>> STONE_BENCH_MENU =
            registerMenuType("stone_bench_menu", StoneBenchMenu::new);

    @SuppressWarnings("SameParameterValue")
    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory)
    {
        return MENUS.register(name, () -> new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS));
    }

    public static void register(IEventBus eventBus)
    {
        MENUS.register(eventBus);
    }
}
