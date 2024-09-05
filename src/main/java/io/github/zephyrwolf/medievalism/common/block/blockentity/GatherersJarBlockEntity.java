package io.github.zephyrwolf.medievalism.common.block.blockentity;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.menu.GatherersJarMenu;
import io.github.zephyrwolf.medievalism.content.block.BlockEntityRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class GatherersJarBlockEntity extends BlockEntity implements MenuProvider, Nameable, HasInventory {
    //region Constants
    private static final String INVENTORY_TAG = "inventory";
    public static final int COLUMNS = 2;
    public static final int ROWS = 2;
    public static final int CONTAINER_SIZE = COLUMNS * ROWS;
    //endregion

    //private int openCount;

    //region Boilerplate
    public GatherersJarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistration.GATHERERS_JAR_BLOCK_ENTITY_TYPE.get(), pPos, pBlockState);
    }
    //endregion

    //region Name
    private Component customName;

    public Component getDefaultName() {
        return Component.translatable(GatherersJarBlock.LANG_DEFAULT_NAME);
    }

    @Override
    public Component getName() {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    @Override
    public Component getDisplayName() {
        return this.getName();
    }

    @Override
    public @Nullable Component getCustomName() {
        return customName;
    }
    //endregion

    //region Menu
    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new GatherersJarMenu(pContainerId, pPlayerInventory, this);
    }
    //endregion

    //region Inventory
    private final ItemStackHandler items = new ItemStackHandler(CONTAINER_SIZE) {
        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (!isItemValid(slot, stack)) return stack;
            return super.insertItem(slot, stack, simulate);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            //var block = GatherersJarBlock.byItem(stack.getItem());
            return stack.getItem().canFitInsideContainerItems();
        }

        @Override // required for serialization to work properly
        protected void onContentsChanged(int slot) {
            GatherersJarBlockEntity.this.setChanged();
        }
    };

    @Override
    public ItemStackHandler getInventory() {
        return items;
    }

    @SuppressWarnings("unused")
    public void dropInventory() {
        SimpleContainer inventory = new SimpleContainer((items.getSlots()));
        for (int slot = 0; slot < items.getSlots(); slot++) {
            // Do not drop ingredient if its is being worked
            inventory.setItem(slot, items.getStackInSlot(slot));
        }
        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    //endregion

    //region Components
    @Override // Block place
    protected void applyImplicitComponents(DataComponentInput pComponentInput) {
        super.applyImplicitComponents(pComponentInput);
        this.customName = pComponentInput.get(DataComponents.CUSTOM_NAME);
        var container = pComponentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY); //.copyInto(this.getItems());
        for (int slot = 0; slot < container.getSlots(); slot++) {
            items.setStackInSlot(slot, container.getStackInSlot(slot));
        }
    }

    @Override // Block Break
    protected void collectImplicitComponents(DataComponentMap.Builder pComponents) {
        super.collectImplicitComponents(pComponents);
        pComponents.set(DataComponents.CUSTOM_NAME, this.customName);
        pComponents.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getInventoryAsList()));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void removeComponentsFromTag(CompoundTag pTag) {
        pTag.remove("CustomName");
        pTag.remove("Items");
    }
    //endregion

    //region Serialization
    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.put(INVENTORY_TAG, items.serializeNBT(pRegistries));
        if (this.customName != null) {
            pTag.putString("CustomName", Component.Serializer.toJson(this.customName, pRegistries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        items.deserializeNBT(pRegistries, pTag.getCompound(INVENTORY_TAG));
        if (pTag.contains("CustomName", 8)) {
            this.customName = parseCustomNameSafe(pTag.getString("CustomName"), pRegistries);
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag pTag = super.getUpdateTag(pRegistries);
        saveAdditional(pTag, pRegistries);
        return pTag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    //endregion
}
