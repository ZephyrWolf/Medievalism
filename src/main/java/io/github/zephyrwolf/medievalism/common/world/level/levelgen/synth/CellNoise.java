package io.github.zephyrwolf.medievalism.common.world.level.levelgen.synth;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public final class CellNoise
{
    private record WorldPoint(int x, int z)
    {
        public float distance(WorldPoint other)
        {
            float dx = other.x - x;
            float dz = other.z - z;
            return (float) Math.sqrt(dx * dx + dz * dz);
        }
    }

    private record CellPoint(int cx, int cz) { }

    private static CellNoise.WorldPoint WarpPoint(NormalNoise noise, float warp, int boarderThickness, BlockPos pos)
    {
        double wx = pos.getX() + (noise.getValue(
                pos.getX() * warp,
                pos.getY() * warp,
                pos.getZ() * warp) - 0.5) * boarderThickness;
        double wz = pos.getZ() + (noise.getValue(
                pos.getX() * warp + 1000,
                pos.getY() * warp + 1000,
                pos.getZ() * warp + 1000) - 0.5) * boarderThickness;
        return new CellNoise.WorldPoint((int) wx, (int) wz);
    }

    private static CellNoise.CellPoint getCellPoint(float cellSize, CellNoise.WorldPoint pt )
    {
        int cellX = (int) Math.floor(pt.x() / cellSize);
        int cellZ = (int) Math.floor(pt.z() / cellSize);
        return new CellNoise.CellPoint(cellX, cellZ);
    }

    private static CellNoise.WorldPoint GetWorldPoint(NormalNoise noise, float cellSize, CellNoise.CellPoint cell)
    {
        float x = cell.cx() * cellSize
                + (float) noise.getValue(cell.cx(), 0, cell.cz()) * cellSize;
        float z = cell.cz() * cellSize
                + (float) noise.getValue(cell.cx() + cellSize * 10, 0, cell.cz() + cellSize * 10) * cellSize;
        return new CellNoise.WorldPoint((int) x, (int) z);
    }

    private static long hash(int cellX, int cellY)
    {
        long h = 0x9E41567D46B94A7CL;
        h ^= cellX * 0x9E3779B97F4A7C15L;
        h ^= cellY * 0xC2B2AE3D27D4EB4FL;
        h ^= h >>> 30;
        h *= 0xBF58476D1CE4E5B9L;
        h ^= h >>> 27;
        h *= 0x94D049BB133111EBL;
        h ^= h >>> 31;
        return h;
    }

    public static long noise(NormalNoise noise, int cellSize, float warp, int boarderThickness, BlockPos oPos)
    {
        CellNoise.WorldPoint wpt = CellNoise.WarpPoint(noise, warp, boarderThickness, oPos);
        CellNoise.CellPoint originCellPt = getCellPoint(cellSize, wpt);
        float minDistance = Float.MAX_VALUE;
        CellNoise.WorldPoint bestPt = new CellNoise.WorldPoint(0, 0);
        for (int cxd = -1; cxd < 2; cxd++)
        {
            for (int czd = -1; czd < 2; czd++)
            {
                CellNoise.CellPoint offsetCellPt = new CellNoise.CellPoint(originCellPt.cx() + cxd, originCellPt.cz() + czd);
                CellNoise.WorldPoint cellOriginPt = GetWorldPoint(noise, cellSize, offsetCellPt);
                float distance = wpt.distance( cellOriginPt );
                if (distance < minDistance)
                {
                    minDistance = distance;
                    bestPt = cellOriginPt;
                }
            }
        }
        return hash(bestPt.x(), bestPt.z());
    }
}
