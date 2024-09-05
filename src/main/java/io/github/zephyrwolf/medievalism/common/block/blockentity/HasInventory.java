package io.github.zephyrwolf.medievalism.common.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public interface HasInventory {
    IItemHandler getInventory();

    default NonNullList<ItemStack> getInventoryAsList() {
        NonNullList<ItemStack> stacks = NonNullList.create();
        for (int slot = 0; slot < getInventory().getSlots(); slot++) {
            stacks.add(slot, getInventory().getStackInSlot(slot));
        }
        return stacks;
    }

    default int getAnalogueSignal(Level pLevel, BlockPos pPos)
    {
        float f = 0.0F;
        IItemHandler inventory = getInventory();
        int inventorySize = inventory.getSlots();
        for (int slot = 0; slot < inventorySize; slot++) {
            ItemStack itemstack = inventory.getStackInSlot(slot);
            if (!itemstack.isEmpty()) {
                f += (float) itemstack.getCount() / Math.min(itemstack.getMaxStackSize(), inventory.getSlotLimit(slot));
            }
        }
        f /= (float) inventorySize;
        return Mth.lerpDiscrete(f, 0, 15);
    }
}
