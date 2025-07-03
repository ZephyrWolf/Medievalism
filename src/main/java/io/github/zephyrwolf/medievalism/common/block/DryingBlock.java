package io.github.zephyrwolf.medievalism.common.block;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.blockitem.DryingBlockItem;
import io.github.zephyrwolf.medievalism.content.loot.LootContextParamSetRegistration;
import io.github.zephyrwolf.medievalism.tools.WarmthTools;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
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
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class DryingBlock extends Block
{
    float baseDryingChance;

    public DryingBlock(Properties props, VoxelShape shape, SoundType drySound, float baseDryingChance)
    {
        super(props);
        registerDefaultState(getStateDefinition().any()
                .setValue(WarmthTools.IS_DRY, false)
        );
        this.shape = shape;
        this.drySound = drySound;
        this.baseDryingChance = baseDryingChance;
    }

    //region Sounds
    SoundType drySound;

    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        if (WarmthTools.isDry(state)) {
            return drySound;
        }
        return super.getSoundType(state, level, pos, entity);
    }
    //endregion

    //region State
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder
                .add(WarmthTools.IS_DRY);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        ItemStack held = pContext.getItemInHand();
        if (held.getItem() instanceof DryingBlockItem dryingItem) {
            return defaultBlockState()
                    .setValue(WarmthTools.IS_DRY, dryingItem.isDry());
        }
        return defaultBlockState();
    }
    //endregion

    //region Shape
    protected final VoxelShape shape;

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape;
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!isCollisionShapeFullBlock(pState, pLevel, pCurrentPos) && !pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }
    //endregion

    //region Block Behaviour
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

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return isCollisionShapeFullBlock(pState, pLevel, pPos) || belowState.isFaceSturdy(pLevel, belowPos, Direction.UP, SupportType.FULL);
    }
    //endregion

    //region Tick
    @Override // Scheduled Tick from Block Update
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
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
            if (WarmthTools.isDry(pState))
            {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(WarmthTools.IS_DRY, false));
            }
            else if (pRandom.nextInt(3) == 0)
            {
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
            }
        }
        else
        { // Drying
            if (!WarmthTools.isDry(pState))
            {
                if (WarmthTools.canWarm(pLevel, pPos, baseDryingChance))
                {
                    pLevel.setBlockAndUpdate(pPos, pState.setValue(WarmthTools.IS_DRY, true));
                }
            }
        }
    }
    //endregion

    //region Drops
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
    //endregion

    public static class BasicDryingBlock extends DryingBlock
    {
        public BasicDryingBlock(Properties props) { super(props, Shapes.block(), SoundType.PACKED_MUD, WarmthTools.DEFAULT_WARMING_CHANCE); }
    }
}
