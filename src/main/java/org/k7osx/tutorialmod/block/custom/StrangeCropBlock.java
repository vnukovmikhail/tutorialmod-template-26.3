package org.k7osx.tutorialmod.block.custom;

import org.k7osx.tutorialmod.item.ModItems;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class StrangeCropBlock extends CropBlock {
  public static final int MAX_AGE = 5;
  public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);

  public StrangeCropBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected ItemLike getBaseSeedId() {
    return ModItems.STRANGE_SEEDS;
  }

  @Override
  protected IntegerProperty getAgeProperty() {
    return AGE;
  }

  @Override
  public int getMaxAge() {
    return MAX_AGE;
  }

  @Override
  protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
    builder.add(AGE);
  }
}
