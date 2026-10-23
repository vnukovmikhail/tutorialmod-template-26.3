package org.k7osx.tutorialmod.item;

import java.util.function.Function;

import org.k7osx.tutorialmod.TutorialMod;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
  public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new);
  public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", Item::new);

  private static Item registerItem(String name, Function<Item.Properties, Item> function) {
    return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
        function.apply(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
  }

  public static void registerModItems() {
    TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
      output.accept(PINK_GARNET);
      output.accept(RAW_PINK_GARNET);
    });
  }
}
