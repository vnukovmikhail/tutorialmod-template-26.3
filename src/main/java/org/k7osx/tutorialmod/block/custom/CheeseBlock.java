package org.k7osx.tutorialmod.block.custom;

import org.k7osx.tutorialmod.item.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CheeseBlock extends Block {
  public CheeseBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
      BlockHitResult hitResult) {
    level.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);
    level.playSound(player, pos, SoundEvents.SLIME_HURT, SoundSource.BLOCKS, 2f, 1f);

    return super.useWithoutItem(state, level, pos, player, hitResult);
  }

  @Override
  public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
    if (entity instanceof Player player) {
      player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10));
    }

    if (entity instanceof ItemEntity itemEntity) {
      if (isValidItem(itemEntity.getItem())) {
        itemEntity.setItem(new ItemStack(Items.GOLD_NUGGET, itemEntity.getItem().getCount() + 1));
      }
    }

    super.stepOn(level, pos, onState, entity);
  }

  private boolean isValidItem(ItemStack item) {
    return item.is(ModItems.RAW_PINK_GARNET) || item.is(Items.INK_SAC);
  }
}
