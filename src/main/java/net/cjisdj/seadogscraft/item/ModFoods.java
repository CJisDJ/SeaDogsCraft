package net.cjisdj.seadogscraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CREAM_PIPE = new FoodProperties.Builder()
            .nutrition(6)
            .fast()
            .saturationMod(0.5f)
            .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 50, 2),1f)
            .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 100, 2),1f)
            .build();



}
