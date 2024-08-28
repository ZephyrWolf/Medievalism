package io.github.zephyrwolf.medievalism.content.recipe;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.recipe.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeRegistration
{
    // Registries
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MedievalismConstants.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create( Registries.RECIPE_SERIALIZER, MedievalismConstants.MOD_ID);

    // Serializers
    public static final Supplier<RecipeSerializer<InWorldRecipe>> IN_WORLD_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("in_world", InWorldRecipeSerializer::new);
    public static final Supplier<RecipeSerializer<AdditionalDropToolUseRecipe>> ADDITIONAL_DROP_TOOL_USE_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("additional_drop_tool_use", AdditionalDropToolUseRecipeSerializer::new);
    public static final Supplier<RecipeSerializer<MalleableMaterialRecipe>> MALLEABLE_MATERIAL_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("malleable_material", MalleableMaterialRecipeSerializer::new);
    public static final Supplier<RecipeSerializer<MalleableRecipe>> MALLEABLE_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("malleable", MalleableRecipeSerializer::new);

    // Types
    public static final Supplier<RecipeType<InWorldRecipe>> IN_WORLD_RECIPE_TYPE = RECIPE_TYPES.register("in_world", () -> RecipeType.simple(MedievalismConstants.resource("in_world")));
    public static final Supplier<RecipeType<AdditionalDropToolUseRecipe>> ADDITIONAL_DROP_TOOL_USE_RECIPE_TYPE = RECIPE_TYPES.register("additional_drop_tool_use", () -> RecipeType.simple(MedievalismConstants.resource("additional_drop_tool_use")));
    public static final Supplier<RecipeType<MalleableMaterialRecipe>> MALLEABLE_MATERIAL_RECIPE_TYPE = RECIPE_TYPES.register("malleable_material", () -> RecipeType.simple(MedievalismConstants.resource("malleable_material")));
    public static final Supplier<RecipeType<MalleableRecipe>> MALLEABLE_RECIPE_TYPE = RECIPE_TYPES.register("malleable", () -> RecipeType.simple(MedievalismConstants.resource("malleable")));


    public static void register(IEventBus modEventBus)
    {
        RECIPE_TYPES.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
