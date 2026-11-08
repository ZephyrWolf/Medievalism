package io.github.zephyrwolf.medievalism.datagen.base.tag;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registration.item.*;
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
                WorldItemRegistration.CLAY_IN_DIRT.get()
        );

        tag(ItemTags.STONE_TOOL_MATERIALS).add(
                WorldItemRegistration.COBBLED_GREYWACKE.get(),
                WorldItemRegistration.COBBLED_SILTSTONE.get(),
                WorldItemRegistration.COBBLED_DOLOSTONE.get(),
                WorldItemRegistration.COBBLED_LIMESTONE.get(),
                WorldItemRegistration.COBBLED_IRONSTONE.get()
        );

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                WorldItemRegistration.COBBLED_GREYWACKE.get(),
                WorldItemRegistration.COBBLED_SILTSTONE.get(),
                WorldItemRegistration.COBBLED_DOLOSTONE.get(),
                WorldItemRegistration.COBBLED_LIMESTONE.get(),
                WorldItemRegistration.COBBLED_IRONSTONE.get()
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
                .add(LeatherWorkingItemRegistration.COW_HIDE.get())
                .add(LeatherWorkingItemRegistration.HORSE_HIDE.get())
                .add(LeatherWorkingItemRegistration.MOOSHROOM_HIDE.get())
                .add(LeatherWorkingItemRegistration.RAVAGER_HIDE.get())
                .add(LeatherWorkingItemRegistration.PANDA_HIDE.get())
                .add(LeatherWorkingItemRegistration.SNIFFER_HIDE.get())
                .add(LeatherWorkingItemRegistration.POLAR_BEAR_HIDE.get())
                .add(LeatherWorkingItemRegistration.HOGLIN_HIDE.get());
        tag(ItemTagCatalog.MEDIUM_HIDE)
                .add(LeatherWorkingItemRegistration.DONKEY_HIDE.get())
                .add(LeatherWorkingItemRegistration.MULE_HIDE.get())
                .add(LeatherWorkingItemRegistration.WOLF_HIDE.get())
                .add(LeatherWorkingItemRegistration.PIG_HIDE.get())
                .add(LeatherWorkingItemRegistration.GOAT_HIDE.get())
                .add(LeatherWorkingItemRegistration.LLAMA_HIDE.get())
                .add(LeatherWorkingItemRegistration.SHEEP_HIDE.get());
        tag(ItemTagCatalog.SMALL_HIDE)
                .add(Items.RABBIT_HIDE)
                .add(LeatherWorkingItemRegistration.FOX_HIDE.get())
                .add(LeatherWorkingItemRegistration.SNOW_FOX_HIDE.get())
                .add(LeatherWorkingItemRegistration.OCELOT_HIDE.get())
                .add(LeatherWorkingItemRegistration.CAT_HIDE.get())
                .add(LeatherWorkingItemRegistration.OCELOT_HIDE.get())
                .add(LeatherWorkingItemRegistration.BAT_HIDE.get());

        tag(ItemTagCatalog.CAN_CRAFT_FLOUR)
                .add(CookingItemRegistration.CRACKED_WHEAT.get())
                .add(CookingItemRegistration.CRACKED_BARLEY.get())
                .add(CookingItemRegistration.ROLLED_OATS.get());
        tag(ItemTagCatalog.CLAY_BALL)
                .add(
                        Items.CLAY_BALL,
                        ClayWorkingItemRegistration.POTTERS_CLAY_BALL.get(),
                        ClayWorkingItemRegistration.KAOLIN_CLAY_BALL.get(),
                        ClayWorkingItemRegistration.REFRACTORY_CLAY_BALL.get()
                );
        tag(ItemTagCatalog.GROG)
                .add(
                        ClayWorkingItemRegistration.GROG.get(),
                        ClayWorkingItemRegistration.KAOLIN_GROG.get(),
                        ClayWorkingItemRegistration.REFRACTORY_GROG.get()
                );
        tag(ItemTagCatalog.CLAY_BLOCK)
                .add(Items.CLAY);

        tag(ItemTagCatalog.ROCK).add(
                WorldItemRegistration.SANDSTONE_ROCK.get(),
                WorldItemRegistration.RED_SANDSTONE_ROCK.get(),
                WorldItemRegistration.SAPROLITE_ROCK.get(),
                WorldItemRegistration.LATERITE_ROCK.get(),
                WorldItemRegistration.SILT_CLUMP.get(),
                WorldItemRegistration.GREYWACKE_ROCK.get(),
                WorldItemRegistration.SILTSTONE_ROCK.get(),
                WorldItemRegistration.DOLOSTONE_ROCK.get(),
                WorldItemRegistration.LIMESTONE_ROCK.get(),
                WorldItemRegistration.IRONSTONE_ROCK.get(),
                WorldItemRegistration.SHALE_ROCK.get(),
                WorldItemRegistration.ARKOSE_ROCK.get()
        );
        tag(ItemTagCatalog.HARD_ROCK).add(
                WorldItemRegistration.GREYWACKE_ROCK.get(),
                WorldItemRegistration.SILTSTONE_ROCK.get(),
                WorldItemRegistration.DOLOSTONE_ROCK.get(),
                WorldItemRegistration.LIMESTONE_ROCK.get(),
                WorldItemRegistration.IRONSTONE_ROCK.get(),
                WorldItemRegistration.ARKOSE_ROCK.get(),
                WorldItemRegistration.MARBLE_ROCK.get(),
                WorldItemRegistration.QUARTZITE_ROCK.get(),
                WorldItemRegistration.HORNFELS_ROCK.get(),
                WorldItemRegistration.SLATE_ROCK.get(),
                WorldItemRegistration.GABBRO_ROCK.get(),
                WorldItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                WorldItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                WorldItemRegistration.NORITE_ROCK.get(),
                WorldItemRegistration.PERIDOTITE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_ROCK).add(
                WorldItemRegistration.LARGE_SANDSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_RED_SANDSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_SAPROLITE_ROCK.get(),
                WorldItemRegistration.LARGE_LATERITE_ROCK.get(),
                WorldItemRegistration.LARGE_SILT_CLUMP.get(),
                WorldItemRegistration.LARGE_GREYWACKE_ROCK.get(),
                WorldItemRegistration.LARGE_SILTSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_DOLOSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_LIMESTONE_ROCK.get(),
                WorldItemRegistration.LARGE_IRONSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_ARKOSE_ROCK.get(),
                WorldItemRegistration.MARBLE_ROCK.get(),
                WorldItemRegistration.QUARTZITE_ROCK.get(),
                WorldItemRegistration.HORNFELS_ROCK.get(),
                WorldItemRegistration.SLATE_ROCK.get(),
                WorldItemRegistration.GABBRO_ROCK.get(),
                WorldItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                WorldItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                WorldItemRegistration.NORITE_ROCK.get(),
                WorldItemRegistration.PERIDOTITE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_HARD_ROCK).add(
                WorldItemRegistration.LARGE_GREYWACKE_ROCK.get(),
                WorldItemRegistration.LARGE_SILTSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_DOLOSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_LIMESTONE_ROCK.get(),
                WorldItemRegistration.LARGE_IRONSTONE_ROCK.get(),
                WorldItemRegistration.LARGE_ARKOSE_ROCK.get(),
                WorldItemRegistration.MARBLE_ROCK.get(),
                WorldItemRegistration.QUARTZITE_ROCK.get(),
                WorldItemRegistration.HORNFELS_ROCK.get(),
                WorldItemRegistration.SLATE_ROCK.get(),
                WorldItemRegistration.GABBRO_ROCK.get(),
                WorldItemRegistration.SMOOTH_DIORITE_ROCK.get(),
                WorldItemRegistration.SMOOTH_GRANITE_ROCK.get(),
                WorldItemRegistration.NORITE_ROCK.get(),
                WorldItemRegistration.PERIDOTITE_ROCK.get()
        );
        tag(ItemTagCatalog.COPPER_ROCK).add(
                WorldItemRegistration.SAPROLITE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.GREYWACKE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.SILTSTONE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.DOLOSTONE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.LIMESTONE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.CHALK_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.IRONSTONE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.SHALE_ROCK_COPPER_ORE.get(),
                WorldItemRegistration.ARKOSE_ROCK_COPPER_ORE.get()
        );
        tag(ItemTagCatalog.BRANCH).add(
                WorldItemRegistration.OAK_BRANCH.get(),
                WorldItemRegistration.BIRCH_BRANCH.get(),
                WorldItemRegistration.SPRUCE_BRANCH.get(),
                WorldItemRegistration.JUNGLE_BRANCH.get(),
                WorldItemRegistration.ACACIA_BRANCH.get(),
                WorldItemRegistration.DARK_OAK_BRANCH.get(),
                WorldItemRegistration.CHERRY_BRANCH.get(),
                WorldItemRegistration.MANGROVE_BRANCH.get()
        );

        tag(ItemTagCatalog.TINDER)
                .add(ItemRegistration.THATCH.get());
        // Candlenut leaves?

        tag(ItemTagCatalog.BARK).add(
                WoodWorkingItemRegistration.WHITE_BARK.get(),
                WoodWorkingItemRegistration.BROWN_BARK.get(),
                WoodWorkingItemRegistration.GREY_BARK.get(),
                WoodWorkingItemRegistration.DARK_BROWN_BARK.get(),
                WoodWorkingItemRegistration.BLACK_BARK.get()
        );

        tag(ItemTagCatalog.CLAY_FLUX).add(
                ItemRegistration.WOOD_ASH.get(),
                WoodWorkingItemRegistration.POTASH.get()
        );

        tag(ItemTagCatalog.WET_BRICK).add(
                ClayWorkingItemRegistration.DRYING_CLAY_BRICK.get()
        );

        tag(ItemTagCatalog.GOAT_HORN_MATERIAL).add(
                Items.GOAT_HORN,
                KnappingItemRegistration.BROKEN_GOAT_HORN.get()
        );

        tag(ItemTagCatalog.SMALL_TOOL_HANDLE).add(
                Items.STICK
        );
        tag(ItemTagCatalog.LARGE_TOOL_HANDLE).add(
                WoodWorkingItemRegistration.TOOL_HANDLE.get()
        );
        tag(ItemTagCatalog.TOOL_BINDING).add(
                Items.STRING,
                WeavingItemRegistration.FLAX_FIBER.get()
        );

        tag(ItemTagCatalog.CARVING_TOOL).add(
                KnappingItemRegistration.ROCK_KNIFE.get(),
                KnappingItemRegistration.BONE_KNIFE.get(),
                KnappingItemRegistration.FLINT_KNIFE.get()
        );
        tag(ItemTagCatalog.KNAP_TOOL)
                .addTag(ItemTagCatalog.HARD_ROCK);
    }

    public void registerBlockTags()
    {
        tag(ItemTagCatalog.SEDIMENTARY_WG_STONES).add(
                WorldItemRegistration.GREYWACKE.get(),
                WorldItemRegistration.SILTSTONE.get(),
                WorldItemRegistration.DOLOSTONE.get(),
                WorldItemRegistration.LIMESTONE.get(),
                WorldItemRegistration.CHALK.get(),
                WorldItemRegistration.IRONSTONE.get(),
                WorldItemRegistration.SHALE.get(),
                WorldItemRegistration.ARKOSE.get()
        );
    }

    public void registerBlockItemNeoForgeCompatibilityTags()
    {
        tag(Tags.Items.INGOTS).add(
                ClayWorkingItemRegistration.CHINA_CLAY_BRICK.get(),
                ClayWorkingItemRegistration.REFRACTORY_CLAY_BRICK.get(),
                MudWorkingItemRegistration.PACKED_MUD_BRICK.get(),
                MudWorkingItemRegistration.DAUB_BRICKS.get()
        );
        // Gravel
        tag(Tags.Items.GRAVELS).add(
                WorldItemRegistration.SILT.get()
        );

        // Ashfall & Regolith // Do not add these to Tags.Blocks.COBBLESTONES, they are too soft
        // BlockRegistration.COBBLED_CHALK.get(),

        // Sedimentary
        tag(Tags.Items.STONES).add(
                WorldItemRegistration.GREYWACKE.get(),
                WorldItemRegistration.SILTSTONE.get(),
                WorldItemRegistration.DOLOSTONE.get(),
                WorldItemRegistration.LIMESTONE.get(), // not chalk
                WorldItemRegistration.IRONSTONE.get(),
                WorldItemRegistration.SHALE.get()
        );
        tag(Tags.Items.COBBLESTONES_NORMAL).add( // Only those of equal hardness as greywacke cobblestone
                WorldItemRegistration.COBBLED_GREYWACKE.get(),
                WorldItemRegistration.COBBLED_SILTSTONE.get(),
                WorldItemRegistration.COBBLED_DOLOSTONE.get(),
                WorldItemRegistration.COBBLED_LIMESTONE.get(), // not chalk
                WorldItemRegistration.COBBLED_IRONSTONE.get(),
                WorldItemRegistration.COBBLED_SHALE.get()
        );
        tag(Tags.Items.COBBLESTONES_MOSSY);
        tag(Tags.Items.COBBLESTONES_INFESTED);
        tag(Tags.Items.COBBLESTONES).add( // Everything from NORMAL, MOSSY and INFESTED
                WorldItemRegistration.COBBLED_GREYWACKE.get(),
                WorldItemRegistration.COBBLED_SILTSTONE.get(),
                WorldItemRegistration.COBBLED_DOLOSTONE.get(),
                WorldItemRegistration.COBBLED_LIMESTONE.get(),
                WorldItemRegistration.COBBLED_IRONSTONE.get(),
                WorldItemRegistration.COBBLED_SHALE.get(),
                WorldItemRegistration.COBBLED_ARKOSE.get()
        );
        tag(Tags.Items.ORE_BEARING_GROUND_STONE)
                .addTag(ItemTagCatalog.SEDIMENTARY_WG_STONES);

        // Metamorphic & Soft Igneous Extrusive // Harder than vanilla stone

        // Igneous Intrusive & Hard Igneous Extrusive
        tag(Tags.Items.COBBLESTONES_DEEPSLATE).add( // Only those of equal hardness as gabbro
                WorldItemRegistration.COBBLED_GABBRO.get()
        );

        // Deep Igneous Intrusive // Harder than vanilla deepslate
        tag(Tags.Items.ORE_BEARING_GROUND_DEEPSLATE).add( // TODO This may not be the best idea
                WorldItemRegistration.GABBRO.get(),
                WorldItemRegistration.SMOOTH_DIORITE.get(),
                WorldItemRegistration.ROUGH_DIORITE.get()
                //BlockRegistration.ANDESITE.get(),
                //BlockRegistration.BASALT.get()
        );

        tag(Tags.Items.ORES_COPPER).add(
                WorldItemRegistration.GREYWACKE_COPPER_ORE.get(),
                WorldItemRegistration.SILTSTONE_COPPER_ORE.get(),
                WorldItemRegistration.DOLOSTONE_COPPER_ORE.get(),
                WorldItemRegistration.LIMESTONE_COPPER_ORE.get(),
                WorldItemRegistration.CHALK_COPPER_ORE.get(),
                WorldItemRegistration.IRONSTONE_COPPER_ORE.get(),
                WorldItemRegistration.SHALE_COPPER_ORE.get(),
                WorldItemRegistration.ARKOSE_COPPER_ORE.get(),
                WorldItemRegistration.MARBLE_COPPER_ORE.get(),
                WorldItemRegistration.QUARTZITE_COPPER_ORE.get(),
                WorldItemRegistration.HORNFELS_COPPER_ORE.get(),
                WorldItemRegistration.SLATE_COPPER_ORE.get()
        );
        tag(Tags.Items.ORES_IRON).add(
                WorldItemRegistration.GABBRO_IRON_ORE.get(),
                WorldItemRegistration.SMOOTH_DIORITE_IRON_ORE.get(),
                WorldItemRegistration.SMOOTH_GRANITE_IRON_ORE.get(),
                WorldItemRegistration.NORITE_IRON_ORE.get(),
                WorldItemRegistration.PERIDOTITE_IRON_ORE.get(),
                WorldItemRegistration.RHYOLITE_IRON_ORE.get(),
                WorldItemRegistration.DACITE_IRON_ORE.get(),
                WorldItemRegistration.ANDESITE_IRON_ORE.get(),
                WorldItemRegistration.BASALT_IRON_ORE.get()
        );
        tag(Tags.Items.ORES_GOLD).add(
                WorldItemRegistration.GREYWACKE_GOLD_ORE.get(),
                WorldItemRegistration.SILTSTONE_GOLD_ORE.get(),
                WorldItemRegistration.DOLOSTONE_GOLD_ORE.get(),
                WorldItemRegistration.LIMESTONE_GOLD_ORE.get(),
                WorldItemRegistration.CHALK_GOLD_ORE.get(),
                WorldItemRegistration.IRONSTONE_GOLD_ORE.get(),
                WorldItemRegistration.SHALE_GOLD_ORE.get(),
                WorldItemRegistration.ARKOSE_GOLD_ORE.get(),
                WorldItemRegistration.MARBLE_GOLD_ORE.get(),
                WorldItemRegistration.QUARTZITE_GOLD_ORE.get(),
                WorldItemRegistration.HORNFELS_GOLD_ORE.get(),
                WorldItemRegistration.SLATE_GOLD_ORE.get(),
                WorldItemRegistration.GABBRO_GOLD_ORE.get(),
                WorldItemRegistration.SMOOTH_DIORITE_GOLD_ORE.get(),
                WorldItemRegistration.SMOOTH_GRANITE_GOLD_ORE.get(),
                WorldItemRegistration.NORITE_GOLD_ORE.get(),
                WorldItemRegistration.PERIDOTITE_GOLD_ORE.get(),
                WorldItemRegistration.RHYOLITE_GOLD_ORE.get(),
                WorldItemRegistration.DACITE_GOLD_ORE.get(),
                WorldItemRegistration.ANDESITE_GOLD_ORE.get(),
                WorldItemRegistration.BASALT_GOLD_ORE.get()
        );
        tag(Tags.Items.ORES_COAL).add(
                WorldItemRegistration.SAPROLITE_COAL_ORE.get(),
                WorldItemRegistration.LATERITE_COAL_ORE.get(),
                WorldItemRegistration.GREYWACKE_COAL_ORE.get(),
                WorldItemRegistration.SILTSTONE_COAL_ORE.get(),
                WorldItemRegistration.DOLOSTONE_COAL_ORE.get(),
                WorldItemRegistration.LIMESTONE_COAL_ORE.get(),
                WorldItemRegistration.CHALK_COAL_ORE.get(),
                WorldItemRegistration.IRONSTONE_COAL_ORE.get(),
                WorldItemRegistration.SHALE_COAL_ORE.get(),
                WorldItemRegistration.ARKOSE_COAL_ORE.get(),
                WorldItemRegistration.MARBLE_COAL_ORE.get(),
                WorldItemRegistration.QUARTZITE_COAL_ORE.get(),
                WorldItemRegistration.HORNFELS_COAL_ORE.get(),
                WorldItemRegistration.SLATE_COAL_ORE.get()
        );
        tag(Tags.Items.ORES_DIAMOND).add(
                WorldItemRegistration.GABBRO_DIAMOND_ORE.get(),
                WorldItemRegistration.SMOOTH_DIORITE_DIAMOND_ORE.get(),
                WorldItemRegistration.SMOOTH_GRANITE_DIAMOND_ORE.get(),
                WorldItemRegistration.NORITE_DIAMOND_ORE.get(),
                WorldItemRegistration.PERIDOTITE_DIAMOND_ORE.get(),
                WorldItemRegistration.ANDESITE_DIAMOND_ORE.get(),
                WorldItemRegistration.BASALT_DIAMOND_ORE.get()
        );
        tag(Tags.Items.ORES_EMERALD).add(
                WorldItemRegistration.GABBRO_EMERALD_ORE.get(),
                WorldItemRegistration.SMOOTH_DIORITE_EMERALD_ORE.get(),
                WorldItemRegistration.SMOOTH_GRANITE_EMERALD_ORE.get(),
                WorldItemRegistration.NORITE_EMERALD_ORE.get(),
                WorldItemRegistration.PERIDOTITE_EMERALD_ORE.get(),
                WorldItemRegistration.RHYOLITE_EMERALD_ORE.get(),
                WorldItemRegistration.DACITE_EMERALD_ORE.get(),
                WorldItemRegistration.ANDESITE_EMERALD_ORE.get(),
                WorldItemRegistration.BASALT_EMERALD_ORE.get()
        );
        tag(Tags.Items.ORES_LAPIS).add(
                WorldItemRegistration.MARBLE_LAPIS_ORE.get(),
                WorldItemRegistration.QUARTZITE_LAPIS_ORE.get(),
                WorldItemRegistration.HORNFELS_LAPIS_ORE.get(),
                WorldItemRegistration.SLATE_LAPIS_ORE.get()
        );
        tag(Tags.Items.ORES_REDSTONE).add(
                WorldItemRegistration.GABBRO_REDSTONE_ORE.get(),
                WorldItemRegistration.SMOOTH_DIORITE_REDSTONE_ORE.get(),
                WorldItemRegistration.SMOOTH_GRANITE_REDSTONE_ORE.get(),
                WorldItemRegistration.NORITE_REDSTONE_ORE.get(),
                WorldItemRegistration.PERIDOTITE_REDSTONE_ORE.get()
        );

        tag(Tags.Items.ORES_QUARTZ);

        tag(ItemTagCatalog.ORES_TIN);

        tag(ItemTagCatalog.ORES_CHERT).add(
                WorldItemRegistration.LIMESTONE_CHERT_ORE.get(),
                WorldItemRegistration.CHALK_CHERT_ORE.get()
        );

        tag(ItemTagCatalog.ORES_GEODE).add(
                WorldItemRegistration.BASALT_GEODE_ORE.get(),
                WorldItemRegistration.ANDESITE_GEODE_ORE.get(),
                WorldItemRegistration.RHYOLITE_GEODE_ORE.get(),
                WorldItemRegistration.DACITE_GEODE_ORE.get()
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
                WorldItemRegistration.COBBLED_SANDSTONE.get(),
                WorldItemRegistration.COBBLED_RED_SANDSTONE.get()
        );
        tag(Tags.Items.SANDSTONE_UNCOLORED_BLOCKS).add(
                WorldItemRegistration.COBBLED_SANDSTONE.get()
        );
        tag(Tags.Items.SANDSTONE_RED_BLOCKS).add(
                WorldItemRegistration.COBBLED_RED_SANDSTONE.get()
        );
    }

    public void registerItemNeoForgeCompatibilityTags()
    {
        tag(Tags.Items.CROPS).add(
                FarmingItemRegistration.BLUEBERRIES.get(),
                FarmingItemRegistration.RASPBERRIES.get(),
                FarmingItemRegistration.STRAWBERRIES.get(),
                FarmingItemRegistration.BARLEY.get(),
                FarmingItemRegistration.OATS.get(),
                FarmingItemRegistration.YAM.get(),
                FarmingItemRegistration.FLAX.get()
        );

        tag(Tags.Items.SEEDS).add(
                FarmingItemRegistration.BARLEY_SEEDS.get(),
                FarmingItemRegistration.OAT_SEEDS.get(),
                FarmingItemRegistration.FLAX_SEEDS.get()
        );

        tag(Tags.Items.MUSHROOMS);

        tag(Tags.Items.FOODS).add(
                FarmingItemRegistration.BLUEBERRIES.get(),
                FarmingItemRegistration.RASPBERRIES.get(),
                FarmingItemRegistration.STRAWBERRIES.get(),
                FarmingItemRegistration.YAM.get(),
                CookingItemRegistration.BAKED_YAM.get(),
                CookingItemRegistration.BAKED_BEETROOT.get(),
                CookingItemRegistration.BAKED_CARROT.get()
        );

        tag(Tags.Items.FOODS_BERRY).add(
                FarmingItemRegistration.BLUEBERRIES.get(),
                FarmingItemRegistration.RASPBERRIES.get(),
                FarmingItemRegistration.STRAWBERRIES.get()
        );

        tag(Tags.Items.DUSTS).add(
                CookingItemRegistration.CRACKED_BARLEY.get(),
                CookingItemRegistration.CRACKED_WHEAT.get(),
                CookingItemRegistration.ROLLED_OATS.get(),
                CookingItemRegistration.FLOUR.get()
        );

        tag(Tags.Items.GEMS);

        tag(Tags.Items.RAW_MATERIALS);
        tag(Tags.Items.RAW_MATERIALS_COPPER);
        tag(Tags.Items.RAW_MATERIALS_GOLD);
        tag(Tags.Items.RAW_MATERIALS_IRON);

        tag(Tags.Items.TOOLS).add(
                WoodWorkingItemRegistration.FIRE_STARTER.get()
        );
        tag(Tags.Items.TOOLS_IGNITER).add(
                WoodWorkingItemRegistration.FIRE_STARTER.get()
        );
        tag(Tags.Items.MINING_TOOL_TOOLS);
    }
}
