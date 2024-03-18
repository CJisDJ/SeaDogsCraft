
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.cjisdj.seadogscraft.entity.init;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;


public class SeaDogsCraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SeaDogsCraft.MOD_ID);
	public static final RegistryObject<Item> GUNNER_SPAWN_EGG = REGISTRY.register("gunner_spawn_egg", () -> new ForgeSpawnEggItem(SeaDogsCraftModEntities.GUNNER, -65485, -1, new Item.Properties()));
	public static final RegistryObject<Item> SWORDMAN_SPAWN_EGG = REGISTRY.register("swordman_spawn_egg", () -> new ForgeSpawnEggItem(SeaDogsCraftModEntities.SWORDMAN, -16776961, -1, new Item.Properties()));
	public static final RegistryObject<Item> CAPTAIN_SPAWN_EGG = REGISTRY.register("captain_spawn_egg", () -> new ForgeSpawnEggItem(SeaDogsCraftModEntities.CAPTAIN, -13369549, -1, new Item.Properties()));
	public static final RegistryObject<Item> TRADER_SPAWN_EGG = REGISTRY.register("trader_spawn_egg", () -> new ForgeSpawnEggItem(SeaDogsCraftModEntities.TRADER, -256, -1, new Item.Properties()));
}
