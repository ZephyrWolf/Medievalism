package io.github.zephyrwolf.medievalism.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class HammerstoneItem extends Item
{
    public HammerstoneItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public boolean hasCraftingRemainingItem(@NotNull ItemStack stack) { return true; }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(ItemStack itemStack)
    {
        ItemStack retStack = itemStack.copy();
        retStack.setDamageValue(itemStack.getDamageValue() + 1);
        if (retStack.getDamageValue() == retStack.getMaxDamage()) return ItemStack.EMPTY;
        else return retStack;
    }

    //@Override
    //public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
    //    return super.damageItem(stack, amount, entity, onBroken);
    //}
}
