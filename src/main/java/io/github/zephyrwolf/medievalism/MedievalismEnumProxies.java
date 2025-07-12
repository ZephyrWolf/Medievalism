package io.github.zephyrwolf.medievalism;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.IArmPoseTransformer;

public final class MedievalismEnumProxies
{ // https://docs.neoforged.net/docs/1.21.5/advanced/extensibleenums/
    // To prevent loading too early, these need to be in an isolated class from the rest of the project
    public static final EnumProxy<HumanoidModel.ArmPose> KNAPPING_ARM_POSE
            = new EnumProxy<>(
                    HumanoidModel.ArmPose.class,
                    true,
                    // 3rd Person
                    (IArmPoseTransformer) (model, entity, arm) ->
                    {
                        int duration = entity.getTicksUsingItem();
                        int totalTime = entity.getUseItem().getUseDuration(entity);
                        float nTime = (float) duration / (float) totalTime;
                        float frequency = 4.0f;

                        float handedness = arm == HumanoidArm.RIGHT ? 1 : -1;
                        ModelPart mainArm = arm == HumanoidArm.RIGHT ? model.rightArm : model.leftArm;
                        ModelPart oMainArm = arm == HumanoidArm.RIGHT ? model.leftArm : model.rightArm;

                        mainArm.xRot = (float) (-Math.PI/2.0 - 0.15f + 0.4f * Math.sin(Math.PI * 2 * nTime * frequency + Math.PI / 2.0f));
                        mainArm.yRot = handedness * -0.4f;

                        oMainArm.xRot = (float) (-Math.PI/2.0 + 0.55f + (float) Math.max(Math.sin(Math.PI * 2 * nTime * frequency + 4.0f * Math.PI / 2.0f), 0) * 0.08f);
                        oMainArm.yRot = handedness * 0.4f;
                    }
    );
}
