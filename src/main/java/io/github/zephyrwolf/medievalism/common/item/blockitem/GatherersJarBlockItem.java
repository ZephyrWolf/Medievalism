package io.github.zephyrwolf.medievalism.common.item.blockitem;

import io.github.zephyrwolf.medievalism.common.block.GatherersJarBlock;
import io.github.zephyrwolf.medievalism.common.menu.GatherersJarMenu;
import io.github.zephyrwolf.medievalism.common.menu.ItemStackMenuProvider;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GatherersJarBlockItem extends ContainerItemBlockItem {
    public GatherersJarBlockItem(Supplier<? extends Block> pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            int slot = pPlayer.getInventory().selected;
            ItemStack stack = pPlayer.getItemInHand(pUsedHand);
            ItemStackMenuProvider menuProvider = new ItemStackMenuProvider(stack,
                    (containerId, playerInventory, player) -> new GatherersJarMenu(containerId, playerInventory, playerInventory.getSelected())
            );
            pPlayer.openMenu(menuProvider, buf -> {
                buf.writeInt(GatherersJarBlock.MenuTriggerSource.IN_HAND_MENU.ordinal());
                buf.writeInt(slot);
            });
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide);
    }
}
