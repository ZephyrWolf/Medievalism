package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.loot.LootContextParamSetRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
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

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WetPackedMudBrick extends Block {
    public static MapCodec<WetPackedMudBrick> CODEC = simpleCodec(WetPackedMudBrick::new);

    protected static final VoxelShape BRICK_SHAPE_1000 = Block.box(2, 0, 1, 6, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_0100 = Block.box(10, 0, 1, 14, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_0010 = Block.box(2, 0, 9, 6, 3, 15);
    protected static final VoxelShape BRICK_SHAPE_0001 = Block.box(10, 0, 9, 14, 3, 15);

    protected final VoxelShape[] BRICK_SHAPES = new VoxelShape[16];

    @MethodsReturnNonnullByDefault
    public enum PackedMudBrickState implements StringRepresentable {
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

    public static final EnumProperty<PackedMudBrickState> BACK_LEFT = EnumProperty.create("back_left", PackedMudBrickState.class);
    public static final EnumProperty<PackedMudBrickState> BACK_RIGHT = EnumProperty.create("back_right", PackedMudBrickState.class);
    public static final EnumProperty<PackedMudBrickState> FRONT_LEFT = EnumProperty.create("front_left", PackedMudBrickState.class);
    public static final EnumProperty<PackedMudBrickState> FRONT_RIGHT = EnumProperty.create("front_right", PackedMudBrickState.class);
    public static final EnumProperty<?>[] BRICK_PROPERTIES = new EnumProperty[]{BACK_LEFT, BACK_RIGHT, FRONT_LEFT, FRONT_RIGHT};

    public WetPackedMudBrick(Properties props) {
        super(props);
        registerDefaultState(getStateDefinition().any()
                .setValue(BACK_LEFT, PackedMudBrickState.EMPTY)
                .setValue(BACK_LEFT, PackedMudBrickState.EMPTY)
                .setValue(BACK_LEFT, PackedMudBrickState.EMPTY)
                .setValue(BACK_LEFT, PackedMudBrickState.EMPTY)
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
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
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
        if (pStack.getItem() == ItemRegistration.WET_PACKED_MUD_BRICK_ITEM.get()) {
            EnumProperty<PackedMudBrickState> prop = null;
            if (pState.getValue(BACK_LEFT).isEmpty()) prop = BACK_LEFT;
            else if (pState.getValue(BACK_RIGHT).isEmpty()) prop = BACK_RIGHT;
            else if (pState.getValue(FRONT_LEFT).isEmpty()) prop = FRONT_LEFT;
            else if (pState.getValue(FRONT_RIGHT).isEmpty()) prop = FRONT_RIGHT;
            if (prop != null) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(prop, PackedMudBrickState.WET));
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
            PackedMudBrickState state = pState.getValue((EnumProperty<PackedMudBrickState>) property);
            if (state == PackedMudBrickState.WET)
                items.add(new ItemStack(ItemRegistration.WET_PACKED_MUD_BRICK_ITEM.get()));
            else if (state == PackedMudBrickState.DRY)
                items.add(new ItemStack(ItemRegistration.PACKED_MUD_BRICK.get()));
        }
        return items;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState()
                .setValue(BACK_LEFT, PackedMudBrickState.WET);
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

    private ResourceKey<LootTable> _ruinedLootTableKeyCache = null;

    public ResourceKey<LootTable> getOrCreateRuinedLootTable() {
        if (_ruinedLootTableKeyCache == null) {
            var key = BuiltInRegistries.BLOCK.getKey(this);
            ResourceLocation rl = MedievalismConstants.resource("ruined_" + key.getPath())
                    .withPrefix("additional_drops/");
            _ruinedLootTableKeyCache = ResourceKey.create(Registries.LOOT_TABLE, rl);
        }
        return _ruinedLootTableKeyCache;
    }

    @Override // Random Tick
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        boolean isRaining = pLevel.isRaining();
        if (!isRaining && pLevel.getBrightness(LightLayer.SKY, pPos) > 10 && pLevel.isDay()) {
            //long timeOfDay = pLevel.dayTime();
            int index = pRandom.nextInt(4);
            @SuppressWarnings("unchecked")
            EnumProperty<PackedMudBrickState> property = (EnumProperty<PackedMudBrickState>) BRICK_PROPERTIES[index];
            PackedMudBrickState state = pState.getValue(property);
            if (state == PackedMudBrickState.WET) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, PackedMudBrickState.DRY));
            }
        } else if (isRaining && pLevel.canSeeSky(pPos)) {
            int index = pRandom.nextInt(4);
            @SuppressWarnings("unchecked")
            EnumProperty<PackedMudBrickState> property = (EnumProperty<PackedMudBrickState>) BRICK_PROPERTIES[index];
            PackedMudBrickState state = pState.getValue(property);
            if (state == PackedMudBrickState.DRY) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, PackedMudBrickState.WET));
            } else if (state == PackedMudBrickState.WET && pRandom.nextInt(3) == 0) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, PackedMudBrickState.EMPTY));

                LootParams.Builder pParams = new LootParams.Builder(pLevel);
                LootParams lootParams = pParams
                        .withParameter(LootContextParams.BLOCK_STATE, pState)
                        .withParameter(LootContextParams.ORIGIN, new Vec3(pPos.getX() + 0.5f, pPos.getY() + 0.5f, pPos.getZ() + 0.5f))
                        .create(LootContextParamSetRegistration.ADDITIONAL_DROPS);
                ResourceKey<LootTable> resourceKey = getOrCreateRuinedLootTable();
                LootTable loottable = pLevel.getServer().reloadableRegistries().getLootTable(resourceKey);
                var items = loottable.getRandomItems(lootParams);

                for (ItemStack item : items) {
                    pLevel.addFreshEntity(new ItemEntity(
                            pLevel,
                            pPos.getX() + 0.5f,
                            pPos.getY() + 0.5f,
                            pPos.getZ() + 0.5f,
                            item
                    ));
                }
            }
        }
    }
}
