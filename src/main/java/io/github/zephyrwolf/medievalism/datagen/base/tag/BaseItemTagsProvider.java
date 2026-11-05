package io.github.zephyrwolf.medievalism.datagen.base.tag;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.registration.item.tag.ItemTagCatalog;
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
                ItemRegistration.CLAY_IN_DIRT.get()
        );

        tag(ItemTags.STONE_TOOL_MATERIALS).add(
                ItemRegistration.COBBLED_GREYWACKE.get(),
                ItemRegistration.COBBLED_SILTSTONE.get(),
                ItemRegistration.COBBLED_DOLOSTONE.get(),
                ItemRegistration.COBBLED_LIMESTONE.get(),
                ItemRegistration.COBBLED_IRONSTONE.get()
        );

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                ItemRegistration.COBBLED_GREYWACKE.get(),
                ItemRegistration.COBBLED_SILTSTONE.get(),
                ItemRegistration.COBBLED_DOLOSTONE.get(),
                ItemRegistration.COBBLED_LIMESTONE.get(),
                ItemRegistration.COBBLED_IRONSTONE.get()
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
                .add(
                        Items.CLAY_BALL,
                        ItemRegistration.POTTERS_CLAY_BALL.get(),
                        ItemRegistration.KAOLIN_CLAY_BALL.get(),
                        ItemRegistration.REFRACTORY_CLAY_BALL.get()
                );
        tag(ItemTagCatalog.GROG)
                .add(
                        ItemRegistration.GROG.get(),
                        ItemRegistration.KAOLIN_GROG.get(),
                        ItemRegistration.REFRACTORY_GROG.get()
                );
        tag(ItemTagCatalog.CLAY_BLOCK)
                .add(Items.CLAY);

        tag(ItemTagCatalog.ROCK).add(
                ItemRegistration.SANDSTONE_ROCK.get(),
                ItemRegistration.RED_SANDSTONE_ROCK.get(),
                ItemRegistration.SAPROLITE_ROCK.get(),
                ItemRegistration.LATERITE_ROCK.get(),
                ItemRegistration.SILT_CLUMP.get(),
                ItemRegistration.GREYWACKE_ROCK.get(),
                ItemRegistration.SILTSTONE_ROCK.get(),
                ItemRegistration.DOLOSTONE_ROCK.get(),
                ItemRegistration.LIMESTONE_ROCK.get(),
                ItemRegistration.IRONSTONE_ROCK.get(),
                ItemRegistration.SHALE_ROCK.get(),
                ItemRegistration.ARKOSE_ROCK.get()
        );
        tag(ItemTagCatalog.HARD_ROCK).add(
                ItemRegistration.GREYWACKE_ROCK.get(),
                ItemRegistration.SILTSTONE_ROCK.get(),
                ItemRegistration.DOLOSTONE_ROCK.get(),
                ItemRegistration.LIMESTONE_ROCK.get(),
                ItemRegistration.IRONSTONE_ROCK.get(),
                ItemRegistration.ARKOSE_ROCK.get(),
                ItemRegistration.MARBLE_ROCK.get(),
                ItemRegistration.QUARTZITE_ROCK.get(),
                ItemRegistration.HORNFELS_ROCK.get(),
                ItemRegistration.SLATE_ROCK.get(),
                ItemRegistration.GABBRO_ROCK.get(),
                ItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                ItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                ItemRegistration.NORITE_ROCK.get(),
                ItemRegistration.PERIDOTITE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_ROCK).add(
                ItemRegistration.LARGE_SANDSTONE_ROCK.get(),
                ItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(),
                ItemRegistration.LARGE_SAPROLITE_ROCK.get(),
                ItemRegistration.LARGE_LATERITE_ROCK.get(),
                ItemRegistration.LARGE_SILT_CLUMP.get(),
                ItemRegistration.LARGE_GREYWACKE_ROCK.get(),
                ItemRegistration.LARGE_SILTSTONE_ROCK.get(),
                ItemRegistration.LARGE_DOLOSTONE_ROCK.get(),
                ItemRegistration.LARGE_LIMESTONE_ROCK.get(),
                ItemRegistration.LARGE_IRONSTONE_ROCK.get(),
                ItemRegistration.LARGE_ARKOSE_ROCK.get(),
                ItemRegistration.MARBLE_ROCK.get(),
                ItemRegistration.QUARTZITE_ROCK.get(),
                ItemRegistration.HORNFELS_ROCK.get(),
                ItemRegistration.SLATE_ROCK.get(),
                ItemRegistration.GABBRO_ROCK.get(),
                ItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                ItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                ItemRegistration.NORITE_ROCK.get(),
                ItemRegistration.PERIDOTITE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_HARD_ROCK).add(
                ItemRegistration.LARGE_GREYWACKE_ROCK.get(),
                ItemRegistration.LARGE_SILTSTONE_ROCK.get(),
                ItemRegistration.LARGE_DOLOSTONE_ROCK.get(),
                ItemRegistration.LARGE_LIMESTONE_ROCK.get(),
                ItemRegistration.LARGE_IRONSTONE_ROCK.get(),
                ItemRegistration.LARGE_ARKOSE_ROCK.get(),
                ItemRegistration.MARBLE_ROCK.get(),
                ItemRegistration.QUARTZITE_ROCK.get(),
                ItemRegistration.HORNFELS_ROCK.get(),
                ItemRegistration.SLATE_ROCK.get(),
                ItemRegistration.GABBRO_ROCK.get(),
                ItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                ItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                ItemRegistration.NORITE_ROCK.get(),
                ItemRegistration.PERIDOTITE_ROCK.get()
        );
        tag(ItemTagCatalog.COPPER_ROCK).add(
                ItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(),
                ItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(),
                ItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(),
                ItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(),
                ItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(),
                ItemRegistration.CHALK_ROCK_COPPER_ORE.get(),
                ItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(),
                ItemRegistration.SHALE_ROCK_COPPER_ORE.get(),
                ItemRegistration.ARKOSE_ROCK_COPPER_ORE.get()
        );
        tag(ItemTagCatalog.BRANCH).add(
                ItemRegistration.OAK_BRANCH.get(),
                ItemRegistration.BIRCH_BRANCH.get(),
                ItemRegistration.SPRUCE_BRANCH.get(),
                ItemRegistration.JUNGLE_BRANCH.get(),
                ItemRegistration.ACACIA_BRANCH.get(),
                ItemRegistration.DARK_OAK_BRANCH.get(),
                ItemRegistration.CHERRY_BRANCH.get(),
                ItemRegistration.MANGROVE_BRANCH.get()
        );

        tag(ItemTagCatalog.TINDER)
                .add(ItemRegistration.THATCH.get());
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
                ItemRegistration.DRYING_CLAY_BRICK.get()
        );
    }

    public void registerBlockTags()
    {
        tag(ItemTagCatalog.SEDIMENTARY_WG_STONES).add(
                ItemRegistration.GREYWACKE.get(),
                ItemRegistration.SILTSTONE.get(),
                ItemRegistration.DOLOSTONE.get(),
                ItemRegistration.LIMESTONE.get(),
                ItemRegistration.CHALK.get(),
                ItemRegistration.IRONSTONE.get(),
                ItemRegistration.SHALE.get(),
                ItemRegistration.ARKOSE.get()
        );
    }

    public void registerBlockItemNeoForgeCompatibilityTags()
    {
        // Gravel
        tag(Tags.Items.GRAVELS).add(
                ItemRegistration.SILT.get()
        );

        // Ashfall & Regolith // Do not add these to Tags.Blocks.COBBLESTONES, they are too soft
        // BlockRegistration.COBBLED_CHALK.get(),

        // Sedimentary
        tag(Tags.Items.STONES).add(
                ItemRegistration.GREYWACKE.get(),
                ItemRegistration.SILTSTONE.get(),
                ItemRegistration.DOLOSTONE.get(),
                ItemRegistration.LIMESTONE.get(), // not chalk
                ItemRegistration.IRONSTONE.get(),
                ItemRegistration.SHALE.get()
        );
        tag(Tags.Items.COBBLESTONES_NORMAL).add( // Only those of equal hardness as greywacke cobblestone
                ItemRegistration.COBBLED_GREYWACKE.get(),
                ItemRegistration.COBBLED_SILTSTONE.get(),
                ItemRegistration.COBBLED_DOLOSTONE.get(),
                ItemRegistration.COBBLED_LIMESTONE.get(), // not chalk
                ItemRegistration.COBBLED_IRONSTONE.get(),
                ItemRegistration.COBBLED_SHALE.get()
        );
        tag(Tags.Items.COBBLESTONES_MOSSY);
        tag(Tags.Items.COBBLESTONES_INFESTED);
        tag(Tags.Items.COBBLESTONES).add( // Everything from NORMAL, MOSSY and INFESTED
                ItemRegistration.COBBLED_GREYWACKE.get(),
                ItemRegistration.COBBLED_SILTSTONE.get(),
                ItemRegistration.COBBLED_DOLOSTONE.get(),
                ItemRegistration.COBBLED_LIMESTONE.get(),
                ItemRegistration.COBBLED_IRONSTONE.get(),
                ItemRegistration.COBBLED_SHALE.get(),
                ItemRegistration.COBBLED_ARKOSE.get()
        );
        tag(Tags.Items.ORE_BEARING_GROUND_STONE)
                .addTag(ItemTagCatalog.SEDIMENTARY_WG_STONES);

        // Metamorphic & Soft Igneous Extrusive // Harder than vanilla stone

        // Igneous Intrusive & Hard Igneous Extrusive
        tag(Tags.Items.COBBLESTONES_DEEPSLATE).add( // Only those of equal hardness as gabbro
                ItemRegistration.COBBLED_GABBRO.get()
        );

        // Deep Igneous Intrusive // Harder than vanilla deepslate
        tag(Tags.Items.ORE_BEARING_GROUND_DEEPSLATE).add( // TODO This may not be the best idea
                ItemRegistration.GABBRO.get(),
                ItemRegistration.SMOOTH_DIORITE.get(),
                ItemRegistration.ROUGH_DIORITE.get()
                //BlockRegistration.ANDESITE.get(),
                //BlockRegistration.BASALT.get()
        );

        tag(Tags.Items.ORES_COPPER).add(
                ItemRegistration.GREYWACKE_COPPER_ORE.get(),
                ItemRegistration.SILTSTONE_COPPER_ORE.get(),
                ItemRegistration.DOLOSTONE_COPPER_ORE.get(),
                ItemRegistration.LIMESTONE_COPPER_ORE.get(),
                ItemRegistration.CHALK_COPPER_ORE.get(),
                ItemRegistration.IRONSTONE_COPPER_ORE.get(),
                ItemRegistration.SHALE_COPPER_ORE.get(),
                ItemRegistration.ARKOSE_COPPER_ORE.get(),
                ItemRegistration.MARBLE_COPPER_ORE.get(),
                ItemRegistration.QUARTZITE_COPPER_ORE.get(),
                ItemRegistration.HORNFELS_COPPER_ORE.get(),
                ItemRegistration.SLATE_COPPER_ORE.get()
        );
        tag(Tags.Items.ORES_IRON).add(
                ItemRegistration.GABBRO_IRON_ORE.get(),
                ItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(),
                ItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(),
                ItemRegistration.NORITE_IRON_ORE.get(),
                ItemRegistration.PERIDOTITE_IRON_ORE.get(),
                ItemRegistration.RHYOLITE_IRON_ORE.get(),
                ItemRegistration.DACITE_IRON_ORE.get(),
                ItemRegistration.ANDESITE_IRON_ORE.get(),
                ItemRegistration.BASALT_IRON_ORE.get()
        );
        tag(Tags.Items.ORES_GOLD).add(
                ItemRegistration.GREYWACKE_GOLD_ORE.get(),
                ItemRegistration.SILTSTONE_GOLD_ORE.get(),
                ItemRegistration.DOLOSTONE_GOLD_ORE.get(),
                ItemRegistration.LIMESTONE_GOLD_ORE.get(),
                ItemRegistration.CHALK_GOLD_ORE.get(),
                ItemRegistration.IRONSTONE_GOLD_ORE.get(),
                ItemRegistration.SHALE_GOLD_ORE.get(),
                ItemRegistration.ARKOSE_GOLD_ORE.get(),
                ItemRegistration.MARBLE_GOLD_ORE.get(),
                ItemRegistration.QUARTZITE_GOLD_ORE.get(),
                ItemRegistration.HORNFELS_GOLD_ORE.get(),
                ItemRegistration.SLATE_GOLD_ORE.get(),
                ItemRegistration.GABBRO_GOLD_ORE.get(),
                ItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(),
                ItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(),
                ItemRegistration.NORITE_GOLD_ORE.get(),
                ItemRegistration.PERIDOTITE_GOLD_ORE.get(),
                ItemRegistration.RHYOLITE_GOLD_ORE.get(),
                ItemRegistration.DACITE_GOLD_ORE.get(),
                ItemRegistration.ANDESITE_GOLD_ORE.get(),
                ItemRegistration.BASALT_GOLD_ORE.get()
        );
        tag(Tags.Items.ORES_COAL).add(
                ItemRegistration.SAPROLITE_COAL_ORE.get(),
                ItemRegistration.LATERITE_COAL_ORE.get(),
                ItemRegistration.GREYWACKE_COAL_ORE.get(),
                ItemRegistration.SILTSTONE_COAL_ORE.get(),
                ItemRegistration.DOLOSTONE_COAL_ORE.get(),
                ItemRegistration.LIMESTONE_COAL_ORE.get(),
                ItemRegistration.CHALK_COAL_ORE.get(),
                ItemRegistration.IRONSTONE_COAL_ORE.get(),
                ItemRegistration.SHALE_COAL_ORE.get(),
                ItemRegistration.ARKOSE_COAL_ORE.get(),
                ItemRegistration.MARBLE_COAL_ORE.get(),
                ItemRegistration.QUARTZITE_COAL_ORE.get(),
                ItemRegistration.HORNFELS_COAL_ORE.get(),
                ItemRegistration.SLATE_COAL_ORE.get()
        );
        tag(Tags.Items.ORES_DIAMOND).add(
                ItemRegistration.GABBRO_DIAMOND_ORE.get(),
                ItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(),
                ItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(),
                ItemRegistration.NORITE_DIAMOND_ORE.get(),
                ItemRegistration.PERIDOTITE_DIAMOND_ORE.get(),
                ItemRegistration.ANDESITE_DIAMOND_ORE.get(),
                ItemRegistration.BASALT_DIAMOND_ORE.get()
        );
        tag(Tags.Items.ORES_EMERALD).add(
                ItemRegistration.GABBRO_EMERALD_ORE.get(),
                ItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(),
                ItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(),
                ItemRegistration.NORITE_EMERALD_ORE.get(),
                ItemRegistration.PERIDOTITE_EMERALD_ORE.get(),
                ItemRegistration.RHYOLITE_EMERALD_ORE.get(),
                ItemRegistration.DACITE_EMERALD_ORE.get(),
                ItemRegistration.ANDESITE_EMERALD_ORE.get(),
                ItemRegistration.BASALT_EMERALD_ORE.get()
        );
        tag(Tags.Items.ORES_LAPIS).add(
                ItemRegistration.MARBLE_LAPIS_ORE.get(),
                ItemRegistration.QUARTZITE_LAPIS_ORE.get(),
                ItemRegistration.HORNFELS_LAPIS_ORE.get(),
                ItemRegistration.SLATE_LAPIS_ORE.get()
        );
        tag(Tags.Items.ORES_REDSTONE).add(
                ItemRegistration.GABBRO_REDSTONE_ORE.get(),
                ItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(),
                ItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(),
                ItemRegistration.NORITE_REDSTONE_ORE.get(),
                ItemRegistration.PERIDOTITE_REDSTONE_ORE.get()
        );

        tag(Tags.Items.ORES_QUARTZ);

        tag(ItemTagCatalog.ORES_TIN);

        tag(ItemTagCatalog.ORES_CHERT).add(
                ItemRegistration.LIMESTONE_CHERT_ORE.get(),
                ItemRegistration.CHALK_CHERT_ORE.get()
        );

        tag(ItemTagCatalog.ORES_GEODE).add(
                ItemRegistration.BASALT_GEODE_ORE.get(),
                ItemRegistration.ANDESITE_GEODE_ORE.get(),
                ItemRegistration.RHYOLITE_GEODE_ORE.get(),
                ItemRegistration.DACITE_GEODE_ORE.get()
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
                ItemRegistration.COBBLED_SANDSTONE.get(),
                ItemRegistration.COBBLED_RED_SANDSTONE.get()
        );
        tag(Tags.Items.SANDSTONE_UNCOLORED_BLOCKS).add(
                ItemRegistration.COBBLED_SANDSTONE.get()
        );
        tag(Tags.Items.SANDSTONE_RED_BLOCKS).add(
                ItemRegistration.COBBLED_RED_SANDSTONE.get()
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
