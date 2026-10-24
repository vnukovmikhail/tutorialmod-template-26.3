package org.k7osx.tutorialmod.item.custom;

import java.util.Map;
import java.util.function.Consumer;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ChiselItem extends Item {
  private static Map<Block, Block> CHISEL_MAP = Map.of(
      Blocks.STONE, Blocks.GRAVEL,
      Blocks.SANDSTONE, Blocks.SAND);

  public ChiselItem(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult useOn(UseOnContext context) {
    Level level = context.getLevel();
    Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

    if (CHISEL_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
      level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
      context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand());
    }

    return InteractionResult.SUCCESS;
  }

  @Override
  public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display,
      Consumer<Component> builder, TooltipFlag tooltipFlag) {
    if (Minecraft.getInstance().hasShiftDown()) {
      builder.accept(Component.translatable("tooltip.tutorialmod.chisel.shift_down"));
    } else {
      builder.accept(Component.translatable("tooltip.tutorialmod.chisel"));
    }

    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
  }
}
