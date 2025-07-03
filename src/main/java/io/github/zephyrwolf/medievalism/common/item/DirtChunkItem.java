package io.github.zephyrwolf.medievalism.common.item;


import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class DirtChunkItem extends Item
{
    public DirtChunkItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand)
    {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);
        if (blockhitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        }
        else
        {
            if (blockhitresult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockpos = blockhitresult.getBlockPos();
                if (!pLevel.mayInteract(pPlayer, blockpos)) {
                    return InteractionResultHolder.pass(itemstack);
                }

                if (pLevel.getFluidState(blockpos).is(FluidTags.WATER)) {
                    pLevel.playSound(
                            pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.GENERIC_SPLASH, SoundSource.NEUTRAL, 1.0F, 1.0F
                    );
                    //pLevel.gameEvent(pPlayer, GameEvent.FLUID_PICKUP, blockpos);
                    return InteractionResultHolder.sidedSuccess(
                            turnDirtChunkIntoMudBall(itemstack, pPlayer, new ItemStack(ItemRegistration.MUD_BALL.get())),
                            pLevel.isClientSide()
                    );
                }
            }
            return InteractionResultHolder.pass(itemstack);
        }
    }

    protected ItemStack turnDirtChunkIntoMudBall(ItemStack dirtChunkStack, Player pPlayer, ItemStack mudBallStack)
    {
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        boolean flag = pPlayer.hasInfiniteMaterials();
        if (flag)
        {
            if (!pPlayer.getInventory().contains(mudBallStack)) { pPlayer.getInventory().add(mudBallStack); }
            return dirtChunkStack;
        }
        else
        {
            dirtChunkStack.consume(1, pPlayer);
            if (dirtChunkStack.isEmpty()) { return mudBallStack; }
            else
            {
                if (!pPlayer.getInventory().add(mudBallStack)) { pPlayer.drop(mudBallStack, false); }
                return dirtChunkStack;
            }
        }
    }
}
