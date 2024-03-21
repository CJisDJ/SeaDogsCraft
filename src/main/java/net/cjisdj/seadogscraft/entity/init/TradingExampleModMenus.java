package net.cjisdj.seadogscraft.entity.init;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.world.inventory.CaptraderTradingMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TradingExampleModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SeaDogsCraft.MOD_ID);
    public static final RegistryObject<MenuType<CaptraderTradingMenu>> CAPTRADER_TRADING = REGISTRY.register("captrader_trading", () -> IForgeMenuType.create(CaptraderTradingMenu::new));
}
