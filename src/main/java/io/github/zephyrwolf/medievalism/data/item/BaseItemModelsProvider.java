package io.github.zephyrwolf.medievalism.data.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.item.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BaseItemModelsProvider extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public BaseItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        {
            blockBasedModel(BlockItemRegistration.BIRCH_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.OAK_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.SPRUCE_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.JUNGLE_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.ACACIA_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.DARK_OAK_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.CHERRY_BRANCH.get(), "");
            blockBasedModel(BlockItemRegistration.MANGROVE_BRANCH.get(), "");

            blockBasedModel(BlockItemRegistration.ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SANDSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.RED_SANDSTONE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.MOSSY_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LIGHTER_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SNOWY_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.ICE_ROCK.get(), "1");

            blockBasedModel(BlockItemRegistration.LARGE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SANDSTONE_LARGE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.RED_SANDSTONE_LARGE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.MOSSY_LARGE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.LIGHTER_LARGE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.SNOWY_LARGE_ROCK.get(), "1");
            blockBasedModel(BlockItemRegistration.ICE_LARGE_ROCK.get(), "1");

            blockBasedModel(BlockItemRegistration.RED_CLAY_BLOCK.get(), "");
            blockBasedModel(BlockItemRegistration.LIMESTONE.get(), "");
            blockBasedModel(BlockItemRegistration.WET_PACKED_MUD.get(), "");
            blockIconGeneratedModel(BlockItemRegistration.LIMESTONE_ROCK.get());
            blockIconGeneratedModel(BlockItemRegistration.COPPER_ROCK.get());
            blockBasedModel(BlockItemRegistration.THATCH_BLOCK.get(), "");
            itemGeneratedModel(BlockItemRegistration.DOGBANE_BLOCK_ITEM.get());
            blockBasedModel(BlockItemRegistration.STONE_BENCH.get(), "");
            blockBasedModel(BlockItemRegistration.CHOPPING_BLOCK.get(), "");

            itemGeneratedModel(ItemRegistration.MUD_BALL.get());
            itemGeneratedModel(BlockItemRegistration.WET_PACKED_MUD_BRICK.get());
            itemGeneratedModel(ItemRegistration.PACKED_MUD_BRICK.get());
        }

        blockBasedModel(BlockItemRegistration.WET_GATHERERS_JAR.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_GATHERERS_JAR.get(), "");
        blockBasedModel(BlockItemRegistration.GATHERERS_JAR.get(), "");

        blockBasedModel(BlockItemRegistration.WET_KEEPERS_CROCK.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_KEEPERS_CROCK.get(), "");
        blockBasedModel(BlockItemRegistration.KEEPERS_CROCK.get(), "");

        blockBasedModel(BlockItemRegistration.WET_SETTLERS_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_SETTLERS_POT.get(), "");
        blockBasedModel(BlockItemRegistration.SETTLERS_POT.get(), "");

        blockBasedModel(BlockItemRegistration.WET_CLAY_COOKING_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_CLAY_COOKING_POT.get(), "");
        blockBasedModel(BlockItemRegistration.CLAY_COOKING_POT.get(), "");

        blockBasedModel(BlockItemRegistration.WET_CLAY_CAULDRON.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_CLAY_CAULDRON.get(), "");
        blockBasedModel(BlockItemRegistration.CLAY_CAULDRON.get(), "");

        blockBasedModel(BlockItemRegistration.WET_JUG.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_JUG.get(), "");
        blockBasedModel(BlockItemRegistration.JUG.get(), "");

        blockBasedModel(BlockItemRegistration.WET_FLOWER_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_FLOWER_POT.get(), "");

        blockBasedModel(BlockItemRegistration.WET_DECORATED_POT.get(), "");
        blockBasedModel(BlockItemRegistration.DRY_DECORATED_POT.get(), "");

        //withExistingParent(itemName(BlockRegistration.WET_GATHERERS_JAR_ITEM.get()), resourceBlock(blockName(BlockRegistration.DRYING_GATHERERS_JAR) + "_wet"));

        { // World
            itemGeneratedModel(ItemRegistration.RED_CLAY_BALL.get());
            itemGeneratedModel(ItemRegistration.RAW_TIN.get());
            blockBasedModel(BlockItemRegistration.TIN_ORE_BLOCK.get(), "");
            blockBasedModel(BlockItemRegistration.DEEPSLATE_TIN_ORE_BLOCK.get(), "");
            itemGeneratedModel(ItemRegistration.FLAX.get());
            itemGeneratedModel(ItemRegistration.FLAX_SEEDS.get());
            itemGeneratedModel(ItemRegistration.FLAX_FIBER.get());

            // Wild Potato
            // Wild Carrot
            // Wild Beetroot
            // Wild Yam
            // Branch
            // Rocks
        }
        { // Farming

            itemGeneratedModel(ItemRegistration.BLUEBERRIES.get());
            itemGeneratedModel(ItemRegistration.RASPBERRIES.get());
            itemGeneratedModel(ItemRegistration.STRAWBERRIES.get());
            itemGeneratedModel(ItemRegistration.BARLEY_SEEDS.get());
            itemGeneratedModel(ItemRegistration.BARLEY.get());
            itemGeneratedModel(ItemRegistration.OAT_SEEDS.get());
            itemGeneratedModel(ItemRegistration.OATS.get());
            itemGeneratedModel(ItemRegistration.YAM.get());
            itemGeneratedModel(ItemRegistration.BAKED_YAM.get());
            itemGeneratedModel(ItemRegistration.BAKED_BEETROOT.get());
            itemGeneratedModel(ItemRegistration.BAKED_CARROT.get());
            itemGeneratedModel(ItemRegistration.CRACKED_BARLEY.get());
            itemGeneratedModel(ItemRegistration.CRACKED_WHEAT.get());
            itemGeneratedModel(ItemRegistration.ROLLED_OATS.get());
            itemGeneratedModel(ItemRegistration.FLOUR.get());
            itemGeneratedModel(ItemRegistration.DOUGH.get());
        }
        { // Knapping
            itemGeneratedModel(ItemRegistration.HAMMERSTONE.asItem());
            itemGeneratedModel(ItemRegistration.LUNATE.get());
            itemGeneratedModel(ItemRegistration.BIFACE.get());
        }
        { // Pottery
            itemGeneratedModel(ItemRegistration.UNFIRED_BRICK.get());
            //itemGeneratedModel(ItemRegistration.UNFIRED_BIRCH_POT.get());
        }
        itemGeneratedModel(ItemRegistration.BROKEN_GOAT_HORN.get());
        { // Bark
            itemGeneratedModel(ItemRegistration.WHITE_BARK.get());
            itemGeneratedModel(ItemRegistration.BROWN_BARK.get());
            itemGeneratedModel(ItemRegistration.GREY_BARK.get());
            itemGeneratedModel(ItemRegistration.DARK_BROWN_BARK.get());
            itemGeneratedModel(ItemRegistration.BLACK_BARK.get());
        }
        { // Leather Working
            // Hide
            itemGeneratedModel(ItemRegistration.COW_HIDE.get());
            itemGeneratedModel(ItemRegistration.CAMEL_HIDE.get());
            itemGeneratedModel(ItemRegistration.DONKEY_HIDE.get());
            itemGeneratedModel(ItemRegistration.HOGLIN_HIDE.get());
            itemGeneratedModel(ItemRegistration.HORSE_HIDE.get());
            itemGeneratedModel(ItemRegistration.MOOSHROOM_HIDE.get());
            itemGeneratedModel(ItemRegistration.MULE_HIDE.get());
            // Rabbit Hide -> minecraft:rabbit_hide
            itemGeneratedModel(ItemRegistration.RAVAGER_HIDE.get()); // Should this be extra large?
            itemGeneratedModel(ItemRegistration.SHEEP_HIDE.get());
            itemGeneratedModel(ItemRegistration.FOX_HIDE.get());
            itemGeneratedModel(ItemRegistration.SNOW_FOX_HIDE.get()); // Unobtainable
            itemGeneratedModel(ItemRegistration.WOLF_HIDE.get()); // Only one variable
            itemGeneratedModel(ItemRegistration.OCELOT_HIDE.get());
            itemGeneratedModel(ItemRegistration.CAT_HIDE.get()); // Only one variable
            itemGeneratedModel(ItemRegistration.BAT_HIDE.get());
            itemGeneratedModel(ItemRegistration.CAT_HIDE.get()); // Only one variable
            itemGeneratedModel(ItemRegistration.GOAT_HIDE.get());
            itemGeneratedModel(ItemRegistration.LLAMA_HIDE.get());
            itemGeneratedModel(ItemRegistration.PANDA_HIDE.get());
            itemGeneratedModel(ItemRegistration.PIG_HIDE.get());
            itemGeneratedModel(ItemRegistration.POLAR_BEAR_HIDE.get());
            itemGeneratedModel(ItemRegistration.SNIFFER_HIDE.get());

            // Leather
            itemGeneratedModel(ItemRegistration.LARGE_LIMED_HIDE.get());
            itemGeneratedModel(ItemRegistration.MEDIUM_LIMED_HIDE.get());
            itemGeneratedModel(ItemRegistration.SMALL_LIMED_HIDE.get());
            itemGeneratedModel(ItemRegistration.LARGE_RAW_HIDE.get());
            itemGeneratedModel(ItemRegistration.MEDIUM_RAW_HIDE.get());
            itemGeneratedModel(ItemRegistration.SMALL_RAW_HIDE.get());
            itemGeneratedModel(ItemRegistration.LARGE_WET_LEATHER.get());
            itemGeneratedModel(ItemRegistration.MEDIUM_WET_LEATHER.get());
            itemGeneratedModel(ItemRegistration.SMALL_WET_LEATHER.get());
            // Large Leather -> minecraft:leather
            itemGeneratedModel(ItemRegistration.MEDIUM_LEATHER.get());
            itemGeneratedModel(ItemRegistration.SMALL_LEATHER.get());
        }
        { // Metallurgy
            itemGeneratedModel(ItemRegistration.CHARCOAL_POWDER.get());
            itemGeneratedModel(ItemRegistration.FIRECLAY.get());
            itemGeneratedModel(ItemRegistration.POTASH.get());
            itemGeneratedModel(ItemRegistration.REFRACTORY_CLAY.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_CLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.CLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_FIRECLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.FIRECLAY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_REFRACTORY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.REFRACTORY_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.COPPER_ORE_DUST.get());
            itemGeneratedModel(ItemRegistration.TIN_ORE_DUST.get());
            itemGeneratedModel(ItemRegistration.IRON_ORE_DUST.get());
        }
        { // Misc
            itemGeneratedModel(ItemRegistration.QUICK_LIME.get());
            itemGeneratedModel(ItemRegistration.THATCH.get());
            itemGeneratedModel(ItemRegistration.CHOPPED_WOOD.get());
            itemGeneratedModel(ItemRegistration.SLACKED_LIME_BUCKET.get());
            itemGeneratedModel(ItemRegistration.TANNIN_BUCKET.get());
            itemGeneratedModel(ItemRegistration.DIGGING_STICK.get());
            itemGeneratedModel(ItemRegistration.FIRE_STARTER.get());
            itemGeneratedModel(ItemRegistration.WOOD_ASH.get());
        }
    }

    private String itemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public void blockBasedModel(Item item, String suffix) {
        withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
    }

    public void blockIconGeneratedModel(Item item) {
        blockIconGeneratedModel(item, resourceBlock(itemName(item)));
    }

    public void blockIconGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    @SuppressWarnings("unused")
    public void itemHandheldModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), HANDHELD).texture("layer0", texture);
    }

    public void itemGeneratedModel(Item item) {
        itemGeneratedModel(item, resourceItem(itemName(item)));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "item/" + path);
    }
}
