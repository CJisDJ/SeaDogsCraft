package net.cjisdj.seadogscraft.entity.client.armor;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class PiratesHatModel extends GeoModel{
    private final ResourceLocation modelResource = new ResourceLocation(SeaDogsCraft.MOD_ID, "geo/pirates_hat.geo.json");
    private final ResourceLocation textureResource = new ResourceLocation(SeaDogsCraft.MOD_ID, "textures/armor/pirates_hat.png");
    private final ResourceLocation animationResource = new ResourceLocation(SeaDogsCraft.MOD_ID, "animations/pirates_hat.animation.json");


    @Override
    public ResourceLocation getModelResource(GeoAnimatable animatable) {
        return this.modelResource;
    }

    @Override
    public ResourceLocation getTextureResource(GeoAnimatable animatable) {
        return this.textureResource;
    }

    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable animatable) {
        return this.animationResource;
    }
}
