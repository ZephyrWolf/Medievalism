package io.github.zephyrwolf.medievalism.common.block;

import com.mojang.serialization.MapCodec;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.loot.LootContextParamSetRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import io.github.zephyrwolf.medievalism.common.block.BlockStatePropertyList.DryingBrickState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.stream.IntStream;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DryingBrick extends Block {
    public static MapCodec<DryingBrick> CODEC = simpleCodec(DryingBrick::new);

    protected static final int DEFAULT_CHANCE = 1;
    int dryingChance = DEFAULT_CHANCE;

    protected static final VoxelShape BRICK_SHAPE_BACK_LEFT = Block.box(2, 0, 1, 6, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_BACK_RIGHT = Block.box(10, 0, 1, 14, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_FRONT_LEFT = Block.box(2, 0, 9, 6, 3, 15);
    protected static final VoxelShape BRICK_SHAPE_FRONT_RIGHT = Block.box(10, 0, 9, 14, 3, 15);
    protected static final VoxelShape[] BRICK_SHAPES = makeShapes();

    private static VoxelShape[] makeShapes()
    {
        return IntStream.range(0, 16)
                .mapToObj(DryingBrick::makeShape)
                .toArray(VoxelShape[]::new);
    }
    private static VoxelShape makeShape(int pBitfield)
    {
        if (pBitfield == 0) return Shapes.box(2, 0, 1, 14, 3, 15);

        VoxelShape voxelshape = Shapes.empty();
        if ((pBitfield & 1) != 0) {
            voxelshape = Shapes.or(voxelshape, DryingBrick.BRICK_SHAPE_FRONT_RIGHT);
        }

        if ((pBitfield & 2) != 0) {
            voxelshape = Shapes.or(voxelshape, DryingBrick.BRICK_SHAPE_FRONT_LEFT);
        }

        if ((pBitfield & 4) != 0) {
            voxelshape = Shapes.or(voxelshape, DryingBrick.BRICK_SHAPE_BACK_RIGHT);
        }

        if ((pBitfield & 8) != 0) {
            voxelshape = Shapes.or(voxelshape, DryingBrick.BRICK_SHAPE_BACK_LEFT);
        }

        return voxelshape;
    }

    public static final EnumProperty<DryingBrickState> BACK_LEFT = EnumProperty.create("back_left", DryingBrickState.class);
    public static final EnumProperty<DryingBrickState> BACK_RIGHT = EnumProperty.create("back_right", DryingBrickState.class);
    public static final EnumProperty<DryingBrickState> FRONT_LEFT = EnumProperty.create("front_left", DryingBrickState.class);
    public static final EnumProperty<DryingBrickState> FRONT_RIGHT = EnumProperty.create("front_right", DryingBrickState.class);
    public static final EnumProperty<?>[] BRICK_PROPERTIES = new EnumProperty[]{BACK_LEFT, BACK_RIGHT, FRONT_LEFT, FRONT_RIGHT};

    public DryingBrick(Properties props)
    {
        this(props, DEFAULT_CHANCE);
    }

    public DryingBrick(Properties props, int chance)
    {
        super(props);
        dryingChance = chance;
        registerDefaultState(getStateDefinition().any()
                .setValue(BACK_LEFT, DryingBrickState.EMPTY)
                .setValue(BACK_LEFT, DryingBrickState.EMPTY)
                .setValue(BACK_LEFT, DryingBrickState.EMPTY)
                .setValue(BACK_LEFT, DryingBrickState.EMPTY)
        );
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

    public ItemInteractionResult useItemOnNext(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos)
    {
        if (pState.getBlock() != this) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        EnumProperty<DryingBrickState> prop = null;
        if (pState.getValue(BACK_LEFT).isEmpty()) prop = BACK_LEFT;
        else if (pState.getValue(BACK_RIGHT).isEmpty()) prop = BACK_RIGHT;
        else if (pState.getValue(FRONT_LEFT).isEmpty()) prop = FRONT_LEFT;
        else if (pState.getValue(FRONT_RIGHT).isEmpty()) prop = FRONT_RIGHT;
        if (prop != null)
        {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(prop, DryingBrickState.WET));
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        ItemInteractionResult result = useItemOnNext(pStack, pState, pLevel, pPos);
        if (result == ItemInteractionResult.SUCCESS)
        {
            if (pPlayer instanceof ServerPlayer)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)pPlayer, pPos, pStack);
            }
            SoundType soundtype = pState.getSoundType(pLevel, pPos, pPlayer);
            pLevel.playSound(
                    pPlayer,
                    pPos,
                    getSoundType(pState, pLevel, pPos, pPlayer).getPlaceSound(),
                    SoundSource.BLOCKS,
                    (soundtype.getVolume() + 1.0F) / 2.0F,
                    soundtype.getPitch() * 0.8F
            );
            pLevel.gameEvent(GameEvent.BLOCK_PLACE, pPos, GameEvent.Context.of(pPlayer, pState));
            pStack.consume(1, pPlayer);
            return result;
        }
        if (result == ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) {
            return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
        }
        return result;
    }

    @Override
    protected List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        List<ItemStack> items = super.getDrops(pState, pParams);
        for (EnumProperty<?> property : BRICK_PROPERTIES) {
            @SuppressWarnings("unchecked")
            DryingBrickState state = pState.getValue((EnumProperty<DryingBrickState>) property);
            if (state == DryingBrickState.WET)
                items.add(new ItemStack(BlockItemRegistration.WET_PACKED_MUD_BRICK.get()));
            else if (state == DryingBrickState.DRY)
                items.add(new ItemStack(ItemRegistration.PACKED_MUD_BRICK.get()));
        }
        return items;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState()
                .setValue(BACK_LEFT, DryingBrickState.WET);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return BRICK_SHAPES[getShapeIndex(pState)];
    }

    private int getShapeIndex(BlockState pState)
    {
        int index = 0;
        if (!pState.getValue(BACK_LEFT).isEmpty()) index |= 0b1000;
        if (!pState.getValue(BACK_RIGHT).isEmpty()) index |= 0b0100;
        if (!pState.getValue(FRONT_LEFT).isEmpty()) index |= 0b0010;
        if (!pState.getValue(FRONT_RIGHT).isEmpty()) index |= 0b0001;
        return index;
    }

    @Override
    public boolean hasDynamicShape() {
        return true;
    }

    @Override
    protected VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return super.getInteractionShape(pState, pLevel, pPos);
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
            EnumProperty<DryingBrickState> property = (EnumProperty<DryingBrickState>) BRICK_PROPERTIES[index];
            DryingBrickState state = pState.getValue(property);
            int chance = pRandom.nextInt(DEFAULT_CHANCE);
            if (state == DryingBrickState.WET && chance == 0) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, DryingBrickState.DRY));
            }
        } else if (isRaining && pLevel.canSeeSky(pPos)) {
            int index = pRandom.nextInt(4);
            @SuppressWarnings("unchecked")
            EnumProperty<DryingBrickState> property = (EnumProperty<DryingBrickState>) BRICK_PROPERTIES[index];
            DryingBrickState state = pState.getValue(property);
            if (state == DryingBrickState.DRY) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, DryingBrickState.WET));
            } else if (state == DryingBrickState.WET && pRandom.nextInt(3) == 0) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(property, DryingBrickState.EMPTY));

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
