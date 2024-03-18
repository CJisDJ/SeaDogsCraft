
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.cjisdj.seadogscraft.entity.init;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeaDogsCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SeaDogsCraft.MOD_ID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(SeaDogsCraftModItems.GUNNER_SPAWN_EGG.get());
			tabData.accept(SeaDogsCraftModItems.SWORDMAN_SPAWN_EGG.get());
			tabData.accept(SeaDogsCraftModItems.CAPTAIN_SPAWN_EGG.get());
			tabData.accept(SeaDogsCraftModItems.TRADER_SPAWN_EGG.get());
		}
	}
}
