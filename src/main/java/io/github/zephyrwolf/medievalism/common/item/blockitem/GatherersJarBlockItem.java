package io.github.zephyrwolf.medievalism.common.item.blockitem;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.menu.GatherersJarMenu;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GatherersJarBlockItem extends ContainerItemBlockItem implements MenuProvider {
    public GatherersJarBlockItem(Supplier<? extends Block> pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide)
        {
            int slot = pPlayer.getInventory().selected;
            pPlayer.openMenu(this, buf -> { buf.writeInt(GatherersJarBlock.IN_HAND_MENU); buf.writeInt(slot); });
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide);
    }

    //region Name
    public Component getDefaultName() {
        return Component.translatable(GatherersJarBlock.LANG_DEFAULT_NAME);
    }

    public @Nullable Component getCustomName() {
        return null; // How can I when you don't give me the itemstack CRY
    }

    @Override
    public Component getDisplayName() {
        Component customName = getCustomName();
        return customName != null ? customName : this.getDefaultName();
    }

    //endregion

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new GatherersJarMenu(pContainerId, pPlayerInventory, pPlayerInventory.getSelected());
    }
}
