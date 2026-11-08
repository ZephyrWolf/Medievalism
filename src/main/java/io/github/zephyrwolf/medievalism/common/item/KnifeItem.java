package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipeInput;
import io.github.zephyrwolf.medievalism.registration.block.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class KnifeItem extends SwordItem
{
    //region Constants
    private static final int TICKS_PER_SECOND = 20;
    private static final int SCRAPE_DURATION_TICKS = 50;
    private static final int SCRAPE_PREPARE_DURATION_TICKS = 8;
    private static final int SCRAPE_FAIL_DURATION_TICKS = 10;
    public static final int SCRAPES = 3;
    private static final float PERIOD = SCRAPE_DURATION_TICKS / (float) (SCRAPES * TICKS_PER_SECOND); // Sec
    private static final int TIMING_TUNE = (int) (PERIOD * TICKS_PER_SECOND / 2f);
    //endregion

    public KnifeItem(Tier pTier, Item.Properties pProperties)
    {
        super(pTier, pProperties.component(DataComponents.TOOL, createToolProperties()));
    }

    public static Tool createToolProperties()
    {
        return new Tool(List.of(
                Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F),
                Tool.Rule.overrideSpeed(BlockTagCatalog.KNIFE_EFFICIENT, 1.5F)
        ), 1.0F, 2);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility itemAbility)
    {
        return ItemAbilityCatalog.DEFAULT_KNIFE_ACTIONS.contains(itemAbility);
    }

    // TODO check Max Stack Size

    @Override
    public int getUseDuration(@NotNull ItemStack pStack, LivingEntity pEntity)
    {
        if (pEntity.getUsedItemHand() == InteractionHand.MAIN_HAND && pStack.getItem() == this)
        {
            return getKnifeAction(pEntity, InteractionHand.MAIN_HAND).duration;
        }
        return -1;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack)
    {
        return UseAnim.CUSTOM;
    }

    // -- == --

    private static boolean couldScrapeOrCarve(@NotNull ItemStack stack) { return stack.is(ItemTagCatalog.CARVING_TOOL); }

    private static boolean canScrapeOrCarve(@NotNull ItemStack stack) { return couldScrapeOrCarve(stack) && stack.getCount() == 1; }

    private static InhandRecipeInput getRecipeInput(ItemStack tool, ItemStack ingredient) { return new InhandRecipeInput(tool, ingredient);  }

    private static Optional<InhandRecipe> getRecipe(Level level, ItemStack tool, ItemStack ingredient)
    {
        return getRecipeHolder(level, tool, ingredient).map(RecipeHolder::value);
    }

    private static Optional<RecipeHolder<InhandRecipe>> getRecipeHolder(Level level, ItemStack tool, ItemStack ingredient)
    {
        var recipes = RecipeManager.createCheck(RecipeRegistration.INHAND_RECIPE_TYPE.get());
        return recipes.getRecipeFor(getRecipeInput(tool, ingredient), level);
    }

    private static boolean isScrapeableOrCarvable(Level level, ItemStack tool, ItemStack ingredient)
    {
        if (ingredient.isEmpty() || ingredient.isDamaged()) { return false; } // TODO is this line required?
        return getRecipe(level, tool, ingredient).isPresent();
    }

    /*
    Obtains the hand holding ItemStack.
    Some method pass an ItemStack before player.useItem is updated.
     */
    private static @Nullable InteractionHand handFromStack(@NotNull LivingEntity pEntity, @NotNull ItemStack pStack)
    {
        if (pEntity.getUsedItemHand() == InteractionHand.OFF_HAND && pStack == pEntity.getItemInHand(InteractionHand.OFF_HAND))
            return InteractionHand.OFF_HAND;
        else if (pEntity.getUsedItemHand() == InteractionHand.MAIN_HAND && pStack == pEntity.getItemInHand(InteractionHand.MAIN_HAND))
            return InteractionHand.MAIN_HAND;
        else
            return null;
    }

    public enum KnifeAction
    {
        NO_ACTION(SCRAPE_FAIL_DURATION_TICKS),
        CAN_SCRAPE_OR_CARVE(SCRAPE_DURATION_TICKS);

        public final int duration;

        KnifeAction(int useDuration) { duration = useDuration; }
    }

    public static KnifeItem.KnifeAction getKnifeAction(@NotNull LivingEntity pEntity, @NotNull InteractionHand hand)
    {
        ItemStack mItemStack = pEntity.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack oItemStack = pEntity.getItemInHand(InteractionHand.OFF_HAND);

        if (hand == InteractionHand.MAIN_HAND && canScrapeOrCarve(mItemStack) && isScrapeableOrCarvable(pEntity.level(), mItemStack, oItemStack))
        {
            return KnifeItem.KnifeAction.CAN_SCRAPE_OR_CARVE;
        }
        return KnifeItem.KnifeAction.NO_ACTION;
    }
}
