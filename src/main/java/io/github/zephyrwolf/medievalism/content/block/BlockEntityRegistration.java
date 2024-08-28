package io.github.zephyrwolf.medievalism.content.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.blockentity.StoneBenchBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class BlockEntityRegistration
{
    // Registry
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MedievalismConstants.MOD_ID);

    // Block Entities

    @SuppressWarnings("DataFlowIssue")
    public static final Supplier<BlockEntityType<StoneBenchBlockEntity>> STONE_BENCH_BLOCK_ENTITY_TYPE =
            BLOCK_ENTITY_TYPES.register(
                    "stone_bench_block_entity",
                    () -> BlockEntityType.Builder
                            .of(StoneBenchBlockEntity::new, BlockRegistration.STONE_BENCH.get())
                            .build(null) // null because we don't need to use any data-fixers
            );




    public static void register(IEventBus bus)
    {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}
