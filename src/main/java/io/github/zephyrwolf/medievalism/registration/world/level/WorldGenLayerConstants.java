package io.github.zephyrwolf.medievalism.registration.world.level;

import net.minecraft.world.level.levelgen.VerticalAnchor;

public class WorldGenLayerConstants
{
    public enum WorldLayerGeneratesFrom
    {
        UPPER, // world_wg
        LOWER // ocean_wg
    }

    public enum WorldLayers
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

        WorldLayers(WorldLayerGeneratesFrom pGeneratesFrom)
        {
            this.GeneratesFrom = pGeneratesFrom;
        }
    }

    public static final int SEA_LEVEL = 63;
    public static final VerticalAnchor DATUM = VerticalAnchor.absolute(SEA_LEVEL);

    public static final VerticalAnchor MIN_ASHFALL = VerticalAnchor.absolute(100);
    public static final VerticalAnchor MAX_ASHFALL = VerticalAnchor.top();

    public static final VerticalAnchor MIN_REGOLITH = VerticalAnchor.absolute(53); // just below sealevel
    public static final VerticalAnchor MAX_REGOLITH = VerticalAnchor.absolute(110); // ends just above start of ashfall

    public static final VerticalAnchor MIN_DEEP_IGNEOUS_INTRUSIVE = VerticalAnchor.bottom();
    public static final VerticalAnchor TYPICAL_DEEP_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(-34);
    public static final VerticalAnchor MAX_DEEP_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(63); // No higher than sea-level
    public static final float          POS_SCALE_DEEP_IGNEOUS_INTRUSIVE = 0.45f;
    public static final float          NEG_SCALE_DEEP_IGNEOUS_INTRUSIVE = 0.0f;

    public static final VerticalAnchor MIN_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(-34);
    public static final VerticalAnchor TYPICAL_IGNEOUS_INTRUSIVE = VerticalAnchor.absolute(-4);
    public static final VerticalAnchor MAX_IGNEOUS_INTRUSIVE = VerticalAnchor.top();
    public static final float          POS_SCALE_IGNEOUS_INTRUSIVE = 0.8f;
    public static final float          NEG_SCALE_IGNEOUS_INTRUSIVE = 0.0f;

    public static final VerticalAnchor MIN_IGNEOUS_GROUP = MIN_DEEP_IGNEOUS_INTRUSIVE;
    public static final VerticalAnchor MAX_IGNEOUS_GROUP = MAX_IGNEOUS_INTRUSIVE;

    public static final VerticalAnchor MIN_METAMORPHIC = VerticalAnchor.absolute(-4);
    public static final VerticalAnchor TYPICAL_METAMORPHIC = VerticalAnchor.absolute(26);
    public static final VerticalAnchor MAX_METAMORPHIC = VerticalAnchor.absolute(235);
    public static final float          POS_SCALE_METAMORPHIC = 1.3f;
    public static final float          NEG_SCALE_METAMORPHIC = 0.5f;

    public static final VerticalAnchor MIN_SEDIMENTARY = VerticalAnchor.absolute(26);
    public static final VerticalAnchor TYPICAL_SEDIMENTARY = VerticalAnchor.absolute(56);
    public static final VerticalAnchor MAX_SEDIMENTARY = VerticalAnchor.absolute(165);

    public static final VerticalAnchor MIN_HARD_IGNEOUS_EXTRUSIVE = MIN_METAMORPHIC;
    public static final VerticalAnchor MAX_HARD_IGNEOUS_EXTRUSIVE = MAX_METAMORPHIC;
    public static final VerticalAnchor MIN_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(135);
    public static final VerticalAnchor MAX_HEIGHTMAP_HARD_IGNEOUS_EXTRUSIVE = VerticalAnchor.top();
    public static final VerticalAnchor DATUM_HARD_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(140);
    public static final float          SCALE_HARD_IGNEOUS_EXTRUSIVE = 0.1f;

    public static final VerticalAnchor MIN_SOFT_IGNEOUS_EXTRUSIVE = MIN_SEDIMENTARY;
    public static final VerticalAnchor MAX_SOFT_IGNEOUS_EXTRUSIVE = MAX_METAMORPHIC; // At what point does metamorphic breach sedimentary?
    public static final VerticalAnchor MIN_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(130);
    public static final VerticalAnchor MAX_HEIGHTMAP_SOFT_IGNEOUS_EXTRUSIVE = VerticalAnchor.top();
    public static final VerticalAnchor DATUM_SOFT_IGNEOUS_EXTRUSIVE = VerticalAnchor.absolute(122);
    public static final float          SCALE_SOFT_IGNEOUS_EXTRUSIVE = 0.1f;

    public static final VerticalAnchor MIN_IGNEOUS_EXTRUSIVE_GROUP = MIN_HARD_IGNEOUS_EXTRUSIVE;
    public static final VerticalAnchor MAX_IGNEOUS_EXTRUSIVE_GROUP = MAX_SOFT_IGNEOUS_EXTRUSIVE;
}
