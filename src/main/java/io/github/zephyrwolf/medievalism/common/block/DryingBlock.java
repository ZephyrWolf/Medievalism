package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.item.blockitem.DryingBlockItem;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DryingBlock extends Block {
    public static final int SKY_BRIGHTNESS_TO_DRY = 12;
    public static final int MAX_DRYNESS = 11;
    public static final int DEFAULT_DRYNESS = 4;
    public static final int MIN_DRYNESS = 0;

    public static final IntegerProperty DRYNESS = IntegerProperty.create("dryness", MIN_DRYNESS, MAX_DRYNESS);
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;

    protected final VoxelShape shape;

    public DryingBlock(Properties props, VoxelShape shape) {
        super(props);
        registerDefaultState(getStateDefinition().any()
                .setValue(DRYNESS, DEFAULT_DRYNESS)
                .setValue(AXIS, Direction.Axis.Z)
        );
        this.shape = shape;
    }

    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        if (state.getValue(DRYNESS) == MAX_DRYNESS) {
            return SoundType.PACKED_MUD;
        }
        return super.getSoundType(state, level, pos, entity);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(DRYNESS)
                .add(AXIS);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape;
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
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        ItemStack held = pContext.getItemInHand();
        if (held.getItem() instanceof DryingBlockItem dryingItem) {
            if (dryingItem.isDry()) {
                return defaultBlockState()
                        .setValue(DRYNESS, MAX_DRYNESS)
                        .setValue(AXIS, pContext.getHorizontalDirection().getAxis());
            }
        }
        return defaultBlockState()
                .setValue(AXIS, pContext.getHorizontalDirection().getAxis());
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!isCollisionShapeFullBlock(pState, pLevel, pCurrentPos) && !pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return isCollisionShapeFullBlock(pState, pLevel, pPos) || belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }

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

    @Override // Random Tick
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        boolean isRaining = pLevel.isRaining();
        if (!isRaining && pLevel.getBrightness(LightLayer.SKY, pPos) > SKY_BRIGHTNESS_TO_DRY && pLevel.isDay()) {
            //long timeOfDay = pLevel.dayTime();
            int dryness = pState.getValue(DRYNESS);
            if (dryness != MAX_DRYNESS) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(DRYNESS, dryness + 1));
            }
        } else if (isRaining && pLevel.canSeeSky(pPos)) {
            int dryness = pState.getValue(DRYNESS);
            if (dryness == MIN_DRYNESS) {
                pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());

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
            } else {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(DRYNESS, dryness - 1));
            }
        }
    }

    @Override
    protected List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        return super.getDrops(pState, pParams);
    }
}
