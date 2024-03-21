
package net.cjisdj.seadogscraft.entity.network;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.procedures.RemoveItemWhenItemTradedProcedure;
import net.cjisdj.seadogscraft.entity.procedures.SetPageTradesProcedure;
import net.cjisdj.seadogscraft.entity.world.inventory.CaptraderTradingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CaptraderTradingSlotMessage {
    private final int slotID, x, y, z, changeType, meta;

    public CaptraderTradingSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
        this.slotID = slotID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.changeType = changeType;
        this.meta = meta;
    }

    public CaptraderTradingSlotMessage(FriendlyByteBuf buffer) {
        this.slotID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.changeType = buffer.readInt();
        this.meta = buffer.readInt();
    }

    public static void buffer(CaptraderTradingSlotMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.slotID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        buffer.writeInt(message.changeType);
        buffer.writeInt(message.meta);
    }

    public static void handler(CaptraderTradingSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int slotID = message.slotID;
            int changeType = message.changeType;
            int meta = message.meta;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleSlotAction(entity, slotID, changeType, meta, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CaptraderTradingMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (slot == 0 && changeType == 0) {

            SetPageTradesProcedure.execute(entity);
        }
        if (slot == 1 && changeType == 1) {

            RemoveItemWhenItemTradedProcedure.execute(entity);
        }
        if (slot == 1 && changeType == 2) {
            int amount = meta;

            RemoveItemWhenItemTradedProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        SeaDogsCraft.addNetworkMessage(CaptraderTradingSlotMessage.class, CaptraderTradingSlotMessage::buffer, CaptraderTradingSlotMessage::new, CaptraderTradingSlotMessage::handler);
    }
}
