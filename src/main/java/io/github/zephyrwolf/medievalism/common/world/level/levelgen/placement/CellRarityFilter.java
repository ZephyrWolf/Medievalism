package io.github.zephyrwolf.medievalism.common.world.level.levelgen.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.zephyrwolf.medievalism.common.world.level.cell.WorldLayerCell;
import io.github.zephyrwolf.medievalism.common.world.level.layer.WorldLayer;
import io.github.zephyrwolf.medievalism.registration.RegistryRegistration;
import io.github.zephyrwolf.medievalism.registration.world.level.PlacementModifierRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class CellRarityFilter extends PlacementFilter
{
    public static final MapCodec<CellRarityFilter> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.fieldOf( "chance").forGetter(placement -> placement.chance),
            ResourceKey.codec(RegistryRegistration.WORLD_LAYERS).fieldOf("layer").forGetter(placement -> placement.layer),
            ResourceKey.codec(RegistryRegistration.LAYER_CELLS).fieldOf("variant").forGetter(placement -> placement.variant)
    ).apply(instance, CellRarityFilter::new));

    @Override
    public @NotNull PlacementModifierType<?> type() { return PlacementModifierRegistration.CELL.get(); }

    int chance;
    ResourceKey<WorldLayer> layer;
    ResourceKey<WorldLayerCell> variant;

    public CellRarityFilter(int chance, ResourceKey<WorldLayer> layer, ResourceKey<WorldLayerCell> variant)
    {
        this.chance = chance;
        this.layer = layer;
        this.variant = variant;
    }

    @Override
    protected boolean shouldPlace(@NotNull PlacementContext pContext, @NotNull RandomSource pRandom, @NotNull BlockPos pPos)
    {
        if (pRandom.nextFloat() >= 1.0F / (float)this.chance)
        {
            return false;
        } // Process the above first to save the expensive check below
        RandomState randomState = pContext.getLevel().getLevel().getChunkSource().randomState();
        ResourceKey<WorldLayerCell> variant = WorldLayer.getCellAt(randomState, pPos, layer);
        return this.variant == variant;
    }
}
