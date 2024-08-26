package io.github.zephyrwolf.medievalism.common.blockentity;

import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import io.github.zephyrwolf.medievalism.common.menu.StoneBenchMenu;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableMaterialRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableMaterialRecipeInput;
import io.github.zephyrwolf.medievalism.content.BlockEntityRegistration;
import io.github.zephyrwolf.medievalism.content.RecipeRegistration;
import io.github.zephyrwolf.medievalism.tools.ItemTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneBenchBlockEntity extends BlockEntity implements MenuProvider {
    public static final String INVENTORY_TAG = "inventory";
    public static final String SHAPE_TAG = "shape";
    public static final String DISPLAY_NAME_LANG_KEY = "block.medievalism.stone_bench";

    public static final int TOOL_SLOT = 0;
    public static final int INPUT_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    public static final int INVENTORY_SIZE = 3;

    protected @Nullable MalleableMaterial storedMaterial = null;

    private final ItemStackHandler items = new ItemStackHandler(INVENTORY_SIZE) {
        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (slot == RESULT_SLOT) return stack; // Cannot insert into these slots.
            return super.insertItem(slot, stack, simulate);
        }

        @Override
        public int getSlotLimit(int slot) {
            if (slot == TOOL_SLOT) return 1;
            return super.getSlotLimit(slot);
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            return super.extractItem(slot, amount, simulate);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if (slot == INPUT_SLOT) {
                if (level == null) return false;
                var recipes = RecipeManager.createCheck(RecipeRegistration.MALLEABLE_MATERIAL_RECIPE_TYPE.get());
                MalleableMaterialRecipeInput input = new MalleableMaterialRecipeInput(stack);
                Optional<RecipeHolder<MalleableMaterialRecipe>> optional = recipes.getRecipeFor(input, level);
                Optional<MalleableMaterial> material = optional
                        .map(RecipeHolder::value)
                        .map(e -> e.assembleMaterial(input, level.registryAccess()));
                return material.isPresent();
            } else if (slot == RESULT_SLOT) return false;
            return super.isItemValid(slot, stack);
        }

        @Override
        protected void onContentsChanged(int slot) {
            StoneBenchBlockEntity.this.setChanged();
        }
    };

    //region Boilerplate
    public StoneBenchBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistration.STONE_BENCH_BLOCK_ENTITY_TYPE.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME_LANG_KEY);
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new StoneBenchMenu(pContainerId, pPlayerInventory, this);
    }
    //endregion

    //region Material
    public Optional<MalleableMaterial> getMaterial() {
        if (storedMaterial != null) {
            return Optional.of(storedMaterial);
        } else {
            return getMalleableMaterialForStack(items.getStackInSlot(INPUT_SLOT));
        }
    }

    public void setStoredMaterial(@Nullable MalleableMaterial storedMaterial) {
        this.storedMaterial = storedMaterial;
        setChanged();
    }

    public Optional<MalleableMaterial> getMalleableMaterialForStack(ItemStack stack) {
        var recipes = RecipeManager.createCheck(RecipeRegistration.MALLEABLE_MATERIAL_RECIPE_TYPE.get());
        MalleableMaterialRecipeInput input = new MalleableMaterialRecipeInput(stack);
        assert level != null;
        Optional<RecipeHolder<MalleableMaterialRecipe>> optional = recipes.getRecipeFor(input, level);
        return optional
                .map(RecipeHolder::value)
                .map(e -> e.assembleMaterial(input, level.registryAccess()));
    }
    //endregion

    //region Inventory
    public ItemStackHandler getInventory() {
        return items;
    }

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

    //region Serialization
    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.put(INVENTORY_TAG, items.serializeNBT(pRegistries));
        if (storedMaterial != null) {
            pTag.put(SHAPE_TAG, MalleableMaterial.serializeNBT(storedMaterial, pRegistries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        items.deserializeNBT(pRegistries, pTag.getCompound(INVENTORY_TAG));
        if (pTag.contains(SHAPE_TAG)) {
            storedMaterial = MalleableMaterial.deserializeNBT(pTag.getCompound(SHAPE_TAG));
        } else {
            storedMaterial = null;
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

    //region Logic
    // Called only on the server
    public void cellClicked(int index) {
        boolean ghost = storedMaterial == null;
        Optional<MalleableMaterial> opMaterial = getMaterial();
        if (opMaterial.isEmpty()) return;
        MalleableMaterial material = opMaterial.get();
        if (index >= material.pattern().size()) return;

        boolean cellActive = material.pattern().get(index);
        if (!cellActive && !opMaterial.get().materialType().canToggle()) return; // Gameplay issues with clay
        if (!processTool(material)) return;
        if (ghost) { // Will move a single item from input slot to materialType slot
            consumeMaterial();
        }
        assert storedMaterial != null; // At this point, materialType should never be null
        storedMaterial.pattern().set(index, !cellActive);
        if (storedMaterial.is(false)) {
            storedMaterial = null;
        }
        setChangedAndSendUpdates();
    }

    private void setChangedAndSendUpdates() {
        setChanged();
        assert level != null;
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
    }

    private void consumeMaterial() {
        ItemStack materialStack = items.extractItem(INPUT_SLOT, 1, false);
        setStoredMaterial(getMalleableMaterialForStack(materialStack).orElse(null));
    }

    private boolean processTool(MalleableMaterial material)
    {
        if (material.materialType().requiresTool()) {
            ItemStack tool = items.getStackInSlot(TOOL_SLOT);
            if (!material.materialType().validTool(tool)) return false; // Not Valid
            return ItemTools.damageOrShrinkStack((ServerLevel)level, tool, 1) != 0; // Did Damage
        }
        return true; // No tool so always true
    }
    //endregion
}
