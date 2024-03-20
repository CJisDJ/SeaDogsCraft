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

    public static final FoodProperties COOKED_RICE = new FoodProperties.Builder()
            .nutrition(4)
            .fast()
            .saturationMod(0.7f)
            .build();


    public static final FoodProperties SUSHI = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1.2f)
            .build();


    public static final FoodProperties CHICKEN_CURRY = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(1.8f)
            .effect(()-> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 2),1f)
            .effect(()-> new MobEffectInstance(MobEffects.WATER_BREATHING, 260, 1),1f)
            .build();







}
