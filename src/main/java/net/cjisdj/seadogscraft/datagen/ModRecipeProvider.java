package net.cjisdj.seadogscraft.datagen;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    private static final  List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(),9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL)
                .pattern("SSS")
                .pattern("S S")
                .pattern("SSS")
                .define('S', ModItems.MINI_COAL.get())
                .unlockedBy(getHasName(ModItems.MINI_COAL.get()), has(ModItems.MINI_COAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MINI_COAL.get(),9)
                .requires(Items.COAL)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CREAM_PIPE.get(),4)
                .requires(Items.CAKE)
                .unlockedBy(getHasName(Items.CAKE), has(Items.CAKE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK.get())
                .pattern("SSS")
                .pattern("SOS")
                .pattern("SSS")
                .define('S', Items.WHITE_WOOL)
                .define('O', Items.IRON_BARS)
                .unlockedBy(getHasName(ModItems.MINI_COAL.get()), has(ModItems.MINI_COAL.get()))
                .save(pWriter);

//ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.METAL_PIPE.get())
      //          .pattern(" S ")
       //         .pattern(" S ")
      //          .pattern(" S ")
       //         .define('S', Items.IRON_INGOT)
        //        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
       //         .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SeaDogsCraft.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


}
