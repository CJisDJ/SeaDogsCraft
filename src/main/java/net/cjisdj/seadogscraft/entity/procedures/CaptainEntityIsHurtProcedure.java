package net.cjisdj.seadogscraft.entity.procedures;

import net.cjisdj.seadogscraft.entity.init.SeaDogsCraftModEntities;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;


public class CaptainEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (0.3 >= Math.random()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SeaDogsCraftModEntities.GUNNER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SeaDogsCraftModEntities.SWORDMAN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
