package org.k7osx.tutorialmod.block.entity;

import org.k7osx.tutorialmod.TutorialMod;
import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.block.entity.custom.PedestalBlockEntity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
  public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE = Registry.register(
      BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "pedestal_be"),
      FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL_BLOCK).build());

  public static void registerBlockEntities() {
    TutorialMod.LOGGER.info("Registering ModBlockEntities for " + TutorialMod.MOD_ID);
  }
}
