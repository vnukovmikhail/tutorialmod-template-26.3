package org.k7osx.tutorialmod.datagen;

import java.util.Map;

import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.block.custom.StrangeCropBlock;
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
    blockModelGenerators.createTrivialCube(ModBlocks.PINK_GARNET_ORE);
    blockModelGenerators.createTrivialCube(ModBlocks.CHEESE_BLOCK);

    blockModelGenerators.createCropBlock(ModBlocks.STRANGE_CROP, StrangeCropBlock.AGE, 0, 1, 2, 3, 4, 5);

    blockModelGenerators.createNonTemplateModelBlock(ModBlocks.PEDESTAL_BLOCK);
  }

  @Override
  public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    itemModelGenerators.generateFlatItem(ModItems.PINK_GARNET, ModelTemplates.FLAT_ITEM);
    itemModelGenerators.generateFlatItem(ModItems.RAW_PINK_GARNET, ModelTemplates.FLAT_ITEM);
    itemModelGenerators.generateFlatItem(ModItems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
    itemModelGenerators.generateFlatItem(ModItems.MAGIC_WAND, ModelTemplates.FLAT_HANDHELD_ITEM);
    itemModelGenerators.generateFlatItem(ModItems.CHEESE, ModelTemplates.FLAT_ITEM);

    itemModelGenerators.generateTrimmableItem(
        ModItems.GARNET_HELMET,
        ItemModelGenerators.TRIM_PREFIX_HELMET,
        false,
        Map.of());
    itemModelGenerators.generateTrimmableItem(
        ModItems.GARNET_CHESTPLATE,
        ItemModelGenerators.TRIM_PREFIX_CHESTPLATE,
        false,
        Map.of());
  }
}
