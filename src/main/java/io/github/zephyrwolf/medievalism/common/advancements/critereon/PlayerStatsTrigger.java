package io.github.zephyrwolf.medievalism.common.advancements.critereon;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.content.advancements.CriteriaTriggersRegistration;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class PlayerStatsTrigger extends SimpleCriterionTrigger<PlayerStatsTrigger.TriggerInstance>
{
    @Override
    public @NotNull Codec<PlayerStatsTrigger.TriggerInstance> codec() {
        return PlayerStatsTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer pPlayer)
    {
        this.trigger(pPlayer, instance -> instance.matches(pPlayer));
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player, ResourceLocation stat, int value) implements SimpleCriterionTrigger.SimpleInstance
    {
        public static final Codec<PlayerStatsTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                            EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(PlayerStatsTrigger.TriggerInstance::player),
                            ResourceLocation.CODEC.fieldOf("stat").forGetter(PlayerStatsTrigger.TriggerInstance::stat),
                            Codec.INT.fieldOf("ticks").forGetter(PlayerStatsTrigger.TriggerInstance::value)
                        ).apply(builder, PlayerStatsTrigger.TriggerInstance::new)
        );

        public static Criterion<PlayerStatsTrigger.TriggerInstance> timePlayerInWorld(int ticks)
        {
            return CriteriaTriggersRegistration.PLAYER_STATS.get()
                    .createCriterion(new PlayerStatsTrigger.TriggerInstance(Optional.empty(), Stats.PLAY_TIME, ticks));
        }

        public boolean matches(ServerPlayer pPlayer)
        {
            Stat<?> playTimeStat = Stats.CUSTOM.get(Stats.PLAY_TIME);
            return pPlayer.getStats().getValue(playTimeStat) >= value;
        }
    }
}
