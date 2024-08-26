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
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MalleableRecipeBuilder implements RecipeBuilder
{
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private final ItemStack result;
    private final MalleableMaterialType materialType;
    private final List<String> rows = new ArrayList<>();
    private boolean mirror = false;

    public static MalleableRecipeBuilder builder(MalleableMaterialType materialType, ItemStack result)
    {
        return new MalleableRecipeBuilder(materialType, result);
    }

    private MalleableRecipeBuilder(MalleableMaterialType materialType, ItemStack result)
    {
        this.materialType = materialType;
        this.result = result;
    }

    public MalleableRecipeBuilder pattern(String row)
    {
        rows.add(row);
        return this;
    }

    public MalleableRecipeBuilder allowMirror()
    {
        mirror = true;
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId) {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        MalleableRecipe recipe = buildRecipe();
        pRecipeOutput.accept(pId, recipe, advancement$builder.build(pId.withPrefix("recipes/" + "malleable" + "/")));
    }

    private @NotNull MalleableRecipe buildRecipe()
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
        return new MalleableRecipe(
                material.trim(),
                result,
                mirror
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
