
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.cjisdj.seadogscraft.entity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.cjisdj.seadogscraft.entity.client.renderer.TraderRenderer;
import net.cjisdj.seadogscraft.entity.client.renderer.SwordmanRenderer;
import net.cjisdj.seadogscraft.entity.client.renderer.GunnerRenderer;
import net.cjisdj.seadogscraft.entity.client.renderer.CaptainRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SeaDogsCraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SeaDogsCraftModEntities.GUNNER.get(), GunnerRenderer::new);
		event.registerEntityRenderer(SeaDogsCraftModEntities.SWORDMAN.get(), SwordmanRenderer::new);
		event.registerEntityRenderer(SeaDogsCraftModEntities.CAPTAIN.get(), CaptainRenderer::new);
		event.registerEntityRenderer(SeaDogsCraftModEntities.TRADER.get(), TraderRenderer::new);
	}
}
