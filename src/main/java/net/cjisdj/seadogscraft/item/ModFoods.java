package net.cjisdj.seadogscraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties WINE_BOTTLE = new FoodProperties.Builder()
            .nutrition(6)
            .fast()
            .saturationMod(0.5f)
            .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 500, 2),1f)
            .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 250, 3),1f)
            .build();

    public static final FoodProperties GRAPE = new FoodProperties.Builder()
            .nutrition(2)
            .fast()
            .saturationMod(0.2f)
            .build();

    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(3)
            .fast()
            .saturationMod(0.3f)
            .build();







}
