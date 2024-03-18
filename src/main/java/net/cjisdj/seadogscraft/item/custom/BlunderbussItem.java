package net.cjisdj.seadogscraft.item.custom;

import net.cjisdj.seadogscraft.entity.custom.CommonProjectileEntity;
import net.cjisdj.seadogscraft.entity.custom.SniperProjectileEntity;
import net.cjisdj.seadogscraft.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class BlunderbussItem extends Item{
    public BlunderbussItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ANCIENT_DEBRIS_BREAK, SoundSource.NEUTRAL,
                1.5F, 1F);
        pPlayer.getCooldowns().addCooldown(this, 0);

        if(!pLevel.isClientSide()) {
            CommonProjectileEntity magicProjectile = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile.shootFromRotation(pPlayer, pPlayer.getXRot()-01.2F, pPlayer.getYRot(), 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile);


            CommonProjectileEntity magicProjectile2 = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile2.shootFromRotation(pPlayer, pPlayer.getXRot()+01.2F, pPlayer.getYRot(), 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile2);

            CommonProjectileEntity magicProjectile3 = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile3.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot()-01.2F, 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile3);

            CommonProjectileEntity magicProjectile4 = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile4.shootFromRotation(pPlayer, pPlayer.getXRot()-01.3F, pPlayer.getYRot()+01.2F, 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile4);

            CommonProjectileEntity magicProjectile5 = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile5.shootFromRotation(pPlayer, pPlayer.getXRot()+01.3F, pPlayer.getYRot()-01.2F, 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile5);

            CommonProjectileEntity magicProjectile6 = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile6.shootFromRotation(pPlayer, pPlayer.getXRot()-01.3F, pPlayer.getYRot()-01.2F, 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile6);

            CommonProjectileEntity magicProjectile7 = new CommonProjectileEntity(pLevel, pPlayer);
            magicProjectile7.shootFromRotation(pPlayer, pPlayer.getXRot()+1.3F, pPlayer.getYRot()+01.2F, 0.0F, 6F, 4);
            pLevel.addFreshEntity(magicProjectile7);


        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
        }


        if(itemstack.getDamageValue() == 5){
            return InteractionResultHolder.sidedSuccess(new ItemStack(ModItems.EMPTY_BLUNDERBUSS.get()), pLevel.isClientSide());
        }
        else{
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }
    }
}
