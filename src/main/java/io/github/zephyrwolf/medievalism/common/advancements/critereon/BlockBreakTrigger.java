package io.github.zephyrwolf.medievalism.common.advancements.critereon;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.content.advancements.CriteriaTriggersRegistration;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class BlockBreakTrigger extends SimpleCriterionTrigger<BlockBreakTrigger.TriggerInstance>
{
    @Override
    public @NotNull Codec<BlockBreakTrigger.TriggerInstance> codec() {
        return BlockBreakTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer pPlayer, BlockState target)
    {
        this.trigger(pPlayer, instance -> instance.matches(pPlayer, target));
    }

    public record TriggerInstance(
            Optional<ContextAwarePredicate> player,
            Optional<ItemPredicate> item,
            Optional<BlockPredicate> block
            ) implements SimpleInstance
    {
        public static final Codec<BlockBreakTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                            EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(BlockBreakTrigger.TriggerInstance::player),
                            ItemPredicate.CODEC.optionalFieldOf("item").forGetter(BlockBreakTrigger.TriggerInstance::item),
                            BlockPredicate.CODEC.optionalFieldOf("block").forGetter(BlockBreakTrigger.TriggerInstance::block)
                        ).apply(builder, BlockBreakTrigger.TriggerInstance::new)
        );

        public static Criterion<BlockBreakTrigger.TriggerInstance> breakWithEmptyHand(BlockPredicate block)
        {
            return CriteriaTriggersRegistration.BLOCK_BREAK.get()
                    .createCriterion(new BlockBreakTrigger.TriggerInstance(
                            Optional.empty(),
                            Optional.of(ItemPredicate.Builder.item().withCount(MinMaxBounds.Ints.exactly(0)).build()),
                            Optional.of(block)
                    ));
        }

        public static Criterion<BlockBreakTrigger.TriggerInstance> breakingWithEmptyHand(BlockPredicate block)
        {
            return CriteriaTriggersRegistration.BLOCK_BREAKING.get()
                    .createCriterion(new BlockBreakTrigger.TriggerInstance(
                            Optional.empty(),
                            Optional.of(ItemPredicate.Builder.item().withCount(MinMaxBounds.Ints.exactly(0)).build()),
                            Optional.of(block)
                    ));
        }

        public boolean matches(ServerPlayer pPlayer, BlockState target)
        {
            if (item.isPresent())
            {
                if (!item.get().test(pPlayer.getMainHandItem()))
                {
                    return false;
                }
            }
            return block.isEmpty() || block.get().matchesState(target);
        }
    }
}
