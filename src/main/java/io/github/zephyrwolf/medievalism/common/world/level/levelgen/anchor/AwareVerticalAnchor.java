package io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;

public final class AwareVerticalAnchor
{
    public static IAwareVerticalAnchor worldLayer(VerticalAnchor minHeight, VerticalAnchor typicalHeight, VerticalAnchor maxHeight, VerticalAnchor yDatum, float posScale, float negScale)
    {
        return new WorldLayerAwareVerticalAnchor(minHeight, typicalHeight, maxHeight, yDatum, posScale, negScale);
    }

    public static IAwareVerticalAnchor heightMap(int offset)
    {
        return new HeightmapAwareVerticalAnchor(offset);
    }

    public static IAwareVerticalAnchor inverseBell(VerticalAnchor minHeight, float scale)
    {
        return new InverseBellAwareVerticalAnchor(minHeight, scale);
    }

    public static int resolveY(VerticalAnchor anchor, WorldGenerationContext context, int surfaceHeight)
    {
        if (anchor instanceof IAwareVerticalAnchor awareAnchor)
        {
            return awareAnchor.resolveY(context, surfaceHeight);
        }
        return anchor.resolveY(context);
    }
}
