package io.github.zephyrwolf.medievalism.common.recipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class KnapInhandRecipeBuilder extends InhandRecipeBuilder<KnapInhandRecipe>
{
    public static KnapInhandRecipeBuilder knapInhand(ItemStack result)
    {
        return new KnapInhandRecipeBuilder(result);
    }

    public static KnapInhandRecipeBuilder knapInhand(ItemLike result)
    {
        return new KnapInhandRecipeBuilder(new ItemStack(result, 1));
    }

    public static KnapInhandRecipeBuilder knapInhand(ItemLike result, int count)
    {
        return new KnapInhandRecipeBuilder(new ItemStack(result, count));
    }

    protected KnapInhandRecipeBuilder(ItemStack result)
    {
        super(result);
    }

    @Override
    protected String category() { return "knap_inhand"; }

    @Override
    protected @NotNull KnapInhandRecipe buildRecipe()
    {
        return new KnapInhandRecipe(
                Objects.requireNonNullElse(group, ""),
                tool,
                ingredient,
                result
        );
    }
}
