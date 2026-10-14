package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.IAwareVerticalAnchor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;

public class WorldGenLayerCatalog
{
    public enum WorldLayerGeneratesFrom
    {
        UPPER, // world_wg
        LOWER // ocean_wg
    }

    public enum WorldLayer
    {
        ASHFALL(WorldLayerGeneratesFrom.UPPER),
        REGOLITH(WorldLayerGeneratesFrom.UPPER),
        SEDIMENTARY(WorldLayerGeneratesFrom.LOWER),
        METAMORPHIC(WorldLayerGeneratesFrom.LOWER),
        SOFT_IGNEOUS_EXTRUSIVE(WorldLayerGeneratesFrom.UPPER),
        HARD_IGNEOUS_EXTRUSIVE(WorldLayerGeneratesFrom.UPPER),
        IGNEOUS_INTRUSIVE(WorldLayerGeneratesFrom.LOWER),
        DEEP_IGNEOUS_INTRUSIVE(WorldLayerGeneratesFrom.LOWER);

        final WorldLayerGeneratesFrom GeneratesFrom;

        WorldLayer(WorldLayerGeneratesFrom pGeneratesFrom)
        {
            this.GeneratesFrom = pGeneratesFrom;
        }
    }

    public static class LayerInfoAtPos
    {
        public final WorldLayer Layer;
        public final boolean Exists;
        public final boolean Defaulted;
        public final int MinY;
        public final int MaxY;

        public LayerInfoAtPos(WorldLayer layer, boolean exists, boolean defaulted, int minY, int maxY)
        {
            this.Layer = layer;
            this.Exists = exists && minY <= maxY;
            this.Defaulted = defaulted;
            this.MinY = minY;
            this.MaxY = maxY;
        }
    }

