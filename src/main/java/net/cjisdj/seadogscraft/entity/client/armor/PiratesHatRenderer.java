package net.cjisdj.seadogscraft.entity.client.armor;

import software.bernie.example.item.GeckoArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class PiratesHatRenderer extends GeoArmorRenderer<GeckoArmorItem> {
    public PiratesHatRenderer() {
        super(new PiratesHatModel()); // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
}
