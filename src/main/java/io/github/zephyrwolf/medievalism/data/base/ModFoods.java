package io.github.zephyrwolf.medievalism.data.base;

import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties YAM = new FoodProperties.Builder().nutrition(1).saturationModifier(0.4F).build();
    public static final FoodProperties BAKED_YAM = new FoodProperties.Builder().nutrition(5).saturationModifier(0.7F).build();
    public static final FoodProperties BAKED_CARROT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.8F).build();
    public static final FoodProperties BAKED_BEETROOT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build();
    public static final FoodProperties BLUEBERRIES = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).alwaysEdible().build();
    public static final FoodProperties RASPBERRIES = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).alwaysEdible().build();
    public static final FoodProperties STRAWBERRIES = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).alwaysEdible().build();
}
