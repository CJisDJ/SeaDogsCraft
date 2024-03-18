package net.cjisdj.seadogscraft.datagen;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.item.ModItems;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SeaDogsCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PERIDOT_HELMET.get(),
                        ModItems.PERIDOT_CHESTPLATE.get(),
                        ModItems.PERIDOT_LEGGINGS.get(),
                        ModItems.PERIDOT_BOOTS.get()
                );
        this.tag(ItemTags.LOGS_THAT_BURN);

        this.tag(ModTags.Items.FISH)
                .add(Items.COD)
                .add(Items.SALMON)
                .add(Items.PUFFERFISH)
                .add(Items.TROPICAL_FISH);


        this.tag(ItemTags.PLANKS);

    }
}
