package io.github.zephyrwolf.medievalism.common.recipe.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class ShapelessToolRecipeSerializer implements RecipeSerializer<ShapelessToolRecipe>
{
    private static final MapCodec<ShapelessToolRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codec.STRING.optionalFieldOf("group", "").forGetter(p_301127_ -> p_301127_.group),
                            CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(p_301133_ -> p_301133_.category),
                            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_301142_ -> p_301142_.result),
                            Ingredient.CODEC_NONEMPTY
                                    .listOf()
                                    .fieldOf("ingredients")
                                    .flatXmap(
                                            ingredients -> {
                                                Ingredient[] aingredient = ingredients.toArray(Ingredient[]::new);
                                                if (aingredient.length == 0)
                                                {
                                                    return DataResult.error(() -> "No ingredients for shapeless recipe");
                                                }
                                                else
                                                {
                                                    return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()
                                                            ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s"
                                                            .formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()))
                                                            : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
                                                }
                                            },
                                            DataResult::success
                                    )
                                    .forGetter(recipe -> recipe.ingredients),
                            Ingredient.CODEC_NONEMPTY
                                    .listOf()
                                    .fieldOf("tools")
                                    .flatXmap(
                                            tools -> {
                                                Ingredient[] atools = tools.toArray(Ingredient[]::new);
                                                if (atools.length == 0)
                                                {
                                                    return DataResult.error(() -> "No tools for shapeless tool recipe");
                                                }
                                                else
                                                {
                                                    return atools.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()
                                                            ? DataResult.error(() -> "Too many tools for shapeless tool recipe. The maximum is: %s"
                                                            .formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()))
                                                            : DataResult.success(NonNullList.of(Ingredient.EMPTY, atools));
                                                }
                                            },
                                            DataResult::success
                                    )
                                    .forGetter(recipe -> recipe.tools)
                    )
                    .apply(instance, ShapelessToolRecipe::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, ShapelessToolRecipe> STREAM_CODEC = StreamCodec.of(
            ShapelessToolRecipeSerializer::toNetwork, ShapelessToolRecipeSerializer::fromNetwork
    );

    @Override
    public @NotNull MapCodec<ShapelessToolRecipe> codec() {
        return CODEC;
    }

    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, ShapelessToolRecipe> streamCodec() {
        return STREAM_CODEC;
    }

    private static ShapelessToolRecipe fromNetwork(RegistryFriendlyByteBuf byteBuffer)
    {
        String s = byteBuffer.readUtf();
        CraftingBookCategory craftingbookcategory = byteBuffer.readEnum(CraftingBookCategory.class);

        int numIngredients = byteBuffer.readVarInt();
        NonNullList<Ingredient> ingredientsList = NonNullList.withSize(numIngredients, Ingredient.EMPTY);
        ingredientsList.replaceAll(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.decode(byteBuffer));

        int numTools = byteBuffer.readVarInt();
        NonNullList<Ingredient> toolsList = NonNullList.withSize(numTools, Ingredient.EMPTY);
        toolsList.replaceAll(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.decode(byteBuffer));

        ItemStack itemstack = ItemStack.STREAM_CODEC.decode(byteBuffer);
        return new ShapelessToolRecipe(s, craftingbookcategory, itemstack, ingredientsList, toolsList);
    }

    private static void toNetwork(RegistryFriendlyByteBuf byteBuffer, ShapelessToolRecipe recipe)
    {
        byteBuffer.writeUtf(recipe.group);
        byteBuffer.writeEnum(recipe.category);

        byteBuffer.writeVarInt(recipe.ingredients.size());
        for (Ingredient ingredient : recipe.ingredients)
        {
            Ingredient.CONTENTS_STREAM_CODEC.encode(byteBuffer, ingredient);
        }

        byteBuffer.writeVarInt(recipe.tools.size());
        for (Ingredient tool : recipe.tools)
        {
            Ingredient.CONTENTS_STREAM_CODEC.encode(byteBuffer, tool);
        }

        ItemStack.STREAM_CODEC.encode(byteBuffer, recipe.result);
    }
}
