package io.github.zephyrwolf.medievalism.client.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import cpw.mods.modlauncher.EnumerationHelper;
import io.github.zephyrwolf.medievalism.MedievalismEnumProxies;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RockBlockItemClientExtension implements IClientItemExtensions
{
    // 1st person
    @Override
    public boolean applyForgeHandTransform(
            @NotNull PoseStack poseStack,
            @NotNull LocalPlayer player,
            @NotNull HumanoidArm arm,
            @NotNull ItemStack itemInHand,
            float partialTick, // 0.0 to 1.0
            float equipProcess, // 0.0 to 1.0 // this corresponds to the sword guage bar
            float swingProcess) // 0.0 to 1.0 // exactly 0 means the animation is not playing
    {
        if (player.isUsingItem())
        {
            int i = arm == HumanoidArm.RIGHT ? 1 : -1;
            poseStack.translate(i * 0.56F, -0.52F, -0.72F);
            int duration = player.getTicksUsingItem();
            int totalTime = player.getUseItem().getUseDuration(player);
            float nTime = (float) duration / (float) totalTime;
            float frequency = 4.0f;

            if (player.getUseItem() == itemInHand)
            {
                poseStack.translate(-i * 0.23F + (float) Math.sin(Math.PI * 2 * nTime * frequency) * 0.3f, 0.0f, 0.0f);
                //poseStack.translate(0.0, -0.1, 0.0);
                //float deg = (float) Math.sin(Math.PI * 2 * nTime * frequency) * 5.0f;
                float deg = 0;
                poseStack.rotateAround(Axis.XP.rotation(
                        (float) Math.sin(Math.PI * 2 * nTime * frequency) * 0.2f),
                        -1.1f, -1.0f, -0.3f);
            }
            else
            {
                poseStack.translate(
                        -i * 0.61F - (float) Math.max(Math.sin(Math.PI * 2 * nTime * frequency + Math.PI / 2), 0) * 0.04f,
                        0.08f,
                        -0.1f);
            }
            return true;
        }
        return false; // prevents ItemStack from being handled by Vanilla rendering system
    }

    // 3rd person
    @Override
    public HumanoidModel.@Nullable ArmPose getArmPose(
            @NotNull LivingEntity entityLiving,
            @NotNull InteractionHand hand,
            ItemStack itemStack)
    {
        if (!itemStack.isEmpty())
        {
            if (entityLiving.getUsedItemHand() == hand && entityLiving.getUseItemRemainingTicks() > 0)
            {
                return MedievalismEnumProxies.KNAPPING_ARM_POSE.getValue();
            }
        }
        return HumanoidModel.ArmPose.EMPTY; // default is null
    }
}
