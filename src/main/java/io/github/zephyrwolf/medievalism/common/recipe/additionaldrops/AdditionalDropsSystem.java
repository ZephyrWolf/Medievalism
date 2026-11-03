package io.github.zephyrwolf.medievalism.common.recipe.additionaldrops;

import io.github.zephyrwolf.medievalism.registration.recipe.RecipeRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.joml.Vector3f;

import java.util.Optional;

public final class AdditionalDropsSystem
{
    public static void registerEventHandlers()
    {
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, AdditionalDropsSystem::onToolUse);
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, AdditionalDropsSystem::onToolDig);
    }

    public static void onToolDig(BlockEvent.BreakEvent event)
    {
        if (event.isCanceled()) return;
        IAdditionalDropRecipeInput input = AdditionalDropsSystem.getRecipeInput(event.getPos(), event.getPlayer().getMainHandItem());
        ItemStack stack = getAdditionalDropsFor(event.getPlayer().level(), input);
        spawnDropsInWorld(event.getPlayer().level(), event.getPos(), new Vector3f(), new Vector3f(), stack);
    }

    public static void onToolUse(BlockEvent.BlockToolModificationEvent event)
    {
        if (event.isCanceled()) return;
        IAdditionalDropRecipeInput input = AdditionalDropsSystem.getRecipeInput(event.getPos(), event.getItemAbility());
        ItemStack stack = getAdditionalDropsFor(event.getContext().getLevel(), input);
        Vector3f offset = event.getContext().getClickedFace().step();
        offset.mul(0.65f);
        Vector3f vel = event.getContext().getClickedFace().step();
        vel.mul(0.15f);
        spawnDropsInWorld(event.getContext().getLevel(), event.getPos(), offset, vel, stack);
    }

    private static IAdditionalDropRecipeInput getRecipeInput(BlockPos pos, ItemAbility ability)
    { return AdditionalDropSetRecipeInput.create(pos, ability); }
    private static IAdditionalDropRecipeInput getRecipeInput(BlockPos pos, ItemStack stack)
    { return AdditionalDropStackRecipeInput.create(pos, stack); }

    private static ItemStack getAdditionalDropsFor(Level level, IAdditionalDropRecipeInput recipeInput)
    {
        var recipes = RecipeManager.createCheck(RecipeRegistration.ADDITIONAL_DROP_TOOL_USE_RECIPE_TYPE.get());
        Optional<RecipeHolder<AdditionalDropToolUseRecipe>> optional = recipes.getRecipeFor(
                recipeInput,
                level
        );
        Optional<ItemStack> stack = optional.map(RecipeHolder::value)
                .map(e->e.assemble(recipeInput, level.registryAccess()));
        if (stack.isPresent() && level.getRandom().nextInt(optional.get().value().getChance()) == 0)
        {
            return stack.get();
        }
        return ItemStack.EMPTY;
    }

    private static void spawnDropsInWorld(Level level, BlockPos pos, Vector3f offset, Vector3f vel, ItemStack stack)
    {
        if (stack.isEmpty()) { return; }
        Vector3f spawn = new Vector3f(pos.getX() + offset.x(), pos.getY() + offset.y(), pos.getZ() + offset.z());
        level.addFreshEntity(
                new ItemEntity(
                        level,
                        spawn.x(), spawn.y(), spawn.z(),
                        stack,
                        vel.x(), vel.y(), vel.z()
                )
        );
    }
}
