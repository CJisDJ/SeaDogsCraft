package net.cjisdj.seadogscraft.item;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.entity.ModEntities;
import net.cjisdj.seadogscraft.item.custom.*;
import net.cjisdj.seadogscraft.item.custom.BowlFoodItem;
import net.minecraft.world.item.*;
import net.cjisdj.seadogscraft.item.custom.SniperItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.tools.Tool;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeaDogsCraft.MOD_ID);
    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(-1).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            ()-> new Item(new Item.Properties().food(ModFoods.GRAPE)));

    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            ()-> new Item(new Item.Properties().food(ModFoods.CORN)));

    public static final RegistryObject<Item> CURRY_POWDER = ITEMS.register("curry_powder",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> CANNONBALL = ITEMS.register("cannonball",
            ()-> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> METAL_BULLETS = ITEMS.register("metal_bullets",
            ()-> new Item(new Item.Properties()));


    public static final RegistryObject<Item> CHICKEN_CURRY_BOWL = ITEMS.register("chicken_curry_bowl",
            ()-> new BowlFoodItem(new Item.Properties().food(ModFoods.CHICKEN_CURRY)));


    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_RICE = ITEMS.register("raw_rice",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COOKED_RICE = ITEMS.register("cooked_rice",
            ()-> new Item(new Item.Properties().food(ModFoods.COOKED_RICE)));

    public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi",
            ()-> new Item(new Item.Properties().food(ModFoods.SUSHI)));

    public static final RegistryObject<Item> STONE_HOOK = ITEMS.register("stone_hook",
            () -> new SwordItem(Tiers.STONE, 1, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_HOOK = ITEMS.register("golden_hook",
            () -> new SwordItem(Tiers.GOLD, 1, -1.8F, new Item.Properties()));

    public static final RegistryObject<Item> IRON_HOOK = ITEMS.register("iron_hook",
            () -> new SwordItem(Tiers.IRON, 1, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_HOOK = ITEMS.register("diamond_hook",
            () -> new SwordItem(Tiers.DIAMOND, 1, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> MINI_COAL = ITEMS.register("mini_coal",
            ()-> new FuelItem(new Item.Properties(), 200));

    public static final RegistryObject<Item> PERIDOT_SWORD = ITEMS.register("peridot_sword",
            ()-> new SwordItem(ModToolTiers.PERIDOT, 4,  -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> NAVAL_CUTLASS = ITEMS.register("naval_cutlass",
            ()-> new SwordItem(Tiers.DIAMOND, 3,  -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> DAMAGED_CUTLASS = ITEMS.register("damaged_cutlass",
            ()-> new BleedingSwordItem(Tiers.NETHERITE, 3,  -2.4F, new Item.Properties()));


    public static final RegistryObject<Item> PROJECTILE_TESTER = ITEMS.register("tester",
            () -> new MagicTESTItem(new Item.Properties().durability(999)));


    public static final RegistryObject<Item> EMPTY_FLINTLOCK = ITEMS.register("empty_flintlock",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> FLINTLOCK = ITEMS.register("flintlock",
            () -> new FlintlockItem(new Item.Properties().durability(6)));


    public static final RegistryObject<Item> EMPTY_SNIPER_RIFLE = ITEMS.register("empty_sniper_rifle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SNIPER_RIFLE = ITEMS.register("sniper_rifle",
            () -> new SniperItem(new Item.Properties().durability(6)));

    public static final RegistryObject<Item> EMPTY_BLUNDERBUSS = ITEMS.register("empty_blunderbuss",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLUNDERBUSS = ITEMS.register("shotgun",
            () -> new BlunderbussItem(new Item.Properties().durability(6)));

    public static final RegistryObject<Item> HAND_CANNON = ITEMS.register("hand_cannon",
            () -> new HandCannonItem(new Item.Properties().durability(3)));

    public static final RegistryObject<Item> EMPTY_HAND_CANNON = ITEMS.register("empty_hand_cannon",
            () -> new Item(new Item.Properties()));

   // public static final RegistryObject<Item> ALEXANDRITE_BOW = ITEMS.register("alexandrite_bow",
   //         () -> new BowItem(new Item.Properties().durability(500)));

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

    public static final RegistryObject<Item> PIRATES_HAT = ITEMS.register("pirates_hat",
            ()-> new PiratesHatItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.GRAPE_CROP.get(), new  Item.Properties()));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new  Item.Properties()));

    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new  Item.Properties()));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));


    public static final RegistryObject<Item> EMPTY_WINE_BOTTLE = ITEMS.register("empty_wine_bottle",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_MUG = ITEMS.register("empty_mug",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WINE_BOTTLE = ITEMS.register("wine_bottle",
            ()-> new DrinkWineBottleItem(new Item.Properties().food(ModFoods.WINE_BOTTLE)));

    public static final RegistryObject<Item> BEER_MUG = ITEMS.register("beer_mug",
            ()-> new DrinkMugItem(new Item.Properties().food(ModFoods.WINE_BOTTLE)));

    public static final RegistryObject<Item> RUM_MUG = ITEMS.register("rum_mug",
            ()-> new DrinkMugItem(new Item.Properties().food(ModFoods.WINE_BOTTLE)));

    public static final RegistryObject<Item> GROG_MUG = ITEMS.register("grog_mug",
            ()-> new DrinkMugItem(new Item.Properties().food(ModFoods.WINE_BOTTLE)));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
