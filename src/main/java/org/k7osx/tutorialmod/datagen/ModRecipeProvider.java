package org.k7osx.tutorialmod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends FabricRecipeProvider {
  public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected RecipeProvider createRecipeProvider(
      HolderLookup.Provider registries,
      BootstrapContext<Recipe<?>> recipeOutput,
      BootstrapContext<Advancement> advancementOutput) {
    return new RecipeProvider(recipeOutput, advancementOutput) {
      @Override
      public void buildRecipes() {
        List<ItemLike> GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET);

        oreSmelting(
            GARNET_SMELTABLES,
            RecipeCategory.MISC,
            CookingBookCategory.BLOCKS,
            ModItems.PINK_GARNET,
            0.25f,
            200,
            "pink_garnet");

        oreBlasting(
            GARNET_SMELTABLES,
            RecipeCategory.MISC,
            CookingBookCategory.BLOCKS,
            ModItems.PINK_GARNET,
            0.25f,
            100,
            "pink_garnet");

        nineBlockStorageRecipes(
            RecipeCategory.MISC,
            ModItems.PINK_GARNET,
            RecipeCategory.DECORATIONS,
            ModBlocks.PINK_GARNET_BLOCK);
      }
    };
  }

  @Override
  public String getName() {
    return "TutorialMod Recipes";
  }
}
