package io.github.zephyrwolf.medievalism.data.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.data.provider.BlankRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class OverhaulBlankRecipeProvider extends BlankRecipeProvider
{
    public OverhaulBlankRecipeProvider(PackOutput output)
    {
        super(output);
    }

    @Override
    protected void addRecipes()
    {
        // Delete vanilla recipes
        // TODO Doesn't actually remove the recipe, just causes an error, I hate this. Even if I make a blank recipe,
        //  then its still another recipe, its not removing anything.
        // I think I need to create a new recipe type, i.e. blank
        // or mixin RecipeManager$apply to skip recipes which have an empty root tag
        addBlank(ResourceLocation.withDefaultNamespace("oak_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("birch_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("jungle_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("spruce_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("acacia_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("bamboo_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("dark_oak_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("mangrove_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("crimson_planks"));
        addBlank(ResourceLocation.withDefaultNamespace("warped_planks"));

        addBlank(ResourceLocation.withDefaultNamespace("leather"));
        addBlank(ResourceLocation.withDefaultNamespace("bread"));
        addBlank(ResourceLocation.withDefaultNamespace("pumpkin_pie"));
        addBlank(ResourceLocation.withDefaultNamespace("mushroom_stew"));
        addBlank(ResourceLocation.withDefaultNamespace("rabbit_stew_from_red_mushroom"));
        addBlank(ResourceLocation.withDefaultNamespace("rabbit_stew_from_brown_mushrooms"));

        addBlank(ResourceLocation.withDefaultNamespace("brick"));
        addBlank(MedievalismConstants.resource("brick_from_clay_ball_tag"));
    }
}
