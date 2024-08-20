package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.registry.ItemRegistration;
import io.github.zephyrwolf.medievalism.registry.BlockRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BaseItemModels extends ItemModelProvider
{
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public BaseItemModels(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        {
            blockBasedModel(BlockRegistration.RED_CLAY_BLOCK_ITEM.get(), "");
            blockBasedModel(BlockRegistration.LIMESTONE_ITEM.get(), "");
            blockIconGeneratedModel(BlockRegistration.BRANCH_ITEM.get());
            blockIconGeneratedModel(BlockRegistration.LARGE_ROCK_ITEM.get());
            blockIconGeneratedModel(BlockRegistration.ROCK_ITEM.get());
            blockIconGeneratedModel(BlockRegistration.LIMESTONE_ROCK_ITEM.get());
            blockIconGeneratedModel(BlockRegistration.COPPER_ROCK_ITEM.get());
            blockBasedModel(BlockRegistration.THATCH_BLOCK_ITEM.get(), "");
        }



        { // World
            itemGeneratedModel(ItemRegistration.RED_CLAY_BALL.get());
            itemGeneratedModel(ItemRegistration.RAW_TIN.get());
            blockBasedModel(BlockRegistration.TIN_ORE_BLOCK_ITEM.get(), "");
            blockBasedModel(BlockRegistration.DEEPSLATE_TIN_ORE_BLOCK_ITEM.get(), "");
            itemGeneratedModel(ItemRegistration.DOG_BANE.get());
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
            itemGeneratedModel(ItemRegistration.UNFIRED_JUG.get());
            itemGeneratedModel(ItemRegistration.JUG.get());
            itemGeneratedModel(ItemRegistration.UNFIRED_CRUCIBLE.get());
            itemGeneratedModel(ItemRegistration.CRUCIBLE.get());
        }
        itemGeneratedModel(ItemRegistration.BROKEN_GOAT_HORN.get());
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

        { // Misc
            itemGeneratedModel(ItemRegistration.QUICK_LIME.get());
            itemGeneratedModel(ItemRegistration.THATCH.get());
            itemGeneratedModel(ItemRegistration.CHOPPED_WOOD.get());
            itemGeneratedModel(ItemRegistration.SLACKED_LIME_BUCKET.get());
            itemGeneratedModel(ItemRegistration.TANNIN_BUCKET.get());
            itemGeneratedModel(ItemRegistration.DIGGING_STICK.get());
            itemGeneratedModel(ItemRegistration.FIRE_STARTER.get());
        }
    }

    private String itemName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public void blockBasedModel(Item item, String suffix)
    {
        withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
    }

    public void blockIconGeneratedModel(Item item)
    {
        blockIconGeneratedModel(item, resourceBlock(itemName(item)));
    }

    public void blockIconGeneratedModel(Item item, ResourceLocation texture)
    {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    public void itemHandheldModel(Item item, ResourceLocation texture)
    {
        withExistingParent(itemName(item), HANDHELD).texture("layer0", texture);
    }

    public void itemGeneratedModel(Item item)
    {
        itemGeneratedModel(item, resourceItem(itemName(item)));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture)
    {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    public ResourceLocation resourceBlock(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return ResourceLocation.fromNamespaceAndPath(MedievalismConstants.MOD_ID, "item/" + path);
    }
}
