package io.github.zephyrwolf.medievalism.common.world.level.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.Heightmap;

public enum WorldLayerAnchor
{
    UPPER(Heightmap.Types.WORLD_SURFACE_WG),    // world_wg
    NONE(null),                             // doesn't rely on heightmap
    LOWER(Heightmap.Types.OCEAN_FLOOR_WG);      // ocean_wg

    final Heightmap.Types heightmap;

    WorldLayerAnchor(Heightmap.Types hm)
    {
        this.heightmap = hm;
    }

    public static WorldLayerAnchor from(String name)
    {
        try {
            return valueOf(name);
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }

    public static final MapCodec<WorldLayerAnchor> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.fieldOf( "layer_anchor").forGetter(Enum::name)
    ).apply(instance, WorldLayerAnchor::from));
}
