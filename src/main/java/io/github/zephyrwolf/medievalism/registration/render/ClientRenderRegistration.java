package io.github.zephyrwolf.medievalism.registration.render;

import net.neoforged.bus.api.IEventBus;

public final class ClientRenderRegistration
{
    public static void register(IEventBus bus)
    {
        //bus.addListener(ClientRenderRegistration::renderHand);
    }
/*
    private static void renderHand(RenderHandEvent event)
    {
        event.


        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) return;

        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();

        // Only do this for your custom item (can be main or offhand)
        if (!isYourItem(main) && !isYourItem(off)) return;

        if (!player.isUsingItem()) return;

        event.setCanceled(true); // Cancel default rendering

        // Setup transforms
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();

        float partialTicks = event.getPartialTicks();
        int useTicks = player.getUseItemRemainingTicks();
        float useProgress = 1.0f - (useTicks / 20f); // Adjust to your needs

        // Render both hands
        renderHand(player, InteractionHand.MAIN_HAND, poseStack, buffer, partialTicks, useProgress);
        renderHand(player, InteractionHand.OFF_HAND, poseStack, buffer, partialTicks, useProgress);

    }

    private static void renderHand(LocalPlayer player, InteractionHand hand, PoseStack poseStack, MultiBufferSource buffer, float partialTicks, float useProgress) {
        poseStack.pushPose();

        boolean isRight = hand == InteractionHand.MAIN_HAND == (player.getMainArm() == HumanoidArm.RIGHT);

        // Apply custom animation offset
        float offset = (float) Math.sin(useProgress * Math.PI * 2) * 0.15f;
        float x = isRight ? 0.6f : -0.6f;
        poseStack.translate(x + (isRight ? -offset : offset), -0.2f, -0.7f);
        poseStack.mulPose(Axis.XP.rotationDegrees(-20));

        Minecraft.getInstance().getItemInHandRenderer().renderPlayerArm(poseStack, buffer, 15728880, hand == InteractionHand.MAIN_HAND ? player : null);

        poseStack.popPose();
    }

 */
}
