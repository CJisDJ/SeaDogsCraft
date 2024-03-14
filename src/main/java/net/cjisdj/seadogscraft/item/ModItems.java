package net.cjisdj.seadogscraft.item;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.entity.ModEntities;
import net.cjisdj.seadogscraft.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeaDogsCraft.MOD_ID);
    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(-1)));

    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            ()-> new Item(new Item.Properties().food(ModFoods.GRAPE)));

    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            ()-> new Item(new Item.Properties().food(ModFoods.CORN)));

    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MINI_COAL = ITEMS.register("mini_coal",
            ()-> new FuelItem(new Item.Properties(), 200));

    public static final RegistryObject<Item> PERIDOT_SWORD = ITEMS.register("peridot_sword",
            ()-> new SwordItem(ModToolTiers.PERIDOT, 4,  -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> PERIDOT_PICKAXE = ITEMS.register("peridot_pickaxe",
            ()-> new PickaxeItem(ModToolTiers.PERIDOT, 2,  -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> PERIDOT_AXE = ITEMS.register("peridot_axe",
            ()-> new AxeItem(ModToolTiers.PERIDOT, 6,-3, new Item.Properties()));

    public static final RegistryObject<Item> PERIDOT_SHOVEL = ITEMS.register("peridot_shovel",
            ()-> new ShovelItem(ModToolTiers.PERIDOT, 2.5F,-3, new Item.Properties()));

    public static final RegistryObject<Item> PERIDOT_HOE = ITEMS.register("peridot_hoe",
            ()-> new HoeItem(ModToolTiers.PERIDOT, -4,0, new Item.Properties()));

    public static final RegistryObject<Item> PERIDOT_HELMET = ITEMS.register("peridot_helmet",
            ()-> new ModArmorItem(ModArmorMaterials.PERIDOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PERIDOT_CHESTPLATE= ITEMS.register("peridot_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.PERIDOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PERIDOT_LEGGINGS = ITEMS.register("peridot_leggings",
            ()-> new ArmorItem(ModArmorMaterials.PERIDOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PERIDOT_BOOTS = ITEMS.register("peridot_boots",
            ()-> new ArmorItem(ModArmorMaterials.PERIDOT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.GRAPE_CROP.get(), new  Item.Properties()));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new  Item.Properties()));

    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new  Item.Properties()));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static final RegistryObject<Item> WINE_BOTTLE = ITEMS.register("wine_bottle",
            ()-> new DrinkBottleItem(new Item.Properties().food(ModFoods.WINE_BOTTLE)));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
