
package net.cjisdj.seadogscraft.entity.init;

import net.cjisdj.seadogscraft.entity.client.gui.CaptraderTradingScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TradingExampleModScreens {
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(TradingExampleModMenus.CAPTRADER_TRADING.get(), CaptraderTradingScreen::new);
        });
    }
}
