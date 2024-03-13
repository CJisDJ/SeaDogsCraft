package net.cjisdj.seadogscraft.entity.custom;

import net.cjisdj.seadogscraft.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class RhinoEntity extends Animal {
    public RhinoEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new BreedGoal(this, 1.150));
        this.goalSelector.addGoal(2,new TemptGoal(this, 1.20, Ingredient.of(Items.CARROT), false));
        this.goalSelector.addGoal(1,new FollowParentGoal(this, 1.10));
        this.goalSelector.addGoal(1,new WaterAvoidingRandomStrollGoal(this, 1.10));
        this.goalSelector.addGoal(1,new LookAtPlayerGoal(this, Player.class, 3));
        this.goalSelector.addGoal(1,new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAtributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.MOVEMENT_SPEED, 0.250)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.FOLLOW_RANGE, 0.25D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);


    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob ageableMob) {
        return ModEntities.RHINO.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.CARROT);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }
}
