package org.k7osx.tutorialmod.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MagicWandItem extends Item {
  public MagicWandItem(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult use(Level level, Player player, InteractionHand hand) {
    ItemStack stack = player.getItemInHand(hand);

    if (!level.isClientSide()) {
      Vec3 lookVec = player.getLookAngle();

      double x = player.getX() + lookVec.x * 1.5;
      double y = player.getY() + player.getEyeHeight() + lookVec.y * 1.5;
      double z = player.getZ() + lookVec.z * 1.5;

      SmallFireball fireball = new SmallFireball(level, player, lookVec.scale(1.5));
      fireball.setPos(x, y, z);
      level.addFreshEntity(fireball);

      level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS,
          1.0F, 1.2F);

      player.getCooldowns().addCooldown(stack, 5);

      stack.hurtAndBreak(1, player, hand);
    }

    return super.use(level, player, hand);
  }
}
