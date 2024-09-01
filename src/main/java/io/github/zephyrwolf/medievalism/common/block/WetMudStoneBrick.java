package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.content.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WetMudStoneBrick extends Block {
    protected static final VoxelShape BRICK_SHAPE_1000 = Block.box(2, 0, 1, 6, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_0100 = Block.box(10, 0, 1, 14, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_0010 = Block.box(2, 0, 9, 6, 3, 15);
    protected static final VoxelShape BRICK_SHAPE_0001 = Block.box(10, 0, 9, 14, 3, 15);

    protected final VoxelShape[] BRICK_SHAPES = new VoxelShape[16];

    @MethodsReturnNonnullByDefault
    public enum BrickState implements StringRepresentable {
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

    public static final EnumProperty<BrickState> BACK_LEFT = EnumProperty.create("back_left", BrickState.class);
    public static final EnumProperty<BrickState> BACK_RIGHT = EnumProperty.create("back_right", BrickState.class);
    public static final EnumProperty<BrickState> FRONT_LEFT = EnumProperty.create("front_left", BrickState.class);
    public static final EnumProperty<BrickState> FRONT_RIGHT = EnumProperty.create("front_right", BrickState.class);
    public static final EnumProperty<?>[] BRICK_PROPERTIES = new EnumProperty[]{BACK_LEFT, BACK_RIGHT, FRONT_LEFT, FRONT_RIGHT};

    protected final Supplier<ItemStack> ITEM_HOLDER;

    public WetMudStoneBrick(Properties props, Supplier<ItemStack> itemHolder) {
        super(props);
        registerDefaultState(getStateDefinition().any()
                .setValue(BACK_LEFT, BrickState.EMPTY)
                .setValue(BACK_LEFT, BrickState.EMPTY)
                .setValue(BACK_LEFT, BrickState.EMPTY)
                .setValue(BACK_LEFT, BrickState.EMPTY)
        );
        for (int i = 0; i < 16; i++) {
            VoxelShape shape1000 = (i & 0b1000) != 0 ? BRICK_SHAPE_1000 : Shapes.empty();
            VoxelShape shape0100 = (i & 0b0100) != 0 ? BRICK_SHAPE_0100 : Shapes.empty();
            VoxelShape shape0010 = (i & 0b0010) != 0 ? BRICK_SHAPE_0010 : Shapes.empty();
            VoxelShape shape0001 = (i & 0b0001) != 0 ? BRICK_SHAPE_0001 : Shapes.empty();
            VoxelShape shape1100 = Shapes.join(shape1000, shape0100, BooleanOp.OR);
            VoxelShape shape0011 = Shapes.join(shape0010, shape0001, BooleanOp.OR);
            VoxelShape shape1111 = Shapes.join(shape1100, shape0011, BooleanOp.OR);
            BRICK_SHAPES[i] = shape1111;
        }
        ITEM_HOLDER = itemHolder;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(BACK_LEFT)
                .add(BACK_RIGHT)
                .add(FRONT_LEFT)
                .add(FRONT_RIGHT);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (pStack.getItem() == BlockRegistration.WET_MUD_STONE_BRICK_ITEM.get()) {
            EnumProperty<BrickState> prop = null;
            if (pState.getValue(BACK_LEFT).isEmpty()) prop = BACK_LEFT;
            else if (pState.getValue(BACK_RIGHT).isEmpty()) prop = BACK_RIGHT;
            else if (pState.getValue(FRONT_LEFT).isEmpty()) prop = FRONT_LEFT;
            else if (pState.getValue(FRONT_RIGHT).isEmpty()) prop = FRONT_RIGHT;
            if (prop != null)
            {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(prop, BrickState.WET));
                if (!pPlayer.isCreative()) {
                    pStack.shrink(1);
                }
                return ItemInteractionResult.CONSUME_PARTIAL;
            }
        } else if (pPlayer.isCreative() && !pLevel.isClientSide) {
            randomTick(pState, (ServerLevel) pLevel, pPos, pLevel.getRandom());
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        List<ItemStack> items = super.getDrops(pState, pParams);
        for (EnumProperty<?> property : BRICK_PROPERTIES) {
            @SuppressWarnings("unchecked")
            BrickState state = pState.getValue((EnumProperty<BrickState>) property);
            if (state == BrickState.WET) items.add(new ItemStack(BlockRegistration.WET_MUD_STONE_BRICK_ITEM.get()));
            else if (state == BrickState.DRY) items.add(new ItemStack(ItemRegistration.MUD_STONE_BRICK.get()));
        }
        return items;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState()
                .setValue(BACK_LEFT, BrickState.WET);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        //int index = 0;
        //index |= pState.getValue(BACK_LEFT).isEmpty() ? 0 : 0b1000;
        //index |= pState.getValue(BACK_RIGHT).isEmpty() ? 0 : 0b0100;
        //index |= pState.getValue(FRONT_LEFT).isEmpty() ? 0 : 0b0010;
        //index |= pState.getValue(FRONT_RIGHT).isEmpty() ? 0 : 0b0001;
        //return BRICK_SHAPES[index];
        return Block.box(1, 0, 1, 15, 3, 15);
    }

    @Override
    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType) {
        return false;
    }

    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return true;
    }

    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }

    @Override // Random Tick
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        boolean isRaining = pLevel.isRaining();
        if (!isRaining && pLevel.getBrightness(LightLayer.SKY, pPos) > 10 && pLevel.isDay()) {
            //long timeOfDay = pLevel.dayTime();
            int index = pRandom.nextInt(4);
            @SuppressWarnings("unchecked")
            EnumProperty<BrickState> property = (EnumProperty<BrickState>) BRICK_PROPERTIES[index];
            BrickState state = pState.getValue(property);
            if (state == BrickState.WET) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, BrickState.DRY));
            }
        } else if (isRaining && pLevel.canSeeSky(pPos)) {
            int index = pRandom.nextInt(4);
            @SuppressWarnings("unchecked")
            EnumProperty<BrickState> property = (EnumProperty<BrickState>) BRICK_PROPERTIES[index];
            BrickState state = pState.getValue(property);
            if (state == BrickState.DRY) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, BrickState.WET));
            } else if (state == BrickState.WET && pRandom.nextInt(3) == 0) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, BrickState.EMPTY));
                pLevel.addFreshEntity(new ItemEntity(
                        pLevel,
                        pPos.getX() + 0.5f,
                        pPos.getY() + 0.5f,
                        pPos.getZ() + 0.5f,
                        ITEM_HOLDER.get()
                ));
            }
        }
    }
}
