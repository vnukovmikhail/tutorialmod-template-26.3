package org.k7osx.tutorialmod.datagen;

import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.item.ModItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricPackOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
    blockModelGenerators.createTrivialCube(ModBlocks.PINK_GARNET_BLOCK);
  }

  @Override
  public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    itemModelGenerators.generateFlatItem(ModItems.PINK_GARNET, ModelTemplates.FLAT_ITEM);
    itemModelGenerators.generateFlatItem(ModItems.RAW_PINK_GARNET, ModelTemplates.FLAT_ITEM);
  }
}
