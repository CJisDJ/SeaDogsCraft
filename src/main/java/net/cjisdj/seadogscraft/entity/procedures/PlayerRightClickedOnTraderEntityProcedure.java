package net.cjisdj.seadogscraft.entity.procedures;

import io.netty.buffer.Unpooled;
import net.cjisdj.seadogscraft.entity.custom.CaptraderTraderEntity;
import net.cjisdj.seadogscraft.entity.world.inventory.CaptraderTradingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRightClickedOnTraderEntityProcedure {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof CaptraderTraderEntity) {
            sourceentity.getPersistentData().putDouble("playerTradeCount1", (entity.getPersistentData().getDouble("tradeCount1")));
            sourceentity.getPersistentData().putDouble("playerTradeCount2", (entity.getPersistentData().getDouble("tradeCount2")));
            sourceentity.getPersistentData().putDouble("playerTradeCount3", (entity.getPersistentData().getDouble("tradeCount3")));
            sourceentity.getPersistentData().putDouble("playerTradeItem1", (entity.getPersistentData().getDouble("tradeItem1")));
            sourceentity.getPersistentData().putDouble("playerTradeItem2", (entity.getPersistentData().getDouble("tradeItem2")));
            sourceentity.getPersistentData().putDouble("playerTradeItem3", (entity.getPersistentData().getDouble("tradeItem3")));
            sourceentity.getPersistentData().putDouble("playerTradePage", 1);
            if (sourceentity instanceof ServerPlayer _ent) {
                BlockPos _bpos = BlockPos.containing(x, y, z);
                NetworkHooks.openScreen(_ent, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("CaptraderTrading");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new CaptraderTradingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                    }
                }, _bpos);
            }
        }
    }
}
