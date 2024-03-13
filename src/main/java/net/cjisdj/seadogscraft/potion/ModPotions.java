package net.cjisdj.seadogscraft.potion;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, SeaDogsCraft.MOD_ID);

    public static final RegistryObject<Potion> WINE_BOTTLE1 = POTIONS.register("wine_bottle1",
            () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 20, 1),
                    new MobEffectInstance(MobEffects.REGENERATION, 200, 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
