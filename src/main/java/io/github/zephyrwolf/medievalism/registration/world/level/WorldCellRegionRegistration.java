package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegion;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldCellRegionMap;
import io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth.CellNoise;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.List;

public final class WorldCellRegionRegistration
{
    public static final DeferredRegister<WorldCellRegionMap> CELL_REGION_MAPS = DeferredRegister.create(
            RegistryRegistration.WORLD_CELL_REGION_MAPS, MedievalismConstants.MOD_ID);
    public static final DeferredRegister<WorldCellRegion> CELL_REGIONS = DeferredRegister.create(
            RegistryRegistration.WORLD_CELL_REGIONS, MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus)
    {
        CELL_REGION_MAPS.register(modEventBus);
        CELL_REGIONS.register(modEventBus);
    }

    public record StoneVariationConfig(int cellSize, float warp, int boarderThickness)
    { }
    public static final StoneVariationConfig OVERWORLD_REGOLITH_CONFIG =                new StoneVariationConfig(500, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_SEDIMENTARY_CONFIG =             new StoneVariationConfig(500, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_METAMORPHIC_CONFIG =             new StoneVariationConfig(600, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_IGNEOUS_INTRUSIVE_CONFIG =       new StoneVariationConfig(700, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_DEEP_IGNEOUS_INTRUSIVE_CONFIG =  new StoneVariationConfig(800, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_ASHFALL_CONFIG =                 new StoneVariationConfig(350, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE_CONFIG =  new StoneVariationConfig(500, 1.0f, 15);
    public static final StoneVariationConfig OVERWORLD_HARD_IGNEOUS_EXTRUSIVE_CONFIG =  new StoneVariationConfig(500, 1.0f, 15);

    private static ResourceKey<WorldCellRegion> getCellRegion_StoneGen_Overworld(
            @Nullable LevelReader level, @Nullable ChunkGenerator chunkGenerator,
            RandomState randomState, WorldCellRegionMap cellRegionMap,
            List<ResourceKey<WorldCellRegion>> cellRegionKeyList, BlockPos origin)
    {
        assert cellRegionMap.noise() != null;
        StoneVariationConfig config = (StoneVariationConfig) cellRegionMap.extra();
        assert config != null;
        NormalNoise noise = randomState.getOrCreateNoise(cellRegionMap.noise());
        long n =  CellNoise.noise(noise, config.cellSize(), config.warp(), config.boarderThickness(), origin);
        int ordinal = Math.floorMod(n, cellRegionKeyList.size());
        return cellRegionKeyList.get(ordinal);
    }

    public static final String DEFAULT_CELL_REGION_MAP_NAME = "none";
    public static final String DEFAULT_CELL_REGION_NAME = "none";
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> NONE_CELL_REGION_MAP = CELL_REGION_MAPS.register(DEFAULT_CELL_REGION_MAP_NAME, WorldCellRegionMap.newCellMap(Level.OVERWORLD, null, WorldCellRegionMap.DEFAULT_CELL_REGION_GETTER));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> NONE_CELL_REGION = CELL_REGIONS.register(DEFAULT_CELL_REGION_NAME, WorldCellRegion.newLayer(NONE_CELL_REGION_MAP.getKey()) );

    // == Vanilla ==

    // == Overhaul ==
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_REGOLITH_MAP = CELL_REGION_MAPS.register("overworld_regolith", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_REGOLITH, OVERWORLD_REGOLITH_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> LATERITE =         CELL_REGIONS.register("laterite",          WorldCellRegion.newLayer(OVERWORLD_REGOLITH_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SAPROLITE =        CELL_REGIONS.register("saprolite",         WorldCellRegion.newLayer(OVERWORLD_REGOLITH_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SILT =             CELL_REGIONS.register("silt",              WorldCellRegion.newLayer(OVERWORLD_REGOLITH_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_SEDIMENTARY_MAP = CELL_REGION_MAPS.register("overworld_sedimentary", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_SEDIMENTARY, OVERWORLD_SEDIMENTARY_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> GREYWACKE =        CELL_REGIONS.register("greywacke",         WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SILTSTONE =        CELL_REGIONS.register("siltstone",         WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> DOLOSTONE =        CELL_REGIONS.register("dolostone",         WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> LIMESTONE =        CELL_REGIONS.register("limestone",         WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> IRONSTONE =        CELL_REGIONS.register("ironstone",         WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SHALE =            CELL_REGIONS.register("shale",             WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> ARKOSE =           CELL_REGIONS.register("arkose",            WorldCellRegion.newLayer(OVERWORLD_SEDIMENTARY_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_METAMORPHIC_MAP = CELL_REGION_MAPS.register("overworld_metamorphic", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_METAMORPHIC, OVERWORLD_METAMORPHIC_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> MARBLE =           CELL_REGIONS.register("marble",            WorldCellRegion.newLayer(OVERWORLD_METAMORPHIC_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> QUARTZITE =        CELL_REGIONS.register("quartzite",         WorldCellRegion.newLayer(OVERWORLD_METAMORPHIC_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> HORNFELS =         CELL_REGIONS.register("hornfels",          WorldCellRegion.newLayer(OVERWORLD_METAMORPHIC_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SLATE =            CELL_REGIONS.register("slate",             WorldCellRegion.newLayer(OVERWORLD_METAMORPHIC_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_IGNEOUS_INTRUSIVE_MAP = CELL_REGION_MAPS.register("overworld_igneous_intrusive", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_IGNEOUS_INTRUSIVE, OVERWORLD_IGNEOUS_INTRUSIVE_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> GABBRO =           CELL_REGIONS.register("gabbro",            WorldCellRegion.newLayer(OVERWORLD_IGNEOUS_INTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SMOOTH_DIORITE =   CELL_REGIONS.register("smooth_diorite",    WorldCellRegion.newLayer(OVERWORLD_IGNEOUS_INTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SMOOTH_GRANITE =   CELL_REGIONS.register("smooth_granite",    WorldCellRegion.newLayer(OVERWORLD_IGNEOUS_INTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_DEEP_IGNEOUS_INTRUSIVE_MAP = CELL_REGION_MAPS.register("overworld_deep_igneous_intrusive", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_DEEP_IGNEOUS_INTRUSIVE, OVERWORLD_DEEP_IGNEOUS_INTRUSIVE_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> NORITE =           CELL_REGIONS.register("norite",            WorldCellRegion.newLayer(OVERWORLD_DEEP_IGNEOUS_INTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> PERIDOTITE =       CELL_REGIONS.register("peridotite",        WorldCellRegion.newLayer(OVERWORLD_DEEP_IGNEOUS_INTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_ASHFALL_MAP = CELL_REGION_MAPS.register("overworld_ashfall", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_ASHFALL, OVERWORLD_ASHFALL_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> SOFT_TUFF =        CELL_REGIONS.register("soft_tuff",         WorldCellRegion.newLayer(OVERWORLD_ASHFALL_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> IGNIMBRITE =       CELL_REGIONS.register("ignimbrite",        WorldCellRegion.newLayer(OVERWORLD_ASHFALL_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> LAPILLISTONE =     CELL_REGIONS.register("lapillistone",      WorldCellRegion.newLayer(OVERWORLD_ASHFALL_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> WELDED_TUFF =      CELL_REGIONS.register("welded_tuff",       WorldCellRegion.newLayer(OVERWORLD_ASHFALL_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE_MAP = CELL_REGION_MAPS.register("overworld_soft_igneous_extrusive", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_SOFT_IGNEOUS_EXTRUSIVE, OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> RHYOLITE =         CELL_REGIONS.register("rhyolite",          WorldCellRegion.newLayer(OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> DACITE =           CELL_REGIONS.register("dacite",            WorldCellRegion.newLayer(OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegionMap, WorldCellRegionMap> OVERWORLD_HARD_IGNEOUS_EXTRUSIVE_MAP = CELL_REGION_MAPS.register("overworld_hard_igneous_extrusive", WorldCellRegionMap.newCellMap(Level.OVERWORLD, WorldCellRegionRegistration::getCellRegion_StoneGen_Overworld, NoiseRegistration.NOISE_HARD_IGNEOUS_EXTRUSIVE, OVERWORLD_HARD_IGNEOUS_EXTRUSIVE_CONFIG));
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> ANDESITE =         CELL_REGIONS.register("andesite",          WorldCellRegion.newLayer(OVERWORLD_HARD_IGNEOUS_EXTRUSIVE_MAP.getKey()) );
    public static final DeferredHolder<WorldCellRegion, WorldCellRegion> BASALT =           CELL_REGIONS.register("basalt",            WorldCellRegion.newLayer(OVERWORLD_HARD_IGNEOUS_EXTRUSIVE_MAP.getKey()) );
}
