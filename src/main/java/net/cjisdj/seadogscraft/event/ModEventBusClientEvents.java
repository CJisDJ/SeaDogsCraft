package net.cjisdj.seadogscraft.event;


import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.client.ModModelLayers;
import net.cjisdj.seadogscraft.entity.client.RhinoModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SeaDogsCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
        }


}
