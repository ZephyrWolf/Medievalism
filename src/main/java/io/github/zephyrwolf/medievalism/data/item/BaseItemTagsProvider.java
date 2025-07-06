package io.github.zephyrwolf.medievalism.data.item;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.content.blockitem.BlockItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemRegistration;
import io.github.zephyrwolf.medievalism.content.item.ItemTagCatalog;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.registerVanillaTags();
        this.registerModTags();
        this.registerCommonModTags();
        this.registerCompatibilityTags();
    }

    private void registerVanillaTags() {

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
                BlockItemRegistration.ROCK.get(),
                BlockItemRegistration.SANDSTONE_ROCK.get(),
                BlockItemRegistration.RED_SANDSTONE_ROCK.get(),
                BlockItemRegistration.MOSSY_ROCK.get(),
                BlockItemRegistration.LIGHTER_ROCK.get(),
                BlockItemRegistration.SNOWY_ROCK.get(),
                BlockItemRegistration.ICE_ROCK.get(),
                BlockItemRegistration.COPPER_ROCK.get(),
                BlockItemRegistration.LIMESTONE.get()
        );
        tag(ItemTagCatalog.HARD_ROCK).add(
                BlockItemRegistration.ROCK.get(),
                BlockItemRegistration.MOSSY_ROCK.get(),
                BlockItemRegistration.LIGHTER_ROCK.get(),
                BlockItemRegistration.SNOWY_ROCK.get(),
                BlockItemRegistration.ICE_ROCK.get(),
                BlockItemRegistration.COPPER_ROCK.get(),
                BlockItemRegistration.LIMESTONE.get()
        );
        tag(ItemTagCatalog.LARGE_ROCK).add(
                BlockItemRegistration.LARGE_ROCK.get(),
                BlockItemRegistration.SANDSTONE_LARGE_ROCK.get(),
                BlockItemRegistration.RED_SANDSTONE_LARGE_ROCK.get(),
                BlockItemRegistration.MOSSY_LARGE_ROCK.get(),
                BlockItemRegistration.LIGHTER_LARGE_ROCK.get(),
                BlockItemRegistration.SNOWY_LARGE_ROCK.get(),
                BlockItemRegistration.ICE_LARGE_ROCK.get()
        );
        tag(ItemTagCatalog.LARGE_HARD_ROCK).add(
                BlockItemRegistration.LARGE_ROCK.get(),
                BlockItemRegistration.MOSSY_LARGE_ROCK.get(),
                BlockItemRegistration.LIGHTER_LARGE_ROCK.get(),
                BlockItemRegistration.SNOWY_LARGE_ROCK.get(),
                BlockItemRegistration.ICE_LARGE_ROCK.get()
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

        tag(ItemTagCatalog.HAMMER).add(
                ItemRegistration.HAMMERSTONE.get()
        );

        tag(ItemTagCatalog.KNIFE).add(
                ItemRegistration.LUNATE.get()
        );
    }

    public void registerCommonModTags() {
    }

    public void registerCompatibilityTags() {
    }
}