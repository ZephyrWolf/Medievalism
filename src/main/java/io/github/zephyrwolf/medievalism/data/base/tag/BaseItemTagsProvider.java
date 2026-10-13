package io.github.zephyrwolf.medievalism.data.base.tag;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.ItemTagCatalog;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BaseItemTagsProvider extends ItemTagsProvider { // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/ItemTags.java
    public BaseItemTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> provider,
            CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.registerVanillaTags();
        this.registerVanillaAnimalFood();
        this.registerModTags();
        this.registerBlockTags();
        this.registerBlockItemNeoForgeCompatibilityTags();
        this.registerItemNeoForgeCompatibilityTags();
        //this.registerSpecificModCompatibilityTags();
    }

    private void registerVanillaTags()
    {
        tag(ItemTags.DIRT).add(
                BlockItemRegistration.CLAY_IN_DIRT.get(),
                BlockItemRegistration.RED_CLAY_IN_DIRT.get()
        );

        tag(ItemTags.STONE_TOOL_MATERIALS).add(
                BlockItemRegistration.COBBLED_GREYWACKE.get(),
                BlockItemRegistration.COBBLED_SILTSTONE.get(),
                BlockItemRegistration.COBBLED_DOLOSTONE.get(),
                BlockItemRegistration.COBBLED_LIMESTONE.get(),
                BlockItemRegistration.COBBLED_IRONSTONE.get()
        );

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                BlockItemRegistration.COBBLED_GREYWACKE.get(),
                BlockItemRegistration.COBBLED_SILTSTONE.get(),
                BlockItemRegistration.COBBLED_DOLOSTONE.get(),
                BlockItemRegistration.COBBLED_LIMESTONE.get(),
                BlockItemRegistration.COBBLED_IRONSTONE.get()
        );
    }

    private void registerVanillaAnimalFood()
    { // TODO Populate and be liberal (animals eat more than one thing)
        tag(ItemTags.SNIFFER_FOOD);
        tag(ItemTags.PIGLIN_FOOD);
        tag(ItemTags.FOX_FOOD);
        tag(ItemTags.COW_FOOD);
        tag(ItemTags.GOAT_FOOD);
        tag(ItemTags.SHEEP_FOOD);
        tag(ItemTags.WOLF_FOOD);
        tag(ItemTags.CAT_FOOD);
        tag(ItemTags.HORSE_FOOD);
        tag(ItemTags.HORSE_TEMPT_ITEMS);
        tag(ItemTags.CAMEL_FOOD);
        tag(ItemTags.ARMADILLO_FOOD);
        tag(ItemTags.BEE_FOOD);
        tag(ItemTags.CHICKEN_FOOD);
        tag(ItemTags.FROG_FOOD);
        tag(ItemTags.HOGLIN_FOOD);
        tag(ItemTags.LLAMA_FOOD);
        tag(ItemTags.LLAMA_TEMPT_ITEMS);
        tag(ItemTags.OCELOT_FOOD);
        tag(ItemTags.PANDA_FOOD);
        tag(ItemTags.PIG_FOOD);
        tag(ItemTags.RABBIT_FOOD);
        tag(ItemTags.STRIDER_FOOD);
        tag(ItemTags.STRIDER_TEMPT_ITEMS);
        tag(ItemTags.TURTLE_FOOD);
        tag(ItemTags.PARROT_FOOD);
        tag(ItemTags.PARROT_POISONOUS_FOOD);
        tag(ItemTags.AXOLOTL_FOOD);
    }

    private void registerModTags() {
        tag(ItemTagCatalog.LARGE_HIDE)
                .add(ItemRegistration.COW_HIDE.get())
                .add(ItemRegistration.HORSE_HIDE.get())
                .add(ItemRegistration.MOOSHROOM_HIDE.get())
                .add(ItemRegistration.RAVAGER_HIDE.get())
                .add(ItemRegistration.PANDA_HIDE.get())
                .add(ItemRegistration.SNIFFER_HIDE.get())
                .add(ItemRegistration.POLAR_BEAR_HIDE.get())
                .add(ItemRegistration.HOGLIN_HIDE.get());
        tag(ItemTagCatalog.MEDIUM_HIDE)
                .add(ItemRegistration.DONKEY_HIDE.get())
                .add(ItemRegistration.MULE_HIDE.get())
                .add(ItemRegistration.WOLF_HIDE.get())
                .add(ItemRegistration.PIG_HIDE.get())
                .add(ItemRegistration.GOAT_HIDE.get())
                .add(ItemRegistration.LLAMA_HIDE.get())
                .add(ItemRegistration.SHEEP_HIDE.get());
        tag(ItemTagCatalog.SMALL_HIDE)
                .add(Items.RABBIT_HIDE)
                .add(ItemRegistration.FOX_HIDE.get())
                .add(ItemRegistration.SNOW_FOX_HIDE.get())
                .add(ItemRegistration.OCELOT_HIDE.get())
                .add(ItemRegistration.CAT_HIDE.get())
                .add(ItemRegistration.OCELOT_HIDE.get())
                .add(ItemRegistration.BAT_HIDE.get());

        tag(ItemTagCatalog.CAN_CRAFT_FLOUR)
                .add(ItemRegistration.CRACKED_WHEAT.get())
                .add(ItemRegistration.CRACKED_BARLEY.get())
                .add(ItemRegistration.ROLLED_OATS.get());
        tag(ItemTagCatalog.CLAY_BALL)
                .add(Items.CLAY_BALL)
                .add(ItemRegistration.RED_CLAY_BALL.get());
        tag(ItemTagCatalog.CLAY_BLOCK)
                .add(Items.CLAY)
                .add(BlockItemRegistration.RED_CLAY_BLOCK.get());

        tag(ItemTagCatalog.ROCK).add(
                BlockItemRegistration.SANDSTONE_ROCK.get(),
                BlockItemRegistration.RED_SANDSTONE_ROCK.get(),
                BlockItemRegistration.SAPROLITE_ROCK.get(),
                BlockItemRegistration.LATERITE_ROCK.get(),
                BlockItemRegistration.GREYWACKE_ROCK.get(),
                BlockItemRegistration.SILTSTONE_ROCK.get(),
                BlockItemRegistration.DOLOSTONE_ROCK.get(),
                BlockItemRegistration.LIMESTONE_ROCK.get(),
                BlockItemRegistration.IRONSTONE_ROCK.get(),
                BlockItemRegistration.SHALE_ROCK.get(),
                BlockItemRegistration.ARKOSE_ROCK.get()
        );
        tag(ItemTagCatalog.HARD_ROCK).add(
                BlockItemRegistration.GREYWACKE_ROCK.get(),
                BlockItemRegistration.SILTSTONE_ROCK.get(),
                BlockItemRegistration.DOLOSTONE_ROCK.get(),
                BlockItemRegistration.LIMESTONE_ROCK.get(),
                BlockItemRegistration.IRONSTONE_ROCK.get(),
                BlockItemRegistration.ARKOSE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_ROCK).add(
                BlockItemRegistration.LARGE_SANDSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_SAPROLITE_ROCK.get(),
                BlockItemRegistration.LARGE_LATERITE_ROCK.get(),
                BlockItemRegistration.LARGE_GREYWACKE_ROCK.get(),
                BlockItemRegistration.LARGE_SILTSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_DOLOSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_LIMESTONE_ROCK.get(),
                BlockItemRegistration.LARGE_IRONSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_ARKOSE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_HARD_ROCK).add(
                BlockItemRegistration.LARGE_GREYWACKE_ROCK.get(),
                BlockItemRegistration.LARGE_SILTSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_DOLOSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_LIMESTONE_ROCK.get(),
                BlockItemRegistration.LARGE_IRONSTONE_ROCK.get(),
                BlockItemRegistration.LARGE_ARKOSE_ROCK.get()
        );
        tag(ItemTagCatalog.COPPER_ROCK).add(
                BlockItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.CHALK_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.SHALE_ROCK_COPPER_ORE.get(),
                BlockItemRegistration.ARKOSE_ROCK_COPPER_ORE.get()
        );
        tag(ItemTagCatalog.BRANCH).add(
                BlockItemRegistration.OAK_BRANCH.get(),
                BlockItemRegistration.BIRCH_BRANCH.get(),
                BlockItemRegistration.SPRUCE_BRANCH.get(),
                BlockItemRegistration.JUNGLE_BRANCH.get(),
                BlockItemRegistration.ACACIA_BRANCH.get(),
                BlockItemRegistration.DARK_OAK_BRANCH.get(),
                BlockItemRegistration.CHERRY_BRANCH.get(),
                BlockItemRegistration.MANGROVE_BRANCH.get()
        );

        tag(ItemTagCatalog.TINDER)
                .add(BlockItemRegistration.THATCH.get());
        // Candlenut leaves?

        tag(ItemTagCatalog.BARK).add(
                ItemRegistration.WHITE_BARK.get(),
                ItemRegistration.BROWN_BARK.get(),
                ItemRegistration.GREY_BARK.get(),
                ItemRegistration.DARK_BROWN_BARK.get(),
                ItemRegistration.BLACK_BARK.get()
        );

        tag(ItemTagCatalog.CLAY_FLUX).add(
                ItemRegistration.WOOD_ASH.get(),
                ItemRegistration.POTASH.get()
        );

        tag(ItemTagCatalog.CARVING_TOOL).add(
                ItemRegistration.LUNATE.get()
        );

        tag(ItemTagCatalog.KNAP_TOOL).addTag(ItemTagCatalog.HARD_ROCK);

        tag(ItemTagCatalog.WET_BRICK).add(
                BlockItemRegistration.WET_CLAY_BRICK.get(),
                BlockItemRegistration.WET_RED_CLAY_BRICK.get()
        );
    }

    public void registerBlockTags()
    {
        tag(ItemTagCatalog.SEDIMENTARY_WG_STONES).add(
                BlockItemRegistration.GREYWACKE.get(),
                BlockItemRegistration.SILTSTONE.get(),
                BlockItemRegistration.DOLOSTONE.get(),
                BlockItemRegistration.LIMESTONE.get(),
                BlockItemRegistration.CHALK.get(),
                BlockItemRegistration.IRONSTONE.get(),
                BlockItemRegistration.SHALE.get(),
                BlockItemRegistration.ARKOSE.get()
        );
    }

    public void registerBlockItemNeoForgeCompatibilityTags()
    {
        // Gravel
        tag(Tags.Items.GRAVELS).add(
                BlockItemRegistration.GRAVEL.get(),
                BlockItemRegistration.SILT.get()
        );

        // Ashfall & Regolith // Do not add these to Tags.Blocks.COBBLESTONES, they are too soft
        // BlockRegistration.COBBLED_CHALK.get(),

        // Sedimentary
        tag(Tags.Items.STONES).add(
                BlockItemRegistration.GREYWACKE.get(),
                BlockItemRegistration.SILTSTONE.get(),
                BlockItemRegistration.DOLOSTONE.get(),
                BlockItemRegistration.LIMESTONE.get(), // not chalk
                BlockItemRegistration.IRONSTONE.get(),
                BlockItemRegistration.SHALE.get()
        );
        tag(Tags.Items.COBBLESTONES_NORMAL).add( // Only those of equal hardness as greywacke cobblestone
                BlockItemRegistration.COBBLED_GREYWACKE.get(),
                BlockItemRegistration.COBBLED_SILTSTONE.get(),
                BlockItemRegistration.COBBLED_DOLOSTONE.get(),
                BlockItemRegistration.COBBLED_LIMESTONE.get(), // not chalk
                BlockItemRegistration.COBBLED_IRONSTONE.get(),
                BlockItemRegistration.COBBLED_SHALE.get()
        );
        tag(Tags.Items.COBBLESTONES_MOSSY);
        tag(Tags.Items.COBBLESTONES_INFESTED);
        tag(Tags.Items.COBBLESTONES).add( // Everything from NORMAL, MOSSY and INFESTED
                BlockItemRegistration.COBBLED_GREYWACKE.get(),
                BlockItemRegistration.COBBLED_SILTSTONE.get(),
                BlockItemRegistration.COBBLED_DOLOSTONE.get(),
                BlockItemRegistration.COBBLED_LIMESTONE.get(),
                BlockItemRegistration.COBBLED_IRONSTONE.get(),
                BlockItemRegistration.COBBLED_SHALE.get(),
                BlockItemRegistration.COBBLED_ARKOSE.get()
        );
        tag(Tags.Items.ORE_BEARING_GROUND_STONE)
                .addTag(ItemTagCatalog.SEDIMENTARY_WG_STONES);

        // Metamorphic & Soft Igneous Extrusive // Harder than vanilla stone

        // Igneous Intrusive & Hard Igneous Extrusive
        tag(Tags.Items.COBBLESTONES_DEEPSLATE).add( // Only those of equal hardness as gabbro
                BlockItemRegistration.COBBLED_GABBRO.get()
        );

        // Deep Igneous Intrusive // Harder than vanilla deepslate
        tag(Tags.Items.ORE_BEARING_GROUND_DEEPSLATE).add( // TODO This may not be the best idea
                BlockItemRegistration.GABBRO.get(),
                BlockItemRegistration.SMOOTH_DIORITE.get(),
                BlockItemRegistration.ROUGH_DIORITE.get()
                //BlockRegistration.ANDESITE.get(),
                //BlockRegistration.BASALT.get()
        );

        tag(Tags.Items.ORES_COPPER).add(
                BlockItemRegistration.SAPROLITE_COPPER_ORE.get(),
                BlockItemRegistration.LATERITE_COPPER_ORE.get(),
                BlockItemRegistration.GREYWACKE_COPPER_ORE.get(),
                BlockItemRegistration.SILTSTONE_COPPER_ORE.get(),
                BlockItemRegistration.DOLOSTONE_COPPER_ORE.get(),
                BlockItemRegistration.LIMESTONE_COPPER_ORE.get(),
                BlockItemRegistration.CHALK_COPPER_ORE.get(),
                BlockItemRegistration.IRONSTONE_COPPER_ORE.get(),
                BlockItemRegistration.SHALE_COPPER_ORE.get(),
                BlockItemRegistration.ARKOSE_COPPER_ORE.get(),
                BlockItemRegistration.MARBLE_COPPER_ORE.get(),
                BlockItemRegistration.QUARTZITE_COPPER_ORE.get(),
                BlockItemRegistration.HORNFELS_COPPER_ORE.get(),
                BlockItemRegistration.SLATE_COPPER_ORE.get()
        );
        tag(Tags.Items.ORES_IRON).add(
                BlockItemRegistration.GABBRO_IRON_ORE.get(),
                BlockItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(),
                BlockItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(),
                BlockItemRegistration.NORITE_IRON_ORE.get(),
                BlockItemRegistration.PERIDOTITE_IRON_ORE.get(),
                BlockItemRegistration.RHYOLITE_IRON_ORE.get(),
                BlockItemRegistration.DACITE_IRON_ORE.get(),
                BlockItemRegistration.ANDESITE_IRON_ORE.get(),
                BlockItemRegistration.BASALT_IRON_ORE.get()
        );
        tag(Tags.Items.ORES_GOLD).add(
                BlockItemRegistration.GREYWACKE_GOLD_ORE.get(),
                BlockItemRegistration.SILTSTONE_GOLD_ORE.get(),
                BlockItemRegistration.DOLOSTONE_GOLD_ORE.get(),
                BlockItemRegistration.LIMESTONE_GOLD_ORE.get(),
                BlockItemRegistration.CHALK_GOLD_ORE.get(),
                BlockItemRegistration.IRONSTONE_GOLD_ORE.get(),
                BlockItemRegistration.SHALE_GOLD_ORE.get(),
                BlockItemRegistration.ARKOSE_GOLD_ORE.get(),
                BlockItemRegistration.MARBLE_GOLD_ORE.get(),
                BlockItemRegistration.QUARTZITE_GOLD_ORE.get(),
                BlockItemRegistration.HORNFELS_GOLD_ORE.get(),
                BlockItemRegistration.SLATE_GOLD_ORE.get(),
                BlockItemRegistration.GABBRO_GOLD_ORE.get(),
                BlockItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(),
                BlockItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(),
                BlockItemRegistration.NORITE_GOLD_ORE.get(),
                BlockItemRegistration.PERIDOTITE_GOLD_ORE.get(),
                BlockItemRegistration.RHYOLITE_GOLD_ORE.get(),
                BlockItemRegistration.DACITE_GOLD_ORE.get(),
                BlockItemRegistration.ANDESITE_GOLD_ORE.get(),
                BlockItemRegistration.BASALT_GOLD_ORE.get()
        );
        tag(Tags.Items.ORES_COAL).add(
                BlockItemRegistration.SAPROLITE_COAL_ORE.get(),
                BlockItemRegistration.LATERITE_COAL_ORE.get(),
                BlockItemRegistration.GREYWACKE_COAL_ORE.get(),
                BlockItemRegistration.SILTSTONE_COAL_ORE.get(),
                BlockItemRegistration.DOLOSTONE_COAL_ORE.get(),
                BlockItemRegistration.LIMESTONE_COAL_ORE.get(),
                BlockItemRegistration.CHALK_COAL_ORE.get(),
                BlockItemRegistration.IRONSTONE_COAL_ORE.get(),
                BlockItemRegistration.SHALE_COAL_ORE.get(),
                BlockItemRegistration.ARKOSE_COAL_ORE.get(),
                BlockItemRegistration.MARBLE_COAL_ORE.get(),
                BlockItemRegistration.QUARTZITE_COAL_ORE.get(),
                BlockItemRegistration.HORNFELS_COAL_ORE.get(),
                BlockItemRegistration.SLATE_COAL_ORE.get()
        );
        tag(Tags.Items.ORES_DIAMOND).add(
                BlockItemRegistration.GABBRO_DIAMOND_ORE.get(),
                BlockItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(),
                BlockItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(),
                BlockItemRegistration.NORITE_DIAMOND_ORE.get(),
                BlockItemRegistration.PERIDOTITE_DIAMOND_ORE.get(),
                BlockItemRegistration.ANDESITE_DIAMOND_ORE.get(),
                BlockItemRegistration.BASALT_DIAMOND_ORE.get()
        );
        tag(Tags.Items.ORES_EMERALD).add(
                BlockItemRegistration.GABBRO_EMERALD_ORE.get(),
                BlockItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(),
                BlockItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(),
                BlockItemRegistration.NORITE_EMERALD_ORE.get(),
                BlockItemRegistration.PERIDOTITE_EMERALD_ORE.get(),
                BlockItemRegistration.RHYOLITE_EMERALD_ORE.get(),
                BlockItemRegistration.DACITE_EMERALD_ORE.get(),
                BlockItemRegistration.ANDESITE_EMERALD_ORE.get(),
                BlockItemRegistration.BASALT_EMERALD_ORE.get()
        );
        tag(Tags.Items.ORES_LAPIS).add(
                BlockItemRegistration.MARBLE_LAPIS_ORE.get(),
                BlockItemRegistration.QUARTZITE_LAPIS_ORE.get(),
                BlockItemRegistration.HORNFELS_LAPIS_ORE.get(),
                BlockItemRegistration.SLATE_LAPIS_ORE.get()
        );
        tag(Tags.Items.ORES_REDSTONE).add(
                BlockItemRegistration.GABBRO_REDSTONE_ORE.get(),
                BlockItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(),
                BlockItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(),
                BlockItemRegistration.NORITE_REDSTONE_ORE.get(),
                BlockItemRegistration.PERIDOTITE_REDSTONE_ORE.get()
        );

        tag(Tags.Items.ORES_QUARTZ);

        tag(ItemTagCatalog.ORES_TIN).add(
                BlockItemRegistration.TIN_ORE_IN_GREYWACKE.get(),
                BlockItemRegistration.TIN_ORE_IN_GABBRO.get()
        );

        tag(ItemTagCatalog.ORES_CHERT).add(
                BlockItemRegistration.LIMESTONE_CHERT_ORE.get(),
                BlockItemRegistration.CHALK_CHERT_ORE.get()
        );

        tag(ItemTagCatalog.ORES_GEODE).add(
                BlockItemRegistration.BASALT_GEODE_ORE.get(),
                BlockItemRegistration.ANDESITE_GEODE_ORE.get(),
                BlockItemRegistration.RHYOLITE_GEODE_ORE.get(),
                BlockItemRegistration.DACITE_GEODE_ORE.get(),
                BlockItemRegistration.TIN_ORE_IN_GREYWACKE.get(),
                BlockItemRegistration.TIN_ORE_IN_GABBRO.get()
        );

        // --

        tag(Tags.Items.ORE_RATES_DENSE)
                .addTag(Tags.Items.ORES_COPPER)
                .addTag(Tags.Items.ORES_LAPIS)
                .addTag(Tags.Items.ORES_QUARTZ)
                .addTag(Tags.Items.ORES_REDSTONE);

        tag(Tags.Items.ORE_RATES_SINGULAR)
                .addTag(Tags.Items.ORES_IRON)
                .addTag(Tags.Items.ORES_GOLD)
                .addTag(Tags.Items.ORES_COAL)
                .addTag(Tags.Items.ORES_DIAMOND)
                .addTag(Tags.Items.ORES_EMERALD)
                .addTag(ItemTagCatalog.ORES_TIN)
                .addTag(ItemTagCatalog.ORES_CHERT)
                .addTag(ItemTagCatalog.ORES_GEODE);

        tag(Tags.Items.ORE_RATES_SPARSE);

        tag(Tags.Items.SANDSTONE_BLOCKS).add(
                BlockItemRegistration.COBBLED_SANDSTONE.get(),
                BlockItemRegistration.COBBLED_RED_SANDSTONE.get()
        );
        tag(Tags.Items.SANDSTONE_UNCOLORED_BLOCKS).add(
                BlockItemRegistration.COBBLED_SANDSTONE.get()
        );
        tag(Tags.Items.SANDSTONE_RED_BLOCKS).add(
                BlockItemRegistration.COBBLED_RED_SANDSTONE.get()
        );
    }

    public void registerItemNeoForgeCompatibilityTags()
    {
        tag(Tags.Items.CROPS).add(
                ItemRegistration.BLUEBERRIES.get(),
                ItemRegistration.RASPBERRIES.get(),
                ItemRegistration.STRAWBERRIES.get(),
                ItemRegistration.BARLEY.get(),
                ItemRegistration.OATS.get(),
                ItemRegistration.YAM.get(),
                ItemRegistration.FLAX.get()
        );

        tag(Tags.Items.SEEDS).add(
                ItemRegistration.BARLEY_SEEDS.get(),
                ItemRegistration.OAT_SEEDS.get(),
                ItemRegistration.FLAX_SEEDS.get()
        );

        tag(Tags.Items.MUSHROOMS);

        tag(Tags.Items.FOODS).add(
                ItemRegistration.BLUEBERRIES.get(),
                ItemRegistration.RASPBERRIES.get(),
                ItemRegistration.STRAWBERRIES.get(),
                ItemRegistration.YAM.get(),
                ItemRegistration.BAKED_YAM.get(),
                ItemRegistration.BAKED_BEETROOT.get(),
                ItemRegistration.BAKED_CARROT.get()
        );

        tag(Tags.Items.FOODS_BERRY).add(
                ItemRegistration.BLUEBERRIES.get(),
                ItemRegistration.RASPBERRIES.get(),
                ItemRegistration.STRAWBERRIES.get()
        );

        tag(Tags.Items.DUSTS).add(
                ItemRegistration.CRACKED_BARLEY.get(),
                ItemRegistration.CRACKED_WHEAT.get(),
                ItemRegistration.ROLLED_OATS.get(),
                ItemRegistration.FLOUR.get()
        );

        tag(Tags.Items.GEMS);

        tag(Tags.Items.RAW_MATERIALS);
        tag(Tags.Items.RAW_MATERIALS_COPPER);
        tag(Tags.Items.RAW_MATERIALS_GOLD);
        tag(Tags.Items.RAW_MATERIALS_IRON);

        tag(Tags.Items.TOOLS).add(
                ItemRegistration.FIRE_STARTER.get()
        );
        tag(Tags.Items.TOOLS_IGNITER).add(
                ItemRegistration.FIRE_STARTER.get()
        );
        tag(Tags.Items.MINING_TOOL_TOOLS);
    }
}
