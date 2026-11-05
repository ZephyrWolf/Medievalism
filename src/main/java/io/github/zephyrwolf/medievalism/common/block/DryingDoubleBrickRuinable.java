package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.warmth.WarmthTools;
import io.github.zephyrwolf.medievalism.registration.loot.LootContextParamSetRegistration;
import io.github.zephyrwolf.medievalism.tools.GeometryTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DryingDoubleBrickRuinable extends Block
{
    SoundType drySound;
    float baseDryingChance;

    public DryingDoubleBrickRuinable(Properties props, SoundType drySound, float chance)
    {
        super(props);
        this.drySound = drySound;
        this.baseDryingChance = chance;
        registerDefaultState(getStateDefinition().any()
                .setValue(IS_DRY, false)
                .setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X)
        );
    }

    //region Sounds


    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity)
    {
        if (entity instanceof Player) {
            boolean hit = raytraceBrickIndex(state, pos, (Player) entity);
            if (hit && state.getValue(IS_DRY)) {  return drySound; }
        }
        else
        {
            if (state.getValue(IS_DRY)) {  return drySound; }
        }
        return super.getSoundType(state, level, pos, entity);
    }
    //endregion

    //region Interaction
    public boolean raytraceBrickIndex(BlockState state, BlockPos pos, @Nonnull Player player)
    {
        HitResult hitresult = GeometryTools.raytraceBlockHitResult(player);
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            Direction.Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            int ordinal = axis == Direction.Axis.X ? 0 : 1;
            Vec3 target = hitresult.getLocation();
            if (pos.getX() == Math.floor(target.x()) &&
                    pos.getY() == Math.floor(target.y()) &&
                    pos.getZ() == Math.floor(target.z())
            )
            { // Not entirely necessary but the safety is nice
                AABB aabb = BRICK_BBS[ordinal].move(pos);
                return aabb.contains(target);
            }
        }
        return false;
    }

    /*
    public ItemInteractionResult tryPlaceAdditionalBrick(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, @Nullable Player pPlayer)
    {
        ItemInteractionResult result = ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        return result;
    }
     */

    /*
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
     */
    //endregion

    //region State
    public static final BooleanProperty IS_DRY = WarmthTools.IS_DRY;

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder
                .add(IS_DRY)
                .add(BlockStateProperties.HORIZONTAL_AXIS);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        return defaultBlockState()
                .setValue(IS_DRY, false)
                .setValue(BlockStateProperties.HORIZONTAL_AXIS, pContext.getHorizontalDirection().getAxis());
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
    protected static final VoxelShape BRICK_SHAPE = Block.box(2, 0, 1, 6, 3, 7);
    protected static final VoxelShape BRICK_SHAPE_ROT = Block.box(9, 0, 2, 15, 3, 6);
    protected static final VoxelShape BRICK_SHAPE_X = BRICK_SHAPE_ROT;
    protected static final VoxelShape BRICK_SHAPE_Z = BRICK_SHAPE;

    protected static final VoxelShape[] BRICK_SHAPES = makeShapes();

    private static VoxelShape[] makeShapes()
    {
        return new VoxelShape[] { BRICK_SHAPE_X, BRICK_SHAPE_Z };
    }

    protected static final AABB BRICK_BBS_X = new AABB(0, 0, 0, 8 / 16.0f, 4 / 16.0f, 6 / 16.0f).inflate(0.00001);;
    protected static final AABB BRICK_BBS_Z = new AABB(0, 0, 0, 6 / 16.0f, 4 / 16.0f, 8 / 16.0f).inflate(0.00001);
    protected static final AABB[] BRICK_BBS = new AABB[]{ BRICK_BBS_X, BRICK_BBS_Z };


    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        Direction.Axis axis = pState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        int ordinal = axis == Direction.Axis.X ? 0 : 1;
        return BRICK_SHAPES[ordinal];
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
        boolean isDry = pState.getValue(IS_DRY);
        if (!isDry)
        {
            items.addAll(super.getDrops(pState, pParams));
        }
        else
        {
            ResourceKey<LootTable> resourceKey = getOrCreateAlternateLootTable();
            LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(resourceKey);
            items.addAll(loottable.getRandomItems(aParams));
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
        boolean canSeeSky = pLevel.canSeeSky(pPos);
        if (canSeeSky && isRaining && pLevel.getBiome(pPos).value().getModifiedClimateSettings().hasPrecipitation())
        { // Raining
            if (pRandom.nextInt(3) != 0) return;
            boolean isDry = pState.getValue(IS_DRY);
            if (isDry)
            {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(IS_DRY, false));
            }
            else
            {
                BlockState newState = Blocks.AIR.defaultBlockState();
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
        else
        { // Drying
            if (!pState.getValue(IS_DRY))
            {
                if (WarmthTools.canWarm(pLevel, pPos, baseDryingChance))
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(IS_DRY, true));
                }
            }
        }
    }
    //endregion

    @SuppressWarnings("unused")
    public static class BasicDryingBrick extends DryingDoubleBrickRuinable
    {
        public BasicDryingBrick(Properties props) { super(props, SoundType.PACKED_MUD, WarmthTools.DEFAULT_WARMING_CHANCE); }
    }
}
