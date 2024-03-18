package net.cjisdj.seadogscraft.entity;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SeaDogsCraft.MOD_ID);

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
        ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                .sized(2.5f, 2.5f).build("rhino"));

    public static final RegistryObject<EntityType<MagicProjectileEntity>> MAGIC_PROJECTILE =
            ENTITY_TYPES.register("magic_projectile",
                    () -> EntityType.Builder.<MagicProjectileEntity>of(MagicProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("magic_projectile"));

    public static final RegistryObject<EntityType<CannonProjectileEntity>> CANNON_PROJECTILE =
            ENTITY_TYPES.register("cannon_projectile",
                    () -> EntityType.Builder.<CannonProjectileEntity>of(CannonProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("cannon_projectile"));

    public static final RegistryObject<EntityType<SniperProjectileEntity>> SNIPER_PROJECTILE =
            ENTITY_TYPES.register("sniper_projectile",
                    () -> EntityType.Builder.<SniperProjectileEntity>of(SniperProjectileEntity::new, MobCategory.MISC)
                            .sized(0.2f, 0.2f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("sniper_projectile"));

    public static final RegistryObject<EntityType<CommonProjectileEntity>> COMMON_PROJECTILE =
            ENTITY_TYPES.register("common_projectile",
                    () -> EntityType.Builder.<CommonProjectileEntity>of(CommonProjectileEntity::new, MobCategory.MISC)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("common_projectile"));

    public static final RegistryObject<EntityType<FlintlockProjectileEntity>> FLINTLOCK_PROJECTILE =
            ENTITY_TYPES.register("flintlock_projectile",
                    () -> EntityType.Builder.<FlintlockProjectileEntity>of(FlintlockProjectileEntity::new, MobCategory.MISC)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("flintlock_projectile"));




    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
