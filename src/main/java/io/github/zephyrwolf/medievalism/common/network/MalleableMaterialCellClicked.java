package io.github.zephyrwolf.medievalism.common.network;

import io.github.zephyrwolf.medievalism.common.menu.StoneBenchMenu;
import io.github.zephyrwolf.medievalism.content.NetworkRegistration;
import io.netty.buffer.ByteBuf;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
public record MalleableMaterialCellClicked(int index) implements CustomPacketPayload
{
    public static final StreamCodec<ByteBuf, MalleableMaterialCellClicked> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.INT,
                    MalleableMaterialCellClicked::index,
                    MalleableMaterialCellClicked::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() { return NetworkRegistration.MALLEABLE_MATERIAL_CELL_CLICKED; }

    public static void handleMalleableMaterialCellClicked(final MalleableMaterialCellClicked data, final IPayloadContext context)
    {
        // network thread // heavy work here
        Player player = context.player();
        if (player.containerMenu instanceof StoneBenchMenu menu)
        {
            var op = menu.blockEntity.getMaterial();
            if (op.isPresent())
            {
                context.enqueueWork(() -> { // Main Thread
                            menu.blockEntity.cellClicked(data.index);
                        })
                        .exceptionally(e -> {
                            context.disconnect(Component.translatable("medievalism.networking.failed", e.getMessage()));
                            return null;
                        });
            }
        }
    }
}
