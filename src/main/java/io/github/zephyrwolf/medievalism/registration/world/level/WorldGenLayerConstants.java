package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.AwareVerticalAnchor;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.anchor.IAwareVerticalAnchor;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;

@SuppressWarnings("unused")
public class WorldGenLayerConstants
{
    public static class LayerInfoAtPos
    {
        public final ResourceKey<WorldLayer> Layer;
        public final boolean Exists;
        public final boolean Defaulted;
        public final int MinY;
        public final int MaxY;

        public LayerInfoAtPos(ResourceKey<WorldLayer> layer, boolean exists, boolean defaulted, int minY, int maxY)
        {
            this.Layer = layer;
            this.Exists = exists && minY <= maxY;
            this.Defaulted = defaulted;
            this.MinY = minY;
            this.MaxY = maxY;
        }

        public static LayerInfoAtPos BadLayerInfoAtPos() { return new LayerInfoAtPos(WorldLayersRegistration.NONE_LAYER.getKey(), false, false, 0, 0); }
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static LayerInfoAtPos GetLayer(WorldGenerationContext context, BlockPos pos, int hmOceanY, int hmSurfaceY)
    {
        // This code mimics the flow within OverhaulVanillaLevelStoneGeneration
        // Will not be able to replace that code with this function as this function is unable to provide gradients
        // Instead this function approximates the gradient at the midpoint within the transition

        final int hmY = Math.max(hmOceanY, hmSurfaceY);

        // Try Ashfall
        final IAwareVerticalAnchor anchorAshfall = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_ASHFALL);
        final int minYAshfall = anchorAshfall.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_ASHFALL / 2;
        final int maxYAshfall = hmY;
        if (pos.getY() >= MIN_ASHFALL.resolveY(context) && pos.getY() <= MAX_ASHFALL.resolveY(context))
        {
            if (pos.getY() >= minYAshfall)
            {
                return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.getKey(), true, false, minYAshfall, maxYAshfall);
            }
        }
        // Try Regolith
        final IAwareVerticalAnchor anchorRegolith = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_REGOLITH);
        final int minYRegolith = anchorRegolith.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_REGOLITH / 2;
        final int maxYRegolith = hmY;
        if (pos.getY() >= MIN_REGOLITH.resolveY(context) && pos.getY() <= MAX_REGOLITH.resolveY(context))
        {
            if (pos.getY() >= minYRegolith)
            {
                return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_REGOLITH.getKey(), true, false, minYRegolith, maxYRegolith);
            }
        }
        // Try Deep Igneous Intrusive
        final IAwareVerticalAnchor anchorDeepIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerConstants.MIN_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.TYPICAL_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.MAX_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.DATUM,
                WorldGenLayerConstants.POS_SCALE_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE);
        final int minYDeepIgIn = MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context);
        final int maxYDeepIgIn = anchorDeepIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_DEEP_IGNEOUS_INTRUSIVE / 2;
        if (pos.getY() >= MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context) && pos.getY() <= MAX_DEEP_IGNEOUS_INTRUSIVE.resolveY(context))
        {
            if (pos.getY() <= maxYDeepIgIn)
            {
                return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE.getKey(), true, false, minYDeepIgIn, maxYDeepIgIn);
            }
        }
        // Try Igneous Intrusive
        final IAwareVerticalAnchor anchorIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerConstants.MIN_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.TYPICAL_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.MAX_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.DATUM,
                WorldGenLayerConstants.POS_SCALE_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.NEG_SCALE_IGNEOUS_INTRUSIVE);
        final int minYIgIn = maxYDeepIgIn + 1;
        final int maxYIgIn = anchorIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_IGNEOUS_INTRUSIVE / 2;
        if (pos.getY() >= MIN_IGNEOUS_INTRUSIVE.resolveY(context) && pos.getY() <= MAX_IGNEOUS_INTRUSIVE.resolveY(context))
        {
            if (pos.getY() <= maxYIgIn)
            {
                return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE.getKey(), true, false, minYIgIn, maxYIgIn);
            }
        }
        // Try Hard Igneous Extrusive & Metamorphic
        final IAwareVerticalAnchor anchorMeta = AwareVerticalAnchor.worldLayer(
                WorldGenLayerConstants.MIN_METAMORPHIC,
                WorldGenLayerConstants.TYPICAL_METAMORPHIC,
                WorldGenLayerConstants.MAX_METAMORPHIC,
                WorldGenLayerConstants.DATUM,
                WorldGenLayerConstants.POS_SCALE_METAMORPHIC,
                WorldGenLayerConstants.NEG_SCALE_METAMORPHIC);
        final int minYMeta = minYIgIn;
        final int maxYMeta = anchorMeta.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_METAMORPHIC / 2;
        final IAwareVerticalAnchor anchorHardIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerConstants.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                WorldGenLayerConstants.SCALE_HARD_IGNEOUS_EXTRUSIVE);
        final int minYHardIgEx = anchorHardIgEx.resolveY(context, hmOceanY);
        final int maxYHardIgEx = maxYMeta;
        if (pos.getY() >= MIN_METAMORPHIC.resolveY(context) && pos.getY() <= MAX_METAMORPHIC.resolveY(context))
        {
            if (pos.getY() <= maxYMeta)
            {
                // Try Hard Igneous Extrusive
                if (hmOceanY >= MIN_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE.resolveY(context) && hmOceanY <= MAX_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE.resolveY(context))
                {
                    if (pos.getY() >= minYHardIgEx)
                    {
                        return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE.getKey(), true, false, minYHardIgEx, maxYHardIgEx);
                    }
                }
                // Else Metamorphic
                return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.getKey(), true, false, minYMeta, maxYMeta);
            }
        }
        // Try Soft Igneous Extrusive & Sedimentary
        final int minYSed = maxYMeta + 1;
        final int maxYSed = Math.min(minYRegolith, minYAshfall);
        final IAwareVerticalAnchor anchorSoftIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerConstants.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                WorldGenLayerConstants.SCALE_SOFT_IGNEOUS_EXTRUSIVE);
        final int minYSoftIgEx = anchorSoftIgEx.resolveY(context, hmOceanY);
        final int maxYSoftIgEx = maxYSed;
        if (pos.getY() >= MIN_SEDIMENTARY.resolveY(context) && pos.getY() <= MAX_SEDIMENTARY.resolveY(context))
        {
            // Try Soft Igneous Extrusive
            if (hmOceanY >= MIN_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context) && hmOceanY <= MAX_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context))
            {
                if (pos.getY() >= maxYSoftIgEx)
                {
                    return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE.getKey(), true, false, minYSoftIgEx, maxYSoftIgEx);
                }
            }
            // Else Sedimentary
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey(), true, false, minYSed, maxYSed);
        }
        return LayerInfoAtPos.BadLayerInfoAtPos();
    }

    public static LayerInfoAtPos GetRange(WorldGenerationContext context, ResourceKey<WorldLayer> layer, int hmOceanY, int hmSurfaceY)
    {
        WorldLayer forLayer = RegistryRegistration.WORLD_LAYERS_REGISTRY.getOrThrow(layer);
        // This code mimics the flow within OverhaulVanillaLevelStoneGeneration
        // Will not be able to replace that code with this function as this function is unable to provide gradients
        // Instead this function approximates the gradient at the midpoint within the transition

        final int hmY = Math.max(hmOceanY, hmSurfaceY);

        // Try Ashfall
        final IAwareVerticalAnchor anchorAshfall = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_ASHFALL);
        final int minYAshfall = Math.max(anchorAshfall.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_ASHFALL / 2, WorldGenLayerConstants.MIN_ASHFALL.resolveY(context));
        final int maxYAshfall = Math.min(hmY, WorldGenLayerConstants.MAX_ASHFALL.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.getKey(), true, false, minYAshfall, maxYAshfall);
        }
        // Try Regolith
        final IAwareVerticalAnchor anchorRegolith = AwareVerticalAnchor.heightMap(-DEPTH_SURFACE_REGOLITH);
        final int minYRegolith = Math.max(anchorRegolith.resolveY(context, hmOceanY) - TRANSITION_THICKNESS_REGOLITH / 2, WorldGenLayerConstants.MIN_REGOLITH.resolveY(context));
        final int maxYRegolith = Math.min(hmY, WorldGenLayerConstants.MAX_REGOLITH.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_REGOLITH.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_REGOLITH.getKey(), true, false, minYRegolith, maxYRegolith);
        }
        // Try Deep Igneous Intrusive
        final IAwareVerticalAnchor anchorDeepIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerConstants.MIN_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.TYPICAL_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.MAX_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.DATUM,
                WorldGenLayerConstants.POS_SCALE_DEEP_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE);
        final int minYDeepIgIn = Math.max(WorldGenLayerConstants.MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context), WorldGenLayerConstants.MIN_DEEP_IGNEOUS_INTRUSIVE.resolveY(context));
        final int maxYDeepIgIn = Math.min(anchorDeepIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_DEEP_IGNEOUS_INTRUSIVE / 2, WorldGenLayerConstants.MAX_DEEP_IGNEOUS_INTRUSIVE.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE.getKey(), true, false, minYDeepIgIn, maxYDeepIgIn);
        }
        // Try Igneous Intrusive
        final IAwareVerticalAnchor anchorIgIn = AwareVerticalAnchor.worldLayer(
                WorldGenLayerConstants.MIN_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.TYPICAL_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.MAX_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.DATUM,
                WorldGenLayerConstants.POS_SCALE_IGNEOUS_INTRUSIVE,
                WorldGenLayerConstants.NEG_SCALE_IGNEOUS_INTRUSIVE);
        final int minYIgIn = Math.max(maxYDeepIgIn + 1, WorldGenLayerConstants.MIN_IGNEOUS_INTRUSIVE.resolveY(context));
        final int maxYIgIn = Math.min(anchorIgIn.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_IGNEOUS_INTRUSIVE / 2, WorldGenLayerConstants.MAX_IGNEOUS_INTRUSIVE.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE.getKey(), true, false, minYIgIn, maxYIgIn);
        }
        // Try Hard Igneous Extrusive & Metamorphic
        final IAwareVerticalAnchor anchorMeta = AwareVerticalAnchor.worldLayer(
                WorldGenLayerConstants.MIN_METAMORPHIC,
                WorldGenLayerConstants.TYPICAL_METAMORPHIC,
                WorldGenLayerConstants.MAX_METAMORPHIC,
                WorldGenLayerConstants.DATUM,
                WorldGenLayerConstants.POS_SCALE_METAMORPHIC,
                WorldGenLayerConstants.NEG_SCALE_METAMORPHIC);
        final int minYMeta = Math.max(minYIgIn + 1, WorldGenLayerConstants.MIN_METAMORPHIC.resolveY(context));
        final int maxYMeta = Math.min(anchorMeta.resolveY(context, hmSurfaceY) + TRANSITION_THICKNESS_METAMORPHIC / 2, WorldGenLayerConstants.MAX_METAMORPHIC.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.getKey(), true, false, minYMeta, maxYMeta);
        }
        final IAwareVerticalAnchor anchorHardIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerConstants.DATUM_HARD_IGNEOUS_EXTRUSIVE,
                WorldGenLayerConstants.SCALE_HARD_IGNEOUS_EXTRUSIVE);
        final int minYHardIgEx = Math.max(anchorHardIgEx.resolveY(context, hmOceanY), WorldGenLayerConstants.MIN_HARD_IGNEOUS_EXTRUSIVE.resolveY(context));
        final int maxYHardIgEx = Math.min(maxYMeta, WorldGenLayerConstants.MAX_HARD_IGNEOUS_EXTRUSIVE.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE.getKey(), true, false, minYHardIgEx, maxYHardIgEx);
        }
        // Try Soft Igneous Extrusive & Sedimentary
        final int minYSed = Math.max(maxYMeta + 1, WorldGenLayerConstants.MIN_SEDIMENTARY.resolveY(context));
        final int maxYSed = Math.min(Math.min(minYRegolith - 1, minYAshfall - 1), WorldGenLayerConstants.MAX_SEDIMENTARY.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey(), true, false, minYSed, maxYSed);
        }
        final IAwareVerticalAnchor anchorSoftIgEx = AwareVerticalAnchor.inverseBell(
                WorldGenLayerConstants.DATUM_SOFT_IGNEOUS_EXTRUSIVE,
                WorldGenLayerConstants.SCALE_SOFT_IGNEOUS_EXTRUSIVE);
        final int minYSoftIgEx = Math.max(anchorSoftIgEx.resolveY(context, hmOceanY), WorldGenLayerConstants.MIN_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context));
        final int maxYSoftIgEx = Math.min(maxYSed, WorldGenLayerConstants.MAX_SOFT_IGNEOUS_EXTRUSIVE.resolveY(context));
        if (forLayer == WorldLayersRegistration.OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE.get())
        {
            return new LayerInfoAtPos(WorldLayersRegistration.OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE.getKey(), true, false, minYSoftIgEx, maxYSoftIgEx);
        }
        return LayerInfoAtPos.BadLayerInfoAtPos();
    }

    public static final int SEA_LEVEL = 63;
    public static final VerticalAnchor DATUM = VerticalAnchor.absolute(SEA_LEVEL);

    public static final VerticalAnchor      MIN_ASHFALL = VerticalAnchor.absolute(100);
    public static final int                 DEPTH_SURFACE_ASHFALL = 5;
    public static final VerticalAnchor      MAX_ASHFALL = VerticalAnchor.top();
    public static final int                 TRANSITION_THICKNESS_ASHFALL = 3;

    public static final VerticalAnchor      MIN_REGOLITH = VerticalAnchor.absolute(53); // just below sea-level
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
