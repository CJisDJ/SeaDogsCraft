package net.cjisdj.seadogscraft.item.custom;

import net.cjisdj.seadogscraft.entity.custom.CannonProjectileEntity;
import net.cjisdj.seadogscraft.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;


public class HandCannonItem extends Item{
    public HandCannonItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ANCIENT_DEBRIS_BREAK, SoundSource.NEUTRAL,
                1.5F, 1F);
        pPlayer.getCooldowns().addCooldown(this, 0);

        if(!pLevel.isClientSide()) {
            CannonProjectileEntity cannonProjectile = new CannonProjectileEntity(pLevel, pPlayer);
            cannonProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.2F, 0.25F);
            pLevel.addFreshEntity(cannonProjectile);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
        }

        if(itemstack.getDamageValue() == 1){
            return InteractionResultHolder.sidedSuccess(new ItemStack(ModItems.EMPTY_HAND_CANNON.get()), pLevel.isClientSide());
        }
        else{
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }



    }
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }


}
