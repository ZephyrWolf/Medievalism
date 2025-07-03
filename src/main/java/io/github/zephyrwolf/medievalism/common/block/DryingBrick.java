package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.loot.LootContextParamSetRegistration;
import io.github.zephyrwolf.medievalism.tools.GeometryTools;
import io.github.zephyrwolf.medievalism.tools.WarmthTools;
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
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DryingBrick extends Block
{
    float baseDryingChance;

    public DryingBrick(Properties props, SoundType drySound, float chance)
    {
        super(props);
        this.drySound = drySound;
        baseDryingChance = chance;
        registerDefaultState(getStateDefinition().any()
                .setValue(BACK_LEFT, WarmthTools.DryingBrickState.EMPTY)
                .setValue(BACK_LEFT, WarmthTools.DryingBrickState.EMPTY)
                .setValue(BACK_LEFT, WarmthTools.DryingBrickState.EMPTY)
                .setValue(BACK_LEFT, WarmthTools.DryingBrickState.EMPTY)
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
        );
    }

    //region Sounds
    SoundType drySound;

    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity)
    {
        if (entity instanceof Player) {
            int index = raytraceBrickIndex(state, pos, (Player) entity);
            if (index != -1) {
                EnumProperty<WarmthTools.DryingBrickState> prop = BRICK_PROPERTIES[index];
                if (state.getValue(prop).isDry()) {
                    return drySound;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                EnumProperty<WarmthTools.DryingBrickState> prop = BRICK_PROPERTIES[i];
                if (state.getValue(prop).isWet()) {
                    break;
                }
            }
            return drySound;
        }
        return super.getSoundType(state, level, pos, entity);
    }
    //endregion

    //region Interaction
    public int raytraceBrickIndex(BlockState state, BlockPos pos, @Nonnull Player player)
    {
        HitResult hitresult = GeometryTools.raytraceBlockHitResult(player);
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            Vec3 target = hitresult.getLocation();
            if (pos.getX() == Math.floor(target.x()) &&
                    pos.getY() == Math.floor(target.y()) &&
                    pos.getZ() == Math.floor(target.z())
            ) { // Not entirely necessary but the safety is nice
                for (int i = 0; i < 4; i++) {
                    AABB aabb = BRICK_BBS[dir.get2DDataValue()][i].move(pos);
                    if (aabb.contains(target)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public ItemInteractionResult tryPlaceAdditionalBrick(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, @Nullable Player pPlayer)
    {
        ItemInteractionResult result = ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (pState.getBlock() == this && pState.getBlock().asItem() == pStack.getItem() && pState.getBlock() instanceof DryingBrick) {
            EnumProperty<WarmthTools.DryingBrickState> prop = null;
            for (int i = 0; i < 4; i++) {
                if (pState.getValue(BRICK_PROPERTIES[i]).isEmpty()) {
                    prop = BRICK_PROPERTIES[i];
                }
            }
            if (prop != null) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(prop, WarmthTools.DryingBrickState.WET));
                result = ItemInteractionResult.SUCCESS;
            }
        }
        if (result == ItemInteractionResult.SUCCESS) {
            if (pPlayer != null)
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
            }
            return ItemInteractionResult.SUCCESS;
        }
        return result;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult)
    {
        if (pPlayer.isCreative() && pStack.isEmpty() && pLevel instanceof ServerLevel)
        {
            randomTick(pState, (ServerLevel) pLevel, pPos, pLevel.random);
            return ItemInteractionResult.SUCCESS;
        }
        ItemInteractionResult result = tryPlaceAdditionalBrick(pStack, pState, pLevel, pPos, pPlayer);

        if (result == ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) {
            return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
        }
        return result;
    }
    //endregion

    //region State
    public static final EnumProperty<WarmthTools.DryingBrickState> BACK_LEFT = EnumProperty.create("back_left", WarmthTools.DryingBrickState.class);
    public static final EnumProperty<WarmthTools.DryingBrickState> BACK_RIGHT = EnumProperty.create("back_right", WarmthTools.DryingBrickState.class);
    public static final EnumProperty<WarmthTools.DryingBrickState> FRONT_LEFT = EnumProperty.create("front_left", WarmthTools.DryingBrickState.class);
    public static final EnumProperty<WarmthTools.DryingBrickState> FRONT_RIGHT = EnumProperty.create("front_right", WarmthTools.DryingBrickState.class);
    @SuppressWarnings("unchecked")
    public static final EnumProperty<WarmthTools.DryingBrickState>[] BRICK_PROPERTIES = new EnumProperty[]{BACK_LEFT, BACK_RIGHT, FRONT_LEFT, FRONT_RIGHT};

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder
                .add(BACK_LEFT)
                .add(BACK_RIGHT)
                .add(FRONT_LEFT)
                .add(FRONT_RIGHT)
                .add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        return defaultBlockState()
                .setValue(BACK_LEFT, WarmthTools.DryingBrickState.WET)
                .setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection());
    }
    //endregion

    //region Block Behaviour
    @Override
    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType)
    {
        return false;
    }

    @Override
    protected float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos)
    {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos)
    {
        return true;
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }
    //endregion

    //region Shape
    protected static final VoxelShape BRICK_SHAPE_BACK_LEFT = Block.box(2, 0, 1, 6, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_BACK_RIGHT = Block.box(10, 0, 1, 14, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_FRONT_LEFT = Block.box(2, 0, 9, 6, 3, 15);
    protected static final VoxelShape BRICK_SHAPE_FRONT_RIGHT = Block.box(10, 0, 9, 14, 3, 15);

    protected static final VoxelShape BRICK_SHAPE_BACK_LEFT_ROT = Block.box(9, 0, 2, 15, 3, 6);
    protected static final VoxelShape BRICK_SHAPE_BACK_RIGHT_ROT = Block.box(9, 0, 10, 15, 3, 14);
    protected static final VoxelShape BRICK_SHAPE_FRONT_LEFT_ROT = Block.box(1, 0, 2, 7, 3, 6);
    protected static final VoxelShape BRICK_SHAPE_FRONT_RIGHT_ROT = Block.box(1, 0, 10, 7, 3, 14);

    protected static final VoxelShape[] BRICK_SHAPES_N = makeShapes(Direction.NORTH);
    protected static final VoxelShape[] BRICK_SHAPES_E = makeShapes(Direction.EAST);
    protected static final VoxelShape[] BRICK_SHAPES_S = makeShapes(Direction.SOUTH);
    protected static final VoxelShape[] BRICK_SHAPES_W = makeShapes(Direction.WEST);
    protected static final VoxelShape[][] BRICK_SHAPES = new VoxelShape[][]{BRICK_SHAPES_S, BRICK_SHAPES_W, BRICK_SHAPES_N, BRICK_SHAPES_E};

    private static VoxelShape[] makeShapes(Direction dir)
    {
        VoxelShape bl, br, fl, fr;
        switch (dir) {
            case Direction.EAST: {
                bl = BRICK_SHAPE_BACK_LEFT_ROT;
                br = BRICK_SHAPE_BACK_RIGHT_ROT;
                fl = BRICK_SHAPE_FRONT_LEFT_ROT;
                fr = BRICK_SHAPE_FRONT_RIGHT_ROT;
                break;
            }
            case Direction.SOUTH: {
                bl = BRICK_SHAPE_FRONT_RIGHT;
                br = BRICK_SHAPE_FRONT_LEFT;
                fl = BRICK_SHAPE_BACK_RIGHT;
                fr = BRICK_SHAPE_BACK_LEFT;
                break;
            }
            case Direction.WEST: {
                bl = BRICK_SHAPE_FRONT_RIGHT_ROT;
                br = BRICK_SHAPE_FRONT_LEFT_ROT;
                fl = BRICK_SHAPE_BACK_RIGHT_ROT;
                fr = BRICK_SHAPE_BACK_LEFT_ROT;
                break;
            }
            case Direction.NORTH:
            default: {
                bl = BRICK_SHAPE_BACK_LEFT;
                br = BRICK_SHAPE_BACK_RIGHT;
                fl = BRICK_SHAPE_FRONT_LEFT;
                fr = BRICK_SHAPE_FRONT_RIGHT;
                break;
            }
        }
        return IntStream.range(0, 16)
                .mapToObj((bitfield) -> DryingBrick.makeShape(bitfield, bl, br, fl, fr))
                .toArray(VoxelShape[]::new);
    }

    private static VoxelShape makeShape(int pBitfield, VoxelShape backLeft, VoxelShape backRight, VoxelShape frontLeft, VoxelShape frontRight)
    {
        if (pBitfield == 0) return Shapes.box(2, 0, 1, 14, 3, 15);

        VoxelShape voxelshape = Shapes.empty();
        if ((pBitfield & 1) != 0) {
            voxelshape = Shapes.or(voxelshape, frontRight);
        }

        if ((pBitfield & 2) != 0) {
            voxelshape = Shapes.or(voxelshape, frontLeft);
        }

        if ((pBitfield & 4) != 0) {
            voxelshape = Shapes.or(voxelshape, backRight);
        }

        if ((pBitfield & 8) != 0) {
            voxelshape = Shapes.or(voxelshape, backLeft);
        }

        return voxelshape;
    }

    private static int getShapeIndex(BlockState pState)
    {
        int index = 0;
        if (!pState.getValue(BACK_LEFT).isEmpty()) index |= 0b1000;
        if (!pState.getValue(BACK_RIGHT).isEmpty()) index |= 0b0100;
        if (!pState.getValue(FRONT_LEFT).isEmpty()) index |= 0b0010;
        if (!pState.getValue(FRONT_RIGHT).isEmpty()) index |= 0b0001;
        return index;
    }

    protected static final AABB BRICK_BB = new AABB(0, 0, 0, 4 / 16.0f, 3 / 16.0f, 6 / 16.0f).inflate(0.00001);
    protected static final AABB[] BRICK_BBS_N = makeBoundingBoxes(Direction.NORTH);
    protected static final AABB[] BRICK_BBS_E = makeBoundingBoxes(Direction.EAST);
    protected static final AABB[] BRICK_BBS_S = makeBoundingBoxes(Direction.SOUTH);
    protected static final AABB[] BRICK_BBS_W = makeBoundingBoxes(Direction.WEST);
    protected static final AABB[][] BRICK_BBS = new AABB[][]{BRICK_BBS_S, BRICK_BBS_W, BRICK_BBS_N, BRICK_BBS_E};

    private static AABB[] makeBoundingBoxes(Direction dir)
    {
        return new AABB[]{
                GeometryTools.applyRotationToUnit(BRICK_BB.move(2.0f / 16.0f, 0, 1.0f / 16.0f), dir),
                GeometryTools.applyRotationToUnit(BRICK_BB.move(10.0f / 16.0f, 0, 1.0f / 16.0f), dir),
                GeometryTools.applyRotationToUnit(BRICK_BB.move(2.0f / 16.0f, 0, 9.0f / 16.0f), dir),
                GeometryTools.applyRotationToUnit(BRICK_BB.move(10.0f / 16.0f, 0, 9.0f / 16.0f), dir)
        };
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return BRICK_SHAPES[pState.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue()][getShapeIndex(pState)];
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public boolean hasDynamicShape()
    {
        return true;
    }

    @Override
    protected VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos)
    {
        return super.getInteractionShape(pState, pLevel, pPos);
    }
    //endregion

    //region drops
    private ResourceKey<LootTable> _ruinedLootTableKeyCache = null;
    public ResourceKey<LootTable> getOrCreateRuinedLootTable()
    {
        if (_ruinedLootTableKeyCache == null) {
            var key = BuiltInRegistries.BLOCK.getKey(this);
            ResourceLocation rl = MedievalismConstants.resource("ruined_" + key.getPath())
                    .withPrefix("additional_drops/");
            _ruinedLootTableKeyCache = ResourceKey.create(Registries.LOOT_TABLE, rl);
        }
        return _ruinedLootTableKeyCache;
    }

    private ResourceKey<LootTable> _alternateLootTableKeyCache = null;
    public ResourceKey<LootTable> getOrCreateAlternateLootTable()
    {
        if (_alternateLootTableKeyCache == null) {
            var key = BuiltInRegistries.BLOCK.getKey(this);
            ResourceLocation rl = MedievalismConstants.resource("alternate_" + key.getPath())
                    .withPrefix("additional_drops/");
            _alternateLootTableKeyCache = ResourceKey.create(Registries.LOOT_TABLE, rl);
        }
        return _alternateLootTableKeyCache;
    }

    @Override
    protected List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams)
    {
        ArrayList<ItemStack> items = new ArrayList<>();
        ServerLevel serverlevel = pParams.getLevel();
        LootParams.Builder aParamsBuilder = new LootParams.Builder(serverlevel);
        Vec3 pos = pParams.getParameter(LootContextParams.ORIGIN);
        LootParams aParams = aParamsBuilder
                .withParameter(LootContextParams.BLOCK_STATE, pState)
                .withParameter(LootContextParams.ORIGIN, pos)
                .create(LootContextParamSetRegistration.ADDITIONAL_DROPS);
        for (EnumProperty<WarmthTools.DryingBrickState> property : BRICK_PROPERTIES) {
            WarmthTools.DryingBrickState state = pState.getValue(property);
            if (state == WarmthTools.DryingBrickState.WET) {
                items.addAll(super.getDrops(pState, pParams));
            } else if (state == WarmthTools.DryingBrickState.DRY) {
                ResourceKey<LootTable> resourceKey = getOrCreateAlternateLootTable();
                LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(resourceKey);
                items.addAll(loottable.getRandomItems(aParams));
            }
        }
        return items;
    }
    //endregion

    //region Tick
    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override // Random Tick
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        boolean isRaining = pLevel.isRaining();
        int count = 0;
        for (EnumProperty<WarmthTools.DryingBrickState> property : BRICK_PROPERTIES) {
            count += pState.getValue(property).isEmpty() ? 0 : 1;
        }
        if (count == 0) {
            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
            return;
        }
        boolean canSeeSky = pLevel.canSeeSky(pPos);
        if (canSeeSky && isRaining)
        { // Raining
            for (int i = 0; i < 4; i++)
            {
                if (pRandom.nextInt(3) != 0) continue;
                EnumProperty<WarmthTools.DryingBrickState> property = BRICK_PROPERTIES[i];
                WarmthTools.DryingBrickState state = pState.getValue(property);
                if (state.isDry())
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(property, WarmthTools.DryingBrickState.WET));
                }
                else if (state.isWet())
                {
                    BlockState newState = count <= 1 ? Blocks.AIR.defaultBlockState() : pState.setValue(property, WarmthTools.DryingBrickState.EMPTY);
                    pLevel.setBlockAndUpdate(pPos, newState);

                    LootParams.Builder pParams = new LootParams.Builder(pLevel);
                    LootParams lootParams = pParams
                            .withParameter(LootContextParams.BLOCK_STATE, pState)
                            .withParameter(LootContextParams.ORIGIN, new Vec3(pPos.getX() + 0.5f, pPos.getY() + 0.5f, pPos.getZ() + 0.5f))
                            .create(LootContextParamSetRegistration.ADDITIONAL_DROPS);
                    ResourceKey<LootTable> resourceKey = getOrCreateRuinedLootTable();
                    LootTable loottable = pLevel.getServer().reloadableRegistries().getLootTable(resourceKey);
                    var items = loottable.getRandomItems(lootParams);

                    for (ItemStack item : items)
                    {
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
        else
        { // Drying
            for (int i = 0; i < 4; i++)
            {
                EnumProperty<WarmthTools.DryingBrickState> property = BRICK_PROPERTIES[i];
                if (pState.getValue(property).isWet())
                {
                    if (WarmthTools.canWarm(pLevel, pPos, baseDryingChance))
                    {
                        pLevel.setBlockAndUpdate(pPos, pState.setValue(property, WarmthTools.DryingBrickState.DRY));
                    }
                }
            }
        }
    }
    //endregion

    @SuppressWarnings("unused")
    public static class BasicDryingBrick extends DryingBrick
    {
        public BasicDryingBrick(Properties props) { super(props, SoundType.PACKED_MUD, WarmthTools.DEFAULT_WARMING_CHANCE); }
    }
}
