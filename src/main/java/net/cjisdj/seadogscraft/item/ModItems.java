package net.cjisdj.seadogscraft.item;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.item.custom.FuelItem;
import net.cjisdj.seadogscraft.item.custom.MetalDetectorItem;
import net.cjisdj.seadogscraft.item.custom.MetalPipeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeaDogsCraft.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
        ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(-1)));

    public static final RegistryObject<Item> METAL_PIPE = ITEMS.register("metal_pipe",
            ()-> new MetalPipeItem(new Item.Properties().durability(250).setNoRepair()));

    public static final RegistryObject<Item> CREAM_PIPE = ITEMS.register("cream_pipe",
            ()-> new Item(new Item.Properties().food(ModFoods.CREAM_PIPE)));

    public static final RegistryObject<Item> MINI_COAL = ITEMS.register("mini_coal",
            ()-> new FuelItem(new Item.Properties(), 200));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
