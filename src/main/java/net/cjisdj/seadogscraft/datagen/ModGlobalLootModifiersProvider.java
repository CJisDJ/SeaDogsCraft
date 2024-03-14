package net.cjisdj.seadogscraft.datagen;

import net.cjisdj.seadogscraft.item.ModItems;
import net.cjisdj.seadogscraft.loot.AddItemModifier;
import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, SeaDogsCraft.MOD_ID);
    }

    @Override
    protected void start() {
        add("corn_seeds_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.CORN_SEEDS.get()));
        add("grape_seeds_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.GRAPE_SEEDS.get()));

      // add("metal_pipe_from_iron_golem", new AddItemModifier(new LootItemCondition[]{
       //        new LootTableIdCondition.Builder(new ResourceLocation("entities/iron_golem")).build(),
        //        LootItemRandomChanceCondition.randomChance(1f).build()}, ModItems.METAL_PIPE.get()));

     //   add("metal_pipe_from_temple", new AddItemModifier(new LootItemCondition[]{
      //          new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build()}, ModItems.METAL_PIPE.get()));

    }
}
