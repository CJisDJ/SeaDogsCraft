package net.cjisdj.seadogscraft.item.custom;

import com.mojang.blaze3d.platform.InputConstants;
import net.cjisdj.seadogscraft.entity.custom.SniperProjectileEntity;
import net.cjisdj.seadogscraft.item.ModItems;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;


public class SniperItem extends Item{
    public SniperItem(Properties pProperties) {
        super(pProperties);
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);


        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FLINTANDSTEEL_USE, SoundSource.NEUTRAL,
                1.5F, 1F);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.NEUTRAL,
                1.5F, 1F);
        pPlayer.getCooldowns().addCooldown(this, 50);

        if(!pLevel.isClientSide()) {
            SniperProjectileEntity magicProjectile = new SniperProjectileEntity(pLevel, pPlayer);
            magicProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 8F, 0);
            pLevel.addFreshEntity(magicProjectile);
        }


        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
        }

        if(itemstack.getDamageValue() == 5){
            return InteractionResultHolder.sidedSuccess(new ItemStack(ModItems.EMPTY_SNIPER_RIFLE.get()), pLevel.isClientSide());
        }
        else{
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }
    }
}
