package io.github.zephyrwolf.medievalism.common.item;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

public final class ItemAbilityCODEC
{
    public static final StreamCodec<RegistryFriendlyByteBuf, ItemAbility> STREAM_CODEC = new StreamCodec<>()
    {
        public @NotNull ItemAbility decode(@NotNull RegistryFriendlyByteBuf buf)
        {
            String name = ByteBufCodecs.STRING_UTF8.decode(buf);
            return ItemAbility.get(name);
        }

        public void encode(@NotNull RegistryFriendlyByteBuf buf, ItemAbility ability)
        {
            ByteBufCodecs.STRING_UTF8.encode(buf, ability.name());
        }
    };
}
