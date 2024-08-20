package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
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
            blockBasedModel(Registration.RED_CLAY_BLOCK_ITEM.get(), "");
            blockBasedModel(Registration.LIMESTONE_ITEM.get(), "");
            blockIconGeneratedModel(Registration.BRANCH_ITEM.get());
            blockIconGeneratedModel(Registration.LARGE_ROCK_ITEM.get());
            blockIconGeneratedModel(Registration.ROCK_ITEM.get());
            blockIconGeneratedModel(Registration.LIMESTONE_ROCK_ITEM.get());
            blockIconGeneratedModel(Registration.COPPER_ROCK_ITEM.get());
            blockBasedModel(Registration.THATCH_BLOCK_ITEM.get(), "");
        }



        { // World
            itemGeneratedModel(Registration.RED_CLAY_BALL.get());
            itemGeneratedModel(Registration.DOG_BANE.get());
            itemGeneratedModel(Registration.FLAX.get());
            itemGeneratedModel(Registration.FLAX_SEEDS.get());
            itemGeneratedModel(Registration.FLAX_FIBER.get());
            // Wild Potato
            // Wild Carrot
            // Wild Beetroot
            // Wild Yam
            // Branch
            // Rocks
        }
        { // Farming

            itemGeneratedModel(Registration.BLUEBERRIES.get());
            itemGeneratedModel(Registration.RASPBERRIES.get());
            itemGeneratedModel(Registration.STRAWBERRIES.get());
            itemGeneratedModel(Registration.BARLEY_SEEDS.get());
            itemGeneratedModel(Registration.BARLEY.get());
            itemGeneratedModel(Registration.OAT_SEEDS.get());
            itemGeneratedModel(Registration.OATS.get());
            itemGeneratedModel(Registration.YAM.get());
            itemGeneratedModel(Registration.BAKED_YAM.get());
            itemGeneratedModel(Registration.BAKED_BEETROOT.get());
            itemGeneratedModel(Registration.BAKED_CARROT.get());
            itemGeneratedModel(Registration.CRACKED_BARLEY.get());
            itemGeneratedModel(Registration.CRACKED_WHEAT.get());
            itemGeneratedModel(Registration.ROLLED_OATS.get());
            itemGeneratedModel(Registration.FLOUR.get());
            itemGeneratedModel(Registration.DOUGH.get());
        }
        { // Knapping
            itemGeneratedModel(Registration.HAMMERSTONE.asItem());
            itemGeneratedModel(Registration.LUNATE.get());
            itemGeneratedModel(Registration.BIFACE.get());
        }
        { // Pottery
            itemGeneratedModel(Registration.UNFIRED_BRICK.get());
            itemGeneratedModel(Registration.UNFIRED_JUG.get());
            itemGeneratedModel(Registration.JUG.get());
            itemGeneratedModel(Registration.UNFIRED_CRUCIBLE.get());
            itemGeneratedModel(Registration.CRUCIBLE.get());
        }
        itemGeneratedModel(Registration.BROKEN_GOAT_HORN.get());
        { // Leather Working
            // Hide
            itemGeneratedModel(Registration.COW_HIDE.get());
            itemGeneratedModel(Registration.CAMEL_HIDE.get());
            itemGeneratedModel(Registration.DONKEY_HIDE.get());
            itemGeneratedModel(Registration.HOGLIN_HIDE.get());
            itemGeneratedModel(Registration.HORSE_HIDE.get());
            itemGeneratedModel(Registration.MOOSHROOM_HIDE.get());
            itemGeneratedModel(Registration.MULE_HIDE.get());
            //itemGeneratedModel(Registration.RABBIT_HIDE.get());
            itemGeneratedModel(Registration.RAVAGER_HIDE.get()); // Should this be extra large?
            itemGeneratedModel(Registration.SHEEP_HIDE.get());
            itemGeneratedModel(Registration.FOX_HIDE.get());
            itemGeneratedModel(Registration.SNOW_FOX_HIDE.get()); // Unobtainable
            itemGeneratedModel(Registration.WOLF_HIDE.get()); // Only one variable
            itemGeneratedModel(Registration.OCELOT_HIDE.get());
            itemGeneratedModel(Registration.CAT_HIDE.get()); // Only one variable
            itemGeneratedModel(Registration.BAT_HIDE.get());
            itemGeneratedModel(Registration.CAT_HIDE.get()); // Only one variable
            itemGeneratedModel(Registration.GOAT_HIDE.get());
            itemGeneratedModel(Registration.LLAMA_HIDE.get());
            itemGeneratedModel(Registration.PANDA_HIDE.get());
            itemGeneratedModel(Registration.PIG_HIDE.get());
            itemGeneratedModel(Registration.POLAR_BEAR_HIDE.get());
            itemGeneratedModel(Registration.SNIFFER_HIDE.get());

            // Leather
            itemGeneratedModel(Registration.LARGE_LIMED_HIDE.get());
            itemGeneratedModel(Registration.MEDIUM_LIMED_HIDE.get());
            itemGeneratedModel(Registration.SMALL_LIMED_HIDE.get());
            itemGeneratedModel(Registration.LARGE_RAW_HIDE.get());
            itemGeneratedModel(Registration.MEDIUM_RAW_HIDE.get());
            itemGeneratedModel(Registration.SMALL_RAW_HIDE.get());
            itemGeneratedModel(Registration.LARGE_WET_LEATHER.get());
            itemGeneratedModel(Registration.MEDIUM_WET_LEATHER.get());
            itemGeneratedModel(Registration.SMALL_WET_LEATHER.get());
            // Large Leather -> minecraft:leather
            itemGeneratedModel(Registration.MEDIUM_LEATHER.get());
            itemGeneratedModel(Registration.SMALL_LEATHER.get());
        }

        { // Misc
            itemGeneratedModel(Registration.QUICK_LIME.get());
            itemGeneratedModel(Registration.THATCH.get());
            itemGeneratedModel(Registration.CHOPPED_WOOD.get());
            itemGeneratedModel(Registration.SLACKED_LIME_BUCKET.get());
            itemGeneratedModel(Registration.TANNIN_BUCKET.get());
            itemGeneratedModel(Registration.DIGGING_STICK.get());
            itemGeneratedModel(Registration.FIRE_STARTER.get());
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
