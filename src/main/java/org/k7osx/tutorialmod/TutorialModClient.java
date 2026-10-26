package org.k7osx.tutorialmod;

import org.k7osx.tutorialmod.block.entity.ModBlockEntities;
import org.k7osx.tutorialmod.block.entity.renderer.PedestalBlockEntityRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class TutorialModClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    BlockEntityRenderers.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
  }
}
