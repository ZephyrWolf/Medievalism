package io.github.zephyrwolf.medievalism.common.malleablematerial;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.content.RegistryRegistration;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class MalleableMaterialType
{
    public static final Codec<Holder<MalleableMaterialType>> CODEC = // MapCodec.unit(MalleableMaterialType::create);
            RegistryRegistration.MATERIALS_REGISTRY
                    .holderByNameCodec()
                    .validate(
                            holder -> Objects.requireNonNull(holder.getKey()).location().equals(MedievalismConstants.resource("air"))
                            ? DataResult.error(() -> "Material must not be medieval:air")
                            : DataResult.success(holder)
                    );
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<MalleableMaterialType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(MalleableMaterialRegistration.MATERIALS.getRegistryKey());

    public Holder.Reference<MalleableMaterialType> builtInRegistryHolder()
    {
        var key = RegistryRegistration.MATERIALS_REGISTRY.getId(this);
        var holder = RegistryRegistration.MATERIALS_REGISTRY.getHolder(key);
        if (holder.isEmpty())
        {
            throw new IllegalStateException("Cannot locate holder for " + key);
        }
        return holder.get();
    }

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
