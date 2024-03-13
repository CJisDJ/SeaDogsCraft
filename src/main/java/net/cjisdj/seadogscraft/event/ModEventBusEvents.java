package net.cjisdj.seadogscraft.event;


import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.ModEntities;
import net.cjisdj.seadogscraft.entity.custom.RhinoEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SeaDogsCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAtributes().build());
    }
}
