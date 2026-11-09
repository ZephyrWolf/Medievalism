package io.github.zephyrwolf.medievalism;

import com.mojang.logging.LogUtils;
import io.github.zephyrwolf.medievalism.common.additionaldrops.AdditionalDropsSystem;
import io.github.zephyrwolf.medievalism.common.block.OverhaulBlockBreakSystem;
import io.github.zephyrwolf.medievalism.datagen.DataGenRegistration;
import io.github.zephyrwolf.medievalism.registration.*;
import io.github.zephyrwolf.medievalism.registration.advancements.CriteriaTriggersRegistration;
import io.github.zephyrwolf.medievalism.registration.blockentity.BlockEntityRegistration;
import io.github.zephyrwolf.medievalism.common.advancements.CriteriaTriggerEvents;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.CreativeTabRegistration;
import io.github.zephyrwolf.medievalism.registration.capabilities.CapabilitiesRegistration;
import io.github.zephyrwolf.medievalism.registration.components.DataComponentTypeRegistration;
import io.github.zephyrwolf.medievalism.registration.item.*;
import io.github.zephyrwolf.medievalism.registrationclient.particle.ClientParticleProviderRegistration;
import io.github.zephyrwolf.medievalism.registration.particles.ParticleTypeRegistration;
import io.github.zephyrwolf.medievalism.registrationclient.render.ClientColoursRegistration;
import io.github.zephyrwolf.medievalism.registrationclient.render.ClientExtensionsRegistration;
import io.github.zephyrwolf.medievalism.registration.menu.ClientMenuScreenRegistration;
import io.github.zephyrwolf.medievalism.registration.menu.MenuRegistration;
import io.github.zephyrwolf.medievalism.registration.recipe.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import io.github.zephyrwolf.medievalism.registration.sounds.SoundsRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.FeatureRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldCellRegionRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.WorldLayersRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MedievalismConstants.MOD_ID)
public class MedievalismMod
{
    public static final Logger LOGGER = LogUtils.getLogger();

    public MedievalismMod(IEventBus bus, ModContainer ignoredModContainer)
    {
        registerCommon(bus);
        registerServer(bus);
        registerClient(bus);
    }

    private void registerCommon(IEventBus bus)
    {
        // Registries
        RegistryRegistration.setup(bus);
        PackRegistration.register(bus);
        DataGenRegistration.register(bus);
        NetworkRegistration.register(bus);

        // Game Objects
        BlockRegistration.register(bus);

        ItemRegistration.register(bus);
        BlockEntityRegistration.register(bus);
        CreativeTabRegistration.register(bus);
        CapabilitiesRegistration.register(bus);
        DataComponentTypeRegistration.register(bus);
        MenuRegistration.register(bus);

        // Crafting
        RecipeRegistration.register(bus);
        MalleableMaterialRegistration.register(bus);

        // World Gen
        FeatureRegistration.register(bus);
        WorldLayersRegistration.register(bus);
        WorldCellRegionRegistration.register(bus);
        PlacementModifierRegistration.register(bus);

        // Effects
        ParticleTypeRegistration.register(bus);
        SoundsRegistration.register(bus);
        ClientParticleProviderRegistration.register(bus);

        // Advancement
        CriteriaTriggersRegistration.register(bus);

        // Event Handlers
        CriteriaTriggerEvents.registerEventHandlers();
        AdditionalDropsSystem.registerEventHandlers();
        CriteriaTriggerEvents.registerEventHandlers();

        OverhaulBlockBreakSystem.registerEventHandlers(); // TODO This should only run with overhaul data enabled
    }

    private void registerServer(IEventBus bus)
    {

    }

    // This approach may still crash in a server environment
    private void registerClient(IEventBus bus)
    {
        ClientColoursRegistration.register(bus);
        ClientMenuScreenRegistration.register(bus);
        ClientExtensionsRegistration.register(bus);
    }
}
