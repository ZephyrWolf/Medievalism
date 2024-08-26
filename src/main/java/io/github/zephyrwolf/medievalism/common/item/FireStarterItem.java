package io.github.zephyrwolf.medievalism.common.item;

import io.github.zephyrwolf.medievalism.content.RecipeRegistration;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipe;
import io.github.zephyrwolf.medievalism.common.recipe.InWorldRecipeInput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class FireStarterItem extends Item
{
    public FireStarterItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context)
    {
		Direction face = context.getClickedFace();
		BlockPos pos = context.getClickedPos().relative(face);
		Level level = context.getLevel();

        // TODO Test if the player is allowed to modify the world

        if (!level.isClientSide())
        {
            List<ItemEntity> entities = level.getEntitiesOfClass( ItemEntity.class, new AABB( pos ) );
            //List<ItemStack> stacks = entities.stream().map(ItemEntity::getItem).toList();
            InWorldRecipeInput input = new InWorldRecipeInput(context.getItemInHand(), entities, pos);
            // Investigate how AbstractFurnaceBlockEntity uses this, I assume they refresh it on inventory change
            var recipes = RecipeManager.createCheck(RecipeRegistration.IN_WORLD_RECIPE_TYPE.get());
            Optional<RecipeHolder<InWorldRecipe>> optional = recipes.getRecipeFor(input, level);
            Optional<BlockState> state = optional
                    .map(RecipeHolder::value)
                    .map(e -> e.assembleState(input, level.registryAccess()));
            if (state.isPresent())
            {
                entities.forEach(entity -> entity.remove(Entity.RemovalReason.DISCARDED)); // TODO How do I properly remove an item from in world
                level.setBlock(pos, state.get(), 3);
                level.playLocalSound(pos, SoundEvents.FIRE_AMBIENT, SoundSource.PLAYERS, 1.0f, 1.0f, false);
                damageItem(context.getItemInHand(), 1, context.getPlayer(), (held) -> {
                    if (context.getPlayer() != null)
                        context.getPlayer().setItemInHand(context.getHand(), ItemStack.EMPTY);
                });
            }
        }

		return InteractionResult.SUCCESS;
	}

    //@Override
    //public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
    //    return super.damageItem(stack, amount, entity, onBroken);
    //}
}
