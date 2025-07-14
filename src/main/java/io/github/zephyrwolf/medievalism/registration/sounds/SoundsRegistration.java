package io.github.zephyrwolf.medievalism.registration.sounds;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundsRegistration
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, MedievalismConstants.MOD_ID);

    public static final Holder<SoundEvent> INAHND_KNAP_HIT = SOUND_EVENT.register("entity.inhand_knap.hit", SoundEvent::createVariableRangeEvent);
    public static final Holder<SoundEvent> INHAND_KNAP_FINAL_HIT = SOUND_EVENT.register("entity.inhand_knap.final_hit", SoundEvent::createVariableRangeEvent);
    public static final Holder<SoundEvent> INHAND_KNAP_FAIL = SOUND_EVENT.register("entity.inhand_knap.fail", SoundEvent::createVariableRangeEvent);

    public static final Holder<SoundEvent> KNAP_CRAFT = SOUND_EVENT.register("entity.knap.craft", SoundEvent::createVariableRangeEvent);


    public static void register(IEventBus bus)
    {
        SOUND_EVENT.register(bus);
    }
}
