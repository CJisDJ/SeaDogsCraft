package net.cjisdj.seadogscraft.entity.client;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation RHINO_LAYER = new ModelLayerLocation(
            new ResourceLocation(SeaDogsCraft.MOD_ID, "rhino_layer"), "main");

    public static final ModelLayerLocation MAGIC_PROJECTILE_LAYER = new ModelLayerLocation(
            new ResourceLocation(SeaDogsCraft.MOD_ID, "magic_projectile_layer"), "magic_projectile_layer");

    public static final ModelLayerLocation CANNON_PROJECTILE_LAYER = new ModelLayerLocation(
            new ResourceLocation(SeaDogsCraft.MOD_ID, "cannon_projectile_layer"), "cannon_projectile_layer");

    public static final ModelLayerLocation SNIPER_PROJECTILE_LAYER = new ModelLayerLocation(
            new ResourceLocation(SeaDogsCraft.MOD_ID, "sniper_projectile_layer"), "sniper_projectile_layer");

}
