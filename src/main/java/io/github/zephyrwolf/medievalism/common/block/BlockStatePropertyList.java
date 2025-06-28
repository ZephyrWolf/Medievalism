package io.github.zephyrwolf.medievalism.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

public final class BlockStatePropertyList
{
    @MethodsReturnNonnullByDefault
    public static enum DryingBrickState implements StringRepresentable {
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
    }
}
