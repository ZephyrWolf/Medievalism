package io.github.zephyrwolf.medievalism.tools;

import com.mojang.datafixers.util.Function3;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

import static net.minecraft.world.level.BlockGetter.traverseBlocks;

public final class GeometryTools
{
    //region point
    private static double[] rotateY(double x, double z, double cos, double sin) {
        double newX = x * cos - z * sin;
        double newZ = x * sin + z * cos;
        return new double[] { newX, newZ };
    }
    //endregion

    //region AABB
    public static AABB rotateY(AABB aabb, double radians)
    {
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        // Rotate all four bottom corners
        double[][] corners = {
                rotateY(aabb.minX, aabb.minZ, cos, sin),
                rotateY(aabb.minX, aabb.maxZ, cos, sin),
                rotateY(aabb.maxX, aabb.minZ, cos, sin),
                rotateY(aabb.maxX, aabb.maxZ, cos, sin)
        };

        double minX = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double minZ = Double.POSITIVE_INFINITY;
        double maxZ = Double.NEGATIVE_INFINITY;

        for (double[] corner : corners) {
            minX = Math.min(minX, corner[0]);
            maxX = Math.max(maxX, corner[0]);
            minZ = Math.min(minZ, corner[1]);
            maxZ = Math.max(maxZ, corner[1]);
        }

        return new AABB(minX, aabb.minY, minZ, maxX, aabb.maxY, maxZ);
    }

    public static AABB applyRotation(AABB aabb, Direction facing)
    {
        double rotRad;
        switch (facing)
        {
            case EAST -> rotRad = Math.PI / 2.0;
            case SOUTH -> rotRad = Math.PI;
            case WEST -> rotRad = -Math.PI/2.0;
            default -> rotRad = 0.0;
        }
        return rotateY(aabb, rotRad);
    }

    public static AABB applyRotationToUnit(AABB aabb, Direction facing)
    {
        return applyRotation(aabb.move(-0.5, -0.5, -0.5), facing).move(0.5, 0.5, 0.5);
    }
    //endregion

    //region Raytrace: default clip behaviour
    public static HitResult raytraceBlockHitResult(@Nonnull Player player)
    { // Default Clip
        HitResult hitresult = player.pick(player.blockInteractionRange(), 0, false);
        Vec3 playerEye = player.getEyePosition();
        return limitHitResultToRange(hitresult, playerEye, player.blockInteractionRange());
    }

    private static HitResult limitHitResultToRange(HitResult pHitResult, Vec3 pPos, double pBlockInteractionRange) {
        Vec3 vec3 = pHitResult.getLocation();
        if (!vec3.closerThan(pPos, pBlockInteractionRange)) {
            Vec3 vec31 = pHitResult.getLocation();
            Direction direction = Direction.getNearest(vec31.x - pPos.x, vec31.y - pPos.y, vec31.z - pPos.z);
            return BlockHitResult.miss(vec31, direction, BlockPos.containing(vec31));
        } else {
            return pHitResult;
        }
    }
    //endregion

    //region Raytrace: filtered clip behaviour
    public enum ClipContextBlockFilter
    {
        PASS,
        FULL,
        EMPTY
    }

    public static BlockHitResult clipFiltered(Level level, ClipContext pContext, Function3<Level, BlockState, BlockPos, ClipContextBlockFilter> filter)
    { // Special Clip that allows filtering what will collide
        return traverseBlocks(pContext.getFrom(), pContext.getTo(), pContext, (clipContext, pos) -> {
            // Tester
            Vec3 fromVec = clipContext.getFrom();
            Vec3 toVec = clipContext.getTo();
            BlockState bState = level.getBlockState(pos);
            FluidState fState = level.getFluidState(pos);
            VoxelShape bShape = clipContext.getBlockShape(bState, level, pos);
            bShape = switch (filter.apply(level, bState, pos))
            {
                case ClipContextBlockFilter.PASS -> bShape;
                case ClipContextBlockFilter.FULL -> Shapes.block();
                case ClipContextBlockFilter.EMPTY -> Shapes.empty();
            };
            VoxelShape fShape = clipContext.getFluidShape(fState, level, pos);
            BlockHitResult bHitResult = level.clipWithInteractionOverride(fromVec, toVec, pos, bShape, bState);
            BlockHitResult fHitResult = fShape.clip(fromVec, toVec, pos);
            double bDistSqr = bHitResult == null ? Double.MAX_VALUE : clipContext.getFrom().distanceToSqr(bHitResult.getLocation());
            double fDistSqr = fHitResult == null ? Double.MAX_VALUE : clipContext.getFrom().distanceToSqr(fHitResult.getLocation());
            return bDistSqr <= fDistSqr ? bHitResult : fHitResult;
        }, clipContext -> {
            // On fail
            Vec3 vec3 = clipContext.getFrom().subtract(clipContext.getTo());
            return BlockHitResult.miss(clipContext.getTo(), Direction.getNearest(vec3.x, vec3.y, vec3.z), BlockPos.containing(clipContext.getTo()));
        });
    }

    public static boolean hasLineOfSightToBlock(Level pLevel, Vec3 fromPos, Vec3 toPos)
    {
        BlockHitResult result = clipFiltered(pLevel, new ClipContext(
                fromPos, toPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, CollisionContext.empty()),
                (level, bState, pos) ->
                        bState.isCollisionShapeFullBlock(level, pos) ?
                                ClipContextBlockFilter.PASS :
                                ClipContextBlockFilter.EMPTY);
        return result.getType() == HitResult.Type.MISS ||
                result.getBlockPos().equals(new BlockPos((int) toPos.x, (int) toPos.y, (int) toPos.z));
    }
    //endregion
}
