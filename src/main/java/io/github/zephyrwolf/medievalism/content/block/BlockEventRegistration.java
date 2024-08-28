package io.github.zephyrwolf.medievalism.content.block;

import io.github.zephyrwolf.medievalism.common.recipe.AdditionalDropToolUseRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.AdditionalDropToolUseRecipeInput;
import io.github.zephyrwolf.medievalism.content.recipe.RecipeRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.joml.Vector3f;

import java.util.Optional;

public class BlockEventRegistration
{
    public static void register()
    {
        NeoForge.EVENT_BUS.addListener(BlockEventRegistration::blockDrops);
        NeoForge.EVENT_BUS.addListener(BlockEventRegistration::breakSpeed);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, BlockEventRegistration::onToolUse);
    }

    public static void onToolUse(BlockEvent.BlockToolModificationEvent event)
    {
        if (event.isCanceled()) return;

        Level level = event.getContext().getLevel();
        AdditionalDropToolUseRecipeInput input = new AdditionalDropToolUseRecipeInput(event.getPos(), event.getItemAbility());
        var recipes = RecipeManager.createCheck(RecipeRegistration.ADDITIONAL_DROP_TOOL_USE_RECIPE_TYPE.get());
        Optional<RecipeHolder<AdditionalDropToolUseRecipe>> optional = recipes.getRecipeFor(
                input,
                level
        );
        Optional<ItemStack> stack = optional
                .map(RecipeHolder::value)
                .map(e->e.assemble(input, level.registryAccess()));
        if (stack.isPresent() && level.getRandom().nextInt(optional.get().value().getChance()) == 0)
        {
            BlockPos pos = event.getPos();
            Vector3f step = event.getContext().getClickedFace().step();
            Vector3f spawn = new Vector3f(step);
            spawn.mul(0.65f);
            spawn.add(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f);
            step.mul(0.15f);
            event.getLevel().addFreshEntity(
                    new ItemEntity(
                            level,
                            spawn.x(), spawn.y(), spawn.z(), // Pos
                            stack.get(),
                            step.x(), step.y(), step.z() // Vel
                    )
            );
        }
    }

    public static void blockDrops(BlockDropsEvent event)
    {
        BlockState state = event.getState();
        Entity entity = event.getBreaker();
        if (entity instanceof Player player)
        {
            if (!player.isCreative() && state.is(BlockTagCatalog.REQUIRES_AXE_FOR_DROPS))
            {
                ItemStack mainHand = player.getMainHandItem();
                if (!mainHand.is(ItemTags.AXES))
                {
                    event.setCanceled(true);
                }
            }
        }
    }

    public static void breakSpeed(PlayerEvent.BreakSpeed event)
    {
        // Tool tool = pStack.get(DataComponents.TOOL);
        // return tool != null ? tool.getMiningSpeed(pState) : 1.0F;
        BlockState state = event.getState();
        Player player = event.getEntity();
        if (!player.isCreative() && state.is(BlockTagCatalog.REQUIRES_AXE_FOR_DROPS))
        {
            ItemStack mainHand = player.getMainHandItem();
            if (!mainHand.is(ItemTags.AXES))
            {
                event.setNewSpeed(0.5f); // instead of override, divide
            }
        }
    }

}
