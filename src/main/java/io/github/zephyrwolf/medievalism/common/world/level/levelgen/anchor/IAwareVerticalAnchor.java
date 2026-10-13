package io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor;

import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;

public interface IAwareVerticalAnchor extends VerticalAnchor
{
    @Override
    default int resolveY(WorldGenerationContext context)
    {
        throw new RuntimeException("Deprecated: resolveY(WorldGenerationContext) is deprecated for AwareVerticalAnchors");
    }

    int resolveY(WorldGenerationContext context, int surfaceHeight);
}
