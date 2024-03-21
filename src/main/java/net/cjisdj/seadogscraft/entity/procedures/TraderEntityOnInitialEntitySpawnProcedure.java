package net.cjisdj.seadogscraft.entity.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TraderEntityOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double tradeNumber = 0;
        double randomNumber = 0;
        double randomAmount = 0;
        tradeNumber = 1;
        if (!world.isClientSide()) {
            randomNumber = Math.random();
            if (randomNumber >= 0.75) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 1);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 1);
            } else if (randomNumber >= 0.5) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 2);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 1);
            } else if (randomNumber >= 0) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 3);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 8);
            }
            tradeNumber = tradeNumber + 1;
            if (randomNumber >= 0.75) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 1);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 12);
            } else if (randomNumber >= 0.5) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 2);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 4);
            } else if (randomNumber >= 0) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 3);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 5);
            }
            tradeNumber = tradeNumber + 1;
            if (randomNumber >= 0.75) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 1);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 32);
            } else if (randomNumber >= 0.5) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 2);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 45);
            } else if (randomNumber >= 0) {
                entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 3);
                entity.getPersistentData().putDouble(("tradeCount" + new java.text.DecimalFormat("##").format(tradeNumber)), 64);
            }
            tradeNumber = tradeNumber + 1;
        }
    }
}
