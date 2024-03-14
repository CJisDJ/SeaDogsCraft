package net.cjisdj.seadogscraft.item;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PERIDOT = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1561, 8F, 4.0F, 15,
                    ModTags.Blocks.NEEDS_PERIDOT_TOOL, () -> Ingredient.of(ModItems.PERIDOT.get())),
            new ResourceLocation(SeaDogsCraft.MOD_ID, "peridot"), List.of(Tiers.NETHERITE), List.of());
}
