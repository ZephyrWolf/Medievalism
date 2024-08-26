package io.github.zephyrwolf.medievalism.common.blockentity;

import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import io.github.zephyrwolf.medievalism.common.menu.StoneBenchMenu;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableMaterialRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.MalleableMaterialRecipeInput;
import io.github.zephyrwolf.medievalism.content.BlockEntityRegistration;
import io.github.zephyrwolf.medievalism.content.RecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
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
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneBenchBlockEntity extends BlockEntity implements MenuProvider {
    public static final int TOOL_SLOT = 0;
    public static final int INPUT_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    public static final int INVENTORY_SIZE = 3;
    private final ItemStackHandler items = new ItemStackHandler(INVENTORY_SIZE) {
        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (slot == RESULT_SLOT) return stack; // Cannot insert into these slots.
            return super.insertItem(slot, stack, simulate);
        }

        @Override
        public int getSlotLimit(int slot)
        {
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

    private static final int SHAPE = 0;
    public static final int DATA_COUNT = 4;
    private int positiveColour = 0xFFFFFF; // White
    private int negativeColour = 0x000000; // Black
    protected final ContainerData data;

    public static final String INVENTORY_TAG = "inventory";
    public static final String SHAPE_TAG = "shape";
    public static final String DISPLAY_NAME_LANG_KEY = "block.medievalism.stone_bench";

    protected @Nullable MalleableMaterial material = null;

    public StoneBenchBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistration.STONE_BENCH_BLOCK_ENTITY_TYPE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    //case SHAPE -> StoneBenchBlockEntity.this.curShape;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    //case INITIAL_SHAPE -> StoneBenchBlockEntity.this.initialShape = pValue;
                    //case CUR_SHAPE -> StoneBenchBlockEntity.this.curShape = pValue;
                    //case POSITIVE_COLOUR -> StoneBenchBlockEntity.this.positiveColour = pValue;
                    //case NEGATIVE_COLOUR -> StoneBenchBlockEntity.this.negativeColour = pValue;
                }
            }

            @Override
            public int getCount() {
                return 0; // DATA_COUNT;
            }
        };
    }

    public Optional<MalleableMaterial> getMaterial() {
        if (material != null) {
            return Optional.of(material);
        } else {
            return getMalleableMaterialForStack(items.getStackInSlot(INPUT_SLOT));
        }
    }

    // Called only on the server
    public void cellClicked(int index) {
        boolean ghost = material == null;
        Optional<MalleableMaterial> opMaterial = getMaterial();

        if (opMaterial.isPresent() && index < opMaterial.get().pattern().size()) {

            boolean val = opMaterial.get().pattern().get(index);
            if (!val) return;
            //if (!val && !opMaterial.get().material().canToggle()) return; // Play issues with clay
            if (opMaterial.get().material().requiresTool()) {
                ItemStack tool = items.getStackInSlot(TOOL_SLOT);
                if (!opMaterial.get().material().validTool(tool)) return;
                if (tool.isDamageableItem()) {
                    int amt = tool.getItem().damageItem(tool, 1, null, item -> {
                    });
                    if (amt > 0) {
                        amt = EnchantmentHelper.processDurabilityChange((ServerLevel) level, tool, amt);
                        if (amt <= 0) {
                            return;
                        }
                    }
                    int i = tool.getDamageValue() + amt;
                    tool.setDamageValue(i);
                    if (i >= tool.getMaxDamage()) {
                        Item item = tool.getItem();
                        tool.shrink(1);
                    }
                } else {
                    tool.shrink(1);
                }
            }
            if (ghost) { // Will move a single item from input slot to material slot
                ItemStack materialStack = items.extractItem(INPUT_SLOT, 1, false);
                setMaterial(getMalleableMaterialForStack(materialStack).orElse(null));
            }
            assert material != null; // At this point, material should never be null
            material.pattern().set(index, !val);
            if (material.pattern().stream().filter(v -> v).findAny().isEmpty()) {
                material = null;
            }
            setChanged();
            assert level != null;
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public void setMaterial(@Nullable MalleableMaterial material) {
        this.material = material;
        setChanged();
    }

    public Optional<MalleableMaterial> getMalleableMaterialForStack(ItemStack stack) {
        var recipes = RecipeManager.createCheck(RecipeRegistration.MALLEABLE_MATERIAL_RECIPE_TYPE.get());
        MalleableMaterialRecipeInput input = new MalleableMaterialRecipeInput(stack);
        assert level != null;
        Optional<RecipeHolder<MalleableMaterialRecipe>> optional = recipes.getRecipeFor(input, level);
        return optional
                .map(RecipeHolder::value)
                .map(e -> {
                    return e.assembleMaterial(input, level.registryAccess());
                });
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

    public ItemStackHandler getInventory() {
        return items;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME_LANG_KEY);
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new StoneBenchMenu(pContainerId, pPlayerInventory, this, this.data);
        return null;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.put(INVENTORY_TAG, items.serializeNBT(pRegistries));
        if (material != null) {
            pTag.put(SHAPE_TAG, MalleableMaterial.serializeNBT(material, pRegistries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        items.deserializeNBT(pRegistries, pTag.getCompound(INVENTORY_TAG));
        if (pTag.contains(SHAPE_TAG)) {
            material = MalleableMaterial.deserializeNBT(pTag.getCompound(SHAPE_TAG));
        } else {
            material = null;
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag pTag = super.getUpdateTag(pRegistries);
        saveAdditional(pTag, pRegistries);
        return pTag;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider lookupProvider) {
        /*
        CompoundTag pTag = pkt.getTag();
        if (pTag.contains(SHAPE_TAG))
        {
            CompoundTag tag = pTag.getCompound(SHAPE_TAG);
            material = MalleableMaterial.deserializeNBT(tag);
        } else {
            material = null;
        }
        */
        super.onDataPacket(net, pkt, lookupProvider);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
