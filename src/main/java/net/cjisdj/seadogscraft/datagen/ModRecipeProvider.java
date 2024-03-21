package net.cjisdj.seadogscraft.datagen;

import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.item.ModItems;
import net.cjisdj.seadogscraft.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    private static final  List<ItemLike> RICE_SMELTABLES = List.of(ModItems.RAW_RICE.get());
//    private static final  List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.MINI_COAL.get(),
//            ModBlocks.PERIDOT_ORE.get(), ModBlocks.DEEPSLATE_PERIDOT_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.PERIDOT.get(), 0.25f, 200, "sapphire");
       //  oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.PERIDOT.get(), 0.25f, 100, "sapphire");
        oreSmoking(pWriter, RICE_SMELTABLES, RecipeCategory.FOOD, ModItems.COOKED_RICE.get(), 0.25f, 100, "rice");
        oreSmelting(pWriter, RICE_SMELTABLES, RecipeCategory.FOOD, ModItems.COOKED_RICE.get(), 0.25f, 200, "rice");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHICKEN_CURRY_BOWL.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")

                .define('A', ModItems.CURRY_POWDER.get())
                .define('B', ModItems.COOKED_RICE.get())
                .define('C', Items.COOKED_CHICKEN)
                .define('D', Items.CARROT)
                .define('E', Items.BOWL)
                .unlockedBy(getHasName(ModItems.CURRY_POWDER.get()), has(ModItems.CURRY_POWDER.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAND_CANNON.get())
                .pattern("GS")
                .pattern("OS")
                .define('G', ModItems.EMPTY_HAND_CANNON.get())
                .define('O', ModItems.CANNONBALL.get())
                .define('S', Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLINTLOCK.get())
                .pattern("GS")
                .pattern("O ")
                .define('G', ModItems.EMPTY_FLINTLOCK.get())
                .define('S', ModItems.METAL_BULLETS.get())
                .define('O', Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SNIPER_RIFLE.get())
                .pattern("GS")
                .pattern("OS")
                .define('G', ModItems.EMPTY_SNIPER_RIFLE.get())
                .define('O', ModItems.METAL_BULLETS.get())
                .define('S', Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUNDERBUSS.get())
                .pattern("GS")
                .pattern("OS")
                .define('G', ModItems.EMPTY_BLUNDERBUSS.get())
                .define('S', ModItems.METAL_BULLETS.get())
                .define('O', Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_RICE.get(),2)
                .requires(ModItems.RICE.get())
                .unlockedBy(getHasName(ModItems.RICE.get()), has(ModItems.RICE.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUSHI.get(),2)
                .requires(ModItems.COOKED_RICE.get())
                .requires(ModTags.Items.FISH)
                .requires(Items.DRIED_KELP)
                .unlockedBy(getHasName(ModItems.RICE.get()), has(ModItems.RICE.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PERIDOT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PERIDOT.get())
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PERIDOT.get(),9)
                .requires(ModBlocks.PERIDOT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PERIDOT_BLOCK.get()), has(ModBlocks.PERIDOT_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL)
                .pattern("SSS")
                .pattern("S S")
                .pattern("SSS")
                .define('S', ModItems.MINI_COAL.get())
                .unlockedBy(getHasName(ModItems.MINI_COAL.get()), has(ModItems.MINI_COAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MINI_COAL.get(),8)
                .requires(Items.COAL)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK.get())
                .pattern("SSS")
                .pattern("SOS")
                .pattern("SSS")
                .define('S', Items.WHITE_WOOL)
                .define('O', Items.IRON_BARS)
                .unlockedBy(getHasName(ModItems.MINI_COAL.get()), has(ModItems.MINI_COAL.get()))
                .save(pWriter);

//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.METAL_PIPE.get())
//                .pattern(" S ")
//                .pattern(" S ")
//                .pattern(" S ")
//                .define('S', Items.IRON_INGOT)
//                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
//                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PERIDOT_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', ModItems.PERIDOT.get())
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PERIDOT_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PERIDOT.get())
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PERIDOT_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.PERIDOT.get())
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PERIDOT_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.PERIDOT.get())
                .unlockedBy(getHasName(ModItems.PERIDOT.get()), has(ModItems.PERIDOT.get()))
                .save(pWriter);



    }


    protected static void oreSmoking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smoking");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
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
