package net.cjisdj.seadogscraft.entity.custom;

import net.cjisdj.seadogscraft.effect.ModEffects;
import net.cjisdj.seadogscraft.entity.ModEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class FlintlockProjectileEntity extends Projectile {
    private static final EntityDataAccessor<Boolean> HIT =
            SynchedEntityData.defineId(SniperProjectileEntity.class, EntityDataSerializers.BOOLEAN);
    private int counter = 0;
    private boolean hasHit = false;

    public FlintlockProjectileEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public FlintlockProjectileEntity(Level pLevel, Player player) {
        super(ModEntities.SNIPER_PROJECTILE.get(), pLevel);
        setOwner(player);


        double d0 = player.getX();
        double d1 = player.getY() + 1.65D;
        double d2 = player.getZ();
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());

       // player.sendSystemMessage(Component.literal("X"+player.getX() + "Y"+player.getY()+ "Z" + player.getZ()));
       // player.sendSystemMessage(Component.literal("pseudoX"+d0 + "pseudoY"+d1+ "pseudoZ" + d2));

    }

    @Override
    public void tick() {
        super.tick();
        if(this.entityData.get(HIT)) {
            if(this.tickCount >= counter) {
                this.discard();
            }
        }

        if (this.tickCount >= 200) {
            this.remove(RemovalReason.DISCARDED);
        }

        Vec3 vec3 = this.getDeltaMovement();
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult))
            this.onHit(hitresult);

        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

//        double d5 = vec3.x;
//        double d6 = vec3.y;
//        double d7 = vec3.z;

//        for(int i = 1; i < 5; ++i) {
//            this.level().addParticle(ParticleTypes.SMOKE, d0-(d5*2), d1-(d6*2), d2-(d7*2),
//                    -d5, -d6 - 0.1D, -d7);
//        }

        if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        } else if (this.isInWaterOrBubble()) {
            this.discard();
        }
        else if (hasHit == true) {
            this.discard();
        } else {
            this.setDeltaMovement(vec3.scale(0.99F));
            this.setPos(d0, d1, d2);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity hitEntity = hitResult.getEntity();
        Entity owner = this.getOwner();
        hasHit = true;

        if(hitEntity == owner && this.level().isClientSide()) {
            return;
        }

        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.NEUTRAL,
                2F, 1F);

        LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 8f;
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingentity), damage);
        if (hurt) {
            if(hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addEffect(new MobEffectInstance(ModEffects.BLEEDING_EFFECT.get(), 60, 1), owner);
            }
        }
    }




    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        hasHit = true;

//        CompoundTag compoundtag = new CompoundTag();
//        compoundtag.putString("id", "minecraft:tnt");
//        Entity entity = EntityType.loadEntityRecursive(compoundtag, this.level(), (e) -> {
//            e.moveTo(this.getX(), this.getY(), this.getZ(), 0, 0);
//            return e;
//        });
//        this.level().addFreshEntity(entity);
//
//        for(int x = 0; x < 18; ++x) {
//            for(int y = 0; y < 18; ++y) {
//                this.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, this.getX(), this.getY(), this.getZ(),
//                        Math.cos(x*20) * 0.15d, Math.cos(y*20) * 0.15d, Math.sin(x*20) * 0.15d);
//            }
//        }

        if(this.level().isClientSide()) {
            return;
        }

        if(hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
            Entity hit = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            if(owner != hit) {
                this.entityData.set(HIT, true);
                counter = this.tickCount + 5;
            }
        } else {
            this.entityData.set(HIT, true);
            counter = this.tickCount + 5;
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(HIT, false);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}