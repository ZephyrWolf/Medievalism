package io.github.zephyrwolf.medievalism.common.world.level.levelgen.conditionsource;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import java.util.Collection;
import java.util.Map;

public final class AwareConditionSources
{
    public static SurfaceRules.ConditionSource verticalRange(VerticalAnchor pAnchorLower, VerticalAnchor pAnchorHigher)
    {
        return verticalRange(Heightmap.Types.OCEAN_FLOOR_WG, pAnchorLower, pAnchorHigher);
    }

    public static SurfaceRules.ConditionSource verticalRange(Heightmap.Types hmType, VerticalAnchor pAnchorLower, VerticalAnchor pAnchorHigher)
    {
        return new VerticalRangeAwareConditionSource(hmType, pAnchorLower, pAnchorHigher);
    }

    public static SurfaceRules.ConditionSource lowerVerticalGradient(String randomName, VerticalAnchor trueAtAndBelow, int transitionAbove)
    {
        return new LowerGradientAwareConditionSource(ResourceLocation.parse(randomName), trueAtAndBelow, transitionAbove);
    }

    public static SurfaceRules.ConditionSource upperVerticalGradient(String randomName, VerticalAnchor trueAtAndAbove, int transitionBelow)
    {
        return new UpperGradientAwareConditionSource(ResourceLocation.parse(randomName), trueAtAndAbove, transitionBelow);
    }

    private static final int SEA_LEVEL = 63;

    public static int getSurfaceHeight(Heightmap.Types hmType, final SurfaceRules.Context pContext)
    {
        return getSurfaceHeight(hmType, pContext, SEA_LEVEL);
    }

    public static int getSurfaceHeight(Heightmap.Types hmType, final SurfaceRules.Context pContext, final int failHeight)
    {
        Collection<Map.Entry<Heightmap.Types, Heightmap>> maps = pContext.chunk.getHeightmaps();
        for (Map.Entry<Heightmap.Types, Heightmap> entry : maps)
        {
            if (entry.getKey() == hmType)
            {
                return entry.getValue().getHighestTaken(pContext.blockX, pContext.blockZ);
            }
        }
        return failHeight;
    }
}
