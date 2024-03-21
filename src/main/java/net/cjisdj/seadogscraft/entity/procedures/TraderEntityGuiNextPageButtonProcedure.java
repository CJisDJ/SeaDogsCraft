package net.cjisdj.seadogscraft.entity.procedures;

import net.minecraft.world.entity.Entity;

public class TraderEntityGuiNextPageButtonProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("playerTradePage") == 1) {
            entity.getPersistentData().putDouble("playerTradePage", 2);
        } else if (entity.getPersistentData().getDouble("playerTradePage") == 2) {
            entity.getPersistentData().putDouble("playerTradePage", 3);
        }
    }
}
