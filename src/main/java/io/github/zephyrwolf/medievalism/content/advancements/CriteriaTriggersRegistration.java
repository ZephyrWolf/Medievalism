package io.github.zephyrwolf.medievalism.content.advancements;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.BlockBreakTrigger;
import io.github.zephyrwolf.medievalism.common.advancements.critereon.PlayerStatsTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class CriteriaTriggersRegistration
{
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES = DeferredRegister.create(Registries.TRIGGER_TYPE, MedievalismConstants.MOD_ID);

    public static final Supplier<PlayerStatsTrigger> PLAYER_STATS = TRIGGER_TYPES.register("player_stat", PlayerStatsTrigger::new);
    public static final Supplier<BlockBreakTrigger> BLOCK_BREAK = TRIGGER_TYPES.register("block_break", BlockBreakTrigger::new);
    public static final Supplier<BlockBreakTrigger> BLOCK_BREAKING = TRIGGER_TYPES.register("block_breaking", BlockBreakTrigger::new);

    public static void register(IEventBus modEventBus)
    {
        TRIGGER_TYPES.register(modEventBus);
    }
}
