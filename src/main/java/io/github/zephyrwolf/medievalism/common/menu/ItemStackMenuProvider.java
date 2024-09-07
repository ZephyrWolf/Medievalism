package io.github.zephyrwolf.medievalism.common.menu;

import com.mojang.datafixers.util.Function3;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ItemStackMenuProvider implements MenuProvider, Nameable {
    protected ItemStack stack;
    @Nullable
    protected Function3<Integer, Inventory, Player, AbstractContainerMenu> menuFactory;

    public ItemStackMenuProvider(@NotNull ItemStack stack) {
        this(stack, null);
    }

    public ItemStackMenuProvider(@NotNull ItemStack stack, @Nullable Function3<Integer, Inventory, Player, AbstractContainerMenu> menuFactory) {
        this.stack = stack;
        this.menuFactory = menuFactory;
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public Component getName() {
        //stack.getHoverName
        return stack.has(DataComponents.ITEM_NAME) ? stack.get(DataComponents.ITEM_NAME) : stack.getItem().getName(stack);
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public @Nullable Component getCustomName() {
        return stack.has(DataComponents.CUSTOM_NAME) ? Component.literal(stack.get(DataComponents.CUSTOM_NAME).getString()) : null;
    }

    @Override
    public Component getDisplayName() {
        Component customName = getCustomName();
        return customName != null ? customName : getName();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        if (menuFactory == null) throw new IllegalStateException("Cannot create menu from null creator function.");
        return menuFactory.apply(pContainerId, pPlayerInventory, pPlayer);
    }

    // getItemStack?
}
