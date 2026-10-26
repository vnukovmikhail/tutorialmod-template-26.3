package org.k7osx.tutorialmod.datagen;

import java.util.concurrent.CompletableFuture;

import org.k7osx.tutorialmod.block.ModBlocks;
import org.k7osx.tutorialmod.block.custom.StrangeCropBlock;
import org.k7osx.tutorialmod.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
  public ModBlockLootTableProvider(FabricPackOutput packOutput,
      CompletableFuture<HolderLookup.Provider> registriesFuture) {
    super(packOutput, registriesFuture);
  }

  @Override
  public void generate() {
    dropSelf(ModBlocks.PINK_GARNET_BLOCK);
    // add(ModBlocks.PINK_GARNET_BLOCK, createOreDrop(ModBlocks.PINK_GARNET_BLOCK,
    // ModItems.PINK_GARNET));
    add(ModBlocks.PINK_GARNET_ORE, createMultipleOreDrops(ModBlocks.PINK_GARNET_BLOCK, ModItems.RAW_PINK_GARNET, 1, 3));
    dropSelf(ModBlocks.CHEESE_BLOCK);
    dropSelf(ModBlocks.PEDESTAL_BLOCK);

    this.add(ModBlocks.STRANGE_CROP, this.createCropDrops(
        ModBlocks.STRANGE_CROP, ModItems.CHEESE, ModItems.STRANGE_SEEDS,
        MatchBlock.blockMatches(this.blocks, ModBlocks.STRANGE_CROP,
            StatePropertiesPredicate.Builder.properties()
                .hasProperty(StrangeCropBlock.AGE, StrangeCropBlock.MAX_AGE))));
  }

  public LootTable.Builder createMultipleOreDrops(final Block block, Item item, int minDrops, int maxDrops) {
    return this.createSilkTouchDispatchTable(
        block,
        (LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(
            block,
            LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops)))
                .apply(ApplyBonusCount.addOreBonusCount(this.enchantments.getOrThrow(Enchantments.FORTUNE)))));
  }
}
