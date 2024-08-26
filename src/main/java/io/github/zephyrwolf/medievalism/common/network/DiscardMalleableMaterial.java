package io.github.zephyrwolf.medievalism.common.network;

import io.github.zephyrwolf.medievalism.common.menu.StoneBenchMenu;
import io.github.zephyrwolf.medievalism.content.NetworkRegistration;
import io.netty.buffer.ByteBuf;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record DiscardMalleableMaterial() implements CustomPacketPayload
{
    public static final StreamCodec<ByteBuf, DiscardMalleableMaterial> STREAM_CODEC = StreamCodec.unit(new DiscardMalleableMaterial());

    @Override
    public Type<? extends CustomPacketPayload> type() { return NetworkRegistration.DISCARD_MALLEABLE_MATERIAL; }

    public static void handleDiscardMalleableMaterial(final DiscardMalleableMaterial data, final IPayloadContext context)
    {
        Player player = context.player();
        if (player.containerMenu instanceof StoneBenchMenu menu)
        {
            context.enqueueWork(() -> { // Main Thread
                        menu.blockEntity.setStoredMaterial(null);
                        menu.blockEntity.setChangedAndSendUpdates();
                        menu.updateResult();
                    })
                    .exceptionally(e -> {
                        context.disconnect(Component.translatable("medievalism.networking.failed", e.getMessage()));
                        return null;
                    });
        }
    }
}
