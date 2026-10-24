package org.k7osx.tutorialmod.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
  public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.3f)
      .build();

  public static final Consumable CHEESE_CONSUMABLE = Consumables.defaultFood().consumeSeconds(1f)
      .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 100), 0.15f))
      .build();
}
