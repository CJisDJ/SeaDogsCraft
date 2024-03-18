
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.cjisdj.seadogscraft.entity.init;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.custom.CaptainEntity;
import net.cjisdj.seadogscraft.entity.custom.GunnerEntity;
import net.cjisdj.seadogscraft.entity.custom.SwordmanEntity;
import net.cjisdj.seadogscraft.entity.custom.TraderEntity;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeaDogsCraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SeaDogsCraft.MOD_ID);
	public static final RegistryObject<EntityType<GunnerEntity>> GUNNER = register("gunner",
			EntityType.Builder.<GunnerEntity>of(GunnerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GunnerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SwordmanEntity>> SWORDMAN = register("swordman",
			EntityType.Builder.<SwordmanEntity>of(SwordmanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SwordmanEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CaptainEntity>> CAPTAIN = register("captain",
			EntityType.Builder.<CaptainEntity>of(CaptainEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CaptainEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TraderEntity>> TRADER = register("trader",
			EntityType.Builder.<TraderEntity>of(TraderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TraderEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GunnerEntity.init();
			SwordmanEntity.init();
			CaptainEntity.init();
			TraderEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GUNNER.get(), GunnerEntity.createAttributes().build());
		event.put(SWORDMAN.get(), SwordmanEntity.createAttributes().build());
		event.put(CAPTAIN.get(), CaptainEntity.createAttributes().build());
		event.put(TRADER.get(), TraderEntity.createAttributes().build());
	}
}
