package io.github.zephyrwolf.medievalism.common.malleablematerial;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.zephyrwolf.medievalism.content.MalleableMaterialRegistration;
import io.github.zephyrwolf.medievalism.content.RegistryRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public record MalleableMaterial(MalleableMaterialType material, int rows, int cols, List<Boolean> pattern)
{
    public static final MapCodec<MalleableMaterial> CODEC =
            RecordCodecBuilder.mapCodec(inst -> inst.group(
                    MalleableMaterialType.CODEC.fieldOf("material").forGetter(MalleableMaterial::getMaterialHolder),
                    ExtraCodecs.intRange(1, 9).fieldOf("rows").orElse(1).forGetter(MalleableMaterial::rows),
                    ExtraCodecs.intRange(1, 9).fieldOf("cols").orElse(1).forGetter(MalleableMaterial::cols),
                    Codec.BOOL.listOf().fieldOf("pattern").forGetter(MalleableMaterial::pattern)
            ).apply(inst, MalleableMaterial::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, MalleableMaterial> STREAM_CODEC = new StreamCodec<>()
    {
        public MalleableMaterial decode(RegistryFriendlyByteBuf buf) {
            int rows = buf.readVarInt();
            if (rows <= 0)
            {
                return MalleableMaterial.EMPTY.get();
            }
            else
            {
                int cols = buf.readVarInt();
                List<Boolean> pattern = new ArrayList<>(rows * cols);
                for (int i = 0; i < rows * cols; i++)
                {
                    pattern.add(buf.readBoolean());
                }
                Holder<MalleableMaterialType> holder = MalleableMaterialType.STREAM_CODEC.decode(buf);
                return new MalleableMaterial(holder, rows, cols, pattern);
            }
        }

        public void encode(RegistryFriendlyByteBuf buf, MalleableMaterial shape)
        {
            if (shape.isEmpty())
            {
                buf.writeVarInt(0);
            }
            else {
                buf.writeVarInt(shape.rows());
                buf.writeVarInt(shape.cols());
                for (int i = 0; i < shape.rows() * shape.cols(); i++) {
                    buf.writeBoolean(shape.pattern.get(i));
                }
                MalleableMaterialType.STREAM_CODEC.encode(buf, shape.getMaterialHolder());
            }
        }
    };

    public static final Supplier<MalleableMaterial> EMPTY = () -> new MalleableMaterial(MalleableMaterialRegistration.AIR.get(), 0, 0, List.of());

    public MalleableMaterial(Holder<MalleableMaterialType> holder, int rows, int cols, List<Boolean> pattern)
    {
        this(holder.value(), rows, cols, pattern);
    }

    public static CompoundTag serializeNBT(MalleableMaterial material, HolderLookup.Provider pRegistries)
    {
        CompoundTag tag = new CompoundTag();
        tag.putString("material", Objects.requireNonNull(material.getMaterialHolder().getKey()).location().toString());
        tag.putInt("rows", material.rows());
        tag.putInt("cols", material.cols());
        tag.putIntArray("pattern", material.pattern().stream().map(val -> val ? 1 : 0).toList());
        return tag;
    }

    @Nullable
    public static MalleableMaterial deserializeNBT(CompoundTag tag)
    {
        String strResource = tag.getString("material");
        ResourceLocation location = ResourceLocation.bySeparator(strResource, ':');
        MalleableMaterialType type = RegistryRegistration.MATERIALS_REGISTRY.get(location);
        if (type == null) return null;
        int rows = tag.getInt("rows");
        int cols = tag.getInt("cols");
        int[] array = tag.getIntArray("pattern");
        List<Boolean> pattern = new ArrayList<>(rows * cols);
        for (int i = 0; i < rows * cols; i++)
        {
            pattern.add(array[i] == 1);
        }
        return new MalleableMaterial(type, rows, cols, pattern);
    }

    public MalleableMaterial copy()
    {
        return new MalleableMaterial(material, rows, cols, new ArrayList<>(pattern));
    }

    public Holder<MalleableMaterialType> getMaterialHolder()
    {
        return this.material().builtInRegistryHolder();
    }

    public boolean is(MalleableMaterialType pMaterial) { return material() == pMaterial; }

    public boolean isEmpty()
    {
        return is(MalleableMaterialRegistration.AIR.get()) || rows() * cols() <= 0;
    }

    public MalleableMaterial trim()
    {
        // intentionally reversed so they will be updated.
        int minRow = rows-1;
        int maxRow = 0;
        int minCol = cols-1;
        int maxCol = 0;
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                int index = row * cols + col;
                if (pattern.get(index))
                {
                    minRow = Math.min(minRow, row);
                    maxRow = Math.max(maxRow, row);
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);
                }
            }
        }
        if (minRow != 0 || maxRow != rows-1 || minCol != 0 || maxCol != cols-1)
        {
            List<Boolean> subPattern = subRegion(minRow, minCol,  maxRow - minRow + 1, maxCol - minCol + 1);
            return new MalleableMaterial(material, maxRow - minRow + 1, maxCol - minCol + 1, subPattern);
        }
        return this;
    }

    public List<Boolean> subRegion(int row0, int col0, int rows, int cols)
    {
        rows = Math.min(rows, this.cols - row0);
        cols = Math.min(cols, this.cols - col0);
        List<Boolean> subPattern = new ArrayList<>(rows * cols);
        for (int drow = 0; drow < rows; drow++)
        {
            for (int dcol = 0; dcol < cols; dcol++)
            {
                int row = row0 + drow;
                int col = col0 + dcol;
                int index = row * this.cols + col;
                subPattern.add(pattern.get(index));
            }
        }
        return subPattern;
    }
}


