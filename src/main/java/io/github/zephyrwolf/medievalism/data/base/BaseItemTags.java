package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
import io.github.zephyrwolf.medievalism.common.item.ModItemTags;
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

public class BaseItemTags extends ItemTagsProvider
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/ItemTags.java
    public BaseItemTags(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> provider,
            CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, provider, blockTagProvider, MedievalismConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.registerVanillaTags();
        this.registerModTags();
        this.registerCommonModTags();
        this.registerCompatibilityTags();
    }

    private void registerVanillaTags()
    {

    }

    private void registerModTags()
    {
        tag(ModItemTags.LARGE_HIDE)
                .add(Registration.COW_HIDE.get())
                .add(Registration.HORSE_HIDE.get())
                .add(Registration.MOOSHROOM_HIDE.get())
                .add(Registration.RAVAGER_HIDE.get())
                .add(Registration.PANDA_HIDE.get())
                .add(Registration.SNIFFER_HIDE.get())
                .add(Registration.POLAR_BEAR_HIDE.get())
                .add(Registration.HOGLIN_HIDE.get());
        tag(ModItemTags.MEDIUM_HIDE)
                .add(Registration.DONKEY_HIDE.get())
                .add(Registration.MULE_HIDE.get())
                .add(Registration.WOLF_HIDE.get())
                .add(Registration.PIG_HIDE.get())
                .add(Registration.GOAT_HIDE.get())
                .add(Registration.LLAMA_HIDE.get())
                .add(Registration.SHEEP_HIDE.get());
        tag(ModItemTags.SMALL_HIDE)
                .add(Items.RABBIT_HIDE)
                .add(Registration.FOX_HIDE.get())
                .add(Registration.SNOW_FOX_HIDE.get())
                .add(Registration.OCELOT_HIDE.get())
                .add(Registration.CAT_HIDE.get())
                .add(Registration.OCELOT_HIDE.get())
                .add(Registration.BAT_HIDE.get());

        tag(ModItemTags.CAN_CRAFT_FLOUR)
                .add(Registration.CRACKED_WHEAT.get())
                .add(Registration.CRACKED_BARLEY.get())
                .add(Registration.ROLLED_OATS.get());
        tag(ModItemTags.CLAY_BALL)
                .add(Items.CLAY_BALL)
                .add(Registration.RED_CLAY_BALL.get());

        tag(ModItemTags.ROCK)
                .add(Registration.ROCK_ITEM.get())
                .add(Registration.COPPER_ROCK_ITEM.get())
                .add(Registration.LIMESTONE_ITEM.get());
        tag(ModItemTags.LARGE_ROCK)
                .add(Registration.LARGE_ROCK_ITEM.get());

        tag(ModItemTags.TINDER)
                .add(Registration.THATCH.get());
                // Candlenut leaves?
    }

    public void registerCommonModTags()
    {
    }

    public void registerCompatibilityTags()
    {
    }
}