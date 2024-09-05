package io.github.zephyrwolf.medievalism.content.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.block.blockentity.GatherersJarBlockEntity;
import io.github.zephyrwolf.medievalism.common.block.blockentity.KeepersCrockBlockEntity;
import io.github.zephyrwolf.medievalism.common.block.blockentity.SettlersPotBlockEntity;
import io.github.zephyrwolf.medievalism.common.block.blockentity.StoneBenchBlockEntity;
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

    public static final Supplier<BlockEntityType<GatherersJarBlockEntity>> GATHERERS_JAR_BLOCK_ENTITY_TYPE =
            BLOCK_ENTITY_TYPES.register(
                    "gatherers_jar_block_entity",
                    () -> BlockEntityType.Builder
                            .of(GatherersJarBlockEntity::new, BlockRegistration.GATHERERS_JAR.get())
                            .build(null) // null because we don't need to use any data-fixers
            );

    public static final Supplier<BlockEntityType<KeepersCrockBlockEntity>> KEEPERS_CROCK_BLOCK_ENTITY_TYPE =
            BLOCK_ENTITY_TYPES.register(
                    "keepers_crock_block_entity",
                    () -> BlockEntityType.Builder
                            .of(KeepersCrockBlockEntity::new, BlockRegistration.KEEPERS_CROCK.get())
                            .build(null) // null because we don't need to use any data-fixers
            );

    public static final Supplier<BlockEntityType<SettlersPotBlockEntity>> SETTLERS_POT_BLOCK_ENTITY_TYPE =
            BLOCK_ENTITY_TYPES.register(
                    "settlers_pot_block_entity",
                    () -> BlockEntityType.Builder
                            .of(SettlersPotBlockEntity::new, BlockRegistration.SETTLERS_POT.get())
                            .build(null) // null because we don't need to use any data-fixers
            );

    public static void register(IEventBus bus)
    {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}
