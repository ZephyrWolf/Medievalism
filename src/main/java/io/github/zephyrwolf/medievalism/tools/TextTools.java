package io.github.zephyrwolf.medievalism.tools;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.MedievalismMod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class TextTools
{
    public static MutableComponent getTranslation(String key, Object... args)
    {
        return Component.translatable(MedievalismConstants.MOD_ID + "." + key, args);
    }
}