    public static LayerInfoAtPos GetLayer(WorldGenerationContext context, BlockPos pos, int hmOceanY, int hmSurfaceY)
    {
        // This code mimics the flow within OverhaulVanillaLevelStoneGeneration
        // Will not be able to replace that code with this function as this function is unable to provide gradients
        // Instead this function approximates the gradient at the midpoint within the transition

        int hmY = Math.max(hmOceanY, hmSurfaceY);

        // Try Ashfall
        IAwareVerticalAnchor anchorAshfall = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_ASHFALL);
        int minYAshfall = anchorAshfall.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_ASHFALL / 2;
        int maxYAshfall = hmY;
        if (pos.getY() >= MIN_ASHFALL.resolveY(context) && pos.getY() <= MAX_ASHFALL.resolveY(context))
        {
            if (pos.getY() >= minYAshfall)
            {
                return new LayerInfoAtPos(WorldLayer.ASHFALL, true, false, minYAshfall, maxYAshfall);
            }
        }
        // Try Regolith
        IAwareVerticalAnchor anchorRegolith = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_REGOLITH);
        int minYRegolith = anchorRegolith.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_REGOLITH / 2;
        int maxYRegolith = hmY;
        if (pos.getY() >= MIN_REGOLITH.resolveY(context) && pos.getY() <= MAX_REGOLITH.resolveY(context))
        {
            if (pos.getY() >= minYRegolith)
            {
                return new LayerInfoAtPos(WorldLayer.ASHFALL, true, false, minYRegolith, maxYRegolith);
            }
        }
        // Try Deep Igneous Intrusive
        IAwareVerticalAnchor anchorDeepIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerCatalog.MIN_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.TYPICAL_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.MAX_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.DATUM,
                WorldGenLayerCatalog.POS_SCALE_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE);
        int minYDeepIgIn = MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context);
        int maxYDeepIgIn = anchorDeepIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_DEEP_IGNEOUS_INTRUSIVE / 2;
        if (pos.getY() >= MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context) && pos.getY() <= MAX_DEEP_IGNEOUS_INTRUSIVE.resolveY(context))
        {
            if (pos.getY() <= maxYDeepIgIn)
            {
                return new LayerInfoAtPos(WorldLayer.DEEP_IGNEOUS_INTRUSIVE, true, false, minYDeepIgIn, maxYDeepIgIn);
            }
        }
        // Try Igneous Intrusive
        IAwareVerticalAnchor anchorIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerCatalog.MIN_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.TYPICAL_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.MAX_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.DATUM,
                WorldGenLayerCatalog.POS_SCALE_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.NEG_SCALE_IGNEOUS_INTRUSIVE);
        int minYIgIn = maxYDeepIgIn + 1;
        int maxYIgIn = anchorIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_IGNEOUS_INTRUSIVE / 2;
        if (pos.getY() >= MIN_IGNEOUS_INTRUSIVE.resolveY(context) && pos.getY() <= MAX_IGNEOUS_INTRUSIVE.resolveY(context))
        {
            if (pos.getY() <= maxYIgIn)
            {
                return new LayerInfoAtPos(WorldLayer.IGNEOUS_INTRUSIVE, true, false, minYIgIn, maxYIgIn);
            }
        }
        // Try Hard Igneous Extrusive & Metamorphic
        IAwareVerticalAnchor anchorMeta = AwareVerticalAnchor.worldLayer(
                WorldGenLayerCatalog.MIN_METAMORPHIC,
                WorldGenLayerCatalog.TYPICAL_METAMORPHIC,
                WorldGenLayerCatalog.MAX_METAMORPHIC,
                WorldGenLayerCatalog.DATUM,
                WorldGenLayerCatalog.POS_SCALE_METAMORPHIC,
                WorldGenLayerCatalog.NEG_SCALE_METAMORPHIC);
        int minYMeta = minYIgIn;
        int maxYMeta = anchorMeta.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_METAMORPHIC / 2;
        IAwareVerticalAnchor anchorHardIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerCatalog.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                WorldGenLayerCatalog.SCALE_HARD_IGNEOUS_EXTRUSIVE);
        int minYHardIgEx = anchorHardIgEx.resolveY(context, hmOceanY);
        int maxYHardIgEx = maxYMeta;
        if (pos.getY() >= MIN_METAMORPHIC.resolveY(context) && pos.getY() <= MAX_METAMORPHIC.resolveY(context))
        {
            if (pos.getY() <= maxYMeta)
            {
                // Try Hard Igneous Extrusive
                if (hmOceanY >= MIN_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE.resolveY(context) && hmOceanY <= MAX_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE.resolveY(context))
                {
                    if (pos.getY() >= minYHardIgEx)
                    {
                        return new LayerInfoAtPos(WorldLayer.HARD_IGNEOUS_EXTRUSIVE, true, false, minYHardIgEx, maxYHardIgEx);
                    }
                }
                // Else Metamorphic
                return new LayerInfoAtPos(WorldLayer.METAMORPHIC, true, false, minYMeta, maxYMeta);
            }
        }
        // Try Soft Igneous Extrusive & Sedimentary
        int minYSed = maxYMeta + 1;
        int maxYSed = Math.min(minYRegolith, minYAshfall);
        IAwareVerticalAnchor anchorSoftIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerCatalog.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                WorldGenLayerCatalog.SCALE_SOFT_IGNEOUS_EXTRUSIVE);
        int minYSoftIgEx = anchorSoftIgEx.resolveY(context, hmOceanY);
        int maxYSoftIgEx = maxYSed;
        if (pos.getY() >= MIN_SEDIMENTARY.resolveY(context) && pos.getY() <= MAX_SEDIMENTARY.resolveY(context))
        {
            // Try Soft Igneous Extrusive
            if (hmOceanY >= MIN_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context) && hmOceanY <= MAX_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context))
            {
                if (pos.getY() >= maxYSoftIgEx)
                {
                    return new LayerInfoAtPos(WorldLayer.SOFT_IGNEOUS_EXTRUSIVE, true, false, minYSoftIgEx, maxYSoftIgEx);
                }
            }
            // Else Sedimentary
            return new LayerInfoAtPos(WorldLayer.SEDIMENTARY, true, false, minYSed, maxYSed);
        }
        return new LayerInfoAtPos(WorldLayer.SEDIMENTARY, false, true, 0, 0); // Should never get here, but just in case
    }

    public static LayerInfoAtPos GetRange(WorldGenerationContext context, WorldLayer forLayer, BlockPos ppos, int hmOceanY, int hmSurfaceY)
    {
        // This code mimics the flow within OverhaulVanillaLevelStoneGeneration
        // Will not be able to replace that code with this function as this function is unable to provide gradients
        // Instead this function approximates the gradient at the midpoint within the transition

        final int hmY = Math.max(hmOceanY, hmSurfaceY);

        // Try Ashfall
        final IAwareVerticalAnchor anchorAshfall = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_ASHFALL);
        final int minYAshfall = Math.max(anchorAshfall.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_ASHFALL / 2, WorldGenLayerCatalog.MIN_ASHFALL.resolveY(context));
        final int maxYAshfall = Math.min(hmY, WorldGenLayerCatalog.MAX_ASHFALL.resolveY(context));
        if (forLayer == WorldLayer.ASHFALL)
        {
            return new LayerInfoAtPos(WorldLayer.ASHFALL, true, false, minYAshfall, maxYAshfall);
        }
        // Try Regolith
        final IAwareVerticalAnchor anchorRegolith = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_REGOLITH);
        final int minYRegolith = Math.max(anchorRegolith.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_REGOLITH / 2, WorldGenLayerCatalog.MIN_REGOLITH.resolveY(context));
        final int maxYRegolith = Math.min(hmY, WorldGenLayerCatalog.MAX_REGOLITH.resolveY(context));
        if (forLayer == WorldLayer.REGOLITH)
        {
            return new LayerInfoAtPos(WorldLayer.REGOLITH, true, false, minYRegolith, maxYRegolith);
        }
        // Try Deep Igneous Intrusive
        final IAwareVerticalAnchor anchorDeepIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerCatalog.MIN_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.TYPICAL_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.MAX_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.DATUM,
                WorldGenLayerCatalog.POS_SCALE_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE);
        final int minYDeepIgIn = Math.max(WorldGenLayerCatalog.MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context), WorldGenLayerCatalog.MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context));
        final int maxYDeepIgIn = Math.min(anchorDeepIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_DEEP_IGNEOUS_INTRUSIVE / 2, WorldGenLayerCatalog.MAX_DEEP_IGNEOUS_INTRUSIVE.resolveY(context));
        if (forLayer == WorldLayer.DEEP_IGNEOUS_INTRUSIVE)
        {
            return new LayerInfoAtPos(WorldLayer.DEEP_IGNEOUS_INTRUSIVE, true, false, minYDeepIgIn, maxYDeepIgIn);
        }
        // Try Igneous Intrusive
        final IAwareVerticalAnchor anchorIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerCatalog.MIN_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.TYPICAL_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.MAX_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.DATUM,
                WorldGenLayerCatalog.POS_SCALE_IGNEOUS_INTRUSIVE,
                WorldGenLayerCatalog.NEG_SCALE_IGNEOUS_INTRUSIVE);
        final int minYIgIn = Math.max(maxYDeepIgIn + 1, WorldGenLayerCatalog.MIN_IGNEOUS_INTRUSIVE.resolveY(context));
        final int maxYIgIn = Math.min(anchorIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_IGNEOUS_INTRUSIVE / 2, WorldGenLayerCatalog.MAX_IGNEOUS_INTRUSIVE.resolveY(context));
        if (forLayer == WorldLayer.IGNEOUS_INTRUSIVE)
        {
            return new LayerInfoAtPos(WorldLayer.IGNEOUS_INTRUSIVE, true, false, minYIgIn, maxYIgIn);
        }
        // Try Hard Igneous Extrusive & Metamorphic
        final IAwareVerticalAnchor anchorMeta = AwareVerticalAnchor.worldLayer(
                WorldGenLayerCatalog.MIN_METAMORPHIC,
                WorldGenLayerCatalog.TYPICAL_METAMORPHIC,
                WorldGenLayerCatalog.MAX_METAMORPHIC,
                WorldGenLayerCatalog.DATUM,
                WorldGenLayerCatalog.POS_SCALE_METAMORPHIC,
                WorldGenLayerCatalog.NEG_SCALE_METAMORPHIC);
        final int minYMeta = Math.max(minYIgIn + 1, WorldGenLayerCatalog.MIN_METAMORPHIC.resolveY(context));
        final int maxYMeta = Math.min(anchorMeta.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_METAMORPHIC / 2, WorldGenLayerCatalog.MAX_METAMORPHIC.resolveY(context));
        if (forLayer == WorldLayer.METAMORPHIC)
        {
            return new LayerInfoAtPos(WorldLayer.METAMORPHIC, true, false, minYMeta, maxYMeta);
        }
        final IAwareVerticalAnchor anchorHardIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerCatalog.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                WorldGenLayerCatalog.SCALE_HARD_IGNEOUS_EXTRUSIVE);
        final int minYHardIgEx = Math.max(anchorHardIgEx.resolveY(context, hmOceanY), WorldGenLayerCatalog.MIN_HARD_IGNEOUS_EXTRUSIVE.resolveY(context));
        final int maxYHardIgEx = Math.min(maxYMeta, WorldGenLayerCatalog.MAX_HARD_IGNEOUS_EXTRUSIVE.resolveY(context));
        if (forLayer == WorldLayer.HARD_IGNEOUS_EXTRUSIVE)
        {
            return new LayerInfoAtPos(WorldLayer.HARD_IGNEOUS_EXTRUSIVE, true, false, minYHardIgEx, maxYHardIgEx);
        }
        // Try Soft Igneous Extrusive & Sedimentary
        final int minYSed = Math.max(maxYMeta + 1, WorldGenLayerCatalog.MIN_SEDIMENTARY.resolveY(context));
        final int maxYSed = Math.min(Math.min(minYRegolith - 1, minYAshfall - 1), WorldGenLayerCatalog.MAX_SEDIMENTARY.resolveY(context));
        if (forLayer == WorldLayer.SEDIMENTARY)
        {
            return new LayerInfoAtPos(WorldLayer.SEDIMENTARY, true, false, minYSed, maxYSed);
        }
        final IAwareVerticalAnchor anchorSoftIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerCatalog.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                WorldGenLayerCatalog.SCALE_SOFT_IGNEOUS_EXTRUSIVE);
        final int minYSoftIgEx = Math.max(anchorSoftIgEx.resolveY(context, hmOceanY), WorldGenLayerCatalog.MIN_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context));
        final int maxYSoftIgEx = Math.min(maxYSed, WorldGenLayerCatalog.MAX_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context));
        if (forLayer == WorldLayer.SOFT_IGNEOUS_EXTRUSIVE)
        {
            return new LayerInfoAtPos(WorldLayer.SOFT_IGNEOUS_EXTRUSIVE, true, false, minYSoftIgEx, maxYSoftIgEx);
        }
        return new LayerInfoAtPos(forLayer, false, false, 0, 0);
    }

    public static final int SEA_LEVEL = 63;
    public static final VerticalAnchor DATUM = VerticalAnchor.absolute(SEA_LEVEL);

    public static final VerticalAnchor      MIN_ASHFALL = VerticalAnchor.absolute(100);
    public static final int                 DEPTH_SURFACE_ASHFALL = 5;
    public static final VerticalAnchor      MAX_ASHFALL = VerticalAnchor.top();
    public static final int                 TRANSITION_THICKNESS_ASHFALL = 3;

    public static final VerticalAnchor      MIN_REGOLITH = VerticalAnchor.absolute(53); // just below sealevel
    public static final int                 DEPTH_SURFACE_REGOLITH = 7;
    public static final VerticalAnchor      MAX_REGOLITH = VerticalAnchor.absolute(110); // ends just above start of ashfall
    public static final int                 TRANSITION_THICKNESS_REGOLITH = 5;

    public static final VerticalAnchor      MIN_DEEP_IGNEOUS_INTRUSIVE = VerticalAnchor.bottom();
    public static final VerticalAnchor      TYPICAL_DEEP_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(-34);
    public static final VerticalAnchor      MAX_DEEP_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(63); // No higher than sea-level
    public static final float               POS_SCALE_DEEP_IGNEOUS_INTRUSIVE = 0.45f;
    public static final float               NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE = 0.0f;
    public static final int                 TRANSITION_THICKNESS_DEEP_IGNEOUS_INTRUSIVE = 8;

    public static final VerticalAnchor      MIN_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(-34);
    public static final VerticalAnchor      TYPICAL_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(-4);
    public static final VerticalAnchor      MAX_IGNEOUS_INTRUSIVE = VerticalAnchor.top();
    public static final float               POS_SCALE_IGNEOUS_INTRUSIVE = 0.8f;
    public static final float               NEG_SCALE_IGNEOUS_INTRUSIVE = 0.0f;
    public static final int                 TRANSITION_THICKNESS_IGNEOUS_INTRUSIVE = 8;

    public static final VerticalAnchor MIN_IGNEOUS_GROUP = MIN_DEEP_IGNEOUS_INTRUSIVE;
    public static final VerticalAnchor MAX_IGNEOUS_GROUP = MAX_IGNEOUS_INTRUSIVE;

    public static final VerticalAnchor MIN_METAMORPHIC = VerticalAnchor.absolute(-4);
    public static final VerticalAnchor TYPICAL_METAMORPHIC = VerticalAnchor.absolute(26);
    public static final VerticalAnchor MAX_METAMORPHIC = VerticalAnchor.absolute(235);
    public static final float          POS_SCALE_METAMORPHIC = 1.3f;
    public static final float          NEG_SCALE_METAMORPHIC = 0.5f;
    public static final int            TRANSITION_THICKNESS_METAMORPHIC = 8;

    public static final VerticalAnchor MIN_SEDIMENTARY = VerticalAnchor.absolute(26);
    public static final VerticalAnchor TYPICAL_SEDIMENTARY = VerticalAnchor.absolute(56);
    public static final VerticalAnchor MAX_SEDIMENTARY = VerticalAnchor.absolute(165);

    public static final VerticalAnchor MIN_HARD_IGNEOUS_EXTRUSIVE = MIN_METAMORPHIC;
    public static final VerticalAnchor MAX_HARD_IGNEOUS_EXTRUSIVE = MAX_METAMORPHIC;
    public static final VerticalAnchor MIN_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(135);
    public static final VerticalAnchor MAX_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE = VerticalAnchor.top();
    public static final VerticalAnchor DATUM_HARD_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(140);
    public static final float          SCALE_HARD_IGNEOUS_EXTRUSIVE = 0.1f;
    public static final int            TRANSITION_THICKNESS_HARD_IGNEOUS_EXTRUSIVE = 4;

    public static final VerticalAnchor MIN_SOFT_IGNEOUS_EXTRUSIVE = MIN_SEDIMENTARY;
    public static final VerticalAnchor MAX_SOFT_IGNEOUS_EXTRUSIVE = MAX_METAMORPHIC; // At what point does metamorphic breach sedimentary?
    public static final VerticalAnchor MIN_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(130);
    public static final VerticalAnchor MAX_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE = VerticalAnchor.top();
    public static final VerticalAnchor DATUM_SOFT_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(122);
    public static final float          SCALE_SOFT_IGNEOUS_EXTRUSIVE = 0.1f;
    public static final int            TRANSITION_THICKNESS_SOFT_IGNEOUS_EXTRUSIVE = 4;


    public static final VerticalAnchor MIN_IGNEOUS_EXTRUSIVE_GROUP = MIN_HARD_IGNEOUS_EXTRUSIVE;
    public static final VerticalAnchor MAX_IGNEOUS_EXTRUSIVE_GROUP = MAX_SOFT_IGNEOUS_EXTRUSIVE;
}
