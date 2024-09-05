package io.github.zephyrwolf.medievalism.common.menu;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.block.blockentity.GatherersJarBlockEntity;
import io.github.zephyrwolf.medievalism.common.block.blockentity.HasInventory;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.menu.MenuRegistration;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GatherersJarMenu extends AbstractContainerMenu implements HasInventory, Nameable {
    public static final int COLUMNS = 2;
    public static final int ROWS = 2;

    // private final Container container;

    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int VANILLA_SLOT_COUNT = PLAYER_INVENTORY_SLOT_COUNT + HOTBAR_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;

    // TE
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = COLUMNS * ROWS;

    private Level level = null;
    private int source = 0;
    private Inventory playerInv;

    public GatherersJarBlockEntity _blockEntity = null;
    private ItemStack _stack = null;

    public GatherersJarMenu(int pContainerId, Inventory playerInv, FriendlyByteBuf extraData) {
        super(MenuRegistration.GATHERERS_JAR_MENU.get(), pContainerId);
        int source = extraData.readInt();
        if (source == GatherersJarBlock.BLOCK_ENTITY_MENU) {
            _blockEntity = (GatherersJarBlockEntity) playerInv.player.level().getBlockEntity(extraData.readBlockPos());
        } else if (source == GatherersJarBlock.IN_HAND_MENU) {
            _stack = playerInv.getItem(extraData.readInt());
        } else {
            throw new IllegalStateException("Source cannot be " + source);
        }
        init(source, playerInv);
    }

    public GatherersJarMenu(int pContainerId, Inventory playerInv, BlockEntity entity) {
        super(MenuRegistration.GATHERERS_JAR_MENU.get(), pContainerId);
        _blockEntity = ((GatherersJarBlockEntity) entity);
        init(GatherersJarBlock.BLOCK_ENTITY_MENU, playerInv);
    }

    public GatherersJarMenu(int pContainerId, Inventory playerInv, ItemStack stack) {
        super(MenuRegistration.GATHERERS_JAR_MENU.get(), pContainerId);
        _stack = stack;
        init(GatherersJarBlock.IN_HAND_MENU, playerInv);
    }

    protected void init(int source, Inventory pPlayerInv) {
        this.source = source;
        checkContainerSize(pPlayerInv, 2);
        playerInv = pPlayerInv;
        level = playerInv.player.level();

        /*
        int selectedSlot = playerInv.selected;
        ItemStack stack = playerInv.getItem(selectedSlot);
        var items = stack.getCapability(Capabilities.ItemHandler.ITEM);
        if (items != null) {
            handler = items;
        } else throw new IllegalStateException("No itemhandler");
        */

        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);
        addContainerInventory(getInventory());
    }

    // --

    protected ItemStackHandler _stackItems = null;

    @Override
    public IItemHandler getInventory() {
        if (source == GatherersJarBlock.BLOCK_ENTITY_MENU) {
            return _blockEntity.getInventory();
        } else {
            if (_stackItems == null) {
                var dataMap = _stack.getComponents();
                var container = dataMap.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
                NonNullList<ItemStack> stacks = NonNullList.createWithCapacity(4);
                for (int slot = 0; slot < 4; slot++) {
                    if (slot < container.getSlots()) {
                        stacks.add(container.getStackInSlot(slot));
                    } else {
                        stacks.add(ItemStack.EMPTY);
                    }
                }
                _stackItems = new ItemStackHandler(stacks) {
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

                    @Override
                    protected void onContentsChanged(int slot) {
                        // Should this be checked for only server? probs?
                        //_stack.getComponents()
                        //        .getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                        //        .copyInto(GatherersJarMenu.this.getInventoryAsList());

                    }
                };
            }
            return _stackItems;
        }
    }

    // --

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        //if (_stackItems != null) _stackItems.set();
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(pPlayer, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return source == GatherersJarBlock.IN_HAND_MENU || stillValid(ContainerLevelAccess.create(level, _blockEntity.getBlockPos()), pPlayer, BlockRegistration.GATHERERS_JAR.get());
    }

    //region Add Player Slots
    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 9; l++) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 68 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 126));
        }
    }

    //endregion
    //region Add Inventory Slots
    private void addContainerInventory(IItemHandler inventory) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.addSlot(new SlotItemHandler(inventory, i * COLUMNS + j, 71 + j * 18, 18 + i * 18) {
                    @Override
                    public void setChanged() {
                        if (!GatherersJarMenu.this.level.isClientSide) {
                            var map = DataComponentMap.builder().addAll(_stack.getComponents());
                            map.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(getInventoryAsList()));
                            _stack.applyComponents(map.build());
                        }
                    }
                });
            }
        }
    }

    @Override
    public Component getName() {
        return hasCustomName() ? getCustomName() : Component.translatable(GatherersJarBlock.LANG_DEFAULT_NAME);
    }

    @Override
    public @Nullable Component getCustomName() {
        if (source == GatherersJarBlock.IN_HAND_MENU) {
            return _stack.has(DataComponents.CUSTOM_NAME) ? Component.literal(_stack.getComponents().get(DataComponents.CUSTOM_NAME).getString()) : null;
        } else {
            return _blockEntity.getCustomName();
        }
    }
    //endregion
}
