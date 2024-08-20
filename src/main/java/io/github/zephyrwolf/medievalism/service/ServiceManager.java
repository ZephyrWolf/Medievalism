package io.github.zephyrwolf.medievalism.service;

import com.google.common.base.Suppliers;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public final class ServiceManager
{
    //private static final Supplier<PlatformService> PLATFORM = Suppliers.memoize(() -> lookup(PlatformService.class));
    private static final Supplier<PlatformService> PLATFORM = Suppliers.memoize(PlatformService::new);

    public static PlatformService platform() { return PLATFORM.get(); }

    // Allows create of an interface from an unknown package; eg fabric or forge
    //private static <T> T lookup(final Class<T> serviceClass)
    //{
    //    return ServiceLoader.load(serviceClass).findFirst().orElseThrow();
    //}
}
