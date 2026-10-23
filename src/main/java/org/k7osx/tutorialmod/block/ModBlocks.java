package org.k7osx.tutorialmod.block;

import java.util.function.Function;

import org.k7osx.tutorialmod.TutorialMod;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
  public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
      properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

  private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
    Block toRegister = function.apply(BlockBehaviour.Properties.of()
        .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name))));
    registerBlockItem(name, toRegister);
    return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
        toRegister);
  }

  public static void registerBlockItem(String name, Block block) {
    Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
        new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
  }

  public static void registerModBlocks() {
    TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
  }
}
