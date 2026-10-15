package io.github.zephyrwolf.medievalism.registration.world.level;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class LayerCellRegistration
{
    public static final DeferredRegister<WorldLayerCell> CELLS = DeferredRegister.create(
            RegistryRegistration.LAYER_CELLS, MedievalismConstants.MOD_ID);
    public static void register(IEventBus modEventBus) { CELLS.register(modEventBus); }

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> NONE =             CELLS.register("none",              WorldLayerCell.newLayer(WorldLayersRegistration.NONE_LAYER.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> LATERITE =         CELLS.register("laterite",          WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_REGOLITH.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SAPROLITE =        CELLS.register("saprolite",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_REGOLITH.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SILT =             CELLS.register("silt",              WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_REGOLITH.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> GREYWACKE =        CELLS.register("greywacke",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SILTSTONE =        CELLS.register("siltstone",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> DOLOSTONE =        CELLS.register("dolostone",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> LIMESTONE =        CELLS.register("limestone",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> IRONSTONE =        CELLS.register("ironstone",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SHALE =            CELLS.register("shale",             WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> ARKOSE =           CELLS.register("arkose",            WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SEDIMENTARY.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> MARBLE =           CELLS.register("marble",            WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> QUARTZITE =        CELLS.register("quartzite",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> HORNFELS =         CELLS.register("hornfels",          WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SLATE =            CELLS.register("slate",             WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_METAMORPHIC.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> GABBRO =           CELLS.register("gabbro",            WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SMOOTH_DIORITE =   CELLS.register("smooth_diorite",    WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SMOOTH_GRANITE =   CELLS.register("smooth_granite",    WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_IGNEOUS_INTRUSIVE.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> NORITE =           CELLS.register("norite",            WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> PERIDOTITE =       CELLS.register("peridotite",        WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_DEEP_IGNEOUS_INTRUSIVE.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> SOFT_TUFF =        CELLS.register("soft_tuff",         WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> IGNIMBRITE =       CELLS.register("ignimbrite",        WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> LAPILLISTONE =     CELLS.register("lapillistone",      WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> WELDED_TUFF =      CELLS.register("welded_tuff",       WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_ASHFALL.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> RHYOLITE =         CELLS.register("rhyolite",          WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> DACITE =           CELLS.register("dacite",            WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_SOFT_IGNEOUS_EXTRUSIVE.getKey()) );

    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> ANDESITE =         CELLS.register("andesite",          WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE.getKey()) );
    public static final DeferredHolder<WorldLayerCell, WorldLayerCell> BASALT =           CELLS.register("basalt",            WorldLayerCell.newLayer(WorldLayersRegistration.OVERHAUL_OVERWORLD_HARD_IGNEOUS_EXTRUSIVE.getKey()) );
}
