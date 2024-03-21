package net.cjisdj.seadogscraft.entity.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;

import java.util.Map;
import java.util.function.Supplier;

public class RemoveItemWhenItemTradedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
            ((Slot) _slots.get(0)).remove(1);
            _player.containerMenu.broadcastChanges();
        }
    }
}
