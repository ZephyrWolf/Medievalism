package io.github.zephyrwolf.medievalism.common.malleablematerial;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.registration.recipe.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class MalleableMaterialType
{
    public static final Codec<Holder<MalleableMaterialType>> CODEC = RegistryRegistration.MALLEABLE_MATERIALS_REGISTRY.holderByNameCodec()
            .validate(
                    holder -> Objects.requireNonNull(holder.getKey()).equals(MalleableMaterialRegistration.AIR.getKey())
                            ? DataResult.error(() -> "Malleable Material must not be " + MalleableMaterialRegistration.AIR.getId())
                            : DataResult.success(holder)
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<MalleableMaterialType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(MalleableMaterialRegistration.MATERIALS.getRegistryKey());

    // --

    protected int positiveColour = 0x00FFFFFF;
    protected int negativeColour = 0x00000000;

    public MalleableMaterialType() {}
    public MalleableMaterialType(int positive, int negative)
    {
        positiveColour = positive;
        negativeColour = negative;
    }

    public boolean requiresTool() { return false; }

    public boolean validTool(ItemStack stack) { return true; }

    public int getPositiveColour() { return positiveColour; }
    public int getNegativeColour() { return negativeColour; }

    public boolean canToggle() { return true; }
}
