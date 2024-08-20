package io.github.zephyrwolf.medievalism.data.base;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.Registration;
import io.github.zephyrwolf.medievalism.tools.TextTools;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BaseAdvancements implements AdvancementProvider.AdvancementGenerator
{ // https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/advancement/FDAdvancementGenerator.java

    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
    {

        AdvancementHolder medievalism = Advancement.Builder.advancement()
                .display(Registration.RED_CLAY_BALL.get(),
                        TextTools.getTranslation("advancement.root"),
                        TextTools.getTranslation("advancement.root.desc"),
                        ResourceLocation.fromNamespaceAndPath("minecraft", "textures/block/bricks.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("auto", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {}))
                .save(saver, getNameId("main/root"));

        AdvancementHolder red_clay_pun = Advancement.Builder.advancement()
                .parent(medievalism)
                .display(Registration.RED_CLAY_BALL.get(),
                        TextTools.getTranslation("advancement.get_red_clay"),
                        TextTools.getTranslation("advancement.get_red_clay.desc"),
                        ResourceLocation.fromNamespaceAndPath("minecraft", "textures/block/bricks.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("red_clay_balls", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RED_CLAY_BALL.get()))
                .addCriterion("red_clay_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RED_CLAY_BLOCK.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/get_red_clay"));
/*
        // Harvesting Branch
        AdvancementHolder huntAndGather = getAdvancement(farmersDelight, ModItems.FLINT_KNIFE.get(), "craft_knife", FrameType.TASK, true, true, false)
                .addCriterion("flint_knife", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_KNIFE.get()))
                .addCriterion("iron_knife", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_KNIFE.get()))
                .addCriterion("diamond_knife", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DIAMOND_KNIFE.get()))
                .addCriterion("golden_knife", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLDEN_KNIFE.get()))
                .addCriterion("netherite_knife", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_KNIFE.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("main/craft_knife"));

         */
    }

    /* // Really unneeded
    protected static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(parent).display(display,
                TextUtils.getTranslation("advancement." + name),
                TextUtils.getTranslation("advancement." + name + ".desc"),
                null, frame, showToast, announceToChat, hidden);
    }

     */

    private String getNameId(String id)
    {
        return MedievalismConstants.MOD_ID + ":" + id;
    }
}
