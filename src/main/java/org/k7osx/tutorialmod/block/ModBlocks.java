package org.k7osx.tutorialmod.block;

import java.util.function.Function;

import org.k7osx.tutorialmod.TutorialMod;
import org.k7osx.tutorialmod.block.custom.CheeseBlock;
import org.k7osx.tutorialmod.block.custom.StrangeCropBlock;

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
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
  public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
      properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

  public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
      properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

  public static final Block CHEESE_BLOCK = registerBlock("cheese_block",
      properties -> new CheeseBlock(
          properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

  public static final Block STRANGE_CROP = registerBlock("strange_crop",
      properties -> new StrangeCropBlock(
          properties.noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.POPPED)));

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

  private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> function) {
    Block toRegister = function.apply(BlockBehaviour.Properties.of()
        .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name))));
    return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
        toRegister);
  }

  public static void registerModBlocks() {
    TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
  }
}
