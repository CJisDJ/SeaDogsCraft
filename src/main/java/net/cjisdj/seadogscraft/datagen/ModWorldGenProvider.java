package net.cjisdj.seadogscraft.datagen;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.worldgen.dimesion.ModDimensions;
import net.cjisdj.seadogscraft.worldgen.ModBiomeModifiers;
import net.cjisdj.seadogscraft.worldgen.ModConfiguredFeatures;
import net.cjisdj.seadogscraft.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();
            //.add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            //.add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
            //.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            //.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            //.add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SeaDogsCraft.MOD_ID));
    }
}