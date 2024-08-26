package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.network.DiscardMalleableMaterial;
import io.github.zephyrwolf.medievalism.common.network.MalleableMaterialCellClicked;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public final class NetworkRegistration
{
    public static final CustomPacketPayload.Type<MalleableMaterialCellClicked> MALLEABLE_MATERIAL_CELL_CLICKED = new CustomPacketPayload.Type<>(MedievalismConstants.resource( "malleable_material_cell_clicked"));
    public static final CustomPacketPayload.Type<DiscardMalleableMaterial> DISCARD_MALLEABLE_MATERIAL = new CustomPacketPayload.Type<>(MedievalismConstants.resource("discard_malleable_material"));

    public static void register(IEventBus bus)
    {
        bus.addListener(NetworkRegistration::addPacketHandlers);
    }

    private static void addPacketHandlers(final RegisterPayloadHandlersEvent event)
    {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToServer(
                MALLEABLE_MATERIAL_CELL_CLICKED,
                MalleableMaterialCellClicked.STREAM_CODEC,
                MalleableMaterialCellClicked::handleMalleableMaterialCellClicked
        );
        registrar.playToServer(
                DISCARD_MALLEABLE_MATERIAL,
                DiscardMalleableMaterial.STREAM_CODEC,
                DiscardMalleableMaterial::handleDiscardMalleableMaterial
        );
    }
}
