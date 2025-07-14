package io.github.zephyrwolf.medievalism.client.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.zephyrwolf.medievalism.MedievalismEnumProxies;
import io.github.zephyrwolf.medievalism.common.blockitem.RockBlockItem;
import io.github.zephyrwolf.medievalism.tools.MathTools;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.IArmPoseTransformer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KnappingItemAnimationClientExtension implements IClientItemExtensions
{
    private static final double SKEW = 0.28;

    // 1st person
    @Override
    public boolean applyForgeHandTransform(
            @NotNull PoseStack poseStack,
            @NotNull LocalPlayer player,
            @NotNull HumanoidArm arm,
            @NotNull ItemStack itemInHand,
            float partialTick, // [0,1)
            float equipProcess, // [0,1) // this corresponds to the sword gauge bar
            float swingProcess) // [0,1) // exactly 0 means the animation is not playing
    { // returning true prevents ItemStack from being handled by Vanilla rendering system
        if (!player.isUsingItem()) { return false; }

        int duration = player.getTicksUsingItem();
        int totalTime = player.getUseItem().getUseDuration(player);
        float nTime = (float) duration / (float) totalTime;

        RockBlockItem.KnapAction action = RockBlockItem.getKnapAction(player, player.getUsedItemHand());
        if (action == RockBlockItem.KnapAction.CAN_KNAP)
        { // Knap Animation
            int i = arm == HumanoidArm.RIGHT ? 1 : -1;
            poseStack.translate(i * 0.56F, -0.52F, -0.72F);

            if (player.getUseItem() == itemInHand)
            {
                float f = -(float) MathTools.asymmetricCos(Math.PI * 2.0f * nTime * RockBlockItem.HITS + Math.PI * 0.5f, SKEW);
                poseStack.translate(-i * 0.23F + f * 0.3f, 0.0f, 0.0f);
                poseStack.rotateAround(Axis.XP.rotation(
                                f * 0.2f),
                        -1.1f, -1.0f, -0.3f);
            }
            else
            {
                float f2 = (float) MathTools.asymmetricCos(Math.PI * 2.0f * nTime * RockBlockItem.HITS + Math.PI * 2.0f * SKEW * 0.0f, SKEW);
                poseStack.translate(
                        -i * 0.61F - Math.max(f2, 0) * 0.04f,
                        0.08f,
                        -0.1f);
            }
            return true;
        }
        else if (action == RockBlockItem.KnapAction.NO_ACTION)
        { // Fail Animation
            if (player.getUseItem() == itemInHand)
            {
                float f = -0.1F * Math.abs(Mth.sin(nTime * (float) Math.PI * 2f));
                poseStack.translate(f, -0.52F, -0.72F);
                return true;
            }
            return false;
        }
        else
        { // Prepare Animation
            if (player.getUseItem() == itemInHand)
            {
                int i = arm == HumanoidArm.RIGHT ? 1 : -1;
                InteractionHand hand = player.getUsedItemHand();
                boolean flag = hand == InteractionHand.MAIN_HAND;
                HumanoidArm humanoidarm = flag ? player.getMainArm() : player.getMainArm().getOpposite();
                float f = -0.4F * Mth.sin(Mth.sqrt(swingProcess) * (float) Math.PI);
                float f1 = 0.2F * Mth.sin(Mth.sqrt(swingProcess) * (float) (Math.PI * 2));
                float f2 = -0.2F * Mth.sin(swingProcess * (float) Math.PI);
                poseStack.translate((float)i * f, f1, f2);
                Minecraft.getInstance().gameRenderer.itemInHandRenderer.applyItemArmTransform(poseStack, humanoidarm, equipProcess);
                Minecraft.getInstance().gameRenderer.itemInHandRenderer.applyItemArmAttackTransform(poseStack, humanoidarm, swingProcess);
                return true;
            }
            return false;
        }
    }

    // 3rd person condition
    @Override
    public HumanoidModel.@Nullable ArmPose getArmPose(
            @NotNull LivingEntity entityLiving,
            @NotNull InteractionHand hand,
            @NotNull ItemStack itemStack)
    {
        if (entityLiving.getUseItemRemainingTicks() > 0)
        {
            RockBlockItem.KnapAction action = RockBlockItem.getKnapAction(entityLiving, hand);
            if (action == RockBlockItem.KnapAction.CAN_KNAP)
            {
                return MedievalismEnumProxies.KNAPPING_ARM_POSE.getValue();
            }
        }
        return HumanoidModel.ArmPose.EMPTY;
    }

    // 3rd person
    public static class KnappingArmPoseTransformer implements IArmPoseTransformer
    {
        @Override
        public void applyTransform(
                @NotNull HumanoidModel<?> model,
                @NotNull LivingEntity entity,
                @NotNull HumanoidArm arm)
        {
            int duration = entity.getTicksUsingItem();
            int totalTime = entity.getUseItem().getUseDuration(entity);
            float nTime = (float) duration / (float) totalTime;

            float handedness = arm == HumanoidArm.RIGHT ? 1 : -1;
            ModelPart mainArm = arm == HumanoidArm.RIGHT ? model.rightArm : model.leftArm;
            ModelPart oMainArm = arm == HumanoidArm.RIGHT ? model.leftArm : model.rightArm;

            mainArm.xRot = (float) (-Math.PI/2.0 - 0.15f - 0.4f * MathTools.asymmetricCos(Math.PI * 2 * nTime * RockBlockItem.HITS + Math.PI / 2.0f, SKEW));
            mainArm.yRot = handedness * -0.4f;

            oMainArm.xRot = (float) (-Math.PI/2.0 + 0.55f - (float) Math.max(MathTools.asymmetricCos(Math.PI * 2 * nTime * RockBlockItem.HITS + 4.0f * Math.PI / 2.0f, SKEW), 0) * 0.08f);
            oMainArm.yRot = handedness * 0.4f;
        }
    }
}
