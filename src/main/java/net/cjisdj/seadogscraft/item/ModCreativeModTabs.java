package net.cjisdj.seadogscraft.item;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SeaDogsCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AFRICA_TAB = CREATIVE_MODE_TABS.register("africa_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PERIDOT.get()))
                    .title(Component.translatable("creativetab.africa_tab"))
                    .displayItems((pParameters, pOutput) ->{
                        pOutput.accept(ModItems.PERIDOT.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModBlocks.PERIDOT_BLOCK.get());
                        pOutput.accept(ModItems.WINE_BOTTLE.get());
                        pOutput.accept(ModItems.EMPTY_WINE_BOTTLE.get());

                        pOutput.accept(ModItems.EMPTY_MUG.get());
                        pOutput.accept(ModItems.BEER_MUG.get());
                        pOutput.accept(ModItems.RUM_MUG.get());
                        pOutput.accept(ModItems.GROG_MUG.get());




                        pOutput.accept(ModItems.MINI_COAL.get());
                        pOutput.accept(ModBlocks.PERIDOT_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_PERIDOT_ORE.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.MOD_PORTAL.get());
                        pOutput.accept(ModItems.EMPTY_HAND_CANNON.get());
                        pOutput.accept(ModItems.HAND_CANNON.get());
                        pOutput.accept(ModItems.EMPTY_FLINTLOCK.get());
                        pOutput.accept(ModItems.FLINTLOCK.get());
                        pOutput.accept(ModItems.EMPTY_SNIPER_RIFLE.get());
                        pOutput.accept(ModItems.SNIPER_RIFLE.get());
                        pOutput.accept(ModItems.EMPTY_BLUNDERBUSS.get());
                        pOutput.accept(ModItems.BLUNDERBUSS.get());
                        pOutput.accept(ModItems.PROJECTILE_TESTER.get());

                        pOutput.accept(ModItems.NAVAL_CUTLASS.get());
                        pOutput.accept(ModItems.PIRATE_CUTLASS.get());
                        pOutput.accept(ModItems.PERIDOT_SWORD.get());
                        pOutput.accept(ModItems.PERIDOT_PICKAXE.get());
                        pOutput.accept(ModItems.PERIDOT_AXE.get());
                        pOutput.accept(ModItems.PERIDOT_SHOVEL.get());
                        pOutput.accept(ModItems.PERIDOT_HOE.get());

                        pOutput.accept(ModItems.PERIDOT_HELMET.get());
                        pOutput.accept(ModItems.PERIDOT_CHESTPLATE.get());
                        pOutput.accept(ModItems.PERIDOT_LEGGINGS.get());
                        pOutput.accept(ModItems.PERIDOT_BOOTS.get());


                        pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());

                        pOutput.accept(ModItems.METAL_BULLETS.get());
                        pOutput.accept(ModItems.CANNONBALL.get());


                        pOutput.accept(ModItems.GRAPE_SEEDS.get());
                        pOutput.accept(ModItems.GRAPE.get());

                        pOutput.accept(ModItems.CURRY_POWDER.get());

                        pOutput.accept(ModItems.CORN.get());
                        pOutput.accept(ModItems.CORN_SEEDS.get());


                        pOutput.accept(ModItems.RICE.get());
                        pOutput.accept(ModItems.RICE_SEEDS.get());

                        pOutput.accept(ModItems.PIRATES_HAT.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
