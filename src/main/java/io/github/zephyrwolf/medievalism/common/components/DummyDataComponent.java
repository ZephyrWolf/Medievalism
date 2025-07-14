package io.github.zephyrwolf.medievalism.common.components;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;

public record DummyDataComponent()
{
    public static final DummyDataComponent INSTANCE = new DummyDataComponent();
    public static final Codec<DummyDataComponent> CODEC = Codec.unit(INSTANCE);
    public static final StreamCodec<ByteBuf, DummyDataComponent> STREAM_CODEC = StreamCodec.unit(INSTANCE);
}
