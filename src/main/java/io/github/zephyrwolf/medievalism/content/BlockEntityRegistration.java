package io.github.zephyrwolf.medievalism.content;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.blockentity.StoneBenchBlockEntity;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeSerializer;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class BlockEntityRegistration
{
    // Registry
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MedievalismConstants.MOD_ID);

    // Block Entities





    public static void register(IEventBus bus)
    {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}