package org.k7osx.tutorialmod.creativemodetab;

import org.k7osx.tutorialmod.TutorialMod;
import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.item.ModItems;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
  public static final CreativeModeTab PINK_GARNET_ITEM_TAB = Registry.register(
      BuiltInRegistries.CREATIVE_MODE_TAB,
      Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "pink_garnet_items"),
      FabricCreativeModeTab.builder()
          .icon(() -> new ItemStack(ModItems.PINK_GARNET))
          .title(Component.translatable("creativemodetab.tutorialmod.pink_garnet_items"))
          .displayItems((parameters, output) -> {
            output.accept(ModItems.PINK_GARNET);
            output.accept(ModItems.RAW_PINK_GARNET);

            output.accept(ModItems.CHISEL);
            output.accept(ModItems.MAGIC_WAND);

            output.accept(ModItems.CHEESE);

            output.accept(ModItems.GARNET_HELMET);
            output.accept(ModItems.GARNET_CHESTPLATE);

            output.accept(ModItems.STRANGE_SEEDS);
          })
          .build());

  public static final CreativeModeTab PINK_GARNET_BLOCK_TAB = Registry.register(
      BuiltInRegistries.CREATIVE_MODE_TAB,
      Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "pink_garnet_blocks"),
      FabricCreativeModeTab.builder()
          .icon(() -> new ItemStack(ModItems.RAW_PINK_GARNET))
          .title(Component.translatable("creativemodetab.tutorialmod.pink_garnet_blocks"))
          .displayItems((parameters, output) -> {
            output.accept(ModBlocks.PINK_GARNET_BLOCK);
            output.accept(ModBlocks.PINK_GARNET_ORE);
            output.accept(ModBlocks.CHEESE_BLOCK);
          })
          .build());

  public static void registerCreativeModeTabs() {
    TutorialMod.LOGGER.info("Registering Creative Mode Tabs for " + TutorialMod.MOD_ID);
  }
}
