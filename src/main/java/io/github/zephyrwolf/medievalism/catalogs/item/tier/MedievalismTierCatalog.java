package io.github.zephyrwolf.medievalism.catalogs.item.tier;

import com.google.common.base.Suppliers;
import io.github.zephyrwolf.medievalism.catalogs.tag.BlockTagCatalog;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public enum MedievalismTierCatalog implements Tier
{
    // Wood
    // Stone
    ROCK(() -> BlockTagCatalog.NEEDS_PRIMITIVE_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_PRIMITIVE_TOOL, 100, 2.0f, 1.0f, 5, () -> Ingredient.EMPTY),
    FLINT(() -> BlockTagCatalog.NEEDS_PRIMITIVE_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_PRIMITIVE_TOOL, 120, 2.2f, 1.2f, 7, () -> Ingredient.EMPTY),
    BONE(() -> BlockTagCatalog.NEEDS_PRIMITIVE_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_PRIMITIVE_TOOL, 90, 2.2f, 1.5f, 10, () -> Ingredient.EMPTY),
    COPPER(() -> BlockTagCatalog.NEEDS_COPPER_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_COPPER_TOOL, 200, 3.0f, 1.2f, 9, () -> Ingredient.of(Items.COPPER_INGOT)),
    BRONZE(() -> BlockTagCatalog.NEEDS_BRONZE_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_BRONZE_TOOL, 400, 2.0f, 1.7f, 12, () -> Ingredient.EMPTY), // TODO No repair item
    // Iron
    WROUGHT_IRON(() -> BlockTagCatalog.NEEDS_WROUGHT_IRON_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_WROUGHT_IRON_TOOL, 800, 6.0f, 2.5f, 14, () -> Ingredient.EMPTY), // TODO No repair item
    // Diamond
    STEEL(() -> BlockTagCatalog.NEEDS_STEEL_TOOL, () -> BlockTagCatalog.INCORRECT_FOR_STEEL_TOOL, 1600, 8.0f, 3.5f, 16, () -> Ingredient.EMPTY); // TODO No repair item
    // Netherite
    private final Supplier<TagKey<Block>> incorrectBlocksForDrops;
    final Supplier<TagKey<Block>> needsTierDrops;
    final int uses;
    final float speed;
    final float damage;
    final int enchantmentValue;
    final Supplier<Ingredient> repairIngredient;

    MedievalismTierCatalog(Supplier<TagKey<Block>> needsTierDrops, Supplier<TagKey<Block>> pIncorrectBlockForDrops, int pUses, float pSpeed, float pDamage,
                           int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient)
    {
        this.needsTierDrops = needsTierDrops;
        this.incorrectBlocksForDrops = pIncorrectBlockForDrops;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = Suppliers.memoize(pRepairIngredient::get);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops.get();
    }

    @Nullable
    public TagKey<Block> getTag() { return needsTierDrops.get(); } // net.neoforged.neoforge.common.CommonHooks.getTagFromVanillaTier(this)

    @Override
    public int getEnchantmentValue() { return this.enchantmentValue; }

    @Override
    public @NotNull Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
