package io.github.zephyrwolf.medievalism;

import io.github.zephyrwolf.medievalism.client.item.KnappingItemAnimationClientExtension;
import net.minecraft.client.model.HumanoidModel;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

public final class MedievalismEnumProxies
{ // https://docs.neoforged.net/docs/1.21.5/advanced/extensibleenums/
    // To prevent loading too early, these need to be in an isolated class from the rest of the project
    public static final EnumProxy<HumanoidModel.ArmPose> KNAPPING_ARM_POSE
            = new EnumProxy<>(
                    HumanoidModel.ArmPose.class,
                    true,
                    // 3rd Person
                    new KnappingItemAnimationClientExtension.KnappingArmPoseTransformer()
    );
}
