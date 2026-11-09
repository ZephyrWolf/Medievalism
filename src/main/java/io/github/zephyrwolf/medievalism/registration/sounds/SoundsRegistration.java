package io.github.zephyrwolf.medievalism.registration.sounds;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.inhand.InhandRecipeIngredientMaterialType;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundsRegistration
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, MedievalismConstants.MOD_ID);

    public static final Holder<SoundEvent> INHAND_FAIL = SOUND_EVENT.register("entity.inhand.fail", SoundEvent::createVariableRangeEvent);

    public static final Holder<SoundEvent> INHAND_HIT_ROCK_HIT = SOUND_EVENT.register("entity.inhand_hit_rock.hit", SoundEvent::createVariableRangeEvent);
    public static final Holder<SoundEvent> INHAND_HIT_ROCK_FINAL = SOUND_EVENT.register("entity.inhand_hit_rock.final_hit", SoundEvent::createVariableRangeEvent);

    public static final Holder<SoundEvent> INHAND_HIT_PLANT_HIT = SOUND_EVENT.register("entity.inhand_hit_plant.hit", SoundEvent::createVariableRangeEvent);
    public static final Holder<SoundEvent> INHAND_HIT_PLANT_FINAL = SOUND_EVENT.register("entity.inhand_hit_plant.final_hit", SoundEvent::createVariableRangeEvent);

    public static final Holder<SoundEvent> INHAND_SCRAPE_PLANT_HIT = SOUND_EVENT.register("entity.inhand_scrape_plant.hit", SoundEvent::createVariableRangeEvent);
    public static final Holder<SoundEvent> INHAND_SCRAPE_PLANT_FINAL = SOUND_EVENT.register("entity.inhand_scrape_plant.final_hit", SoundEvent::createVariableRangeEvent);

    public static SoundEvent getInhandSoundEvent(InhandRecipeIngredientMaterialType materialType, boolean finalHit)
    {
        return switch (materialType)
        {
            case HIT_ROCK ->
                    finalHit ? SoundsRegistration.INHAND_HIT_ROCK_FINAL.value() : SoundsRegistration.INHAND_HIT_ROCK_HIT.value();
            case HIT_PLANT ->
                    finalHit ? SoundsRegistration.INHAND_HIT_PLANT_FINAL.value() : SoundsRegistration.INHAND_HIT_PLANT_HIT.value();
            case SCRAPE_PLANT ->
                    finalHit ? SoundsRegistration.INHAND_SCRAPE_PLANT_FINAL.value() : SoundsRegistration.INHAND_SCRAPE_PLANT_HIT.value();
        };
    }

    public static void register(IEventBus bus)
    {
        SOUND_EVENT.register(bus);
    }
}
