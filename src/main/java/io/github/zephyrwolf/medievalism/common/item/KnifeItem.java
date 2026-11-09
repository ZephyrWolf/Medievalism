package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.catalogs.item.itemability.ItemAbilityCatalog;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.IInhandRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipeInput;
import io.github.zephyrwolf.medievalism.catalogs.tag.BlockTagCatalog;
import io.github.zephyrwolf.medievalism.catalogs.tag.ItemTagCatalog;
import io.github.zephyrwolf.medievalism.registration.particles.ParticleTypeRegistration;
import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import io.github.zephyrwolf.medievalism.registration.sounds.SoundsRegistration;
import io.github.zephyrwolf.medievalism.tools.ParticleTools;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class KnifeItem extends SwordItem
{
    //region Constants
    private static final int TICKS_PER_SECOND = 20;
    private static final int CARVE_DURATION_TICKS = 50;
    private static final int CARVE_PREPARE_DURATION_TICKS = 8;
    private static final int CARVE_FAIL_DURATION_TICKS = 10;
    public static final int CARVES = 3;
    private static final float PERIOD = CARVE_DURATION_TICKS / (float) (CARVES * TICKS_PER_SECOND); // Sec
    private static final int TIMING_TUNE = (int) (PERIOD * TICKS_PER_SECOND / 2f);
    //endregion

    public KnifeItem(Tier pTier, Properties pProperties)
    {
        super(pTier, pProperties.component(DataComponents.TOOL, createToolProperties()));
    }

    public static Tool createToolProperties()
    {
        return new Tool(List.of(
                Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F),
                Tool.Rule.overrideSpeed(BlockTagCatalog.KNIFE_EFFICIENT, 1.5F) // TODO This isn't working
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

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(
            @NotNull Level pLevel,
            Player pPlayer,
            @NotNull InteractionHand pHand)
    {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        // if (pHand == InteractionHand.OFF_HAND) return InteractionResultHolder.pass(itemStack);

        KnifeAction action = getKnifeAction(pPlayer, pHand);
        if (action == KnifeAction.NO_ACTION && pLevel.isClientSide())
        {
            pLevel.playSound( // Play error sound; client only
                    pPlayer,
                    pPlayer.getOnPos(),
                    SoundsRegistration.INHAND_FAIL.value(),
                    SoundSource.PLAYERS,
                    1.5f,
                    1.0f);
        }
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void onUseTick(
            @NotNull Level pLevel,
            @NotNull LivingEntity pLivingEntity,
            @NotNull ItemStack pStack,
            int pRemainingUseDuration)
    {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
        KnifeAction action = getKnifeAction(pLivingEntity, pLivingEntity.getUsedItemHand());
        if (action != KnifeAction.CAN_INHAND_CRAFT) return;
        if (pRemainingUseDuration % (CARVE_DURATION_TICKS / CARVES) == TIMING_TUNE)
        {
            RandomSource rand = pLevel.getRandom();
            boolean finalHit = pRemainingUseDuration == TIMING_TUNE;
            Optional<IInhandRecipe> recipe = getRecipe(pLevel, pLivingEntity.getMainHandItem(), pLivingEntity.getOffhandItem());
            SoundEvent sndEvent = recipe.map(iInhandRecipe -> SoundsRegistration.getInhandSoundEvent(iInhandRecipe.getMaterialType(), finalHit)).orElseGet(SoundsRegistration.INHAND_FAIL::value);
            int numParticles = finalHit ? (3 + rand.nextInt(4)) : (1 + rand.nextInt(2));
            pLevel.playSound( // Play hit sound
                    pLivingEntity,
                    pLivingEntity.getOnPos(),
                    sndEvent,
                    SoundSource.PLAYERS,
                    0.9f + 0.2f * rand.nextFloat(),
                    0.9f + 0.2f * rand.nextFloat());
            for (int n = 0; n < numParticles; n++) {
                if (FMLEnvironment.dist == Dist.CLIENT // Spawn particle for client
                        && pLevel.isClientSide()
                        && pLivingEntity instanceof Player player
                        && player == Minecraft.getInstance().player) {
                    ClientLevel clientLevel = (ClientLevel) pLevel;
                    float rot = Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON
                            ? pLivingEntity.yHeadRot
                            : pLivingEntity.yBodyRot;
                    float yaw = rot * ((float) Math.PI / 180f);
                    Supplier<SimpleParticleType> particle = recipe.isPresent() ? ParticleTypeRegistration.getInhandParticle(recipe.get().getMaterialType()) : ParticleTypeRegistration.SCRAPE_PLANT;
                    ParticleTools.addParticleClient(
                            clientLevel,
                            player,
                            particle.get(),
                            pLivingEntity.getX() - Mth.sin(yaw) * 0.6f,
                            pLivingEntity.getY() + 1.3,
                            pLivingEntity.getZ() + Mth.cos(yaw) * 0.6F,
                            rand.nextDouble() - 0.4 - Mth.sin(yaw) * 0.1f,
                            rand.nextDouble(),
                            rand.nextDouble() - 0.4 + Mth.cos(yaw) * 0.1F
                    );
                } else if (FMLEnvironment.dist == Dist.DEDICATED_SERVER // Spawn particle for server
                        && !pLevel.isClientSide()
                        && pLivingEntity instanceof Player player) {
                    ServerLevel serverLevel = (ServerLevel) pLevel;
                    float yaw = pLivingEntity.yBodyRot * ((float) Math.PI / 180F);
                    Supplier<SimpleParticleType> particle = recipe.isPresent() ? ParticleTypeRegistration.getInhandParticle(recipe.get().getMaterialType()) : ParticleTypeRegistration.SCRAPE_PLANT;
                    ParticleTools.sendParticlesServer(
                            serverLevel,
                            player,
                            particle.get(),
                            pLivingEntity.getX() - Mth.sin(yaw) * 0.6f,
                            pLivingEntity.getY() + 1.3,
                            pLivingEntity.getZ() + Mth.cos(yaw) * 0.6F,
                            0,
                            rand.nextDouble() - 0.4 - Mth.sin(yaw) * 0.1f,
                            rand.nextDouble(),
                            rand.nextDouble() - 0.4 + Mth.cos(yaw) * 0.1F,
                            0.0
                    );
                }
            }
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(
            @NotNull ItemStack pStack,
            @NotNull Level pLevel,
            @NotNull LivingEntity pLivingEntity)
    {
        InteractionHand hand = pLivingEntity.getUsedItemHand();
        InteractionHand oHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack mItemStack = pLivingEntity.getItemInHand(hand);
        ItemStack oItemStack = pLivingEntity.getItemInHand(oHand);

        KnifeItem.KnifeAction action = getKnifeAction(pLivingEntity, hand);
        if (action == KnifeAction.CAN_INHAND_CRAFT)
        {
            // Serverside
            if (!pLevel.isClientSide() && pLivingEntity instanceof Player player)
            {
                // We check so that if we are using an item, and we shouldn't, we aren't acting on items that we shouldn't
                // e.g. What if another mod modifies the players inventory?
                if (canToolCarve(mItemStack) && isCarvableRecipe(pLevel, mItemStack, oItemStack))
                {
                    InhandRecipeInput input = getRecipeInput(mItemStack, oItemStack);
                    getRecipeHolder(pLevel, mItemStack, oItemStack).ifPresent(recipe
                            -> {
                        ItemStack result = recipe.value().assemble(input, pLevel.registryAccess());
                        player.triggerRecipeCrafted(recipe, List.of(
                                result
                        ));
                        if (!player.addItem(result))
                        {
                            player.drop(result, true);
                        }
                    });

                    if (!player.isCreative()) {
                        pStack.setDamageValue(pStack.getDamageValue() + 1);
                        if (pStack.getDamageValue() >= pStack.getMaxDamage())
                        {
                            pStack = ItemStack.EMPTY;
                        }
                        oItemStack.shrink(1);
                    }
                }
            }
        }

        if (!pLevel.isClientSide && pLivingEntity instanceof Player player)
        {
            player.getCooldowns().addCooldown(this, 5);
        }

        return pStack;
    }

    private static boolean couldCarve(@NotNull ItemStack stack) { return stack.is(ItemTagCatalog.CARVING_TOOL); }
    private static boolean canToolCarve(@NotNull ItemStack stack) { return couldCarve(stack) && stack.getCount() == 1; }

    private static InhandRecipeInput getRecipeInput(ItemStack tool, ItemStack ingredient) { return new InhandRecipeInput(tool, ingredient);  }

    private static Optional<IInhandRecipe> getRecipe(Level level, ItemStack tool, ItemStack ingredient)
    {
        return getRecipeHolder(level, tool, ingredient).map(RecipeHolder::value);
    }

    private static Optional<RecipeHolder<IInhandRecipe>> getRecipeHolder(Level level, ItemStack tool, ItemStack ingredient)
    {
        var recipes = RecipeManager.createCheck(RecipeRegistration.INHAND_RECIPE_TYPE.get());
        return recipes.getRecipeFor(getRecipeInput(tool, ingredient), level);
    }

    private static boolean isCarvableRecipe(Level level, ItemStack tool, ItemStack ingredient)
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
        NO_ACTION(CARVE_FAIL_DURATION_TICKS),
        CAN_INHAND_CRAFT(CARVE_DURATION_TICKS);

        public final int duration;

        KnifeAction(int useDuration) { duration = useDuration; }
    }

    public static KnifeAction getKnifeAction(@NotNull LivingEntity pEntity, @NotNull InteractionHand hand)
    {
        ItemStack toolStack = pEntity.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack ingredientStack = pEntity.getItemInHand(InteractionHand.OFF_HAND);

        if (hand == InteractionHand.MAIN_HAND)
        {
            if (canToolCarve(toolStack))
            {
                if (isCarvableRecipe(pEntity.level(), toolStack, ingredientStack))
                {
                    return KnifeAction.CAN_INHAND_CRAFT;
                }
            }
        }
        return KnifeAction.NO_ACTION;
    }
}
