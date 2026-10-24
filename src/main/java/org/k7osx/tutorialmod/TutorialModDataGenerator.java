package org.k7osx.tutorialmod;

import org.k7osx.tutorialmod.datagen.ModBlockLootTableProvider;
import org.k7osx.tutorialmod.datagen.ModBlockTagsProvider;
import org.k7osx.tutorialmod.datagen.ModEquipmentAssetProvider;
import org.k7osx.tutorialmod.datagen.ModModelProvider;
import org.k7osx.tutorialmod.datagen.ModRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    var pack = fabricDataGenerator.createPack();

    pack.addProvider(ModModelProvider::new);
    pack.addProvider(ModBlockTagsProvider::new);
    pack.addProvider(ModBlockLootTableProvider::new);
    pack.addProvider(ModRecipeProvider::new);
    pack.addProvider(ModEquipmentAssetProvider::new);
  }
}
