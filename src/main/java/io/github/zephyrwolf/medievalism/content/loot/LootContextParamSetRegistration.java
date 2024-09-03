package io.github.zephyrwolf.medievalism.content.loot;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class LootContextParamSetRegistration { // package net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

    // NOTE: Using AT. I do not like using them, but it is the only way as the LOOT_TABLE codec is hardcoded to read from this frozen registry.
    public static final LootContextParamSet ADDITIONAL_DROPS = LootContextParamSets.register(
            "additional_drops",
            builder -> builder
                    .required(LootContextParams.ORIGIN)
                    .required(LootContextParams.BLOCK_STATE)
    );
}
