package org.k7osx.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.creativemodetab.ModCreativeModeTabs;
import org.k7osx.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
  public static final String MOD_ID = "tutorialmod";

  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Hello Fabric world!");
    ModCreativeModeTabs.registerCreativeModeTabs();
    ModItems.registerModItems();
    ModBlocks.registerModBlocks();
  }

  public static Identifier id(String path) {
    return Identifier.fromNamespaceAndPath(MOD_ID, path);
  }
}
