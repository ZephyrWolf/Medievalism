package io.github.zephyrwolf.medievalism.tools;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public final class WarmthTools
{
    public static final int SKY_BRIGHTNESS_WARMTH = 11;

    //region Warmth
    public static float getWarmth(@NotNull Level pLevel, @NotNull BlockPos pPos)
    {
        float warmth = WarmthTools.getWarmthFromSky(pLevel, pPos);
        warmth += getWarmthFromWeather(pLevel);
        warmth += WarmthTools.getWarmthForSurroundingBlocks(pLevel, pPos);
        warmth += WarmthTools.getWarmthForBiome(pLevel, pPos);
        return warmth;
    }

    public static float getWarmthFromWeather(@NotNull Level pLevel)
    {
        float warmth = pLevel.isRaining() ? -1.0f : 0.0f;
        warmth -= pLevel.isThundering() ? 1.0f : 0.0f;
        return warmth;
    }

    public static float getWarmthFromSky(@NotNull Level pLevel, @NotNull BlockPos pPos)
    {
        float skyBrightness = pPos.getX() >= -30000000 && pPos.getZ() >= -30000000 && pPos.getX() < 30000000 && pPos.getZ() < 30000000
                ? (float) pLevel.getBrightness(LightLayer.SKY, pPos) - pLevel.getSkyDarken()
                : 15.0f; // This check is from the proper rawBrightness method. this bounds within lighting engine capabilities. We do this instead of calling raw because that takes the max of sky and block and I only want sky
        return Math.max(0.0f, skyBrightness - WarmthTools.SKY_BRIGHTNESS_WARMTH)/2.0f; //11-15 to 1,1,2,2,3
    }

    public static float getWarmthForBiome(@NotNull Level level, @NotNull BlockPos pos)
    {
        float warmth = 0;
        if (level.dimensionType().ultraWarm()) warmth++;
        if (level.getBiome(pos).is(Tags.Biomes.IS_HOT)) warmth++; // Nether will be 2
        if (level.getBiome(pos).is(Tags.Biomes.IS_COLD)) warmth--;
        return warmth;
    }

    public static float getWarmthForState(@NotNull BlockState bState, @NotNull FluidState fState)
    {
        if (bState.is(BlockTags.ICE)) return -1.0f;
        if (bState.is(BlockTags.CAMPFIRES) && bState.getValue(BlockStateProperties.LIT)) return 1.0f;
        if (bState.is(BlockTags.FIRE)) return 2.0f;
        if (bState.getBlock() == Blocks.LAVA) return 3.0f;
        if (fState.getFluidType() == Fluids.LAVA.getFluidType()) return 3.0f;
        if (fState.getFluidType() == Fluids.FLOWING_LAVA.getFluidType()) return 3.0f;
        return 0;
    }

    public static int getWarmthForSurroundingBlocks(@NotNull Level level, @NotNull BlockPos mePos)
    {
        Vec3 meVec = new Vec3(mePos.getX() + 0.5, mePos.getY() + 0.5, mePos.getZ() + 0.5);
        final int RANGE = 3;
        BlockPos.MutableBlockPos scanPos = new BlockPos.MutableBlockPos();
        int maxWarmth = 0;
        int minWarmth = 0;
        for (int dx = -RANGE; dx <= RANGE; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -RANGE; dz <= RANGE; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) continue;
                    scanPos.set(mePos.getX() + dx, mePos.getY() + dy, mePos.getZ() + dz);
                    BlockState bState = level.getBlockState(scanPos);
                    FluidState fState = level.getFluidState(scanPos);

                    float blockWarmth = getWarmthForState(bState, fState);
                    if (blockWarmth > 0)
                    {
                        Vec3 scanVec = meVec.add(dx, dy, dz);
                        if (GeometryTools.hasLineOfSightToBlock(level, meVec, scanVec.add(dx, dy, dz)))
                        {
                            float distanceCorrectBlockWarmth = blockWarmth - (int) Math.floor(meVec.distanceTo(scanVec)) + 1;
                            maxWarmth = Math.max(maxWarmth, (int) Math.floor(distanceCorrectBlockWarmth));
                        }
                    }
                    else if (blockWarmth < 0)
                    {
                        Vec3 scanVec = meVec.add(dx, dy, dz);
                        if (GeometryTools.hasLineOfSightToBlock(level, meVec, scanVec.add(dx, dy, dz)))
                        { // This needs testing
                            float distanceCorrectBlockWarmth = blockWarmth + (int) Math.floor(meVec.distanceTo(scanVec)) -1;
                            minWarmth = Math.min(minWarmth, (int) Math.floor(distanceCorrectBlockWarmth));
                        }
                    }
                }
            }
        }

        return maxWarmth + minWarmth; // Penalty for being near ice
    }
    //endregion

    //region Warming
    public static final float DEFAULT_WARMING_CHANCE = 1.0f;

    @SuppressWarnings("unused")
    public static boolean canWarm(RandomSource rand, float baseWarmingChance, float warmth)
    {
        float warmingChance = baseWarmingChance - warmth;
        if (warmingChance > 0)
        {
            return rand.nextFloat() < (1.0f / warmingChance);
        }
        return false;
    }

    public static boolean canWarm(Level level, BlockPos pos, float baseWarmingChance)
    {
        float warmingChance = baseWarmingChance - getWarmth(level, pos);
        if (warmingChance > 0)
        {
            return level.getRandom().nextFloat() < (1.0f / warmingChance);
        }
        return false;
    }
    //endregion

    //region Block State Properties
    public static final BooleanProperty IS_DRY = BooleanProperty.create("is_dry");
    public static boolean isDry(BlockState state)
    {
        return state.getValue(IS_DRY);
    }

    @MethodsReturnNonnullByDefault
    public enum DryingBrickState implements StringRepresentable
    {
        EMPTY,
        WET,
        DRY;

        @Override
        public String getSerializedName() {
            return switch (this) {
                case EMPTY -> "empty";
                case WET -> "wet";
                case DRY -> "dry";
            };
        }

        public boolean isEmpty() {
            return this == EMPTY;
        }
        public boolean isDry() { return this == DRY; }
        public boolean isWet() { return this == WET; }
    }
    //endregion
}
