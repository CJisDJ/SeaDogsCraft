package net.cjisdj.blockyafrica.event;


import net.cjisdj.blockyafrica.BlockyAfrica;
import net.cjisdj.blockyafrica.entity.ModEntities;
import net.cjisdj.blockyafrica.entity.custom.RhinoEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlockyAfrica.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAtributes().build());
    }
}
