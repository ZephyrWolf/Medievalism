package io.github.zephyrwolf.medievalism.tools;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public final class PlayerInventoryTools
{
    /*
    RETURNS The remaining size of pStack.
     */
    public static int addStackToPlayerInventory(@NotNull Player pPlayer, @NotNull ItemStack pStack, boolean includeOffhand, boolean pSendPacket, boolean simulate)
    {
        ItemStack toInsert = simulate ? pStack.copy() : pStack; // defensive copy
        int slotId = includeOffhand ? Inventory.SLOT_OFFHAND : Inventory.NOT_FOUND_INDEX;

        int pStackCount = addStackToPlayerInventorySlot(pPlayer, toInsert, slotId, pSendPacket, simulate);
        for (slotId = 0; slotId < Inventory.INVENTORY_SIZE && pStackCount > 0; slotId++)
        {
            pStackCount = addStackToPlayerInventorySlot(pPlayer, toInsert, slotId, pSendPacket, simulate);
        }
        return pStackCount;
    }

    /*
    RETURNS The remaining size of pStack.
     */
    public static int addStackToPlayerInventorySlot(@NotNull Player pPlayer, @NotNull ItemStack pStack, int slotId, boolean pSendPacket, boolean simulate)
    {
        ItemStack toInsert = simulate ? pStack.copy() : pStack; // defensive copy

        int pStackCount = pStack.getCount();
        ItemStack stackInSlot = pPlayer.getInventory().getItem(slotId);
        if (stackInSlot.isEmpty())
        {
            if (!simulate)
            {
                pPlayer.getInventory().setItem(slotId, toInsert);
                if (pSendPacket)
                { notifyChangedSlot(pPlayer, slotId); }
            }
            return 0; // Moved the entire stack
        }
        else if (ItemStack.isSameItemSameComponents(stackInSlot, toInsert))
        {
            int space = stackInSlot.getMaxStackSize() - stackInSlot.getCount();
            int toInsertCount = toInsert.getCount();
            int transferAmt = Math.min(toInsertCount, space);
            if (transferAmt > 0)
            {
                pStackCount -= transferAmt;
                if (!simulate)
                {
                    stackInSlot.grow(transferAmt);
                    toInsert.shrink(transferAmt);
                    if (pSendPacket)
                    { notifyChangedSlot(pPlayer, slotId); }
                }
            }
        }
        return pStackCount;
    }

    public static void notifyChangedSlot(Player pPlayer, int slotId)
    {
        if (pPlayer instanceof ServerPlayer serverPlayer)
        { // I got sending this packet from Inventory.placeItemBackInInventory which this method is based upon
            serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(-2, 0, slotId, pPlayer.getInventory().getItem(slotId)));
        }
    }

}
