package io.github.zephyrwolf.medievalism.common.worldgen.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public record CompositeFeatureConfiguration(List<Holder<PlacedFeature>> features) implements FeatureConfiguration {
    public static final Codec<CompositeFeatureConfiguration> CODEC = RecordCodecBuilder.create(
            config -> config.group(
                            //ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(CompositeFeatureConfiguration::tries),
                            PlacedFeature.CODEC.listOf().fieldOf("features").forGetter(CompositeFeatureConfiguration::features)
                    )
                    .apply(config, CompositeFeatureConfiguration::new)
    );
}