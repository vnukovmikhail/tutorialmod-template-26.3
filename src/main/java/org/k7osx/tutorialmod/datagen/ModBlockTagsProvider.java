package org.k7osx.tutorialmod.datagen;

import java.util.concurrent.CompletableFuture;

import org.k7osx.tutorialmod.TutorialMod;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
  public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
    super(output, registryLookupFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider registries) {
    builder(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(ResourceKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "pink_garnet_block")));

    builder(BlockTags.NEEDS_IRON_TOOL)
        .add(ResourceKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "pink_garnet_block")));
  }
}
