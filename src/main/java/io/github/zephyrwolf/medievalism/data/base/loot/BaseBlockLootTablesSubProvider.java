package io.github.zephyrwolf.medievalism.data.base.loot;

import io.github.zephyrwolf.medievalism.common.block.FireLayBlock;
import io.github.zephyrwolf.medievalism.common.block.TwigsBlock;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.common.warmth.WarmthTools;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BaseBlockLootTablesSubProvider extends BlockLootSubProvider {
    //private final Set<Block> generatedLootTables = new HashSet<>();

    public BaseBlockLootTablesSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate() { // TODO CLEANUP AND METHODIZE THIS

        add(BlockRegistration.CLAY_IN_GRASS.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                Items.CLAY_BALL,
                UniformGenerator.between(1, 3)
        ));
        add(BlockRegistration.RED_CLAY_IN_GRASS.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                ItemRegistration.RED_CLAY_BALL.get(),
                UniformGenerator.between(1, 3)
        ));
        add(BlockRegistration.CLAY_IN_DIRT.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                Items.CLAY_BALL,
                UniformGenerator.between(1, 3)
        ));
        add(BlockRegistration.RED_CLAY_IN_DIRT.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                ItemRegistration.RED_CLAY_BALL.get(),
                UniformGenerator.between(1, 3)
        ));

        add(BlockRegistration.RED_CLAY.get(), (block) -> createSingleItemTableWithSilkTouch(
                block,
                ItemRegistration.RED_CLAY_BALL.get(),
                ConstantValue.exactly(4)
        ));

        add(BlockRegistration.TIN_ORE_IN_GREYWACKE.get(), (block) -> createOreDrop(
                BlockRegistration.TIN_ORE_IN_GREYWACKE.get(),
                ItemRegistration.RAW_TIN.get()
        ));
        add(BlockRegistration.TIN_ORE_IN_GABBRO.get(), (block) -> createOreDrop(
                BlockRegistration.TIN_ORE_IN_GABBRO.get(),
                ItemRegistration.RAW_TIN.get()
        ));

        dropSelf(BlockRegistration.WET_PACKED_MUD_BRICK.get());
        dropSelf(BlockRegistration.WET_DAUB_BRICK.get());
        dropSelf(BlockRegistration.DRYING_CLAY_BRICK.get());
        dropSelf(BlockRegistration.DRYING_RED_CLAY_BRICK.get());

        add(BlockRegistration.DRYING_GATHERERS_JAR.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_GATHERERS_JAR, BlockItemRegistration.DRY_GATHERERS_JAR));
        add(BlockRegistration.GATHERERS_JAR.get(), this::createCeramicContainer);
        add(BlockRegistration.DRYING_KEEPERS_CROCK.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_KEEPERS_CROCK, BlockItemRegistration.DRY_KEEPERS_CROCK));
        add(BlockRegistration.KEEPERS_CROCK.get(), this::createCeramicContainer);
        add(BlockRegistration.DRYING_SETTLERS_POT.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_SETTLERS_POT, BlockItemRegistration.DRY_SETTLERS_POT));
        add(BlockRegistration.SETTLERS_POT.get(), this::createNameable);
        add(BlockRegistration.DRYING_CLAY_COOKING_POT.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_CLAY_COOKING_POT, BlockItemRegistration.DRY_CLAY_COOKING_POT));
        dropSelf(BlockRegistration.CLAY_COOKING_POT.get());
        add(BlockRegistration.DRYING_CLAY_CAULDRON.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_CLAY_CAULDRON, BlockItemRegistration.DRY_CLAY_CAULDRON));
        dropSelf(BlockRegistration.CLAY_CAULDRON.get());
        add(BlockRegistration.DRYING_JUG.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_JUG, BlockItemRegistration.DRY_JUG));
        dropSelf(BlockRegistration.JUG.get());
        add(BlockRegistration.DRYING_FLOWER_POT.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_FLOWER_POT, BlockItemRegistration.DRY_FLOWER_POT));
        add(BlockRegistration.DRYING_DECORATED_POT.get(), block -> createSpecialDropOnStateTable(block, WarmthTools.IS_DRY, true, BlockItemRegistration.WET_DECORATED_POT, BlockItemRegistration.DRY_DECORATED_POT));

        //region twigs
        add(
                BlockRegistration.TWIGS.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .setQuality(1)
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.TWIGS.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(TwigsBlock.NUM_STICKS, 1)
                                                )
                                        )
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .setQuality(1)
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.TWIGS.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(TwigsBlock.NUM_STICKS, 2)
                                                )
                                        )
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(3))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .setQuality(1)
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.TWIGS.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(TwigsBlock.NUM_STICKS, 3)
                                                )
                                        )
                                )
                        )
        );
        //endregion

        dropSelf(BlockRegistration.OAK_BRANCH.get());
        dropSelf(BlockRegistration.BIRCH_BRANCH.get());
        dropSelf(BlockRegistration.SPRUCE_BRANCH.get());
        dropSelf(BlockRegistration.JUNGLE_BRANCH.get());
        dropSelf(BlockRegistration.DARK_OAK_BRANCH.get());
        dropSelf(BlockRegistration.ACACIA_BRANCH.get());
        dropSelf(BlockRegistration.CHERRY_BRANCH.get());
        dropSelf(BlockRegistration.MANGROVE_BRANCH.get());

        // ROCK
        dropSelf(BlockRegistration.SANDSTONE_ROCK.get());
        dropSelf(BlockRegistration.RED_SANDSTONE_ROCK.get());
        dropSelf(BlockRegistration.SAPROLITE_ROCK.get());
        dropSelf(BlockRegistration.LATERITE_ROCK.get());
        dropSelf(BlockRegistration.SILT_CLUMP.get());
        dropSelf(BlockRegistration.GREYWACKE_ROCK.get());
        dropSelf(BlockRegistration.SILTSTONE_ROCK.get());
        dropSelf(BlockRegistration.DOLOSTONE_ROCK.get());
        dropSelf(BlockRegistration.LIMESTONE_ROCK.get());
        dropSelf(BlockRegistration.IRONSTONE_ROCK.get());
        dropSelf(BlockRegistration.SHALE_ROCK.get());
        dropSelf(BlockRegistration.ARKOSE_ROCK.get());
        dropSelf(BlockRegistration.MARBLE_ROCK.get());
        dropSelf(BlockRegistration.QUARTZITE_ROCK.get());
        dropSelf(BlockRegistration.HORNFELS_ROCK.get());
        dropSelf(BlockRegistration.SLATE_ROCK.get());
        dropSelf(BlockRegistration.GABBRO_ROCK.get());
        dropSelf(BlockRegistration.SMOOTH_DIORITE_ROCK.get());
        dropSelf(BlockRegistration.SMOOTH_GRANITE_ROCK.get());
        dropSelf(BlockRegistration.NORITE_ROCK.get());
        dropSelf(BlockRegistration.PERIDOTITE_ROCK.get());
        // LARGE ROCK
        dropSelf(BlockRegistration.LARGE_SANDSTONE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_RED_SANDSTONE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SAPROLITE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_LATERITE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SILT_CLUMP.get());
        dropSelf(BlockRegistration.LARGE_GREYWACKE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SILTSTONE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_DOLOSTONE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_LIMESTONE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_IRONSTONE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SHALE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_ARKOSE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_MARBLE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_QUARTZITE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_HORNFELS_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SLATE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_GABBRO_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SMOOTH_DIORITE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_SMOOTH_GRANITE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_NORITE_ROCK.get());
        dropSelf(BlockRegistration.LARGE_PERIDOTITE_ROCK.get());
        // COPPER ROCK
        dropSelf(BlockRegistration.SAPROLITE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.GREYWACKE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.SILTSTONE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.DOLOSTONE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.LIMESTONE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.CHALK_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.IRONSTONE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.SHALE_ROCK_COPPER_ORE.get());
        dropSelf(BlockRegistration.ARKOSE_ROCK_COPPER_ORE.get());

        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        add(BlockRegistration.SHRUB.get(), createSilkTouchOrShearsDispatchTable(
                BlockRegistration.SHRUB.get(),
                ((LootPoolSingletonContainer.Builder<?>)applyExplosionCondition(BlockRegistration.SHRUB.get(), LootItem.lootTableItem(Items.STICK)))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.05F, 0.0625F, 0.083333336F, 0.1F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_SHEARS.or(hasSilkTouch()).invert())
                        .when(LootItemRandomChanceCondition.randomChance(0.3f))
                        .add(LootItem.lootTableItem(Items.STICK))
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        BlockRegistration.SHRUB.get(),
                                        LootItem.lootTableItem(Items.STICK)
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                )).when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))
                        )
        ));

        add(
                BlockRegistration.YAMS.get(),
                createCropDrops(
                        BlockRegistration.YAMS.get(),
                        ItemRegistration.YAM.get(),
                        ItemRegistration.YAM.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistration.YAMS.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))
                )
        );
        add(
                BlockRegistration.WILD_YAMS.get(),
                applyExplosionDecay(
                        BlockRegistration.WILD_YAMS.get(),
                        LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .add(
                                                        LootItem.lootTableItem(ItemRegistration.YAM.get())
                                                )
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .add(
                                                        LootItem.lootTableItem(ItemRegistration.YAM.get())
                                                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286f, 1))
                                                )
                                )
                )
        );

        // DIRT
        dropSelf(BlockRegistration.SILT.get());
        dropSelf(BlockRegistration.WET_PACKED_MUD.get());
        dropSelf(BlockRegistration.WET_DAUB_BLOCK.get());
        dropSelf(BlockRegistration.DAUB_BLOCK.get());
        dropSelf(BlockRegistration.DAUB_BRICKS.get());
        dropSelf(BlockRegistration.CRACKED_DAUB_BLOCK.get());
        dropSelf(BlockRegistration.CRACKED_DAUB_BRICKS.get());
        // STONE
        add(BlockRegistration.SOFT_TUFF.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_SOFT_TUFF.get()));
        add(BlockRegistration.IGNIMBRITE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_IGNIMBRITE.get()));
        add(BlockRegistration.LAPILLISTONE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_LAPILLISTONE.get()));
        add(BlockRegistration.SAPROLITE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_SAPROLITE.get()));
        add(BlockRegistration.LATERITE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_LATERITE.get()));
        add(BlockRegistration.SILTSTONE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_SILTSTONE.get()));
        add(BlockRegistration.DOLOSTONE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_DOLOSTONE.get()));
        add(BlockRegistration.LIMESTONE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_LIMESTONE.get()));
        add(BlockRegistration.CHALK.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_CHALK.get()));
        add(BlockRegistration.IRONSTONE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_IRONSTONE.get()));
        add(BlockRegistration.SHALE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_SHALE.get()));
        add(BlockRegistration.ARKOSE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.COBBLED_ARKOSE.get()));
        dropSelf(BlockRegistration.MARBLE.get());
        dropSelf(BlockRegistration.QUARTZITE.get());
        dropSelf(BlockRegistration.HORNFELS.get());
        dropSelf(BlockRegistration.SLATE.get());
        dropSelf(BlockRegistration.NORITE.get());
        dropSelf(BlockRegistration.PERIDOTITE.get());
        dropSelf(BlockRegistration.DACITE.get());
        dropSelf(BlockRegistration.RHYOLITE.get());
        add(BlockRegistration.SMOOTH_DIORITE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.ROUGH_DIORITE.get()));
        add(BlockRegistration.SMOOTH_GRANITE.get(), block -> createSingleItemTableWithSilkTouch(block, BlockRegistration.ROUGH_GRANITE.get()));
        // INFESTED STONE
        otherWhenSilkTouch(BlockRegistration.INFESTED_SILTSTONE.get(), BlockRegistration.COBBLED_SILTSTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_DOLOSTONE.get(), BlockRegistration.COBBLED_DOLOSTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_LIMESTONE.get(), BlockRegistration.COBBLED_LIMESTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_SHALE.get(), BlockRegistration.COBBLED_SHALE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_ARKOSE.get(), BlockRegistration.COBBLED_ARKOSE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_MARBLE.get(), BlockRegistration.MARBLE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_QUARTZITE.get(), BlockRegistration.QUARTZITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_HORNFELS.get(), BlockRegistration.HORNFELS.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_SLATE.get(), BlockRegistration.SLATE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_SMOOTH_DIORITE.get(), BlockRegistration.ROUGH_DIORITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_SMOOTH_GRANITE.get(), BlockRegistration.ROUGH_GRANITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_NORITE.get(), BlockRegistration.NORITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_PERIDOTITE.get(), BlockRegistration.PERIDOTITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_RHYOLITE.get(), BlockRegistration.RHYOLITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_DACITE.get(), BlockRegistration.DACITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_ANDESITE.get(), BlockRegistration.ANDESITE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_BASALT.get(), BlockRegistration.BASALT.get());
        // COPPER ORE
        add( BlockRegistration.SAPROLITE_COPPER_ORE.get(), createOreDrops(BlockRegistration.SAPROLITE_COPPER_ORE.get(), BlockItemRegistration.SAPROLITE_ROCK_COPPER_ORE, 1.0f, 3.0f ));
        add( BlockRegistration.SILTSTONE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.SILTSTONE_COPPER_ORE.get() ));
        add( BlockRegistration.DOLOSTONE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.DOLOSTONE_COPPER_ORE.get() ));
        add( BlockRegistration.LIMESTONE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.LIMESTONE_COPPER_ORE.get() ));
        add( BlockRegistration.CHALK_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.CHALK_COPPER_ORE.get() ));
        add( BlockRegistration.IRONSTONE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.IRONSTONE_COPPER_ORE.get() ));
        add( BlockRegistration.SHALE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.SHALE_COPPER_ORE.get() ));
        add( BlockRegistration.ARKOSE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.ARKOSE_COPPER_ORE.get() ));
        add( BlockRegistration.MARBLE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.MARBLE_COPPER_ORE.get() ));
        add( BlockRegistration.QUARTZITE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.QUARTZITE_COPPER_ORE.get() ));
        add( BlockRegistration.HORNFELS_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.HORNFELS_COPPER_ORE.get() ));
        add( BlockRegistration.SLATE_COPPER_ORE.get(), createCopperOreDrops(BlockRegistration.SLATE_COPPER_ORE.get() ));
        // IRON
        add( BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.SMOOTH_DIORITE_IRON_ORE.get() ));
        add( BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.SMOOTH_GRANITE_IRON_ORE.get() ));
        add( BlockRegistration.NORITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.NORITE_IRON_ORE.get() ));
        add( BlockRegistration.PERIDOTITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.PERIDOTITE_IRON_ORE.get() ));
        add( BlockRegistration.RHYOLITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.RHYOLITE_IRON_ORE.get() ));
        add( BlockRegistration.DACITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.DACITE_IRON_ORE.get() ));
        add( BlockRegistration.ANDESITE_IRON_ORE.get(), createIronOreDrops(BlockRegistration.ANDESITE_IRON_ORE.get() ));
        add( BlockRegistration.BASALT_IRON_ORE.get(), createIronOreDrops(BlockRegistration.BASALT_IRON_ORE.get() ));
        // GOLD ORE
        add( BlockRegistration.SILTSTONE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.SILTSTONE_GOLD_ORE.get() ));
        add( BlockRegistration.DOLOSTONE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.DOLOSTONE_GOLD_ORE.get() ));
        add( BlockRegistration.LIMESTONE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.LIMESTONE_GOLD_ORE.get() ));
        add( BlockRegistration.CHALK_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.CHALK_GOLD_ORE.get() ));
        add( BlockRegistration.IRONSTONE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.IRONSTONE_GOLD_ORE.get() ));
        add( BlockRegistration.SHALE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.SHALE_GOLD_ORE.get() ));
        add( BlockRegistration.ARKOSE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.ARKOSE_GOLD_ORE.get() ));
        add( BlockRegistration.MARBLE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.MARBLE_GOLD_ORE.get() ));
        add( BlockRegistration.QUARTZITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.QUARTZITE_GOLD_ORE.get() ));
        add( BlockRegistration.HORNFELS_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.HORNFELS_GOLD_ORE.get() ));
        add( BlockRegistration.SLATE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.SLATE_GOLD_ORE.get() ));
        add( BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.SMOOTH_DIORITE_GOLD_ORE.get() ));
        add( BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.SMOOTH_GRANITE_GOLD_ORE.get() ));
        add( BlockRegistration.NORITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.NORITE_GOLD_ORE.get() ));
        add( BlockRegistration.PERIDOTITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.PERIDOTITE_GOLD_ORE.get() ));
        add( BlockRegistration.RHYOLITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.RHYOLITE_GOLD_ORE.get() ));
        add( BlockRegistration.DACITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.DACITE_GOLD_ORE.get() ));
        add( BlockRegistration.ANDESITE_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.ANDESITE_GOLD_ORE.get() ));
        add( BlockRegistration.BASALT_GOLD_ORE.get(), createGoldOreDrops(BlockRegistration.BASALT_GOLD_ORE.get() ));
        // COAL ORE
        add( BlockRegistration.SAPROLITE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.SAPROLITE_COAL_ORE.get() ));
        add( BlockRegistration.LATERITE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.LATERITE_COAL_ORE.get() ));
        add( BlockRegistration.SILTSTONE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.SILTSTONE_COAL_ORE.get() ));
        add( BlockRegistration.DOLOSTONE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.DOLOSTONE_COAL_ORE.get() ));
        add( BlockRegistration.LIMESTONE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.LIMESTONE_COAL_ORE.get() ));
        add( BlockRegistration.CHALK_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.CHALK_COAL_ORE.get() ));
        add( BlockRegistration.IRONSTONE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.IRONSTONE_COAL_ORE.get() ));
        add( BlockRegistration.SHALE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.SHALE_COAL_ORE.get() ));
        add( BlockRegistration.ARKOSE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.ARKOSE_COAL_ORE.get() ));
        add( BlockRegistration.MARBLE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.MARBLE_COAL_ORE.get() ));
        add( BlockRegistration.QUARTZITE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.QUARTZITE_COAL_ORE.get() ));
        add( BlockRegistration.HORNFELS_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.HORNFELS_COAL_ORE.get() ));
        add( BlockRegistration.SLATE_COAL_ORE.get(), createCoalOreDrops(BlockRegistration.SLATE_COAL_ORE.get() ));
        // DIAMOND ORE
        add( BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(), createDiamondOreDrops(BlockRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get() ));
        add( BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(), createDiamondOreDrops(BlockRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get() ));
        add( BlockRegistration.NORITE_DIAMOND_ORE.get(), createDiamondOreDrops(BlockRegistration.NORITE_DIAMOND_ORE.get() ));
        add( BlockRegistration.PERIDOTITE_DIAMOND_ORE.get(), createDiamondOreDrops(BlockRegistration.PERIDOTITE_DIAMOND_ORE.get() ));
        add( BlockRegistration.ANDESITE_DIAMOND_ORE.get(), createDiamondOreDrops(BlockRegistration.ANDESITE_DIAMOND_ORE.get() ));
        add( BlockRegistration.BASALT_DIAMOND_ORE.get(), createDiamondOreDrops(BlockRegistration.BASALT_DIAMOND_ORE.get() ));
        // EMERALD ORE
        add( BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.SMOOTH_DIORITE_EMERALD_ORE.get() ));
        add( BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.SMOOTH_GRANITE_EMERALD_ORE.get() ));
        add( BlockRegistration.NORITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.NORITE_EMERALD_ORE.get() ));
        add( BlockRegistration.PERIDOTITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.PERIDOTITE_EMERALD_ORE.get() ));
        add( BlockRegistration.RHYOLITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.RHYOLITE_EMERALD_ORE.get() ));
        add( BlockRegistration.DACITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.DACITE_EMERALD_ORE.get() ));
        add( BlockRegistration.ANDESITE_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.ANDESITE_EMERALD_ORE.get() ));
        add( BlockRegistration.BASALT_EMERALD_ORE.get(), createEmeraldOreDrops(BlockRegistration.BASALT_EMERALD_ORE.get() ));
        // LAPIS ORE
        add( BlockRegistration.MARBLE_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistration.MARBLE_LAPIS_ORE.get() ));
        add( BlockRegistration.QUARTZITE_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistration.QUARTZITE_LAPIS_ORE.get() ));
        add( BlockRegistration.HORNFELS_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistration.HORNFELS_LAPIS_ORE.get() ));
        add( BlockRegistration.SLATE_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistration.SLATE_LAPIS_ORE.get() ));
        // REDSTONE ORE
        add( BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get() ));
        add( BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get() ));
        add( BlockRegistration.NORITE_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistration.NORITE_REDSTONE_ORE.get() ));
        add( BlockRegistration.PERIDOTITE_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistration.PERIDOTITE_REDSTONE_ORE.get() ));
        // TIN ORE
        // CHERT ORE
        dropSelf(BlockRegistration.LIMESTONE_CHERT_ORE.get());   // TEMP DROPS
        dropSelf(BlockRegistration.CHALK_CHERT_ORE.get());       // TEMP DROPS
        // GEODE ORE
        dropSelf(BlockRegistration.BASALT_GEODE_ORE.get());      // TEMP DROPS
        dropSelf(BlockRegistration.ANDESITE_GEODE_ORE.get());    // TEMP DROPS
        dropSelf(BlockRegistration.RHYOLITE_GEODE_ORE.get());    // TEMP DROPS
        dropSelf(BlockRegistration.DACITE_GEODE_ORE.get());      // TEMP DROPS

        // COBBLE
        dropSelf(BlockRegistration.COBBLED_SOFT_TUFF.get());
        dropSelf(BlockRegistration.COBBLED_IGNIMBRITE.get());
        dropSelf(BlockRegistration.COBBLED_LAPILLISTONE.get());
        dropSelf(BlockRegistration.COBBLED_WELDED_TUFF.get());
        dropSelf(BlockRegistration.COBBLED_SANDSTONE.get());
        dropSelf(BlockRegistration.COBBLED_RED_SANDSTONE.get());
        dropSelf(BlockRegistration.COBBLED_SAPROLITE.get());
        dropSelf(BlockRegistration.COBBLED_LATERITE.get());
        dropSelf(BlockRegistration.COBBLED_SILTSTONE.get());
        dropSelf(BlockRegistration.COBBLED_DOLOSTONE.get());
        dropSelf(BlockRegistration.COBBLED_LIMESTONE.get());
        dropSelf(BlockRegistration.COBBLED_CHALK.get());
        dropSelf(BlockRegistration.COBBLED_IRONSTONE.get());
        dropSelf(BlockRegistration.COBBLED_SHALE.get());
        dropSelf(BlockRegistration.COBBLED_ARKOSE.get());
        // INFESTED COBBLE
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_SILTSTONE.get(), BlockRegistration.COBBLED_SILTSTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_DOLOSTONE.get(), BlockRegistration.COBBLED_DOLOSTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_LIMESTONE.get(), BlockRegistration.COBBLED_LIMESTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_CHALK.get(), BlockRegistration.COBBLED_CHALK.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_IRONSTONE.get(), BlockRegistration.COBBLED_IRONSTONE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_SHALE.get(), BlockRegistration.COBBLED_SHALE.get());
        otherWhenSilkTouch(BlockRegistration.INFESTED_COBBLED_ARKOSE.get(), BlockRegistration.COBBLED_ARKOSE.get());


        // PRIMITIVE TECHNOLOGY
        dropSelf(BlockRegistration.THATCH.get());
        dropSelf(BlockRegistration.DOGBANE.get());

        //region Fire Lay
        add( // TODO This is wrong
                BlockRegistration.FIRE_LAY.get(),
                LootTable.lootTable()
                        //region Pool Stage 1
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(BlockItemRegistration.THATCH.get())
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 1)
                                                )
                                        )
                                )
                        )
                        //endregion
                        //region Pool Stage 2
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(BlockItemRegistration.THATCH.get())
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 2)
                                                )
                                        )
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 2)
                                                )
                                        )
                                )
                        )
                        //endregion
                        //region Pool Stage 3
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(BlockItemRegistration.THATCH.get())
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 3)
                                                )
                                        )
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 3)
                                                )
                                        )
                                )
                        )
                        //endregion
                        //region Pool Stage 4
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(BlockItemRegistration.THATCH.get())
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 4)
                                                )
                                        )
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)))
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 4)
                                                )
                                        )
                                )
                        )
                        //endregion
                        //region Pool Stage 5
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(BlockItemRegistration.THATCH.get())
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 5)
                                                )
                                        )
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem
                                        .lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)))
                                        .when(new LootItemBlockStatePropertyCondition.Builder(BlockRegistration.FIRE_LAY.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(FireLayBlock.STAGE_PROP, 5)
                                                )
                                        )
                                )
                        )
                        //endregion

        );
        //endregion
        dropSelf(BlockRegistration.STONE_BENCH.get());
        dropSelf(BlockRegistration.CHOPPING_BLOCK.get());
    }

    @SuppressWarnings("unused")
    protected void dropNamedContainer(Block block) {
        add(block, this::createNameableBlockEntityTable);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BlockRegistration.BLOCKS.getEntries().stream().map(DeferredHolder::get).map(b -> (Block) b)::iterator;
    }

    @SuppressWarnings("unused")
    protected void dropOther(Block pBlock, ItemLike pItem, int count) {
        this.add(pBlock, this.createItemTable(pItem, count));
    }

    public LootTable.Builder createItemTable(ItemLike pItem, int count) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(pItem, LootPool
                        .lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem
                                .lootTableItem(pItem)
                                .setQuality(count)
                        )
                ));
    }

    public LootTable.Builder createCeramicContainer(Block block) {
        //LootItemFunctions
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(block)
                                .setQuality(1)
                                .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                .include(DataComponents.CUSTOM_NAME)
                                                .include(DataComponents.CONTAINER)
                                        //.include(DataComponents.LOCK)
                                        //.include(DataComponents.CONTAINER_LOOT)
                                )
                        )
                );
    }

    public LootTable.Builder createNameable(Block block) {
        //LootItemFunctions
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(block)
                                .setQuality(1)
                                .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                .include(DataComponents.CUSTOM_NAME)
                                        //.include(DataComponents.LOCK)
                                        //.include(DataComponents.CONTAINER_LOOT)
                                )
                        )
                );
    }

    @SuppressWarnings("unused")
    public LootTable.Builder createSpecialDropOnStateTable(Block block, Property<Integer> property, int value, ItemLike wet, ItemLike dry) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(dry)
                                .setQuality(1)
                                .when(new LootItemBlockStatePropertyCondition.Builder(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(property, value)
                                        )
                                )
                        )
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(wet)
                                .setQuality(1)
                                .when(InvertedLootItemCondition.invert(
                                                new LootItemBlockStatePropertyCondition.Builder(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(property, value)
                                                        )
                                        )
                                )
                        )
                );
    }

    public LootTable.Builder createSpecialDropOnStateTable(Block block, Property<Boolean> property, boolean value, ItemLike wet, ItemLike dry) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(dry)
                                .setQuality(1)
                                .when(new LootItemBlockStatePropertyCondition.Builder(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(property, value)
                                        )
                                )
                        )
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem
                                .lootTableItem(wet)
                                .setQuality(1)
                                .when(InvertedLootItemCondition.invert(
                                                new LootItemBlockStatePropertyCondition.Builder(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(property, value)
                                                        )
                                        )
                                )
                        )
                );
    }

    @SuppressWarnings("unused")
    public LootTable.Builder emptyItemTable() {
        return LootTable.lootTable();
    }

    // -- Ore

    protected LootTable.Builder createSingleOreDrops(Block pBlock, ItemLike item)
    {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                //.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createOreDrops(Block pBlock, ItemLike item, float minCount, float maxCount)
    {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createIronOreDrops(Block pBlock)
    {
        return createSingleOreDrops(pBlock, Items.RAW_IRON);
    }

    protected LootTable.Builder createGoldOreDrops(Block pBlock)
    {
        return createSingleOreDrops(pBlock, Items.RAW_GOLD);
    }

    protected LootTable.Builder createCoalOreDrops(Block pBlock)
    {
        return createSingleOreDrops(pBlock, Items.COAL);
    }

    protected LootTable.Builder createDiamondOreDrops(Block pBlock)
    {
        return createSingleOreDrops(pBlock, Items.DIAMOND);
    }

    protected LootTable.Builder createEmeraldOreDrops(Block pBlock)
    {
        return createSingleOreDrops(pBlock, Items.EMERALD);
    }
}
