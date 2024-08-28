package io.github.zephyrwolf.medievalism.common.menu;

import io.github.zephyrwolf.medievalism.common.blockentity.StoneBenchBlockEntity;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableRecipeInput;
import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.menu.MenuRegistration;
import io.github.zephyrwolf.medievalism.content.recipe.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;
import java.util.Optional;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneBenchMenu extends AbstractContainerMenu
{
    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)

    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int VANILLA_SLOT_COUNT = PLAYER_INVENTORY_SLOT_COUNT + HOTBAR_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;

    // TE
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 3;

    public final StoneBenchBlockEntity blockEntity;
    private final Level level;

    public StoneBenchMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData)
    {
        this(pContainerId, inv, Objects.requireNonNull(inv.player.level().getBlockEntity(extraData.readBlockPos())));
    }

    public StoneBenchMenu(int pContainerId, Inventory playerInv, BlockEntity entity)
    {
        super(MenuRegistration.STONE_BENCH_MENU.get(), pContainerId);
        checkContainerSize(playerInv, 2);
        blockEntity = ((StoneBenchBlockEntity) entity);
        this.level = playerInv.player.level();

        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);

        var blockEntityInv = blockEntity.getInventory();
        this.addSlot(new SlotItemHandler(blockEntityInv, StoneBenchBlockEntity.TOOL_SLOT, 20, 18));
        this.addSlot(new SlotItemHandler(blockEntityInv, StoneBenchBlockEntity.INPUT_SLOT, 140, 18) {
            @Override
            public void setChanged() {
                StoneBenchMenu.this.slotsChanged(container);
            }
        });
        this.addSlot(new SlotItemHandler(blockEntityInv, StoneBenchBlockEntity.RESULT_SLOT, 140, 86));
    }

    @Override
    public void slotsChanged(Container pContainer)
    {
        updateResult();
        super.slotsChanged(pContainer);
    }

    public void updateResult()
    {
        Optional<MalleableMaterial> opMaterial = blockEntity.getMaterial();
        if (opMaterial.isEmpty())
        {
            blockEntity.getInventory().setStackInSlot(StoneBenchBlockEntity.RESULT_SLOT, ItemStack.EMPTY);
            return;
        }
        var recipes = RecipeManager.createCheck(RecipeRegistration.MALLEABLE_RECIPE_TYPE.get());
        MalleableRecipeInput input = new MalleableRecipeInput(opMaterial.get().trim());
        assert level != null;
        Optional<RecipeHolder<MalleableRecipe>> opRecipe = recipes.getRecipeFor(input, level);
        Optional<ItemStack> opResult = opRecipe
                .map(RecipeHolder::value)
                .map(e -> e.assemble(input, level.registryAccess()));
        blockEntity.getInventory().setStackInSlot(StoneBenchBlockEntity.RESULT_SLOT, opResult.orElse(ItemStack.EMPTY));
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex)
    {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT)
        {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false))
            {
                return ItemStack.EMPTY;
            }
        }
        else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT)
        {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false))
            {
                return ItemStack.EMPTY;
            }
        }
        else
        {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0)
        {
            sourceSlot.set(ItemStack.EMPTY);
        } else
        {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(pPlayer, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer)
    {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, BlockRegistration.STONE_BENCH.get());
    }

    //region Add Player Slots
    private void addPlayerInventory(Inventory playerInventory)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int l = 0; l < 9; l++)
            {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 118 + i * 18)); // 84
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory)
    {
        for (int i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 176)); // 142
        }
    }
    //endregion
}
