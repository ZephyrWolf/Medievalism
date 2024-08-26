package io.github.zephyrwolf.medievalism.common.recipe;

import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterial;
import io.github.zephyrwolf.medievalism.common.malleablematerial.MalleableMaterialType;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class MalleableMaterialRecipeBuilder implements RecipeBuilder
{
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private final Ingredient ingredient;
    private final MalleableMaterialType materialType;
    private final List<String> rows = new ArrayList<>();

    public static MalleableMaterialRecipeBuilder builder(Ingredient ingredient, MalleableMaterialType material)
    {
        return new MalleableMaterialRecipeBuilder(ingredient, material);
    }

    private MalleableMaterialRecipeBuilder(Ingredient ingredient, MalleableMaterialType material)
    {
        this.ingredient = ingredient;
        this.materialType = material;
    }

    @Override
    public MalleableMaterialRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion)
    {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    public MalleableMaterialRecipeBuilder pattern(String row)
    {
        rows.add(row);
        return this;
    }

    @Override
    public MalleableMaterialRecipeBuilder group(@Nullable String pGroupName) { return this; }

    @Deprecated
    @Override
    public Item getResult() { return Items.AIR; }
    public MalleableMaterialType getResultMaterial() { return materialType; }

    @Override
    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId)
    {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        MalleableMaterialRecipe stonebenchmaterialrecipe = getStoneBenchMaterialRecipe();
        pRecipeOutput.accept(pId, stonebenchmaterialrecipe, advancement$builder.build(pId.withPrefix("recipes/" + "stone_bench_recipe" + "/")));
    }

    private @NotNull MalleableMaterialRecipe getStoneBenchMaterialRecipe()
    {
        int numRows = rows.size();
        int numCols = rows.getFirst().length();
        List<Boolean> pattern = new ArrayList<>(numRows * numCols);
        for (String row : rows)
        {
            for (int coli = 0; coli < row.length(); coli++)
            {
                pattern.add(row.charAt(coli) != ' ');
            }
        }
        var material = new MalleableMaterial(materialType, numRows, numCols, pattern);
        return new MalleableMaterialRecipe(
                ingredient,
                material.trim()
        );
    }

    private void ensureValid(ResourceLocation pId)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
        if (rows.isEmpty() || rows.getFirst().isEmpty())
        {
            throw new IllegalStateException("No shape for recipe " + pId);
        }
        int cols = rows.getFirst().length();
        for (String row : rows)
        {
            if (row.length() != cols)
            {
                throw new IllegalStateException("Column size mismatch for shaped recipe " + pId);
            }
        }
    }
}
